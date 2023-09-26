import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sl")
public abstract class class472 implements class294 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Ltr;"
	)
	class517 field3932;

	class472(int var1) {
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;IS)V",
		garbageValue = "6664"
	)
	@Export("vmethod7769")
	abstract void vmethod7769(Buffer var1, int var2);

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "-1679983256"
	)
	public void method2368(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			class468 var3 = (class468)SequenceDefinition.findEnumerated(class30.method120(), var2);
			if (var3 != null) {
				switch(var3.field3929) {
				case 0:
					int var5 = var1.readUnsignedByte();
					this.field3932 = Tile.method1230(var5);
					if (this.field3932 != null) {
						break;
					}

					throw new IllegalStateException("Unknown ScriptVarType ID in VarType.decode: " + var5);
				case 1:
					var1.readStringCp1252NullCircumfixed();
					break;
				case 2:
					class367[] var4 = new class367[]{class367.field3514, class367.field3513, class367.field3515, class367.field3512};
					SequenceDefinition.findEnumerated(var4, var1.readUnsignedByte());
					break;
				default:
					throw new IllegalStateException("Unrecognised VarTypeEncodingKey - " + var3);
				}
			} else {
				this.vmethod7769(var1, var2);
			}
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1797957438"
	)
	boolean method2369() {
		return this.field3932 != null;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/Object;",
		garbageValue = "1069039915"
	)
	Object method2370() {
		if (this.field3932 == class517.field4129) {
			return 0;
		} else if (this.field3932 == class517.field4131) {
			return -1L;
		} else {
			return this.field3932 == class517.field4130 ? "" : null;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)[Luf;",
		garbageValue = "-1429373012"
	)
	@Export("FillMode_values")
	public static class541[] FillMode_values() {
		return new class541[]{class541.field4257, class541.SOLID, class541.field4258};
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZB)I",
		garbageValue = "47"
	)
	static int method2371(int var0, Script var1, boolean var2) {
		if (var0 == 7463) {
			boolean var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			class330.method1730(var3);
			return 1;
		} else {
			return 2;
		}
	}
}