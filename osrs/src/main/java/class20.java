import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Map;

@ObfuscatedName("aw")
public class class20 {
	@ObfuscatedName("tk")
	@ObfuscatedSignature(
		descriptor = "Lqi;"
	)
	@Export("friendsChat")
	static FriendsChat friendsChat;
	@ObfuscatedName("at")
	final int field62;
	@ObfuscatedName("ah")
	final Map field64;
	@ObfuscatedName("ar")
	final String field63;

	class20(String var1) {
		this.field62 = 400;
		this.field64 = null;
		this.field63 = "";
	}

	class20(HttpURLConnection var1) throws IOException {
		this.field62 = var1.getResponseCode();
		var1.getResponseMessage();
		this.field64 = var1.getHeaderFields();
		StringBuilder var2 = new StringBuilder();
		InputStream var3 = this.field62 >= 300 ? var1.getErrorStream() : var1.getInputStream();
		if (var3 != null) {
			InputStreamReader var4 = new InputStreamReader(var3);
			BufferedReader var5 = new BufferedReader(var4);

			String var6;
			while ((var6 = var5.readLine()) != null) {
				var2.append(var6);
			}

			var3.close();
		}

		this.field63 = var2.toString();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "3"
	)
	public int method74() {
		return this.field62;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/Map;",
		garbageValue = "1360391754"
	)
	public Map method75() {
		return this.field64;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-541639855"
	)
	public String method76() {
		return this.field63;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "564353501"
	)
	public static String method77(String var0) {
		int var1 = var0.length();
		char[] var2 = new char[var1];
		byte var3 = 2;

		for (int var4 = 0; var4 < var1; ++var4) {
			char var5 = var0.charAt(var4);
			if (var3 == 0) {
				var5 = Character.toLowerCase(var5);
			} else if (var3 == 2 || Character.isUpperCase(var5)) {
				char var6;
				if (var5 != 181 && var5 != 402) {
					var6 = Character.toTitleCase(var5);
				} else {
					var6 = var5;
				}

				var5 = var6;
			}

			if (Character.isLetter(var5)) {
				var3 = 0;
			} else if (var5 != '.' && var5 != '?' && var5 != '!') {
				if (Character.isSpaceChar(var5)) {
					if (var3 != 2) {
						var3 = 1;
					}
				} else {
					var3 = 1;
				}
			} else {
				var3 = 2;
			}

			var2[var4] = var5;
		}

		return new String(var2);
	}
}