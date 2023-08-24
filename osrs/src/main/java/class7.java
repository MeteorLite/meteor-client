import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ObfuscatedName("ap")
public class class7 {
	@ObfuscatedName("aq")
	static int field9;
	@ObfuscatedName("au")
	ExecutorService field10;
	@ObfuscatedName("ae")
	Future field11;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ltm;"
	)
	final Buffer field13;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lat;"
	)
	final class3 field12;

	@ObfuscatedSignature(
		descriptor = "(Ltm;Lat;)V"
	)
	public class7(Buffer var1, class3 var2) {
		this.field10 = Executors.newSingleThreadExecutor();
		this.field13 = var1;
		this.field12 = var2;
		this.method17();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1836441256"
	)
	public boolean method14() {
		return this.field11.isDone();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2092027940"
	)
	public void method15() {
		this.field10.shutdown();
		this.field10 = null;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)Ltm;",
		garbageValue = "-120"
	)
	public Buffer method16() {
		try {
			return (Buffer)this.field11.get();
		} catch (Exception var2) {
			return null;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-691162885"
	)
	void method17() {
		this.field11 = this.field10.submit(new class1(this, this.field13, this.field12));
	}

	@ObfuscatedName("iy")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "1"
	)
	static final int method18(int var0) {
		return Math.abs(var0 - UserComparator10.cameraYaw) > 1024 ? var0 + 2048 * (var0 < UserComparator10.cameraYaw ? 1 : -1) : var0;
	}
}