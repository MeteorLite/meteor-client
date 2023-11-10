import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
public class class222 extends Node {
	@ObfuscatedName("ar")
	public int field1883;
	@ObfuscatedName("ao")
	public int field1882;
	@ObfuscatedName("ab")
	public int field1881;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lnn;"
	)
	public Widget field1884;

	@ObfuscatedSignature(
		descriptor = "(IIILnn;)V"
	)
	public class222(int var1, int var2, int var3, Widget var4) {
		this.field1881 = var1;
		this.field1883 = var2;
		this.field1882 = var3;
		this.field1884 = var4;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "0"
	)
	static final void method1121(String var0) {
		WorldMapArea.method1213(var0 + " is already on your friend list");
	}
}