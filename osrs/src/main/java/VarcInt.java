import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.List;

@ObfuscatedName("hk")
@Implements("VarcInt")
public class VarcInt extends DualNode {
	@ObfuscatedName("wz")
	static List field1532;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("VarcInt_archive")
	public static AbstractArchive VarcInt_archive;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lle;"
	)
	@Export("VarcInt_cached")
	static EvictingDualNodeHashTable VarcInt_cached;
	@ObfuscatedName("dy")
	@ObfuscatedSignature(
		descriptor = "Luk;"
	)
	static IndexedSprite field1534;
	@ObfuscatedName("if")
	@ObfuscatedSignature(
		descriptor = "Lgz;"
	)
	@Export("socketTask")
	static Task socketTask;
	@ObfuscatedName("ao")
	@Export("persist")
	public boolean persist;

	static {
		VarcInt_cached = new EvictingDualNodeHashTable(64);
	}

	VarcInt() {
		this.persist = false;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "-2131192855"
	)
	void method954(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.method955(var1, var2);
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ltm;IB)V",
		garbageValue = "-12"
	)
	void method955(Buffer var1, int var2) {
		if (var2 == 2) {
			this.persist = true;
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Lch;",
		garbageValue = "-580226644"
	)
	@Export("getNextWorldListWorld")
	static World getNextWorldListWorld() {
		return World.World_listCount < World.World_count ? class176.World_worlds[++World.World_listCount - 1] : null;
	}
}