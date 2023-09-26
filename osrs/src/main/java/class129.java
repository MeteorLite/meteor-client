import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class129 {
	@ObfuscatedName("iz")
	static int field1205;
	@ObfuscatedName("ac")
	public final int field1219;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Led;"
	)
	public class129 field1218;
	@ObfuscatedName("ak")
	float[][] field1209;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "[Lrb;"
	)
	final class465[] field1217;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "[Lrb;"
	)
	class465[] field1216;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "[Lrb;"
	)
	class465[] field1215;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lrb;"
	)
	class465 field1214;
	@ObfuscatedName("ab")
	boolean field1206;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lrb;"
	)
	class465 field1213;
	@ObfuscatedName("av")
	boolean field1207;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lrb;"
	)
	class465 field1212;
	@ObfuscatedName("aa")
	float[][] field1208;
	@ObfuscatedName("ap")
	float[][] field1210;
	@ObfuscatedName("ay")
	float[][] field1211;

	@ObfuscatedSignature(
		descriptor = "(ILul;Z)V"
	)
	public class129(int var1, Buffer var2, boolean var3) {
		this.field1214 = new class465();
		this.field1206 = true;
		this.field1213 = new class465();
		this.field1207 = true;
		this.field1212 = new class465();
		this.field1219 = var2.readShort();
		this.field1217 = new class465[var1];
		this.field1216 = new class465[this.field1217.length];
		this.field1215 = new class465[this.field1217.length];
		this.field1209 = new float[this.field1217.length][3];

		for (int var4 = 0; var4 < this.field1217.length; ++var4) {
			this.field1217[var4] = new class465(var2, var3);
			this.field1209[var4][0] = var2.method2586();
			this.field1209[var4][1] = var2.method2586();
			this.field1209[var4][2] = var2.method2586();
		}

		this.method693();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-13"
	)
	void method693() {
		this.field1208 = new float[this.field1217.length][3];
		this.field1210 = new float[this.field1217.length][3];
		this.field1211 = new float[this.field1217.length][3];
		class465 var1 = ParamComposition.method1053();

		for (int var2 = 0; var2 < this.field1217.length; ++var2) {
			class465 var3 = this.method694(var2);
			var1.method2342(var3);
			var1.method2350();
			this.field1208[var2] = var1.method2339();
			this.field1210[var2][0] = var3.field3908[12];
			this.field1210[var2][1] = var3.field3908[13];
			this.field1210[var2][2] = var3.field3908[14];
			this.field1211[var2] = var3.method2351();
		}

		var1.method2336();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Lrb;",
		garbageValue = "-1380153125"
	)
	class465 method694(int var1) {
		return this.field1217[var1];
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)Lrb;",
		garbageValue = "-1405133305"
	)
	class465 method695(int var1) {
		if (this.field1216[var1] == null) {
			this.field1216[var1] = new class465(this.method694(var1));
			if (this.field1218 != null) {
				this.field1216[var1].method2346(this.field1218.method695(var1));
			} else {
				this.field1216[var1].method2346(class465.field3903);
			}
		}

		return this.field1216[var1];
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(II)Lrb;",
		garbageValue = "-1214410602"
	)
	class465 method696(int var1) {
		if (this.field1215[var1] == null) {
			this.field1215[var1] = new class465(this.method695(var1));
			this.field1215[var1].method2350();
		}

		return this.field1215[var1];
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lrb;I)V",
		garbageValue = "2009872809"
	)
	void method697(class465 var1) {
		this.field1214.method2342(var1);
		this.field1206 = true;
		this.field1207 = true;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)Lrb;",
		garbageValue = "1"
	)
	class465 method698() {
		return this.field1214;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Lrb;",
		garbageValue = "-1187043704"
	)
	class465 method699() {
		if (this.field1206) {
			this.field1213.method2342(this.method698());
			if (this.field1218 != null) {
				this.field1213.method2346(this.field1218.method699());
			}

			this.field1206 = false;
		}

		return this.field1213;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(II)Lrb;",
		garbageValue = "295548775"
	)
	public class465 method700(int var1) {
		if (this.field1207) {
			this.field1212.method2342(this.method696(var1));
			this.field1212.method2346(this.method699());
			this.field1207 = false;
		}

		return this.field1212;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(II)[F",
		garbageValue = "1329468643"
	)
	float[] method701(int var1) {
		return this.field1208[var1];
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(II)[F",
		garbageValue = "-1277196406"
	)
	float[] method702(int var1) {
		return this.field1210[var1];
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(II)[F",
		garbageValue = "996106282"
	)
	float[] method703(int var1) {
		return this.field1211[var1];
	}
}