import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("rz")
public final class class462 {
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "[Lrz;"
	)
	static class462[] field3907;
	@ObfuscatedName("ar")
	static int field3906;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lrz;"
	)
	public static final class462 field3905;
	@ObfuscatedName("ab")
	public float[] field3908;

	static {
		field3907 = new class462[0];
		ServerPacket.method1640(100);
		field3905 = new class462();
	}

	public class462() {
		this.field3908 = new float[16];
		this.method2318();
	}

	@ObfuscatedSignature(
		descriptor = "(Lrz;)V"
	)
	public class462(class462 var1) {
		this.field3908 = new float[16];
		this.method2320(var1);
	}

	@ObfuscatedSignature(
		descriptor = "(Luj;Z)V"
	)
	public class462(Buffer var1, boolean var2) {
		this.field3908 = new float[16];
		this.method2315(var1, var2);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2018425549"
	)
	public void method2314() {
		synchronized(field3907) {
			if (DirectByteArrayCopier.field3136 < field3906 - 1) {
				field3907[++DirectByteArrayCopier.field3136 - 1] = this;
			}

		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Luj;ZI)V",
		garbageValue = "-1679447945"
	)
	void method2315(Buffer var1, boolean var2) {
		if (var2) {
			class463 var3 = new class463();
			int var6 = var1.readShort();
			var6 &= 16383;
			float var5 = (float)(6.283185307179586D * (double)((float)var6 / 16384.0F));
			var3.method2331(var5);
			int var9 = var1.readShort();
			var9 &= 16383;
			float var8 = (float)(6.283185307179586D * (double)((float)var9 / 16384.0F));
			var3.method2332(var8);
			int var12 = var1.readShort();
			var12 &= 16383;
			float var11 = (float)(6.283185307179586D * (double)((float)var12 / 16384.0F));
			var3.method2333(var11);
			var3.method2334((float)var1.readShort(), (float)var1.readShort(), (float)var1.readShort());
			this.method2326(var3);
		} else {
			for (int var13 = 0; var13 < 16; ++var13) {
				this.field3908[var13] = var1.method2565();
			}
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(B)[F",
		garbageValue = "1"
	)
	float[] method2316() {
		float[] var1 = new float[3];
		if ((double)this.field3908[2] < 0.999D && (double)this.field3908[2] > -0.999D) {
			var1[1] = (float)(-Math.asin((double)this.field3908[2]));
			double var2 = Math.cos((double)var1[1]);
			var1[0] = (float)Math.atan2((double)this.field3908[6] / var2, (double)this.field3908[10] / var2);
			var1[2] = (float)Math.atan2((double)this.field3908[1] / var2, (double)this.field3908[0] / var2);
		} else {
			var1[0] = 0.0F;
			var1[1] = (float)Math.atan2((double)this.field3908[2], 0.0D);
			var1[2] = (float)Math.atan2((double)(-this.field3908[9]), (double)this.field3908[5]);
		}

		return var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)[F",
		garbageValue = "5"
	)
	public float[] method2317() {
		float[] var1 = new float[]{(float)(-Math.asin((double)this.field3908[6])), 0.0F, 0.0F};
		double var2 = Math.cos((double)var1[0]);
		double var4;
		double var6;
		if (Math.abs(var2) > 0.005D) {
			var4 = (double)this.field3908[2];
			var6 = (double)this.field3908[10];
			double var8 = (double)this.field3908[4];
			double var10 = (double)this.field3908[5];
			var1[1] = (float)Math.atan2(var4, var6);
			var1[2] = (float)Math.atan2(var8, var10);
		} else {
			var4 = (double)this.field3908[1];
			var6 = (double)this.field3908[0];
			if (this.field3908[6] < 0.0F) {
				var1[1] = (float)Math.atan2(var4, var6);
			} else {
				var1[1] = (float)(-Math.atan2(var4, var6));
			}

			var1[2] = 0.0F;
		}

		return var1;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-60"
	)
	void method2318() {
		this.field3908[0] = 1.0F;
		this.field3908[1] = 0.0F;
		this.field3908[2] = 0.0F;
		this.field3908[3] = 0.0F;
		this.field3908[4] = 0.0F;
		this.field3908[5] = 1.0F;
		this.field3908[6] = 0.0F;
		this.field3908[7] = 0.0F;
		this.field3908[8] = 0.0F;
		this.field3908[9] = 0.0F;
		this.field3908[10] = 1.0F;
		this.field3908[11] = 0.0F;
		this.field3908[12] = 0.0F;
		this.field3908[13] = 0.0F;
		this.field3908[14] = 0.0F;
		this.field3908[15] = 1.0F;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "77"
	)
	public void method2319() {
		this.field3908[0] = 0.0F;
		this.field3908[1] = 0.0F;
		this.field3908[2] = 0.0F;
		this.field3908[3] = 0.0F;
		this.field3908[4] = 0.0F;
		this.field3908[5] = 0.0F;
		this.field3908[6] = 0.0F;
		this.field3908[7] = 0.0F;
		this.field3908[8] = 0.0F;
		this.field3908[9] = 0.0F;
		this.field3908[10] = 0.0F;
		this.field3908[11] = 0.0F;
		this.field3908[12] = 0.0F;
		this.field3908[13] = 0.0F;
		this.field3908[14] = 0.0F;
		this.field3908[15] = 0.0F;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lrz;I)V",
		garbageValue = "-1456016137"
	)
	public void method2320(class462 var1) {
		System.arraycopy(var1.field3908, 0, this.field3908, 0, 16);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(FB)V",
		garbageValue = "93"
	)
	public void method2321(float var1) {
		this.method2322(var1, var1, var1);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(FFFB)V",
		garbageValue = "111"
	)
	public void method2322(float var1, float var2, float var3) {
		this.method2318();
		this.field3908[0] = var1;
		this.field3908[5] = var2;
		this.field3908[10] = var3;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Lrz;I)V",
		garbageValue = "-459748559"
	)
	public void method2323(class462 var1) {
		for (int var2 = 0; var2 < this.field3908.length; ++var2) {
			float[] var10000 = this.field3908;
			var10000[var2] += var1.field3908[var2];
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lrz;I)V",
		garbageValue = "1005316731"
	)
	public void method2324(class462 var1) {
		float var2 = var1.field3908[12] * this.field3908[3] + var1.field3908[8] * this.field3908[2] + var1.field3908[0] * this.field3908[0] + this.field3908[1] * var1.field3908[4];
		float var3 = var1.field3908[9] * this.field3908[2] + var1.field3908[5] * this.field3908[1] + this.field3908[0] * var1.field3908[1] + var1.field3908[13] * this.field3908[3];
		float var4 = var1.field3908[14] * this.field3908[3] + var1.field3908[6] * this.field3908[1] + var1.field3908[2] * this.field3908[0] + var1.field3908[10] * this.field3908[2];
		float var5 = this.field3908[3] * var1.field3908[15] + var1.field3908[3] * this.field3908[0] + var1.field3908[7] * this.field3908[1] + this.field3908[2] * var1.field3908[11];
		float var6 = this.field3908[7] * var1.field3908[12] + this.field3908[4] * var1.field3908[0] + var1.field3908[4] * this.field3908[5] + this.field3908[6] * var1.field3908[8];
		float var7 = this.field3908[7] * var1.field3908[13] + this.field3908[5] * var1.field3908[5] + var1.field3908[1] * this.field3908[4] + var1.field3908[9] * this.field3908[6];
		float var8 = this.field3908[7] * var1.field3908[14] + this.field3908[4] * var1.field3908[2] + var1.field3908[6] * this.field3908[5] + this.field3908[6] * var1.field3908[10];
		float var9 = var1.field3908[11] * this.field3908[6] + var1.field3908[3] * this.field3908[4] + this.field3908[5] * var1.field3908[7] + this.field3908[7] * var1.field3908[15];
		float var10 = this.field3908[8] * var1.field3908[0] + this.field3908[9] * var1.field3908[4] + this.field3908[10] * var1.field3908[8] + this.field3908[11] * var1.field3908[12];
		float var11 = var1.field3908[1] * this.field3908[8] + var1.field3908[5] * this.field3908[9] + var1.field3908[9] * this.field3908[10] + this.field3908[11] * var1.field3908[13];
		float var12 = this.field3908[8] * var1.field3908[2] + this.field3908[9] * var1.field3908[6] + this.field3908[10] * var1.field3908[10] + this.field3908[11] * var1.field3908[14];
		float var13 = this.field3908[11] * var1.field3908[15] + var1.field3908[7] * this.field3908[9] + var1.field3908[3] * this.field3908[8] + var1.field3908[11] * this.field3908[10];
		float var14 = var1.field3908[8] * this.field3908[14] + var1.field3908[0] * this.field3908[12] + var1.field3908[4] * this.field3908[13] + this.field3908[15] * var1.field3908[12];
		float var15 = var1.field3908[9] * this.field3908[14] + this.field3908[12] * var1.field3908[1] + this.field3908[13] * var1.field3908[5] + var1.field3908[13] * this.field3908[15];
		float var16 = var1.field3908[14] * this.field3908[15] + this.field3908[12] * var1.field3908[2] + var1.field3908[6] * this.field3908[13] + var1.field3908[10] * this.field3908[14];
		float var17 = this.field3908[13] * var1.field3908[7] + var1.field3908[3] * this.field3908[12] + var1.field3908[11] * this.field3908[14] + this.field3908[15] * var1.field3908[15];
		this.field3908[0] = var2;
		this.field3908[1] = var3;
		this.field3908[2] = var4;
		this.field3908[3] = var5;
		this.field3908[4] = var6;
		this.field3908[5] = var7;
		this.field3908[6] = var8;
		this.field3908[7] = var9;
		this.field3908[8] = var10;
		this.field3908[9] = var11;
		this.field3908[10] = var12;
		this.field3908[11] = var13;
		this.field3908[12] = var14;
		this.field3908[13] = var15;
		this.field3908[14] = var16;
		this.field3908[15] = var17;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lrq;I)V",
		garbageValue = "-2073322468"
	)
	public void method2325(class461 var1) {
		float var2 = var1.field3901 * var1.field3901;
		float var3 = var1.field3901 * var1.field3903;
		float var4 = var1.field3901 * var1.field3902;
		float var5 = var1.field3901 * var1.field3904;
		float var6 = var1.field3903 * var1.field3903;
		float var7 = var1.field3903 * var1.field3902;
		float var8 = var1.field3904 * var1.field3903;
		float var9 = var1.field3902 * var1.field3902;
		float var10 = var1.field3902 * var1.field3904;
		float var11 = var1.field3904 * var1.field3904;
		this.field3908[0] = var2 + var6 - var11 - var9;
		this.field3908[1] = var5 + var7 + var5 + var7;
		this.field3908[2] = var8 - var4 - var4 + var8;
		this.field3908[4] = var7 - var5 - var5 + var7;
		this.field3908[5] = var9 + var2 - var6 - var11;
		this.field3908[6] = var3 + var3 + var10 + var10;
		this.field3908[8] = var4 + var8 + var8 + var4;
		this.field3908[9] = var10 + (var10 - var3 - var3);
		this.field3908[10] = var2 + var11 - var9 - var6;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lrj;I)V",
		garbageValue = "-1749310376"
	)
	void method2326(class463 var1) {
		this.field3908[0] = var1.field3917;
		this.field3908[1] = var1.field3912;
		this.field3908[2] = var1.field3916;
		this.field3908[3] = 0.0F;
		this.field3908[4] = var1.field3914;
		this.field3908[5] = var1.field3910;
		this.field3908[6] = var1.field3918;
		this.field3908[7] = 0.0F;
		this.field3908[8] = var1.field3909;
		this.field3908[9] = var1.field3911;
		this.field3908[10] = var1.field3913;
		this.field3908[11] = 0.0F;
		this.field3908[12] = var1.field3920;
		this.field3908[13] = var1.field3915;
		this.field3908[14] = var1.field3919;
		this.field3908[15] = 1.0F;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)F",
		garbageValue = "868032907"
	)
	float method2327() {
		return this.field3908[5] * this.field3908[3] * this.field3908[8] * this.field3908[14] + this.field3908[4] * this.field3908[3] * this.field3908[10] * this.field3908[13] + (this.field3908[8] * this.field3908[7] * this.field3908[2] * this.field3908[13] + this.field3908[15] * this.field3908[6] * this.field3908[1] * this.field3908[8] + this.field3908[13] * this.field3908[11] * this.field3908[6] * this.field3908[0] + (this.field3908[15] * this.field3908[5] * this.field3908[0] * this.field3908[10] - this.field3908[5] * this.field3908[0] * this.field3908[11] * this.field3908[14] - this.field3908[6] * this.field3908[0] * this.field3908[9] * this.field3908[15]) + this.field3908[14] * this.field3908[9] * this.field3908[0] * this.field3908[7] - this.field3908[7] * this.field3908[0] * this.field3908[10] * this.field3908[13] - this.field3908[15] * this.field3908[10] * this.field3908[4] * this.field3908[1] + this.field3908[11] * this.field3908[4] * this.field3908[1] * this.field3908[14] - this.field3908[1] * this.field3908[6] * this.field3908[11] * this.field3908[12] - this.field3908[14] * this.field3908[1] * this.field3908[7] * this.field3908[8] + this.field3908[1] * this.field3908[7] * this.field3908[10] * this.field3908[12] + this.field3908[15] * this.field3908[2] * this.field3908[4] * this.field3908[9] - this.field3908[13] * this.field3908[11] * this.field3908[2] * this.field3908[4] - this.field3908[2] * this.field3908[5] * this.field3908[8] * this.field3908[15] + this.field3908[12] * this.field3908[2] * this.field3908[5] * this.field3908[11] - this.field3908[12] * this.field3908[9] * this.field3908[7] * this.field3908[2] - this.field3908[9] * this.field3908[3] * this.field3908[4] * this.field3908[14]) - this.field3908[10] * this.field3908[5] * this.field3908[3] * this.field3908[12] - this.field3908[6] * this.field3908[3] * this.field3908[8] * this.field3908[13] + this.field3908[12] * this.field3908[9] * this.field3908[3] * this.field3908[6];
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-536017222"
	)
	public void method2328() {
		float var1 = 1.0F / this.method2327();
		float var2 = (this.field3908[7] * this.field3908[9] * this.field3908[14] + this.field3908[15] * this.field3908[10] * this.field3908[5] - this.field3908[14] * this.field3908[5] * this.field3908[11] - this.field3908[15] * this.field3908[9] * this.field3908[6] + this.field3908[13] * this.field3908[6] * this.field3908[11] - this.field3908[10] * this.field3908[7] * this.field3908[13]) * var1;
		float var3 = (this.field3908[13] * this.field3908[10] * this.field3908[3] + (this.field3908[15] * -this.field3908[1] * this.field3908[10] + this.field3908[11] * this.field3908[1] * this.field3908[14] + this.field3908[2] * this.field3908[9] * this.field3908[15] - this.field3908[13] * this.field3908[11] * this.field3908[2] - this.field3908[14] * this.field3908[9] * this.field3908[3])) * var1;
		float var4 = var1 * (this.field3908[15] * this.field3908[6] * this.field3908[1] - this.field3908[14] * this.field3908[7] * this.field3908[1] - this.field3908[15] * this.field3908[2] * this.field3908[5] + this.field3908[2] * this.field3908[7] * this.field3908[13] + this.field3908[3] * this.field3908[5] * this.field3908[14] - this.field3908[13] * this.field3908[6] * this.field3908[3]);
		float var5 = (this.field3908[5] * this.field3908[2] * this.field3908[11] + this.field3908[11] * this.field3908[6] * -this.field3908[1] + this.field3908[10] * this.field3908[1] * this.field3908[7] - this.field3908[7] * this.field3908[2] * this.field3908[9] - this.field3908[10] * this.field3908[5] * this.field3908[3] + this.field3908[6] * this.field3908[3] * this.field3908[9]) * var1;
		float var6 = var1 * (this.field3908[12] * this.field3908[7] * this.field3908[10] + (this.field3908[14] * this.field3908[11] * this.field3908[4] + -this.field3908[4] * this.field3908[10] * this.field3908[15] + this.field3908[6] * this.field3908[8] * this.field3908[15] - this.field3908[12] * this.field3908[11] * this.field3908[6] - this.field3908[7] * this.field3908[8] * this.field3908[14]));
		float var7 = var1 * (this.field3908[11] * this.field3908[2] * this.field3908[12] + (this.field3908[0] * this.field3908[10] * this.field3908[15] - this.field3908[0] * this.field3908[11] * this.field3908[14] - this.field3908[8] * this.field3908[2] * this.field3908[15]) + this.field3908[3] * this.field3908[8] * this.field3908[14] - this.field3908[12] * this.field3908[10] * this.field3908[3]);
		float var8 = (this.field3908[3] * this.field3908[6] * this.field3908[12] + (this.field3908[14] * this.field3908[7] * this.field3908[0] + this.field3908[6] * -this.field3908[0] * this.field3908[15] + this.field3908[4] * this.field3908[2] * this.field3908[15] - this.field3908[2] * this.field3908[7] * this.field3908[12] - this.field3908[3] * this.field3908[4] * this.field3908[14])) * var1;
		float var9 = var1 * (this.field3908[8] * this.field3908[2] * this.field3908[7] + (this.field3908[11] * this.field3908[6] * this.field3908[0] - this.field3908[10] * this.field3908[7] * this.field3908[0] - this.field3908[2] * this.field3908[4] * this.field3908[11]) + this.field3908[10] * this.field3908[3] * this.field3908[4] - this.field3908[6] * this.field3908[3] * this.field3908[8]);
		float var10 = var1 * (this.field3908[13] * this.field3908[7] * this.field3908[8] + this.field3908[15] * this.field3908[4] * this.field3908[9] - this.field3908[4] * this.field3908[11] * this.field3908[13] - this.field3908[5] * this.field3908[8] * this.field3908[15] + this.field3908[11] * this.field3908[5] * this.field3908[12] - this.field3908[7] * this.field3908[9] * this.field3908[12]);
		float var11 = var1 * (this.field3908[8] * this.field3908[1] * this.field3908[15] + this.field3908[15] * this.field3908[9] * -this.field3908[0] + this.field3908[0] * this.field3908[11] * this.field3908[13] - this.field3908[12] * this.field3908[1] * this.field3908[11] - this.field3908[8] * this.field3908[3] * this.field3908[13] + this.field3908[12] * this.field3908[9] * this.field3908[3]);
		float var12 = (this.field3908[7] * this.field3908[1] * this.field3908[12] + (this.field3908[15] * this.field3908[5] * this.field3908[0] - this.field3908[13] * this.field3908[7] * this.field3908[0] - this.field3908[4] * this.field3908[1] * this.field3908[15]) + this.field3908[13] * this.field3908[3] * this.field3908[4] - this.field3908[12] * this.field3908[3] * this.field3908[5]) * var1;
		float var13 = var1 * (this.field3908[8] * this.field3908[5] * this.field3908[3] + (this.field3908[11] * this.field3908[5] * -this.field3908[0] + this.field3908[0] * this.field3908[7] * this.field3908[9] + this.field3908[11] * this.field3908[1] * this.field3908[4] - this.field3908[8] * this.field3908[7] * this.field3908[1] - this.field3908[3] * this.field3908[4] * this.field3908[9]));
		float var14 = var1 * (this.field3908[14] * this.field3908[9] * -this.field3908[4] + this.field3908[13] * this.field3908[4] * this.field3908[10] + this.field3908[14] * this.field3908[5] * this.field3908[8] - this.field3908[5] * this.field3908[10] * this.field3908[12] - this.field3908[13] * this.field3908[8] * this.field3908[6] + this.field3908[9] * this.field3908[6] * this.field3908[12]);
		float var15 = (this.field3908[13] * this.field3908[2] * this.field3908[8] + this.field3908[10] * this.field3908[1] * this.field3908[12] + (this.field3908[9] * this.field3908[0] * this.field3908[14] - this.field3908[13] * this.field3908[0] * this.field3908[10] - this.field3908[1] * this.field3908[8] * this.field3908[14]) - this.field3908[12] * this.field3908[2] * this.field3908[9]) * var1;
		float var16 = var1 * (this.field3908[12] * this.field3908[2] * this.field3908[5] + (this.field3908[14] * -this.field3908[0] * this.field3908[5] + this.field3908[0] * this.field3908[6] * this.field3908[13] + this.field3908[14] * this.field3908[1] * this.field3908[4] - this.field3908[6] * this.field3908[1] * this.field3908[12] - this.field3908[13] * this.field3908[4] * this.field3908[2]));
		float var17 = var1 * (this.field3908[4] * this.field3908[2] * this.field3908[9] + this.field3908[5] * this.field3908[0] * this.field3908[10] - this.field3908[9] * this.field3908[6] * this.field3908[0] - this.field3908[10] * this.field3908[4] * this.field3908[1] + this.field3908[8] * this.field3908[1] * this.field3908[6] - this.field3908[2] * this.field3908[5] * this.field3908[8]);
		this.field3908[0] = var2;
		this.field3908[1] = var3;
		this.field3908[2] = var4;
		this.field3908[3] = var5;
		this.field3908[4] = var6;
		this.field3908[5] = var7;
		this.field3908[6] = var8;
		this.field3908[7] = var9;
		this.field3908[8] = var10;
		this.field3908[9] = var11;
		this.field3908[10] = var12;
		this.field3908[11] = var13;
		this.field3908[12] = var14;
		this.field3908[13] = var15;
		this.field3908[14] = var16;
		this.field3908[15] = var17;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)[F",
		garbageValue = "-616853758"
	)
	public float[] method2329() {
		float[] var1 = new float[3];
		class460 var2 = new class460(this.field3908[0], this.field3908[1], this.field3908[2]);
		class460 var3 = new class460(this.field3908[4], this.field3908[5], this.field3908[6]);
		class460 var4 = new class460(this.field3908[8], this.field3908[9], this.field3908[10]);
		var1[0] = var2.method2307();
		var1[1] = var3.method2307();
		var1[2] = var4.method2307();
		return var1;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		StringBuilder var1 = new StringBuilder();
		this.method2317();
		this.method2316();

		for (int var2 = 0; var2 < 4; ++var2) {
			for (int var3 = 0; var3 < 4; ++var3) {
				if (var3 > 0) {
					var1.append("\t");
				}

				float var4 = this.field3908[var3 + var2 * 4];
				if (Math.sqrt((double)(var4 * var4)) < 9.999999747378752E-5D) {
					var4 = 0.0F;
				}

				var1.append(var4);
			}

			var1.append("\n");
		}

		return var1.toString();
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		boolean var1 = true;
		byte var2 = 1;
		int var3 = var2 * 31 + Arrays.hashCode(this.field3908);
		return var3;
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (!(var1 instanceof class462)) {
			return false;
		} else {
			class462 var2 = (class462)var1;

			for (int var3 = 0; var3 < 16; ++var3) {
				if (var2.field3908[var3] != this.field3908[var3]) {
					return false;
				}
			}

			return true;
		}
	}
}