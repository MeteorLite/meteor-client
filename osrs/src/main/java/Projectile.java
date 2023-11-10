import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Projectile")
public final class Projectile extends Renderable {
	@ObfuscatedName("vl")
	static int field783;
	@ObfuscatedName("at")
	@Export("id")
	int id;
	@ObfuscatedName("ah")
	@Export("plane")
	int plane;
	@ObfuscatedName("ar")
	@Export("sourceX")
	int sourceX;
	@ObfuscatedName("ao")
	@Export("sourceY")
	int sourceY;
	@ObfuscatedName("ab")
	@Export("sourceZ")
	int sourceZ;
	@ObfuscatedName("au")
	@Export("endHeight")
	int endHeight;
	@ObfuscatedName("aa")
	int field794;
	@ObfuscatedName("ac")
	int field796;
	@ObfuscatedName("al")
	int field800;
	@ObfuscatedName("az")
	@Export("cycleStart")
	int cycleStart;
	@ObfuscatedName("ap")
	@Export("cycleEnd")
	int cycleEnd;
	@ObfuscatedName("av")
	@Export("slope")
	int slope;
	@ObfuscatedName("ax")
	@Export("startHeight")
	int startHeight;
	@ObfuscatedName("as")
	int field804;
	@ObfuscatedName("ay")
	@Export("targetIndex")
	int targetIndex;
	@ObfuscatedName("ak")
	@Export("isMoving")
	boolean isMoving;
	@ObfuscatedName("aj")
	@Export("x")
	double x;
	@ObfuscatedName("am")
	@Export("y")
	double y;
	@ObfuscatedName("aq")
	@Export("z")
	double z;
	@ObfuscatedName("ai")
	@Export("speedY")
	double speedY;
	@ObfuscatedName("aw")
	@Export("speedX")
	double speedX;
	@ObfuscatedName("ae")
	@Export("speed")
	double speed;
	@ObfuscatedName("an")
	@Export("speedZ")
	double speedZ;
	@ObfuscatedName("ag")
	double field786;
	@ObfuscatedName("ad")
	@Export("yaw")
	int yaw;
	@ObfuscatedName("af")
	@Export("pitch")
	int pitch;
	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "Lhx;"
	)
	@Export("sequenceDefinition")
	SequenceDefinition sequenceDefinition;
	@ObfuscatedName("bd")
	@Export("frame")
	int frame;
	@ObfuscatedName("bl")
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
		int var12 = Canvas.SpotAnimationDefinition_get(this.id).sequence;
		if (var12 != -1) {
			this.sequenceDefinition = DynamicObject.SequenceDefinition_get(var12);
		} else {
			this.sequenceDefinition = null;
		}

	}

	Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) {
		this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11, var12);
		this.field804 = var10;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "34043964"
	)
	@Export("setDestination")
	final void setDestination(int var1, int var2, int var3, int var4) {
		this.field794 = var1;
		this.field796 = var2;
		this.field800 = var3;
		double var5;
		if (!this.isMoving) {
			var5 = (double)(this.field794 - this.sourceX);
			double var7 = (double)(this.field796 - this.sourceY);
			double var9 = Math.sqrt(var7 * var7 + var5 * var5);
			this.x = (double)this.sourceX + (double)this.startHeight * var5 / var9;
			this.y = (double)this.startHeight * var7 / var9 + (double)this.sourceY;
			this.z = (double)this.sourceZ;
		}

		var5 = (double)(this.cycleEnd + 1 - var4);
		this.speedY = ((double)this.field794 - this.x) / var5;
		this.speedX = ((double)this.field796 - this.y) / var5;
		this.speed = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
		if (!this.isMoving) {
			this.speedZ = -this.speed * Math.tan(0.02454369D * (double)this.slope);
		}

		this.field786 = 2.0D * ((double)this.field800 - this.z - this.speedZ * var5) / (var5 * var5);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)Lka;",
		garbageValue = "1"
	)
	@Export("getModel")
	protected final Model getModel() {
		SpotAnimationDefinition var1 = Canvas.SpotAnimationDefinition_get(this.id);
		Model var2 = var1.getModel(this.frame);
		if (var2 == null) {
			return null;
		} else {
			var2.rotateZ(this.pitch);
			return var2;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1019112167"
	)
	@Export("advance")
	final void advance(int var1) {
		this.isMoving = true;
		this.x += (double)var1 * this.speedY;
		this.y += (double)var1 * this.speedX;
		this.z += (double)var1 * this.speedZ + (double)var1 * (double)var1 * 0.5D * this.field786;
		this.speedZ += this.field786 * (double)var1;
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
				int var2 = this.sequenceDefinition.method1052();
				if (this.frame >= var2) {
					this.frame = var2 - this.sequenceDefinition.frameCount;
				}
			}
		}

	}

	@ObfuscatedName("jm")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1070521773"
	)
	static boolean method442() {
		return (Client.drawPlayerNames & 8) != 0;
	}

	@ObfuscatedName("mp")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "2039275921"
	)
	@Export("changeGameOptions")
	static final void changeGameOptions(int var0) {
		class396.method2042();
		class159.method834();
		int var1 = FloorOverlayDefinition.VarpDefinition_get(var0).type;
		if (var1 != 0) {
			int var2 = Varps.Varps_main[var0];
			if (var1 == 1) {
				if (var2 == 1) {
					Rasterizer3D.method1415(0.9D);
					((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).setBrightness(0.9D);
					class166.method866();
					WorldMapIcon_1.clientPreferences.setBrightness(0.9D);
				}

				if (var2 == 2) {
					Rasterizer3D.method1415(0.8D);
					((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).setBrightness(0.8D);
					class166.method866();
					WorldMapIcon_1.clientPreferences.setBrightness(0.8D);
				}

				if (var2 == 3) {
					Rasterizer3D.method1415(0.7D);
					((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).setBrightness(0.7D);
					class166.method866();
					WorldMapIcon_1.clientPreferences.setBrightness(0.7D);
				}

				if (var2 == 4) {
					Rasterizer3D.method1415(0.6D);
					((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).setBrightness(0.6D);
					class166.method866();
					WorldMapIcon_1.clientPreferences.setBrightness(0.6D);
				}
			}

			if (var1 == 3) {
				if (var2 == 0) {
					Decimator.method323(255);
				}

				if (var2 == 1) {
					Decimator.method323(192);
				}

				if (var2 == 2) {
					Decimator.method323(128);
				}

				if (var2 == 3) {
					Decimator.method323(64);
				}

				if (var2 == 4) {
					Decimator.method323(0);
				}
			}

			if (var1 == 4) {
				if (var2 == 0) {
					SoundSystem.method235(127);
				}

				if (var2 == 1) {
					SoundSystem.method235(96);
				}

				if (var2 == 2) {
					SoundSystem.method235(64);
				}

				if (var2 == 3) {
					SoundSystem.method235(32);
				}

				if (var2 == 4) {
					SoundSystem.method235(0);
				}
			}

			if (var1 == 5) {
				Client.leftClickOpensMenu = var2 == 1;
			}

			if (var1 == 6) {
				Client.chatEffects = var2;
			}

			if (var1 == 9) {
			}

			if (var1 == 10) {
				if (var2 == 0) {
					Login.method438(127);
				}

				if (var2 == 1) {
					Login.method438(96);
				}

				if (var2 == 2) {
					Login.method438(64);
				}

				if (var2 == 3) {
					Login.method438(32);
				}

				if (var2 == 4) {
					Login.method438(0);
				}
			}

			if (var1 == 17) {
				Client.followerIndex = var2 & 65535;
			}

			if (var1 == 18) {
				Client.playerAttackOption = (AttackOption)class12.findEnumerated(MenuAction.method436(), var2);
				if (Client.playerAttackOption == null) {
					Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

			if (var1 == 19) {
				if (var2 == -1) {
					Client.combatTargetPlayerIndex = -1;
				} else {
					Client.combatTargetPlayerIndex = var2 & 2047;
				}
			}

			if (var1 == 22) {
				AttackOption[] var3 = new AttackOption[]{AttackOption.field1103, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_hidden, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.field1106};
				Client.npcAttackOption = (AttackOption)class12.findEnumerated(var3, var2);
				if (Client.npcAttackOption == null) {
					Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

		}
	}
}