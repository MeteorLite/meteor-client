import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.util.concurrent.Callable;

@ObfuscatedName("ai")
public class class19 implements Callable {
	@ObfuscatedName("eu")
	@Export("mouseCam")
	static boolean mouseCam;
	@ObfuscatedName("fv")
	@ObfuscatedSignature(
		descriptor = "Loh;"
	)
	static Archive field59;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lap;"
	)
	final class10 field60;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lay;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class14 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lay;Lap;)V"
	)
	class19(class14 var1, class10 var2) {
		this.this$0 = var1;
		this.field60 = var2;
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() throws Exception {
		try {
			while (this.field60.method37()) {
				class219.method1104(10L);
			}
		} catch (IOException var2) {
			return new class20("Error servicing REST query: " + var2.getMessage());
		}

		return this.field60.method38();
	}

	@ObfuscatedName("oq")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-2072070052"
	)
	static void method73(int var0) {
		if (var0 != Client.loginState) {
			Client.loginState = var0;
		}
	}
}