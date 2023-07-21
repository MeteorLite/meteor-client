import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
public class class212 extends Node {
	@ObfuscatedName("ar")
	public int field1854;
	@ObfuscatedName("am")
	public int field1853;
	@ObfuscatedName("as")
	public int field1855;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	public Widget field1856;

	@ObfuscatedSignature(
		descriptor = "(IIILmt;)V"
	)
	public class212(int var1, int var2, int var3, Widget var4) {
		this.field1855 = var1;
		this.field1854 = var2;
		this.field1853 = var3;
		this.field1856 = var4;
	}

	@ObfuscatedName("nw")
	@ObfuscatedSignature(
		descriptor = "(Lmt;II)Ljava/lang/String;",
		garbageValue = "-1905887286"
	)
	static String method1077(Widget var0, int var1) {
		int var3 = UserComparator8.getWidgetFlags(var0);
		boolean var2 = (var3 >> var1 + 1 & 1) != 0;
		if (!var2 && var0.onOp == null) {
			return null;
		} else {
			return var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null;
		}
	}
}
