import java.util.Arrays;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rm")
public final class class451 {
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "[Lrm;"
	)
	static class451[] field3860;
	@ObfuscatedName("ar")
	static int field3859;
	@ObfuscatedName("am")
	static int field3858;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lrm;"
	)
	public static final class451 field3857;
	@ObfuscatedName("as")
	public float[] field3861;

	static {
		field3860 = new class451[0];
		field3859 = 100;
		field3860 = new class451[100];
		field3858 = 0;
		field3857 = new class451();
	}

	public class451() {
		this.field3861 = new float[16];
		this.method2275();
	}

	@ObfuscatedSignature(
		descriptor = "(Lrm;)V"
	)
	public class451(class451 var1) {
		this.field3861 = new float[16];
		this.method2278(var1);
	}

	@ObfuscatedSignature(
		descriptor = "(Lty;Z)V"
	)
	public class451(Buffer var1, boolean var2) {
		this.field3861 = new float[16];
		this.method2272(var1, var2);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1298935751"
	)
	public void method2271() {
		synchronized(field3860) {
			if (field3858 < field3859 - 1) {
				field3860[++field3858 - 1] = this;
			}

		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lty;ZI)V",
		garbageValue = "-1389814144"
	)
	void method2272(Buffer var1, boolean var2) {
		if (var2) {
			class452 var3 = new class452();
			int var6 = var1.readShort();
			var6 &= 16383;
			float var5 = (float)(6.283185307179586D * (double)((float)var6 / 16384.0F));
			var3.method2289(var5);
			int var9 = var1.readShort();
			var9 &= 16383;
			float var8 = (float)((double)((float)var9 / 16384.0F) * 6.283185307179586D);
			var3.method2290(var8);
			int var12 = var1.readShort();
			var12 &= 16383;
			float var11 = (float)((double)((float)var12 / 16384.0F) * 6.283185307179586D);
			var3.method2291(var11);
			var3.method2292((float)var1.readShort(), (float)var1.readShort(), (float)var1.readShort());
			this.method2284(var3);
		} else {
			for (int var13 = 0; var13 < 16; ++var13) {
				this.field3861[var13] = var1.method2531();
			}
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)[F",
		garbageValue = "737121810"
	)
	float[] method2273() {
		float[] var1 = new float[3];
		if ((double)this.field3861[2] < 0.999D && (double)this.field3861[2] > -0.999D) {
			var1[1] = (float)(-Math.asin((double)this.field3861[2]));
			double var2 = Math.cos((double)var1[1]);
			var1[0] = (float)Math.atan2((double)this.field3861[6] / var2, (double)this.field3861[10] / var2);
			var1[2] = (float)Math.atan2((double)this.field3861[1] / var2, (double)this.field3861[0] / var2);
		} else {
			var1[0] = 0.0F;
			var1[1] = (float)Math.atan2((double)this.field3861[2], 0.0D);
			var1[2] = (float)Math.atan2((double)(-this.field3861[9]), (double)this.field3861[5]);
		}

		return var1;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)[F",
		garbageValue = "1036092257"
	)
	public float[] method2274() {
		float[] var1 = new float[]{(float)(-Math.asin((double)this.field3861[6])), 0.0F, 0.0F};
		double var2 = Math.cos((double)var1[0]);
		double var4;
		double var6;
		if (Math.abs(var2) > 0.005D) {
			var4 = (double)this.field3861[2];
			var6 = (double)this.field3861[10];
			double var8 = (double)this.field3861[4];
			double var10 = (double)this.field3861[5];
			var1[1] = (float)Math.atan2(var4, var6);
			var1[2] = (float)Math.atan2(var8, var10);
		} else {
			var4 = (double)this.field3861[1];
			var6 = (double)this.field3861[0];
			if (this.field3861[6] < 0.0F) {
				var1[1] = (float)Math.atan2(var4, var6);
			} else {
				var1[1] = (float)(-Math.atan2(var4, var6));
			}

			var1[2] = 0.0F;
		}

		return var1;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-85"
	)
	void method2275() {
		this.field3861[0] = 1.0F;
		this.field3861[1] = 0.0F;
		this.field3861[2] = 0.0F;
		this.field3861[3] = 0.0F;
		this.field3861[4] = 0.0F;
		this.field3861[5] = 1.0F;
		this.field3861[6] = 0.0F;
		this.field3861[7] = 0.0F;
		this.field3861[8] = 0.0F;
		this.field3861[9] = 0.0F;
		this.field3861[10] = 1.0F;
		this.field3861[11] = 0.0F;
		this.field3861[12] = 0.0F;
		this.field3861[13] = 0.0F;
		this.field3861[14] = 0.0F;
		this.field3861[15] = 1.0F;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1783640512"
	)
	public void method2276() {
		this.field3861[0] = 0.0F;
		this.field3861[1] = 0.0F;
		this.field3861[2] = 0.0F;
		this.field3861[3] = 0.0F;
		this.field3861[4] = 0.0F;
		this.field3861[5] = 0.0F;
		this.field3861[6] = 0.0F;
		this.field3861[7] = 0.0F;
		this.field3861[8] = 0.0F;
		this.field3861[9] = 0.0F;
		this.field3861[10] = 0.0F;
		this.field3861[11] = 0.0F;
		this.field3861[12] = 0.0F;
		this.field3861[13] = 0.0F;
		this.field3861[14] = 0.0F;
		this.field3861[15] = 0.0F;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Lrm;B)V",
		garbageValue = "2"
	)
	public void method2278(class451 var1) {
		System.arraycopy(var1.field3861, 0, this.field3861, 0, 16);
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(FI)V",
		garbageValue = "-1994849424"
	)
	public void method2279(float var1) {
		this.method2280(var1, var1, var1);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(FFFI)V",
		garbageValue = "1837928270"
	)
	public void method2280(float var1, float var2, float var3) {
		this.method2275();
		this.field3861[0] = var1;
		this.field3861[5] = var2;
		this.field3861[10] = var3;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Lrm;S)V",
		garbageValue = "28816"
	)
	public void method2281(class451 var1) {
		for (int var2 = 0; var2 < this.field3861.length; ++var2) {
			float[] var10000 = this.field3861;
			var10000[var2] += var1.field3861[var2];
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lrm;S)V",
		garbageValue = "255"
	)
	public void method2282(class451 var1) {
		float var2 = var1.field3861[12] * this.field3861[3] + this.field3861[0] * var1.field3861[0] + this.field3861[1] * var1.field3861[4] + this.field3861[2] * var1.field3861[8];
		float var3 = var1.field3861[13] * this.field3861[3] + this.field3861[2] * var1.field3861[9] + var1.field3861[5] * this.field3861[1] + var1.field3861[1] * this.field3861[0];
		float var4 = this.field3861[2] * var1.field3861[10] + this.field3861[0] * var1.field3861[2] + var1.field3861[6] * this.field3861[1] + var1.field3861[14] * this.field3861[3];
		float var5 = this.field3861[0] * var1.field3861[3] + var1.field3861[7] * this.field3861[1] + this.field3861[2] * var1.field3861[11] + this.field3861[3] * var1.field3861[15];
		float var6 = this.field3861[7] * var1.field3861[12] + var1.field3861[8] * this.field3861[6] + this.field3861[4] * var1.field3861[0] + var1.field3861[4] * this.field3861[5];
		float var7 = var1.field3861[1] * this.field3861[4] + this.field3861[5] * var1.field3861[5] + this.field3861[6] * var1.field3861[9] + this.field3861[7] * var1.field3861[13];
		float var8 = this.field3861[7] * var1.field3861[14] + this.field3861[4] * var1.field3861[2] + this.field3861[5] * var1.field3861[6] + this.field3861[6] * var1.field3861[10];
		float var9 = this.field3861[7] * var1.field3861[15] + this.field3861[6] * var1.field3861[11] + var1.field3861[7] * this.field3861[5] + var1.field3861[3] * this.field3861[4];
		float var10 = var1.field3861[12] * this.field3861[11] + this.field3861[10] * var1.field3861[8] + var1.field3861[4] * this.field3861[9] + this.field3861[8] * var1.field3861[0];
		float var11 = this.field3861[8] * var1.field3861[1] + var1.field3861[5] * this.field3861[9] + var1.field3861[9] * this.field3861[10] + var1.field3861[13] * this.field3861[11];
		float var12 = this.field3861[8] * var1.field3861[2] + var1.field3861[6] * this.field3861[9] + this.field3861[10] * var1.field3861[10] + this.field3861[11] * var1.field3861[14];
		float var13 = this.field3861[10] * var1.field3861[11] + var1.field3861[3] * this.field3861[8] + this.field3861[9] * var1.field3861[7] + this.field3861[11] * var1.field3861[15];
		float var14 = this.field3861[15] * var1.field3861[12] + this.field3861[13] * var1.field3861[4] + this.field3861[12] * var1.field3861[0] + this.field3861[14] * var1.field3861[8];
		float var15 = var1.field3861[13] * this.field3861[15] + var1.field3861[9] * this.field3861[14] + this.field3861[13] * var1.field3861[5] + this.field3861[12] * var1.field3861[1];
		float var16 = this.field3861[12] * var1.field3861[2] + var1.field3861[6] * this.field3861[13] + var1.field3861[10] * this.field3861[14] + var1.field3861[14] * this.field3861[15];
		float var17 = var1.field3861[11] * this.field3861[14] + this.field3861[13] * var1.field3861[7] + var1.field3861[3] * this.field3861[12] + var1.field3861[15] * this.field3861[15];
		this.field3861[0] = var2;
		this.field3861[1] = var3;
		this.field3861[2] = var4;
		this.field3861[3] = var5;
		this.field3861[4] = var6;
		this.field3861[5] = var7;
		this.field3861[6] = var8;
		this.field3861[7] = var9;
		this.field3861[8] = var10;
		this.field3861[9] = var11;
		this.field3861[10] = var12;
		this.field3861[11] = var13;
		this.field3861[12] = var14;
		this.field3861[13] = var15;
		this.field3861[14] = var16;
		this.field3861[15] = var17;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lrj;I)V",
		garbageValue = "-2118656993"
	)
	public void method2283(class450 var1) {
		float var2 = var1.field3853 * var1.field3853;
		float var3 = var1.field3855 * var1.field3853;
		float var4 = var1.field3856 * var1.field3853;
		float var5 = var1.field3853 * var1.field3854;
		float var6 = var1.field3855 * var1.field3855;
		float var7 = var1.field3855 * var1.field3856;
		float var8 = var1.field3854 * var1.field3855;
		float var9 = var1.field3856 * var1.field3856;
		float var10 = var1.field3856 * var1.field3854;
		float var11 = var1.field3854 * var1.field3854;
		this.field3861[0] = var2 + var6 - var11 - var9;
		this.field3861[1] = var5 + var5 + var7 + var7;
		this.field3861[2] = var8 + (var8 - var4 - var4);
		this.field3861[4] = var7 + (var7 - var5 - var5);
		this.field3861[5] = var9 + var2 - var6 - var11;
		this.field3861[6] = var3 + var10 + var10 + var3;
		this.field3861[8] = var8 + var8 + var4 + var4;
		this.field3861[9] = var10 - var3 - var3 + var10;
		this.field3861[10] = var2 + var11 - var9 - var6;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lrv;I)V",
		garbageValue = "275615452"
	)
	void method2284(class452 var1) {
		this.field3861[0] = var1.field3871;
		this.field3861[1] = var1.field3872;
		this.field3861[2] = var1.field3867;
		this.field3861[3] = 0.0F;
		this.field3861[4] = var1.field3864;
		this.field3861[5] = var1.field3868;
		this.field3861[6] = var1.field3863;
		this.field3861[7] = 0.0F;
		this.field3861[8] = var1.field3862;
		this.field3861[9] = var1.field3873;
		this.field3861[10] = var1.field3870;
		this.field3861[11] = 0.0F;
		this.field3861[12] = var1.field3865;
		this.field3861[13] = var1.field3866;
		this.field3861[14] = var1.field3869;
		this.field3861[15] = 1.0F;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(B)F",
		garbageValue = "-6"
	)
	float method2285() {
		return this.field3861[12] * this.field3861[3] * this.field3861[6] * this.field3861[9] + (this.field3861[14] * this.field3861[5] * this.field3861[3] * this.field3861[8] + this.field3861[13] * this.field3861[10] * this.field3861[4] * this.field3861[3] + (this.field3861[8] * this.field3861[2] * this.field3861[7] * this.field3861[13] + this.field3861[2] * this.field3861[5] * this.field3861[11] * this.field3861[12] + (this.field3861[4] * this.field3861[2] * this.field3861[9] * this.field3861[15] + this.field3861[14] * this.field3861[9] * this.field3861[7] * this.field3861[0] + this.field3861[15] * this.field3861[10] * this.field3861[5] * this.field3861[0] - this.field3861[11] * this.field3861[0] * this.field3861[5] * this.field3861[14] - this.field3861[15] * this.field3861[9] * this.field3861[0] * this.field3861[6] + this.field3861[13] * this.field3861[0] * this.field3861[6] * this.field3861[11] - this.field3861[13] * this.field3861[0] * this.field3861[7] * this.field3861[10] - this.field3861[15] * this.field3861[10] * this.field3861[1] * this.field3861[4] + this.field3861[14] * this.field3861[11] * this.field3861[1] * this.field3861[4] + this.field3861[8] * this.field3861[1] * this.field3861[6] * this.field3861[15] - this.field3861[1] * this.field3861[6] * this.field3861[11] * this.field3861[12] - this.field3861[8] * this.field3861[1] * this.field3861[7] * this.field3861[14] + this.field3861[12] * this.field3861[10] * this.field3861[7] * this.field3861[1] - this.field3861[11] * this.field3861[2] * this.field3861[4] * this.field3861[13] - this.field3861[15] * this.field3861[8] * this.field3861[2] * this.field3861[5]) - this.field3861[12] * this.field3861[9] * this.field3861[7] * this.field3861[2] - this.field3861[9] * this.field3861[4] * this.field3861[3] * this.field3861[14]) - this.field3861[12] * this.field3861[10] * this.field3861[3] * this.field3861[5] - this.field3861[13] * this.field3861[3] * this.field3861[6] * this.field3861[8]);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-882996558"
	)
	public void method2286() {
		float var1 = 1.0F / this.method2285();
		float var2 = (this.field3861[7] * this.field3861[9] * this.field3861[14] + this.field3861[15] * this.field3861[5] * this.field3861[10] - this.field3861[11] * this.field3861[5] * this.field3861[14] - this.field3861[9] * this.field3861[6] * this.field3861[15] + this.field3861[13] * this.field3861[6] * this.field3861[11] - this.field3861[7] * this.field3861[10] * this.field3861[13]) * var1;
		float var3 = var1 * (this.field3861[9] * this.field3861[2] * this.field3861[15] + this.field3861[14] * this.field3861[11] * this.field3861[1] + this.field3861[15] * -this.field3861[1] * this.field3861[10] - this.field3861[11] * this.field3861[2] * this.field3861[13] - this.field3861[3] * this.field3861[9] * this.field3861[14] + this.field3861[13] * this.field3861[10] * this.field3861[3]);
		float var4 = var1 * (this.field3861[3] * this.field3861[5] * this.field3861[14] + this.field3861[13] * this.field3861[2] * this.field3861[7] + (this.field3861[1] * this.field3861[6] * this.field3861[15] - this.field3861[7] * this.field3861[1] * this.field3861[14] - this.field3861[2] * this.field3861[5] * this.field3861[15]) - this.field3861[13] * this.field3861[3] * this.field3861[6]);
		float var5 = (this.field3861[9] * this.field3861[6] * this.field3861[3] + (this.field3861[10] * this.field3861[1] * this.field3861[7] + this.field3861[11] * this.field3861[6] * -this.field3861[1] + this.field3861[5] * this.field3861[2] * this.field3861[11] - this.field3861[2] * this.field3861[7] * this.field3861[9] - this.field3861[10] * this.field3861[5] * this.field3861[3])) * var1;
		float var6 = var1 * (this.field3861[10] * this.field3861[7] * this.field3861[12] + (this.field3861[6] * this.field3861[8] * this.field3861[15] + this.field3861[15] * this.field3861[10] * -this.field3861[4] + this.field3861[11] * this.field3861[4] * this.field3861[14] - this.field3861[6] * this.field3861[11] * this.field3861[12] - this.field3861[14] * this.field3861[8] * this.field3861[7]));
		float var7 = (this.field3861[3] * this.field3861[8] * this.field3861[14] + this.field3861[15] * this.field3861[10] * this.field3861[0] - this.field3861[14] * this.field3861[0] * this.field3861[11] - this.field3861[15] * this.field3861[8] * this.field3861[2] + this.field3861[2] * this.field3861[11] * this.field3861[12] - this.field3861[3] * this.field3861[10] * this.field3861[12]) * var1;
		float var8 = (this.field3861[12] * this.field3861[3] * this.field3861[6] + (this.field3861[6] * -this.field3861[0] * this.field3861[15] + this.field3861[14] * this.field3861[0] * this.field3861[7] + this.field3861[15] * this.field3861[2] * this.field3861[4] - this.field3861[12] * this.field3861[7] * this.field3861[2] - this.field3861[14] * this.field3861[4] * this.field3861[3])) * var1;
		float var9 = var1 * (this.field3861[0] * this.field3861[6] * this.field3861[11] - this.field3861[10] * this.field3861[7] * this.field3861[0] - this.field3861[11] * this.field3861[4] * this.field3861[2] + this.field3861[7] * this.field3861[2] * this.field3861[8] + this.field3861[4] * this.field3861[3] * this.field3861[10] - this.field3861[3] * this.field3861[6] * this.field3861[8]);
		float var10 = var1 * (this.field3861[13] * this.field3861[7] * this.field3861[8] + this.field3861[15] * this.field3861[4] * this.field3861[9] - this.field3861[13] * this.field3861[11] * this.field3861[4] - this.field3861[15] * this.field3861[8] * this.field3861[5] + this.field3861[12] * this.field3861[11] * this.field3861[5] - this.field3861[7] * this.field3861[9] * this.field3861[12]);
		float var11 = var1 * (this.field3861[9] * this.field3861[3] * this.field3861[12] + (this.field3861[15] * this.field3861[8] * this.field3861[1] + this.field3861[11] * this.field3861[0] * this.field3861[13] + this.field3861[15] * this.field3861[9] * -this.field3861[0] - this.field3861[12] * this.field3861[1] * this.field3861[11] - this.field3861[3] * this.field3861[8] * this.field3861[13]));
		float var12 = (this.field3861[4] * this.field3861[3] * this.field3861[13] + this.field3861[7] * this.field3861[1] * this.field3861[12] + (this.field3861[15] * this.field3861[5] * this.field3861[0] - this.field3861[0] * this.field3861[7] * this.field3861[13] - this.field3861[15] * this.field3861[1] * this.field3861[4]) - this.field3861[12] * this.field3861[5] * this.field3861[3]) * var1;
		float var13 = (this.field3861[8] * this.field3861[3] * this.field3861[5] + (this.field3861[4] * this.field3861[1] * this.field3861[11] + this.field3861[5] * -this.field3861[0] * this.field3861[11] + this.field3861[7] * this.field3861[0] * this.field3861[9] - this.field3861[7] * this.field3861[1] * this.field3861[8] - this.field3861[4] * this.field3861[3] * this.field3861[9])) * var1;
		float var14 = (this.field3861[9] * this.field3861[6] * this.field3861[12] + (this.field3861[14] * this.field3861[8] * this.field3861[5] + this.field3861[13] * this.field3861[10] * this.field3861[4] + this.field3861[14] * -this.field3861[4] * this.field3861[9] - this.field3861[12] * this.field3861[10] * this.field3861[5] - this.field3861[6] * this.field3861[8] * this.field3861[13])) * var1;
		float var15 = var1 * (this.field3861[1] * this.field3861[10] * this.field3861[12] + (this.field3861[14] * this.field3861[9] * this.field3861[0] - this.field3861[0] * this.field3861[10] * this.field3861[13] - this.field3861[14] * this.field3861[1] * this.field3861[8]) + this.field3861[13] * this.field3861[8] * this.field3861[2] - this.field3861[9] * this.field3861[2] * this.field3861[12]);
		float var16 = var1 * (this.field3861[12] * this.field3861[2] * this.field3861[5] + (this.field3861[13] * this.field3861[6] * this.field3861[0] + -this.field3861[0] * this.field3861[5] * this.field3861[14] + this.field3861[4] * this.field3861[1] * this.field3861[14] - this.field3861[12] * this.field3861[1] * this.field3861[6] - this.field3861[13] * this.field3861[4] * this.field3861[2]));
		float var17 = (this.field3861[9] * this.field3861[2] * this.field3861[4] + this.field3861[5] * this.field3861[0] * this.field3861[10] - this.field3861[9] * this.field3861[6] * this.field3861[0] - this.field3861[1] * this.field3861[4] * this.field3861[10] + this.field3861[6] * this.field3861[1] * this.field3861[8] - this.field3861[8] * this.field3861[2] * this.field3861[5]) * var1;
		this.field3861[0] = var2;
		this.field3861[1] = var3;
		this.field3861[2] = var4;
		this.field3861[3] = var5;
		this.field3861[4] = var6;
		this.field3861[5] = var7;
		this.field3861[6] = var8;
		this.field3861[7] = var9;
		this.field3861[8] = var10;
		this.field3861[9] = var11;
		this.field3861[10] = var12;
		this.field3861[11] = var13;
		this.field3861[12] = var14;
		this.field3861[13] = var15;
		this.field3861[14] = var16;
		this.field3861[15] = var17;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)[F",
		garbageValue = "24"
	)
	public float[] method2287() {
		float[] var1 = new float[3];
		class449 var2 = new class449(this.field3861[0], this.field3861[1], this.field3861[2]);
		class449 var3 = new class449(this.field3861[4], this.field3861[5], this.field3861[6]);
		class449 var4 = new class449(this.field3861[8], this.field3861[9], this.field3861[10]);
		var1[0] = var2.method2264();
		var1[1] = var3.method2264();
		var1[2] = var4.method2264();
		return var1;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		StringBuilder var1 = new StringBuilder();
		this.method2274();
		this.method2273();

		for (int var2 = 0; var2 < 4; ++var2) {
			for (int var3 = 0; var3 < 4; ++var3) {
				if (var3 > 0) {
					var1.append("\t");
				}

				float var4 = this.field3861[var3 + var2 * 4];
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
		int var3 = 31 * var2 + Arrays.hashCode(this.field3861);
		return var3;
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (!(var1 instanceof class451)) {
			return false;
		} else {
			class451 var2 = (class451)var1;

			for (int var3 = 0; var3 < 16; ++var3) {
				if (this.field3861[var3] != var2.field3861[var3]) {
					return false;
				}
			}

			return true;
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lnd;Ljava/lang/String;Ljava/lang/String;I)Luu;",
		garbageValue = "1008669226"
	)
	@Export("SpriteBuffer_getIndexedSpriteByName")
	public static IndexedSprite SpriteBuffer_getIndexedSpriteByName(AbstractArchive var0, String var1, String var2) {
		if (!var0.isValidFileName(var1, var2)) {
			return null;
		} else {
			int var3 = var0.getGroupId(var1);
			int var4 = var0.getFileId(var3, var2);
			return MouseRecorder.method476(var0, var3, var4);
		}
	}
}
