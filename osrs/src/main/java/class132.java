import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class132 {
	@ObfuscatedName("ac")
	boolean field1233;
	@ObfuscatedName("al")
	boolean field1235;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lfj;"
	)
	class130 field1238;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lfj;"
	)
	class130 field1239;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "[Lef;"
	)
	class127[] field1237;
	@ObfuscatedName("ah")
	boolean field1234;
	@ObfuscatedName("ar")
	float field1247;
	@ObfuscatedName("ab")
	float field1241;
	@ObfuscatedName("am")
	float field1244;
	@ObfuscatedName("av")
	float field1249;
	@ObfuscatedName("ag")
	float field1242;
	@ObfuscatedName("aa")
	float field1240;
	@ObfuscatedName("ap")
	float field1245;
	@ObfuscatedName("ay")
	float field1250;
	@ObfuscatedName("as")
	float field1248;
	@ObfuscatedName("aj")
	float field1243;
	@ObfuscatedName("an")
	boolean field1236;
	@ObfuscatedName("au")
	int field1254;
	@ObfuscatedName("ai")
	float[] field1252;
	@ObfuscatedName("ae")
	int field1253;
	@ObfuscatedName("aw")
	int field1255;
	@ObfuscatedName("aq")
	float field1246;
	@ObfuscatedName("az")
	float field1251;

	class132() {
		this.field1236 = true;
		this.field1254 = 0;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;II)I",
		garbageValue = "-1968596819"
	)
	int method709(Buffer var1, int var2) {
		int var3 = var1.readUnsignedShort();
		AbstractByteArrayCopier.method1886(var1.readUnsignedByte());
		int var5 = var1.readUnsignedByte();
		class130 var6 = (class130)SequenceDefinition.findEnumerated(class186.method950(), var5);
		if (var6 == null) {
			var6 = class130.field1221;
		}

		this.field1238 = var6;
		int var7 = var1.readUnsignedByte();
		class130 var8 = (class130)SequenceDefinition.findEnumerated(class186.method950(), var7);
		if (var8 == null) {
			var8 = class130.field1221;
		}

		this.field1239 = var8;
		this.field1233 = var1.readUnsignedByte() != 0;
		this.field1237 = new class127[var3];
		class127 var11 = null;

		for (int var9 = 0; var9 < var3; ++var9) {
			class127 var10 = new class127();
			var10.method691(var1, var2);
			this.field1237[var9] = var10;
			if (var11 != null) {
				var11.field1194 = var10;
			}

			var11 = var10;
		}

		return var3;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "25701091"
	)
	void method710() {
		this.field1253 = this.field1237[0].field1200;
		this.field1255 = this.field1237[this.method717() - 1].field1200;
		this.field1252 = new float[this.method714() + 1];

		for (int var1 = this.method712(); var1 <= this.method713(); ++var1) {
			this.field1252[var1 - this.method712()] = class183.method938(this, (float)var1);
		}

		this.field1237 = null;
		this.field1246 = class183.method938(this, (float)(this.method712() - 1));
		this.field1251 = class183.method938(this, (float)(this.method713() + 1));
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)F",
		garbageValue = "-1862749488"
	)
	public float method711(int var1) {
		if (var1 < this.method712()) {
			return this.field1246;
		} else {
			return var1 > this.method713() ? this.field1251 : this.field1252[var1 - this.method712()];
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "103"
	)
	int method712() {
		return this.field1253;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "115"
	)
	int method713() {
		return this.field1255;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	int method714() {
		return this.method713() - this.method712();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(FI)I",
		garbageValue = "1249933275"
	)
	int method715(float var1) {
		if (this.field1254 < 0 || (float)this.field1237[this.field1254].field1200 > var1 || this.field1237[this.field1254].field1194 != null && (float)this.field1237[this.field1254].field1194.field1200 <= var1) {
			if (var1 >= (float)this.method712() && var1 <= (float)this.method713()) {
				int var2 = this.method717();
				int var3 = this.field1254;
				if (var2 > 0) {
					int var4 = 0;
					int var5 = var2 - 1;

					do {
						int var6 = var5 + var4 >> 1;
						if (var1 < (float)this.field1237[var6].field1200) {
							if (var1 > (float)this.field1237[var6 - 1].field1200) {
								var3 = var6 - 1;
								break;
							}

							var5 = var6 - 1;
						} else {
							if (var1 <= (float)this.field1237[var6].field1200) {
								var3 = var6;
								break;
							}

							if (var1 < (float)this.field1237[var6 + 1].field1200) {
								var3 = var6;
								break;
							}

							var4 = var6 + 1;
						}
					} while(var4 <= var5);
				}

				if (var3 != this.field1254) {
					this.field1254 = var3;
					this.field1236 = true;
				}

				return this.field1254;
			} else {
				return -1;
			}
		} else {
			return this.field1254;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(FB)Lef;",
		garbageValue = "6"
	)
	class127 method716(float var1) {
		int var2 = this.method715(var1);
		return var2 >= 0 && var2 < this.field1237.length ? this.field1237[var2] : null;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "2119570978"
	)
	int method717() {
		return this.field1237 == null ? 0 : this.field1237.length;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "1742739576"
	)
	public static int method708(int var0, int var1) {
		return (var0 << 8) + var1;
	}
}