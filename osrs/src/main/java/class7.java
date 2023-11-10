import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ObfuscatedName("ac")
public class class7 {
	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "Lrv;"
	)
	static Bounds field13;
	@ObfuscatedName("fc")
	@ObfuscatedSignature(
		descriptor = "Loh;"
	)
	static Archive field12;
	@ObfuscatedName("at")
	ExecutorService field14;
	@ObfuscatedName("ah")
	Future field15;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Luj;"
	)
	final Buffer field17;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lao;"
	)
	final class3 field16;

	@ObfuscatedSignature(
		descriptor = "(Luj;Lao;)V"
	)
	public class7(Buffer var1, class3 var2) {
		this.field14 = Executors.newSingleThreadExecutor();
		this.field17 = var1;
		this.field16 = var2;
		this.method20();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1139388423"
	)
	public boolean method17() {
		return this.field15.isDone();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-85"
	)
	public void method18() {
		this.field14.shutdown();
		this.field14 = null;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)Luj;",
		garbageValue = "1719469539"
	)
	public Buffer method19() {
		try {
			return (Buffer)this.field15.get();
		} catch (Exception var2) {
			return null;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "670467057"
	)
	void method20() {
		this.field15 = this.field14.submit(new class1(this, this.field17, this.field16));
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "1"
	)
	@Export("isWorldMapEvent")
	public static boolean isWorldMapEvent(int var0) {
		return var0 == 10 || var0 == 11 || var0 == 12 || var0 == 13 || var0 == 14 || var0 == 15 || var0 == 16 || var0 == 17;
	}
}