import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class14 {
   @ObfuscatedName("aj")
   final int field41;
   @ObfuscatedName("al")
   final String field40;
   @ObfuscatedName("ac")
   final ThreadFactory field43;
   @ObfuscatedName("ab")
   final ThreadPoolExecutor field42;

   public class14(String var1, int var2, int var3) {
      this.field40 = var1;
      this.field41 = var2;
      this.field43 = new class16(this);
      this.field42 = this.method51(var3);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(IB)Ljava/util/concurrent/ThreadPoolExecutor;",
      garbageValue = "-5"
   )
   final ThreadPoolExecutor method51(int var1) {
      return new ThreadPoolExecutor(var1, var1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(this.field41), this.field43);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lak;S)Lag;",
      garbageValue = "15032"
   )
   public class18 method50(class10 var1) {
      if (this.field42.getQueue().remainingCapacity() <= 0) {
         System.err.println("REST thread pool queue is empty\r\nThread pool size " + this.field42.getCorePoolSize() + " Queue capacity " + this.field41);
         return new class18("Queue full");
      } else {
         class18 var2 = new class18(this.field42.submit(new class19(this, var1)));
         return var2;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "40"
   )
   public final void method55() {
      try {
         this.field42.shutdown();
      } catch (Exception var2) {
         System.err.println("Error shutting down RestRequestService\r\n" + var2);
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Ldx;III)V",
      garbageValue = "-1914250793"
   )
   @Export("runScript")
   static void runScript(ScriptEvent var0, int var1, int var2) {
      Object[] var3 = var0.args;
      Script var4;
      int var20;
      if (Skills.isWorldMapEvent(var0.type)) {
         InvDefinition.worldMapEvent = (WorldMapEvent)var3[0];
         WorldMapElement var5 = class123.WorldMapElement_get(InvDefinition.worldMapEvent.mapElement);
         var4 = GrandExchangeOfferNameComparator.getWorldMapScript(var0.type, var5.objectId, var5.category);
      } else {
         var20 = (Integer)var3[0];
         var4 = SecureRandomCallable.getScript(var20);
      }

      if (var4 != null) {
         Interpreter.Interpreter_intStackSize = 0;
         HealthBar.Interpreter_stringStackSize = 0;
         var20 = -1;
         int[] var6 = var4.opcodes;
         int[] var7 = var4.intOperands;
         byte var8 = -1;
         Interpreter.Interpreter_frameDepth = 0;
         Interpreter.field691 = false;
         boolean var9 = false;
         int var10 = 0;
         boolean var30 = false;

         label953: {
            label954: {
               try {
                  int var13;
                  try {
                     var30 = true;
                     Interpreter.Interpreter_intLocals = new int[var4.localIntCount];
                     int var11 = 0;
                     Interpreter.Interpreter_stringLocals = new String[var4.localStringCount];
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
                              var14 = var0.widget != null ? var0.widget.id * -672060695 * -1052750503 : -1;
                           }

                           if (var14 == -2147483644) {
                              var14 = var0.opIndex;
                           }

                           if (var14 == -2147483643) {
                              var14 = var0.widget != null ? var0.widget.childIndex * 1467332537 * 79765129 : -1;
                           }

                           if (var14 == -2147483642) {
                              var14 = var0.dragTarget != null ? var0.dragTarget.id * -672060695 * -1052750503 : -1;
                           }

                           if (var14 == -2147483641) {
                              var14 = var0.dragTarget != null ? var0.dragTarget.childIndex * 1467332537 * 79765129 : -1;
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

                           Interpreter.Interpreter_stringLocals[var12++] = var21;
                        }
                     }

                     Interpreter.field694 = var0.field853;

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

                           var14 = class7.method14(var33, var4, var35);
                           switch(var14) {
                           case 0:
                              var30 = false;
                              break label953;
                           case 1:
                           default:
                              break;
                           case 2:
                              //throw new IllegalStateException();
                           }
                        } else if (var33 == 0) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7[var20];
                        } else if (var33 == 1) {
                           var13 = var7[var20];
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Varps.Varps_main[var13];
                        } else if (var33 == 2) {
                           var13 = var7[var20];
                           Varps.Varps_main[var13] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                           class159.changeGameOptions(var13);
                        } else if (var33 == 3) {
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var4.stringOperands[var20];
                        } else if (var33 == 6) {
                           var20 += var7[var20];
                        } else if (var33 == 7) {
                           Interpreter.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 8) {
                           Interpreter.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 9) {
                           Interpreter.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 10) {
                           Interpreter.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 21) {
                           if (Interpreter.Interpreter_frameDepth == 0) {
                              var30 = false;
                              break;
                           }

                           ScriptFrame var40 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
                           var4 = var40.script;
                           var6 = var4.opcodes;
                           var7 = var4.intOperands;
                           var20 = var40.pc;
                           Interpreter.Interpreter_intLocals = var40.intLocals;
                           Interpreter.Interpreter_stringLocals = var40.stringLocals;
                        } else if (var33 == 25) {
                           var13 = var7[var20];
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class17.getVarbit(var13);
                        } else if (var33 == 27) {
                           var13 = var7[var20];
                           MouseRecorder.method471(var13, Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                        } else if (var33 == 31) {
                           Interpreter.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 32) {
                           Interpreter.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 33) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.Interpreter_intLocals[var7[var20]];
                        } else if (var33 == 34) {
                           Interpreter.Interpreter_intLocals[var7[var20]] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        } else if (var33 == 35) {
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = Interpreter.Interpreter_stringLocals[var7[var20]];
                        } else if (var33 == 36) {
                           Interpreter.Interpreter_stringLocals[var7[var20]] = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                        } else if (var33 == 37) {
                           var13 = var7[var20];
                           HealthBar.Interpreter_stringStackSize -= var13;
                           var21 = class364.method1937(Interpreter.Interpreter_stringStack, HealthBar.Interpreter_stringStackSize, var13);
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var21;
                        } else if (var33 == 38) {
                           --Interpreter.Interpreter_intStackSize;
                        } else if (var33 == 39) {
                           --HealthBar.Interpreter_stringStackSize;
                        } else {
                           int var17;
                           if (var33 != 40) {
                              if (var33 == 42) {
                                 Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class248.varcs.getInt(var7[var20]);
                              } else if (var33 == 43) {
                                 class248.varcs.setInt(var7[var20], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                              } else if (var33 == 44) {
                                 var13 = var7[var20] >> 16;
                                 var14 = var7[var20] & '\uffff';
                                 int var24 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
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
                                 var14 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                 if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var13]) {
                                    throw new RuntimeException();
                                 }

                                 Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var13][var14];
                              } else if (var33 == 46) {
                                 var13 = var7[var20];
                                 Interpreter.Interpreter_intStackSize -= 2;
                                 var14 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                                 if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var13]) {
                                    throw new RuntimeException();
                                 }

                                 Interpreter.Interpreter_arrays[var13][var14] = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                              } else {
                                 String var22;
                                 if (var33 == 47) {
                                    var22 = class248.varcs.getStringOld(var7[var20]);
                                    if (var22 == null) {
                                       var22 = "null";
                                    }

                                    Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var22;
                                 } else if (var33 == 48) {
                                    class248.varcs.setStringOld(var7[var20], Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize]);
                                 } else if (var33 == 49) {
                                    var22 = class248.varcs.getString(var7[var20]);
                                    Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var22;
                                 } else if (var33 == 50) {
                                    class248.varcs.setString(var7[var20], Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize]);
                                 } else if (var33 == 60) {
                                    IterableNodeHashTable var38 = var4.switches[var7[var20]];
                                    IntegerNode var37 = (IntegerNode)var38.get((long)Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                                    if (var37 != null) {
                                       var20 += var37.integer;
                                    }
                                 } else {
                                    Integer var39;
                                    if (var33 == 74) {
                                       var39 = class366.field3544.getTitleGroupValue(var7[var20]);
                                       if (var39 == null) {
                                          Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                       } else {
                                          Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var39;
                                       }
                                    } else {
                                       if (var33 != 76) {
                                          throw new IllegalStateException();
                                       }

                                       var39 = class188.field1522.method2209(var7[var20]);
                                       if (var39 == null) {
                                          Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                       } else {
                                          Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var39;
                                       }
                                    }
                                 }
                              }
                           } else {
                              var13 = var7[var20];
                              Script var36 = SecureRandomCallable.getScript(var13);
                              int[] var15 = new int[var36.localIntCount];
                              String[] var16 = new String[var36.localStringCount];

                              for(var17 = 0; var17 < var36.intArgumentCount; ++var17) {
                                 var15[var17] = Interpreter.Interpreter_intStack[var17 + (Interpreter.Interpreter_intStackSize - var36.intArgumentCount)];
                              }

                              for(var17 = 0; var17 < var36.stringArgumentCount; ++var17) {
                                 var16[var17] = Interpreter.Interpreter_stringStack[var17 + (HealthBar.Interpreter_stringStackSize - var36.stringArgumentCount)];
                              }

                              Interpreter.Interpreter_intStackSize -= var36.intArgumentCount;
                              HealthBar.Interpreter_stringStackSize -= var36.stringArgumentCount;
                              ScriptFrame var23 = new ScriptFrame();
                              var23.script = var4;
                              var23.pc = var20;
                              var23.intLocals = Interpreter.Interpreter_intLocals;
                              var23.stringLocals = Interpreter.Interpreter_stringLocals;
                              Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var23;
                              var4 = var36;
                              var6 = var36.opcodes;
                              var7 = var36.intOperands;
                              var20 = -1;
                              Interpreter.Interpreter_intLocals = var15;
                              Interpreter.Interpreter_stringLocals = var16;
                           }
                        }
                     }
                  } catch (Exception var31) {
                     var9 = true;
                     StringBuilder var27 = new StringBuilder(30);
                     var27.append("").append(var4.key).append(" ");

                     for(var13 = Interpreter.Interpreter_frameDepth - 1; var13 >= 0; --var13) {
                        var27.append("").append(Interpreter.Interpreter_frames[var13].script.key).append(" ");
                     }

                     var27.append("").append(var8);
                     class364.RunException_sendStackTrace(var27.toString(), var31);
                     var30 = false;
                     break label954;
                  }
               } finally {
                  if (var30) {
                     while(Interpreter.field693.size() > 0) {
                        class99 var19 = (class99)Interpreter.field693.remove(0);
                        class333.widgetDefaultMenuAction(var19.method584(), var19.method585(), var19.method587(), var19.method586(), "");
                     }

                     if (Interpreter.field691) {
                        Interpreter.field691 = false;
                        class240.method1312();
                     }

                     if (!var9 && var2 > 0 && var10 >= var2) {
                        class364.RunException_sendStackTrace("Warning: Script " + var4.field793 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
                     }

                  }
               }

               while(Interpreter.field693.size() > 0) {
                  class99 var41 = (class99)Interpreter.field693.remove(0);
                  class333.widgetDefaultMenuAction(var41.method584(), var41.method585(), var41.method587(), var41.method586(), "");
               }

               if (Interpreter.field691) {
                  Interpreter.field691 = false;
                  class240.method1312();
               }

               if (!var9 && var2 > 0 && var10 >= var2) {
                  class364.RunException_sendStackTrace("Warning: Script " + var4.field793 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
               }

               return;
            }

            while(Interpreter.field693.size() > 0) {
               class99 var26 = (class99)Interpreter.field693.remove(0);
               class333.widgetDefaultMenuAction(var26.method584(), var26.method585(), var26.method587(), var26.method586(), "");
            }

            if (Interpreter.field691) {
               Interpreter.field691 = false;
               class240.method1312();
            }

            if (!var9 && var2 > 0 && var10 >= var2) {
               class364.RunException_sendStackTrace("Warning: Script " + var4.field793 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
            }

            return;
         }

         while(Interpreter.field693.size() > 0) {
            class99 var34 = (class99)Interpreter.field693.remove(0);
            class333.widgetDefaultMenuAction(var34.method584(), var34.method585(), var34.method587(), var34.method586(), "");
         }

         if (Interpreter.field691) {
            Interpreter.field691 = false;
            class240.method1312();
         }

         if (!var9 && var2 > 0 && var10 >= var2) {
            class364.RunException_sendStackTrace("Warning: Script " + var4.field793 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1866312257"
   )
   static void method52(int var0) {
      if (var0 != Login.loginIndex) {
         Login.loginIndex = var0;
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "-91"
   )
   static int method54(int var0, Script var1, boolean var2) {
      if (var0 == 7463) {
         boolean var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         class140.method749(var3);
         return 1;
      } else {
         return 2;
      }
   }
}
