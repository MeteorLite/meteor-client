import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public enum class91 implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Ldo;"
	)
	field881(0, -1),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Ldo;"
	)
	field883(1, 1),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Ldo;"
	)
	field882(2, 7),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Ldo;"
	)
	field885(3, 8),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ldo;"
	)
	field884(4, 9);

	@ObfuscatedName("wx")
	@ObfuscatedSignature(
		descriptor = "Ldy;"
	)
	@Export("clientPreferences")
	static ClientPreferences clientPreferences;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Leq;"
	)
	@Export("World_request")
	static UrlRequest World_request;
	@ObfuscatedName("ah")
	final int field886;
	@ObfuscatedName("ar")
	final int field887;

	class91(int var3, int var4) {
		this.field886 = var3;
		this.field887 = var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field887;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Liz;",
		garbageValue = "1356482974"
	)
	@Export("getObjectDefinition")
	public static ObjectComposition getObjectDefinition(int var0) {
		ObjectComposition var1 = (ObjectComposition)ObjectComposition.ObjectDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ObjectComposition.ObjectDefinition_archive.takeFile(6, var0);
			var1 = new ObjectComposition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			if (var1.isSolid) {
				var1.interactType = 0;
				var1.boolean1 = false;
			}

			ObjectComposition.ObjectDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		descriptor = "(IIIB)V",
		garbageValue = "48"
	)
	static void method482(int var0, int var1, int var2) {
		if (var0 != 0) {
			int var3 = var0 >> 8;
			int var4 = var0 >> 4 & 7;
			int var5 = var0 & 15;
			Client.soundEffectIds[Client.soundEffectCount] = var3;
			Client.queuedSoundEffectLoops[Client.soundEffectCount] = var4;
			Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
			Client.soundEffects[Client.soundEffectCount] = null;
			int var6 = (var1 - 64) / 128;
			int var7 = (var2 - 64) / 128;
			Client.soundLocations[Client.soundEffectCount] = var5 + (var7 << 8) + (var6 << 16);
			++Client.soundEffectCount;
		}
	}

	@ObfuscatedName("kf")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "74"
	)
	static void method483() {
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
	}
}