import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ne")
public class class388 extends Link {
	@ObfuscatedName("vu")
	@ObfuscatedGetter(
		intValue = -693221637
	)
	@Export("foundItemIndex")
	static int foundItemIndex;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 645904559
	)
	public int field4477;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lrg;"
	)
	public Username field4475;
	@ObfuscatedName("c")
	public short field4476;

	@ObfuscatedSignature(
		descriptor = "(Lrg;I)V"
	)
	class388(Username var1, int var2) {
		this.field4477 = (int)(UserComparator8.method2748() / 1000L);
		this.field4475 = var1;
		this.field4476 = (short)var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lpe;ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "1666410399"
	)
	static String method7304(IterableNodeHashTable var0, int var1, String var2) {
		if (var0 == null) {
			return var2;
		} else {
			ObjectNode var3 = (ObjectNode)var0.get((long)var1);
			return var3 == null ? var2 : (String)var3.obj;
		}
	}
}
