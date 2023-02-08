/*
 * Copyright (c) 2020 ThatGamerBlue
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
package mixins;

import net.runelite.api.mixins.*;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSReflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Because we inject into the deob, we can hook into these reflection checks.
 * There is no evidence that Jagex actually uses any of these checks
 * Better safe than sorry I suppose though.
 * We only report method invocations by default.
 */
@Mixin(RSReflection.class)
public abstract class ReflectionMixin implements RSReflection
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	public static boolean reportClasses = false;

	@Inject
	public static boolean reportFields = false;

	@Copy("reportFindClass")
	@Replace("reportFindClass")
	public static void reportFindClass(String className) {
		if (reportClasses)
			client.getLogger().error("ReflectionLookup:Class - " + className);
	}

	@Copy("reportFindField")
	@Replace("reportFindField")
	public static void reportFindField(Class<?> clazz, String fieldName) {
		if (!reportFields)
			return;

		for (Field f : clazz.getDeclaredFields()) {
			for (Annotation a : f.getAnnotations()) {
				if (a instanceof ObfuscatedName) {
					String obfuscatedName = ((ObfuscatedName) a).value();
					if (obfuscatedName.equals(fieldName)) {
						client.getLogger().error("ReflectionLookup:Field - " + clazz.getName() + "." + f.getName());
					}
				}
			}
		}
	}

	@Copy("reportInvoke")
	@Replace("reportInvoke")
	public static void reportInvoke(Method method, Object reference, Object[] args) {
		String className = method.getClass().getName();
		int arg = 0;
		client.getLogger().error("Reflection:INVOKE - " + className + "." + method.getName());
		if (reference != null)
			client.getLogger().error("Reflection:INVOKE - reference - " + reference.getClass().getName());
		for (Object o : args) {
			client.getLogger().error("Reflection:INVOKE - arg" + arg + " - " + o.getClass().getName());
			if (o instanceof Integer)
				client.getLogger().error("Reflection:INVOKE - intValue" + arg + " - " + o);
			if (o instanceof String)
				client.getLogger().error("Reflection:INVOKE - strValue" + arg + " - " + o);
			if (o instanceof Long)
				client.getLogger().error("Reflection:INVOKE - longValue" + arg + " - " + o);
			if (o instanceof Byte)
				client.getLogger().error("Reflection:INVOKE - byteValue" + arg + " - " + o);
			if (o instanceof Boolean)
				client.getLogger().error("Reflection:INVOKE - boolValue" + arg + " - " + o);
			arg++;
		}
	}
}
