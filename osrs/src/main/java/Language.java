import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Locale;



@ObfuscatedName("on")
@Implements("Language")
public class Language implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	static final Language field3606;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	static final Language field3607;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	static final Language field3605;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	static final Language field3608;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "[Lon;"
	)
	static final Language[] field3609;
	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("Widget_spritesArchive")
	public static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "Lsl;"
	)
	@Export("loginType")
	static LoginType loginType;
	@ObfuscatedName("ap")
	final String field3612;
	@ObfuscatedName("aa")
	@Export("language")
	final String language;
	@ObfuscatedName("af")
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", ModeWhere.field3626, 0, "GB");
		field3606 = new Language("DE", "de", "German", ModeWhere.field3626, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", ModeWhere.field3626, 2, "FR");
		field3607 = new Language("PT", "pt", "Portuguese", ModeWhere.field3626, 3, "BR");
		field3605 = new Language("NL", "nl", "Dutch", ModeWhere.field3625, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", ModeWhere.field3625, 5, "ES");
		field3608 = new Language("ES_MX", "es-mx", "Spanish (Latin American)", ModeWhere.field3626, 6, "MX");
		Language[] var0 = method1972();
		field3609 = new Language[var0.length];
		Language[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			Language var3 = var1[var2];
			field3609[var3.id] = var3;
		}

	}

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Loe;ILjava/lang/String;)V"
	)
	Language(String var1, String var2, String var3, ModeWhere var4, int var5, String var6) {
		this.field3612 = var1;
		this.language = var2;
		this.id = var5;
		if (var6 != null) {
			new Locale(var2.substring(0, 2), var6);
		} else {
			new Locale(var2.substring(0, 2));
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "82"
	)
	@Export("getLanguage")
	String getLanguage() {
		return this.language;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[Lon;",
		garbageValue = "-905836833"
	)
	static Language[] method1972() {
		return new Language[]{Language_ES, field3606, Language_FR, field3608, field3605, Language_EN, field3607};
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "66381547"
	)
	static void method1973() {
		Tiles.Tiles_minPlane = 99;
		Tiles.Tiles_underlays = new short[4][104][104];
		class227.Tiles_overlays = new short[4][104][104];
		class172.Tiles_shapes = new byte[4][104][104];
		ModelData0.field2282 = new byte[4][104][104];
		BufferedNetSocket.field3820 = new int[4][105][105];
		MoveSpeed.field1924 = new byte[4][105][105];
		class162.field1419 = new int[105][105];
		Fonts.Tiles_hue = new int[104];
		class466.Tiles_saturation = new int[104];
		Tiles.Tiles_lightness = new int[104];
		class128.Tiles_hueMultiplier = new int[104];
		Interpreter.field710 = new int[104];
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lon;",
		garbageValue = "-695535703"
	)
	public static Language method1976(int var0) {
		return var0 >= 0 && var0 < field3609.length ? field3609[var0] : null;
	}

	@ObfuscatedName("lf")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIB)V",
		garbageValue = "56"
	)
	static final void method1977(int var0, int var1, int var2, int var3, int var4, int var5) {
		int var6 = var2 - var0;
		int var7 = var3 - var1;
		int var8 = var6 >= 0 ? var6 : -var6;
		int var9 = var7 >= 0 ? var7 : -var7;
		int var10 = var8;
		if (var8 < var9) {
			var10 = var9;
		}

		if (var10 != 0) {
			int var11 = (var6 << 16) / var10;
			int var12 = (var7 << 16) / var10;
			if (var12 <= var11) {
				var11 = -var11;
			} else {
				var12 = -var12;
			}

			int var13 = var5 * var12 >> 17;
			int var14 = var5 * var12 + 1 >> 17;
			int var15 = var5 * var11 >> 17;
			int var16 = var5 * var11 + 1 >> 17;
			var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
			var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
			int var17 = var0 + var13;
			int var18 = var0 - var14;
			int var19 = var0 + var6 - var14;
			int var20 = var0 + var13 + var6;
			int var21 = var15 + var1;
			int var22 = var1 - var16;
			int var23 = var7 + var1 - var16;
			int var24 = var15 + var7 + var1;
			Rasterizer3D.method1203(var17, var18, var19);
			Rasterizer3D.method1205(var21, var22, var23, var17, var18, var19, 0.0F, 0.0F, 0.0F, var4);
			Rasterizer3D.method1203(var17, var19, var20);
			Rasterizer3D.method1205(var21, var23, var24, var17, var19, var20, 0.0F, 0.0F, 0.0F, var4);
		}
	}
}