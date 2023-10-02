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
import asm.ClassFile;
import asm.Method;
import asm.attributes.Code;
import asm.attributes.code.Instructions;
import asm.attributes.code.instructions.ALoad;
import asm.attributes.code.instructions.InvokeSpecial;
import asm.attributes.code.instructions.VReturn;
import asm.signature.Signature;

public class GraphicsObject extends AbstractInjector
{
	public GraphicsObject(InjectData inject)
	{
		super(inject);
	}

	public void inject()
	{
		final ClassFile graphicsObjectVanilla = inject.toVanilla(
			inject.getDeobfuscated()
				.findClass("GraphicsObject")
		);

		final ClassFile renderableVanilla = inject.toVanilla(
			inject.getDeobfuscated()
				.findClass("Renderable")
		);

		graphicsObjectVanilla.clearFinal();

		Method initGraphicsObject = new Method(graphicsObjectVanilla, "<init>", new Signature("()V"));
		initGraphicsObject.setPublic();

		final Code code = new Code(initGraphicsObject);
		code.setMaxStack(1);
		initGraphicsObject.setCode(code);
		graphicsObjectVanilla.addMethod(initGraphicsObject);

		Instructions ins = code.getInstructions();

		ins.addInstruction(new ALoad(ins, 0));
		ins.addInstruction(new InvokeSpecial(ins, new asm.pool.Method(renderableVanilla.getPoolClass(), "<init>", new Signature("()V"))));
		ins.addInstruction(new VReturn(ins));
	}
}
