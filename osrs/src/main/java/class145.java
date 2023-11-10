import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class145 extends class144 {
	@ObfuscatedName("ar")
	@Export("RunException_revision")
	public static int RunException_revision;
	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		descriptor = "Loh;"
	)
	static Archive field1338;
	@ObfuscatedName("at")
	int field1340;
	@ObfuscatedName("ah")
	boolean field1339;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfv;"
	)
	final class147 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfv;)V"
	)
	class145(class147 var1) {
		this.this$0 = var1;
		this.field1340 = -1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-734756620"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1340 = var1.readUnsignedShort();
		this.field1339 = var1.readUnsignedByte() == 1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lfc;I)V",
		garbageValue = "-2111347169"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method812(this.field1340, this.field1339);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-7051987"
	)
	public static void method764() {
		class172.field1439.clear();
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(FFFFLfm;B)V",
		garbageValue = "6"
	)
	static void method767(float var0, float var1, float var2, float var3, class131 var4) {
		float var5 = var1 - var0;
		float var6 = var2 - var1;
		float var7 = var3 - var2;
		float var8 = var6 - var5;
		var4.field1267 = var7 - var6 - var8;
		var4.field1265 = var8 + var8 + var8;
		var4.field1270 = var5 + var5 + var5;
		var4.field1263 = var0;
	}
}