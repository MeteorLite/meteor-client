import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("DevicePcmPlayerProvider")
public class DevicePcmPlayerProvider implements class47 {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "[Lqu;"
	)
	@Export("runesSprite")
	static IndexedSprite[] runesSprite;
	@ObfuscatedName("ei")
	@ObfuscatedSignature(
		descriptor = "Llb;"
	)
	@Export("archive5")
	static Archive archive5;
	@ObfuscatedName("ks")
	@ObfuscatedSignature(
		descriptor = "Lkw;"
	)
	static Widget field153;

	DevicePcmPlayerProvider() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)Lad;",
		garbageValue = "1345592536"
	)
	@Export("player")
	public PcmPlayer player() {
		return new DevicePcmPlayer();
	}

	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "14639"
	)
	@Export("forceDisconnect")
	static final void forceDisconnect(int var0) {
		ApproximateRouteStrategy.logOut();
		switch(var0) {
		case 1:
			class7.method68();
			break;
		case 2:
			class139.method3101(24);
			SecureRandomCallable.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
		}

	}
}
