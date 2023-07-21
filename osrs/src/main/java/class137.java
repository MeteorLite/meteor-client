import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class137 extends DualNode {
	@ObfuscatedName("aw")
	int field1290;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "[[Lfm;"
	)
	public class130[][] field1293;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "[[Lfm;"
	)
	class130[][] field1288;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	public Skeleton field1294;
	@ObfuscatedName("as")
	int field1289;
	@ObfuscatedName("aj")
	boolean field1287;
	@ObfuscatedName("av")
	Future field1292;
	@ObfuscatedName("ap")
	List field1291;

	@ObfuscatedSignature(
		descriptor = "(Lnd;Lnd;IZ)V",
		garbageValue = "0"
	)
	public class137(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		this.field1293 = null;
		this.field1288 = null;
		this.field1289 = 0;
		this.field1290 = var3;
		byte[] var5 = var1.takeFile(this.field1290 >> 16 & 65535, this.field1290 & 65535);
		Buffer var6 = new Buffer(var5);
		int var7 = var6.readUnsignedByte();
		int var8 = var6.readUnsignedShort();
		byte[] var9 = var2.getFile(var8, 0);
		this.field1294 = new Skeleton(var8, var9);
		this.field1291 = new ArrayList();
		this.field1292 = SoundCache.field214.submit(new class134(this, var6, var7));
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;IB)V",
		garbageValue = "-79"
	)
	void method734(Buffer var1, int var2) {
		var1.readUnsignedShort();
		var1.readUnsignedShort();
		this.field1289 = var1.readUnsignedByte();
		int var3 = var1.readUnsignedShort();
		this.field1288 = new class130[this.field1294.method1207().method1189()][];
		this.field1293 = new class130[this.field1294.method1206()][];
		class129[] var4 = new class129[var3];

		int var5;
		int var7;
		int var17;
		for (var5 = 0; var5 < var3; ++var5) {
			var7 = var1.readUnsignedByte();
			class131[] var8 = new class131[]{class131.field1255, class131.field1256, class131.field1253, class131.field1252, class131.field1254, class131.field1251};
			class131 var9 = (class131)ClientPreferences.findEnumerated(var8, var7);
			if (var9 == null) {
				var9 = class131.field1255;
			}

			var17 = var1.readShortSmart();
			int var11 = var1.readUnsignedByte();
			class132 var12 = (class132)ClientPreferences.findEnumerated(MenuAction.method434(), var11);
			if (var12 == null) {
				var12 = class132.field1274;
			}

			class130 var13 = new class130();
			var13.method709(var1, var2);
			var4[var5] = new class129(this, var13, var9, var12, var17);
			int var14 = var9.method719();
			class130[][] var15;
			if (var9 == class131.field1256) {
				var15 = this.field1288;
			} else {
				var15 = this.field1293;
			}

			if (var15[var17] == null) {
				var15[var17] = new class130[var14];
			}

			if (var9 == class131.field1254) {
				this.field1287 = true;
			}
		}

		var5 = var3 / UserComparator4.field1166;
		int var6 = var3 % UserComparator4.field1166;
		int var16 = 0;

		for (var17 = 0; var17 < UserComparator4.field1166; ++var17) {
			var7 = var16;
			var16 += var5;
			if (var6 > 0) {
				++var16;
				--var6;
			}

			if (var7 == var16) {
				break;
			}

			this.field1291.add(SoundCache.field214.submit(new class136(this, var7, var16, var4)));
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "1"
	)
	public boolean method735() {
		if (this.field1292 == null && this.field1291 == null) {
			return true;
		} else {
			if (this.field1292 != null) {
				if (!this.field1292.isDone()) {
					return false;
				}

				this.field1292 = null;
			}

			boolean var1 = true;

			for (int var2 = 0; var2 < this.field1291.size(); ++var2) {
				if (!((Future)this.field1291.get(var2)).isDone()) {
					var1 = false;
				} else {
					this.field1291.remove(var2);
					--var2;
				}
			}

			if (!var1) {
				return false;
			} else {
				this.field1291 = null;
				return true;
			}
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-316980325"
	)
	public int method736() {
		return this.field1289;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-96"
	)
	public boolean method737() {
		return this.field1287;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(ILek;III)V",
		garbageValue = "519510056"
	)
	public void method738(int var1, class127 var2, int var3, int var4) {
		class451 var5 = class138.method744();
		this.method739(var5, var3, var2, var1);
		this.method741(var5, var3, var2, var1);
		this.method740(var5, var3, var2, var1);
		var2.method697(var5);
		var5.method2271();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lrm;ILek;IB)V",
		garbageValue = "2"
	)
	void method739(class451 var1, int var2, class127 var3, int var4) {
		float[] var5 = var3.method701(this.field1289);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1288[var2] != null) {
			class130 var9 = this.field1288[var2][0];
			class130 var10 = this.field1288[var2][1];
			class130 var11 = this.field1288[var2][2];
			if (var9 != null) {
				var6 = var9.method711(var4);
			}

			if (var10 != null) {
				var7 = var10.method711(var4);
			}

			if (var11 != null) {
				var8 = var11.method711(var4);
			}
		}

		class450 var16 = ViewportMouse.method1321();
		var16.method2267(1.0F, 0.0F, 0.0F, var6);
		class450 var14 = ViewportMouse.method1321();
		var14.method2267(0.0F, 1.0F, 0.0F, var7);
		class450 var15 = ViewportMouse.method1321();
		var15.method2267(0.0F, 0.0F, 1.0F, var8);
		class450 var12 = ViewportMouse.method1321();
		var12.method2269(var15);
		var12.method2269(var16);
		var12.method2269(var14);
		class451 var13 = class138.method744();
		var13.method2283(var12);
		var1.method2282(var13);
		var16.method2265();
		var14.method2265();
		var15.method2265();
		var12.method2265();
		var13.method2271();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Lrm;ILek;II)V",
		garbageValue = "-502012777"
	)
	void method740(class451 var1, int var2, class127 var3, int var4) {
		float[] var5 = var3.method702(this.field1289);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1288[var2] != null) {
			class130 var9 = this.field1288[var2][3];
			class130 var10 = this.field1288[var2][4];
			class130 var11 = this.field1288[var2][5];
			if (var9 != null) {
				var6 = var9.method711(var4);
			}

			if (var10 != null) {
				var7 = var10.method711(var4);
			}

			if (var11 != null) {
				var8 = var11.method711(var4);
			}
		}

		var1.field3861[12] = var6;
		var1.field3861[13] = var7;
		var1.field3861[14] = var8;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Lrm;ILek;II)V",
		garbageValue = "1367616310"
	)
	void method741(class451 var1, int var2, class127 var3, int var4) {
		float[] var5 = var3.method703(this.field1289);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1288[var2] != null) {
			class130 var9 = this.field1288[var2][6];
			class130 var10 = this.field1288[var2][7];
			class130 var11 = this.field1288[var2][8];
			if (var9 != null) {
				var6 = var9.method711(var4);
			}

			if (var10 != null) {
				var7 = var10.method711(var4);
			}

			if (var11 != null) {
				var8 = var11.method711(var4);
			}
		}

		class451 var12 = class138.method744();
		var12.method2280(var6, var7, var8);
		var1.method2282(var12);
		var12.method2271();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lcr;I)V",
		garbageValue = "1214318405"
	)
	@Export("changeWorld")
	static void changeWorld(World var0) {
		if (var0.isMembersOnly() != Client.isMembersWorld) {
			Client.isMembersWorld = var0.isMembersOnly();
			PendingSpawn.method513(var0.isMembersOnly());
		}

		if (var0.properties != Client.worldProperties) {
			class425.method2154(class386.archive8, var0.properties);
		}

		VarbitComposition.worldHost = var0.host;
		Client.worldId = var0.id;
		Client.worldProperties = var0.properties;
		VarpDefinition.field1494 = var0.field677;
		Login.worldPort = Client.gameBuild == 0 ? 43594 : var0.id + 40000;
		class11.js5Port = Client.gameBuild == 0 ? 443 : var0.id + 50000;
		Varps.currentPort = Login.worldPort;
	}
}
