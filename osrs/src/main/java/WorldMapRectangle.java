import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
   @ObfuscatedName("uk")
   static int field2359;
   @ObfuscatedName("aj")
   @Export("width")
   int width;
   @ObfuscatedName("al")
   @Export("height")
   int height;
   @ObfuscatedName("ac")
   @Export("x")
   int x;
   @ObfuscatedName("ab")
   @Export("y")
   int y;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Ljt;"
   )
   @Export("this$0")
   @ObfuscatedName("this$0")
   final WorldMapManager this$0;

   @ObfuscatedSignature(
      descriptor = "(Ljt;)V"
   )
   WorldMapRectangle(WorldMapManager var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lsq;I)V",
      garbageValue = "295942057"
   )
   static final void method1457(PacketBuffer var0) {
      int var1 = 0;
      var0.importIndex();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < Players.Players_count; ++var2) {
         var3 = Players.Players_indices[var2];
         if ((Players.activityFlags[var3] & 1) == 0) {
            if (var1 > 0) {
               --var1;
               Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
            } else {
               var4 = var0.readBits(1);
               if (var4 == 0) {
                  var1 = Fonts.method2308(var0);
                  Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
               } else {
                  AttackOption.readPlayerUpdate(var0, var3);
               }
            }
         }
      }

      var0.exportIndex();
      if (var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.importIndex();

         for(var2 = 0; var2 < Players.Players_count; ++var2) {
            var3 = Players.Players_indices[var2];
            if ((Players.activityFlags[var3] & 1) != 0) {
               if (var1 > 0) {
                  --var1;
                  Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
               } else {
                  var4 = var0.readBits(1);
                  if (var4 == 0) {
                     var1 = Fonts.method2308(var0);
                     Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                  } else {
                     AttackOption.readPlayerUpdate(var0, var3);
                  }
               }
            }
         }

         var0.exportIndex();
         if (var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.importIndex();

            for(var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
               var3 = Players.Players_emptyIndices[var2];
               if ((Players.activityFlags[var3] & 1) != 0) {
                  if (var1 > 0) {
                     --var1;
                     Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                  } else {
                     var4 = var0.readBits(1);
                     if (var4 == 0) {
                        var1 = Fonts.method2308(var0);
                        Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                     } else if (class157.updateExternalPlayer(var0, var3)) {
                        Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                     }
                  }
               }
            }

            var0.exportIndex();
            if (var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.importIndex();

               for(var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
                  var3 = Players.Players_emptyIndices[var2];
                  if ((Players.activityFlags[var3] & 1) == 0) {
                     if (var1 > 0) {
                        --var1;
                        Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                     } else {
                        var4 = var0.readBits(1);
                        if (var4 == 0) {
                           var1 = Fonts.method2308(var0);
                           Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                        } else if (class157.updateExternalPlayer(var0, var3)) {
                           Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                        }
                     }
                  }
               }

               var0.exportIndex();
               if (var1 != 0) {
                  throw new RuntimeException();
               } else {
                  Players.Players_count = 0;
                  Players.Players_emptyIdxCount = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     Players.activityFlags[var2] = (byte)(Players.activityFlags[var2] >> 1);
                     Player var5 = Client.players[var2];
                     if (var5 != null) {
                        Players.Players_indices[++Players.Players_count - 1] = var2;
                     } else {
                        Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }
}
