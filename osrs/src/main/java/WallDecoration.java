import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("WallDecoration")
public final class WallDecoration {
   @ObfuscatedName("bz")
   static int field2226;
   @ObfuscatedName("h")
   @Export("z")
   int z;
   @ObfuscatedName("e")
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @Export("y")
   int y;
   @ObfuscatedName("x")
   @Export("orientation")
   int orientation;
   @ObfuscatedName("m")
   @Export("orientation2")
   int orientation2;
   @ObfuscatedName("q")
   @Export("xOffset")
   int xOffset;
   @ObfuscatedName("f")
   @Export("yOffset")
   int yOffset;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("b")
   @Export("tag")
   public long tag = 0L;
   @ObfuscatedName("j")
   @Export("flags")
   int flags = 0;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1929783827"
   )
   public static boolean method1297() {
      long var0 = Message.method344();
      int var2 = (int)(var0 - NetCache.field3468);
      NetCache.field3468 = var0;
      if (var2 > 200) {
         var2 = 200;
      }

      NetCache.NetCache_loadTime += var2;
      if (NetCache.NetCache_pendingResponsesCount == 0 && NetCache.NetCache_pendingPriorityResponsesCount == 0 && NetCache.NetCache_pendingWritesCount == 0 && NetCache.NetCache_pendingPriorityWritesCount == 0) {
         return true;
      } else if (NetCache.NetCache_socket == null) {
         return false;
      } else {
         try {
            if (NetCache.NetCache_loadTime > 30000) {
               throw new IOException();
            } else {
               NetFileRequest var3;
               Buffer var4;
               while(NetCache.NetCache_pendingPriorityResponsesCount < 200 && NetCache.NetCache_pendingPriorityWritesCount > 0) {
                  var3 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.first();
                  var4 = new Buffer(4);
                  var4.writeByte(1);
                  var4.writeMedium((int)var3.key);
                  NetCache.NetCache_socket.write(var4.array, 0, 4);
                  NetCache.NetCache_pendingPriorityResponses.put(var3, var3.key);
                  --NetCache.NetCache_pendingPriorityWritesCount;
                  ++NetCache.NetCache_pendingPriorityResponsesCount;
               }

               while(NetCache.NetCache_pendingResponsesCount < 200 && NetCache.NetCache_pendingWritesCount > 0) {
                  var3 = (NetFileRequest)NetCache.NetCache_pendingWritesQueue.removeLast();
                  var4 = new Buffer(4);
                  var4.writeByte(0);
                  var4.writeMedium((int)var3.key);
                  NetCache.NetCache_socket.write(var4.array, 0, 4);
                  var3.removeDual();
                  NetCache.NetCache_pendingResponses.put(var3, var3.key);
                  --NetCache.NetCache_pendingWritesCount;
                  ++NetCache.NetCache_pendingResponsesCount;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = NetCache.NetCache_socket.available();
                  if (var16 < 0) {
                     throw new IOException();
                  }

                  if (var16 == 0) {
                     break;
                  }

                  NetCache.NetCache_loadTime = 0;
                  byte var5 = 0;
                  if (NewShit.NetCache_currentResponse == null) {
                     var5 = 8;
                  } else if (NetCache.field3466 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if (var5 > 0) {
                     var6 = var5 - NetCache.NetCache_responseHeaderBuffer.offset;
                     if (var6 > var16) {
                        var6 = var16;
                     }

                     NetCache.NetCache_socket.read(NetCache.NetCache_responseHeaderBuffer.array, NetCache.NetCache_responseHeaderBuffer.offset, var6);
                     if (NetCache.field3481 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           NetCache.NetCache_responseHeaderBuffer.array[NetCache.NetCache_responseHeaderBuffer.offset + var7] ^= NetCache.field3481;
                        }
                     }

                     NetCache.NetCache_responseHeaderBuffer.offset += var6;
                     if (NetCache.NetCache_responseHeaderBuffer.offset < var5) {
                        break;
                     }

                     if (NewShit.NetCache_currentResponse == null) {
                        NetCache.NetCache_responseHeaderBuffer.offset = 0;
                        var7 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var8 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
                        int var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var10 = NetCache.NetCache_responseHeaderBuffer.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        NetFileRequest var13 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var11);
                        class157.field1395 = true;
                        if (var13 == null) {
                           var13 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var11);
                           class157.field1395 = false;
                        }

                        if (var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0 ? 5 : 9;
                        NewShit.NetCache_currentResponse = var13;
                        ModeWhere.NetCache_responseArchiveBuffer = new Buffer(var10 + var14 + NewShit.NetCache_currentResponse.padding);
                        ModeWhere.NetCache_responseArchiveBuffer.writeByte(var9);
                        ModeWhere.NetCache_responseArchiveBuffer.writeInt(var10);
                        NetCache.field3466 = 8;
                        NetCache.NetCache_responseHeaderBuffer.offset = 0;
                     } else if (NetCache.field3466 == 0) {
                        if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
                           NetCache.field3466 = 1;
                           NetCache.NetCache_responseHeaderBuffer.offset = 0;
                        } else {
                           NewShit.NetCache_currentResponse = null;
                        }
                     }
                  } else {
                     var6 = ModeWhere.NetCache_responseArchiveBuffer.array.length - NewShit.NetCache_currentResponse.padding;
                     var7 = 512 - NetCache.field3466;
                     if (var7 > var6 - ModeWhere.NetCache_responseArchiveBuffer.offset) {
                        var7 = var6 - ModeWhere.NetCache_responseArchiveBuffer.offset;
                     }

                     if (var7 > var16) {
                        var7 = var16;
                     }

                     NetCache.NetCache_socket.read(ModeWhere.NetCache_responseArchiveBuffer.array, ModeWhere.NetCache_responseArchiveBuffer.offset, var7);
                     if (NetCache.field3481 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           ModeWhere.NetCache_responseArchiveBuffer.array[ModeWhere.NetCache_responseArchiveBuffer.offset + var8] ^= NetCache.field3481;
                        }
                     }

                     ModeWhere.NetCache_responseArchiveBuffer.offset += var7;
                     NetCache.field3466 += var7;
                     if (var6 == ModeWhere.NetCache_responseArchiveBuffer.offset) {
                        if (NewShit.NetCache_currentResponse.key == 16711935L) {
                           class169.field1440 = ModeWhere.NetCache_responseArchiveBuffer;

                           for(var8 = 0; var8 < 256; ++var8) {
                              Archive var17 = NetCache.NetCache_archives[var8];
                              if (var17 != null) {
                                 class169.field1440.offset = var8 * 8 + 5;
                                 if (class169.field1440.offset >= class169.field1440.array.length) {
                                    if (!var17.field3445) {
                                       throw new RuntimeException("");
                                    }

                                    var17.method1785();
                                 } else {
                                    var10 = class169.field1440.readInt();
                                    int var18 = class169.field1440.readInt();
                                    var17.loadIndex(var10, var18);
                                 }
                              }
                           }
                        } else {
                           NetCache.NetCache_crc.reset();
                           NetCache.NetCache_crc.update(ModeWhere.NetCache_responseArchiveBuffer.array, 0, var6);
                           var8 = (int)NetCache.NetCache_crc.getValue();
                           if (var8 != NewShit.NetCache_currentResponse.crc) {
                              try {
                                 NetCache.NetCache_socket.close();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++NetCache.NetCache_crcMismatches;
                              NetCache.NetCache_socket = null;
                              NetCache.field3481 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           NetCache.NetCache_crcMismatches = 0;
                           NetCache.NetCache_ioExceptions = 0;
                           NewShit.NetCache_currentResponse.archive.write((int)(NewShit.NetCache_currentResponse.key & 65535L), ModeWhere.NetCache_responseArchiveBuffer.array, 16711680L == (NewShit.NetCache_currentResponse.key & 16711680L), class157.field1395);
                        }

                        NewShit.NetCache_currentResponse.remove();
                        if (class157.field1395) {
                           --NetCache.NetCache_pendingPriorityResponsesCount;
                        } else {
                           --NetCache.NetCache_pendingResponsesCount;
                        }

                        NetCache.field3466 = 0;
                        NewShit.NetCache_currentResponse = null;
                        ModeWhere.NetCache_responseArchiveBuffer = null;
                     } else {
                        if (NetCache.field3466 != 512) {
                           break;
                        }

                        NetCache.field3466 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               NetCache.NetCache_socket.close();
            } catch (Exception var19) {
               ;
            }

            ++NetCache.NetCache_ioExceptions;
            NetCache.NetCache_socket = null;
            return false;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lmb;I)I",
      garbageValue = "643814592"
   )
   @Export("compareStrings")
   public static int compareStrings(CharSequence var0, CharSequence var1, Language var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if (var5 - var7 >= var3) {
            return -1;
         }

         if (var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if (var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if (var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = WorldMapIcon_1.method1316(var9);
         var8 = WorldMapIcon_1.method1316(var10);
         var9 = class168.standardizeChar(var9, var2);
         var10 = class168.standardizeChar(var10, var2);
         if (var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if (var10 != var9) {
               return WorldMapLabel.lowercaseChar(var9, var2) - WorldMapLabel.lowercaseChar(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         if (var2 == Language.Language_FR) {
            var5 = var3 - 1 - var17;
            var6 = var4 - 1 - var17;
         } else {
            var6 = var17;
            var5 = var17;
         }

         char var11 = var0.charAt(var5);
         var12 = var1.charAt(var6);
         if (var11 != var12 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if (var12 != var11) {
               return WorldMapLabel.lowercaseChar(var11, var2) - WorldMapLabel.lowercaseChar(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if (var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if (var12 != var13) {
               return WorldMapLabel.lowercaseChar(var12, var2) - WorldMapLabel.lowercaseChar(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "-81"
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "65280"
   )
   public static void method1295() {
      HealthBarDefinition.HealthBarDefinition_cached.clear();
      HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZB)I",
      garbageValue = "84"
   )
   static int method1294(int var0, Script var1, boolean var2) {
      if (var0 == 5630) {
         Client.logoutTimer = 250;
         return 1;
      } else {
         return 2;
      }
   }
}
