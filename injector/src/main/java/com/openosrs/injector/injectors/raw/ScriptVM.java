/*
 * Copyright (c) 2019, Lucas <https://github.com/Lucwousin>
 * All rights reserved.
 *
 * This code is licensed under GPL3, see the complete license in
 * the LICENSE file in the root directory of this submodule.
 *
 * Copyright (c) 2018 Abex
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
package com.openosrs.injector.injectors.raw;

import com.openosrs.injector.InjectException;
import com.openosrs.injector.InjectUtil;
import com.openosrs.injector.injection.InjectData;
import com.openosrs.injector.injectors.AbstractInjector;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import asm.ClassFile;
import asm.ClassGroup;
import asm.Field;
import asm.Method;
import asm.Type;
import asm.attributes.code.Instruction;
import asm.attributes.code.Instructions;
import asm.attributes.code.Label;
import asm.attributes.code.instructions.ALoad;
import asm.attributes.code.instructions.AStore;
import asm.attributes.code.instructions.Dup;
import asm.attributes.code.instructions.GetField;
import asm.attributes.code.instructions.IALoad;
import asm.attributes.code.instructions.IInc;
import asm.attributes.code.instructions.ILoad;
import asm.attributes.code.instructions.IMul;
import asm.attributes.code.instructions.IStore;
import asm.attributes.code.instructions.IfNe;
import asm.attributes.code.instructions.InvokeStatic;
import asm.attributes.code.instructions.PutField;
import asm.attributes.code.instructions.PutStatic;
import asm.execution.Execution;
import asm.execution.InstructionContext;
import asm.execution.MethodContext;
import asm.execution.StackContext;

public class ScriptVM extends AbstractInjector {
	public ScriptVM(InjectData inject) {
		super(inject);
	}

	public void inject() {
		final ClassGroup vanilla = inject.getVanilla();

		/*
			This hooks local variable assignments in the copied version of runScript:
			 - The currently executing script > client.currentScript
			 - The currently executing script's program counter > client.currentScriptPC
			 - The currently executing opcode > client.vmExecuteOpcode(I)Z

			The currently executing script variable is located as the outermost Script local

			The PC is located by its use in PutField ScriptFrame::invokedFromPC

			The currently executing opcode is found by searching for iaload with the script's instruction array

			The script's instruction array is identified by looking for the getfield from script.instructions

			for rev 163 :
			// Jump back to here if vmExecuteOpcode returns true
			aload6 // Script.instructions
			iinc 5 1 // ++PC
			iload5 // PC
			iaload
			istore8
			// <- Inject here
			iload8
			bipush 100
			if_icmpge L52

		 */
		final ClassFile deobScript = vanilla.findClass("Script");

		final String scriptObName = deobScript.getName();

		final Field scriptInstructions = InjectUtil.findField(inject, "opcodes", "Script");
		final Field scriptStatePC = InjectUtil.findField(inject, "pc", "ScriptFrame");
		System.out.println(scriptInstructions);
		System.out.println(scriptStatePC);

		final ClassFile vanillaClient = vanilla.findClass("Client");

		// Next 4 should be injected by mixins, so don't need fail fast
		final Method runScript = vanillaClient.findStaticMethod("copy$runScript");
		final Method runScriptLogic = vanillaClient.findStaticMethod("copy$runScriptLogic");
		final Method vmExecuteOpcode = vanillaClient.findStaticMethod("vmExecuteOpcode");
		final Method setCurrentScript = vanillaClient.findStaticMethod("setCurrentScript");
		final Field currentScriptPCField = vanillaClient.findField("currentScriptPC");

		Execution e = new Execution(inject.getVanilla());
		e.addMethod(runScriptLogic);
		e.noInvoke = true;

		AtomicReference<MethodContext> pcontext = new AtomicReference<>(null);

		e.addMethodContextVisitor(pcontext::set);
		e.run();

		Instructions instrs = runScriptLogic.getCode().getInstructions();

		Set<AStore> scriptStores = new HashSet<>();
		Integer pcLocalVar = null;
		Integer instructionArrayLocalVar = null;
		IStore currentOpcodeStore = null;
		ALoad localInstructionLoad = null;

		MethodContext methodContext = pcontext.get();

		for (InstructionContext instrCtx : methodContext.getInstructionContexts()) {
			Instruction instr = instrCtx.getInstruction();
			//System.out.println("INSTRUCTION: " + instrCtx.getInstruction().toString());

			if (instr instanceof AStore) {
				AStore store = (AStore) instr;
				StackContext storedVarCtx = instrCtx.getPops().get(0);
				var name = storedVarCtx.getType().getInternalName();
				// Find AStores that store a Script
				if (name.equals(scriptObName)) {
					System.out.println("Found script store: " + name);
					scriptStores.add(store);
				}

				// Find AStores that store the instructions
				InstructionContext pusherCtx = storedVarCtx.getPushed();
				if (pusherCtx.getInstruction() instanceof GetField) {
					GetField getField = (GetField) pusherCtx.getInstruction();
					if (getField.getMyField().equals(scriptInstructions)) {
						instructionArrayLocalVar = store.getVariableIndex();
					}
				}
			}
			// Find the local that invokedFromPc is set from
			if (instr instanceof PutField) {
				PutField put = (PutField) instr;
				if (put.getMyField() == scriptStatePC) {
					pcLocalVar = instrCtx.getPops().stream()
							.map(StackContext::getPushed)
							.filter(i -> i.getInstruction() instanceof ILoad)
							.map(i -> ((ILoad) i.getInstruction()).getVariableIndex())
							.findFirst()
							.orElseThrow(null);
				}
			}
		}

		// Find opcode load
		// This has to run after the first loop because it relies on instructionArrayLocalVar being set
		if (instructionArrayLocalVar == null) {
			throw new InjectException("Unable to find local instruction array");
		}
		for (InstructionContext instrCtx : methodContext.getInstructionContexts()) {
			Instruction instr = instrCtx.getInstruction();

			if (instr instanceof IALoad) {
				StackContext array = instrCtx.getPops().get(1);

				// Check where the array came from (looking for a getField scriptInstructions
				InstructionContext pushedCtx = array.getPushed();
				Instruction pushed = pushedCtx.getInstruction();
				if (pushed instanceof ALoad) {
					ALoad arrayLoad = (ALoad) pushed;
					if (arrayLoad.getVariableIndex() == instructionArrayLocalVar) {
						//Find the istore
						IStore istore = (IStore) instrCtx.getPushes().get(0).getPopped().stream()
								.map(InstructionContext::getInstruction)
								.filter(i -> i instanceof IStore)
								.findFirst()
								.orElseThrow(null);
						if (istore != null) {
							currentOpcodeStore = istore;
							localInstructionLoad = arrayLoad;
							log.debug("[DEBUG] Found instruction array load {}", localInstructionLoad.getVariableIndex());
							log.debug("[DEBUG] currentOpcodeStore {}", currentOpcodeStore.getVariableIndex());
						}
					}

				}
			}
		}

		// Add PutStatics to all Script AStores
		{
			int outerSciptIdx = scriptStores.stream()
					.mapToInt(AStore::getVariableIndex)
					.reduce(Math::min)
					.orElseThrow(() -> new InjectException("Unable to find any Script AStores in runScript"));
			log.debug("[DEBUG] Found script index {}", outerSciptIdx);

			ListIterator<Instruction> instrIter = instrs.getInstructions().listIterator();
			while (instrIter.hasNext()) {
				Instruction instr = instrIter.next();

				if (instr instanceof AStore) {
					AStore il = (AStore) instr;
					if (il.getVariableIndex() == outerSciptIdx) {
						instrIter.previous();
						instrIter.add(new Dup(instrs));
						instrIter.add(new InvokeStatic(instrs, setCurrentScript.getPoolMethod()));
						instrIter.next();
					}
				}
			}
		}

		// Add PutStatics to all PC IStores and IIncs
		{
			if (pcLocalVar == null) {
				throw new InjectException("Unable to find ILoad for invokedFromPc IStore");
			}
			log.debug("[DEBUG] Found pc index {}", pcLocalVar);

			ListIterator<Instruction> instrIter = instrs.getInstructions().listIterator();
			while (instrIter.hasNext()) {
				Instruction instr = instrIter.next();

				if (instr instanceof IStore) {
					IStore il = (IStore) instr;
					if (il.getVariableIndex() == pcLocalVar) {
						instrIter.previous();
						instrIter.add(new Dup(instrs));
						instrIter.add(new PutStatic(instrs, currentScriptPCField));
						instrIter.next();
					}
				}

				if (instr instanceof IInc) {
					IInc iinc = (IInc) instr;
					if (iinc.getVariableIndex() == pcLocalVar) {
						instrIter.add(new ILoad(instrs, pcLocalVar));
						instrIter.add(new PutStatic(instrs, currentScriptPCField));
					}
				}
			}
		}

		// Inject call to vmExecuteOpcode
		//log.debug("[DEBUG] Found instruction array index {}", instructionArrayLocalVar);
		if (currentOpcodeStore == null) {
			throw new InjectException("Unable to find IStore for current opcode");
		}


		/**
		 * for rev 218
		 *          L58 {
		 *              f_new (Locals[15]: ScriptEvent, Script, int, int, [Ljava/lang/Object;, int, [I, [I, int, int, int, int, int, int, int) (Stack[0])
		 *              iinc 5 1
		 *          }
		 *          L59 {
		 *              aload 6
		 *              iload 5
		 *              iaload
		 *              istore 17
		 *          }
		 *          L60 {
		 *              iload 17
		 *              bipush 100
		 *              if_icmplt L72
		 *          }
		 *          L61 {
		 *              aload 1 // reference to arg1
		 *              getfield Script.intOperands:int[]
		 *              iload 5
		 *              iaload
		 *              iconst_1
		 *              if_icmpne L64
		 *          }
		 *          L62 {
		 *              iconst_1
		 *              istore 18
		 *          }
		 */

		/*
			[DEBUG] Found instruction array load 6
			[DEBUG] currentOpcodeStore 17
			[DEBUG] Found script index 1
			[DEBUG] Found pc index 5
		 */

		// Existing code...

		int istorepc = instrs.getInstructions().indexOf(currentOpcodeStore);
		assert istorepc >= 0;
		System.out.println("istorepc: " + istorepc);

		Label nextIteration = instrs.createLabelFor(localInstructionLoad);
		System.out.println("currentOpcodeStore: " + currentOpcodeStore.getVariableIndex());

