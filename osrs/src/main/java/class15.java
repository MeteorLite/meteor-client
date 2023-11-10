import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.bouncycastle.crypto.tls.TlsClientProtocol;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.security.Security;

@ObfuscatedName("ak")
public class class15 extends SSLSocketFactory {
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lak;"
	)
	public static class15 field49;
	@ObfuscatedName("at")
	SecureRandom field50;

	static {
		if (Security.getProvider("BC") == null) {
			Security.addProvider(new BouncyCastleProvider());
		}

	}

	public class15() {
		this.field50 = new SecureRandom();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lorg/bouncycastle/crypto/tls/TlsClientProtocol;B)Ljavax/net/ssl/SSLSocket;",
		garbageValue = "-15"
	)
	SSLSocket method59(String var1, TlsClientProtocol var2) {
		return new class12(this, var2, var1);
	}

	@Export("createSocket")
	@ObfuscatedName("createSocket")
	public Socket createSocket(Socket var1, String var2, int var3, boolean var4) throws IOException {
		if (var1 == null) {
			var1 = new Socket();
		}

		if (!var1.isConnected()) {
			var1.connect(new InetSocketAddress(var2, var3));
		}

		TlsClientProtocol var5 = new TlsClientProtocol(var1.getInputStream(), var1.getOutputStream(), this.field50);
		return this.method59(var2, var5);
	}

	public String[] getDefaultCipherSuites() {
		return null;
	}

	public String[] getSupportedCipherSuites() {
		return null;
	}

	public Socket createSocket(String var1, int var2) throws IOException, UnknownHostException {
		return null;
	}

	public Socket createSocket(InetAddress var1, int var2) throws IOException {
		return null;
	}

	public Socket createSocket(String var1, int var2, InetAddress var3, int var4) throws IOException, UnknownHostException {
		return null;
	}

	public Socket createSocket(InetAddress var1, int var2, InetAddress var3, int var4) throws IOException {
		return null;
	}
}