import java.awt.datatransfer.Clipboard;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("ClanChannelMember")
public class ClanChannelMember {
	@ObfuscatedName("aw")
	@Export("rank")
	public byte rank;
	@ObfuscatedName("ay")
	@Export("world")
	public int world;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lui;"
	)
	@Export("username")
	public Username username;

	ClanChannelMember() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "([BB)Lud;",
		garbageValue = "-39"
	)
	public static final SpritePixels method769(byte[] var0) {
		BufferedImage var1 = null;

		try {
			Class var2 = ImageIO.class;
			synchronized(ImageIO.class) {
				var1 = ImageIO.read(new ByteArrayInputStream(var0));
			}

			int var6 = var1.getWidth();
			int var7 = var1.getHeight();
			int[] var4 = new int[var7 * var6];
			PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var6, var7, var4, 0, var6);
			var5.grabPixels();
			return new SpritePixels(var4, var6, var7);
		} catch (IOException var9) {
		} catch (InterruptedException var10) {
		}

		return new SpritePixels(0, 0);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-729456803"
	)
	static int method770(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 0) {
				var1 = 0;
			} else if (var1 > 127) {
				var1 = 127;
			}

			var1 = 127 - var1;
			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("mw")
	@ObfuscatedSignature(
		descriptor = "([Lmt;IIIIIIIB)V",
		garbageValue = "14"
	)
	@Export("updateInterface")
	static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var8 = 0; var8 < var0.length; ++var8) {
			Widget var9 = var0[var8];
			if (var9 != null && var9.parentId == var1 && (var9.method1787() || UserComparator8.getWidgetFlags(var9) != 0 || var9 == Client.clickedWidgetParent)) {
				if (var9.isIf3) {
					if (WorldMapDecorationType.isComponentHidden(var9)) {
						continue;
					}
				} else if (var9.type == 0 && var9 != WorldMapScaleHandler.mousedOverWidgetIf1 && WorldMapDecorationType.isComponentHidden(var9)) {
					continue;
				}

				if (var9.type == 11) {
					if (var9.method1802(WorldMapLabel.urlRequester)) {
						if (var9.method1795()) {
							class200.invalidateWidget(var9);
							SoundCache.revalidateWidgetScroll(var9.children, var9, true);
						}

						if (var9.field3072 != null) {
							ScriptEvent var10 = new ScriptEvent();
							var10.widget = var9;
							var10.args = var9.field3072;
							Client.scriptEvents.addFirst(var10);
						}
					}
				} else if (var9.type == 12 && var9.method1810()) {
					class200.invalidateWidget(var9);
				}

				int var26 = var9.x + var6;
				int var11 = var7 + var9.y;
				int var12;
				int var13;
				int var14;
				int var15;
				int var16;
				int var17;
				int var18;
				if (var9.type == 9) {
					var16 = var26;
					var17 = var11;
					var18 = var26 + var9.width;
					int var19 = var11 + var9.height;
					if (var18 < var26) {
						var16 = var18;
						var18 = var26;
					}

					if (var19 < var11) {
						var17 = var19;
						var19 = var11;
					}

					++var18;
					++var19;
					var12 = var16 > var2 ? var16 : var2;
					var13 = var17 > var3 ? var17 : var3;
					var14 = var18 < var4 ? var18 : var4;
					var15 = var19 < var5 ? var19 : var5;
				} else {
					var16 = var26 + var9.width;
					var17 = var11 + var9.height;
					var12 = var26 > var2 ? var26 : var2;
					var13 = var11 > var3 ? var11 : var3;
					var14 = var16 < var4 ? var16 : var4;
					var15 = var17 < var5 ? var17 : var5;
				}

				if (var9 == Client.clickedWidget) {
					Client.field393 = true;
					Client.field520 = var26;
					Client.field510 = var11;
				}

				boolean var34 = false;
				if (var9.field2951) {
					switch(Client.field503) {
					case 0:
						var34 = true;
					case 1:
					default:
						break;
					case 2:
						if (Client.field502 == var9.id >>> 16) {
							var34 = true;
						}
						break;
					case 3:
						if (var9.id == Client.field502) {
							var34 = true;
						}
					}
				}

				if (var34 || !var9.isIf3 || var12 < var14 && var13 < var15) {
					if (var9.isIf3) {
						ScriptEvent var27;
						if (var9.noClickThrough) {
							if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								for (var27 = (ScriptEvent)Client.scriptEvents.last(); var27 != null; var27 = (ScriptEvent)Client.scriptEvents.previous()) {
									if (var27.field859) {
										var27.remove();
										var27.widget.field2954 = false;
									}
								}

								class417.method2121();
								if (class130.widgetDragDuration == 0) {
									Client.clickedWidget = null;
									Client.clickedWidgetParent = null;
								}

								if (!Client.isMenuOpen) {
									class89.addCancelMenuEntry();
								}
							}
						} else if (var9.noScrollThrough && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
							for (var27 = (ScriptEvent)Client.scriptEvents.last(); var27 != null; var27 = (ScriptEvent)Client.scriptEvents.previous()) {
								if (var27.field859 && var27.widget.onScroll == var27.args) {
									var27.remove();
								}
							}
						}
					}

					var17 = MouseHandler.MouseHandler_x;
					var18 = MouseHandler.MouseHandler_y;
					if (MouseHandler.MouseHandler_lastButton != 0) {
						var17 = MouseHandler.MouseHandler_lastPressedX;
						var18 = MouseHandler.MouseHandler_lastPressedY;
					}

					boolean var35 = var17 >= var12 && var18 >= var13 && var17 < var14 && var18 < var15;
					if (var9.contentType == 1337) {
						if (!Client.isLoading && !Client.isMenuOpen && var35) {
							class59.addSceneMenuOptions(var17, var18, var12, var13);
						}
					} else if (var9.contentType == 1338) {
						class166.checkIfMinimapClicked(var9, var26, var11);
					} else {
						if (var9.contentType == 1400) {
							class127.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var35, var26, var11, var9.width, var9.height);
						}

						if (!Client.isMenuOpen && var35) {
							if (var9.contentType == 1400) {
								class127.worldMap.addElementMenuOptions(var26, var11, var9.width, var9.height, var17, var18);
							} else {
								class317.method1663(var9);
							}
						}

						boolean var21;
						int var23;
						if (var34) {
							for (int var20 = 0; var20 < var9.field2960.length; ++var20) {
								var21 = false;
								boolean var22 = false;
								if (!var21 && var9.field2960[var20] != null) {
									for (var23 = 0; var23 < var9.field2960[var20].length; ++var23) {
										boolean var24 = false;
										if (var9.field3037 != null) {
											var24 = Client.keyHandlerInstance.getKeyPressed(var9.field2960[var20][var23]);
										}

										if (class319.method1667(var9.field2960[var20][var23]) || var24) {
											var21 = true;
											if (var9.field3037 != null && var9.field3037[var20] > Client.cycle) {
												break;
											}

											byte var33 = var9.field2959[var20][var23];
											if (var33 == 0 || ((var33 & 8) == 0 || !Client.keyHandlerInstance.getKeyPressed(86) && !Client.keyHandlerInstance.getKeyPressed(82) && !Client.keyHandlerInstance.getKeyPressed(81)) && ((var33 & 2) == 0 || Client.keyHandlerInstance.getKeyPressed(86)) && ((var33 & 1) == 0 || Client.keyHandlerInstance.getKeyPressed(82)) && ((var33 & 4) == 0 || Client.keyHandlerInstance.getKeyPressed(81))) {
												var22 = true;
												break;
											}
										}
									}
								}

								if (var22) {
									if (var20 < 10) {
										BufferedSource.widgetDefaultMenuAction(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
									} else if (var20 == 10) {
										SoundCache.Widget_runOnTargetLeave();
										ArchiveDiskAction.selectSpell(var9.id, var9.childIndex, class273.Widget_unpackTargetMask(UserComparator8.getWidgetFlags(var9)), var9.itemId);
										Client.field597 = class13.Widget_getSpellActionName(var9);
										if (Client.field597 == null) {
											Client.field597 = "null";
										}

										Client.field596 = var9.dataText + MusicPatchPcmStream.colorStartTag(16777215);
									}

									var23 = var9.field3028[var20];
									if (var9.field3037 == null) {
										var9.field3037 = new int[var9.field2960.length];
									}

									if (var9.field3029 == null) {
										var9.field3029 = new int[var9.field2960.length];
									}

									if (var23 != 0) {
										if (var9.field3037[var20] == 0) {
											var9.field3037[var20] = var23 + Client.cycle + var9.field3029[var20];
										} else {
											var9.field3037[var20] = var23 + Client.cycle;
										}
									} else {
										var9.field3037[var20] = Integer.MAX_VALUE;
									}
								}

								if (!var21 && var9.field3037 != null) {
									var9.field3037[var20] = 0;
								}
							}
						}

						if (var9.isIf3) {
							if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								var35 = true;
							} else {
								var35 = false;
							}

							boolean var36 = false;
							if ((MouseHandler.MouseHandler_currentButton == 1 || !class28.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var35) {
								var36 = true;
							}

							var21 = false;
							if ((MouseHandler.MouseHandler_lastButton == 1 || !class28.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
								var21 = true;
							}

							if (var21) {
								class353.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var26, MouseHandler.MouseHandler_lastPressedY - var11);
							}

							if (var9.method1788()) {
								if (var21) {
									Client.field625.addFirst(new class212(0, MouseHandler.MouseHandler_x - var26, MouseHandler.MouseHandler_y - var11, var9));
								}

								if (var36) {
									Client.field625.addFirst(new class212(1, MouseHandler.MouseHandler_x - var26, MouseHandler.MouseHandler_y - var11, var9));
								}
							}

							if (var9.contentType == 1400) {
								class127.worldMap.method2361(var17, var18, var35 & var36, var35 & var21);
							}

							if (Client.clickedWidget != null && var9 != Client.clickedWidget && var35 && class319.method1665(UserComparator8.getWidgetFlags(var9))) {
								Client.draggedOnWidget = var9;
							}

							if (var9 == Client.clickedWidgetParent) {
								Client.field391 = true;
								Client.field500 = var26;
								Client.field504 = var11;
							}

							if (var9.hasListener) {
								ScriptEvent var28;
								if (var35 && Client.mouseWheelRotation != 0 && var9.onScroll != null) {
									var28 = new ScriptEvent();
									var28.field859 = true;
									var28.widget = var9;
									var28.mouseY = Client.mouseWheelRotation;
									var28.args = var9.onScroll;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.clickedWidget != null || Client.isMenuOpen) {
									var21 = false;
									var36 = false;
									var35 = false;
								}

								if (!var9.field2957 && var21) {
									var9.field2957 = true;
									if (var9.onClick != null) {
										var28 = new ScriptEvent();
										var28.field859 = true;
										var28.widget = var9;
										var28.mouseX = MouseHandler.MouseHandler_lastPressedX - var26;
										var28.mouseY = MouseHandler.MouseHandler_lastPressedY - var11;
										var28.args = var9.onClick;
										Client.scriptEvents.addFirst(var28);
									}
								}

								if (var9.field2957 && var36 && var9.onClickRepeat != null) {
									var28 = new ScriptEvent();
									var28.field859 = true;
									var28.widget = var9;
									var28.mouseX = MouseHandler.MouseHandler_x - var26;
									var28.mouseY = MouseHandler.MouseHandler_y - var11;
									var28.args = var9.onClickRepeat;
									Client.scriptEvents.addFirst(var28);
								}

								if (var9.field2957 && !var36) {
									var9.field2957 = false;
									if (var9.onRelease != null) {
										var28 = new ScriptEvent();
										var28.field859 = true;
										var28.widget = var9;
										var28.mouseX = MouseHandler.MouseHandler_x - var26;
										var28.mouseY = MouseHandler.MouseHandler_y - var11;
										var28.args = var9.onRelease;
										Client.field626.addFirst(var28);
									}
								}

								if (var36 && var9.onHold != null) {
									var28 = new ScriptEvent();
									var28.field859 = true;
									var28.widget = var9;
									var28.mouseX = MouseHandler.MouseHandler_x - var26;
									var28.mouseY = MouseHandler.MouseHandler_y - var11;
									var28.args = var9.onHold;
									Client.scriptEvents.addFirst(var28);
								}

								if (!var9.field2954 && var35) {
									var9.field2954 = true;
									if (var9.onMouseOver != null) {
										var28 = new ScriptEvent();
										var28.field859 = true;
										var28.widget = var9;
										var28.mouseX = MouseHandler.MouseHandler_x - var26;
										var28.mouseY = MouseHandler.MouseHandler_y - var11;
										var28.args = var9.onMouseOver;
										Client.scriptEvents.addFirst(var28);
									}
								}

								if (var9.field2954 && var35 && var9.onMouseRepeat != null) {
									var28 = new ScriptEvent();
									var28.field859 = true;
									var28.widget = var9;
									var28.mouseX = MouseHandler.MouseHandler_x - var26;
									var28.mouseY = MouseHandler.MouseHandler_y - var11;
									var28.args = var9.onMouseRepeat;
									Client.scriptEvents.addFirst(var28);
								}

								if (var9.field2954 && !var35) {
									var9.field2954 = false;
									if (var9.onMouseLeave != null) {
										var28 = new ScriptEvent();
										var28.field859 = true;
										var28.widget = var9;
										var28.mouseX = MouseHandler.MouseHandler_x - var26;
										var28.mouseY = MouseHandler.MouseHandler_y - var11;
										var28.args = var9.onMouseLeave;
										Client.field626.addFirst(var28);
									}
								}

								if (var9.onTimer != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.onTimer;
									Client.field624.addFirst(var28);
								}

								ScriptEvent var25;
								int var37;
								int var38;
								if (var9.onVarTransmit != null && Client.changedVarpCount > var9.field3024) {
									if (var9.varTransmitTriggers != null && Client.changedVarpCount - var9.field3024 <= 32) {
										label648:
										for (var37 = var9.field3024; var37 < Client.changedVarpCount; ++var37) {
											var23 = Client.changedVarps[var37 & 31];

											for (var38 = 0; var38 < var9.varTransmitTriggers.length; ++var38) {
												if (var23 == var9.varTransmitTriggers[var38]) {
													var25 = new ScriptEvent();
													var25.widget = var9;
													var25.args = var9.onVarTransmit;
													Client.scriptEvents.addFirst(var25);
													break label648;
												}
											}
										}
									} else {
										var28 = new ScriptEvent();
										var28.widget = var9;
										var28.args = var9.onVarTransmit;
										Client.scriptEvents.addFirst(var28);
									}

									var9.field3024 = Client.changedVarpCount;
								}

								if (var9.onInvTransmit != null && Client.changedItemContainersCount > var9.field3023) {
									if (var9.invTransmitTriggers != null && Client.changedItemContainersCount - var9.field3023 <= 32) {
										label624:
										for (var37 = var9.field3023; var37 < Client.changedItemContainersCount; ++var37) {
											var23 = Client.changedItemContainers[var37 & 31];

											for (var38 = 0; var38 < var9.invTransmitTriggers.length; ++var38) {
												if (var23 == var9.invTransmitTriggers[var38]) {
													var25 = new ScriptEvent();
													var25.widget = var9;
													var25.args = var9.onInvTransmit;
													Client.scriptEvents.addFirst(var25);
													break label624;
												}
											}
										}
									} else {
										var28 = new ScriptEvent();
										var28.widget = var9;
										var28.args = var9.onInvTransmit;
										Client.scriptEvents.addFirst(var28);
									}

									var9.field3023 = Client.changedItemContainersCount;
								}

								if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field3025) {
									if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field3025 <= 32) {
										label600:
										for (var37 = var9.field3025; var37 < Client.changedSkillsCount; ++var37) {
											var23 = Client.changedSkills[var37 & 31];

											for (var38 = 0; var38 < var9.statTransmitTriggers.length; ++var38) {
												if (var23 == var9.statTransmitTriggers[var38]) {
													var25 = new ScriptEvent();
													var25.widget = var9;
													var25.args = var9.onStatTransmit;
													Client.scriptEvents.addFirst(var25);
													break label600;
												}
											}
										}
									} else {
										var28 = new ScriptEvent();
										var28.widget = var9;
										var28.args = var9.onStatTransmit;
										Client.scriptEvents.addFirst(var28);
									}

									var9.field3025 = Client.changedSkillsCount;
								}

								if (Client.chatCycle > var9.field3026 && var9.onChatTransmit != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.onChatTransmit;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field516 > var9.field3026 && var9.onFriendTransmit != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.onFriendTransmit;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field509 > var9.field3026 && var9.onClanTransmit != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.onClanTransmit;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field514 > var9.field3026 && var9.field3070 != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.field3070;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field512 > var9.field3026 && var9.field3062 != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.field3062;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field518 > var9.field3026 && var9.onStockTransmit != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.onStockTransmit;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field521 > var9.field3026 && var9.field3069 != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.field3069;
									Client.scriptEvents.addFirst(var28);
								}

								if (Client.field524 > var9.field3026 && var9.onMiscTransmit != null) {
									var28 = new ScriptEvent();
									var28.widget = var9;
									var28.args = var9.onMiscTransmit;
									Client.scriptEvents.addFirst(var28);
								}

								var9.field3026 = Client.cycleCntr;
								if (var9.onKey != null) {
									for (var37 = 0; var37 < Client.field529; ++var37) {
										ScriptEvent var29 = new ScriptEvent();
										var29.widget = var9;
										var29.keyTyped = Client.field578[var37];
										var29.keyPressed = Client.field576[var37];
										var29.args = var9.onKey;
										Client.scriptEvents.addFirst(var29);
									}
								}

								ScriptEvent var30;
								int[] var39;
								if (var9.field3061 != null) {
									var39 = Client.keyHandlerInstance.method1089();

									for (var23 = 0; var23 < var39.length; ++var23) {
										var30 = new ScriptEvent();
										var30.widget = var9;
										var30.keyTyped = var39[var23];
										var30.args = var9.field3061;
										Client.scriptEvents.addFirst(var30);
									}
								}

								if (var9.field3068 != null) {
									var39 = Client.keyHandlerInstance.method1090();

									for (var23 = 0; var23 < var39.length; ++var23) {
										var30 = new ScriptEvent();
										var30.widget = var9;
										var30.keyTyped = var39[var23];
										var30.args = var9.field3068;
										Client.scriptEvents.addFirst(var30);
									}
								}
							}
						}

						if (!var9.isIf3) {
							if (Client.clickedWidget != null || Client.isMenuOpen) {
								continue;
							}

							if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								if (var9.mouseOverRedirect >= 0) {
									WorldMapScaleHandler.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
								} else {
									WorldMapScaleHandler.mousedOverWidgetIf1 = var9;
								}
							}

							if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
								class403.field3700 = var9;
							}

							if (var9.scrollHeight > var9.height) {
								class143.method761(var9, var26 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
							}
						}

						if (var9.type == 0) {
							updateInterface(var0, var9.id, var12, var13, var14, var15, var26 - var9.scrollX, var11 - var9.scrollY);
							if (var9.children != null) {
								updateInterface(var9.children, var9.id, var12, var13, var14, var15, var26 - var9.scrollX, var11 - var9.scrollY);
							}

							InterfaceParent var31 = (InterfaceParent)Client.interfaceParents.get((long)var9.id);
							if (var31 != null) {
								if (var31.type == 0 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15 && !Client.isMenuOpen) {
									for (ScriptEvent var32 = (ScriptEvent)Client.scriptEvents.last(); var32 != null; var32 = (ScriptEvent)Client.scriptEvents.previous()) {
										if (var32.field859) {
											var32.remove();
											var32.widget.field2954 = false;
										}
									}

									if (class130.widgetDragDuration == 0) {
										Client.clickedWidget = null;
										Client.clickedWidgetParent = null;
									}

									if (!Client.isMenuOpen) {
										class89.addCancelMenuEntry();
									}
								}

								class10.updateRootInterface(var31.group, var12, var13, var14, var15, var26, var11);
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("oi")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/awt/datatransfer/Clipboard;",
		garbageValue = "-2056572724"
	)
	public static Clipboard method772() {
		return TileItem.client.getClipboard();
	}
}
