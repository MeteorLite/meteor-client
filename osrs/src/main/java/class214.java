import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ObfuscatedName("im")
public class class214 extends DualNode {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	@Export("archive4")
	static EvictingDualNodeHashTable archive4;

	static {
		archive4 = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IB)Liy;",
		garbageValue = "-114"
	)
	@Export("ItemDefinition_get")
	public static ItemComposition ItemDefinition_get(int var0) {
		ItemComposition var1 = (ItemComposition)ItemComposition.ItemDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class317.ItemDefinition_archive.takeFile(10, var0);
			var1 = new ItemComposition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.post();
			if (var1.noteTemplate != -1) {
				var1.genCert(ItemDefinition_get(var1.noteTemplate), ItemDefinition_get(var1.note));
			}

			if (var1.notedId != -1) {
				var1.genBought(ItemDefinition_get(var1.notedId), ItemDefinition_get(var1.unnotedId));
			}

			if (var1.placeholderTemplate != -1) {
				var1.genPlaceholder(ItemDefinition_get(var1.placeholderTemplate), ItemDefinition_get(var1.placeholder));
			}

			if (!HealthBarUpdate.ItemDefinition_inMembersWorld && var1.isMembersOnly) {
				if (var1.noteTemplate == -1 && var1.notedId == -1 && var1.placeholderTemplate == -1) {
					var1.name = var1.name + " (Members)";
				}

				var1.isTradable = false;

				int var3;
				for (var3 = 0; var3 < var1.groundActions.length; ++var3) {
					var1.groundActions[var3] = null;
				}

				for (var3 = 0; var3 < var1.inventoryActions.length; ++var3) {
					if (var3 != 4) {
						var1.inventoryActions[var3] = null;
					}
				}

				var1.shiftClickIndex = -2;
				var1.team = 0;
				if (var1.params != null) {
					boolean var6 = false;

					for (Node var4 = var1.params.first(); var4 != null; var4 = var1.params.next()) {
						ParamComposition var5 = class180.getParamDefinition((int)var4.key);
						if (var5.autoDisable) {
							var4.remove();
						} else {
							var6 = true;
						}
					}

					if (!var6) {
						var1.params = null;
					}
				}
			}

			ItemComposition.ItemDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(IB)Lfk;",
		garbageValue = "-119"
	)
	static class139 method1051(int var0) {
		class139 var3 = (class139)SequenceDefinition.SequenceDefinition_cachedModel.get((long)var0);
		class139 var2;
		class139 var4;
		AbstractArchive var5;
		AbstractArchive var6;
		boolean var7;
		byte[] var8;
		int var9;
		byte[] var10;
		if (var3 != null) {
			var2 = var3;
		} else {
			var5 = SequenceDefinition.SequenceDefinition_animationsArchive;
			var6 = SequenceDefinition.SequenceDefinition_skeletonsArchive;
			var7 = true;
			var8 = var5.getFile(var0 >> 16 & 65535, var0 & 65535);
			if (var8 == null) {
				var7 = false;
				var4 = null;
			} else {
				var9 = (var8[1] & 255) << 8 | var8[2] & 255;
				var10 = var6.getFile(var9, 0);
				if (var10 == null) {
					var7 = false;
				}

				if (!var7) {
					var4 = null;
				} else {
					if (SoundCache.field214 == null) {
						MusicPatchPcmStream.field2855 = Runtime.getRuntime().availableProcessors();
						SoundCache.field214 = new ThreadPoolExecutor(0, MusicPatchPcmStream.field2855, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(MusicPatchPcmStream.field2855 * 100 + 100), new class186());
					}

					try {
						var4 = new class139(var5, var6, var0, false);
					} catch (Exception var13) {
						var4 = null;
					}
				}
			}

			if (var4 != null) {
				SequenceDefinition.SequenceDefinition_cachedModel.put(var4, (long)var0);
			}

			var2 = var4;
		}

		int var1;
		if (var2 == null) {
			var1 = 2;
		} else {
			var1 = var2.method738() ? 0 : 1;
		}

		if (var1 != 0) {
			return null;
		} else {
			var3 = (class139)SequenceDefinition.SequenceDefinition_cachedModel.get((long)var0);
			if (var3 != null) {
				var2 = var3;
			} else {
				var5 = SequenceDefinition.SequenceDefinition_animationsArchive;
				var6 = SequenceDefinition.SequenceDefinition_skeletonsArchive;
				var7 = true;
				var8 = var5.getFile(var0 >> 16 & 65535, var0 & 65535);
				if (var8 == null) {
					var7 = false;
					var4 = null;
				} else {
					var9 = (var8[1] & 255) << 8 | var8[2] & 255;
					var10 = var6.getFile(var9, 0);
					if (var10 == null) {
						var7 = false;
					}

					if (!var7) {
						var4 = null;
					} else {
						if (SoundCache.field214 == null) {
							MusicPatchPcmStream.field2855 = Runtime.getRuntime().availableProcessors();
							SoundCache.field214 = new ThreadPoolExecutor(0, MusicPatchPcmStream.field2855, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(MusicPatchPcmStream.field2855 * 100 + 100), new class216());
						}

						try {
							var4 = new class139(var5, var6, var0, false);
						} catch (Exception var12) {
							var4 = null;
						}
					}
				}

				if (var4 != null) {
					SequenceDefinition.SequenceDefinition_cachedModel.put(var4, (long)var0);
				}

				var2 = var4;
			}

			return var2;
		}
	}

	@ObfuscatedName("hx")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2124568966"
	)
	static final void method1052() {
		UserComparator10.method682();
		SoundSystem.method226();
		class517.method2526();
		class74.method425();
		PlayerType.method1912();
		EnumComposition.EnumDefinition_cached.clear();
		FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
		FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
		HealthBarDefinition.HealthBarDefinition_cached.clear();
		HealthBarDefinition.ItemDefinition_cachedModels.clear();
		HitSplatDefinition.HitSplatDefinition_cached.clear();
		HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
		HitSplatDefinition.field1697.clear();
		MouseHandler.method173();
		KitDefinition.KitDefinition_cached.clear();
		ObjTypeCustomisation.method947();
		MusicPatchPcmStream.method1725();
		class33.method135();
		class141.method749();
		class20.method75();
		class315.method1655();
		class20.method74();
		SequenceDefinition.SequenceDefinition_cached.clear();
		SequenceDefinition.SequenceDefinition_cachedFrames.clear();
		SequenceDefinition.SequenceDefinition_cachedModel.clear();
		class198.method992();
		Actor.method511();
		UserComparator3.method676();
		HealthBarDefinition.Widget_cachedModels.method2516();
		class53.Widget_cachedFonts.method2516();
		class206.Widget_cachedSpriteMasks.clear();
		class208.field1648.clear();
		class154.method802();
		class193.archive5.clear();
		class188.field1492.clear();
		Language.method2002();
		KeyHandler.method95();
		UserComparator10.method684();
		UserComparator9.method678();
		Client.Widget_cachedModels.clear();
		Client.archive11.clear();
		PlayerComposition.PlayerAppearance_cachedModels.clear();
		PlayerComposition.field2939.clearFiles();
		PlayerComposition.field2937 = 0;
		class33.widgetDefinition.method1744();
		((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).clear();
		Script.Script_cached.clear();
		Client.field631.clearFiles();
		class92.field888.method1950();
		class199.field1567.method1950();
		class190.archive10.method1950();
		SongTask.archive12.method1950();
		SoundSystem.archive2.method1950();
		class313.field2770.method1950();
		WorldMapDecorationType.field3154.method1950();
		class27.archive13.method1950();
		AbstractByteArrayCopier.field3136.method1950();
		class319.field2799.method1950();
		class469.field3930.method1950();
		Language.field3643.method1950();
		class198.archive9.method1950();
		CollisionMap.archive6.method1950();
		GrandExchangeOfferOwnWorldComparator.field361.method1950();
		class317.field2776.method1950();
		class199.archive8.method1950();
		class241.field2052.method1950();
		ArchiveDiskAction.field3538.method1950();
		HorizontalAlignment.field1584.method1950();
		class358.field3177.method1950();
		AABB.field2123.method1950();
	}
}