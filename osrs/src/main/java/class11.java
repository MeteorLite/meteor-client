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

@ObfuscatedName("aq")
class class11 implements TlsAuthentication {
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lan;"
	)
	@Export("this$2")
	@ObfuscatedName("this$2")
	final class13 this$2;

	@ObfuscatedSignature(
		descriptor = "(Lan;)V"
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

			this.this$2.this$1.field39 = (java.security.cert.Certificate[])((java.security.cert.Certificate[])var3.toArray(new java.security.cert.Certificate[0]));
		} catch (CertificateException var7) {
			throw new IOException(var7);
		}
	}

	@Export("getClientCredentials")
	@ObfuscatedName("getClientCredentials")
	public TlsCredentials getClientCredentials(CertificateRequest var1) throws IOException {
		return null;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "([BIII)Ljava/lang/String;",
		garbageValue = "591994113"
	)
	public static String method32(byte[] var0, int var1, int var2) {
		StringBuilder var3 = new StringBuilder();

		for (int var4 = var1; var4 < var2 + var1; var4 += 3) {
			int var5 = var0[var4] & 255;
			var3.append(class385.field3649[var5 >>> 2]);
			if (var4 < var2 - 1) {
				int var6 = var0[var4 + 1] & 255;
				var3.append(class385.field3649[(var5 & 3) << 4 | var6 >>> 4]);
				if (var4 < var2 - 2) {
					int var7 = var0[var4 + 2] & 255;
					var3.append(class385.field3649[(var6 & 15) << 2 | var7 >>> 6]).append(class385.field3649[var7 & 63]);
				} else {
					var3.append(class385.field3649[(var6 & 15) << 2]).append("=");
				}
			} else {
				var3.append(class385.field3649[(var5 & 3) << 4]).append("==");
			}
		}

		return var3.toString();
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "18671"
	)
	static final void method33() {
		if (!ViewportMouse.ViewportMouse_false0) {
			int var0 = Scene.Scene_cameraPitchSine;
			int var1 = Scene.Scene_cameraPitchCosine;
			int var2 = Scene.Scene_cameraYawSine;
			int var3 = Scene.Scene_cameraYawCosine;
			byte var4 = 50;
			short var5 = 3500;
			int var6 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.getClipMidX()) * var4 / Rasterizer3D.get3dZoom();
			int var7 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.getClipMidY()) * var4 / Rasterizer3D.get3dZoom();
			int var8 = (ViewportMouse.ViewportMouse_x - Rasterizer3D.getClipMidX()) * var5 / Rasterizer3D.get3dZoom();
			int var9 = (ViewportMouse.ViewportMouse_y - Rasterizer3D.getClipMidY()) * var5 / Rasterizer3D.get3dZoom();
			int var10 = class33.method129(var7, var4, var1, var0);
			int var11 = var4 * var1 - var0 * var7 >> 16;
			var7 = var10;
			var10 = class33.method129(var9, var5, var1, var0);
			int var12 = var5 * var1 - var0 * var9 >> 16;
			var9 = var10;
			var10 = Tiles.method456(var6, var11, var3, var2);
			int var13 = ClanChannelMember.method775(var6, var11, var3, var2);
			var6 = var10;
			var10 = Tiles.method456(var8, var12, var3, var2);
			int var14 = ClanChannelMember.method775(var8, var12, var3, var2);
			ViewportMouse.field2249 = (var10 + var6) / 2;
			ViewportMouse.field2252 = (var7 + var9) / 2;
			ViewportMouse.field2254 = (var13 + var14) / 2;
			class261.field2396 = (var10 - var6) / 2;
			ViewportMouse.field2248 = (var9 - var7) / 2;
			Frames.field2121 = (var14 - var13) / 2;
			ViewportMouse.field2250 = Math.abs(class261.field2396);
			class7.field9 = Math.abs(ViewportMouse.field2248);
			class30.field82 = Math.abs(Frames.field2121);
		}
	}

	@ObfuscatedName("ni")
	@ObfuscatedSignature(
		descriptor = "(Lmi;IIII)V",
		garbageValue = "1018529135"
	)
	@Export("drawCompass")
	static final void drawCompass(Widget var0, int var1, int var2, int var3) {
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			if (Client.minimapState < 3) {
				Client.compass.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, 25, 25, Client.camAngleY, 256, var4.xStarts, var4.xWidths);
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

		}
	}
}