import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
public abstract class class219 {
	@ObfuscatedName("ao")
	String field1874;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lic;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class208 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lic;Ljava/lang/String;)V"
	)
	class219(class208 var1, String var2) {
		this.this$0 = var1;
		this.field1874 = var2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "561834394"
	)
	@Export("vmethod3379")
	public abstract int vmethod3379();

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "18"
	)
	@Export("vmethod3380")
	public String vmethod3380() {
		return null;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "15"
	)
	@Export("vmethod3378")
	public int vmethod3378() {
		return -1;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-273477420"
	)
	public String method1105() {
		return this.field1874;
	}

	@ObfuscatedName("at")
	public static final void method1104(long var0) {
		if (var0 > 0L) {
			if (0L == var0 % 10L) {
				long var2 = var0 - 1L;

				try {
					Thread.sleep(var2);
				} catch (InterruptedException var8) {
				}

				try {
					Thread.sleep(1L);
				} catch (InterruptedException var7) {
				}
			} else {
				try {
					Thread.sleep(var0);
				} catch (InterruptedException var6) {
				}
			}

		}
	}
}