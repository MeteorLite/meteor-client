/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package rs117.hd

import com.google.common.base.Charsets
import com.jogamp.common.os.Platform
import com.jogamp.opengl.GL4
import java.lang.RuntimeException
import java.lang.IllegalArgumentException
import jogamp.opengl.GLContextImpl
import jogamp.opengl.x11.glx.X11GLXContext
import jogamp.opengl.windows.wgl.WindowsWGLContext
import jogamp.opengl.egl.EGLContext
import jogamp.opengl.macosx.cgl.CGL
import meteor.Logger
import org.jocl.*
import rs117.hd.template.Template
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import java.util.*

object OpenCLManager {
    // The number of faces each worker processes in the two kernels
    private var largeFaceCount = 0
    private var smallFaceCount = 0
    private var platform: cl_platform_id? = null
    private var device: cl_device_id? = null
    var context: cl_context? = null
    private var commandQueue: cl_command_queue? = null
    private var programUnordered: cl_program? = null
    private var programSmall: cl_program? = null
    private var programLarge: cl_program? = null
    private var kernelUnordered: cl_kernel? = null
    private var kernelSmall: cl_kernel? = null
    private var kernelLarge: cl_kernel? = null
    val log = Logger(OpenCLManager.toString())
    fun init(gl: GL4) {
        CL.setExceptionsEnabled(true)
        when (Platform.getOSType()) {
            Platform.OSType.WINDOWS, Platform.OSType.LINUX -> {
                initPlatform()
                initDevice()
                initContext(gl)
            }
            Platform.OSType.MACOS -> initMacOS(gl)
            else -> throw RuntimeException("Unsupported OS Type " + Platform.getOSType().name)
        }
        ensureMinWorkGroupSize()
        initQueue()
        compilePrograms()
    }

    fun cleanup() {
        if (programUnordered != null) {
            CL.clReleaseProgram(programUnordered)
            programUnordered = null
        }
        if (programSmall != null) {
            CL.clReleaseProgram(programSmall)
            programSmall = null
        }
        if (programLarge != null) {
            CL.clReleaseProgram(programLarge)
            programLarge = null
        }
        if (kernelUnordered != null) {
            CL.clReleaseKernel(kernelUnordered)
            kernelUnordered = null
        }
        if (kernelSmall != null) {
            CL.clReleaseKernel(kernelSmall)
            kernelSmall = null
        }
        if (kernelLarge != null) {
            CL.clReleaseKernel(kernelLarge)
            kernelLarge = null
        }
        if (commandQueue != null) {
            CL.clReleaseCommandQueue(commandQueue)
            commandQueue = null
        }
        if (context != null) {
            CL.clReleaseContext(context)
            context = null
        }
        if (device != null) {
            CL.clReleaseDevice(device)
            device = null
        }
    }

    private fun logPlatformInfo(platform: cl_platform_id?, param: Int): String {
        val size = LongArray(1)
        CL.clGetPlatformInfo(platform, param, 0, null, size)
        val buffer = ByteArray(size[0].toInt())
        CL.clGetPlatformInfo(platform, param, buffer.size.toLong(), Pointer.to(buffer), null)
        val platformInfo = String(buffer, Charsets.UTF_8)
        log.debug("Platform: {}, {}", CL.stringFor_cl_platform_info(param), platformInfo)
        return platformInfo
    }

    private fun logBuildInfo(program: cl_program, param: Int) {
        val size = LongArray(1)
        CL.clGetProgramBuildInfo(program, device, param, 0, null, size)
        val buffer = ByteBuffer.allocateDirect(size[0].toInt())
        CL.clGetProgramBuildInfo(program, device, param, buffer.limit().toLong(), Pointer.toBuffer(buffer), null)
        when (param) {
            CL.CL_PROGRAM_BUILD_STATUS -> log.debug(
                "Build status: {}, {}",
                CL.stringFor_cl_program_build_info(param),
                CL.stringFor_cl_build_status(buffer.int)
            )
            CL.CL_PROGRAM_BINARY_TYPE -> log.debug(
                "Binary type: {}, {}",
                CL.stringFor_cl_program_build_info(param),
                CL.stringFor_cl_program_binary_type(buffer.int)
            )
            CL.CL_PROGRAM_BUILD_LOG -> {
                val buildLog = StandardCharsets.US_ASCII.decode(buffer).toString()
                log.info("Build log: {}, {}", CL.stringFor_cl_program_build_info(param), buildLog)
            }
            CL.CL_PROGRAM_BUILD_OPTIONS -> {
                val message = StandardCharsets.US_ASCII.decode(buffer).toString()
                log.debug("Build options: {}, {}", CL.stringFor_cl_program_build_info(param), message)
            }
            else -> throw IllegalArgumentException()
        }
    }

