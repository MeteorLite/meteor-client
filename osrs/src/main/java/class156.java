import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class156 {
   @ObfuscatedName("af")
   long field1389;
   @ObfuscatedName("an")
   long field1388 = -1L;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Loi;"
   )
   IterableNodeDeque field1390 = new IterableNodeDeque();

   @ObfuscatedSignature(
      descriptor = "(Lsg;)V"
   )
   public class156(Buffer var1) {
      this.method887(var1);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lsg;I)V",
      garbageValue = "-1593521254"
   )
   void method887(Buffer var1) {
      this.field1389 = var1.readLong();
      this.field1388 = var1.readLong();

      for(int var2 = var1.readUnsignedByte(); var2 != 0; var2 = var1.readUnsignedByte()) {
         Object var3;
         if (var2 == 1) {
            var3 = new class151(this);
         } else if (var2 == 4) {
            var3 = new class162(this);
         } else if (var2 == 3) {
            var3 = new class147(this);
         } else if (var2 == 2) {
            var3 = new class145(this);
         } else {
            if (var2 != 5) {
               throw new RuntimeException("");
            }

            var3 = new class152(this);
         }

         ((class155)var3).vmethod3238(var1);
         this.field1390.addFirst((Node)var3);
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lgj;B)V",
      garbageValue = "-101"
   )
   public void method888(ClanChannel var1) {
      if (this.field1389 == var1.key && this.field1388 == var1.field1399) {
         for(class155 var2 = (class155)this.field1390.last(); var2 != null; var2 = (class155)this.field1390.previous()) {
            var2.vmethod3239(var1);
         }

         ++var1.field1399;
      } else {
         throw new RuntimeException("");
      }
   }

    @ObfuscatedName("kw")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-742935767"
    )
    static void addCancelMenuEntry() {
      Client.menuOptionsCount = 0;
      Client.isMenuOpen = false;
      Client.menuActions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuOpcodes[0] = 1006;
      Client.menuShiftClick[0] = false;
      Client.menuOptionsCount = 1;
   }
}
