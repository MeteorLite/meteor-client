import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mz")
public final class class324 {
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(ILpv;Lmx;B)V",
      garbageValue = "-113"
   )
   static void method1796(int var0, ArchiveDisk var1, Archive var2) {
      ArchiveDiskAction var3 = new ArchiveDiskAction();
      var3.type = 1;
      var3.key = (long)var0;
      var3.archiveDisk = var1;
      var3.archive = var2;
      NodeDeque var4 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
         ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
      }

      Skills.method1793();
   }
}
