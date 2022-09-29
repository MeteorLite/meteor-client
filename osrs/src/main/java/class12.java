import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.bouncycastle.crypto.tls.TlsClientProtocol;

@ObfuscatedName("h")
class class12 extends SSLSocket {
	@ObfuscatedName("c")
	Certificate[] field62;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Ld;"
	)
	final class15 this$0;
	// $FF: synthetic field
	final TlsClientProtocol val$tlsClientProtocol;
	// $FF: synthetic field
	final String val$host;

	@ObfuscatedSignature(
		descriptor = "(Ld;Lorg/bouncycastle/crypto/tls/TlsClientProtocol;Ljava/lang/String;)V"
	)
	class12(class15 var1, TlsClientProtocol var2, String var3) {
		this.this$0 = var1;
		this.val$tlsClientProtocol = var2;
		this.val$host = var3;
	}

	public void setEnabledCipherSuites(String[] var1) {
	}

	public InputStream getInputStream() throws IOException {
		return this.val$tlsClientProtocol.getInputStream();
	}

	public OutputStream getOutputStream() throws IOException {
		return this.val$tlsClientProtocol.getOutputStream();
	}

	public synchronized void close() throws IOException {
		this.val$tlsClientProtocol.close();
	}

	public void addHandshakeCompletedListener(HandshakeCompletedListener var1) {
	}

	public boolean getEnableSessionCreation() {
		return false;
	}

	public String[] getEnabledCipherSuites() {
		return null;
	}

	public String[] getEnabledProtocols() {
		return null;
	}

	public boolean getNeedClientAuth() {
		return false;
	}

	public SSLSession getSession() {
		return new class17(this);
	}

	public boolean getWantClientAuth() {
		return false;
	}

	public void setUseClientMode(boolean var1) {
	}

	public void setEnabledProtocols(String[] var1) {
	}

	public void setNeedClientAuth(boolean var1) {
	}

	public void setWantClientAuth(boolean var1) {
	}

	public void startHandshake() throws IOException {
		this.val$tlsClientProtocol.connect(new class13(this));
	}

	public void setEnableSessionCreation(boolean var1) {
	}

	public String[] getSupportedProtocols() {
		return null;
	}

	public String[] getSupportedCipherSuites() {
		return null;
	}

	public void removeHandshakeCompletedListener(HandshakeCompletedListener var1) {
	}

	public boolean getUseClientMode() {
		return false;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Llv;I)V",
		garbageValue = "1963307877"
	)
	public static void method178(AbstractArchive var0) {
		FloorOverlayDefinition.FloorOverlayDefinition_archive = var0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2145461636"
	)
	static void method176() {
		class152.Tiles_underlays = null;
		class294.Tiles_overlays = null;
		Tiles.Tiles_shapes = null;
		Tiles.field1001 = null;
		ChatChannel.field996 = null;
		SoundCache.field328 = null;
		Tiles.field1002 = null;
		TextureProvider.Tiles_hue = null;
		FontName.Tiles_saturation = null;
		class436.Tiles_lightness = null;
		class434.Tiles_hueMultiplier = null;
		Tiles.field1008 = null;
	}

	@ObfuscatedName("fd")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1208132518"
	)
	@Export("getLoginError")
	static void getLoginError(int var0) {
		int var1 = WorldMapIcon_0.method5034();
		if (var0 == -3) {
			SecureRandomCallable.setLoginResponseString("Connection timed out.", "Please try using a different world.", "");
		} else if (var0 == -2) {
			SecureRandomCallable.setLoginResponseString("Error connecting to server.", "Please try using a different world.", "");
		} else if (var0 == -1) {
			SecureRandomCallable.setLoginResponseString("No response from server.", "Please try using a different world.", "");
		} else if (var0 == 3) {
			class139.method3101(3);
			Login.field903 = 1;
		} else if (var0 == 4) {
			class139.method3101(14);
			Login.field902 = 0;
		} else if (var0 == 5) {
			Login.field903 = 2;
			SecureRandomCallable.setLoginResponseString("Either your account is still logged in, or the last", "world you were using has become unavailable.", "Please try again later.");
		} else if (var0 != 68 && (Client.onMobile || var0 != 6)) {
			if (var0 == 7) {
				SecureRandomCallable.setLoginResponseString("This world is full.", "Please use a different world.", "");
			} else if (var0 == 8) {
				SecureRandomCallable.setLoginResponseString("Unable to connect.", "Login server offline.", "");
			} else if (var0 == 9) {
				SecureRandomCallable.setLoginResponseString("Login limit exceeded.", "Too many connections from your address.", "");
			} else if (var0 == 10) {
				SecureRandomCallable.setLoginResponseString("Unable to connect.", "Bad session id.", "");
			} else if (var0 == 11) {
				SecureRandomCallable.setLoginResponseString("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
			} else if (var0 == 12) {
				SecureRandomCallable.setLoginResponseString("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
			} else if (var0 == 13) {
				SecureRandomCallable.setLoginResponseString("Could not complete login.", "Please try using a different world.", "");
			} else if (var0 == 14) {
				SecureRandomCallable.setLoginResponseString("The server is being updated.", "Please wait 1 minute and try again.", "");
			} else if (var0 == 16) {
				SecureRandomCallable.setLoginResponseString("Too many login attempts.", "Please wait a few minutes before trying again.", "");
			} else if (var0 == 17) {
				SecureRandomCallable.setLoginResponseString("To access this free world, log into a", "members world and move your character", "to a non-members area.");
			} else if (var0 == 18) {
				class139.method3101(14);
				Login.field902 = 1;
			} else if (var0 == 19) {
				SecureRandomCallable.setLoginResponseString("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
			} else if (var0 == 20) {
				SecureRandomCallable.setLoginResponseString("Invalid loginserver requested.", "Please try using a different world.", "");
			} else if (var0 == 22) {
				SecureRandomCallable.setLoginResponseString("Malformed login packet.", "Please try again.", "");
			} else if (var0 == 23) {
				SecureRandomCallable.setLoginResponseString("No reply from loginserver.", "Please wait 1 minute and try again.", "");
			} else if (var0 == 24) {
				SecureRandomCallable.setLoginResponseString("Error loading your profile.", "Please contact customer support.", "");
			} else if (var0 == 25) {
				SecureRandomCallable.setLoginResponseString("Unexpected loginserver response.", "Please try using a different world.", "");
			} else if (var0 == 26) {
				SecureRandomCallable.setLoginResponseString("This computers address has been blocked", "as it was used to break our rules.", "");
			} else if (var0 == 27) {
				SecureRandomCallable.setLoginResponseString("", "Service unavailable.", "");
			} else if (var0 == 31) {
				SecureRandomCallable.setLoginResponseString("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
			} else if (var0 == 32) {
				class139.method3101(14);
				Login.field902 = 2;
			} else if (var0 == 37) {
				SecureRandomCallable.setLoginResponseString("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
			} else if (var0 == 38) {
				SecureRandomCallable.setLoginResponseString("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
			} else if (var0 == 55) {
				class139.method3101(8);
			} else {
				if (var0 == 56) {
					SecureRandomCallable.setLoginResponseString("Enter the 6-digit code generated by your", "authenticator app.", "");
					Coord.updateGameState(11);
					return;
				}

				if (var0 == 57) {
					SecureRandomCallable.setLoginResponseString("The code you entered was incorrect.", "Please try again.", "");
					Coord.updateGameState(11);
					return;
				}

				if (var0 == 61) {
					SecureRandomCallable.setLoginResponseString("", "Please enter your date of birth (DD/MM/YYYY)", "");
					class139.method3101(7);
				} else {
					if (var0 == 62) {
						Coord.updateGameState(10);
						class139.method3101(9);
						SecureRandomCallable.setLoginResponseString("Login attempt timed out.", "Please try again.", "");
						return;
					}

					if (var0 == 63) {
						Coord.updateGameState(10);
						class139.method3101(9);
						SecureRandomCallable.setLoginResponseString("You were signed out.", "Please sign in again.", "");
						return;
					}

					if (var0 == 65 || var0 == 67) {
						Coord.updateGameState(10);
						class139.method3101(9);
						SecureRandomCallable.setLoginResponseString("Failed to login.", "Please try again.", "");
						return;
					}

					if (var0 == 71) {
						Coord.updateGameState(10);
						class139.method3101(7);
						SecureRandomCallable.setLoginResponseString("There was a problem updating your DOB.", "Please try again later. If the problem ", "persists, please contact Jagex Support.");
					} else if (var0 == 73) {
						Coord.updateGameState(10);
						class139.method3101(6);
						SecureRandomCallable.setLoginResponseString("Your date of birth information is waiting", "to be reviewed by our staff.", "It will be processed shortly.");
					} else if (var0 == 72) {
						Coord.updateGameState(10);
						class139.method3101(26);
					} else {
						SecureRandomCallable.setLoginResponseString("Unexpected server response", "Please try using a different world.", "");
					}
				}
			}
		} else {
			SecureRandomCallable.setLoginResponseString("RuneScape has been updated!", "Please reload this page.", "");
		}

		Coord.updateGameState(10);
		boolean var2 = var1 != WorldMapIcon_0.method5034();
		if (!var2 && Client.field639.method8184()) {
			class139.method3101(9);
		}

	}

	@ObfuscatedName("mc")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "243834325"
	)
	static void method164(boolean var0) {
		Client.leftClickOpensMenu = var0;
	}
}
