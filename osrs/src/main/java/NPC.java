import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("NPC")
public final class NPC extends Actor {
	@ObfuscatedName("aa")
	static int field1080;
	@ObfuscatedName("al")
	static int field1081;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lhw;"
	)
	@Export("definition")
	NPCComposition definition;
	@ObfuscatedName("ah")
	@Export("nameChange")
	String nameChange;
	@ObfuscatedName("ao")
	int field1085;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lum;"
	)
	class527 field1087;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lhf;"
	)
	NewShit field1083;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lhf;"
	)
	NewShit field1082;

	static {
		field1080 = 1;
		field1081 = 1;
	}

	NPC() {
		this.nameChange = "";
		this.field1085 = 31;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-983100224"
	)
	void method575(String var1) {
		this.nameChange = var1 == null ? "" : var1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)Lka;",
		garbageValue = "1"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.definition == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? DynamicObject.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence == -1 || super.movementSequence == super.idleSequence && var1 != null ? null : DynamicObject.SequenceDefinition_get(super.movementSequence);
			Model var3 = null;
			if (this.field1083 != null && this.field1083.field1530) {
				var3 = class229.localPlayer.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			} else {
				var3 = this.definition.method940(var1, super.sequenceFrame, var2, super.movementFrame, this.field1083);
			}

			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				int var4 = var3.indicesCount;
				var3 = this.method514(var3);
				if (this.definition.size == 1) {
					var3.isSingleTile = true;
				}

				if (super.recolourAmount != 0 && Client.cycle >= super.recolourStartCycle && Client.cycle < super.recolourEndCycle) {
					var3.overrideHue = super.recolourHue;
					var3.overrideSaturation = super.recolourSaturation;
					var3.overrideLuminance = super.recolourLuminance;
					var3.overrideAmount = super.recolourAmount;
					var3.field2423 = (short)var4;
				} else {
					var3.overrideAmount = 0;
				}

				return var3;
			}
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "804243007"
	)
	void method576(int var1) {
		this.field1085 = var1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1535698170"
	)
	boolean method577(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field1085 & 1 << var1) != 0;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "0"
	)
	final String method578() {
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

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(ILiz;I)V",
		garbageValue = "844868343"
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

		if (super.sequence != -1 && DynamicObject.SequenceDefinition_get(super.sequence).priority == 1) {
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

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(IIZB)V",
		garbageValue = "75"
	)
	final void method581(int var1, int var2, boolean var3) {
		if (super.sequence != -1 && DynamicObject.SequenceDefinition_get(super.sequence).priority == 1) {
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
		super.field1029 = 0;
		super.field1028 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.x = super.pathX[0] * 128 + super.field983 * 64;
		super.y = super.pathY[0] * 128 + super.field983 * 64;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(S)[I",
		garbageValue = "-23200"
	)
	int[] method584() {
		return this.field1087 != null ? this.field1087.method2619() : this.definition.method948();
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)[S",
		garbageValue = "120"
	)
	short[] method585() {
		return this.field1087 != null ? this.field1087.method2620() : this.definition.method950();
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IISI)V",
		garbageValue = "-558766672"
	)
	void method586(int var1, int var2, short var3) {
		if (this.field1087 == null) {
			this.field1087 = new class527(this.definition);
		}

		this.field1087.method2621(var1, var2, var3);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "([I[SI)V",
		garbageValue = "-1790507927"
	)
	void method587(int[] var1, short[] var2) {
		if (this.field1087 == null) {
			this.field1087 = new class527(this.definition);
		}

		this.field1087.method2622(var1, var2);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "0"
	)
	void method588() {
		this.field1087 = null;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lhf;I)V",
		garbageValue = "-906762953"
	)
	void method589(NewShit var1) {
		this.field1082 = var1;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)Lhf;",
		garbageValue = "2"
	)
	NewShit method590() {
		return this.field1082;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Lhf;I)V",
		garbageValue = "-977381781"
	)
	void method591(NewShit var1) {
		this.field1083 = var1;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1221291483"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.definition != null;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-434488190"
	)
	void method592() {
		this.field1082 = null;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-923674269"
	)
	void method593() {
		this.field1083 = null;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;IZB)I",
		garbageValue = "-22"
	)
	public static int method580(CharSequence var0, int var1, boolean var2) {
		if (var1 >= 2 && var1 <= 36) {
			boolean var3 = false;
			boolean var4 = false;
			int var5 = 0;
			int var6 = var0.length();

			for (int var7 = 0; var7 < var6; ++var7) {
				char var8 = var0.charAt(var7);
				if (var7 == 0) {
					if (var8 == '-') {
						var3 = true;
						continue;
					}

					if (var8 == '+') {
						continue;
					}
				}

				int var10;
				if (var8 >= '0' && var8 <= '9') {
					var10 = var8 - '0';
				} else if (var8 >= 'A' && var8 <= 'Z') {
					var10 = var8 - '7';
				} else {
					if (var8 < 'a' || var8 > 'z') {
						throw new NumberFormatException();
					}

					var10 = var8 - 'W';
				}

				if (var10 >= var1) {
					throw new NumberFormatException();
				}

				if (var3) {
					var10 = -var10;
				}

				int var9 = var5 * var1 + var10;
				if (var9 / var1 != var5) {
					throw new NumberFormatException();
				}

				var5 = var9;
				var4 = true;
			}

			if (!var4) {
				throw new NumberFormatException();
			} else {
				return var5;
			}
		} else {
			throw new IllegalArgumentException("" + var1);
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-1588641318"
	)
	static final int method595(int var0, int var1) {
		int var2 = var0 + var1 * 57;
		var2 ^= var2 << 13;
		int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
		return var3 >> 19 & 255;
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(Lbk;I)V",
		garbageValue = "2109670231"
	)
	@Export("PcmStream_disable")
	static final void PcmStream_disable(PcmStream var0) {
		var0.active = false;
		if (var0.sound != null) {
			var0.sound.position = 0;
		}

		for (PcmStream var1 = var0.firstSubStream(); var1 != null; var1 = var0.nextSubStream()) {
			PcmStream_disable(var1);
		}

	}
}