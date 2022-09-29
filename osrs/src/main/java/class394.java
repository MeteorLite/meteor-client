import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("op")
public abstract class class394 extends class250 implements class451 {
	@ObfuscatedSignature(
		descriptor = "(Lkl;Llj;I)V"
	)
	protected class394(StudioGame var1, Language var2, int var3) {
		super(var1, var2, var3);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IB)Lof;",
		garbageValue = "-21"
	)
	protected abstract class396 vmethod7723(int var1);

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-457837759"
	)
	public int method7267() {
		return super.field2914;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(IB)Ljava/lang/Object;",
		garbageValue = "119"
	)
	public Object vmethod8208(int var1) {
		class396 var2 = this.vmethod7723(var1);
		return var2 != null && var2.method7287() ? var2.method7295() : null;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Lqq;B)Lql;",
		garbageValue = "39"
	)
	public class452 method7271(Buffer var1) {
		int var2 = var1.readUnsignedShort();
		class396 var3 = this.vmethod7723(var2);
		class452 var4 = new class452(var2);
		Class var5 = var3.field4465.field4697;
		if (var5 == Integer.class) {
			var4.field4797 = var1.readInt();
		} else if (var5 == Long.class) {
			var4.field4797 = var1.readLong();
		} else if (var5 == String.class) {
			var4.field4797 = var1.readStringCp1252NullCircumfixed();
		} else {
			if (!class447.class.isAssignableFrom(var5)) {
				throw new IllegalStateException();
			}

			try {
				class447 var6 = (class447)var5.newInstance();
				var6.method8179(var1);
				var4.field4797 = var6;
			} catch (InstantiationException var7) {
			} catch (IllegalAccessException var8) {
			}
		}

		return var4;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(CLlj;B)I",
		garbageValue = "1"
	)
	@Export("lowercaseChar")
	static int lowercaseChar(char var0, Language var1) {
		int var2 = var0 << 4;
		if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
			var0 = Character.toLowerCase(var0);
			var2 = (var0 << 4) + 1;
		}

		if (var0 == 241 && var1 == Language.Language_ES) {
			var2 = 1762;
		}

		return var2;
	}
}
