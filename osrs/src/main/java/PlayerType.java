import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nz")
@Implements("PlayerType")
public enum PlayerType implements class356 {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lnz;"
    )
    PlayerType_normal(0, -1, true, false, true),
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lnz;"
    )
    PlayerType_playerModerator(1, 0, true, true, true),
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lnz;"
    )
    PlayerType_jagexModerator(2, 1, true, true, false),
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Lnz;"
    )
    PlayerType_ironman(3, 2, false, false, true),
    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "Lnz;"
    )
    PlayerType_ultimateIronman(4, 3, false, false, true),
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Lnz;"
    )
    PlayerType_hardcoreIronman(5, 10, false, false, true),
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lnz;"
   )
   field3430(6, 22, false, false, true),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lnz;"
   )
   field3431(7, 41, false, false, true),
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lnz;"
   )
   field3432(8, 42, false, false, true),
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "Lnz;"
   )
   field3433(9, 43, false, false, true),
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Lnz;"
   )
   field3434(10, 44, false, false, true),
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lnz;"
   )
   field3444(11, 45, false, false, true),
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "Lnz;"
   )
   field3436(12, 46, false, false, true),
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "Lnz;"
   )
   field3439(13, 47, false, false, true),
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "Lnz;"
   )
   field3437(14, 48, false, false, true),
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "Lnz;"
   )
   field3428(15, 49, false, false, true),
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lnz;"
   )
   field3440(16, 52, false, false, true);

    @ObfuscatedName("dz")
    @ObfuscatedSignature(
            descriptor = "Ltc;"
    )
    static IndexedSprite worldSelectLeftSprite;
    @ObfuscatedName("ar")
    final int id;
    @ObfuscatedName("am")
    public final int modIcon;
    @ObfuscatedName("as")
    public final boolean isPrivileged;
    @ObfuscatedName("aj")
    public final boolean isUser;

   PlayerType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.id = var3;
      this.modIcon = var4;
      this.isPrivileged = var6;
      this.isUser = var7;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.id;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Ldr;III)V",
            garbageValue = "637714632"
    )
    static void runScript(ScriptEvent var0, int var1, int var2) {
      Object[] var3 = var0.args;
      Script var4;
      int var20;
      if (class292.isWorldMapEvent(var0.type)) {
         ByteArrayPool.worldMapEvent = (WorldMapEvent)var3[0];
         WorldMapElement var5 = class354.WorldMapElement_get(ByteArrayPool.worldMapEvent.mapElement);
         var4 = class151.getWorldMapScript(var0.type, var5.objectId, var5.category);
      } else {
         var20 = (Integer)var3[0];
         var4 = AbstractByteArrayCopier.getScript(var20);
      }

      if (var4 != null) {
         Interpreter.Interpreter_intStackSize = 0;
         SecureRandomCallable.Interpreter_stringStackSize = 0;
         var20 = -1;
         int[] var6 = var4.opcodes;
         int[] var7 = var4.intOperands;
         byte var8 = -1;
         Interpreter.Interpreter_frameDepth = 0;
         Interpreter.field700 = false;
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
                              var14 = var0.widget != null ? var0.widget.id * 1713081171 * 346484955 : -1;
                           }

                           if (var14 == -2147483644) {
                              var14 = var0.opIndex;
                           }

                           if (var14 == -2147483643) {
                              var14 = var0.widget != null ? var0.widget.childIndex * -1274125071 * 55577617 : -1;
                           }

                           if (var14 == -2147483642) {
                              var14 = var0.dragTarget != null ? var0.dragTarget.id * 1713081171 * 346484955 : -1;
                           }

                           if (var14 == -2147483641) {
                              var14 = var0.dragTarget != null ? var0.dragTarget.childIndex * -1274125071 * 55577617 : -1;
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

                     Interpreter.field703 = var0.field859;

                     label937:
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

                           var14 = class33.method152(var33, var4, var35);
                           switch(var14) {
                           case 0:
                              var30 = false;
                              break label937;
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
                           class7.changeGameOptions(var13);
                        } else if (var33 == 3) {
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var4.stringOperands[var20];
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
                              break label954;
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
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class252.getVarbit(var13);
                        } else if (var33 == 27) {
                           var13 = var7[var20];
                           class283.method1593(var13, Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
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
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = Interpreter.Interpreter_stringLocals[var7[var20]];
                        } else if (var33 == 36) {
                           Interpreter.Interpreter_stringLocals[var7[var20]] = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                        } else if (var33 == 37) {
                           var13 = var7[var20];
                           SecureRandomCallable.Interpreter_stringStackSize -= var13;
                           var21 = WorldMapSprite.method1524(Interpreter.Interpreter_stringStack, SecureRandomCallable.Interpreter_stringStackSize, var13);
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var21;
                        } else if (var33 == 38) {
                           --Interpreter.Interpreter_intStackSize;
                        } else if (var33 == 39) {
                           --SecureRandomCallable.Interpreter_stringStackSize;
                        } else {
                           int var17;
                           if (var33 != 40) {
                              if (var33 == 42) {
                                 Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class373.varcs.getInt(var7[var20]);
                              } else if (var33 == 43) {
                                 class373.varcs.setInt(var7[var20], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
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
                                    var22 = class373.varcs.getStringOld(var7[var20]);
                                    if (var22 == null) {
                                       var22 = "null";
                                    }

                                    Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var22;
                                 } else if (var33 == 48) {
                                    class373.varcs.setStringOld(var7[var20], Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize]);
                                 } else if (var33 == 49) {
                                    var22 = class373.varcs.getString(var7[var20]);
                                    Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var22;
                                 } else if (var33 == 50) {
                                    class373.varcs.setString(var7[var20], Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize]);
                                 } else if (var33 == 60) {
                                    IterableNodeHashTable var38 = var4.switches[var7[var20]];
                                    IntegerNode var37 = (IntegerNode)var38.get((long)Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                                    if (var37 != null) {
                                       var20 += var37.integer;
                                    }
                                 } else {
                                    Integer var39;
                                    if (var33 == 74) {
                                       var39 = class133.field1286.getTitleGroupValue(var7[var20]);
                                       if (var39 == null) {
                                          Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                       } else {
                                          Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var39;
                                       }
                                    } else {
                                       if (var33 != 76) {
                                          throw new IllegalStateException();
                                       }

                                       var39 = Players.varclan.method2273(var7[var20]);
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
                              Script var36 = AbstractByteArrayCopier.getScript(var13);
                              int[] var15 = new int[var36.localIntCount];
                              String[] var16 = new String[var36.localStringCount];

                              for(var17 = 0; var17 < var36.intArgumentCount; ++var17) {
                                 var15[var17] = Interpreter.Interpreter_intStack[var17 + (Interpreter.Interpreter_intStackSize - var36.intArgumentCount)];
                              }

                              for(var17 = 0; var17 < var36.stringArgumentCount; ++var17) {
                                 var16[var17] = Interpreter.Interpreter_stringStack[var17 + (SecureRandomCallable.Interpreter_stringStackSize - var36.stringArgumentCount)];
                              }

                              Interpreter.Interpreter_intStackSize -= var36.intArgumentCount;
                              SecureRandomCallable.Interpreter_stringStackSize -= var36.stringArgumentCount;
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
                     class387.RunException_sendStackTrace(var27.toString(), var31);
                     var30 = false;
                     break label953;
                  }
               } finally {
                  if (var30) {
                     while(Interpreter.field690.size() > 0) {
                        class97 var19 = (class97)Interpreter.field690.remove(0);
                        Message.widgetDefaultMenuAction(var19.method615(), var19.method613(), var19.method614(), var19.method616(), "");
                     }

                     if (Interpreter.field700) {
                        Interpreter.field700 = false;
                        class148.method844();
                     }

                     if (!var9 && var2 > 0 && var10 >= var2) {
                        class387.RunException_sendStackTrace("Warning: Script " + var4.field794 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
                     }

                  }
               }

               while(Interpreter.field690.size() > 0) {
                  class97 var34 = (class97)Interpreter.field690.remove(0);
                  Message.widgetDefaultMenuAction(var34.method615(), var34.method613(), var34.method614(), var34.method616(), "");
               }

               if (Interpreter.field700) {
                  Interpreter.field700 = false;
                  class148.method844();
               }

               if (!var9 && var2 > 0 && var10 >= var2) {
                  class387.RunException_sendStackTrace("Warning: Script " + var4.field794 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
               }

               return;
            }

            while(Interpreter.field690.size() > 0) {
               class97 var41 = (class97)Interpreter.field690.remove(0);
               Message.widgetDefaultMenuAction(var41.method615(), var41.method613(), var41.method614(), var41.method616(), "");
            }

            if (Interpreter.field700) {
               Interpreter.field700 = false;
               class148.method844();
            }

            if (!var9 && var2 > 0 && var10 >= var2) {
               class387.RunException_sendStackTrace("Warning: Script " + var4.field794 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
            }

            return;
         }

         while(Interpreter.field690.size() > 0) {
            class97 var26 = (class97)Interpreter.field690.remove(0);
            Message.widgetDefaultMenuAction(var26.method615(), var26.method613(), var26.method614(), var26.method616(), "");
         }

         if (Interpreter.field700) {
            Interpreter.field700 = false;
            class148.method844();
         }

         if (!var9 && var2 > 0 && var10 >= var2) {
            class387.RunException_sendStackTrace("Warning: Script " + var4.field794 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
         }

      }
   }
}
