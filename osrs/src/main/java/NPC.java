import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("NPC")
public final class NPC extends Actor {
	@ObfuscatedName("ag")
	static int field1068;
	@ObfuscatedName("av")
	static int field1069;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lhi;"
	)
	@Export("definition")
	NPCComposition definition;
	@ObfuscatedName("ay")
	@Export("nameChange")
	String nameChange;
	@ObfuscatedName("am")
	int field1073;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Ltr;"
	)
	class514 field1075;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lhs;"
	)
	NewShit field1071;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lhs;"
	)
	NewShit field1072;

	static {
		field1068 = 1;
		field1069 = 1;
	}

	NPC() {
		this.nameChange = "";
		this.field1073 = 31;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-265998562"
	)
	void method582(String var1) {
		this.nameChange = var1 == null ? "" : var1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Ljo;",
		garbageValue = "-983173466"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.definition == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? class135.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence != -1 && (super.movementSequence != super.idleSequence || var1 == null) ? class135.SequenceDefinition_get(super.movementSequence) : null;
			Model var3 = null;
			if (this.field1071 != null && this.field1071.field1565) {
				var3 = class136.localPlayer.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			} else {
				var3 = this.definition.method966(var1, super.sequenceFrame, var2, super.movementFrame, this.field1071);
			}

			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				int var4 = var3.indicesCount;
				var3 = this.method525(var3);
				if (this.definition.size == 1) {
					var3.isSingleTile = true;
				}

				if (super.recolourAmount != 0 && Client.cycle >= super.recolourStartCycle && Client.cycle < super.recolourEndCycle) {
					var3.overrideHue = super.recolourHue;
					var3.overrideSaturation = super.recolourSaturation;
					var3.overrideLuminance = super.recolourLuminance;
					var3.overrideAmount = super.recolourAmount;
					var3.field2219 = (short)var4;
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
		garbageValue = "1401431099"
	)
	void method584(int var1) {
		this.field1073 = var1;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1268295960"
	)
	boolean method585(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field1073 & 1 << var1) != 0;
		} else {
			return true;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "2003079034"
	)
	final String method586() {
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

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(ILio;I)V",
		garbageValue = "69019912"
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

		if (super.sequence != -1 && class135.SequenceDefinition_get(super.sequence).priority == 1) {
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

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(IIZB)V",
		garbageValue = "0"
	)
	final void method588(int var1, int var2, boolean var3) {
		if (super.sequence != -1 && class135.SequenceDefinition_get(super.sequence).priority == 1) {
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
		super.field1018 = 0;
		super.field1020 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.x = super.field976 * 64 + super.pathX[0] * 128;
		super.y = super.field976 * 64 + super.pathY[0] * 128;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-1083968241"
	)
	int[] method591() {
		return this.field1075 != null ? this.field1075.method2583() : this.definition.method974();
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(B)[S",
		garbageValue = "77"
	)
	short[] method592() {
		return this.field1075 != null ? this.field1075.method2584() : this.definition.method976();
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IISB)V",
		garbageValue = "0"
	)
	void method593(int var1, int var2, short var3) {
		if (this.field1075 == null) {
			this.field1075 = new class514(this.definition);
		}

		this.field1075.method2585(var1, var2, var3);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "([I[SI)V",
		garbageValue = "-1811218204"
	)
	void method594(int[] var1, short[] var2) {
		if (this.field1075 == null) {
			this.field1075 = new class514(this.definition);
		}

		this.field1075.method2586(var1, var2);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1565977870"
	)
	void method595() {
		this.field1075 = null;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lhs;I)V",
		garbageValue = "-1331713030"
	)
	void method596(NewShit var1) {
		this.field1072 = var1;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Lhs;",
		garbageValue = "-1510314469"
	)
	NewShit method597() {
		return this.field1072;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lhs;I)V",
		garbageValue = "-1722306850"
	)
	void method598(NewShit var1) {
		this.field1071 = var1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "0"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.definition != null;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-883060880"
	)
	void method599() {
		this.field1072 = null;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1751428186"
	)
	void method600() {
		this.field1071 = null;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZZB)V",
		garbageValue = "-9"
	)
	@Export("openURL")
	public static void openURL(String var0, boolean var1, boolean var2) {
		if (var1) {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI(var0));
					return;
				} catch (Exception var4) {
				}
			}

			if (class31.field86.startsWith("win")) {
				class351.method1840(var0, 0, "openjs");
			} else if (class31.field86.startsWith("mac")) {
				class351.method1840(var0, 1, "openjs");
			} else {
				class351.method1840(var0, 2, "openjs");
			}
		} else {
			class351.method1840(var0, 3, "openjs");
		}

	}
}
