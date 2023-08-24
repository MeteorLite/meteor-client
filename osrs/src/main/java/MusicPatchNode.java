import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mg")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("au")
	int field2854;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lll;"
	)
	@Export("table")
	MusicPatch table;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lbu;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Llj;"
	)
	MusicPatchNode2 field2857;
	@ObfuscatedName("ac")
	int field2842;
	@ObfuscatedName("ai")
	int field2847;
	@ObfuscatedName("az")
	int field2856;
	@ObfuscatedName("ap")
	int field2851;
	@ObfuscatedName("aa")
	int field2840;
	@ObfuscatedName("af")
	int field2844;
	@ObfuscatedName("ad")
	int field2843;
	@ObfuscatedName("aq")
	int field2852;
	@ObfuscatedName("al")
	int field2848;
	@ObfuscatedName("an")
	int field2850;
	@ObfuscatedName("ar")
	int field2853;
	@ObfuscatedName("ab")
	int field2841;
	@ObfuscatedName("ag")
	int field2845;
	@ObfuscatedName("am")
	int field2849;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lbn;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("ah")
	int field2846;
	@ObfuscatedName("ay")
	int field2855;

	MusicPatchNode() {
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-26"
	)
	void method1696() {
		this.table = null;
		this.rawSound = null;
		this.field2857 = null;
		this.stream = null;
	}
}