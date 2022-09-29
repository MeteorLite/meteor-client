import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
public class class264 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Ljw;"
	)
	public static final class264 field3046;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Ljw;"
	)
	public static final class264 field3047;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Ljw;"
	)
	public static final class264 field3057;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Ljw;"
	)
	public static final class264 field3054;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Ljw;"
	)
	public static final class264 field3049;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Ljw;"
	)
	public static final class264 field3051;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "Ljw;"
	)
	public static final class264 field3052;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "Ljw;"
	)
	public static final class264 field3053;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "Ljw;"
	)
	public static final class264 field3056;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "Ljw;"
	)
	public static final class264 field3055;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "Ljw;"
	)
	public static final class264 field3050;

	static {
		field3046 = new class264(15);
		field3047 = new class264(5);
		field3057 = new class264(6);
		field3054 = new class264(14);
		field3049 = new class264(3);
		field3051 = new class264(4);
		field3052 = new class264(7);
		field3053 = new class264(2);
		field3056 = new class264(5);
		field3055 = new class264(4);
		field3050 = new class264(5);
	}

	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "15"
	)
	class264(int var1) {
	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		descriptor = "(Lkw;I)Z",
		garbageValue = "-2102361500"
	)
	@Export("runCs1")
	static final boolean runCs1(Widget var0) {
		if (var0.cs1Comparisons == null) {
			return false;
		} else {
			for (int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) {
				int var2 = ReflectionCheck.method648(var0, var1);
				int var3 = var0.cs1ComparisonValues[var1];
				if (var0.cs1Comparisons[var1] == 2) {
					if (var2 >= var3) {
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 3) {
					if (var2 <= var3) {
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 4) {
					if (var2 == var3) {
						return false;
					}
				} else if (var3 != var2) {
					return false;
				}
			}

			return true;
		}
	}

	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1968082006"
	)
	static final void method5345(int var0) {
		var0 = Math.min(Math.max(var0, 0), 127);
		Player.clientPreferences.method2405(var0);
	}
}
