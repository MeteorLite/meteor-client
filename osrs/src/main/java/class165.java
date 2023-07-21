import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class165 extends class143 {
	@ObfuscatedName("uq")
	static int field1420;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lds;"
	)
	static LoginScreenAnimation field1419;
	@ObfuscatedName("aw")
	long field1422;
	@ObfuscatedName("ay")
	String field1421;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfr;)V"
	)
	class165(class146 var1) {
		this.this$0 = var1;
		this.field1422 = -1L;
		this.field1421 = null;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "1"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1422 = var1.readLong();
		}

		this.field1421 = var1.readStringCp1252NullTerminatedOrNull();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lfx;B)V",
		garbageValue = "-72"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method811(this.field1422, this.field1421);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lfm;FI)F",
		garbageValue = "-655918907"
	)
	static float method863(class130 var0, float var1) {
		if (var0 == null) {
			return 0.0F;
		} else {
			float var2 = var1 - var0.field1234;
			return (var0.field1239 + (var0.field1242 * var2 + var0.field1238) * var2) * var2 + var0.field1240;
		}
	}
}
