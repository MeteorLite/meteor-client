import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Comparator;

@ObfuscatedName("id")
public class class233 implements Comparator {
	@ObfuscatedName("ec")
	@ObfuscatedSignature(
		descriptor = "Ldp;"
	)
	@Export("mouseRecorder")
	static MouseRecorder mouseRecorder;

	class233() {
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lic;Lic;S)I",
		garbageValue = "-253"
	)
	int method1198(class228 var1, class228 var2) {
		return var1.method1168() - var2.method1168();
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.method1198((class228)var1, (class228)var2);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "([BI)Ljava/lang/String;",
		garbageValue = "-1425233568"
	)
	public static String method1199(byte[] var0) {
		int var2 = var0.length;
		StringBuilder var3 = new StringBuilder();

		for (int var4 = 0; var4 < var2 + 0; var4 += 3) {
			int var5 = var0[var4] & 255;
			var3.append(class400.field3683[var5 >>> 2]);
			if (var4 < var2 - 1) {
				int var6 = var0[var4 + 1] & 255;
				var3.append(class400.field3683[(var5 & 3) << 4 | var6 >>> 4]);
				if (var4 < var2 - 2) {
					int var7 = var0[var4 + 2] & 255;
					var3.append(class400.field3683[(var6 & 15) << 2 | var7 >>> 6]).append(class400.field3683[var7 & 63]);
				} else {
					var3.append(class400.field3683[(var6 & 15) << 2]).append("=");
				}
			} else {
				var3.append(class400.field3683[(var5 & 3) << 4]).append("==");
			}
		}

		String var1 = var3.toString();
		return var1;
	}
}