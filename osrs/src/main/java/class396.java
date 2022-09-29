import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("of")
public abstract class class396 implements class249 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lps;"
	)
	class434 field4465;

	class396(int var1) {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;IB)V",
		garbageValue = "-102"
	)
	abstract void vmethod7286(Buffer var1, int var2);

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V",
		garbageValue = "2142635429"
	)
	public void method7285(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			class392 var3 = (class392)Varps.findEnumerated(BoundaryObject.method4650(), var2);
			if (var3 != null) {
				switch(var3.field4460) {
				case 0:
					Varps.findEnumerated(class230.method5026(), var1.readUnsignedByte());
					break;
				case 1:
					int var4 = var1.readUnsignedByte();
					this.field4465 = class360.method6732(var4);
					if (this.field4465 != null) {
						break;
					}

					throw new IllegalStateException("Unknown ScriptVarType ID in VarType.decode: " + var4);
				case 2:
				default:
					throw new IllegalStateException("Unrecognised VarTypeEncodingKey - " + var3);
				case 3:
					var1.readStringCp1252NullCircumfixed();
				}
			} else {
				this.vmethod7286(var1, var2);
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1329321866"
	)
	boolean method7287() {
		return this.field4465 != null;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/Object;",
		garbageValue = "-1161408575"
	)
	Object method7295() {
		if (this.field4465 == class434.field4691) {
			return 0;
		} else if (this.field4465 == class434.field4688) {
			return -1L;
		} else {
			return this.field4465 == class434.field4689 ? "" : null;
		}
	}
}
