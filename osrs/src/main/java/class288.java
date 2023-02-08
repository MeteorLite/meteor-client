import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
public class class288 {
   @ObfuscatedName("f")
   static int[] field2689;
   @ObfuscatedName("pz")
   static int field2691;
    @ObfuscatedName("rs")
    @ObfuscatedSignature(
            descriptor = "Lra;"
    )
    static PrivateChatMode privateChatMode;

   static {
      new Object();
      field2689 = new int[33];
      field2689[0] = 0;
      int var0 = 2;

      for(int var1 = 1; var1 < 33; ++var1) {
         field2689[var1] = var0 - 1;
         var0 += var0;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1844004108"
   )
   static void method1550() {
      Object var0 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
         if (ArchiveDiskActionHandler.field3437 == 0) {
            ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
            ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setDaemon(true);
            ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.start();
            ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setPriority(5);
         }

         ArchiveDiskActionHandler.field3437 = 600;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1985801344"
   )
   public static boolean method1551(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
