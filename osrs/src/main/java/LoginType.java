import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("te")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lte;"
	)
	@Export("oldscape")
	public static final LoginType oldscape;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lte;"
	)
	static final LoginType field4102;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lte;"
	)
	static final LoginType field4101;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lte;"
	)
	static final LoginType field4105;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lte;"
	)
	static final LoginType field4103;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lte;"
	)
	static final LoginType field4100;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lte;"
	)
	static final LoginType field4104;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lte;"
	)
	static final LoginType field4099;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lte;"
	)
	public static final LoginType field4098;
	@ObfuscatedName("av")
	final int field4106;
	@ObfuscatedName("ag")
	final String field4107;

	static {
		oldscape = new LoginType(4, 0, "", "");
		field4102 = new LoginType(6, 1, "", "");
		field4101 = new LoginType(3, 2, "", "");
		field4105 = new LoginType(5, 3, "", "");
		field4103 = new LoginType(7, 4, "", "");
		field4100 = new LoginType(8, 5, "", "");
		field4104 = new LoginType(2, 6, "", "");
		field4099 = new LoginType(0, 7, "", "");
		field4098 = new LoginType(1, -1, "", "", true, new LoginType[]{oldscape, field4102, field4101, field4103, field4105});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4106 = var1;
		this.field4107 = var4;
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/String;Ljava/lang/String;Z[Lte;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4106 = var1;
		this.field4107 = var4;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field4107;
	}
}