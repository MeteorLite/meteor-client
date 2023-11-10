import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;
import java.util.Map.Entry;

@ObfuscatedName("qx")
class class432 implements Comparator {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	@Export("WorldMapElement_archive")
	public static AbstractArchive WorldMapElement_archive;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lqf;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class431 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lqf;)V"
	)
	class432(class431 var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/Map$Entry;Ljava/util/Map$Entry;I)I",
		garbageValue = "-2140651191"
	)
	int method2193(Entry var1, Entry var2) {
		return ((Float)var2.getValue()).compareTo((Float)var1.getValue());
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.method2193((Entry)var1, (Entry)var2);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}