import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("rb")
public final class class465 {
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "[Lrb;"
	)
	static class465[] field3907;
	@ObfuscatedName("ak")
	static int field3904;
	@ObfuscatedName("ax")
	static int field3905;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lrb;"
	)
	public static final class465 field3903;
	@ObfuscatedName("ui")
	@Export("cameraLookAtAcceleration")
	static int cameraLookAtAcceleration;
	@ObfuscatedName("ao")
	public float[] field3908;

	static {
		field3907 = new class465[0];
		class76.method430(100);
		field3903 = new class465();
	}

	public class465() {
		this.field3908 = new float[16];
		this.method2340();
	}

	@ObfuscatedSignature(
		descriptor = "(Lrb;)V"
	)
	public class465(class465 var1) {
		this.field3908 = new float[16];
		this.method2342(var1);
	}

	@ObfuscatedSignature(
		descriptor = "(Lul;Z)V"
	)
	public class465(Buffer var1, boolean var2) {
		this.field3908 = new float[16];
		this.method2337(var1, var2);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-695246876"
	)
	public void method2336() {
		synchronized(field3907) {
			if (field3905 < field3904 - 1) {
				field3907[++field3905 - 1] = this;
			}

		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lul;ZI)V",
		garbageValue = "332749023"
	)
	void method2337(Buffer var1, boolean var2) {
		if (var2) {
			class466 var3 = new class466();
			var3.method2353(class143.method756(var1.readShort()));
			var3.method2354(class143.method756(var1.readShort()));
			var3.method2355(class143.method756(var1.readShort()));
			var3.method2356((float)var1.readShort(), (float)var1.readShort(), (float)var1.readShort());
			this.method2348(var3);
		} else {
			for (int var4 = 0; var4 < 16; ++var4) {
				this.field3908[var4] = var1.method2586();
			}
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)[F",
		garbageValue = "-1165307425"
	)
	float[] method2338() {
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

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)[F",
		garbageValue = "83"
	)
	public float[] method2339() {
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

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "624646995"
	)
	void method2340() {
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

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1094416342"
	)
	public void method2341() {
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

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lrb;I)V",
		garbageValue = "-1754099381"
	)
	public void method2342(class465 var1) {
		System.arraycopy(var1.field3908, 0, this.field3908, 0, 16);
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(FI)V",
		garbageValue = "-184544595"
	)
	public void method2343(float var1) {
		this.method2344(var1, var1, var1);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(FFFI)V",
		garbageValue = "-1816436529"
	)
	public void method2344(float var1, float var2, float var3) {
		this.method2340();
		this.field3908[0] = var1;
		this.field3908[5] = var2;
		this.field3908[10] = var3;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Lrb;B)V",
		garbageValue = "6"
	)
	public void method2345(class465 var1) {
		for (int var2 = 0; var2 < this.field3908.length; ++var2) {
			float[] var10000 = this.field3908;
			var10000[var2] += var1.field3908[var2];
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lrb;B)V",
		garbageValue = "-104"
	)
	public void method2346(class465 var1) {
		float var2 = var1.field3908[0] * this.field3908[0] + var1.field3908[4] * this.field3908[1] + this.field3908[2] * var1.field3908[8] + var1.field3908[12] * this.field3908[3];
		float var3 = this.field3908[2] * var1.field3908[9] + this.field3908[1] * var1.field3908[5] + var1.field3908[1] * this.field3908[0] + this.field3908[3] * var1.field3908[13];
		float var4 = var1.field3908[14] * this.field3908[3] + var1.field3908[10] * this.field3908[2] + var1.field3908[6] * this.field3908[1] + var1.field3908[2] * this.field3908[0];
		float var5 = var1.field3908[15] * this.field3908[3] + var1.field3908[11] * this.field3908[2] + this.field3908[0] * var1.field3908[3] + this.field3908[1] * var1.field3908[7];
		float var6 = var1.field3908[12] * this.field3908[7] + var1.field3908[0] * this.field3908[4] + var1.field3908[4] * this.field3908[5] + this.field3908[6] * var1.field3908[8];
		float var7 = this.field3908[4] * var1.field3908[1] + var1.field3908[5] * this.field3908[5] + this.field3908[6] * var1.field3908[9] + var1.field3908[13] * this.field3908[7];
		float var8 = var1.field3908[10] * this.field3908[6] + var1.field3908[2] * this.field3908[4] + var1.field3908[6] * this.field3908[5] + this.field3908[7] * var1.field3908[14];
		float var9 = var1.field3908[11] * this.field3908[6] + this.field3908[5] * var1.field3908[7] + this.field3908[4] * var1.field3908[3] + this.field3908[7] * var1.field3908[15];
		float var10 = var1.field3908[0] * this.field3908[8] + this.field3908[9] * var1.field3908[4] + var1.field3908[8] * this.field3908[10] + var1.field3908[12] * this.field3908[11];
		float var11 = this.field3908[11] * var1.field3908[13] + this.field3908[10] * var1.field3908[9] + this.field3908[8] * var1.field3908[1] + var1.field3908[5] * this.field3908[9];
		float var12 = this.field3908[10] * var1.field3908[10] + this.field3908[9] * var1.field3908[6] + this.field3908[8] * var1.field3908[2] + var1.field3908[14] * this.field3908[11];
		float var13 = var1.field3908[3] * this.field3908[8] + var1.field3908[7] * this.field3908[9] + var1.field3908[11] * this.field3908[10] + var1.field3908[15] * this.field3908[11];
		float var14 = this.field3908[15] * var1.field3908[12] + this.field3908[14] * var1.field3908[8] + this.field3908[13] * var1.field3908[4] + this.field3908[12] * var1.field3908[0];
		float var15 = var1.field3908[13] * this.field3908[15] + var1.field3908[9] * this.field3908[14] + this.field3908[13] * var1.field3908[5] + var1.field3908[1] * this.field3908[12];
		float var16 = var1.field3908[14] * this.field3908[15] + var1.field3908[10] * this.field3908[14] + var1.field3908[6] * this.field3908[13] + var1.field3908[2] * this.field3908[12];
		float var17 = var1.field3908[11] * this.field3908[14] + this.field3908[12] * var1.field3908[3] + var1.field3908[7] * this.field3908[13] + this.field3908[15] * var1.field3908[15];
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

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lrd;I)V",
		garbageValue = "-2131255556"
	)
	public void method2347(class464 var1) {
		float var2 = var1.field3901 * var1.field3901;
		float var3 = var1.field3901 * var1.field3902;
		float var4 = var1.field3901 * var1.field3900;
		float var5 = var1.field3901 * var1.field3899;
		float var6 = var1.field3902 * var1.field3902;
		float var7 = var1.field3900 * var1.field3902;
		float var8 = var1.field3902 * var1.field3899;
		float var9 = var1.field3900 * var1.field3900;
		float var10 = var1.field3899 * var1.field3900;
		float var11 = var1.field3899 * var1.field3899;
		this.field3908[0] = var6 + var2 - var11 - var9;
		this.field3908[1] = var7 + var7 + var5 + var5;
		this.field3908[2] = var8 - var4 - var4 + var8;
		this.field3908[4] = var7 - var5 - var5 + var7;
		this.field3908[5] = var9 + var2 - var6 - var11;
		this.field3908[6] = var10 + var3 + var10 + var3;
		this.field3908[8] = var4 + var8 + var8 + var4;
		this.field3908[9] = var10 + (var10 - var3 - var3);
		this.field3908[10] = var11 + var2 - var9 - var6;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lrz;B)V",
		garbageValue = "76"
	)
	void method2348(class466 var1) {
		this.field3908[0] = var1.field3911;
		this.field3908[1] = var1.field3915;
		this.field3908[2] = var1.field3914;
		this.field3908[3] = 0.0F;
		this.field3908[4] = var1.field3920;
		this.field3908[5] = var1.field3917;
		this.field3908[6] = var1.field3913;
		this.field3908[7] = 0.0F;
		this.field3908[8] = var1.field3918;
		this.field3908[9] = var1.field3910;
		this.field3908[10] = var1.field3916;
		this.field3908[11] = 0.0F;
		this.field3908[12] = var1.field3919;
		this.field3908[13] = var1.field3912;
		this.field3908[14] = var1.field3909;
		this.field3908[15] = 1.0F;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(B)F",
		garbageValue = "-125"
	)
	float method2349() {
		return this.field3908[6] * this.field3908[3] * this.field3908[9] * this.field3908[12] + (this.field3908[10] * this.field3908[7] * this.field3908[1] * this.field3908[12] + (this.field3908[11] * this.field3908[4] * this.field3908[1] * this.field3908[14] + (this.field3908[14] * this.field3908[0] * this.field3908[7] * this.field3908[9] + this.field3908[15] * this.field3908[0] * this.field3908[5] * this.field3908[10] - this.field3908[14] * this.field3908[11] * this.field3908[5] * this.field3908[0] - this.field3908[15] * this.field3908[9] * this.field3908[6] * this.field3908[0] + this.field3908[11] * this.field3908[0] * this.field3908[6] * this.field3908[13] - this.field3908[10] * this.field3908[7] * this.field3908[0] * this.field3908[13] - this.field3908[10] * this.field3908[4] * this.field3908[1] * this.field3908[15]) + this.field3908[8] * this.field3908[6] * this.field3908[1] * this.field3908[15] - this.field3908[11] * this.field3908[6] * this.field3908[1] * this.field3908[12] - this.field3908[8] * this.field3908[7] * this.field3908[1] * this.field3908[14]) + this.field3908[15] * this.field3908[2] * this.field3908[4] * this.field3908[9] - this.field3908[13] * this.field3908[11] * this.field3908[2] * this.field3908[4] - this.field3908[15] * this.field3908[8] * this.field3908[5] * this.field3908[2] + this.field3908[2] * this.field3908[5] * this.field3908[11] * this.field3908[12] + this.field3908[13] * this.field3908[8] * this.field3908[7] * this.field3908[2] - this.field3908[12] * this.field3908[7] * this.field3908[2] * this.field3908[9] - this.field3908[14] * this.field3908[9] * this.field3908[4] * this.field3908[3] + this.field3908[13] * this.field3908[4] * this.field3908[3] * this.field3908[10] + this.field3908[5] * this.field3908[3] * this.field3908[8] * this.field3908[14] - this.field3908[10] * this.field3908[3] * this.field3908[5] * this.field3908[12] - this.field3908[13] * this.field3908[3] * this.field3908[6] * this.field3908[8]);
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1302965817"
	)
	public void method2350() {
		float var1 = 1.0F / this.method2349();
		float var2 = var1 * (this.field3908[13] * this.field3908[6] * this.field3908[11] + (this.field3908[10] * this.field3908[5] * this.field3908[15] - this.field3908[11] * this.field3908[5] * this.field3908[14] - this.field3908[15] * this.field3908[6] * this.field3908[9]) + this.field3908[7] * this.field3908[9] * this.field3908[14] - this.field3908[10] * this.field3908[7] * this.field3908[13]);
		float var3 = (this.field3908[14] * this.field3908[1] * this.field3908[11] + this.field3908[15] * this.field3908[10] * -this.field3908[1] + this.field3908[15] * this.field3908[2] * this.field3908[9] - this.field3908[11] * this.field3908[2] * this.field3908[13] - this.field3908[14] * this.field3908[3] * this.field3908[9] + this.field3908[13] * this.field3908[10] * this.field3908[3]) * var1;
		float var4 = (this.field3908[1] * this.field3908[6] * this.field3908[15] - this.field3908[14] * this.field3908[7] * this.field3908[1] - this.field3908[15] * this.field3908[2] * this.field3908[5] + this.field3908[13] * this.field3908[7] * this.field3908[2] + this.field3908[14] * this.field3908[3] * this.field3908[5] - this.field3908[13] * this.field3908[3] * this.field3908[6]) * var1;
		float var5 = var1 * (this.field3908[9] * this.field3908[3] * this.field3908[6] + (this.field3908[11] * this.field3908[2] * this.field3908[5] + this.field3908[6] * -this.field3908[1] * this.field3908[11] + this.field3908[1] * this.field3908[7] * this.field3908[10] - this.field3908[7] * this.field3908[2] * this.field3908[9] - this.field3908[10] * this.field3908[3] * this.field3908[5]));
		float var6 = var1 * (this.field3908[10] * this.field3908[7] * this.field3908[12] + (this.field3908[14] * this.field3908[11] * this.field3908[4] + this.field3908[15] * -this.field3908[4] * this.field3908[10] + this.field3908[15] * this.field3908[6] * this.field3908[8] - this.field3908[12] * this.field3908[6] * this.field3908[11] - this.field3908[14] * this.field3908[8] * this.field3908[7]));
		float var7 = (this.field3908[10] * this.field3908[0] * this.field3908[15] - this.field3908[0] * this.field3908[11] * this.field3908[14] - this.field3908[15] * this.field3908[2] * this.field3908[8] + this.field3908[2] * this.field3908[11] * this.field3908[12] + this.field3908[14] * this.field3908[8] * this.field3908[3] - this.field3908[10] * this.field3908[3] * this.field3908[12]) * var1;
		float var8 = var1 * (this.field3908[15] * this.field3908[6] * -this.field3908[0] + this.field3908[14] * this.field3908[7] * this.field3908[0] + this.field3908[2] * this.field3908[4] * this.field3908[15] - this.field3908[12] * this.field3908[7] * this.field3908[2] - this.field3908[14] * this.field3908[3] * this.field3908[4] + this.field3908[12] * this.field3908[3] * this.field3908[6]);
		float var9 = (this.field3908[10] * this.field3908[3] * this.field3908[4] + this.field3908[7] * this.field3908[2] * this.field3908[8] + (this.field3908[11] * this.field3908[6] * this.field3908[0] - this.field3908[7] * this.field3908[0] * this.field3908[10] - this.field3908[2] * this.field3908[4] * this.field3908[11]) - this.field3908[8] * this.field3908[3] * this.field3908[6]) * var1;
		float var10 = (this.field3908[15] * this.field3908[4] * this.field3908[9] - this.field3908[4] * this.field3908[11] * this.field3908[13] - this.field3908[5] * this.field3908[8] * this.field3908[15] + this.field3908[12] * this.field3908[5] * this.field3908[11] + this.field3908[13] * this.field3908[8] * this.field3908[7] - this.field3908[12] * this.field3908[7] * this.field3908[9]) * var1;
		float var11 = var1 * (this.field3908[12] * this.field3908[9] * this.field3908[3] + (this.field3908[15] * this.field3908[1] * this.field3908[8] + this.field3908[15] * -this.field3908[0] * this.field3908[9] + this.field3908[0] * this.field3908[11] * this.field3908[13] - this.field3908[11] * this.field3908[1] * this.field3908[12] - this.field3908[3] * this.field3908[8] * this.field3908[13]));
		float var12 = (this.field3908[13] * this.field3908[4] * this.field3908[3] + this.field3908[7] * this.field3908[1] * this.field3908[12] + (this.field3908[0] * this.field3908[5] * this.field3908[15] - this.field3908[0] * this.field3908[7] * this.field3908[13] - this.field3908[15] * this.field3908[4] * this.field3908[1]) - this.field3908[5] * this.field3908[3] * this.field3908[12]) * var1;
		float var13 = (this.field3908[9] * this.field3908[7] * this.field3908[0] + this.field3908[5] * -this.field3908[0] * this.field3908[11] + this.field3908[11] * this.field3908[4] * this.field3908[1] - this.field3908[7] * this.field3908[1] * this.field3908[8] - this.field3908[4] * this.field3908[3] * this.field3908[9] + this.field3908[8] * this.field3908[5] * this.field3908[3]) * var1;
		float var14 = (this.field3908[12] * this.field3908[6] * this.field3908[9] + (this.field3908[13] * this.field3908[4] * this.field3908[10] + -this.field3908[4] * this.field3908[9] * this.field3908[14] + this.field3908[8] * this.field3908[5] * this.field3908[14] - this.field3908[12] * this.field3908[10] * this.field3908[5] - this.field3908[13] * this.field3908[6] * this.field3908[8])) * var1;
		float var15 = (this.field3908[9] * this.field3908[0] * this.field3908[14] - this.field3908[13] * this.field3908[0] * this.field3908[10] - this.field3908[14] * this.field3908[1] * this.field3908[8] + this.field3908[10] * this.field3908[1] * this.field3908[12] + this.field3908[13] * this.field3908[8] * this.field3908[2] - this.field3908[12] * this.field3908[2] * this.field3908[9]) * var1;
		float var16 = var1 * (this.field3908[4] * this.field3908[1] * this.field3908[14] + this.field3908[14] * this.field3908[5] * -this.field3908[0] + this.field3908[0] * this.field3908[6] * this.field3908[13] - this.field3908[1] * this.field3908[6] * this.field3908[12] - this.field3908[2] * this.field3908[4] * this.field3908[13] + this.field3908[5] * this.field3908[2] * this.field3908[12]);
		float var17 = var1 * (this.field3908[4] * this.field3908[2] * this.field3908[9] + this.field3908[5] * this.field3908[0] * this.field3908[10] - this.field3908[9] * this.field3908[0] * this.field3908[6] - this.field3908[10] * this.field3908[4] * this.field3908[1] + this.field3908[8] * this.field3908[1] * this.field3908[6] - this.field3908[5] * this.field3908[2] * this.field3908[8]);
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

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[F",
		garbageValue = "1974456847"
	)
	public float[] method2351() {
		float[] var1 = new float[3];
		class463 var2 = new class463(this.field3908[0], this.field3908[1], this.field3908[2]);
		class463 var3 = new class463(this.field3908[4], this.field3908[5], this.field3908[6]);
		class463 var4 = new class463(this.field3908[8], this.field3908[9], this.field3908[10]);
		var1[0] = var2.method2328();
		var1[1] = var3.method2328();
		var1[2] = var4.method2328();
		return var1;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		StringBuilder var1 = new StringBuilder();
		this.method2339();
		this.method2338();

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
		if (!(var1 instanceof class465)) {
			return false;
		} else {
			class465 var2 = (class465)var1;

			for (int var3 = 0; var3 < 16; ++var3) {
				if (var2.field3908[var3] != this.field3908[var3]) {
					return false;
				}
			}

			return true;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "([BILjava/lang/CharSequence;B)I",
		garbageValue = "-72"
	)
	public static int method2335(byte[] var0, int var1, CharSequence var2) {
		int var3 = var2.length();
		int var4 = var1;

		for (int var5 = 0; var5 < var3; ++var5) {
			char var6 = var2.charAt(var5);
			if (var6 <= 127) {
				var0[var4++] = (byte)var6;
			} else if (var6 <= 2047) {
				var0[var4++] = (byte)(192 | var6 >> 6);
				var0[var4++] = (byte)(128 | var6 & '?');
			} else {
				var0[var4++] = (byte)(224 | var6 >> '\f');
				var0[var4++] = (byte)(128 | var6 >> 6 & 63);
				var0[var4++] = (byte)(128 | var6 & '?');
			}
		}

		return var4 - var1;
	}
}