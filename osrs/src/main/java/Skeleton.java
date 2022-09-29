import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
@Implements("Skeleton")
public class Skeleton extends Node {
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -2058756479
	)
	@Export("id")
	int id;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1235807207
	)
	@Export("count")
	int count;
	@ObfuscatedName("q")
	@Export("transformTypes")
	int[] transformTypes;
	@ObfuscatedName("m")
	@Export("labels")
	int[][] labels;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "Lge;"
	)
	class202 field2406;

	public Skeleton(int var1, byte[] var2) {
		this.id = var1;
		Buffer var3 = new Buffer(var2);
		this.count = var3.readUnsignedByte();
		this.transformTypes = new int[this.count];
		this.labels = new int[this.count][];

		int var4;
		for (var4 = 0; var4 < this.count; ++var4) {
			this.transformTypes[var4] = var3.readUnsignedByte();
		}

		for (var4 = 0; var4 < this.count; ++var4) {
			this.labels[var4] = new int[var3.readUnsignedByte()];
		}

		for (var4 = 0; var4 < this.count; ++var4) {
			for (int var5 = 0; var5 < this.labels[var4].length; ++var5) {
				this.labels[var4][var5] = var3.readUnsignedByte();
			}
		}

		if (var3.offset < var3.array.length) {
			var4 = var3.readUnsignedShort();
			if (var4 > 0) {
				this.field2406 = new class202(var3, var4);
			}
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "46"
	)
	public int method4248() {
		return this.count;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(I)Lge;",
		garbageValue = "-563636318"
	)
	public class202 method4249() {
		return this.field2406;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "125"
	)
	static void method4247(int var0) {
		class388.field4430 = var0;
		class388.field4429 = new class388[var0];
		class388.field4434 = 0;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1163435315"
	)
	static boolean method4257() {
		Date var0;
		try {
			SimpleDateFormat var2 = new SimpleDateFormat("ddMMyyyyHH", Locale.ENGLISH);
			var2.setLenient(false);
			StringBuilder var3 = new StringBuilder();
			String[] var4 = Login.field907;
			int var5 = 0;

			while (true) {
				Date var1;
				if (var5 < var4.length) {
					String var6 = var4[var5];
					if (var6 != null) {
						var3.append(var6);
						++var5;
						continue;
					}

					class139.method3101(7);
					SecureRandomCallable.setLoginResponseString("Date not valid.", "Please ensure all characters are populated.", "");
					var1 = null;
				} else {
					var3.append("12");
					var1 = var2.parse(var3.toString());
				}

				var0 = var1;
				break;
			}
		} catch (ParseException var10) {
			class139.method3101(7);
			SecureRandomCallable.setLoginResponseString("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
			return false;
		}

		if (var0 == null) {
			return false;
		} else {
			java.util.Calendar var11 = java.util.Calendar.getInstance();
			var11.set(1, var11.get(1) - 13);
			var11.set(5, var11.get(5) + 1);
			var11.set(11, 0);
			var11.set(12, 0);
			var11.set(13, 0);
			var11.set(14, 0);
			Date var12 = var11.getTime();
			boolean var7 = var0.before(var12);
			boolean var9 = class6.method50(var0);
			if (!var9) {
				class139.method3101(7);
				SecureRandomCallable.setLoginResponseString("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
				return false;
			} else {
				if (!var7) {
					MusicPatchNode2.field3223 = 8388607;
				} else {
					MusicPatchNode2.field3223 = (int)(var0.getTime() / 86400000L - 11745L);
				}

				return true;
			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "1356698053"
	)
	public static int method4255(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + var0.charAt(var3);
		}

		return var2;
	}
}
