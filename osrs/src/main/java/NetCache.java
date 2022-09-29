import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lh")
@Implements("NetCache")
public class NetCache {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lnl;"
	)
	@Export("NetCache_socket")
	public static AbstractSocket NetCache_socket;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -587502367
	)
	@Export("NetCache_loadTime")
	public static int NetCache_loadTime;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		longValue = -3234666347510926673L
	)
	public static long field4058;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lpm;"
	)
	@Export("NetCache_pendingPriorityWrites")
	public static NodeHashTable NetCache_pendingPriorityWrites;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -775655019
	)
	@Export("NetCache_pendingPriorityWritesCount")
	public static int NetCache_pendingPriorityWritesCount;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Lpm;"
	)
	@Export("NetCache_pendingPriorityResponses")
	public static NodeHashTable NetCache_pendingPriorityResponses;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 180815883
	)
	@Export("NetCache_pendingPriorityResponsesCount")
	public static int NetCache_pendingPriorityResponsesCount;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "Lly;"
	)
	@Export("NetCache_pendingWritesQueue")
	public static DualNodeDeque NetCache_pendingWritesQueue;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "Lpm;"
	)
	@Export("NetCache_pendingWrites")
	static NodeHashTable NetCache_pendingWrites;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -872729149
	)
	@Export("NetCache_pendingWritesCount")
	public static int NetCache_pendingWritesCount;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "Lpm;"
	)
	@Export("NetCache_pendingResponses")
	public static NodeHashTable NetCache_pendingResponses;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -687037599
	)
	@Export("NetCache_pendingResponsesCount")
	public static int NetCache_pendingResponsesCount;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "Lqq;"
	)
	@Export("NetCache_responseHeaderBuffer")
	public static Buffer NetCache_responseHeaderBuffer;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -31926009
	)
	public static int field4075;
	@ObfuscatedName("l")
	@Export("NetCache_crc")
	public static CRC32 NetCache_crc;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		descriptor = "[Llb;"
	)
	@Export("NetCache_archives")
	public static Archive[] NetCache_archives;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 599034389
	)
	static int field4072;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 911127177
	)
	static int field4073;
	@ObfuscatedName("r")
	public static byte field4068;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 507315079
	)
	@Export("NetCache_crcMismatches")
	public static int NetCache_crcMismatches;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 548490093
	)
	@Export("NetCache_ioExceptions")
	public static int NetCache_ioExceptions;

	static {
		NetCache_loadTime = 0;
		NetCache_pendingPriorityWrites = new NodeHashTable(4096);
		NetCache_pendingPriorityWritesCount = 0;
		NetCache_pendingPriorityResponses = new NodeHashTable(32);
		NetCache_pendingPriorityResponsesCount = 0;
		NetCache_pendingWritesQueue = new DualNodeDeque();
		NetCache_pendingWrites = new NodeHashTable(4096);
		NetCache_pendingWritesCount = 0;
		NetCache_pendingResponses = new NodeHashTable(4096);
		NetCache_pendingResponsesCount = 0;
		NetCache_responseHeaderBuffer = new Buffer(8);
		field4075 = 0;
		NetCache_crc = new CRC32();
		NetCache_archives = new Archive[256];
		field4072 = -1;
		field4073 = 255;
		field4068 = 0;
		NetCache_crcMismatches = 0;
		NetCache_ioExceptions = 0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "(I)Lbo;",
		garbageValue = "807405643"
	)
	@Export("getNextWorldListWorld")
	static World getNextWorldListWorld() {
		return World.World_listCount < World.World_count ? World.World_worlds[++World.World_listCount - 1] : null;
	}
}
