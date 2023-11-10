import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.net.MalformedURLException;
import java.net.URL;

@ObfuscatedName("nd")
public class class338 {
	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "Luu;"
	)
	@Export("rasterProvider")
	public static AbstractRasterProvider rasterProvider;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lea;"
	)
	UrlRequest field2926;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Luz;"
	)
	SpritePixels field2927;

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lel;)V"
	)
	class338(String var1, UrlRequester var2) {
		try {
			this.field2926 = var2.request(new URL(var1));
		} catch (MalformedURLException var4) {
			this.field2926 = null;
		}

	}

	@ObfuscatedSignature(
		descriptor = "(Lea;)V"
	)
	class338(UrlRequest var1) {
		this.field2926 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Luz;",
		garbageValue = "1464542862"
	)
	SpritePixels method1742() {
		if (this.field2927 == null && this.field2926 != null && this.field2926.isDone()) {
			if (this.field2926.getResponse() != null) {
				this.field2927 = WorldMapArchiveLoader.method2391(this.field2926.getResponse());
			}

			this.field2926 = null;
		}

		return this.field2927;
	}
}