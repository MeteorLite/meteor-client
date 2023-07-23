import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mj")
public class MusicSong {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	public AbstractArchive musicTrackArchive;
	@ObfuscatedName("ay")
	public int musicTrackGroupId;
	@ObfuscatedName("ar")
	public int musicTrackFileId;
	@ObfuscatedName("am")
	public int musicTrackVolume;
	@ObfuscatedName("as")
	public float field2853;
	@ObfuscatedName("aj")
	public boolean musicTrackBoolean;
	@ObfuscatedName("ag")
	public boolean field2849;
	@ObfuscatedName("az")
	public boolean field2852;
	@ObfuscatedName("av")
	public boolean field2851;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Llc;"
	)
	public MidiPcmStream midiPcmStream;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lbh;"
	)
	public SoundCache field2848;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lmp;"
	)
	public MusicTrack field2858;

	@ObfuscatedSignature(
		descriptor = "(Lnd;IIIZ)V"
	)
	public MusicSong(AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		this.musicTrackGroupId = -1;
		this.musicTrackFileId = -1;
		this.musicTrackVolume = 0;
		this.field2853 = 0.0F;
		this.musicTrackBoolean = false;
		this.field2851 = false;
		this.method1664(var1, var2, var3, var4, var5);
	}

	@ObfuscatedSignature(
		descriptor = "(Lnd;Ljava/lang/String;Ljava/lang/String;IZ)V"
	)
	public MusicSong(AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
		this.musicTrackGroupId = -1;
		this.musicTrackFileId = -1;
		this.musicTrackVolume = 0;
		this.field2853 = 0.0F;
		this.musicTrackBoolean = false;
		this.field2851 = false;
		this.musicTrackGroupId = var1.getGroupId(var2);
		this.musicTrackFileId = var1.getFileId(this.musicTrackGroupId, var3);
		this.method1664(var1, this.musicTrackGroupId, this.musicTrackFileId, var4, var5);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lnd;IIIZB)V",
		garbageValue = "10"
	)
	void method1664(AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		this.musicTrackArchive = var1;
		this.musicTrackGroupId = var2;
		this.musicTrackFileId = var3;
		this.musicTrackVolume = var4;
		this.musicTrackBoolean = var5;
	}
}
