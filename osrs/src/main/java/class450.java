import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rj")
public final class class450 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "[Lrj;"
	)
	static class450[] field3852;
	@ObfuscatedName("ay")
	static int field3851;
	@ObfuscatedName("am")
	float field3855;
	@ObfuscatedName("as")
	float field3856;
	@ObfuscatedName("aj")
	float field3854;
	@ObfuscatedName("ag")
	float field3853;

	static {
		field3852 = new class450[0];
		WorldMapManager.method1440(100);
		new class450();
	}

	class450() {
		this.method2268();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "720031596"
	)
	public void method2265() {
		synchronized(field3852) {
			if (class344.field3132 < field3851 - 1) {
				field3852[++class344.field3132 - 1] = this;
			}

		}
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(FFFFI)V",
		garbageValue = "646629181"
	)
	void method2266(float var1, float var2, float var3, float var4) {
		this.field3855 = var1;
		this.field3856 = var2;
		this.field3854 = var3;
		this.field3853 = var4;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(FFFFI)V",
		garbageValue = "-806476274"
	)
	public void method2267(float var1, float var2, float var3, float var4) {
		float var5 = (float)Math.sin((double)(var4 * 0.5F));
		float var6 = (float)Math.cos((double)(var4 * 0.5F));
		this.field3855 = var5 * var1;
		this.field3856 = var2 * var5;
		this.field3854 = var3 * var5;
		this.field3853 = var6;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "407146638"
	)
	final void method2268() {
		this.field3854 = 0.0F;
		this.field3856 = 0.0F;
		this.field3855 = 0.0F;
		this.field3853 = 1.0F;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Lrj;S)V",
		garbageValue = "-7868"
	)
	public final void method2269(class450 var1) {
		this.method2266(this.field3855 * var1.field3853 + this.field3853 * var1.field3855 + var1.field3856 * this.field3854 - this.field3856 * var1.field3854, this.field3853 * var1.field3856 + (var1.field3853 * this.field3856 - var1.field3855 * this.field3854) + this.field3855 * var1.field3854, var1.field3855 * this.field3856 + this.field3854 * var1.field3853 - var1.field3856 * this.field3855 + var1.field3854 * this.field3853, var1.field3853 * this.field3853 - this.field3855 * var1.field3855 - this.field3856 * var1.field3856 - this.field3854 * var1.field3854);
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (!(var1 instanceof class450)) {
			return false;
		} else {
			class450 var2 = (class450)var1;
			return var2.field3855 == this.field3855 && this.field3856 == var2.field3856 && var2.field3854 == this.field3854 && var2.field3853 == this.field3853;
		}
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		boolean var1 = true;
		float var2 = 1.0F;
		var2 = this.field3855 + var2 * 31.0F;
		var2 = this.field3856 + var2 * 31.0F;
		var2 = this.field3854 + 31.0F * var2;
		var2 = var2 * 31.0F + this.field3853;
		return (int)var2;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field3855 + "," + this.field3856 + "," + this.field3854 + "," + this.field3853;
	}

	@ObfuscatedName("ny")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "568233292"
	)
	static void method2270(String var0) {
		class36.param9 = var0;

		try {
			String var1 = TileItem.client.getParameter(Integer.toString(18));
			String var2 = TileItem.client.getParameter(Integer.toString(13));
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				String var4 = var3 + "; Expires=";
				long var6 = class113.clockNow() + 94608000000L;
				Calendar.Calendar_calendar.setTime(new Date(var6));
				int var8 = Calendar.Calendar_calendar.get(7);
				int var9 = Calendar.Calendar_calendar.get(5);
				int var10 = Calendar.Calendar_calendar.get(2);
				int var11 = Calendar.Calendar_calendar.get(1);
				int var12 = Calendar.Calendar_calendar.get(11);
				int var13 = Calendar.Calendar_calendar.get(12);
				int var14 = Calendar.Calendar_calendar.get(13);
				String var5 = Calendar.DAYS_OF_THE_WEEK[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + Calendar.MONTH_NAMES_ENGLISH_GERMAN[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
				var3 = var4 + var5 + "; Max-Age=" + 94608000L;
			}

			class26.method100(TileItem.client, "document.cookie=\"" + var3 + "\"");
		} catch (Throwable var15) {
		}

	}
}
