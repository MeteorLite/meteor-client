import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
public class class209 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	static final class209 field1870;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	static final class209 field1864;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	static final class209 field1868;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	static final class209 field1869;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	public static final class209 field1858;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	static final class209 field1865;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	public static final class209 field1863;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	public static final class209 field1861;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	public static final class209 field1857;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	public static final class209 field1860;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	public static final class209 field1859;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	public static final class209 field1862;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	static final class209 field1866;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "Lil;"
	)
	static final class209 field1867;
	@ObfuscatedName("ar")
	public final int field1871;

	static {
		field1870 = new class209(0);
		field1864 = new class209(1);
		field1868 = new class209(2);
		field1869 = new class209(3);
		field1858 = new class209(4, class197.field1641);
		field1865 = new class209(5);
		field1863 = new class209(6, class197.field1642);
		field1861 = new class209(7, class197.field1640);
		field1857 = new class209(8, class197.field1643);
		field1860 = new class209(9, class197.field1638);
		field1859 = new class209(10, class197.field1644);
		field1862 = new class209(11, class197.field1639);
		field1866 = new class209(12);
		field1867 = new class209(13);
	}

	class209(int var1) {
		this(var1, (class197)null);
	}

	@ObfuscatedSignature(
		descriptor = "(ILhp;)V"
	)
	class209(int var1, class197 var2) {
		this.field1871 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "61"
	)
	static int method1087(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
		}
	}
}