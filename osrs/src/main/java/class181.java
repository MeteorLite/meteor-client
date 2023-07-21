import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public abstract class class181 {
	@ObfuscatedName("am")
	String field1481;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgq;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class170 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgq;Ljava/lang/String;)V"
	)
	class181(class170 var1, String var2) {
		this.this$0 = var1;
		this.field1481 = var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "-14721"
	)
	@Export("vmethod3379")
	public abstract int vmethod3379();

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-768896166"
	)
	@Export("vmethod3380")
	public String vmethod3380() {
		return null;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-400866400"
	)
	@Export("vmethod3378")
	public int vmethod3378() {
		return -1;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "1263481224"
	)
	public String method914() {
		return this.field1481;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II)Lfz;",
		garbageValue = "1920961056"
	)
	static class137 method917(int var0) {
		if (class273.method1504(var0) != 0) {
			return null;
		} else {
			class137 var2 = (class137)SequenceDefinition.SequenceDefinition_cachedModel.get((long)var0);
			class137 var1;
			if (var2 != null) {
				var1 = var2;
			} else {
				AbstractArchive var4 = class333.SequenceDefinition_animationsArchive;
				AbstractArchive var5 = class169.SequenceDefinition_skeletonsArchive;
				boolean var6 = true;
				byte[] var7 = var4.getFile(var0 >> 16 & 65535, var0 & 65535);
				class137 var3;
				if (var7 == null) {
					var6 = false;
					var3 = null;
				} else {
					int var8 = (var7[1] & 255) << 8 | var7[2] & 255;
					byte[] var9 = var5.getFile(var8, 0);
					if (var9 == null) {
						var6 = false;
					}

					if (!var6) {
						var3 = null;
					} else {
						if (SoundCache.field214 == null) {
							UserComparator4.field1166 = Runtime.getRuntime().availableProcessors();
							SoundCache.field214 = new ThreadPoolExecutor(0, UserComparator4.field1166, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(UserComparator4.field1166 * 100 + 100), new class203());
						}

						try {
							var3 = new class137(var4, var5, var0, false);
						} catch (Exception var11) {
							var3 = null;
						}
					}
				}

				if (var3 != null) {
					SequenceDefinition.SequenceDefinition_cachedModel.put(var3, (long)var0);
				}

				var1 = var3;
			}

			return var1;
		}
	}
}
