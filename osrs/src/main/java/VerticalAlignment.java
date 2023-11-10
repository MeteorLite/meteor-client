import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lhg;"
	)
	field1581(2, 0),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lhg;"
	)
	@Export("VerticalAlignment_centered")
	VerticalAlignment_centered(0, 1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lhg;"
	)
	field1580(1, 2);

	@ObfuscatedName("ao")
	@Export("value")
	public final int value;
	@ObfuscatedName("ab")
	@Export("id")
	final int id;

	VerticalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)[Lnt;",
		garbageValue = "1599103276"
	)
	public static StudioGame[] method955() {
		return new StudioGame[]{StudioGame.game5, StudioGame.stellardawn, StudioGame.oldscape, StudioGame.game3, StudioGame.runescape, StudioGame.game4};
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IS)Lhw;",
		garbageValue = "4625"
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

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "-2145020206"
	)
	static int method959(int var0, Script var1, boolean var2) {
		return 2;
	}

	@ObfuscatedName("hx")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "-52"
	)
	static final void method958(boolean var0) {
		if (var0) {
			Client.field419 = Login.field744 ? class124.field1205 : class124.field1206;
		} else {
			Client.field419 = WorldMapIcon_1.clientPreferences.method565(Login.Login_username) ? class124.field1208 : class124.field1207;
		}

	}

	@ObfuscatedName("oh")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-66"
	)
	static void method960() {
		if (Client.oculusOrbState == 1) {
			Client.oculusOrbOnLocalPlayer = true;
		}

	}
}