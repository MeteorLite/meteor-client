import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
@Implements("AbstractSound")
public abstract class AbstractSound extends Node {
	@ObfuscatedName("j")
	@Export("position")
	int position;

	AbstractSound() {
	}
}
