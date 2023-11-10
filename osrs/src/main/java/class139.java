import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@ObfuscatedName("fo")
public class class139 extends DualNode {
	@ObfuscatedName("ac")
	static ThreadPoolExecutor field1309;
	@ObfuscatedName("at")
	int field1313;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "[[Lfm;"
	)
	public class131[][] field1316;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "[[Lfm;"
	)
	class131[][] field1311;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lkd;"
	)
	public Skeleton field1317;
	@ObfuscatedName("ab")
	int field1312;
	@ObfuscatedName("au")
	boolean field1310;
	@ObfuscatedName("al")
	Future field1315;
	@ObfuscatedName("az")
	List field1314;

	@ObfuscatedSignature(
		descriptor = "(Lol;Lol;IZ)V"
	)
	class139(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		this.field1316 = null;
		this.field1311 = null;
		this.field1312 = 0;
		this.field1313 = var3;
		byte[] var5 = var1.takeFile(this.field1313 >> 16 & 65535, this.field1313 & 65535);
		Buffer var6 = new Buffer(var5);
		int var7 = var6.readUnsignedByte();
		int var8 = var6.readUnsignedShort();
		byte[] var9;
		if (var4) {
			var9 = var2.getFile(0, var8);
		} else {
			var9 = var2.getFile(var8, 0);
		}

		this.field1317 = new Skeleton(var8, var9);
		this.field1314 = new ArrayList();
		this.field1315 = field1309.submit(new class138(this, var6, var7));
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Luj;II)V",
		garbageValue = "-170957792"
	)
	void method740(Buffer var1, int var2) {
		var1.readUnsignedShort();
		var1.readUnsignedShort();
		this.field1312 = var1.readUnsignedByte();
		int var3 = var1.readUnsignedShort();
		this.field1311 = new class131[this.field1317.method1455().method1439()][];
		this.field1316 = new class131[this.field1317.method1454()][];
		class130[] var4 = new class130[var3];

		int var5;
		int var7;
		int var9;
		for (var5 = 0; var5 < var3; ++var5) {
			var7 = var1.readUnsignedByte();
			class132 var8 = (class132)class12.findEnumerated(Language.method1991(), var7);
			if (var8 == null) {
				var8 = class132.field1279;
			}

			var9 = var1.readShortSmart();
			int var11 = var1.readUnsignedByte();
			class133[] var12 = new class133[]{class133.field1296, class133.field1288, class133.field1294, class133.field1292, class133.field1286, class133.field1297, class133.field1285, class133.field1287, class133.field1291, class133.field1301, class133.field1293, class133.field1298, class133.field1299, class133.field1295, class133.field1300, class133.field1290, class133.field1289};
			class133 var13 = (class133)class12.findEnumerated(var12, var11);
			if (var13 == null) {
				var13 = class133.field1296;
			}

			class131 var20 = new class131();
			var20.method714(var1, var2);
			var4[var5] = new class130(this, var20, var8, var13, var9);
			int var14 = var8.method725();
			class131[][] var15;
			if (var8 == class132.field1276) {
				var15 = this.field1311;
			} else {
				var15 = this.field1316;
			}

			if (var15[var9] == null) {
				var15[var9] = new class131[var14];
			}

			if (var8 == class132.field1275) {
				this.field1310 = true;
			}
		}

		var5 = var3 / FloorDecoration.field2162;
		int var16 = var3 % FloorDecoration.field2162;
		int var17 = 0;

		for (var9 = 0; var9 < FloorDecoration.field2162; ++var9) {
			var7 = var17;
			var17 += var5;
			if (var16 > 0) {
				++var17;
				--var16;
			}

			if (var17 == var7) {
				break;
			}

			this.field1314.add(field1309.submit(new class134(this, var7, var17, var4)));
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(S)Z",
		garbageValue = "136"
	)
	public boolean method741() {
		if (this.field1315 == null && this.field1314 == null) {
			return true;
		} else {
			if (this.field1315 != null) {
				if (!this.field1315.isDone()) {
					return false;
				}

				this.field1315 = null;
			}

			boolean var1 = true;

			for (int var2 = 0; var2 < this.field1314.size(); ++var2) {
				if (!((Future)this.field1314.get(var2)).isDone()) {
					var1 = false;
				} else {
					this.field1314.remove(var2);
					--var2;
				}
			}

			if (!var1) {
				return false;
			} else {
				this.field1314 = null;
				return true;
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "53"
	)
	public int method742() {
		return this.field1312;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-99"
	)
	public boolean method743() {
		return this.field1310;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(ILej;III)V",
		garbageValue = "-685417553"
	)
	public void method744(int var1, class128 var2, int var3, int var4) {
		class462 var5 = WorldMapDecoration.method1329();
		this.method745(var5, var3, var2, var1);
		this.method747(var5, var3, var2, var1);
		this.method746(var5, var3, var2, var1);
		var2.method701(var5);
		var5.method2314();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Lrz;ILej;II)V",
		garbageValue = "2098789523"
	)
	void method745(class462 var1, int var2, class128 var3, int var4) {
		float[] var5 = var3.method705(this.field1312);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1311[var2] != null) {
			class131 var9 = this.field1311[var2][0];
			class131 var10 = this.field1311[var2][1];
			class131 var11 = this.field1311[var2][2];
			if (var9 != null) {
				var6 = var9.method716(var4);
			}

			if (var10 != null) {
				var7 = var10.method716(var4);
			}

			if (var11 != null) {
				var8 = var11.method716(var4);
			}
		}

		class461 var16 = class214.method1093();
		var16.method2311(1.0F, 0.0F, 0.0F, var6);
		class461 var14 = class214.method1093();
		var14.method2311(0.0F, 1.0F, 0.0F, var7);
		class461 var15 = class214.method1093();
		var15.method2311(0.0F, 0.0F, 1.0F, var8);
		class461 var12 = class214.method1093();
		var12.method2313(var15);
		var12.method2313(var16);
		var12.method2313(var14);
		class462 var13 = WorldMapDecoration.method1329();
		var13.method2325(var12);
		var1.method2324(var13);
		var16.method2309();
		var14.method2309();
		var15.method2309();
		var12.method2309();
		var13.method2314();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lrz;ILej;II)V",
		garbageValue = "1029943917"
	)
	void method746(class462 var1, int var2, class128 var3, int var4) {
		float[] var5 = var3.method706(this.field1312);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1311[var2] != null) {
			class131 var9 = this.field1311[var2][3];
			class131 var10 = this.field1311[var2][4];
			class131 var11 = this.field1311[var2][5];
			if (var9 != null) {
				var6 = var9.method716(var4);
			}

			if (var10 != null) {
				var7 = var10.method716(var4);
			}

			if (var11 != null) {
				var8 = var11.method716(var4);
			}
		}

		var1.field3908[12] = var6;
		var1.field3908[13] = var7;
		var1.field3908[14] = var8;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lrz;ILej;IB)V",
		garbageValue = "-43"
	)
	void method747(class462 var1, int var2, class128 var3, int var4) {
		float[] var5 = var3.method707(this.field1312);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1311[var2] != null) {
			class131 var9 = this.field1311[var2][6];
			class131 var10 = this.field1311[var2][7];
			class131 var11 = this.field1311[var2][8];
			if (var9 != null) {
				var6 = var9.method716(var4);
			}

			if (var10 != null) {
				var7 = var10.method716(var4);
			}

			if (var11 != null) {
				var8 = var11.method716(var4);
			}
		}

		class462 var12 = WorldMapDecoration.method1329();
		var12.method2322(var6, var7, var8);
		var1.method2324(var12);
		var12.method2314();
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)[B",
		garbageValue = "-1858381549"
	)
	public static byte[] method748() {
		byte[] var0 = new byte[24];

		try {
			JagexCache.JagexCache_randomDat.seek(0L);
			JagexCache.JagexCache_randomDat.readFully(var0);

			int var1;
			for (var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
			}

			if (var1 >= 24) {
				throw new IOException();
			}
		} catch (Exception var4) {
			for (int var2 = 0; var2 < 24; ++var2) {
				var0[var2] = -1;
			}
		}

		return var0;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-2047450168"
	)
	@Export("setLoginResponseString")
	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}
}