import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("RouteStrategy")
public abstract class RouteStrategy {
	@ObfuscatedName("at")
	@Export("approxDestinationX")
	public int approxDestinationX;
	@ObfuscatedName("ah")
	@Export("approxDestinationY")
	public int approxDestinationY;
	@ObfuscatedName("ar")
	@Export("approxDestinationSizeX")
	public int approxDestinationSizeX;
	@ObfuscatedName("ao")
	@Export("approxDestinationSizeY")
	public int approxDestinationSizeY;

	protected RouteStrategy() {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIILiw;I)Z",
		garbageValue = "729664573"
	)
	@Export("hasArrived")
	protected abstract boolean hasArrived(int var1, int var2, int var3, CollisionMap var4);

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)[Lir;",
		garbageValue = "-994113329"
	)
	static class225[] method1149() {
		return new class225[]{class225.field1912, class225.field1909, class225.field1907, class225.field1911, class225.field1913, class225.field1910, class225.field1908};
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "820783273"
	)
	public static void method1150() {
		PlayerComposition.PlayerAppearance_cachedModels.clear();
		PlayerComposition.field2938.clearFiles();
		PlayerComposition.field2936 = 0;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZB)I",
		garbageValue = "52"
	)
	static int method1151(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 3500) {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.keyHandlerInstance.getKeyPressed(var3) ? 1 : 0;
			return 1;
		} else if (var0 == 3501) {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.keyHandlerInstance.method1129(var3) ? 1 : 0;
			return 1;
		} else if (var0 == 3502) {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.keyHandlerInstance.method1131(var3) ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}
}