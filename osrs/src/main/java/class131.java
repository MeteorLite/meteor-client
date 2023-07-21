import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class131 implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	static final class131 field1255;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	static final class131 field1256;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	static final class131 field1253;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	static final class131 field1252;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	static final class131 field1254;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lfa;"
	)
	static final class131 field1251;
	@ObfuscatedName("dr")
	@ObfuscatedSignature(
		descriptor = "[Lud;"
	)
	@Export("worldSelectBackSprites")
	static SpritePixels[] worldSelectBackSprites;
	@ObfuscatedName("ff")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	@Export("archive10")
	static Archive archive10;
	@ObfuscatedName("ag")
	final int field1257;
	@ObfuscatedName("az")
	final int field1259;
	@ObfuscatedName("av")
	final int field1258;

	static {
		field1255 = new class131(0, 0, (String)null, 0);
		field1256 = new class131(1, 1, (String)null, 9);
		field1253 = new class131(2, 2, (String)null, 3);
		field1252 = new class131(3, 3, (String)null, 6);
		field1254 = new class131(4, 4, (String)null, 1);
		field1251 = new class131(5, 5, (String)null, 3);
	}

	class131(int var1, int var2, String var3, int var4) {
		this.field1257 = var1;
		this.field1259 = var2;
		this.field1258 = var4;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1580346823"
	)
	int method719() {
		return this.field1258;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1259;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)Lia;",
		garbageValue = "-1250585364"
	)
	public static FloorOverlayDefinition method718(int var0) {
		FloorOverlayDefinition var1 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var0);
			var1 = new FloorOverlayDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2), var0);
			}

			var1.postDecode();
			FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
