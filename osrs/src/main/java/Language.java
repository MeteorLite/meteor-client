import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
@Implements("Language")
public class Language implements MouseWheel {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Llj;"
	)
	@Export("Language_EN")
	public static final Language Language_EN;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Llj;"
	)
	static final Language field4134;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Llj;"
	)
	@Export("Language_FR")
	public static final Language Language_FR;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Llj;"
	)
	static final Language field4136;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Llj;"
	)
	static final Language field4137;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Llj;"
	)
	@Export("Language_ES")
	public static final Language Language_ES;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "Llj;"
	)
	static final Language field4135;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "[Llj;"
	)
	public static final Language[] field4143;
	@ObfuscatedName("jh")
	@ObfuscatedGetter(
		intValue = -1837809733
	)
	@Export("oculusOrbFocalPointY")
	static int oculusOrbFocalPointY;
	@ObfuscatedName("q")
	final String field4140;
	@ObfuscatedName("m")
	@Export("language")
	final String language;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1893856257
	)
	@Export("id")
	final int id;

	static {
		Language_EN = new Language("EN", "en", "English", ModeWhere.field4158, 0, "GB");
		field4134 = new Language("DE", "de", "German", ModeWhere.field4158, 1, "DE");
		Language_FR = new Language("FR", "fr", "French", ModeWhere.field4158, 2, "FR");
		field4136 = new Language("PT", "pt", "Portuguese", ModeWhere.field4158, 3, "BR");
		field4137 = new Language("NL", "nl", "Dutch", ModeWhere.field4152, 4, "NL");
		Language_ES = new Language("ES", "es", "Spanish", ModeWhere.field4152, 5, "ES");
		field4135 = new Language("ES_MX", "es-mx", "Spanish (Latin American)", ModeWhere.field4158, 6, "MX");
		Language[] var0 = new Language[]{field4136, field4137, Language_ES, field4135, Language_EN, Language_FR, field4134};
		field4143 = new Language[var0.length];
		Language[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			Language var4 = var2[var3];
			if (field4143[var4.id] != null) {
				throw new IllegalStateException();
			}

			field4143[var4.id] = var4;
		}

	}

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Llu;ILjava/lang/String;)V"
	)
	Language(String var1, String var2, String var3, ModeWhere var4, int var5, String var6) {
		this.field4140 = var1;
		this.language = var2;
		this.id = var5;
		if (var6 != null) {
			new Locale(var2.substring(0, 2), var6);
		} else {
			new Locale(var2.substring(0, 2));
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-1335488063"
	)
	@Export("getLanguage")
	String getLanguage() {
		return this.language;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	public String toString() {
		return this.getLanguage().toLowerCase(Locale.ENGLISH);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)J",
		garbageValue = "1223672293"
	)
	public static final synchronized long method6232() {
		long var0 = System.currentTimeMillis();
		if (var0 < class270.field3201) {
			class345.field4197 += class270.field3201 - var0;
		}

		class270.field3201 = var0;
		return class345.field4197 + var0;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZI)I",
		garbageValue = "1066310043"
	)
	static int method6235(int var0, Script var1, boolean var2) {
		if (var0 < 1000) {
			return KeyHandler.method368(var0, var1, var2);
		} else if (var0 < 1100) {
			return class296.method5887(var0, var1, var2);
		} else if (var0 < 1200) {
			return class102.method2710(var0, var1, var2);
		} else if (var0 < 1300) {
			return Frames.method4473(var0, var1, var2);
		} else if (var0 < 1400) {
			return BufferedFile.method7715(var0, var1, var2);
		} else if (var0 < 1500) {
			return class361.method6736(var0, var1, var2);
		} else if (var0 < 1600) {
			return class1.method12(var0, var1, var2);
		} else if (var0 < 1700) {
			return class300.method5916(var0, var1, var2);
		} else if (var0 < 1800) {
			return InterfaceParent.method2238(var0, var1, var2);
		} else if (var0 < 1900) {
			return class127.method2992(var0, var1, var2);
		} else if (var0 < 2000) {
			return HealthBarUpdate.method2353(var0, var1, var2);
		} else if (var0 < 2100) {
			return class296.method5887(var0, var1, var2);
		} else if (var0 < 2200) {
			return class102.method2710(var0, var1, var2);
		} else if (var0 < 2300) {
			return Frames.method4473(var0, var1, var2);
		} else if (var0 < 2400) {
			return BufferedFile.method7715(var0, var1, var2);
		} else if (var0 < 2500) {
			return class361.method6736(var0, var1, var2);
		} else if (var0 < 2600) {
			return WorldMapSection0.method5068(var0, var1, var2);
		} else if (var0 < 2700) {
			return SequenceDefinition.method3977(var0, var1, var2);
		} else if (var0 < 2800) {
			return VarcInt.method3560(var0, var1, var2);
		} else if (var0 < 2900) {
			return class360.method6733(var0, var1, var2);
		} else if (var0 < 3000) {
			return HealthBarUpdate.method2353(var0, var1, var2);
		} else if (var0 < 3200) {
			return class343.method6445(var0, var1, var2);
		} else if (var0 < 3300) {
			return UserComparator9.method2772(var0, var1, var2);
		} else if (var0 < 3400) {
			return class102.method2709(var0, var1, var2);
		} else if (var0 < 3500) {
			return class16.method215(var0, var1, var2);
		} else if (var0 < 3600) {
			return ClanChannelMember.method3025(var0, var1, var2);
		} else if (var0 < 3700) {
			return class303.method5917(var0, var1, var2);
		} else if (var0 < 3800) {
			return UserComparator10.method2782(var0, var1, var2);
		} else if (var0 < 3900) {
			return MouseHandler.method603(var0, var1, var2);
		} else if (var0 < 4000) {
			return class361.method6735(var0, var1, var2);
		} else if (var0 < 4100) {
			return class129.method3013(var0, var1, var2);
		} else if (var0 < 4200) {
			return class155.method3341(var0, var1, var2);
		} else if (var0 < 4300) {
			return ItemLayer.method4039(var0, var1, var2);
		} else if (var0 < 5100) {
			return class271.method5375(var0, var1, var2);
		} else if (var0 < 5400) {
			return InterfaceParent.method2239(var0, var1, var2);
		} else if (var0 < 5600) {
			return WorldMapIcon_1.method4702(var0, var1, var2);
		} else if (var0 < 5700) {
			return class229.method5006(var0, var1, var2);
		} else if (var0 < 6300) {
			return class28.method414(var0, var1, var2);
		} else if (var0 < 6600) {
			return class260.method5340(var0, var1, var2);
		} else if (var0 < 6700) {
			return class130.method3022(var0, var1, var2);
		} else if (var0 < 6800) {
			return class13.method180(var0, var1, var2);
		} else if (var0 < 6900) {
			return class434.method7790(var0, var1, var2);
		} else if (var0 < 7000) {
			return class78.method2235(var0, var1, var2);
		} else if (var0 < 7100) {
			return class194.method4038(var0, var1, var2);
		} else if (var0 < 7200) {
			return PlayerType.method5943(var0, var1, var2);
		} else if (var0 < 7300) {
			return SecureRandomFuture.method2103(var0, var1, var2);
		} else if (var0 < 7500) {
			return SecureRandomCallable.method2206(var0, var1, var2);
		} else if (var0 < 7600) {
			return class119.method2911(var0, var1, var2);
		} else {
			return var0 < 7700 ? class241.method5125(var0, var1, var2) : 2;
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "([BIILgp;[Lgj;I)V",
		garbageValue = "-1340343543"
	)
	static final void method6230(byte[] var0, int var1, int var2, Scene var3, CollisionMap[] var4) {
		Buffer var5 = new Buffer(var0);
		int var6 = -1;

		while (true) {
			int var7 = var5.method8003();
			if (var7 == 0) {
				return;
			}

			var6 += var7;
			int var8 = 0;

			while (true) {
				int var9 = var5.readUShortSmart();
				if (var9 == 0) {
					break;
				}

				var8 += var9 - 1;
				int var10 = var8 & 63;
				int var11 = var8 >> 6 & 63;
				int var12 = var8 >> 12;
				int var13 = var5.readUnsignedByte();
				int var14 = var13 >> 2;
				int var15 = var13 & 3;
				int var16 = var11 + var1;
				int var17 = var10 + var2;
				if (var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
					int var18 = var12;
					if ((Tiles.Tiles_renderFlags[1][var16][var17] & 2) == 2) {
						var18 = var12 - 1;
					}

					CollisionMap var19 = null;
					if (var18 >= 0) {
						var19 = var4[var18];
					}

					WorldMapAreaData.addObjects(var12, var16, var17, var6, var15, var14, var3, var19);
				}
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "253206918"
	)
	@Export("hslToRgb")
	static final int hslToRgb(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}
}
