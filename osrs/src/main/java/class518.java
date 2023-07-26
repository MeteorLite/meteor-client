import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tf")
public class class518 implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	public static final class518 field4159;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	public static final class518 field4160;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	static final class518 field4163;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	static final class518 field4162;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	static final class518 field4164;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	static final class518 field4161;
	@ObfuscatedName("ag")
	final int field4165;
	@ObfuscatedName("az")
	final int field4166;

	static {
		field4159 = new class518(4, 0);
		field4160 = new class518(0, 2);
		field4163 = new class518(2, 5);
		field4162 = new class518(5, 6);
		field4164 = new class518(3, 7);
		field4161 = new class518(1, 8);
	}

	class518(int var1, int var2) {
		this.field4165 = var1;
		this.field4166 = var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "748601950"
	)
	public boolean method2597() {
		return this == field4160;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4166;
	}
}
