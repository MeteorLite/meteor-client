import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mu")
@Implements("MusicSong")
public class MusicSong {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("musicTrackArchive")
	public AbstractArchive musicTrackArchive;
	@ObfuscatedName("ae")
	@Export("musicTrackGroupId")
	public int musicTrackGroupId;
	@ObfuscatedName("ao")
	@Export("musicTrackFileId")
	public int musicTrackFileId;
	@ObfuscatedName("at")
	@Export("musicTrackVolume")
	public int musicTrackVolume;
	@ObfuscatedName("ac")
	public float field2867;
	@ObfuscatedName("ai")
	@Export("musicTrackBoolean")
	public boolean musicTrackBoolean;
	@ObfuscatedName("az")
	public boolean field2866;
	@ObfuscatedName("ap")
	public boolean field2865;
	@ObfuscatedName("aa")
	public boolean field2862;
	@ObfuscatedName("af")
	public boolean field2863;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Llf;"
	)
	@Export("midiPcmStream")
	public MidiPcmStream midiPcmStream;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lbi;"
	)
	public SoundCache field2861;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lmv;"
	)
	public MusicTrack field2872;

	@ObfuscatedSignature(
		descriptor = "(Lnu;Ljava/lang/String;Ljava/lang/String;IZ)V"
	)
	public MusicSong(AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
		this.musicTrackGroupId = -1;
		this.musicTrackFileId = -1;
		this.musicTrackVolume = 0;
		this.field2867 = 0.0F;
		this.musicTrackBoolean = false;
		this.field2862 = false;
		this.field2863 = false;
		this.musicTrackGroupId = var1.getGroupId(var2);
		this.musicTrackFileId = var1.getFileId(this.musicTrackGroupId, var3);
		this.method1701(var1, this.musicTrackGroupId, this.musicTrackFileId, var4, var5);
	}

	@ObfuscatedSignature(
		descriptor = "(Lnu;IIIZ)V"
	)
	public MusicSong(AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		this.musicTrackGroupId = -1;
		this.musicTrackFileId = -1;
		this.musicTrackVolume = 0;
		this.field2867 = 0.0F;
		this.musicTrackBoolean = false;
		this.field2862 = false;
		this.field2863 = false;
		this.method1701(var1, var2, var3, var4, var5);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lnu;IIIZB)V",
		garbageValue = "28"
	)
	void method1701(AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		this.musicTrackArchive = var1;
		this.musicTrackGroupId = var2;
		this.musicTrackFileId = var3;
		this.musicTrackVolume = var4;
		this.musicTrackBoolean = var5;
	}

	@ObfuscatedName("hi")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-79"
	)
	@Export("updateGameState")
	static void updateGameState(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 30) {
				Client.field423.method1090();
			}

			if (Client.gameState == 0) {
				class219.client.method158();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45 || var0 == 50) {
				class316.method1700(0);
				Client.field448 = 0;
				Client.field447 = 0;
				Client.timer.method2152(var0);
				if (var0 != 20) {
					PendingSpawn.method509(false);
				}
			}

			if (var0 != 20 && var0 != 40 && AbstractSocket.field3819 != null) {
				AbstractSocket.field3819.close();
				AbstractSocket.field3819 = null;
			}

			if (Client.gameState == 25) {
				Client.field456 = 0;
				Client.field452 = 0;
				Client.field453 = 1;
				Client.field455 = 0;
				Client.field454 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					int var3 = Client.gameState == 11 ? 4 : 0;
					Timer.method2157(class141.archive10, PcmPlayer.archive8, false, var3);
				} else if (var0 == 11) {
					Timer.method2157(class141.archive10, PcmPlayer.archive8, false, 4);
				} else if (var0 == 50) {
					class318.setLoginResponseString("", "Updating date of birth...", "");
					Timer.method2157(class141.archive10, PcmPlayer.archive8, false, 7);
				} else if (class403.clearLoginScreen) {
					Login.titleboxSprite = null;
					class219.titlebuttonSprite = null;
					Login.runesSprite = null;
					Login.leftTitleSprite = null;
					Bounds.rightTitleSprite = null;
					SoundSystem.logoSprite = null;
					class13.title_muteSprite = null;
					Login.options_buttons_0Sprite = null;
					UserComparator6.options_buttons_2Sprite = null;
					class74.worldSelectBackSprites = null;
					SoundCache.worldSelectFlagSprites = null;
					MusicPatchPcmStream.worldSelectArrows = null;
					SecureRandomCallable.worldSelectStars = null;
					VarcInt.field1534 = null;
					class139.field1323.method528();
					Script.method445(0, 100);
					CollisionMap.method1122().method1932(true);
					class403.clearLoginScreen = false;
				}
			} else {
				boolean var1 = class449.clientPreferences.method564() >= Client.param21;
				int var2 = var1 ? 0 : 12;
				Timer.method2157(class141.archive10, PcmPlayer.archive8, true, var2);
			}

			Client.gameState = var0;
		}
	}
}