import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

import java.util.concurrent.ThreadFactory;

@ObfuscatedName("fb")
final class class136 implements ThreadFactory {
	@Export("newThread")
	@ObfuscatedName("newThread")
	public Thread newThread(Runnable var1) {
		return new Thread(var1, "OSRS Maya Anim Load");
	}
}