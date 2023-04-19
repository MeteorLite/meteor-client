import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class162 extends class155 {
    @ObfuscatedName("aa")
    public static int pcmSampleLength;
   @ObfuscatedName("af")
   String field1411;
   @ObfuscatedName("an")
   byte field1410;
   @ObfuscatedName("aw")
   byte field1409;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lgr;"
   )
   final class156 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lgr;)V"
   )
   class162(class156 var1) {
      this.this$0 = var1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "-1949352075"
    )
    void vmethod3238(Buffer var1) {
      this.field1411 = var1.readStringCp1252NullTerminatedOrNull();
      if (this.field1411 != null) {
         var1.readUnsignedByte();
         this.field1410 = var1.readByte();
         this.field1409 = var1.readByte();
      }

   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lgj;B)V",
            garbageValue = "-49"
    )
    void vmethod3239(ClanChannel var1) {
      var1.name = this.field1411;
      if (this.field1411 != null) {
         var1.field1396 = this.field1410;
         var1.field1401 = this.field1409;
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "68"
   )
   static void method912() {
      Messages.Messages_channels.clear();
      Messages.Messages_hashTable.clear();
      Messages.Messages_queue.clear();
      Messages.Messages_count = 0;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      descriptor = "(Lmq;IIB)V",
      garbageValue = "-125"
   )
   public static void method911(Widget var0, int var1, int var2) {
      PlayerComposition var3 = var0.field2894;
      boolean var4 = var2 != var3.field2840;
      var3.field2840 = var2;
      if (var4) {
         int var5;
         int var6;
         if (var3.field2840 == var1) {
            for(var5 = 0; var5 < PlayerComposition.equipmentIndices.length; ++var5) {
               var6 = PlayerComposition.equipmentIndices[var5];
               if (var3.equipment[var6] > 0 && var3.equipment[var6] < 512) {
                  var3.equipment[var6] = var3.field2841[var6];
               }
            }
         } else {
            label58: {
               if (var3.equipment[0] >= 512) {
                  boolean var8;
                  if (var3.equipment[0] < 512) {
                     var8 = false;
                  } else {
                     ItemComposition var7 = HealthBarUpdate.ItemDefinition_get(var3.equipment[0] - 512);
                     var8 = var7.maleModel1 != class204.field1840.field1831 && var7.maleModel2 != class204.field1840.field1831;
                  }

                  if (!var8) {
                     break label58;
                  }
               }

               var3.equipment[class204.field1840.field1831] = 1;
            }

            for(var5 = 0; var5 < 7; ++var5) {
               var6 = PlayerComposition.equipmentIndices[var5];
               if (var3.equipment[var6] > 0 && var3.equipment[var6] < 512) {
                  class163.method915(var2, var3.equipment, var5);
               }
            }
         }
      }

      var3.method1702();
   }
}
