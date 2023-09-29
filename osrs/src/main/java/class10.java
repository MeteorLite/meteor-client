import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.net.ssl.HttpsURLConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.URL;

@ObfuscatedName("ag")
public class class10 {
	@ObfuscatedName("jz")
	@ObfuscatedSignature(
		descriptor = "Ljt;"
	)
	@Export("scene")
	static Scene scene;
	@ObfuscatedName("qq")
	static int field24;
	@ObfuscatedName("ac")
	final HttpsURLConnection field31;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lqv;"
	)
	final class434 field32;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lav;"
	)
	final class9 field30;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lsd;"
	)
	class476 field29;
	@ObfuscatedName("ao")
	boolean field27;
	@ObfuscatedName("ah")
	boolean field26;
	@ObfuscatedName("ar")
	int field28;

	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URL;Lav;Lqv;Z)V"
	)
	public class10(URL var1, class9 var2, class434 var3, boolean var4) throws IOException {
		this.field27 = false;
		this.field26 = false;
		this.field28 = 300000;
		if (!var2.method26()) {
			throw new UnsupportedEncodingException("Unsupported request method used " + var2.method27());
		} else {
			this.field31 = (HttpsURLConnection)var1.openConnection();
			if (!var4) {
				HttpsURLConnection var5 = this.field31;
				if (class15.field44 == null) {
					class15.field44 = new class15();
				}

				class15 var6 = class15.field44;
				var5.setSSLSocketFactory(var6);
			}

			this.field30 = var2;
			this.field32 = var3 != null ? var3 : new class434();
		}
	}

	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URL;Lav;Z)V"
	)
	public class10(URL var1, class9 var2, boolean var3) throws IOException {
		this(var1, var2, new class434(), var3);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)Lqv;",
		garbageValue = "1852518909"
	)
	public class434 method31() {
		return this.field32;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lsd;I)V",
		garbageValue = "-1455589333"
	)
	public void method32(class476 var1) {
		if (!this.field27) {
			if (var1 == null) {
				this.field32.method2199("Content-Type");
				this.field29 = null;
			} else {
				this.field29 = var1;
				if (this.field29.vmethod2213() != null) {
					this.field32.method2203(this.field29.vmethod2213());
				} else {
					this.field32.method2204();
				}

			}
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "937101739"
	)
	void method33() throws ProtocolException {
		if (!this.field27) {
			this.field31.setRequestMethod(this.field30.method27());
			this.field32.method2196(this.field31);
			if (this.field30.method28() && this.field29 != null) {
				this.field31.setDoOutput(true);
				ByteArrayOutputStream var1 = new ByteArrayOutputStream();

				try {
					var1.write(this.field29.vmethod7797());
					var1.writeTo(this.field31.getOutputStream());
				} catch (IOException var11) {
					var11.printStackTrace();
				} finally {
					try {
						var1.close();
					} catch (IOException var10) {
						var10.printStackTrace();
					}

				}
			}

			this.field31.setConnectTimeout(this.field28);
			this.field31.setInstanceFollowRedirects(this.field26);
			this.field27 = true;
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2097496739"
	)
	boolean method34() throws IOException {
		if (!this.field27) {
			this.method33();
		}

		this.field31.connect();
		return this.field31.getResponseCode() == -1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)Law;",
		garbageValue = "1182023619"
	)
	class20 method35() {
		try {
			if (!this.field27 || this.field31.getResponseCode() == -1) {
				return new class20("No REST response has been received yet.");
			}
		} catch (IOException var10) {
			this.field31.disconnect();
			return new class20("Error decoding REST response code: " + var10.getMessage());
		}

		class20 var3;
		try {
			class20 var1 = new class20(this.field31);
			return var1;
		} catch (IOException var8) {
			var3 = new class20("Error decoding REST response: " + var8.getMessage());
		} finally {
			this.field31.disconnect();
		}

		return var3;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IIIII)I",
		garbageValue = "-1751398414"
	)
	static final int method30(int var0, int var1, int var2, int var3) {
		return var0 * var2 + var3 * var1 >> 16;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "([FI)V",
		garbageValue = "-1762235426"
	)
	static void method36(float[] var0) {
		if (class128.field1202 + var0[0] < 1.3333334F) {
			float var1 = var0[0] - 2.0F;
			float var2 = var0[0] - 1.0F;
			float var3 = (float)Math.sqrt((double)(var1 * var1 - var2 * var2 * 4.0F));
			float var4 = (var3 + -var1) * 0.5F;
			if (var0[1] + class128.field1202 > var4) {
				var0[1] = var4 - class128.field1202;
			} else {
				var4 = (-var1 - var3) * 0.5F;
				if (var0[1] < class128.field1202 + var4) {
					var0[1] = var4 + class128.field1202;
				}
			}
		} else {
			var0[0] = 1.3333334F - class128.field1202;
			var0[1] = 0.33333334F - class128.field1202;
		}

	}
}