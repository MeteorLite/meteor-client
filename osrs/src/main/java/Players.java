import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("Players")
public class Players {
	@ObfuscatedName("ar")
	@Export("activityFlags")
	static byte[] activityFlags;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "[Liz;"
	)
	@Export("playerMovementSpeeds")
	static MoveSpeed[] playerMovementSpeeds;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "[Luj;"
	)
	@Export("cachedAppearanceBuffer")
	static Buffer[] cachedAppearanceBuffer;
	@ObfuscatedName("au")
	@Export("Players_count")
	static int Players_count;
	@ObfuscatedName("aa")
	@Export("Players_indices")
	static int[] Players_indices;
	@ObfuscatedName("ac")
	@Export("Players_emptyIdxCount")
	static int Players_emptyIdxCount;
	@ObfuscatedName("al")
	@Export("Players_emptyIndices")
	static int[] Players_emptyIndices;
	@ObfuscatedName("az")
	@Export("Players_regions")
	static int[] Players_regions;
	@ObfuscatedName("ap")
	@Export("Players_orientations")
	static int[] Players_orientations;
	@ObfuscatedName("av")
	@Export("Players_targetIndices")
	static int[] Players_targetIndices;
	@ObfuscatedName("ax")
	@Export("Players_pendingUpdateCount")
	static int Players_pendingUpdateCount;
	@ObfuscatedName("as")
	@Export("Players_pendingUpdateIndices")
	static int[] Players_pendingUpdateIndices;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Luj;"
	)
	static Buffer field1126;
	@ObfuscatedName("re")
	@ObfuscatedSignature(
		descriptor = "Ltl;"
	)
	@Export("Widget_cachedFonts")
	static class509 Widget_cachedFonts;

	static {
		activityFlags = new byte[2048];
		playerMovementSpeeds = new MoveSpeed[2048];
		cachedAppearanceBuffer = new Buffer[2048];
		Players_count = 0;
		Players_indices = new int[2048];
		Players_emptyIdxCount = 0;
		Players_emptyIndices = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		Players_pendingUpdateCount = 0;
		Players_pendingUpdateIndices = new int[2048];
		field1126 = new Buffer(new byte[5000]);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Luo;I)V",
		garbageValue = "-823798047"
	)
	@Export("updatePlayer")
	static final void updatePlayer(PacketBuffer var0) {
		var0.importIndex();
		int var1 = Client.localPlayerIndex;
		Player var2 = class229.localPlayer = Client.players[var1] = new Player();
		var2.index = var1;
		int var3 = var0.readBits(30);
		byte var4 = (byte)(var3 >> 28);
		int var5 = var3 >> 14 & 16383;
		int var6 = var3 & 16383;
		var2.pathX[0] = var5 - NewShit.baseX;
		var2.x = (var2.pathX[0] << 7) + (var2.transformedSize() << 6);
		var2.pathY[0] = var6 - class101.baseY;
		var2.y = (var2.pathY[0] << 7) + (var2.transformedSize() << 6);
		ItemLayer.Client_plane = var2.plane = var4;
		if (cachedAppearanceBuffer[var1] != null) {
			var2.read(cachedAppearanceBuffer[var1]);
		}

		Players_count = 0;
		Players_indices[++Players_count - 1] = var1;
		activityFlags[var1] = 0;
		Players_emptyIdxCount = 0;

		for (int var7 = 1; var7 < 2048; ++var7) {
			if (var1 != var7) {
				int var8 = var0.readBits(18);
				int var9 = var8 >> 16;
				int var10 = var8 >> 8 & 597;
				int var11 = var8 & 597;
				Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
				Players_orientations[var7] = 0;
				Players_targetIndices[var7] = -1;
				Players_emptyIndices[++Players_emptyIdxCount - 1] = var7;
				activityFlags[var7] = 0;
			}
		}

		var0.exportIndex();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lol;Ljava/lang/String;Ljava/lang/String;I)[Luz;",
		garbageValue = "-669885727"
	)
	public static SpritePixels[] method620(AbstractArchive var0, String var1, String var2) {
		if (!var0.isValidFileName(var1, var2)) {
			return null;
		} else {
			int var3 = var0.getGroupId(var1);
			int var4 = var0.getFileId(var3, var2);
			return VertexNormal.method1568(var0, var3, var4);
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(IIZI)Ljava/lang/String;",
		garbageValue = "-1100853766"
	)
	static String method619(int var0, int var1, boolean var2) {
		if (var1 >= 2 && var1 <= 36) {
			if (var2 && var0 >= 0) {
				int var3 = 2;

				for (int var4 = var0 / var1; var4 != 0; ++var3) {
					var4 /= var1;
				}

				char[] var5 = new char[var3];
				var5[0] = '+';

				for (int var6 = var3 - 1; var6 > 0; --var6) {
					int var7 = var0;
					var0 /= var1;
					int var8 = var7 - var0 * var1;
					if (var8 >= 10) {
						var5[var6] = (char)(var8 + 87);
					} else {
						var5[var6] = (char)(var8 + 48);
					}
				}

				return new String(var5);
			} else {
				return Integer.toString(var0, var1);
			}
		} else {
			throw new IllegalArgumentException("" + var1);
		}
	}
}