import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pg")
public class class423 {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "Lpg;"
	)
	public class423 field4626;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "Lpg;"
	)
	public class423 field4625;

	@ObfuscatedName("a")
	public void method7815() {
		if (this.field4625 != null) {
			this.field4625.field4626 = this.field4626;
			this.field4626.field4625 = this.field4625;
			this.field4626 = null;
			this.field4625 = null;
		}
	}
}
