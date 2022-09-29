import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pn")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	@Export("oldscape")
	public static final LoginType oldscape;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	static final LoginType field4643;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	static final LoginType field4644;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	static final LoginType field4645;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	static final LoginType field4652;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	static final LoginType field4647;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	static final LoginType field4646;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	static final LoginType field4649;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	public static final LoginType field4650;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "[Lqu;"
	)
	@Export("title_muteSprite")
	static IndexedSprite[] title_muteSprite;
	@ObfuscatedName("pp")
	@ObfuscatedSignature(
		descriptor = "Lcb;"
	)
	@Export("varcs")
	static Varcs varcs;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 472013381
	)
	public final int field4642;
	@ObfuscatedName("j")
	final String field4654;

	static {
		oldscape = new LoginType(5, 0, "", "");
		field4643 = new LoginType(2, 1, "", "");
		field4644 = new LoginType(3, 2, "", "");
		field4645 = new LoginType(4, 3, "", "");
		field4652 = new LoginType(8, 4, "", "");
		field4647 = new LoginType(7, 5, "", "");
		field4646 = new LoginType(6, 6, "", "");
		field4649 = new LoginType(1, 7, "", "");
		field4650 = new LoginType(0, -1, "", "", true, new LoginType[]{oldscape, field4643, field4644, field4652, field4645});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4642 = var1;
		this.field4654 = var4;
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/String;Ljava/lang/String;Z[Lpn;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4642 = var1;
		this.field4654 = var4;
	}

	public String toString() {
		return this.field4654;
	}
}