// Debug statements to display indices before adding instructions
		System.out.println("Before adding instructions:");
		System.out.println("Index 1: " + (istorepc + 1));
		System.out.println("Index 2: " + (istorepc + 2));
		System.out.println("Index 3: " + (istorepc + 3));

		instrs.addInstruction(istorepc + 1, new ILoad(instrs, currentOpcodeStore.getVariableIndex()));
		System.out.println("vmExecuteOpcode: " + vmExecuteOpcode.getName() + " " + "istorepc: " + (istorepc + 1));
		instrs.addInstruction(istorepc + 2, new InvokeStatic(instrs, vmExecuteOpcode.getPoolMethod()));
		instrs.addInstruction(istorepc + 3, new IfNe(instrs, nextIteration));
		System.out.println("Script instructions: " + scriptInstructions.getName() + " " + "istorepc: " + (istorepc + 3));


		Instructions runScriptInstrs = runScript.getCode().getInstructions();

		ListIterator<Instruction> instrIter = runScriptInstrs.getInstructions().listIterator();
		while (instrIter.hasNext()) {
			Instruction instr = instrIter.next();
			//log.debug("[DEBUG] Checking instruction {}", instr.getInstructions());

			if (instr instanceof InvokeStatic) {
				InvokeStatic invokeStatic = (InvokeStatic) instr;
				if (invokeStatic.getMethod().getType().getReturnValue().toString().equals("L" + scriptObName + ";")) {
					instrIter.add(new Dup(instrs));
					instrIter.add(new InvokeStatic(instrs, setCurrentScript.getPoolMethod()));
					instrIter.next();
				}
			}
		}

	}
}