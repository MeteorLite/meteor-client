import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.bouncycastle.crypto.tls.DefaultTlsClient;
import org.bouncycastle.crypto.tls.TlsAuthentication;

@ObfuscatedName("t")
class class13 extends DefaultTlsClient {
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "Lfx;"
	)
	@Export("clock")
	static Clock clock;
	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		descriptor = "Lqu;"
	)
	@Export("worldSelectRightSprite")
	static IndexedSprite worldSelectRightSprite;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lh;"
	)
	final class12 this$1;

	@ObfuscatedSignature(
		descriptor = "(Lh;)V"
	)
	class13(class12 var1) {
		this.this$1 = var1;
	}

	public Hashtable getClientExtensions() throws IOException {
		Hashtable var1 = super.getClientExtensions();
		if (var1 == null) {
			var1 = new Hashtable();
		}

		byte[] var2 = this.this$1.val$host.getBytes();
		ByteArrayOutputStream var3 = new ByteArrayOutputStream();
		DataOutputStream var4 = new DataOutputStream(var3);
		var4.writeShort(var2.length + 3);
		var4.writeByte(0);
		var4.writeShort(var2.length);
		var4.write(var2);
		var4.close();
		var1.put(0, var3.toByteArray());
		return var1;
	}

	public TlsAuthentication getAuthentication() throws IOException {
		return new class11(this);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(JLjava/lang/String;I)I",
		garbageValue = "2014428702"
	)
	static final int method185(long var0, String var2) {
		Random var3 = new Random();
		Buffer var4 = new Buffer(128);
		Buffer var5 = new Buffer(128);
		int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
		var4.writeByte(10);

		int var7;
		for (var7 = 0; var7 < 4; ++var7) {
			var4.writeInt(var3.nextInt());
		}

		var4.writeInt(var6[0]);
		var4.writeInt(var6[1]);
		var4.writeLong(var0);
		var4.writeLong(0L);

		for (var7 = 0; var7 < 4; ++var7) {
			var4.writeInt(var3.nextInt());
		}

		var4.encryptRsa(class65.field870, class65.field862);
		var5.writeByte(10);

		for (var7 = 0; var7 < 3; ++var7) {
			var5.writeInt(var3.nextInt());
		}

		var5.writeLong(var3.nextLong());
		var5.writeLongMedium(var3.nextLong());
		if (Client.randomDatData != null) {
			var5.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
		} else {
			byte[] var8 = new byte[24];

			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.readFully(var8);

				int var9;
				for (var9 = 0; var9 < 24 && var8[var9] == 0; ++var9) {
				}

				if (var9 >= 24) {
					throw new IOException();
				}
			} catch (Exception var24) {
				for (int var10 = 0; var10 < 24; ++var10) {
					var8[var10] = -1;
				}
			}

			var5.writeBytes(var8, 0, var8.length);
		}

		var5.writeLong(var3.nextLong());
		var5.encryptRsa(class65.field870, class65.field862);
		var7 = class357.stringCp1252NullTerminatedByteSize(var2);
		if (var7 % 8 != 0) {
			var7 += 8 - var7 % 8;
		}

		Buffer var25 = new Buffer(var7);
		var25.writeStringCp1252NullTerminated(var2);
		var25.offset = var7;
		var25.xteaEncryptAll(var6);
		Buffer var18 = new Buffer(var4.offset + var5.offset + var25.offset + 5);
		var18.writeByte(2);
		var18.writeByte(var4.offset);
		var18.writeBytes(var4.array, 0, var4.offset);
		var18.writeByte(var5.offset);
		var18.writeBytes(var5.array, 0, var5.offset);
		var18.writeShort(var25.offset);
		var18.writeBytes(var25.array, 0, var25.offset);
		String var20 = ItemLayer.method4040(var18.array);

		try {
			URL var11 = new URL(SecureRandomCallable.method2205("services", false) + "m=accountappeal/login.ws");
			URLConnection var12 = var11.openConnection();
			var12.setDoInput(true);
			var12.setDoOutput(true);
			var12.setConnectTimeout(5000);
			OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
			var13.write("data2=" + class452.method8211(var20) + "&dest=" + class452.method8211("passwordchoice.ws"));
			var13.flush();
			InputStream var14 = var12.getInputStream();
			var18 = new Buffer(new byte[1000]);

			do {
				int var15 = var14.read(var18.array, var18.offset, 1000 - var18.offset);
				if (var15 == -1) {
					var13.close();
					var14.close();
					String var21 = new String(var18.array);
					if (var21.startsWith("OFFLINE")) {
						return 4;
					} else if (var21.startsWith("WRONG")) {
						return 7;
					} else if (var21.startsWith("RELOAD")) {
						return 3;
					} else if (var21.startsWith("Not permitted for social network accounts.")) {
						return 6;
					} else {
						var18.xteaDecryptAll(var6);

						while (var18.offset > 0 && var18.array[var18.offset - 1] == 0) {
							--var18.offset;
						}

						var21 = new String(var18.array, 0, var18.offset);
						boolean var16;
						if (var21 == null) {
							var16 = false;
						} else {
							label106: {
								try {
									new URL(var21);
								} catch (MalformedURLException var22) {
									var16 = false;
									break label106;
								}

								var16 = true;
							}
						}

						if (var16) {
							CollisionMap.openURL(var21, true, false);
							return 2;
						} else {
							return 5;
						}
					}
				}

				var18.offset += var15;
			} while(var18.offset < 1000);

			return 5;
		} catch (Throwable var23) {
			var23.printStackTrace();
			return 5;
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZI)I",
		garbageValue = "535008134"
	)
	static int method180(int var0, Script var1, boolean var2) {
		if (var0 == 6754) {
			int var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			NPCComposition var4 = class193.getNpcDefinition(var3);
			Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = var4 != null ? var4.name : "";
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(IB)Ljava/lang/Object;",
		garbageValue = "116"
	)
	static Object method184(int var0) {
		return class269.method5366((class434)Varps.findEnumerated(class434.method7781(), var0));
	}
}
