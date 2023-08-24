import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rp")
public abstract class class455 extends class281 implements class522 {
	@ObfuscatedSignature(
		descriptor = "(Lns;Lon;I)V"
	)
	protected class455(StudioGame var1, Language var2, int var3) {
		super(var1, var2, var3);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IB)Lrv;",
		garbageValue = "-32"
	)
	@Export("vmethod8207")
	protected abstract class457 vmethod8207(int var1);

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1119561049"
	)
	public int method2322() {
		return super.field2482;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)Ljava/lang/Object;",
		garbageValue = "22"
	)
	@Export("vmethod8697")
	public Object vmethod8697(int var1) {
		class457 var2 = this.vmethod8207(var1);
		return var2 != null && var2.method2328() ? var2.method2329() : null;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)Lud;",
		garbageValue = "-80"
	)
	public class523 method2324(Buffer var1) {
		int var2 = var1.readUnsignedShort();
		class457 var3 = this.vmethod8207(var2);
		class523 var4 = new class523(var2);
		Class var5 = var3.field3900.field4105;
		if (var5 == Integer.class) {
			var4.field4215 = var1.readInt();
		} else if (var5 == Long.class) {
			var4.field4215 = var1.readLong();
		} else if (var5 == String.class) {
			var4.field4215 = var1.readStringCp1252NullCircumfixed();
		} else {
			if (!class518.class.isAssignableFrom(var5)) {
				throw new IllegalStateException();
			}

			try {
				class518 var6 = (class518)var5.newInstance();
				var6.method2614(var1);
				var4.field4215 = var6;
			} catch (InstantiationException var7) {
			} catch (IllegalAccessException var8) {
			}
		}

		return var4;
	}
}