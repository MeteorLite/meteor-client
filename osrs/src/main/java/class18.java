import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.Future;

@ObfuscatedName("ax")
public class class18 {
	@ObfuscatedName("vg")
	@ObfuscatedSignature(
		descriptor = "Lsm;"
	)
	static PlatformInfo field51;
	@ObfuscatedName("ba")
	protected static String field50;
	@ObfuscatedName("au")
	Future field53;
	@ObfuscatedName("ae")
	String field52;

	class18(Future var1) {
		this.field53 = var1;
	}

	class18(String var1) {
		this.method51(var1);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-1898504795"
	)
	void method51(String var1) {
		if (var1 == null) {
			var1 = "";
		}

		this.field52 = var1;
		if (this.field53 != null) {
			this.field53.cancel(true);
			this.field53 = null;
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-197315393"
	)
	public final String method52() {
		return this.field52;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2089695473"
	)
	public boolean method53() {
		return this.field52 != null || this.field53 == null;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "1"
	)
	public final boolean method54() {
		return this.method53() ? true : this.field53.isDone();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)Las;",
		garbageValue = "626026127"
	)
	public final class20 method55() {
		if (this.method53()) {
			return new class20(this.field52);
		} else if (!this.method54()) {
			return null;
		} else {
			try {
				return (class20)this.field53.get();
			} catch (Exception var3) {
				String var2 = "Error retrieving REST request reply";
				System.err.println(var2 + "\r\n" + var3);
				this.method51(var2);
				return new class20(var2);
			}
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1969917926"
	)
	public static void method56() {
		WorldMapRegion.WorldMapRegion_cachedSprites.demote(5);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(S)Lch;",
		garbageValue = "9992"
	)
	@Export("worldListStart")
	static World worldListStart() {
		World.World_listCount = 0;
		return VarcInt.getNextWorldListWorld();
	}

	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "94"
	)
	static void method58() {
		class27.field76 = System.getenv("JX_ACCESS_TOKEN");
		class9.field20 = System.getenv("JX_REFRESH_TOKEN");
		class157.field1407 = System.getenv("JX_SESSION_ID");
		Varcs.field1140 = System.getenv("JX_CHARACTER_ID");
		class478.method2372(System.getenv("JX_DISPLAY_NAME"));
	}

	@ObfuscatedName("jh")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "-1303959829"
	)
	@Export("getTileHeight")
	static final int getTileHeight(int var0, int var1, int var2) {
		int var3 = var0 >> 7;
		int var4 = var1 >> 7;
		if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
			int var5 = var2;
			if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
				var5 = var2 + 1;
			}

			int var6 = var0 & 127;
			int var7 = var1 & 127;
			int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4] + var6 * Tiles.Tiles_heights[var5][var3 + 1][var4] >> 7;
			int var9 = var6 * Tiles.Tiles_heights[var5][var3 + 1][var4 + 1] + Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
			return var9 * var7 + var8 * (128 - var7) >> 7;
		} else {
			return 0;
		}
	}
}