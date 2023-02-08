import java.io.EOFException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oi")
@Implements("ArchiveDisk")
public final class ArchiveDisk {
    @ObfuscatedName("f")
    static byte[] ArchiveDisk_buffer = new byte[520];
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lqp;"
    )
    BufferedFile datFile = null;
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lqp;"
    )
    BufferedFile idxFile = null;
    @ObfuscatedName("s")
    int archive;
    @ObfuscatedName("z")
    int maxEntrySize = 65000;

   @ObfuscatedSignature(
      descriptor = "(ILqp;Lqp;I)V"
   )
   public ArchiveDisk(int var1, BufferedFile var2, BufferedFile var3, int var4) {
      this.archive = var1;
      this.datFile = var2;
      this.idxFile = var3;
      this.maxEntrySize = var4;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(II)[B",
            garbageValue = "105987201"
    )
    public byte[] read(int var1) {
      BufferedFile var2 = this.datFile;
      synchronized(this.datFile) {
         try {
            Object var10000;
            if (this.idxFile.length() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.idxFile.seek((long)(var1 * 6));
               this.idxFile.read(ArchiveDisk_buffer, 0, 6);
               int var3 = ((ArchiveDisk_buffer[0] & 255) << 16) + (ArchiveDisk_buffer[2] & 255) + ((ArchiveDisk_buffer[1] & 255) << 8);
               int var4 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
               if (var3 < 0 || var3 > this.maxEntrySize) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if (var4 <= 0 || (long)var4 > this.datFile.length() / 520L) {
                  var10000 = null;
                  return (byte[])var10000;
               } else {
                  byte[] var5 = new byte[var3];
                  int var6 = 0;

                  for(int var7 = 0; var6 < var3; ++var7) {
                     if (var4 == 0) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     this.datFile.seek(520L * (long)var4);
                     int var8 = var3 - var6;
                     int var9;
                     int var10;
                     int var11;
                     int var12;
                     byte var13;
                     if (var1 > 65535) {
                        if (var8 > 510) {
                           var8 = 510;
                        }

                        var13 = 10;
                        this.datFile.read(ArchiveDisk_buffer, 0, var8 + var13);
                        var9 = ((ArchiveDisk_buffer[1] & 255) << 16) + ((ArchiveDisk_buffer[0] & 255) << 24) + (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
                        var10 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[4] & 255) << 8);
                        var11 = (ArchiveDisk_buffer[8] & 255) + ((ArchiveDisk_buffer[7] & 255) << 8) + ((ArchiveDisk_buffer[6] & 255) << 16);
                        var12 = ArchiveDisk_buffer[9] & 255;
                     } else {
                        if (var8 > 512) {
                           var8 = 512;
                        }

                        var13 = 8;
                        this.datFile.read(ArchiveDisk_buffer, 0, var8 + var13);
                        var9 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
                        var10 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
                        var11 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
                        var12 = ArchiveDisk_buffer[7] & 255;
                     }

                     if (var9 != var1 || var10 != var7 || var12 != this.archive) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     if (var11 < 0 || (long)var11 > this.datFile.length() / 520L) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     int var14 = var13 + var8;

                     for(int var15 = var13; var15 < var14; ++var15) {
                        var5[var6++] = ArchiveDisk_buffer[var15];
                     }

                     var4 = var11;
                  }

                  byte[] var20 = var5;
                  return var20;
               }
            }
         } catch (IOException var18) {
            return null;
         }
      }
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I[BIB)Z",
            garbageValue = "-11"
    )
    public boolean write(int var1, byte[] var2, int var3) {
      BufferedFile var4 = this.datFile;
      synchronized(this.datFile) {
         if (var3 >= 0 && var3 <= this.maxEntrySize) {
            boolean var5 = this.write0(var1, var2, var3, true);
            if (!var5) {
               var5 = this.write0(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException("" + this.archive + ',' + var1 + ',' + var3);
         }
      }
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(I[BIZI)Z",
            garbageValue = "1815008195"
    )
    boolean write0(int var1, byte[] var2, int var3, boolean var4) {
      BufferedFile var5 = this.datFile;
      synchronized(this.datFile) {
         try {
            int var6;
            boolean var10000;
            if (var4) {
               if (this.idxFile.length() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.idxFile.seek((long)(var1 * 6));
               this.idxFile.read(ArchiveDisk_buffer, 0, 6);
               var6 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
               if (var6 <= 0 || (long)var6 > this.datFile.length() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.datFile.length() + 519L) / 520L);
               if (var6 == 0) {
                  var6 = 1;
               }
            }

            ArchiveDisk_buffer[0] = (byte)(var3 >> 16);
            ArchiveDisk_buffer[1] = (byte)(var3 >> 8);
            ArchiveDisk_buffer[2] = (byte)var3;
            ArchiveDisk_buffer[3] = (byte)(var6 >> 16);
            ArchiveDisk_buffer[4] = (byte)(var6 >> 8);
            ArchiveDisk_buffer[5] = (byte)var6;
            this.idxFile.seek((long)(var1 * 6));
            this.idxFile.write(ArchiveDisk_buffer, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if (var7 < var3) {
                  label170: {
                     int var9 = 0;
                     int var10;
                     if (var4) {
                        this.datFile.seek((long)var6 * 520L);
                        int var11;
                        int var12;
                        if (var1 > 65535) {
                           try {
                              this.datFile.read(ArchiveDisk_buffer, 0, 10);
                           } catch (EOFException var17) {
                              break label170;
                           }

                           var10 = ((ArchiveDisk_buffer[1] & 255) << 16) + ((ArchiveDisk_buffer[0] & 255) << 24) + (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
                           var11 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[4] & 255) << 8);
                           var9 = (ArchiveDisk_buffer[8] & 255) + ((ArchiveDisk_buffer[7] & 255) << 8) + ((ArchiveDisk_buffer[6] & 255) << 16);
                           var12 = ArchiveDisk_buffer[9] & 255;
                        } else {
                           try {
                              this.datFile.read(ArchiveDisk_buffer, 0, 8);
                           } catch (EOFException var16) {
                              break label170;
                           }

                           var10 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
                           var11 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
                           var9 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
                           var12 = ArchiveDisk_buffer[7] & 255;
                        }

                        if (var10 != var1 || var11 != var8 || var12 != this.archive) {
                           var10000 = false;
                           return var10000;
                        }

                        if (var9 < 0 || (long)var9 > this.datFile.length() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if (var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.datFile.length() + 519L) / 520L);
                        if (var9 == 0) {
                           ++var9;
                        }

                        if (var9 == var6) {
                           ++var9;
                        }
                     }

                     if (var1 > 65535) {
                        if (var3 - var7 <= 510) {
                           var9 = 0;
                        }

                        ArchiveDisk_buffer[0] = (byte)(var1 >> 24);
                        ArchiveDisk_buffer[1] = (byte)(var1 >> 16);
                        ArchiveDisk_buffer[2] = (byte)(var1 >> 8);
                        ArchiveDisk_buffer[3] = (byte)var1;
                        ArchiveDisk_buffer[4] = (byte)(var8 >> 8);
                        ArchiveDisk_buffer[5] = (byte)var8;
                        ArchiveDisk_buffer[6] = (byte)(var9 >> 16);
                        ArchiveDisk_buffer[7] = (byte)(var9 >> 8);
                        ArchiveDisk_buffer[8] = (byte)var9;
                        ArchiveDisk_buffer[9] = (byte)this.archive;
                        this.datFile.seek(520L * (long)var6);
                        this.datFile.write(ArchiveDisk_buffer, 0, 10);
                        var10 = var3 - var7;
                        if (var10 > 510) {
                           var10 = 510;
                        }

                        this.datFile.write(var2, var7, var10);
                        var7 += var10;
                     } else {
                        if (var3 - var7 <= 512) {
                           var9 = 0;
                        }

                        ArchiveDisk_buffer[0] = (byte)(var1 >> 8);
                        ArchiveDisk_buffer[1] = (byte)var1;
                        ArchiveDisk_buffer[2] = (byte)(var8 >> 8);
                        ArchiveDisk_buffer[3] = (byte)var8;
                        ArchiveDisk_buffer[4] = (byte)(var9 >> 16);
                        ArchiveDisk_buffer[5] = (byte)(var9 >> 8);
                        ArchiveDisk_buffer[6] = (byte)var9;
                        ArchiveDisk_buffer[7] = (byte)this.archive;
                        this.datFile.seek((long)var6 * 520L);
                        this.datFile.write(ArchiveDisk_buffer, 0, 8);
                        var10 = var3 - var7;
                        if (var10 > 512) {
                           var10 = 512;
                        }

                        this.datFile.write(var2, var7, var10);
                        var7 += var10;
                     }

                     var6 = var9;
                     ++var8;
                     continue;
                  }
               }

               var10000 = true;
               return var10000;
            }
         } catch (IOException var18) {
            return false;
         }
      }
   }

    @ObfuscatedName("toString")
    public String toString() {
      return "" + this.archive;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZB)I",
      garbageValue = "3"
   )
   static int method2152(int var0, Script var1, boolean var2) {
      int var3;
      int var5;
      int var7;
      Object var21;
      class467 var22;
      if (var0 != 7500 && var0 != 7508) {
         if (var0 != 7501) {
            int var4;
            int var6;
            if (var0 == 7502) {
               class302.Interpreter_intStackSize -= 3;
               var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
               var6 = WorldMapLabelSize.method1319(var4);
               var7 = MidiPcmStream.method1590(var4);
               int var8 = WorldMapIcon_0.method1428(var4);
               DbRowType var23 = Ignored.getDbRowType(var3);
               DbTableType var24 = ClientPacket.getDbTableType(var6);
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
                     class463 var17 = class370.method1933(var16);
                     if (var17 == class463.field3985) {
                        Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     } else {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class370.method1934(var16);
                     }
                  }

                  return 1;
               } else {
                  var15 = var14.length / var25.length;
                  if (var5 >= 0 && var5 < var15) {
                     for(var16 = var12; var16 < var13; ++var16) {
                        int var19 = var16 + var25.length * var5;
                        class463 var18 = class370.method1933(var25[var16]);
                        if (var18 == class463.field3985) {
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = (String)var14[var19];
                        } else {
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = (Integer)var14[var19];
                        }
                     }

                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               }
            } else if (var0 == 7503) {
               class302.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
               var5 = 0;
               var6 = WorldMapLabelSize.method1319(var4);
               var7 = MidiPcmStream.method1590(var4);
               DbRowType var26 = Ignored.getDbRowType(var3);
               DbTableType var9 = ClientPacket.getDbTableType(var6);
               int[] var10 = var9.types[var7];
               Object[] var11 = var26.getColumnType(var7);
               if (var11 == null && var9.defaultValues != null) {
                  var11 = var9.defaultValues[var7];
               }

               if (var11 != null) {
                  var5 = var11.length / var10.length;
               }

               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var5;
               return 1;
            } else if (var0 != 7504 && var0 != 7510) {
               if (var0 == 7505) {
                  var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  DbRowType var28 = Ignored.getDbRowType(var3);
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var28.tableId;
                  return 1;
               } else if (var0 == 7506) {
                  var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  var4 = -1;
                  if (Skeleton.field1984 != null && var3 >= 0 && var3 < Skeleton.field1984.size()) {
                     var4 = (Integer)Skeleton.field1984.get(var3);
                  }

                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4;
                  return 1;
               } else if (var0 != 7507 && var0 != 7509) {
                  return 2;
               } else {
                  var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  var21 = Client.method374(var3);
                  var5 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  var22 = Tiles.method448(var5);
                  if (var22 == null) {
                     throw new RuntimeException();
                  } else if (WorldMapLabelSize.method1319(var5) != Client.field641) {
                     throw new RuntimeException();
                  } else if (Skeleton.field1984 == null && Skeleton.field1984.isEmpty()) {
                     throw new RuntimeException();
                  } else {
                     var7 = WorldMapIcon_0.method1428(var5);
                     List var20 = var22.method2349(var21, var7);
                     Skeleton.field1984 = new LinkedList(Skeleton.field1984);
                     if (var20 != null) {
                        Skeleton.field1984.retainAll(var20);
                     } else {
                        Skeleton.field1984.clear();
                     }

                     Canvas.field78 = Skeleton.field1984.iterator();
                     if (var0 == 7507) {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Skeleton.field1984.size();
                     }

                     return 1;
                  }
               }
            } else {
               --class302.Interpreter_intStackSize;
               var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
               class467 var27 = Clock.method910(var3);
               if (var27 == null) {
                  throw new RuntimeException();
               } else {
                  Skeleton.field1984 = var27.method2349(0, 0);
                  var5 = 0;
                  if (Skeleton.field1984 != null) {
                     Client.field641 = var3;
                     Canvas.field78 = Skeleton.field1984.iterator();
                     var5 = Skeleton.field1984.size();
                  }

                  if (var0 == 7504) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var5;
                  }

                  return 1;
               }
            }
         } else {
            if (Canvas.field78 != null && Canvas.field78.hasNext()) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = (Integer)Canvas.field78.next();
            } else {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
            }

            return 1;
         }
      } else {
         var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         var21 = Client.method374(var3);
         var5 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         var22 = Tiles.method448(var5);
         if (var22 == null) {
            throw new RuntimeException();
         } else {
            var7 = WorldMapIcon_0.method1428(var5);
            Skeleton.field1984 = var22.method2349(var21, var7);
            if (Skeleton.field1984 != null) {
               Client.field641 = WorldMapLabelSize.method1319(var5);
               Canvas.field78 = Skeleton.field1984.iterator();
               if (var0 == 7500) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Skeleton.field1984.size();
               }
            } else {
               Client.field641 = -1;
               Canvas.field78 = null;
               if (var0 == 7500) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               }
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      descriptor = "(IS)Z",
      garbageValue = "197"
   )
   static final boolean method2154(int var0) {
      if (var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuOpcodes[var0];
         if (var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
