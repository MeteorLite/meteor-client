package com.openosrs.injector.injectors.raw;

import com.openosrs.injector.InjectUtil;
import com.openosrs.injector.injection.InjectData;
import com.openosrs.injector.injectors.AbstractInjector;
import java.util.ListIterator;
import asm.ClassFile;
import asm.Method;
import asm.attributes.code.Instruction;
import asm.attributes.code.Instructions;
import asm.attributes.code.instructions.LDC;
import asm.attributes.code.instructions.PutStatic;
import asm.pool.Field;

public class GameDrawingMode extends AbstractInjector
{
	public GameDrawingMode(InjectData inject)
	{
		super(inject);
	}

	public void inject()
	{
		final ClassFile clientVanilla = inject.toVanilla(
			inject.getDeobfuscated()
				.findClass("Client")
		);
		final Field gameDrawingMode = InjectUtil.findField(inject, "gameDrawingMode", "Client").getPoolField();

		Method clinit = clientVanilla.findMethod("<clinit>");

		Instructions ins = clinit.getCode().getInstructions();
		ListIterator<Instruction> iterator = ins.getInstructions().listIterator();
		while (iterator.hasNext())
		{
			Instruction i = iterator.next();

			if (i instanceof PutStatic)
			{
				Field field = ((PutStatic) i).getField();

				if (field.getName().equals(gameDrawingMode.getName()))
				{
					iterator.add(new LDC(ins, 2));
					iterator.add(new PutStatic(ins, gameDrawingMode));
				}
			}
		}
	}
}
