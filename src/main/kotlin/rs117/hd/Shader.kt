/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2020 Abex
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
import com.jogamp.opengl.GL2ES2
import com.jogamp.opengl.GL
import rs117.hd.template.Template
import java.util.ArrayList

class Shader {
    val units: MutableList<Unit> = ArrayList()
    class Unit(var type: Int, var filename: String?)

    fun add(type: Int, name: String?): Shader {
        units.add(Unit(type, name))
        return this
    }

    @Throws(ShaderException::class)
    fun compile(gl: GL4, template: Template): Int {
        val program = gl.glCreateProgram()
        val shaders = IntArray(units.size)
        var i = 0
        var ok = false
        try {
            while (i < shaders.size) {
                val unit = units[i]
                val shader = gl.glCreateShader(unit.type)
                if (shader == 0) {
                    throw ShaderException("Unable to create shader of type " + unit.type)
                }
                val source = template.load(unit.filename)
                gl.glShaderSource(shader, 1, arrayOf(source), null)
                gl.glCompileShader(shader)
                if (GLUtil.glGetShader(gl, shader, GL2ES2.GL_COMPILE_STATUS) != GL.GL_TRUE) {
                    val err = GLUtil.glGetShaderInfoLog(gl, shader)
                    gl.glDeleteShader(shader)
                    throw ShaderException(err)
                }
                gl.glAttachShader(program, shader)
                shaders[i++] = shader
            }
            gl.glLinkProgram(program)
            if (GLUtil.glGetProgram(gl, program, GL2ES2.GL_LINK_STATUS) == GL.GL_FALSE) {
                val err = GLUtil.glGetProgramInfoLog(gl, program)
                throw ShaderException(err)
            }
            ok = true
        } finally {
            while (i > 0) {
                val shader = shaders[--i]
                gl.glDetachShader(program, shader)
                gl.glDeleteShader(shader)
            }
            if (!ok) {
                gl.glDeleteProgram(program)
            }
        }
        return program
    }
}