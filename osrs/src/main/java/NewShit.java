import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
@Implements("NewShit")
public class NewShit {
	@ObfuscatedName("hr")
	static int[] field1577;
	@ObfuscatedName("au")
	public long field1582;
	@ObfuscatedName("ae")
	int[] field1578;
	@ObfuscatedName("ao")
	short[] field1579;
	@ObfuscatedName("at")
	short[] field1580;
	@ObfuscatedName("ac")
	public boolean field1581;

	public NewShit(long var1, int[] var3, short[] var4, short[] var5, boolean var6) {
		this.field1581 = false;
		this.field1582 = var1;
		this.field1578 = var3;
		this.field1579 = var4;
		this.field1580 = var5;
		this.field1581 = var6;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "29"
	)
	public static int method979(int var0) {
		return var0 >>> 4 & class508.field4121;
	}

	@ObfuscatedName("nc")
	@ObfuscatedSignature(
		descriptor = "(Lmi;I)I",
		garbageValue = "-282927864"
	)
	@Export("getWidgetFlags")
	static int getWidgetFlags(Widget var0) {
		IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.childIndex + ((long)var0.id << 32));
		return var1 != null ? var1.integer : var0.flags;
	}
}