import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class10 {
	@ObfuscatedName("jf")
	@ObfuscatedSignature(
		descriptor = "Lud;"
	)
	@Export("compass")
	static SpritePixels compass;
	@ObfuscatedName("aw")
	final HttpsURLConnection field32;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lqb;"
	)
	final class420 field33;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lap;"
	)
	final class9 field31;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lrq;"
	)
	class462 field30;
	@ObfuscatedName("as")
	boolean field28;
	@ObfuscatedName("aj")
	boolean field27;
	@ObfuscatedName("ag")
	int field29;

	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URL;Lap;Lqb;Z)V"
	)
	public class10(URL var1, class9 var2, class420 var3, boolean var4) throws IOException {
		this.field28 = false;
		this.field27 = false;
		this.field29 = 300000;
		if (!var2.method24()) {
			throw new UnsupportedEncodingException("Unsupported request method used " + var2.method25());
		} else {
			this.field32 = (HttpsURLConnection)var1.openConnection();
			if (!var4) {
				HttpsURLConnection var5 = this.field32;
				if (class15.field46 == null) {
					class15.field46 = new class15();
				}

				class15 var6 = class15.field46;
				var5.setSSLSocketFactory(var6);
			}

			this.field31 = var2;
			this.field33 = var3 != null ? var3 : new class420();
		}
	}

	@ObfuscatedSignature(
		descriptor = "(Ljava/net/URL;Lap;Z)V"
	)
	public class10(URL var1, class9 var2, boolean var3) throws IOException {
		this(var1, var2, new class420(), var3);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)Lqb;",
		garbageValue = "1781094058"
	)
	public class420 method31() {
		return this.field33;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lrq;I)V",
		garbageValue = "446743890"
	)
	public void method32(class462 var1) {
		if (!this.field28) {
			if (var1 == null) {
				this.field33.method2128("Content-Type");
				this.field30 = null;
			} else {
				this.field30 = var1;
				if (this.field30.vmethod2213() != null) {
					this.field33.method2132(this.field30.vmethod2213());
				} else {
					this.field33.method2133();
				}

			}
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "188935179"
	)
	void method33() throws ProtocolException {
		if (!this.field28) {
			this.field32.setRequestMethod(this.field31.method25());
			this.field33.method2125(this.field32);
			if (this.field31.method26() && this.field30 != null) {
				this.field32.setDoOutput(true);
				ByteArrayOutputStream var1 = new ByteArrayOutputStream();

				try {
					var1.write(this.field30.vmethod7797());
					var1.writeTo(this.field32.getOutputStream());
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

			this.field32.setConnectTimeout(this.field29);
			this.field32.setInstanceFollowRedirects(this.field27);
			this.field28 = true;
		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1249212417"
	)
	boolean method34() throws IOException {
		if (!this.field28) {
			this.method33();
		}

		this.field32.connect();
		return this.field32.getResponseCode() == -1;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)Lac;",
		garbageValue = "-1318308721"
	)
	class20 method35() {
		try {
			if (!this.field28 || this.field32.getResponseCode() == -1) {
				return new class20("No REST response has been received yet.");
			}
		} catch (IOException var10) {
			this.field32.disconnect();
			return new class20("Error decoding REST response code: " + var10.getMessage());
		}

		class20 var3;
		try {
			class20 var1 = new class20(this.field32);
			return var1;
		} catch (IOException var8) {
			var3 = new class20("Error decoding REST response: " + var8.getMessage());
		} finally {
			this.field32.disconnect();
		}

		return var3;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lty;[II)[Ljava/lang/Object;",
		garbageValue = "-1294646917"
	)
	static Object[] method30(Buffer var0, int[] var1) {
		int var2 = var0.readUShortSmart();
		Object[] var3 = new Object[var1.length * var2];

		for (int var4 = 0; var4 < var2; ++var4) {
			for (int var5 = 0; var5 < var1.length; ++var5) {
				int var6 = var1.length * var4 + var5;
				class503 var7 = class395.method1994(var1[var5]);
				var3[var6] = var7.method2474(var0);
			}
		}

		return var3;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZI)I",
		garbageValue = "-1321398026"
	)
	static int method36(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? class36.scriptDotWidget : class351.scriptActiveWidget;
		if (var0 == 1500) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == 1501) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == 1502) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == 1503) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == 1504) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == 1505) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("mp")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIII)V",
		garbageValue = "-1708450572"
	)
	@Export("updateRootInterface")
	static final void updateRootInterface(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Login.loadInterface(var0)) {
			ClanChannelMember.updateInterface(ArchiveLoader.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
		}
	}

	@ObfuscatedName("oq")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-517461757"
	)
	static void method38(boolean var0) {
		Client.leftClickOpensMenu = var0;
	}
}
