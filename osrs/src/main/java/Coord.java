import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kz")
@Implements("Coord")
public class Coord {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -971404419
	)
	@Export("plane")
	public int plane;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1909585313
	)
	@Export("x")
	public int x;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1205071133
	)
	@Export("y")
	public int y;

	@ObfuscatedSignature(
		descriptor = "(Lkz;)V"
	)
	public Coord(Coord var1) {
		this.plane = var1.plane;
		this.x = var1.x;
		this.y = var1.y;
	}

	public Coord(int var1, int var2, int var3) {
		this.plane = var1;
		this.x = var2;
		this.y = var3;
	}

	public Coord(int var1) {
		if (var1 == -1) {
			this.plane = -1;
		} else {
			this.plane = var1 >> 28 & 3;
			this.x = var1 >> 14 & 16383;
			this.y = var1 & 16383;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-49"
	)
	@Export("packed")
	public int packed() {
		int var2 = this.plane;
		int var3 = this.x;
		int var4 = this.y;
		int var1 = var2 << 28 | var3 << 14 | var4;
		return var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Lkz;I)Z",
		garbageValue = "1896039463"
	)
	@Export("equalsCoord")
	boolean equalsCoord(Coord var1) {
		if (this.plane != var1.plane) {
			return false;
		} else if (this.x != var1.x) {
			return false;
		} else {
			return this.y == var1.y;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "1344824322"
	)
	@Export("toString")
	String toString(String var1) {
		return this.plane + var1 + (this.x >> 6) + var1 + (this.y >> 6) + var1 + (this.x & 63) + var1 + (this.y & 63);
	}

	public String toString() {
		return this.toString(",");
	}

	public int hashCode() {
		return this.packed();
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else {
			return !(var1 instanceof Coord) ? false : this.equalsCoord((Coord)var1);
		}
	}

	@ObfuscatedName("fl")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1396639971"
	)
	@Export("updateGameState")
	static void updateGameState(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 0) {
				IgnoreList.client.method493();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45 || var0 == 50) {
				class142.method3196(0);
				Client.field525 = 0;
				Client.field526 = 0;
				Client.timer.method6704(var0);
				if (var0 != 20) {
					PacketWriter.method2673(false);
				}
			}

			if (var0 != 20 && var0 != 40 && RouteStrategy.field2237 != null) {
				RouteStrategy.field2237.close();
				RouteStrategy.field2237 = null;
			}

			if (Client.gameState == 25) {
				Client.field774 = 0;
				Client.field523 = 0;
				Client.field585 = 1;
				Client.field558 = 0;
				Client.field559 = 1;
			}

			int var1;
			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					var1 = Client.gameState == 11 ? 4 : 0;
					LoginScreenAnimation.method2375(class163.archive10, ChatChannel.archive8, false, var1);
				} else if (var0 == 11) {
					LoginScreenAnimation.method2375(class163.archive10, ChatChannel.archive8, false, 4);
				} else if (var0 == 50) {
					SecureRandomCallable.setLoginResponseString("", "Updating date of birth...", "");
					LoginScreenAnimation.method2375(class163.archive10, ChatChannel.archive8, false, 7);
				} else {
					FriendSystem.method1836();
				}
			} else {
				var1 = class344.method6492() ? 0 : 12;
				LoginScreenAnimation.method2375(class163.archive10, ChatChannel.archive8, true, var1);
			}

			Client.gameState = var0;
		}
	}
}
