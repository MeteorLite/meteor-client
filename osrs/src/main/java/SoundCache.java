import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("SoundCache")
public class SoundCache {
	@ObfuscatedName("gy")
	@Export("playerUUIDLength")
	static int playerUUIDLength;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	@Export("soundEffectIndex")
	AbstractArchive soundEffectIndex;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	AbstractArchive field212;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ltw;"
	)
	NodeHashTable field214;

	@ObfuscatedSignature(
		descriptor = "(Lol;Lol;)V"
	)
	public SoundCache(AbstractArchive var1, AbstractArchive var2) {
		new NodeHashTable(256);
		this.field214 = new NodeHashTable(256);
		this.soundEffectIndex = var1;
		this.field212 = var2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II[II)Lbt;",
		garbageValue = "1933572054"
	)
	@Export("getSoundEffect0")
	RawSound getSoundEffect0(int var1, int var2, int[] var3) {
		long var4 = this.method241(var1, var2, false);
		class53 var6 = (class53)this.field214.get(var4);
		if (var6 != null) {
			return var6.method305();
		} else if (var3 != null && var3[0] <= 0) {
			return null;
		} else {
			SoundEffect var7 = SoundEffect.readSoundEffect(this.soundEffectIndex, var1, var2);
			if (var7 == null) {
				return null;
			} else {
				RawSound var8 = var7.toRawSound();
				this.field214.put(new class53(var8), var4);
				if (var3 != null) {
					var3[0] -= var8.samples.length;
				}

				return var8;
			}
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IIB)Lcg;",
		garbageValue = "1"
	)
	class53 method237(int var1, int var2) {
		long var3 = this.method241(var1, var2, true);
		class53 var5 = (class53)this.field214.get(var3);
		if (var5 != null) {
			return var5;
		} else {
			VorbisSample var6 = VorbisSample.readMusicSample(this.field212, var1, var2);
			if (var6 == null) {
				return new class53();
			} else {
				class53 var7 = new class53(var6);
				this.field214.put(var7, var3);
				return var7;
			}
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I[IB)Lbt;",
		garbageValue = "47"
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

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)Lcg;",
		garbageValue = "656232055"
	)
	public class53 method239(int var1) {
		if (this.field212.getGroupCount() == 1) {
			return this.method237(0, var1);
		} else if (this.field212.getGroupFileCount(var1) == 1) {
			return this.method237(var1, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(IS)Lbt;",
		garbageValue = "26403"
	)
	public RawSound method240(int var1) {
		return this.getSoundEffect(var1, (int[])null);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IIZI)J",
		garbageValue = "414633479"
	)
	long method241(int var1, int var2, boolean var3) {
		int var4 = var2 ^ (var1 << 4 & 65535 | var1 >> 12);
		var4 |= var1 << 16;
		return var3 ? (long)var4 ^ 4294967296L : (long)var4;
	}

	@ObfuscatedName("ma")
	@ObfuscatedSignature(
		descriptor = "([Lnn;II)V",
		garbageValue = "685108589"
	)
	@Export("drawModelComponents")
	static final void drawModelComponents(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null && var3.parentId == var1 && (!var3.isIf3 || !class11.isComponentHidden(var3))) {
				if (var3.type == 0) {
					if (!var3.isIf3 && class11.isComponentHidden(var3) && var3 != Interpreter.mousedOverWidgetIf1) {
						continue;
					}

					drawModelComponents(var0, var3.id);
					if (var3.children != null) {
						drawModelComponents(var3.children, var3.id);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						ClanChannel.method862(var4.group);
					}
				}

				if (var3.type == 6) {
					int var5;
					if (var3.sequenceId != -1 || var3.sequenceId2 != -1) {
						boolean var8 = WidgetDefinition.runCs1(var3);
						if (var8) {
							var5 = var3.sequenceId2;
						} else {
							var5 = var3.sequenceId;
						}

						if (var5 != -1) {
							SequenceDefinition var6 = DynamicObject.SequenceDefinition_get(var5);
							if (!var6.isCachedModelIdSet()) {
								for (var3.modelFrameCycle += Client.field460; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; class159.invalidateWidget(var3)) {
									var3.modelFrameCycle -= var6.frameLengths[var3.modelFrame];
									++var3.modelFrame;
									if (var3.modelFrame >= var6.frameIds.length) {
										var3.modelFrame -= var6.frameCount;
										if (var3.modelFrame < 0 || var3.modelFrame >= var6.frameIds.length) {
											var3.modelFrame = 0;
										}
									}
								}
							} else {
								var3.modelFrame += Client.field460;
								int var7 = var6.method1052();
								if (var3.modelFrame >= var7) {
									var3.modelFrame -= var6.frameCount;
									if (var3.modelFrame < 0 || var3.modelFrame >= var7) {
										var3.modelFrame = 0;
									}
								}

								class159.invalidateWidget(var3);
							}
						}
					}

					if (var3.rotationKey != 0 && !var3.isIf3) {
						int var9 = var3.rotationKey >> 16;
						var5 = var3.rotationKey << 16 >> 16;
						var9 *= Client.field460;
						var5 *= Client.field460;
						var3.modelAngleX = var9 + var3.modelAngleX & 2047;
						var3.modelAngleY = var5 + var3.modelAngleY & 2047;
						class159.invalidateWidget(var3);
					}
				}
			}
		}

	}
}