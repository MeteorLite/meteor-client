import java.awt.FontMetrics;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class14 {
	@ObfuscatedName("bn")
	@Export("loginScreenFontMetrics")
	static FontMetrics loginScreenFontMetrics;
	@ObfuscatedName("so")
	@ObfuscatedSignature(
		descriptor = "Lut;"
	)
	@Export("privateChatMode")
	static PrivateChatMode privateChatMode;
	@ObfuscatedName("aw")
	final int field42;
	@ObfuscatedName("ay")
	final String field43;
	@ObfuscatedName("ar")
	final ThreadFactory field44;
	@ObfuscatedName("am")
	final ThreadPoolExecutor field45;

	public class14(String var1, int var2, int var3) {
		this.field43 = var1;
		this.field42 = var2;
		this.field44 = new class16(this);
		this.field45 = this.method48(var3);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/util/concurrent/ThreadPoolExecutor;",
		garbageValue = "-936222323"
	)
	final ThreadPoolExecutor method48(int var1) {
		return new ThreadPoolExecutor(var1, var1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(this.field42), this.field44);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Laq;I)Lad;",
		garbageValue = "1690553514"
	)
	public class18 method49(class10 var1) {
		if (this.field45.getQueue().remainingCapacity() <= 0) {
			System.err.println("REST thread pool queue is empty\r\nThread pool size " + this.field45.getCorePoolSize() + " Queue capacity " + this.field42);
			return new class18("Queue full");
		} else {
			class18 var2 = new class18(this.field45.submit(new class19(this, var1)));
			return var2;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1652727695"
	)
	public final void method50() {
		try {
			this.field45.shutdown();
		} catch (Exception var2) {
			System.err.println("Error shutting down RestRequestService\r\n" + var2);
		}

	}

	@ObfuscatedName("ay")
	public static double method47(double var0, double var2, double var4) {
		return class133.method726((var0 - var2) / var4) / var4;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-1748832285"
	)
	static String method51() {
		String var0;
		if (class150.clientPreferences.getIsUsernameHidden()) {
			String var2 = Login.Login_username;
			int var4 = var2.length();
			char[] var5 = new char[var4];

			for (int var6 = 0; var6 < var4; ++var6) {
				var5[var6] = '*';
			}

			String var3 = new String(var5);
			var0 = var3;
		} else {
			var0 = Login.Login_username;
		}

		return var0;
	}
}
