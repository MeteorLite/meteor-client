import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;

@ObfuscatedName("en")
@Implements("UrlRequester")
public abstract class UrlRequester implements Runnable {
	@ObfuscatedName("ah")
	static int field1162;
	@ObfuscatedName("co")
	@ObfuscatedSignature(
		descriptor = "Lnp;"
	)
	static StudioGame field1163;
	@ObfuscatedName("ac")
	final Thread field1166;
	@ObfuscatedName("al")
	@Export("isClosed")
	volatile boolean isClosed;
	@ObfuscatedName("ak")
	@Export("requests")
	Queue requests;
	@ObfuscatedName("ax")
	int field1164;

	UrlRequester(int var1) {
		this.requests = new LinkedList();
		this.field1166 = new Thread(this);
		this.field1166.setPriority(1);
		this.field1166.start();
		this.field1164 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Leq;I)V",
		garbageValue = "1796222901"
	)
	@Export("vmethod2700")
	abstract void vmethod2700(UrlRequest var1) throws IOException;

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URLConnection;B)I",
		garbageValue = "127"
	)
	int method648(URLConnection var1) {
		int var2 = UrlRequest.field1169;
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

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URLConnection;I)V",
		garbageValue = "204362010"
	)
	void method649(URLConnection var1) {
		var1.setConnectTimeout(5000);
		var1.setReadTimeout(5000);
		var1.setUseCaches(false);
		var1.setRequestProperty("Connection", "close");
		var1.setRequestProperty("User-Agent", "OldSchoolRuneScape/" + this.field1164);
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URLConnection;Leq;S)V",
		garbageValue = "32767"
	)
	void method650(URLConnection var1, UrlRequest var2) {
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
				byte[] var6 = class148.ByteArrayPool_getArray(5000);

				for (int var7 = var3.read(var6); var7 > -1; var7 = var3.read(var6)) {
					byte[] var8 = new byte[var4.length + var7];
					System.arraycopy(var4, 0, var8, 0, var4.length);
					System.arraycopy(var6, 0, var8, var4.length, var7);
					var4 = var8;
				}

				MenuAction.ByteArrayPool_release(var6);
			}

			var2.response0 = var4;
		} catch (IOException var14) {
			var2.response0 = null;
		} finally {
			var2.field1173 = this.method648(var1);
		}

		if (var3 != null) {
			try {
				var3.close();
			} catch (IOException var13) {
			}
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URL;I)Leq;",
		garbageValue = "511979680"
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

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1319494381"
	)
	@Export("close")
	public void close() {
		this.isClosed = true;

		try {
			synchronized(this) {
				this.notify();
			}

			this.field1166.join();
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
				class190.RunException_sendStackTrace((String)null, var7);
			}
		}

	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(Lnm;III)V",
		garbageValue = "1281314063"
	)
	public static void method653(Widget var0, int var1, int var2) {
		PlayerComposition var3 = var0.field3127;
		boolean var4 = var2 != var3.field2950;
		var3.field2950 = var2;
		if (var4) {
			int var5;
			int var6;
			if (var3.field2950 == var1) {
				for (var5 = 0; var5 < PlayerComposition.equipmentIndices.length; ++var5) {
					var6 = PlayerComposition.equipmentIndices[var5];
					if (var3.equipment[var6] > 0 && var3.equipment[var6] < 512) {
						var3.equipment[var6] = var3.field2944[var6];
					}
				}
			} else {
				if (var3.equipment[0] < 512 || class286.method1574(var3)) {
					var3.equipment[class223.field1865.field1879] = 1;
				}

				for (var5 = 0; var5 < 7; ++var5) {
					var6 = PlayerComposition.equipmentIndices[var5];
					if (var3.equipment[var6] > 0 && var3.equipment[var6] < 512) {
						int[] var7 = var3.equipment;

						for (int var8 = 0; var8 < class403.KitDefinition_fileCount; ++var8) {
							KitDefinition var9 = class73.KitDefinition_get(var8);
							if (var9 != null && !var9.nonSelectable && var9.bodypartID == (var2 == 1 ? 7 : 0) + var5) {
								var7[PlayerComposition.equipmentIndices[var5]] = var8 + 256;
								break;
							}
						}
					}
				}
			}
		}

		var3.method1760();
	}
}