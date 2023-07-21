import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public enum class89 implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Ldd;"
	)
	field882(0, -1),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Ldd;"
	)
	field883(1, 1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ldd;"
	)
	field880(2, 7),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Ldd;"
	)
	field879(3, 8),
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Ldd;"
	)
	field881(4, 9);

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lgh;"
	)
	static ClanChannel field878;
	@ObfuscatedName("aj")
	final int field885;
	@ObfuscatedName("ag")
	final int field884;

	class89(int var3, int var4) {
		this.field885 = var3;
		this.field884 = var4;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field884;
	}

	@ObfuscatedName("iq")
	@ObfuscatedSignature(
		descriptor = "(IIIB)V",
		garbageValue = "0"
	)
	static final void method482(int var0, int var1, int var2) {
		if (class157.cameraX < var0) {
			class157.cameraX = (var0 - class157.cameraX) * SecureRandomFuture.field803 / 1000 + class157.cameraX + Client.field538;
			if (class157.cameraX > var0) {
				class157.cameraX = var0;
			}
		}

		if (class157.cameraX > var0) {
			class157.cameraX -= (class157.cameraX - var0) * SecureRandomFuture.field803 / 1000 + Client.field538;
			if (class157.cameraX < var0) {
				class157.cameraX = var0;
			}
		}

		if (class384.cameraY < var1) {
			class384.cameraY = (var1 - class384.cameraY) * SecureRandomFuture.field803 / 1000 + class384.cameraY + Client.field538;
			if (class384.cameraY > var1) {
				class384.cameraY = var1;
			}
		}

		if (class384.cameraY > var1) {
			class384.cameraY -= (class384.cameraY - var1) * SecureRandomFuture.field803 / 1000 + Client.field538;
			if (class384.cameraY < var1) {
				class384.cameraY = var1;
			}
		}

		if (SoundSystem.cameraZ < var2) {
			SoundSystem.cameraZ = (var2 - SoundSystem.cameraZ) * SecureRandomFuture.field803 / 1000 + SoundSystem.cameraZ + Client.field538;
			if (SoundSystem.cameraZ > var2) {
				SoundSystem.cameraZ = var2;
			}
		}

		if (SoundSystem.cameraZ > var2) {
			SoundSystem.cameraZ -= (SoundSystem.cameraZ - var2) * SecureRandomFuture.field803 / 1000 + Client.field538;
			if (SoundSystem.cameraZ < var2) {
				SoundSystem.cameraZ = var2;
			}
		}

	}

	@ObfuscatedName("it")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2092495072"
	)
	static void method483() {
		if (Client.field382) {
			GrandExchangeOfferNameComparator.addPlayerToScene(class136.localPlayer, false);
		}

	}

	@ObfuscatedName("kq")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1018323278"
	)
	@Export("addCancelMenuEntry")
	static void addCancelMenuEntry() {
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
		Client.menuActions[0] = "Cancel";
		Client.menuTargets[0] = "";
		Client.menuOpcodes[0] = 1006;
		Client.menuShiftClick[0] = false;
		Client.menuOptionsCount = 1;
	}
}
