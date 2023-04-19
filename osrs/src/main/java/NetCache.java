import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nl")
@Implements("NetCache")
public class NetCache {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lph;"
    )
    public static AbstractSocket NetCache_socket;
    @ObfuscatedName("an")
    public static int NetCache_loadTime = 0;
   @ObfuscatedName("aw")
   public static long field3509;
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Lrc;"
    )
    public static NodeHashTable NetCache_pendingPriorityWrites = new NodeHashTable(4096);
    @ObfuscatedName("au")
    public static int NetCache_pendingPriorityWritesCount = 0;
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Lrc;"
    )
    public static NodeHashTable NetCache_pendingPriorityResponses = new NodeHashTable(32);
    @ObfuscatedName("aq")
    public static int NetCache_pendingPriorityResponsesCount = 0;
    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "Lni;"
    )
    public static DualNodeDeque NetCache_pendingWritesQueue = new DualNodeDeque();
    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "Lrc;"
    )
    public static NodeHashTable NetCache_pendingWrites = new NodeHashTable(4096);
    @ObfuscatedName("aa")
    public static int NetCache_pendingWritesCount = 0;
    @ObfuscatedName("ay")
    @ObfuscatedSignature(
            descriptor = "Lrc;"
    )
    public static NodeHashTable NetCache_pendingResponses = new NodeHashTable(4096);
    @ObfuscatedName("ao")
    public static int NetCache_pendingResponsesCount = 0;
   @ObfuscatedName("ax")
   static boolean field3498;
    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            descriptor = "Lsg;"
    )
    public static Buffer NetCache_responseHeaderBuffer = new Buffer(8);
    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            descriptor = "Lsg;"
    )
    public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("av")
   public static int field3504 = 0;
    @ObfuscatedName("am")
    static CRC32 NetCache_crc = new CRC32();
    @ObfuscatedName("aj")
    @ObfuscatedSignature(
            descriptor = "[Lnd;"
    )
    static Archive[] NetCache_archives = new Archive[256];
   @ObfuscatedName("ak")
   static int field3489 = -1;
   @ObfuscatedName("az")
   static int field3508 = 255;
   @ObfuscatedName("ad")
   public static byte field3506 = 0;
    @ObfuscatedName("ae")
    public static int NetCache_crcMismatches = 0;
    @ObfuscatedName("ap")
    public static int NetCache_ioExceptions = 0;

    @ObfuscatedName("bq")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "1990174320"
    )
    protected static int getGcDuration() {
      int var0 = 0;
      if (class291.garbageCollector == null || !class291.garbageCollector.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if (var2.isValid()) {
                  class291.garbageCollector = var2;
                  GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                  GameEngine.garbageCollectorLastCollectionTime = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if (class291.garbageCollector != null) {
         long var9 = class96.clockNow();
         long var3 = class291.garbageCollector.getCollectionTime();
         if (GameEngine.garbageCollectorLastCollectionTime != -1L) {
            long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
            long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
            if (var7 != 0L) {
               var0 = (int)(var5 * 100L / var7);
            }
         }

         GameEngine.garbageCollectorLastCollectionTime = var3;
         GameEngine.garbageCollectorLastCheckTimeMs = var9;
      }

      return var0;
   }
}
