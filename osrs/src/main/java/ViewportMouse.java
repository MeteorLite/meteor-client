import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("netscape/js")
@Implements("ViewportMouse")
public class ViewportMouse {
	@ObfuscatedName("ac")
	@Export("ViewportMouse_isInViewport")
	static boolean ViewportMouse_isInViewport;
	@ObfuscatedName("al")
	@Export("ViewportMouse_x")
	static int ViewportMouse_x;
	@ObfuscatedName("ak")
	@Export("ViewportMouse_y")
	static int ViewportMouse_y;
	@ObfuscatedName("ax")
	@Export("ViewportMouse_false0")
	static boolean ViewportMouse_false0;
	@ObfuscatedName("ao")
	static int field2264;
	@ObfuscatedName("ah")
	static int field2260;
	@ObfuscatedName("am")
	static int field2263;
	@ObfuscatedName("av")
	static int field2265;
	@ObfuscatedName("ay")
	@Export("ViewportMouse_entityCount")
	public static int ViewportMouse_entityCount;
	@ObfuscatedName("as")
	@Export("ViewportMouse_entityTags")
	public static long[] ViewportMouse_entityTags;

	static {
		ViewportMouse_isInViewport = false;
		ViewportMouse_x = 0;
		ViewportMouse_y = 0;
		ViewportMouse_false0 = false;
		ViewportMouse_entityCount = 0;
		ViewportMouse_entityTags = new long[1000];
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZI)I",
		garbageValue = "-527981427"
	)
	static int method1389(int var0, Script var1, boolean var2) {
		if (var0 < 1000) {
			return class168.method878(var0, var1, var2);
		} else if (var0 < 1100) {
			return ClientPreferences.method567(var0, var1, var2);
		} else if (var0 < 1200) {
			return class17.method56(var0, var1, var2);
		} else if (var0 < 1300) {
			return class76.method432(var0, var1, var2);
		} else if (var0 < 1400) {
			return class4.method6(var0, var1, var2);
		} else if (var0 < 1500) {
			return class31.method127(var0, var1, var2);
		} else if (var0 < 1600) {
			return class87.method462(var0, var1, var2);
		} else if (var0 < 1700) {
			return class134.method725(var0, var1, var2);
		} else if (var0 < 1800) {
			return class202.method1004(var0, var1, var2);
		} else if (var0 < 1900) {
			return class13.method42(var0, var1, var2);
		} else if (var0 < 2000) {
			return class20.method77(var0, var1, var2);
		} else if (var0 < 2100) {
			return ClientPreferences.method567(var0, var1, var2);
		} else if (var0 < 2200) {
			return class17.method56(var0, var1, var2);
		} else if (var0 < 2300) {
			return class76.method432(var0, var1, var2);
		} else if (var0 < 2400) {
			return class4.method6(var0, var1, var2);
		} else if (var0 < 2500) {
			return class31.method127(var0, var1, var2);
		} else if (var0 < 2600) {
			return class30.method123(var0, var1, var2);
		} else if (var0 < 2700) {
			return DevicePcmPlayerProvider.method86(var0, var1, var2);
		} else if (var0 < 2800) {
			return Varps.method1735(var0, var1, var2);
		} else if (var0 < 2900) {
			return ClientPacket.method1640(var0, var1, var2);
		} else if (var0 < 3000) {
			return class20.method77(var0, var1, var2);
		} else if (var0 < 3200) {
			return class266.method1430(var0, var1, var2);
		} else if (var0 < 3300) {
			return class133.method722(var0, var1, var2);
		} else if (var0 < 3400) {
			return Frames.method1339(var0, var1, var2);
		} else if (var0 < 3500) {
			return Buddy.method2285(var0, var1, var2);
		} else if (var0 < 3600) {
			return WorldMapElement.method971(var0, var1, var2);
		} else if (var0 < 3700) {
			return ReflectionCheck.method184(var0, var1, var2);
		} else if (var0 < 3800) {
			return class470.method2363(var0, var1, var2);
		} else if (var0 < 3900) {
			return class13.method43(var0, var1, var2);
		} else if (var0 < 4000) {
			return class74.method427(var0, var1, var2);
		} else if (var0 < 4100) {
			return KitDefinition.method986(var0, var1, var2);
		} else if (var0 < 4200) {
			return class141.method752(var0, var1, var2);
		} else if (var0 < 4300) {
			return class18.method65(var0, var1, var2);
		} else if (var0 < 5100) {
			return Projectile.method439(var0, var1, var2);
		} else if (var0 < 5400) {
			return PlayerComposition.method1761(var0, var1, var2);
		} else if (var0 < 5600) {
			return ObjectSound.method416(var0, var1, var2);
		} else if (var0 < 5700) {
			return HealthBarUpdate.method524(var0, var1, var2);
		} else if (var0 < 6300) {
			return WorldMapAreaData.method1601(var0, var1, var2);
		} else if (var0 < 6600) {
			return class319.method1660(var0, var1, var2);
		} else if (var0 < 6700) {
			return GrandExchangeOfferNameComparator.method1980(var0, var1, var2);
		} else if (var0 < 6800) {
			return class330.method1729(var0, var1, var2);
		} else if (var0 < 6900) {
			return class169.method881(var0, var1, var2);
		} else if (var0 < 7000) {
			return class104.method606(var0, var1, var2);
		} else if (var0 < 7100) {
			return class224.method1141(var0, var1, var2);
		} else if (var0 < 7200) {
			return class17.method57(var0, var1, var2);
		} else if (var0 < 7300) {
			return MouseHandler.method179(var0, var1, var2);
		} else if (var0 < 7500) {
			return class472.method2371(var0, var1, var2);
		} else if (var0 < 7600) {
			return DynamicObject.method451(var0, var1, var2);
		} else if (var0 < 7700) {
			return class150.method789(var0, var1, var2);
		} else {
			return var0 < 8100 ? class4.method7(var0, var1, var2) : 2;
		}
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(ILnm;IIIII[FI)Lnm;",
		garbageValue = "-357368567"
	)
	static Widget method1390(int var0, Widget var1, int var2, int var3, int var4, int var5, int var6, float[] var7) {
		Widget var8 = new Widget();
		var8.type = var0;
		var8.parentId = var1.id;
		var8.childIndex = var2;
		var8.isIf3 = true;
		var8.xAlignment = var3;
		var8.yAlignment = var4;
		var8.widthAlignment = var5;
		var8.heightAlignment = var6;
		var8.rawX = (int)(var7[0] * (float)var1.width);
		var8.rawY = (int)((float)var1.height * var7[1]);
		var8.rawWidth = (int)(var7[2] * (float)var1.width);
		var8.rawHeight = (int)((float)var1.height * var7[3]);
		return var8;
	}
}