import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ms")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("ac")
	int field2865;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lmq;"
	)
	@Export("table")
	MusicPatch table;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lbs;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lmx;"
	)
	MusicPatchNode2 field2881;
	@ObfuscatedName("ao")
	int field2872;
	@ObfuscatedName("ah")
	int field2868;
	@ObfuscatedName("ar")
	int field2875;
	@ObfuscatedName("ab")
	int field2864;
	@ObfuscatedName("am")
	int field2870;
	@ObfuscatedName("av")
	int field2878;
	@ObfuscatedName("ag")
	int field2867;
	@ObfuscatedName("aa")
	int field2863;
	@ObfuscatedName("ap")
	int field2873;
	@ObfuscatedName("ay")
	int field2879;
	@ObfuscatedName("as")
	int field2876;
	@ObfuscatedName("aj")
	int field2869;
	@ObfuscatedName("an")
	int field2871;
	@ObfuscatedName("au")
	int field2877;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lbx;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("ae")
	int field2866;
	@ObfuscatedName("aq")
	int field2874;

	MusicPatchNode() {
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "60"
	)
	void method1727() {
		this.table = null;
		this.rawSound = null;
		this.field2881 = null;
		this.stream = null;
	}
}