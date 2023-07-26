import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rc")
public abstract class class458 implements class281 {
	@ObfuscatedName("tn")
	static boolean field3887;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Ltm;"
	)
	class503 field3888;

	class458(int var1) {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;II)V",
		garbageValue = "-546839154"
	)
	@Export("vmethod7769")
	abstract void vmethod7769(Buffer var1, int var2);

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "126"
	)
	public void method2304(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			class454 var3 = (class454)ClientPreferences.findEnumerated(UrlRequester.method644(), var2);
			if (var3 != null) {
				switch(var3.field3882) {
				case 0:
					ClientPreferences.findEnumerated(Tiles.method459(), var1.readUnsignedByte());
					break;
				case 1:
				default:
					throw new IllegalStateException("Unrecognised VarTypeEncodingKey - " + var3);
				case 2:
					var1.readStringCp1252NullCircumfixed();
					break;
				case 3:
					int var4 = var1.readUnsignedByte();
					this.field3888 = class395.method1994(var4);
				}
			} else {
				this.vmethod7769(var1, var2);
			}
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1079590565"
	)
	boolean method2305() {
		return this.field3888 != null;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/Object;",
		garbageValue = "703790014"
	)
	Object method2306() {
		if (this.field3888 == class503.field4090) {
			return 0;
		} else if (this.field3888 == class503.field4091) {
			return -1L;
		} else {
			return this.field3888 == class503.field4089 ? "" : null;
		}
	}

	@ObfuscatedName("aj")
	@Export("Entity_unpackID")
	public static int Entity_unpackID(long var0) {
		return (int)(var0 >>> 17 & 4294967295L);
	}
}
