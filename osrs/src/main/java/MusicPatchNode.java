import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mw")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("wy")
	@Export("foundItemIds")
	static short[] foundItemIds;
	@ObfuscatedName("at")
	int field2872;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lmq;"
	)
	@Export("table")
	MusicPatch table;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lbt;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lmk;"
	)
	MusicPatchNode2 field2878;
	@ObfuscatedName("ab")
	int field2862;
	@ObfuscatedName("au")
	int field2873;
	@ObfuscatedName("aa")
	int field2861;
	@ObfuscatedName("ac")
	int field2863;
	@ObfuscatedName("al")
	int field2868;
	@ObfuscatedName("az")
	int field2877;
	@ObfuscatedName("ap")
	int field2870;
	@ObfuscatedName("av")
	int field2874;
	@ObfuscatedName("ax")
	int field2875;
	@ObfuscatedName("as")
	int field2871;
	@ObfuscatedName("ay")
	int field2876;
	@ObfuscatedName("ak")
	int field2867;
	@ObfuscatedName("aj")
	int field2866;
	@ObfuscatedName("am")
	int field2869;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lbb;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("ai")
	int field2865;
	@ObfuscatedName("ae")
	int field2864;

	MusicPatchNode() {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "94"
	)
	void method1724() {
		this.table = null;
		this.rawSound = null;
		this.field2878 = null;
		this.stream = null;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "666285399"
	)
	public static int method1723(int var0) {
		return var0 != 0 && var0 != 1 ? -1 : 0;
	}
}