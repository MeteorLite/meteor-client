import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mp")
@Implements("ArchiveDiskActionHandler")
public class ArchiveDiskActionHandler implements Runnable {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lnj;"
   )
   @Export("ArchiveDiskActionHandler_requestQueue")
   static NodeDeque ArchiveDiskActionHandler_requestQueue = new NodeDeque();
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lnj;"
   )
   @Export("ArchiveDiskActionHandler_responseQueue")
   static NodeDeque ArchiveDiskActionHandler_responseQueue = new NodeDeque();
   @ObfuscatedName("ac")
   static int field3409 = 0;
   @ObfuscatedName("ab")
   @Export("ArchiveDiskActionHandler_lock")
   static Object ArchiveDiskActionHandler_lock = new Object();
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "Ldt;"
   )
   static LoginScreenAnimation field3410;
   @ObfuscatedName("ju")
   static int field3408;

   @Export("run")
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
                  if (field3409 <= 1) {
                     field3409 = 0;
                     ArchiveDiskActionHandler_lock.notifyAll();
                     return;
                  }

                  field3409 = 600;
               }
            } else {
               Login.method429(100L);
               var14 = ArchiveDiskActionHandler_lock;
               synchronized(ArchiveDiskActionHandler_lock) {
                  if (field3409 <= 1) {
                     field3409 = 0;
                     ArchiveDiskActionHandler_lock.notifyAll();
                     return;
                  }

                  --field3409;
               }
            }
         }
      } catch (Exception var13) {
         class364.RunException_sendStackTrace((String)null, var13);
      }
   }
}
