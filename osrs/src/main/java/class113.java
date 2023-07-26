import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class113 extends UrlRequester {
	@ObfuscatedName("ii")
	@ObfuscatedSignature(
		descriptor = "Lpc;"
	)
	@Export("fontPlain12")
	static Font fontPlain12;
	@ObfuscatedName("ms")
	@ObfuscatedSignature(
		descriptor = "Ljb;"
	)
	static TextureProvider textureProvider;
	@ObfuscatedName("as")
	final boolean field1160;

	public class113(boolean var1, int var2) {
		super(var2);
		this.field1160 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lei;I)V",
		garbageValue = "-1617729938"
	)
	@Export("vmethod2700")
	void vmethod2700(UrlRequest var1) throws IOException {
		URLConnection var2 = null;
		boolean var9 = false;

		label124: {
			HttpURLConnection var12;
			label125: {
				try {
					var9 = true;
					String var3 = var1.field1163.getProtocol();
					if (var3.equals("http")) {
						var2 = this.method654(var1);
					} else {
						if (!var3.equals("https")) {
							var1.field1165 = UrlRequest.field1161;
							var9 = false;
							break label124;
						}

						var2 = this.method655(var1);
					}

					this.method647(var2, var1);
					var9 = false;
					break label125;
				} catch (IOException var10) {
					var1.field1165 = UrlRequest.field1161;
					var9 = false;
				} finally {
					if (var9) {
						if (var2 != null && var2 instanceof HttpURLConnection) {
							HttpURLConnection var6 = (HttpURLConnection)var2;
							var6.disconnect();
						}

					}
				}

				if (var2 != null && var2 instanceof HttpURLConnection) {
					var12 = (HttpURLConnection)var2;
					var12.disconnect();
				}

				return;
			}

			if (var2 != null && var2 instanceof HttpURLConnection) {
				var12 = (HttpURLConnection)var2;
				var12.disconnect();
			}

			return;
		}

		if (var2 != null && var2 instanceof HttpURLConnection) {
			HttpURLConnection var4 = (HttpURLConnection)var2;
			var4.disconnect();
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Lei;I)Ljava/net/URLConnection;",
		garbageValue = "1537364324"
	)
	URLConnection method654(UrlRequest var1) throws IOException {
		URLConnection var2 = var1.field1163.openConnection();
		this.method646(var2);
		return var2;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(Lei;I)Ljava/net/URLConnection;",
		garbageValue = "-1919857679"
	)
	URLConnection method655(UrlRequest var1) throws IOException {
		HttpsURLConnection var2 = (HttpsURLConnection)var1.field1163.openConnection();
		if (!this.field1160) {
			if (class15.field46 == null) {
				class15.field46 = new class15();
			}

			class15 var4 = class15.field46;
			var2.setSSLSocketFactory(var4);
		}

		this.method646(var2);
		return var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)J",
		garbageValue = "1625750201"
	)
	@Export("clockNow")
	public static final synchronized long clockNow() {
		long var0 = System.currentTimeMillis();
		if (var0 < class302.field2735) {
			class302.field2736 += class302.field2735 - var0;
		}

		class302.field2735 = var0;
		return class302.field2736 + var0;
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZI)I",
		garbageValue = "35871473"
	)
	static int method656(int var0, Script var1, boolean var2) {
		if (var0 == 5306) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Huffman.getWindowedMode();
			return 1;
		} else {
			int var3;
			if (var0 == 5307) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					RouteStrategy.setWindowedMode(var3);
				}

				return 1;
			} else if (var0 == 5308) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class150.clientPreferences.method573();
				return 1;
			} else if (var0 != 5309) {
				if (var0 == 5310) {
					--Interpreter.Interpreter_intStackSize;
					return 1;
				} else {
					return 2;
				}
			} else {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var3 == 1 || var3 == 2) {
					class150.clientPreferences.method572(var3);
				}

				return 1;
			}
		}
	}
}
