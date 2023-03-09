import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("Messages")
public class Messages {
   @ObfuscatedName("aj")
   @Export("Messages_channels")
   static final Map Messages_channels = new HashMap();
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lrz;"
   )
   @Export("Messages_hashTable")
   static final IterableNodeHashTable Messages_hashTable = new IterableNodeHashTable(1024);
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lnh;"
   )
   @Export("Messages_queue")
   static final IterableDualNodeQueue Messages_queue = new IterableDualNodeQueue();
   @ObfuscatedName("ab")
   @Export("Messages_count")
   static int Messages_count = 0;
   @ObfuscatedName("gl")
   @Export("playerUUIDLength")
   static int playerUUIDLength;
   @ObfuscatedName("qp")
   @ObfuscatedSignature(
      descriptor = "Lrw;"
   )
   @Export("HitSplatDefinition_cached")
   static class462 HitSplatDefinition_cached;

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZI)I",
      garbageValue = "577265757"
   )
   static int method620(int var0, Script var1, boolean var2) {
      if (var0 == 3200) {
         Interpreter.Interpreter_intStackSize -= 3;
         Skills.queueSoundEffect(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
         return 1;
      } else if (var0 == 3201) {
         Language.playSong(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         return 1;
      } else if (var0 == 3202) {
         Interpreter.Interpreter_intStackSize -= 2;
         class19.playJingle(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
         return 1;
      } else {
         int var6;
         class88 var8;
         class87 var9;
         int var10;
         String var12;
         if (var0 != 3212 && var0 != 3213 && var0 != 3209 && var0 != 3181 && var0 != 3203 && var0 != 3205 && var0 != 3207) {
            boolean var15;
            if (var0 != 3214 && var0 != 3215 && var0 != 3210 && var0 != 3182 && var0 != 3204 && var0 != 3206 && var0 != 3208) {
               if (var0 == 3211) {
                  return 1;
               } else {
                  int var3;
                  int var4;
                  if (var0 == 3216) {
                     var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     var4 = 0;
                     class88 var13 = (class88)SpriteMask.findEnumerated(ParamComposition.method1000(), var3);
                     if (var13 != null) {
                        var4 = var13 != class88.field879 ? 1 : 0;
                     }

                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
                     return 1;
                  } else if (var0 == 3218) {
                     var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     var4 = 0;
                     class87 var5 = (class87)SpriteMask.findEnumerated(class122.method675(), var3);
                     if (var5 != null) {
                        var4 = var5 != class87.field866 ? 1 : 0;
                     }

                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
                     return 1;
                  } else if (var0 != 3217 && var0 != 3219) {
                     return 2;
                  } else {
                     var8 = class88.field879;
                     var9 = class87.field866;
                     var15 = true;
                     boolean var14 = true;
                     int var7;
                     if (var0 == 3217) {
                        var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        var8 = (class88)SpriteMask.findEnumerated(ParamComposition.method1000(), var7);
                        if (var8 == null) {
                           throw new RuntimeException(String.format("Unrecognized device option %d", var7));
                        }
                     }

                     if (var0 == 3219) {
                        var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        var9 = (class87)SpriteMask.findEnumerated(class122.method675(), var7);
                        if (var9 == null) {
                           throw new RuntimeException(String.format("Unrecognized game option %d", var7));
                        }
                     }

                     String var11;
                     byte var16;
                     if (var9 == class87.field866) {
                        switch(var8.field875) {
                        case 1:
                        case 2:
                        case 3:
                           var16 = 0;
                           var6 = 1;
                           break;
                        case 4:
                           var16 = 0;
                           var6 = Integer.MAX_VALUE;
                           break;
                        case 5:
                           var16 = 0;
                           var6 = 100;
                           break;
                        default:
                           var11 = String.format("Unkown device option: %s.", var8.toString());
                           throw new RuntimeException(var11);
                        }
                     } else {
                        switch(var9.field870) {
                        case 1:
                           var16 = 0;
                           var6 = 1;
                           break;
                        case 2:
                        case 3:
                        case 4:
                           var16 = 0;
                           var6 = 100;
                           break;
                        default:
                           var11 = String.format("Unkown game option: %s.", var9.toString());
                           throw new RuntimeException(var11);
                        }
                     }

                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var16;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6;
                     return 1;
                  }
               }
            } else {
               var8 = class88.field879;
               var9 = class87.field866;
               var15 = false;
               if (var0 == 3214) {
                  var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var8 = (class88)SpriteMask.findEnumerated(ParamComposition.method1000(), var6);
                  if (var8 == null) {
                     throw new RuntimeException(String.format("Unrecognized device option %d", var6));
                  }
               }

               if (var0 == 3215) {
                  var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var9 = (class87)SpriteMask.findEnumerated(class122.method675(), var6);
                  if (var9 == null) {
                     throw new RuntimeException(String.format("Unrecognized game option %d", var6));
                  }
               }

               if (var0 == 3210) {
                  var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var8 = (class88)SpriteMask.findEnumerated(ParamComposition.method1000(), var6);
                  if (var8 == null) {
                     var9 = (class87)SpriteMask.findEnumerated(class122.method675(), var6);
                     if (var9 == null) {
                        throw new RuntimeException(String.format("Unrecognized client option %d", var6));
                     }
                  }
               } else if (var0 == 3182) {
                  var8 = class88.field878;
               } else if (var0 == 3204) {
                  var9 = class87.field867;
               } else if (var0 == 3206) {
                  var9 = class87.field872;
               } else if (var0 == 3208) {
                  var9 = class87.field869;
               }

               if (var9 == class87.field866) {
                  switch(var8.field875) {
                  case 1:
                     var10 = WorldMapSectionType.clientPreferences.getIsUsernameHidden() ? 1 : 0;
                     break;
                  case 2:
                     var10 = WorldMapSectionType.clientPreferences.getTitleMusicDisabled() ? 1 : 0;
                     break;
                  case 3:
                     var10 = WorldMapSectionType.clientPreferences.method522() ? 1 : 0;
                     break;
                  case 4:
                     var10 = WorldMapSectionType.clientPreferences.method551();
                     break;
                  case 5:
                     var10 = NetCache.method1853();
                     break;
                  default:
                     var12 = String.format("Unkown device option: %s.", var8.toString());
                     throw new RuntimeException(var12);
                  }
               } else {
                  switch(var9.field870) {
                  case 1:
                     var10 = WorldMapSectionType.clientPreferences.getRoofsHidden() ? 1 : 0;
                     break;
                  case 2:
                     var6 = WorldMapSectionType.clientPreferences.getCurrentMusicVolume();
                     var10 = Math.round((float)(var6 * 100) / 255.0F);
                     break;
                  case 3:
                     var6 = WorldMapSectionType.clientPreferences.getCurrentSoundEffectsVolume();
                     var10 = Math.round((float)(var6 * 100) / 127.0F);
                     break;
                  case 4:
                     var6 = WorldMapSectionType.clientPreferences.getAreaSoundEffectsVolume();
                     var10 = Math.round((float)(var6 * 100) / 127.0F);
                     break;
                  default:
                     var12 = String.format("Unkown game option: %s.", var9.toString());
                     throw new RuntimeException(var12);
                  }
               }

               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var10;
               return 1;
            }
         } else {
            var8 = class88.field879;
            var9 = class87.field866;
            var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            if (var0 == 3212) {
               var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var8 = (class88)SpriteMask.findEnumerated(ParamComposition.method1000(), var6);
               if (var8 == null) {
                  throw new RuntimeException(String.format("Unrecognized device option %d", var6));
               }
            }

            if (var0 == 3213) {
               var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var9 = (class87)SpriteMask.findEnumerated(class122.method675(), var6);
               if (var9 == null) {
                  throw new RuntimeException(String.format("Unrecognized game option %d", var6));
               }
            }

            if (var0 == 3209) {
               var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var8 = (class88)SpriteMask.findEnumerated(ParamComposition.method1000(), var6);
               if (var8 == null) {
                  var9 = (class87)SpriteMask.findEnumerated(class122.method675(), var6);
                  if (var9 == null) {
                     throw new RuntimeException(String.format("Unrecognized client option %d", var6));
                  }
               }
            } else if (var0 == 3181) {
               var8 = class88.field878;
            } else if (var0 == 3203) {
               var9 = class87.field867;
            } else if (var0 == 3205) {
               var9 = class87.field872;
            } else if (var0 == 3207) {
               var9 = class87.field869;
            }

            if (var9 == class87.field866) {
               switch(var8.field875) {
               case 1:
                  WorldMapSectionType.clientPreferences.setIsUsernameHidden(var10 == 1);
                  break;
               case 2:
                  WorldMapSectionType.clientPreferences.getTitleMusicDisabled(var10 == 1);
                  break;
               case 3:
                  WorldMapSectionType.clientPreferences.method550(var10 == 1);
                  break;
               case 4:
                  if (var10 < 0) {
                     var10 = 0;
                  }

                  WorldMapSectionType.clientPreferences.method527(var10);
                  break;
               case 5:
                  Skeleton.method1188(var10);
                  break;
               default:
                  var12 = String.format("Unkown device option: %s.", var8.toString());
                  throw new RuntimeException(var12);
               }
            } else {
               switch(var9.field870) {
               case 1:
                  WorldMapSectionType.clientPreferences.setRoofsHidden(var10 == 1);
                  break;
               case 2:
                  var10 = Math.min(Math.max(var10, 0), 100);
                  var6 = Math.round((float)(var10 * 255) / 100.0F);
                  class70.method417(var6);
                  break;
               case 3:
                  var10 = Math.min(Math.max(var10, 0), 100);
                  var6 = Math.round((float)(var10 * 127) / 100.0F);
                  ApproximateRouteStrategy.method339(var6);
                  break;
               case 4:
                  var10 = Math.min(Math.max(var10, 0), 100);
                  var6 = Math.round((float)(var10 * 127) / 100.0F);
                  class12.method45(var6);
                  break;
               default:
                  var12 = String.format("Unkown game option: %s.", var9.toString());
                  throw new RuntimeException(var12);
               }
            }

            return 1;
         }
      }
   }
}
