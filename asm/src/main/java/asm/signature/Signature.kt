/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package asm.signature

import asm.Type
import java.util.*
import java.util.regex.Pattern

class Signature {
    private val argument: MutableList<Type>

    var returnValue: Type

    constructor(arguments: List<Type>, rv: Type) {
        this.argument = ArrayList(arguments)
        returnValue = rv
    }

    constructor(str: String) {
        val rvStart = str.indexOf(')')
        require(rvStart != -1) { "Descriptor has no return value!" }
        returnValue = Type(str.substring(rvStart + 1))
        argument = findArgs(str, ArrayList(), str.indexOf('(') + 1, rvStart).toMutableList()
    }

    constructor(other: Signature) {
        argument = ArrayList(other.argument)
        returnValue = other.returnValue
    }

    override fun equals(other: Any?): Boolean {
        return if (other !is Signature) {
            false
        } else this.toString() == other.toString()
    }

    override fun hashCode(): Int {
        return this.toString().hashCode()
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append('(')
        for (a in argument) {
            sb.append(a)
        }
        sb.append(')')
        sb.append(returnValue)
        return sb.toString()
    }

    fun size(): Int {
        return argument.size
    }

    fun remove(i: Int) {
        argument.removeAt(i)
    }

    fun getTypeOfArg(i: Int): Type {
        return argument[i]
    }

    fun getArguments(): List<Type> {
        return Collections.unmodifiableList(argument)
    }

    val isVoid: Boolean
        get() = returnValue == Type.VOID

    class Builder {
        private val arguments: MutableList<Type> = ArrayList()
        lateinit var rv: Type
        fun setReturnType(type: Type): Builder {
            rv = type
            return this
        }

        fun addArgument(type: Type): Builder {
            arguments.add(type)
            return this
        }

        fun addArgument(idx: Int, type: Type): Builder {
            arguments.add(idx, type)
            return this
        }

        fun addArguments(types: Collection<Type>?): Builder {
            arguments.addAll(types!!)
            return this
        }

        fun build(): Signature {
            return Signature(arguments, rv)
        }
    }

    fun rsApiToRsClient(): Signature {
        return Signature(RLAPITORSAPI.matcher(this.toString()).replaceAll(""))
    }

    companion object {
        private val RLAPITORSAPI = Pattern.compile("net/runelite/(rs/)?api/(RS)?")
        private fun findArgs(str: String, ret: MutableList<Type>, from: Int, to: Int): List<Type> {
            if (from >= to) return ret
            var i = from
            while (str[i] == '[') ++i
            if (str[i] == 'L') i = str.indexOf(';', i)
            ret.add(Type(str.substring(from, ++i)))
            return findArgs(str, ret, i, to)
        }
    }
}
