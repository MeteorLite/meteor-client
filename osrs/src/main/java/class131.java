import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.util.concurrent.Callable;

@ObfuscatedName("fh")
public class class131 implements Callable {
	@ObfuscatedName("ur")
	@Export("cameraMoveToAcceleration")
	static int cameraMoveToAcceleration;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lfz;"
	)
	final class132 field1231;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	final class133 field1230;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lfl;"
	)
	final class134 field1229;
	@ObfuscatedName("ax")
	final int field1232;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfk;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class139 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfk;Lfz;Lfs;Lfl;I)V"
	)
	class131(class139 var1, class132 var2, class133 var3, class134 var4, int var5) {
		this.this$0 = var1;
		this.field1231 = var2;
		this.field1230 = var3;
		this.field1229 = var4;
		this.field1232 = var5;
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() {
		this.field1231.method710();
		class132[][] var1;
		if (this.field1230 == class133.field1260) {
			var1 = this.this$0.field1292;
		} else {
			var1 = this.this$0.field1297;
		}

		var1[this.field1232][this.field1229.method724()] = this.field1231;
		return null;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)[B",
		garbageValue = "1"
	)
	public static byte[] method706() {
		byte[] var0 = new byte[24];

		try {
			JagexCache.JagexCache_randomDat.seek(0L);
			JagexCache.JagexCache_randomDat.readFully(var0);

			int var1;
			for (var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
			}

			if (var1 >= 24) {
				throw new IOException();
			}
		} catch (Exception var4) {
			for (int var2 = 0; var2 < 24; ++var2) {
				var0[var2] = -1;
			}
		}

		return var0;
	}

	@ObfuscatedName("mu")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1460663579"
	)
	static boolean method707(int var0) {
		for (int var1 = 0; var1 < Client.field533; ++var1) {
			if (Client.field577[var1] == var0) {
				return true;
			}
		}

		return false;
	}
}