import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("bk")
public class class27 {
	@ObfuscatedName("au")
	static String[] field74;
	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	@Export("archive13")
	static Archive archive13;
	@ObfuscatedName("ar")
	int[] field77;
	@ObfuscatedName("ab")
	int[] field76;

	public class27() {
		this.field77 = new int[112];
		this.field76 = new int[192];
		Arrays.fill(this.field77, 3);
		Arrays.fill(this.field76, 3);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1970517025"
	)
	public void method102(int var1, int var2) {
		if (this.method111(var1) && this.method113(var2)) {
			this.field77[var1] = var2;
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(CII)V",
		garbageValue = "-1891863343"
	)
	public void method104(char var1, int var2) {
		if (this.method112(var1) && this.method113(var2)) {
			this.field76[var1] = var2;
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "24"
	)
	public int method105(int var1) {
		return this.method111(var1) ? this.field77[var1] : 0;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(CI)I",
		garbageValue = "-535571819"
	)
	public int method106(char var1) {
		return this.method112(var1) ? this.field76[var1] : 0;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "-101"
	)
	public boolean method107(int var1) {
		return this.method111(var1) && (this.field77[var1] == 1 || this.field77[var1] == 3);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(CB)Z",
		garbageValue = "9"
	)
	public boolean method108(char var1) {
		return this.method112(var1) && (this.field76[var1] == 1 || this.field76[var1] == 3);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1930578634"
	)
	public boolean method109(int var1) {
		return this.method111(var1) && (this.field77[var1] == 2 || this.field77[var1] == 3);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(CB)Z",
		garbageValue = "37"
	)
	public boolean method110(char var1) {
		return this.method112(var1) && (this.field76[var1] == 2 || this.field76[var1] == 3);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "0"
	)
	boolean method111(int var1) {
		if (var1 >= 0 && var1 < 112) {
			return true;
		} else {
			System.out.println("Invalid keycode: " + var1);
			return false;
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "-1032091509"
	)
	boolean method112(char var1) {
		if (var1 >= 0 && var1 < 192) {
			return true;
		} else {
			System.out.println("Invalid keychar: " + var1);
			return false;
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1780470681"
	)
	boolean method113(int var1) {
		if (var1 >= 0 && var1 < 4) {
			return true;
		} else {
			System.out.println("Invalid mode: " + var1);
			return false;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "534503383"
	)
	@Export("ItemContainer_getCount")
	static int ItemContainer_getCount(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else {
			return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-376109619"
	)
	static void method114(int var0) {
		GameEngine.method166(14);
		Login.field748 = var0;
	}
}