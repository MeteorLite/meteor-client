import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("my")
public class class358 {
   @ObfuscatedName("h")
   public static final char[] cp1252AsciiExtension = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   @ObfuscatedName("m")
   static int field3565;
   @ObfuscatedName("f")
   static byte[][][] field3562;
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   static Archive archive13;
   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      descriptor = "[Lrx;"
   )
   static SpritePixels[] headIconHintSprites;
   @ObfuscatedName("oe")
   static int selectedSpellWidget;

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "85706073"
   )
   static int method1909(int var0, Script var1, boolean var2) {
      int var3;
      if (var0 == 3903) {
         var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].type();
         return 1;
      } else if (var0 == 3904) {
         var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].id;
         return 1;
      } else if (var0 == 3905) {
         var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].unitPrice;
         return 1;
      } else if (var0 == 3906) {
         var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if (var0 == 3907) {
         var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentQuantity;
         return 1;
      } else if (var0 == 3908) {
         var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentPrice;
         return 1;
      } else {
         int var12;
         if (var0 == 3910) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var12 == 0 ? 1 : 0;
            return 1;
         } else if (var0 == 3911) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var12 == 2 ? 1 : 0;
            return 1;
         } else if (var0 == 3912) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var12 == 5 ? 1 : 0;
            return 1;
         } else if (var0 == 3913) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var12 == 1 ? 1 : 0;
            return 1;
         } else {
            boolean var13;
            if (var0 == 3914) {
               var13 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
               if (ItemContainer.grandExchangeEvents != null) {
                  ItemContainer.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_nameComparator, var13);
               }

               return 1;
            } else if (var0 == 3915) {
               var13 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
               if (ItemContainer.grandExchangeEvents != null) {
                  ItemContainer.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_priceComparator, var13);
               }

               return 1;
            } else if (var0 == 3916) {
               class87.Interpreter_intStackSize -= 2;
               var13 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize] == 1;
               boolean var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1] == 1;
               if (ItemContainer.grandExchangeEvents != null) {
                  Client.GrandExchangeEvents_worldComparator.filterWorlds = var4;
                  ItemContainer.grandExchangeEvents.sort(Client.GrandExchangeEvents_worldComparator, var13);
               }

               return 1;
            } else if (var0 == 3917) {
               var13 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
               if (ItemContainer.grandExchangeEvents != null) {
                  ItemContainer.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_ageComparator, var13);
               }

               return 1;
            } else if (var0 == 3918) {
               var13 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
               if (ItemContainer.grandExchangeEvents != null) {
                  ItemContainer.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_quantityComparator, var13);
               }

               return 1;
            } else if (var0 == 3919) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = ItemContainer.grandExchangeEvents == null ? 0 : ItemContainer.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if (var0 == 3920) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var11.world;
                  return 1;
               } else if (var0 == 3921) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.getOfferName();
                  return 1;
               } else if (var0 == 3922) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var11.getPreviousOfferName();
                  return 1;
               } else if (var0 == 3923) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  long var5 = Message.clockNow() - WorldMapLabelSize.field2243 - var11.age;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var10;
                  return 1;
               } else if (var0 == 3924) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if (var0 == 3925) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.unitPrice;
                  return 1;
               } else if (var0 == 3926) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var11 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.id;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-1783114355"
   )
   static final void updateItemPile(int var0, int var1) {
      NodeDeque var2 = Client.groundItems[class383.Client_plane][var0][var1];
      if (var2 == null) {
         ReflectionCheck.scene.removeGroundItemPile(class383.Client_plane, var0, var1);
      } else {
         long var3 = -99999999L;
         TileItem var5 = null;

         TileItem var6;
         for(var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
            ItemComposition var7 = NPCComposition.ItemDefinition_get(var6.id);
            long var8 = (long)var7.price;
            if (var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if (var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if (var5 == null) {
            ReflectionCheck.scene.removeGroundItemPile(class383.Client_plane, var0, var1);
         } else {
            var2.addLast(var5);
            TileItem var12 = null;
            TileItem var11 = null;

            for(var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
               if (var5.id != var6.id) {
                  if (var12 == null) {
                     var12 = var6;
                  }

                  if (var12.id != var6.id && var11 == null) {
                     var11 = var6;
                  }
               }
            }

            long var9 = GameEngine.calculateTag(var0, var1, 3, false, 0);
            ReflectionCheck.scene.newGroundItemPile(class383.Client_plane, var0, var1, SpotAnimationDefinition.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class383.Client_plane), var5, var9, var12, var11);
         }
      }
   }

   @ObfuscatedName("kh")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1198990155"
   )
   static void setTapToDrop(boolean var0) {
      Client.tapToDrop = var0;
   }
}
