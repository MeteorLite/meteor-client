import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rn")
public abstract class class456 extends class282 implements class521 {
	@ObfuscatedName("kj")
	@Export("cameraYaw")
	static int cameraYaw;

	@ObfuscatedSignature(
		descriptor = "(Lnu;Lot;I)V"
	)
	protected class456(StudioGame var1, Language var2, int var3) {
		super(var1, var2, var3);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Lrc;",
		garbageValue = "-1481639468"
	)
	@Export("vmethod8207")
	protected abstract class458 vmethod8207(int var1);

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1877372338"
	)
	public int method2298() {
		return super.field2464;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/Object;",
		garbageValue = "-692946397"
	)
	@Export("vmethod8697")
	public Object vmethod8697(int var1) {
		class458 var2 = this.vmethod8207(var1);
		return var2 != null && var2.method2305() ? var2.method2306() : null;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lty;I)Luh;",
		garbageValue = "-297164320"
	)
	public class522 method2300(Buffer var1) {
		int var2 = var1.readUnsignedShort();
		class458 var3 = this.vmethod8207(var2);
		class522 var4 = new class522(var2);
		Class var5 = var3.field3888.field4095;
		if (var5 == Integer.class) {
			var4.field4169 = var1.readInt();
		} else if (var5 == Long.class) {
			var4.field4169 = var1.readLong();
		} else if (var5 == String.class) {
			var4.field4169 = var1.readStringCp1252NullCircumfixed();
		} else {
			if (!class517.class.isAssignableFrom(var5)) {
				throw new IllegalStateException();
			}

			try {
				class517 var6 = (class517)var5.newInstance();
				var6.method2595(var1);
				var4.field4169 = var6;
			} catch (InstantiationException var7) {
			} catch (IllegalAccessException var8) {
			}
		}

		return var4;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)V",
		garbageValue = "-32"
	)
	static void method2301(int var0, int var1, int var2, int var3) {
		for (ObjectSound var4 = (ObjectSound)ObjectSound.objectSounds.last(); var4 != null; var4 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var4.soundEffectId != -1 || var4.soundEffectIds != null) {
				int var5 = 0;
				if (var1 > var4.maxX) {
					var5 += var1 - var4.maxX;
				} else if (var1 < var4.x) {
					var5 += var4.x - var1;
				}

				if (var2 > var4.maxY) {
					var5 += var2 - var4.maxY;
				} else if (var2 < var4.y) {
					var5 += var4.y - var2;
				}

				if (var5 - 64 <= var4.field687 && class150.clientPreferences.getAreaSoundEffectsVolume() != 0 && var0 == var4.plane) {
					var5 -= 64;
					if (var5 < 0) {
						var5 = 0;
					}

					int var6 = (var4.field687 - var5) * class150.clientPreferences.getAreaSoundEffectsVolume() / var4.field687;
					if (var4.stream1 == null) {
						if (var4.soundEffectId >= 0) {
							SoundEffect var7 = SoundEffect.readSoundEffect(class149.field1340, var4.soundEffectId, 0);
							if (var7 != null) {
								RawSound var8 = var7.toRawSound().resample(SoundCache.decimator);
								RawPcmStream var9 = RawPcmStream.createRawPcmStream(var8, 100, var6);
								var9.setNumLoops(-1);
								SecureRandomCallable.pcmStreamMixer.addSubStream(var9);
								var4.stream1 = var9;
							}
						}
					} else {
						var4.stream1.method243(var6);
					}

					if (var4.stream2 == null) {
						if (var4.soundEffectIds != null && (var4.field688 -= var3) <= 0) {
							int var11 = (int)(Math.random() * (double)var4.soundEffectIds.length);
							SoundEffect var12 = SoundEffect.readSoundEffect(class149.field1340, var4.soundEffectIds[var11], 0);
							if (var12 != null) {
								RawSound var13 = var12.toRawSound().resample(SoundCache.decimator);
								RawPcmStream var10 = RawPcmStream.createRawPcmStream(var13, 100, var6);
								var10.setNumLoops(0);
								SecureRandomCallable.pcmStreamMixer.addSubStream(var10);
								var4.stream2 = var10;
								var4.field688 = var4.field691 + (int)(Math.random() * (double)(var4.field692 - var4.field691));
							}
						}
					} else {
						var4.stream2.method243(var6);
						if (!var4.stream2.hasNext()) {
							var4.stream2 = null;
						}
					}
				} else {
					if (var4.stream1 != null) {
						SecureRandomCallable.pcmStreamMixer.removeSubStream(var4.stream1);
						var4.stream1 = null;
					}

					if (var4.stream2 != null) {
						SecureRandomCallable.pcmStreamMixer.removeSubStream(var4.stream2);
						var4.stream2 = null;
					}
				}
			}
		}

	}
}
