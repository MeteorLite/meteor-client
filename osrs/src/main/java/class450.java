import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("rz")
public final class class450 {
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "[Lrz;"
	)
	public static class450[] field3873;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lrz;"
	)
	public static final class450 field3874;
	@ObfuscatedName("ac")
	public float[] field3875;

	static {
		field3873 = new class450[0];
		class272.method1544(100);
		field3874 = new class450();
	}

	public class450() {
		this.field3875 = new float[16];
		this.method2302();
	}

	@ObfuscatedSignature(
		descriptor = "(Lrz;)V"
	)
	public class450(class450 var1) {
		this.field3875 = new float[16];
		this.method2304(var1);
	}

	@ObfuscatedSignature(
		descriptor = "(Ltm;Z)V"
	)
	public class450(Buffer var1, boolean var2) {
		this.field3875 = new float[16];
		this.method2299(var1, var2);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1723077119"
	)
	public void method2298() {
		synchronized(field3873) {
			if (class462.field3904 < GrandExchangeOfferOwnWorldComparator.field361 - 1) {
				field3873[++class462.field3904 - 1] = this;
			}

		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ltm;ZI)V",
		garbageValue = "1560038466"
	)
	void method2299(Buffer var1, boolean var2) {
		if (var2) {
			class451 var3 = new class451();
			int var6 = var1.readShort();
			var6 &= 16383;
			float var5 = (float)(6.283185307179586D * (double)((float)var6 / 16384.0F));
			var3.method2315(var5);
			int var9 = var1.readShort();
			var9 &= 16383;
			float var8 = (float)((double)((float)var9 / 16384.0F) * 6.283185307179586D);
			var3.method2316(var8);
			int var12 = var1.readShort();
			var12 &= 16383;
			float var11 = (float)((double)((float)var12 / 16384.0F) * 6.283185307179586D);
			var3.method2317(var11);
			var3.method2318((float)var1.readShort(), (float)var1.readShort(), (float)var1.readShort());
			this.method2310(var3);
		} else {
			for (int var13 = 0; var13 < 16; ++var13) {
				this.field3875[var13] = var1.method2551();
			}
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)[F",
		garbageValue = "-57"
	)
	float[] method2300() {
		float[] var1 = new float[3];
		if ((double)this.field3875[2] < 0.999D && (double)this.field3875[2] > -0.999D) {
			var1[1] = (float)(-Math.asin((double)this.field3875[2]));
			double var2 = Math.cos((double)var1[1]);
			var1[0] = (float)Math.atan2((double)this.field3875[6] / var2, (double)this.field3875[10] / var2);
			var1[2] = (float)Math.atan2((double)this.field3875[1] / var2, (double)this.field3875[0] / var2);
		} else {
			var1[0] = 0.0F;
			var1[1] = (float)Math.atan2((double)this.field3875[2], 0.0D);
			var1[2] = (float)Math.atan2((double)(-this.field3875[9]), (double)this.field3875[5]);
		}

		return var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)[F",
		garbageValue = "1952444493"
	)
	public float[] method2301() {
		float[] var1 = new float[]{(float)(-Math.asin((double)this.field3875[6])), 0.0F, 0.0F};
		double var2 = Math.cos((double)var1[0]);
		double var4;
		double var6;
		if (Math.abs(var2) > 0.005D) {
			var4 = (double)this.field3875[2];
			var6 = (double)this.field3875[10];
			double var8 = (double)this.field3875[4];
			double var10 = (double)this.field3875[5];
			var1[1] = (float)Math.atan2(var4, var6);
			var1[2] = (float)Math.atan2(var8, var10);
		} else {
			var4 = (double)this.field3875[1];
			var6 = (double)this.field3875[0];
			if (this.field3875[6] < 0.0F) {
				var1[1] = (float)Math.atan2(var4, var6);
			} else {
				var1[1] = (float)(-Math.atan2(var4, var6));
			}

			var1[2] = 0.0F;
		}

		return var1;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1131918254"
	)
	public void method2302() {
		this.field3875[0] = 1.0F;
		this.field3875[1] = 0.0F;
		this.field3875[2] = 0.0F;
		this.field3875[3] = 0.0F;
		this.field3875[4] = 0.0F;
		this.field3875[5] = 1.0F;
		this.field3875[6] = 0.0F;
		this.field3875[7] = 0.0F;
		this.field3875[8] = 0.0F;
		this.field3875[9] = 0.0F;
		this.field3875[10] = 1.0F;
		this.field3875[11] = 0.0F;
		this.field3875[12] = 0.0F;
		this.field3875[13] = 0.0F;
		this.field3875[14] = 0.0F;
		this.field3875[15] = 1.0F;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "109"
	)
	public void method2303() {
		this.field3875[0] = 0.0F;
		this.field3875[1] = 0.0F;
		this.field3875[2] = 0.0F;
		this.field3875[3] = 0.0F;
		this.field3875[4] = 0.0F;
		this.field3875[5] = 0.0F;
		this.field3875[6] = 0.0F;
		this.field3875[7] = 0.0F;
		this.field3875[8] = 0.0F;
		this.field3875[9] = 0.0F;
		this.field3875[10] = 0.0F;
		this.field3875[11] = 0.0F;
		this.field3875[12] = 0.0F;
		this.field3875[13] = 0.0F;
		this.field3875[14] = 0.0F;
		this.field3875[15] = 0.0F;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lrz;I)V",
		garbageValue = "1658923125"
	)
	public void method2304(class450 var1) {
		System.arraycopy(var1.field3875, 0, this.field3875, 0, 16);
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(FB)V",
		garbageValue = "54"
	)
	public void method2305(float var1) {
		this.method2306(var1, var1, var1);
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(FFFB)V",
		garbageValue = "0"
	)
	public void method2306(float var1, float var2, float var3) {
		this.method2302();
		this.field3875[0] = var1;
		this.field3875[5] = var2;
		this.field3875[10] = var3;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(Lrz;I)V",
		garbageValue = "1420506541"
	)
	public void method2307(class450 var1) {
		for (int var2 = 0; var2 < this.field3875.length; ++var2) {
			float[] var10000 = this.field3875;
			var10000[var2] += var1.field3875[var2];
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Lrz;I)V",
		garbageValue = "2026698221"
	)
	public void method2308(class450 var1) {
		float var2 = this.field3875[2] * var1.field3875[8] + var1.field3875[0] * this.field3875[0] + var1.field3875[4] * this.field3875[1] + var1.field3875[12] * this.field3875[3];
		float var3 = this.field3875[0] * var1.field3875[1] + var1.field3875[5] * this.field3875[1] + var1.field3875[9] * this.field3875[2] + this.field3875[3] * var1.field3875[13];
		float var4 = var1.field3875[14] * this.field3875[3] + this.field3875[2] * var1.field3875[10] + var1.field3875[6] * this.field3875[1] + var1.field3875[2] * this.field3875[0];
		float var5 = this.field3875[0] * var1.field3875[3] + var1.field3875[7] * this.field3875[1] + this.field3875[2] * var1.field3875[11] + this.field3875[3] * var1.field3875[15];
		float var6 = this.field3875[7] * var1.field3875[12] + this.field3875[4] * var1.field3875[0] + this.field3875[5] * var1.field3875[4] + var1.field3875[8] * this.field3875[6];
		float var7 = this.field3875[6] * var1.field3875[9] + var1.field3875[1] * this.field3875[4] + var1.field3875[5] * this.field3875[5] + this.field3875[7] * var1.field3875[13];
		float var8 = this.field3875[7] * var1.field3875[14] + this.field3875[5] * var1.field3875[6] + this.field3875[4] * var1.field3875[2] + var1.field3875[10] * this.field3875[6];
		float var9 = var1.field3875[15] * this.field3875[7] + this.field3875[6] * var1.field3875[11] + this.field3875[4] * var1.field3875[3] + this.field3875[5] * var1.field3875[7];
		float var10 = var1.field3875[12] * this.field3875[11] + this.field3875[10] * var1.field3875[8] + var1.field3875[4] * this.field3875[9] + this.field3875[8] * var1.field3875[0];
		float var11 = this.field3875[11] * var1.field3875[13] + this.field3875[9] * var1.field3875[5] + var1.field3875[1] * this.field3875[8] + var1.field3875[9] * this.field3875[10];
		float var12 = var1.field3875[14] * this.field3875[11] + this.field3875[9] * var1.field3875[6] + var1.field3875[2] * this.field3875[8] + this.field3875[10] * var1.field3875[10];
		float var13 = var1.field3875[15] * this.field3875[11] + var1.field3875[11] * this.field3875[10] + var1.field3875[7] * this.field3875[9] + this.field3875[8] * var1.field3875[3];
		float var14 = this.field3875[14] * var1.field3875[8] + var1.field3875[0] * this.field3875[12] + this.field3875[13] * var1.field3875[4] + this.field3875[15] * var1.field3875[12];
		float var15 = var1.field3875[13] * this.field3875[15] + var1.field3875[5] * this.field3875[13] + this.field3875[12] * var1.field3875[1] + var1.field3875[9] * this.field3875[14];
		float var16 = this.field3875[14] * var1.field3875[10] + var1.field3875[6] * this.field3875[13] + this.field3875[12] * var1.field3875[2] + var1.field3875[14] * this.field3875[15];
		float var17 = var1.field3875[15] * this.field3875[15] + var1.field3875[3] * this.field3875[12] + this.field3875[13] * var1.field3875[7] + var1.field3875[11] * this.field3875[14];
		this.field3875[0] = var2;
		this.field3875[1] = var3;
		this.field3875[2] = var4;
		this.field3875[3] = var5;
		this.field3875[4] = var6;
		this.field3875[5] = var7;
		this.field3875[6] = var8;
		this.field3875[7] = var9;
		this.field3875[8] = var10;
		this.field3875[9] = var11;
		this.field3875[10] = var12;
		this.field3875[11] = var13;
		this.field3875[12] = var14;
		this.field3875[13] = var15;
		this.field3875[14] = var16;
		this.field3875[15] = var17;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lro;I)V",
		garbageValue = "1037679755"
	)
	public void method2309(class449 var1) {
		float var2 = var1.field3872 * var1.field3872;
		float var3 = var1.field3871 * var1.field3872;
		float var4 = var1.field3872 * var1.field3869;
		float var5 = var1.field3870 * var1.field3872;
		float var6 = var1.field3871 * var1.field3871;
		float var7 = var1.field3871 * var1.field3869;
		float var8 = var1.field3870 * var1.field3871;
		float var9 = var1.field3869 * var1.field3869;
		float var10 = var1.field3869 * var1.field3870;
		float var11 = var1.field3870 * var1.field3870;
		this.field3875[0] = var6 + var2 - var11 - var9;
		this.field3875[1] = var7 + var5 + var7 + var5;
		this.field3875[2] = var8 - var4 - var4 + var8;
		this.field3875[4] = var7 - var5 - var5 + var7;
		this.field3875[5] = var2 + var9 - var6 - var11;
		this.field3875[6] = var3 + var10 + var3 + var10;
		this.field3875[8] = var8 + var4 + var8 + var4;
		this.field3875[9] = var10 - var3 - var3 + var10;
		this.field3875[10] = var11 + var2 - var9 - var6;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Lrm;I)V",
		garbageValue = "-552331483"
	)
	void method2310(class451 var1) {
		this.field3875[0] = var1.field3887;
		this.field3875[1] = var1.field3880;
		this.field3875[2] = var1.field3883;
		this.field3875[3] = 0.0F;
		this.field3875[4] = var1.field3886;
		this.field3875[5] = var1.field3878;
		this.field3875[6] = var1.field3882;
		this.field3875[7] = 0.0F;
		this.field3875[8] = var1.field3888;
		this.field3875[9] = var1.field3884;
		this.field3875[10] = var1.field3877;
		this.field3875[11] = 0.0F;
		this.field3875[12] = var1.field3881;
		this.field3875[13] = var1.field3879;
		this.field3875[14] = var1.field3885;
		this.field3875[15] = 1.0F;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)F",
		garbageValue = "-1874677140"
	)
	float method2311() {
		return this.field3875[12] * this.field3875[9] * this.field3875[6] * this.field3875[3] + (this.field3875[8] * this.field3875[7] * this.field3875[2] * this.field3875[13] + this.field3875[8] * this.field3875[1] * this.field3875[6] * this.field3875[15] + this.field3875[14] * this.field3875[11] * this.field3875[4] * this.field3875[1] + (this.field3875[0] * this.field3875[7] * this.field3875[9] * this.field3875[14] + this.field3875[15] * this.field3875[5] * this.field3875[0] * this.field3875[10] - this.field3875[0] * this.field3875[5] * this.field3875[11] * this.field3875[14] - this.field3875[15] * this.field3875[0] * this.field3875[6] * this.field3875[9] + this.field3875[13] * this.field3875[0] * this.field3875[6] * this.field3875[11] - this.field3875[10] * this.field3875[0] * this.field3875[7] * this.field3875[13] - this.field3875[15] * this.field3875[4] * this.field3875[1] * this.field3875[10]) - this.field3875[12] * this.field3875[1] * this.field3875[6] * this.field3875[11] - this.field3875[7] * this.field3875[1] * this.field3875[8] * this.field3875[14] + this.field3875[12] * this.field3875[10] * this.field3875[7] * this.field3875[1] + this.field3875[15] * this.field3875[4] * this.field3875[2] * this.field3875[9] - this.field3875[13] * this.field3875[11] * this.field3875[4] * this.field3875[2] - this.field3875[15] * this.field3875[8] * this.field3875[2] * this.field3875[5] + this.field3875[11] * this.field3875[2] * this.field3875[5] * this.field3875[12] - this.field3875[9] * this.field3875[7] * this.field3875[2] * this.field3875[12] - this.field3875[14] * this.field3875[3] * this.field3875[4] * this.field3875[9] + this.field3875[13] * this.field3875[10] * this.field3875[4] * this.field3875[3] + this.field3875[14] * this.field3875[8] * this.field3875[5] * this.field3875[3] - this.field3875[12] * this.field3875[3] * this.field3875[5] * this.field3875[10] - this.field3875[6] * this.field3875[3] * this.field3875[8] * this.field3875[13]);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-93"
	)
	public void method2312() {
		float var1 = 1.0F / this.method2311();
		float var2 = (this.field3875[11] * this.field3875[6] * this.field3875[13] + (this.field3875[15] * this.field3875[5] * this.field3875[10] - this.field3875[14] * this.field3875[11] * this.field3875[5] - this.field3875[9] * this.field3875[6] * this.field3875[15]) + this.field3875[14] * this.field3875[7] * this.field3875[9] - this.field3875[7] * this.field3875[10] * this.field3875[13]) * var1;
		float var3 = (this.field3875[13] * this.field3875[3] * this.field3875[10] + (this.field3875[15] * -this.field3875[1] * this.field3875[10] + this.field3875[14] * this.field3875[11] * this.field3875[1] + this.field3875[9] * this.field3875[2] * this.field3875[15] - this.field3875[11] * this.field3875[2] * this.field3875[13] - this.field3875[14] * this.field3875[9] * this.field3875[3])) * var1;
		float var4 = (this.field3875[15] * this.field3875[6] * this.field3875[1] - this.field3875[1] * this.field3875[7] * this.field3875[14] - this.field3875[15] * this.field3875[2] * this.field3875[5] + this.field3875[2] * this.field3875[7] * this.field3875[13] + this.field3875[3] * this.field3875[5] * this.field3875[14] - this.field3875[13] * this.field3875[6] * this.field3875[3]) * var1;
		float var5 = (this.field3875[9] * this.field3875[3] * this.field3875[6] + (this.field3875[7] * this.field3875[1] * this.field3875[10] + this.field3875[11] * -this.field3875[1] * this.field3875[6] + this.field3875[11] * this.field3875[2] * this.field3875[5] - this.field3875[7] * this.field3875[2] * this.field3875[9] - this.field3875[5] * this.field3875[3] * this.field3875[10])) * var1;
		float var6 = (this.field3875[12] * this.field3875[10] * this.field3875[7] + (this.field3875[6] * this.field3875[8] * this.field3875[15] + this.field3875[15] * this.field3875[10] * -this.field3875[4] + this.field3875[4] * this.field3875[11] * this.field3875[14] - this.field3875[11] * this.field3875[6] * this.field3875[12] - this.field3875[14] * this.field3875[8] * this.field3875[7])) * var1;
		float var7 = (this.field3875[2] * this.field3875[11] * this.field3875[12] + (this.field3875[0] * this.field3875[10] * this.field3875[15] - this.field3875[14] * this.field3875[0] * this.field3875[11] - this.field3875[15] * this.field3875[2] * this.field3875[8]) + this.field3875[14] * this.field3875[8] * this.field3875[3] - this.field3875[3] * this.field3875[10] * this.field3875[12]) * var1;
		float var8 = (this.field3875[15] * this.field3875[2] * this.field3875[4] + this.field3875[15] * this.field3875[6] * -this.field3875[0] + this.field3875[0] * this.field3875[7] * this.field3875[14] - this.field3875[7] * this.field3875[2] * this.field3875[12] - this.field3875[3] * this.field3875[4] * this.field3875[14] + this.field3875[12] * this.field3875[3] * this.field3875[6]) * var1;
		float var9 = (this.field3875[10] * this.field3875[4] * this.field3875[3] + this.field3875[0] * this.field3875[6] * this.field3875[11] - this.field3875[10] * this.field3875[0] * this.field3875[7] - this.field3875[2] * this.field3875[4] * this.field3875[11] + this.field3875[7] * this.field3875[2] * this.field3875[8] - this.field3875[8] * this.field3875[6] * this.field3875[3]) * var1;
		float var10 = (this.field3875[15] * this.field3875[4] * this.field3875[9] - this.field3875[13] * this.field3875[4] * this.field3875[11] - this.field3875[15] * this.field3875[5] * this.field3875[8] + this.field3875[11] * this.field3875[5] * this.field3875[12] + this.field3875[13] * this.field3875[8] * this.field3875[7] - this.field3875[12] * this.field3875[9] * this.field3875[7]) * var1;
		float var11 = var1 * (this.field3875[15] * this.field3875[9] * -this.field3875[0] + this.field3875[13] * this.field3875[0] * this.field3875[11] + this.field3875[1] * this.field3875[8] * this.field3875[15] - this.field3875[11] * this.field3875[1] * this.field3875[12] - this.field3875[8] * this.field3875[3] * this.field3875[13] + this.field3875[9] * this.field3875[3] * this.field3875[12]);
		float var12 = (this.field3875[4] * this.field3875[3] * this.field3875[13] + this.field3875[12] * this.field3875[1] * this.field3875[7] + (this.field3875[15] * this.field3875[5] * this.field3875[0] - this.field3875[13] * this.field3875[0] * this.field3875[7] - this.field3875[1] * this.field3875[4] * this.field3875[15]) - this.field3875[12] * this.field3875[3] * this.field3875[5]) * var1;
		float var13 = var1 * (this.field3875[8] * this.field3875[3] * this.field3875[5] + (-this.field3875[0] * this.field3875[5] * this.field3875[11] + this.field3875[9] * this.field3875[7] * this.field3875[0] + this.field3875[4] * this.field3875[1] * this.field3875[11] - this.field3875[8] * this.field3875[1] * this.field3875[7] - this.field3875[3] * this.field3875[4] * this.field3875[9]));
		float var14 = (this.field3875[12] * this.field3875[6] * this.field3875[9] + (this.field3875[14] * this.field3875[9] * -this.field3875[4] + this.field3875[13] * this.field3875[10] * this.field3875[4] + this.field3875[8] * this.field3875[5] * this.field3875[14] - this.field3875[12] * this.field3875[10] * this.field3875[5] - this.field3875[8] * this.field3875[6] * this.field3875[13])) * var1;
		float var15 = (this.field3875[13] * this.field3875[8] * this.field3875[2] + this.field3875[0] * this.field3875[9] * this.field3875[14] - this.field3875[13] * this.field3875[0] * this.field3875[10] - this.field3875[1] * this.field3875[8] * this.field3875[14] + this.field3875[1] * this.field3875[10] * this.field3875[12] - this.field3875[12] * this.field3875[2] * this.field3875[9]) * var1;
		float var16 = var1 * (-this.field3875[0] * this.field3875[5] * this.field3875[14] + this.field3875[6] * this.field3875[0] * this.field3875[13] + this.field3875[14] * this.field3875[1] * this.field3875[4] - this.field3875[6] * this.field3875[1] * this.field3875[12] - this.field3875[4] * this.field3875[2] * this.field3875[13] + this.field3875[2] * this.field3875[5] * this.field3875[12]);
		float var17 = (this.field3875[5] * this.field3875[0] * this.field3875[10] - this.field3875[0] * this.field3875[6] * this.field3875[9] - this.field3875[1] * this.field3875[4] * this.field3875[10] + this.field3875[1] * this.field3875[6] * this.field3875[8] + this.field3875[2] * this.field3875[4] * this.field3875[9] - this.field3875[8] * this.field3875[2] * this.field3875[5]) * var1;
		this.field3875[0] = var2;
		this.field3875[1] = var3;
		this.field3875[2] = var4;
		this.field3875[3] = var5;
		this.field3875[4] = var6;
		this.field3875[5] = var7;
		this.field3875[6] = var8;
		this.field3875[7] = var9;
		this.field3875[8] = var10;
		this.field3875[9] = var11;
		this.field3875[10] = var12;
		this.field3875[11] = var13;
		this.field3875[12] = var14;
		this.field3875[13] = var15;
		this.field3875[14] = var16;
		this.field3875[15] = var17;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)[F",
		garbageValue = "6"
	)
	public float[] method2313() {
		float[] var1 = new float[3];
		class448 var2 = new class448(this.field3875[0], this.field3875[1], this.field3875[2]);
		class448 var3 = new class448(this.field3875[4], this.field3875[5], this.field3875[6]);
		class448 var4 = new class448(this.field3875[8], this.field3875[9], this.field3875[10]);
		var1[0] = var2.method2291();
		var1[1] = var3.method2291();
		var1[2] = var4.method2291();
		return var1;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		StringBuilder var1 = new StringBuilder();
		this.method2301();
		this.method2300();

		for (int var2 = 0; var2 < 4; ++var2) {
			for (int var3 = 0; var3 < 4; ++var3) {
				if (var3 > 0) {
					var1.append("\t");
				}

				float var4 = this.field3875[var3 + var2 * 4];
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
		int var3 = var2 * 31 + Arrays.hashCode(this.field3875);
		return var3;
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (!(var1 instanceof class450)) {
			return false;
		} else {
			class450 var2 = (class450)var1;

			for (int var3 = 0; var3 < 16; ++var3) {
				if (this.field3875[var3] != var2.field3875[var3]) {
					return false;
				}
			}

			return true;
		}
	}
}