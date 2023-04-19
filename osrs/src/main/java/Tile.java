import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("Tile")
public final class Tile extends Node {
    @ObfuscatedName("af")
    int plane;
    @ObfuscatedName("an")
    int x;
    @ObfuscatedName("aw")
    int y;
    @ObfuscatedName("ac")
    int originalPlane;
    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "Ljc;"
    )
    SceneTilePaint paint;
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Lij;"
    )
    SceneTileModel model;
    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "Ljk;"
    )
    BoundaryObject boundaryObject;
    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "Lje;"
    )
    WallDecoration wallDecoration;
    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "Lig;"
    )
    FloorDecoration floorDecoration;
    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "Liy;"
    )
    ItemLayer itemLayer;
    @ObfuscatedName("ay")
    int gameObjectsCount;
    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "[Ljj;"
    )
    GameObject[] gameObjects = new GameObject[5];
    @ObfuscatedName("ax")
    int[] gameObjectEdgeMasks = new int[5];
    @ObfuscatedName("ai")
    int gameObjectsEdgeMask = 0;
    @ObfuscatedName("ag")
    int minPlane;
    @ObfuscatedName("ah")
    boolean drawPrimary;
    @ObfuscatedName("av")
    boolean drawSecondary;
    @ObfuscatedName("ar")
    boolean drawGameObjects;
    @ObfuscatedName("am")
    int drawGameObjectEdges;
   @ObfuscatedName("as")
   int field1987;
   @ObfuscatedName("aj")
   int field1969;
   @ObfuscatedName("ak")
   int field1989;
    @ObfuscatedName("az")
    @ObfuscatedSignature(
            descriptor = "Lis;"
    )
    Tile linkedBelowTile;

   Tile(int var1, int var2, int var3) {
      this.originalPlane = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-5"
   )
   public static boolean method1214() {
      long var0 = class96.clockNow();
      int var2 = (int)(var0 - NetCache.field3509);
      NetCache.field3509 = var0;
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
                  if (Script.NetCache_currentResponse == null) {
                     var5 = 8;
                  } else if (NetCache.field3504 == 0) {
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
                     if (NetCache.field3506 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           NetCache.NetCache_responseHeaderBuffer.array[NetCache.NetCache_responseHeaderBuffer.offset + var7] ^= NetCache.field3506;
                        }
                     }

                     NetCache.NetCache_responseHeaderBuffer.offset += var6;
                     if (NetCache.NetCache_responseHeaderBuffer.offset < var5) {
                        break;
                     }

                     if (Script.NetCache_currentResponse == null) {
                        NetCache.NetCache_responseHeaderBuffer.offset = 0;
                        var7 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var8 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
                        int var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var10 = NetCache.NetCache_responseHeaderBuffer.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        NetFileRequest var13 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.get(var11);
                        NetCache.field3498 = true;
                        if (var13 == null) {
                           var13 = (NetFileRequest)NetCache.NetCache_pendingResponses.get(var11);
                           NetCache.field3498 = false;
                        }

                        if (var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0 ? 5 : 9;
                        Script.NetCache_currentResponse = var13;
                        NetCache.NetCache_responseArchiveBuffer = new Buffer(var14 + var10 + Script.NetCache_currentResponse.padding);
                        NetCache.NetCache_responseArchiveBuffer.writeByte(var9);
                        NetCache.NetCache_responseArchiveBuffer.writeInt(var10);
                        NetCache.field3504 = 8;
                        NetCache.NetCache_responseHeaderBuffer.offset = 0;
                     } else if (NetCache.field3504 == 0) {
                        if (NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
                           NetCache.field3504 = 1;
                           NetCache.NetCache_responseHeaderBuffer.offset = 0;
                        } else {
                           Script.NetCache_currentResponse = null;
                        }
                     }
                  } else {
                     var6 = NetCache.NetCache_responseArchiveBuffer.array.length - Script.NetCache_currentResponse.padding;
                     var7 = 512 - NetCache.field3504;
                     if (var7 > var6 - NetCache.NetCache_responseArchiveBuffer.offset) {
                        var7 = var6 - NetCache.NetCache_responseArchiveBuffer.offset;
                     }

                     if (var7 > var16) {
                        var7 = var16;
                     }

                     NetCache.NetCache_socket.read(NetCache.NetCache_responseArchiveBuffer.array, NetCache.NetCache_responseArchiveBuffer.offset, var7);
                     if (NetCache.field3506 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           NetCache.NetCache_responseArchiveBuffer.array[var8 + NetCache.NetCache_responseArchiveBuffer.offset] ^= NetCache.field3506;
                        }
                     }

                     NetCache.NetCache_responseArchiveBuffer.offset += var7;
                     NetCache.field3504 += var7;
                     if (var6 == NetCache.NetCache_responseArchiveBuffer.offset) {
                        if (Script.NetCache_currentResponse.key == 16711935L) {
                           Login.field764 = NetCache.NetCache_responseArchiveBuffer;

                           for(var8 = 0; var8 < 256; ++var8) {
                              Archive var17 = NetCache.NetCache_archives[var8];
                              if (var17 != null) {
                                 Login.field764.offset = var8 * 8 + 5;
                                 if (Login.field764.offset >= Login.field764.array.length) {
                                    if (!var17.field3465) {
                                       throw new RuntimeException("");
                                    }

                                    var17.method1872();
                                 } else {
                                    var10 = Login.field764.readInt();
                                    int var18 = Login.field764.readInt();
                                    var17.loadIndex(var10, var18);
                                 }
                              }
                           }
                        } else {
                           NetCache.NetCache_crc.reset();
                           NetCache.NetCache_crc.update(NetCache.NetCache_responseArchiveBuffer.array, 0, var6);
                           var8 = (int)NetCache.NetCache_crc.getValue();
                           if (var8 != Script.NetCache_currentResponse.crc) {
                              try {
                                 NetCache.NetCache_socket.close();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++NetCache.NetCache_crcMismatches;
                              NetCache.NetCache_socket = null;
                              NetCache.field3506 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           NetCache.NetCache_crcMismatches = 0;
                           NetCache.NetCache_ioExceptions = 0;
                           Script.NetCache_currentResponse.archive.write((int)(Script.NetCache_currentResponse.key & 65535L), NetCache.NetCache_responseArchiveBuffer.array, 16711680L == (Script.NetCache_currentResponse.key & 16711680L), NetCache.field3498);
                        }

                        Script.NetCache_currentResponse.remove();
                        if (NetCache.field3498) {
                           --NetCache.NetCache_pendingPriorityResponsesCount;
                        } else {
                           --NetCache.NetCache_pendingResponsesCount;
                        }

                        NetCache.field3504 = 0;
                        Script.NetCache_currentResponse = null;
                        NetCache.NetCache_responseArchiveBuffer = null;
                     } else {
                        if (NetCache.field3504 != 512) {
                           break;
                        }

                        NetCache.field3504 = 0;
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
}
