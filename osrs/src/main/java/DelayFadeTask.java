import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pn")
public class DelayFadeTask extends SongTask {
	@ObfuscatedName("or")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	static Widget field3700;
	@ObfuscatedName("aw")
	long field3703;
	@ObfuscatedName("ay")
	int field3702;
	@ObfuscatedName("ar")
	boolean field3701;

	@ObfuscatedSignature(
		descriptor = "(Lpp;I)V"
	)
	public DelayFadeTask(SongTask var1, int var2) {
		super(var1);
		this.field3701 = false;
		this.field3702 = var2;
		super.field3712 = "DelayFadeTask";
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "994462530"
	)
	public boolean vmethod2107(int var1) {
		if (!this.field3701) {
			this.field3703 = (long)var1;
			this.field3701 = true;
		}

		return (long)var1 >= this.field3703 + (long)this.field3702;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lsi;I)I",
		garbageValue = "1563471733"
	)
	static final int method2089(LoginType var0) {
		if (var0 == null) {
			return 12;
		} else {
			switch(var0.field4064) {
			case 8:
				return 20;
			default:
				return 12;
			}
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "([BIII)Ljava/lang/String;",
		garbageValue = "1912660533"
	)
	public static String method2088(byte[] var0, int var1, int var2) {
		char[] var3 = new char[var2];
		int var4 = 0;
		int var5 = var1;

		int var8;
		for (int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
			int var7 = var0[var5++] & 255;
			if (var7 < 128) {
				if (var7 == 0) {
					var8 = 65533;
				} else {
					var8 = var7;
				}
			} else if (var7 < 192) {
				var8 = 65533;
			} else if (var7 < 224) {
				if (var5 < var6 && (var0[var5] & 192) == 128) {
					var8 = (var7 & 31) << 6 | var0[var5++] & 63;
					if (var8 < 128) {
						var8 = 65533;
					}
				} else {
					var8 = 65533;
				}
			} else if (var7 < 240) {
				if (var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
					var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
					if (var8 < 2048) {
						var8 = 65533;
					}
				} else {
					var8 = 65533;
				}
			} else if (var7 < 248) {
				if (var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
					var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
					if (var8 >= 65536 && var8 <= 1114111) {
						var8 = 65533;
					} else {
						var8 = 65533;
					}
				} else {
					var8 = 65533;
				}
			} else {
				var8 = 65533;
			}
		}

		return new String(var3, 0, var4);
	}

	@ObfuscatedName("nq")
	@ObfuscatedSignature(
		descriptor = "(Lty;II)V",
		garbageValue = "-2009704277"
	)
	static void method2091(Buffer var0, int var1) {
		Language.VorbisSample_setData(var0.array, var1);
		WorldMapSectionType.method1482(var0, var1);
	}
}
