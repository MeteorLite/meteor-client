import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("UrlRequester")
public abstract class UrlRequester implements Runnable {
	@ObfuscatedName("ss")
	@ObfuscatedGetter(
		intValue = 393762944
	)
	static int field1355;
	@ObfuscatedName("c")
	final Thread field1353;
	@ObfuscatedName("p")
	@Export("isClosed")
	volatile boolean isClosed;
	@ObfuscatedName("f")
	@Export("requests")
	Queue requests;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 842284203
	)
	int field1354;

	UrlRequester(int var1) {
		this.requests = new LinkedList();
		this.field1353 = new Thread(this);
		this.field1353.setPriority(1);
		this.field1353.start();
		this.field1354 = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lcm;B)V",
		garbageValue = "-112"
	)
	abstract void vmethod2697(UrlRequest var1) throws IOException;

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URLConnection;I)V",
		garbageValue = "1514770635"
	)
	void method2677(URLConnection var1) {
		var1.setConnectTimeout(5000);
		var1.setReadTimeout(5000);
		var1.setUseCaches(false);
		var1.setRequestProperty("Connection", "close");
		var1.setRequestProperty("User-Agent", "OldSchoolRuneScape/" + this.field1354);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URLConnection;Lcm;B)V",
		garbageValue = "54"
	)
	void method2678(URLConnection var1, UrlRequest var2) {
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
				byte[] var6 = TaskHandler.ByteArrayPool_getArray(5000);

				byte[] var8;
				for (int var7 = var3.read(var6, 0, var6.length); var7 > -1; var4 = var8) {
					var8 = new byte[var4.length + var7];
					System.arraycopy(var4, 0, var8, 0, var4.length);
					System.arraycopy(var6, 0, var8, var4.length, var7);
				}

				class221.ByteArrayPool_release(var6);
			}

			var2.response0 = var4;
		} catch (IOException var10) {
		}

		if (var3 != null) {
			try {
				var3.close();
			} catch (IOException var9) {
			}
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URL;I)Lcm;",
		garbageValue = "2072850161"
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "100485034"
	)
	@Export("close")
	public void close() {
		this.isClosed = true;

		try {
			synchronized(this) {
				this.notify();
			}

			this.field1353.join();
		} catch (InterruptedException var4) {
		}

	}

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

				this.vmethod2697(var1);
			} catch (Exception var7) {
				Clock.RunException_sendStackTrace((String)null, var7);
			}
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Ldi;[F[FB)V",
		garbageValue = "16"
	)
	static void method2679(class118 var0, float[] var1, float[] var2) {
		if (var0 != null) {
			float var3 = var1[3] - var1[0];
			if ((double)var3 != 0.0D) {
				float var4 = var1[1] - var1[0];
				float var5 = var1[2] - var1[0];
				Float var6 = var4 / var3;
				Float var7 = var5 / var3;
				var0.field1457 = var6 == 0.33333334F && var7 == 0.6666667F;
				float var8 = var6;
				float var9 = var7;
				if ((double)var6 < 0.0D) {
					var6 = 0.0F;
				}

				if ((double)var7 > 1.0D) {
					var7 = 1.0F;
				}

				float var15;
				float var16;
				float var18;
				if ((double)var6 > 1.0D || var7 < -1.0F) {
					Float var10 = var6;
					Float var11 = 1.0F - var7;
					if (var6 < 0.0F) {
						var10 = 0.0F;
					}

					if (var11 < 0.0F) {
						var11 = 0.0F;
					}

					if (var10 > 1.0F || var11 > 1.0F) {
						float var12 = (float)((double)(var10 * (var10 - 2.0F + var11)) + (double)var11 * ((double)var11 - 2.0D) + 1.0D);
						if (class115.field1423 + var12 > 0.0F) {
							Float var14;
							if (var10 + class115.field1423 < 1.3333334F) {
								var15 = var10 - 2.0F;
								var16 = var10 - 1.0F;
								float var17 = (float)Math.sqrt((double)(var15 * var15 - var16 * 4.0F * var16));
								var18 = 0.5F * (var17 + -var15);
								if (var11 + class115.field1423 > var18) {
									var14 = var18 - class115.field1423;
								} else {
									var18 = 0.5F * (-var15 - var17);
									if (var11 < var18 + class115.field1423) {
										var14 = var18 + class115.field1423;
									}
								}
							} else {
								Float var13 = 1.3333334F - class115.field1423;
								var14 = 0.33333334F - class115.field1423;
							}
						}
					}

					var11 = 1.0F - var11;
				}

				if (var6 != var8) {
					var1[1] = var1[0] + var6 * var3;
					if ((double)var8 != 0.0D) {
						var2[1] = var2[0] + (var2[1] - var2[0]) * var6 / var8;
					}
				}

				if (var7 != var9) {
					var1[2] = var1[0] + var7 * var3;
					if ((double)var9 != 1.0D) {
						var2[2] = (float)((double)var2[3] - (double)(var2[3] - var2[2]) * (1.0D - (double)var7) / (1.0D - (double)var9));
					}
				}

				var0.field1458 = var1[0];
				var0.field1459 = var1[3];
				float var22 = var6;
				float var23 = var7;
				float[] var24 = var0.field1460;
				float var25 = var22 - 0.0F;
				float var26 = var23 - var22;
				var15 = 1.0F - var23;
				var16 = var26 - var25;
				var24[3] = var15 - var26 - var16;
				var24[2] = var16 + var16 + var16;
				var24[1] = var25 + var25 + var25;
				var24[0] = 0.0F;
				var25 = var2[0];
				var26 = var2[1];
				var15 = var2[2];
				var16 = var2[3];
				float[] var27 = var0.field1462;
				var18 = var26 - var25;
				float var19 = var15 - var26;
				float var20 = var16 - var15;
				float var21 = var19 - var18;
				var27[3] = var20 - var19 - var21;
				var27[2] = var21 + var21 + var21;
				var27[1] = var18 + var18 + var18;
				var27[0] = var25;
			}
		}
	}
}
