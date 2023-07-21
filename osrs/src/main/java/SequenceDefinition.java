import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("SequenceDefinition")
public class SequenceDefinition extends DualNode {
	@ObfuscatedName("aw")
	static boolean field1808;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	@Export("SequenceDefinition_archive")
	static AbstractArchive SequenceDefinition_archive;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("SequenceDefinition_cached")
	static EvictingDualNodeHashTable SequenceDefinition_cached;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("SequenceDefinition_cachedFrames")
	static EvictingDualNodeHashTable SequenceDefinition_cachedFrames;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lld;"
	)
	@Export("SequenceDefinition_cachedModel")
	static EvictingDualNodeHashTable SequenceDefinition_cachedModel;
	@ObfuscatedName("aq")
	@Export("SequenceDefinition_cachedModelId")
	public int SequenceDefinition_cachedModelId;
	@ObfuscatedName("at")
	@Export("animMayaFrameSounds")
	public Map animMayaFrameSounds;
	@ObfuscatedName("ah")
	@Export("animMayaStart")
	int animMayaStart;
	@ObfuscatedName("ax")
	@Export("animMayaEnd")
	int animMayaEnd;
	@ObfuscatedName("aa")
	@Export("frameIds")
	public int[] frameIds;
	@ObfuscatedName("au")
	@Export("chatFrameIds")
	int[] chatFrameIds;
	@ObfuscatedName("ae")
	@Export("frameLengths")
	public int[] frameLengths;
	@ObfuscatedName("ab")
	@Export("soundEffects")
	public int[] soundEffects;
	@ObfuscatedName("ad")
	@Export("frameCount")
	public int frameCount;
	@ObfuscatedName("ao")
	@Export("mergedBoneGroups")
	int[] mergedBoneGroups;
	@ObfuscatedName("ac")
	@Export("animMayaMasks")
	boolean[] animMayaMasks;
	@ObfuscatedName("ak")
	@Export("stretches")
	public boolean stretches;
	@ObfuscatedName("an")
	@Export("forcedPriority")
	public int forcedPriority;
	@ObfuscatedName("af")
	@Export("shield")
	public int shield;
	@ObfuscatedName("ai")
	@Export("weapon")
	public int weapon;
	@ObfuscatedName("al")
	@Export("iterations")
	public int iterations;
	@ObfuscatedName("bd")
	public boolean field1819;
	@ObfuscatedName("bb")
	@Export("precedenceAnimating")
	public int precedenceAnimating;
	@ObfuscatedName("bn")
	@Export("priority")
	public int priority;
	@ObfuscatedName("ba")
	@Export("replyMode")
	public int replyMode;

	static {
		field1808 = false;
		SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
		SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
		SequenceDefinition_cachedModel = new EvictingDualNodeHashTable(100);
	}

	SequenceDefinition() {
		this.SequenceDefinition_cachedModelId = -1;
		this.animMayaStart = 0;
		this.animMayaEnd = 0;
		this.frameCount = -1;
		this.stretches = false;
		this.forcedPriority = 5;
		this.shield = -1;
		this.weapon = -1;
		this.iterations = 99;
		this.field1819 = false;
		this.precedenceAnimating = -1;
		this.priority = -1;
		this.replyMode = 2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lty;S)V",
		garbageValue = "-22539"
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

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lty;II)V",
		garbageValue = "1148727534"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		int var3;
		int var4;
		if (var2 == 1) {
			var3 = var1.readUnsignedShort();
			this.frameLengths = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameLengths[var4] = var1.readUnsignedShort();
			}

			this.frameIds = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameIds[var4] = var1.readUnsignedShort();
			}

			for (var4 = 0; var4 < var3; ++var4) {
				this.frameIds[var4] += var1.readUnsignedShort() << 16;
			}
		} else if (var2 == 2) {
			this.frameCount = var1.readUnsignedShort();
		} else if (var2 == 3) {
			var3 = var1.readUnsignedByte();
			this.mergedBoneGroups = new int[var3 + 1];

			for (var4 = 0; var4 < var3; ++var4) {
				this.mergedBoneGroups[var4] = var1.readUnsignedByte();
			}

			this.mergedBoneGroups[var3] = 9999999;
		} else if (var2 == 4) {
			this.stretches = true;
		} else if (var2 == 5) {
			this.forcedPriority = var1.readUnsignedByte();
		} else if (var2 == 6) {
			this.shield = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.weapon = var1.readUnsignedShort();
		} else if (var2 == 8) {
			this.iterations = var1.readUnsignedByte();
			this.field1819 = true;
		} else if (var2 == 9) {
			this.precedenceAnimating = var1.readUnsignedByte();
		} else if (var2 == 10) {
			this.priority = var1.readUnsignedByte();
		} else if (var2 == 11) {
			this.replyMode = var1.readUnsignedByte();
		} else if (var2 == 12) {
			var3 = var1.readUnsignedByte();
			this.chatFrameIds = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.chatFrameIds[var4] = var1.readUnsignedShort();
			}

			for (var4 = 0; var4 < var3; ++var4) {
				this.chatFrameIds[var4] += var1.readUnsignedShort() << 16;
			}
		} else if (var2 == 13) {
			var3 = var1.readUnsignedByte();
			this.soundEffects = new int[var3];

			for (var4 = 0; var4 < var3; ++var4) {
				this.soundEffects[var4] = var1.readMedium();
			}
		} else if (var2 == 14) {
			this.SequenceDefinition_cachedModelId = var1.readInt();
		} else if (var2 == 15) {
			var3 = var1.readUnsignedShort();
			this.animMayaFrameSounds = new HashMap();

			for (var4 = 0; var4 < var3; ++var4) {
				int var5 = var1.readUnsignedShort();
				int var6 = var1.readMedium();
				this.animMayaFrameSounds.put(var5, var6);
			}
		} else if (var2 == 16) {
			this.animMayaStart = var1.readUnsignedShort();
			this.animMayaEnd = var1.readUnsignedShort();
		} else if (var2 == 17) {
			this.animMayaMasks = new boolean[256];

			for (var3 = 0; var3 < this.animMayaMasks.length; ++var3) {
				this.animMayaMasks[var3] = false;
			}

			var3 = var1.readUnsignedByte();

			for (var4 = 0; var4 < var3; ++var4) {
				this.animMayaMasks[var1.readUnsignedByte()] = true;
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "121"
	)
	@Export("postDecode")
	void postDecode() {
		if (this.precedenceAnimating == -1) {
			if (this.mergedBoneGroups == null && this.animMayaMasks == null) {
				this.precedenceAnimating = 0;
			} else {
				this.precedenceAnimating = 2;
			}
		}

		if (this.priority == -1) {
			if (this.mergedBoneGroups == null && this.animMayaMasks == null) {
				this.priority = 0;
			} else {
				this.priority = 2;
			}
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Ljo;II)Ljo;",
		garbageValue = "509430466"
	)
	@Export("transformActorModel")
	public Model transformActorModel(Model var1, int var2) {
		Model var4;
		if (!this.isCachedModelIdSet()) {
			var2 = this.frameIds[var2];
			Frames var5 = class157.getFrames(var2 >> 16);
			var2 &= 65535;
			if (var5 == null) {
				return var1.toSharedSequenceModel(true);
			} else {
				var4 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2));
				var4.animate(var5, var2);
				return var4;
			}
		} else {
			class137 var3 = class181.method917(this.SequenceDefinition_cachedModelId);
			if (var3 == null) {
				return var1.toSharedSequenceModel(true);
			} else {
				var4 = var1.toSharedSequenceModel(!var3.method737());
				var4.method1296(var3, var2);
				return var4;
			}
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Ljo;IIB)Ljo;",
		garbageValue = "-111"
	)
	@Export("transformObjectModel")
	Model transformObjectModel(Model var1, int var2, int var3) {
		Model var5;
		if (!this.isCachedModelIdSet()) {
			var2 = this.frameIds[var2];
			Frames var6 = class157.getFrames(var2 >> 16);
			var2 &= 65535;
			if (var6 == null) {
				return var1.toSharedSequenceModel(true);
			} else {
				var5 = var1.toSharedSequenceModel(!var6.hasAlphaTransform(var2));
				var3 &= 3;
				if (var3 == 1) {
					var5.rotateY270Ccw();
				} else if (var3 == 2) {
					var5.rotateY180();
				} else if (var3 == 3) {
					var5.rotateY90Ccw();
				}

				var5.animate(var6, var2);
				if (var3 == 1) {
					var5.rotateY90Ccw();
				} else if (var3 == 2) {
					var5.rotateY180();
				} else if (var3 == 3) {
					var5.rotateY270Ccw();
				}

				return var5;
			}
		} else {
			class137 var4 = class181.method917(this.SequenceDefinition_cachedModelId);
			if (var4 == null) {
				return var1.toSharedSequenceModel(true);
			} else {
				var5 = var1.toSharedSequenceModel(!var4.method737());
				var3 &= 3;
				if (var3 == 1) {
					var5.rotateY270Ccw();
				} else if (var3 == 2) {
					var5.rotateY180();
				} else if (var3 == 3) {
					var5.rotateY90Ccw();
				}

				var5.method1296(var4, var2);
				if (var3 == 1) {
					var5.rotateY90Ccw();
				} else if (var3 == 2) {
					var5.rotateY180();
				} else if (var3 == 3) {
					var5.rotateY270Ccw();
				}

				return var5;
			}
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Ljo;II)Ljo;",
		garbageValue = "1735736185"
	)
	Model method1062(Model var1, int var2) {
		Model var4;
		if (!this.isCachedModelIdSet()) {
			var2 = this.frameIds[var2];
			Frames var5 = class157.getFrames(var2 >> 16);
			var2 &= 65535;
			if (var5 == null) {
				return var1.method1288(true);
			} else {
				var4 = var1.method1288(!var5.hasAlphaTransform(var2));
				var4.animate(var5, var2);
				return var4;
			}
		} else {
			class137 var3 = class181.method917(this.SequenceDefinition_cachedModelId);
			if (var3 == null) {
				return var1.method1288(true);
			} else {
				var4 = var1.method1288(!var3.method737());
				var4.method1296(var3, var2);
				return var4;
			}
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Ljo;ILig;II)Ljo;",
		garbageValue = "-1383318725"
	)
	@Export("applyTransformations")
	public Model applyTransformations(Model var1, int var2, SequenceDefinition var3, int var4) {
		if (field1808 && !this.isCachedModelIdSet() && !var3.isCachedModelIdSet()) {
			return this.method1064(var1, var2, var3, var4);
		} else {
			Model var5 = var1.toSharedSequenceModel(false);
			boolean var6 = false;
			Frames var7 = null;
			Skeleton var8 = null;
			class137 var9;
			if (this.isCachedModelIdSet()) {
				var9 = this.method1068();
				if (var9 == null) {
					return var5;
				}

				if (var3.isCachedModelIdSet() && this.animMayaMasks == null) {
					var5.method1296(var9, var2);
					return var5;
				}

				var8 = var9.field1294;
				var5.method1300(var8, var9, var2, this.animMayaMasks, false, !var3.isCachedModelIdSet());
			} else {
				var2 = this.frameIds[var2];
				var7 = class157.getFrames(var2 >> 16);
				var2 &= 65535;
				if (var7 == null) {
					return var3.transformActorModel(var1, var4);
				}

				if (!var3.isCachedModelIdSet() && (this.mergedBoneGroups == null || var4 == -1)) {
					var5.animate(var7, var2);
					return var5;
				}

				if (this.mergedBoneGroups == null || var4 == -1) {
					var5.animate(var7, var2);
					return var5;
				}

				var6 = var3.isCachedModelIdSet();
				if (!var6) {
					var5.method1301(var7, var2, this.mergedBoneGroups, false);
				}
			}

			if (var3.isCachedModelIdSet()) {
				var9 = var3.method1068();
				if (var9 == null) {
					return var5;
				}

				if (var8 == null) {
					var8 = var9.field1294;
				}

				var5.method1300(var8, var9, var4, this.animMayaMasks, true, true);
			} else {
				var4 = var3.frameIds[var4];
				Frames var10 = class157.getFrames(var4 >> 16);
				var4 &= 65535;
				if (var10 == null) {
					return this.transformActorModel(var1, var2);
				}

				var5.method1301(var10, var4, this.mergedBoneGroups, true);
			}

			if (var6 && var7 != null) {
				var5.method1301(var7, var2, this.mergedBoneGroups, false);
			}

			var5.resetBounds();
			return var5;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Ljo;ILig;IB)Ljo;",
		garbageValue = "6"
	)
	Model method1064(Model var1, int var2, SequenceDefinition var3, int var4) {
		var2 = this.frameIds[var2];
		Frames var5 = class157.getFrames(var2 >> 16);
		var2 &= 65535;
		if (var5 == null) {
			return var3.transformActorModel(var1, var4);
		} else {
			var4 = var3.frameIds[var4];
			Frames var6 = class157.getFrames(var4 >> 16);
			var4 &= 65535;
			Model var7;
			if (var6 == null) {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2));
				var7.animate(var5, var2);
				return var7;
			} else {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2) & !var6.hasAlphaTransform(var4));
				var7.animate2(var5, var2, var6, var4, this.mergedBoneGroups);
				return var7;
			}
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Ljo;II)Ljo;",
		garbageValue = "-2020208153"
	)
	@Export("transformWidgetModel")
	public Model transformWidgetModel(Model var1, int var2) {
		if (!this.isCachedModelIdSet()) {
			int var3 = this.frameIds[var2];
			Frames var4 = class157.getFrames(var3 >> 16);
			var3 &= 65535;
			if (var4 == null) {
				return var1.toSharedSequenceModel(true);
			} else {
				Frames var5 = null;
				int var6 = 0;
				if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
					var6 = this.chatFrameIds[var2];
					var5 = class157.getFrames(var6 >> 16);
					var6 &= 65535;
				}

				Model var7;
				if (var5 != null && var6 != 65535) {
					var7 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var3) & !var5.hasAlphaTransform(var6));
					var7.animate(var4, var3);
					var7.animate(var5, var6);
					return var7;
				} else {
					var7 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var3));
					var7.animate(var4, var3);
					return var7;
				}
			}
		} else {
			return this.transformActorModel(var1, var2);
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2102518176"
	)
	@Export("isCachedModelIdSet")
	public boolean isCachedModelIdSet() {
		return this.SequenceDefinition_cachedModelId >= 0;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "791799028"
	)
	public int method1067() {
		return this.animMayaEnd - this.animMayaStart;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)Lfz;",
		garbageValue = "49"
	)
	class137 method1068() {
		return this.isCachedModelIdSet() ? class181.method917(this.SequenceDefinition_cachedModelId) : null;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Lho;",
		garbageValue = "-1093606391"
	)
	@Export("WorldMapElement_get")
	public static WorldMapElement WorldMapElement_get(int var0) {
		return var0 >= 0 && var0 < class335.WorldMapElement_cached.length && class335.WorldMapElement_cached[var0] != null ? class335.WorldMapElement_cached[var0] : new WorldMapElement(var0);
	}
}
