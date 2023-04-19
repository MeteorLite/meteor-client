import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class144 extends class139 {
   @ObfuscatedName("iz")
   static int field1333;
    @ObfuscatedName("lf")
    static int oculusOrbFocalPointY;
   @ObfuscatedName("af")
   int field1328;
   @ObfuscatedName("an")
   int field1329;
   @ObfuscatedName("aw")
   int field1330;
   @ObfuscatedName("ac")
   int field1332;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfa;)V"
   )
   class144(class142 var1) {
      this.this$0 = var1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "168736686"
    )
    void vmethod3254(Buffer var1) {
      this.field1328 = var1.readInt();
      this.field1332 = var1.readInt();
      this.field1329 = var1.readUnsignedByte();
      this.field1330 = var1.readUnsignedByte();
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lfj;I)V",
            garbageValue = "1712319228"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method862(this.field1328, this.field1332, this.field1329, this.field1330);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(IIILia;Lif;Z[I[II)I",
      garbageValue = "1716451155"
   )
   public static int method818(int var0, int var1, int var2, RouteStrategy var3, CollisionMap var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class211.directions[var8][var9] = 0;
            class211.distances[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var13;
      int var14;
      int var15;
      int var17;
      int var19;
      int var20;
      int var21;
      boolean var28;
      int var30;
      int var31;
      int var33;
      if (var2 == 1) {
         var28 = class88.method522(var0, var1, var3, var4);
      } else if (var2 == 2) {
         var10 = var0;
         var11 = var1;
         byte var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class211.directions[var12][var13] = 99;
         class211.distances[var12][var13] = 0;
         byte var16 = 0;
         var17 = 0;
         class211.bufferX[var16] = var0;
         var33 = var16 + 1;
         class211.bufferY[var16] = var1;
         int[][] var18 = var4.flags;

         boolean var29;
         while(true) {
            if (var17 == var33) {
               class18.field56 = var10;
               class397.field3691 = var11;
               var29 = false;
               break;
            }

            var10 = class211.bufferX[var17];
            var11 = class211.bufferY[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.xInset;
            var20 = var11 - var4.yInset;
            if (var3.hasArrived(2, var10, var11, var4)) {
               class18.field56 = var10;
               class397.field3691 = var11;
               var29 = true;
               break;
            }

            var21 = class211.distances[var30][var31] + 1;
            if (var30 > 0 && class211.directions[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0) {
               class211.bufferX[var33] = var10 - 1;
               class211.bufferY[var33] = var11;
               var33 = var33 + 1 & 4095;
               class211.directions[var30 - 1][var31] = 2;
               class211.distances[var30 - 1][var31] = var21;
            }

            if (var30 < 126 && class211.directions[var30 + 1][var31] == 0 && (var18[var19 + 2][var20] & 19136899) == 0 && (var18[var19 + 2][var20 + 1] & 19136992) == 0) {
               class211.bufferX[var33] = var10 + 1;
               class211.bufferY[var33] = var11;
               var33 = var33 + 1 & 4095;
               class211.directions[var30 + 1][var31] = 8;
               class211.distances[var30 + 1][var31] = var21;
            }

            if (var31 > 0 && class211.directions[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0) {
               class211.bufferX[var33] = var10;
               class211.bufferY[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class211.directions[var30][var31 - 1] = 1;
               class211.distances[var30][var31 - 1] = var21;
            }

            if (var31 < 126 && class211.directions[var30][var31 + 1] == 0 && (var18[var19][var20 + 2] & 19136824) == 0 && (var18[var19 + 1][var20 + 2] & 19136992) == 0) {
               class211.bufferX[var33] = var10;
               class211.bufferY[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class211.directions[var30][var31 + 1] = 4;
               class211.distances[var30][var31 + 1] = var21;
            }

            if (var30 > 0 && var31 > 0 && class211.directions[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class211.bufferX[var33] = var10 - 1;
               class211.bufferY[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class211.directions[var30 - 1][var31 - 1] = 3;
               class211.distances[var30 - 1][var31 - 1] = var21;
            }

            if (var30 < 126 && var31 > 0 && class211.directions[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136911) == 0 && (var18[var19 + 2][var20 - 1] & 19136899) == 0 && (var18[var19 + 2][var20] & 19136995) == 0) {
               class211.bufferX[var33] = var10 + 1;
               class211.bufferY[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class211.directions[var30 + 1][var31 - 1] = 9;
               class211.distances[var30 + 1][var31 - 1] = var21;
            }

            if (var30 > 0 && var31 < 126 && class211.directions[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136830) == 0 && (var18[var19 - 1][var20 + 2] & 19136824) == 0 && (var18[var19][var20 + 2] & 19137016) == 0) {
               class211.bufferX[var33] = var10 - 1;
               class211.bufferY[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class211.directions[var30 - 1][var31 + 1] = 6;
               class211.distances[var30 - 1][var31 + 1] = var21;
            }

            if (var30 < 126 && var31 < 126 && class211.directions[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 2] & 19137016) == 0 && (var18[var19 + 2][var20 + 2] & 19136992) == 0 && (var18[var19 + 2][var20 + 1] & 19136995) == 0) {
               class211.bufferX[var33] = var10 + 1;
               class211.bufferY[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class211.directions[var30 + 1][var31 + 1] = 12;
               class211.distances[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else {
         var28 = KitDefinition.method1000(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class18.field56;
      var30 = class397.field3691;
      if (!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.approxDestinationX;
         var17 = var3.approxDestinationY;
         int var27 = var3.approxDestinationSizeX;
         var19 = var3.approxDestinationSizeY;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var17 + var32; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if (var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class211.distances[var22][var23] < 100) {
                  int var24 = 0;
                  if (var20 < var33) {
                     var24 = var33 - var20;
                  } else if (var20 > var27 + var33 - 1) {
                     var24 = var20 - (var27 + var33 - 1);
                  }

                  int var25 = 0;
                  if (var21 < var17) {
                     var25 = var17 - var21;
                  } else if (var21 > var19 + var17 - 1) {
                     var25 = var21 - (var19 + var17 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if (var26 < var31 || var31 == var26 && class211.distances[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class211.distances[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if (var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if (var0 == var11 && var30 == var1) {
         var6[0] = var11;
         var7[0] = var30;
         return 0;
      } else {
         var13 = 0;
         class211.bufferX[var13] = var11;
         var31 = var13 + 1;
         class211.bufferY[var13] = var30;

         for(var14 = var15 = class211.directions[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class211.directions[var11 - var9][var30 - var10]) {
            if (var14 != var15) {
               var15 = var14;
               class211.bufferX[var31] = var11;
               class211.bufferY[var31++] = var30;
            }

            if ((var14 & 2) != 0) {
               ++var11;
            } else if ((var14 & 8) != 0) {
               --var11;
            }

            if ((var14 & 1) != 0) {
               ++var30;
            } else if ((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class211.bufferX[var31];
            var7[var33++] = class211.bufferY[var31];
            if (var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(IS)Lhq;",
            garbageValue = "2415"
    )
    public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.ObjectDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.ObjectDefinition_archive.takeFile(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.postDecode();
         if (var1.isSolid) {
            var1.interactType = 0;
            var1.boolean1 = false;
         }

         ObjectComposition.ObjectDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "([BIII)Ljava/lang/String;",
      garbageValue = "-253703196"
   )
   static String method826(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class370.field3593[var5 >>> 2]);
         if (var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class370.field3593[(var5 & 3) << 4 | var6 >>> 4]);
            if (var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class370.field3593[(var6 & 15) << 2 | var7 >>> 6]).append(class370.field3593[var7 & 63]);
            } else {
               var3.append(class370.field3593[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class370.field3593[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1444508047"
   )
   public static void method822() {
      Object var0 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
         if (ArchiveDiskActionHandler.field3453 != 0) {
            ArchiveDiskActionHandler.field3453 = 1;

            try {
               ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIFFFII)V",
      garbageValue = "-515253774"
   )
   public static void method825(int var0, int var1, int var2, int var3, int var4, int var5, float var6, float var7, float var8, int var9) {
      Rasterizer3D.field1999.vmethod1366(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "38"
   )
   static int method821(int var0, Script var1, boolean var2) {
      int var3;
      int var5;
      int var7;
      Object var21;
      class482 var22;
      if (var0 != 7500 && var0 != 7508) {
         if (var0 != 7501) {
            int var4;
            int var6;
            if (var0 == 7502) {
               Interpreter.Interpreter_intStackSize -= 3;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
               var6 = class373.method1992(var4);
               var7 = BufferedSink.method2222(var4);
               int var8 = class146.method833(var4);
               DbRowType var23 = class125.getDbRowType(var3);
               DbTableType var24 = GameBuild.getDbTableType(var6);
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
                     class478 var17 = class103.method639(var16);
                     if (var17 == class478.field4026) {
                        Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.method1933(var16);
                     }
                  }

                  return 1;
               } else {
                  var15 = var14.length / var25.length;
                  if (var5 >= 0 && var5 < var15) {
                     for(var16 = var12; var16 < var13; ++var16) {
                        int var19 = var16 + var25.length * var5;
                        class478 var18 = class103.method639(var25[var16]);
                        if (var18 == class478.field4026) {
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = (String)var14[var19];
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
               var6 = class373.method1992(var4);
               var7 = BufferedSink.method2222(var4);
               DbRowType var26 = class125.getDbRowType(var3);
               DbTableType var9 = GameBuild.getDbTableType(var6);
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
                  DbRowType var28 = class125.getDbRowType(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var28.tableId;
                  return 1;
               } else if (var0 == 7506) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var4 = -1;
                  if (class9.field21 != null && var3 >= 0 && var3 < class9.field21.size()) {
                     var4 = (Integer)class9.field21.get(var3);
                  }

                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
                  return 1;
               } else if (var0 != 7507 && var0 != 7509) {
                  return 2;
               } else {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var21 = ScriptEvent.method489(var3);
                  var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var22 = class206.method1147(var5);
                  if (var22 == null) {
                     throw new RuntimeException();
                  } else if (class373.method1992(var5) != Client.field613) {
                     throw new RuntimeException();
                  } else if (class9.field21 == null && class9.field21.isEmpty()) {
                     throw new RuntimeException();
                  } else {
                     var7 = class146.method833(var5);
                     List var20 = var22.method2448(var21, var7);
                     class9.field21 = new LinkedList(class9.field21);
                     if (var20 != null) {
                        class9.field21.retainAll(var20);
                     } else {
                        class9.field21.clear();
                     }

                     class1.field4 = class9.field21.iterator();
                     if (var0 == 7507) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class9.field21.size();
                     }

                     return 1;
                  }
               }
            } else {
               --Interpreter.Interpreter_intStackSize;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               class482 var27 = class10.method40(var3);
               if (var27 == null) {
                  throw new RuntimeException();
               } else {
                  class9.field21 = var27.method2448(0, 0);
                  var5 = 0;
                  if (class9.field21 != null) {
                     Client.field613 = var3;
                     class1.field4 = class9.field21.iterator();
                     var5 = class9.field21.size();
                  }

                  if (var0 == 7504) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5;
                  }

                  return 1;
               }
            }
         } else {
            if (class1.field4 != null && class1.field4.hasNext()) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (Integer)class1.field4.next();
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
            }

            return 1;
         }
      } else {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         var21 = ScriptEvent.method489(var3);
         var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         var22 = class206.method1147(var5);
         if (var22 == null) {
            throw new RuntimeException();
         } else {
            var7 = class146.method833(var5);
            class9.field21 = var22.method2448(var21, var7);
            if (class9.field21 != null) {
               Client.field613 = class373.method1992(var5);
               class1.field4 = class9.field21.iterator();
               if (var0 == 7500) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class9.field21.size();
               }
            } else {
               Client.field613 = -1;
               class1.field4 = null;
               if (var0 == 7500) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               }
            }

            return 1;
         }
      }
   }

    @ObfuscatedName("ma")
    @ObfuscatedSignature(
            descriptor = "(Lmq;I)V",
            garbageValue = "-1541166442"
    )
    public static void invalidateWidget(Widget var0) {
      if (var0 != null && var0.cycle == Client.field527) {
         Client.field573[var0.rootIndex] = true;
      }

   }
}
