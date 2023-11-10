import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
	@ObfuscatedName("gd")
	static String field862;
	@ObfuscatedName("ty")
	static boolean field861;
	@ObfuscatedName("at")
	@Export("group")
	int group;
	@ObfuscatedName("ah")
	@Export("type")
	int type;
	@ObfuscatedName("ar")
	boolean field863;

	InterfaceParent() {
		this.field863 = false;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lmf;I)V",
		garbageValue = "-919285791"
	)
	public static void method462(class322 var0) {
		class316.field2793.remove(var0);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1759271664"
	)
	public static int method463() {
		return ++MouseHandler.MouseHandler_idleCycles - 1;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "94"
	)
	public static void method464() {
		NPCComposition.NpcDefinition_cached.clear();
		NPCComposition.NpcDefinition_cachedModels.clear();
	}
}