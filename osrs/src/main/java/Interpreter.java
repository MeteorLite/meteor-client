import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Interpreter")
public class Interpreter {
	@ObfuscatedName("am")
	@Export("Interpreter_intLocals")
	static int[] Interpreter_intLocals;
	@ObfuscatedName("as")
	@Export("Interpreter_stringLocals")
	static String[] Interpreter_stringLocals;
	@ObfuscatedName("aj")
	@Export("Interpreter_arrayLengths")
	static int[] Interpreter_arrayLengths;
	@ObfuscatedName("ag")
	@Export("Interpreter_arrays")
	static int[][] Interpreter_arrays;
	@ObfuscatedName("az")
	@Export("Interpreter_intStack")
	static int[] Interpreter_intStack;
	@ObfuscatedName("av")
	@Export("Interpreter_intStackSize")
	static int Interpreter_intStackSize;
	@ObfuscatedName("ap")
	@Export("Interpreter_stringStack")
	static String[] Interpreter_stringStack;
	@ObfuscatedName("aq")
	@Export("Interpreter_stringStackSize")
	static int Interpreter_stringStackSize;
	@ObfuscatedName("at")
	@Export("Interpreter_frameDepth")
	static int Interpreter_frameDepth;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "[Lca;"
	)
	@Export("Interpreter_frames")
	static ScriptFrame[] Interpreter_frames;
	@ObfuscatedName("ad")
	@Export("Interpreter_calendar")
	static java.util.Calendar Interpreter_calendar;
	@ObfuscatedName("ao")
	@Export("Interpreter_MONTHS")
	static final String[] Interpreter_MONTHS;
	@ObfuscatedName("ak")
	static boolean field698;
	@ObfuscatedName("an")
	static boolean field699;
	@ObfuscatedName("af")
	static ArrayList field711;
	@ObfuscatedName("ai")
	static int field701;
	@ObfuscatedName("bn")
	static final double field715;
	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "Lot;"
	)
	@Export("clientLanguage")
	static Language clientLanguage;
	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		descriptor = "Lny;"
	)
	static Archive field713;

	static {
		Interpreter_arrayLengths = new int[5];
		Interpreter_arrays = new int[5][5000];
		Interpreter_intStack = new int[1000];
		Interpreter_stringStack = new String[1000];
		Interpreter_frameDepth = 0;
		Interpreter_frames = new ScriptFrame[50];
		Interpreter_calendar = java.util.Calendar.getInstance();
		Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		field698 = false;
		field699 = false;
		field711 = new ArrayList();
		field701 = 0;
		field715 = Math.log(2.0D);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lag;I)Lam;",
		garbageValue = "-654808051"
	)
	public static class3 method424(class6 var0) {
		switch(var0.field8) {
		case 0:
			return new class0();
		default:
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lnd;Lnd;ZLpc;I)V",
		garbageValue = "2044314347"
	)
	public static void method426(AbstractArchive var0, AbstractArchive var1, boolean var2, Font var3) {
		Frames.ItemDefinition_archive = var0;
		class140.ItemDefinition_modelArchive = var1;
		class502.ItemDefinition_inMembersWorld = var2;
		class239.ItemDefinition_fileCount = Frames.ItemDefinition_archive.getGroupFileCount(10);
		FloorDecoration.ItemDefinition_fontPlain11 = var3;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IB)Ldc;",
		garbageValue = "-81"
	)
	@Export("getScript")
	static Script getScript(int var0) {
		Script var1 = (Script)Script.Script_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class126.archive12.takeFile(var0, 0);
			if (var2 == null) {
				return null;
			} else {
				var1 = SoundCache.newScript(var2);
				Script.Script_cached.put(var1, (long)var0);
				return var1;
			}
		}
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZI)I",
		garbageValue = "-2066860268"
	)
	static int method427(int var0, Script var1, boolean var2) {
		return 2;
	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "81"
	)
	@Export("playJingle")
	static void playJingle(int var0, int var1) {
		if (class150.clientPreferences.getCurrentMusicVolume() != 0 && var0 != -1) {
			ArrayList var2 = new ArrayList();
			var2.add(new class318(GrandExchangeOfferOwnWorldComparator.field358, var0, 0, class150.clientPreferences.getCurrentMusicVolume(), false));
			UserComparator4.method663(var2, 0, 0, 0, 0, true);
			Client.playingJingle = true;
		}

	}

	@ObfuscatedName("mt")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-47"
	)
	static final void method429(int var0) {
		var0 = Math.min(Math.max(var0, 0), 127);
		class150.clientPreferences.setAreaSoundEffectsVolume(var0);
	}
}
