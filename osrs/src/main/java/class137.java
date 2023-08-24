import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@ObfuscatedName("fv")
public class class137 extends DualNode {
	@ObfuscatedName("ap")
	public static ThreadPoolExecutor field1296;
	@ObfuscatedName("ad")
	@Export("Interpreter_stringStackSize")
	static int Interpreter_stringStackSize;
	@ObfuscatedName("au")
	int field1301;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "[[Lfh;"
	)
	public class130[][] field1304;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "[[Lfh;"
	)
	class130[][] field1299;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Liu;"
	)
	public Skeleton field1305;
	@ObfuscatedName("ac")
	int field1300;
	@ObfuscatedName("ai")
	boolean field1298;
	@ObfuscatedName("aa")
	Future field1303;
	@ObfuscatedName("af")
	List field1302;

	@ObfuscatedSignature(
		descriptor = "(Lnu;Lnu;IZ)V",
		garbageValue = "0"
	)
	public class137(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		this.field1304 = null;
		this.field1299 = null;
		this.field1300 = 0;
		this.field1301 = var3;
		byte[] var5 = var1.takeFile(this.field1301 >> 16 & 65535, this.field1301 & 65535);
		Buffer var6 = new Buffer(var5);
		int var7 = var6.readUnsignedByte();
		int var8 = var6.readUnsignedShort();
		byte[] var9 = var2.getFile(var8, 0);
		this.field1305 = new Skeleton(var8, var9);
		this.field1302 = new ArrayList();
		this.field1303 = field1296.submit(new class134(this, var6, var7));
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;IB)V",
		garbageValue = "100"
	)
	void method745(Buffer var1, int var2) {
		var1.readUnsignedShort();
		var1.readUnsignedShort();
		this.field1300 = var1.readUnsignedByte();
		int var3 = var1.readUnsignedShort();
		this.field1299 = new class130[this.field1305.method1231().method1212()][];
		this.field1304 = new class130[this.field1305.method1230()][];
		class129[] var4 = new class129[var3];

		int var5;
		int var7;
		int var9;
		for (var5 = 0; var5 < var3; ++var5) {
			var7 = var1.readUnsignedByte();
			class131 var8 = (class131)KeyHandler.findEnumerated(WorldMapSprite.method1533(), var7);
			if (var8 == null) {
				var8 = class131.field1268;
			}

			var9 = var1.readShortSmart();
			int var11 = var1.readUnsignedByte();
			class132[] var12 = new class132[]{class132.field1288, class132.field1277, class132.field1283, class132.field1287, class132.field1275, class132.field1280, class132.field1289, class132.field1284, class132.field1273, class132.field1278, class132.field1276, class132.field1285, class132.field1281, class132.field1282, class132.field1286, class132.field1274, class132.field1279};
			class132 var13 = (class132)KeyHandler.findEnumerated(var12, var11);
			if (var13 == null) {
				var13 = class132.field1288;
			}

			class130 var20 = new class130();
			var20.method718(var1, var2);
			var4[var5] = new class129(this, var20, var8, var13, var9);
			int var14 = var8.method727();
			class130[][] var15;
			if (var8 == class131.field1264) {
				var15 = this.field1299;
			} else {
				var15 = this.field1304;
			}

			if (var15[var9] == null) {
				var15[var9] = new class130[var14];
			}

			if (var8 == class131.field1263) {
				this.field1298 = true;
			}
		}

		var5 = var3 / class291.field2496;
		int var16 = var3 % class291.field2496;
		int var17 = 0;

		for (var9 = 0; var9 < class291.field2496; ++var9) {
			var7 = var17;
			var17 += var5;
			if (var16 > 0) {
				++var17;
				--var16;
			}

			if (var17 == var7) {
				break;
			}

			this.field1302.add(field1296.submit(new class136(this, var7, var17, var4)));
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1948814782"
	)
	public boolean method746() {
		if (this.field1303 == null && this.field1302 == null) {
			return true;
		} else {
			if (this.field1303 != null) {
				if (!this.field1303.isDone()) {
					return false;
				}

				this.field1303 = null;
			}

			boolean var1 = true;

			for (int var2 = 0; var2 < this.field1302.size(); ++var2) {
				if (!((Future)this.field1302.get(var2)).isDone()) {
					var1 = false;
				} else {
					this.field1302.remove(var2);
					--var2;
				}
			}

			if (!var1) {
				return false;
			} else {
				this.field1302 = null;
				return true;
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1976853081"
	)
	public int method747() {
		return this.field1300;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1397730419"
	)
	public boolean method748() {
		return this.field1298;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(ILeo;IIB)V",
		garbageValue = "-98"
	)
	public void method749(int var1, class127 var2, int var3, int var4) {
		class450 var5;
		synchronized(class450.field3873) {
			if (class462.field3904 == 0) {
				var5 = new class450();
			} else {
				class450.field3873[--class462.field3904].method2302();
				var5 = class450.field3873[class462.field3904];
			}
		}

		this.method750(var5, var3, var2, var1);
		this.method753(var5, var3, var2, var1);
		this.method752(var5, var3, var2, var1);
		var2.method708(var5);
		var5.method2298();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Lrz;ILeo;II)V",
		garbageValue = "1937438486"
	)
	void method750(class450 var1, int var2, class127 var3, int var4) {
		float[] var5 = var3.method712(this.field1300);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1299[var2] != null) {
			class130 var9 = this.field1299[var2][0];
			class130 var10 = this.field1299[var2][1];
			class130 var11 = this.field1299[var2][2];
			if (var9 != null) {
				var6 = var9.method720(var4);
			}

			if (var10 != null) {
				var7 = var10.method720(var4);
			}

			if (var11 != null) {
				var8 = var11.method720(var4);
			}
		}

		class449 var17 = Login.method427();
		var17.method2295(1.0F, 0.0F, 0.0F, var6);
		class449 var18 = Login.method427();
		var18.method2295(0.0F, 1.0F, 0.0F, var7);
		class449 var19 = Login.method427();
		var19.method2295(0.0F, 0.0F, 1.0F, var8);
		class449 var12 = Login.method427();
		var12.method2297(var19);
		var12.method2297(var17);
		var12.method2297(var18);
		class450 var13;
		synchronized(class450.field3873) {
			if (class462.field3904 == 0) {
				var13 = new class450();
			} else {
				class450.field3873[--class462.field3904].method2302();
				var13 = class450.field3873[class462.field3904];
			}
		}

		var13.method2309(var12);
		var1.method2308(var13);
		var17.method2293();
		var18.method2293();
		var19.method2293();
		var12.method2293();
		var13.method2298();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Lrz;ILeo;II)V",
		garbageValue = "1689339528"
	)
	void method752(class450 var1, int var2, class127 var3, int var4) {
		float[] var5 = var3.method713(this.field1300);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1299[var2] != null) {
			class130 var9 = this.field1299[var2][3];
			class130 var10 = this.field1299[var2][4];
			class130 var11 = this.field1299[var2][5];
			if (var9 != null) {
				var6 = var9.method720(var4);
			}

			if (var10 != null) {
				var7 = var10.method720(var4);
			}

			if (var11 != null) {
				var8 = var11.method720(var4);
			}
		}

		var1.field3875[12] = var6;
		var1.field3875[13] = var7;
		var1.field3875[14] = var8;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lrz;ILeo;II)V",
		garbageValue = "-2003285459"
	)
	void method753(class450 var1, int var2, class127 var3, int var4) {
		float[] var5 = var3.method714(this.field1300);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1299[var2] != null) {
			class130 var9 = this.field1299[var2][6];
			class130 var10 = this.field1299[var2][7];
			class130 var11 = this.field1299[var2][8];
			if (var9 != null) {
				var6 = var9.method720(var4);
			}

			if (var10 != null) {
				var7 = var10.method720(var4);
			}

			if (var11 != null) {
				var8 = var11.method720(var4);
			}
		}

		class450 var14;
		synchronized(class450.field3873) {
			if (class462.field3904 == 0) {
				var14 = new class450();
			} else {
				class450.field3873[--class462.field3904].method2302();
				var14 = class450.field3873[class462.field3904];
			}
		}

		var14.method2306(var6, var7, var8);
		var1.method2308(var14);
		var14.method2298();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "([BI)V",
		garbageValue = "-7280279"
	)
	@Export("SpriteBuffer_decode")
	static void SpriteBuffer_decode(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		var1.offset = var0.length - 2;
		class529.SpriteBuffer_spriteCount = var1.readUnsignedShort();
		class529.SpriteBuffer_xOffsets = new int[class529.SpriteBuffer_spriteCount];
		class152.SpriteBuffer_yOffsets = new int[class529.SpriteBuffer_spriteCount];
		HealthBarUpdate.SpriteBuffer_spriteWidths = new int[class529.SpriteBuffer_spriteCount];
		SpriteMask.SpriteBuffer_spriteHeights = new int[class529.SpriteBuffer_spriteCount];
		Coord.SpriteBuffer_pixels = new byte[class529.SpriteBuffer_spriteCount][];
		var1.offset = var0.length - 7 - class529.SpriteBuffer_spriteCount * 8;
		class529.SpriteBuffer_spriteWidth = var1.readUnsignedShort();
		class420.SpriteBuffer_spriteHeight = var1.readUnsignedShort();
		int var2 = (var1.readUnsignedByte() & 255) + 1;

		int var3;
		for (var3 = 0; var3 < class529.SpriteBuffer_spriteCount; ++var3) {
			class529.SpriteBuffer_xOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class529.SpriteBuffer_spriteCount; ++var3) {
			class152.SpriteBuffer_yOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class529.SpriteBuffer_spriteCount; ++var3) {
			HealthBarUpdate.SpriteBuffer_spriteWidths[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class529.SpriteBuffer_spriteCount; ++var3) {
			SpriteMask.SpriteBuffer_spriteHeights[var3] = var1.readUnsignedShort();
		}

		var1.offset = var0.length - 7 - class529.SpriteBuffer_spriteCount * 8 - (var2 - 1) * 3;
		DbTableType.SpriteBuffer_spritePalette = new int[var2];

		for (var3 = 1; var3 < var2; ++var3) {
			DbTableType.SpriteBuffer_spritePalette[var3] = var1.readMedium();
			if (DbTableType.SpriteBuffer_spritePalette[var3] == 0) {
				DbTableType.SpriteBuffer_spritePalette[var3] = 1;
			}
		}

		var1.offset = 0;

		for (var3 = 0; var3 < class529.SpriteBuffer_spriteCount; ++var3) {
			int var4 = HealthBarUpdate.SpriteBuffer_spriteWidths[var3];
			int var5 = SpriteMask.SpriteBuffer_spriteHeights[var3];
			int var6 = var4 * var5;
			byte[] var7 = new byte[var6];
			Coord.SpriteBuffer_pixels[var3] = var7;
			int var8 = var1.readUnsignedByte();
			int var9;
			if (var8 == 0) {
				for (var9 = 0; var9 < var6; ++var9) {
					var7[var9] = var1.readByte();
				}
			} else if (var8 == 1) {
				for (var9 = 0; var9 < var4; ++var9) {
					for (int var10 = 0; var10 < var5; ++var10) {
						var7[var9 + var4 * var10] = var1.readByte();
					}
				}
			}
		}

	}
}