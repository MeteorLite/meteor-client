import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public enum class6 implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lar;"
	)
	field4(0, 0);

	@ObfuscatedName("al")
	public final int field6;
	@ObfuscatedName("ak")
	final int field5;

	class6(int var3, int var4) {
		this.field6 = var3;
		this.field5 = var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field5;
	}

	@ObfuscatedName("il")
	@ObfuscatedSignature(
		descriptor = "(Ldi;II)V",
		garbageValue = "1987002078"
	)
	@Export("updateActorSequence")
	static final void updateActorSequence(Actor var0, int var1) {
		int var2;
		int var3;
		int var4;
		int var5;
		int var7;
		SequenceDefinition var11;
		if (var0.spotAnimation >= Client.cycle) {
			var2 = Math.max(1, var0.spotAnimation - Client.cycle);
			var3 = var0.field971 * 64 + var0.field1016 * 128;
			var4 = var0.field971 * 64 + var0.field1013 * 128;
			var0.x += (var3 - var0.x) / var2;
			var0.y += (var4 - var0.y) / var2;
			var0.field1024 = 0;
			var0.orientation = var0.exactMoveDirection;
		} else if (var0.exactMoveArrive1Cycle >= Client.cycle) {
			JagexCache.method918(var0);
		} else {
			var0.movementSequence = var0.idleSequence;
			if (var0.pathLength == 0) {
				var0.field1024 = 0;
			} else {
				label554: {
					if (var0.sequence != -1 && var0.sequenceDelay == 0) {
						var11 = class36.SequenceDefinition_get(var0.sequence);
						if (var0.field1023 > 0 && var11.precedenceAnimating == 0) {
							++var0.field1024;
							break label554;
						}

						if (var0.field1023 <= 0 && var11.priority == 0) {
							++var0.field1024;
							break label554;
						}
					}

					var2 = var0.x;
					var3 = var0.y;
					var4 = var0.field971 * 64 + var0.pathX[var0.pathLength - 1] * 128;
					var5 = var0.field971 * 64 + var0.pathY[var0.pathLength - 1] * 128;
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
						var7 = var0.orientation - var0.rotation & 2047;
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
							if (var0.rotation != var0.orientation && var0.targetIndex == -1 && var0.field1020 != 0) {
								var9 = 2;
							}

							if (var0.pathLength > 2) {
								var9 = 6;
							}

							if (var0.pathLength > 3) {
								var9 = 8;
							}

							if (var0.field1024 > 0 && var0.pathLength > 1) {
								var9 = 8;
								--var0.field1024;
							}
						} else {
							if (var0.pathLength > 1) {
								var9 = 6;
							}

							if (var0.pathLength > 2) {
								var9 = 8;
							}

							if (var0.field1024 > 0 && var0.pathLength > 1) {
								var9 = 8;
								--var0.field1024;
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
							} else if (var0.walkLeftSequence == var0.movementSequence && var0.runLeftSequence != -1) {
								var0.movementSequence = var0.runLeftSequence;
							} else if (var0.movementSequence == var0.walkRightSequence && var0.runRightSequence != -1) {
								var0.movementSequence = var0.runRightSequence;
							}
						} else if (var9 <= 2) {
							if (var0.walkSequence == var0.movementSequence && var0.crawlSequence != -1) {
								var0.movementSequence = var0.crawlSequence;
							} else if (var0.movementSequence == var0.walkBackSequence && var0.crawlBackSequence != -1) {
								var0.movementSequence = var0.crawlBackSequence;
							} else if (var0.walkLeftSequence == var0.movementSequence && var0.crawlLeftSequence != -1) {
								var0.movementSequence = var0.crawlLeftSequence;
							} else if (var0.movementSequence == var0.walkRightSequence && var0.crawlRightSequence != -1) {
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
							if (var0.field1023 > 0) {
								--var0.field1023;
							}
						}
					} else {
						var0.x = var4;
						var0.y = var5;
						--var0.pathLength;
						if (var0.field1023 > 0) {
							--var0.field1023;
						}
					}
				}
			}
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = 0;
			var0.exactMoveArrive1Cycle = 0;
			var0.method519();
			var0.x = var0.field971 * 64 + var0.pathX[0] * 128;
			var0.y = var0.pathY[0] * 128 + var0.field971 * 64;
			var0.method512();
		}

		if (TextureProvider.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = 0;
			var0.exactMoveArrive1Cycle = 0;
			var0.method519();
			var0.x = var0.field971 * 64 + var0.pathX[0] * 128;
			var0.y = var0.pathY[0] * 128 + var0.field971 * 64;
			var0.method512();
		}

		if (var0.targetIndex != -1) {
			var11 = null;
			var3 = 65536;
			Object var18;
			if (var0.targetIndex < var3) {
				var18 = Client.npcs[var0.targetIndex];
			} else {
				var18 = Client.players[var0.targetIndex - var3];
			}

			if (var18 != null) {
				var4 = var0.x - ((Actor)var18).x;
				var5 = var0.y - ((Actor)var18).y;
				if (var4 != 0 || var5 != 0) {
					var7 = (int)(Math.atan2((double)var4, (double)var5) * 325.94932345220167D) & 2047;
					var0.orientation = var7;
				}
			} else if (var0.false0) {
				var0.targetIndex = -1;
				var0.false0 = false;
			}
		}

		int var12;
		if (var0.pathLength == 0 || var0.field1024 > 0) {
			var2 = -1;
			if (var0.field995 != -1 && var0.field996 != -1) {
				var3 = var0.field995 * 128 - class20.baseX * 128 + 64;
				var4 = var0.field996 * 128 - class19.baseY * 128 + 64;
				var5 = var0.x - var3;
				var12 = var0.y - var4;
				if (var5 != 0 || var12 != 0) {
					var7 = (int)(Math.atan2((double)var5, (double)var12) * 325.94932345220167D) & 2047;
					var2 = var7;
				}
			} else if (var0.movingOrientation != -1) {
				var2 = var0.movingOrientation;
			}

			if (var2 != -1) {
				var0.orientation = var2;
				if (var0.field964) {
					var0.rotation = var0.orientation;
				}
			}

			var0.method521();
		}

		var2 = var0.orientation - var0.rotation & 2047;
		if (var2 != 0) {
			boolean var16 = true;
			boolean var17 = true;
			++var0.field1004;
			var5 = var2 > 1024 ? -1 : 1;
			var0.rotation += var0.field1020 * var5;
			boolean var19 = true;
			if (var2 < var0.field1020 || var2 > 2048 - var0.field1020) {
				var0.rotation = var0.orientation;
				var19 = false;
			}

			if (var0.field1020 > 0 && var0.movementSequence == var0.idleSequence && (var0.field1004 > 25 || var19)) {
				if (var5 == -1 && var0.turnLeftSequence != -1) {
					var0.movementSequence = var0.turnLeftSequence;
				} else if (var5 == 1 && var0.turnRightSequence != -1) {
					var0.movementSequence = var0.turnRightSequence;
				} else {
					var0.movementSequence = var0.walkSequence;
				}
			}

			var0.rotation &= 2047;
		} else {
			if (var0.false0) {
				var0.targetIndex = -1;
				var0.false0 = false;
			}

			var0.field1004 = 0;
		}

		var0.isWalking = false;
		if (var0.movementSequence != -1) {
			var11 = class36.SequenceDefinition_get(var0.movementSequence);
			if (var11 != null) {
				if (!var11.isCachedModelIdSet() && var11.frameIds != null) {
					++var0.movementFrameCycle;
					if (var0.movementFrame < var11.frameIds.length && var0.movementFrameCycle > var11.frameLengths[var0.movementFrame]) {
						var0.movementFrameCycle = 1;
						++var0.movementFrame;
						FontName.method2481(var11, var0.movementFrame, var0.x, var0.y);
					}

					if (var0.movementFrame >= var11.frameIds.length) {
						if (var11.frameCount > 0) {
							var0.movementFrame -= var11.frameCount;
							if (var11.field1849) {
								++var0.field993;
							}

							if (var0.movementFrame < 0 || var0.movementFrame >= var11.frameIds.length || var11.field1849 && var0.field993 >= var11.iterations) {
								var0.movementFrameCycle = 0;
								var0.movementFrame = 0;
								var0.field993 = 0;
							}
						} else {
							var0.movementFrameCycle = 0;
							var0.movementFrame = 0;
						}

						FontName.method2481(var11, var0.movementFrame, var0.x, var0.y);
					}
				} else if (var11.isCachedModelIdSet()) {
					++var0.movementFrame;
					var3 = var11.method1127();
					if (var0.movementFrame < var3) {
						ModeWhere.method2013(var11, var0.movementFrame, var0.x, var0.y);
					} else {
						if (var11.frameCount > 0) {
							var0.movementFrame -= var11.frameCount;
							if (var11.field1849) {
								++var0.field993;
							}

							if (var0.movementFrame < 0 || var0.movementFrame >= var3 || var11.field1849 && var0.field993 >= var11.iterations) {
								var0.movementFrame = 0;
								var0.movementFrameCycle = 0;
								var0.field993 = 0;
							}
						} else {
							var0.movementFrameCycle = 0;
							var0.movementFrame = 0;
						}

						ModeWhere.method2013(var11, var0.movementFrame, var0.x, var0.y);
					}
				} else {
					var0.movementSequence = -1;
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		IterableNodeHashTableIterator var20 = new IterableNodeHashTableIterator(var0.method518());

		for (SpotAnimation var14 = (SpotAnimation)var20.method2484(); var14 != null; var14 = (SpotAnimation)var20.next()) {
			if (var14.field4304 != -1 && Client.cycle >= var14.field4308) {
				var4 = class406.SpotAnimationDefinition_get(var14.field4304).sequence;
				if (var4 == -1) {
					var14.remove();
					--var0.field1007;
				} else {
					var14.field4306 = Math.max(var14.field4306, 0);
					SequenceDefinition var15 = class36.SequenceDefinition_get(var4);
					if (var15.frameIds != null && !var15.isCachedModelIdSet()) {
						++var14.field4305;
						if (var14.field4306 < var15.frameIds.length && var14.field4305 > var15.frameLengths[var14.field4306]) {
							var14.field4305 = 1;
							++var14.field4306;
							FontName.method2481(var15, var14.field4306, var0.x, var0.y);
						}

						if (var14.field4306 >= var15.frameIds.length) {
							var14.remove();
							--var0.field1007;
						}
					} else if (var15.isCachedModelIdSet()) {
						++var14.field4306;
						var12 = var15.method1127();
						if (var14.field4306 < var12) {
							ModeWhere.method2013(var15, var14.field4306, var0.x, var0.y);
						} else {
							var14.remove();
							--var0.field1007;
						}
					} else {
						var14.remove();
						--var0.field1007;
					}
				}
			}
		}

		SequenceDefinition var21;
		if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
			var21 = class36.SequenceDefinition_get(var0.sequence);
			if (var21.precedenceAnimating == 1 && var0.field1023 > 0 && var0.spotAnimation <= Client.cycle && var0.exactMoveArrive1Cycle < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var21 = class36.SequenceDefinition_get(var0.sequence);
			if (var21 == null) {
				var0.sequence = -1;
			} else if (!var21.isCachedModelIdSet() && var21.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var21.frameIds.length && var0.sequenceFrameCycle > var21.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					FontName.method2481(var21, var0.sequenceFrame, var0.x, var0.y);
				}

				if (var0.sequenceFrame >= var21.frameIds.length) {
					var0.sequenceFrame -= var21.frameCount;
					++var0.currentSequenceFrameIndex;
					if (var0.currentSequenceFrameIndex >= var21.iterations) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var21.frameIds.length) {
						FontName.method2481(var21, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequence = -1;
					}
				}

				var0.isWalking = var21.stretches;
			} else if (var21.isCachedModelIdSet()) {
				++var0.sequenceFrame;
				var4 = var21.method1127();
				if (var0.sequenceFrame < var4) {
					ModeWhere.method2013(var21, var0.sequenceFrame, var0.x, var0.y);
				} else {
					var0.sequenceFrame -= var21.frameCount;
					++var0.currentSequenceFrameIndex;
					if (var0.currentSequenceFrameIndex >= var21.iterations) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var4) {
						ModeWhere.method2013(var21, var0.sequenceFrame, var0.x, var0.y);
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

	@ObfuscatedName("km")
	@ObfuscatedSignature(
		descriptor = "(IIIIII)V",
		garbageValue = "569925847"
	)
	@Export("drawObject")
	static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
		long var5 = class10.scene.getBoundaryObjectTag(var0, var1, var2);
		int var7;
		int var8;
		int var9;
		int var10;
		int var12;
		int var13;
		if (var5 != 0L) {
			var7 = class10.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = var3;
			if (class372.method1929(var5)) {
				var10 = var4;
			}

			int[] var11 = SpriteMask.sceneMinimapSprite.pixels;
			var12 = var1 * 4 + (103 - var2) * 2048 + 24624;
			var13 = SecureRandomFuture.Entity_unpackID(var5);
			ObjectComposition var14 = class91.getObjectDefinition(var13);
			if (var14.mapSceneId != -1) {
				IndexedSprite var15 = KitDefinition.mapSceneSprites[var14.mapSceneId];
				if (var15 != null) {
					int var16 = (var14.sizeX * 4 - var15.subWidth) / 2;
					int var17 = (var14.sizeY * 4 - var15.subHeight) / 2;
					var15.drawAt(var16 + var1 * 4 + 48, var17 + (104 - var2 - var14.sizeY) * 4 + 48);
				}
			} else {
				if (var9 == 0 || var9 == 2) {
					if (var8 == 0) {
						var11[var12] = var10;
						var11[var12 + 512] = var10;
						var11[var12 + 1024] = var10;
						var11[var12 + 1536] = var10;
					} else if (var8 == 1) {
						var11[var12] = var10;
						var11[var12 + 1] = var10;
						var11[var12 + 2] = var10;
						var11[var12 + 3] = var10;
					} else if (var8 == 2) {
						var11[var12 + 3] = var10;
						var11[var12 + 512 + 3] = var10;
						var11[var12 + 1024 + 3] = var10;
						var11[var12 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var11[var12 + 1536] = var10;
						var11[var12 + 1536 + 1] = var10;
						var11[var12 + 1536 + 2] = var10;
						var11[var12 + 1536 + 3] = var10;
					}
				}

				if (var9 == 3) {
					if (var8 == 0) {
						var11[var12] = var10;
					} else if (var8 == 1) {
						var11[var12 + 3] = var10;
					} else if (var8 == 2) {
						var11[var12 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var11[var12 + 1536] = var10;
					}
				}

				if (var9 == 2) {
					if (var8 == 3) {
						var11[var12] = var10;
						var11[var12 + 512] = var10;
						var11[var12 + 1024] = var10;
						var11[var12 + 1536] = var10;
					} else if (var8 == 0) {
						var11[var12] = var10;
						var11[var12 + 1] = var10;
						var11[var12 + 2] = var10;
						var11[var12 + 3] = var10;
					} else if (var8 == 1) {
						var11[var12 + 3] = var10;
						var11[var12 + 512 + 3] = var10;
						var11[var12 + 1024 + 3] = var10;
						var11[var12 + 1536 + 3] = var10;
					} else if (var8 == 2) {
						var11[var12 + 1536] = var10;
						var11[var12 + 1536 + 1] = var10;
						var11[var12 + 1536 + 2] = var10;
						var11[var12 + 1536 + 3] = var10;
					}
				}
			}
		}

		var5 = class10.scene.getGameObjectTag(var0, var1, var2);
		if (var5 != 0L) {
			var7 = class10.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = SecureRandomFuture.Entity_unpackID(var5);
			ObjectComposition var24 = class91.getObjectDefinition(var10);
			int var19;
			if (var24.mapSceneId != -1) {
				IndexedSprite var18 = KitDefinition.mapSceneSprites[var24.mapSceneId];
				if (var18 != null) {
					var13 = (var24.sizeX * 4 - var18.subWidth) / 2;
					var19 = (var24.sizeY * 4 - var18.subHeight) / 2;
					var18.drawAt(var1 * 4 + var13 + 48, var19 + (104 - var2 - var24.sizeY) * 4 + 48);
				}
			} else if (var9 == 9) {
				var12 = 15658734;
				if (class372.method1929(var5)) {
					var12 = 15597568;
				}

				int[] var20 = SpriteMask.sceneMinimapSprite.pixels;
				var19 = var1 * 4 + (103 - var2) * 2048 + 24624;
				if (var8 != 0 && var8 != 2) {
					var20[var19] = var12;
					var20[var19 + 1 + 512] = var12;
					var20[var19 + 1024 + 2] = var12;
					var20[var19 + 1536 + 3] = var12;
				} else {
					var20[var19 + 1536] = var12;
					var20[var19 + 1 + 1024] = var12;
					var20[var19 + 512 + 2] = var12;
					var20[var19 + 3] = var12;
				}
			}
		}

		var5 = class10.scene.getFloorDecorationTag(var0, var1, var2);
		if (0L != var5) {
			var7 = SecureRandomFuture.Entity_unpackID(var5);
			ObjectComposition var21 = class91.getObjectDefinition(var7);
			if (var21.mapSceneId != -1) {
				IndexedSprite var22 = KitDefinition.mapSceneSprites[var21.mapSceneId];
				if (var22 != null) {
					var10 = (var21.sizeX * 4 - var22.subWidth) / 2;
					int var23 = (var21.sizeY * 4 - var22.subHeight) / 2;
					var22.drawAt(var10 + var1 * 4 + 48, (104 - var2 - var21.sizeY) * 4 + var23 + 48);
				}
			}
		}

	}

	@ObfuscatedName("no")
	@ObfuscatedSignature(
		descriptor = "(Lnm;I)V",
		garbageValue = "-2045006615"
	)
	static final void method16(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 324) {
			if (Client.field548 == -1) {
				Client.field548 = var0.spriteId2;
				Client.field549 = var0.spriteId;
			}

			if (Client.playerAppearance.field2950 == 1) {
				var0.spriteId2 = Client.field548;
			} else {
				var0.spriteId2 = Client.field549;
			}

		} else if (var1 == 325) {
			if (Client.field548 == -1) {
				Client.field548 = var0.spriteId2;
				Client.field549 = var0.spriteId;
			}

			if (Client.playerAppearance.field2950 == 1) {
				var0.spriteId2 = Client.field549;
			} else {
				var0.spriteId2 = Client.field548;
			}

		} else if (var1 == 327) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 0;
		} else if (var1 == 328) {
			var0.modelAngleX = 150;
			var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
			var0.modelType = 5;
			var0.modelId = 1;
		}
	}
}