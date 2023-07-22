import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("FriendSystem")
public class FriendSystem {
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lsi;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lqp;"
	)
	@Export("friendsList")
	public final FriendsList friendsList;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lqm;"
	)
	@Export("ignoreList")
	public final IgnoreList ignoreList;
	@ObfuscatedName("ag")
	int friendListStatus;

	@ObfuscatedSignature(
		descriptor = "(Lsi;)V"
	)
	FriendSystem(LoginType var1) {
		this.friendListStatus = 0;
		this.loginType = var1;
		this.friendsList = new FriendsList(var1);
		this.ignoreList = new IgnoreList(var1);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "106"
	)
	boolean method406() {
		return this.friendListStatus == 2;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "109"
	)
	final void setFriendListToLoaded() {
		this.friendListStatus = 1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lty;II)V",
		garbageValue = "1175550458"
	)
	@Export("readUpdate")
	final void readUpdate(Buffer var1, int var2) {
		this.friendsList.read(var1, var2);
		this.friendListStatus = 2;

		for (int var3 = 0; var3 < Players.Players_count; ++var3) {
			Player var4 = Client.players[Players.Players_indices[var3]];
			var4.clearIsFriend();
		}

		class106.method619();
		if (Canvas.friendsChat != null) {
			Canvas.friendsChat.clearFriends();
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-119"
	)
	@Export("processFriendUpdates")
	final void processFriendUpdates() {
		for (FriendLoginUpdate var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (FriendLoginUpdate)this.friendsList.friendLoginUpdates.previous()) {
			if ((long)var1.field3784 < class113.clockNow() / 1000L - 5L) {
				if (var1.worldId > 0) {
					class415.addGameMessage(5, "", var1.friendUsername + " has logged in.");
				}

				if (var1.worldId == 0) {
					class415.addGameMessage(5, "", var1.friendUsername + " has logged out.");
				}

				var1.remove();
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1126290435"
	)
	@Export("clear")
	final void clear() {
		this.friendListStatus = 0;
		this.friendsList.clear();
		this.ignoreList.clear();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lui;ZB)Z",
		garbageValue = "77"
	)
	@Export("isFriended")
	final boolean isFriended(Username var1, boolean var2) {
		if (var1 == null) {
			return false;
		} else if (var1.equals(class136.localPlayer.username)) {
			return true;
		} else {
			return this.friendsList.isFriended(var1, var2);
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Lui;I)Z",
		garbageValue = "1453652382"
	)
	@Export("isIgnored")
	final boolean isIgnored(Username var1) {
		if (var1 == null) {
			return false;
		} else {
			return this.ignoreList.contains(var1);
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "119"
	)
	@Export("addFriend")
	final void addFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsListIsFull()) {
					Tile.method1160("Your friend list is full. Max of 200 for free users, and 400 for members");
				} else if (class136.localPlayer.username.equals(var2)) {
					class220.method1126();
				} else if (this.isFriended(var2, false)) {
					WorldMapSectionType.method1481(var1);
				} else if (this.isIgnored(var2)) {
					Tile.method1160("Please remove " + var1 + " from your ignore list first");
				} else {
					Canvas.method83(var1);
				}
			}
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-30"
	)
	@Export("friendsListIsFull")
	final boolean friendsListIsFull() {
		return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.isMembers != 1;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "109"
	)
	@Export("addIgnore")
	final void addIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.canAddIgnore()) {
					UserComparator5.method672();
				} else if (class136.localPlayer.username.equals(var2)) {
					Tile.method1160("You can't add yourself to your own ignore list");
				} else if (this.isIgnored(var2)) {
					MusicPatchNode.method1660(var1);
				} else if (this.isFriended(var2, false)) {
					Tile.method1160("Please remove " + var1 + " from your friend list first");
				} else {
					ItemContainer.method467(var1);
				}
			}
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-876943227"
	)
	@Export("canAddIgnore")
	final boolean canAddIgnore() {
		return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.isMembers != 1;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "1474613294"
	)
	@Export("removeFriend")
	final void removeFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsList.removeByUsername(var2)) {
					Client.field516 = Client.cycleCntr;
					PacketBufferNode var3 = class503.getPacketBufferNode(ClientPacket.field2503, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class501.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				for (int var5 = 0; var5 < Players.Players_count; ++var5) {
					Player var4 = Client.players[Players.Players_indices[var5]];
					var4.clearIsFriend();
				}

				class106.method619();
				if (Canvas.friendsChat != null) {
					Canvas.friendsChat.clearFriends();
				}

			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZB)V",
		garbageValue = "-31"
	)
	@Export("removeIgnore")
	public final void removeIgnore(String var1, boolean var2) {
		if (var1 != null) {
			Username var3 = new Username(var1, this.loginType);
			if (var3.hasCleanName()) {
				if (this.ignoreList.removeByUsername(var3)) {
					Client.field516 = Client.cycleCntr;
					if (var2) {
						PacketBufferNode var4 = class503.getPacketBufferNode(ClientPacket.field2534, Client.packetWriter.isaacCipher);
						var4.packetBuffer.writeByte(class501.stringCp1252NullTerminatedByteSize(var1));
						var4.packetBuffer.writeStringCp1252NullTerminated(var1);
						Client.packetWriter.addNode(var4);
					}
				}

				GameBuild.FriendSystem_invalidateIgnoreds();
			}
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lui;B)Z",
		garbageValue = "24"
	)
	@Export("isFriendAndHasWorld")
	final boolean isFriendAndHasWorld(Username var1) {
		Friend var2 = (Friend)this.friendsList.getByUsername(var1);
		return var2 != null && var2.hasWorld();
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZI)I",
		garbageValue = "-1211828959"
	)
	static int method420(int var0, Script var1, boolean var2) {
		String var3;
		int var4;
		if (var0 == 4100) {
			var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
			var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + var4;
			return 1;
		} else {
			String var9;
			if (var0 == 4101) {
				Interpreter.Interpreter_stringStackSize -= 2;
				var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
				var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + var9;
				return 1;
			} else if (var0 == 4102) {
				var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + class509.intToString(var4, true);
				return 1;
			} else if (var0 == 4103) {
				var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.toLowerCase();
				return 1;
			} else {
				int var6;
				int var10;
				if (var0 == 4104) {
					var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					long var11 = (11745L + (long)var10) * 86400000L;
					Interpreter.Interpreter_calendar.setTime(new Date(var11));
					var6 = Interpreter.Interpreter_calendar.get(5);
					int var17 = Interpreter.Interpreter_calendar.get(2);
					int var8 = Interpreter.Interpreter_calendar.get(1);
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var17] + "-" + var8;
					return 1;
				} else if (var0 != 4105) {
					if (var0 == 4106) {
						var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Integer.toString(var10);
						return 1;
					} else if (var0 == 4107) {
						Interpreter.Interpreter_stringStackSize -= 2;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOfferTotalQuantityComparator.method1909(FloorOverlayDefinition.compareStrings(Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1], Interpreter.clientLanguage));
						return 1;
					} else {
						int var5;
						byte[] var13;
						Font var14;
						if (var0 == 4108) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							Interpreter.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							var13 = FontName.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
							return 1;
						} else if (var0 == 4109) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							Interpreter.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							var13 = FontName.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
							return 1;
						} else if (var0 == 4110) {
							Interpreter.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
							if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
							} else {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9;
							}

							return 1;
						} else if (var0 == 4111) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
							return 1;
						} else if (var0 == 4112) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + (char)var4;
							return 1;
						} else if (var0 == 4113) {
							var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ChatChannel.isCharPrintable((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4114) {
							var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class126.isAlphaNumeric((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4115) {
							var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Canvas.isCharAlphabetic((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4116) {
							var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class164.isDigit((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4117) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							if (var3 != null) {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.length();
							} else {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							}

							return 1;
						} else if (var0 == 4118) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							Interpreter.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
							return 1;
						} else if (var0 == 4119) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							StringBuilder var18 = new StringBuilder(var3.length());
							boolean var16 = false;

							for (var6 = 0; var6 < var3.length(); ++var6) {
								char var7 = var3.charAt(var6);
								if (var7 == '<') {
									var16 = true;
								} else if (var7 == '>') {
									var16 = false;
								} else if (!var16) {
									var18.append(var7);
								}
							}

							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var18.toString();
							return 1;
						} else if (var0 == 4120) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.indexOf(var4);
							return 1;
						} else if (var0 == 4121) {
							Interpreter.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
							var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
							return 1;
						} else if (var0 == 4122) {
							var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.toUpperCase();
							return 1;
						} else if (var0 == 4123) {
							Interpreter.Interpreter_stringStackSize -= 3;
							var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
							String var15 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 2];
							if (class136.localPlayer.appearance == null) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var15;
								return 1;
							} else {
								switch(class136.localPlayer.appearance.field2899) {
								case 0:
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
									break;
								case 1:
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9;
									break;
								case 2:
								default:
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var15;
								}

								return 1;
							}
						} else {
							return 2;
						}
					}
				} else {
					Interpreter.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
					var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
					if (class136.localPlayer.appearance != null && class136.localPlayer.appearance.field2900 != 0) {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9;
					} else {
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("lq")
	@ObfuscatedSignature(
		descriptor = "(Lmt;IIZI)V",
		garbageValue = "-593729074"
	)
	@Export("alignWidgetSize")
	static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
		int var4 = var0.width;
		int var5 = var0.height;
		if (var0.widthAlignment == 0) {
			var0.width = var0.rawWidth;
		} else if (var0.widthAlignment == 1) {
			var0.width = var1 - var0.rawWidth;
		} else if (var0.widthAlignment == 2) {
			var0.width = var0.rawWidth * var1 >> 14;
		}

		if (var0.heightAlignment == 0) {
			var0.height = var0.rawHeight;
		} else if (var0.heightAlignment == 1) {
			var0.height = var2 - var0.rawHeight;
		} else if (var0.heightAlignment == 2) {
			var0.height = var2 * var0.rawHeight >> 14;
		}

		if (var0.widthAlignment == 4) {
			var0.width = var0.height * var0.field2990 / var0.field2981;
		}

		if (var0.heightAlignment == 4) {
			var0.height = var0.width * var0.field2981 / var0.field2990;
		}

		if (var0.contentType == 1337) {
			Client.viewportWidget = var0;
		}

		if (var0.type == 12) {
			var0.method1805().method1699(var0.width, var0.height);
		}

		if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) {
			ScriptEvent var6 = new ScriptEvent();
			var6.widget = var0;
			var6.args = var0.onResize;
			Client.scriptEvents.addFirst(var6);
		}

	}
}
