import java.util.concurrent.locks.ReentrantLock;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class47 {
	@ObfuscatedName("de")
	@ObfuscatedSignature(
		descriptor = "Luu;"
	)
	@Export("worldSelectLeftSprite")
	static IndexedSprite worldSelectLeftSprite;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lcz;"
	)
	VorbisSample field229;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lbi;"
	)
	RawSound field228;
	@ObfuscatedName("ar")
	ReentrantLock field230;

	@ObfuscatedSignature(
		descriptor = "(Lcz;Lbi;)V"
	)
	class47(VorbisSample var1, RawSound var2) {
		this.field229 = var1;
		this.field228 = var2;
		this.field230 = new ReentrantLock();
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZI)I",
		garbageValue = "2017715384"
	)
	static int method233(int var0, Script var1, boolean var2) {
		Widget var3 = VarbitComposition.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		if (var0 == 2600) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == 2601) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else if (var0 == 2602) {
			Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.text;
			return 1;
		} else if (var0 == 2603) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollWidth;
			return 1;
		} else if (var0 == 2604) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollHeight;
			return 1;
		} else if (var0 == 2605) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelZoom;
			return 1;
		} else if (var0 == 2606) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleX;
			return 1;
		} else if (var0 == 2607) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleZ;
			return 1;
		} else if (var0 == 2608) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleY;
			return 1;
		} else if (var0 == 2609) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyTop;
			return 1;
		} else if (var0 == 2610) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyBot;
			return 1;
		} else if (var0 == 2611) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color;
			return 1;
		} else if (var0 == 2612) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color2;
			return 1;
		} else if (var0 == 2613) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
			return 1;
		} else if (var0 == 2614) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
			return 1;
		} else {
			class325 var4;
			if (var0 == 2617) {
				var4 = var3.method1806();
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 != null ? var4.field2874 * 486674949 * -392959283 : 0;
			}

			if (var0 == 2618) {
				var4 = var3.method1806();
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 != null ? var4.field2875 * 226510377 * 987280921 : 0;
				return 1;
			} else {
				class330 var7;
				if (var0 == 2619) {
					var7 = var3.method1805();
					Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1743().method2000() : "";
					return 1;
				} else if (var0 == 2620) {
					var4 = var3.method1806();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 != null ? var4.field2873 * 1386938305 * -1999040447 : 0;
					return 1;
				} else if (var0 == 2621) {
					var7 = var3.method1805();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1753() : 0;
					return 1;
				} else if (var0 == 2622) {
					var7 = var3.method1805();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1754() : 0;
					return 1;
				} else if (var0 == 2623) {
					var7 = var3.method1805();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1755() : 0;
					return 1;
				} else if (var0 == 2624) {
					var7 = var3.method1805();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null && var7.method1745() ? 1 : 0;
					return 1;
				} else if (var0 != 2625) {
					if (var0 == 2626) {
						var7 = var3.method1805();
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1744().method2074() : "";
						return 1;
					} else if (var0 == 2627) {
						var7 = var3.method1805();
						int var5 = var7 != null ? var7.method1749() : 0;
						int var6 = var7 != null ? var7.method1748() : 0;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Math.min(var5, var6);
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Math.max(var5, var6);
						return 1;
					} else if (var0 == 2628) {
						var7 = var3.method1805();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1748() : 0;
						return 1;
					} else if (var0 == 2629) {
						var7 = var3.method1805();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1757() : 0;
						return 1;
					} else if (var0 == 2630) {
						var7 = var3.method1805();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1756() : 0;
						return 1;
					} else if (var0 == 2631) {
						var7 = var3.method1805();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1758() : 0;
						return 1;
					} else if (var0 == 2632) {
						var7 = var3.method1805();
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1759() : 0;
						return 1;
					} else {
						class27 var8;
						if (var0 == 2633) {
							var8 = var3.method1807();
							Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = var8 != null ? var8.method104(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]) : 0;
							return 1;
						} else if (var0 == 2634) {
							var8 = var3.method1807();
							Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = var8 != null ? var8.method105((char)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]) : 0;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = var3.method1805();
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null && var7.method1746() ? 1 : 0;
					return 1;
				}
			}
		}
	}

	@ObfuscatedName("ix")
	@ObfuscatedSignature(
		descriptor = "(Ldx;II)V",
		garbageValue = "-1729917411"
	)
	@Export("updateActorSequence")
	static final void updateActorSequence(Actor var0, int var1) {
		int var2;
		int var3;
		int var4;
		SequenceDefinition var11;
		if (var0.spotAnimation >= Client.cycle) {
			var2 = Math.max(1, var0.spotAnimation - Client.cycle);
			var3 = var0.field976 * 64 + var0.field1013 * 128;
			var4 = var0.field976 * 64 + var0.field1007 * 128;
			var0.x += (var3 - var0.x) / var2;
			var0.y += (var4 - var0.y) / var2;
			var0.field1020 = 0;
			var0.orientation = var0.exactMoveDirection;
		} else if (var0.exactMoveArrive1Cycle >= Client.cycle) {
			class197.method981(var0);
		} else {
			var0.movementSequence = var0.idleSequence;
			if (var0.pathLength == 0) {
				var0.field1020 = 0;
			} else {
				label454: {
					if (var0.sequence != -1 && var0.sequenceDelay == 0) {
						var11 = class135.SequenceDefinition_get(var0.sequence);
						if (var0.field1018 > 0 && var11.precedenceAnimating == 0) {
							++var0.field1020;
							break label454;
						}

						if (var0.field1018 <= 0 && var11.priority == 0) {
							++var0.field1020;
							break label454;
						}
					}

					var2 = var0.x;
					var3 = var0.y;
					var4 = var0.field976 * 64 + var0.pathX[var0.pathLength - 1] * 128;
					int var5 = var0.field976 * 64 + var0.pathY[var0.pathLength - 1] * 128;
					if (var2 < var4) {
						if (var3 < var5) {
							var0.orientation = 1280;
						} else if (var3 > var5) {
							var0.orientation = 1792;
						} else {
							var0.orientation = 1536;
						}
					} else if (var2 > var4) {
						if (var3 < var5) {
							var0.orientation = 768;
						} else if (var3 > var5) {
							var0.orientation = 256;
						} else {
							var0.orientation = 512;
						}
					} else if (var3 < var5) {
						var0.orientation = 1024;
					} else if (var3 > var5) {
						var0.orientation = 0;
					}

					MoveSpeed var6 = var0.pathTraversed[var0.pathLength - 1];
					if (var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
						int var7 = var0.orientation - var0.rotation & 2047;
						if (var7 > 1024) {
							var7 -= 2048;
						}

						int var8 = var0.walkBackSequence;
						if (var7 >= -256 && var7 <= 256) {
							var8 = var0.walkSequence;
						} else if (var7 >= 256 && var7 < 768) {
							var8 = var0.walkRightSequence;
						} else if (var7 >= -768 && var7 <= -256) {
							var8 = var0.walkLeftSequence;
						}

						if (var8 == -1) {
							var8 = var0.walkSequence;
						}

						var0.movementSequence = var8;
						int var9 = 4;
						boolean var10 = true;
						if (var0 instanceof NPC) {
							var10 = ((NPC)var0).definition.isClickable;
						}

						if (var10) {
							if (var0.orientation != var0.rotation && var0.targetIndex == -1 && var0.field1005 != 0) {
								var9 = 2;
							}

							if (var0.pathLength > 2) {
								var9 = 6;
							}

							if (var0.pathLength > 3) {
								var9 = 8;
							}

							if (var0.field1020 > 0 && var0.pathLength > 1) {
								var9 = 8;
								--var0.field1020;
							}
						} else {
							if (var0.pathLength > 1) {
								var9 = 6;
							}

							if (var0.pathLength > 2) {
								var9 = 8;
							}

							if (var0.field1020 > 0 && var0.pathLength > 1) {
								var9 = 8;
								--var0.field1020;
							}
						}

						if (var6 == MoveSpeed.RUN) {
							var9 <<= 1;
						} else if (var6 == MoveSpeed.CRAWL) {
							var9 >>= 1;
						}

						if (var9 >= 8) {
							if (var0.walkSequence == var0.movementSequence && var0.runSequence != -1) {
								var0.movementSequence = var0.runSequence;
							} else if (var0.walkBackSequence == var0.movementSequence && var0.runBackSequence != -1) {
								var0.movementSequence = var0.runBackSequence;
							} else if (var0.movementSequence == var0.walkLeftSequence && var0.runLeftSequence != -1) {
								var0.movementSequence = var0.runLeftSequence;
							} else if (var0.walkRightSequence == var0.movementSequence && var0.runRightSequence != -1) {
								var0.movementSequence = var0.runRightSequence;
							}
						} else if (var9 <= 2) {
							if (var0.movementSequence == var0.walkSequence && var0.crawlSequence != -1) {
								var0.movementSequence = var0.crawlSequence;
							} else if (var0.movementSequence == var0.walkBackSequence && var0.crawlBackSequence != -1) {
								var0.movementSequence = var0.crawlBackSequence;
							} else if (var0.walkLeftSequence == var0.movementSequence && var0.crawlLeftSequence != -1) {
								var0.movementSequence = var0.crawlLeftSequence;
							} else if (var0.walkRightSequence == var0.movementSequence && var0.crawlRightSequence != -1) {
								var0.movementSequence = var0.crawlRightSequence;
							}
						}

						if (var4 != var2 || var3 != var5) {
							if (var2 < var4) {
								var0.x += var9;
								if (var0.x > var4) {
									var0.x = var4;
								}
							} else if (var2 > var4) {
								var0.x -= var9;
								if (var0.x < var4) {
									var0.x = var4;
								}
							}

							if (var3 < var5) {
								var0.y += var9;
								if (var0.y > var5) {
									var0.y = var5;
								}
							} else if (var3 > var5) {
								var0.y -= var9;
								if (var0.y < var5) {
									var0.y = var5;
								}
							}
						}

						if (var4 == var0.x && var5 == var0.y) {
							--var0.pathLength;
							if (var0.field1018 > 0) {
								--var0.field1018;
							}
						}
					} else {
						var0.x = var4;
						var0.y = var5;
						--var0.pathLength;
						if (var0.field1018 > 0) {
							--var0.field1018;
						}
					}
				}
			}
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = 0;
			var0.exactMoveArrive1Cycle = 0;
			var0.method524();
			var0.x = var0.pathX[0] * 128 + var0.field976 * 64;
			var0.y = var0.field976 * 64 + var0.pathY[0] * 128;
			var0.method517();
		}

		if (class136.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = 0;
			var0.exactMoveArrive1Cycle = 0;
			var0.method524();
			var0.x = var0.field976 * 64 + var0.pathX[0] * 128;
			var0.y = var0.pathY[0] * 128 + var0.field976 * 64;
			var0.method517();
		}

		class389.method1986(var0);
		var0.isWalking = false;
		if (var0.movementSequence != -1) {
			var11 = class135.SequenceDefinition_get(var0.movementSequence);
			if (var11 != null) {
				if (!var11.isCachedModelIdSet() && var11.frameIds != null) {
					++var0.movementFrameCycle;
					if (var0.movementFrame < var11.frameIds.length && var0.movementFrameCycle > var11.frameLengths[var0.movementFrame]) {
						var0.movementFrameCycle = 1;
						++var0.movementFrame;
						class405.method2096(var11, var0.movementFrame, var0.x, var0.y);
					}

					if (var0.movementFrame >= var11.frameIds.length) {
						if (var11.frameCount > 0) {
							var0.movementFrame -= var11.frameCount;
							if (var11.field1819) {
								++var0.field991;
							}

							if (var0.movementFrame < 0 || var0.movementFrame >= var11.frameIds.length || var11.field1819 && var0.field991 >= var11.iterations) {
								var0.movementFrameCycle = 0;
								var0.movementFrame = 0;
								var0.field991 = 0;
							}
						} else {
							var0.movementFrameCycle = 0;
							var0.movementFrame = 0;
						}

						class405.method2096(var11, var0.movementFrame, var0.x, var0.y);
					}
				} else if (var11.isCachedModelIdSet()) {
					++var0.movementFrame;
					var3 = var11.method1067();
					if (var0.movementFrame < var3) {
						class7.method19(var11, var0.movementFrame, var0.x, var0.y);
					} else {
						if (var11.frameCount > 0) {
							var0.movementFrame -= var11.frameCount;
							if (var11.field1819) {
								++var0.field991;
							}

							if (var0.movementFrame < 0 || var0.movementFrame >= var3 || var11.field1819 && var0.field991 >= var11.iterations) {
								var0.movementFrame = 0;
								var0.movementFrameCycle = 0;
								var0.field991 = 0;
							}
						} else {
							var0.movementFrameCycle = 0;
							var0.movementFrame = 0;
						}

						class7.method19(var11, var0.movementFrame, var0.x, var0.y);
					}
				} else {
					var0.movementSequence = -1;
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		IterableNodeHashTableIterator var15 = new IterableNodeHashTableIterator(var0.method523());

		for (SpotAnimation var12 = (SpotAnimation)var15.method2423(); var12 != null; var12 = (SpotAnimation)var15.next()) {
			if (var12.field4238 != -1 && Client.cycle >= var12.field4235) {
				var4 = NPCComposition.SpotAnimationDefinition_get(var12.field4238).sequence;
				if (var4 == -1) {
					var12.remove();
					--var0.field1017;
				} else {
					var12.field4239 = Math.max(var12.field4239, 0);
					SequenceDefinition var13 = class135.SequenceDefinition_get(var4);
					if (var13.frameIds != null && !var13.isCachedModelIdSet()) {
						++var12.field4236;
						if (var12.field4239 < var13.frameIds.length && var12.field4236 > var13.frameLengths[var12.field4239]) {
							var12.field4236 = 1;
							++var12.field4239;
							class405.method2096(var13, var12.field4239, var0.x, var0.y);
						}

						if (var12.field4239 >= var13.frameIds.length) {
							var12.remove();
							--var0.field1017;
						}
					} else if (var13.isCachedModelIdSet()) {
						++var12.field4239;
						int var14 = var13.method1067();
						if (var12.field4239 < var14) {
							class7.method19(var13, var12.field4239, var0.x, var0.y);
						} else {
							var12.remove();
							--var0.field1017;
						}
					} else {
						var12.remove();
						--var0.field1017;
					}
				}
			}
		}

		SequenceDefinition var16;
		if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
			var16 = class135.SequenceDefinition_get(var0.sequence);
			if (var16.precedenceAnimating == 1 && var0.field1018 > 0 && var0.spotAnimation <= Client.cycle && var0.exactMoveArrive1Cycle < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var16 = class135.SequenceDefinition_get(var0.sequence);
			if (var16 == null) {
				var0.sequence = -1;
			} else if (!var16.isCachedModelIdSet() && var16.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var16.frameIds.length && var0.sequenceFrameCycle > var16.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					class405.method2096(var16, var0.sequenceFrame, var0.x, var0.y);
				}

				if (var0.sequenceFrame >= var16.frameIds.length) {
					var0.sequenceFrame -= var16.frameCount;
					++var0.currentSequenceFrameIndex;
					if (var0.currentSequenceFrameIndex >= var16.iterations) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var16.frameIds.length) {
						class405.method2096(var16, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}

				var0.isWalking = var16.stretches;
			} else if (var16.isCachedModelIdSet()) {
				++var0.sequenceFrame;
				var4 = var16.method1067();
				if (var0.sequenceFrame < var4) {
					class7.method19(var16, var0.sequenceFrame, var0.x, var0.y);
				} else {
					var0.sequenceFrame -= var16.frameCount;
					++var0.currentSequenceFrameIndex;
					if (var0.currentSequenceFrameIndex >= var16.iterations) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var4) {
						class7.method19(var16, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}
			} else {
				var0.sequence = -1;
			}
		}

		if (var0.sequenceDelay > 0) {
			--var0.sequenceDelay;
		}

	}

	@ObfuscatedName("ls")
	@ObfuscatedSignature(
		descriptor = "([Lmt;IIIIIIIII)V",
		garbageValue = "1798184407"
	)
	@Export("drawInterface")
	static final void drawInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
		Rasterizer3D.method1176();

		for (int var9 = 0; var9 < var0.length; ++var9) {
			Widget var10 = var0[var9];
			if (var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.clickedWidget)) {
				int var11;
				if (var8 == -1) {
					Client.rootWidgetXs[Client.rootWidgetCount] = var10.x + var6;
					Client.rootWidgetYs[Client.rootWidgetCount] = var7 + var10.y;
					Client.rootWidgetWidths[Client.rootWidgetCount] = var10.width;
					Client.rootWidgetHeights[Client.rootWidgetCount] = var10.height;
					var11 = ++Client.rootWidgetCount - 1;
				} else {
					var11 = var8;
				}

				var10.rootIndex = var11;
				var10.cycle = Client.cycle;
				if (!var10.isIf3 || !WorldMapDecorationType.isComponentHidden(var10)) {
					if (var10.contentType > 0) {
						VarbitComposition.method996(var10);
					}

					int var12 = var10.x + var6;
					int var13 = var7 + var10.y;
					int var14 = var10.transparencyTop;
					int var15;
					int var16;
					if (var10 == Client.clickedWidget) {
						if (var1 != -1412584499 && !var10.isScrollBar) {
							WorldMapDecoration.field2419 = var0;
							class300.field2731 = var6;
							WorldMapIcon_0.field2371 = var7;
							continue;
						}

						if (Client.isDraggingWidget && Client.field391) {
							var15 = MouseHandler.MouseHandler_x;
							var16 = MouseHandler.MouseHandler_y;
							var15 -= Client.widgetClickX;
							var16 -= Client.widgetClickY;
							if (var15 < Client.field500) {
								var15 = Client.field500;
							}

							if (var15 + var10.width > Client.field500 + Client.clickedWidgetParent.width) {
								var15 = Client.field500 + Client.clickedWidgetParent.width - var10.width;
							}

							if (var16 < Client.field504) {
								var16 = Client.field504;
							}

							if (var16 + var10.height > Client.field504 + Client.clickedWidgetParent.height) {
								var16 = Client.field504 + Client.clickedWidgetParent.height - var10.height;
							}

							var12 = var15;
							var13 = var16;
						}

						if (!var10.isScrollBar) {
							var14 = 128;
						}
					}

					int var17;
					int var18;
					int var19;
					int var20;
					int var21;
					int var22;
					if (var10.type == 9) {
						var19 = var12;
						var20 = var13;
						var21 = var12 + var10.width;
						var22 = var13 + var10.height;
						if (var21 < var12) {
							var19 = var21;
							var21 = var12;
						}

						if (var22 < var13) {
							var20 = var22;
							var22 = var13;
						}

						++var21;
						++var22;
						var15 = var19 > var2 ? var19 : var2;
						var16 = var20 > var3 ? var20 : var3;
						var17 = var21 < var4 ? var21 : var4;
						var18 = var22 < var5 ? var22 : var5;
					} else {
						var19 = var12 + var10.width;
						var20 = var13 + var10.height;
						var15 = var12 > var2 ? var12 : var2;
						var16 = var13 > var3 ? var13 : var3;
						var17 = var19 < var4 ? var19 : var4;
						var18 = var20 < var5 ? var20 : var5;
					}

					if (!var10.isIf3 || var15 < var17 && var16 < var18) {
						if (var10.contentType != 0) {
							if (var10.contentType == 1336) {
								if (class150.clientPreferences.method557()) {
									var13 += 15;
									class113.fontPlain12.drawRightAligned("Fps:" + GameEngine.fps, var12 + var10.width, var13, 16776960, -1);
									var13 += 15;
									Runtime var41 = Runtime.getRuntime();
									var20 = (int)((var41.totalMemory() - var41.freeMemory()) / 1024L);
									var21 = 16776960;
									if (var20 > 327680 && !Client.isLowDetail) {
										var21 = 16711680;
									}

									class113.fontPlain12.drawRightAligned("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
									var13 += 15;
								}
								continue;
							}

							if (var10.contentType == 1337) {
								Client.viewportX = var12;
								Client.viewportY = var13;
								class27.drawEntities(var12, var13, var10.width, var10.height);
								Client.field403[var10.rootIndex] = true;
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1338) {
								WorldMapManager.drawMinimap(var10, var12, var13, var11);
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1339) {
								DevicePcmPlayerProvider.drawCompass(var10, var12, var13, var11);
								Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
								continue;
							}

							if (var10.contentType == 1400) {
								class127.worldMap.draw(var12, var13, var10.width, var10.height, Client.cycle);
							}

							if (var10.contentType == 1401) {
								class127.worldMap.drawOverview(var12, var13, var10.width, var10.height);
							}

							if (var10.contentType == 1402) {
								class165.field1419.draw(var12, Client.cycle);
							}
						}

						if (var10.type == 0) {
							if (!var10.isIf3 && WorldMapDecorationType.isComponentHidden(var10) && var10 != WorldMapScaleHandler.mousedOverWidgetIf1) {
								continue;
							}

							if (!var10.isIf3) {
								if (var10.scrollY > var10.scrollHeight - var10.height) {
									var10.scrollY = var10.scrollHeight - var10.height;
								}

								if (var10.scrollY < 0) {
									var10.scrollY = 0;
								}
							}

							drawInterface(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
							if (var10.children != null) {
								drawInterface(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
							}

							InterfaceParent var28 = (InterfaceParent)Client.interfaceParents.get((long)var10.id);
							if (var28 != null) {
								class7.drawWidgets(var28.group, var15, var16, var17, var18, var12, var13, var11);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
							Rasterizer3D.method1176();
						} else if (var10.type == 11) {
							if (WorldMapDecorationType.isComponentHidden(var10) && var10 != WorldMapScaleHandler.mousedOverWidgetIf1) {
								continue;
							}

							if (var10.children != null) {
								drawInterface(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
							}

							Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
							Rasterizer3D.method1176();
						}

						if (Client.isResizable || Client.field405[var11] || Client.gameDrawingMode > 1) {
							if (var10.type == 0 && !var10.isIf3 && var10.scrollHeight > var10.height) {
								class153.drawScrollBar(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
							}

							if (var10.type != 1) {
								if (var10.type == 3) {
									if (GrandExchangeOfferOwnWorldComparator.runCs1(var10)) {
										var19 = var10.color2;
										if (var10 == WorldMapScaleHandler.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
											var19 = var10.mouseOverColor2;
										}
									} else {
										var19 = var10.color;
										if (var10 == WorldMapScaleHandler.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
											var19 = var10.mouseOverColor;
										}
									}

									if (var10.fill) {
										switch(var10.fillMode.field4187) {
										case 1:
											Rasterizer2D.Rasterizer2D_fillRectangleGradient(var12, var13, var10.width, var10.height, var10.color, var10.color2);
											break;
										case 2:
											Rasterizer2D.Rasterizer2D_fillRectangleGradientAlpha(var12, var13, var10.width, var10.height, var10.color, var10.color2, 255 - (var10.transparencyTop & 255), 255 - (var10.transparencyBot & 255));
											break;
										default:
											if (var14 == 0) {
												Rasterizer2D.Rasterizer2D_fillRectangle(var12, var13, var10.width, var10.height, var19);
											} else {
												Rasterizer2D.Rasterizer2D_fillRectangleAlpha(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
											}
										}
									} else if (var14 == 0) {
										Rasterizer2D.Rasterizer2D_drawRectangle(var12, var13, var10.width, var10.height, var19);
									} else {
										Rasterizer2D.Rasterizer2D_drawRectangleAlpha(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
									}
								} else if (var10.type == 4) {
									Font var40 = var10.getFont();
									if (var40 == null) {
										if (Widget.field2926) {
											class200.invalidateWidget(var10);
										}
									} else {
										String var42 = var10.text;
										if (GrandExchangeOfferOwnWorldComparator.runCs1(var10)) {
											var20 = var10.color2;
											if (var10 == WorldMapScaleHandler.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
												var20 = var10.mouseOverColor2;
											}

											if (var10.text2.length() > 0) {
												var42 = var10.text2;
											}
										} else {
											var20 = var10.color;
											if (var10 == WorldMapScaleHandler.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
												var20 = var10.mouseOverColor;
											}
										}

										if (var10.isIf3 && var10.itemId != -1) {
											ItemComposition var43 = class125.ItemDefinition_get(var10.itemId);
											var42 = var43.name;
											if (var42 == null) {
												var42 = "null";
											}

											if ((var43.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
												var42 = MusicPatchPcmStream.colorStartTag(16748608) + var42 + "</col>" + " " + 'x' + class191.formatItemStacks(var10.itemQuantity);
											}
										}

										if (var10 == Client.meslayerContinueWidget) {
											var42 = "Please wait...";
											var20 = var10.color;
										}

										if (!var10.isIf3) {
											var42 = WorldMapRectangle.method1498(var42, var10);
										}

										var40.method2054(var42, var12, var13, var10.width, var10.height, var20, var10.textShadowed ? 0 : -1, class467.method2323(var10.transparencyTop), var10.textXAlignment, var10.textYAlignment, var10.textLineHeight);
									}
								} else {
									int var23;
									int var24;
									int var25;
									if (var10.type == 5) {
										SpritePixels var38;
										if (!var10.isIf3) {
											var38 = var10.getSprite(GrandExchangeOfferOwnWorldComparator.runCs1(var10), WorldMapLabel.urlRequester);
											if (var38 != null) {
												var38.drawTransBgAt(var12, var13);
											} else if (Widget.field2926) {
												class200.invalidateWidget(var10);
											}
										} else {
											if (var10.itemId != -1) {
												var38 = FaceNormal.getItemSprite(var10.itemId, var10.itemQuantity, var10.outline, var10.spriteShadow, var10.itemQuantityMode, false);
											} else {
												var38 = var10.getSprite(false, WorldMapLabel.urlRequester);
											}

											if (var38 == null) {
												if (Widget.field2926) {
													class200.invalidateWidget(var10);
												}
											} else {
												var20 = var38.width;
												var21 = var38.height;
												if (!var10.spriteTiling) {
													var22 = var10.width * 4096 / var20;
													if (var10.spriteAngle != 0) {
														var38.method2668(var10.width / 2 + var12, var10.height / 2 + var13, var10.spriteAngle, var22);
													} else if (var14 != 0) {
														var38.drawTransScaledAt(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
													} else if (var20 == var10.width && var21 == var10.height) {
														var38.drawTransBgAt(var12, var13);
													} else {
														var38.drawScaledAt(var12, var13, var10.width, var10.height);
													}
												} else {
													Rasterizer2D.Rasterizer2D_expandClip(var12, var13, var12 + var10.width, var13 + var10.height);
													var22 = (var20 - 1 + var10.width) / var20;
													var23 = (var21 - 1 + var10.height) / var21;

													for (var24 = 0; var24 < var22; ++var24) {
														for (var25 = 0; var25 < var23; ++var25) {
															if (var10.spriteAngle != 0) {
																var38.method2668(var20 / 2 + var12 + var20 * var24, var21 / 2 + var13 + var25 * var21, var10.spriteAngle, 4096);
															} else if (var14 != 0) {
																var38.drawTransAt(var12 + var20 * var24, var13 + var25 * var21, 256 - (var14 & 255));
															} else {
																var38.drawTransBgAt(var12 + var24 * var20, var13 + var21 * var25);
															}
														}
													}

													Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
												}
											}
										}
									} else {
										int var26;
										if (var10.type == 6) {
											boolean var36 = GrandExchangeOfferOwnWorldComparator.runCs1(var10);
											if (var36) {
												var20 = var10.sequenceId2;
											} else {
												var20 = var10.sequenceId;
											}

											Model var39 = null;
											var22 = 0;
											if (var10.itemId != -1) {
												ItemComposition var44 = class125.ItemDefinition_get(var10.itemId);
												if (var44 != null) {
													var44 = var44.getCountObj(var10.itemQuantity);
													var39 = var44.getModel(1);
													if (var39 != null) {
														var39.calculateBoundsCylinder();
														var22 = var39.height / 2;
													} else {
														class200.invalidateWidget(var10);
													}
												}
											} else if (var10.modelType == 5) {
												if (var10.modelId == 0) {
													var39 = Client.playerAppearance.getModel((SequenceDefinition)null, -1, (SequenceDefinition)null, -1);
												} else {
													var39 = class136.localPlayer.getModel();
												}
											} else if (var10.modelType == 7) {
												var39 = var10.field3081.getModel((SequenceDefinition)null, -1, class135.SequenceDefinition_get(class136.localPlayer.idleSequence), class136.localPlayer.movementFrame);
											} else {
												NPCComposition var45 = null;
												NewShit var33 = null;
												if (var10.modelType == 6) {
													var25 = var10.modelId;
													if (var25 >= 0 && var25 < Client.npcs.length) {
														NPC var34 = Client.npcs[var25];
														if (var34 != null) {
															var45 = var34.definition;
															var33 = var34.method597();
														}
													}
												}

												SequenceDefinition var35 = null;
												var26 = -1;
												if (var20 != -1) {
													var35 = class135.SequenceDefinition_get(var20);
													var26 = var10.modelFrame;
												}

												var39 = var10.getModel(var35, var26, var36, class136.localPlayer.appearance, var45, var33);
												if (var39 == null && Widget.field2926) {
													class200.invalidateWidget(var10);
												}
											}

											Rasterizer3D.method1179(var10.width / 2 + var12, var10.height / 2 + var13);
											var23 = Rasterizer3D.Rasterizer3D_sine[var10.modelAngleX] * var10.modelZoom >> 16;
											var24 = Rasterizer3D.Rasterizer3D_cosine[var10.modelAngleX] * var10.modelZoom >> 16;
											if (var39 != null) {
												if (!var10.isIf3) {
													var39.method1309(0, var10.modelAngleY, 0, var10.modelAngleX, 0, var23, var24);
												} else {
													var39.calculateBoundsCylinder();
													if (var10.modelOrthog) {
														var39.method1310(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var22 + var23 + var10.modelOffsetY, var24 + var10.modelOffsetY, var10.modelZoom);
													} else {
														var39.method1309(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var22 + var23 + var10.modelOffsetY, var24 + var10.modelOffsetY);
													}
												}
											}

											Rasterizer3D.method1178();
										} else {
											Font var29;
											if (var10.type == 8 && var10 == class403.field3700 && Client.field493 == Client.field494) {
												var19 = 0;
												var20 = 0;
												var29 = class113.fontPlain12;
												String var30 = var10.text;

												String var31;
												for (var30 = WorldMapRectangle.method1498(var30, var10); var30.length() > 0; var20 = var20 + var29.ascent + 1) {
													var24 = var30.indexOf("<br>");
													if (var24 != -1) {
														var31 = var30.substring(0, var24);
														var30 = var30.substring(var24 + 4);
													} else {
														var31 = var30;
														var30 = "";
													}

													var25 = var29.stringWidth(var31);
													if (var25 > var19) {
														var19 = var25;
													}
												}

												var19 += 6;
												var20 += 7;
												var24 = var12 + var10.width - 5 - var19;
												var25 = var13 + var10.height + 5;
												if (var24 < var12 + 5) {
													var24 = var12 + 5;
												}

												if (var24 + var19 > var4) {
													var24 = var4 - var19;
												}

												if (var20 + var25 > var5) {
													var25 = var5 - var20;
												}

												Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var19, var20, 16777120);
												Rasterizer2D.Rasterizer2D_drawRectangle(var24, var25, var19, var20, 0);
												var30 = var10.text;
												var26 = var25 + var29.ascent + 2;

												for (var30 = WorldMapRectangle.method1498(var30, var10); var30.length() > 0; var26 = var26 + var29.ascent + 1) {
													int var27 = var30.indexOf("<br>");
													if (var27 != -1) {
														var31 = var30.substring(0, var27);
														var30 = var30.substring(var27 + 4);
													} else {
														var31 = var30;
														var30 = "";
													}

													var29.draw(var31, var24 + 3, var26, 0, -1);
												}
											}

											if (var10.type == 9) {
												if (var10.field2943) {
													var19 = var12;
													var20 = var13 + var10.height;
													var21 = var12 + var10.width;
													var22 = var13;
												} else {
													var19 = var12;
													var20 = var13;
													var21 = var12 + var10.width;
													var22 = var13 + var10.height;
												}

												if (var10.lineWid == 1) {
													Rasterizer2D.Rasterizer2D_drawLine(var19, var20, var21, var22, var10.color);
												} else {
													KeyHandler.method99(var19, var20, var21, var22, var10.color, var10.lineWid);
												}
											} else if (var10.type == 12) {
												class330 var37 = var10.method1805();
												class325 var32 = var10.method1806();
												if (var37 != null && var32 != null && var37.method1750()) {
													var29 = var10.getFont();
													if (var29 != null) {
														Client.field646.method2675(var12, var13, var10.width, var10.height, var37.method1751(), var37.method1752(), var37.method1748(), var37.method1749(), var37.method1747());
														var22 = var10.textShadowed ? var10.spriteShadow * -1608681345 * 1342850943 : -1;
														if (!var37.method1745() && var37.method1742().method1997()) {
															Client.field646.method2676(var32.field2873, var22, var32.field2874, var32.field2875);
															Client.field646.method2677(var37.method1743(), var29);
														} else {
															Client.field646.method2676(var10.color, var22, var32.field2874, var32.field2875);
															Client.field646.method2677(var37.method1742(), var29);
														}

														Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}
}
