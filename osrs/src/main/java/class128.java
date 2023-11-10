import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class128 {
	@ObfuscatedName("at")
	public final int field1238;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lej;"
	)
	public class128 field1237;
	@ObfuscatedName("ar")
	float[][] field1227;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "[Lrz;"
	)
	final class462[] field1236;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "[Lrz;"
	)
	class462[] field1234;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "[Lrz;"
	)
	class462[] field1235;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lrz;"
	)
	class462 field1231;
	@ObfuscatedName("ac")
	boolean field1225;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lrz;"
	)
	class462 field1232;
	@ObfuscatedName("az")
	boolean field1226;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lrz;"
	)
	class462 field1233;
	@ObfuscatedName("av")
	float[][] field1229;
	@ObfuscatedName("ax")
	float[][] field1230;
	@ObfuscatedName("as")
	float[][] field1228;

	@ObfuscatedSignature(
		descriptor = "(ILuj;Z)V"
	)
	public class128(int var1, Buffer var2, boolean var3) {
		this.field1231 = new class462();
		this.field1225 = true;
		this.field1232 = new class462();
		this.field1226 = true;
		this.field1233 = new class462();
		this.field1238 = var2.readShort();
		this.field1236 = new class462[var1];
		this.field1234 = new class462[this.field1236.length];
		this.field1235 = new class462[this.field1236.length];
		this.field1227 = new float[this.field1236.length][3];

		for (int var4 = 0; var4 < this.field1236.length; ++var4) {
			this.field1236[var4] = new class462(var2, var3);
			this.field1227[var4][0] = var2.method2565();
			this.field1227[var4][1] = var2.method2565();
			this.field1227[var4][2] = var2.method2565();
		}

		this.method695();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-36"
	)
	void method695() {
		this.field1229 = new float[this.field1236.length][3];
		this.field1230 = new float[this.field1236.length][3];
		this.field1228 = new float[this.field1236.length][3];
		class462 var1 = WorldMapDecoration.method1329();

		for (int var2 = 0; var2 < this.field1236.length; ++var2) {
			class462 var3 = this.method697(var2);
			var1.method2320(var3);
			var1.method2328();
			this.field1229[var2] = var1.method2317();
			this.field1230[var2][0] = var3.field3908[12];
			this.field1230[var2][1] = var3.field3908[13];
			this.field1230[var2][2] = var3.field3908[14];
			this.field1228[var2] = var3.method2329();
		}

		var1.method2314();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)Lrz;",
		garbageValue = "1567155502"
	)
	class462 method697(int var1) {
		return this.field1236[var1];
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)Lrz;",
		garbageValue = "211716274"
	)
	class462 method698(int var1) {
		if (this.field1234[var1] == null) {
			this.field1234[var1] = new class462(this.method697(var1));
			if (this.field1237 != null) {
				this.field1234[var1].method2324(this.field1237.method698(var1));
			} else {
				this.field1234[var1].method2324(class462.field3905);
			}
		}

		return this.field1234[var1];
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IS)Lrz;",
		garbageValue = "6325"
	)
	class462 method700(int var1) {
		if (this.field1235[var1] == null) {
			this.field1235[var1] = new class462(this.method698(var1));
			this.field1235[var1].method2328();
		}

		return this.field1235[var1];
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Lrz;I)V",
		garbageValue = "1841353885"
	)
	void method701(class462 var1) {
		this.field1231.method2320(var1);
		this.field1225 = true;
		this.field1226 = true;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)Lrz;",
		garbageValue = "37"
	)
	class462 method702() {
		return this.field1231;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Lrz;",
		garbageValue = "155823310"
	)
	class462 method703() {
		if (this.field1225) {
			this.field1232.method2320(this.method702());
			if (this.field1237 != null) {
				this.field1232.method2324(this.field1237.method703());
			}

			this.field1225 = false;
		}

		return this.field1232;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IB)Lrz;",
		garbageValue = "80"
	)
	public class462 method704(int var1) {
		if (this.field1226) {
			this.field1233.method2320(this.method700(var1));
			this.field1233.method2324(this.method703());
			this.field1226 = false;
		}

		return this.field1233;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)[F",
		garbageValue = "-2041613656"
	)
	float[] method705(int var1) {
		return this.field1229[var1];
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(II)[F",
		garbageValue = "-1019764578"
	)
	float[] method706(int var1) {
		return this.field1230[var1];
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(IB)[F",
		garbageValue = "4"
	)
	float[] method707(int var1) {
		return this.field1228[var1];
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
		garbageValue = "-566534946"
	)
	public static String method696(CharSequence var0) {
		long var3 = 0L;
		int var5 = var0.length();

		for (int var6 = 0; var6 < var5; ++var6) {
			var3 *= 37L;
			char var7 = var0.charAt(var6);
			if (var7 >= 'A' && var7 <= 'Z') {
				var3 += (long)(var7 + 1 - 65);
			} else if (var7 >= 'a' && var7 <= 'z') {
				var3 += (long)(var7 + 1 - 97);
			} else if (var7 >= '0' && var7 <= '9') {
				var3 += (long)(var7 + 27 - 48);
			}

			if (var3 >= 177917621779460413L) {
				break;
			}
		}

		while (0L == var3 % 37L && 0L != var3) {
			var3 /= 37L;
		}

		String var8 = HitSplatDefinition.base37DecodeLong(var3);
		if (var8 == null) {
			var8 = "";
		}

		return var8;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;ZI)[B",
		garbageValue = "-232126704"
	)
	public static byte[] method694(Object var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0 instanceof byte[]) {
			byte[] var6 = (byte[])((byte[])var0);
			if (var1) {
				int var4 = var6.length;
				byte[] var5 = new byte[var4];
				System.arraycopy(var6, 0, var5, 0, var4);
				return var5;
			} else {
				return var6;
			}
		} else if (var0 instanceof AbstractByteArrayCopier) {
			AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
			return var2.get();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)Ljava/lang/String;",
		garbageValue = "1233783388"
	)
	@Export("readString")
	public static String readString(Buffer var0) {
		return DevicePcmPlayerProvider.method82(var0, 32767);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "41"
	)
	public static int method699(int var0) {
		return class158.method828(ViewportMouse.ViewportMouse_entityTags[var0]);
	}
}