import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public abstract class class159 extends Node {
	@ObfuscatedName("ax")
	static int[] field1403;

	class159() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "-43"
	)
	@Export("vmethod3238")
	abstract void vmethod3238(Buffer var1);

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lgh;I)V",
		garbageValue = "-2132107044"
	)
	@Export("vmethod3239")
	abstract void vmethod3239(ClanChannel var1);

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1889169776"
	)
	static int method837(int var0) {
		return (int)((Math.log((double)var0) / Interpreter.field715 - 7.0D) * 256.0D);
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZB)I",
		garbageValue = "43"
	)
	static int method838(int var0, Script var1, boolean var2) {
		return 2;
	}

	@ObfuscatedName("hy")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-22255"
	)
	static final void method836() {
		class405.method2095();
		ArchiveDiskActionHandler.method1849();
		KitDefinition.KitDefinition_cached.clear();
		ObjectComposition.ObjectDefinition_cached.clear();
		ObjectComposition.ObjectDefinition_cachedModelData.clear();
		ObjectComposition.ObjectDefinition_cachedEntities.clear();
		ObjectComposition.ObjectDefinition_cachedModels.clear();
		UserComparator3.method676();
		GrandExchangeOfferOwnWorldComparator.method355();
		class467.method2324();
		InvDefinition.method929();
		VarbitComposition.VarbitDefinition_cached.clear();
		VarpDefinition.VarpDefinition_cached.clear();
		class293.HitSplatDefinition_cachedSprites.method2458();
		class344.HitSplatDefinition_cached.method2458();
		HitSplatDefinition.HitSplatDefinition_cached.clear();
		HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
		HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
		class503.method2471();
		class134.method730();
		ParamComposition.ParamDefinition_cached.clear();
		WorldMapElement.WorldMapElement_cachedSprites.clear();
		Message.method347();
		DbRowType.DBRowType_cache.clear();
		Client.Widget_cachedModels.clear();
		Client.Widget_cachedFonts.clear();
		PlayerComposition.PlayerAppearance_cachedModels.clear();
		class59.method322();
		((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).clear();
		Script.Script_cached.clear();
		Client.archive5.method2150();
		class151.field1352.clearFiles();
		TileItem.archive7.clearFiles();
		class253.archive4.clearFiles();
		class149.field1340.clearFiles();
		Canvas.archive9.clearFiles();
		class13.archive6.clearFiles();
		class7.archive11.clearFiles();
		class386.archive8.clearFiles();
		class148.field1335.clearFiles();
		class131.archive10.clearFiles();
		GrandExchangeOfferOwnWorldComparator.field358.clearFiles();
		class126.archive12.clearFiles();
		class176.field1459.clearFiles();
	}
}
