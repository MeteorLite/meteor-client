/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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

import com.jogamp.opengl.GL4
import java.nio.charset.StandardCharsets

internal object GLUtil {
    private const val ERR_LEN = 1024
    private val buf = IntArray(1)
    private val fbuf = FloatArray(1)
    fun glGetInteger(gl: GL4, pname: Int): Int {
        gl.glGetIntegerv(pname, buf, 0)
        return buf[0]
    }

    @JvmStatic
    fun glGetFloat(gl: GL4, pname: Int): Float {
        gl.glGetFloatv(pname, fbuf, 0)
        return fbuf[0]
    }
    @JvmStatic
    fun glGetShader(gl: GL4, shader: Int, pname: Int): Int {
        gl.glGetShaderiv(shader, pname, buf, 0)
        assert(buf[0] > -1)
        return buf[0]
    }
    @JvmStatic
    fun glGetProgram(gl: GL4, program: Int, pname: Int): Int {
        gl.glGetProgramiv(program, pname, buf, 0)
        assert(buf[0] > -1)
        return buf[0]
    }
    @JvmStatic
    fun glGetShaderInfoLog(gl: GL4, shader: Int): String {
        val err = ByteArray(ERR_LEN)
        gl.glGetShaderInfoLog(shader, ERR_LEN, buf, 0, err, 0)
        return String(err, 0, buf[0], StandardCharsets.UTF_8)
    }
    @JvmStatic
    fun glGetProgramInfoLog(gl: GL4, program: Int): String {
        val err = ByteArray(ERR_LEN)
        gl.glGetProgramInfoLog(program, ERR_LEN, buf, 0, err, 0)
        return String(err, 0, buf[0], StandardCharsets.UTF_8)
    }
    @JvmStatic
    fun glGenVertexArrays(gl: GL4): Int {
        gl.glGenVertexArrays(1, buf, 0)
        return buf[0]
    }
    @JvmStatic
    fun glDeleteVertexArrays(gl: GL4, vertexArray: Int) {
        buf[0] = vertexArray
        gl.glDeleteVertexArrays(1, buf, 0)
    }
    @JvmStatic
    fun glGenBuffers(gl: GL4): Int {
        gl.glGenBuffers(1, buf, 0)
        return buf[0]
    }
    @JvmStatic
    fun glDeleteBuffer(gl: GL4, buffer: Int) {
        buf[0] = buffer
        gl.glDeleteBuffers(1, buf, 0)
    }
    @JvmStatic
    fun glGenTexture(gl: GL4): Int {
        gl.glGenTextures(1, buf, 0)
        return buf[0]
    }
    @JvmStatic
    fun glDeleteTexture(gl: GL4, texture: Int) {
        buf[0] = texture
        gl.glDeleteTextures(1, buf, 0)
    }
    @JvmStatic
    fun glGenFrameBuffer(gl: GL4): Int {
        gl.glGenFramebuffers(1, buf, 0)
        return buf[0]
    }
    @JvmStatic
    fun glDeleteFrameBuffer(gl: GL4, frameBuffer: Int) {
        buf[0] = frameBuffer
        gl.glDeleteFramebuffers(1, buf, 0)
    }
    @JvmStatic
    fun glGenRenderbuffer(gl: GL4): Int {
        gl.glGenRenderbuffers(1, buf, 0)
        return buf[0]
    }
    @JvmStatic
    fun glDeleteRenderbuffers(gl: GL4, renderBuffer: Int) {
        buf[0] = renderBuffer
        gl.glDeleteRenderbuffers(1, buf, 0)
    }
}