import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lv")
@Implements("BoundaryObject")
public final class BoundaryObject {
	@ObfuscatedName("at")
	@Export("z")
	int z;
	@ObfuscatedName("ah")
	@Export("x")
	int x;
	@ObfuscatedName("ar")
	@Export("y")
	int y;
	@ObfuscatedName("ao")
	@Export("orientationA")
	int orientationA;
	@ObfuscatedName("ab")
	@Export("orientationB")
	int orientationB;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lkt;"
	)
	@Export("renderable1")
	public Renderable renderable1;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lkt;"
	)
	@Export("renderable2")
	public Renderable renderable2;
	@ObfuscatedName("ac")
	@Export("tag")
	public long tag;
	@ObfuscatedName("al")
	@Export("flags")
	int flags;

	BoundaryObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
		garbageValue = "-1198617474"
	)
	public static String method1600(CharSequence[] var0, int var1, int var2) {
		if (var2 == 0) {
			return "";
		} else if (var2 == 1) {
			CharSequence var3 = var0[var1];
			return var3 == null ? "null" : var3.toString();
		} else {
			int var8 = var2 + var1;
			int var4 = 0;

			for (int var5 = var1; var5 < var8; ++var5) {
				CharSequence var6 = var0[var5];
				if (var6 == null) {
					var4 += 4;
				} else {
					var4 += var6.length();
				}
			}

			StringBuilder var9 = new StringBuilder(var4);

			for (int var10 = var1; var10 < var8; ++var10) {
				CharSequence var7 = var0[var10];
				if (var7 == null) {
					var9.append("null");
				} else {
					var9.append(var7);
				}
			}

			return var9.toString();
		}
	}
}