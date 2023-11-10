import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("MoveSpeed")
public enum MoveSpeed implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Liz;"
	)
	@Export("STATIONARY")
	STATIONARY((byte)-1),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Liz;"
	)
	@Export("CRAWL")
	CRAWL((byte)0),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Liz;"
	)
	@Export("WALK")
	WALK((byte)1),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Liz;"
	)
	@Export("RUN")
	RUN((byte)2);

	@ObfuscatedName("cw")
	static String field1933;
	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		descriptor = "[Lup;"
	)
	@Export("worldSelectStars")
	static IndexedSprite[] worldSelectStars;
	@ObfuscatedName("ab")
	@Export("speed")
	public byte speed;

	MoveSpeed(byte var3) {
		this.speed = var3;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.speed;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I[III)V",
		garbageValue = "-1953021335"
	)
	static void method1167(int var0, int[] var1, int var2) {
		for (int var3 = 0; var3 < class348.KitDefinition_fileCount; ++var3) {
			KitDefinition var4 = class1.KitDefinition_get(var3);
			if (var4 != null && !var4.nonSelectable && var4.bodypartID == (var0 == 1 ? 7 : 0) + var2) {
				var1[PlayerComposition.equipmentIndices[var2]] = var3 + 256;
				break;
			}
		}

	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		descriptor = "(Ldf;II)V",
		garbageValue = "-1026770295"
	)
	@Export("updateActorSequence")
	static final void updateActorSequence(Actor var0, int var1) {
		int var3;
		int var4;
		int var6;
		SequenceDefinition var9;
		if (var0.spotAnimation >= Client.cycle) {
			int var2 = Math.max(1, var0.spotAnimation - Client.cycle);
			var3 = var0.field983 * 64 + var0.field1013 * 128;
			var4 = var0.field983 * 64 + var0.field1012 * 128;
			var0.x += (var3 - var0.x) / var2;
			var0.y += (var4 - var0.y) / var2;
			var0.field1028 = 0;
			var0.orientation = var0.exactMoveDirection;
		} else if (var0.exactMoveArrive1Cycle >= Client.cycle) {
			boolean var12 = var0.exactMoveArrive1Cycle == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0;
			if (!var12) {
				var9 = DynamicObject.SequenceDefinition_get(var0.sequence);
				if (var9 != null && !var9.isCachedModelIdSet()) {
					var12 = var0.sequenceFrameCycle + 1 > var9.frameLengths[var0.sequenceFrame];
				} else {
					var12 = true;
				}
			}

			if (var12) {
				var3 = var0.exactMoveArrive1Cycle - var0.spotAnimation;
				var4 = Client.cycle - var0.spotAnimation;
				int var5 = var0.field983 * 64 + var0.field1013 * 128;
				var6 = var0.field983 * 64 + var0.field1012 * 128;
				int var7 = var0.field983 * 64 + var0.field1024 * 128;
				int var8 = var0.field983 * 64 + var0.field1010 * 128;
				var0.x = (var4 * var7 + var5 * (var3 - var4)) / var3;
				var0.y = (var8 * var4 + var6 * (var3 - var4)) / var3;
			}

			var0.field1028 = 0;
			var0.orientation = var0.exactMoveDirection;
			var0.rotation = var0.orientation;
		} else {
			DevicePcmPlayerProvider.method84(var0);
		}

		if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
			var0.sequence = -1;
			var0.spotAnimation = 0;
			var0.exactMoveArrive1Cycle = 0;
			var0.method513();
			var0.x = var0.pathX[0] * 128 + var0.field983 * 64;
			var0.y = var0.field983 * 64 + var0.pathY[0] * 128;
			var0.method506();
		}

		if (class229.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
			var0.sequence = -1;
			var0.spotAnimation = 0;
			var0.exactMoveArrive1Cycle = 0;
			var0.method513();
			var0.x = var0.pathX[0] * 128 + var0.field983 * 64;
			var0.y = var0.pathY[0] * 128 + var0.field983 * 64;
			var0.method506();
		}

		WorldMap.method2456(var0);
		var0.isWalking = false;
		if (var0.movementSequence != -1) {
			SequenceDefinition var10 = DynamicObject.SequenceDefinition_get(var0.movementSequence);
			if (var10 != null) {
				if (!var10.isCachedModelIdSet() && var10.frameIds != null) {
					++var0.movementFrameCycle;
					if (var0.movementFrame < var10.frameIds.length && var0.movementFrameCycle > var10.frameLengths[var0.movementFrame]) {
						var0.movementFrameCycle = 1;
						++var0.movementFrame;
						DynamicObject.method451(var10, var0.movementFrame, var0.x, var0.y, var0);
					}

					if (var0.movementFrame >= var10.frameIds.length) {
						if (var10.frameCount > 0) {
							var0.movementFrame -= var10.frameCount;
							if (var10.field1796) {
								++var0.field1006;
							}

							if (var0.movementFrame < 0 || var0.movementFrame >= var10.frameIds.length || var10.field1796 && var0.field1006 >= var10.iterations) {
								var0.movementFrameCycle = 0;
								var0.movementFrame = 0;
								var0.field1006 = 0;
							}
						} else {
							var0.movementFrameCycle = 0;
							var0.movementFrame = 0;
						}

						DynamicObject.method451(var10, var0.movementFrame, var0.x, var0.y, var0);
					}
				} else if (var10.isCachedModelIdSet()) {
					++var0.movementFrame;
					var3 = var10.method1052();
					if (var0.movementFrame < var3) {
						FriendLoginUpdate.method2227(var10, var0.movementFrame, var0.x, var0.y, var0);
					} else {
						if (var10.frameCount > 0) {
							var0.movementFrame -= var10.frameCount;
							if (var10.field1796) {
								++var0.field1006;
							}

							if (var0.movementFrame < 0 || var0.movementFrame >= var3 || var10.field1796 && var0.field1006 >= var10.iterations) {
								var0.movementFrame = 0;
								var0.movementFrameCycle = 0;
								var0.field1006 = 0;
							}
						} else {
							var0.movementFrameCycle = 0;
							var0.movementFrame = 0;
						}

						FriendLoginUpdate.method2227(var10, var0.movementFrame, var0.x, var0.y, var0);
					}
				} else {
					var0.movementSequence = -1;
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		IterableNodeHashTableIterator var14 = new IterableNodeHashTableIterator(var0.method512());

		for (SpotAnimation var13 = (SpotAnimation)var14.method2461(); var13 != null; var13 = (SpotAnimation)var14.next()) {
			if (var13.field4313 != -1 && Client.cycle >= var13.field4311) {
				var4 = Canvas.SpotAnimationDefinition_get(var13.field4313).sequence;
				if (var4 == -1) {
					var13.remove();
					--var0.field1026;
				} else {
					var13.field4310 = Math.max(var13.field4310, 0);
					SequenceDefinition var11 = DynamicObject.SequenceDefinition_get(var4);
					if (var11.frameIds != null && !var11.isCachedModelIdSet()) {
						++var13.field4312;
						if (var13.field4310 < var11.frameIds.length && var13.field4312 > var11.frameLengths[var13.field4310]) {
							var13.field4312 = 1;
							++var13.field4310;
							DynamicObject.method451(var11, var13.field4310, var0.x, var0.y, var0);
						}

						if (var13.field4310 >= var11.frameIds.length) {
							var13.remove();
							--var0.field1026;
						}
					} else if (var11.isCachedModelIdSet()) {
						++var13.field4310;
						var6 = var11.method1052();
						if (var13.field4310 < var6) {
							FriendLoginUpdate.method2227(var11, var13.field4310, var0.x, var0.y, var0);
						} else {
							var13.remove();
							--var0.field1026;
						}
					} else {
						var13.remove();
						--var0.field1026;
					}
				}
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
			var9 = DynamicObject.SequenceDefinition_get(var0.sequence);
			if (var9.precedenceAnimating == 1 && var0.field1029 > 0 && var0.spotAnimation <= Client.cycle && var0.exactMoveArrive1Cycle < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var9 = DynamicObject.SequenceDefinition_get(var0.sequence);
			if (var9 == null) {
				var0.sequence = -1;
			} else if (!var9.isCachedModelIdSet() && var9.frameIds != null) {
				++var0.sequenceFrameCycle;
				if (var0.sequenceFrame < var9.frameIds.length && var0.sequenceFrameCycle > var9.frameLengths[var0.sequenceFrame]) {
					var0.sequenceFrameCycle = 1;
					++var0.sequenceFrame;
					DynamicObject.method451(var9, var0.sequenceFrame, var0.x, var0.y, var0);
				}

				if (var0.sequenceFrame >= var9.frameIds.length) {
					var0.sequenceFrame -= var9.frameCount;
					++var0.currentSequenceFrameIndex;
					if (var0.currentSequenceFrameIndex >= var9.iterations) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var9.frameIds.length) {
						DynamicObject.method451(var9, var0.sequenceFrame, var0.x, var0.y, var0);
					} else {
						var0.sequence = -1;
					}
				}

				var0.isWalking = var9.stretches;
			} else if (var9.isCachedModelIdSet()) {
				++var0.sequenceFrame;
				var4 = var9.method1052();
				if (var0.sequenceFrame < var4) {
					FriendLoginUpdate.method2227(var9, var0.sequenceFrame, var0.x, var0.y, var0);
				} else {
					var0.sequenceFrame -= var9.frameCount;
					++var0.currentSequenceFrameIndex;
					if (var0.currentSequenceFrameIndex >= var9.iterations) {
						var0.sequence = -1;
					} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var4) {
						FriendLoginUpdate.method2227(var9, var0.sequenceFrame, var0.x, var0.y, var0);
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
}