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
package asm.attributes.code.instructions;

import asm.ClassFile;
import asm.ClassGroup;
import asm.Field;
import asm.attributes.code.Instruction;
import asm.attributes.code.InstructionType;
import asm.attributes.code.Instructions;
import asm.attributes.code.instruction.types.GetFieldInstruction;
import asm.attributes.code.instruction.types.InvokeInstruction;
import asm.execution.*;
import asm.pool.Method;
import asm.signature.Signature;
import asm.signature.util.VirtualMethods;
import asm.mapping.MappingExecutorUtil;
import asm.mapping.ParallelExecutorMapping;
import org.objectweb.asm.MethodVisitor;

import java.util.Arrays;
import java.util.List;

public class InvokeInterface extends Instruction implements InvokeInstruction
{
	private Method method;
	private List<asm.Method> myMethods;

	public InvokeInterface(Instructions instructions, InstructionType type)
	{
		super(instructions, type);
	}

	public InvokeInterface(Instructions instructions, Method method)
	{
		super(instructions, InstructionType.INVOKEINTERFACE);
		this.method = method;
	}

	@Override
	public String toString()
	{
		return "invokeinterface " + method + " in " + this.getInstructions().getCode().getMethod();// + " at pc 0x" + Integer.toHexString(this.getPc());
	}

	@Override
	public void accept(MethodVisitor visitor)
	{
		visitor.visitMethodInsn(this.getType().getCode(),
			method.getClazz().getName(),
			method.getName(),
			method.getType().toString(),
			true);
	}

	@Override
	public List<asm.Method> getMethods()
	{
		return myMethods != null ? myMethods : Arrays.asList();
	}

	@Override
	public InstructionContext execute(Frame frame)
	{
		InstructionContext ins = new InstructionContext(this, frame);
		Stack stack = frame.getStack();

		int count = method.getType().size();

		for (int i = 0; i < count; ++i)
		{
			StackContext arg = stack.pop();
			ins.pop(arg);
		}

		StackContext object = stack.pop();
		ins.pop(object);

		if (!method.getType().isVoid())
		{
			StackContext ctx = new StackContext(ins,
				method.getType().getReturnValue(),
				Value.UNKNOWN
			);
			stack.push(ctx);

			ins.push(ctx);
		}

		for (asm.Method method : getMethods())
		{
			ins.invoke(method);

			if (method.getCode() == null)
			{
				continue;
			}

			// add possible method call to execution
			Execution execution = frame.getExecution();
			execution.invoke(ins, method);
		}

		if (myMethods != null)
		{
			for (asm.Method method : myMethods)
			{
				frame.getExecution().order(frame, method);
			}
		}

		return ins;
	}

	@Override
	public void removeParameter(int idx)
	{
		asm.pool.Class clazz = method.getClazz();

		// create new signature
		Signature sig = new Signature(method.getType());
		sig.remove(idx);

		// create new method pool object
		method = new Method(clazz, method.getName(), sig);
	}

	@Override
	public Method getMethod()
	{
		return method;
	}

	private List<asm.Method> lookupMethods()
	{
		ClassGroup group = this.getInstructions().getCode().getMethod().getClassFile().getGroup();

		ClassFile otherClass = group.findClass(method.getClazz().getName());
		if (otherClass == null)
		{
			return null; // not our class
		}
		asm.Method m = otherClass.findMethod(method.getName(), method.getType());
		if (m == null)
		{
			return null;
		}

		return VirtualMethods.getVirtualMethods(m);
	}

	@Override
	public void lookup()
	{
		myMethods = lookupMethods();
	}

	@Override
	public void regeneratePool()
	{
		if (myMethods != null && !myMethods.isEmpty())
		{
			if (!myMethods.equals(lookupMethods()))
			{
				method = myMethods.get(0).getPoolMethod(); // is this right?
			}
		}
	}

