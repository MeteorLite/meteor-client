import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;

@ObfuscatedName("ap")
public class class10 {
	@ObfuscatedName("wj")
	static Iterator field30;
	@ObfuscatedName("at")
	final HttpsURLConnection field36;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lqf;"
	)
	final class431 field37;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Laz;"
	)
	final class9 field35;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lsd;"
	)
	class473 field34;
	@ObfuscatedName("ab")
	boolean field31;
	@ObfuscatedName("au")
	boolean field32;
	@ObfuscatedName("aa")
	int field33;

	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URL;Laz;Lqf;Z)V"
	)
	public class10(URL var1, class9 var2, class431 var3, boolean var4) throws IOException {
		this.field31 = false;
		this.field32 = false;
		this.field33 = 300000;
		if (!var2.method23()) {
			throw new UnsupportedEncodingException("Unsupported request method used " + var2.method24());
		} else {
			this.field36 = (HttpsURLConnection)var1.openConnection();
			if (!var4) {
				HttpsURLConnection var5 = this.field36;
				if (class15.field49 == null) {
					class15.field49 = new class15();
				}

				class15 var6 = class15.field49;
				var5.setSSLSocketFactory(var6);
			}

			this.field35 = var2;
			this.field37 = var3 != null ? var3 : new class431();
		}
	}

	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URL;Laz;Z)V"
	)
	public class10(URL var1, class9 var2, boolean var3) throws IOException {
		this(var1, var2, new class431(), var3);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Lqf;",
		garbageValue = "77865186"
	)
	public class431 method34() {
		return this.field37;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lsd;I)V",
		garbageValue = "2039275921"
	)
	public void method35(class473 var1) {
		if (!this.field31) {
			if (var1 == null) {
				this.field37.method2183("Content-Type");
				this.field34 = null;
			} else {
				this.field34 = var1;
				if (this.field34.vmethod2213() != null) {
					this.field37.method2187(this.field34.vmethod2213());
				} else {
					this.field37.method2188();
				}

			}
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "6"
	)
	void method36() throws ProtocolException {
		if (!this.field31) {
			this.field36.setRequestMethod(this.field35.method24());
			this.field37.method2180(this.field36);
			if (this.field35.method25() && this.field34 != null) {
				this.field36.setDoOutput(true);
				ByteArrayOutputStream var1 = new ByteArrayOutputStream();

				try {
					var1.write(this.field34.vmethod7797());
					var1.writeTo(this.field36.getOutputStream());
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

			this.field36.setConnectTimeout(this.field33);
			this.field36.setInstanceFollowRedirects(this.field32);
			this.field31 = true;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1613730505"
	)
	boolean method37() throws IOException {
		if (!this.field31) {
			this.method36();
		}

		this.field36.connect();
		return this.field36.getResponseCode() == -1;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Law;",
		garbageValue = "1005545851"
	)
	class20 method38() {
		try {
			if (!this.field31 || this.field36.getResponseCode() == -1) {
				return new class20("No REST response has been received yet.");
			}
		} catch (IOException var10) {
			this.field36.disconnect();
			return new class20("Error decoding REST response code: " + var10.getMessage());
		}

		class20 var3;
		try {
			class20 var1 = new class20(this.field36);
			return var1;
		} catch (IOException var8) {
			var3 = new class20("Error decoding REST response: " + var8.getMessage());
		} finally {
			this.field36.disconnect();
		}

		return var3;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/io/File;",
		garbageValue = "1180339211"
	)
	@Export("getFile")
	static File getFile(String var0) {
		if (!FileSystem.FileSystem_hasPermissions) {
			throw new RuntimeException("");
		} else {
			File var1 = (File)FileSystem.FileSystem_cacheFiles.get(var0);
			if (var1 != null) {
				return var1;
			} else {
				File var2 = new File(FileSystem.FileSystem_cacheDir, var0);
				RandomAccessFile var3 = null;

				try {
					File var4 = new File(var2.getParent());
					if (!var4.exists()) {
						throw new RuntimeException("");
					} else {
						var3 = new RandomAccessFile(var2, "rw");
						int var5 = var3.read();
						var3.seek(0L);
						var3.write(var5);
						var3.seek(0L);
						var3.close();
						FileSystem.FileSystem_cacheFiles.put(var0, var2);
						return var2;
					}
				} catch (Exception var8) {
					try {
						if (var3 != null) {
							var3.close();
							var3 = null;
						}
					} catch (Exception var7) {
					}

					throw new RuntimeException();
				}
			}
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-841050646"
	)
	public static int method32(int var0, int var1) {
		return (var0 << 8) + var1;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Lol;Lol;Ljava/lang/String;Ljava/lang/String;B)Lpf;",
		garbageValue = "84"
	)
	public static Font method40(AbstractArchive var0, AbstractArchive var1, String var2, String var3) {
		if (!var0.isValidFileName(var2, var3)) {
			return null;
		} else {
			int var4 = var0.getGroupId(var2);
			int var5 = var0.getFileId(var4, var3);
			byte[] var8 = var0.takeFile(var4, var5);
			boolean var7;
			if (var8 == null) {
				var7 = false;
			} else {
				class162.SpriteBuffer_decode(var8);
				var7 = true;
			}

			Font var6;
			if (!var7) {
				var6 = null;
			} else {
				var6 = WorldMapArea.method1229(var1.takeFile(var4, var5));
			}

			return var6;
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(CS)Z",
		garbageValue = "128"
	)
	@Export("isCharAlphabetic")
	public static boolean isCharAlphabetic(char var0) {
		return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}

	@ObfuscatedName("lv")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "10"
	)
	@Export("resumePauseWidget")
	static void resumePauseWidget(int var0, int var1) {
		PacketBufferNode var2 = class113.getPacketBufferNode(ClientPacket.RESUME_PAUSEBUTTON, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeIntLE(var0);
		var2.packetBuffer.writeIntME(var1);
		Client.packetWriter.addNode(var2);
	}
}