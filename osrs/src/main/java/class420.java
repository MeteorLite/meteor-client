import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;
import java.util.Map.Entry;

@ObfuscatedName("qr")
class class420 implements Comparator {
	@ObfuscatedName("ao")
	@Export("SpriteBuffer_spriteHeight")
	static int SpriteBuffer_spriteHeight;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lqf;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class419 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lqf;)V"
	)
	class420(class419 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/Map$Entry;Ljava/util/Map$Entry;I)I",
		garbageValue = "1962289219"
	)
	int method2177(Entry var1, Entry var2) {
		return ((Float)var2.getValue()).compareTo((Float)var1.getValue());
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.method2177((Entry)var1, (Entry)var2);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}