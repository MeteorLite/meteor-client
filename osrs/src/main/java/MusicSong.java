import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mv")
@Implements("MusicSong")
public class MusicSong {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	@Export("musicTrackArchive")
	public AbstractArchive musicTrackArchive;
	@ObfuscatedName("al")
	@Export("musicTrackGroupId")
	public int musicTrackGroupId;
	@ObfuscatedName("ak")
	@Export("musicTrackFileId")
	public int musicTrackFileId;
	@ObfuscatedName("ax")
	@Export("musicTrackVolume")
	public int musicTrackVolume;
	@ObfuscatedName("ao")
	public float field2888;
	@ObfuscatedName("ah")
	@Export("musicTrackBoolean")
	public boolean musicTrackBoolean;
	@ObfuscatedName("ar")
	public boolean field2887;
	@ObfuscatedName("ab")
	public boolean field2884;
	@ObfuscatedName("am")
	public boolean field2886;
	@ObfuscatedName("av")
	boolean field2882;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	@Export("midiPcmStream")
	public MidiPcmStream midiPcmStream;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lbl;"
	)
	public SoundCache field2883;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lmk;"
	)
	public MusicTrack field2892;

	@ObfuscatedSignature(
		descriptor = "(Lom;IIIZ)V"
	)
	public MusicSong(AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		this.musicTrackGroupId = -1;
		this.musicTrackFileId = -1;
		this.musicTrackVolume = 0;
		this.field2888 = 0.0F;
		this.musicTrackBoolean = false;
		this.field2886 = false;
		this.field2882 = false;
		this.method1731(var1, var2, var3, var4, var5);
	}

	@ObfuscatedSignature(
		descriptor = "(Lom;Ljava/lang/String;Ljava/lang/String;IZ)V"
	)
	public MusicSong(AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
		this.musicTrackGroupId = -1;
		this.musicTrackFileId = -1;
		this.musicTrackVolume = 0;
		this.field2888 = 0.0F;
		this.musicTrackBoolean = false;
		this.field2886 = false;
		this.field2882 = false;
		this.musicTrackGroupId = var1.getGroupId(var2);
		this.musicTrackFileId = var1.getFileId(this.musicTrackGroupId, var3);
		this.method1731(var1, this.musicTrackGroupId, this.musicTrackFileId, var4, var5);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lom;IIIZB)V",
		garbageValue = "-90"
	)
	void method1731(AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		this.musicTrackArchive = var1;
		this.musicTrackGroupId = var2;
		this.musicTrackFileId = var3;
		this.musicTrackVolume = var4;
		this.musicTrackBoolean = var5;
	}

	@ObfuscatedName("hk")
	@ObfuscatedSignature(
		descriptor = "(Lok;Ljava/lang/String;B)V",
		garbageValue = "-43"
	)
	static void method1732(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field551 += var2.groupCount;
	}
}