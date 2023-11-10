import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
	@ObfuscatedName("au")
	@Export("PcmPlayer_stereo")
	public static boolean PcmPlayer_stereo;
	@ObfuscatedName("at")
	@Export("width")
	int width;
	@ObfuscatedName("ah")
	@Export("height")
	int height;
	@ObfuscatedName("ar")
	@Export("x")
	int x;
	@ObfuscatedName("ao")
	@Export("y")
	int y;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Ljf;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final WorldMapManager this$0;

	@ObfuscatedSignature(
		descriptor = "(Ljf;)V"
	)
	WorldMapRectangle(WorldMapManager var1) {
		this.this$0 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1725155859"
	)
	static int method1326() {
		return class28.KeyHandler_keyCodes.length;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "-373966383"
	)
	static int method1327(int var0, Script var1, boolean var2) {
		boolean var3 = true;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = HealthBarDefinition.widgetDefinition.method1733(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
			var3 = false;
		} else {
			var4 = var2 ? Interpreter.scriptDotWidget : HealthBar.scriptActiveWidget;
		}

		int var11;
		if (var0 == 1300) {
			var11 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] - 1;
			if (var11 >= 0 && var11 <= 9) {
				var4.setAction(var11, Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize]);
				return 1;
			} else {
				--class127.Interpreter_stringStackSize;
				return 1;
			}
		} else {
			int var6;
			if (var0 == 1301) {
				DbTableType.Interpreter_intStackSize -= 2;
				var11 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
				var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
				var4.parent = HealthBarDefinition.widgetDefinition.getWidgetChild(var11, var6);
				return 1;
			} else if (var0 == 1302) {
				var4.isScrollBar = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
				return 1;
			} else if (var0 == 1303) {
				var4.dragZoneSize = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				return 1;
			} else if (var0 == 1304) {
				var4.dragThreshold = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				return 1;
			} else if (var0 == 1305) {
				var4.dataText = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == 1306) {
				var4.spellActionName = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == 1307) {
				var4.actions = null;
				return 1;
			} else if (var0 == 1308) {
				var4.prioritizeMenuEntry = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
				return 1;
			} else if (var0 == 1309) {
				--DbTableType.Interpreter_intStackSize;
				return 1;
			} else {
				int var7;
				byte[] var9;
				if (var0 != 1350) {
					byte var5;
					if (var0 == 1351) {
						DbTableType.Interpreter_intStackSize -= 2;
						var5 = 10;
						var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize]};
						byte[] var10 = new byte[]{(byte)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]};
						class176.Widget_setKey(var4, var5, var9, var10);
						return 1;
					} else if (var0 == 1352) {
						DbTableType.Interpreter_intStackSize -= 3;
						var11 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize] - 1;
						var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
						var7 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
						if (var11 >= 0 && var11 <= 9) {
							WorldMapAreaData.Widget_setKeyRate(var4, var11, var6, var7);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == 1353) {
						var5 = 10;
						var6 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						WorldMapAreaData.Widget_setKeyRate(var4, var5, var6, var7);
						return 1;
					} else if (var0 == 1354) {
						--DbTableType.Interpreter_intStackSize;
						var11 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize] - 1;
						if (var11 >= 0 && var11 <= 9) {
							class137.Widget_setKeyIgnoreHeld(var4, var11);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == 1355) {
						var5 = 10;
						class137.Widget_setKeyIgnoreHeld(var4, var5);
						return 1;
					} else {
						return 2;
					}
				} else {
					byte[] var8 = null;
					var9 = null;
					if (var3) {
						DbTableType.Interpreter_intStackSize -= 10;

						for (var7 = 0; var7 < 10 && Interpreter.Interpreter_intStack[var7 + DbTableType.Interpreter_intStackSize] >= 0; var7 += 2) {
						}

						if (var7 > 0) {
							var8 = new byte[var7 / 2];
							var9 = new byte[var7 / 2];

							for (var7 -= 2; var7 >= 0; var7 -= 2) {
								var8[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + DbTableType.Interpreter_intStackSize];
								var9[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + DbTableType.Interpreter_intStackSize + 1];
							}
						}
					} else {
						DbTableType.Interpreter_intStackSize -= 2;
						var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize]};
						var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]};
					}

					var7 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] - 1;
					if (var7 >= 0 && var7 <= 9) {
						class176.Widget_setKey(var4, var7, var8, var9);
						return 1;
					} else {
						throw new RuntimeException();
					}
				}
			}
		}
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "-1752890787"
	)
	static int method1328(int var0, Script var1, boolean var2) {
		if (var0 == 3800) {
			if (class478.guestClanSettings != null) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 1;
				Timer.field3782 = class478.guestClanSettings;
			} else {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else {
			int var3;
			if (var0 == 3801) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				if (Client.currentClanSettings[var3] != null) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 1;
					Timer.field3782 = Client.currentClanSettings[var3];
				} else {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == 3802) {
				Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = Timer.field3782.name;
				return 1;
			} else if (var0 == 3803) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.allowGuests ? 1 : 0;
				return 1;
			} else if (var0 == 3804) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.field1380;
				return 1;
			} else if (var0 == 3805) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.field1383;
				return 1;
			} else if (var0 == 3806) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.field1381;
				return 1;
			} else if (var0 == 3807) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.field1382;
				return 1;
			} else if (var0 == 3809) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.memberCount;
				return 1;
			} else if (var0 == 3810) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = Timer.field3782.memberNames[var3];
				return 1;
			} else if (var0 == 3811) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.memberRanks[var3];
				return 1;
			} else if (var0 == 3812) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.bannedMemberCount;
				return 1;
			} else if (var0 == 3813) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = Timer.field3782.bannedMemberNames[var3];
				return 1;
			} else {
				int var5;
				int var6;
				if (var0 == 3814) {
					DbTableType.Interpreter_intStackSize -= 3;
					var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
					var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.method801(var3, var6, var5);
					return 1;
				} else if (var0 == 3815) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.currentOwner;
					return 1;
				} else if (var0 == 3816) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.field1388;
					return 1;
				} else if (var0 == 3817) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.method800(Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize]);
					return 1;
				} else if (var0 == 3818) {
					Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.getSortedMembers()[Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1]];
					return 1;
				} else if (var0 == 3819) {
					DbTableType.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
					var6 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
					UserComparator4.method667(var6, var3);
					return 1;
				} else if (var0 == 3820) {
					var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.field1390[var3];
					return 1;
				} else {
					if (var0 == 3821) {
						DbTableType.Interpreter_intStackSize -= 3;
						var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1] == 1;
						var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 2];
						class4.method6(var5, var3, var4);
					}

					if (var0 == 3822) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Timer.field3782.field1379[var3] ? 1 : 0;
						return 1;
					} else if (var0 == 3850) {
						if (ItemContainer.guestClanChannel != null) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 1;
							VarcInt.field1474 = ItemContainer.guestClanChannel;
						} else {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						}

						return 1;
					} else if (var0 == 3851) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						if (Client.currentClanChannels[var3] != null) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 1;
							VarcInt.field1474 = Client.currentClanChannels[var3];
							class395.field3683 = var3;
						} else {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						}

						return 1;
					} else if (var0 == 3852) {
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = VarcInt.field1474.name;
						return 1;
					} else if (var0 == 3853) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = VarcInt.field1474.field1418;
						return 1;
					} else if (var0 == 3854) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = VarcInt.field1474.field1417;
						return 1;
					} else if (var0 == 3855) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = VarcInt.field1474.method857();
						return 1;
					} else if (var0 == 3856) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = ((ClanChannelMember)VarcInt.field1474.members.get(var3)).username.getName();
						return 1;
					} else if (var0 == 3857) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = ((ClanChannelMember)VarcInt.field1474.members.get(var3)).rank;
						return 1;
					} else if (var0 == 3858) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = ((ClanChannelMember)VarcInt.field1474.members.get(var3)).world;
						return 1;
					} else if (var0 == 3859) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						class30.method134(class395.field3683, var3);
						return 1;
					} else if (var0 == 3860) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = VarcInt.field1474.method858(Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize]);
						return 1;
					} else if (var0 == 3861) {
						Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1] = VarcInt.field1474.getSortedMembers()[Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize - 1]];
						return 1;
					} else if (var0 == 3890) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Client.varclan != null ? 1 : 0;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}
}