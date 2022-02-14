package rs117.hd

import com.google.common.primitives.Ints
import com.jogamp.common.os.Platform
import com.jogamp.nativewindow.awt.AWTGraphicsConfiguration
import com.jogamp.nativewindow.awt.JAWTWindow
import com.jogamp.opengl.*
import com.jogamp.opengl.math.Matrix4
import eventbus.events.*
import jogamp.nativewindow.SurfaceScaleUtils
import jogamp.nativewindow.jawt.x11.X11JAWTWindow
import jogamp.nativewindow.macosx.OSXUtil
import jogamp.newt.awt.NewtFactoryAWT
import meteor.Logger.Companion.getLogger
import meteor.Logger.Companion.isDebugEnabled
import meteor.config.ConfigManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.PluginManager
import meteor.rs.ClientThread
import meteor.ui.DrawManager
import net.runelite.api.*
import net.runelite.api.hooks.DrawCallbacks
import org.jocl.CL
import org.rationalityfrontline.kevent.Event
import rs117.hd.GLUtil.glDeleteBuffer
import rs117.hd.GLUtil.glDeleteFrameBuffer
import rs117.hd.GLUtil.glDeleteRenderbuffers
import rs117.hd.GLUtil.glDeleteTexture
import rs117.hd.GLUtil.glDeleteVertexArrays
import rs117.hd.GLUtil.glGenBuffers
import rs117.hd.GLUtil.glGenFrameBuffer
import rs117.hd.GLUtil.glGenRenderbuffer
import rs117.hd.GLUtil.glGenTexture
import rs117.hd.GLUtil.glGenVertexArrays
import rs117.hd.GLUtil.glGetProgram
import rs117.hd.GLUtil.glGetProgramInfoLog
import rs117.hd.HDUtils.lerp
import rs117.hd.HDUtils.linearToGamma
import rs117.hd.config.*
import rs117.hd.environments.EnvironmentManager
import rs117.hd.lighting.LightManager
import rs117.hd.materials.Material
import rs117.hd.materials.ObjectProperties
import rs117.hd.template.Template
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Image
import java.awt.image.BufferedImage
import java.awt.image.DataBufferInt
import java.nio.Buffer
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.math.log10

@PluginDescriptor(
    name = "GPU HD (beta)",
    description = "117 GPU renderer with a suite of graphical enhancements",
    tags = arrayOf("hd", "high", "detail", "graphics", "shaders", "textures")
)
class GpuHDPlugin : DrawCallbacks, Plugin() {
    companion object {
        const val MAX_DISTANCE = 90
        const val MAX_FOG_DEPTH = 100
        // This is the maximum number of triangles the compute shaders support
        const val MAX_TRIANGLE = 4096
        const val SMALL_TRIANGLE_COUNT = 512
    }

    private val FLAG_SCENE_BUFFER = Int.MIN_VALUE
    private val DEFAULT_DISTANCE = 25

    // MAX_MATERIALS and MAX_LIGHTS must match the #defined values in the HD and shadow fragment shaders
    private val MAX_MATERIALS = 200
    private val MAX_LIGHTS = 100
    private val MATERIAL_PROPERTIES_COUNT = 12
    private val LIGHT_PROPERTIES_COUNT = 8
    private val SCALAR_BYTES = 4
    var log = getLogger(javaClass)
    private val openCLManager = OpenCLManager
    private val clientThread = ClientThread
    override val config = configuration<HdPluginConfig>()
    private val textureManager = TextureManager

    private val lightManager = LightManager(config, this)
    private val environmentManager = EnvironmentManager(config, this)
    private val drawManager = DrawManager
    private val pluginManager = PluginManager
    private val proceduralGenerator = ProceduralGenerator(this)
    private val sceneUploader = SceneUploader(this, proceduralGenerator)
    private val configManager = ConfigManager

    private var computeMode = ComputeMode.OPENGL

    private var canvas: Canvas? = null
    private var jawtWindow: JAWTWindow? = null
    private var gl: GL4? = null
    private var glContext: GLContext? = null
    private var glDrawable: GLDrawable? = null
    val LINUX_VERSION_HEADER: String = "#version 420\n" +
            "#extension GL_ARB_compute_shader : require\n" +
            "#extension GL_ARB_shader_storage_buffer_object : require\n" +
            "#extension GL_ARB_explicit_attrib_location : require"
        val WINDOWS_VERSION_HEADER = "#version 430\n"

    val PROGRAM = Shader()
        .add(GL4.GL_VERTEX_SHADER, "vert.glsl")
        .add(GL4.GL_GEOMETRY_SHADER, "geom.glsl")
        .add(GL4.GL_FRAGMENT_SHADER, "frag.glsl")

    val SHADOW_PROGRAM = Shader()
        .add(GL4.GL_VERTEX_SHADER, "shadow_vert.glsl")
        .add(GL4.GL_FRAGMENT_SHADER, "shadow_frag.glsl")

    val COMPUTE_PROGRAM = Shader()
        .add(GL4.GL_COMPUTE_SHADER, "comp.glsl")

    val SMALL_COMPUTE_PROGRAM = Shader()
        .add(GL4.GL_COMPUTE_SHADER, "comp_small.glsl")

    val UNORDERED_COMPUTE_PROGRAM = Shader()
        .add(GL4.GL_COMPUTE_SHADER, "comp_unordered.glsl")

    val UI_PROGRAM = Shader()
        .add(GL4.GL_VERTEX_SHADER, "vertui.glsl")
        .add(GL4.GL_FRAGMENT_SHADER, "fragui.glsl")

    private var glProgram = 0
    private var glComputeProgram = 0
    private var glSmallComputeProgram = 0
    private var glUnorderedComputeProgram = 0
    private var glUiProgram = 0
    private var glShadowProgram = 0

    private var vaoHandle = 0

    private var interfaceTexture = 0

    private var vaoUiHandle = 0
    private var vboUiHandle = 0

    private var fboSceneHandle = 0
    private var rboSceneHandle = 0

    private var fboShadowMap = 0
    private var texShadowMap = 0

    // scene vertex buffer
    private val sceneVertexBuffer = GLBuffer()

    // scene uv buffer
    private val sceneUvBuffer = GLBuffer()

    // scene normal buffer
    private val sceneNormalBuffer = GLBuffer()

    private val tmpVertexBuffer = GLBuffer() // temporary scene vertex buffer

    private val tmpUvBuffer = GLBuffer() // temporary scene uv buffer

    private val tmpNormalBuffer = GLBuffer() // temporary scene normal buffer

    private val tmpModelBufferLarge = GLBuffer() // scene model buffer, large

    private val tmpModelBufferSmall = GLBuffer() // scene model buffer, small

    private val tmpModelBufferUnordered = GLBuffer() // scene model buffer, unordered

    private val tmpOutBuffer = GLBuffer() // target vertex buffer for compute shaders

    private val tmpOutUvBuffer = GLBuffer() // target uv buffer for compute shaders

    private val tmpOutNormalBuffer = GLBuffer() // target normal buffer for compute shaders


    private var textureArrayId = 0
    private var textureHDArrayId = 0

    private val uniformBuffer = GLBuffer()
    private val textureOffsets = FloatArray(256)
    private val materialsUniformBuffer = GLBuffer()
    private val lightsUniformBuffer = GLBuffer()
    private var lightsUniformBuf: ByteBuffer? = null

    private var vertexBuffer: GpuIntBuffer? = null
    private var uvBuffer: GpuFloatBuffer? = null
    private var normalBuffer: GpuFloatBuffer? = null

    private var modelBufferUnordered: GpuIntBuffer? = null
    private var modelBufferSmall: GpuIntBuffer? = null
    private var modelBuffer: GpuIntBuffer? = null

    private var unorderedModels = 0

    /**
     * number of models in small buffer
     */
    private var smallModels = 0

    /**
     * number of models in large buffer
     */
    private var largeModels = 0

    /**
     * offset in the target buffer for model
     */
    private var targetBufferOffset = 0

    /**
     * offset into the temporary scene vertex buffer
     */
    private var tempOffset = 0

    /**
     * offset into the temporary scene uv buffer
     */
    private var tempUvOffset = 0

    private var lastCanvasWidth = 0
    private var lastCanvasHeight = 0
    private var lastStretchedCanvasWidth = 0
    private var lastStretchedCanvasHeight = 0
    private var lastAntiAliasingMode: AntiAliasingMode? = null
    private var lastAnisotropicFilteringLevel = -1

    private var yaw = 0
    private var pitch = 0

    // Uniforms
    private var uniColorBlindMode = 0
    private var uniUiColorBlindMode = 0
    private var uniUseFog = 0
    private var uniFogColor = 0
    private var uniFogDepth = 0
    private var uniDrawDistance = 0
    private var uniWaterColorLight = 0
    private var uniWaterColorMid = 0
    private var uniWaterColorDark = 0
    private var uniAmbientStrength = 0
    private var uniAmbientColor = 0
    private var uniLightStrength = 0
    private var uniLightColor = 0
    private var uniUnderglowStrength = 0
    private var uniUnderglowColor = 0
    private var uniGroundFogStart = 0
    private var uniGroundFogEnd = 0
    private var uniGroundFogOpacity = 0
    private var uniLightningBrightness = 0
    private var uniWaterEffects = 0
    private var uniSaturation = 0
    private var uniContrast = 0
    private var uniLightX = 0
    private var uniLightY = 0
    private var uniLightZ = 0
    private var uniShadowMaxBias = 0
    private var uniShadowsEnabled = 0

    // Shadow program uniforms
    private var uniShadowTexturesHD = 0
    private var uniShadowTextureOffsets = 0
    private var uniShadowLightProjectionMatrix = 0

    // Point light uniforms
    private var uniPointLightsCount = 0

    private var uniProjectionMatrix = 0
    private var uniLightProjectionMatrix = 0
    private var uniShadowMap = 0
    private var uniTex = 0
    private var uniTexSamplingMode = 0
    private var uniTexSourceDimensions = 0
    private var uniTexTargetDimensions = 0
    private var uniUiAlphaOverlay = 0
    private var uniTextures = 0
    private var uniTexturesHD = 0
    private var uniTextureOffsets = 0
    private var uniAnimationCurrent = 0

    private var uniBlockSmall = 0
    private var uniBlockLarge = 0
    private var uniBlockMain = 0
    private var uniBlockMaterials = 0
    private var uniShadowBlockMaterials = 0
    private var uniBlockPointLights = 0

    // Animation things
    private var lastFrameTime = System.currentTimeMillis()

    // Generic scalable animation timer used in shaders
    private var animationCurrent = 0f

    // Config settings used very frequently - thousands/frame
    var configGroundTextures = false
    var configGroundBlending = false
    var configWaterEffects = WaterEffects.ALL
    var configLevelOfDetail = LevelOfDetail.FULL
    var configObjectTextures = true
    var configTzhaarHD = true
    var configProjectileLights = true
    var configNpcLights = true
    var configShadowsEnabled = false
    var configExpandShadowDraw = false
    var configUnlockFps = false

    // Reduces drawing a buggy mess when toggling HD
    private var startUpCompleted = false

    var camTarget = IntArray(3)