    private fun initPlatform() {
        val platformCount = IntArray(1)
        CL.clGetPlatformIDs(0, null, platformCount)
        if (platformCount[0] == 0) {
            throw RuntimeException("No compute platforms found")
        }
        val platforms = arrayOfNulls<cl_platform_id>(platformCount[0])
        CL.clGetPlatformIDs(platforms.size, platforms, null)
        for (platform in platforms) {
            log.debug("Found cl_platform_id {}", platform as Any)
            logPlatformInfo(platform, CL.CL_PLATFORM_PROFILE)
            logPlatformInfo(platform, CL.CL_PLATFORM_VERSION)
            logPlatformInfo(platform, CL.CL_PLATFORM_NAME)
            logPlatformInfo(platform, CL.CL_PLATFORM_VENDOR)
            val extensions = logPlatformInfo(platform, CL.CL_PLATFORM_EXTENSIONS).split(" ").toTypedArray()
            if (Arrays.stream(extensions).noneMatch { s: String -> s == GL_SHARING_PLATFORM_EXT }) {
                throw RuntimeException("Platform does not support OpenGL buffer sharing")
            }
        }
        platform = platforms[0]
        log.debug("Selected cl_platform_id {}", platform as Any)
    }

    private fun initDevice() {
        val deviceCount = IntArray(1)
        CL.clGetDeviceIDs(platform, CL.CL_DEVICE_TYPE_GPU, 0, null, deviceCount)
        if (deviceCount[0] == 0) {
            throw RuntimeException("No compute devices found")
        }
        val devices = arrayOfNulls<cl_device_id>(deviceCount[0])
        CL.clGetDeviceIDs(platform, CL.CL_DEVICE_TYPE_GPU, devices.size, devices, null)
        for (device in devices) {
            val size = LongArray(1)
            CL.clGetDeviceInfo(device, CL.CL_DEVICE_EXTENSIONS, 0, null, size)
            val devInfoBuf = ByteArray(size[0].toInt())
            CL.clGetDeviceInfo(device, CL.CL_DEVICE_EXTENSIONS, devInfoBuf.size.toLong(), Pointer.to(devInfoBuf), null)
            log.debug("Found cl_device_id: {}", device as Any)
            log.debug("Device extensions: {}", String(devInfoBuf, Charsets.UTF_8))
        }
        device = devices[0]
        log.debug("Selected cl_device_id {}", device as Any)
    }

    private fun initContext(gl: GL4) {
        // set computation platform
        val contextProps = cl_context_properties()
        contextProps.addProperty(CL.CL_CONTEXT_PLATFORM.toLong(), platform)

        // pull gl context
        val glContext = gl.context
        log.debug("Got GLContext of type {}", glContext.javaClass.simpleName)
        if (!glContext.isCurrent) {
            throw RuntimeException("Can't create OpenCL context from inactive GL Context")
        }

        // get correct props based on os
        val glContextHandle = glContext.handle
        val glContextImpl = glContext as GLContextImpl
        val glDrawableImpl = glContextImpl.drawableImpl
        val nativeSurface = glDrawableImpl.nativeSurface
        if (glContext is X11GLXContext) {
            val displayHandle = nativeSurface.displayHandle
            contextProps.addProperty(CL.CL_GL_CONTEXT_KHR.toLong(), glContextHandle)
            contextProps.addProperty(CL.CL_GLX_DISPLAY_KHR.toLong(), displayHandle)
        } else if (glContext is WindowsWGLContext) {
            val surfaceHandle = nativeSurface.surfaceHandle
            contextProps.addProperty(CL.CL_GL_CONTEXT_KHR.toLong(), glContextHandle)
            contextProps.addProperty(CL.CL_WGL_HDC_KHR.toLong(), surfaceHandle)
        } else if (glContext is EGLContext) {
            val displayHandle = nativeSurface.displayHandle
            contextProps.addProperty(CL.CL_GL_CONTEXT_KHR.toLong(), glContextHandle)
            contextProps.addProperty(CL.CL_EGL_DISPLAY_KHR.toLong(), displayHandle)
        }
        log.debug("Creating context with props: {}", contextProps)
        context = CL.clCreateContext(contextProps, 1, arrayOf(device), null, null, null)
        log.debug("Created compute context {}", context as Any)
    }

