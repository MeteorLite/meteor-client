import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;

@ObfuscatedName("qw")
class class422 implements Comparator {
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	static AbstractArchive field3769;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lqv;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class423 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lqv;)V"
	)
	class422(class423 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lqj;Lqj;I)I",
		garbageValue = "-1576026190"
	)
	int method2178(class424 var1, class424 var2) {
		if (var1.field3779 > var2.field3779) {
			return 1;
		} else {
			return var1.field3779 < var2.field3779 ? -1 : 0;
		}
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.method2178((class424)var1, (class424)var2);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}