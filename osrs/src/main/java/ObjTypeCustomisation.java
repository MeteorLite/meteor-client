import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
@Implements("ObjTypeCustomisation")
public class ObjTypeCustomisation {
	@ObfuscatedName("ak")
	@Export("recol")
	public short[] recol;
	@ObfuscatedName("ax")
	@Export("retex")
	public short[] retex;

	public ObjTypeCustomisation(int var1) {
		ItemComposition var2 = class214.ItemDefinition_get(var1);
		if (var2.hasRecolor()) {
			this.recol = new short[var2.recolorTo.length];
			System.arraycopy(var2.recolorTo, 0, this.recol, 0, this.recol.length);
		}

		if (var2.hasRetexture()) {
			this.retex = new short[var2.retextureTo.length];
			System.arraycopy(var2.retextureTo, 0, this.retex, 0, this.retex.length);
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "466779098"
	)
	static void method948() {
		Tiles.Tiles_minPlane = 99;
		World.Tiles_underlays = new short[4][104][104];
		VertexNormal.Tiles_overlays = new short[4][104][104];
		SecureRandomFuture.Tiles_shapes = new byte[4][104][104];
		class199.field1563 = new byte[4][104][104];
		UserComparator6.field1191 = new int[4][105][105];
		Tiles.field835 = new byte[4][105][105];
		class158.field1387 = new int[105][105];
		SecureRandomFuture.Tiles_hue = new int[104];
		class135.Tiles_saturation = new int[104];
		Tiles.Tiles_lightness = new int[104];
		WorldMapSection2.Tiles_hueMultiplier = new int[104];
		Script.field812 = new int[104];
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "841575506"
	)
	public static void method947() {
		InvDefinition.InvDefinition_cached.clear();
	}
}