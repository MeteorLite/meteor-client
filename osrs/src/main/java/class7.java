import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class7 {
	@ObfuscatedName("c")
	ExecutorService field27;
	@ObfuscatedName("p")
	Future field22;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lqq;"
	)
	final Buffer field23;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Ln;"
	)
	final class3 field24;

	@ObfuscatedSignature(
		descriptor = "(Lqq;Ln;)V"
	)
	public class7(Buffer var1, class3 var2) {
		this.field27 = Executors.newSingleThreadExecutor();
		this.field23 = var1;
		this.field24 = var2;
		this.method58();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "1"
	)
	public boolean method51() {
		return this.field22.isDone();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1794518613"
	)
	public void method52() {
		this.field27.shutdown();
		this.field27 = null;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(B)Lqq;",
		garbageValue = "68"
	)
	public Buffer method55() {
		try {
			return (Buffer)this.field22.get();
		} catch (Exception var2) {
			return null;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-109"
	)
	void method58() {
		this.field22 = this.field27.submit(new class1(this, this.field23, this.field24));
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)[Lkg;",
		garbageValue = "1957950782"
	)
	public static GameBuild[] method59() {
		return new GameBuild[]{GameBuild.BUILDLIVE, GameBuild.LIVE, GameBuild.RC, GameBuild.WIP};
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Llv;B)V",
		garbageValue = "-126"
	)
	public static void method69(AbstractArchive var0) {
		EnumComposition.EnumDefinition_archive = var0;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1939268693"
	)
	static void method68() {
		class139.method3101(24);
		SecureRandomCallable.setLoginResponseString("", "You were disconnected from the server.", "");
	}

	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "2127754023"
	)
	static final void method67(int var0, int var1) {
		if (var0 < 128) {
			var0 = 128;
		}

		if (var0 > 383) {
			var0 = 383;
		}

		if (class163.cameraPitch < var0) {
			class163.cameraPitch = (var0 - class163.cameraPitch) * class93.field1270 / 1000 + class163.cameraPitch + SoundSystem.field327;
			if (class163.cameraPitch > var0) {
				class163.cameraPitch = var0;
			}
		}

		if (class163.cameraPitch > var0) {
			class163.cameraPitch -= (class163.cameraPitch - var0) * class93.field1270 / 1000 + SoundSystem.field327;
			if (class163.cameraPitch < var0) {
				class163.cameraPitch = var0;
			}
		}

		int var2 = var1 - class10.cameraYaw;
		if (var2 > 1024) {
			var2 -= 2048;
		}

		if (var2 < -1024) {
			var2 += 2048;
		}

		if (var2 > 0) {
			class10.cameraYaw = class10.cameraYaw + SoundSystem.field327 + var2 * class93.field1270 / 1000;
			class10.cameraYaw &= 2047;
		}

		if (var2 < 0) {
			class10.cameraYaw -= SoundSystem.field327 + -var2 * class93.field1270 / 1000;
			class10.cameraYaw &= 2047;
		}

		int var3 = var1 - class10.cameraYaw;
		if (var3 > 1024) {
			var3 -= 2048;
		}

		if (var3 < -1024) {
			var3 += 2048;
		}

		if (var3 < 0 && var2 > 0 || var3 > 0 && var2 < 0) {
			class10.cameraYaw = var1;
		}

	}
}
