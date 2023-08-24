import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ti")
public final class class504 {
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IZII)V",
		garbageValue = "-1433824975"
	)
	public static final void method2502(int var0, boolean var1, int var2) {
		if (var0 >= 8000 && var0 <= 48000) {
			PcmPlayer.field181 = var0;
			PcmPlayer.PcmPlayer_stereo = var1;
			PcmPlayer.field182 = var2;
		} else {
			throw new IllegalArgumentException();
		}
	}
}