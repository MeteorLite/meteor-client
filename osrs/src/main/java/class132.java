import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class132 implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1274;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1276;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1269;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1266;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1270;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1265;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1263;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1277;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1273;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1267;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1268;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1271;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1264;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1275;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1261;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1272;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lfg;"
	)
	static final class132 field1262;
	@ObfuscatedName("uk")
	static int field1260;
	@ObfuscatedName("ab")
	final int field1278;
	@ObfuscatedName("ad")
	final int field1279;
	@ObfuscatedName("ao")
	final int field1280;

	static {
		field1274 = new class132(0, 0, (String)null, -1, -1);
		field1276 = new class132(1, 1, (String)null, 0, 2);
		field1269 = new class132(2, 2, (String)null, 1, 2);
		field1266 = new class132(3, 3, (String)null, 2, 2);
		field1270 = new class132(4, 4, (String)null, 3, 1);
		field1265 = new class132(5, 5, (String)null, 4, 1);
		field1263 = new class132(6, 6, (String)null, 5, 1);
		field1277 = new class132(7, 7, (String)null, 6, 3);
		field1273 = new class132(8, 8, (String)null, 7, 3);
		field1267 = new class132(9, 9, (String)null, 8, 3);
		field1268 = new class132(10, 10, (String)null, 0, 7);
		field1271 = new class132(11, 11, (String)null, 1, 7);
		field1264 = new class132(12, 12, (String)null, 2, 7);
		field1275 = new class132(13, 13, (String)null, 3, 7);
		field1261 = new class132(14, 14, (String)null, 4, 7);
		field1272 = new class132(15, 15, (String)null, 5, 7);
		field1262 = new class132(16, 16, (String)null, 0, 5);
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/String;II)V",
		garbageValue = "-1"
	)
	class132(int var1, int var2, String var3, int var4, int var5) {
		this.field1278 = var1;
		this.field1279 = var2;
		this.field1280 = var4;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1279;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-130893378"
	)
	int method724() {
		return this.field1280;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Lhe;",
		garbageValue = "2013282869"
	)
	public static VarcInt method721(int var0) {
		VarcInt var1 = (VarcInt)VarcInt.VarcInt_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarcInt.VarcInt_archive.takeFile(19, var0);
			var1 = new VarcInt();
			if (var2 != null) {
				var1.method940(new Buffer(var2));
			}

			VarcInt.VarcInt_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IB)Lhx;",
		garbageValue = "1"
	)
	@Export("KitDefinition_get")
	public static KitDefinition KitDefinition_get(int var0) {
		KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = World.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			KitDefinition.KitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("id")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-225277985"
	)
	static final void method725() {
		for (int var0 = 0; var0 < Client.npcCount; ++var0) {
			int var1 = Client.npcIndices[var0];
			NPC var2 = Client.npcs[var1];
			if (var2 != null) {
				class47.updateActorSequence(var2, var2.definition.size);
			}
		}

	}
}
