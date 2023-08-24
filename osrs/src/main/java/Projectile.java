import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Projectile")
public final class Projectile extends Renderable {
	@ObfuscatedName("au")
	@Export("id")
	int id;
	@ObfuscatedName("ae")
	@Export("plane")
	int plane;
	@ObfuscatedName("ao")
	@Export("sourceX")
	int sourceX;
	@ObfuscatedName("at")
	@Export("sourceY")
	int sourceY;
	@ObfuscatedName("ac")
	@Export("sourceZ")
	int sourceZ;
	@ObfuscatedName("ai")
	@Export("endHeight")
	int endHeight;
	@ObfuscatedName("az")
	int field805;
	@ObfuscatedName("ap")
	int field799;
	@ObfuscatedName("aa")
	int field789;
	@ObfuscatedName("af")
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("ad")
	@Export("cycleEnd")
	int cycleEnd;
	@ObfuscatedName("aq")
	@Export("slope")
	int slope;
	@ObfuscatedName("al")
	@Export("startHeight")
	int startHeight;
	@ObfuscatedName("an")
	int field797;
	@ObfuscatedName("ar")
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("ab")
	@Export("isMoving")
	boolean isMoving;
	@ObfuscatedName("ag")
	@Export("x")
	double x;
	@ObfuscatedName("am")
	@Export("y")
	double y;
	@ObfuscatedName("ax")
	@Export("z")
	double z;
	@ObfuscatedName("ah")
	double speedY;
	@ObfuscatedName("as")
	double speedX;
	@ObfuscatedName("ay")
	double speed;
	@ObfuscatedName("aj")
	@Export("speedZ")
	double speedZ;
	@ObfuscatedName("av")
	double field785;
	@ObfuscatedName("aw")
	@Export("yaw")
	int yaw;
	@ObfuscatedName("ak")
	@Export("pitch")
	int pitch;
	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "Lib;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("bj")
	@Export("frame")
	int frame;
	@ObfuscatedName("bk")
	@Export("frameCycle")
	int frameCycle;

	Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
		this.isMoving = false;
		this.frame = 0;
		this.frameCycle = 0;
		this.id = var1;
		this.plane = var2;
		this.sourceX = var3;
		this.sourceY = var4;
		this.sourceZ = var5;
		this.cycleStart = var6;
		this.cycleEnd = var7;
		this.slope = var8;
		this.startHeight = var9;
		this.targetIndex = var10;
		this.endHeight = var11;
		this.isMoving = false;
		int var12 = StructComposition.SpotAnimationDefinition_get(this.id).sequence;
		if (var12 != -1) {
			this.sequenceDefinition = EnumComposition.SequenceDefinition_get(var12);
		} else {
			this.sequenceDefinition = null;
		}

	}

	Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) {
		this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11, var12);
		this.field797 = var10;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "-912424366"
	)
	@Export("setDestination")
	final void setDestination(int var1, int var2, int var3, int var4) {
		this.field805 = var1;
		this.field799 = var2;
		this.field789 = var3;
		double var5;
		if (!this.isMoving) {
			var5 = (double)(this.field805 - this.sourceX);
			double var7 = (double)(this.field799 - this.sourceY);
			double var9 = Math.sqrt(var5 * var5 + var7 * var7);
			this.x = (double)this.sourceX + (double)this.startHeight * var5 / var9;
			this.y = (double)this.sourceY + (double)this.startHeight * var7 / var9;
			this.z = (double)this.sourceZ;
		}

		var5 = (double)(this.cycleEnd + 1 - var4);
		this.speedY = ((double)this.field805 - this.x) / var5;
		this.speedX = ((double)this.field799 - this.y) / var5;
		this.speed = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
		if (!this.isMoving) {
			this.speedZ = -this.speed * Math.tan((double)this.slope * 0.02454369D);
		}

		this.field785 = ((double)this.field789 - this.z - this.speedZ * var5) * 2.0D / (var5 * var5);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)Ljr;",
		garbageValue = "798227647"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = StructComposition.SpotAnimationDefinition_get(this.id);
		Model var2 = var1.getModel(this.frame);
		if (var2 == null) {
			return null;
		} else {
			var2.rotateZ(this.pitch);
			return var2;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "30"
	)
	@Export("advance")
	final void advance(int var1) {
		this.isMoving = true;
		this.x += this.speedY * (double)var1;
		this.y += (double)var1 * this.speedX;
		this.z += 0.5D * this.field785 * (double)var1 * (double)var1 + (double)var1 * this.speedZ;
		this.speedZ += this.field785 * (double)var1;
		this.yaw = (int)(Math.atan2(this.speedY, this.speedX) * 325.949D) + 1024 & 2047;
		this.pitch = (int)(Math.atan2(this.speedZ, this.speed) * 325.949D) & 2047;
		if (this.sequenceDefinition != null) {
			if (!this.sequenceDefinition.isCachedModelIdSet()) {
				this.frameCycle += var1;

				while (true) {
					do {
						do {
							if (this.frameCycle <= this.sequenceDefinition.frameLengths[this.frame]) {
								return;
							}

							this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
							++this.frame;
						} while(this.frame < this.sequenceDefinition.frameIds.length);

						this.frame -= this.sequenceDefinition.frameCount;
					} while(this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

					this.frame = 0;
				}
			} else {
				this.frame += var1;
				int var2 = this.sequenceDefinition.method1085();
				if (this.frame >= var2) {
					this.frame = var2 - this.sequenceDefinition.frameCount;
				}
			}
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "992783271"
	)
	public static int method430(int var0) {
		return class303.field2755[var0];
	}
}