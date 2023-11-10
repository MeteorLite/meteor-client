import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.applet.Applet;
import java.util.Arrays;

@ObfuscatedName("bd")
public class class27 {
	@ObfuscatedName("aa")
	int[] field80;
	@ObfuscatedName("ac")
	int[] field81;

	public class27() {
		this.field80 = new int[112];
		this.field81 = new int[192];
		Arrays.fill(this.field80, 3);
		Arrays.fill(this.field81, 3);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1639161786"
	)
	public void method111(int var1, int var2) {
		if (this.method121(var1) && this.method123(var2)) {
			this.field80[var1] = var2;
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(CII)V",
		garbageValue = "-87016088"
	)
	public void method113(char var1, int var2) {
		if (this.method122(var1) && this.method123(var2)) {
			this.field81[var1] = var2;
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1141320535"
	)
	public int method115(int var1) {
		return this.method121(var1) ? this.field80[var1] : 0;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(CI)I",
		garbageValue = "832183208"
	)
	public int method116(char var1) {
		return this.method122(var1) ? this.field81[var1] : 0;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1834915572"
	)
	public boolean method117(int var1) {
		return this.method121(var1) && (this.field80[var1] == 1 || this.field80[var1] == 3);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "1013987055"
	)
	public boolean method118(char var1) {
		return this.method122(var1) && (this.field81[var1] == 1 || this.field81[var1] == 3);
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1584083272"
	)
	public boolean method119(int var1) {
		return this.method121(var1) && (this.field80[var1] == 2 || this.field80[var1] == 3);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "-769837729"
	)
	public boolean method120(char var1) {
		return this.method122(var1) && (this.field81[var1] == 2 || this.field81[var1] == 3);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "2115531423"
	)
	boolean method121(int var1) {
		if (var1 >= 0 && var1 < 112) {
			return true;
		} else {
			System.out.println("Invalid keycode: " + var1);
			return false;
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "494262388"
	)
	boolean method122(char var1) {
		if (var1 >= 0 && var1 < 192) {
			return true;
		} else {
			System.out.println("Invalid keychar: " + var1);
			return false;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(IS)Z",
		garbageValue = "9461"
	)
	boolean method123(int var1) {
		if (var1 >= 0 && var1 < 4) {
			return true;
		} else {
			System.out.println("Invalid mode: " + var1);
			return false;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
		garbageValue = "-1746840644"
	)
	public static void method112(Applet var0, String var1) {
		class31.field85 = var0;
		if (var1 != null) {
			class31.field86 = var1;
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lnh;I)V",
		garbageValue = "-1843378433"
	)
	public static void method110(Huffman var0) {
		class350.huffman = var0;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "70"
	)
	static int method114(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else if (var1 == -1) {
			return 0;
		} else {
			int var3 = 0;

			for (int var4 = 0; var4 < var2.quantities.length; ++var4) {
				if (var2.ids[var4] == var1) {
					var3 += var2.quantities[var4];
				}
			}

			return var3;
		}
	}
}