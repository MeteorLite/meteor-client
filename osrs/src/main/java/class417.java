import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pv")
public abstract class class417 implements class261 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lqr;"
   )
   class456 field3791;

   class417(int var1) {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;II)V",
      garbageValue = "1487404426"
   )
   @Export("vmethod7769")
   abstract void vmethod7769(Buffer var1, int var2);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Lqy;B)V",
      garbageValue = "1"
   )
   public void method2163(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         class413 var3 = (class413)World.findEnumerated(GraphicsObject.method426(), var2);
         if (var3 != null) {
            switch(var3.field3783) {
            case 0:
               class326[] var5 = new class326[]{class326.field3401, class326.field3404, class326.field3402, class326.field3405};
               World.findEnumerated(var5, var1.readUnsignedByte());
               break;
            case 1:
            default:
               throw new IllegalStateException("Unrecognised VarTypeEncodingKey - " + var3);
            case 2:
               int var4 = var1.readUnsignedByte();
               this.field3791 = class9.method33(var4);
               if (this.field3791 != null) {
                  break;
               }

               throw new IllegalStateException("Unknown ScriptVarType ID in VarType.decode: " + var4);
            case 3:
               var1.readStringCp1252NullCircumfixed();
            }
         } else {
            this.vmethod7769(var1, var2);
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(S)Z",
      garbageValue = "-3806"
   )
   boolean method2165() {
      return this.field3791 != null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/Object;",
      garbageValue = "-84"
   )
   Object method2166() {
      if (this.field3791 == class456.field3970) {
         return 0;
      } else if (this.field3791 == class456.field3967) {
         return -1L;
      } else {
         return this.field3791 == class456.field3968 ? "" : null;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "-377158891"
   )
   static int method2167(int var0, Script var1, boolean var2) {
      int var3;
      int var5;
      int var7;
      Object var21;
      class460 var22;
      if (var0 != 7500 && var0 != 7508) {
         if (var0 != 7501) {
            int var4;
            int var6;
            if (var0 == 7502) {
               class87.Interpreter_intStackSize -= 3;
               var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
               var6 = class300.method1620(var4);
               var7 = DbTableType.method2315(var4);
               int var8 = class163.method864(var4);
               DbRowType var23 = HealthBarUpdate.getDbRowType(var3);
               DbTableType var24 = class146.getDbTableType(var6);
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
                     class456 var17 = class9.method33(var16);
                     if (var17 == class456.field3968) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     } else {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class18.method63(var16);
                     }
                  }

                  return 1;
               } else {
                  var15 = var14.length / var25.length;
                  if (var5 >= 0 && var5 < var15) {
                     for(var16 = var12; var16 < var13; ++var16) {
                        int var19 = var16 + var25.length * var5;
                        class456 var18 = class9.method33(var25[var16]);
                        if (var18 == class456.field3968) {
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = (String)var14[var19];
                        } else {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = (Integer)var14[var19];
                        }
                     }

                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               }
            } else if (var0 == 7503) {
               class87.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
               var5 = 0;
               var6 = class300.method1620(var4);
               var7 = DbTableType.method2315(var4);
               DbRowType var26 = HealthBarUpdate.getDbRowType(var3);
               DbTableType var9 = class146.getDbTableType(var6);
               int[] var10 = var9.types[var7];
               Object[] var11 = var26.getColumnType(var7);
               if (var11 == null && var9.defaultValues != null) {
                  var11 = var9.defaultValues[var7];
               }

               if (var11 != null) {
                  var5 = var11.length / var10.length;
               }

               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var5;
               return 1;
            } else if (var0 != 7504 && var0 != 7510) {
               if (var0 == 7505) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  DbRowType var28 = HealthBarUpdate.getDbRowType(var3);
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var28.tableId;
                  return 1;
               } else if (var0 == 7506) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var4 = -1;
                  if (PcmPlayer.field205 != null && var3 >= 0 && var3 < PcmPlayer.field205.size()) {
                     var4 = (Integer)PcmPlayer.field205.get(var3);
                  }

                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4;
                  return 1;
               } else if (var0 != 7507 && var0 != 7509) {
                  return 2;
               } else {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var21 = class130.method724(var3);
                  var5 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var22 = LoginScreenAnimation.method532(var5);
                  if (var22 == null) {
                     throw new RuntimeException();
                  } else if (class300.method1620(var5) != Client.field645) {
                     throw new RuntimeException();
                  } else if (PcmPlayer.field205 == null && PcmPlayer.field205.isEmpty()) {
                     throw new RuntimeException();
                  } else {
                     var7 = class163.method864(var5);
                     List var20 = var22.method2317(var21, var7);
                     PcmPlayer.field205 = new LinkedList(PcmPlayer.field205);
                     if (var20 != null) {
                        PcmPlayer.field205.retainAll(var20);
                     } else {
                        PcmPlayer.field205.clear();
                     }

                     Timer.field3652 = PcmPlayer.field205.iterator();
                     if (var0 == 7507) {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = PcmPlayer.field205.size();
                     }

                     return 1;
                  }
               }
            } else {
               --class87.Interpreter_intStackSize;
               var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
               class460 var27 = class412.method2150(var3);
               if (var27 == null) {
                  throw new RuntimeException();
               } else {
                  PcmPlayer.field205 = var27.method2317(0, 0);
                  var5 = 0;
                  if (PcmPlayer.field205 != null) {
                     Client.field645 = var3;
                     Timer.field3652 = PcmPlayer.field205.iterator();
                     var5 = PcmPlayer.field205.size();
                  }

                  if (var0 == 7504) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var5;
                  }

                  return 1;
               }
            }
         } else {
            if (Timer.field3652 != null && Timer.field3652.hasNext()) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = (Integer)Timer.field3652.next();
            } else {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
            }

            return 1;
         }
      } else {
         var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         var21 = class130.method724(var3);
         var5 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         var22 = LoginScreenAnimation.method532(var5);
         if (var22 == null) {
            throw new RuntimeException();
         } else {
            var7 = class163.method864(var5);
            PcmPlayer.field205 = var22.method2317(var21, var7);
            if (PcmPlayer.field205 != null) {
               Client.field645 = class300.method1620(var5);
               Timer.field3652 = PcmPlayer.field205.iterator();
               if (var0 == 7500) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = PcmPlayer.field205.size();
               }
            } else {
               Client.field645 = -1;
               Timer.field3652 = null;
               if (var0 == 7500) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               }
            }

            return 1;
         }
      }
   }
}
