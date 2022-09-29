import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("od")
public class class390 {
	@ObfuscatedName("c")
	float field4448;
	@ObfuscatedName("p")
	float field4452;
	@ObfuscatedName("f")
	float field4444;
	@ObfuscatedName("n")
	float field4450;
	@ObfuscatedName("k")
	float field4446;
	@ObfuscatedName("w")
	float field4447;
	@ObfuscatedName("s")
	float field4442;
	@ObfuscatedName("q")
	float field4449;
	@ObfuscatedName("m")
	float field4443;
	@ObfuscatedName("x")
	float field4451;
	@ObfuscatedName("j")
	float field4445;
	@ObfuscatedName("v")
	float field4453;

	static {
		new class390();
	}

	class390() {
		this.method7233();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1328551408"
	)
	void method7233() {
		this.field4453 = 0.0F;
		this.field4445 = 0.0F;
		this.field4451 = 0.0F;
		this.field4449 = 0.0F;
		this.field4442 = 0.0F;
		this.field4447 = 0.0F;
		this.field4450 = 0.0F;
		this.field4444 = 0.0F;
		this.field4452 = 0.0F;
		this.field4443 = 1.0F;
		this.field4446 = 1.0F;
		this.field4448 = 1.0F;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(FI)V",
		garbageValue = "1596898937"
	)
	void method7240(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field4452;
		float var5 = this.field4446;
		float var6 = this.field4449;
		float var7 = this.field4445;
		this.field4452 = var4 * var2 - var3 * this.field4444;
		this.field4444 = this.field4444 * var2 + var3 * var4;
		this.field4446 = var2 * var5 - var3 * this.field4447;
		this.field4447 = var3 * var5 + var2 * this.field4447;
		this.field4449 = var6 * var2 - this.field4443 * var3;
		this.field4443 = var3 * var6 + var2 * this.field4443;
		this.field4445 = var2 * var7 - var3 * this.field4453;
		this.field4453 = var2 * this.field4453 + var3 * var7;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(FB)V",
		garbageValue = "5"
	)
	void method7235(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field4448;
		float var5 = this.field4450;
		float var6 = this.field4442;
		float var7 = this.field4451;
		this.field4448 = var3 * this.field4444 + var2 * var4;
		this.field4444 = this.field4444 * var2 - var3 * var4;
		this.field4450 = var2 * var5 + this.field4447 * var3;
		this.field4447 = var2 * this.field4447 - var5 * var3;
		this.field4442 = this.field4443 * var3 + var6 * var2;
		this.field4443 = var2 * this.field4443 - var6 * var3;
		this.field4451 = var7 * var2 + this.field4453 * var3;
		this.field4453 = var2 * this.field4453 - var3 * var7;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(FI)V",
		garbageValue = "2028361359"
	)
	void method7236(float var1) {
		float var2 = (float)Math.cos((double)var1);
		float var3 = (float)Math.sin((double)var1);
		float var4 = this.field4448;
		float var5 = this.field4450;
		float var6 = this.field4442;
		float var7 = this.field4451;
		this.field4448 = var2 * var4 - this.field4452 * var3;
		this.field4452 = var2 * this.field4452 + var3 * var4;
		this.field4450 = var5 * var2 - this.field4446 * var3;
		this.field4446 = var3 * var5 + this.field4446 * var2;
		this.field4442 = var2 * var6 - this.field4449 * var3;
		this.field4449 = var2 * this.field4449 + var3 * var6;
		this.field4451 = var7 * var2 - this.field4445 * var3;
		this.field4445 = var7 * var3 + this.field4445 * var2;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(FFFI)V",
		garbageValue = "-51199894"
	)
	void method7237(float var1, float var2, float var3) {
		this.field4451 += var1;
		this.field4445 += var2;
		this.field4453 += var3;
	}

	public String toString() {
		return this.field4448 + "," + this.field4450 + "," + this.field4442 + "," + this.field4451 + "\n" + this.field4452 + "," + this.field4446 + "," + this.field4449 + "," + this.field4445 + "\n" + this.field4444 + "," + this.field4447 + "," + this.field4443 + "," + this.field4453;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Llv;III)[Lqu;",
		garbageValue = "94464176"
	)
	public static IndexedSprite[] method7253(AbstractArchive var0, int var1, int var2) {
		return !Occluder.method4475(var0, var1, var2) ? null : GraphicsObject.method2018();
	}

	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-93"
	)
	static final void method7252() {
		for (int var0 = 0; var0 < Client.soundEffectCount; ++var0) {
			int var10002 = Client.queuedSoundEffectDelays[var0]--;
			if (Client.queuedSoundEffectDelays[var0] >= -10) {
				SoundEffect var1 = Client.soundEffects[var0];
				if (var1 == null) {
					Object var10000 = null;
					var1 = SoundEffect.readSoundEffect(UserComparator10.archive4, Client.soundEffectIds[var0], 0);
					if (var1 == null) {
						continue;
					}

					int[] var13 = Client.queuedSoundEffectDelays;
					var13[var0] += var1.calculateDelay();
					Client.soundEffects[var0] = var1;
				}

				if (Client.queuedSoundEffectDelays[var0] < 0) {
					int var2;
					if (Client.soundLocations[var0] != 0) {
						int var3 = (Client.soundLocations[var0] & 255) * 128;
						int var4 = Client.soundLocations[var0] >> 16 & 255;
						int var5 = var4 * 128 + 64 - class67.localPlayer.x;
						if (var5 < 0) {
							var5 = -var5;
						}

						int var6 = Client.soundLocations[var0] >> 8 & 255;
						int var7 = var6 * 128 + 64 - class67.localPlayer.y;
						if (var7 < 0) {
							var7 = -var7;
						}

						int var8 = var7 + var5 - 128;
						if (var8 > var3) {
							Client.queuedSoundEffectDelays[var0] = -100;
							continue;
						}

						if (var8 < 0) {
							var8 = 0;
						}

						var2 = (var3 - var8) * Player.clientPreferences.method2474() / var3;
					} else {
						var2 = Player.clientPreferences.method2385();
					}

					if (var2 > 0) {
						RawSound var9 = var1.toRawSound().resample(class327.decimator);
						RawPcmStream var10 = RawPcmStream.createRawPcmStream(var9, 100, var2);
						var10.setNumLoops(Client.queuedSoundEffectLoops[var0] - 1);
						class16.pcmStreamMixer.addSubStream(var10);
					}

					Client.queuedSoundEffectDelays[var0] = -100;
				}
			} else {
				--Client.soundEffectCount;

				for (int var11 = var0; var11 < Client.soundEffectCount; ++var11) {
					Client.soundEffectIds[var11] = Client.soundEffectIds[var11 + 1];
					Client.soundEffects[var11] = Client.soundEffects[var11 + 1];
					Client.queuedSoundEffectLoops[var11] = Client.queuedSoundEffectLoops[var11 + 1];
					Client.queuedSoundEffectDelays[var11] = Client.queuedSoundEffectDelays[var11 + 1];
					Client.soundLocations[var11] = Client.soundLocations[var11 + 1];
				}

				--var0;
			}
		}

		if (Client.playingJingle) {
			boolean var12;
			if (class274.musicPlayerStatus != 0) {
				var12 = true;
			} else {
				var12 = class139.midiPcmStream.isReady();
			}

			if (!var12) {
				if (Player.clientPreferences.method2402() != 0 && Client.currentTrackGroupId != -1) {
					Message.method1164(class14.archive6, Client.currentTrackGroupId, 0, Player.clientPreferences.method2402(), false);
				}

				Client.playingJingle = false;
			}
		}

	}
}
