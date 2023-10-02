/*
 * Copyright (c) 2021, Owain van Brakel <https://github.com/Owain94>
 * All rights reserved.
 *
 * This code is licensed under GPL3, see the complete license in
 * the LICENSE file in the root directory of this submodule.
 */
package com.openosrs.injector.injectors.raw;

//import com.openosrs.injector.InjectUtil;
import com.openosrs.injector.InjectUtil;
import com.openosrs.injector.injection.InjectData;
import com.openosrs.injector.injectors.AbstractInjector;
import java.util.List;
import java.util.ListIterator;
import asm.ClassFile;
import asm.Field;
import asm.Method;
import asm.attributes.Code;
import asm.attributes.code.Instruction;
import asm.attributes.code.InstructionType;
import asm.attributes.code.Instructions;
import asm.attributes.code.instructions.BAStore;
import asm.attributes.code.instructions.Dup;
import asm.attributes.code.instructions.GetStatic;
import asm.attributes.code.instructions.ILoad;
import asm.attributes.code.instructions.InvokeSpecial;
import asm.attributes.code.instructions.InvokeStatic;
import asm.attributes.code.instructions.New;
import asm.attributes.code.instructions.Return;
import asm.signature.Signature;

public class RuneliteMenuEntry extends AbstractInjector
{
	private static final String RUNELITE_MENU_ENTRY = "RuneLiteMenuEntry";

	public RuneliteMenuEntry(InjectData inject)
	{
		super(inject);
	}

	public void inject()
	{
		addInvoke("newRuneliteMenuEntry", true);
		addInvoke("newBareRuneliteMenuEntry", false);
		addSwap(InjectUtil.findMethod(inject, "menu"), InjectUtil.findField(inject, "menuShiftClick", "Client"));
	}

	private void addInvoke(String methodName, boolean iload)
	{
		ClassFile runeliteMenuEntryVanilla = inject.vanilla.findClass(RUNELITE_MENU_ENTRY);

		final ClassFile clientVanilla = inject.toVanilla(
			inject.getDeobfuscated()
				.findClass("Client")
		);

		Method copy = clientVanilla.findMethod(methodName);

		final Code code = new Code(copy);
		code.setMaxStack(3);
		copy.setCode(code);

		final Instructions instructions = code.getInstructions();
		final List<Instruction> ins = instructions.getInstructions();

		ins.add(new New(instructions, runeliteMenuEntryVanilla.getPoolClass()));
		ins.add(new Dup(instructions));
		if (iload)
		{
			ins.add(new ILoad(instructions, 0));
			ins.add(new InvokeSpecial(instructions, new asm.pool.Method(runeliteMenuEntryVanilla.getPoolClass(), "<init>", new Signature("(I)V"))));
		}
		else
		{
			ins.add(new InvokeSpecial(instructions, new asm.pool.Method(runeliteMenuEntryVanilla.getPoolClass(), "<init>", new Signature("()V"))));
		}
		ins.add(new Return(instructions, InstructionType.ARETURN));
	}

	private void addSwap(Method method, Field field)
	{
		final ClassFile clientVanilla = inject.toVanilla(
			inject.getDeobfuscated()
				.findClass("Client")
		);

		Instructions ins = method.getCode().getInstructions();
		ListIterator<Instruction> iterator = ins.getInstructions().listIterator();

		int found = 0;

		while (iterator.hasNext())
		{
			Instruction i = iterator.next();

			if (found < 1)
			{
				if (!(i instanceof GetStatic))
				{
					continue;
				}

				if (((GetStatic) i).getField().getName().equals(field.getName()))
				{
					found += 1;
				}
			}
			else
			{
				if (!(i instanceof BAStore))
				{
					continue;
				}

				ILoad i1 = new ILoad(ins, 3);
				InvokeStatic i2 = new InvokeStatic(ins, new asm.pool.Method(clientVanilla.getPoolClass(), "swapMenuEntries", new Signature("(I)V")));

				iterator.add(i1);
				iterator.add(i2);

				return;
			}
		}
	}
}
