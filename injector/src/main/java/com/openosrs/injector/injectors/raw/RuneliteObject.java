/*
 * Copyright (c) 2021, Owain van Brakel <https://github.com/Owain94>
 * All rights reserved.
 *
 * This code is licensed under GPL3, see the complete license in
 * the LICENSE file in the root directory of this submodule.
 */
package com.openosrs.injector.injectors.raw;

import com.openosrs.injector.injection.InjectData;
import com.openosrs.injector.injectors.AbstractInjector;
import java.util.List;
import asm.ClassFile;
import asm.Method;
import asm.attributes.Code;
import asm.attributes.code.Instruction;
import asm.attributes.code.InstructionType;
import asm.attributes.code.Instructions;
import asm.attributes.code.instructions.Dup;
import asm.attributes.code.instructions.InvokeSpecial;
import asm.attributes.code.instructions.New;
import asm.attributes.code.instructions.Return;
import asm.signature.Signature;

public class RuneliteObject extends AbstractInjector
{
	private static final String RUNELITE_OBJECT = "RuneLiteObject";

	public RuneliteObject(InjectData inject)
	{
		super(inject);
	}

	public void inject()
	{
		ClassFile runeliteObjectVanilla = inject.vanilla.findClass(RUNELITE_OBJECT);

		final ClassFile clientVanilla = inject.toVanilla(
			inject.getDeobfuscated()
				.findClass("Client")
		);

		Method copy = new Method(clientVanilla, "createRuneLiteObject", new Signature("()Lnet/runelite/api/RuneLiteObject;"));
		copy.setPublic();

		final Code code = new Code(copy);
		code.setMaxStack(2);
		copy.setCode(code);
		clientVanilla.addMethod(copy);

		final Instructions instructions = code.getInstructions();
		final List<Instruction> ins = instructions.getInstructions();

		ins.add(new New(instructions, runeliteObjectVanilla.getPoolClass()));
		ins.add(new Dup(instructions));
		ins.add(new InvokeSpecial(instructions, new asm.pool.Method(runeliteObjectVanilla.getPoolClass(), "<init>", new Signature("()V"))));
		ins.add(new Return(instructions, InstructionType.ARETURN));
	}
}
