import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class162 extends class143 {
	@ObfuscatedName("aa")
	static int[][] field1419;
	@ObfuscatedName("qv")
	@ObfuscatedSignature(
		descriptor = "[Lmi;"
	)
	static Widget[] field1420;
	@ObfuscatedName("tm")
	@ObfuscatedSignature(
		descriptor = "Lbl;"
	)
	@Export("pcmStreamMixer")
	static PcmStreamMixer pcmStreamMixer;
	@ObfuscatedName("au")
	int field1421;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfn;"
	)
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfn;)V"
	)
	class162(class146 var1) {
		this.this$0 = var1;
		this.field1421 = -1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "209179459"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1421 = var1.readUnsignedShort();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lfi;B)V",
		garbageValue = "73"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method818(this.field1421);
	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "(ILmc;ZI)V",
		garbageValue = "-1867605195"
	)
	static void method854(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = class227.getWorldMap().getMapArea(var0);
		int var4 = VarbitComposition.localPlayer.plane;
		int var5 = (VarbitComposition.localPlayer.x >> 7) + UrlRequester.baseX;
		int var6 = (VarbitComposition.localPlayer.y >> 7) + class47.baseY;
		Coord var7 = new Coord(var4, var5, var6);
		class227.getWorldMap().method2400(var3, var7, var1, var2);
	}
}