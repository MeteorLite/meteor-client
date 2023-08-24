import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("un")
@Implements("SpotAnimation")
public class SpotAnimation extends Node {
	@ObfuscatedName("au")
	public int field4281;
	@ObfuscatedName("ae")
	public int field4278;
	@ObfuscatedName("ao")
	public int field4279;
	@ObfuscatedName("at")
	public int field4280;
	@ObfuscatedName("ac")
	public int field4277;

	public SpotAnimation(int var1, int var2, int var3, int var4) {
		this.field4281 = -1;
		this.field4278 = 0;
		this.field4279 = 0;
		this.field4280 = 0;
		this.field4277 = 0;
		this.field4281 = var1;
		this.field4277 = var2;
		this.field4280 = var3;
		this.field4278 = var4;
	}
}