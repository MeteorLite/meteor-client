import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class127 {
	@ObfuscatedName("wn")
	@ObfuscatedSignature(
		descriptor = "Lsq;"
	)
	@Export("worldMap")
	static WorldMap worldMap;
	@ObfuscatedName("aw")
	public final int field1213;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lek;"
	)
	public class127 field1212;
	@ObfuscatedName("ar")
	float[][] field1203;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "[Lrm;"
	)
	final class451[] field1211;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "[Lrm;"
	)
	class451[] field1210;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "[Lrm;"
	)
	class451[] field1209;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lrm;"
	)
	class451 field1206;
	@ObfuscatedName("az")
	boolean field1201;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lrm;"
	)
	class451 field1208;
	@ObfuscatedName("ap")
	boolean field1200;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lrm;"
	)
	class451 field1207;
	@ObfuscatedName("at")
	float[][] field1204;
	@ObfuscatedName("ah")
	float[][] field1202;
	@ObfuscatedName("ax")
	float[][] field1205;

	@ObfuscatedSignature(
		descriptor = "(ILty;Z)V"
	)
	public class127(int var1, Buffer var2, boolean var3) {
		this.field1206 = new class451();
		this.field1201 = true;
		this.field1208 = new class451();
		this.field1200 = true;
		this.field1207 = new class451();
		this.field1213 = var2.readShort();
		this.field1211 = new class451[var1];
		this.field1210 = new class451[this.field1211.length];
		this.field1209 = new class451[this.field1211.length];
		this.field1203 = new float[this.field1211.length][3];

		for (int var4 = 0; var4 < this.field1211.length; ++var4) {
			this.field1211[var4] = new class451(var2, var3);
			this.field1203[var4][0] = var2.method2531();
			this.field1203[var4][1] = var2.method2531();
			this.field1203[var4][2] = var2.method2531();
		}

		this.method693();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1463837860"
	)
	void method693() {
		this.field1204 = new float[this.field1211.length][3];
		this.field1202 = new float[this.field1211.length][3];
		this.field1205 = new float[this.field1211.length][3];
		class451 var1 = class138.method744();

		for (int var2 = 0; var2 < this.field1211.length; ++var2) {
			class451 var3 = this.method694(var2);
			var1.method2278(var3);
			var1.method2286();
			this.field1204[var2] = var1.method2274();
			this.field1202[var2][0] = var3.field3861[12];
			this.field1202[var2][1] = var3.field3861[13];
			this.field1202[var2][2] = var3.field3861[14];
			this.field1205[var2] = var3.method2287();
		}

		var1.method2271();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)Lrm;",
		garbageValue = "-961715639"
	)
	class451 method694(int var1) {
		return this.field1211[var1];
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)Lrm;",
		garbageValue = "-318230111"
	)
	class451 method695(int var1) {
		if (this.field1210[var1] == null) {
			this.field1210[var1] = new class451(this.method694(var1));
			if (this.field1212 != null) {
				this.field1210[var1].method2282(this.field1212.method695(var1));
			} else {
				this.field1210[var1].method2282(class451.field3857);
			}
		}

		return this.field1210[var1];
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(IB)Lrm;",
		garbageValue = "81"
	)
	class451 method696(int var1) {
		if (this.field1209[var1] == null) {
			this.field1209[var1] = new class451(this.method695(var1));
			this.field1209[var1].method2286();
		}

		return this.field1209[var1];
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lrm;I)V",
		garbageValue = "1524637069"
	)
	void method697(class451 var1) {
		this.field1206.method2278(var1);
		this.field1201 = true;
		this.field1200 = true;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)Lrm;",
		garbageValue = "144980279"
	)
	class451 method698() {
		return this.field1206;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)Lrm;",
		garbageValue = "0"
	)
	class451 method699() {
		if (this.field1201) {
			this.field1208.method2278(this.method698());
			if (this.field1212 != null) {
				this.field1208.method2282(this.field1212.method699());
			}

			this.field1201 = false;
		}

		return this.field1208;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(IB)Lrm;",
		garbageValue = "2"
	)
	public class451 method700(int var1) {
		if (this.field1200) {
			this.field1207.method2278(this.method696(var1));
			this.field1207.method2282(this.method699());
			this.field1200 = false;
		}

		return this.field1207;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(II)[F",
		garbageValue = "-1038210043"
	)
	float[] method701(int var1) {
		return this.field1204[var1];
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)[F",
		garbageValue = "-2141591558"
	)
	float[] method702(int var1) {
		return this.field1202[var1];
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IB)[F",
		garbageValue = "0"
	)
	float[] method703(int var1) {
		return this.field1205[var1];
	}

	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "552746163"
	)
	static final boolean method704(int var0) {
		if (var0 < 0) {
			return false;
		} else {
			int var1 = Client.menuOpcodes[var0];
			if (var1 >= 2000) {
				var1 -= 2000;
			}

			return var1 == 1007;
		}
	}
}
