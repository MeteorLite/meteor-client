import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class159 extends class140 {
   @ObfuscatedName("aj")
   int field1380;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfo;"
   )
   final class143 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfo;)V"
   )
   class159(class143 var1) {
      this.this$0 = var1;
      this.field1380 = -1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "-1979280996"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      this.field1380 = var1.readUnsignedShort();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lfi;B)V",
      garbageValue = "29"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.method789(this.field1380);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "872602777"
   )
   @Export("encodeStringCp1252")
   public static int encodeStringCp1252(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if ((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if (var7 == 8364) {
               var3[var6 + var4] = -128;
            } else if (var7 == 8218) {
               var3[var6 + var4] = -126;
            } else if (var7 == 402) {
               var3[var6 + var4] = -125;
            } else if (var7 == 8222) {
               var3[var6 + var4] = -124;
            } else if (var7 == 8230) {
               var3[var6 + var4] = -123;
            } else if (var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if (var7 == 8225) {
               var3[var6 + var4] = -121;
            } else if (var7 == 710) {
               var3[var6 + var4] = -120;
            } else if (var7 == 8240) {
               var3[var6 + var4] = -119;
            } else if (var7 == 352) {
               var3[var6 + var4] = -118;
            } else if (var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if (var7 == 338) {
               var3[var6 + var4] = -116;
            } else if (var7 == 381) {
               var3[var6 + var4] = -114;
            } else if (var7 == 8216) {
               var3[var6 + var4] = -111;
            } else if (var7 == 8217) {
               var3[var6 + var4] = -110;
            } else if (var7 == 8220) {
               var3[var6 + var4] = -109;
            } else if (var7 == 8221) {
               var3[var6 + var4] = -108;
            } else if (var7 == 8226) {
               var3[var6 + var4] = -107;
            } else if (var7 == 8211) {
               var3[var6 + var4] = -106;
            } else if (var7 == 8212) {
               var3[var6 + var4] = -105;
            } else if (var7 == 732) {
               var3[var6 + var4] = -104;
            } else if (var7 == 8482) {
               var3[var6 + var4] = -103;
            } else if (var7 == 353) {
               var3[var6 + var4] = -102;
            } else if (var7 == 8250) {
               var3[var6 + var4] = -101;
            } else if (var7 == 339) {
               var3[var6 + var4] = -100;
            } else if (var7 == 382) {
               var3[var6 + var4] = -98;
            } else if (var7 == 376) {
               var3[var6 + var4] = -97;
            } else {
               var3[var6 + var4] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "1"
   )
   static int method839(int var0, Script var1, boolean var2) {
      int var3;
      int var5;
      int var7;
      Object var21;
      class471 var22;
      if (var0 != 7500 && var0 != 7508) {
         if (var0 != 7501) {
            int var4;
            int var6;
            if (var0 == 7502) {
               Interpreter.Interpreter_intStackSize -= 3;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
               var6 = class36.method175(var4);
               var7 = GameObject.method1307(var4);
               int var8 = Clock.method920(var4);
               DbRowType var23 = SecureRandomCallable.getDbRowType(var3);
               DbTableType var24 = WorldMapSection0.getDbTableType(var6);
               int[] var25 = var24.types[var7];
               int var12 = 0;
               int var13 = var25.length;
               if (var8 >= 0) {
                  if (var8 >= var13) {
                     throw new RuntimeException("Tuple index out-of-bounds. Requested: " + var8 + ", Max: " + var13);
                  }

                  var12 = var8;
                  var13 = var8 + 1;
               }

               Object[] var14 = var23.getColumnType(var7);
               if (var14 == null && var24.defaultValues != null) {
                  var14 = var24.defaultValues[var7];
               }

               int var15;
               int var16;
               if (var14 == null) {
                  for(var15 = var12; var15 < var13; ++var15) {
                     var16 = var25[var15];
                     class467 var17 = class458.method2331(var16);
                     if (var17 == class467.field3949) {
                        Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ItemComposition.method1053(var16);
                     }
                  }

                  return 1;
               } else {
                  var15 = var14.length / var25.length;
                  if (var5 >= 0 && var5 < var15) {
                     for(var16 = var12; var16 < var13; ++var16) {
                        int var19 = var16 + var25.length * var5;
                        class467 var18 = class458.method2331(var25[var16]);
                        if (var18 == class467.field3949) {
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = (String)var14[var19];
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (Integer)var14[var19];
                        }
                     }

                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               }
            } else if (var0 == 7503) {
               Interpreter.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var5 = 0;
               var6 = class36.method175(var4);
               var7 = GameObject.method1307(var4);
               DbRowType var26 = SecureRandomCallable.getDbRowType(var3);
               DbTableType var9 = WorldMapSection0.getDbTableType(var6);
               int[] var10 = var9.types[var7];
               Object[] var11 = var26.getColumnType(var7);
               if (var11 == null && var9.defaultValues != null) {
                  var11 = var9.defaultValues[var7];
               }

               if (var11 != null) {
                  var5 = var11.length / var10.length;
               }

               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5;
               return 1;
            } else if (var0 != 7504 && var0 != 7510) {
               if (var0 == 7505) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  DbRowType var28 = SecureRandomCallable.getDbRowType(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var28.tableId;
                  return 1;
               } else if (var0 == 7506) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var4 = -1;
                  if (class258.field2371 != null && var3 >= 0 && var3 < class258.field2371.size()) {
                     var4 = (Integer)class258.field2371.get(var3);
                  }

                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
                  return 1;
               } else if (var0 != 7507 && var0 != 7509) {
                  return 2;
               } else {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var21 = class135.method734(var3);
                  var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var22 = class126.method696(var5);
                  if (var22 == null) {
                     throw new RuntimeException();
                  } else if (class36.method175(var5) != Client.field637) {
                     throw new RuntimeException();
                  } else if (class258.field2371 == null && class258.field2371.isEmpty()) {
                     throw new RuntimeException();
                  } else {
                     var7 = Clock.method920(var5);
                     List var20 = var22.method2376(var21, var7);
                     class258.field2371 = new LinkedList(class258.field2371);
                     if (var20 != null) {
                        class258.field2371.retainAll(var20);
                     } else {
                        class258.field2371.clear();
                     }

                     ScriptFrame.field339 = class258.field2371.iterator();
                     if (var0 == 7507) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class258.field2371.size();
                     }

                     return 1;
                  }
               }
            } else {
               --Interpreter.Interpreter_intStackSize;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               class471 var27 = class70.method419(var3);
               if (var27 == null) {
                  throw new RuntimeException();
               } else {
                  class258.field2371 = var27.method2376(0, 0);
                  var5 = 0;
                  if (class258.field2371 != null) {
                     Client.field637 = var3;
                     ScriptFrame.field339 = class258.field2371.iterator();
                     var5 = class258.field2371.size();
                  }

                  if (var0 == 7504) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5;
                  }

                  return 1;
               }
            }
         } else {
            if (ScriptFrame.field339 != null && ScriptFrame.field339.hasNext()) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (Integer)ScriptFrame.field339.next();
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
            }

            return 1;
         }
      } else {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         var21 = class135.method734(var3);
         var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         var22 = class126.method696(var5);
         if (var22 == null) {
            throw new RuntimeException();
         } else {
            var7 = Clock.method920(var5);
            class258.field2371 = var22.method2376(var21, var7);
            if (class258.field2371 != null) {
               Client.field637 = class36.method175(var5);
               ScriptFrame.field339 = class258.field2371.iterator();
               if (var0 == 7500) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class258.field2371.size();
               }
            } else {
               Client.field637 = -1;
               ScriptFrame.field339 = null;
               if (var0 == 7500) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               }
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("my")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-284669755"
   )
   @Export("changeGameOptions")
   static final void changeGameOptions(int var0) {
      GrandExchangeOfferNameComparator.process();
      WorldMapSection2.method1329();
      int var1 = GameEngine.VarpDefinition_get(var0).type;
      if (var1 != 0) {
         int var2 = Varps.Varps_main[var0];
         if (var1 == 1) {
            if (var2 == 1) {
               class7.method21(0.9D);
            }

            if (var2 == 2) {
               class7.method21(0.8D);
            }

            if (var2 == 3) {
               class7.method21(0.7D);
            }

            if (var2 == 4) {
               Rasterizer3D.Rasterizer3D_setBrightness(0.6D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.6D);
               TaskHandler.method887();
               WorldMapSectionType.clientPreferences.setBrightness(0.6D);
            }
         }

         if (var1 == 3) {
            if (var2 == 0) {
               class70.method417(255);
            }

            if (var2 == 1) {
               class70.method417(192);
            }

            if (var2 == 2) {
               class70.method417(128);
            }

            if (var2 == 3) {
               class70.method417(64);
            }

            if (var2 == 4) {
               class70.method417(0);
            }
         }

         if (var1 == 4) {
            if (var2 == 0) {
               ApproximateRouteStrategy.method339(127);
            }

            if (var2 == 1) {
               ApproximateRouteStrategy.method339(96);
            }

            if (var2 == 2) {
               ApproximateRouteStrategy.method339(64);
            }

            if (var2 == 3) {
               ApproximateRouteStrategy.method339(32);
            }

            if (var2 == 4) {
               ApproximateRouteStrategy.method339(0);
            }
         }

         if (var1 == 5) {
            Client.leftClickOpensMenu = var2 == 1;
         }

         if (var1 == 6) {
            Client.chatEffects = var2;
         }

         if (var1 == 9) {
            ;
         }

         if (var1 == 10) {
            if (var2 == 0) {
               class12.method45(127);
            }

            if (var2 == 1) {
               class12.method45(96);
            }

            if (var2 == 2) {
               class12.method45(64);
            }

            if (var2 == 3) {
               class12.method45(32);
            }

            if (var2 == 4) {
               class12.method45(0);
            }
         }

         if (var1 == 17) {
            Client.followerIndex = var2 & '\uffff';
         }

         AttackOption[] var3;
         if (var1 == 18) {
            var3 = new AttackOption[]{AttackOption.field1071, AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.field1069};
            Client.playerAttackOption = (AttackOption)SpriteMask.findEnumerated(var3, var2);
            if (Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if (var1 == 19) {
            if (var2 == -1) {
               Client.combatTargetPlayerIndex = -1;
            } else {
               Client.combatTargetPlayerIndex = var2 & 2047;
            }
         }

         if (var1 == 22) {
            var3 = new AttackOption[]{AttackOption.field1071, AttackOption.AttackOption_hidden, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.field1069};
            Client.npcAttackOption = (AttackOption)SpriteMask.findEnumerated(var3, var2);
            if (Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
