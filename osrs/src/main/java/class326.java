import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.net.MalformedURLException;
import java.net.URL;

@ObfuscatedName("mw")
public class class326 {
	@ObfuscatedName("qq")
	static int field2893;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Let;"
	)
	UrlRequest field2894;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lui;"
	)
	SpritePixels field2895;

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Lev;)V"
	)
	class326(String var1, UrlRequester var2) {
		try {
			this.field2894 = var2.request(new URL(var1));
		} catch (MalformedURLException var4) {
			this.field2894 = null;
		}

	}

	@ObfuscatedSignature(
		descriptor = "(Let;)V"
	)
	class326(UrlRequest var1) {
		this.field2894 = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Lui;",
		garbageValue = "-688482237"
	)
	SpritePixels method1715() {
		if (this.field2895 == null && this.field2894 != null && this.field2894.isDone()) {
			if (this.field2894.getResponse() != null) {
				this.field2895 = WorldMapData_1.method1484(this.field2894.getResponse());
			}

			this.field2894 = null;
		}

		return this.field2895;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lnu;I)V",
		garbageValue = "-856388391"
	)
	public static void method1714(AbstractArchive var0) {
		FloorOverlayDefinition.FloorOverlayDefinition_archive = var0;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "-1268604308"
	)
	static int method1716(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 == 2700) {
			var3 = class92.getWidget(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == 2701) {
			var3 = class92.getWidget(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == 2702) {
			int var5 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var5);
			if (var4 != null) {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
			} else {
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == 2706) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.rootInterface;
			return 1;
		} else if (var0 == 2707) {
			var3 = class92.getWidget(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.method1834() ? 1 : 0;
			return 1;
		} else if (var0 == 2708) {
			var3 = class92.getWidget(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
			return WorldMapDecoration.method1530(var3);
		} else if (var0 == 2709) {
			var3 = class92.getWidget(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
			return class390.method2030(var3);
		} else {
			return 2;
		}
	}
}