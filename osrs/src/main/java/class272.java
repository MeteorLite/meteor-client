import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
public class class272 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(ILoi;Lln;I)V",
      garbageValue = "1655477466"
   )
   static void method1515(int var0, ArchiveDisk var1, Archive var2) {
      ArchiveDiskAction var3 = new ArchiveDiskAction();
      var3.type = 1;
      var3.key = (long)var0;
      var3.archiveDisk = var1;
      var3.archive = var2;
      NodeDeque var4 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
         ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
      }

      class154.method822();
   }

   @ObfuscatedName("m")
   public static boolean method1513(long var0) {
      return (int)(var0 >>> 16 & 1L) == 1;
   }

   @ObfuscatedName("nb")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-677085282"
   )
   static void method1514(int var0) {
      Client.oculusOrbState = var0;
   }
}