    private fun initMacOS(gl: GL4) {
        // get sharegroup from gl context
        val glContext = gl.context
        if (!glContext.isCurrent) {
            throw RuntimeException("Can't create context from inactive GL")
        }
        val cglContext = CGL.CGLGetCurrentContext()
        val cglShareGroup = CGL.CGLGetShareGroup(cglContext)

        // build context props
        val contextProps = cl_context_properties()
        contextProps.addProperty(CL.CL_CONTEXT_PROPERTY_USE_CGL_SHAREGROUP_APPLE.toLong(), cglShareGroup)

        // ask macos to make the context for us
        log.debug("Creating context with props: {}", contextProps)
        context = CL.clCreateContext(contextProps, 0, null, null, null, null)

        // pull the compute device out of the provided context
        device = cl_device_id()
        CL.clGetGLContextInfoAPPLE(
            context,
            cglContext,
            CL.CL_CGL_DEVICE_FOR_CURRENT_VIRTUAL_SCREEN_APPLE,
            Sizeof.cl_device_id.toLong(),
            Pointer.to(device),
            null
        )
        log.debug("Got macOS CLGL compute device {}", device as Any)
    }

    private fun ensureMinWorkGroupSize() {
        val maxWorkGroupSize = LongArray(1)
        CL.clGetDeviceInfo(
            device,
            CL.CL_DEVICE_MAX_WORK_GROUP_SIZE,
            Sizeof.size_t.toLong(),
            Pointer.to(maxWorkGroupSize),
            null
        )
        log.debug("Device CL_DEVICE_MAX_WORK_GROUP_SIZE: {}", maxWorkGroupSize[0])
        if (maxWorkGroupSize[0] < MIN_WORK_GROUP_SIZE) {
            throw RuntimeException("Compute device does not support min work group size " + MIN_WORK_GROUP_SIZE)
        }

        // Largest power of 2 less than or equal to maxWorkGroupSize
        val groupSize = -0x80000000 ushr Integer.numberOfLeadingZeros(maxWorkGroupSize[0].toInt())
        largeFaceCount = LARGE_SIZE / Math.min(groupSize, LARGE_SIZE)
        smallFaceCount = SMALL_SIZE / Math.min(groupSize, SMALL_SIZE)
        log.debug("Face counts: small: {}, large: {}", smallFaceCount, largeFaceCount)
    }

    private fun initQueue() {
        val l = LongArray(1)
        CL.clGetDeviceInfo(device, CL.CL_DEVICE_QUEUE_PROPERTIES, Sizeof.cl_long.toLong(), Pointer.to(l), null)
        commandQueue =
            CL.clCreateCommandQueue(context, device, l[0] and CL.CL_QUEUE_OUT_OF_ORDER_EXEC_MODE_ENABLE, null)
        log.debug(
            "Created command_queue {}, properties {}",
            commandQueue!!,
            l[0] and CL.CL_QUEUE_OUT_OF_ORDER_EXEC_MODE_ENABLE
        )
    }

    private fun compileProgram(programSource: String): cl_program {
        log.info("Compiling program:\n {}", programSource)
        val program = CL.clCreateProgramWithSource(context, 1, arrayOf(programSource), null, null)
        try {
            CL.clBuildProgram(program, 0, null, null, null, null)
        } catch (e: CLException) {
            logBuildInfo(program, CL.CL_PROGRAM_BUILD_LOG)
            throw e
        }
        logBuildInfo(program, CL.CL_PROGRAM_BUILD_STATUS)
        logBuildInfo(program, CL.CL_PROGRAM_BINARY_TYPE)
        logBuildInfo(program, CL.CL_PROGRAM_BUILD_OPTIONS)
        logBuildInfo(program, CL.CL_PROGRAM_BUILD_LOG)
        return program
    }

    private fun getKernel(program: cl_program?, kernelName: String): cl_kernel {
        val kernel = CL.clCreateKernel(program, kernelName, null)
        log.debug("Loaded kernel {} for program {}", kernelName as Any, program as Any)
        return kernel
    }

    private fun compilePrograms() {
        val templateSmall = Template()
            .addInclude(OpenCLManager::class.java)
            .add { key: String -> if (key == "FACE_COUNT") "#define FACE_COUNT $smallFaceCount" else null }
        val templateLarge = Template()
            .addInclude(OpenCLManager::class.java)
            .add { key: String -> if (key == "FACE_COUNT") "#define FACE_COUNT $largeFaceCount" else null }
        val unordered = Template()
            .addInclude(OpenCLManager::class.java)
            .load("comp_unordered.cl")
        val small = templateSmall.load("comp.cl")
        val large = templateLarge.load("comp.cl")
        programUnordered = compileProgram(unordered)
        programSmall = compileProgram(small)
        programLarge = compileProgram(large)
        kernelUnordered = getKernel(programUnordered, KERNEL_NAME_UNORDERED)
        kernelSmall = getKernel(programSmall, KERNEL_NAME_LARGE)
        kernelLarge = getKernel(programLarge, KERNEL_NAME_LARGE)
    }

