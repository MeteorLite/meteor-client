import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tb")
public class class502 implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Ltb;"
	)
	public static final class502 field4101;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Ltb;"
	)
	public static final class502 field4099;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ltb;"
	)
	public static final class502 field4100;
	@ObfuscatedName("ke")
	@ObfuscatedSignature(
		descriptor = "[Lui;"
	)
	@Export("headIconPrayerSprites")
	static SpritePixels[] headIconPrayerSprites;
	@ObfuscatedName("at")
	public final int field4104;
	@ObfuscatedName("ac")
	public final int field4103;
	@ObfuscatedName("ai")
	public final Class field4105;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Ltj;"
	)
	public final class498 field4106;

	static {
		field4101 = new class502(1, 0, Integer.class, new class499());
		field4099 = new class502(0, 1, Long.class, new class501());
		field4100 = new class502(2, 2, String.class, new class503());
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/Class;Ltj;)V"
	)
	class502(int var1, int var2, Class var3, class498 var4) {
		this.field4104 = var1;
		this.field4103 = var2;
		this.field4105 = var3;
		this.field4106 = var4;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4103;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ltm;S)Ljava/lang/Object;",
		garbageValue = "5018"
	)
	public Object method2497(Buffer var1) {
		return this.field4106.vmethod8273(var1);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)[Ltb;",
		garbageValue = "44"
	)
	public static class502[] method2494() {
		return new class502[]{field4101, field4100, field4099};
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Class;B)Ltb;",
		garbageValue = "82"
	)
	public static class502 method2495(Class var0) {
		class502[] var1 = method2494();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			class502 var3 = var1[var2];
			if (var3.field4105 == var0) {
				return var3;
			}
		}

		return null;
	}
}