import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@ObfuscatedName("aw")
public class class20 {
	@ObfuscatedName("jr")
	@Export("baseX")
	static int baseX;
	@ObfuscatedName("ac")
	final int field56;
	@ObfuscatedName("al")
	final Map field58;
	@ObfuscatedName("ak")
	final String field57;

	class20(String var1) {
		this.field56 = 400;
		this.field58 = null;
		this.field57 = "";
	}

	class20(HttpURLConnection var1) throws IOException {
		this.field56 = var1.getResponseCode();
		var1.getResponseMessage();
		this.field58 = var1.getHeaderFields();
		StringBuilder var2 = new StringBuilder();
		InputStream var3 = this.field56 >= 300 ? var1.getErrorStream() : var1.getInputStream();
		if (var3 != null) {
			InputStreamReader var4 = new InputStreamReader(var3);
			BufferedReader var5 = new BufferedReader(var4);

			String var6;
			while ((var6 = var5.readLine()) != null) {
				var2.append(var6);
			}

			var3.close();
		}

		this.field57 = var2.toString();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1672578717"
	)
	public int method71() {
		return this.field56;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/util/Map;",
		garbageValue = "-85"
	)
	public Map method72() {
		return this.field58;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-21006210"
	)
	public String method73() {
		return this.field57;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "775264196"
	)
	public static int method70(int var0) {
		return var0 + -512;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1265533406"
	)
	public static void method74() {
		ParamComposition.ParamDefinition_cached.clear();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/Date;",
		garbageValue = "572472849"
	)
	static Date method76() throws ParseException {
		SimpleDateFormat var0 = new SimpleDateFormat("ddMMyyyyHH", Locale.ENGLISH);
		var0.setLenient(false);
		StringBuilder var1 = new StringBuilder();
		String[] var2 = Login.field766;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			String var4 = var2[var3];
			if (var4 == null) {
				class19.method67("Date not valid.", "Please ensure all characters are populated.", "");
				return null;
			}

			var1.append(var4);
		}

		var1.append("12");
		return var0.parse(var1.toString());
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-690055453"
	)
	public static void method75() {
		NPCComposition.NpcDefinition_cached.clear();
		NPCComposition.HitSplatDefinition_cachedFonts.clear();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(ILds;ZI)I",
		garbageValue = "1223727295"
	)
	static int method77(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 != 1927 && var0 != 2927) {
			int var4;
			if (var0 == 1928) {
				var3 = var2 ? class416.scriptDotWidget : class306.scriptActiveWidget;
				var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var4 >= 1 && var4 <= 10) {
					class104 var5 = new class104(var4, var3.id, var3.childIndex, var3.itemId);
					Interpreter.field713.add(var5);
					return 1;
				} else {
					throw new RuntimeException();
				}
			} else if (var0 == 2928) {
				Interpreter.Interpreter_intStackSize -= 3;
				int var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				int var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
				if (var8 >= 1 && var8 <= 10) {
					class104 var6 = new class104(var8, var7, var4, class33.field89.method1740(var7).itemId);
					Interpreter.field713.add(var6);
					return 1;
				} else {
					throw new RuntimeException();
				}
			} else {
				return 2;
			}
		} else if (Interpreter.field706 >= 10) {
			throw new RuntimeException();
		} else {
			if (var0 >= 2000) {
				var3 = class33.field89.method1740(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			} else {
				var3 = var2 ? class416.scriptDotWidget : class306.scriptActiveWidget;
			}

			if (var3.onResize == null) {
				return 0;
			} else {
				ScriptEvent var9 = new ScriptEvent();
				var9.widget = var3;
				var9.args = var3.onResize;
				var9.field864 = Interpreter.field706 + 1;
				Client.scriptEvents.addFirst(var9);
				return 1;
			}
		}
	}
}