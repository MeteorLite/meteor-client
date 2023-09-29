import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.ThreadPoolExecutor;

@ObfuscatedName("bl")
@Implements("SoundCache")
public class SoundCache {
	@ObfuscatedName("ab")
	public static ThreadPoolExecutor field214;
	@ObfuscatedName("jo")
	@ObfuscatedSignature(
		descriptor = "Lpu;"
	)
	@Export("fontBold12")
	static Font fontBold12;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	@Export("soundEffectIndex")
	AbstractArchive soundEffectIndex;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	AbstractArchive field217;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	NodeHashTable field218;

	@ObfuscatedSignature(
		descriptor = "(Lom;Lom;)V"
	)
	public SoundCache(AbstractArchive var1, AbstractArchive var2) {
		new NodeHashTable(256);
		this.field218 = new NodeHashTable(256);
		this.soundEffectIndex = var1;
		this.field217 = var2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II[II)Lbs;",
		garbageValue = "804068595"
	)
	@Export("getSoundEffect0")
	RawSound getSoundEffect0(int var1, int var2, int[] var3) {
		long var4 = this.method234(var1, var2, false);
		class53 var6 = (class53)this.field218.get(var4);
		if (var6 != null) {
			return var6.method300();
		} else if (var3 != null && var3[0] <= 0) {
			return null;
		} else {
			SoundEffect var7 = SoundEffect.readSoundEffect(this.soundEffectIndex, var1, var2);
			if (var7 == null) {
				return null;
			} else {
				RawSound var8 = var7.toRawSound();
				this.field218.put(new class53(var8), var4);
				if (var3 != null) {
					var3[0] -= var8.samples.length;
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(III)Lcu;",
		garbageValue = "941566921"
	)
	class53 method229(int var1, int var2) {
		long var3 = this.method234(var1, var2, true);
		class53 var5 = (class53)this.field218.get(var3);
		if (var5 != null) {
			return var5;
		} else {
			VorbisSample var6 = VorbisSample.readMusicSample(this.field217, var1, var2);
			if (var6 == null) {
				return new class53();
			} else {
				class53 var7 = new class53(var6);
				this.field218.put(var7, var3);
				return var7;
			}
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I[IB)Lbs;",
		garbageValue = "-23"
	)
	@Export("getSoundEffect")
	RawSound getSoundEffect(int var1, int[] var2) {
		if (this.soundEffectIndex.getGroupCount() == 1) {
			return this.getSoundEffect0(0, var1, var2);
		} else if (this.soundEffectIndex.getGroupFileCount(var1) == 1) {
			return this.getSoundEffect0(var1, 0, var2);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IB)Lcu;",
		garbageValue = "0"
	)
	public class53 method232(int var1) {
		if (this.field217.getGroupCount() == 1) {
			return this.method229(0, var1);
		} else if (this.field217.getGroupFileCount(var1) == 1) {
			return this.method229(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IS)Lbs;",
		garbageValue = "11636"
	)
	public RawSound method233(int var1) {
		return this.getSoundEffect(var1, (int[])null);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IIZI)J",
		garbageValue = "1435261523"
	)
	long method234(int var1, int var2, boolean var3) {
		int var4 = var2 ^ (var1 << 4 & 65535 | var1 >> 12);
		var4 |= var1 << 16;
		return var3 ? (long)var4 ^ 4294967296L : (long)var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "74"
	)
	static void method228() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var0.stream1 != null) {
				class140.pcmStreamMixer.removeSubStream(var0.stream1);
				var0.stream1 = null;
			}

			if (var0.stream2 != null) {
				class140.pcmStreamMixer.removeSubStream(var0.stream2);
				var0.stream2 = null;
			}
		}

		ObjectSound.objectSounds.clear();
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(III)Lcr;",
		garbageValue = "1668135160"
	)
	@Export("Messages_getByChannelAndID")
	static Message Messages_getByChannelAndID(int var0, int var1) {
		ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var2.getMessage(var1);
	}

	@ObfuscatedName("og")
	@ObfuscatedSignature(
		descriptor = "(IB)Luq;",
		garbageValue = "-5"
	)
	static class521 method235(int var0) {
		class521 var1 = (class521)Client.Widget_cachedModels.get((long)var0);
		if (var1 == null) {
			var1 = new class521(class313.field2770, AbstractArchive.method1931(var0), VarbitComposition.method1046(var0));
			Client.Widget_cachedModels.put(var1, (long)var0);
		}

		return var1;
	}
}