	@Override
	public void map(ParallelExecutorMapping mapping, InstructionContext ctx, InstructionContext other)
	{
		InvokeInterface otherIv = (InvokeInterface) other.getInstruction();

		List<asm.Method> myMethods = this.getMethods(),
			otherMethods = otherIv.getMethods();

		assert myMethods.size() == otherMethods.size();

		for (int i = 0; i < myMethods.size(); ++i)
		{
			asm.Method m1 = myMethods.get(i), otherMethod = null;
			ClassFile c1 = m1.getClassFile();

			if (myMethods.size() == 1)
			{
				otherMethod = otherMethods.get(0);
			}
			else
			{
				for (int j = 0; j < myMethods.size(); ++j)
				{
					asm.Method m2 = otherMethods.get(j);
					ClassFile c2 = m2.getClassFile();

					if (MappingExecutorUtil.isMaybeEqual(c1, c2))
					{
						if (otherMethod != null)
						{
							otherMethod = null;
							break;
						}

						otherMethod = m2;
					}
				}
			}

			if (otherMethod != null)
			{
				mapping.map(this, m1, otherMethod);
			}
		}

		for (int i = 0; i < ctx.getPops().size(); ++i)
		{
			StackContext s1 = ctx.getPops().get(i),
				s2 = other.getPops().get(i);

			InstructionContext base1 = MappingExecutorUtil.resolve(s1.getPushed(), s1);
			InstructionContext base2 = MappingExecutorUtil.resolve(s2.getPushed(), s2);

			if (base1.getInstruction() instanceof GetFieldInstruction && base2.getInstruction() instanceof GetFieldInstruction)
			{
				GetFieldInstruction gf1 = (GetFieldInstruction) base1.getInstruction(),
					gf2 = (GetFieldInstruction) base2.getInstruction();

				Field f1 = gf1.getMyField(),
					f2 = gf2.getMyField();

				if (f1 != null && f2 != null)
				{
					mapping.map(this, f1, f2);
				}
			}
		}

		/* map field that was invoked on */
		StackContext object1 = ctx.getPops().get(method.getType().size()),
			object2 = other.getPops().get(otherIv.method.getType().size());

		InstructionContext base1 = MappingExecutorUtil.resolve(object1.getPushed(), object1);
		InstructionContext base2 = MappingExecutorUtil.resolve(object2.getPushed(), object2);

		if (base1.getInstruction() instanceof GetFieldInstruction && base2.getInstruction() instanceof GetFieldInstruction)
		{
			GetFieldInstruction gf1 = (GetFieldInstruction) base1.getInstruction(),
				gf2 = (GetFieldInstruction) base2.getInstruction();

			Field f1 = gf1.getMyField(),
				f2 = gf2.getMyField();

			if (f1 != null && f2 != null)
			{
				mapping.map(this, f1, f2);
			}
		}
	}

	@Override
	public boolean isSame(InstructionContext thisIc, InstructionContext otherIc)
	{
		if (thisIc.getInstruction().getClass() != otherIc.getInstruction().getClass())
		{
			return false;
		}

		InvokeInterface thisIi = (InvokeInterface) thisIc.getInstruction(),
			otherIi = (InvokeInterface) otherIc.getInstruction();

		if (!MappingExecutorUtil.isMaybeEqual(thisIi.method.getType(), otherIi.method.getType()))
		{
			return false;
		}

		List<asm.Method> thisMethods = thisIi.getMethods(),
			otherMethods = otherIi.getMethods();

		if (thisMethods.size() != otherMethods.size())
		{
			return false;
		}

		for (int i = 0; i < thisMethods.size(); ++i)
		{
			asm.Method m1 = thisMethods.get(i);
			asm.Method m2 = otherMethods.get(i);

			if (!MappingExecutorUtil.isMaybeEqual(m1.getDescriptor(), m2.getDescriptor()))
			{
				return false;
			}

			break;
		}

		return true;
	}

	@Override
	public boolean canMap(InstructionContext thisIc)
	{
		return MappingExecutorUtil.isMappable(this);
	}

	@Override
	public void setMethod(Method method)
	{
		this.method = method;
	}
}