    override fun onStart() {
        configGroundTextures = config.groundTextures()
        configGroundBlending = config.groundBlending()
        configWaterEffects = config.waterEffects()!!
        configLevelOfDetail = config.levelOfDetail()!!
        configObjectTextures = config.objectTextures()
        configTzhaarHD = config.tzhaarHD()
        configProjectileLights = config.projectileLights()
        configNpcLights = config.npcLights()
        configShadowsEnabled = config.shadowsEnabled()
        configExpandShadowDraw = config.expandShadowDraw()
        configUnlockFps = config.unlockFps()
        clientThread.invoke {
            try {
                rboSceneHandle = -1
                fboSceneHandle = rboSceneHandle // AA FBO
                fboShadowMap = -1
                largeModels = 0
                smallModels = largeModels
                unorderedModels = smallModels
                canvas = client.canvas
                if (canvas == null)
                    return@invoke
                if (!canvas!!.isDisplayable) {
                    return@invoke
                }
                computeMode =
                    if (Platform.getOSType() == Platform.OSType.MACOS) ComputeMode.OPENCL else ComputeMode.OPENGL
                canvas!!.ignoreRepaint = true
                vertexBuffer = GpuIntBuffer()
                uvBuffer = GpuFloatBuffer()
                normalBuffer = GpuFloatBuffer()
                modelBufferUnordered = GpuIntBuffer()
                modelBufferSmall = GpuIntBuffer()
                modelBuffer = GpuIntBuffer()

                //System.setProperty("jogl.debug", "true");
                GLProfile.initSingleton()
                invokeOnMainThread {

                    // Get and display the device and driver used by the GPU plugin
                    val dummyDrawable = GLDrawableFactory.getFactory(GLProfile.getDefault())
                        .createDummyDrawable(
                            GLProfile.getDefaultDevice(),
                            true,
                            GLCapabilities(GLProfile.getDefault()),
                            null
                        )
                    dummyDrawable.isRealized = true
                    val versionContext = dummyDrawable.createContext(null)
                    versionContext.makeCurrent()
                    // Due to probable JOGL spaghetti, calling .getGL() once results in versionGL being set to null
                    // I have no idea exactly why the second call works, but it results in the correct GL being gotten.
                    val versionGL = versionContext.gl.gl
                    //log.info("Using device: {}", versionGL.glGetString(GL.GL_RENDERER));
                    //log.info("Using driver: {}", versionGL.glGetString(GL.GL_VERSION));
                    versionContext.destroy()
                    val glProfile = GLProfile.get(GLProfile.GL4)
                    val glCaps = GLCapabilities(glProfile)
                    val config =
                        AWTGraphicsConfiguration.create(canvas!!.graphicsConfiguration, glCaps, glCaps)
                    jawtWindow = NewtFactoryAWT.getNativeWindow(canvas, config)
                    canvas!!.isFocusable = true
                    val glDrawableFactory = GLDrawableFactory.getFactory(glProfile)
                    jawtWindow!!.lockSurface()
                    try {
                        glDrawable = glDrawableFactory.createGLDrawable(jawtWindow)
                        glDrawable!!.isRealized = true
                        glContext = glDrawable!!.createContext(null)
                        if (isDebugEnabled) {
                            // Debug config on context needs to be set before .makeCurrent call
                            //glContext.enableGLDebugMessage(true);
                        }
                    } finally {
                        jawtWindow!!.unlockSurface()
                    }
                    val res = glContext!!.makeCurrent()
                    if (res == GLContext.CONTEXT_NOT_CURRENT) {
                        throw GLException("Unable to make context current")
                    }

                    // Surface needs to be unlocked on X11 window otherwise input is blocked
                    if (jawtWindow is X11JAWTWindow && jawtWindow!!.lock.isLocked) {
                        jawtWindow!!.unlockSurface()
                    }
                    gl = glContext!!.gl.gL4
                    val unlockFps = this.config.unlockFps()
                    client.isUnlockedFps = unlockFps
                    gl!!.swapInterval = if (unlockFps) 1 else 0
                    if (false) {
                        gl!!.glEnable(GL2ES2.GL_DEBUG_OUTPUT)

                        // Suppress warning messages which flood the log on NVIDIA systems.
                        gl!!.context.glDebugMessageControl(
                            GL2ES2.GL_DEBUG_SOURCE_API, GL2ES2.GL_DEBUG_TYPE_OTHER,
                            GL2ES2.GL_DEBUG_SEVERITY_NOTIFICATION, 0, null, 0, false
                        )
                    }
                    initVao()
                    try {
                        initProgram()
                    } catch (ex: ShaderException) {
                        throw RuntimeException(ex)
                    }
                    initInterfaceTexture()
                    initUniformBuffer()
                    initMaterialsUniformBuffer()
                    initLightsUniformBuffer()
                    initBuffers()
                    initShadowMapFbo()
                }
                client.setDrawCallbacks(this)
                client.isGpu = true

                // force rebuild of main buffer provider to enable alpha channel
                client.`resizeCanvas$api`()
                lastCanvasHeight = -1
                lastCanvasWidth = lastCanvasHeight
                lastStretchedCanvasHeight = -1
                lastStretchedCanvasWidth = lastStretchedCanvasHeight
                lastAntiAliasingMode = null
                textureArrayId = -1
                textureHDArrayId = -1

                // load all dynamic scene lights from text file
                lightManager.loadLightsFromFile()
                if (client.gameState == GameState.LOGGED_IN) {
                    invokeOnMainThread { this.uploadScene() }
                }
                startUpCompleted = true
            } catch (e: Throwable) {
                e.printStackTrace()
                onStop()
            }
        }
    }

    override fun onStop() {
        startUpCompleted = false
        lightManager.reset()
        clientThread.invoke {
            client.isGpu = false
            client.drawCallbacks = null
            invokeOnMainThread(Runnable {
                openCLManager.cleanup()
                if (gl != null) {
                    if (textureArrayId != -1) {
                        textureManager.freeTextureArray(gl!!, textureArrayId)
                        textureArrayId = -1
                    }
                    if (textureHDArrayId != -1) {
                        textureManager.freeTextureArray(gl!!, textureHDArrayId)
                        textureHDArrayId = -1
                    }
                    destroyGlBuffer(uniformBuffer)
                    destroyGlBuffer(materialsUniformBuffer)
                    destroyGlBuffer(lightsUniformBuffer)
                    shutdownBuffers()
                    shutdownInterfaceTexture()
                    shutdownProgram()
                    shutdownVao()
                    shutdownAAFbo()
                    shutdownShadowMapFbo()
                }
                if (jawtWindow != null) {
                    if (!jawtWindow!!.lock.isLocked) {
                        jawtWindow!!.lockSurface()
                    }
                    if (glContext != null) {
                        glContext!!.destroy()
                    }

                    // this crashes on osx when the plugin is turned back on, don't know why
                    // we'll just leak the window...
                    if (Platform.getOSType() != Platform.OSType.MACOS) {
                        NewtFactoryAWT.destroyNativeWindow(jawtWindow)
                    }
                }
            })
            GLProfile.shutdown()
            jawtWindow = null
            gl = null
            glDrawable = null
            glContext = null
            vertexBuffer = null
            uvBuffer = null
            normalBuffer = null
            modelBufferSmall = null
            modelBuffer = null
            modelBufferUnordered = null
            lastAnisotropicFilteringLevel = -1

            // force main buffer provider rebuild to turn off alpha channel
            client.`resizeCanvas$api`()
        }
    }

    @Throws(ShaderException::class)
    private fun initProgram() {
        val versionHeader =
            if (Platform.getOSType() == Platform.OSType.LINUX) LINUX_VERSION_HEADER else WINDOWS_VERSION_HEADER
        val template = Template()
        template.add { key: String? ->
            when (key) {
                "version_header" -> return@add versionHeader
                "CONST_MACOS_INTEL_WORKAROUND" -> return@add String.format(
                    "#define %s %d\n",
                    key,
                    if (config.macosIntelWorkaround()) 1 else 0
                )
                "MACOS_INTEL_WORKAROUND_MATERIAL_CASES" -> {
                    val sb = StringBuilder(
                        MAX_MATERIALS * ("case : return material[];".length +
                                (log10(MAX_MATERIALS.toDouble()).toInt() + 1) * 2)
                    )
                    var i = 0
                    while (i < MAX_MATERIALS) {
                        sb.append("case ").append(i).append(": return material[").append(i).append("];\n")
                        i++
                    }
                    return@add sb.toString()
                }
            }
            null
        }
        template.addInclude(GpuHDPlugin::class.java)
        glProgram = PROGRAM.compile(gl!!, template)
        glUiProgram = UI_PROGRAM.compile(gl!!, template)
        glShadowProgram = SHADOW_PROGRAM.compile(gl!!, template)
        if (computeMode === ComputeMode.OPENCL) {
            openCLManager.init(gl!!)
        } else {
            glComputeProgram = COMPUTE_PROGRAM.compile(gl!!, template)
            glSmallComputeProgram = SMALL_COMPUTE_PROGRAM.compile(gl!!, template)
            glUnorderedComputeProgram = UNORDERED_COMPUTE_PROGRAM.compile(gl!!, template)
        }
        initUniforms()
        gl!!.glUseProgram(glProgram)

        // bind texture samplers before validating, else the validation fails
        gl!!.glUniform1i(uniTextures, 1) // texture sampler array is bound to texture1
        gl!!.glUniform1i(uniTexturesHD, 2) // HD texture sampler array is bound to texture2
        gl!!.glUniform1i(uniShadowMap, 3) // shadow map sampler is bound to texture3
        gl!!.glUseProgram(0)

        // validate program
        gl!!.glValidateProgram(glProgram)
        if (glGetProgram(gl!!, glProgram, GL2ES2.GL_VALIDATE_STATUS) == GL.GL_FALSE) {
            val err = glGetProgramInfoLog(gl!!, glProgram)
            throw ShaderException(err)
        }
    }

    private fun initUniforms() {
        uniProjectionMatrix = gl!!.glGetUniformLocation(glProgram, "projectionMatrix")
        uniLightProjectionMatrix = gl!!.glGetUniformLocation(glProgram, "lightProjectionMatrix")
        uniShadowMap = gl!!.glGetUniformLocation(glProgram, "shadowMap")
        uniWaterEffects = gl!!.glGetUniformLocation(glProgram, "waterEffects")
        uniSaturation = gl!!.glGetUniformLocation(glProgram, "saturation")
        uniContrast = gl!!.glGetUniformLocation(glProgram, "contrast")
        uniUseFog = gl!!.glGetUniformLocation(glProgram, "useFog")
        uniFogColor = gl!!.glGetUniformLocation(glProgram, "fogColor")
        uniFogDepth = gl!!.glGetUniformLocation(glProgram, "fogDepth")
        uniWaterColorLight = gl!!.glGetUniformLocation(glProgram, "waterColorLight")
        uniWaterColorMid = gl!!.glGetUniformLocation(glProgram, "waterColorMid")
        uniWaterColorDark = gl!!.glGetUniformLocation(glProgram, "waterColorDark")
        uniDrawDistance = gl!!.glGetUniformLocation(glProgram, "drawDistance")
        uniAmbientStrength = gl!!.glGetUniformLocation(glProgram, "ambientStrength")
        uniAmbientColor = gl!!.glGetUniformLocation(glProgram, "ambientColor")
        uniLightStrength = gl!!.glGetUniformLocation(glProgram, "lightStrength")
        uniLightColor = gl!!.glGetUniformLocation(glProgram, "lightColor")
        uniUnderglowStrength = gl!!.glGetUniformLocation(glProgram, "underglowStrength")
        uniUnderglowColor = gl!!.glGetUniformLocation(glProgram, "underglowColor")
        uniGroundFogStart = gl!!.glGetUniformLocation(glProgram, "groundFogStart")
        uniGroundFogEnd = gl!!.glGetUniformLocation(glProgram, "groundFogEnd")
        uniGroundFogOpacity = gl!!.glGetUniformLocation(glProgram, "groundFogOpacity")
        uniLightningBrightness = gl!!.glGetUniformLocation(glProgram, "lightningBrightness")
        uniPointLightsCount = gl!!.glGetUniformLocation(glProgram, "pointLightsCount")
        uniColorBlindMode = gl!!.glGetUniformLocation(glProgram, "colorBlindMode")
        uniLightX = gl!!.glGetUniformLocation(glProgram, "lightX")
        uniLightY = gl!!.glGetUniformLocation(glProgram, "lightY")
        uniLightZ = gl!!.glGetUniformLocation(glProgram, "lightZ")
        uniShadowMaxBias = gl!!.glGetUniformLocation(glProgram, "shadowMaxBias")
        uniShadowsEnabled = gl!!.glGetUniformLocation(glProgram, "shadowsEnabled")
        uniTex = gl!!.glGetUniformLocation(glUiProgram, "tex")
        uniTexSamplingMode = gl!!.glGetUniformLocation(glUiProgram, "samplingMode")
        uniTexTargetDimensions = gl!!.glGetUniformLocation(glUiProgram, "targetDimensions")
        uniTexSourceDimensions = gl!!.glGetUniformLocation(glUiProgram, "sourceDimensions")
        uniUiColorBlindMode = gl!!.glGetUniformLocation(glUiProgram, "colorBlindMode")
        uniUiAlphaOverlay = gl!!.glGetUniformLocation(glUiProgram, "alphaOverlay")
        uniTextures = gl!!.glGetUniformLocation(glProgram, "textures")
        uniTexturesHD = gl!!.glGetUniformLocation(glProgram, "texturesHD")
        uniTextureOffsets = gl!!.glGetUniformLocation(glProgram, "textureOffsets")
        uniAnimationCurrent = gl!!.glGetUniformLocation(glProgram, "animationCurrent")
        uniBlockSmall = gl!!.glGetUniformBlockIndex(glSmallComputeProgram, "uniforms")
        uniBlockLarge = gl!!.glGetUniformBlockIndex(glComputeProgram, "uniforms")
        uniBlockMain = gl!!.glGetUniformBlockIndex(glProgram, "uniforms")
        uniBlockMaterials = gl!!.glGetUniformBlockIndex(glProgram, "materials")
        uniBlockPointLights = gl!!.glGetUniformBlockIndex(glProgram, "pointLights")

        // Shadow program uniforms
        uniShadowBlockMaterials = gl!!.glGetUniformBlockIndex(glShadowProgram, "materials")
        uniShadowLightProjectionMatrix = gl!!.glGetUniformLocation(glShadowProgram, "lightProjectionMatrix")
        uniShadowTexturesHD = gl!!.glGetUniformLocation(glShadowProgram, "texturesHD")
        uniShadowTextureOffsets = gl!!.glGetUniformLocation(glShadowProgram, "textureOffsets")
    }


