import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;

@ObfuscatedName("ez")
public class class113 extends UrlRequester {
	@ObfuscatedName("am")
	static int field1172;
	@ObfuscatedName("as")
	@Export("canvasWidth")
	public static int canvasWidth;
	@ObfuscatedName("ac")
	final boolean field1173;

	public class113(boolean var1, int var2) {
		super(var2);
		this.field1173 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Let;B)V",
		garbageValue = "-114"
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
					String var3 = var1.field1177.getProtocol();
					if (var3.equals("http")) {
						var2 = this.method660(var1);
					} else {
						if (!var3.equals("https")) {
							var1.field1179 = UrlRequest.field1176;
							var9 = false;
							break label124;
						}

						var2 = this.method661(var1);
					}

					this.method649(var2, var1);
					var9 = false;
					break label125;
				} catch (IOException var10) {
					var1.field1179 = UrlRequest.field1176;
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

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Let;B)Ljava/net/URLConnection;",
		garbageValue = "46"
	)
	URLConnection method660(UrlRequest var1) throws IOException {
		URLConnection var2 = var1.field1177.openConnection();
		this.method648(var2);
		return var2;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Let;B)Ljava/net/URLConnection;",
		garbageValue = "-94"
	)
	URLConnection method661(UrlRequest var1) throws IOException {
		HttpsURLConnection var2 = (HttpsURLConnection)var1.field1177.openConnection();
		if (!this.field1173) {
			var2.setSSLSocketFactory(class15.method45());
		}

		this.method648(var2);
		return var2;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[Lhe;",
		garbageValue = "-242071193"
	)
	static HorizontalAlignment[] method658() {
		return new HorizontalAlignment[]{HorizontalAlignment.field1574, HorizontalAlignment.field1573, HorizontalAlignment.HorizontalAlignment_centered};
	}

	@ObfuscatedName("mn")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1761588634"
	)
	@Export("process")
	static void process() {
		for (InterfaceParent var0 = (InterfaceParent)Client.interfaceParents.first(); var0 != null; var0 = (InterfaceParent)Client.interfaceParents.next()) {
			int var1 = var0.group;
			if (ModeWhere.loadInterface(var1)) {
				boolean var2 = true;
				Widget[] var3 = PacketBufferNode.Widget_interfaceComponents[var1];

				int var4;
				for (var4 = 0; var4 < var3.length; ++var4) {
					if (var3[var4] != null) {
						var2 = var3[var4].isIf3;
						break;
					}
				}

				if (!var2) {
					var4 = (int)var0.key;
					Widget var5 = class92.getWidget(var4);
					if (var5 != null) {
						class218.invalidateWidget(var5);
					}
				}
			}
		}

	}

	@ObfuscatedName("nw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1946244652"
	)
	static final void method663() {
		Client.field518 = Client.cycleCntr;
	}
}