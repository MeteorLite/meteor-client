import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
public class class228 {
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "[Lek;"
	)
	class127[] field2018;
	@ObfuscatedName("ar")
	int field2019;

	@ObfuscatedSignature(
		descriptor = "(Lty;I)V"
	)
	class228(Buffer var1, int var2) {
		this.field2018 = new class127[var2];
		this.field2019 = var1.readUnsignedByte();

		for (int var3 = 0; var3 < this.field2018.length; ++var3) {
			class127 var4 = new class127(this.field2019, var1, false);
			this.field2018[var3] = var4;
		}

		this.method1188();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-5"
	)
	void method1188() {
		class127[] var1 = this.field2018;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			class127 var3 = var1[var2];
			if (var3.field1213 >= 0) {
				var3.field1212 = this.field2018[var3.field1213];
			}
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "3739"
	)
	public int method1189() {
		return this.field2018.length;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)Lek;",
		garbageValue = "1197556608"
	)
	class127 method1191(int var1) {
		return var1 >= this.method1189() ? null : this.field2018[var1];
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)[Lek;",
		garbageValue = "104"
	)
	class127[] method1192() {
		return this.field2018;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lfz;II)V",
		garbageValue = "233488741"
	)
	void method1193(class137 var1, int var2) {
		this.method1194(var1, var2, (boolean[])null, false);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lfz;I[ZZI)V",
		garbageValue = "2080039921"
	)
	void method1194(class137 var1, int var2, boolean[] var3, boolean var4) {
		int var5 = var1.method736();
		int var6 = 0;
		class127[] var7 = this.method1192();

		for (int var8 = 0; var8 < var7.length; ++var8) {
			class127 var9 = var7[var8];
			if (var3 == null || var4 == var3[var6]) {
				var1.method738(var2, var9, var6, var5);
			}

			++var6;
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Lut;",
		garbageValue = "1151848897"
	)
	public static PrivateChatMode method1187(int var0) {
		PrivateChatMode[] var1 = new PrivateChatMode[]{PrivateChatMode.field4228, PrivateChatMode.field4229, PrivateChatMode.field4227};
		PrivateChatMode[] var2 = var1;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			PrivateChatMode var4 = var2[var3];
			if (var0 == var4.id) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1771033339"
	)
	public static int method1190(int var0) {
		return class304.field2739[var0];
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-1328962536"
	)
	public static int method1195(int var0, int var1) {
		int var2 = var0 >>> 31;
		return (var0 + var2) / var1 - var2;
	}
}
