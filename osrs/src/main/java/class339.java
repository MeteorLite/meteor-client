import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nx")
public class class339 {
	@ObfuscatedName("ac")
	public int field2923;
	@ObfuscatedName("al")
	public int field2925;
	@ObfuscatedName("ak")
	public int field2924;

	class339() {
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-250555554"
	)
	static void method1746() {
		GameEngine.method166(24);
		AbstractWorldMapIcon.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
	}
}