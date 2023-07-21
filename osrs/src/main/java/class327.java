import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mc")
public class class327 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lei;"
	)
	UrlRequest field2878;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lud;"
	)
	SpritePixels field2879;

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lej;)V"
	)
	class327(String var1, UrlRequester var2) {
		try {
			this.field2878 = var2.request(new URL(var1));
		} catch (MalformedURLException var4) {
			this.field2878 = null;
		}

	}

	@ObfuscatedSignature(
		descriptor = "(Lei;)V"
	)
	class327(UrlRequest var1) {
		this.field2878 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)Lud;",
		garbageValue = "915750590"
	)
	SpritePixels method1675() {
		if (this.field2879 == null && this.field2878 != null && this.field2878.isDone()) {
			if (this.field2878.getResponse() != null) {
				this.field2879 = ClanChannelMember.method769(this.field2878.getResponse());
			}

			this.field2878 = null;
		}

		return this.field2879;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(IIZI)Ljava/lang/String;",
		garbageValue = "175301623"
	)
	static String method1676(int var0, int var1, boolean var2) {
		if (var1 >= 2 && var1 <= 36) {
			if (var2 && var0 >= 0) {
				int var3 = 2;

				for (int var4 = var0 / var1; var4 != 0; ++var3) {
					var4 /= var1;
				}

				char[] var5 = new char[var3];
				var5[0] = '+';

				for (int var6 = var3 - 1; var6 > 0; --var6) {
					int var7 = var0;
					var0 /= var1;
					int var8 = var7 - var0 * var1;
					if (var8 >= 10) {
						var5[var6] = (char)(var8 + 87);
					} else {
						var5[var6] = (char)(var8 + 48);
					}
				}

				return new String(var5);
			} else {
				return Integer.toString(var0, var1);
			}
		} else {
			throw new IllegalArgumentException("" + var1);
		}
	}
}
