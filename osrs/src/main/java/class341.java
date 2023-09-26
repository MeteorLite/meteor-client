import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.net.MalformedURLException;
import java.net.URL;

@ObfuscatedName("nd")
public class class341 {
	@ObfuscatedName("of")
	@Export("menuWidth")
	static int menuWidth;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Leq;"
	)
	UrlRequest field2928;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lud;"
	)
	SpritePixels field2929;

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Len;)V"
	)
	class341(String var1, UrlRequester var2) {
		try {
			this.field2928 = var2.request(new URL(var1));
		} catch (MalformedURLException var4) {
			this.field2928 = null;
		}

	}

	@ObfuscatedSignature(
		descriptor = "(Leq;)V"
	)
	class341(UrlRequest var1) {
		this.field2928 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)Lud;",
		garbageValue = "1517070019"
	)
	SpritePixels method1747() {
		if (this.field2929 == null && this.field2928 != null && this.field2928.isDone()) {
			if (this.field2928.getResponse() != null) {
				this.field2929 = Frames.method1335(this.field2928.getResponse());
			}

			this.field2928 = null;
		}

		return this.field2929;
	}
}