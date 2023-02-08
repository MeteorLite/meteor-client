import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("na")
public class class378 {
    @ObfuscatedName("vf")
    static int foundItemIdCount;
   @ObfuscatedName("la")
   @ObfuscatedSignature(
      descriptor = "Lkz;"
   )
   static Widget field3629;
   @ObfuscatedName("f")
   int field3634;
   @ObfuscatedName("w")
   int field3630;
   @ObfuscatedName("v")
   int field3631;
   @ObfuscatedName("s")
   int field3633;

    @ObfuscatedName("toString")
    public String toString() {
      boolean var1 = true;
      int var2 = 10 - Integer.toString(this.field3634).length();
      int var3 = 10 - Integer.toString(this.field3631).length();
      int var4 = 10 - Integer.toString(this.field3630).length();
      String var5 = "          ".substring(10 - var2);
      String var6 = "          ".substring(10 - var3);
      String var7 = "          ".substring(10 - var4);
      return "    Size: " + this.field3634 + var5 + "Created: " + this.field3630 + var7 + "Total used: " + this.field3631 + var6 + "Max-In-Use: " + this.field3633;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "-1374612729"
   )
   static int method2017(int var0, Script var1, boolean var2) {
      if (var0 == 6500) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class290.loadWorlds() ? 1 : 0;
         return 1;
      } else {
         World var3;
         if (var0 == 6501) {
            var3 = class108.worldListStart();
            if (var3 != null) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.id;
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.properties;
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3.activity;
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.location;
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.population;
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3.host;
            } else {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if (var0 == 6502) {
            var3 = TileItem.getNextWorldListWorld();
            if (var3 != null) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.id;
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.properties;
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3.activity;
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.location;
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.population;
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3.host;
            } else {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var7;
            if (var0 == 6506) {
               var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.World_count; ++var5) {
                  if (var7 == class88.World_worlds[var5].id) {
                     var4 = class88.World_worlds[var5];
                     break;
                  }
               }

               if (var4 != null) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4.id;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4.properties;
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var4.activity;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4.location;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4.population;
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var4.host;
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            } else if (var0 == 6507) {
               class302.Interpreter_intStackSize -= 4;
               var7 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
               boolean var10 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1] == 1;
               var5 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
               boolean var6 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 3] == 1;
               SecureRandomCallable.sortWorldList(var7, var10, var5, var6);
               return 1;
            } else if (var0 != 6511) {
               if (var0 == 6512) {
                  Client.followerOpsLowPriority = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  ParamComposition var9;
                  if (var0 == 6513) {
                     class302.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                     var9 = ClanChannelMember.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = class137.getNpcDefinition(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class137.getNpcDefinition(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6514) {
                     class302.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                     var9 = ClanChannelMember.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = class463.getObjectDefinition(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class463.getObjectDefinition(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6515) {
                     class302.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                     var9 = ClanChannelMember.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = TileItem.ItemDefinition_get(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = TileItem.ItemDefinition_get(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6516) {
                     class302.Interpreter_intStackSize -= 2;
                     var7 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                     var8 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                     var9 = ClanChannelMember.getParamDefinition(var8);
                     if (var9.isString()) {
                        Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = Actor.StructDefinition_getStructDefinition(var7).getStringParam(var8, var9.defaultStr);
                     } else {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Actor.StructDefinition_getStructDefinition(var7).getIntParam(var8, var9.defaultInt);
                     }

                     return 1;
                  } else if (var0 == 6518) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.onMobile ? 1 : 0;
                     return 1;
                  } else if (var0 == 6519) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.clientType;
                     return 1;
                  } else if (var0 == 6520) {
                     return 1;
                  } else if (var0 == 6521) {
                     return 1;
                  } else if (var0 == 6522) {
                     --class20.Interpreter_stringStackSize;
                     --class302.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 6523) {
                     --class20.Interpreter_stringStackSize;
                     --class302.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 6524) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
                     return 1;
                  } else if (var0 == 6525) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
                     return 1;
                  } else if (var0 == 6526) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
                     return 1;
                  } else if (var0 == 6527) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.field372;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               if (var7 >= 0 && var7 < World.World_count) {
                  var4 = class88.World_worlds[var7];
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4.id;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4.properties;
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var4.activity;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4.location;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4.population;
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var4.host;
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }
}
