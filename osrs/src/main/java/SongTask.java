import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ql")
@Implements("SongTask")
public abstract class SongTask {
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lql;"
	)
	SongTask field3758;
	@ObfuscatedName("ao")
	String field3757;
	@ObfuscatedName("ab")
	String field3756;
	@ObfuscatedName("au")
	boolean field3755;
	@ObfuscatedName("aa")
	boolean field3754;

	@ObfuscatedSignature(
		descriptor = "(Lql;)V"
	)
	SongTask(SongTask var1) {
		this.field3758 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-799935345"
	)
	@Export("vmethod2142")
	public abstract boolean vmethod2142();

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1285191143"
	)
	public boolean method2156() {
		return this.field3755;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "0"
	)
	public boolean method2157() {
		return this.field3754;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "1733616113"
	)
	public String method2158() {
		return "Error in task: " + this.field3756 + ", Error message: " + this.field3757;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Lql;",
		garbageValue = "1680402489"
	)
	public SongTask method2159() {
		return this.field3758;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "2"
	)
	void method2160(String var1) {
		this.field3755 = true;
		this.field3757 = var1;
	}
}