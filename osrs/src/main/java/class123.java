import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class123 extends DualNode {
	@ObfuscatedName("tf")
	@ObfuscatedGetter(
		intValue = -24815631
	)
	static int field1520;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1466561951
	)
	@Export("canvasWidth")
	public static int canvasWidth;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 822751707
	)
	int field1518;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "[[Ldi;"
	)
	public class118[][] field1514;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "[[Ldi;"
	)
	class118[][] field1515;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lgm;"
	)
	public Skeleton field1516;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 217334787
	)
	int field1517;
	@ObfuscatedName("w")
	boolean field1521;

	@ObfuscatedSignature(
		descriptor = "(Llv;Llv;IZ)V"
	)
	class123(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		this.field1514 = null;
		this.field1515 = null;
		this.field1517 = 0;
		this.field1518 = var3;
		byte[] var5 = var1.takeFile(this.field1518 >> 16 & 65535, this.field1518 & 65535);
		Buffer var6 = new Buffer(var5);
		int var7 = var6.readUnsignedByte();
		int var8 = var6.readUnsignedShort();
		byte[] var9;
		if (var4) {
			var9 = var2.getFile(0, var8);
		} else {
			var9 = var2.getFile(var8, 0);
		}

		this.field1516 = new Skeleton(var8, var9);
		this.method2929(var6, var7);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Lqq;II)V",
		garbageValue = "1360392494"
	)
	void method2929(Buffer var1, int var2) {
		var1.readUnsignedShort();
		var1.readUnsignedShort();
		this.field1517 = var1.readUnsignedByte();
		int var3 = var1.readUnsignedShort();
		this.field1515 = new class118[this.field1516.method4249().method4231()][];
		this.field1514 = new class118[this.field1516.method4248()][];

		for (int var4 = 0; var4 < var3; ++var4) {
			class119 var5 = WorldMapEvent.method5257(var1.readUnsignedByte());
			int var6 = var1.readShortSmart();
			class120 var7 = class388.method7152(var1.readUnsignedByte());
			class118 var8 = new class118();
			var8.method2868(var1, var2);
			int var9 = var5.method2901();
			class118[][] var10;
			if (var5 == class119.field1470) {
				var10 = this.field1515;
			} else {
				var10 = this.field1514;
			}

			if (var10[var6] == null) {
				var10[var6] = new class118[var9];
			}

			var10[var6][var7.method2914()] = var8;
			if (var5 == class119.field1471) {
				this.field1521 = true;
			}
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "32"
	)
	public int method2945() {
		return this.field1517;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-40"
	)
	public boolean method2931() {
		return this.field1521;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(ILdj;IIB)V",
		garbageValue = "18"
	)
	public void method2930(int var1, class116 var2, int var3, int var4) {
		class389 var5 = SequenceDefinition.method3974();
		this.method2941(var5, var3, var2, var1);
		this.method2935(var5, var3, var2, var1);
		this.method2934(var5, var3, var2, var1);
		var2.method2824(var5);
		var5.method7203();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(Lnw;ILdj;IB)V",
		garbageValue = "0"
	)
	void method2941(class389 var1, int var2, class116 var3, int var4) {
		float[] var5 = var3.method2828(this.field1517);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1515[var2] != null) {
			class118 var9 = this.field1515[var2][0];
			class118 var10 = this.field1515[var2][1];
			class118 var11 = this.field1515[var2][2];
			if (var9 != null) {
				var6 = var9.method2870(var4);
			}

			if (var10 != null) {
				var7 = var10.method2870(var4);
			}

			if (var11 != null) {
				var8 = var11.method2870(var4);
			}
		}

		class388 var16 = class82.method2262();
		var16.method7144(1.0F, 0.0F, 0.0F, var6);
		class388 var14 = class82.method2262();
		var14.method7144(0.0F, 1.0F, 0.0F, var7);
		class388 var15 = class82.method2262();
		var15.method7144(0.0F, 0.0F, 1.0F, var8);
		class388 var12 = class82.method2262();
		var12.method7163(var15);
		var12.method7163(var16);
		var12.method7163(var14);
		class389 var13 = SequenceDefinition.method3974();
		var13.method7179(var12);
		var1.method7178(var13);
		var16.method7143();
		var14.method7143();
		var15.method7143();
		var12.method7143();
		var13.method7203();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(Lnw;ILdj;II)V",
		garbageValue = "598653608"
	)
	void method2934(class389 var1, int var2, class116 var3, int var4) {
		float[] var5 = var3.method2849(this.field1517);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1515[var2] != null) {
			class118 var9 = this.field1515[var2][3];
			class118 var10 = this.field1515[var2][4];
			class118 var11 = this.field1515[var2][5];
			if (var9 != null) {
				var6 = var9.method2870(var4);
			}

			if (var10 != null) {
				var7 = var10.method2870(var4);
			}

			if (var11 != null) {
				var8 = var11.method2870(var4);
			}
		}

		var1.field4440[12] = var6;
		var1.field4440[13] = var7;
		var1.field4440[14] = var8;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(Lnw;ILdj;IB)V",
		garbageValue = "6"
	)
	void method2935(class389 var1, int var2, class116 var3, int var4) {
		float[] var5 = var3.method2854(this.field1517);
		float var6 = var5[0];
		float var7 = var5[1];
		float var8 = var5[2];
		if (this.field1515[var2] != null) {
			class118 var9 = this.field1515[var2][6];
			class118 var10 = this.field1515[var2][7];
			class118 var11 = this.field1515[var2][8];
			if (var9 != null) {
				var6 = var9.method2870(var4);
			}

			if (var10 != null) {
				var7 = var10.method2870(var4);
			}

			if (var11 != null) {
				var8 = var11.method2870(var4);
			}
		}

		class389 var12 = SequenceDefinition.method3974();
		var12.method7176(var6, var7, var8);
		var1.method7178(var12);
		var12.method7203();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "846863545"
	)
	public static String method2954(String var0) {
		int var1 = var0.length();
		char[] var2 = new char[var1];
		byte var3 = 2;

		for (int var4 = 0; var4 < var1; ++var4) {
			char var5 = var0.charAt(var4);
			if (var3 == 0) {
				var5 = Character.toLowerCase(var5);
			} else if (var3 == 2 || Character.isUpperCase(var5)) {
				var5 = WorldMapManager.method4969(var5);
			}

			if (Character.isLetter(var5)) {
				var3 = 0;
			} else if (var5 != '.' && var5 != '?' && var5 != '!') {
				if (Character.isSpaceChar(var5)) {
					if (var3 != 2) {
						var3 = 1;
					}
				} else {
					var3 = 1;
				}
			} else {
				var3 = 2;
			}

			var2[var4] = var5;
		}

		return new String(var2);
	}
}
