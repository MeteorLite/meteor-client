import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public class class105 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1105 = new class105(0);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1104 = new class105(1);
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1093 = new class105(2);
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1100 = new class105(3);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1095 = new class105(4);
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1096 = new class105(5);
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1101 = new class105(6);
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1106 = new class105(7);
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1099 = new class105(8);
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1092 = new class105(9);
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1094 = new class105(10);
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1102 = new class105(11);
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1103 = new class105(12);
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   static final class105 field1097 = new class105(13);
   @ObfuscatedName("am")
   int field1098;

   class105(int var1) {
      this.field1098 = var1;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "-35"
   )
   static int method604(int var0, Script var1, boolean var2) {
      int var3;
      if (var0 == 5504) {
         Interpreter.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         int var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         if (!Client.isCameraLocked) {
            Client.camAngleX = var3;
            Client.camAngleY = var4;
         }

         return 1;
      } else if (var0 == 5505) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camAngleX;
         return 1;
      } else if (var0 == 5506) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camAngleY;
         return 1;
      } else if (var0 == 5530) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         if (var3 < 0) {
            var3 = 0;
         }

         Client.camFollowHeight = var3;
         return 1;
      } else if (var0 == 5531) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camFollowHeight;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1729736934"
   )
   @Export("getGcDuration")
   protected static int getGcDuration() {
      int var0 = 0;
      if (class135.garbageCollector == null || !class135.garbageCollector.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if (var2.isValid()) {
                  class135.garbageCollector = var2;
                  GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                  GameEngine.garbageCollectorLastCollectionTime = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if (class135.garbageCollector != null) {
         long var9 = WorldMapSection2.clockNow();
         long var3 = class135.garbageCollector.getCollectionTime();
         if (GameEngine.garbageCollectorLastCollectionTime != -1L) {
            long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
            long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
            if (var7 != 0L) {
               var0 = (int)(var5 * 100L / var7);
            }
         }

         GameEngine.garbageCollectorLastCollectionTime = var3;
         GameEngine.garbageCollectorLastCheckTimeMs = var9;
      }

      return var0;
   }
}
