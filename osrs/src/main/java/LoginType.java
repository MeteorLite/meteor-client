import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tt")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ltt;"
	)
	@Export("oldscape")
	public static final LoginType oldscape;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ltt;"
	)
	static final LoginType field4097;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ltt;"
	)
	static final LoginType field4099;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ltt;"
	)
	static final LoginType field4098;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Ltt;"
	)
	static final LoginType field4095;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Ltt;"
	)
	static final LoginType field4100;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Ltt;"
	)
	static final LoginType field4094;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Ltt;"
	)
	static final LoginType field4096;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Ltt;"
	)
	public static final LoginType field4092;
	@ObfuscatedName("az")
	public final int field4102;
	@ObfuscatedName("ap")
	final String field4101;

	static {
		oldscape = new LoginType(0, 0, "", "");
		field4097 = new LoginType(8, 1, "", "");
		field4099 = new LoginType(7, 2, "", "");
		field4098 = new LoginType(5, 3, "", "");
		field4095 = new LoginType(4, 4, "", "");
		field4100 = new LoginType(1, 5, "", "");
		field4094 = new LoginType(6, 6, "", "");
		field4096 = new LoginType(3, 7, "", "");
		field4092 = new LoginType(2, -1, "", "", true, new LoginType[]{oldscape, field4097, field4099, field4095, field4098});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4102 = var1;
		this.field4101 = var4;
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/String;Ljava/lang/String;Z[Ltt;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4102 = var1;
		this.field4101 = var4;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field4101;
	}
}