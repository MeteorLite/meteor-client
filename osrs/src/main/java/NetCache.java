import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nk")
@Implements("NetCache")
public class NetCache {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lpj;"
   )
   @Export("NetCache_socket")
   public static AbstractSocket NetCache_socket;
   @ObfuscatedName("al")
   @Export("NetCache_loadTime")
   public static int NetCache_loadTime = 0;
   @ObfuscatedName("ac")
   public static long field3445;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lrh;"
   )
   @Export("NetCache_pendingPriorityWrites")
   public static NodeHashTable NetCache_pendingPriorityWrites = new NodeHashTable(4096);
   @ObfuscatedName("an")
   @Export("NetCache_pendingPriorityWritesCount")
   public static int NetCache_pendingPriorityWritesCount = 0;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lrh;"
   )
   @Export("NetCache_pendingPriorityResponses")
   public static NodeHashTable NetCache_pendingPriorityResponses = new NodeHashTable(32);
   @ObfuscatedName("av")
   @Export("NetCache_pendingPriorityResponsesCount")
   public static int NetCache_pendingPriorityResponsesCount = 0;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lnl;"
   )
   @Export("NetCache_pendingWritesQueue")
   public static DualNodeDeque NetCache_pendingWritesQueue = new DualNodeDeque();
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lrh;"
   )
   @Export("NetCache_pendingWrites")
   public static NodeHashTable NetCache_pendingWrites = new NodeHashTable(4096);
   @ObfuscatedName("ar")
   @Export("NetCache_pendingWritesCount")
   public static int NetCache_pendingWritesCount = 0;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Lrh;"
   )
   @Export("NetCache_pendingResponses")
   public static NodeHashTable NetCache_pendingResponses = new NodeHashTable(4096);
   @ObfuscatedName("ax")
   @Export("NetCache_pendingResponsesCount")
   public static int NetCache_pendingResponsesCount = 0;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Lsy;"
   )
   @Export("NetCache_responseHeaderBuffer")
   public static Buffer NetCache_responseHeaderBuffer = new Buffer(8);
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "Lsy;"
   )
   @Export("NetCache_responseArchiveBuffer")
   public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("ae")
   public static int field3457 = 0;
   @ObfuscatedName("ag")
   @Export("NetCache_crc")
   public static CRC32 NetCache_crc = new CRC32();
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "[Lmx;"
   )
   @Export("NetCache_archives")
   public static Archive[] NetCache_archives = new Archive[256];
   @ObfuscatedName("ai")
   static int field3459 = -1;
   @ObfuscatedName("aw")
   static int field3460 = 255;
   @ObfuscatedName("aa")
   public static byte field3454 = 0;
   @ObfuscatedName("ah")
   @Export("NetCache_crcMismatches")
   public static int NetCache_crcMismatches = 0;
   @ObfuscatedName("ad")
   @Export("NetCache_ioExceptions")
   public static int NetCache_ioExceptions = 0;

   @ObfuscatedName("ls")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1019053742"
   )
   static final int method1853() {
      float var0 = 200.0F * ((float)WorldMapSectionType.clientPreferences.getBrightness() - 0.5F);
      return 100 - Math.round(var0);
   }
}
