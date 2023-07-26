import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("MoveSpeed")
public enum MoveSpeed implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lio;"
	)
	@Export("STATIONARY")
	STATIONARY((byte)-1),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lio;"
	)
	@Export("CRAWL")
	CRAWL((byte)0),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lio;"
	)
	@Export("WALK")
	WALK((byte)1),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lio;"
	)
	@Export("RUN")
	RUN((byte)2);

	@ObfuscatedName("dn")
	@ObfuscatedSignature(
		descriptor = "[Luu;"
	)
	@Export("worldSelectStars")
	static IndexedSprite[] worldSelectStars;
	@ObfuscatedName("as")
	@Export("speed")
	public byte speed;

	MoveSpeed(byte var3) {
		this.speed = var3;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.speed;
	}
}
