import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mu")
public final class class357 {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "Llg;"
	)
	@Export("InvDefinition_archive")
	static AbstractArchive InvDefinition_archive;
	@ObfuscatedName("w")
	@Export("ByteArrayPool_arrays")
	public static byte[][][] ByteArrayPool_arrays;

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(JLjava/lang/String;I)I",
		garbageValue = "813549097"
	)
	static final int method6825(long var0, String var2) {
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

		var4.encryptRsa(class69.field874, class69.field875);
		var5.writeByte(10);

		for (var7 = 0; var7 < 3; ++var7) {
			var5.writeInt(var3.nextInt());
		}

		var5.writeLong(var3.nextLong());
		var5.writeLongMedium(var3.nextLong());
		MusicPatchNode.method5669(var5);
		var5.writeLong(var3.nextLong());
		var5.encryptRsa(class69.field874, class69.field875);
		var7 = Actor.stringCp1252NullTerminatedByteSize(var2);
		if (var7 % 8 != 0) {
			var7 += 8 - var7 % 8;
		}

		Buffer var8 = new Buffer(var7);
		var8.writeStringCp1252NullTerminated(var2);
		var8.offset = var7;
		var8.xteaEncryptAll(var6);
		Buffer var9 = new Buffer(var8.offset + var5.offset + var4.offset + 5);
		var9.writeByte(2);
		var9.writeByte(var4.offset);
		var9.writeBytes(var4.array, 0, var4.offset);
		var9.writeByte(var5.offset);
		var9.writeBytes(var5.array, 0, var5.offset);
		var9.writeShort(var8.offset);
		var9.writeBytes(var8.array, 0, var8.offset);
		byte[] var11 = var9.array;
		int var13 = var11.length;
		StringBuilder var14 = new StringBuilder();

		int var17;
		for (int var15 = 0; var15 < var13 + 0; var15 += 3) {
			int var16 = var11[var15] & 255;
			var14.append(class356.field4298[var16 >>> 2]);
			if (var15 < var13 - 1) {
				var17 = var11[var15 + 1] & 255;
				var14.append(class356.field4298[(var16 & 3) << 4 | var17 >>> 4]);
				if (var15 < var13 - 2) {
					int var18 = var11[var15 + 2] & 255;
					var14.append(class356.field4298[(var17 & 15) << 2 | var18 >>> 6]).append(class356.field4298[var18 & 63]);
				} else {
					var14.append(class356.field4298[(var17 & 15) << 2]).append("=");
				}
			} else {
				var14.append(class356.field4298[(var16 & 3) << 4]).append("==");
			}
		}

		String var12 = var14.toString();
		var12 = var12;

		try {
			URL var19 = new URL(class135.method2990("services", false) + "m=accountappeal/login.ws");
			URLConnection var24 = var19.openConnection();
			var24.setDoInput(true);
			var24.setDoOutput(true);
			var24.setConnectTimeout(5000);
			OutputStreamWriter var20 = new OutputStreamWriter(var24.getOutputStream());
			var20.write("data2=" + DynamicObject.method2132(var12) + "&dest=" + DynamicObject.method2132("passwordchoice.ws"));
			var20.flush();
			InputStream var21 = var24.getInputStream();
			var9 = new Buffer(new byte[1000]);

			do {
				var17 = var21.read(var9.array, var9.offset, 1000 - var9.offset);
				if (var17 == -1) {
					var20.close();
					var21.close();
					String var22 = new String(var9.array);
					if (var22.startsWith("OFFLINE")) {
						return 4;
					} else if (var22.startsWith("WRONG")) {
						return 7;
					} else if (var22.startsWith("RELOAD")) {
						return 3;
					} else if (var22.startsWith("Not permitted for social network accounts.")) {
						return 6;
					} else {
						var9.xteaDecryptAll(var6);

						while (var9.offset > 0 && var9.array[var9.offset - 1] == 0) {
							--var9.offset;
						}

						var22 = new String(var9.array, 0, var9.offset);
						if (NPC.method2494(var22)) {
							UrlRequester.openURL(var22, true, false);
							return 2;
						} else {
							return 5;
						}
					}
				}

				var9.offset += var17;
			} while(var9.offset < 1000);

			return 5;
		} catch (Throwable var23) {
			var23.printStackTrace();
			return 5;
		}
	}
}
