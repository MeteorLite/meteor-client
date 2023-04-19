import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nr")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
    @ObfuscatedName("an")
    public static Comparator GrandExchangeEvents_ageComparator = new GrandExchangeOfferAgeComparator();
    @ObfuscatedName("aw")
    public static Comparator GrandExchangeEvents_priceComparator;
    @ObfuscatedName("ac")
    public static Comparator GrandExchangeEvents_nameComparator;
    @ObfuscatedName("au")
    public static Comparator GrandExchangeEvents_quantityComparator;
    @ObfuscatedName("af")
    public final List events;

   static {
      new GrandExchangeOfferWorldComparator();
      GrandExchangeEvents_priceComparator = new GrandExchangeOfferUnitPriceComparator();
      GrandExchangeEvents_nameComparator = new GrandExchangeOfferNameComparator();
      GrandExchangeEvents_quantityComparator = new GrandExchangeOfferTotalQuantityComparator();
   }

   @ObfuscatedSignature(
      descriptor = "(Lsg;Z)V",
      garbageValue = "1"
   )
   public GrandExchangeEvents(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if (var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.events = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.events.add(new GrandExchangeEvent(var1, var5, var3));
      }

   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Ljava/util/Comparator;ZI)V",
            garbageValue = "694808074"
    )
    public void sort(Comparator var1, boolean var2) {
      if (var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lsq;II)V",
            garbageValue = "-48927414"
    )
    static final void updatePlayers(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      Players.Players_pendingUpdateCount = 0;
      int var3 = 0;
      var0.importIndex();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < Players.Players_count; ++var4) {
         var5 = Players.Players_indices[var4];
         if ((Players.activityFlags[var5] & 1) == 0) {
            if (var3 > 0) {
               --var3;
               Players.activityFlags[var5] = (byte)(Players.activityFlags[var5] | 2);
            } else {
               var6 = var0.readBits(1);
               if (var6 == 0) {
                  var3 = LoginScreenAnimation.method551(var0);
                  Players.activityFlags[var5] = (byte)(Players.activityFlags[var5] | 2);
               } else {
                  class330.readPlayerUpdate(var0, var5);
               }
            }
         }
      }

      var0.exportIndex();
      if (var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.importIndex();

         for(var4 = 0; var4 < Players.Players_count; ++var4) {
            var5 = Players.Players_indices[var4];
            if ((Players.activityFlags[var5] & 1) != 0) {
               if (var3 > 0) {
                  --var3;
                  Players.activityFlags[var5] = (byte)(Players.activityFlags[var5] | 2);
               } else {
                  var6 = var0.readBits(1);
                  if (var6 == 0) {
                     var3 = LoginScreenAnimation.method551(var0);
                     Players.activityFlags[var5] = (byte)(Players.activityFlags[var5] | 2);
                  } else {
                     class330.readPlayerUpdate(var0, var5);
                  }
               }
            }
         }

         var0.exportIndex();
         if (var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.importIndex();

            for(var4 = 0; var4 < Players.Players_emptyIdxCount; ++var4) {
               var5 = Players.Players_emptyIndices[var4];
               if ((Players.activityFlags[var5] & 1) != 0) {
                  if (var3 > 0) {
                     --var3;
                     Players.activityFlags[var5] = (byte)(Players.activityFlags[var5] | 2);
                  } else {
                     var6 = var0.readBits(1);
                     if (var6 == 0) {
                        var3 = LoginScreenAnimation.method551(var0);
                        Players.activityFlags[var5] = (byte)(Players.activityFlags[var5] | 2);
                     } else if (WorldMapID.updateExternalPlayer(var0, var5)) {
                        Players.activityFlags[var5] = (byte)(Players.activityFlags[var5] | 2);
                     }
                  }
               }
            }

            var0.exportIndex();
            if (var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.importIndex();

               for(var4 = 0; var4 < Players.Players_emptyIdxCount; ++var4) {
                  var5 = Players.Players_emptyIndices[var4];
                  if ((Players.activityFlags[var5] & 1) == 0) {
                     if (var3 > 0) {
                        --var3;
                        Players.activityFlags[var5] = (byte)(Players.activityFlags[var5] | 2);
                     } else {
                        var6 = var0.readBits(1);
                        if (var6 == 0) {
                           var3 = LoginScreenAnimation.method551(var0);
                           Players.activityFlags[var5] = (byte)(Players.activityFlags[var5] | 2);
                        } else if (WorldMapID.updateExternalPlayer(var0, var5)) {
                           Players.activityFlags[var5] = (byte)(Players.activityFlags[var5] | 2);
                        }
                     }
                  }
               }

               var0.exportIndex();
               if (var3 != 0) {
                  throw new RuntimeException();
               } else {
                  Players.Players_count = 0;
                  Players.Players_emptyIdxCount = 0;

                  for(var4 = 1; var4 < 2048; ++var4) {
                     Players.activityFlags[var4] = (byte)(Players.activityFlags[var4] >> 1);
                     Player var7 = Client.players[var4];
                     if (var7 != null) {
                        Players.Players_indices[++Players.Players_count - 1] = var4;
                     } else {
                        Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var4;
                     }
                  }

                  WorldMapLabelSize.method1397(var0);
                  if (var0.offset - var2 != var1) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }
}
