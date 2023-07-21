import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ot")
@Implements("Language")
public class Language implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lot;"
	)
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lot;"
	)
	static final Language field3598;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lot;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lot;"
	)
	static final Language field3596;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lot;"
	)
	static final Language field3597;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lot;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lot;"
	)
	static final Language field3595;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "[Lot;"
	)
	public static final Language[] field3593;
	@ObfuscatedName("ah")
	@Export("Tiles_hueMultiplier")
	static int[] Tiles_hueMultiplier;
	@ObfuscatedName("az")
	final String field3601;
	@ObfuscatedName("av")
	@Export("language")
	final String language;
	@ObfuscatedName("ap")
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", ModeWhere.field3615, 0, "GB");
		field3598 = new Language("DE", "de", "German", ModeWhere.field3615, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", ModeWhere.field3615, 2, "FR");
		field3596 = new Language("PT", "pt", "Portuguese", ModeWhere.field3615, 3, "BR");
		field3597 = new Language("NL", "nl", "Dutch", ModeWhere.field3608, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", ModeWhere.field3608, 5, "ES");
		field3595 = new Language("ES_MX", "es-mx", "Spanish (Latin American)", ModeWhere.field3615, 6, "MX");
		Language[] var0 = method1939();
		field3593 = new Language[var0.length];
		Language[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			Language var3 = var1[var2];
			field3593[var3.id] = var3;
		}

	}

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lox;ILjava/lang/String;)V"
	)
	Language(String var1, String var2, String var3, ModeWhere var4, int var5, String var6) {
		this.field3601 = var1;
		this.language = var2;
		this.id = var5;
		if (var6 != null) {
			new Locale(var2.substring(0, 2), var6);
		} else {
			new Locale(var2.substring(0, 2));
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "57"
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

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)[Lot;",
		garbageValue = "2127004251"
	)
	static Language[] method1939() {
		return new Language[]{field3595, Language_EN, Language_ES, field3596, Language_FR, field3598, field3597};
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lnd;I)V",
		garbageValue = "1823199498"
	)
	public static void method1938(AbstractArchive var0) {
		DbRowType.field4105 = var0;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lfm;FZB)F",
		garbageValue = "53"
	)
	static float method1942(class130 var0, float var1, boolean var2) {
		float var3 = 0.0F;
		if (var0 != null && var0.method717() != 0) {
			float var4 = (float)var0.field1232[0].field1193;
			float var5 = (float)var0.field1232[var0.method717() - 1].field1193;
			float var6 = var5 - var4;
			if ((double)var6 == 0.0D) {
				return var0.field1232[0].field1192;
			} else {
				float var7 = 0.0F;
				if (var1 > var5) {
					var7 = (var1 - var5) / var6;
				} else {
					var7 = (var1 - var4) / var6;
				}

				double var8 = (double)((int)var7);
				float var10 = Math.abs((float)((double)var7 - var8));
				float var11 = var10 * var6;
				var8 = Math.abs(var8 + 1.0D);
				double var12 = var8 / 2.0D;
				double var14 = (double)((int)var12);
				var10 = (float)(var12 - var14);
				float var16;
				float var17;
				if (var2) {
					if (var0.field1231 == class128.field1216) {
						if ((double)var10 != 0.0D) {
							var11 += var4;
						} else {
							var11 = var5 - var11;
						}
					} else if (var0.field1231 != class128.field1215 && var0.field1231 != class128.field1214) {
						if (var0.field1231 == class128.field1218) {
							var11 = var4 - var1;
							var16 = var0.field1232[0].field1190;
							var17 = var0.field1232[0].field1189;
							var3 = var0.field1232[0].field1192;
							if (0.0D != (double)var16) {
								var3 -= var11 * var17 / var16;
							}

							return var3;
						}
					} else {
						var11 = var5 - var11;
					}
				} else if (var0.field1230 == class128.field1216) {
					if ((double)var10 != 0.0D) {
						var11 = var5 - var11;
					} else {
						var11 += var4;
					}
				} else if (var0.field1230 != class128.field1215 && var0.field1230 != class128.field1214) {
					if (var0.field1230 == class128.field1218) {
						var11 = var1 - var5;
						var16 = var0.field1232[var0.method717() - 1].field1191;
						var17 = var0.field1232[var0.method717() - 1].field1188;
						var3 = var0.field1232[var0.method717() - 1].field1192;
						if (0.0D != (double)var16) {
							var3 += var11 * var17 / var16;
						}

						return var3;
					}
				} else {
					var11 += var4;
				}

				var3 = ApproximateRouteStrategy.method348(var0, var11);
				float var18;
				if (var2 && var0.field1231 == class128.field1214) {
					var18 = var0.field1232[var0.method717() - 1].field1192 - var0.field1232[0].field1192;
					var3 = (float)((double)var3 - (double)var18 * var8);
				} else if (!var2 && var0.field1230 == class128.field1214) {
					var18 = var0.field1232[var0.method717() - 1].field1192 - var0.field1232[0].field1192;
					var3 = (float)((double)var3 + var8 * (double)var18);
				}

				return var3;
			}
		} else {
			return var3;
		}
	}

	@ObfuscatedName("mq")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "-18764"
	)
	static void method1943(int var0) {
		WorldMapRegion.tempMenuAction = new MenuAction();
		WorldMapRegion.tempMenuAction.param0 = Client.menuArguments1[var0];
		WorldMapRegion.tempMenuAction.param1 = Client.menuArguments2[var0];
		WorldMapRegion.tempMenuAction.opcode = Client.menuOpcodes[var0];
		WorldMapRegion.tempMenuAction.identifier = Client.menuIdentifiers[var0];
		WorldMapRegion.tempMenuAction.itemId = Client.menuItemIds[var0];
		WorldMapRegion.tempMenuAction.action = Client.menuActions[var0];
		WorldMapRegion.tempMenuAction.target = Client.menuTargets[var0];
	}

	@ObfuscatedName("nd")
	@ObfuscatedSignature(
		descriptor = "([BII)V",
		garbageValue = "-1791629405"
	)
	@Export("VorbisSample_setData")
	static void VorbisSample_setData(byte[] var0, int var1) {
		if (Client.randomDatData == null) {
			Client.randomDatData = new byte[24];
		}

		class410.writeRandomDat(var0, var1, Client.randomDatData, 0, 24);
	}
}
