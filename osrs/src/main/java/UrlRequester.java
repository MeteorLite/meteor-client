import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("UrlRequester")
public abstract class UrlRequester implements Runnable {
	@ObfuscatedName("aw")
	final Thread field1156;
	@ObfuscatedName("ay")
	@Export("isClosed")
	volatile boolean isClosed;
	@ObfuscatedName("ar")
	@Export("requests")
	Queue requests;
	@ObfuscatedName("am")
	int field1154;

	UrlRequester(int var1) {
		this.requests = new LinkedList();
		this.field1156 = new Thread(this);
		this.field1156.setPriority(1);
		this.field1156.start();
		this.field1154 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lei;I)V",
		garbageValue = "-1617729938"
	)
	@Export("vmethod2700")
	abstract void vmethod2700(UrlRequest var1) throws IOException;

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URLConnection;I)I",
		garbageValue = "-258783956"
	)
	int method645(URLConnection var1) {
		int var2 = UrlRequest.field1161;
		if (var1 != null) {
			try {
				if (var1 instanceof HttpURLConnection) {
					var2 = ((HttpURLConnection)var1).getResponseCode();
				}
			} catch (IOException var4) {
			}
		}

		return var2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URLConnection;I)V",
		garbageValue = "396426494"
	)
	void method646(URLConnection var1) {
		var1.setConnectTimeout(5000);
		var1.setReadTimeout(5000);
		var1.setUseCaches(false);
		var1.setRequestProperty("Connection", "close");
		var1.setRequestProperty("User-Agent", "OldSchoolRuneScape/" + this.field1154);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URLConnection;Lei;I)V",
		garbageValue = "-1316938585"
	)
	void method647(URLConnection var1, UrlRequest var2) {
		DataInputStream var3 = null;

		try {
			int var5 = var1.getContentLength();
			var3 = new DataInputStream(var1.getInputStream());
			byte[] var4;
			if (var5 >= 0) {
				var4 = new byte[var5];
				var3.readFully(var4);
			} else {
				var4 = new byte[0];
				byte[] var6 = SpriteMask.ByteArrayPool_getArray(5000);

				byte[] var8;
				for (int var7 = var3.read(var6, 0, var6.length); var7 > -1; var4 = var8) {
					var8 = new byte[var4.length + var7];
					System.arraycopy(var4, 0, var8, 0, var4.length);
					System.arraycopy(var6, 0, var8, var4.length, var7);
				}

				GrandExchangeOfferUnitPriceComparator.ByteArrayPool_release(var6);
			}

			var2.response0 = var4;
		} catch (IOException var14) {
			var2.response0 = null;
		} finally {
			var2.field1165 = this.method645(var1);
		}

		if (var3 != null) {
			try {
				var3.close();
			} catch (IOException var13) {
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URL;I)Lei;",
		garbageValue = "1908448074"
	)
	@Export("request")
	public UrlRequest request(URL var1) {
		UrlRequest var2 = new UrlRequest(var1);
		synchronized(this) {
			this.requests.add(var2);
			this.notify();
			return var2;
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "29176"
	)
	@Export("close")
	public void close() {
		this.isClosed = true;

		try {
			synchronized(this) {
				this.notify();
			}

			this.field1156.join();
		} catch (InterruptedException var4) {
		}

	}

	@Export("run")
	@ObfuscatedName("run")
	public void run() {
		while (!this.isClosed) {
			try {
				UrlRequest var1;
				synchronized(this) {
					var1 = (UrlRequest)this.requests.poll();
					if (var1 == null) {
						try {
							this.wait();
						} catch (InterruptedException var5) {
						}
						continue;
					}
				}

				this.vmethod2700(var1);
			} catch (Exception var7) {
				class317.RunException_sendStackTrace((String)null, var7);
			}
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)[Lrr;",
		garbageValue = "55"
	)
	static class454[] method644() {
		return new class454[]{class454.field3877, class454.field3878, class454.field3879, class454.field3880};
	}

	@ObfuscatedName("mz")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "975652572"
	)
	static final void method650(int var0) {
		var0 = Math.max(Math.min(var0, 100), 0);
		var0 = 100 - var0;
		float var1 = 0.5F + (float)var0 / 200.0F;
		Rasterizer3D.method1164((double)var1);
		((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).setBrightness((double)var1);
		HealthBar.method581();
		class150.clientPreferences.setBrightness((double)var1);
	}
}
