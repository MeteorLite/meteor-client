import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mf")
public class class351 {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "Lpg;"
	)
	class423 field4282;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lpg;"
	)
	class423 field4281;

	public class351() {
		this.field4282 = new class423();
		this.field4282.field4626 = this.field4282;
		this.field4282.field4625 = this.field4282;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(Lpg;)V"
	)
	public void method6734(class423 var1) {
		if (var1.field4625 != null) {
			var1.method7815();
		}

		var1.field4625 = this.field4282.field4625;
		var1.field4626 = this.field4282;
		var1.field4625.field4626 = var1;
		var1.field4626.field4625 = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "()Lpg;"
	)
	public class423 method6736() {
		class423 var1 = this.field4282.field4626;
		if (var1 == this.field4282) {
			this.field4281 = null;
			return null;
		} else {
			this.field4281 = var1.field4626;
			return var1;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "()Lpg;"
	)
	public class423 method6733() {
		class423 var1 = this.field4281;
		if (var1 == this.field4282) {
			this.field4281 = null;
			return null;
		} else {
			this.field4281 = var1.field4626;
			return var1;
		}
	}
}
