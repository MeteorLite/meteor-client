import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lv")
@Implements("NetCache")
public class NetCache {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lov;"
    )
    public static AbstractSocket NetCache_socket;
    @ObfuscatedName("w")
    public static int NetCache_loadTime = 0;
   @ObfuscatedName("v")
   public static long field3486;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lqg;"
    )
    public static NodeHashTable NetCache_pendingPriorityWrites = new NodeHashTable(4096);
    @ObfuscatedName("z")
    public static int NetCache_pendingPriorityWritesCount = 0;
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "Lqg;"
    )
    public static NodeHashTable NetCache_pendingPriorityResponses = new NodeHashTable(32);
    @ObfuscatedName("i")
    public static int NetCache_pendingPriorityResponsesCount = 0;
    @ObfuscatedName("n")
    @ObfuscatedSignature(
            descriptor = "Lmy;"
    )
    public static DualNodeDeque NetCache_pendingWritesQueue = new DualNodeDeque();
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "Lqg;"
    )
    public static NodeHashTable NetCache_pendingWrites = new NodeHashTable(4096);
    @ObfuscatedName("k")
    public static int NetCache_pendingWritesCount = 0;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            descriptor = "Lqg;"
    )
    public static NodeHashTable NetCache_pendingResponses = new NodeHashTable(4096);
    @ObfuscatedName("r")
    public static int NetCache_pendingResponsesCount = 0;
    @ObfuscatedName("t")
    @ObfuscatedSignature(
            descriptor = "Lrd;"
    )
    public static Buffer NetCache_responseHeaderBuffer = new Buffer(8);
   @ObfuscatedName("p")
   public static int field3484 = 0;
    @ObfuscatedName("u")
    static CRC32 NetCache_crc = new CRC32();
    @ObfuscatedName("a")
    @ObfuscatedSignature(
            descriptor = "[Llm;"
    )
    static Archive[] NetCache_archives = new Archive[256];
   @ObfuscatedName("q")
   static int field3487 = -1;
   @ObfuscatedName("d")
   static int field3488 = 255;
   @ObfuscatedName("e")
   public static byte field3482 = 0;
    @ObfuscatedName("g")
    public static int NetCache_crcMismatches = 0;
    @ObfuscatedName("y")
    public static int NetCache_ioExceptions = 0;
    @ObfuscatedName("ey")
    @ObfuscatedSignature(
            descriptor = "Llm;"
    )
    static Archive archive9;
    @ObfuscatedName("fr")
    static String worldHost;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "670848294"
   )
   public static byte[] method1839(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if (var4 > 127) {
            var2[var3] = 63;
         } else {
            var2[var3] = (byte)var4;
         }
      }

      return var2;
   }
}
