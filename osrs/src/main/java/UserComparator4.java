import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("UserComparator4")
public class UserComparator4 implements Comparator {
	@ObfuscatedName("vf")
	@ObfuscatedGetter(
		intValue = 1706361753
	)
	@Export("foundItemIdCount")
	static int foundItemIdCount;
	@ObfuscatedName("c")
	@Export("reversed")
	final boolean reversed;

	public UserComparator4(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lnr;Lnr;B)I",
		garbageValue = "-116"
	)
	@Export("compare_bridged")
	int compare_bridged(Buddy var1, Buddy var2) {
		return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((Buddy)var1, (Buddy)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)[Lqt;",
		garbageValue = "392614583"
	)
	@Export("FillMode_values")
	public static FillMode[] FillMode_values() {
		return new FillMode[]{FillMode.SOLID, FillMode.field4810, FillMode.field4814};
	}

	@ObfuscatedName("hp")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "564741140"
	)
	static boolean method2730() {
		return (Client.drawPlayerNames & 4) != 0;
	}

	@ObfuscatedName("iq")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1545861626"
	)
	static final void method2731() {
		PacketBuffer var0 = Client.packetWriter.packetBuffer;
		var0.importIndex();
		int var1 = var0.readBits(8);
		int var2;
		if (var1 < Client.npcCount) {
			for (var2 = var1; var2 < Client.npcCount; ++var2) {
				Client.field775[++Client.field625 - 1] = Client.npcIndices[var2];
			}
		}

		if (var1 > Client.npcCount) {
			throw new RuntimeException("");
		} else {
			Client.npcCount = 0;

			for (var2 = 0; var2 < var1; ++var2) {
				int var3 = Client.npcIndices[var2];
				NPC var4 = Client.npcs[var3];
				int var5 = var0.readBits(1);
				if (var5 == 0) {
					Client.npcIndices[++Client.npcCount - 1] = var3;
					var4.npcCycle = Client.cycle;
				} else {
					int var6 = var0.readBits(2);
					if (var6 == 0) {
						Client.npcIndices[++Client.npcCount - 1] = var3;
						var4.npcCycle = Client.cycle;
						Client.field550[++Client.field549 - 1] = var3;
					} else {
						int var7;
						int var8;
						if (var6 == 1) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method2510(var7, class193.field2246);
							var8 = var0.readBits(1);
							if (var8 == 1) {
								Client.field550[++Client.field549 - 1] = var3;
							}
						} else if (var6 == 2) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							if (var0.readBits(1) == 1) {
								var7 = var0.readBits(3);
								var4.method2510(var7, class193.field2247);
								var8 = var0.readBits(3);
								var4.method2510(var8, class193.field2247);
							} else {
								var7 = var0.readBits(3);
								var4.method2510(var7, class193.field2244);
							}

							var7 = var0.readBits(1);
							if (var7 == 1) {
								Client.field550[++Client.field549 - 1] = var3;
							}
						} else if (var6 == 3) {
							Client.field775[++Client.field625 - 1] = var3;
						}
					}
				}
			}

		}
	}
}
