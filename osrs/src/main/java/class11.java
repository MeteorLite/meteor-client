import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.bouncycastle.crypto.tls.Certificate;
import org.bouncycastle.crypto.tls.CertificateRequest;
import org.bouncycastle.crypto.tls.TlsAuthentication;
import org.bouncycastle.crypto.tls.TlsCredentials;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.LinkedList;

@ObfuscatedName("av")
class class11 implements TlsAuthentication {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lup;"
	)
	static IndexedSprite field38;
	@ObfuscatedName("kv")
	@ObfuscatedSignature(
		descriptor = "Luz;"
	)
	@Export("redHintArrowSprite")
	static SpritePixels redHintArrowSprite;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Las;"
	)
	@Export("this$2")
	@ObfuscatedName("this$2")
	final class13 this$2;

	@ObfuscatedSignature(
		descriptor = "(Las;)V"
	)
	class11(class13 var1) {
		this.this$2 = var1;
	}

	@Export("notifyServerCertificate")
	@ObfuscatedName("notifyServerCertificate")
	public void notifyServerCertificate(Certificate var1) throws IOException {
		try {
			CertificateFactory var2 = CertificateFactory.getInstance("X.509");
			LinkedList var3 = new LinkedList();
			org.bouncycastle.asn1.x509.Certificate[] var4 = var1.getCertificateList();

			for (int var5 = 0; var5 < var4.length; ++var5) {
				org.bouncycastle.asn1.x509.Certificate var6 = var4[var5];
				var3.add(var2.generateCertificate(new ByteArrayInputStream(var6.getEncoded())));
			}

			this.this$2.this$1.field43 = (java.security.cert.Certificate[])((java.security.cert.Certificate[])var3.toArray(new java.security.cert.Certificate[0]));
		} catch (CertificateException var7) {
			throw new IOException(var7);
		}
	}

	@Export("getClientCredentials")
	@ObfuscatedName("getClientCredentials")
	public TlsCredentials getClientCredentials(CertificateRequest var1) throws IOException {
		return null;
	}

	@ObfuscatedName("nv")
	@ObfuscatedSignature(
		descriptor = "(Lnn;B)Z",
		garbageValue = "18"
	)
	@Export("isComponentHidden")
	static boolean isComponentHidden(Widget var0) {
		return var0.isHidden;
	}
}