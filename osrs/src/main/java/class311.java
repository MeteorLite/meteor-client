import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.HashMap;
import java.util.TimeZone;


@ObfuscatedName("lt")
public final class class311 {
	@ObfuscatedName("ar")
	static final HashMap field2771;

	static {
		field2771 = new HashMap();
		TimeZone var0;
		synchronized(field2771) {
			TimeZone var2 = (TimeZone)field2771.get("Europe/London");
			if (var2 == null) {
				var2 = TimeZone.getTimeZone("Europe/London");
				field2771.put("Europe/London", var2);
			}

			var0 = var2;
		}

		java.util.Calendar.getInstance(var0);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)Lfw;",
		garbageValue = "-1631504286"
	)
	static class140 method1646(int var0) {
		class140 var1 = (class140)class12.findEnumerated(UserComparator8.method671(), var0);
		if (var1 == null) {
			var1 = class140.field1323;
		}

		return var1;
	}

	@ObfuscatedName("me")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-256877556"
	)
	static final void method1647(int var0) {
		var0 = Math.max(Math.min(var0, 100), 0);
		var0 = 100 - var0;
		float var1 = 0.5F + (float)var0 / 200.0F;
		Rasterizer3D.method1415((double)var1);
		((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).setBrightness((double)var1);
		class166.method866();
		WorldMapIcon_1.clientPreferences.setBrightness((double)var1);
	}
}