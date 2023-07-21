import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qc")
public class class419 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lqc;"
	)
	static final class419 field3748;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lqc;"
	)
	static final class419 field3749;
	@ObfuscatedName("ar")
	final String field3750;

	static {
		field3748 = new class419("Basic");
		field3749 = new class419("Bearer");
	}

	class419(String var1) {
		this.field3750 = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-1786685713"
	)
	String method2122() {
		return this.field3750;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Lcr;",
		garbageValue = "1237545484"
	)
	@Export("getNextWorldListWorld")
	static World getNextWorldListWorld() {
		return World.World_listCount < World.World_count ? class387.World_worlds[++World.World_listCount - 1] : null;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(IIIB)I",
		garbageValue = "18"
	)
	static final int method2124(int var0, int var1, int var2) {
		int var3 = var0 / var2;
		int var4 = var0 & var2 - 1;
		int var5 = var1 / var2;
		int var6 = var1 & var2 - 1;
		int var7 = WorldMapSprite.method1501(var3, var5);
		int var8 = WorldMapSprite.method1501(var3 + 1, var5);
		int var9 = WorldMapSprite.method1501(var3, var5 + 1);
		int var10 = WorldMapSprite.method1501(var3 + 1, var5 + 1);
		int var11 = class128.method706(var7, var8, var4, var2);
		int var12 = class128.method706(var9, var10, var4, var2);
		return class128.method706(var11, var12, var6, var2);
	}
}
