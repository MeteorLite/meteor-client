import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.concurrent.Callable;

@ObfuscatedName("al")
public class class1 implements Callable {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lul;"
	)
	final Buffer field1;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lax;"
	)
	final class3 field0;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lab;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class7 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lab;Lul;Lax;)V"
	)
	class1(class7 var1, Buffer var2, class3 var3) {
		this.this$0 = var1;
		this.field1 = var2;
		this.field0 = var3;
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() {
		return this.field0.vmethod12(this.field1);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lom;Lom;Lom;Ljava/util/ArrayList;B)Z",
		garbageValue = "-86"
	)
	public static boolean method2(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, ArrayList var3) {
		class319.field2800 = var0;
		class319.field2802 = var1;
		class319.field2801 = var2;
		class319.midiPcmStream = var3;
		return true;
	}
}