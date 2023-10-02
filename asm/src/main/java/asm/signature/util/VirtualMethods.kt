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
package asm.signature.util

import asm.ClassFile
import asm.Method
import asm.signature.Signature

object VirtualMethods {
    // find the base methods for a method. search goes up from there to see if two
    // different methods can be invoked with the same instruction.
    private fun findBaseMethods(
        methods: MutableList<Method>,
        cf: ClassFile?,
        name: String,
        type: Signature
    ): MutableList<Method> {
        if (cf == null) return methods
        val m = cf.findMethod(name, type)
        if (m != null && !m.isStatic) methods.add(m)
        val parentMethods = findBaseMethods(ArrayList(), cf.parent, name, type)
        for (inter in cf.interfaces.myInterfaces) parentMethods.addAll(findBaseMethods(ArrayList(), inter, name, type))

        // parentMethods take precedence over our methods
        return if (parentMethods.isEmpty()) methods else parentMethods
    }

    private fun findBaseMethods(method: Method): List<Method> {
        return findBaseMethods(ArrayList(), method.classFile, method.name, method.descriptor)
    }

    private fun findMethodUp(
        methods: MutableList<Method>,
        visited: MutableSet<ClassFile>,
        cf: ClassFile?,
        name: String,
        type: Signature
    ) {
        if (cf == null || visited.contains(cf)) return
        visited.add(cf) // can do diamond inheritance with interfaces
        val m = cf.findMethod(name, type)
        if (m != null && !m.isStatic) methods.add(m)
        for (child in cf.children) findMethodUp(methods, visited, child, name, type)
    }

    @JvmStatic
	fun getVirtualMethods(method: Method): List<Method> {
        val list: MutableList<Method> = ArrayList()
        if (method.isStatic) {
            list.add(method)
            return list
        }
        val bases = findBaseMethods(method) // base methods method overrides
        assert(
            bases.isNotEmpty() // must contain at least a method
        )

        // now search up from bases, appending to list.
        for (m in bases) findMethodUp(list, HashSet(), m.classFile, m.name, m.descriptor)
        return list
    }
}
