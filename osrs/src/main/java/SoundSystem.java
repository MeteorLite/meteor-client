import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("SoundSystem")
public class SoundSystem implements Runnable {
	@ObfuscatedName("wh")
	@Export("foundItemIdCount")
	static int foundItemIdCount;
	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		descriptor = "Lng;"
	)
	static GameBuild field211;
	@ObfuscatedName("fb")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	@Export("archive2")
	static Archive archive2;
	@ObfuscatedName("up")
	@Export("cameraMoveToHeight")
	static int cameraMoveToHeight;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "[Lbu;"
	)
	@Export("players")
	public volatile PcmPlayer[] players;

	public SoundSystem() {
		this.players = new PcmPlayer[2];
	}

	@Export("run")
	@ObfuscatedName("run")
	public void run() {
		try {
			for (int var1 = 0; var1 < 2; ++var1) {
				PcmPlayer var2 = this.players[var1];
				if (var2 != null) {
					var2.run();
				}
			}
		} catch (Exception var4) {
			class190.RunException_sendStackTrace((String)null, var4);
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "13012"
	)
	public static void method226() {
		class201.field1580.clear();
	}
}