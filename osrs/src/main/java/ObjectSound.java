import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("tu")
	@ObfuscatedGetter(
		intValue = -1208168089
	)
	static int field832;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Llc;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 516937797
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -870441583
	)
	@Export("x")
	int x;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 378496640
	)
	@Export("y")
	int y;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1232157189
	)
	@Export("maxX")
	int maxX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1611461431
	)
	@Export("maxY")
	int maxY;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1585697121
	)
	int field819;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -272736565
	)
	int field823;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1699420357
	)
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "Lae;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1844338655
	)
	int field827;
	@ObfuscatedName("v")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1150988163
	)
	int field829;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "Lae;"
	)
	@Export("stream2")
	RawPcmStream stream2;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "Lgz;"
	)
	@Export("obj")
	ObjectComposition obj;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "940400704"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectComposition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field823 = var2.int7 * 128;
			this.field819 = var2.int5;
			this.field827 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field823 = 0;
			this.field819 = 0;
			this.field827 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			class16.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)[Lcj;",
		garbageValue = "1956276941"
	)
	static class83[] method1849() {
		return new class83[]{class83.field1073, class83.field1074, class83.field1078, class83.field1076, class83.field1075, class83.field1077};
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "(ZB)V",
		garbageValue = "46"
	)
	static void method1848(boolean var0) {
		byte var1 = 0;
		if (!class344.method6492()) {
			var1 = 12;
		} else if (IgnoreList.client.method1190() || IgnoreList.client.method1191()) {
			var1 = 10;
		}

		class139.method3101(var1);
		if (var0) {
			Login.Login_username = "";
			Login.Login_password = "";
			class347.field4201 = 0;
			class28.otp = "";
		}

		if (Login.Login_username == null || Login.Login_username.length() <= 0) {
			if (Player.clientPreferences.method2407() != null) {
				Login.Login_username = Player.clientPreferences.method2407();
				Client.Login_isUsernameRemembered = true;
			} else {
				Client.Login_isUsernameRemembered = false;
			}
		}

		class65.method2029();
	}

	@ObfuscatedName("lu")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-500016340"
	)
	static void method1850(int var0) {
		for (IntegerNode var1 = (IntegerNode)Client.widgetFlags.first(); var1 != null; var1 = (IntegerNode)Client.widgetFlags.next()) {
			if ((var1.key >> 48 & 65535L) == (long)var0) {
				var1.remove();
			}
		}

	}
}
