/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
 * All rights reserved.
 *
 * This code is licensed under GPL3, see the complete license in
 * the LICENSE file in the root directory of this submodule.
 */
package com.openosrs.injector.injection;

import com.openosrs.injector.InjectUtil;
import com.openosrs.injector.injectors.Injector;
import com.openosrs.injector.rsapi.RSApi;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.runelite.asm.ClassFile;
import net.runelite.asm.ClassGroup;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.Type;
import net.runelite.asm.signature.Signature;

/**
 * Abstract class meant as the interface of {@link com.openosrs.injector.Injector injection} for injectors
 */
@AllArgsConstructor
@NoArgsConstructor
public abstract class InjectData
{
	public static final String CALLBACKS = "net/runelite/api/hooks/Callbacks";

	@Getter
	public ClassGroup vanilla;

	public ClassGroup getVanilla() {
		return vanilla;
	}

	@Getter
	public ClassGroup deobfuscated;

	public ClassGroup getDeobfuscated() {
		return deobfuscated;
	}

	@Getter
	public ClassGroup mixins;

	public ClassGroup getMixins() {
		return mixins;
	}

	@Getter
	public RSApi rsApi;

	public RSApi getRsApi() {
		return rsApi;
	}

	/**
	 * Deobfuscated ClassFiles -> Vanilla ClassFiles
	 */
	public final Map<ClassFile, ClassFile> toVanilla = new HashMap<>();

	/**
	 * Strings -> Deobfuscated ClassFiles
	 * keys:
	 * - Obfuscated name
	 * - RSApi implementing name
	 */
	public final Map<String, ClassFile> toDeob = new HashMap<>();

	public abstract void runChildInjector(Injector injector);

	public void initToVanilla()
	{
		for (final ClassFile deobClass : deobfuscated)
		{

			final String obName = deobClass.getName();
			if (obName != null)
			{
				if (deobClass.getName().contains("mudclient")) {
					//System.out.println(deobClass.getName());
				}
				toDeob.put(obName, deobClass);

				final ClassFile obClass = this.vanilla.findClass(obName);

				if (obClass != null)
				{
					toVanilla.put(deobClass, obClass);
				}
			}
		}
	}

	/**
	 * Deobfuscated ClassFile -> Vanilla ClassFile
	 */
	public ClassFile toVanilla(ClassFile deobClass)
	{

		return toVanilla.get(deobClass);
	}

	/**
	 * Deobfuscated Method -> Vanilla Method
	 */
	public Method toVanilla(Method deobMeth)
	{
		final ClassFile obC = toVanilla(deobMeth.getClassFile());

		String name = deobMeth.getName();

		Signature sig = deobMeth.getDescriptor();
		if (sig == null)
		{
			sig = deobMeth.getDescriptor();
		}

		return obC.findMethod(name, sig);
	}

	/**
	 * Deobfuscated Field -> Vanilla Field
	 */
	public Field toVanilla(Field deobField)
	{
		final ClassFile obC = toVanilla(deobField.getClassFile());

		String name = deobField.getName();

		Type type = deobField.getType();

		Field f = obC.findField(name, type);

		if (f == null)
			throw new RuntimeException("couldn't find static field " + deobField.getClassFile() + "/" + deobField.getName());
		return f;
	}

	/**
	 * Vanilla ClassFile -> Deobfuscated ClassFile
	 */
	public ClassFile toDeob(String str)
	{
		return this.toDeob.get(str);
	}

	/**
	 * Adds a string mapping for a deobfuscated class
	 */
	public void addToDeob(String key, ClassFile value)
	{
		toDeob.put(key, value);
	}

	/**
	 * Do something with all paired classes.
	 * <p>
	 * Key = deobfuscated, Value = vanilla
	 */
	public void forEachPair(BiConsumer<ClassFile, ClassFile> action)
	{
		for (Map.Entry<ClassFile, ClassFile> pair : toVanilla.entrySet())
		{
			action.accept(pair.getKey(), pair.getValue());
		}
	}
}
