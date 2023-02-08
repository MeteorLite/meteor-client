import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("r")
   public static short[] field1866;
   @ObfuscatedName("f")
   int z;
   @ObfuscatedName("w")
   int x;
   @ObfuscatedName("v")
   int y;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
           descriptor = "Lhd;"
   )
   Renderable first;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
           descriptor = "Lhd;"
   )
   Renderable second;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
           descriptor = "Lhd;"
   )
   Renderable third;
   @ObfuscatedName("i")
   long tag;
   @ObfuscatedName("n")
   int height;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "1806736275"
   )
   public static boolean method1115(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
           descriptor = "(Lcd;III)V",
           garbageValue = "2122204306"
   )
   static void runScript(ScriptEvent var0, int var1, int var2) {
      Object[] var3 = var0.args;
      Script var4;
      int var20;
      if (class316.isWorldMapEvent(var0.type)) {
         class20.worldMapEvent = (WorldMapEvent)var3[0];
         WorldMapElement var5 = class4.WorldMapElement_get(class20.worldMapEvent.mapElement);
         var4 = class145.getWorldMapScript(var0.type, var5.objectId, var5.category);
      } else {
         var20 = (Integer)var3[0];
         var4 = class70.getScript(var20);
      }

      if (var4 != null) {
         class302.Interpreter_intStackSize = 0;
         class20.Interpreter_stringStackSize = 0;
         var20 = -1;
         int[] var6 = var4.opcodes;
         int[] var7 = var4.intOperands;
         byte var8 = -1;
         Interpreter.Interpreter_frameDepth = 0;
         Interpreter.field705 = false;
         boolean var9 = false;
         int var10 = 0;
         boolean var30 = false;

         label960: {
            label961: {
               try {
                  int var13;
                  try {
                     var30 = true;
                     Interpreter.Interpreter_intLocals = new int[var4.localIntCount];
                     int var11 = 0;
                     SecureRandomFuture.Interpreter_stringLocals = new String[var4.localStringCount];
                     int var12 = 0;

                     int var14;
                     String var21;
                     for(var13 = 1; var13 < var3.length; ++var13) {
                        if (var3[var13] instanceof Integer) {
                           var14 = (Integer)var3[var13];
                           if (var14 == -2147483647) {
                              var14 = var0.mouseX;
                           }

                           if (var14 == -2147483646) {
                              var14 = var0.mouseY;
                           }

                           if (var14 == -2147483645) {
                              var14 = var0.widget != null ? var0.widget.id * -1493443793 * -62043185 : -1;
                           }

                           if (var14 == -2147483644) {
                              var14 = var0.opIndex;
                           }

                           if (var14 == -2147483643) {
                              var14 = var0.widget != null ? var0.widget.childIndex * 1171460333 * -1779839771 : -1;
                           }

                           if (var14 == -2147483642) {
                              var14 = var0.dragTarget != null ? var0.dragTarget.id * -1493443793 * -62043185 : -1;
                           }

                           if (var14 == -2147483641) {
                              var14 = var0.dragTarget != null ? var0.dragTarget.childIndex * 1171460333 * -1779839771 : -1;
                           }

                           if (var14 == -2147483640) {
                              var14 = var0.keyTyped;
                           }

                           if (var14 == -2147483639) {
                              var14 = var0.keyPressed;
                           }

                           Interpreter.Interpreter_intLocals[var11++] = var14;
                        } else if (var3[var13] instanceof String) {
                           var21 = (String)var3[var13];
                           if (var21.equals("event_opbase")) {
                              var21 = var0.targetName;
                           }

                           SecureRandomFuture.Interpreter_stringLocals[var12++] = var21;
                        }
                     }

                     Interpreter.field712 = var0.field866;

                     label934:
                     while(true) {
                        ++var10;
                        if (var10 > var1) {
                           throw new RuntimeException();
                        }

                        ++var20;
                        int var33 = var6[var20];
                        if (var33 >= 100) {
                           boolean var35;
                           if (var4.intOperands[var20] == 1) {
                              var35 = true;
                           } else {
                              var35 = false;
                           }

                           var14 = class33.method132(var33, var4, var35);
                           switch(var14) {
                           case 0:
                              var30 = false;
                              break label961;
                           case 1:
                           default:
                              break;
                           case 2:
                              //throw new IllegalStateException();
                           }
                        } else if (var33 == 0) {
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7[var20];
                        } else if (var33 == 1) {
                           var13 = var7[var20];
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Varps.Varps_main[var13];
                        } else if (var33 == 2) {
                           var13 = var7[var20];
                           Varps.Varps_main[var13] = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                           ReflectionCheck.changeGameOptions(var13);
                        } else if (var33 == 3) {
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var4.stringOperands[var20];
                        } else if (var33 == 6) {
                           var20 += var7[var20];
                        } else if (var33 == 7) {
                           class302.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 8) {
                           class302.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 9) {
                           class302.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 10) {
                           class302.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 21) {
                           if (Interpreter.Interpreter_frameDepth == 0) {
                              var30 = false;
                              break label960;
                           }

                           ScriptFrame var40 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
                           var4 = var40.script;
                           var6 = var4.opcodes;
                           var7 = var4.intOperands;
                           var20 = var40.pc;
                           Interpreter.Interpreter_intLocals = var40.intLocals;
                           SecureRandomFuture.Interpreter_stringLocals = var40.stringLocals;
                        } else if (var33 == 25) {
                           var13 = var7[var20];
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = SecureRandomFuture.getVarbit(var13);
                        } else if (var33 == 27) {
                           var13 = var7[var20];
                           WorldMapEvent.method1503(var13, Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
                        } else if (var33 == 31) {
                           class302.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 32) {
                           class302.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 33) {
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Interpreter.Interpreter_intLocals[var7[var20]];
                        } else if (var33 == 34) {
                           Interpreter.Interpreter_intLocals[var7[var20]] = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                        } else if (var33 == 35) {
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = SecureRandomFuture.Interpreter_stringLocals[var7[var20]];
                        } else if (var33 == 36) {
                           SecureRandomFuture.Interpreter_stringLocals[var7[var20]] = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                        } else if (var33 == 37) {
                           var13 = var7[var20];
                           class20.Interpreter_stringStackSize -= var13;
                           var21 = class312.method1765(Interpreter.Interpreter_stringStack, class20.Interpreter_stringStackSize, var13);
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var21;
                        } else if (var33 == 38) {
                           --class302.Interpreter_intStackSize;
                        } else if (var33 == 39) {
                           --class20.Interpreter_stringStackSize;
                        } else {
                           int var17;
                           if (var33 != 40) {
                              if (var33 == 42) {
                                 Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class9.varcs.getInt(var7[var20]);
                              } else if (var33 == 43) {
                                 class9.varcs.setInt(var7[var20], Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
                              } else if (var33 == 44) {
                                 var13 = var7[var20] >> 16;
                                 var14 = var7[var20] & '\uffff';
                                 int var24 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                                 if (var24 < 0 || var24 > 5000) {
                                    throw new RuntimeException();
                                 }

                                 Interpreter.Interpreter_arrayLengths[var13] = var24;
                                 byte var25 = -1;
                                 if (var14 == 105) {
                                    var25 = 0;
                                 }

                                 for(var17 = 0; var17 < var24; ++var17) {
                                    Interpreter.Interpreter_arrays[var13][var17] = var25;
                                 }
                              } else if (var33 == 45) {
                                 var13 = var7[var20];
                                 var14 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                                 if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var13]) {
                                    throw new RuntimeException();
                                 }

                                 Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var13][var14];
                              } else if (var33 == 46) {
                                 var13 = var7[var20];
                                 class302.Interpreter_intStackSize -= 2;
                                 var14 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                                 if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var13]) {
                                    throw new RuntimeException();
                                 }

                                 Interpreter.Interpreter_arrays[var13][var14] = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                              } else {
                                 String var22;
                                 if (var33 == 47) {
                                    var22 = class9.varcs.getStringOld(var7[var20]);
                                    if (var22 == null) {
                                       var22 = "null";
                                    }

                                    Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var22;
                                 } else if (var33 == 48) {
                                    class9.varcs.setStringOld(var7[var20], Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize]);
                                 } else if (var33 == 49) {
                                    var22 = class9.varcs.getString(var7[var20]);
                                    Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var22;
                                 } else if (var33 == 50) {
                                    class9.varcs.setString(var7[var20], Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize]);
                                 } else if (var33 == 60) {
                                    IterableNodeHashTable var38 = var4.switches[var7[var20]];
                                    IntegerNode var37 = (IntegerNode)var38.get((long)Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
                                    if (var37 != null) {
                                       var20 += var37.integer;
                                    }
                                 } else {
                                    Integer var39;
                                    if (var33 == 74) {
                                       var39 = WorldMapArea.field2264.getTitleGroupValue(var7[var20]);
                                       if (var39 == null) {
                                          Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
                                       } else {
                                          Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var39;
                                       }
                                    } else {
                                       if (var33 != 76) {
                                          throw new IllegalStateException();
                                       }

                                       var39 = class388.field3667.method2194(var7[var20]);
                                       if (var39 == null) {
                                          Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
                                       } else {
                                          Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var39;
                                       }
                                    }
                                 }
                              }
                           } else {
                              var13 = var7[var20];
                              Script var36 = class70.getScript(var13);
                              int[] var15 = new int[var36.localIntCount];
                              String[] var16 = new String[var36.localStringCount];

                              for(var17 = 0; var17 < var36.intArgumentCount; ++var17) {
                                 var15[var17] = Interpreter.Interpreter_intStack[var17 + (class302.Interpreter_intStackSize - var36.intArgumentCount)];
                              }

                              for(var17 = 0; var17 < var36.stringArgumentCount; ++var17) {
                                 var16[var17] = Interpreter.Interpreter_stringStack[var17 + (class20.Interpreter_stringStackSize - var36.stringArgumentCount)];
                              }

                              class302.Interpreter_intStackSize -= var36.intArgumentCount;
                              class20.Interpreter_stringStackSize -= var36.stringArgumentCount;
                              ScriptFrame var23 = new ScriptFrame();
                              var23.script = var4;
                              var23.pc = var20;
                              var23.intLocals = Interpreter.Interpreter_intLocals;
                              var23.stringLocals = SecureRandomFuture.Interpreter_stringLocals;
                              Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var23;
                              var4 = var36;
                              var6 = var36.opcodes;
                              var7 = var36.intOperands;
                              var20 = -1;
                              Interpreter.Interpreter_intLocals = var15;
                              SecureRandomFuture.Interpreter_stringLocals = var16;
                           }
                        }
                     }
                  } catch (Exception var31) {
                     var9 = true;
                     StringBuilder var27 = new StringBuilder(30);
                     var27.append("").append(var4.key).append(" ");
                     var13 = Interpreter.Interpreter_frameDepth - 1;

                     while(true) {
                        if (var13 < 0) {
                           var27.append("").append(var8);
                           class121.RunException_sendStackTrace(var27.toString(), var31);
                           var30 = false;
                           break;
                        }

                        var27.append("").append(Interpreter.Interpreter_frames[var13].script.key).append(" ");
                        --var13;
                     }
                  }
               } finally {
                  if (var30) {
                     while(Interpreter.field714.size() > 0) {
                        class97 var19 = (class97)Interpreter.field714.remove(0);
                        class16.widgetDefaultMenuAction(var19.method584(), var19.method581(), var19.method582(), var19.method583(), "");
                     }

                     if (Interpreter.field705) {
                        Interpreter.field705 = false;
                        SoundCache.method229();
                     }

                     if (!var9 && var2 > 0 && var10 >= var2) {
                        class121.RunException_sendStackTrace("Warning: Script " + var4.field807 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
                     }

                  }
               }

               while(Interpreter.field714.size() > 0) {
                  class97 var26 = (class97)Interpreter.field714.remove(0);
                  class16.widgetDefaultMenuAction(var26.method584(), var26.method581(), var26.method582(), var26.method583(), "");
               }

               if (Interpreter.field705) {
                  Interpreter.field705 = false;
                  SoundCache.method229();
               }

               if (!var9 && var2 > 0 && var10 >= var2) {
                  class121.RunException_sendStackTrace("Warning: Script " + var4.field807 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
               }

               return;
            }

            while(Interpreter.field714.size() > 0) {
               class97 var34 = (class97)Interpreter.field714.remove(0);
               class16.widgetDefaultMenuAction(var34.method584(), var34.method581(), var34.method582(), var34.method583(), "");
            }

            if (Interpreter.field705) {
               Interpreter.field705 = false;
               SoundCache.method229();
            }

            if (!var9 && var2 > 0 && var10 >= var2) {
               class121.RunException_sendStackTrace("Warning: Script " + var4.field807 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
            }

            return;
         }

         while(Interpreter.field714.size() > 0) {
            class97 var41 = (class97)Interpreter.field714.remove(0);
            class16.widgetDefaultMenuAction(var41.method584(), var41.method581(), var41.method582(), var41.method583(), "");
         }

         if (Interpreter.field705) {
            Interpreter.field705 = false;
            SoundCache.method229();
         }

         if (!var9 && var2 > 0 && var10 >= var2) {
            class121.RunException_sendStackTrace("Warning: Script " + var4.field807 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
           descriptor = "(IIIZII)J",
           garbageValue = "-1955908833"
   )
   public static long calculateTag(int var0, int var1, int var2, boolean var3, int var4) {
      long var5 = (long)((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long)var4 & 4294967295L) << 17;
      if (var3) {
         var5 |= 65536L;
      }

      return var5;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "-18"
   )
   static int method1114(int var0) {
      return (int)Math.pow(2.0D, (double)(7.0F + (float)var0 / 256.0F));
   }
}
