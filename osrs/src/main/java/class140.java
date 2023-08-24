import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class140 extends class143 {
	@ObfuscatedName("aq")
	public static short[][] field1328;
	@ObfuscatedName("au")
	int field1332;
	@ObfuscatedName("ae")
	int field1329;
	@ObfuscatedName("ao")
	int field1330;
	@ObfuscatedName("at")
	int field1331;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfn;"
	)
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfn;)V"
	)
	class140(class146 var1) {
		this.this$0 = var1;
		this.field1332 = -1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "209179459"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1332 = var1.readUnsignedShort();
		this.field1329 = var1.readInt();
		this.field1330 = var1.readUnsignedByte();
		this.field1331 = var1.readUnsignedByte();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lfi;B)V",
		garbageValue = "73"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method820(this.field1332, this.field1329, this.field1330, this.field1331);
	}

	@ObfuscatedName("ii")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-64"
	)
	static final void method762() {
		int var0;
		int var1;
		int var2;
		if (!Client.field402) {
			var0 = Players.cameraMoveToX * 128 + 64;
			var1 = class33.cameraMoveToY * 128 + 64;
			var2 = class18.getTileHeight(var0, var1, HealthBar.Client_plane) - VarpDefinition.cameraMoveToHeight;
			class126.method702(var0, var2, var1);
		} else if (Client.field642 != null) {
			NPCComposition.cameraX = Client.field642.vmethod2349();
			class139.cameraZ = Client.field642.vmethod2347();
			if (Client.field401) {
				class133.cameraY = Client.field642.vmethod2320();
			} else {
				class133.cameraY = class18.getTileHeight(NPCComposition.cameraX, class139.cameraZ, HealthBar.Client_plane) - Client.field642.vmethod2320();
			}

			Client.field642.method2376();
		}

		if (!Client.field404) {
			var0 = PendingSpawn.cameraLookAtX * 128 + 64;
			var1 = VarbitComposition.cameraLookAtY * 128 + 64;
			var2 = class18.getTileHeight(var0, var1, HealthBar.Client_plane) - MusicPatchNode2.cameraLookAtHeight;
			int var3 = var0 - NPCComposition.cameraX;
			int var4 = var2 - class133.cameraY;
			int var5 = var1 - class139.cameraZ;
			int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
			int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.9490051269531D) & 2047;
			int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.9490051269531D) & 2047;
			class416.method2161(var7, var8);
		} else {
			if (Client.field647 != null) {
				class129.cameraPitch = Client.field647.method2371();
				class129.cameraPitch = Math.min(Math.max(class129.cameraPitch, 128), 383);
				Client.field647.method2376();
			}

			if (Client.field646 != null) {
				UserComparator10.cameraYaw = Client.field646.method2371() & 2047;
				Client.field646.method2376();
			}
		}

	}
}