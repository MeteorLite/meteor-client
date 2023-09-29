import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("NPC")
public final class NPC extends Actor {
	@ObfuscatedName("ar")
	static int field1077;
	@ObfuscatedName("am")
	static int field1076;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lhw;"
	)
	@Export("definition")
	NPCComposition definition;
	@ObfuscatedName("al")
	@Export("nameChange")
	String nameChange;
	@ObfuscatedName("ax")
	int field1081;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lup;"
	)
	class530 field1083;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lhe;"
	)
	NewShit field1079;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lhe;"
	)
	NewShit field1078;

	static {
		field1077 = 1;
		field1076 = 1;
	}

	NPC() {
		this.nameChange = "";
		this.field1081 = 31;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "218528952"
	)
	void method578(String var1) {
		this.nameChange = var1 == null ? "" : var1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)Ljn;",
		garbageValue = "0"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.definition == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? class36.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence == -1 || super.movementSequence == super.idleSequence && var1 != null ? null : class36.SequenceDefinition_get(super.movementSequence);
			Model var3 = null;
			if (this.field1079 != null && this.field1079.field1593) {
				var3 = TextureProvider.localPlayer.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			} else {
				var3 = this.definition.method1011(var1, super.sequenceFrame, var2, super.movementFrame, this.field1079);
			}

			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				int var4 = var3.indicesCount;
				var3 = this.method520(var3);
				if (this.definition.size == 1) {
					var3.isSingleTile = true;
				}

				if (super.recolourAmount != 0 && Client.cycle >= super.recolourStartCycle && Client.cycle < super.recolourEndCycle) {
					var3.overrideHue = super.recolourHue;
					var3.overrideSaturation = super.recolourSaturation;
					var3.overrideLuminance = super.recolourLuminance;
					var3.overrideAmount = super.recolourAmount;
					var3.field2255 = (short)var4;
				} else {
					var3.overrideAmount = 0;
				}

				return var3;
			}
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1833659778"
	)
	void method579(int var1) {
		this.field1081 = var1;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "113824049"
	)
	boolean method580(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field1081 & 1 << var1) != 0;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "-29"
	)
	final String method582() {
		if (!this.nameChange.isEmpty()) {
			return this.nameChange;
		} else {
			NPCComposition var1 = this.definition;
			if (var1.transforms != null) {
				var1 = var1.transform();
				if (var1 == null) {
					var1 = this.definition;
				}
			}

			return var1.name;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(ILip;B)V",
		garbageValue = "-1"
	)
	@Export("move")
	final void move(int var1, MoveSpeed var2) {
		int var3 = super.pathX[0];
		int var4 = super.pathY[0];
		if (var1 == 0) {
			--var3;
			++var4;
		}

		if (var1 == 1) {
			++var4;
		}

		if (var1 == 2) {
			++var3;
			++var4;
		}

		if (var1 == 3) {
			--var3;
		}

		if (var1 == 4) {
			++var3;
		}

		if (var1 == 5) {
			--var3;
			--var4;
		}

		if (var1 == 6) {
			--var4;
		}

		if (var1 == 7) {
			++var3;
			--var4;
		}

		if (super.sequence != -1 && class36.SequenceDefinition_get(super.sequence).priority == 1) {
			super.sequence = -1;
		}

		if (super.pathLength < 9) {
			++super.pathLength;
		}

		for (int var5 = super.pathLength; var5 > 0; --var5) {
			super.pathX[var5] = super.pathX[var5 - 1];
			super.pathY[var5] = super.pathY[var5 - 1];
			super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
		}

		super.pathX[0] = var3;
		super.pathY[0] = var4;
		super.pathTraversed[0] = var2;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(IIZI)V",
		garbageValue = "-358090235"
	)
	final void method584(int var1, int var2, boolean var3) {
		if (super.sequence != -1 && class36.SequenceDefinition_get(super.sequence).priority == 1) {
			super.sequence = -1;
		}

		if (!var3) {
			int var4 = var1 - super.pathX[0];
			int var5 = var2 - super.pathY[0];
			if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
				if (super.pathLength < 9) {
					++super.pathLength;
				}

				for (int var6 = super.pathLength; var6 > 0; --var6) {
					super.pathX[var6] = super.pathX[var6 - 1];
					super.pathY[var6] = super.pathY[var6 - 1];
					super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
				}

				super.pathX[0] = var1;
				super.pathY[0] = var2;
				super.pathTraversed[0] = MoveSpeed.WALK;
				return;
			}
		}

		super.pathLength = 0;
		super.field1023 = 0;
		super.field1024 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.x = super.field971 * 64 + super.pathX[0] * 128;
		super.y = super.field971 * 64 + super.pathY[0] * 128;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)[I",
		garbageValue = "0"
	)
	int[] method587() {
		return this.field1083 != null ? this.field1083.method2639() : this.definition.method1019();
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)[S",
		garbageValue = "-288846359"
	)
	short[] method588() {
		return this.field1083 != null ? this.field1083.method2640() : this.definition.method1021();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(IISS)V",
		garbageValue = "-15144"
	)
	void method589(int var1, int var2, short var3) {
		if (this.field1083 == null) {
			this.field1083 = new class530(this.definition);
		}

		this.field1083.method2641(var1, var2, var3);
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "([I[SB)V",
		garbageValue = "8"
	)
	void method590(int[] var1, short[] var2) {
		if (this.field1083 == null) {
			this.field1083 = new class530(this.definition);
		}

		this.field1083.method2642(var1, var2);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-432488525"
	)
	void method591() {
		this.field1083 = null;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lhe;I)V",
		garbageValue = "-1403637183"
	)
	void method592(NewShit var1) {
		this.field1078 = var1;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)Lhe;",
		garbageValue = "905115149"
	)
	NewShit method593() {
		return this.field1078;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lhe;I)V",
		garbageValue = "463654606"
	)
	void method594(NewShit var1) {
		this.field1079 = var1;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "4"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.definition != null;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-64"
	)
	void method595() {
		this.field1078 = null;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "257879915"
	)
	void method596() {
		this.field1079 = null;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-965276822"
	)
	static void method581(int var0) {
	}

	@ObfuscatedName("iy")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "0"
	)
	static final int method597(int var0) {
		return Math.abs(var0 - WallDecoration.cameraYaw) > 1024 ? 2048 * (var0 < WallDecoration.cameraYaw ? 1 : -1) + var0 : var0;
	}

	@ObfuscatedName("ok")
	@ObfuscatedSignature(
		descriptor = "(Lul;II)V",
		garbageValue = "101752739"
	)
	static void method598(Buffer var0, int var1) {
		class266.method1432(var0.array, var1);
		HealthBar.method576(var0, var1);
	}
}