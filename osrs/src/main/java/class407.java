import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pp")
public abstract class class407 {
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lud;"
	)
	@Export("leftTitleSprite")
	static SpritePixels leftTitleSprite;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lpp;"
	)
	class407 field3714;
	@ObfuscatedName("as")
	String field3713;
	@ObfuscatedName("aj")
	String field3712;
	@ObfuscatedName("ag")
	boolean field3710;
	@ObfuscatedName("az")
	boolean field3711;

	@ObfuscatedSignature(
		descriptor = "(Lpp;)V"
	)
	class407(class407 var1) {
		this.field3714 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "994462530"
	)
	public abstract boolean vmethod2107(int var1);

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "15"
	)
	public boolean method2098() {
		return this.field3710;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "751419690"
	)
	public boolean method2099() {
		return this.field3711;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "-29"
	)
	public String method2100() {
		return "Error in task: " + this.field3712 + ", Error message: " + this.field3713;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(S)Lpp;",
		garbageValue = "276"
	)
	public class407 method2101() {
		return this.field3714;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "934674418"
	)
	void method2102(String var1) {
		this.field3710 = true;
		this.field3713 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lnd;Lnd;Lnd;I)V",
		garbageValue = "-1865602506"
	)
	public static void method2103(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
		SequenceDefinition.SequenceDefinition_archive = var0;
		class333.SequenceDefinition_animationsArchive = var1;
		class169.SequenceDefinition_skeletonsArchive = var2;
	}
}
