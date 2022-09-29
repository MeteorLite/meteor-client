import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
public class class239 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lip;"
	)
	static final class239 field2866;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lip;"
	)
	static final class239 field2863;
	@ObfuscatedName("j")
	public static short[] field2865;
	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		descriptor = "Lqu;"
	)
	@Export("worldSelectLeftSprite")
	static IndexedSprite worldSelectLeftSprite;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1856667107
	)
	@Export("value")
	final int value;

	static {
		field2866 = new class239(0);
		field2863 = new class239(1);
	}

	class239(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIS)I",
		garbageValue = "-13783"
	)
	public static int method5121(int var0, int var1, int var2, int var3, int var4, int var5) {
		if ((var5 & 1) == 1) {
			int var6 = var3;
			var3 = var4;
			var4 = var6;
		}

		var2 &= 3;
		if (var2 == 0) {
			return var1;
		} else if (var2 == 1) {
			return 7 - var0 - (var3 - 1);
		} else {
			return var2 == 2 ? 7 - var1 - (var4 - 1) : var0;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(ILnj;Llb;B)V",
		garbageValue = "-13"
	)
	static void method5122(int var0, ArchiveDisk var1, Archive var2) {
		byte[] var3 = null;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			for (ArchiveDiskAction var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var5 != null; var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
				if ((long)var0 == var5.key && var1 == var5.archiveDisk && var5.type == 0) {
					var3 = var5.data;
					break;
				}
			}
		}

		if (var3 != null) {
			var2.load(var1, var0, var3, true);
		} else {
			byte[] var4 = var1.read(var0);
			var2.load(var1, var0, var4, true);
		}
	}
}
