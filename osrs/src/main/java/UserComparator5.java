import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ObfuscatedName("es")
@Implements("UserComparator5")
public class UserComparator5 extends AbstractUserComparator {
	@ObfuscatedName("jx")
	@Export("regionLandArchives")
	static byte[][] regionLandArchives;
	@ObfuscatedName("au")
	@Export("reversed")
	final boolean reversed;

	public UserComparator5(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lqb;Lqb;B)I",
		garbageValue = "-73"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0) {
			if (var2.world == 0) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world != 0) {
			return this.reversed ? 1 : -1;
		}

		return this.compareUser(var1, var2);
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lorg/json/JSONObject;Ljava/lang/String;S)[F",
		garbageValue = "21147"
	)
	static float[] method679(JSONObject var0, String var1) throws JSONException {
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

	@ObfuscatedName("iv")
	@ObfuscatedSignature(
		descriptor = "(Ldr;I)V",
		garbageValue = "-316834748"
	)
	static final void method680(Actor var0) {
		var0.isWalking = false;
		if (var0.movementSequence != -1) {
			SequenceDefinition var1 = EnumComposition.SequenceDefinition_get(var0.movementSequence);
			if (var1 != null) {
				if (!var1.isCachedModelIdSet() && var1.frameIds != null) {
					++var0.movementFrameCycle;
					if (var0.movementFrame < var1.frameIds.length && var0.movementFrameCycle > var1.frameLengths[var0.movementFrame]) {
						var0.movementFrameCycle = 1;
						++var0.movementFrame;
						FileSystem.method914(var1, var0.movementFrame, var0.x, var0.y);
					}

					if (var0.movementFrame >= var1.frameIds.length) {
						if (var1.frameCount > 0) {
							var0.movementFrame -= var1.frameCount;
							if (var1.field1843) {
								++var0.field999;
							}

							if (var0.movementFrame < 0 || var0.movementFrame >= var1.frameIds.length || var1.field1843 && var0.field999 >= var1.iterations) {
								var0.movementFrameCycle = 0;
								var0.movementFrame = 0;
								var0.field999 = 0;
							}
						} else {
							var0.movementFrameCycle = 0;
							var0.movementFrame = 0;
						}

						FileSystem.method914(var1, var0.movementFrame, var0.x, var0.y);
					}
				} else if (var1.isCachedModelIdSet()) {
					++var0.movementFrame;
					int var2 = var1.method1085();
					if (var0.movementFrame < var2) {
						class169.method880(var1, var0.movementFrame, var0.x, var0.y);
					} else {
						if (var1.frameCount > 0) {
							var0.movementFrame -= var1.frameCount;
							if (var1.field1843) {
								++var0.field999;
							}

							if (var0.movementFrame < 0 || var0.movementFrame >= var2 || var1.field1843 && var0.field999 >= var1.iterations) {
								var0.movementFrame = 0;
								var0.movementFrameCycle = 0;
								var0.field999 = 0;
							}
						} else {
							var0.movementFrameCycle = 0;
							var0.movementFrame = 0;
						}

						class169.method880(var1, var0.movementFrame, var0.x, var0.y);
					}
				} else {
					var0.movementSequence = -1;
				}
			} else {
				var0.movementSequence = -1;
			}
		}

		IterableNodeHashTableIterator var7 = new IterableNodeHashTableIterator(var0.method518());

		int var3;
		for (SpotAnimation var6 = (SpotAnimation)var7.method2449(); var6 != null; var6 = (SpotAnimation)var7.next()) {
			if (var6.field4281 != -1 && Client.cycle >= var6.field4280) {
				var3 = StructComposition.SpotAnimationDefinition_get(var6.field4281).sequence;
				if (var3 == -1) {
					var6.remove();
					--var0.field1011;
				} else {
					var6.field4278 = Math.max(var6.field4278, 0);
					SequenceDefinition var4 = EnumComposition.SequenceDefinition_get(var3);
					if (var4.frameIds != null && !var4.isCachedModelIdSet()) {
						++var6.field4279;
						if (var6.field4278 < var4.frameIds.length && var6.field4279 > var4.frameLengths[var6.field4278]) {
							var6.field4279 = 1;
							++var6.field4278;
							FileSystem.method914(var4, var6.field4278, var0.x, var0.y);
						}

						if (var6.field4278 >= var4.frameIds.length) {
							var6.remove();
							--var0.field1011;
						}
					} else if (var4.isCachedModelIdSet()) {
						++var6.field4278;
						int var5 = var4.method1085();
						if (var6.field4278 < var5) {
							class169.method880(var4, var6.field4278, var0.x, var0.y);
						} else {
							var6.remove();
							--var0.field1011;
						}
					} else {
						var6.remove();
						--var0.field1011;
					}
				}
			}
		}

		SequenceDefinition var8;
		if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
			var8 = EnumComposition.SequenceDefinition_get(var0.sequence);
			if (var8.precedenceAnimating == 1 && var0.field1022 > 0 && var0.spotAnimation <= Client.cycle && var0.exactMoveArrive1Cycle < Client.cycle) {
				var0.sequenceDelay = 1;
				return;
			}
		}

		if (var0.sequence != -1 && var0.sequenceDelay == 0) {
			var8 = EnumComposition.SequenceDefinition_get(var0.sequence);
			if (var8 != null) {
				if (!var8.isCachedModelIdSet() && var8.frameIds != null) {
					++var0.sequenceFrameCycle;
					if (var0.sequenceFrame < var8.frameIds.length && var0.sequenceFrameCycle > var8.frameLengths[var0.sequenceFrame]) {
						var0.sequenceFrameCycle = 1;
						++var0.sequenceFrame;
						FileSystem.method914(var8, var0.sequenceFrame, var0.x, var0.y);
					}

					if (var0.sequenceFrame >= var8.frameIds.length) {
						var0.sequenceFrame -= var8.frameCount;
						++var0.currentSequenceFrameIndex;
						if (var0.currentSequenceFrameIndex >= var8.iterations) {
							var0.sequence = -1;
						} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var8.frameIds.length) {
							FileSystem.method914(var8, var0.sequenceFrame, var0.x, var0.y);
						} else {
							var0.sequence = -1;
						}
					}

					var0.isWalking = var8.stretches;
				} else if (var8.isCachedModelIdSet()) {
					++var0.sequenceFrame;
					var3 = var8.method1085();
					if (var0.sequenceFrame < var3) {
						class169.method880(var8, var0.sequenceFrame, var0.x, var0.y);
					} else {
						var0.sequenceFrame -= var8.frameCount;
						++var0.currentSequenceFrameIndex;
						if (var0.currentSequenceFrameIndex >= var8.iterations) {
							var0.sequence = -1;
						} else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var3) {
							class169.method880(var8, var0.sequenceFrame, var0.x, var0.y);
						} else {
							var0.sequence = -1;
						}
					}
				} else {
					var0.sequence = -1;
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