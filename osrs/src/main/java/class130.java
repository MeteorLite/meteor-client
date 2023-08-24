import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class130 {
	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		descriptor = "Liv;"
	)
	@Export("scene")
	static Scene scene;
	@ObfuscatedName("au")
	boolean field1243;
	@ObfuscatedName("ae")
	boolean field1240;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lew;"
	)
	class128 field1245;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lew;"
	)
	class128 field1246;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "[Leg;"
	)
	class125[] field1244;
	@ObfuscatedName("ai")
	boolean field1242;
	@ObfuscatedName("az")
	float field1258;
	@ObfuscatedName("ap")
	float field1254;
	@ObfuscatedName("aa")
	float field1247;
	@ObfuscatedName("af")
	float field1250;
	@ObfuscatedName("ad")
	float field1249;
	@ObfuscatedName("aq")
	float field1255;
	@ObfuscatedName("al")
	float field1252;
	@ObfuscatedName("an")
	float field1253;
	@ObfuscatedName("ar")
	float field1256;
	@ObfuscatedName("ab")
	float field1248;
	@ObfuscatedName("ag")
	boolean field1241;
	@ObfuscatedName("am")
	int field1261;
	@ObfuscatedName("ax")
	float[] field1259;
	@ObfuscatedName("ah")
	int field1260;
	@ObfuscatedName("as")
	int field1262;
	@ObfuscatedName("ay")
	float field1257;
	@ObfuscatedName("aj")
	float field1251;

	class130() {
		this.field1241 = true;
		this.field1261 = 0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;IB)I",
		garbageValue = "-47"
	)
	int method718(Buffer var1, int var2) {
		int var3 = var1.readUnsignedShort();
		int var4 = var1.readUnsignedByte();
		class138[] var5 = new class138[]{class138.field1314, class138.field1309, class138.field1311, class138.field1313, class138.field1308, class138.field1310, class138.field1315, class138.field1312, class138.field1307};
		class138 var6 = (class138)KeyHandler.findEnumerated(var5, var4);
		if (var6 == null) {
			var6 = class138.field1307;
		}

		this.field1245 = ArchiveLoader.method466(var1.readUnsignedByte());
		this.field1246 = ArchiveLoader.method466(var1.readUnsignedByte());
		this.field1243 = var1.readUnsignedByte() != 0;
		this.field1244 = new class125[var3];
		class125 var9 = null;

		for (int var8 = 0; var8 < var3; ++var8) {
			class125 var7 = new class125();
			var7.method696(var1, var2);
			this.field1244[var8] = var7;
			if (var9 != null) {
				var9.field1196 = var7;
			}

			var9 = var7;
		}

		return var3;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-1069"
	)
	void method719() {
		this.field1260 = this.field1244[0].field1202;
		this.field1262 = this.field1244[this.method726() - 1].field1202;
		this.field1259 = new float[this.method723() + 1];

		for (int var1 = this.method721(); var1 <= this.method722(); ++var1) {
			this.field1259[var1 - this.method721()] = Skeleton.method1229(this, (float)var1);
		}

		this.field1244 = null;
		this.field1257 = Skeleton.method1229(this, (float)(this.method721() - 1));
		this.field1251 = Skeleton.method1229(this, (float)(this.method722() + 1));
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)F",
		garbageValue = "-13"
	)
	public float method720(int var1) {
		if (var1 < this.method721()) {
			return this.field1257;
		} else {
			return var1 > this.method722() ? this.field1251 : this.field1259[var1 - this.method721()];
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1409378084"
	)
	int method721() {
		return this.field1260;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1371661145"
	)
	int method722() {
		return this.field1262;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1808269392"
	)
	int method723() {
		return this.method722() - this.method721();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(FB)I",
		garbageValue = "116"
	)
	int method724(float var1) {
		if (this.field1261 < 0 || (float)this.field1244[this.field1261].field1202 > var1 || this.field1244[this.field1261].field1196 != null && (float)this.field1244[this.field1261].field1196.field1202 <= var1) {
			if (var1 >= (float)this.method721() && var1 <= (float)this.method722()) {
				int var2 = this.method726();
				int var3 = this.field1261;
				if (var2 > 0) {
					int var4 = 0;
					int var5 = var2 - 1;

					do {
						int var6 = var5 + var4 >> 1;
						if (var1 < (float)this.field1244[var6].field1202) {
							if (var1 > (float)this.field1244[var6 - 1].field1202) {
								var3 = var6 - 1;
								break;
							}

							var5 = var6 - 1;
						} else {
							if (var1 <= (float)this.field1244[var6].field1202) {
								var3 = var6;
								break;
							}

							if (var1 < (float)this.field1244[var6 + 1].field1202) {
								var3 = var6;
								break;
							}

							var4 = var6 + 1;
						}
					} while(var4 <= var5);
				}

				if (var3 != this.field1261) {
					this.field1261 = var3;
					this.field1241 = true;
				}

				return this.field1261;
			} else {
				return -1;
			}
		} else {
			return this.field1261;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(FI)Leg;",
		garbageValue = "1942643085"
	)
	class125 method725(float var1) {
		int var2 = this.method724(var1);
		return var2 >= 0 && var2 < this.field1244.length ? this.field1244[var2] : null;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1392526079"
	)
	int method726() {
		return this.field1244 == null ? 0 : this.field1244.length;
	}
}