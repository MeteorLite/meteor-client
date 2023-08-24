import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("NPC")
public final class NPC extends Actor {
	@ObfuscatedName("az")
	static int field1075;
	@ObfuscatedName("aa")
	static int field1074;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lhw;"
	)
	@Export("definition")
	NPCComposition definition;
	@ObfuscatedName("ae")
	@Export("nameChange")
	String nameChange;
	@ObfuscatedName("at")
	int field1079;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Ltw;"
	)
	class515 field1081;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lhq;"
	)
	NewShit field1076;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lhq;"
	)
	NewShit field1077;

	static {
		field1075 = 1;
		field1074 = 1;
	}

	NPC() {
		this.nameChange = "";
		this.field1079 = 31;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-1576222812"
	)
	void method577(String var1) {
		this.nameChange = var1 == null ? "" : var1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)Ljr;",
		garbageValue = "798227647"
	)
	@Export("getModel")
	protected final Model getModel() {
		if (this.definition == null) {
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? EnumComposition.SequenceDefinition_get(super.sequence) : null;
			SequenceDefinition var2 = super.movementSequence == -1 || super.idleSequence == super.movementSequence && var1 != null ? null : EnumComposition.SequenceDefinition_get(super.movementSequence);
			Model var3 = null;
			if (this.field1076 != null && this.field1076.field1581) {
				var3 = VarbitComposition.localPlayer.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
			} else {
				var3 = this.definition.method985(var1, super.sequenceFrame, var2, super.movementFrame, this.field1076);
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
					var3.field2243 = (short)var4;
				} else {
					var3.overrideAmount = 0;
				}

				return var3;
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-979887943"
	)
	void method579(int var1) {
		this.field1079 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1723224473"
	)
	boolean method580(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field1079 & 1 << var1) != 0;
		} else {
			return true;
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-1406418583"
	)
	final String method581() {
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

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(ILin;I)V",
		garbageValue = "1389933188"
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

		if (super.sequence != -1 && EnumComposition.SequenceDefinition_get(super.sequence).priority == 1) {
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

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(IIZI)V",
		garbageValue = "-2120679358"
	)
	final void method583(int var1, int var2, boolean var3) {
		if (super.sequence != -1 && EnumComposition.SequenceDefinition_get(super.sequence).priority == 1) {
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
		super.field1022 = 0;
		super.field1021 = 0;
		super.pathX[0] = var1;
		super.pathY[0] = var2;
		super.x = super.field976 * 64 + super.pathX[0] * 128;
		super.y = super.pathY[0] * 128 + super.field976 * 64;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "2108949560"
	)
	int[] method587() {
		return this.field1081 != null ? this.field1081.method2602() : this.definition.method993();
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(S)[S",
		garbageValue = "17216"
	)
	short[] method588() {
		return this.field1081 != null ? this.field1081.method2603() : this.definition.method995();
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IISI)V",
		garbageValue = "-1331637163"
	)
	void method589(int var1, int var2, short var3) {
		if (this.field1081 == null) {
			this.field1081 = new class515(this.definition);
		}

		this.field1081.method2604(var1, var2, var3);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "([I[SI)V",
		garbageValue = "1783936038"
	)
	void method590(int[] var1, short[] var2) {
		if (this.field1081 == null) {
			this.field1081 = new class515(this.definition);
		}

		this.field1081.method2605(var1, var2);
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "707622194"
	)
	void method591() {
		this.field1081 = null;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lhq;I)V",
		garbageValue = "244947071"
	)
	void method592(NewShit var1) {
		this.field1077 = var1;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Lhq;",
		garbageValue = "1386769503"
	)
	NewShit method593() {
		return this.field1077;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Lhq;B)V",
		garbageValue = "-37"
	)
	void method594(NewShit var1) {
		this.field1076 = var1;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "381940201"
	)
	@Export("isVisible")
	final boolean isVisible() {
		return this.definition != null;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1283231682"
	)
	void method595() {
		this.field1077 = null;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "58"
	)
	void method596() {
		this.field1076 = null;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-1698780109"
	)
	public static int method578(int var0, int var1) {
		int var2;
		for (var2 = 1; var1 > 1; var1 >>= 1) {
			if ((var1 & 1) != 0) {
				var2 = var0 * var2;
			}

			var0 *= var0;
		}

		if (var1 == 1) {
			return var0 * var2;
		} else {
			return var2;
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ldy;IIB)V",
		garbageValue = "-51"
	)
	@Export("runScript")
	static void runScript(ScriptEvent var0, int var1, int var2) {
		Object[] var3 = var0.args;
		Script var4;
		if (SongTask.isWorldMapEvent(var0.type)) {
			GrandExchangeOfferOwnWorldComparator.worldMapEvent = (WorldMapEvent)var3[0];
			WorldMapElement var5 = class138.WorldMapElement_get(GrandExchangeOfferOwnWorldComparator.worldMapEvent.mapElement);
			var4 = GrandExchangeOfferWorldComparator.getWorldMapScript(var0.type, var5.objectId, var5.category);
		} else {
			int var6 = (Integer)var3[0];
			var4 = class133.getScript(var6);
		}

		if (var4 != null) {
			class147.runScriptLogic(var0, var4, var1, var2);
		}

	}

	@ObfuscatedName("on")
	@ObfuscatedSignature(
		descriptor = "(IIIZB)V",
		garbageValue = "-59"
	)
	public static void method597(int var0, int var1, int var2, boolean var3) {
		PacketBufferNode var4 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.TELEPORT, Client.packetWriter.isaacCipher);
		var4.packetBuffer.writeByteNeg(var2);
		var4.packetBuffer.writeShort(var1);
		var4.packetBuffer.writeIntIME(var3 ? Client.field476 * -1700661189 * -770825997 : 0);
		var4.packetBuffer.writeShortAdd(var0);
		Client.packetWriter.addNode(var4);
	}
}