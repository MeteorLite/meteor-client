import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qm")
@Implements("SongTask")
public abstract class SongTask {
	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	@Export("archive12")
	static Archive archive12;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lqm;"
	)
	SongTask field3755;
	@ObfuscatedName("ax")
	String field3754;
	@ObfuscatedName("ao")
	String field3753;
	@ObfuscatedName("ah")
	boolean field3751;
	@ObfuscatedName("ar")
	boolean field3752;

	@ObfuscatedSignature(
		descriptor = "(Lqm;)V"
	)
	SongTask(SongTask var1) {
		this.field3755 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-90"
	)
	@Export("vmethod2142")
	public abstract boolean vmethod2142();

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1050307233"
	)
	public boolean method2165() {
		return this.field3751;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "45"
	)
	public boolean method2167() {
		return this.field3752;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-1522187493"
	)
	public String method2168() {
		return "Error in task: " + this.field3753 + ", Error message: " + this.field3754;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)Lqm;",
		garbageValue = "-1213560262"
	)
	public SongTask method2169() {
		return this.field3755;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "225620137"
	)
	void method2170(String var1) {
		this.field3751 = true;
		this.field3754 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1674491330"
	)
	@Export("isWorldMapEvent")
	public static boolean isWorldMapEvent(int var0) {
		return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
	}
}