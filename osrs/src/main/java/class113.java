import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;

@ObfuscatedName("es")
public class class113 extends UrlRequester {
	@ObfuscatedName("ch")
	static int field1178;
	@ObfuscatedName("ab")
	final boolean field1179;

	public class113(boolean var1, int var2) {
		super(var2);
		this.field1179 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lea;I)V",
		garbageValue = "422697771"
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
					String var3 = var1.field1184.getProtocol();
					if (var3.equals("http")) {
						var2 = this.method655(var1);
					} else {
						if (!var3.equals("https")) {
							var1.field1186 = UrlRequest.field1181;
							var9 = false;
							break label124;
						}

						var2 = this.method656(var1);
					}

					this.method647(var2, var1);
					var9 = false;
					break label125;
				} catch (IOException var10) {
					var1.field1186 = UrlRequest.field1181;
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

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Lea;I)Ljava/net/URLConnection;",
		garbageValue = "-1165040742"
	)
	URLConnection method655(UrlRequest var1) throws IOException {
		URLConnection var2 = var1.field1184.openConnection();
		this.method646(var2);
		return var2;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Lea;I)Ljava/net/URLConnection;",
		garbageValue = "1061431523"
	)
	URLConnection method656(UrlRequest var1) throws IOException {
		HttpsURLConnection var2 = (HttpsURLConnection)var1.field1184.openConnection();
		if (!this.field1179) {
			if (class15.field49 == null) {
				class15.field49 = new class15();
			}

			class15 var4 = class15.field49;
			var2.setSSLSocketFactory(var4);
		}

		this.method646(var2);
		return var2;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Llq;Luy;I)Lld;",
		garbageValue = "-133059507"
	)
	@Export("getPacketBufferNode")
	public static PacketBufferNode getPacketBufferNode(ClientPacket var0, IsaacCipher var1) {
		PacketBufferNode var2 = FaceNormal.method1516();
		var2.clientPacket = var0;
		var2.clientPacketLength = var0.length;
		if (var2.clientPacketLength == -1) {
			var2.packetBuffer = new PacketBuffer(260);
		} else if (var2.clientPacketLength == -2) {
			var2.packetBuffer = new PacketBuffer(10000);
		} else if (var2.clientPacketLength <= 18) {
			var2.packetBuffer = new PacketBuffer(20);
		} else if (var2.clientPacketLength <= 98) {
			var2.packetBuffer = new PacketBuffer(100);
		} else {
			var2.packetBuffer = new PacketBuffer(260);
		}

		var2.packetBuffer.setIsaacCipher(var1);
		var2.packetBuffer.writeByteIsaac(var2.clientPacket.id);
		var2.index = 0;
		return var2;
	}
}