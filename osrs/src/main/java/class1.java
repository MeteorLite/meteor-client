import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class1 implements Callable {
	@ObfuscatedName("au")
	static int field0;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	final Buffer field2;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lam;"
	)
	final class3 field1;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Laz;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class7 this$0;

	@ObfuscatedSignature(
		descriptor = "(Laz;Lty;Lam;)V"
	)
	class1(class7 var1, Buffer var2, class3 var3) {
		this.this$0 = var1;
		this.field2 = var2;
		this.field1 = var3;
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() {
		return this.field1.vmethod12(this.field2);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)[Ldt;",
		garbageValue = "-1290744164"
	)
	static class90[] method2() {
		return new class90[]{class90.field893, class90.field888, class90.field891, class90.field890, class90.field892, class90.field889};
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "701566139"
	)
	protected static final int method3() {
		return GameEngine.keyHandler.getIdleCycles();
	}
}
