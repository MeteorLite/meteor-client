import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public enum class90 implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Ldk;"
	)
	field893(0, -1),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Ldk;"
	)
	field889(1, 2),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ldk;"
	)
	field891(2, 3),
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ldk;"
	)
	field892(3, 4),
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Ldk;"
	)
	field888(4, 5),
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Ldk;"
	)
	field890(5, 6);

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "Lrb;"
	)
	static Bounds field887;
	@ObfuscatedName("az")
	final int field895;
	@ObfuscatedName("ap")
	final int field894;

	class90(int var3, int var4) {
		this.field895 = var3;
		this.field894 = var4;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field894;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IB)Lhw;",
		garbageValue = "0"
	)
	@Export("getNpcDefinition")
	public static NPCComposition getNpcDefinition(int var0) {
		NPCComposition var1 = (NPCComposition)NPCComposition.NpcDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = NPCComposition.NpcDefinition_archive.takeFile(9, var0);
			var1 = new NPCComposition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			NPCComposition.NpcDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}