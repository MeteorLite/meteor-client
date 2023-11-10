import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
@Implements("NPCComposition")
public class NPCComposition extends DualNode {
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	@Export("NpcDefinition_archive")
	static AbstractArchive NpcDefinition_archive;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("NpcDefinition_cached")
	static EvictingDualNodeHashTable NpcDefinition_cached;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	@Export("NpcDefinition_cachedModels")
	static EvictingDualNodeHashTable NpcDefinition_cachedModels;
	@ObfuscatedName("cu")
	static int field1532;
	@ObfuscatedName("au")
	@Export("id")
	public int id;
	@ObfuscatedName("aa")
	@Export("name")
	public String name;
	@ObfuscatedName("ac")
	@Export("size")
	public int size;
	@ObfuscatedName("al")
	@Export("models")
	int[] models;
	@ObfuscatedName("az")
	int[] field1543;
	@ObfuscatedName("ap")
	@Export("idleSequence")
	public int idleSequence;
	@ObfuscatedName("av")
	@Export("turnLeftSequence")
	public int turnLeftSequence;
	@ObfuscatedName("ax")
	@Export("turnRightSequence")
	public int turnRightSequence;
	@ObfuscatedName("as")
	@Export("walkSequence")
	public int walkSequence;
	@ObfuscatedName("ay")
	@Export("walkBackSequence")
	public int walkBackSequence;
	@ObfuscatedName("ak")
	@Export("walkLeftSequence")
	public int walkLeftSequence;
	@ObfuscatedName("aj")
	@Export("walkRightSequence")
	public int walkRightSequence;
	@ObfuscatedName("am")
	@Export("runSequence")
	public int runSequence;
	@ObfuscatedName("aq")
	@Export("runBackSequence")
	public int runBackSequence;
	@ObfuscatedName("ai")
	@Export("runLeftSequence")
	public int runLeftSequence;
	@ObfuscatedName("aw")
	@Export("runRightSequence")
	public int runRightSequence;
	@ObfuscatedName("ae")
	@Export("crawlSequence")
	public int crawlSequence;
	@ObfuscatedName("an")
	@Export("crawlBackSequence")
	public int crawlBackSequence;
	@ObfuscatedName("ag")
	@Export("crawlLeftSequence")
	public int crawlLeftSequence;
	@ObfuscatedName("ad")
	@Export("crawlRightSequence")
	public int crawlRightSequence;
	@ObfuscatedName("af")
	@Export("recolorFrom")
	short[] recolorFrom;
	@ObfuscatedName("be")
	@Export("recolorTo")
	public short[] recolorTo;
	@ObfuscatedName("bd")
	@Export("retextureFrom")
	short[] retextureFrom;
	@ObfuscatedName("bl")
	@Export("retextureTo")
	public short[] retextureTo;
	@ObfuscatedName("bi")
	@Export("actions")
	public String[] actions;
	@ObfuscatedName("bv")
	@Export("drawMapDot")
	public boolean drawMapDot;
	@ObfuscatedName("bf")
	@Export("combatLevel")
	public int combatLevel;
	@ObfuscatedName("bg")
	@Export("widthScale")
	int widthScale;
	@ObfuscatedName("ba")
	@Export("heightScale")
	int heightScale;
	@ObfuscatedName("bm")
	@Export("isVisible")
	public boolean isVisible;
	@ObfuscatedName("bp")
	@Export("ambient")
	int ambient;
	@ObfuscatedName("bw")
	@Export("contrast")
	int contrast;
	@ObfuscatedName("bj")
	@Export("rotation")
	public int rotation;
	@ObfuscatedName("bn")
	@Export("transforms")
	public int[] transforms;
	@ObfuscatedName("bo")
	@Export("transformVarbit")
	int transformVarbit;
	@ObfuscatedName("bt")
	@Export("transformVarp")
	int transformVarp;
	@ObfuscatedName("bu")
	@Export("isInteractable")
	public boolean isInteractable;
	@ObfuscatedName("by")
	@Export("isClickable")
	public boolean isClickable;
	@ObfuscatedName("bh")
	@Export("isFollower")
	public boolean isFollower;
	@ObfuscatedName("bz")
	@Export("headIconArchiveIds")
	int[] headIconArchiveIds;
	@ObfuscatedName("bc")
	@Export("headIconSpriteIndexes")
	short[] headIconSpriteIndexes;
	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "Ltz;"
	)
	@Export("params")
	IterableNodeHashTable params;

	static {
		NpcDefinition_cached = new EvictingDualNodeHashTable(64);
		NpcDefinition_cachedModels = new EvictingDualNodeHashTable(50);
	}

	NPCComposition() {
		this.name = "null";
		this.size = 1;
		this.idleSequence = -1;
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1;
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1;
		this.runSequence = -1;
		this.runBackSequence = -1;
		this.runLeftSequence = -1;
		this.runRightSequence = -1;
		this.crawlSequence = -1;
		this.crawlBackSequence = -1;
		this.crawlLeftSequence = -1;
		this.crawlRightSequence = -1;
		this.actions = new String[5];
		this.drawMapDot = true;
		this.combatLevel = -1;
		this.widthScale = 128;
		this.heightScale = 128;
		this.isVisible = false;
		this.ambient = 0;
		this.contrast = 0;
		this.rotation = 32;
		this.transformVarbit = -1;
		this.transformVarp = -1;
		this.isInteractable = true;
		this.isClickable = true;
		this.isFollower = false;
		this.headIconArchiveIds = null;
		this.headIconSpriteIndexes = null;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "3"
	)
	@Export("postDecode")
	void postDecode() {
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Luj;B)V",
		garbageValue = "-39"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Luj;II)V",
		garbageValue = "221871708"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		int var3;
		int var4;
		if (var2 == 1) {
			var3 = var1.readUnsignedByte();
			this.models = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.models[var4] = var1.readUnsignedShort();
			}
		} else if (var2 == 2) {
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 12) {
			this.size = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.idleSequence = var1.readUnsignedShort();
		} else if (var2 == 14) {
			this.walkSequence = var1.readUnsignedShort();
		} else if (var2 == 15) {
			this.turnLeftSequence = var1.readUnsignedShort();
		} else if (var2 == 16) {
			this.turnRightSequence = var1.readUnsignedShort();
		} else if (var2 == 17) {
			this.walkSequence = var1.readUnsignedShort();
			this.walkBackSequence = var1.readUnsignedShort();
			this.walkLeftSequence = var1.readUnsignedShort();
			this.walkRightSequence = var1.readUnsignedShort();
		} else if (var2 == 18) {
			var1.readUnsignedShort();
		} else if (var2 >= 30 && var2 < 35) {
			this.actions[var2 - 30] = var1.readStringCp1252NullTerminated();
			if (this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
				this.actions[var2 - 30] = null;
			}
		} else if (var2 == 40) {
			var3 = var1.readUnsignedByte();
			this.recolorFrom = new short[var3];
			this.recolorTo = new short[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.recolorFrom[var4] = (short)var1.readUnsignedShort();
				this.recolorTo[var4] = (short)var1.readUnsignedShort();
			}
		} else if (var2 == 41) {
			var3 = var1.readUnsignedByte();
			this.retextureFrom = new short[var3];
			this.retextureTo = new short[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.retextureFrom[var4] = (short)var1.readUnsignedShort();
				this.retextureTo[var4] = (short)var1.readUnsignedShort();
			}
		} else if (var2 == 60) {
			var3 = var1.readUnsignedByte();
			this.field1543 = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.field1543[var4] = var1.readUnsignedShort();
			}
		} else if (var2 == 93) {
			this.drawMapDot = false;
		} else if (var2 == 95) {
			this.combatLevel = var1.readUnsignedShort();
		} else if (var2 == 97) {
			this.widthScale = var1.readUnsignedShort();
		} else if (var2 == 98) {
			this.heightScale = var1.readUnsignedShort();
		} else if (var2 == 99) {
			this.isVisible = true;
		} else if (var2 == 100) {
			this.ambient = var1.readByte();
		} else if (var2 == 101) {
			this.contrast = var1.readByte() * 5;
		} else {
			int var5;
			if (var2 == 102) {
				var3 = var1.readUnsignedByte();
				var4 = 0;

				for (var5 = var3; var5 != 0; var5 >>= 1) {
					++var4;
				}

				this.headIconArchiveIds = new int[var4];
				this.headIconSpriteIndexes = new short[var4];

				for (int var6 = 0; var6 < var4; ++var6) {
					if ((var3 & 1 << var6) == 0) {
						this.headIconArchiveIds[var6] = -1;
						this.headIconSpriteIndexes[var6] = -1;
					} else {
						this.headIconArchiveIds[var6] = var1.readNullableLargeSmart();
						this.headIconSpriteIndexes[var6] = (short)var1.readShortSmartSub();
					}
				}
			} else if (var2 == 103) {
				this.rotation = var1.readUnsignedShort();
			} else if (var2 != 106 && var2 != 118) {
				if (var2 == 107) {
					this.isInteractable = false;
				} else if (var2 == 109) {
					this.isClickable = false;
				} else if (var2 == 111) {
					this.isFollower = true;
				} else if (var2 == 114) {
					this.runSequence = var1.readUnsignedShort();
				} else if (var2 == 115) {
					this.runSequence = var1.readUnsignedShort();
					this.runBackSequence = var1.readUnsignedShort();
					this.runLeftSequence = var1.readUnsignedShort();
					this.runRightSequence = var1.readUnsignedShort();
				} else if (var2 == 116) {
					this.crawlSequence = var1.readUnsignedShort();
				} else if (var2 == 117) {
					this.crawlSequence = var1.readUnsignedShort();
					this.crawlBackSequence = var1.readUnsignedShort();
					this.crawlLeftSequence = var1.readUnsignedShort();
					this.crawlRightSequence = var1.readUnsignedShort();
				} else if (var2 == 249) {
					this.params = class144.readStringIntParameters(var1, this.params);
				}
			} else {
				this.transformVarbit = var1.readUnsignedShort();
				if (this.transformVarbit == 65535) {
					this.transformVarbit = -1;
				}

				this.transformVarp = var1.readUnsignedShort();
				if (this.transformVarp == 65535) {
					this.transformVarp = -1;
				}

				var3 = -1;
				if (var2 == 118) {
					var3 = var1.readUnsignedShort();
					if (var3 == 65535) {
						var3 = -1;
					}
				}

				var4 = var1.readUnsignedByte();
				this.transforms = new int[var4 + 2];

				for (var5 = 0; var5 <= var4; ++var5) {
					this.transforms[var5] = var1.readUnsignedShort();
					if (this.transforms[var5] == 65535) {
						this.transforms[var5] = -1;
					}
				}

				this.transforms[var4 + 1] = var3;
			}
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lhx;ILhx;ILhf;B)Lka;",
		garbageValue = "-112"
	)
	public final Model method940(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4, NewShit var5) {
		if (this.transforms != null) {
			NPCComposition var6 = this.transform();
			return var6 == null ? null : var6.method940(var1, var2, var3, var4, var5);
		} else {
			long var10 = (long)this.id;
			if (var5 != null) {
				var10 |= var5.field1531 << 16;
			}

			Model var8 = (Model)NpcDefinition_cachedModels.get(var10);
			if (var8 == null) {
				ModelData var9 = this.method942(this.models, var5);
				if (var9 == null) {
					return null;
				}

				var8 = var9.toModel(this.ambient + 64, this.contrast + 850, -30, -50, -30);
				NpcDefinition_cachedModels.put(var8, var10);
			}

			Model var12;
			if (var1 != null && var3 != null) {
				var12 = var1.applyTransformations(var8, var2, var3, var4);
			} else if (var1 != null) {
				var12 = var1.transformActorModel(var8, var2);
			} else if (var3 != null) {
				var12 = var3.transformActorModel(var8, var4);
			} else {
				var12 = var8.toSharedSequenceModel(true);
			}

			if (this.widthScale != 128 || this.heightScale != 128) {
				var12.scale(this.widthScale, this.heightScale, this.widthScale);
			}

			return var12;
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Lhf;B)Lkq;",
		garbageValue = "40"
	)
	public final ModelData method941(NewShit var1) {
		if (this.transforms != null) {
			NPCComposition var2 = this.transform();
			return var2 == null ? null : var2.method941(var1);
		} else {
			return this.method942(this.field1543, var1);
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "([ILhf;I)Lkq;",
		garbageValue = "-578729183"
	)
	ModelData method942(int[] var1, NewShit var2) {
		int[] var3 = var1;
		if (var2 != null && var2.field1527 != null) {
			var3 = var2.field1527;
		}

		if (var3 == null) {
			return null;
		} else {
			boolean var4 = false;

			for (int var5 = 0; var5 < var3.length; ++var5) {
				if (var3[var5] != -1 && !class191.field1586.tryLoadFile(var3[var5], 0)) {
					var4 = true;
				}
			}

			if (var4) {
				return null;
			} else {
				ModelData[] var9 = new ModelData[var3.length];

				for (int var6 = 0; var6 < var3.length; ++var6) {
					var9[var6] = ModelData.ModelData_get(class191.field1586, var3[var6], 0);
				}

				ModelData var10;
				if (var9.length == 1) {
					var10 = var9[0];
					if (var10 == null) {
						var10 = new ModelData(var9, var9.length);
					}
				} else {
					var10 = new ModelData(var9, var9.length);
				}

				short[] var7;
				int var8;
				if (this.recolorFrom != null) {
					var7 = this.recolorTo;
					if (var2 != null && var2.field1529 != null) {
						var7 = var2.field1529;
					}

					for (var8 = 0; var8 < this.recolorFrom.length; ++var8) {
						var10.recolor(this.recolorFrom[var8], var7[var8]);
					}
				}

				if (this.retextureFrom != null) {
					var7 = this.retextureTo;
					if (var2 != null && var2.field1528 != null) {
						var7 = var2.field1528;
					}

					for (var8 = 0; var8 < this.retextureFrom.length; ++var8) {
						var10.retexture(this.retextureFrom[var8], var7[var8]);
					}
				}

				return var10;
			}
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)Lhw;",
		garbageValue = "-454054205"
	)
	@Export("transform")
	public final NPCComposition transform() {
		int var1 = -1;
		if (this.transformVarbit != -1) {
			var1 = HealthBar.getVarbit(this.transformVarbit);
		} else if (this.transformVarp != -1) {
			var1 = Varps.Varps_main[this.transformVarp];
		}

		int var2;
		if (var1 >= 0 && var1 < this.transforms.length - 1) {
			var2 = this.transforms[var1];
		} else {
			var2 = this.transforms[this.transforms.length - 1];
		}

		return var2 != -1 ? VerticalAlignment.getNpcDefinition(var2) : null;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "10"
	)
	@Export("transformIsVisible")
	public boolean transformIsVisible() {
		if (this.transforms == null) {
			return true;
		} else {
			int var1 = -1;
			if (this.transformVarbit != -1) {
				var1 = HealthBar.getVarbit(this.transformVarbit);
			} else if (this.transformVarp != -1) {
				var1 = Varps.Varps_main[this.transformVarp];
			}

			if (var1 >= 0 && var1 < this.transforms.length) {
				return this.transforms[var1] != -1;
			} else {
				return this.transforms[this.transforms.length - 1] != -1;
			}
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-1331214833"
	)
	@Export("getIntParam")
	public int getIntParam(int var1, int var2) {
		return Player.method478(this.params, var1, var2);
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-2078724578"
	)
	@Export("getStringParam")
	public String getStringParam(int var1, String var2) {
		IterableNodeHashTable var4 = this.params;
		String var3;
		if (var4 == null) {
			var3 = var2;
		} else {
			ObjectNode var5 = (ObjectNode)var4.get((long)var1);
			if (var5 == null) {
				var3 = var2;
			} else {
				var3 = (String)var5.obj;
			}
		}

		return var3;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1998191718"
	)
	public boolean method947() {
		return this.headIconArchiveIds != null && this.headIconSpriteIndexes != null;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-1546218068"
	)
	public int[] method948() {
		return this.headIconArchiveIds;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1923898777"
	)
	public int method949(int var1) {
		return this.headIconArchiveIds != null && var1 < this.headIconArchiveIds.length ? this.headIconArchiveIds[var1] : -1;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)[S",
		garbageValue = "1795535195"
	)
	public short[] method950() {
		return this.headIconSpriteIndexes;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(IB)S",
		garbageValue = "-62"
	)
	public short method951(int var1) {
		return this.headIconSpriteIndexes != null && var1 < this.headIconSpriteIndexes.length ? this.headIconSpriteIndexes[var1] : -1;
	}

	@ObfuscatedName("lq")
	@ObfuscatedSignature(
		descriptor = "(IIIZB)V",
		garbageValue = "-115"
	)
	static final void method952(int var0, int var1, int var2, boolean var3) {
		if (HealthBarDefinition.widgetDefinition.loadInterface(var0)) {
			UrlRequest.resizeInterface(HealthBarDefinition.widgetDefinition.Widget_interfaceComponents[var0], -1, var1, var2, var3);
		}
	}
}