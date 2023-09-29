import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sm")
public abstract class class470 extends class295 implements class537 {
	@ObfuscatedSignature(
		descriptor = "(Lnp;Loa;I)V"
	)
	protected class470(StudioGame var1, Language var2, int var3) {
		super(var1, var2, var3);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Lsl;",
		garbageValue = "-799452482"
	)
	@Export("vmethod8207")
	protected abstract class472 vmethod8207(int var1);

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1745704270"
	)
	public int method2359() {
		return super.field2498;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/Object;",
		garbageValue = "-123056323"
	)
	@Export("vmethod8697")
	public Object vmethod8697(int var1) {
		class472 var2 = this.vmethod8207(var1);
		return var2 != null && var2.method2369() ? var2.method2370() : null;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)Lut;",
		garbageValue = "-1458029459"
	)
	public class538 method2361(Buffer var1) {
		int var2 = var1.readUnsignedShort();
		class472 var3 = this.vmethod8207(var2);
		class538 var4 = new class538(var2);
		Class var5 = var3.field3932.field4134;
		if (var5 == Integer.class) {
			var4.field4242 = var1.readInt();
		} else if (var5 == Long.class) {
			var4.field4242 = var1.readLong();
		} else if (var5 == String.class) {
			var4.field4242 = var1.readStringCp1252NullCircumfixed();
		} else {
			if (!class533.class.isAssignableFrom(var5)) {
				throw new IllegalStateException();
			}

			try {
				class533 var6 = (class533)var5.newInstance();
				var6.method2652(var1);
				var4.field4242 = var6;
			} catch (InstantiationException var7) {
			} catch (IllegalAccessException var8) {
			}
		}

		return var4;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-89620142"
	)
	public static void method2362() {
		class319.field2789.clear();
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZI)I",
		garbageValue = "1657121032"
	)
	static int method2363(int var0, Script var1, boolean var2) {
		return 2;
	}
}