import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
public class class215 {
	@ObfuscatedName("iv")
	static int[] field1854;
	@ObfuscatedName("ao")
	public String field1859;
	@ObfuscatedName("ab")
	public float[] field1855;
	@ObfuscatedName("au")
	public int field1858;
	@ObfuscatedName("aa")
	public int field1856;
	@ObfuscatedName("ac")
	public int field1857;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class208 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lic;)V"
	)
	class215(class208 var1) {
		this.this$0 = var1;
		this.field1855 = new float[4];
		this.field1858 = 1;
		this.field1856 = 1;
		this.field1857 = 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/String;[SB)V",
		garbageValue = "0"
	)
	public static void method1095(String[] var0, short[] var1) {
		class132.sortItemsByName(var0, var1, 0, var0.length - 1);
	}
}