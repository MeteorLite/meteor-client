import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class154 extends class136 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "Lco;"
   )
   static LoginScreenAnimation field1379;
   @ObfuscatedName("hk")
   static int baseX;
   @ObfuscatedName("h")
   int field1376;
   @ObfuscatedName("e")
   int field1378;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lem;"
   )
   final class139 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lem;)V"
   )
   class154(class139 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1101327225"
   )
   void vmethod3254(Buffer var1) {
      this.field1376 = var1.readInt();
      this.field1378 = var1.readInt();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   void vmethod3248(ClanSettings var1) {
      var1.method789(this.field1376, this.field1378);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-106"
   )
   static void method822() {
      Object var0 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
         if (ArchiveDiskActionHandler.field3432 == 0) {
            AbstractByteArrayCopier.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
            AbstractByteArrayCopier.ArchiveDiskActionHandler_thread.setDaemon(true);
            AbstractByteArrayCopier.ArchiveDiskActionHandler_thread.start();
            AbstractByteArrayCopier.ArchiveDiskActionHandler_thread.setPriority(5);
         }

         ArchiveDiskActionHandler.field3432 = 600;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "11"
   )
   public static void method821() {
      FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      descriptor = "(B)J",
      garbageValue = "0"
   )
   static long method823() {
      return Client.field482;
   }
}
