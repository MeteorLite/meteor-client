import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.ThreadFactory;

@ObfuscatedName("lh")
class class308 implements ThreadFactory {
	@ObfuscatedName("wc")
	@ObfuscatedSignature(
		descriptor = "Lnf;"
	)
	static JagNetThread field2819;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Llf;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final MidiPcmStream this$0;

	@ObfuscatedSignature(
		descriptor = "(Llf;)V"
	)
	class308(MidiPcmStream var1) {
		this.this$0 = var1;
	}

	@Export("newThread")
	@ObfuscatedName("newThread")
	public Thread newThread(Runnable var1) {
		return new Thread(var1, "OSRS WAV Load");
	}
}