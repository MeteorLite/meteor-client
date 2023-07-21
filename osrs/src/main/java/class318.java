import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mj")
public class class318 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	public AbstractArchive field2859;
	@ObfuscatedName("ay")
	public int field2856;
	@ObfuscatedName("ar")
	public int field2855;
	@ObfuscatedName("am")
	public int field2854;
	@ObfuscatedName("as")
	public float field2853;
	@ObfuscatedName("aj")
	public boolean field2850;
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
	public MidiPcmStream field2857;
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
	public class318(AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		this.field2856 = -1;
		this.field2855 = -1;
		this.field2854 = 0;
		this.field2853 = 0.0F;
		this.field2850 = false;
		this.field2851 = false;
		this.method1664(var1, var2, var3, var4, var5);
	}

	@ObfuscatedSignature(
		descriptor = "(Lnd;Ljava/lang/String;Ljava/lang/String;IZ)V"
	)
	public class318(AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
		this.field2856 = -1;
		this.field2855 = -1;
		this.field2854 = 0;
		this.field2853 = 0.0F;
		this.field2850 = false;
		this.field2851 = false;
		this.field2856 = var1.getGroupId(var2);
		this.field2855 = var1.getFileId(this.field2856, var3);
		this.method1664(var1, this.field2856, this.field2855, var4, var5);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lnd;IIIZB)V",
		garbageValue = "10"
	)
	void method1664(AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
		this.field2859 = var1;
		this.field2856 = var2;
		this.field2855 = var3;
		this.field2854 = var4;
		this.field2850 = var5;
	}
}