    private fun shutdownProgram() {
        gl!!.glDeleteProgram(glProgram)
        glProgram = -1
        gl!!.glDeleteProgram(glComputeProgram)
        glComputeProgram = -1
        gl!!.glDeleteProgram(glSmallComputeProgram)
        glSmallComputeProgram = -1
        gl!!.glDeleteProgram(glUnorderedComputeProgram)
        glUnorderedComputeProgram = -1
        gl!!.glDeleteProgram(glUiProgram)
        glUiProgram = -1
        gl!!.glDeleteProgram(glShadowProgram)
        glShadowProgram = -1
    }

    private fun recompileProgram() {
        clientThread.invoke {
            invokeOnMainThread(Runnable {
                try {
                    shutdownProgram()
                    shutdownVao()
                    initVao()
                    initProgram()
                } catch (ex: ShaderException) {
                    log.error("Failed to recompile shader program", ex)
                    onStop()
                }
            })
        }
    }

    private fun initVao() {
        // Create VAO
        vaoHandle = glGenVertexArrays(gl!!)

        // Create UI VAO
        vaoUiHandle = glGenVertexArrays(gl!!)
        // Create UI buffer
        vboUiHandle = glGenBuffers(gl!!)
        gl!!.glBindVertexArray(vaoUiHandle)
        val vboUiBuf = GpuFloatBuffer.allocateDirect(5 * 4)
        vboUiBuf.put(
            floatArrayOf( // positions     // texture coords
                1f, 1f, 0.0f, 1.0f, 0f,  // top right
                1f, -1f, 0.0f, 1.0f, 1f,  // bottom right
                -1f, -1f, 0.0f, 0.0f, 1f,  // bottom left
                -1f, 1f, 0.0f, 0.0f, 0f // top left
            )
        )
        vboUiBuf.rewind()
        gl!!.glBindBuffer(GL.GL_ARRAY_BUFFER, vboUiHandle)
        gl!!.glBufferData(
            GL.GL_ARRAY_BUFFER,
            (vboUiBuf.capacity() * java.lang.Float.BYTES).toLong(),
            vboUiBuf,
            GL.GL_STATIC_DRAW
        )

        // position attribute
        gl!!.glVertexAttribPointer(0, 3, GL.GL_FLOAT, false, 5 * java.lang.Float.BYTES, 0)
        gl!!.glEnableVertexAttribArray(0)

        // texture coord attribute
        gl!!.glVertexAttribPointer(
            1,
            2,
            GL.GL_FLOAT,
            false,
            5 * java.lang.Float.BYTES,
            (3 * java.lang.Float.BYTES).toLong()
        )
        gl!!.glEnableVertexAttribArray(1)

        // unbind VBO
        gl!!.glBindBuffer(GL.GL_ARRAY_BUFFER, 0)
    }

    private fun shutdownVao() {
        glDeleteVertexArrays(gl!!, vaoHandle)
        vaoHandle = -1
        glDeleteBuffer(gl!!, vboUiHandle)
        vboUiHandle = -1
        glDeleteVertexArrays(gl!!, vaoUiHandle)
        vaoUiHandle = -1
    }

    private fun initBuffers() {
        initGlBuffer(sceneVertexBuffer)
        initGlBuffer(sceneUvBuffer)
        initGlBuffer(sceneNormalBuffer)
        initGlBuffer(tmpVertexBuffer)
        initGlBuffer(tmpUvBuffer)
        initGlBuffer(tmpNormalBuffer)
        initGlBuffer(tmpModelBufferLarge)
        initGlBuffer(tmpModelBufferSmall)
        initGlBuffer(tmpModelBufferUnordered)
        initGlBuffer(tmpOutBuffer)
        initGlBuffer(tmpOutUvBuffer)
        initGlBuffer(tmpOutNormalBuffer)
    }

    private fun initGlBuffer(glBuffer: GLBuffer) {
        glBuffer.glBufferId = glGenBuffers(gl!!)
    }

    private fun shutdownBuffers() {
        destroyGlBuffer(sceneVertexBuffer)
        destroyGlBuffer(sceneUvBuffer)
        destroyGlBuffer(sceneNormalBuffer)
        destroyGlBuffer(tmpVertexBuffer)
        destroyGlBuffer(tmpUvBuffer)
        destroyGlBuffer(tmpNormalBuffer)
        destroyGlBuffer(tmpModelBufferLarge)
        destroyGlBuffer(tmpModelBufferSmall)
        destroyGlBuffer(tmpModelBufferUnordered)
        destroyGlBuffer(tmpOutBuffer)
        destroyGlBuffer(tmpOutUvBuffer)
        destroyGlBuffer(tmpOutNormalBuffer)
    }

    private fun destroyGlBuffer(glBuffer: GLBuffer) {
        if (glBuffer.glBufferId != -1) {
            glDeleteBuffer(gl!!, glBuffer.glBufferId)
            glBuffer.glBufferId = -1
        }
        glBuffer.size = -1
        if (glBuffer.cl_mem != null) {
            CL.clReleaseMemObject(glBuffer.cl_mem)
            glBuffer.cl_mem = null
        }
    }

