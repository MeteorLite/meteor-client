import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.ThreadFactory;

@ObfuscatedName("mv")
class class319 implements ThreadFactory {
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lmn;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final MidiPcmStream this$0;

	@ObfuscatedSignature(
		descriptor = "(Lmn;)V"
	)
	class319(MidiPcmStream var1) {
		this.this$0 = var1;
	}

	@Export("newThread")
	@ObfuscatedName("newThread")
	public Thread newThread(Runnable var1) {
		return new Thread(var1, "OSRS WAV Load");
	}

	@ObfuscatedName("ia")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "29"
	)
	static final int method1705(int var0) {
		return Math.abs(var0 - class192.cameraYaw) > 1024 ? (var0 < class192.cameraYaw ? 1 : -1) * 2048 + var0 : var0;
	}
}