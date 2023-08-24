import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.net.ssl.HttpsURLConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.URL;

@ObfuscatedName("ad")
public class class10 {
	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		descriptor = "Lnk;"
	)
	static Archive field28;
	@ObfuscatedName("au")
	final HttpsURLConnection field34;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lqf;"
	)
	final class419 field35;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Laf;"
	)
	final class9 field33;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lrf;"
	)
	class461 field32;
	@ObfuscatedName("ac")
	boolean field29;
	@ObfuscatedName("ai")
	boolean field30;
	@ObfuscatedName("az")
	int field31;

	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URL;Laf;Lqf;Z)V"
	)
	public class10(URL var1, class9 var2, class419 var3, boolean var4) throws IOException {
		this.field29 = false;
		this.field30 = false;
		this.field31 = 300000;
		if (!var2.method21()) {
			throw new UnsupportedEncodingException("Unsupported request method used " + var2.method22());
		} else {
			this.field34 = (HttpsURLConnection)var1.openConnection();
			if (!var4) {
				this.field34.setSSLSocketFactory(class15.method45());
			}

			this.field33 = var2;
			this.field35 = var3 != null ? var3 : new class419();
		}
	}

	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URL;Laf;Z)V"
	)
	public class10(URL var1, class9 var2, boolean var3) throws IOException {
		this(var1, var2, new class419(), var3);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)Lqf;",
		garbageValue = "106"
	)
	public class419 method27() {
		return this.field35;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lrf;B)V",
		garbageValue = "2"
	)
	public void method28(class461 var1) {
		if (!this.field29) {
			if (var1 == null) {
				this.field35.method2167("Content-Type");
				this.field32 = null;
			} else {
				this.field32 = var1;
				if (this.field32.vmethod2213() != null) {
					this.field35.method2171(this.field32.vmethod2213());
				} else {
					this.field35.method2172();
				}

			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2080187114"
	)
	void method29() throws ProtocolException {
		if (!this.field29) {
			this.field34.setRequestMethod(this.field33.method22());
			this.field35.method2164(this.field34);
			if (this.field33.method23() && this.field32 != null) {
				this.field34.setDoOutput(true);
				ByteArrayOutputStream var1 = new ByteArrayOutputStream();

				try {
					var1.write(this.field32.vmethod7797());
					var1.writeTo(this.field34.getOutputStream());
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

			this.field34.setConnectTimeout(this.field31);
			this.field34.setInstanceFollowRedirects(this.field30);
			this.field29 = true;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-170543381"
	)
	boolean method30() throws IOException {
		if (!this.field29) {
			this.method29();
		}

		this.field34.connect();
		return this.field34.getResponseCode() == -1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)Las;",
		garbageValue = "-1418069243"
	)
	class20 method31() {
		try {
			if (!this.field29 || this.field34.getResponseCode() == -1) {
				return new class20("No REST response has been received yet.");
			}
		} catch (IOException var10) {
			this.field34.disconnect();
			return new class20("Error decoding REST response code: " + var10.getMessage());
		}

		class20 var3;
		try {
			class20 var1 = new class20(this.field34);
			return var1;
		} catch (IOException var8) {
			var3 = new class20("Error decoding REST response: " + var8.getMessage());
		} finally {
			this.field34.disconnect();
		}

		return var3;
	}
}