    private fun initInterfaceTexture() {
        interfaceTexture = glGenTexture(gl!!)
        gl!!.glBindTexture(GL.GL_TEXTURE_2D, interfaceTexture)
        gl!!.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP_TO_EDGE)
        gl!!.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP_TO_EDGE)
        gl!!.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR)
        gl!!.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR)
        gl!!.glBindTexture(GL.GL_TEXTURE_2D, 0)
    }

    private fun shutdownInterfaceTexture() {
        glDeleteTexture(gl!!, interfaceTexture)
        interfaceTexture = -1
    }

    private fun initUniformBuffer() {
        initGlBuffer(uniformBuffer)
        val uniformBuf = GpuIntBuffer.allocateDirect(8 + 2048 * 4)
        uniformBuf.put(IntArray(8)) // uniform block
        val pad = IntArray(2)
        for (i in 0..2047) {
            uniformBuf.put(Perspective.SINE[i])
            uniformBuf.put(Perspective.COSINE[i])
            uniformBuf.put(pad) // ivec2 alignment in std140 is 16 bytes
        }
        uniformBuf.flip()
        updateBuffer(
            uniformBuffer,
            GL2ES3.GL_UNIFORM_BUFFER,
            uniformBuf.limit() * Integer.BYTES,
            uniformBuf,
            GL.GL_DYNAMIC_DRAW,
            CL.CL_MEM_READ_ONLY
        )
        gl!!.glBindBuffer(GL2ES3.GL_UNIFORM_BUFFER, 0)
    }

    private fun initMaterialsUniformBuffer() {
        if (Material.values().size > MAX_MATERIALS) {
            log.error("Number of materials exceeds value of MAX_MATERIALS")
        }
        initGlBuffer(materialsUniformBuffer)
        val materialUniformBuf =
            ByteBuffer.allocateDirect(MAX_MATERIALS * MATERIAL_PROPERTIES_COUNT * SCALAR_BYTES)
                .order(ByteOrder.nativeOrder())
        for (i in 0 until Math.min(MAX_MATERIALS, Material.values().size)) {
            val material = Material.values()[i]
            materialUniformBuf.putInt(material.diffuseMapId)
            materialUniformBuf.putFloat(material.specularStrength)
            materialUniformBuf.putFloat(material.specularGloss)
            materialUniformBuf.putFloat(material.emissiveStrength)
            materialUniformBuf.putInt(material.displacementMapId)
            materialUniformBuf.putFloat(material.displacementStrength)
            materialUniformBuf.putFloat(material.displacementDurationX)
            materialUniformBuf.putFloat(material.displacementDurationY)
            materialUniformBuf.putFloat(material.scrollDurationX)
            materialUniformBuf.putFloat(material.scrollDurationY)
            materialUniformBuf.putFloat(material.textureScaleX)
            materialUniformBuf.putFloat(material.textureScaleY)

            // UBO elements must be divisible by groups of 4 scalars. Pad any remaining space
            materialUniformBuf.put(
                ByteArray(
                    (Math.ceil((MATERIAL_PROPERTIES_COUNT / 4f).toDouble())
                        .toInt() * 4 - MATERIAL_PROPERTIES_COUNT) * SCALAR_BYTES
                )
            )
        }
        materialUniformBuf.flip()
        updateBuffer(
            materialsUniformBuffer,
            GL2ES3.GL_UNIFORM_BUFFER,
            MAX_MATERIALS * MATERIAL_PROPERTIES_COUNT * SCALAR_BYTES,
            materialUniformBuf,
            GL.GL_STATIC_DRAW,
            CL.CL_MEM_READ_ONLY
        )
        gl!!.glBindBuffer(GL2ES3.GL_UNIFORM_BUFFER, 0)
    }

    private fun initLightsUniformBuffer() {
        if (config.maxDynamicLights()!!.value > MAX_LIGHTS) {
            log.warn("Number of max dynamic lights exceeds value of MAX_LIGHTS")
        }
        initGlBuffer(lightsUniformBuffer)
        lightsUniformBuf =
            ByteBuffer.allocateDirect(MAX_LIGHTS * LIGHT_PROPERTIES_COUNT * SCALAR_BYTES)
                .order(ByteOrder.nativeOrder())
        updateBuffer(
            lightsUniformBuffer,
            GL2ES3.GL_UNIFORM_BUFFER,
            MAX_LIGHTS * LIGHT_PROPERTIES_COUNT * SCALAR_BYTES,
            null,
            GL.GL_DYNAMIC_DRAW,
            CL.CL_MEM_READ_ONLY
        )
        gl!!.glBindBuffer(GL2ES3.GL_UNIFORM_BUFFER, 0)
    }

    private fun updateBuffer(glBuffer: GLBuffer, target: Int, size: Int, data: Buffer?, usage: Int, clFlags: Long) {
        gl!!.glBindBuffer(target, glBuffer.glBufferId)
        if (size > glBuffer.size) {
            //log.trace("Buffer resize: {} {} -> {}", glBuffer, glBuffer.size, size);
            glBuffer.size = size
            gl!!.glBufferData(target, size.toLong(), data, usage)
            if (computeMode === ComputeMode.OPENCL) {
                // cleanup previous buffer
                if (glBuffer.cl_mem != null) {
                    CL.clReleaseMemObject(glBuffer.cl_mem)
                }

                // allocate new
                if (size == 0) {
                    // opencl does not allow 0-size gl buffers, it will segfault on macos
                    glBuffer.cl_mem = null
                } else {
                    glBuffer.cl_mem = CL.clCreateFromGLBuffer(openCLManager.context, clFlags, glBuffer.glBufferId, null)
                }
            }
        } else if (data != null) {
            gl!!.glBufferSubData(target, 0, size.toLong(), data)
        }
    }

    private fun initAAFbo(width: Int, height: Int, aaSamples: Int) {
        // Create and bind the FBO
        fboSceneHandle = glGenFrameBuffer(gl!!)
        gl!!.glBindFramebuffer(GL.GL_FRAMEBUFFER, fboSceneHandle)

        // Create color render buffer
        rboSceneHandle = glGenRenderbuffer(gl!!)
        gl!!.glBindRenderbuffer(GL.GL_RENDERBUFFER, rboSceneHandle)
        gl!!.glRenderbufferStorageMultisample(GL.GL_RENDERBUFFER, aaSamples, GL.GL_RGBA, width, height)
        gl!!.glFramebufferRenderbuffer(GL.GL_FRAMEBUFFER, GL.GL_COLOR_ATTACHMENT0, GL.GL_RENDERBUFFER, rboSceneHandle)

        // Reset
        gl!!.glBindFramebuffer(GL.GL_FRAMEBUFFER, 0)
        gl!!.glBindRenderbuffer(GL.GL_RENDERBUFFER, 0)
    }

    private fun shutdownAAFbo() {
        if (fboSceneHandle != -1) {
            glDeleteFrameBuffer(gl!!, fboSceneHandle)
            fboSceneHandle = -1
        }
        if (rboSceneHandle != -1) {
            glDeleteRenderbuffers(gl!!, rboSceneHandle)
            rboSceneHandle = -1
        }
    }

    private fun initShadowMapFbo() {
        if (!configShadowsEnabled) {
            return
        }

        // Create and bind the FBO
        fboShadowMap = glGenFrameBuffer(gl!!)
        gl!!.glBindFramebuffer(GL.GL_FRAMEBUFFER, fboShadowMap)

        // Create texture
        texShadowMap = glGenTexture(gl!!)
        gl!!.glBindTexture(GL.GL_TEXTURE_2D, texShadowMap)
        gl!!.glTexImage2D(
            GL.GL_TEXTURE_2D,
            0,
            GL2ES2.GL_DEPTH_COMPONENT,
            config.shadowResolution()!!.value,
            config.shadowResolution()!!.value,
            0,
            GL2ES2.GL_DEPTH_COMPONENT,
            GL.GL_FLOAT,
            null
        )
        gl!!.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST)
        gl!!.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST)
        gl!!.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL2ES2.GL_CLAMP_TO_BORDER)
        gl!!.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL2ES2.GL_CLAMP_TO_BORDER)
        val color = floatArrayOf(1.0f, 1.0f, 1.0f, 1.0f)
        gl!!.glTexParameterfv(GL.GL_TEXTURE_2D, GL2ES2.GL_TEXTURE_BORDER_COLOR, color, 0)

        // Bind texture
        gl!!.glFramebufferTexture2D(GL.GL_FRAMEBUFFER, GL.GL_DEPTH_ATTACHMENT, GL.GL_TEXTURE_2D, texShadowMap, 0)
        gl!!.glDrawBuffer(GL.GL_NONE)
        gl!!.glReadBuffer(GL.GL_NONE)

        // Reset
        gl!!.glBindTexture(GL.GL_TEXTURE_2D, 0)
        gl!!.glBindFramebuffer(GL.GL_FRAMEBUFFER, 0)
    }

    private fun shutdownShadowMapFbo() {
        if (texShadowMap != -1) {
            glDeleteTexture(gl!!, texShadowMap)
            texShadowMap = -1
        }
        if (fboShadowMap != -1) {
            glDeleteFrameBuffer(gl!!, fboShadowMap)
            fboShadowMap = -1
        }
    }

    override fun drawScene(cameraX: Int, cameraY: Int, cameraZ: Int, cameraPitch: Int, cameraYaw: Int, plane: Int) {
        yaw = client.cameraYaw
        pitch = client.cameraPitch
        val scene = client.scene
        scene.drawDistance = getDrawDistance()
        if (!environmentManager.update()) return
        lightManager.update()
        invokeOnMainThread(Runnable {

            // UBO. Only the first 32 bytes get modified here, the rest is the constant sin/cos table.
            // We can reuse the vertex buffer since it isn't used yet.
            vertexBuffer!!.clear()
            vertexBuffer!!.ensureCapacity(32)
            val uniformBuf = vertexBuffer!!.buffer
            uniformBuf
                .put(yaw)
                .put(pitch)
                .put(client.centerX)
                .put(client.centerY)
                .put(client.scale)
                .put(cameraX)
                .put(cameraY)
                .put(cameraZ)
            uniformBuf.flip()
            gl!!.glBindBuffer(GL2ES3.GL_UNIFORM_BUFFER, uniformBuffer.glBufferId)
            gl!!.glBufferSubData(
                GL2ES3.GL_UNIFORM_BUFFER,
                0,
                (uniformBuf.limit() * Integer.BYTES).toLong(),
                uniformBuf
            )
            gl!!.glBindBuffer(GL2ES3.GL_UNIFORM_BUFFER, 0)
            gl!!.glBindBufferBase(GL2ES3.GL_UNIFORM_BUFFER, 0, uniformBuffer.glBufferId)
            uniformBuf.clear()

            // Bind materials UBO
            gl!!.glBindBuffer(GL2ES3.GL_UNIFORM_BUFFER, materialsUniformBuffer.glBufferId)
            gl!!.glBindBufferBase(GL2ES3.GL_UNIFORM_BUFFER, 1, materialsUniformBuffer.glBufferId)
            gl!!.glBindBuffer(GL2ES3.GL_UNIFORM_BUFFER, 0)
            if (config.maxDynamicLights()!!.value > 0) {
                // Update lights UBO
                lightsUniformBuf!!.clear()
                val visibleLights =
                    lightManager.getVisibleLights(getDrawDistance(), config.maxDynamicLights()!!.value)
                for (light in visibleLights) {
                    lightsUniformBuf!!.putInt(light.x)
                    lightsUniformBuf!!.putInt(light.y)
                    lightsUniformBuf!!.putInt(light.z)
                    lightsUniformBuf!!.putFloat(light.currentSize.toFloat())
                    lightsUniformBuf!!.putFloat(light.currentColor[0])
                    lightsUniformBuf!!.putFloat(light.currentColor[1])
                    lightsUniformBuf!!.putFloat(light.currentColor[2])
                    lightsUniformBuf!!.putFloat(light.currentStrength)

                    // UBO elements must be divisible by groups of 4 scalars. Pad any remaining space
                    lightsUniformBuf!!.put(
                        ByteArray(
                            (Math.ceil((LIGHT_PROPERTIES_COUNT / 4f).toDouble())
                                .toInt() * 4 - LIGHT_PROPERTIES_COUNT) * SCALAR_BYTES
                        )
                    )
                }
                lightsUniformBuf!!.flip()
                gl!!.glBindBuffer(GL2ES3.GL_UNIFORM_BUFFER, lightsUniformBuffer.glBufferId)
                gl!!.glBufferSubData(
                    GL2ES3.GL_UNIFORM_BUFFER,
                    0,
                    (MAX_LIGHTS * LIGHT_PROPERTIES_COUNT * SCALAR_BYTES).toLong(),
                    lightsUniformBuf
                )
                lightsUniformBuf!!.clear()
            }
            gl!!.glBindBufferBase(GL2ES3.GL_UNIFORM_BUFFER, 2, lightsUniformBuffer.glBufferId)
            gl!!.glBindBuffer(GL2ES3.GL_UNIFORM_BUFFER, 0)
        })
    }

    override fun postDrawScene() {
        invokeOnMainThread(Runnable { postDraw() })
    }

    private fun postDraw() {
        // Upload buffers
        vertexBuffer!!.flip()
        uvBuffer!!.flip()
        normalBuffer!!.flip()
        modelBuffer!!.flip()
        modelBufferSmall!!.flip()
        modelBufferUnordered!!.flip()
        val vertexBuffer = vertexBuffer!!.buffer
        val uvBuffer = uvBuffer!!.buffer
        val normalBuffer = normalBuffer!!.buffer
        val modelBuffer = modelBuffer!!.buffer
        val modelBufferSmall = modelBufferSmall!!.buffer
        val modelBufferUnordered = modelBufferUnordered!!.buffer

        // temp buffers
        updateBuffer(
            tmpVertexBuffer,
            GL.GL_ARRAY_BUFFER,
            vertexBuffer.limit() * Integer.BYTES,
            vertexBuffer,
            GL.GL_DYNAMIC_DRAW,
            CL.CL_MEM_READ_ONLY
        )
        updateBuffer(
            tmpUvBuffer,
            GL.GL_ARRAY_BUFFER,
            uvBuffer.limit() * java.lang.Float.BYTES,
            uvBuffer,
            GL.GL_DYNAMIC_DRAW,
            CL.CL_MEM_READ_ONLY
        )
        updateBuffer(
            tmpNormalBuffer,
            GL.GL_ARRAY_BUFFER,
            normalBuffer.limit() * java.lang.Float.BYTES,
            normalBuffer,
            GL.GL_DYNAMIC_DRAW,
            CL.CL_MEM_READ_ONLY
        )

        // model buffers
        updateBuffer(
            tmpModelBufferLarge,
            GL.GL_ARRAY_BUFFER,
            modelBuffer.limit() * Integer.BYTES,
            modelBuffer,
            GL.GL_DYNAMIC_DRAW,
            CL.CL_MEM_READ_ONLY
        )
        updateBuffer(
            tmpModelBufferSmall,
            GL.GL_ARRAY_BUFFER,
            modelBufferSmall.limit() * Integer.BYTES,
            modelBufferSmall,
            GL.GL_DYNAMIC_DRAW,
            CL.CL_MEM_READ_ONLY
        )
        updateBuffer(
            tmpModelBufferUnordered,
            GL.GL_ARRAY_BUFFER,
            modelBufferUnordered.limit() * Integer.BYTES,
            modelBufferUnordered,
            GL.GL_DYNAMIC_DRAW,
            CL.CL_MEM_READ_ONLY
        )

        // Output buffers
        updateBuffer(
            tmpOutBuffer,
            GL.GL_ARRAY_BUFFER,
            targetBufferOffset * 16,  // each vertex is an ivec4, which is 16 bytes
            null,
            GL2ES2.GL_STREAM_DRAW,
            CL.CL_MEM_WRITE_ONLY
        )
        updateBuffer(
            tmpOutUvBuffer,
            GL.GL_ARRAY_BUFFER,
            targetBufferOffset * 16,  // each vertex is an ivec4, which is 16 bytes
            null,
            GL2ES2.GL_STREAM_DRAW,
            CL.CL_MEM_WRITE_ONLY
        )
        updateBuffer(
            tmpOutNormalBuffer,
            GL.GL_ARRAY_BUFFER,
            targetBufferOffset * 16,  // each vertex is an ivec4, which is 16 bytes
            null,
            GL2ES2.GL_STREAM_DRAW,
            CL.CL_MEM_WRITE_ONLY
        )
        if (computeMode === ComputeMode.OPENCL) {
            // The docs for clEnqueueAcquireGLObjects say all pending GL operations must be completed before calling
            // clEnqueueAcquireGLObjects, and recommends calling glFinish() as the only portable way to do that.
            // However no issues have been observed from not calling it, and so will leave disabled for now.
            // gl.glFinish();
            openCLManager.compute(
                unorderedModels, smallModels, largeModels,
                sceneVertexBuffer, sceneUvBuffer,
                tmpVertexBuffer, tmpUvBuffer,
                tmpModelBufferUnordered, tmpModelBufferSmall, tmpModelBufferLarge,
                tmpOutBuffer, tmpOutUvBuffer,
                uniformBuffer,
                tmpOutNormalBuffer, sceneNormalBuffer, tmpNormalBuffer
            )
            return
        }

        /*
		 * Compute is split into three separate programs: 'unordered', 'small', and 'large'
		 * to save on GPU resources. Small will sort <= 512 faces, large will do <= 4096.
		 */

        // Bind UBO to compute programs
        gl!!.glUniformBlockBinding(glSmallComputeProgram, uniBlockSmall, 0)
        gl!!.glUniformBlockBinding(glComputeProgram, uniBlockLarge, 0)

        // unordered
        gl!!.glUseProgram(glUnorderedComputeProgram)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 0, tmpModelBufferUnordered.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 1, sceneVertexBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 2, tmpVertexBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 3, tmpOutBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 4, tmpOutUvBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 5, sceneUvBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 6, tmpUvBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 7, tmpOutNormalBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 8, sceneNormalBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 9, tmpNormalBuffer.glBufferId)
        gl!!.glDispatchCompute(unorderedModels, 1, 1)

        // small
        gl!!.glUseProgram(glSmallComputeProgram)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 0, tmpModelBufferSmall.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 1, sceneVertexBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 2, tmpVertexBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 3, tmpOutBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 4, tmpOutUvBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 5, sceneUvBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 6, tmpUvBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 7, tmpOutNormalBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 8, sceneNormalBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 9, tmpNormalBuffer.glBufferId)
        gl!!.glDispatchCompute(smallModels, 1, 1)

        // large
        gl!!.glUseProgram(glComputeProgram)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 0, tmpModelBufferLarge.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 1, sceneVertexBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 2, tmpVertexBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 3, tmpOutBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 4, tmpOutUvBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 5, sceneUvBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 6, tmpUvBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 7, tmpOutNormalBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 8, sceneNormalBuffer.glBufferId)
        gl!!.glBindBufferBase(GL3ES3.GL_SHADER_STORAGE_BUFFER, 9, tmpNormalBuffer.glBufferId)
        gl!!.glDispatchCompute(largeModels, 1, 1)
    }

    override fun drawScenePaint(
        orientation: Int, pitchSin: Int, pitchCos: Int, yawSin: Int, yawCos: Int, x: Int, y: Int, z: Int,
        paint: SceneTilePaint, tileZ: Int, tileX: Int, tileY: Int,
        zoom: Int, centerX: Int, centerY: Int
    ) {
        if (paint.bufferLen > 0) {
            val localX = tileX * Perspective.LOCAL_TILE_SIZE
            val localY = 0
            val localZ = tileY * Perspective.LOCAL_TILE_SIZE
            val b = modelBufferUnordered!!
            b.ensureCapacity(16)
            val buffer = b.buffer
            var bufferLength = paint.bufferLen

            // we packed a boolean into the buffer length of tiles so we can tell
            // which tiles have procedurally-generated underwater terrain.
            // unpack the boolean:
            val underwaterTerrain = bufferLength and 1 == 1
            // restore the bufferLength variable:
            bufferLength = bufferLength shr 1
            if (underwaterTerrain) {
                // draw underwater terrain tile before surface tile

                // buffer length includes the generated underwater terrain, so it must be halved
                bufferLength /= 2
                ++unorderedModels
                buffer.put(paint.bufferOffset + bufferLength)
                buffer.put(paint.uvBufferOffset + bufferLength)
                buffer.put(bufferLength / 3)
                buffer.put(targetBufferOffset)
                buffer.put(FLAG_SCENE_BUFFER)
                buffer.put(localX).put(localY).put(localZ)
                targetBufferOffset += bufferLength
            }
            ++unorderedModels
            buffer.put(paint.bufferOffset)
            buffer.put(paint.uvBufferOffset)
            buffer.put(bufferLength / 3)
            buffer.put(targetBufferOffset)
            buffer.put(FLAG_SCENE_BUFFER)
            buffer.put(localX).put(localY).put(localZ)
            targetBufferOffset += bufferLength
        }
    }

    override fun drawSceneModel(
        orientation: Int, pitchSin: Int, pitchCos: Int, yawSin: Int, yawCos: Int, x: Int, y: Int, z: Int,
        model: SceneTileModel, tileZ: Int, tileX: Int, tileY: Int,
        zoom: Int, centerX: Int, centerY: Int
    ) {
        if (model.bufferLen > 0) {
            val localX = tileX * Perspective.LOCAL_TILE_SIZE
            val localY = 0
            val localZ = tileY * Perspective.LOCAL_TILE_SIZE
            val b = modelBufferUnordered!!
            b.ensureCapacity(16)
            val buffer = b.buffer
            var bufferLength = model.bufferLen

            // we packed a boolean into the buffer length of tiles so we can tell
            // which tiles have procedurally-generated underwater terrain.
            // unpack the boolean:
            val underwaterTerrain = bufferLength and 1 == 1
            // restore the bufferLength variable:
            bufferLength = bufferLength shr 1
            if (underwaterTerrain) {
                // draw underwater terrain tile before surface tile

                // buffer length includes the generated underwater terrain, so it must be halved
                bufferLength /= 2
                ++unorderedModels
                buffer.put(model.bufferOffset + bufferLength)
                buffer.put(model.uvBufferOffset + bufferLength)
                buffer.put(bufferLength / 3)
                buffer.put(targetBufferOffset)
                buffer.put(FLAG_SCENE_BUFFER)
                buffer.put(localX).put(localY).put(localZ)
                targetBufferOffset += bufferLength
            }
            ++unorderedModels
            buffer.put(model.bufferOffset)
            buffer.put(model.uvBufferOffset)
            buffer.put(bufferLength / 3)
            buffer.put(targetBufferOffset)
            buffer.put(FLAG_SCENE_BUFFER)
            buffer.put(localX).put(localY).put(localZ)
            targetBufferOffset += bufferLength
        }
    }

    override fun draw(overlayColor: Int) {
        invokeOnMainThread { drawFrame(overlayColor) }
    }

    private fun resize(canvasWidth: Int, canvasHeight: Int, viewportWidth: Int, viewportHeight: Int) {
        if (canvasWidth != lastCanvasWidth || canvasHeight != lastCanvasHeight) {
            lastCanvasWidth = canvasWidth
            lastCanvasHeight = canvasHeight
            gl!!.glBindTexture(GL.GL_TEXTURE_2D, interfaceTexture)
            gl!!.glTexImage2D(
                GL.GL_TEXTURE_2D,
                0,
                GL.GL_RGBA,
                canvasWidth,
                canvasHeight,
                0,
                GL.GL_BGRA,
                GL2GL3.GL_UNSIGNED_INT_8_8_8_8_REV,
                null
            )
            gl!!.glBindTexture(GL.GL_TEXTURE_2D, 0)
            if (Platform.getOSType() == Platform.OSType.MACOS && glDrawable is GLFBODrawable) {
                // GLDrawables created with createGLDrawable() do not have a resize listener
                // I don't know why this works with Windows/Linux, but on OSX
                // it prevents JOGL from resizing its FBOs and underlying GL textures. So,
                // we manually trigger a resize here.
                val glfboDrawable = glDrawable as GLFBODrawable
                glfboDrawable.resetSize(gl)
            }
        }
    }

    private fun getDrawDistance(): Int {
        val limit = MAX_DISTANCE
        return Ints.constrainToRange(config.drawDistance(), 0, limit)
    }

    private fun drawFrame(overlayColor: Int) {
        if (jawtWindow!!.awtComponent !== client.canvas) {
            // We inject code in the game engine mixin to prevent the client from doing canvas replacement,
            // so this should not ever be hit
            log.warn("Canvas invalidated!")
            onStop()
            onStart()
            return
        }
        if (client.gameState == GameState.LOADING || client.gameState == GameState.HOPPING) {
            return
        }
        camTarget = getCameraFocalPoint()

        // shader variables for water, lava animations
        animationCurrent += (System.currentTimeMillis() - lastFrameTime) / 1000f
        lastFrameTime = System.currentTimeMillis()
        val canvasHeight = client.canvasHeight
        val canvasWidth = client.canvasWidth
        val viewportHeight = client.viewportHeight
        val viewportWidth = client.viewportWidth
        resize(canvasWidth, canvasHeight, viewportWidth, viewportHeight)

        // Setup anti-aliasing
        val antiAliasingMode = config.antiAliasingMode()
        val aaEnabled = antiAliasingMode !== AntiAliasingMode.DISABLED
        if (aaEnabled) {
            gl!!.glEnable(GL.GL_MULTISAMPLE)
            val stretchedDimensions = client.stretchedDimensions
            val stretchedCanvasWidth = if (client.isStretchedEnabled) stretchedDimensions.width else canvasWidth
            val stretchedCanvasHeight = if (client.isStretchedEnabled) stretchedDimensions.height else canvasHeight

            // Re-create fbo
            if (lastStretchedCanvasWidth != stretchedCanvasWidth || lastStretchedCanvasHeight != stretchedCanvasHeight || lastAntiAliasingMode !== antiAliasingMode) {
                shutdownAAFbo()

                // Bind default FBO to check whether anti-aliasing is forced
                gl!!.glBindFramebuffer(GL.GL_FRAMEBUFFER, 0)
                val forcedAASamples = glGetInteger(gl!!, GL.GL_SAMPLES)
                val maxSamples = glGetInteger(gl!!, GL.GL_MAX_SAMPLES)
                val samples =
                    if (forcedAASamples != 0) forcedAASamples else Math.min(antiAliasingMode!!.samples, maxSamples)

                //log.debug("AA samples: {}, max samples: {}, forced samples: {}", samples, maxSamples, forcedAASamples);
                initAAFbo(stretchedCanvasWidth, stretchedCanvasHeight, samples)
                lastStretchedCanvasWidth = stretchedCanvasWidth
                lastStretchedCanvasHeight = stretchedCanvasHeight
            }
            gl!!.glBindFramebuffer(GL.GL_DRAW_FRAMEBUFFER, fboSceneHandle)
        } else {
            gl!!.glDisable(GL.GL_MULTISAMPLE)
            shutdownAAFbo()
        }
        gl!!.glClearColor(0f, 0f, 0f, 1f)
        gl!!.glClear(GL.GL_COLOR_BUFFER_BIT)

        // Draw 3d scene
        val textureProvider = client.textureProvider
        val gameState = client.gameState
        if (textureProvider != null) {
            if (textureArrayId == -1) {
                // lazy init textures as they may not be loaded at plugin start.
                // this will return -1 and retry if not all textures are loaded yet, too.
                textureArrayId = textureManager.initTextureArray(textureProvider, gl!!)
            }
            if (textureHDArrayId == -1) {
                textureHDArrayId = textureManager.initTextureHDArray(textureProvider, gl!!)
            }
            val textures = textureProvider.textures
            var renderHeightOff = client.viewportYOffset
            var renderWidthOff = client.viewportXOffset
            var renderCanvasHeight = canvasHeight
            var renderViewportHeight = viewportHeight
            var renderViewportWidth = viewportWidth

            // Setup anisotropic filtering
            val anisotropicFilteringLevel = config.anisotropicFilteringLevel()
            if (lastAnisotropicFilteringLevel != anisotropicFilteringLevel) {
                if (textureArrayId != -1) {
                    textureManager.setAnisotropicFilteringLevel(textureArrayId, anisotropicFilteringLevel, gl!!, false)
                }
                if (textureHDArrayId != -1) {
                    textureManager.setAnisotropicFilteringLevel(textureHDArrayId, anisotropicFilteringLevel, gl!!, true)
                }
                lastAnisotropicFilteringLevel = anisotropicFilteringLevel
            }
            if (client.isStretchedEnabled) {
                val dim = client.stretchedDimensions
                renderCanvasHeight = dim.height
                val scaleFactorY = dim.getHeight() / canvasHeight
                val scaleFactorX = dim.getWidth() / canvasWidth

                // Pad the viewport a little because having ints for our viewport dimensions can introduce off-by-one errors.
                val padding = 1

                // Ceil the sizes because even if the size is 599.1 we want to treat it as size 600 (i.e. render to the x=599 pixel).
                renderViewportHeight = Math.ceil(scaleFactorY * renderViewportHeight).toInt() + padding * 2
                renderViewportWidth = Math.ceil(scaleFactorX * renderViewportWidth).toInt() + padding * 2

                // Floor the offsets because even if the offset is 4.9, we want to render to the x=4 pixel anyway.
                renderHeightOff = Math.floor(scaleFactorY * renderHeightOff).toInt() - padding
                renderWidthOff = Math.floor(scaleFactorX * renderWidthOff).toInt() - padding
            }
            val vertexBuffer: Int
            val uvBuffer: Int
            val normalBuffer: Int

            // Before reading the SSBOs written to from postDrawScene() we must insert a barrier
            if (computeMode === ComputeMode.OPENCL) {
                openCLManager.finish()
            } else {
                gl!!.glMemoryBarrier(GL3ES3.GL_SHADER_STORAGE_BARRIER_BIT)
            }

            // Draw using the output buffer of the compute
            vertexBuffer = tmpOutBuffer.glBufferId
            uvBuffer = tmpOutUvBuffer.glBufferId
            normalBuffer = tmpOutNormalBuffer.glBufferId
            for (id in textures.indices) {
                val texture = textures[id] ?: continue
                textureProvider.load(id) // trips the texture load flag which lets textures animate
                textureOffsets[id * 2] = texture.u
                textureOffsets[id * 2 + 1] = texture.v
            }
            val lightProjectionMatrix = Matrix4()
            val lightPitch = -128f
            val lightYaw = 55f
            if (client.gameState == GameState.LOGGED_IN && configShadowsEnabled && fboShadowMap != -1 && environmentManager.currentDirectionalStrength > 0.0f) {
                // render shadow depth map
                gl!!.glViewport(0, 0, config.shadowResolution()!!.value, config.shadowResolution()!!.value)
                gl!!.glBindFramebuffer(GL.GL_FRAMEBUFFER, fboShadowMap)
                gl!!.glClear(GL.GL_DEPTH_BUFFER_BIT)
                gl!!.glUseProgram(glShadowProgram)
                val camX = camTarget[0]
                val camY = camTarget[1]
                val camZ = camTarget[2]
                val drawDistanceSceneUnits =
                    Math.min(config.shadowDistance()!!.value, getDrawDistance()) * Perspective.LOCAL_TILE_SIZE / 2
                val east = Math.min(camX + drawDistanceSceneUnits, Perspective.LOCAL_TILE_SIZE * Perspective.SCENE_SIZE)
                val west = Math.max(camX - drawDistanceSceneUnits, 0)
                val north =
                    Math.min(camY + drawDistanceSceneUnits, Perspective.LOCAL_TILE_SIZE * Perspective.SCENE_SIZE)
                val south = Math.max(camY - drawDistanceSceneUnits, 0)
                val width = east - west
                val height = north - south
                val near = -10000
                val far = 10000
                val maxDrawDistance = 90
                val maxScale = 0.7f
                val minScale = 0.4f
                val scaleMultiplier = 1.0f - getDrawDistance() / (maxDrawDistance * maxScale)
                val scale = lerp(maxScale, minScale, scaleMultiplier)
                lightProjectionMatrix.scale(scale, scale, scale)
                lightProjectionMatrix.makeOrtho(
                    -width / 2f,
                    width / 2f,
                    -height / 2f,
                    height / 2f,
                    near.toFloat(),
                    far.toFloat()
                )
                lightProjectionMatrix.rotate((lightPitch * (Math.PI / 360f * 2)).toFloat(), 1f, 0f, 0f)
                lightProjectionMatrix.rotate((lightYaw * (Math.PI / 360f * 2)).toFloat(), 0f, -1f, 0f)
                lightProjectionMatrix.translate(-(width / 2f + west), -camZ.toFloat(), -(height / 2f + south))
                gl!!.glUniformMatrix4fv(uniShadowLightProjectionMatrix, 1, false, lightProjectionMatrix.matrix, 0)

                // bind uniforms
                gl!!.glUniformBlockBinding(glShadowProgram, uniShadowBlockMaterials, 1)
                gl!!.glUniform1i(uniShadowTexturesHD, 2) // HD texture sampler array is bound to texture2
                gl!!.glUniform2fv(uniShadowTextureOffsets, textureOffsets.size, textureOffsets, 0)
                gl!!.glEnable(GL.GL_CULL_FACE)
                gl!!.glEnable(GL.GL_DEPTH_TEST)

                // Draw buffers
                gl!!.glBindVertexArray(vaoHandle)
                gl!!.glEnableVertexAttribArray(0)
                gl!!.glBindBuffer(GL.GL_ARRAY_BUFFER, vertexBuffer)
                gl!!.glVertexAttribIPointer(0, 4, GL2ES2.GL_INT, 0, 0)
                gl!!.glEnableVertexAttribArray(1)
                gl!!.glBindBuffer(GL.GL_ARRAY_BUFFER, uvBuffer)
                gl!!.glVertexAttribPointer(1, 4, GL.GL_FLOAT, false, 0, 0)
                gl!!.glDrawArrays(GL.GL_TRIANGLES, 0, targetBufferOffset)
                gl!!.glDisable(GL.GL_CULL_FACE)
                gl!!.glDisable(GL.GL_DEPTH_TEST)
                gl!!.glBindFramebuffer(GL.GL_FRAMEBUFFER, 0)
                gl!!.glUseProgram(0)
            }
            glDpiAwareViewport(
                renderWidthOff,
                renderCanvasHeight - renderViewportHeight - renderHeightOff,
                renderViewportWidth,
                renderViewportHeight
            )
            gl!!.glUseProgram(glProgram)
            if (texShadowMap != -1) {
                // bind shadow map
                gl!!.glActiveTexture(GL.GL_TEXTURE3)
                gl!!.glBindTexture(GL.GL_TEXTURE_2D, texShadowMap)
                gl!!.glActiveTexture(GL.GL_TEXTURE0)
            }
            if (aaEnabled) {
                gl!!.glEnable(GL.GL_MULTISAMPLE)
                val stretchedDimensions = client.stretchedDimensions
                val stretchedCanvasWidth = if (client.isStretchedEnabled) stretchedDimensions.width else canvasWidth
                val stretchedCanvasHeight = if (client.isStretchedEnabled) stretchedDimensions.height else canvasHeight

                // Re-create fbo
                if (lastStretchedCanvasWidth != stretchedCanvasWidth || lastStretchedCanvasHeight != stretchedCanvasHeight || lastAntiAliasingMode !== antiAliasingMode) {
                    shutdownAAFbo()
                    val maxSamples = glGetInteger(gl!!, GL.GL_MAX_SAMPLES)
                    val samples = Math.min(antiAliasingMode!!.samples, maxSamples)
                    initAAFbo(stretchedCanvasWidth, stretchedCanvasHeight, samples)
                    lastStretchedCanvasWidth = stretchedCanvasWidth
                    lastStretchedCanvasHeight = stretchedCanvasHeight
                }
                gl!!.glBindFramebuffer(GL.GL_DRAW_FRAMEBUFFER, fboSceneHandle)
            } else {
                gl!!.glDisable(GL.GL_MULTISAMPLE)
                shutdownAAFbo()
            }
            lastAntiAliasingMode = antiAliasingMode

            // Clear scene
            val sky = environmentManager.fogColor
            val fogColor =
                floatArrayOf((sky shr 16 and 0xFF) / 255f, (sky shr 8 and 0xFF) / 255f, (sky and 0xFF) / 255f)
            for (i in fogColor.indices) {
                fogColor[i] = linearToGamma(fogColor[i])
            }
            gl!!.glClearColor(fogColor[0], fogColor[1], fogColor[2], 1f)
            gl!!.glClear(GL.GL_COLOR_BUFFER_BIT)
            val drawDistance = getDrawDistance()
            var fogDepth = config.fogDepth()
            fogDepth *= 10
            if (config.fogDepthMode() === FogDepthMode.DYNAMIC) {
                fogDepth = environmentManager.currentFogDepth
            } else if (config.fogDepthMode() === FogDepthMode.NONE) {
                fogDepth = 0
            }
            gl!!.glUniform1i(uniUseFog, if (fogDepth > 0) 1 else 0)
            gl!!.glUniform1i(uniFogDepth, fogDepth)
            gl!!.glUniform4f(uniFogColor, fogColor[0], fogColor[1], fogColor[2], 1f)
            gl!!.glUniform1i(uniDrawDistance, drawDistance * Perspective.LOCAL_TILE_SIZE)
            gl!!.glUniform1i(uniColorBlindMode, config.colorBlindMode()!!.ordinal)
            val waterColor = environmentManager.currentWaterColor
            val waterColorHSB = Color.RGBtoHSB(
                (waterColor[0] * 255f).toInt(),
                (waterColor[1] * 255f).toInt(),
                (waterColor[2] * 255f).toInt(),
                null
            )
            val lightBrightnessMultiplier = 0.8f
            val midBrightnessMultiplier = 0.45f
            val darkBrightnessMultiplier = 0.05f
            val waterColorLight = Color(
                Color.HSBtoRGB(
                    waterColorHSB[0],
                    waterColorHSB[1],
                    waterColorHSB[2] * lightBrightnessMultiplier
                )
            ).getRGBColorComponents(null)
            val waterColorMid = Color(
                Color.HSBtoRGB(
                    waterColorHSB[0],
                    waterColorHSB[1],
                    waterColorHSB[2] * midBrightnessMultiplier
                )
            ).getRGBColorComponents(null)
            val waterColorDark = Color(
                Color.HSBtoRGB(
                    waterColorHSB[0],
                    waterColorHSB[1],
                    waterColorHSB[2] * darkBrightnessMultiplier
                )
            ).getRGBColorComponents(null)
            for (i in waterColorLight.indices) {
                waterColorLight[i] = linearToGamma(waterColorLight[i])
            }
            for (i in waterColorMid.indices) {
                waterColorMid[i] = linearToGamma(waterColorMid[i])
            }
            for (i in waterColorDark.indices) {
                waterColorDark[i] = linearToGamma(waterColorDark[i])
            }
            gl!!.glUniform3f(uniWaterColorLight, waterColorLight[0], waterColorLight[1], waterColorLight[2])
            gl!!.glUniform3f(uniWaterColorMid, waterColorMid[0], waterColorMid[1], waterColorMid[2])
            gl!!.glUniform3f(uniWaterColorDark, waterColorDark[0], waterColorDark[1], waterColorDark[2])

            // get ambient light strength from either the config or the current area
            var ambientStrength = environmentManager.currentAmbientStrength
            ambientStrength *= (config.brightness().toDouble() / 20).toFloat()
            gl!!.glUniform1f(uniAmbientStrength, ambientStrength)

            // and ambient color
            val ambientColor = environmentManager.currentAmbientColor
            gl!!.glUniform3f(uniAmbientColor, ambientColor[0], ambientColor[1], ambientColor[2])

            // get light strength from either the config or the current area
            var lightStrength = environmentManager.currentDirectionalStrength
            lightStrength *= (config.brightness().toDouble() / 20).toFloat()
            gl!!.glUniform1f(uniLightStrength, lightStrength)

            // and light color
            val lightColor = environmentManager.currentDirectionalColor
            gl!!.glUniform3f(uniLightColor, lightColor[0], lightColor[1], lightColor[2])

            // get underglow light strength from the current area
            val underglowStrength = environmentManager.currentUnderglowStrength
            gl!!.glUniform1f(uniUnderglowStrength, underglowStrength)
            // and underglow color
            val underglowColor = environmentManager.currentUnderglowColor
            gl!!.glUniform3f(uniUnderglowColor, underglowColor[0], underglowColor[1], underglowColor[2])

            // get ground fog variables
            val groundFogStart = environmentManager.currentGroundFogStart
            gl!!.glUniform1f(uniGroundFogStart, groundFogStart)
            val groundFogEnd = environmentManager.currentGroundFogEnd
            gl!!.glUniform1f(uniGroundFogEnd, groundFogEnd)
            var groundFogOpacity = environmentManager.currentGroundFogOpacity
            groundFogOpacity = if (config.groundFog()) groundFogOpacity else 0f
            gl!!.glUniform1f(uniGroundFogOpacity, groundFogOpacity)

            // lightning
            gl!!.glUniform1f(uniLightningBrightness, environmentManager.lightningBrightness)
            gl!!.glUniform1i(
                uniPointLightsCount,
                if (config.maxDynamicLights()!!.value > 0) lightManager.visibleLightsCount else 0
            )
            gl!!.glUniform1i(uniWaterEffects, configWaterEffects.mode)
            gl!!.glUniform1f(uniSaturation, config.saturation()!!.amount)
            gl!!.glUniform1f(uniContrast, config.contrast()!!.amount)
            val lightPitchRadians = Math.toRadians(lightPitch.toDouble())
            val lightYawRadians = Math.toRadians(lightYaw.toDouble())
            val lightX = Math.cos(lightPitchRadians) * Math.sin(lightYawRadians)
            val lightY = Math.sin(lightPitchRadians)
            val lightZ = Math.cos(lightPitchRadians) * Math.cos(lightYawRadians)
            gl!!.glUniform1f(uniLightX, lightX.toFloat())
            gl!!.glUniform1f(uniLightY, lightY.toFloat())
            gl!!.glUniform1f(uniLightZ, lightZ.toFloat())

            // use a curve to calculate max bias value based on the density of the shadow map
            val shadowPixelsPerTile =
                config.shadowResolution()!!.value.toFloat() / config.shadowDistance()!!.value.toFloat()
            val maxBias = 26f * Math.pow(0.925, (0.4f * shadowPixelsPerTile + -10f).toDouble()).toFloat() + 13f
            gl!!.glUniform1f(uniShadowMaxBias, maxBias / 10000f)
            gl!!.glUniform1i(uniShadowsEnabled, if (configShadowsEnabled) 1 else 0)

            // Calculate projection matrix
            val projectionMatrix = Matrix4()
            projectionMatrix.scale(client.scale.toFloat(), client.scale.toFloat(), 1f)
            projectionMatrix.multMatrix(makeProjectionMatrix(viewportWidth.toFloat(), viewportHeight.toFloat(), 50f))
            projectionMatrix.rotate((Math.PI - pitch * Perspective.UNIT).toFloat(), -1f, 0f, 0f)
            projectionMatrix.rotate((yaw * Perspective.UNIT).toFloat(), 0f, 1f, 0f)
            projectionMatrix.translate(
                -client.cameraX2.toFloat(),
                -client.cameraY2.toFloat(),
                -client.cameraZ2.toFloat()
            )
            gl!!.glUniformMatrix4fv(uniProjectionMatrix, 1, false, projectionMatrix.matrix, 0)

            // Bind directional light projection matrix
            gl!!.glUniformMatrix4fv(uniLightProjectionMatrix, 1, false, lightProjectionMatrix.matrix, 0)

            // Bind uniforms
            gl!!.glUniformBlockBinding(glProgram, uniBlockMain, 0)
            gl!!.glUniformBlockBinding(glProgram, uniBlockMaterials, 1)
            gl!!.glUniformBlockBinding(glProgram, uniBlockPointLights, 2)
            gl!!.glUniform2fv(uniTextureOffsets, 128, textureOffsets, 0)
            gl!!.glUniform1f(uniAnimationCurrent, animationCurrent)

            // We just allow the GL to do face culling. Note this requires the priority renderer
            // to have logic to disregard culled faces in the priority depth testing.
            gl!!.glEnable(GL.GL_CULL_FACE)
            gl!!.glCullFace(GL.GL_BACK)

            // Enable blending for alpha
            gl!!.glEnable(GL.GL_BLEND)
            gl!!.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA)

            // Draw buffers
            gl!!.glBindVertexArray(vaoHandle)
            gl!!.glEnableVertexAttribArray(0)
            gl!!.glBindBuffer(GL.GL_ARRAY_BUFFER, vertexBuffer)
            gl!!.glVertexAttribIPointer(0, 4, GL2ES2.GL_INT, 0, 0)
            gl!!.glEnableVertexAttribArray(1)
            gl!!.glBindBuffer(GL.GL_ARRAY_BUFFER, uvBuffer)
            gl!!.glVertexAttribPointer(1, 4, GL.GL_FLOAT, false, 0, 0)
            gl!!.glEnableVertexAttribArray(2)
            gl!!.glBindBuffer(GL.GL_ARRAY_BUFFER, normalBuffer)
            gl!!.glVertexAttribPointer(2, 4, GL.GL_FLOAT, false, 0, 0)
            gl!!.glDrawArrays(GL.GL_TRIANGLES, 0, targetBufferOffset)
            gl!!.glDisable(GL.GL_BLEND)
            gl!!.glDisable(GL.GL_CULL_FACE)
            gl!!.glUseProgram(0)
        }
        if (aaEnabled) {
            gl!!.glBindFramebuffer(GL.GL_READ_FRAMEBUFFER, fboSceneHandle)
            gl!!.glBindFramebuffer(GL.GL_DRAW_FRAMEBUFFER, 0)
            gl!!.glBlitFramebuffer(
                0, 0, lastStretchedCanvasWidth, lastStretchedCanvasHeight,
                0, 0, lastStretchedCanvasWidth, lastStretchedCanvasHeight,
                GL.GL_COLOR_BUFFER_BIT, GL.GL_NEAREST
            )

            // Reset
            gl!!.glBindFramebuffer(GL.GL_READ_FRAMEBUFFER, 0)
        }
        vertexBuffer!!.clear()
        uvBuffer!!.clear()
        normalBuffer!!.clear()
        modelBuffer!!.clear()
        modelBufferSmall!!.clear()
        modelBufferUnordered!!.clear()
        targetBufferOffset = 0
        unorderedModels = 0
        largeModels = unorderedModels
        smallModels = largeModels
        tempOffset = 0
        tempUvOffset = 0

        // Texture on UI
        drawUi(overlayColor, canvasHeight, canvasWidth)
        try {
            glDrawable!!.swapBuffers()
        } catch (e: Exception) {
            onStop()
            return
        }
        drawManager.processDrawComplete { this.screenshot() }
    }

    private fun glDpiAwareViewport(x: Int, y: Int, width: Int, height: Int) {
        if (Platform.getOSType() == Platform.OSType.MACOS) {
            // JOGL seems to handle DPI scaling for us already
            gl!!.glViewport(x, y, width, height)
        } else {
            val graphics = canvas!!.graphics as Graphics2D
            val t = graphics.transform
            gl!!.glViewport(
                getScaledValue(t.scaleX, x),
                getScaledValue(t.scaleY, y),
                getScaledValue(t.scaleX, width),
                getScaledValue(t.scaleY, height)
            )
            graphics.dispose()
        }
    }

    private fun getScaledValue(scale: Double, value: Int): Int {
        return SurfaceScaleUtils.scale(value, scale.toFloat())
    }

    private fun drawUi(overlayColor: Int, canvasHeight: Int, canvasWidth: Int) {
        val bufferProvider = client.bufferProvider
        val pixels = bufferProvider.pixels
        val width = bufferProvider.width
        val height = bufferProvider.height
        gl!!.glEnable(GL.GL_BLEND)
        vertexBuffer!!.clear() // reuse vertex buffer for interface
        vertexBuffer!!.ensureCapacity(pixels.size)
        val interfaceBuffer = vertexBuffer!!.buffer
        interfaceBuffer.put(pixels)
        vertexBuffer!!.flip()
        gl!!.glBlendFunc(GL.GL_ONE, GL.GL_ONE_MINUS_SRC_ALPHA)
        gl!!.glBindTexture(GL.GL_TEXTURE_2D, interfaceTexture)
        gl!!.glTexSubImage2D(
            GL.GL_TEXTURE_2D,
            0,
            0,
            0,
            width,
            height,
            GL.GL_BGRA,
            GL2GL3.GL_UNSIGNED_INT_8_8_8_8_REV,
            interfaceBuffer
        )

        // Use the texture bound in the first pass
        val uiScalingMode = config.uiScalingMode()
        gl!!.glUseProgram(glUiProgram)
        gl!!.glUniform1i(uniTex, 0)
        gl!!.glUniform1i(uniTexSamplingMode, uiScalingMode!!.mode)
        gl!!.glUniform2i(uniTexSourceDimensions, canvasWidth, canvasHeight)
        gl!!.glUniform1i(uniUiColorBlindMode, config.colorBlindMode()!!.ordinal)
        gl!!.glUniform4f(
            uniUiAlphaOverlay,
            (overlayColor shr 16 and 0xFF) / 255f,
            (overlayColor shr 8 and 0xFF) / 255f,
            (overlayColor and 0xFF) / 255f,
            (overlayColor ushr 24) / 255f
        )
        if (client.isStretchedEnabled) {
            val dim = client.stretchedDimensions
            glDpiAwareViewport(0, 0, dim.width, dim.height)
            gl!!.glUniform2i(uniTexTargetDimensions, dim.width, dim.height)
        } else {
            glDpiAwareViewport(0, 0, canvasWidth, canvasHeight)
            gl!!.glUniform2i(uniTexTargetDimensions, canvasWidth, canvasHeight)
        }

        // Set the sampling function used when stretching the UI.
        // This is probably better done with sampler objects instead of texture parameters, but this is easier and likely more portable.
        // See https://www.khronos.org/opengl/wiki/Sampler_Object for details.
        if (client.isStretchedEnabled) {
            // GL_NEAREST makes sampling for bicubic/xBR simpler, so it should be used whenever linear isn't
            val function = if (uiScalingMode === UIScalingMode.LINEAR) GL.GL_LINEAR else GL.GL_NEAREST
            gl!!.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, function)
            gl!!.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, function)
        }

        // Texture on UI
        gl!!.glBindVertexArray(vaoUiHandle)
        gl!!.glDrawArrays(GL.GL_TRIANGLE_FAN, 0, 4)

        // Reset
        gl!!.glBindTexture(GL.GL_TEXTURE_2D, 0)
        gl!!.glBindVertexArray(0)
        gl!!.glUseProgram(0)
        gl!!.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA)
        gl!!.glDisable(GL.GL_BLEND)
        vertexBuffer!!.clear()
    }

    /**
     * Convert the front framebuffer to an Image
     *
     * @return
     */
    private fun screenshot(): Image {
        var width = client.canvasWidth
        var height = client.canvasHeight
        if (client.isStretchedEnabled) {
            val dim = client.stretchedDimensions
            width = dim.width
            height = dim.height
        }
        if (Platform.getOSType() != Platform.OSType.MACOS) {
            val graphics = canvas!!.graphics as Graphics2D
            val t = graphics.transform
            width = getScaledValue(t.scaleX, width)
            height = getScaledValue(t.scaleY, height)
            graphics.dispose()
        }
        val buffer = ByteBuffer.allocateDirect(width * height * 4)
            .order(ByteOrder.nativeOrder())
        gl!!.glReadBuffer(GL.GL_FRONT)
        gl!!.glReadPixels(0, 0, width, height, GL.GL_RGBA, GL.GL_UNSIGNED_BYTE, buffer)
        val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
        val pixels = (image.raster.dataBuffer as DataBufferInt).data
        for (y in 0 until height) {
            for (x in 0 until width) {
                val r: Int = buffer.get().toInt() and 0xff
                val g: Int = buffer.get().toInt() and 0xff
                val b: Int = buffer.get().toInt() and 0xff
                buffer.get() // alpha
                pixels[(height - y - 1) * width + x] = r shl 16 or (g shl 8) or b
            }
        }
        return image
    }

    private fun makeProjectionMatrix(w: Float, h: Float, n: Float): FloatArray {
        return floatArrayOf(
            2 / w, 0f, 0f, 0f, 0f, 2 / h, 0f, 0f, 0f, 0f, -1f, -1f, 0f, 0f, -2 * n, 0f
        )
    }

    fun getCameraFocalPoint(): IntArray {
        val camX = client.oculusOrbFocalPointX
        val camY = client.oculusOrbFocalPointY
        // approximate the Z position of the point the camera is aimed at.
        // the difference in height between the camera at lowest and highest pitch
        val camPitch = client.cameraPitch
        val minCamPitch = 128
        val maxCamPitch = 512
        val camPitchDiff = maxCamPitch - minCamPitch
        val camHeight = (camPitch - minCamPitch) / camPitchDiff.toFloat()
        val camHeightDiff = 2200
        val camZ = (client.`cameraZ$api` + camHeight * camHeightDiff).toInt()
        return intArrayOf(camX, camY, camZ)
    }

    private fun uploadScene() {
        vertexBuffer!!.clear()
        uvBuffer!!.clear()
        normalBuffer!!.clear()
        generateHDSceneData()
        sceneUploader.upload(client.scene, vertexBuffer!!, uvBuffer!!, normalBuffer!!)
        vertexBuffer!!.flip()
        uvBuffer!!.flip()
        normalBuffer!!.flip()
        val vertexBuffer = vertexBuffer!!.buffer
        val uvBuffer = uvBuffer!!.buffer
        val normalBuffer = normalBuffer!!.buffer
        updateBuffer(
            sceneVertexBuffer,
            GL.GL_ARRAY_BUFFER,
            vertexBuffer.limit() * Integer.BYTES,
            vertexBuffer,
            GL2ES3.GL_STATIC_COPY,
            CL.CL_MEM_READ_ONLY
        )
        updateBuffer(
            sceneUvBuffer,
            GL.GL_ARRAY_BUFFER,
            uvBuffer.limit() * java.lang.Float.BYTES,
            uvBuffer,
            GL2ES3.GL_STATIC_COPY,
            CL.CL_MEM_READ_ONLY
        )
        updateBuffer(
            sceneNormalBuffer,
            GL.GL_ARRAY_BUFFER,
            normalBuffer.limit() * java.lang.Float.BYTES,
            normalBuffer,
            GL2ES3.GL_STATIC_COPY,
            CL.CL_MEM_READ_ONLY
        )
        gl!!.glBindBuffer(GL.GL_ARRAY_BUFFER, 0)
        vertexBuffer.clear()
        uvBuffer.clear()
        normalBuffer.clear()
    }

    fun generateHDSceneData() {
        environmentManager.loadSceneEnvironments()
        lightManager.loadSceneLights()
        val procGenTimer = System.currentTimeMillis()
        val timerCalculateTerrainNormals: Long
        val timerGenerateTerrainData: Long
        val timerGenerateUnderwaterTerrain: Long
        var startTime = System.currentTimeMillis()
        proceduralGenerator.generateUnderwaterTerrain(client.scene)
        timerGenerateUnderwaterTerrain = (System.currentTimeMillis() - startTime).toInt().toLong()
        startTime = System.currentTimeMillis()
        proceduralGenerator.calculateTerrainNormals(client.scene)
        timerCalculateTerrainNormals = (System.currentTimeMillis() - startTime).toInt().toLong()
        startTime = System.currentTimeMillis()
        proceduralGenerator.generateTerrainData(client.scene)
        timerGenerateTerrainData = (System.currentTimeMillis() - startTime).toInt().toLong()

        //log.error("procedural data generation took {}ms to complete", (System.currentTimeMillis() - procGenTimer));
        //log.error("-- calculateTerrainNormals: {}ms", timerCalculateTerrainNormals);
        //log.error("-- generateTerrainData: {}ms", timerGenerateTerrainData);
        //log.error("-- generateUnderwaterTerrain: {}ms", timerGenerateUnderwaterTerrain);
    }

    fun glGetInteger(gl: GL4, pname: Int): Int {
        val tmpbf = IntArray(1)
        gl.glGetIntegerv(pname, tmpbf, 0)
        return tmpbf[0]
    }

    override fun draw(
        renderable: Renderable,
        orientation: Int,
        pitchSin: Int,
        pitchCos: Int,
        yawSin: Int,
        yawCos: Int,
        x: Int,
        y: Int,
        z: Int,
        hash: Long
    ) {
        val camX = camTarget[0]
        val camY = camTarget[1]
        val camZ = camTarget[2]
        val adjustedX = x + client.`cameraX$api`
        val adjustedY = z + client.`cameraY$api`
        val adjustedZ = y + client.`cameraZ$api`
        var distance = 0.0
        if (configLevelOfDetail !== LevelOfDetail.FULL) {
            distance = Math.sqrt(
                Math.pow((camX - adjustedX).toDouble(), 2.0) + Math.pow(
                    (camY - adjustedY).toDouble(),
                    2.0
                ) + Math.pow((camZ - adjustedZ).toDouble(), 2.0)
            )
        }
        val drawObjectCutoff = configLevelOfDetail.distance * Perspective.LOCAL_TILE_SIZE

        // Model may be in the scene buffer
        if (renderable is Model && renderable.sceneId == sceneUploader.sceneId) {
            val model = renderable
            model.`calculateBoundsCylinder$api`()
            if (!isVisible(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash)) {
                return
            }
            if (model.bufferOffset and 3 == 1 && distance > drawObjectCutoff || model.bufferOffset and 3 == 3) {
                return
            }
            model.calculateExtreme(orientation)
            client.checkClickbox(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash)
            val tc = Math.min(MAX_TRIANGLE, model.trianglesCount)
            val uvOffset = model.uvBufferOffset
            val b: GpuIntBuffer = bufferForTriangles(tc)
            b.ensureCapacity(8)
            val buffer = b.buffer
            // shift the bufferoffset as the last bit is used for the level of detail setting
            buffer.put(model.bufferOffset shr 2)
            buffer.put(uvOffset)
            buffer.put(tc)
            buffer.put(targetBufferOffset)
            buffer.put(FLAG_SCENE_BUFFER or (model.radius shl 12) or orientation)
            buffer.put(x + client.cameraX2).put(y + client.cameraY2).put(z + client.cameraZ2)
            targetBufferOffset += tc * 3
        } else {
            // Temporary model (animated or otherwise not a static Model on the scene)
            val model = if (renderable is Model) renderable else renderable.`model$api`
            if (model != null) {
                // Apply height to renderable from the model
                if (model !== renderable) {
                    renderable.modelHeight = model.modelHeight
                }
                model.`calculateBoundsCylinder$api`()
                if (!isVisible(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash)) {
                    return
                }
                if (model.bufferOffset and 3 == 1 && distance > drawObjectCutoff || model.bufferOffset and 3 == 3) {
                    return
                }
                model.calculateExtreme(orientation)
                client.checkClickbox(model, orientation, pitchSin, pitchCos, yawSin, yawCos, x, y, z, hash)
                val faceCount = Math.min(MAX_TRIANGLE, model.trianglesCount)
                vertexBuffer!!.ensureCapacity(12 * faceCount)
                uvBuffer!!.ensureCapacity(12 * faceCount)
                normalBuffer!!.ensureCapacity(12 * faceCount)
                var vertexLength = 0
                var uvLength = 0
                var bufferLengths: IntArray
                for (face in 0 until faceCount) {
                    bufferLengths = sceneUploader.pushFace(
                        model, face,
                        vertexBuffer!!, uvBuffer!!, normalBuffer!!, 0, 0, 0, ObjectProperties.NONE, ObjectType.NONE
                    )
                    vertexLength += bufferLengths[0]
                    uvLength += bufferLengths[1]
                }
                val b: GpuIntBuffer = bufferForTriangles(faceCount)
                b.ensureCapacity(8)
                val buffer = b.buffer
                buffer.put(tempOffset)
                buffer.put(if (uvLength > 0) tempUvOffset else -1)
                buffer.put(vertexLength / 3)
                buffer.put(targetBufferOffset)
                buffer.put(model.radius shl 12 or orientation)
                buffer.put(x + client.cameraX2).put(y + client.cameraY2).put(z + client.cameraZ2)
                tempOffset += vertexLength
                tempUvOffset += uvLength
                targetBufferOffset += vertexLength
            }
        }
    }

    private fun bufferForTriangles(triangles: Int): GpuIntBuffer {
        return if (triangles <= SMALL_TRIANGLE_COUNT) {
            ++smallModels
            modelBufferSmall!!
        } else {
            ++largeModels
            modelBuffer!!
        }
    }

    private fun isVisible(
        model: Model,
        orientation: Int,
        pitchSin: Int,
        pitchCos: Int,
        yawSin: Int,
        yawCos: Int,
        _x: Int,
        _y: Int,
        _z: Int,
        hash: Long
    ): Boolean {
        val XYZMag = model.xyzMag
        var zoom = client.get3dZoom()
        if (configShadowsEnabled && configExpandShadowDraw) {
            zoom /= 2
        }
        val modelHeight = model.modelHeight
        val Rasterizer3D_clipMidX2 = client.rasterizer3D_clipMidX2
        val Rasterizer3D_clipNegativeMidX = client.rasterizer3D_clipNegativeMidX
        val Rasterizer3D_clipNegativeMidY = client.rasterizer3D_clipNegativeMidY
        val Rasterizer3D_clipMidY2 = client.rasterizer3D_clipMidY2
        val var11 = yawCos * _z - yawSin * _x shr 16
        val var12 = pitchSin * _y + pitchCos * var11 shr 16
        val var13 = pitchCos * XYZMag shr 16
        val var14 = var12 + var13
        if (var14 > 50) {
            val var15 = _z * yawSin + yawCos * _x shr 16
            val var16 = (var15 - XYZMag) * zoom
            if (var16 / var14 < Rasterizer3D_clipMidX2) {
                val var17 = (var15 + XYZMag) * zoom
                if (var17 / var14 > Rasterizer3D_clipNegativeMidX) {
                    val var18 = pitchCos * _y - var11 * pitchSin shr 16
                    val var19 = pitchSin * XYZMag shr 16
                    val var20 = (var18 + var19) * zoom
                    if (var20 / var14 > Rasterizer3D_clipNegativeMidY) {
                        val var21 = (pitchCos * modelHeight shr 16) + var19
                        val var22 = (var18 - var21) * zoom
                        return var22 / var14 < Rasterizer3D_clipMidY2
                    }
                }
            }
        }
        return false
    }

    override fun drawFace(model: Model?, face: Int): Boolean {
        return false
    }

    override fun animate(texture: Texture?, diff: Int) {
        textureManager.animate(texture!!, diff)
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.new != GameState.LOGGED_IN) {
            lightManager.reset()
        }
        if (it.new == GameState.LOGGED_IN) {
            invokeOnMainThread { uploadScene() }
        }
    }

    override fun onProjectileMoved(): ((Event<ProjectileMoved>) -> Unit) = {
        lightManager.addProjectileLight(it.data.projectile)
    }

    override fun onNPCSpawned(): ((Event<NpcSpawned>) -> Unit) = {
        lightManager.addNpcLight(it.data.npc)
    }

    override fun onNPCDespawned(): ((Event<NpcDespawned>) -> Unit) = {
        lightManager.removeNpcLight(it.data)
    }

    override fun onNpcChanged(): ((Event<NpcChanged>) -> Unit) = {
        lightManager.updateNpcChanged(it.data)
    }

    override fun onGameObjectSpawned(): ((Event<GameObjectSpawned>) -> Unit) = {
        val it = it.data
        val gameObject: GameObject = it.gameObject
        lightManager.addObjectLight(
            gameObject,
            it.tile.renderLevel,
            gameObject.sizeX(),
            gameObject.sizeY(),
            gameObject.orientation.angle
        )
    }

    override fun onGameObjectChanged(): ((Event<GameObjectChanged>) -> Unit) = {
        val it = it.data
        val previous: GameObject = it.oldObject
        val gameObject: GameObject = it.newObject
        lightManager.removeObjectLight(previous)
        lightManager.addObjectLight(
            gameObject,
            it.tile.renderLevel,
            gameObject.sizeX(),
            gameObject.sizeY(),
            gameObject.orientation.angle
        )
    }

    override fun onGameObjectDespawned(): ((Event<GameObjectDespawned>) -> Unit) = {
        val gameObject: GameObject = it.data.gameObject
        lightManager.removeObjectLight(gameObject)
    }

    override fun onWallObjectSpawned(): ((Event<WallObjectSpawned>) -> Unit) = {
        val wallObject: WallObject = it.data.wallObject
        lightManager.addObjectLight(wallObject, it.data.tile.renderLevel, 1, 1, wallObject.orientationA)

    }

    override fun onWallObjectChanged(): ((Event<WallObjectChanged>) -> Unit) = {
        val it = it.data
        val previous: WallObject = it.previous
        val wallObject: WallObject = it.wallObject
        lightManager.removeObjectLight(previous)
        lightManager.addObjectLight(wallObject, it.tile.renderLevel, 1, 1, wallObject.orientationA)

    }

    override fun onWallObjectDespawned(): ((Event<WallObjectDespawned>) -> Unit) = {
        val wallObject: WallObject = it.data.wallObject
        lightManager.removeObjectLight(wallObject)
    }

    override fun onDecorativeObjectSpawned(): ((Event<DecorativeObjectSpawned>) -> Unit) = {
        val decorativeObject: DecorativeObject = it.data.decorativeObject
        lightManager.addObjectLight(decorativeObject, it.data.tile.renderLevel)
    }

    override fun onDecorativeObjectChanged(): ((Event<DecorativeObjectChanged>) -> Unit) = {
        val it = it.data
        val previous: DecorativeObject = it.previous
        val decorativeObject: DecorativeObject = it.decorativeObject
        lightManager.removeObjectLight(previous)
        lightManager.addObjectLight(decorativeObject, it.tile.getRenderLevel())
    }

    override fun onDecorativeObjectDespawned(): ((Event<DecorativeObjectDespawned>) -> Unit) = {
        val decorativeObject: DecorativeObject = it.data.decorativeObject
        lightManager.removeObjectLight(decorativeObject)
    }

    override fun onGroundObjectSpawned(): ((Event<GroundObjectSpawned>) -> Unit) = {
        val groundObject: GroundObject = it.data.groundObject
        lightManager.addObjectLight(groundObject, it.data.tile.renderLevel)
    }

    override fun onGroundObjectChanged(): ((Event<GroundObjectChanged>) -> Unit) = {
        val it = it.data
        val previous: GroundObject = it.previous
        val groundObject: GroundObject = it.groundObject
        lightManager.removeObjectLight(previous)
        lightManager.addObjectLight(groundObject, it.tile.renderLevel)
    }

    override fun onGroundObjectDespawned(): ((Event<GroundObjectDespawned>) -> Unit) = {
        val groundObject: GroundObject = it.data.groundObject
        lightManager.removeObjectLight(groundObject)
    }

    override fun onItemDespawned(): ((Event<ItemDespawned>) -> Unit) = {
        lightManager.removeGroundItemLight(it.data)
    }

    override fun onItemSpawned(): ((Event<ItemSpawned>) -> Unit) = {
        lightManager.addGroundItemLight(it.data)
    }

    private fun invokeOnMainThread(runnable: Runnable) {
        if (Platform.getOSType() == Platform.OSType.MACOS) {
            OSXUtil.RunOnMainThread(true, false, runnable)
        } else {
            runnable.run()
        }
    }
}