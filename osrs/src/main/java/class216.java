import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public class class216 extends class219 {
	@ObfuscatedName("ua")
	@Export("cameraLookAtY")
	static int cameraLookAtY;
	@ObfuscatedName("at")
	int field1861;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	final class208 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lic;Ljava/lang/String;I)V"
	)
	class216(class208 var1, String var2, int var3) {
		super(var1, var2);
		this.this$0 = var1;
		this.field1861 = var3;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "561834394"
	)
	public int vmethod3379() {
		return 0;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "15"
	)
	@Export("vmethod3378")
	public int vmethod3378() {
		return this.field1861;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-106"
	)
	public static boolean method1096() {
		ReflectionCheck var0 = (ReflectionCheck)class36.reflectionChecks.last();
		return var0 != null;
	}

	@ObfuscatedName("mg")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1337719835"
	)
	static final int method1099() {
		float var0 = 200.0F * ((float)WorldMapIcon_1.clientPreferences.getBrightness() - 0.5F);
		return 100 - Math.round(var0);
	}
}