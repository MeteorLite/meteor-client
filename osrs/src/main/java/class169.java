import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class169 extends class181 {
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	@Export("SequenceDefinition_skeletonsArchive")
	static AbstractArchive SequenceDefinition_skeletonsArchive;
	@ObfuscatedName("aw")
	String field1430;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgq;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class170 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgq;Ljava/lang/String;Ljava/lang/String;)V"
	)
	class169(class170 var1, String var2, String var3) {
		super(var1, var2);
		this.this$0 = var1;
		this.field1430 = var3;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "-14721"
	)
	@Export("vmethod3379")
	public int vmethod3379() {
		return 1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-768896166"
	)
	@Export("vmethod3380")
	public String vmethod3380() {
		return this.field1430;
	}
}
