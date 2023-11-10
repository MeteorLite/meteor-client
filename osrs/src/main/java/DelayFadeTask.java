import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pt")
@Implements("DelayFadeTask")
public class DelayFadeTask extends SongTask {
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lbz;"
	)
	@Export("soundSystem")
	public static SoundSystem soundSystem;
	@ObfuscatedName("at")
	long field3748;
	@ObfuscatedName("ah")
	int field3747;

	@ObfuscatedSignature(
		descriptor = "(Lql;I)V"
	)
	public DelayFadeTask(SongTask var1, int var2) {
		super(var1);
		this.field3747 = var2;
		super.field3756 = "DelayFadeTask";
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-799935345"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		if (this.field3748 < (long)this.field3747) {
			++this.field3748;
			return false;
		} else {
			return true;
		}
	}

	@ObfuscatedName("nc")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-52"
	)
	@Export("FriendSystem_invalidateIgnoreds")
	static final void FriendSystem_invalidateIgnoreds() {
		Canvas.method87();
		if (class20.friendsChat != null) {
			class20.friendsChat.invalidateIgnoreds();
		}

	}
}