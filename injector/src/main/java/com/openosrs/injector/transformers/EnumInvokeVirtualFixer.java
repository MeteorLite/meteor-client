/*
 * Copyright (c) 2020, ThatGamerBlue <thatgamerblue@gmail.com>
 * All rights reserved.
 *
 * This code is licensed under GPL3, see the complete license in
 * the LICENSE file in the root directory of this submodule.
 */
package com.openosrs.injector.transformers;

import com.openosrs.injector.injection.InjectData;

import net.runelite.asm.ClassFile;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;

import meteor.Logger;

public class EnumInvokeVirtualFixer extends InjectTransformer
{
	private int fixedEnums = 0;
	private Logger log = new Logger("Injector");
	public EnumInvokeVirtualFixer(InjectData inject)
	{
		super(inject);
	}

	@Override
	void transformImpl()
	{
		inject.forEachPair(this::fixEnumInvokeVirtuals);
		log.setName("Injector");
		log.debug("Fixed " + fixedEnums + " enums.");
	}

	private void fixEnumInvokeVirtuals(ClassFile rsc, ClassFile vanilla)
	{
		if (vanilla.isEnum()) {
			Method valuesMethod = vanilla.findMethod("values");
			if (valuesMethod != null) {
				for (Instruction insn : valuesMethod.getCode().getInstructions()) {
					if (insn instanceof InvokeVirtual) {
						InvokeVirtual invokeVirtual = (InvokeVirtual) insn;
						invokeVirtual.getMethod().getClazz().fixEnumDimensions();
						fixedEnums++;
					}
				}
			}
		}
	}
}