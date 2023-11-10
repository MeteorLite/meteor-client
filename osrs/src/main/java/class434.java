import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;

@ObfuscatedName("qv")
class class434 implements Comparator {
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lqc;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class435 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lqc;)V"
	)
	class434(class435 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lqe;Lqe;I)I",
		garbageValue = "1841574446"
	)
	int method2194(class436 var1, class436 var2) {
		if (var1.field3814 > var2.field3814) {
			return 1;
		} else {
			return var1.field3814 < var2.field3814 ? -1 : 0;
		}
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.method2194((class436)var1, (class436)var2);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}