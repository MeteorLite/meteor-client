import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("AttackOption")
public enum AttackOption implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Ldy;"
   )
   @Export("AttackOption_dependsOnCombatLevels")
   AttackOption_dependsOnCombatLevels(0),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Ldy;"
   )
   @Export("AttackOption_alwaysRightClick")
   AttackOption_alwaysRightClick(1),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Ldy;"
   )
   field1069(2),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Ldy;"
   )
   @Export("AttackOption_hidden")
   AttackOption_hidden(3),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Ldy;"
   )
   field1071(4);

   @ObfuscatedName("ao")
   @Export("id")
   final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lew;FI)F",
      garbageValue = "-137382386"
   )
   static float method590(class127 var0, float var1) {
      if (var0 != null && var0.method703() != 0) {
         if (var1 < (float)var0.field1203[0].field1165) {
            return var0.field1201 == class125.field1194 ? var0.field1203[0].field1158 : class181.method922(var0, var1, true);
         } else if (var1 > (float)var0.field1203[var0.method703() - 1].field1165) {
            return var0.field1214 == class125.field1194 ? var0.field1203[var0.method703() - 1].field1158 : class181.method922(var0, var1, false);
         } else if (var0.field1200) {
            return var0.field1203[0].field1158;
         } else {
            class122 var2 = var0.method702(var1);
            boolean var3 = false;
            boolean var4 = false;
            if (var2 == null) {
               return 0.0F;
            } else {
               if ((double)var2.field1161 == 0.0D && (double)var2.field1162 == 0.0D) {
                  var3 = true;
               } else if (var2.field1161 == Float.MAX_VALUE && Float.MAX_VALUE == var2.field1162) {
                  var4 = true;
               } else if (var2.field1163 != null) {
                  if (var0.field1215) {
                     float var5 = (float)var2.field1165;
                     float var9 = var2.field1158;
                     float var6 = var2.field1161 * 0.33333334F + var5;
                     float var10 = var9 + var2.field1162 * 0.33333334F;
                     float var8 = (float)var2.field1163.field1165;
                     float var12 = var2.field1163.field1158;
                     float var7 = var8 - var2.field1163.field1159 * 0.33333334F;
                     float var11 = var12 - var2.field1163.field1160 * 0.33333334F;
                     if (var0.field1210) {
                        class145.method767(var0, var5, var6, var7, var8, var9, var10, var11, var12);
                     } else {
                        class136.method735(var0, var5, var6, var7, var8, var9, var10, var11, var12);
                     }

                     var0.field1215 = false;
                  }
               } else {
                  var3 = true;
               }

               if (var3) {
                  return var2.field1158;
               } else if (var4) {
                  return (float)var2.field1165 != var1 && var2.field1163 != null ? var2.field1163.field1158 : var2.field1158;
               } else {
                  return var0.field1210 ? Tiles.method453(var0, var1) : class467.method2360(var0, var1);
               }
            }
         }
      } else {
         return 0.0F;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lsq;B)V",
      garbageValue = "1"
   )
   @Export("performReflectionCheck")
   public static void performReflectionCheck(PacketBuffer var0) {
      ReflectionCheck var1 = (ReflectionCheck)class36.reflectionChecks.last();
      if (var1 != null) {
         int var2 = var0.offset;
         var0.writeInt(var1.id);

         for(int var3 = 0; var3 < var1.size; ++var3) {
            if (var1.creationErrors[var3] != 0) {
               var0.writeByte(var1.creationErrors[var3]);
            } else {
               try {
                  int var4 = var1.operations[var3];
                  Field var5;
                  int var6;
                  if (var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.writeByte(0);
                     var0.writeInt(var6);
                  } else if (var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.intReplaceValues[var3]);
                     var0.writeByte(0);
                  } else if (var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.writeByte(0);
                     var0.writeInt(var6);
                  }

                  Method var25;
                  if (var4 != 3) {
                     if (var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.writeByte(0);
                        var0.writeInt(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.arguments[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = Reflection.invoke(var25, (Object)null, var7);
                     if (var11 == null) {
                        var0.writeByte(0);
                     } else if (var11 instanceof Number) {
                        var0.writeByte(1);
                        var0.writeLong(((Number)var11).longValue());
                     } else if (var11 instanceof String) {
                        var0.writeByte(2);
                        var0.writeStringCp1252NullTerminated((String)var11);
                     } else {
                        var0.writeByte(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.writeByte(-10);
               } catch (InvalidClassException var14) {
                  var0.writeByte(-11);
               } catch (StreamCorruptedException var15) {
                  var0.writeByte(-12);
               } catch (OptionalDataException var16) {
                  var0.writeByte(-13);
               } catch (IllegalAccessException var17) {
                  var0.writeByte(-14);
               } catch (IllegalArgumentException var18) {
                  var0.writeByte(-15);
               } catch (InvocationTargetException var19) {
                  var0.writeByte(-16);
               } catch (SecurityException var20) {
                  var0.writeByte(-17);
               } catch (IOException var21) {
                  var0.writeByte(-18);
               } catch (NullPointerException var22) {
                  var0.writeByte(-19);
               } catch (Exception var23) {
                  var0.writeByte(-20);
               } catch (Throwable var24) {
                  var0.writeByte(-21);
               }
            }
         }

         var0.writeCrc(var2);
         var1.remove();
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lsq;II)V",
      garbageValue = "7099921"
   )
   @Export("readPlayerUpdate")
   static void readPlayerUpdate(PacketBuffer var0, int var1) {
      boolean var2 = var0.readBits(1) == 1;
      if (var2) {
         Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
      }

      int var3 = var0.readBits(2);
      Player var4 = Client.players[var1];
      if (var3 == 0) {
         if (var2) {
            var4.hasMovementPending = false;
         } else if (Client.localPlayerIndex == var1) {
            throw new RuntimeException();
         } else {
            Players.Players_regions[var1] = (var4.plane << 28) + (GameEngine.baseX + var4.pathX[0] >> 13 << 14) + (class178.baseY + var4.pathY[0] >> 13);
            if (var4.movingOrientation != -1) {
               Players.Players_orientations[var1] = var4.movingOrientation;
            } else {
               Players.Players_orientations[var1] = var4.orientation;
            }

            Players.Players_targetIndices[var1] = var4.targetIndex;
            Client.players[var1] = null;
            if (var0.readBits(1) != 0) {
               class157.updateExternalPlayer(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if (var3 == 1) {
            var5 = var0.readBits(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if (var5 == 0) {
               --var6;
               --var7;
            } else if (var5 == 1) {
               --var7;
            } else if (var5 == 2) {
               ++var6;
               --var7;
            } else if (var5 == 3) {
               --var6;
            } else if (var5 == 4) {
               ++var6;
            } else if (var5 == 5) {
               --var6;
               ++var7;
            } else if (var5 == 6) {
               ++var7;
            } else if (var5 == 7) {
               ++var6;
               ++var7;
            }

            if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if (var2) {
                  var4.hasMovementPending = true;
                  var4.tileX = var6;
                  var4.tileY = var7;
               } else {
                  var4.hasMovementPending = false;
                  var4.move(var6, var7, Players.playerMovementSpeeds[var1]);
               }
            } else {
               var4.resetPath(var6, var7);
               var4.hasMovementPending = false;
            }

         } else if (var3 == 2) {
            var5 = var0.readBits(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if (var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if (var5 == 1) {
               --var6;
               var7 -= 2;
            } else if (var5 == 2) {
               var7 -= 2;
            } else if (var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if (var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if (var5 == 5) {
               var6 -= 2;
               --var7;
            } else if (var5 == 6) {
               var6 += 2;
               --var7;
            } else if (var5 == 7) {
               var6 -= 2;
            } else if (var5 == 8) {
               var6 += 2;
            } else if (var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if (var5 == 10) {
               var6 += 2;
               ++var7;
            } else if (var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if (var5 == 12) {
               --var6;
               var7 += 2;
            } else if (var5 == 13) {
               var7 += 2;
            } else if (var5 == 14) {
               ++var6;
               var7 += 2;
            } else if (var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if (var2) {
                  var4.hasMovementPending = true;
                  var4.tileX = var6;
                  var4.tileY = var7;
               } else {
                  var4.hasMovementPending = false;
                  var4.move(var6, var7, Players.playerMovementSpeeds[var1]);
               }
            } else {
               var4.resetPath(var6, var7);
               var4.hasMovementPending = false;
            }

         } else {
            var5 = var0.readBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if (var5 == 0) {
               var6 = var0.readBits(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if (var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if (var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if (var2) {
                     var4.hasMovementPending = true;
                     var4.tileX = var10;
                     var4.tileY = var11;
                  } else {
                     var4.hasMovementPending = false;
                     var4.move(var10, var11, Players.playerMovementSpeeds[var1]);
                  }
               } else {
                  var4.resetPath(var10, var11);
                  var4.hasMovementPending = false;
               }

               var4.plane = (byte)(var7 + var4.plane & 3);
               if (Client.localPlayerIndex == var1) {
                  TaskHandler.Client_plane = var4.plane;
               }

            } else {
               var6 = var0.readBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + GameEngine.baseX + var4.pathX[0] & 16383) - GameEngine.baseX;
               var11 = (var9 + class178.baseY + var4.pathY[0] & 16383) - class178.baseY;
               if (Client.localPlayerIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if (var2) {
                     var4.hasMovementPending = true;
                     var4.tileX = var10;
                     var4.tileY = var11;
                  } else {
                     var4.hasMovementPending = false;
                     var4.move(var10, var11, Players.playerMovementSpeeds[var1]);
                  }
               } else {
                  var4.resetPath(var10, var11);
                  var4.hasMovementPending = false;
               }

               var4.plane = (byte)(var7 + var4.plane & 3);
               if (Client.localPlayerIndex == var1) {
                  TaskHandler.Client_plane = var4.plane;
               }

            }
         }
      }
   }
}
