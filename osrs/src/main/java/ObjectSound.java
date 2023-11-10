import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("ObjectSound")
public final class ObjectSound extends Node {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	@Export("objectSounds")
	static NodeDeque objectSounds;
	@ObfuscatedName("ah")
	@Export("plane")
	int plane;
	@ObfuscatedName("ar")
	@Export("x")
	int x;
	@ObfuscatedName("ao")
	@Export("y")
	int y;
	@ObfuscatedName("ab")
	@Export("maxX")
	int maxX;
	@ObfuscatedName("au")
	@Export("maxY")
	int maxY;
	@ObfuscatedName("aa")
	int field691;
	@ObfuscatedName("ac")
	@Export("soundEffectId")
	int soundEffectId;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lbb;"
	)
	@Export("stream1")
	RawPcmStream stream1;
	@ObfuscatedName("az")
	int field700;
	@ObfuscatedName("ap")
	int field696;
	@ObfuscatedName("av")
	@Export("soundEffectIds")
	int[] soundEffectIds;
	@ObfuscatedName("ax")
	int field699;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lbb;"
	)
	@Export("stream2")
	RawPcmStream stream2;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lhs;"
	)
	@Export("obj")
	ObjectComposition obj;

	static {
		objectSounds = new NodeDeque();
	}

	ObjectSound() {
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "12079465"
	)
	@Export("set")
	void set() {
		int var1 = this.soundEffectId;
		ObjectComposition var2 = this.obj.transform();
		if (var2 != null) {
			this.soundEffectId = var2.ambientSoundId;
			this.field691 = var2.int7 * 128;
			this.field700 = var2.int5;
			this.field696 = var2.int6;
			this.soundEffectIds = var2.soundEffectIds;
		} else {
			this.soundEffectId = -1;
			this.field691 = 0;
			this.field700 = 0;
			this.field696 = 0;
			this.soundEffectIds = null;
		}

		if (var1 != this.soundEffectId && this.stream1 != null) {
			LoginScreenAnimation.pcmStreamMixer.removeSubStream(this.stream1);
			this.stream1 = null;
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-737174701"
	)
	static int method423(int var0, int var1) {
		for (int var2 = 0; var2 < 8; ++var2) {
			if (var1 <= var0 + 30) {
				return var2;
			}

			var0 += 30;
			var0 += var2 != 1 && var2 != 3 ? 5 : 20;
		}

		return 0;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZB)I",
		garbageValue = "2"
	)
	static int method425(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 4200) {
			var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = class214.ItemDefinition_get(var3).name;
			return 1;
		} else {
			int var4;
			ItemComposition var5;
			if (var0 == 4201) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				var5 = class214.ItemDefinition_get(var3);
				if (var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var5.groundActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == 4202) {
				DbTableType.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				var5 = class214.ItemDefinition_get(var3);
				if (var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var5.inventoryActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == 4203) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class214.ItemDefinition_get(var3).price;
				return 1;
			} else if (var0 == 4204) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class214.ItemDefinition_get(var3).isStackable == 1 ? 1 : 0;
				return 1;
			} else {
				ItemComposition var6;
				if (var0 == 4205) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					var6 = class214.ItemDefinition_get(var3);
					if (var6.noteTemplate == -1 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == 4206) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					var6 = class214.ItemDefinition_get(var3);
					if (var6.noteTemplate >= 0 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == 4207) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class214.ItemDefinition_get(var3).isMembersOnly ? 1 : 0;
					return 1;
				} else if (var0 == 4208) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					var6 = class214.ItemDefinition_get(var3);
					if (var6.placeholderTemplate == -1 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == 4209) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					var6 = class214.ItemDefinition_get(var3);
					if (var6.placeholderTemplate >= 0 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == 4210) {
					String var7 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					UrlRequest.findItemDefinitions(var7, var4 == 1);
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = BuddyRankComparator.foundItemIdCount;
					return 1;
				} else if (var0 != 4211) {
					if (var0 == 4212) {
						ApproximateRouteStrategy.foundItemIndex = 0;
						return 1;
					} else if (var0 == 4213) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var4 = class214.ItemDefinition_get(var3).getShiftClickIndex();
						if (var4 == -1) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4;
						} else {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var4 + 1;
						}

						return 1;
					} else if (var0 == 4214) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class214.ItemDefinition_get(var3).maleModel;
						return 1;
					} else if (var0 == 4215) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class214.ItemDefinition_get(var3).maleModel1;
						return 1;
					} else if (var0 == 4216) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class214.ItemDefinition_get(var3).maleModel2;
						return 1;
					} else if (var0 == 4217) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var6 = class214.ItemDefinition_get(var3);
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var6.field1763;
						return 1;
					} else {
						return 2;
					}
				} else {
					if (MusicPatchNode.foundItemIds != null && ApproximateRouteStrategy.foundItemIndex < BuddyRankComparator.foundItemIdCount) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = MusicPatchNode.foundItemIds[++ApproximateRouteStrategy.foundItemIndex - 1] & '\uffff';
					} else {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("hv")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-16844"
	)
	static final void method424() {
		class72.method431();
		class184.field1515.clear();
		InvDefinition.method877();
		KitDefinition.method907();
		DbTableType.DBTableType_cache.clear();
		EnumComposition.EnumDefinition_cached.clear();
		class138.method737();
		class172.method883();
		AttackOption.method606();
		Client.method360();
		class145.method764();
		HitSplatDefinition.method994();
		InvDefinition.InvDefinition_cached.clear();
		class267.method1444();
		WorldMapElement.HitSplatDefinition_cached2.clear();
		class185.field1516.clear();
		InterfaceParent.method464();
		ItemComposition.ItemDefinition_cached.clear();
		ItemComposition.HealthBarDefinition_cachedSprites.clear();
		ItemComposition.ItemDefinition_cachedSprites.clear();
		ModeWhere.method2001();
		SequenceDefinition.SequenceDefinition_cached.clear();
		SequenceDefinition.SequenceDefinition_cachedFrames.clear();
		SequenceDefinition.SequenceDefinition_cachedModel.clear();
		SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
		SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
		WorldMapElement.method893();
		class252.method1337();
		class399.Widget_cachedModels.method2493();
		Players.Widget_cachedFonts.method2493();
		class189.Widget_cachedSpriteMasks.clear();
		class191.field1584.clear();
		VarcInt.VarcInt_cached.clear();
		VarcInt.method900();
		class171.field1438.clear();
		class208.method1062();
		class197.archive4.clear();
		LoginPacket.method1643();
		class195.field1619.clear();
		Client.Widget_cachedModels.clear();
		Client.archive11.clear();
		RouteStrategy.method1150();
		HealthBarDefinition.widgetDefinition.method1737();
		((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).clear();
		Canvas.method89();
		Client.field631.clearFiles();
		UserComparator7.field1190.method1943();
		class145.field1338.method1943();
		WorldMapDecorationType.archive10.method1943();
		class47.archive12.method1943();
		class344.archive2.method1943();
		class267.field2224.method1943();
		SoundSystem.field209.method1943();
		VarbitComposition.archive13.method1943();
		class313.archive4.method1943();
		WorldMapAreaData.field2099.method1943();
		Language.field3643.method1943();
		PcmPlayer.field181.method1943();
		WorldMapSection0.archive9.method1943();
		class514.archive6.method1943();
		class19.field59.method1943();
		class7.field12.method1943();
		GrandExchangeOfferOwnWorldComparator.archive8.method1943();
		Canvas.field68.method1943();
		StructComposition.field1637.method1943();
		WorldMapData_0.field1938.method1943();
		BuddyRankComparator.field1200.method1943();
		SpotAnimationDefinition.field1597.method1943();
	}
}