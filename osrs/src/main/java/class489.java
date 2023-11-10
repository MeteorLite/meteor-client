import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sf")
public class class489 extends class491 {
	@ObfuscatedName("wn")
	static long field3990;
	@ObfuscatedName("at")
	int field3995;
	@ObfuscatedName("ah")
	int field3992;
	@ObfuscatedName("ar")
	int field3994;
	@ObfuscatedName("ao")
	int field3993;
	@ObfuscatedName("ab")
	int field3991;
	@ObfuscatedName("au")
	int field3996;

	public class489(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		super(var7, var8);
		this.field3995 = 0;
		this.field3992 = 0;
		this.field3994 = 0;
		this.field3993 = 0;
		this.field3991 = 0;
		this.field3996 = 0;
		this.field3995 = var1;
		this.field3992 = var2;
		this.field3994 = var3;
		this.field3993 = var4;
		this.field3991 = var5;
		this.field3996 = var6;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "2"
	)
	public int vmethod2386() {
		double var1 = this.method2390();
		return (int)Math.round((double)(this.field3993 - this.field3995) * var1 + (double)this.field3995);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "124"
	)
	public int vmethod2387() {
		double var1 = this.method2390();
		return (int)Math.round((double)this.field3992 + (double)(this.field3991 - this.field3992) * var1);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1254922863"
	)
	public int vmethod2320() {
		double var1 = this.method2390();
		return (int)Math.round((double)this.field3994 + (double)(this.field3996 - this.field3994) * var1);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(CI)Z",
		garbageValue = "-1028387364"
	)
	public static final boolean method2381(char var0) {
		return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
	}
}