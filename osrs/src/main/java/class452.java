import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rv")
public class class452 {
	@ObfuscatedName("aw")
	float field3871;
	@ObfuscatedName("ay")
	float field3872;
	@ObfuscatedName("ar")
	float field3867;
	@ObfuscatedName("am")
	float field3864;
	@ObfuscatedName("as")
	float field3868;
	@ObfuscatedName("aj")
	float field3863;
	@ObfuscatedName("ag")
	float field3862;
	@ObfuscatedName("az")
	float field3873;
	@ObfuscatedName("av")
	float field3870;
	@ObfuscatedName("ap")
	float field3865;
	@ObfuscatedName("aq")
	float field3866;
	@ObfuscatedName("at")
	float field3869;

	static {
		new class452();
	}

	class452() {
		this.method2288();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-112"
	)
	void method2288() {
		this.field3869 = 0.0F;
		this.field3866 = 0.0F;
		this.field3865 = 0.0F;
		this.field3873 = 0.0F;
		this.field3862 = 0.0F;
		this.field3863 = 0.0F;
		this.field3864 = 0.0F;
		this.field3867 = 0.0F;
		this.field3872 = 0.0F;
		this.field3870 = 1.0F;
		this.field3868 = 1.0F;
		this.field3871 = 1.0F;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(FB)V",
		garbageValue = "116"
	)
	void method2289(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field3872;
		float var5 = this.field3868;
		float var6 = this.field3873;
		float var7 = this.field3866;
		this.field3872 = var2 * var4 - this.field3867 * var3;
		this.field3867 = this.field3867 * var2 + var4 * var3;
		this.field3868 = var5 * var2 - var3 * this.field3863;
		this.field3863 = this.field3863 * var2 + var3 * var5;
		this.field3873 = var6 * var2 - var3 * this.field3870;
		this.field3870 = var3 * var6 + var2 * this.field3870;
		this.field3866 = var2 * var7 - this.field3869 * var3;
		this.field3869 = this.field3869 * var2 + var3 * var7;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(FI)V",
		garbageValue = "851748256"
	)
	void method2290(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field3871;
		float var5 = this.field3864;
		float var6 = this.field3862;
		float var7 = this.field3865;
		this.field3871 = var4 * var2 + this.field3867 * var3;
		this.field3867 = var2 * this.field3867 - var3 * var4;
		this.field3864 = var2 * var5 + this.field3863 * var3;
		this.field3863 = this.field3863 * var2 - var5 * var3;
		this.field3862 = this.field3870 * var3 + var2 * var6;
		this.field3870 = var2 * this.field3870 - var3 * var6;
		this.field3865 = var3 * this.field3869 + var7 * var2;
		this.field3869 = var2 * this.field3869 - var3 * var7;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(FI)V",
		garbageValue = "415453075"
	)
	void method2291(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field3871;
		float var5 = this.field3864;
		float var6 = this.field3862;
		float var7 = this.field3865;
		this.field3871 = var4 * var2 - this.field3872 * var3;
		this.field3872 = var4 * var3 + var2 * this.field3872;
		this.field3864 = var2 * var5 - this.field3868 * var3;
		this.field3868 = this.field3868 * var2 + var5 * var3;
		this.field3862 = var2 * var6 - this.field3873 * var3;
		this.field3873 = var3 * var6 + var2 * this.field3873;
		this.field3865 = var2 * var7 - this.field3866 * var3;
		this.field3866 = var3 * var7 + var2 * this.field3866;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(FFFI)V",
		garbageValue = "-1893116772"
	)
	void method2292(float var1, float var2, float var3) {
		this.field3865 += var1;
		this.field3866 += var2;
		this.field3869 += var3;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field3871 + "," + this.field3864 + "," + this.field3862 + "," + this.field3865 + "\n" + this.field3872 + "," + this.field3868 + "," + this.field3873 + "," + this.field3866 + "\n" + this.field3867 + "," + this.field3863 + "," + this.field3870 + "," + this.field3869;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(IIIIS)V",
		garbageValue = "128"
	)
	public static void someMusicMethod(int var0, int var1, int var2, int var3) {
		if (class306.musicSongs.size() > 1 && class306.musicSongs.get(0) != null && ((MusicSong)class306.musicSongs.get(0)).midiPcmStream.isReady() && class306.musicSongs.get(1) != null && ((MusicSong)class306.musicSongs.get(1)).midiPcmStream.isReady()) {
			ArchiveLoader.method464(var0, var1, var2, var3);
			class306.field2760.add(new SwapSongTask((SongTask)null));
			ArrayList var4 = new ArrayList();
			var4.add(new DelayFadeTask(new FadeInTask((SongTask)null, 1, false, class306.field2751), class306.field2754));
			var4.add(new DelayFadeTask(new FadeOutTask((SongTask)null, 0, false, class306.field2753), class306.musicPlayerStatus));
			class306.field2760.add(new ConcurrentMidiTask((SongTask)null, var4));
			if (class306.field2755.get(0) != null && class306.field2755.get(1) != null) {
				MusicSong var5 = (MusicSong)class306.field2755.get(0);
				class306.field2755.set(0, class306.musicSongs.get(1));
				class306.field2755.set(1, var5);
			}
		}

	}
}
