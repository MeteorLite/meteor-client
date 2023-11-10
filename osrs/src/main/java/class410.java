import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Date;

@ObfuscatedName("pd")
public class class410 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lpv;"
	)
	class406 field3743;
	@ObfuscatedName("ah")
	int field3741;
	@ObfuscatedName("ar")
	int field3742;

	@ObfuscatedSignature(
		descriptor = "(Lpv;II)V"
	)
	class410(class406 var1, int var2, int var3) {
		this.field3741 = 0;
		this.field3742 = 0;
		this.field3743 = var1;
		this.field3741 = var2;
		this.field3742 = var3;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "2063026916"
	)
	public String method2131() {
		if (this.method2133()) {
			return "";
		} else {
			StringBuilder var1 = new StringBuilder(this.method2134());

			for (int var2 = this.field3741; var2 < this.field3742; ++var2) {
				class408 var3 = this.field3743.method2051(var2);
				var1.append(var3.field3716);
			}

			return var1.toString();
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1949431779"
	)
	boolean method2132(int var1) {
		return this.field3743.method2083() == 2 || this.field3743.method2083() == 1 && (!this.field3743.field3705 || this.field3742 - 1 != var1);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "43"
	)
	public boolean method2133() {
		return this.field3742 == this.field3741;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "25"
	)
	public int method2134() {
		return this.field3742 - this.field3741;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Lpn;I)Z",
		garbageValue = "-1150378981"
	)
	boolean method2135(class408 var1) {
		if (this.field3743.field3706 == 2) {
			return true;
		} else if (this.field3743.field3706 == 0) {
			return false;
		} else {
			return this.field3743.method2052() != var1;
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "128"
	)
	int method2136() {
		if (this.method2133()) {
			return 0;
		} else {
			class408 var1 = this.field3743.method2051(this.field3742 - 1);
			if (var1.field3716 == '\n') {
				return 0;
			} else if (this.method2135(var1)) {
				return this.field3743.field3714.advances[42];
			} else {
				int var2 = this.field3743.field3714.advances[var1.field3716];
				if (var2 == 0) {
					return var1.field3716 == '\t' ? this.field3743.field3714.advances[32] * 3 : this.field3743.field3714.advances[32];
				} else {
					return var2;
				}
			}
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Lti;",
		garbageValue = "-1126162265"
	)
	public class497 method2137() {
		if (this.method2133()) {
			return new class497(0, 0);
		} else {
			class408 var1 = this.field3743.method2051(this.field3742 - 1);
			return new class497(var1.field3717 + this.method2136(), var1.field3718);
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)Lpn;",
		garbageValue = "262474299"
	)
	public class408 method2138(int var1) {
		return var1 >= 0 && var1 < this.method2134() ? this.field3743.method2051(this.field3741 + var1) : null;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-127"
	)
	public static final void method2139() {
		ViewportMouse.ViewportMouse_isInViewport = false;
		ViewportMouse.ViewportMouse_entityCount = 0;
	}

	@ObfuscatedName("nz")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "1487231086"
	)
	static void method2140(String var0) {
		MenuAction.param9 = var0;

		try {
			String var1 = SpriteMask.client.getParameter(Integer.toString(18));
			String var2 = SpriteMask.client.getParameter(Integer.toString(13));
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				String var4 = var3 + "; Expires=";
				long var6 = SpotAnimationDefinition.method962() + 94608000000L;
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

			class26.method107(SpriteMask.client, "document.cookie=\"" + var3 + "\"");
		} catch (Throwable var15) {
		}

	}
}