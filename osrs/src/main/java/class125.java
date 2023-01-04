import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public class class125 {
   @ObfuscatedName("ir")
   static int regionChunkY;
   @ObfuscatedName("h")
   boolean field1211;
   @ObfuscatedName("e")
   boolean field1202;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Ldp;"
   )
   class124 field1203;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Ldp;"
   )
   class124 field1204;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "[Ldq;"
   )
   class121[] field1205;
   @ObfuscatedName("q")
   boolean field1221;
   @ObfuscatedName("f")
   float field1207;
   @ObfuscatedName("r")
   float field1208;
   @ObfuscatedName("u")
   float field1209;
   @ObfuscatedName("b")
   float field1223;
   @ObfuscatedName("j")
   float field1201;
   @ObfuscatedName("g")
   float field1212;
   @ObfuscatedName("i")
   float field1213;
   @ObfuscatedName("o")
   float field1214;
   @ObfuscatedName("n")
   float field1215;
   @ObfuscatedName("k")
   float field1216;
   @ObfuscatedName("a")
   boolean field1217 = true;
   @ObfuscatedName("s")
   int field1220 = 0;
   @ObfuscatedName("l")
   float[] field1210;
   @ObfuscatedName("t")
   int field1206;
   @ObfuscatedName("c")
   int field1219;
   @ObfuscatedName("p")
   float field1222;
   @ObfuscatedName("d")
   float field1218;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;II)I",
      garbageValue = "-978416029"
   )
   int method698(Buffer var1, int var2) {
      int var3 = var1.readUnsignedShort();
      ChatChannel.method458(var1.readUnsignedByte());
      int var5 = var1.readUnsignedByte();
      class124 var6 = (class124)World.findEnumerated(MidiPcmStream.method1566(), var5);
      if (var6 == null) {
         var6 = class124.field1199;
      }

      this.field1203 = var6;
      int var7 = var1.readUnsignedByte();
      class124 var8 = (class124)World.findEnumerated(MidiPcmStream.method1566(), var7);
      if (var8 == null) {
         var8 = class124.field1199;
      }

      this.field1204 = var8;
      this.field1211 = var1.readUnsignedByte() != 0;
      this.field1205 = new class121[var3];
      class121 var11 = null;

      int var9;
      for(var9 = 0; var9 < var3; ++var9) {
         class121 var10 = new class121();
         var10.method680(var1, var2);
         this.field1205[var9] = var10;
         if (var11 != null) {
            var11.field1173 = var10;
         }

         var11 = var10;
      }

      this.field1206 = this.field1205[0].field1174;
      this.field1219 = this.field1205[this.method702() - 1].field1174;
      this.field1210 = new float[this.method699() + 1];

      for(var9 = this.method701(); var9 <= this.method697(); ++var9) {
         this.field1210[var9 - this.method701()] = FloorOverlayDefinition.method1044(this, (float)var9);
      }

      this.field1205 = null;
      this.field1222 = FloorOverlayDefinition.method1044(this, (float)(this.method701() - 1));
      this.field1218 = FloorOverlayDefinition.method1044(this, (float)(this.method697() + 1));
      return var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IB)F",
      garbageValue = "-121"
   )
   public float method704(int var1) {
      if (var1 < this.method701()) {
         return this.field1222;
      } else {
         return var1 > this.method697() ? this.field1218 : this.field1210[var1 - this.method701()];
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "64"
   )
   int method701() {
      return this.field1206;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "826348925"
   )
   int method697() {
      return this.field1219;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1825494223"
   )
   int method699() {
      return this.method697() - this.method701();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(FI)I",
      garbageValue = "628644903"
   )
   int method700(float var1) {
      if (this.field1220 < 0 || (float)this.field1205[this.field1220].field1174 > var1 || this.field1205[this.field1220].field1173 != null && (float)this.field1205[this.field1220].field1173.field1174 <= var1) {
         if (var1 >= (float)this.method701() && var1 <= (float)this.method697()) {
            int var2 = this.method702();
            int var3 = this.field1220;
            if (var2 > 0) {
               int var4 = 0;
               int var5 = var2 - 1;

               do {
                  int var6 = var5 + var4 >> 1;
                  if (var1 < (float)this.field1205[var6].field1174) {
                     if (var1 > (float)this.field1205[var6 - 1].field1174) {
                        var3 = var6 - 1;
                        break;
                     }

                     var5 = var6 - 1;
                  } else {
                     if (var1 <= (float)this.field1205[var6].field1174) {
                        var3 = var6;
                        break;
                     }

                     if (var1 < (float)this.field1205[var6 + 1].field1174) {
                        var3 = var6;
                        break;
                     }

                     var4 = var6 + 1;
                  }
               } while(var4 <= var5);
            }

            if (var3 != this.field1220) {
               this.field1220 = var3;
               this.field1217 = true;
            }

            return this.field1220;
         } else {
            return -1;
         }
      } else {
         return this.field1220;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(FI)Ldq;",
      garbageValue = "-1470055279"
   )
   class121 method703(float var1) {
      int var2 = this.method700(var1);
      return var2 >= 0 && var2 < this.field1205.length ? this.field1205[var2] : null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1641369395"
   )
   int method702() {
      return this.field1205 == null ? 0 : this.field1205.length;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lcb;III)V",
      garbageValue = "-1404765395"
   )
   static void runScript(ScriptEvent var0, int var1, int var2) {
      Object[] var3 = var0.args;
      Script var4;
      int var20;
      if (class87.isWorldMapEvent(var0.type)) {
         GrandExchangeOfferUnitPriceComparator.worldMapEvent = (WorldMapEvent)var3[0];
         WorldMapElement var5 = JagexCache.WorldMapElement_get(GrandExchangeOfferUnitPriceComparator.worldMapEvent.mapElement);
         var4 = class29.getWorldMapScript(var0.type, var5.objectId, var5.category);
      } else {
         var20 = (Integer)var3[0];
         var4 = VarbitComposition.getScript(var20);
      }

      if (var4 != null) {
         class87.Interpreter_intStackSize = 0;
         Interpreter.Interpreter_stringStackSize = 0;
         var20 = -1;
         int[] var6 = var4.opcodes;
         int[] var7 = var4.intOperands;
         byte var8 = -1;
         Interpreter.Interpreter_frameDepth = 0;
         Interpreter.field694 = false;
         boolean var9 = false;
         int var10 = 0;
         boolean var30 = false;

         label950: {
            label951: {
               try {
                  int var13;
                  try {
                     var30 = true;
                     Interpreter.Interpreter_intLocals = new int[var4.localIntCount];
                     int var11 = 0;
                     class415.Interpreter_stringLocals = new String[var4.localStringCount];
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
                              var14 = var0.widget != null ? var0.widget.id * 1023837327 * -353756561 : -1;
                           }

                           if (var14 == -2147483644) {
                              var14 = var0.opIndex;
                           }

                           if (var14 == -2147483643) {
                              var14 = var0.widget != null ? var0.widget.childIndex * -915599827 * 1271165349 : -1;
                           }

                           if (var14 == -2147483642) {
                              var14 = var0.dragTarget != null ? var0.dragTarget.id * 1023837327 * -353756561 : -1;
                           }

                           if (var14 == -2147483641) {
                              var14 = var0.dragTarget != null ? var0.dragTarget.childIndex * -915599827 * 1271165349 : -1;
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

                           class415.Interpreter_stringLocals[var12++] = var21;
                        }
                     }

                     Interpreter.field700 = var0.field851;

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

                           var14 = SecureRandomFuture.method445(var33, var4, var35);
                           switch(var14) {
                           case 0:
                              var30 = false;
                              break label934;
                           case 1:
                           default:
                              break;
                           case 2:
                              //throw new IllegalStateException();
                           }
                        } else if (var33 == 0) {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7[var20];
                        } else if (var33 == 1) {
                           var13 = var7[var20];
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Varps.Varps_main[var13];
                        } else if (var33 == 2) {
                           var13 = var7[var20];
                           Varps.Varps_main[var13] = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                           MouseRecorder.changeGameOptions(var13);
                        } else if (var33 == 3) {
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.stringOperands[var20];
                        } else if (var33 == 6) {
                           var20 += var7[var20];
                        } else if (var33 == 7) {
                           class87.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 8) {
                           class87.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 9) {
                           class87.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 10) {
                           class87.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 21) {
                           if (Interpreter.Interpreter_frameDepth == 0) {
                              var30 = false;
                              break label951;
                           }

                           ScriptFrame var40 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
                           var4 = var40.script;
                           var6 = var4.opcodes;
                           var7 = var4.intOperands;
                           var20 = var40.pc;
                           Interpreter.Interpreter_intLocals = var40.intLocals;
                           class415.Interpreter_stringLocals = var40.stringLocals;
                        } else if (var33 == 25) {
                           var13 = var7[var20];
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = ObjTypeCustomisation.getVarbit(var13);
                        } else if (var33 == 27) {
                           var13 = var7[var20];
                           Login.method432(var13, Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
                        } else if (var33 == 31) {
                           class87.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 32) {
                           class87.Interpreter_intStackSize -= 2;
                           if (Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]) {
                              var20 += var7[var20];
                           }
                        } else if (var33 == 33) {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Interpreter.Interpreter_intLocals[var7[var20]];
                        } else if (var33 == 34) {
                           Interpreter.Interpreter_intLocals[var7[var20]] = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                        } else if (var33 == 35) {
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = class415.Interpreter_stringLocals[var7[var20]];
                        } else if (var33 == 36) {
                           class415.Interpreter_stringLocals[var7[var20]] = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                        } else if (var33 == 37) {
                           var13 = var7[var20];
                           Interpreter.Interpreter_stringStackSize -= var13;
                           var21 = Tile.method1140(Interpreter.Interpreter_stringStack, Interpreter.Interpreter_stringStackSize, var13);
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var21;
                        } else if (var33 == 38) {
                           --class87.Interpreter_intStackSize;
                        } else if (var33 == 39) {
                           --Interpreter.Interpreter_stringStackSize;
                        } else {
                           int var17;
                           if (var33 != 40) {
                              if (var33 == 42) {
                                 Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = WorldMapArea.varcs.getInt(var7[var20]);
                              } else if (var33 == 43) {
                                 WorldMapArea.varcs.setInt(var7[var20], Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
                              } else if (var33 == 44) {
                                 var13 = var7[var20] >> 16;
                                 var14 = var7[var20] & '\uffff';
                                 int var24 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
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
                                 var14 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                                 if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var13]) {
                                    throw new RuntimeException();
                                 }

                                 Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var13][var14];
                              } else if (var33 == 46) {
                                 var13 = var7[var20];
                                 class87.Interpreter_intStackSize -= 2;
                                 var14 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                                 if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var13]) {
                                    throw new RuntimeException();
                                 }

                                 Interpreter.Interpreter_arrays[var13][var14] = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                              } else {
                                 String var22;
                                 if (var33 == 47) {
                                    var22 = WorldMapArea.varcs.getStringOld(var7[var20]);
                                    if (var22 == null) {
                                       var22 = "null";
                                    }

                                    Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var22;
                                 } else if (var33 == 48) {
                                    WorldMapArea.varcs.setStringOld(var7[var20], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
                                 } else if (var33 == 49) {
                                    var22 = WorldMapArea.varcs.getString(var7[var20]);
                                    Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var22;
                                 } else if (var33 == 50) {
                                    WorldMapArea.varcs.setString(var7[var20], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
                                 } else if (var33 == 60) {
                                    IterableNodeHashTable var38 = var4.switches[var7[var20]];
                                    IntegerNode var37 = (IntegerNode)var38.get((long)Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
                                    if (var37 != null) {
                                       var20 += var37.integer;
                                    }
                                 } else {
                                    Integer var39;
                                    if (var33 == 74) {
                                       var39 = class126.field1235.getTitleGroupValue(var7[var20]);
                                       if (var39 == null) {
                                          Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                                       } else {
                                          Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var39;
                                       }
                                    } else {
                                       if (var33 != 76) {
                                          //throw new IllegalStateException();
                                       }

                                       var39 = LoginScreenAnimation.field1028.method2155(var7[var20]);
                                       if (var39 == null) {
                                          Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                                       } else {
                                          Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var39;
                                       }
                                    }
                                 }
                              }
                           } else {
                              var13 = var7[var20];
                              Script var36 = VarbitComposition.getScript(var13);
                              int[] var15 = new int[var36.localIntCount];
                              String[] var16 = new String[var36.localStringCount];

                              for(var17 = 0; var17 < var36.intArgumentCount; ++var17) {
                                 var15[var17] = Interpreter.Interpreter_intStack[var17 + (class87.Interpreter_intStackSize - var36.intArgumentCount)];
                              }

                              for(var17 = 0; var17 < var36.stringArgumentCount; ++var17) {
                                 var16[var17] = Interpreter.Interpreter_stringStack[var17 + (Interpreter.Interpreter_stringStackSize - var36.stringArgumentCount)];
                              }

                              class87.Interpreter_intStackSize -= var36.intArgumentCount;
                              Interpreter.Interpreter_stringStackSize -= var36.stringArgumentCount;
                              ScriptFrame var23 = new ScriptFrame();
                              var23.script = var4;
                              var23.pc = var20;
                              var23.intLocals = Interpreter.Interpreter_intLocals;
                              var23.stringLocals = class415.Interpreter_stringLocals;
                              Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var23;
                              var4 = var36;
                              var6 = var36.opcodes;
                              var7 = var36.intOperands;
                              var20 = -1;
                              Interpreter.Interpreter_intLocals = var15;
                              class415.Interpreter_stringLocals = var16;
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
                     class132.RunException_sendStackTrace(var27.toString(), var31);
                     var30 = false;
                     break label950;
                  }
               } finally {
                  if (var30) {
                     while(Interpreter.field696.size() > 0) {
                        class98 var19 = (class98)Interpreter.field696.remove(0);
                        ModelData0.widgetDefaultMenuAction(var19.method593(), var19.method594(), var19.method595(), var19.method596(), "");
                     }

                     if (Interpreter.field694) {
                        Interpreter.field694 = false;
                        WorldMapSectionType.method1429();
                     }

                     if (!var9 && var2 > 0 && var10 >= var2) {
                        class132.RunException_sendStackTrace("Warning: Script " + var4.field792 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
                     }

                  }
               }

               while(Interpreter.field696.size() > 0) {
                  class98 var34 = (class98)Interpreter.field696.remove(0);
                  ModelData0.widgetDefaultMenuAction(var34.method593(), var34.method594(), var34.method595(), var34.method596(), "");
               }

               if (Interpreter.field694) {
                  Interpreter.field694 = false;
                  WorldMapSectionType.method1429();
               }

               if (!var9 && var2 > 0 && var10 >= var2) {
                  class132.RunException_sendStackTrace("Warning: Script " + var4.field792 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
               }

               return;
            }

            while(Interpreter.field696.size() > 0) {
               class98 var41 = (class98)Interpreter.field696.remove(0);
               ModelData0.widgetDefaultMenuAction(var41.method593(), var41.method594(), var41.method595(), var41.method596(), "");
            }

            if (Interpreter.field694) {
               Interpreter.field694 = false;
               WorldMapSectionType.method1429();
            }

            if (!var9 && var2 > 0 && var10 >= var2) {
               class132.RunException_sendStackTrace("Warning: Script " + var4.field792 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
            }

            return;
         }

         while(Interpreter.field696.size() > 0) {
            class98 var26 = (class98)Interpreter.field696.remove(0);
            ModelData0.widgetDefaultMenuAction(var26.method593(), var26.method594(), var26.method595(), var26.method596(), "");
         }

         if (Interpreter.field694) {
            Interpreter.field694 = false;
            WorldMapSectionType.method1429();
         }

         if (!var9 && var2 > 0 && var10 >= var2) {
            class132.RunException_sendStackTrace("Warning: Script " + var4.field792 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lly;III)Lrx;",
      garbageValue = "-16711936"
   )
   public static SpritePixels SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
      byte[] var4 = var0.takeFile(var1, var2);
      boolean var3;
      if (var4 == null) {
         var3 = false;
      } else {
         VarpDefinition.SpriteBuffer_decode(var4);
         var3 = true;
      }

      return !var3 ? null : class360.method1910();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Lqy;II)V",
      garbageValue = "-1201081904"
   )
   public static void method695(Buffer var0, int var1) {
      if (JagexCache.JagexCache_randomDat != null) {
         try {
            JagexCache.JagexCache_randomDat.seek(0L);
            JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("kx")
   @ObfuscatedSignature(
      descriptor = "(IIB)Ljava/lang/String;",
      garbageValue = "120"
   )
   static final String method706(int var0, int var1) {
      int var2 = var1 - var0;
      if (var2 < -9) {
         return MouseRecorder.colorStartTag(16711680);
      } else if (var2 < -6) {
         return MouseRecorder.colorStartTag(16723968);
      } else if (var2 < -3) {
         return MouseRecorder.colorStartTag(16740352);
      } else if (var2 < 0) {
         return MouseRecorder.colorStartTag(16756736);
      } else if (var2 > 9) {
         return MouseRecorder.colorStartTag(65280);
      } else if (var2 > 6) {
         return MouseRecorder.colorStartTag(4259584);
      } else if (var2 > 3) {
         return MouseRecorder.colorStartTag(8453888);
      } else {
         return var2 > 0 ? MouseRecorder.colorStartTag(12648192) : MouseRecorder.colorStartTag(16776960);
      }
   }
}
