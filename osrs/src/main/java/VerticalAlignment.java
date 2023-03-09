import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lhe;"
   )
   field1592(1, 0),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lhe;"
   )
   @Export("VerticalAlignment_centered")
   VerticalAlignment_centered(2, 1),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lhe;"
   )
   field1594(0, 2);

   @ObfuscatedName("ab")
   @Export("value")
   public final int value;
   @ObfuscatedName("an")
   @Export("id")
   final int id;

   VerticalAlignment(int var3, int var4) {
      this.value = var3;
      this.id = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1334130459"
   )
   public static void method976() {
      while(true) {
         NodeDeque var1 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
         ArchiveDiskAction var0;
         synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
            var0 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.removeLast();
         }

         if (var0 == null) {
            return;
         }

         var0.archive.load(var0.archiveDisk, (int)var0.key, var0.data, false);
      }
   }
}
