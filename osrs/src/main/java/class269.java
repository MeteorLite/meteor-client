import java.util.HashMap;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
public final class class269 {
	@ObfuscatedName("f")
	static final HashMap field3192;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 659320505
	)
	@Export("musicTrackVolume")
	public static int musicTrackVolume;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lnk;"
	)
	static Bounds field3195;
	@ObfuscatedName("hg")
	@Export("regions")
	static int[] regions;
	@ObfuscatedName("hb")
	@Export("regionLandArchives")
	static byte[][] regionLandArchives;

	static {
		field3192 = new HashMap();
		java.util.Calendar.getInstance(method5362("Europe/London"));
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)Ljava/util/TimeZone;",
		garbageValue = "-6"
	)
	static TimeZone method5362(String var0) {
		synchronized(field3192) {
			TimeZone var2 = (TimeZone)field3192.get(var0);
			if (var2 == null) {
				var2 = TimeZone.getTimeZone(var0);
				field3192.put(var0, var2);
			}

			return var2;
		}
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(Lps;I)Ljava/lang/Object;",
		garbageValue = "-189745240"
	)
	static Object method5366(class434 var0) {
		if (var0 == null) {
			throw new IllegalStateException("popValueOfType() failure - null baseVarType");
		} else {
			switch(var0.field4694) {
			case 1:
				return Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			case 2:
				return Interpreter.Interpreter_stringStack[--VarbitComposition.Interpreter_stringStackSize];
			default:
				throw new IllegalStateException("popValueOfType() failure - unsupported type");
			}
		}
	}

	@ObfuscatedName("hh")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1214293925"
	)
	static final void method5365() {
		Players.method2581(false);
		Client.field523 = 0;
		boolean var0 = true;

		int var1;
		for (var1 = 0; var1 < regionLandArchives.length; ++var1) {
			if (class124.regionMapArchiveIds[var1] != -1 && regionLandArchives[var1] == null) {
				regionLandArchives[var1] = class434.archive9.takeFile(class124.regionMapArchiveIds[var1], 0);
				if (regionLandArchives[var1] == null) {
					var0 = false;
					++Client.field523;
				}
			}

			if (HitSplatDefinition.regionLandArchiveIds[var1] != -1 && class33.regionMapArchives[var1] == null) {
				class33.regionMapArchives[var1] = class434.archive9.takeFileEncrypted(HitSplatDefinition.regionLandArchiveIds[var1], 0, class202.xteaKeys[var1]);
				if (class33.regionMapArchives[var1] == null) {
					var0 = false;
					++Client.field523;
				}
			}
		}

		if (!var0) {
			Client.field774 = 1;
		} else {
			Client.field558 = 0;
			var0 = true;

			int var3;
			int var4;
			for (var1 = 0; var1 < regionLandArchives.length; ++var1) {
				byte[] var15 = class33.regionMapArchives[var1];
				if (var15 != null) {
					var3 = (regions[var1] >> 8) * 64 - class128.baseX * 64;
					var4 = (regions[var1] & 255) * 64 - WorldMapData_1.baseY * 64;
					if (Client.isInInstance) {
						var3 = 10;
						var4 = 10;
					}

					var0 &= Buddy.method6989(var15, var3, var4);
				}
			}

			if (!var0) {
				Client.field774 = 2;
			} else {
				if (Client.field774 != 0) {
					class146.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
				}

				class14.playPcmPlayers();
				MusicPatchNode.scene.clear();

				for (var1 = 0; var1 < 4; ++var1) {
					Client.collisionMaps[var1].clear();
				}

				int var2;
				for (var1 = 0; var1 < 4; ++var1) {
					for (var2 = 0; var2 < 104; ++var2) {
						for (var3 = 0; var3 < 104; ++var3) {
							Tiles.Tiles_renderFlags[var1][var2][var3] = 0;
						}
					}
				}

				class14.playPcmPlayers();
				class148.method3260();
				var1 = regionLandArchives.length;
				class303.method5918();
				Players.method2581(true);
				int var5;
				if (!Client.isInInstance) {
					byte[] var14;
					for (var2 = 0; var2 < var1; ++var2) {
						var3 = (regions[var2] >> 8) * 64 - class128.baseX * 64;
						var4 = (regions[var2] & 255) * 64 - WorldMapData_1.baseY * 64;
						var14 = regionLandArchives[var2];
						if (var14 != null) {
							class14.playPcmPlayers();
							PacketBufferNode.method5355(var14, var3, var4, class6.field17 * 8 - 48, class146.field1684 * 8 - 48, Client.collisionMaps);
						}
					}

					for (var2 = 0; var2 < var1; ++var2) {
						var3 = (regions[var2] >> 8) * 64 - class128.baseX * 64;
						var4 = (regions[var2] & 255) * 64 - WorldMapData_1.baseY * 64;
						var14 = regionLandArchives[var2];
						if (var14 == null && class146.field1684 < 800) {
							class14.playPcmPlayers();
							Decimator.method1104(var3, var4, 64, 64);
						}
					}

					Players.method2581(true);

					for (var2 = 0; var2 < var1; ++var2) {
						byte[] var13 = class33.regionMapArchives[var2];
						if (var13 != null) {
							var4 = (regions[var2] >> 8) * 64 - class128.baseX * 64;
							var5 = (regions[var2] & 255) * 64 - WorldMapData_1.baseY * 64;
							class14.playPcmPlayers();
							Language.method6230(var13, var4, var5, MusicPatchNode.scene, Client.collisionMaps);
						}
					}
				}

				int var6;
				int var7;
				int var8;
				if (Client.isInInstance) {
					int var9;
					int var10;
					int var11;
					for (var2 = 0; var2 < 4; ++var2) {
						class14.playPcmPlayers();

						for (var3 = 0; var3 < 13; ++var3) {
							for (var4 = 0; var4 < 13; ++var4) {
								boolean var16 = false;
								var6 = Client.instanceChunkTemplates[var2][var3][var4];
								if (var6 != -1) {
									var7 = var6 >> 24 & 3;
									var8 = var6 >> 1 & 3;
									var9 = var6 >> 14 & 1023;
									var10 = var6 >> 3 & 2047;
									var11 = (var9 / 8 << 8) + var10 / 8;

									for (int var12 = 0; var12 < regions.length; ++var12) {
										if (regions[var12] == var11 && regionLandArchives[var12] != null) {
											class21.method315(regionLandArchives[var12], var2, var3 * 8, var4 * 8, var7, (var9 & 7) * 8, (var10 & 7) * 8, var8, Client.collisionMaps);
											var16 = true;
											break;
										}
									}
								}

								if (!var16) {
									class364.method6771(var2, var3 * 8, var4 * 8);
								}
							}
						}
					}

					for (var2 = 0; var2 < 13; ++var2) {
						for (var3 = 0; var3 < 13; ++var3) {
							var4 = Client.instanceChunkTemplates[0][var2][var3];
							if (var4 == -1) {
								Decimator.method1104(var2 * 8, var3 * 8, 8, 8);
							}
						}
					}

					Players.method2581(true);

					for (var2 = 0; var2 < 4; ++var2) {
						class14.playPcmPlayers();

						for (var3 = 0; var3 < 13; ++var3) {
							for (var4 = 0; var4 < 13; ++var4) {
								var5 = Client.instanceChunkTemplates[var2][var3][var4];
								if (var5 != -1) {
									var6 = var5 >> 24 & 3;
									var7 = var5 >> 1 & 3;
									var8 = var5 >> 14 & 1023;
									var9 = var5 >> 3 & 2047;
									var10 = (var8 / 8 << 8) + var9 / 8;

									for (var11 = 0; var11 < regions.length; ++var11) {
										if (regions[var11] == var10 && class33.regionMapArchives[var11] != null) {
											Tiles.method2148(class33.regionMapArchives[var11], var2, var3 * 8, var4 * 8, var6, (var8 & 7) * 8, (var9 & 7) * 8, var7, MusicPatchNode.scene, Client.collisionMaps);
											break;
										}
									}
								}
							}
						}
					}
				}

				Players.method2581(true);
				class14.playPcmPlayers();
				WorldMapArea.method4808(MusicPatchNode.scene, Client.collisionMaps);
				Players.method2581(true);
				var2 = Tiles.Tiles_minPlane;
				if (var2 > Tiles.Client_plane) {
					var2 = Tiles.Client_plane;
				}

				if (var2 < Tiles.Client_plane - 1) {
					var2 = Tiles.Client_plane - 1;
				}

				if (Client.isLowDetail) {
					MusicPatchNode.scene.init(Tiles.Tiles_minPlane);
				} else {
					MusicPatchNode.scene.init(0);
				}

				for (var3 = 0; var3 < 104; ++var3) {
					for (var4 = 0; var4 < 104; ++var4) {
						Friend.updateItemPile(var3, var4);
					}
				}

				class14.playPcmPlayers();
				ScriptFrame.method1133();
				ObjectComposition.ObjectDefinition_cachedModelData.clear();
				PacketBufferNode var17;
				if (IgnoreList.client.hasFrame()) {
					var17 = class120.getPacketBufferNode(ClientPacket.field2995, Client.packetWriter.isaacCipher);
					var17.packetBuffer.writeInt(1057001181);
					Client.packetWriter.addNode(var17);
				}

				if (!Client.isInInstance) {
					var3 = (class6.field17 - 6) / 8;
					var4 = (class6.field17 + 6) / 8;
					var5 = (class146.field1684 - 6) / 8;
					var6 = (class146.field1684 + 6) / 8;

					for (var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
						for (var8 = var5 - 1; var8 <= var6 + 1; ++var8) {
							if (var7 < var3 || var7 > var4 || var8 < var5 || var8 > var6) {
								class434.archive9.loadRegionFromName("m" + var7 + "_" + var8);
								class434.archive9.loadRegionFromName("l" + var7 + "_" + var8);
							}
						}
					}
				}

				Coord.updateGameState(30);
				class14.playPcmPlayers();
				class12.method176();
				var17 = class120.getPacketBufferNode(ClientPacket.field2976, Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var17);
				class18.method282();
			}
		}
	}

	@ObfuscatedName("ky")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "16711935"
	)
	@Export("changeGameOptions")
	static final void changeGameOptions(int var0) {
		class33.method647();
		NPC.method2528();
		int var1 = class119.VarpDefinition_get(var0).type;
		if (var1 != 0) {
			int var2 = Varps.Varps_main[var0];
			if (var1 == 1) {
				if (var2 == 1) {
					class124.method2965(0.9D);
				}

				if (var2 == 2) {
					class124.method2965(0.8D);
				}

				if (var2 == 3) {
					class124.method2965(0.7D);
				}

				if (var2 == 4) {
					class124.method2965(0.6D);
				}
			}

			if (var1 == 3) {
				if (var2 == 0) {
					NPC.method2511(255);
				}

				if (var2 == 1) {
					NPC.method2511(192);
				}

				if (var2 == 2) {
					NPC.method2511(128);
				}

				if (var2 == 3) {
					NPC.method2511(64);
				}

				if (var2 == 4) {
					NPC.method2511(0);
				}
			}

			if (var1 == 4) {
				if (var2 == 0) {
					class150.method3286(127);
				}

				if (var2 == 1) {
					class150.method3286(96);
				}

				if (var2 == 2) {
					class150.method3286(64);
				}

				if (var2 == 3) {
					class150.method3286(32);
				}

				if (var2 == 4) {
					class150.method3286(0);
				}
			}

			if (var1 == 5) {
				Client.leftClickOpensMenu = var2 == 1;
			}

			if (var1 == 6) {
				Client.chatEffects = var2;
			}

			if (var1 == 9) {
				Client.field565 = var2;
			}

			if (var1 == 10) {
				if (var2 == 0) {
					class264.method5345(127);
				}

				if (var2 == 1) {
					class264.method5345(96);
				}

				if (var2 == 2) {
					class264.method5345(64);
				}

				if (var2 == 3) {
					class264.method5345(32);
				}

				if (var2 == 4) {
					class264.method5345(0);
				}
			}

			if (var1 == 17) {
				Client.followerIndex = var2 & 65535;
			}

			if (var1 == 18) {
				Client.playerAttackOption = (AttackOption)Varps.findEnumerated(FontName.method7594(), var2);
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
				Client.npcAttackOption = (AttackOption)Varps.findEnumerated(FontName.method7594(), var2);
				if (Client.npcAttackOption == null) {
					Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

		}
	}
}
