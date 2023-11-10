import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ObfuscatedName("az")
public class class9 implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Laz;"
	)
	public static final class9 field22;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Laz;"
	)
	public static final class9 field21;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Laz;"
	)
	static final class9 field25;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Laz;"
	)
	static final class9 field24;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Laz;"
	)
	static final class9 field23;
	@ObfuscatedName("au")
	int field28;
	@ObfuscatedName("aa")
	String field29;
	@ObfuscatedName("ac")
	boolean field26;
	@ObfuscatedName("al")
	boolean field27;

	static {
		field22 = new class9(0, "POST", true, true);
		field21 = new class9(1, "GET", true, false);
		field25 = new class9(2, "PUT", false, true);
		field24 = new class9(3, "PATCH", false, true);
		field23 = new class9(4, "DELETE", false, true);
	}

	class9(int var1, String var2, boolean var3, boolean var4) {
		this.field28 = var1;
		this.field29 = var2;
		this.field26 = var3;
		this.field27 = var4;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-82"
	)
	boolean method23() {
		return this.field26;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field28;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "62"
	)
	public String method24() {
		return this.field29;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1331729662"
	)
	boolean method25() {
		return this.field27;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Luo;IB)V",
		garbageValue = "10"
	)
	@Export("readPlayerUpdate")
	static void readPlayerUpdate(PacketBuffer var0, int var1) {
		boolean var2 = var0.readBits(1) == 1;
		if (var2) {
			Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
		}

		int var3 = var0.readBits(2);
		Player var4 = Client.players[var1];
		if (var3 == 0) {
			if (var2) {
				var4.hasMovementPending = false;
			} else if (Client.localPlayerIndex == var1) {
				throw new RuntimeException();
			} else {
				Players.Players_regions[var1] = (var4.plane << 28) + (class101.baseY + var4.pathY[0] >> 13) + (NewShit.baseX + var4.pathX[0] >> 13 << 14);
				if (var4.movingOrientation != -1) {
					Players.Players_orientations[var1] = var4.movingOrientation;
				} else {
					Players.Players_orientations[var1] = var4.orientation;
				}

				Players.Players_targetIndices[var1] = var4.targetIndex;
				Client.players[var1] = null;
				if (var0.readBits(1) != 0) {
					Buddy.updateExternalPlayer(var0, var1);
				}

			}
		} else {
			int var5;
			int var6;
			int var7;
			if (var3 == 1) {
				var5 = var0.readBits(3);
				var6 = var4.pathX[0];
				var7 = var4.pathY[0];
				if (var5 == 0) {
					--var6;
					--var7;
				} else if (var5 == 1) {
					--var7;
				} else if (var5 == 2) {
					++var6;
					--var7;
				} else if (var5 == 3) {
					--var6;
				} else if (var5 == 4) {
					++var6;
				} else if (var5 == 5) {
					--var6;
					++var7;
				} else if (var5 == 6) {
					++var7;
				} else if (var5 == 7) {
					++var6;
					++var7;
				}

				if (Client.localPlayerIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
					var4.resetPath(var6, var7);
					var4.hasMovementPending = false;
				} else if (var2) {
					var4.hasMovementPending = true;
					var4.tileX = var6;
					var4.tileY = var7;
				} else {
					var4.hasMovementPending = false;
					var4.move(var6, var7, Players.playerMovementSpeeds[var1]);
				}

			} else if (var3 == 2) {
				var5 = var0.readBits(4);
				var6 = var4.pathX[0];
				var7 = var4.pathY[0];
				if (var5 == 0) {
					var6 -= 2;
					var7 -= 2;
				} else if (var5 == 1) {
					--var6;
					var7 -= 2;
				} else if (var5 == 2) {
					var7 -= 2;
				} else if (var5 == 3) {
					++var6;
					var7 -= 2;
				} else if (var5 == 4) {
					var6 += 2;
					var7 -= 2;
				} else if (var5 == 5) {
					var6 -= 2;
					--var7;
				} else if (var5 == 6) {
					var6 += 2;
					--var7;
				} else if (var5 == 7) {
					var6 -= 2;
				} else if (var5 == 8) {
					var6 += 2;
				} else if (var5 == 9) {
					var6 -= 2;
					++var7;
				} else if (var5 == 10) {
					var6 += 2;
					++var7;
				} else if (var5 == 11) {
					var6 -= 2;
					var7 += 2;
				} else if (var5 == 12) {
					--var6;
					var7 += 2;
				} else if (var5 == 13) {
					var7 += 2;
				} else if (var5 == 14) {
					++var6;
					var7 += 2;
				} else if (var5 == 15) {
					var6 += 2;
					var7 += 2;
				}

				if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
					if (var2) {
						var4.hasMovementPending = true;
						var4.tileX = var6;
						var4.tileY = var7;
					} else {
						var4.hasMovementPending = false;
						var4.move(var6, var7, Players.playerMovementSpeeds[var1]);
					}
				} else {
					var4.resetPath(var6, var7);
					var4.hasMovementPending = false;
				}

			} else {
				var5 = var0.readBits(1);
				int var8;
				int var9;
				int var10;
				int var11;
				if (var5 == 0) {
					var6 = var0.readBits(12);
					var7 = var6 >> 10;
					var8 = var6 >> 5 & 31;
					if (var8 > 15) {
						var8 -= 32;
					}

					var9 = var6 & 31;
					if (var9 > 15) {
						var9 -= 32;
					}

					var10 = var8 + var4.pathX[0];
					var11 = var9 + var4.pathY[0];
					if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
						if (var2) {
							var4.hasMovementPending = true;
							var4.tileX = var10;
							var4.tileY = var11;
						} else {
							var4.hasMovementPending = false;
							var4.move(var10, var11, Players.playerMovementSpeeds[var1]);
						}
					} else {
						var4.resetPath(var10, var11);
						var4.hasMovementPending = false;
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						ItemLayer.Client_plane = var4.plane;
					}

				} else {
					var6 = var0.readBits(30);
					var7 = var6 >> 28;
					var8 = var6 >> 14 & 16383;
					var9 = var6 & 16383;
					var10 = (var8 + NewShit.baseX + var4.pathX[0] & 16383) - NewShit.baseX;
					var11 = (var9 + class101.baseY + var4.pathY[0] & 16383) - class101.baseY;
					if (Client.localPlayerIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
						var4.resetPath(var10, var11);
						var4.hasMovementPending = false;
					} else if (var2) {
						var4.hasMovementPending = true;
						var4.tileX = var10;
						var4.tileY = var11;
					} else {
						var4.hasMovementPending = false;
						var4.move(var10, var11, Players.playerMovementSpeeds[var1]);
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						ItemLayer.Client_plane = var4.plane;
					}

				}
			}
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONObject;Ljava/lang/String;I)[F",
		garbageValue = "-257144128"
	)
	static float[] method27(JSONObject var0, String var1) throws JSONException {
		float[] var2 = new float[4];

		try {
			JSONArray var3 = var0.getJSONArray(var1);
			var2[0] = (float)var3.optDouble(0, 0.0D);
			var2[1] = (float)var3.optDouble(1, 0.0D);
			var2[2] = (float)var3.optDouble(2, 1.0D);
			var2[3] = (float)var3.optDouble(3, 1.0D);
		} catch (JSONException var4) {
			var2[0] = 0.0F;
			var2[1] = 0.0F;
			var2[2] = 1.0F;
			var2[3] = 1.0F;
		}

		return var2;
	}

	@ObfuscatedName("hd")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "77503344"
	)
	static final void method29() {
		if (Client.logoutTimer > 0) {
			class13.method51();
		} else {
			Client.timer.method2171();
			WorldMapSection2.updateGameState(40);
			class4.field4 = Client.packetWriter.getSocket();
			Client.packetWriter.removeSocket();
		}
	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "416478591"
	)
	@Export("doCheat")
	static final void doCheat(String var0) {
		if (var0.equalsIgnoreCase("toggleroof")) {
			WorldMapIcon_1.clientPreferences.setRoofsHidden(!WorldMapIcon_1.clientPreferences.getRoofsHidden());
			if (WorldMapIcon_1.clientPreferences.getRoofsHidden()) {
				GrandExchangeOfferUnitPriceComparator.addGameMessage(99, "", "Roofs are now all hidden");
			} else {
				GrandExchangeOfferUnitPriceComparator.addGameMessage(99, "", "Roofs will only be removed selectively");
			}
		}

		if (var0.startsWith("zbuf")) {
			boolean var1 = Huffman.method1888(var0.substring(5).trim()) == 1;
			SpriteMask.client.method161(var1);
			Rasterizer3D.method1413(var1);
		}

		if (var0.equalsIgnoreCase("z")) {
			Client.renderSelf = !Client.renderSelf;
		}

		if (var0.equalsIgnoreCase("displayfps")) {
			WorldMapIcon_1.clientPreferences.method546();
		}

		if (var0.equalsIgnoreCase("renderself")) {
			Client.field387 = !Client.field387;
		}

		if (var0.equalsIgnoreCase("mouseovertext")) {
			Client.showMouseOverText = !Client.showMouseOverText;
		}

		if (Client.staffModLevel >= 2) {
			if (var0.equalsIgnoreCase("errortest")) {
				throw new RuntimeException();
			}

			if (var0.equalsIgnoreCase("showcoord")) {
				NewShit.worldMap.showCoord = !NewShit.worldMap.showCoord;
			}

			if (var0.equalsIgnoreCase("fpson")) {
				WorldMapIcon_1.clientPreferences.method545(true);
			}

			if (var0.equalsIgnoreCase("fpsoff")) {
				WorldMapIcon_1.clientPreferences.method545(false);
			}

			if (var0.equalsIgnoreCase("gc")) {
				System.gc();
			}

			if (var0.equalsIgnoreCase("clientdrop")) {
				method29();
			}
		}

		PacketBufferNode var2 = class113.getPacketBufferNode(ClientPacket.DOCHEAT, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeByte(var0.length() + 1);
		var2.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.addNode(var2);
	}

	@ObfuscatedName("ip")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1070211689"
	)
	@Export("setWindowedMode")
	static void setWindowedMode(int var0) {
		Client.field613 = 0L;
		if (var0 >= 2) {
			Client.isResizable = true;
		} else {
			Client.isResizable = false;
		}

		if (ApproximateRouteStrategy.getWindowedMode() == 1) {
			SpriteMask.client.setMaxCanvasSize(765, 503);
		} else {
			SpriteMask.client.setMaxCanvasSize(7680, 2160);
		}

		if (Client.gameState >= 25 && Client.packetWriter != null && Client.packetWriter.isaacCipher != null) {
			PacketBufferNode var1 = class113.getPacketBufferNode(ClientPacket.EVENT_MOUSE_IDLE, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(ApproximateRouteStrategy.getWindowedMode());
			var1.packetBuffer.writeShort(Language.canvasWidth);
			var1.packetBuffer.writeShort(class47.canvasHeight);
			Client.packetWriter.addNode(var1);
		}

	}
}