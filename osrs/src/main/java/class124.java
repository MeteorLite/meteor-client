import java.util.Iterator;
import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class124 implements Callable {
    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            descriptor = "Lon;"
    )
    public static Font ItemDefinition_fontPlain11;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lek;"
   )
   final class125 field1212;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Ley;"
   )
   final class126 field1210;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lec;"
   )
   final class127 field1214;
   @ObfuscatedName("ac")
   final int field1211;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lfh;"
   )
   @ObfuscatedName("this$0")
   final class133 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfh;Lek;Ley;Lec;I)V"
   )
   class124(class133 var1, class125 var2, class126 var3, class127 var4, int var5) {
      this.this$0 = var1;
      this.field1212 = var2;
      this.field1210 = var3;
      this.field1214 = var4;
      this.field1211 = var5;
   }

    @ObfuscatedName("call")
    public Object call() {
      this.field1212.method750();
      class125[][] var1;
      if (this.field1210 == class126.field1240) {
         var1 = this.this$0.field1279;
      } else {
         var1 = this.this$0.field1282;
      }

      var1[this.field1211][this.field1214.method756()] = this.field1212;
      return null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1442694367"
   )
   static void method741() {
      Object var0 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
         if (ArchiveDiskActionHandler.field3453 == 0) {
            GrandExchangeOfferNameComparator.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
            GrandExchangeOfferNameComparator.ArchiveDiskActionHandler_thread.setDaemon(true);
            GrandExchangeOfferNameComparator.ArchiveDiskActionHandler_thread.start();
            GrandExchangeOfferNameComparator.ArchiveDiskActionHandler_thread.setPriority(5);
         }

         ArchiveDiskActionHandler.field3453 = 600;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "49"
   )
   static void method742() {
      Iterator var0 = Messages.Messages_hashTable.iterator();

      while(var0.hasNext()) {
         Message var1 = (Message)var0.next();
         var1.clearIsFromIgnored();
      }

   }
}
