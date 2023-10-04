/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
 * All rights reserved.
 *
 * This code is licensed under GPL3, see the complete license in
 * the LICENSE file in the root directory of this submodule.
 *
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
package com.openosrs.injector.injectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.openosrs.injector.injection.InjectData;
import net.runelite.asm.ClassFile;
import net.runelite.deob.DeobAnnotations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/*
 * This handles creating "virtual" annotations to clean up rs-client in the main project
 */
public class CreateObfuscatedClassMap extends AbstractInjector
{
	public CreateObfuscatedClassMap(InjectData inject)
	{
		super(inject);
	}

	public void inject()
	{
		StringBuilder obfuscatedClassMapBuilder = new StringBuilder();
		obfuscatedClassMapBuilder.append(header());
		StringBuilder mappingsBuilder = new StringBuilder();
		for (final ClassFile deobClass : inject.getDeobfuscated())
		{
			deobClass.getAnnotations().forEach((type, annotation) -> {
				if (annotation.getType().equals(DeobAnnotations.OBFUSCATED_NAME)) {
					mappingsBuilder.append("		INSTANCE.put(\"" + deobClass.getName().replace("/", ".") + "\", \"" + annotation.getValueString() + "\");\n");
				}
			});
		}
		obfuscatedClassMapBuilder.append(mappingsBuilder).append(footer());
		try {
			save(obfuscatedClassMapBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String header() {
		return "package net.runelite.rs;\n" +
				"\n" +
				"import java.util.HashMap;\n" +
				"\n" +
				"public class ObfuscatedClassMap extends HashMap<String, String> {\n" +
				"    public static ObfuscatedClassMap INSTANCE = new ObfuscatedClassMap();\n" +
				"    static {\n";
	}

	public String footer() {
		return "    }\n" +
				"}";
	}

	public void save(String obfuscatedClassMap) throws IOException {
		String loc = "./osrs/src/main/java/net/runelite/rs/ObfuscatedClassMap.java";
		new File(loc).delete();
		try (PrintWriter output = new PrintWriter(loc)) {
			output.print(obfuscatedClassMap);
		}
	}
}
