import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class161 {
	@ObfuscatedName("un")
	static List field1784;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "Llv;"
	)
	@Export("Widget_fontsArchive")
	public static AbstractArchive Widget_fontsArchive;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lcm;"
	)
	public UrlRequest field1786;
	@ObfuscatedName("p")
	public float[] field1781;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfc;"
	)
	final class156 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfc;)V"
	)
	class161(class156 var1) {
		this.this$0 = var1;
		this.field1781 = new float[4];
	}

	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "-15"
	)
	static void method3458(int var0, int var1) {
		if (Player.clientPreferences.method2402() != 0 && var0 != -1) {
			Message.method1164(class283.field3325, var0, 0, Player.clientPreferences.method2402(), false);
			Client.playingJingle = true;
		}

	}
}
