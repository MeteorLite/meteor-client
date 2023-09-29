import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class171 extends class183 {
	@ObfuscatedName("tz")
	@ObfuscatedSignature(
		descriptor = "Lbu;"
	)
	@Export("pcmPlayer1")
	static PcmPlayer pcmPlayer1;
	@ObfuscatedName("ac")
	String field1428;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgr;"
	)
	final class172 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgr;Ljava/lang/String;Ljava/lang/String;)V"
	)
	class171(class172 var1, String var2, String var3) {
		super(var1, var2);
		this.this$0 = var1;
		this.field1428 = var3;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1007456210"
	)
	@Export("vmethod3379")
	public int vmethod3379() {
		return 1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "1667250407"
	)
	@Export("vmethod3380")
	public String vmethod3380() {
		return this.field1428;
	}
}