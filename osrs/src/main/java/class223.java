import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
public class class223 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	static final class223 field1872;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	static final class223 field1875;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	static final class223 field1874;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	static final class223 field1877;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	public static final class223 field1869;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	static final class223 field1873;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	public static final class223 field1870;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	public static final class223 field1866;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	public static final class223 field1868;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	public static final class223 field1871;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	public static final class223 field1867;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	public static final class223 field1865;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	static final class223 field1876;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lij;"
	)
	static final class223 field1878;
	@ObfuscatedName("aw")
	public static String field1863;
	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "Lui;"
	)
	@Export("rasterProvider")
	public static AbstractRasterProvider rasterProvider;
	@ObfuscatedName("as")
	public final int field1879;

	static {
		field1872 = new class223(0);
		field1875 = new class223(1);
		field1874 = new class223(2);
		field1877 = new class223(3);
		field1869 = new class223(4, class209.field1651);
		field1873 = new class223(5);
		field1870 = new class223(6, class209.field1655);
		field1866 = new class223(7, class209.field1650);
		field1868 = new class223(8, class209.field1649);
		field1871 = new class223(9, class209.field1653);
		field1867 = new class223(10, class209.field1654);
		field1865 = new class223(11, class209.field1652);
		field1876 = new class223(12);
		field1878 = new class223(13);
	}

	class223(int var1) {
		this(var1, (class209)null);
	}

	@ObfuscatedSignature(
		descriptor = "(ILik;)V"
	)
	class223(int var1, class209 var2) {
		this.field1879 = var1;
	}

	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-886545953"
	)
	static void method1129() {
		class467.field3921 = System.getenv("JX_ACCESS_TOKEN");
		class191.field1499 = System.getenv("JX_REFRESH_TOKEN");
		LoginScreenAnimation.field1042 = System.getenv("JX_SESSION_ID");
		class155.field1355 = System.getenv("JX_CHARACTER_ID");
		String var0 = System.getenv("JX_DISPLAY_NAME");
		String var1;
		if (var0 != null && !var0.isEmpty() && var0.charAt(0) != '#') {
			var1 = var0;
		} else {
			var1 = "";
		}

		Login.field761 = var1;
	}

	@ObfuscatedName("mj")
	@ObfuscatedSignature(
		descriptor = "(IIIIII)V",
		garbageValue = "796213891"
	)
	@Export("drawScrollBar")
	static final void drawScrollBar(int var0, int var1, int var2, int var3, int var4) {
		class36.scrollBarSprites[0].drawAt(var0, var1);
		class36.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field459);
		int var5 = var3 * (var3 - 32) / var4;
		if (var5 < 8) {
			var5 = 8;
		}

		int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field458);
		Rasterizer2D.method2677(var0, var6 + var1 + 16, var5, Client.field463);
		Rasterizer2D.method2677(var0 + 1, var6 + var1 + 16, var5, Client.field463);
		Rasterizer2D.method2675(var0, var6 + var1 + 16, 16, Client.field463);
		Rasterizer2D.method2675(var0, var6 + var1 + 17, 16, Client.field463);
		Rasterizer2D.method2677(var0 + 15, var6 + var1 + 16, var5, Client.field461);
		Rasterizer2D.method2677(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field461);
		Rasterizer2D.method2675(var0, var5 + var6 + var1 + 15, 16, Client.field461);
		Rasterizer2D.method2675(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field461);
	}

	@ObfuscatedName("oj")
	@ObfuscatedSignature(
		descriptor = "(II)Luq;",
		garbageValue = "-134807305"
	)
	static class521 method1131(int var0) {
		class521 var1 = (class521)Client.archive11.get((long)var0);
		if (var1 == null) {
			var1 = new class521(class313.field2770, var0);
		}

		return var1;
	}
}