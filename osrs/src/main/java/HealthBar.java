import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("HealthBar")
public class HealthBar extends Node {
   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   static Archive field1045;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lfw;"
   )
   HealthBarDefinition definition;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lmv;"
   )
   IterableNodeDeque updates = new IterableNodeDeque();

   @ObfuscatedSignature(
      descriptor = "(Lfw;)V"
   )
   HealthBar(HealthBarDefinition var1) {
      this.definition = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IIIIS)V",
      garbageValue = "-24757"
   )
   void put(int var1, int var2, int var3, int var4) {
      HealthBarUpdate var5 = null;
      int var6 = 0;

      for(HealthBarUpdate var7 = (HealthBarUpdate)this.updates.last(); var7 != null; var7 = (HealthBarUpdate)this.updates.previous()) {
         ++var6;
         if (var7.cycle == var1) {
            var7.set(var1, var2, var3, var4);
            return;
         }

         if (var7.cycle <= var1) {
            var5 = var7;
         }
      }

      if (var5 == null) {
         if (var6 < 4) {
            this.updates.addLast(new HealthBarUpdate(var1, var2, var3, var4));
         }

      } else {
         IterableNodeDeque.IterableNodeDeque_addBefore(new HealthBarUpdate(var1, var2, var3, var4), var5);
         if (var6 >= 4) {
            this.updates.last().remove();
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)Lcu;",
      garbageValue = "-1494424352"
   )
   HealthBarUpdate get(int var1) {
      HealthBarUpdate var2 = (HealthBarUpdate)this.updates.last();
      if (var2 != null && var2.cycle <= var1) {
         for(HealthBarUpdate var3 = (HealthBarUpdate)this.updates.previous(); var3 != null && var3.cycle <= var1; var3 = (HealthBarUpdate)this.updates.previous()) {
            var2.remove();
            var2 = var3;
         }

         if (this.definition.int5 + var2.cycleOffset + var2.cycle > var1) {
            return var2;
         } else {
            var2.remove();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1047690816"
   )
   boolean isEmpty() {
      return this.updates.method1891();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lly;I)V",
      garbageValue = "784434833"
   )
   public static void method572(AbstractArchive var0) {
      ParamComposition.ParamDefinition_archive = var0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-8692175"
   )
   static void method571() {
      for(ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if (var0.obj != null) {
            var0.set();
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(CII)Ljava/lang/String;",
      garbageValue = "1267412510"
   )
   static String method570(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIIII)V",
      garbageValue = "824026775"
   )
   static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (Players.loadInterface(var0)) {
         MouseHandler.field151 = null;
         class34.drawInterface(class71.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if (MouseHandler.field151 != null) {
            class34.drawInterface(MouseHandler.field151, -1412584499, var1, var2, var3, var4, class142.field1316, HealthBarDefinition.field1526, var7);
            MouseHandler.field151 = null;
         }

      } else {
         if (var7 != -1) {
            Client.field576[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field576[var8] = true;
            }
         }

      }
   }
}
