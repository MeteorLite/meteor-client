import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
public class class271 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lkf;"
	)
	static final class271 field2456;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lkf;"
	)
	static final class271 field2455;
	@ObfuscatedName("ao")
	final int field2457;

	static {
		field2456 = new class271(0);
		field2455 = new class271(1);
	}

	class271(int var1) {
		this.field2457 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[Lio;",
		garbageValue = "-681739410"
	)
	static class214[] method1541() {
		return new class214[]{class214.field1898, class214.field1904, class214.field1902, class214.field1900, class214.field1899, class214.field1901, class214.field1903};
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
		garbageValue = "2076822771"
	)
	public static String method1540(CharSequence[] var0, int var1, int var2) {
		if (var2 == 0) {
			return "";
		} else if (var2 == 1) {
			CharSequence var3 = var0[var1];
			return var3 == null ? "null" : var3.toString();
		} else {
			int var8 = var2 + var1;
			int var4 = 0;

			for (int var5 = var1; var5 < var8; ++var5) {
				CharSequence var6 = var0[var5];
				if (var6 == null) {
					var4 += 4;
				} else {
					var4 += var6.length();
				}
			}

			StringBuilder var9 = new StringBuilder(var4);

			for (int var10 = var1; var10 < var8; ++var10) {
				CharSequence var7 = var0[var10];
				if (var7 == null) {
					var9.append("null");
				} else {
					var9.append(var7);
				}
			}

			return var9.toString();
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)Lhu;",
		garbageValue = "1432274466"
	)
	@Export("getEnum")
	public static EnumComposition getEnum(int var0) {
		EnumComposition var1 = (EnumComposition)EnumComposition.EnumDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = EnumComposition.EnumDefinition_archive.takeFile(8, var0);
			var1 = new EnumComposition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			EnumComposition.EnumDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("kb")
	@ObfuscatedSignature(
		descriptor = "(ZLto;I)V",
		garbageValue = "1816945767"
	)
	@Export("loadRegions")
	static final void loadRegions(boolean var0, PacketBuffer var1) {
		Client.isInInstance = var0;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		if (!Client.isInInstance) {
			int var2 = var1.readUnsignedShort();
			var3 = var1.method2587();
			var4 = var1.readUnsignedShort();
			RunException.xteaKeys = new int[var4][4];

			for (var5 = 0; var5 < var4; ++var5) {
				for (var6 = 0; var6 < 4; ++var6) {
					RunException.xteaKeys[var5][var6] = var1.readInt();
				}
			}

			class191.regions = new int[var4];
			class59.regionMapArchiveIds = new int[var4];
			ObjTypeCustomisation.regionLandArchiveIds = new int[var4];
			UserComparator5.regionLandArchives = new byte[var4][];
			class197.regionMapArchives = new byte[var4][];
			var4 = 0;

			for (var5 = (var2 - 6) / 8; var5 <= (var2 + 6) / 8; ++var5) {
				for (var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
					var7 = var6 + (var5 << 8);
					class191.regions[var4] = var7;
					class59.regionMapArchiveIds[var4] = class499.archive9.getGroupId("m" + var5 + "_" + var6);
					ObjTypeCustomisation.regionLandArchiveIds[var4] = class499.archive9.getGroupId("l" + var5 + "_" + var6);
					++var4;
				}
			}

			class316.method1698(var2, var3, true);
		} else {
			boolean var15 = var1.readUnsignedByte() == 1;
			var3 = var1.readUnsignedShort();
			var4 = var1.readUnsignedShort();
			var5 = var1.readUnsignedShort();
			var1.importIndex();

			int var8;
			int var9;
			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = var1.readBits(1);
						if (var9 == 1) {
							Client.instanceChunkTemplates[var6][var7][var8] = var1.readBits(26);
						} else {
							Client.instanceChunkTemplates[var6][var7][var8] = -1;
						}
					}
				}
			}

			var1.exportIndex();
			RunException.xteaKeys = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					RunException.xteaKeys[var6][var7] = var1.readInt();
				}
			}

			class191.regions = new int[var5];
			class59.regionMapArchiveIds = new int[var5];
			ObjTypeCustomisation.regionLandArchiveIds = new int[var5];
			UserComparator5.regionLandArchives = new byte[var5][];
			class197.regionMapArchives = new byte[var5][];
			var5 = 0;

			for (var6 = 0; var6 < 4; ++var6) {
				for (var7 = 0; var7 < 13; ++var7) {
					for (var8 = 0; var8 < 13; ++var8) {
						var9 = Client.instanceChunkTemplates[var6][var7][var8];
						if (var9 != -1) {
							int var10 = var9 >> 14 & 1023;
							int var11 = var9 >> 3 & 2047;
							int var12 = (var10 / 8 << 8) + var11 / 8;

							int var13;
							for (var13 = 0; var13 < var5; ++var13) {
								if (class191.regions[var13] == var12) {
									var12 = -1;
									break;
								}
							}

							if (var12 != -1) {
								class191.regions[var5] = var12;
								var13 = var12 >> 8 & 255;
								int var14 = var12 & 255;
								class59.regionMapArchiveIds[var5] = class499.archive9.getGroupId("m" + var13 + "_" + var14);
								ObjTypeCustomisation.regionLandArchiveIds[var5] = class499.archive9.getGroupId("l" + var13 + "_" + var14);
								++var5;
							}
						}
					}
				}
			}

			class316.method1698(var4, var3, !var15);
		}

	}
}