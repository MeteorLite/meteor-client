import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sv")
public interface class475 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(S)Lsm;",
		garbageValue = "256"
	)
	@Export("get")
	PlatformInfo get();
}