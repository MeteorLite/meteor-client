import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;
import java.security.Principal;
import java.security.cert.Certificate;

@ObfuscatedName("am")
class class17 implements SSLSession {
	@ObfuscatedName("ah")
	public static String field53;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lax;"
	)
	@Export("this$1")
	@ObfuscatedName("this$1")
	final class12 this$1;

	@ObfuscatedSignature(
		descriptor = "(Lax;)V"
	)
	class17(class12 var1) {
		this.this$1 = var1;
	}

	public int getApplicationBufferSize() {
		return 0;
	}

	public String getCipherSuite() {
		throw new UnsupportedOperationException();
	}

	public long getCreationTime() {
		throw new UnsupportedOperationException();
	}

	@Export("getId")
	@ObfuscatedName("getId")
	public byte[] getId() {
		throw new UnsupportedOperationException();
	}

	public long getLastAccessedTime() {
		throw new UnsupportedOperationException();
	}

	public Certificate[] getLocalCertificates() {
		throw new UnsupportedOperationException();
	}

	public Principal getLocalPrincipal() {
		throw new UnsupportedOperationException();
	}

	public int getPacketBufferSize() {
		throw new UnsupportedOperationException();
	}

	public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
		return null;
	}

	public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
		return this.this$1.field43;
	}

	public String getPeerHost() {
		throw new UnsupportedOperationException();
	}

	public int getPeerPort() {
		return 0;
	}

	@Export("getPeerPrincipal")
	@ObfuscatedName("getPeerPrincipal")
	public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
		return null;
	}

	public String getProtocol() {
		throw new UnsupportedOperationException();
	}

	public SSLSessionContext getSessionContext() {
		throw new UnsupportedOperationException();
	}

	@Export("getValue")
	@ObfuscatedName("getValue")
	public Object getValue(String var1) {
		throw new UnsupportedOperationException();
	}

	public String[] getValueNames() {
		throw new UnsupportedOperationException();
	}

	@Export("invalidate")
	@ObfuscatedName("invalidate")
	public void invalidate() {
		throw new UnsupportedOperationException();
	}

	@Export("isValid")
	@ObfuscatedName("isValid")
	public boolean isValid() {
		throw new UnsupportedOperationException();
	}

	@Export("putValue")
	@ObfuscatedName("putValue")
	public void putValue(String var1, Object var2) {
		throw new UnsupportedOperationException();
	}

	@Export("removeValue")
	@ObfuscatedName("removeValue")
	public void removeValue(String var1) {
		throw new UnsupportedOperationException();
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(BI)C",
		garbageValue = "-1889470685"
	)
	public static char method60(byte var0) {
		int var1 = var0 & 255;
		if (var1 == 0) {
			throw new IllegalArgumentException("" + Integer.toString(var1, 16));
		} else {
			if (var1 >= 128 && var1 < 160) {
				char var2 = class396.cp1252AsciiExtension[var1 - 128];
				if (var2 == 0) {
					var2 = '?';
				}

				var1 = var2;
			}

			return (char)var1;
		}
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZB)I",
		garbageValue = "-81"
	)
	static int method62(int var0, Script var1, boolean var2) {
		if (var0 == 6809) {
			int var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			ObjectComposition var4 = WorldMapSection2.getObjectDefinition(var3);
			Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var4 != null ? var4.name : "";
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1059264411"
	)
	static void method61() {
		Client.packetWriter.clearBuffer();
		Client.packetWriter.packetBuffer.offset = 0;
		Client.packetWriter.serverPacket = null;
		Client.packetWriter.field1167 = null;
		Client.packetWriter.field1168 = null;
		Client.packetWriter.field1166 = null;
		Client.packetWriter.serverPacketLength = 0;
		Client.packetWriter.field1164 = 0;
		Client.rebootTimer = 0;
		class160.method840();
		Client.minimapState = 0;
		Client.destinationX = 0;

		int var0;
		for (var0 = 0; var0 < 2048; ++var0) {
			Client.players[var0] = null;
		}

		class229.localPlayer = null;

		for (var0 = 0; var0 < Client.npcs.length; ++var0) {
			NPC var1 = Client.npcs[var0];
			if (var1 != null) {
				var1.targetIndex = -1;
				var1.false0 = false;
			}
		}

		class59.method332();
		WorldMapSection2.updateGameState(30);

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field407[var0] = true;
		}

		if (Client.packetWriter != null && Client.packetWriter.isaacCipher != null) {
			PacketBufferNode var2 = class113.getPacketBufferNode(ClientPacket.EVENT_MOUSE_IDLE, Client.packetWriter.isaacCipher);
			var2.packetBuffer.writeByte(ApproximateRouteStrategy.getWindowedMode());
			var2.packetBuffer.writeShort(Language.canvasWidth);
			var2.packetBuffer.writeShort(class47.canvasHeight);
			Client.packetWriter.addNode(var2);
		}

	}

	@ObfuscatedName("lo")
	@ObfuscatedSignature(
		descriptor = "(Lnn;IIIIIII)V",
		garbageValue = "-1558777613"
	)
	static final void method63(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Client.field382) {
			Client.alternativeScrollbarWidth = 32;
		} else {
			Client.alternativeScrollbarWidth = 0;
		}

		Client.field382 = false;
		int var7;
		if (MouseHandler.MouseHandler_currentButton == 1 || !class19.mouseCam && MouseHandler.MouseHandler_currentButton == 4) {
			if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
				var0.scrollY -= 4;
				class159.invalidateWidget(var0);
			} else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
				var0.scrollY += 4;
				class159.invalidateWidget(var0);
			} else if (var5 >= var1 - Client.alternativeScrollbarWidth && var5 < Client.alternativeScrollbarWidth + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
				var7 = var3 * (var3 - 32) / var4;
				if (var7 < 8) {
					var7 = 8;
				}

				int var8 = var6 - var2 - 16 - var7 / 2;
				int var9 = var3 - 32 - var7;
				var0.scrollY = var8 * (var4 - var3) / var9;
				class159.invalidateWidget(var0);
				Client.field382 = true;
			}
		}

		if (Client.mouseWheelRotation != 0) {
			var7 = var0.width;
			if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
				var0.scrollY += Client.mouseWheelRotation * 45;
				class159.invalidateWidget(var0);
			}
		}

	}
}