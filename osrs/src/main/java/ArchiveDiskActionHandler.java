import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("li")
@Implements("ArchiveDiskActionHandler")
public class ArchiveDiskActionHandler implements Runnable {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lmo;"
    )
    static NodeDeque ArchiveDiskActionHandler_requestQueue = new NodeDeque();
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lmo;"
    )
    static NodeDeque ArchiveDiskActionHandler_responseQueue = new NodeDeque();
   @ObfuscatedName("v")
   public static int field3437 = 0;
    @ObfuscatedName("s")
    public static Object ArchiveDiskActionHandler_lock = new Object();
    @ObfuscatedName("z")
    static Thread ArchiveDiskActionHandler_thread;

    @ObfuscatedName("run")
    public void run() {
      try {
         while(true) {
            NodeDeque var2 = ArchiveDiskActionHandler_requestQueue;
            ArchiveDiskAction var1;
            synchronized(ArchiveDiskActionHandler_requestQueue) {
               var1 = (ArchiveDiskAction)ArchiveDiskActionHandler_requestQueue.last();
            }

            Object var14;
            if (var1 != null) {
               if (var1.type == 0) {
                  var1.archiveDisk.write((int)var1.key, var1.data, var1.data.length);
                  var2 = ArchiveDiskActionHandler_requestQueue;
                  synchronized(ArchiveDiskActionHandler_requestQueue) {
                     var1.remove();
                  }
               } else if (var1.type == 1) {
                  var1.data = var1.archiveDisk.read((int)var1.key);
                  var2 = ArchiveDiskActionHandler_requestQueue;
                  synchronized(ArchiveDiskActionHandler_requestQueue) {
                     ArchiveDiskActionHandler_responseQueue.addFirst(var1);
                  }
               }

               var14 = ArchiveDiskActionHandler_lock;
               synchronized(ArchiveDiskActionHandler_lock) {
                  if (field3437 <= 1) {
                     field3437 = 0;
                     ArchiveDiskActionHandler_lock.notifyAll();
                     return;
                  }

                  field3437 = 600;
               }
            } else {
               Clock.method911(100L);
               var14 = ArchiveDiskActionHandler_lock;
               synchronized(ArchiveDiskActionHandler_lock) {
                  if (field3437 <= 1) {
                     field3437 = 0;
                     ArchiveDiskActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3437;
               }
            }
         }
      } catch (Exception var13) {
         class121.RunException_sendStackTrace((String)null, var13);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IIII)I",
      garbageValue = "1911527843"
   )
   public static int method1792(int var0, int var1, int var2) {
      int var3 = SoundCache.method231(var2 - var1 + 1);
      var3 <<= var1;
      return var0 & ~var3;
   }
}
