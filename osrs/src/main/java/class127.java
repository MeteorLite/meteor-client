import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class127 {
	@ObfuscatedName("au")
	public final int field1222;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Leo;"
	)
	public class127 field1221;
	@ObfuscatedName("ao")
	float[][] field1213;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "[Lrz;"
	)
	final class450[] field1220;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "[Lrz;"
	)
	class450[] field1218;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "[Lrz;"
	)
	class450[] field1219;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lrz;"
	)
	class450 field1217;
	@ObfuscatedName("ap")
	boolean field1210;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lrz;"
	)
	class450 field1215;
	@ObfuscatedName("af")
	boolean field1209;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Lrz;"
	)
	class450 field1216;
	@ObfuscatedName("aq")
	float[][] field1214;
	@ObfuscatedName("al")
	float[][] field1211;
	@ObfuscatedName("an")
	float[][] field1212;

	@ObfuscatedSignature(
		descriptor = "(ILtm;Z)V"
	)
	public class127(int var1, Buffer var2, boolean var3) {
		this.field1217 = new class450();
		this.field1210 = true;
		this.field1215 = new class450();
		this.field1209 = true;
		this.field1216 = new class450();
		this.field1222 = var2.readShort();
		this.field1220 = new class450[var1];
		this.field1218 = new class450[this.field1220.length];
		this.field1219 = new class450[this.field1220.length];
		this.field1213 = new float[this.field1220.length][3];

		for (int var4 = 0; var4 < this.field1220.length; ++var4) {
			this.field1220[var4] = new class450(var2, var3);
			this.field1213[var4][0] = var2.method2551();
			this.field1213[var4][1] = var2.method2551();
			this.field1213[var4][2] = var2.method2551();
		}

		this.method704();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-431712200"
	)
	void method704() {
		this.field1214 = new float[this.field1220.length][3];
		this.field1211 = new float[this.field1220.length][3];
		this.field1212 = new float[this.field1220.length][3];
		class450 var1;
		synchronized(class450.field3873) {
			if (class462.field3904 == 0) {
				var1 = new class450();
			} else {
				class450.field3873[--class462.field3904].method2302();
				var1 = class450.field3873[class462.field3904];
			}
		}

		class450 var2 = var1;

		for (int var5 = 0; var5 < this.field1220.length; ++var5) {
			class450 var4 = this.method705(var5);
			var2.method2304(var4);
			var2.method2312();
			this.field1214[var5] = var2.method2301();
			this.field1211[var5][0] = var4.field3875[12];
			this.field1211[var5][1] = var4.field3875[13];
			this.field1211[var5][2] = var4.field3875[14];
			this.field1212[var5] = var4.method2313();
		}

		var2.method2298();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IB)Lrz;",
		garbageValue = "1"
	)
	class450 method705(int var1) {
		return this.field1220[var1];
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IS)Lrz;",
		garbageValue = "18304"
	)
	class450 method706(int var1) {
		if (this.field1218[var1] == null) {
			this.field1218[var1] = new class450(this.method705(var1));
			if (this.field1221 != null) {
				this.field1218[var1].method2308(this.field1221.method706(var1));
			} else {
				this.field1218[var1].method2308(class450.field3874);
			}
		}

		return this.field1218[var1];
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lrz;",
		garbageValue = "1066264654"
	)
	class450 method707(int var1) {
		if (this.field1219[var1] == null) {
			this.field1219[var1] = new class450(this.method706(var1));
			this.field1219[var1].method2312();
		}

		return this.field1219[var1];
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lrz;I)V",
		garbageValue = "-799671526"
	)
	void method708(class450 var1) {
		this.field1217.method2304(var1);
		this.field1210 = true;
		this.field1209 = true;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(B)Lrz;",
		garbageValue = "-23"
	)
	class450 method709() {
		return this.field1217;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Lrz;",
		garbageValue = "1930419113"
	)
	class450 method710() {
		if (this.field1210) {
			this.field1215.method2304(this.method709());
			if (this.field1221 != null) {
				this.field1215.method2308(this.field1221.method710());
			}

			this.field1210 = false;
		}

		return this.field1215;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)Lrz;",
		garbageValue = "1508889675"
	)
	public class450 method711(int var1) {
		if (this.field1209) {
			this.field1216.method2304(this.method707(var1));
			this.field1216.method2308(this.method710());
			this.field1209 = false;
		}

		return this.field1216;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(II)[F",
		garbageValue = "1706055895"
	)
	float[] method712(int var1) {
		return this.field1214[var1];
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(IB)[F",
		garbageValue = "12"
	)
	float[] method713(int var1) {
		return this.field1211[var1];
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(II)[F",
		garbageValue = "1605437767"
	)
	float[] method714(int var1) {
		return this.field1212[var1];
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "0"
	)
	public static int method703(int var0) {
		return var0 != 0 && var0 != 1 ? -1 : 0;
	}
}