import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;

@ObfuscatedName("gq")
public class class177 {
	@ObfuscatedName("ay")
	@Export("canvasHeight")
	public static int canvasHeight;
	@ObfuscatedName("at")
	public String field1476;
	@ObfuscatedName("ac")
	public float[] field1472;
	@ObfuscatedName("ai")
	public int field1473;
	@ObfuscatedName("az")
	public int field1475;
	@ObfuscatedName("ap")
	public int field1474;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgf;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class170 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgf;)V"
	)
	class177(class170 var1) {
		this.this$0 = var1;
		this.field1472 = new float[4];
		this.field1473 = 1;
		this.field1475 = 1;
		this.field1474 = 0;
	}

	@ObfuscatedName("at")
	public static int method918(long var0) {
		return (int)(var0 >>> 14 & 3L);
	}

	@ObfuscatedName("ob")
	@ObfuscatedSignature(
		descriptor = "(Ltm;S)V",
		garbageValue = "-22136"
	)
	static void method919(Buffer var0) {
		if (Client.randomDatData != null) {
			var0.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
		} else {
			byte[] var2 = new byte[24];

			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.readFully(var2);

				int var3;
				for (var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
				}

				if (var3 >= 24) {
					throw new IOException();
				}
			} catch (Exception var6) {
				for (int var4 = 0; var4 < 24; ++var4) {
					var2[var4] = -1;
				}
			}

			var0.writeBytes(var2, 0, var2.length);
		}
	}
}