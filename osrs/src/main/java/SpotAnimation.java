import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("vk")
@Implements("SpotAnimation")
public class SpotAnimation extends Node {
	@ObfuscatedName("ac")
	public int field4304;
	@ObfuscatedName("al")
	public int field4306;
	@ObfuscatedName("ak")
	public int field4305;
	@ObfuscatedName("ax")
	public int field4308;
	@ObfuscatedName("ao")
	public int field4307;

	public SpotAnimation(int var1, int var2, int var3, int var4) {
		this.field4304 = -1;
		this.field4306 = 0;
		this.field4305 = 0;
		this.field4308 = 0;
		this.field4307 = 0;
		this.field4304 = var1;
		this.field4307 = var2;
		this.field4308 = var3;
		this.field4306 = var4;
	}
}