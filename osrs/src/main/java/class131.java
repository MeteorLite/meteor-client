import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;
import java.io.IOException;

@ObfuscatedName("fm")
public class class131 {
	@ObfuscatedName("at")
	boolean field1254;
	@ObfuscatedName("ah")
	boolean field1252;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lep;"
	)
	class129 field1257;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lep;"
	)
	class129 field1256;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "[Leq;"
	)
	class126[] field1258;
	@ObfuscatedName("au")
	boolean field1255;
	@ObfuscatedName("aa")
	float field1259;
	@ObfuscatedName("ac")
	float field1260;
	@ObfuscatedName("al")
	float field1263;
	@ObfuscatedName("az")
	float field1270;
	@ObfuscatedName("ap")
	float field1265;
	@ObfuscatedName("av")
	float field1267;
	@ObfuscatedName("ax")
	float field1268;
	@ObfuscatedName("as")
	float field1266;
	@ObfuscatedName("ay")
	float field1269;
	@ObfuscatedName("ak")
	float field1262;
	@ObfuscatedName("aj")
	boolean field1253;
	@ObfuscatedName("am")
	int field1273;
	@ObfuscatedName("aq")
	float[] field1271;
	@ObfuscatedName("ai")
	int field1272;
	@ObfuscatedName("aw")
	int field1274;
	@ObfuscatedName("ae")
	float field1261;
	@ObfuscatedName("an")
	float field1264;

	class131() {
		this.field1253 = true;
		this.field1273 = 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;II)I",
		garbageValue = "-979400309"
	)
	int method714(Buffer var1, int var2) {
		int var3 = var1.readUnsignedShort();
		class311.method1646(var1.readUnsignedByte());
		this.field1257 = class72.method432(var1.readUnsignedByte());
		this.field1256 = class72.method432(var1.readUnsignedByte());
		this.field1254 = var1.readUnsignedByte() != 0;
		this.field1258 = new class126[var3];
		class126 var4 = null;

		for (int var5 = 0; var5 < var3; ++var5) {
			class126 var6 = new class126();
			var6.method691(var1, var2);
			this.field1258[var5] = var6;
			if (var4 != null) {
				var4.field1211 = var6;
			}

			var4 = var6;
		}

		return var3;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2128707334"
	)
	void method715() {
		this.field1272 = this.field1258[0].field1217;
		this.field1274 = this.field1258[this.method722() - 1].field1217;
		this.field1271 = new float[this.method719() + 1];

		for (int var1 = this.method717(); var1 <= this.method718(); ++var1) {
			this.field1271[var1 - this.method717()] = class404.method2045(this, (float)var1);
		}

		this.field1258 = null;
		this.field1261 = class404.method2045(this, (float)(this.method717() - 1));
		this.field1264 = class404.method2045(this, (float)(this.method718() + 1));
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)F",
		garbageValue = "-1688546039"
	)
	public float method716(int var1) {
		if (var1 < this.method717()) {
			return this.field1261;
		} else {
			return var1 > this.method718() ? this.field1264 : this.field1271[var1 - this.method717()];
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "124775939"
	)
	int method717() {
		return this.field1272;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "17"
	)
	int method718() {
		return this.field1274;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "71"
	)
	int method719() {
		return this.method718() - this.method717();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(FI)I",
		garbageValue = "2092037965"
	)
	int method720(float var1) {
		if (this.field1273 < 0 || (float)this.field1258[this.field1273].field1217 > var1 || this.field1258[this.field1273].field1211 != null && (float)this.field1258[this.field1273].field1211.field1217 <= var1) {
			if (var1 >= (float)this.method717() && var1 <= (float)this.method718()) {
				int var2 = this.method722();
				int var3 = this.field1273;
				if (var2 > 0) {
					int var4 = 0;
					int var5 = var2 - 1;

					do {
						int var6 = var5 + var4 >> 1;
						if (var1 < (float)this.field1258[var6].field1217) {
							if (var1 > (float)this.field1258[var6 - 1].field1217) {
								var3 = var6 - 1;
								break;
							}

							var5 = var6 - 1;
						} else {
							if (var1 <= (float)this.field1258[var6].field1217) {
								var3 = var6;
								break;
							}

							if (var1 < (float)this.field1258[var6 + 1].field1217) {
								var3 = var6;
								break;
							}

							var4 = var6 + 1;
						}
					} while(var4 <= var5);
				}

				if (var3 != this.field1273) {
					this.field1273 = var3;
					this.field1253 = true;
				}

				return this.field1273;
			} else {
				return -1;
			}
		} else {
			return this.field1273;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(FI)Leq;",
		garbageValue = "-1779778637"
	)
	class126 method721(float var1) {
		int var2 = this.method720(var1);
		return var2 >= 0 && var2 < this.field1258.length ? this.field1258[var2] : null;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1866632408"
	)
	int method722() {
		return this.field1258 == null ? 0 : this.field1258.length;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;ZI)Lto;",
		garbageValue = "-575413864"
	)
	@Export("getPreferencesFile")
	public static AccessFile getPreferencesFile(String var0, String var1, boolean var2) {
		File var3 = new File(JagexCache.cacheDir, "preferences" + var0 + ".dat");
		if (var3.exists()) {
			try {
				AccessFile var10 = new AccessFile(var3, "rw", 10000L);
				return var10;
			} catch (IOException var9) {
			}
		}

		String var4 = "";
		if (class521.cacheGamebuild == 33) {
			var4 = "_rc";
		} else if (class521.cacheGamebuild == 34) {
			var4 = "_wip";
		}

		File var5 = new File(Login.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
		AccessFile var6;
		if (!var2 && var5.exists()) {
			try {
				var6 = new AccessFile(var5, "rw", 10000L);
				return var6;
			} catch (IOException var8) {
			}
		}

		try {
			var6 = new AccessFile(var3, "rw", 10000L);
			return var6;
		} catch (IOException var7) {
			throw new RuntimeException();
		}
	}
}