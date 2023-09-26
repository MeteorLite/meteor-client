import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
@Implements("Clock")
public abstract class Clock {
	@ObfuscatedName("kr")
	static int field1484;

	Clock() {
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "436321701"
	)
	@Export("mark")
	public abstract void mark();

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "712947185"
	)
	@Export("wait")
	public abstract int wait(int var1, int var2);

	@ObfuscatedName("jl")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1548584577"
	)
	static void method944() {
		for (class225 var0 = (class225)Client.field626.last(); var0 != null; var0 = (class225)Client.field626.previous()) {
			var0.remove();
		}

	}
}