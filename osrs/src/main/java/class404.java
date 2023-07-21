import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pi")
public class class404 extends class407 {
	@ObfuscatedSignature(
		descriptor = "(Lpp;)V"
	)
	public class404(class407 var1) {
		super(var1);
		super.field3712 = "StartSongTask";
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "994462530"
	)
	public boolean vmethod2107(int var1) {
		Iterator var2 = class306.field2756.iterator();

		while (var2.hasNext()) {
			class318 var3 = (class318)var2.next();
			if (var3 != null && !var3.field2852 && var3.field2857 != null) {
				try {
					var3.field2857.method1591();
					var3.field2857.setPcmStreamVolume(0);
					if (var3.field2858 != null) {
						var3.field2857.setMusicTrack(var3.field2858, var3.field2850);
					}

					var3.field2858 = null;
					var3.field2848 = null;
					var3.field2859 = null;
					var3.field2852 = true;
				} catch (Exception var5) {
					var5.printStackTrace();
					this.method2102(var5.getMessage());
					return true;
				}
			}
		}

		super.field3711 = true;
		return true;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lnd;B)V",
		garbageValue = "108"
	)
	public static void method2093(AbstractArchive var0) {
		DbTableType.field4098 = var0;
	}
}
