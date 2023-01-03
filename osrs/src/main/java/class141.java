import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class141 extends class136 {
   @ObfuscatedName("bb")
   static String otp;
   @ObfuscatedName("h")
   int field1310;
   @ObfuscatedName("e")
   int field1309;
   @ObfuscatedName("v")
   int field1308;
   @ObfuscatedName("x")
   int field1307;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lem;"
   )
   final class139 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lem;)V"
   )
   class141(class139 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1101327225"
   )
   void vmethod3254(Buffer var1) {
      this.field1310 = var1.readInt();
      this.field1307 = var1.readInt();
      this.field1309 = var1.readUnsignedByte();
      this.field1308 = var1.readUnsignedByte();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   void vmethod3248(ClanSettings var1) {
      var1.method790(this.field1310, this.field1307, this.field1309, this.field1308);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZB)I",
      garbageValue = "108"
   )
   static int method755(int var0, Script var1, boolean var2) {
      if (var0 == 6500) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class29.loadWorlds() ? 1 : 0;
         return 1;
      } else {
         World var3;
         if (var0 == 6501) {
            var3 = PlayerComposition.worldListStart();
            if (var3 != null) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.id;
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.properties;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.activity;
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.location;
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.population;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.host;
            } else {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if (var0 == 6502) {
            var3 = UserComparator9.getNextWorldListWorld();
            if (var3 != null) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.id;
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.properties;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.activity;
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.location;
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.population;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.host;
            } else {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var7;
            if (var0 == 6506) {
               var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.World_count; ++var5) {
                  if (var7 == World.World_worlds[var5].id) {
                     var4 = World.World_worlds[var5];
                     break;
                  }
               }

               if (var4 != null) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4.id;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4.properties;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.activity;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4.location;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4.population;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.host;
               } else {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 6507) {
               class87.Interpreter_intStackSize -= 4;
               var7 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
               boolean var10 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1] == 1;
               var5 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
               boolean var6 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 3] == 1;
               class416.sortWorldList(var7, var10, var5, var6);
               return 1;
            } else if (var0 != 6511) {
               if (var0 == 6512) {
                  Client.followerOpsLowPriority = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  ParamComposition var9;
                  if (var0 == 6513) {
                     class87.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                     var9 = class149.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = class129.getNpcDefinition(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class129.getNpcDefinition(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6514) {
                     class87.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                     var9 = class149.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = VarpDefinition.getObjectDefinition(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = VarpDefinition.getObjectDefinition(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6515) {
                     class87.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                     var9 = class149.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = NPCComposition.ItemDefinition_get(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = NPCComposition.ItemDefinition_get(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6516) {
                     class87.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                     var9 = class149.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = UserComparator3.StructDefinition_getStructDefinition(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = UserComparator3.StructDefinition_getStructDefinition(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6518) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.onMobile ? 1 : 0;
                     return 1;
                  } else if (var0 == 6519) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.clientType;
                     return 1;
                  } else if (var0 == 6520) {
                     return 1;
                  } else if (var0 == 6521) {
                     return 1;
                  } else if (var0 == 6522) {
                     --Interpreter.Interpreter_stringStackSize;
                     --class87.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 6523) {
                     --Interpreter.Interpreter_stringStackSize;
                     --class87.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 6524) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                     return 1;
                  } else if (var0 == 6525) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 1;
                     return 1;
                  } else if (var0 == 6526) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 1;
                     return 1;
                  } else if (var0 == 6527) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.field543;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               if (var7 >= 0 && var7 < World.World_count) {
                  var4 = World.World_worlds[var7];
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4.id;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4.properties;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.activity;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4.location;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4.population;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.host;
               } else {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }
}
