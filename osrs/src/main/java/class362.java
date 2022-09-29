import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mn")
class class362 implements Comparator {
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lmk;"
	)
	final class363 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lmk;)V"
	)
	class362(class363 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lns;Lns;B)I",
		garbageValue = "3"
	)
	int method6738(class364 var1, class364 var2) {
		if (var1.field4317 > var2.field4317) {
			return 1;
		} else {
			return var1.field4317 < var2.field4317 ? -1 : 0;
		}
	}

	public int compare(Object var1, Object var2) {
		return this.method6738((class364)var1, (class364)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}
