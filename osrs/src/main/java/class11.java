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

@ObfuscatedName("aa")
class class11 implements TlsAuthentication {
	@ObfuscatedName("iq")
	@ObfuscatedSignature(
		descriptor = "Lre;"
	)
	static AbstractSocket field33;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lay;"
	)
	@Export("this$2")
	@ObfuscatedName("this$2")
	final class13 this$2;

	@ObfuscatedSignature(
		descriptor = "(Lay;)V"
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

			this.this$2.this$1.field34 = (java.security.cert.Certificate[])((java.security.cert.Certificate[])var3.toArray(new java.security.cert.Certificate[0]));
		} catch (CertificateException var7) {
			throw new IOException(var7);
		}
	}

	@Export("getClientCredentials")
	@ObfuscatedName("getClientCredentials")
	public TlsCredentials getClientCredentials(CertificateRequest var1) throws IOException {
		return null;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(CLoa;I)I",
		garbageValue = "832566677"
	)
	@Export("lowercaseChar")
	static int lowercaseChar(char var0, Language var1) {
		int var2 = var0 << 4;
		if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
			var0 = Character.toLowerCase(var0);
			var2 = (var0 << 4) + 1;
		}

		if (var0 == 241 && var1 == Language.Language_ES) {
			var2 = 1762;
		}

		return var2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "610139414"
	)
	static void method39() {
		Players.Players_count = 0;

		for (int var0 = 0; var0 < 2048; ++var0) {
			Players.cachedAppearanceBuffer[var0] = null;
			Players.playerMovementSpeeds[var0] = MoveSpeed.WALK;
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Ljn;IIIII)Z",
		garbageValue = "-916093529"
	)
	static final boolean method38(Model var0, int var1, int var2, int var3, int var4) {
		if (!GrandExchangeOfferTotalQuantityComparator.method1974()) {
			return false;
		} else {
			TextureProvider.method1350();
			AABB var5 = (AABB)var0.aabb.get(var1);
			int var6 = var2 + var5.xMid;
			int var7 = var3 + var5.yMid;
			int var8 = var4 + var5.zMid;
			int var9 = var5.xMidOffset;
			int var10 = var5.yMidOffset;
			int var11 = var5.zMidOffset;
			int var12 = ViewportMouse.field2264 - var6;
			int var13 = ViewportMouse.field2260 - var7;
			int var14 = class286.field2470 - var8;
			if (Math.abs(var12) > var9 + class190.field1495) {
				return false;
			} else if (Math.abs(var13) > var10 + GraphicsObject.field718) {
				return false;
			} else if (Math.abs(var14) > var11 + HealthBar.field1073) {
				return false;
			} else if (Math.abs(var14 * ViewportMouse.field2263 - var13 * ViewportMouse.field2265) > var11 * GraphicsObject.field718 + var10 * HealthBar.field1073) {
				return false;
			} else if (Math.abs(var12 * ViewportMouse.field2265 - var14 * class180.field1467) > var11 * class190.field1495 + var9 * HealthBar.field1073) {
				return false;
			} else {
				return Math.abs(var13 * class180.field1467 - var12 * ViewportMouse.field2263) <= var9 * GraphicsObject.field718 + var10 * class190.field1495;
			}
		}
	}
}