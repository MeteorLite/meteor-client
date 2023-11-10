import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@ObfuscatedName("aj")
public class class16 implements ThreadFactory {
	@ObfuscatedName("at")
	final ThreadGroup field51;
	@ObfuscatedName("ah")
	final AtomicInteger field52;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lay;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class14 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lay;)V"
	)
	class16(class14 var1) {
		this.this$0 = var1;
		this.field52 = new AtomicInteger(1);
		SecurityManager var2 = System.getSecurityManager();
		this.field51 = var2 != null ? var2.getThreadGroup() : Thread.currentThread().getThreadGroup();
	}

	@Export("newThread")
	@ObfuscatedName("newThread")
	public Thread newThread(Runnable var1) {
		Thread var2 = new Thread(this.field51, var1, this.this$0.field46 + "-rest-request-" + this.field52.getAndIncrement(), 0L);
		var2.setDaemon(true);
		var2.setPriority(5);
		return var2;
	}
}