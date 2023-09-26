import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class9 implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lav;"
	)
	public static final class9 field14;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lav;"
	)
	public static final class9 field15;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lav;"
	)
	static final class9 field17;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lav;"
	)
	static final class9 field19;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lav;"
	)
	static final class9 field18;
	@ObfuscatedName("qo")
	@ObfuscatedSignature(
		descriptor = "[Lnm;"
	)
	static Widget[] field16;
	@ObfuscatedName("ah")
	int field22;
	@ObfuscatedName("ar")
	String field23;
	@ObfuscatedName("ab")
	boolean field20;
	@ObfuscatedName("am")
	boolean field21;

	static {
		field14 = new class9(0, "POST", true, true);
		field15 = new class9(1, "GET", true, false);
		field17 = new class9(2, "PUT", false, true);
		field19 = new class9(3, "PATCH", false, true);
		field18 = new class9(4, "DELETE", false, true);
	}

	class9(int var1, String var2, boolean var3, boolean var4) {
		this.field22 = var1;
		this.field23 = var2;
		this.field20 = var3;
		this.field21 = var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field22;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1688270936"
	)
	boolean method26() {
		return this.field20;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-1083861304"
	)
	public String method27() {
		return this.field23;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2015680525"
	)
	boolean method28() {
		return this.field21;
	}
}