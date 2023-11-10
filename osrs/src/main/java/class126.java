import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class126 {
	@ObfuscatedName("at")
	int field1217;
	@ObfuscatedName("ah")
	float field1213;
	@ObfuscatedName("ar")
	float field1215;
	@ObfuscatedName("ao")
	float field1214;
	@ObfuscatedName("ab")
	float field1212;
	@ObfuscatedName("au")
	float field1216;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Leq;"
	)
	class126 field1211;

	class126() {
		this.field1215 = Float.MAX_VALUE;
		this.field1214 = Float.MAX_VALUE;
		this.field1212 = Float.MAX_VALUE;
		this.field1216 = Float.MAX_VALUE;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;IB)V",
		garbageValue = "116"
	)
	void method691(Buffer var1, int var2) {
		this.field1217 = var1.readShort();
		this.field1213 = var1.method2565();
		this.field1215 = var1.method2565();
		this.field1214 = var1.method2565();
		this.field1212 = var1.method2565();
		this.field1216 = var1.method2565();
	}
}