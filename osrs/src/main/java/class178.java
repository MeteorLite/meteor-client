import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class178 extends class181 {
	@ObfuscatedName("aw")
	int field1468;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgq;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class170 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgq;Ljava/lang/String;I)V"
	)
	class178(class170 var1, String var2, int var3) {
		super(var1, var2);
		this.this$0 = var1;
		this.field1468 = var3;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "-14721"
	)
	public int vmethod3379() {
		return 0;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-400866400"
	)
	@Export("vmethod3378")
	public int vmethod3378() {
		return this.field1468;
	}
}
