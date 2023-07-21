import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("Players")
public class Players {
	@ObfuscatedName("ar")
	@Export("activityFlags")
	static byte[] activityFlags;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "[Lio;"
	)
	@Export("playerMovementSpeeds")
	static MoveSpeed[] playerMovementSpeeds;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "[Lty;"
	)
	@Export("cachedAppearanceBuffer")
	static Buffer[] cachedAppearanceBuffer;
	@ObfuscatedName("aj")
	@Export("Players_count")
	static int Players_count;
	@ObfuscatedName("ag")
	@Export("Players_indices")
	static int[] Players_indices;
	@ObfuscatedName("az")
	@Export("Players_emptyIdxCount")
	static int Players_emptyIdxCount;
	@ObfuscatedName("av")
	@Export("Players_emptyIndices")
	static int[] Players_emptyIndices;
	@ObfuscatedName("ap")
	@Export("Players_regions")
	static int[] Players_regions;
	@ObfuscatedName("aq")
	@Export("Players_orientations")
	static int[] Players_orientations;
	@ObfuscatedName("at")
	@Export("Players_targetIndices")
	static int[] Players_targetIndices;
	@ObfuscatedName("ah")
	@Export("Players_pendingUpdateCount")
	static int Players_pendingUpdateCount;
	@ObfuscatedName("ax")
	@Export("Players_pendingUpdateIndices")
	static int[] Players_pendingUpdateIndices;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lty;"
	)
	static Buffer field1111;

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
		field1111 = new Buffer(new byte[5000]);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1685678133"
	)
	public static boolean method622(int var0) {
		return var0 == WorldMapDecorationType.field3117.id;
	}
}
