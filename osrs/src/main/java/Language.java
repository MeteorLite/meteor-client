import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Locale;



@ObfuscatedName("of")
@Implements("Language")
public class Language implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lof;"
	)
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lof;"
	)
	static final Language field3646;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lof;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lof;"
	)
	static final Language field3647;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lof;"
	)
	static final Language field3645;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lof;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lof;"
	)
	static final Language field3644;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "[Lof;"
	)
	static final Language[] field3648;
	@ObfuscatedName("aw")
	@Export("canvasWidth")
	public static int canvasWidth;
	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		descriptor = "Loh;"
	)
	static Archive field3643;
	@ObfuscatedName("gr")
	static int field3642;
	@ObfuscatedName("ac")
	final String field3650;
	@ObfuscatedName("al")
	@Export("language")
	final String language;
	@ObfuscatedName("az")
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", ModeWhere.field3661, 0, "GB");
		field3646 = new Language("DE", "de", "German", ModeWhere.field3661, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", ModeWhere.field3661, 2, "FR");
		field3647 = new Language("PT", "pt", "Portuguese", ModeWhere.field3661, 3, "BR");
		field3645 = new Language("NL", "nl", "Dutch", ModeWhere.field3658, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", ModeWhere.field3658, 5, "ES");
		field3644 = new Language("ES_MX", "es-mx", "Spanish (Latin American)", ModeWhere.field3661, 6, "MX");
		Language[] var0 = method1992();
		field3648 = new Language[var0.length];
		Language[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			Language var3 = var1[var2];
			field3648[var3.id] = var3;
		}

	}

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lok;ILjava/lang/String;)V"
	)
	Language(String var1, String var2, String var3, ModeWhere var4, int var5, String var6) {
		this.field3650 = var1;
		this.language = var2;
		this.id = var5;
		if (var6 != null) {
			new Locale(var2.substring(0, 2), var6);
		} else {
			new Locale(var2.substring(0, 2));
		}

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

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "1714564751"
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

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)[Lfa;",
		garbageValue = "-1038072000"
	)
	static class132[] method1991() {
		return new class132[]{class132.field1279, class132.field1276, class132.field1278, class132.field1277, class132.field1275, class132.field1280};
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)[Lof;",
		garbageValue = "0"
	)
	static Language[] method1992() {
		return new Language[]{field3647, field3644, Language_FR, Language_EN, field3645, field3646, Language_ES};
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lfm;FFFFFFFFB)V",
		garbageValue = "1"
	)
	static void method1997(class131 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
		if (var0 != null) {
			float var9 = var4 - var1;
			if ((double)var9 != 0.0D) {
				float var10 = var2 - var1;
				float var11 = var3 - var1;
				float[] var12 = new float[]{var10 / var9, var11 / var9};
				var0.field1255 = var12[0] == 0.33333334F && 0.6666667F == var12[1];
				float var13 = var12[0];
				float var14 = var12[1];
				if ((double)var12[0] < 0.0D) {
					var12[0] = 0.0F;
				}

				if ((double)var12[1] > 1.0D) {
					var12[1] = 1.0F;
				}

				if ((double)var12[0] > 1.0D || var12[1] < -1.0F) {
					var12[1] = 1.0F - var12[1];
					if (var12[0] < 0.0F) {
						var12[0] = 0.0F;
					}

					if (var12[1] < 0.0F) {
						var12[1] = 0.0F;
					}

					if (var12[0] > 1.0F || var12[1] > 1.0F) {
						float var15 = (float)(1.0D + ((double)var12[1] - 2.0D) * (double)var12[1] + (double)(var12[0] * (var12[1] + (var12[0] - 2.0F))));
						if (var15 + class127.field1219 > 0.0F) {
							if (class127.field1219 + var12[0] < 1.3333334F) {
								float var16 = var12[0] - 2.0F;
								float var17 = var12[0] - 1.0F;
								float var18 = (float)Math.sqrt((double)(var16 * var16 - var17 * var17 * 4.0F));
								float var19 = (-var16 + var18) * 0.5F;
								if (var12[1] + class127.field1219 > var19) {
									var12[1] = var19 - class127.field1219;
								} else {
									var19 = 0.5F * (-var16 - var18);
									if (var12[1] < class127.field1219 + var19) {
										var12[1] = class127.field1219 + var19;
									}
								}
							} else {
								var12[0] = 1.3333334F - class127.field1219;
								var12[1] = 0.33333334F - class127.field1219;
							}
						}
					}

					var12[1] = 1.0F - var12[1];
				}

				if (var12[0] != var13) {
					var2 = var12[0] * var9 + var1;
					if (0.0D != (double)var13) {
						var6 = var5 + var12[0] * (var6 - var5) / var13;
					}
				}

				if (var12[1] != var14) {
					float var10000 = var1 + var12[1] * var9;
					if ((double)var14 != 1.0D) {
						var7 = (float)((double)var8 - (1.0D - (double)var12[1]) * (double)(var8 - var7) / (1.0D - (double)var14));
					}
				}

				var0.field1259 = var1;
				var0.field1260 = var4;
				class145.method767(0.0F, var12[0], var12[1], 1.0F, var0);
				Canvas.method90(var5, var6, var7, var8, var0);
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)Lof;",
		garbageValue = "15"
	)
	public static Language method1995(int var0) {
		return var0 >= 0 && var0 < field3648.length ? field3648[var0] : null;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Lcr;",
		garbageValue = "458832274"
	)
	@Export("worldListStart")
	static World worldListStart() {
		World.World_listCount = 0;
		return WorldMapData_0.getNextWorldListWorld();
	}
}