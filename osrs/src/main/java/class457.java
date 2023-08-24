import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rv")
public abstract class class457 implements class280 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Ltb;"
	)
	class502 field3900;

	class457(int var1) {
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;II)V",
		garbageValue = "362589282"
	)
	@Export("vmethod7769")
	abstract void vmethod7769(Buffer var1, int var2);

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)V",
		garbageValue = "-87"
	)
	public void method2327(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			class453 var3 = (class453)KeyHandler.findEnumerated(class418.method2163(), var2);
			if (var3 != null) {
				switch(var3.field3897) {
				case 0:
					int var4 = var1.readUnsignedByte();
					this.field3900 = SequenceDefinition.method1074(var4);
					if (this.field3900 != null) {
						break;
					}

					throw new IllegalStateException("Unknown ScriptVarType ID in VarType.decode: " + var4);
				case 1:
					var1.readStringCp1252NullCircumfixed();
					break;
				case 2:
					class352[] var5 = new class352[]{class352.field3482, class352.field3480, class352.field3479, class352.field3481};
					KeyHandler.findEnumerated(var5, var1.readUnsignedByte());
					break;
				default:
					throw new IllegalStateException("Unrecognised VarTypeEncodingKey - " + var3);
				}
			} else {
				this.vmethod7769(var1, var2);
			}
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-2062851135"
	)
	boolean method2328() {
		return this.field3900 != null;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/Object;",
		garbageValue = "-12"
	)
	Object method2329() {
		if (this.field3900 == class502.field4101) {
			return 0;
		} else if (this.field3900 == class502.field4099) {
			return -1L;
		} else {
			return this.field3900 == class502.field4100 ? "" : null;
		}
	}
}