    fun compute(
        unorderedModels: Int, smallModels: Int, largeModels: Int,
        sceneVertexBuffer: GLBuffer,
        sceneUvBuffer: GLBuffer,
        vertexBuffer: GLBuffer,
        uvBuffer: GLBuffer,
        unorderedBuffer: GLBuffer,
        smallBuffer: GLBuffer,
        largeBuffer: GLBuffer,
        outVertexBuffer: GLBuffer,
        outUvBuffer: GLBuffer,
        uniformBuffer: GLBuffer,
        normalOutBuffer: GLBuffer,
        normalBuffer: GLBuffer,
        tempNormalBuffer: GLBuffer
    ) {
        val glBuffersAll = arrayOf(
            sceneVertexBuffer.cl_mem,
            sceneUvBuffer.cl_mem,
            unorderedBuffer.cl_mem,
            smallBuffer.cl_mem,
            largeBuffer.cl_mem,
            vertexBuffer.cl_mem,
            uvBuffer.cl_mem,
            outVertexBuffer.cl_mem,
            outUvBuffer.cl_mem,
            uniformBuffer.cl_mem,
            normalOutBuffer.cl_mem,
            normalBuffer.cl_mem,
            tempNormalBuffer.cl_mem
        )
        val glBuffers = Arrays.stream(glBuffersAll)
            .filter { obj: cl_mem? -> Objects.nonNull(obj) }
            .toArray<cl_mem> { arrayOf() }
        val acquireGLBuffers = cl_event()
        CL.clEnqueueAcquireGLObjects(commandQueue, glBuffers.size, glBuffers, 0, null, acquireGLBuffers)
        val computeEvents = arrayOf(
            cl_event(),
            cl_event(),
            cl_event()
        )
        var numComputeEvents = 0
        if (unorderedModels > 0) {
            CL.clSetKernelArg(kernelUnordered, 0, Sizeof.cl_mem.toLong(), unorderedBuffer.ptr())
            CL.clSetKernelArg(kernelUnordered, 1, Sizeof.cl_mem.toLong(), sceneVertexBuffer.ptr())
            CL.clSetKernelArg(kernelUnordered, 2, Sizeof.cl_mem.toLong(), vertexBuffer.ptr())
            CL.clSetKernelArg(kernelUnordered, 3, Sizeof.cl_mem.toLong(), sceneUvBuffer.ptr())
            CL.clSetKernelArg(kernelUnordered, 4, Sizeof.cl_mem.toLong(), uvBuffer.ptr())
            CL.clSetKernelArg(kernelUnordered, 5, Sizeof.cl_mem.toLong(), outVertexBuffer.ptr())
            CL.clSetKernelArg(kernelUnordered, 6, Sizeof.cl_mem.toLong(), outUvBuffer.ptr())
            CL.clSetKernelArg(kernelUnordered, 7, Sizeof.cl_mem.toLong(), normalOutBuffer.ptr())
            CL.clSetKernelArg(kernelUnordered, 8, Sizeof.cl_mem.toLong(), normalBuffer.ptr())
            CL.clSetKernelArg(kernelUnordered, 9, Sizeof.cl_mem.toLong(), tempNormalBuffer.ptr())

            // queue compute call after acquireGLBuffers
            CL.clEnqueueNDRangeKernel(
                commandQueue,
                kernelUnordered,
                1,
                null,
                longArrayOf(unorderedModels * 6L),
                longArrayOf(6),
                1,
                arrayOf(acquireGLBuffers),
                computeEvents[numComputeEvents++]
            )
        }
        if (smallModels > 0) {
            CL.clSetKernelArg(kernelSmall, 0, ((SHARED_SIZE + SMALL_SIZE) * Integer.BYTES).toLong(), null)
            CL.clSetKernelArg(kernelSmall, 1, Sizeof.cl_mem.toLong(), smallBuffer.ptr())
            CL.clSetKernelArg(kernelSmall, 2, Sizeof.cl_mem.toLong(), sceneVertexBuffer.ptr())
            CL.clSetKernelArg(kernelSmall, 3, Sizeof.cl_mem.toLong(), vertexBuffer.ptr())
            CL.clSetKernelArg(kernelSmall, 4, Sizeof.cl_mem.toLong(), sceneUvBuffer.ptr())
            CL.clSetKernelArg(kernelSmall, 5, Sizeof.cl_mem.toLong(), uvBuffer.ptr())
            CL.clSetKernelArg(kernelSmall, 6, Sizeof.cl_mem.toLong(), outVertexBuffer.ptr())
            CL.clSetKernelArg(kernelSmall, 7, Sizeof.cl_mem.toLong(), outUvBuffer.ptr())
            CL.clSetKernelArg(kernelSmall, 8, Sizeof.cl_mem.toLong(), normalOutBuffer.ptr())
            CL.clSetKernelArg(kernelSmall, 9, Sizeof.cl_mem.toLong(), normalBuffer.ptr())
            CL.clSetKernelArg(kernelSmall, 10, Sizeof.cl_mem.toLong(), tempNormalBuffer.ptr())
            CL.clSetKernelArg(kernelSmall, 11, Sizeof.cl_mem.toLong(), uniformBuffer.ptr())
            CL.clEnqueueNDRangeKernel(
                commandQueue,
                kernelSmall,
                1,
                null,
                longArrayOf((smallModels * (SMALL_SIZE / smallFaceCount)).toLong()),
                longArrayOf((SMALL_SIZE / smallFaceCount).toLong()),
                1,
                arrayOf(acquireGLBuffers),
                computeEvents[numComputeEvents++]
            )
        }
        if (largeModels > 0) {
            CL.clSetKernelArg(kernelLarge, 0, ((SHARED_SIZE + LARGE_SIZE) * Integer.BYTES).toLong(), null)
            CL.clSetKernelArg(kernelLarge, 1, Sizeof.cl_mem.toLong(), largeBuffer.ptr())
            CL.clSetKernelArg(kernelLarge, 2, Sizeof.cl_mem.toLong(), sceneVertexBuffer.ptr())
            CL.clSetKernelArg(kernelLarge, 3, Sizeof.cl_mem.toLong(), vertexBuffer.ptr())
            CL.clSetKernelArg(kernelLarge, 4, Sizeof.cl_mem.toLong(), sceneUvBuffer.ptr())
            CL.clSetKernelArg(kernelLarge, 5, Sizeof.cl_mem.toLong(), uvBuffer.ptr())
            CL.clSetKernelArg(kernelLarge, 6, Sizeof.cl_mem.toLong(), outVertexBuffer.ptr())
            CL.clSetKernelArg(kernelLarge, 7, Sizeof.cl_mem.toLong(), outUvBuffer.ptr())
            CL.clSetKernelArg(kernelLarge, 8, Sizeof.cl_mem.toLong(), normalOutBuffer.ptr())
            CL.clSetKernelArg(kernelLarge, 9, Sizeof.cl_mem.toLong(), normalBuffer.ptr())
            CL.clSetKernelArg(kernelLarge, 10, Sizeof.cl_mem.toLong(), tempNormalBuffer.ptr())
            CL.clSetKernelArg(kernelLarge, 11, Sizeof.cl_mem.toLong(), uniformBuffer.ptr())
            CL.clEnqueueNDRangeKernel(
                commandQueue,
                kernelLarge,
                1,
                null,
                longArrayOf(largeModels.toLong() * (LARGE_SIZE / largeFaceCount)),
                longArrayOf((LARGE_SIZE / largeFaceCount).toLong()),
                1,
                arrayOf(acquireGLBuffers),
                computeEvents[numComputeEvents++]
            )
        }
        if (numComputeEvents == 0) {
            CL.clEnqueueReleaseGLObjects(commandQueue, glBuffers.size, glBuffers, 0, null, null)
        } else {
            CL.clEnqueueReleaseGLObjects(commandQueue, glBuffers.size, glBuffers, numComputeEvents, computeEvents, null)
        }
    }

    fun finish() {
        CL.clFinish(commandQueue)
    }

    private const val GL_SHARING_PLATFORM_EXT = "cl_khr_gl_sharing"
    private const val KERNEL_NAME_UNORDERED = "computeUnordered"
    private const val KERNEL_NAME_LARGE = "computeLarge"
    private const val MIN_WORK_GROUP_SIZE = 256
    private const val SMALL_SIZE = GpuHDPlugin.SMALL_TRIANGLE_COUNT
    private const val LARGE_SIZE = GpuHDPlugin.MAX_TRIANGLE

    //  struct shared_data {
    //      int totalNum[12];
    //      int totalDistance[12];
    //      int totalMappedNum[18];
    //      int min10;
    //      int dfs[0];
    //  };
    private const val SHARED_SIZE = 12 + 12 + 18 + 1 // in ints
}