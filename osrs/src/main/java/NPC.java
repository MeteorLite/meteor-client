import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("NPC")
public final class NPC extends Actor {
	@ObfuscatedName("fp")
	@ObfuscatedGetter(
		intValue = -1899913385
	)
	@Export("worldPort")
	static int worldPort;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lfs;"
	)
	@Export("definition")
	NPCComposition definition;
	@ObfuscatedName("p")
	String field1254;

	NPC() {
		this.field1254 = "";
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-76109777"
	)
	void method2513(String var1) {
		this.field1254 = var1 == null ? "" : var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)Lha;",
		garbageValue = "13"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.definition == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? class4.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence == -1 || super.movementSequence == super.idleSequence && var1 != null ? null : class4.SequenceDefinition_get(super.movementSequence);
			Model var3 = this.definition.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			if (var3 == null) {
				return null;
			} else {
				var3.calculateBoundsCylinder();
				super.defaultHeight = var3.height;
				int var4 = var3.indicesCount;
				if (super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
					Model var5 = class308.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
					if (var5 != null) {
						var5.offsetBy(0, -super.field1145, 0);
						Model[] var6 = new Model[]{var3, var5};
						var3 = new Model(var6, 2);
					}
				}

				if (this.definition.size == 1) {
					var3.isSingleTile = true;
				}

				if (super.field1194 != 0 && Client.cycle >= super.field1188 && Client.cycle < super.field1158) {
					var3.overrideHue = super.field1190;
					var3.overrideSaturation = super.field1191;
					var3.overrideLuminance = super.field1169;
					var3.overrideAmount = super.field1194;
					var3.field2618 = (short)var4;
				} else {
					var3.overrideAmount = 0;
				}

				return var3;
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "1787135628"
	)
	final String method2505() {
		if (!this.field1254.isEmpty()) {
			return this.field1254;
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

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(ILga;I)V",
		garbageValue = "2110529559"
	)
	final void method2510(int var1, class193 var2) {
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

		if (super.sequence != -1 && class4.SequenceDefinition_get(super.sequence).field2218 == 1) {
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

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(IIZB)V",
		garbageValue = "-40"
	)
	final void method2507(int var1, int var2, boolean var3) {
		if (super.sequence != -1 && class4.SequenceDefinition_get(super.sequence).field2218 == 1) {
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
				super.pathTraversed[0] = class193.field2246;
				return;
			}
		}

		super.pathLength = 0;
		super.field1202 = 0;
		super.field1201 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.x = super.field1131 * -360448000 + super.pathX[0] * 128;
		super.y = super.field1131 * -360448000 + super.pathY[0] * 128;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-77"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.definition != null;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-5"
	)
	static void method2528() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var0.obj != null) {
				var0.set();
			}
		}

	}

	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1983499596"
	)
	static final void method2511(int var0) {
		var0 = Math.min(Math.max(var0, 0), 255);
		if (var0 != Player.clientPreferences.method2402()) {
			if (Player.clientPreferences.method2402() == 0 && Client.currentTrackGroupId != -1) {
				Message.method1164(class14.archive6, Client.currentTrackGroupId, 0, var0, false);
				Client.playingJingle = false;
			} else if (var0 == 0) {
				class17.method267();
				Client.playingJingle = false;
			} else if (class274.musicPlayerStatus != 0) {
				class269.musicTrackVolume = var0;
			} else {
				class139.midiPcmStream.setPcmStreamVolume(var0);
			}

			Player.clientPreferences.method2449(var0);
		}

	}
}
