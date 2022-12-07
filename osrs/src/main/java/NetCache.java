import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lv")
public class NetCache {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lou;"
   )
   public static AbstractSocket NetCache_socket;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -38046757
   )
   public static int NetCache_loadTime = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -7487830085444458825L
   )
   public static long field4218;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lqp;"
   )
   public static NodeHashTable NetCache_pendingPriorityWrites = new NodeHashTable(4096);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -912683751
   )
   public static int NetCache_pendingPriorityWritesCount = 0;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lqp;"
   )
   public static NodeHashTable NetCache_pendingPriorityResponses = new NodeHashTable(32);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1360562841
   )
   public static int NetCache_pendingPriorityResponsesCount = 0;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Lmd;"
   )
   public static DualNodeDeque NetCache_pendingWritesQueue = new DualNodeDeque();
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Lqp;"
   )
   public static NodeHashTable NetCache_pendingWrites = new NodeHashTable(4096);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 767219283
   )
   public static int NetCache_pendingWritesCount = 0;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Lqp;"
   )
   public static NodeHashTable NetCache_pendingResponses = new NodeHashTable(4096);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -273303851
   )
   public static int NetCache_pendingResponsesCount = 0;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Lqy;"
   )
   public static Buffer NetCache_responseHeaderBuffer = new Buffer(8);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1267001511
   )
   public static int field4216 = 0;
   @ObfuscatedName("l")
   static CRC32 NetCache_crc = new CRC32();
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "[Lln;"
   )
   static Archive[] NetCache_archives = new Archive[256];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 608271417
   )
   static int field4236 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1995959275
   )
   static int field4217 = 255;
   @ObfuscatedName("y")
   public static byte field4232 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -436432309
   )
   public static int NetCache_crcMismatches = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1247182669
   )
   public static int NetCache_ioExceptions = 0;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lf;B)Lx;",
      garbageValue = "-35"
   )
   public static class3 method6566(class6 var0) {
      switch(var0.field16) {
      case 0:
         return new class0();
      default:
         throw new IllegalArgumentException();
      }
   }
}
