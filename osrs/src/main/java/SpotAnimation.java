import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("vl")
@Implements("SpotAnimation")
public class SpotAnimation extends Node {
	@ObfuscatedName("at")
	public int field4313;
	@ObfuscatedName("ah")
	public int field4310;
	@ObfuscatedName("ar")
	public int field4312;
	@ObfuscatedName("ao")
	public int field4311;
	@ObfuscatedName("ab")
	public int field4309;

	public SpotAnimation(int var1, int var2, int var3, int var4) {
		this.field4313 = -1;
		this.field4310 = 0;
		this.field4312 = 0;
		this.field4311 = 0;
		this.field4309 = 0;
		this.field4313 = var1;
		this.field4309 = var2;
		this.field4311 = var3;
		this.field4310 = var4;
	}
}