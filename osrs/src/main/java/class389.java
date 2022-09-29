import java.util.Arrays;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nw")
public final class class389 {
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "[Lnw;"
	)
	static class389[] field4437;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lnw;"
	)
	public static final class389 field4438;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 310732121
	)
	static int field4441;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1392359511
	)
	static int field4439;
	@ObfuscatedName("w")
	public float[] field4440;

	static {
		field4437 = new class389[0];
		field4441 = 100;
		field4437 = new class389[100];
		field4439 = 0;
		field4438 = new class389();
	}

	public class389() {
		this.field4440 = new float[16];
		this.method7172();
	}

	@ObfuscatedSignature(
		descriptor = "(Lnw;)V"
	)
	public class389(class389 var1) {
		this.field4440 = new float[16];
		this.method7227(var1);
	}

	@ObfuscatedSignature(
		descriptor = "(Lqq;Z)V"
	)
	public class389(Buffer var1, boolean var2) {
		this.field4440 = new float[16];
		this.method7169(var1, var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-901327832"
	)
	public void method7203() {
		synchronized(field4437) {
			if (field4439 < field4441 - 1) {
				field4437[++field4439 - 1] = this;
			}

		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Lqq;ZI)V",
		garbageValue = "-1302105045"
	)
	void method7169(Buffer var1, boolean var2) {
		if (var2) {
			class390 var4 = new class390();
			var4.method7240(UserComparator6.method2792(var1.readShort()));
			var4.method7235(UserComparator6.method2792(var1.readShort()));
			var4.method7236(UserComparator6.method2792(var1.readShort()));
			var4.method7237((float)var1.readShort(), (float)var1.readShort(), (float)var1.readShort());
			this.method7180(var4);
		} else {
			for (int var3 = 0; var3 < 16; ++var3) {
				this.field4440[var3] = var1.method7930();
			}
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(I)[F",
		garbageValue = "1579058177"
	)
	float[] method7170() {
		float[] var1 = new float[3];
		if ((double)this.field4440[2] < 0.999D && (double)this.field4440[2] > -0.999D) {
			var1[1] = (float)(-Math.asin((double)this.field4440[2]));
			double var2 = Math.cos((double)var1[1]);
			var1[0] = (float)Math.atan2((double)this.field4440[6] / var2, (double)this.field4440[10] / var2);
			var1[2] = (float)Math.atan2((double)this.field4440[1] / var2, (double)this.field4440[0] / var2);
		} else {
			var1[0] = 0.0F;
			var1[1] = (float)Math.atan2((double)this.field4440[2], 0.0D);
			var1[2] = (float)Math.atan2((double)(-this.field4440[9]), (double)this.field4440[5]);
		}

		return var1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(B)[F",
		garbageValue = "-51"
	)
	public float[] method7206() {
		float[] var1 = new float[]{(float)(-Math.asin((double)this.field4440[6])), 0.0F, 0.0F};
		double var2 = Math.cos((double)var1[0]);
		double var4;
		double var6;
		if (Math.abs(var2) > 0.005D) {
			var4 = (double)this.field4440[2];
			var6 = (double)this.field4440[10];
			double var8 = (double)this.field4440[4];
			double var10 = (double)this.field4440[5];
			var1[1] = (float)Math.atan2(var4, var6);
			var1[2] = (float)Math.atan2(var8, var10);
		} else {
			var4 = (double)this.field4440[1];
			var6 = (double)this.field4440[0];
			if (this.field4440[6] < 0.0F) {
				var1[1] = (float)Math.atan2(var4, var6);
			} else {
				var1[1] = (float)(-Math.atan2(var4, var6));
			}

			var1[2] = 0.0F;
		}

		return var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "578515372"
	)
	void method7172() {
		this.field4440[0] = 1.0F;
		this.field4440[1] = 0.0F;
		this.field4440[2] = 0.0F;
		this.field4440[3] = 0.0F;
		this.field4440[4] = 0.0F;
		this.field4440[5] = 1.0F;
		this.field4440[6] = 0.0F;
		this.field4440[7] = 0.0F;
		this.field4440[8] = 0.0F;
		this.field4440[9] = 0.0F;
		this.field4440[10] = 1.0F;
		this.field4440[11] = 0.0F;
		this.field4440[12] = 0.0F;
		this.field4440[13] = 0.0F;
		this.field4440[14] = 0.0F;
		this.field4440[15] = 1.0F;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "145510553"
	)
	public void method7173() {
		this.field4440[0] = 0.0F;
		this.field4440[1] = 0.0F;
		this.field4440[2] = 0.0F;
		this.field4440[3] = 0.0F;
		this.field4440[4] = 0.0F;
		this.field4440[5] = 0.0F;
		this.field4440[6] = 0.0F;
		this.field4440[7] = 0.0F;
		this.field4440[8] = 0.0F;
		this.field4440[9] = 0.0F;
		this.field4440[10] = 0.0F;
		this.field4440[11] = 0.0F;
		this.field4440[12] = 0.0F;
		this.field4440[13] = 0.0F;
		this.field4440[14] = 0.0F;
		this.field4440[15] = 0.0F;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(Lnw;B)V",
		garbageValue = "100"
	)
	public void method7227(class389 var1) {
		System.arraycopy(var1.field4440, 0, this.field4440, 0, 16);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "(FI)V",
		garbageValue = "1635594797"
	)
	public void method7201(float var1) {
		this.method7176(var1, var1, var1);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(FFFB)V",
		garbageValue = "81"
	)
	public void method7176(float var1, float var2, float var3) {
		this.method7172();
		this.field4440[0] = var1;
		this.field4440[5] = var2;
		this.field4440[10] = var3;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(Lnw;I)V",
		garbageValue = "1550721431"
	)
	public void method7221(class389 var1) {
		for (int var2 = 0; var2 < this.field4440.length; ++var2) {
			float[] var10000 = this.field4440;
			var10000[var2] += var1.field4440[var2];
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "(Lnw;I)V",
		garbageValue = "363548376"
	)
	public void method7178(class389 var1) {
		float var2 = var1.field4440[12] * this.field4440[3] + var1.field4440[8] * this.field4440[2] + this.field4440[0] * var1.field4440[0] + var1.field4440[4] * this.field4440[1];
		float var3 = this.field4440[2] * var1.field4440[9] + this.field4440[1] * var1.field4440[5] + this.field4440[0] * var1.field4440[1] + var1.field4440[13] * this.field4440[3];
		float var4 = var1.field4440[14] * this.field4440[3] + this.field4440[0] * var1.field4440[2] + this.field4440[1] * var1.field4440[6] + var1.field4440[10] * this.field4440[2];
		float var5 = this.field4440[2] * var1.field4440[11] + var1.field4440[3] * this.field4440[0] + this.field4440[1] * var1.field4440[7] + this.field4440[3] * var1.field4440[15];
		float var6 = var1.field4440[0] * this.field4440[4] + var1.field4440[4] * this.field4440[5] + var1.field4440[8] * this.field4440[6] + var1.field4440[12] * this.field4440[7];
		float var7 = var1.field4440[13] * this.field4440[7] + this.field4440[6] * var1.field4440[9] + this.field4440[5] * var1.field4440[5] + var1.field4440[1] * this.field4440[4];
		float var8 = var1.field4440[2] * this.field4440[4] + var1.field4440[6] * this.field4440[5] + this.field4440[6] * var1.field4440[10] + this.field4440[7] * var1.field4440[14];
		float var9 = this.field4440[4] * var1.field4440[3] + this.field4440[5] * var1.field4440[7] + var1.field4440[11] * this.field4440[6] + var1.field4440[15] * this.field4440[7];
		float var10 = var1.field4440[8] * this.field4440[10] + var1.field4440[0] * this.field4440[8] + this.field4440[9] * var1.field4440[4] + this.field4440[11] * var1.field4440[12];
		float var11 = this.field4440[11] * var1.field4440[13] + this.field4440[9] * var1.field4440[5] + this.field4440[8] * var1.field4440[1] + var1.field4440[9] * this.field4440[10];
		float var12 = var1.field4440[14] * this.field4440[11] + this.field4440[9] * var1.field4440[6] + this.field4440[8] * var1.field4440[2] + this.field4440[10] * var1.field4440[10];
		float var13 = this.field4440[9] * var1.field4440[7] + var1.field4440[3] * this.field4440[8] + var1.field4440[11] * this.field4440[10] + this.field4440[11] * var1.field4440[15];
		float var14 = var1.field4440[12] * this.field4440[15] + this.field4440[12] * var1.field4440[0] + this.field4440[13] * var1.field4440[4] + this.field4440[14] * var1.field4440[8];
		float var15 = this.field4440[13] * var1.field4440[5] + var1.field4440[1] * this.field4440[12] + this.field4440[14] * var1.field4440[9] + this.field4440[15] * var1.field4440[13];
		float var16 = this.field4440[14] * var1.field4440[10] + this.field4440[12] * var1.field4440[2] + var1.field4440[6] * this.field4440[13] + this.field4440[15] * var1.field4440[14];
		float var17 = this.field4440[15] * var1.field4440[15] + this.field4440[14] * var1.field4440[11] + this.field4440[13] * var1.field4440[7] + this.field4440[12] * var1.field4440[3];
		this.field4440[0] = var2;
		this.field4440[1] = var3;
		this.field4440[2] = var4;
		this.field4440[3] = var5;
		this.field4440[4] = var6;
		this.field4440[5] = var7;
		this.field4440[6] = var8;
		this.field4440[7] = var9;
		this.field4440[8] = var10;
		this.field4440[9] = var11;
		this.field4440[10] = var12;
		this.field4440[11] = var13;
		this.field4440[12] = var14;
		this.field4440[13] = var15;
		this.field4440[14] = var16;
		this.field4440[15] = var17;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(Lnn;I)V",
		garbageValue = "1381972226"
	)
	public void method7179(class388 var1) {
		float var2 = var1.field4435 * var1.field4435;
		float var3 = var1.field4435 * var1.field4432;
		float var4 = var1.field4435 * var1.field4433;
		float var5 = var1.field4435 * var1.field4431;
		float var6 = var1.field4432 * var1.field4432;
		float var7 = var1.field4432 * var1.field4433;
		float var8 = var1.field4432 * var1.field4431;
		float var9 = var1.field4433 * var1.field4433;
		float var10 = var1.field4433 * var1.field4431;
		float var11 = var1.field4431 * var1.field4431;
		this.field4440[0] = var6 + var2 - var11 - var9;
		this.field4440[1] = var7 + var5 + var7 + var5;
		this.field4440[2] = var8 + (var8 - var4 - var4);
		this.field4440[4] = var7 - var5 - var5 + var7;
		this.field4440[5] = var2 + var9 - var6 - var11;
		this.field4440[6] = var3 + var3 + var10 + var10;
		this.field4440[8] = var8 + var4 + var8 + var4;
		this.field4440[9] = var10 + (var10 - var3 - var3);
		this.field4440[10] = var2 + var11 - var9 - var6;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "(Lod;I)V",
		garbageValue = "1656242906"
	)
	void method7180(class390 var1) {
		this.field4440[0] = var1.field4448;
		this.field4440[1] = var1.field4452;
		this.field4440[2] = var1.field4444;
		this.field4440[3] = 0.0F;
		this.field4440[4] = var1.field4450;
		this.field4440[5] = var1.field4446;
		this.field4440[6] = var1.field4447;
		this.field4440[7] = 0.0F;
		this.field4440[8] = var1.field4442;
		this.field4440[9] = var1.field4449;
		this.field4440[10] = var1.field4443;
		this.field4440[11] = 0.0F;
		this.field4440[12] = var1.field4451;
		this.field4440[13] = var1.field4445;
		this.field4440[14] = var1.field4453;
		this.field4440[15] = 1.0F;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "(I)F",
		garbageValue = "529784450"
	)
	float method7181() {
		return this.field4440[12] * this.field4440[3] * this.field4440[6] * this.field4440[9] + (this.field4440[8] * this.field4440[7] * this.field4440[2] * this.field4440[13] + this.field4440[15] * this.field4440[8] * this.field4440[1] * this.field4440[6] + this.field4440[0] * this.field4440[7] * this.field4440[9] * this.field4440[14] + this.field4440[13] * this.field4440[6] * this.field4440[0] * this.field4440[11] + (this.field4440[5] * this.field4440[0] * this.field4440[10] * this.field4440[15] - this.field4440[14] * this.field4440[11] * this.field4440[5] * this.field4440[0] - this.field4440[9] * this.field4440[6] * this.field4440[0] * this.field4440[15]) - this.field4440[13] * this.field4440[0] * this.field4440[7] * this.field4440[10] - this.field4440[15] * this.field4440[10] * this.field4440[4] * this.field4440[1] + this.field4440[14] * this.field4440[11] * this.field4440[1] * this.field4440[4] - this.field4440[12] * this.field4440[11] * this.field4440[6] * this.field4440[1] - this.field4440[1] * this.field4440[7] * this.field4440[8] * this.field4440[14] + this.field4440[12] * this.field4440[10] * this.field4440[7] * this.field4440[1] + this.field4440[15] * this.field4440[4] * this.field4440[2] * this.field4440[9] - this.field4440[13] * this.field4440[11] * this.field4440[2] * this.field4440[4] - this.field4440[15] * this.field4440[2] * this.field4440[5] * this.field4440[8] + this.field4440[5] * this.field4440[2] * this.field4440[11] * this.field4440[12] - this.field4440[12] * this.field4440[9] * this.field4440[2] * this.field4440[7] - this.field4440[4] * this.field4440[3] * this.field4440[9] * this.field4440[14] + this.field4440[13] * this.field4440[10] * this.field4440[3] * this.field4440[4] + this.field4440[14] * this.field4440[8] * this.field4440[3] * this.field4440[5] - this.field4440[10] * this.field4440[3] * this.field4440[5] * this.field4440[12] - this.field4440[3] * this.field4440[6] * this.field4440[8] * this.field4440[13]);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "855733111"
	)
	public void method7199() {
		float var1 = 1.0F / this.method7181();
		float var2 = var1 * (this.field4440[7] * this.field4440[9] * this.field4440[14] + this.field4440[13] * this.field4440[11] * this.field4440[6] + (this.field4440[5] * this.field4440[10] * this.field4440[15] - this.field4440[14] * this.field4440[5] * this.field4440[11] - this.field4440[15] * this.field4440[9] * this.field4440[6]) - this.field4440[13] * this.field4440[7] * this.field4440[10]);
		float var3 = var1 * (this.field4440[15] * this.field4440[9] * this.field4440[2] + this.field4440[14] * this.field4440[1] * this.field4440[11] + this.field4440[15] * -this.field4440[1] * this.field4440[10] - this.field4440[13] * this.field4440[11] * this.field4440[2] - this.field4440[3] * this.field4440[9] * this.field4440[14] + this.field4440[13] * this.field4440[10] * this.field4440[3]);
		float var4 = (this.field4440[14] * this.field4440[5] * this.field4440[3] + this.field4440[15] * this.field4440[1] * this.field4440[6] - this.field4440[7] * this.field4440[1] * this.field4440[14] - this.field4440[15] * this.field4440[5] * this.field4440[2] + this.field4440[2] * this.field4440[7] * this.field4440[13] - this.field4440[3] * this.field4440[6] * this.field4440[13]) * var1;
		float var5 = var1 * (this.field4440[3] * this.field4440[6] * this.field4440[9] + (this.field4440[5] * this.field4440[2] * this.field4440[11] + this.field4440[1] * this.field4440[7] * this.field4440[10] + this.field4440[6] * -this.field4440[1] * this.field4440[11] - this.field4440[9] * this.field4440[2] * this.field4440[7] - this.field4440[3] * this.field4440[5] * this.field4440[10]));
		float var6 = (this.field4440[14] * this.field4440[11] * this.field4440[4] + this.field4440[15] * this.field4440[10] * -this.field4440[4] + this.field4440[6] * this.field4440[8] * this.field4440[15] - this.field4440[11] * this.field4440[6] * this.field4440[12] - this.field4440[14] * this.field4440[7] * this.field4440[8] + this.field4440[12] * this.field4440[7] * this.field4440[10]) * var1;
		float var7 = (this.field4440[12] * this.field4440[2] * this.field4440[11] + (this.field4440[10] * this.field4440[0] * this.field4440[15] - this.field4440[0] * this.field4440[11] * this.field4440[14] - this.field4440[15] * this.field4440[8] * this.field4440[2]) + this.field4440[14] * this.field4440[8] * this.field4440[3] - this.field4440[3] * this.field4440[10] * this.field4440[12]) * var1;
		float var8 = (this.field4440[12] * this.field4440[3] * this.field4440[6] + (this.field4440[15] * this.field4440[2] * this.field4440[4] + this.field4440[6] * -this.field4440[0] * this.field4440[15] + this.field4440[14] * this.field4440[7] * this.field4440[0] - this.field4440[12] * this.field4440[2] * this.field4440[7] - this.field4440[14] * this.field4440[4] * this.field4440[3])) * var1;
		float var9 = (this.field4440[7] * this.field4440[2] * this.field4440[8] + (this.field4440[0] * this.field4440[6] * this.field4440[11] - this.field4440[10] * this.field4440[0] * this.field4440[7] - this.field4440[11] * this.field4440[4] * this.field4440[2]) + this.field4440[3] * this.field4440[4] * this.field4440[10] - this.field4440[8] * this.field4440[3] * this.field4440[6]) * var1;
		float var10 = (this.field4440[4] * this.field4440[9] * this.field4440[15] - this.field4440[13] * this.field4440[11] * this.field4440[4] - this.field4440[15] * this.field4440[8] * this.field4440[5] + this.field4440[11] * this.field4440[5] * this.field4440[12] + this.field4440[13] * this.field4440[8] * this.field4440[7] - this.field4440[9] * this.field4440[7] * this.field4440[12]) * var1;
		float var11 = var1 * (this.field4440[13] * this.field4440[0] * this.field4440[11] + this.field4440[15] * -this.field4440[0] * this.field4440[9] + this.field4440[15] * this.field4440[8] * this.field4440[1] - this.field4440[12] * this.field4440[11] * this.field4440[1] - this.field4440[3] * this.field4440[8] * this.field4440[13] + this.field4440[12] * this.field4440[3] * this.field4440[9]);
		float var12 = var1 * (this.field4440[13] * this.field4440[3] * this.field4440[4] + this.field4440[5] * this.field4440[0] * this.field4440[15] - this.field4440[7] * this.field4440[0] * this.field4440[13] - this.field4440[4] * this.field4440[1] * this.field4440[15] + this.field4440[1] * this.field4440[7] * this.field4440[12] - this.field4440[5] * this.field4440[3] * this.field4440[12]);
		float var13 = (this.field4440[8] * this.field4440[5] * this.field4440[3] + (this.field4440[11] * this.field4440[1] * this.field4440[4] + -this.field4440[0] * this.field4440[5] * this.field4440[11] + this.field4440[0] * this.field4440[7] * this.field4440[9] - this.field4440[7] * this.field4440[1] * this.field4440[8] - this.field4440[4] * this.field4440[3] * this.field4440[9])) * var1;
		float var14 = (-this.field4440[4] * this.field4440[9] * this.field4440[14] + this.field4440[13] * this.field4440[4] * this.field4440[10] + this.field4440[14] * this.field4440[5] * this.field4440[8] - this.field4440[12] * this.field4440[10] * this.field4440[5] - this.field4440[13] * this.field4440[8] * this.field4440[6] + this.field4440[6] * this.field4440[9] * this.field4440[12]) * var1;
		float var15 = var1 * (this.field4440[12] * this.field4440[10] * this.field4440[1] + (this.field4440[0] * this.field4440[9] * this.field4440[14] - this.field4440[10] * this.field4440[0] * this.field4440[13] - this.field4440[14] * this.field4440[8] * this.field4440[1]) + this.field4440[2] * this.field4440[8] * this.field4440[13] - this.field4440[9] * this.field4440[2] * this.field4440[12]);
		float var16 = (this.field4440[4] * this.field4440[1] * this.field4440[14] + this.field4440[0] * this.field4440[6] * this.field4440[13] + -this.field4440[0] * this.field4440[5] * this.field4440[14] - this.field4440[6] * this.field4440[1] * this.field4440[12] - this.field4440[2] * this.field4440[4] * this.field4440[13] + this.field4440[12] * this.field4440[5] * this.field4440[2]) * var1;
		float var17 = (this.field4440[8] * this.field4440[6] * this.field4440[1] + (this.field4440[5] * this.field4440[0] * this.field4440[10] - this.field4440[9] * this.field4440[6] * this.field4440[0] - this.field4440[4] * this.field4440[1] * this.field4440[10]) + this.field4440[2] * this.field4440[4] * this.field4440[9] - this.field4440[8] * this.field4440[2] * this.field4440[5]) * var1;
		this.field4440[0] = var2;
		this.field4440[1] = var3;
		this.field4440[2] = var4;
		this.field4440[3] = var5;
		this.field4440[4] = var6;
		this.field4440[5] = var7;
		this.field4440[6] = var8;
		this.field4440[7] = var9;
		this.field4440[8] = var10;
		this.field4440[9] = var11;
		this.field4440[10] = var12;
		this.field4440[11] = var13;
		this.field4440[12] = var14;
		this.field4440[13] = var15;
		this.field4440[14] = var16;
		this.field4440[15] = var17;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "(B)[F",
		garbageValue = "-123"
	)
	public float[] method7185() {
		float[] var1 = new float[3];
		class387 var2 = new class387(this.field4440[0], this.field4440[1], this.field4440[2]);
		class387 var3 = new class387(this.field4440[4], this.field4440[5], this.field4440[6]);
		class387 var4 = new class387(this.field4440[8], this.field4440[9], this.field4440[10]);
		var1[0] = var2.method7130();
		var1[1] = var3.method7130();
		var1[2] = var4.method7130();
		return var1;
	}

	public String toString() {
		StringBuilder var1 = new StringBuilder();
		this.method7206();
		this.method7170();

		for (int var2 = 0; var2 < 4; ++var2) {
			for (int var3 = 0; var3 < 4; ++var3) {
				if (var3 > 0) {
					var1.append("\t");
				}

				float var4 = this.field4440[var3 + var2 * 4];
				if (Math.sqrt((double)(var4 * var4)) < 9.999999747378752E-5D) {
					var4 = 0.0F;
				}

				var1.append(var4);
			}

			var1.append("\n");
		}

		return var1.toString();
	}

	public int hashCode() {
		boolean var1 = true;
		byte var2 = 1;
		int var3 = 31 * var2 + Arrays.hashCode(this.field4440);
		return var3;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof class389)) {
			return false;
		} else {
			class389 var2 = (class389)var1;

			for (int var3 = 0; var3 < 16; ++var3) {
				if (var2.field4440[var3] != this.field4440[var3]) {
					return false;
				}
			}

			return true;
		}
	}
}
