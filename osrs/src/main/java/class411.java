import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pe")
public class class411 {
	@ObfuscatedName("wf")
	static long field3712;
	@ObfuscatedName("ac")
	public char field3713;
	@ObfuscatedName("al")
	public int field3715;
	@ObfuscatedName("ak")
	public int field3714;

	class411() {
		this.field3715 = 0;
		this.field3714 = 0;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;Ljava/lang/String;B)V",
		garbageValue = "56"
	)
	@Export("addGameMessage")
	static void addGameMessage(int var0, String var1, String var2) {
		class164.addChatMessage(var0, var1, var2, (String)null);
	}
}