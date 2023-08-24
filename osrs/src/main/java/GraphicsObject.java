import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.security.SecureRandom;

@ObfuscatedName("cg")
@Implements("GraphicsObject")
public class GraphicsObject extends Renderable {
	@ObfuscatedName("hn")
	@Export("secureRandom")
	static SecureRandom secureRandom;
	@ObfuscatedName("au")
	@Export("id")
	int id;
	@ObfuscatedName("ae")
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("ao")
	@Export("plane")
	int plane;
	@ObfuscatedName("at")
	@Export("x")
	int x;
	@ObfuscatedName("ac")
	@Export("y")
	int y;
	@ObfuscatedName("ai")
	@Export("z")
	int z;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lib;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("ap")
	@Export("frame")
	int frame;
	@ObfuscatedName("aa")
	@Export("frameCycle")
	int frameCycle;
	@ObfuscatedName("af")
	@Export("isFinished")
	boolean isFinished;

	GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		this.frame = 0;
		this.frameCycle = 0;
		this.isFinished = false;
		this.id = var1;
		this.plane = var2;
		this.x = var3;
		this.y = var4;
		this.z = var5;
		this.cycleStart = var7 + var6;
		int var8 = StructComposition.SpotAnimationDefinition_get(this.id).sequence;
		if (var8 != -1) {
			this.isFinished = false;
			this.sequenceDefinition = EnumComposition.SequenceDefinition_get(var8);
		} else {
			this.isFinished = true;
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "47"
	)
	@Export("advance")
	final void advance(int var1) {
		if (!this.isFinished) {
			this.frameCycle += var1;
			if (!this.sequenceDefinition.isCachedModelIdSet()) {
				while (this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) {
					this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
					++this.frame;
					if (this.frame >= this.sequenceDefinition.frameIds.length) {
						this.isFinished = true;
						break;
					}
				}
			} else {
				this.frame += var1;
				if (this.frame >= this.sequenceDefinition.method1085()) {
					this.isFinished = true;
				}
			}

		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)Ljr;",
		garbageValue = "798227647"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = StructComposition.SpotAnimationDefinition_get(this.id);
		Model var2;
		if (!this.isFinished) {
			var2 = var1.getModel(this.frame);
		} else {
			var2 = var1.getModel(-1);
		}

		return var2 == null ? null : var2;
	}

	public GraphicsObject() {
	}
}