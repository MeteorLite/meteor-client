import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("my")
public class class358 {
   @ObfuscatedName("h")
   public static final char[] cp1252AsciiExtension = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1844618131
   )
   static int field4347;
   @ObfuscatedName("f")
   static byte[][][] field4344;
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
   @ObfuscatedGetter(
      intValue = 1164204793
   )
   static int selectedSpellWidget;

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "85706073"
   )
   static int method6920(int var0, Script var1, boolean var2) {
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
         int var13;
         if (var0 == 3910) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            var13 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var13 == 0 ? 1 : 0;
            return 1;
         } else if (var0 == 3911) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            var13 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var13 == 2 ? 1 : 0;
            return 1;
         } else if (var0 == 3912) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            var13 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var13 == 5 ? 1 : 0;
            return 1;
         } else if (var0 == 3913) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            var13 = Client.grandExchangeOffers[var3].status();
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var13 == 1 ? 1 : 0;
            return 1;
         } else {
            boolean var12;
            if (var0 == 3914) {
               var12 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
               if (ItemContainer.grandExchangeEvents != null) {
                  ItemContainer.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_nameComparator, var12);
               }

               return 1;
            } else if (var0 == 3915) {
               var12 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
               if (ItemContainer.grandExchangeEvents != null) {
                  ItemContainer.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_priceComparator, var12);
               }

               return 1;
            } else if (var0 == 3916) {
               class87.Interpreter_intStackSize -= 2;
               var12 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize] == 1;
               boolean var11 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1] == 1;
               if (ItemContainer.grandExchangeEvents != null) {
                  Client.GrandExchangeEvents_worldComparator.filterWorlds = var11;
                  ItemContainer.grandExchangeEvents.sort(Client.GrandExchangeEvents_worldComparator, var12);
               }

               return 1;
            } else if (var0 == 3917) {
               var12 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
               if (ItemContainer.grandExchangeEvents != null) {
                  ItemContainer.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_ageComparator, var12);
               }

               return 1;
            } else if (var0 == 3918) {
               var12 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
               if (ItemContainer.grandExchangeEvents != null) {
                  ItemContainer.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_quantityComparator, var12);
               }

               return 1;
            } else if (var0 == 3919) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = ItemContainer.grandExchangeEvents == null ? 0 : ItemContainer.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var4;
               if (var0 == 3920) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var4 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4.world;
                  return 1;
               } else if (var0 == 3921) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var4 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.getOfferName();
                  return 1;
               } else if (var0 == 3922) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var4 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.getPreviousOfferName();
                  return 1;
               } else if (var0 == 3923) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var4 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  long var5 = Message.method1197() - WorldMapLabelSize.field2824 - var4.age;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var10;
                  return 1;
               } else if (var0 == 3924) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var4 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if (var0 == 3925) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var4 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4.grandExchangeOffer.unitPrice;
                  return 1;
               } else if (var0 == 3926) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var4 = (GrandExchangeEvent)ItemContainer.grandExchangeEvents.events.get(var3);
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4.grandExchangeOffer.id;
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
            long var11 = (long)var7.price;
            if (var7.isStackable == 1) {
               var11 *= (long)(var6.quantity + 1);
            }

            if (var11 > var3) {
               var3 = var11;
               var5 = var6;
            }
         }

         if (var5 == null) {
            ReflectionCheck.scene.removeGroundItemPile(class383.Client_plane, var0, var1);
         } else {
            var2.addLast(var5);
            TileItem var13 = null;
            TileItem var8 = null;

            for(var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
               if (var5.id != var6.id) {
                  if (var13 == null) {
                     var13 = var6;
                  }

                  if (var13.id != var6.id && var8 == null) {
                     var8 = var6;
                  }
               }
            }

            long var9 = GameEngine.calculateTag(var0, var1, 3, false, 0);
            ReflectionCheck.scene.newGroundItemPile(class383.Client_plane, var0, var1, SpotAnimationDefinition.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class383.Client_plane), var5, var9, var13, var8);
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
