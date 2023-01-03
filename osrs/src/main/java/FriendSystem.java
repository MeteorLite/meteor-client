import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("FriendSystem")
public class FriendSystem {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lqi;"
   )
   final LoginType loginType;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lng;"
   )
   public final FriendsList friendsList;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lnj;"
   )
   public final IgnoreList ignoreList;
   @ObfuscatedName("f")
   int field670 = 0;

   @ObfuscatedSignature(
      descriptor = "(Lqi;)V"
   )
   FriendSystem(LoginType var1) {
      this.loginType = var1;
      this.friendsList = new FriendsList(var1);
      this.ignoreList = new IgnoreList(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "2100463332"
   )
   boolean method407() {
      return this.field670 == 2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "8"
   )
   final void method405() {
      this.field670 = 1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lqy;IB)V",
      garbageValue = "15"
   )
   final void readUpdate(Buffer var1, int var2) {
      this.friendsList.read(var1, var2);
      this.field670 = 2;
      class344.method1857();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1832627577"
   )
   final void processFriendUpdates() {
      for(class391 var1 = (class391)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (class391)this.friendsList.friendLoginUpdates.previous()) {
         if ((long)var1.field3684 < Message.clockNow() / 1000L - 5L) {
            if (var1.field3686 > 0) {
               KitDefinition.addGameMessage(5, "", var1.field3685 + " has logged in.");
            }

            if (var1.field3686 == 0) {
               KitDefinition.addGameMessage(5, "", var1.field3685 + " has logged out.");
            }

            var1.remove();
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "62"
   )
   final void clear() {
      this.field670 = 0;
      this.friendsList.clear();
      this.ignoreList.clear();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Lrp;ZI)Z",
      garbageValue = "-112378137"
   )
   final boolean isFriended(Username var1, boolean var2) {
      if (var1 == null) {
         return false;
      } else if (var1.equals(class155.localPlayer.username)) {
         return true;
      } else {
         return this.friendsList.isFriended(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lrp;B)Z",
      garbageValue = "3"
   )
   final boolean isIgnored(Username var1) {
      if (var1 == null) {
         return false;
      } else {
         return this.ignoreList.contains(var1);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "182534146"
   )
   final void addFriend(String var1) {
      if (var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if (var2.hasCleanName()) {
            if (this.friendsListIsFull()) {
               Object var10000 = null;
               String var4 = "Your friend list is full. Max of 200 for free users, and 400 for members";
               KitDefinition.addGameMessage(30, "", var4);
            } else if (class155.localPlayer.username.equals(var2)) {
               Skeleton.method1177();
            } else if (this.isFriended(var2, false)) {
               class1.method3(var1);
            } else if (this.isIgnored(var2)) {
               WorldMapDecorationType.method1765(var1);
            } else {
               PacketBufferNode var3 = class136.getPacketBufferNode(ClientPacket.field2493, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(class13.stringCp1252NullTerminatedByteSize(var1));
               var3.packetBuffer.writeStringCp1252NullTerminated(var1);
               Client.packetWriter.addNode(var3);
            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-922602942"
   )
   final boolean friendsListIsFull() {
      return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.isMembers != 1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)V",
      garbageValue = "6"
   )
   final void addIgnore(String var1) {
      if (var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if (var2.hasCleanName()) {
            StringBuilder var10000;
            String var4;
            if (this.canAddIgnore()) {
               var10000 = null;
               var4 = "Your ignore list is full. Max of 100 for free users, and 400 for members";
               KitDefinition.addGameMessage(30, "", var4);
            } else if (class155.localPlayer.username.equals(var2)) {
               class4.method6();
            } else if (this.isIgnored(var2)) {
               class317.method1768(var1);
            } else if (this.isFriended(var2, false)) {
               var10000 = new StringBuilder();
               Object var10001 = null;
               var10000 = var10000.append("Please remove ").append(var1);
               var10001 = null;
               var4 = var10000.append(" from your friend list first").toString();
               KitDefinition.addGameMessage(30, "", var4);
            } else {
               PacketBufferNode var3 = class136.getPacketBufferNode(ClientPacket.field2459, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(class13.stringCp1252NullTerminatedByteSize(var1));
               var3.packetBuffer.writeStringCp1252NullTerminated(var1);
               Client.packetWriter.addNode(var3);
            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "42588260"
   )
   final boolean canAddIgnore() {
      return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.isMembers != 1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "1809224453"
   )
   final void removeFriend(String var1) {
      if (var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if (var2.hasCleanName()) {
            if (this.friendsList.removeByUsername(var2)) {
               Client.field560 = Client.cycleCntr;
               PacketBufferNode var3 = class136.getPacketBufferNode(ClientPacket.field2534, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(class13.stringCp1252NullTerminatedByteSize(var1));
               var3.packetBuffer.writeStringCp1252NullTerminated(var1);
               Client.packetWriter.addNode(var3);
            }

            class344.method1857();
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "1971260533"
   )
   final void removeIgnore(String var1) {
      if (var1 != null) {
         Username var2 = new Username(var1, this.loginType);
         if (var2.hasCleanName()) {
            if (this.ignoreList.removeByUsername(var2)) {
               Client.field560 = Client.cycleCntr;
               PacketBufferNode var3 = class136.getPacketBufferNode(ClientPacket.field2532, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(class13.stringCp1252NullTerminatedByteSize(var1));
               var3.packetBuffer.writeStringCp1252NullTerminated(var1);
               Client.packetWriter.addNode(var3);
            }

            AbstractWorldMapData.FriendSystem_invalidateIgnoreds();
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(Lrp;I)Z",
      garbageValue = "122630394"
   )
   final boolean isFriendAndHasWorld(Username var1) {
      Friend var2 = (Friend)this.friendsList.getByUsername(var1);
      return var2 != null && var2.hasWorld();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lqx;I)V",
      garbageValue = "1486405514"
   )
   static final void method412(PacketBuffer var0) {
      int var1 = 0;
      var0.importIndex();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < Players.Players_count; ++var2) {
         var3 = Players.Players_indices[var2];
         if ((Players.field1086[var3] & 1) == 0) {
            if (var1 > 0) {
               --var1;
               Players.field1086[var3] = (byte)(Players.field1086[var3] | 2);
            } else {
               var4 = var0.readBits(1);
               if (var4 == 0) {
                  var1 = class323.method1775(var0);
                  Players.field1086[var3] = (byte)(Players.field1086[var3] | 2);
               } else {
                  class160.readPlayerUpdate(var0, var3);
               }
            }
         }
      }

      var0.exportIndex();
      if (var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.importIndex();

         for(var2 = 0; var2 < Players.Players_count; ++var2) {
            var3 = Players.Players_indices[var2];
            if ((Players.field1086[var3] & 1) != 0) {
               if (var1 > 0) {
                  --var1;
                  Players.field1086[var3] = (byte)(Players.field1086[var3] | 2);
               } else {
                  var4 = var0.readBits(1);
                  if (var4 == 0) {
                     var1 = class323.method1775(var0);
                     Players.field1086[var3] = (byte)(Players.field1086[var3] | 2);
                  } else {
                     class160.readPlayerUpdate(var0, var3);
                  }
               }
            }
         }

         var0.exportIndex();
         if (var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.importIndex();

            for(var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
               var3 = Players.Players_emptyIndices[var2];
               if ((Players.field1086[var3] & 1) != 0) {
                  if (var1 > 0) {
                     --var1;
                     Players.field1086[var3] = (byte)(Players.field1086[var3] | 2);
                  } else {
                     var4 = var0.readBits(1);
                     if (var4 == 0) {
                        var1 = class323.method1775(var0);
                        Players.field1086[var3] = (byte)(Players.field1086[var3] | 2);
                     } else if (ArchiveDiskAction.updateExternalPlayer(var0, var3)) {
                        Players.field1086[var3] = (byte)(Players.field1086[var3] | 2);
                     }
                  }
               }
            }

            var0.exportIndex();
            if (var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.importIndex();

               for(var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
                  var3 = Players.Players_emptyIndices[var2];
                  if ((Players.field1086[var3] & 1) == 0) {
                     if (var1 > 0) {
                        --var1;
                        Players.field1086[var3] = (byte)(Players.field1086[var3] | 2);
                     } else {
                        var4 = var0.readBits(1);
                        if (var4 == 0) {
                           var1 = class323.method1775(var0);
                           Players.field1086[var3] = (byte)(Players.field1086[var3] | 2);
                        } else if (ArchiveDiskAction.updateExternalPlayer(var0, var3)) {
                           Players.field1086[var3] = (byte)(Players.field1086[var3] | 2);
                        }
                     }
                  }
               }

               var0.exportIndex();
               if (var1 != 0) {
                  throw new RuntimeException();
               } else {
                  Players.Players_count = 0;
                  Players.Players_emptyIdxCount = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     Players.field1086[var2] = (byte)(Players.field1086[var2] >> 1);
                     Player var5 = Client.players[var2];
                     if (var5 != null) {
                        Players.Players_indices[++Players.Players_count - 1] = var2;
                     } else {
                        Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "([BI)Lbm;",
      garbageValue = "-457159576"
   )
   static Script newScript(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.array.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.array.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intArgumentCount = var2.readUnsignedShort();
      var1.stringArgumentCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if (var6 > 0) {
         var1.switches = var1.newIterableNodeHashTable(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableNodeHashTable var9 = new IterableNodeHashTable(var8 > 0 ? AccessFile.method2278(var8) : 1);
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var1.field792 = var2.readStringCp1252NullTerminatedOrNull();
      var1.opcodes = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.opcodes[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if (var8 == 3) {
            var1.stringOperands[var7] = var2.readStringCp1252NullTerminated();
         } else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Ldu;FZI)F",
      garbageValue = "-519959764"
   )
   static float method408(class125 var0, float var1, boolean var2) {
      float var3 = 0.0F;
      if (var0 != null && var0.method702() != 0) {
         float var4 = (float)var0.field1205[0].field1174;
         float var5 = (float)var0.field1205[var0.method702() - 1].field1174;
         float var6 = var5 - var4;
         if (0.0D == (double)var6) {
            return var0.field1205[0].field1169;
         } else {
            float var7 = 0.0F;
            if (var1 > var5) {
               var7 = (var1 - var5) / var6;
            } else {
               var7 = (var1 - var4) / var6;
            }

            double var8 = (double)((int)var7);
            float var10 = Math.abs((float)((double)var7 - var8));
            float var11 = var10 * var6;
            var8 = Math.abs(1.0D + var8);
            double var12 = var8 / 2.0D;
            double var14 = (double)((int)var12);
            var10 = (float)(var12 - var14);
            float var16;
            float var17;
            if (var2) {
               if (var0.field1203 == class124.field1197) {
                  if (0.0D != (double)var10) {
                     var11 += var4;
                  } else {
                     var11 = var5 - var11;
                  }
               } else if (var0.field1203 != class124.field1195 && var0.field1203 != class124.field1200) {
                  if (var0.field1203 == class124.field1194) {
                     var11 = var4 - var1;
                     var16 = var0.field1205[0].field1168;
                     var17 = var0.field1205[0].field1171;
                     var3 = var0.field1205[0].field1169;
                     if ((double)var16 != 0.0D) {
                        var3 -= var17 * var11 / var16;
                     }

                     return var3;
                  }
               } else {
                  var11 = var5 - var11;
               }
            } else if (var0.field1204 == class124.field1197) {
               if (0.0D != (double)var10) {
                  var11 = var5 - var11;
               } else {
                  var11 += var4;
               }
            } else if (var0.field1204 != class124.field1195 && var0.field1204 != class124.field1200) {
               if (var0.field1204 == class124.field1194) {
                  var11 = var1 - var5;
                  var16 = var0.field1205[var0.method702() - 1].field1172;
                  var17 = var0.field1205[var0.method702() - 1].field1170;
                  var3 = var0.field1205[var0.method702() - 1].field1169;
                  if (0.0D != (double)var16) {
                     var3 += var17 * var11 / var16;
                  }

                  return var3;
               }
            } else {
               var11 += var4;
            }

            var3 = FloorOverlayDefinition.method1044(var0, var11);
            float var18;
            if (var2 && var0.field1203 == class124.field1200) {
               var18 = var0.field1205[var0.method702() - 1].field1169 - var0.field1205[0].field1169;
               var3 = (float)((double)var3 - var8 * (double)var18);
            } else if (!var2 && var0.field1204 == class124.field1200) {
               var18 = var0.field1205[var0.method702() - 1].field1169 - var0.field1205[0].field1169;
               var3 = (float)((double)var3 + var8 * (double)var18);
            }

            return var3;
         }
      } else {
         return var3;
      }
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      descriptor = "(Lct;I)V",
      garbageValue = "-52634308"
   )
   static final void method413(Actor var0) {
      if (var0.field1001 != 0) {
         if (var0.targetIndex != -1) {
            Object var1 = null;
            int var2 = class200.isLargePlayerInfo ? 65536 : '耀';
            if (var0.targetIndex < var2) {
               var1 = Client.npcs[var0.targetIndex];
            } else if (var0.targetIndex >= var2) {
               var1 = Client.players[var0.targetIndex - var2];
            }

            if (var1 != null) {
               int var3 = var0.x - ((Actor)var1).x;
               int var4 = var0.y - ((Actor)var1).y;
               if (var3 != 0 || var4 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var3, (double)var4) * 325.949D) & 2047;
               }
            } else if (var0.false0) {
               var0.targetIndex = -1;
               var0.false0 = false;
            }
         }

         if (var0.movingOrientation != -1 && (var0.pathLength == 0 || var0.field991 > 0)) {
            var0.orientation = var0.movingOrientation;
            var0.movingOrientation = -1;
         }

         int var5 = var0.orientation - var0.rotation & 2047;
         if (var5 == 0 && var0.false0) {
            var0.targetIndex = -1;
            var0.false0 = false;
         }

         if (var5 != 0) {
            ++var0.field997;
            boolean var7;
            if (var5 > 1024) {
               var0.rotation -= var0.instantTurn ? var5 : var0.field1001 * -143599197 * -1951063541;
               var7 = true;
               if (var5 < var0.field1001 || var5 > 2048 - var0.field1001) {
                  var0.rotation = var0.orientation;
                  var7 = false;
               }

               if (!var0.instantTurn && var0.idleSequence == var0.movementSequence && (var0.field997 > 25 || var7)) {
                  if (var0.turnLeftSequence != -1) {
                     var0.movementSequence = var0.turnLeftSequence;
                  } else {
                     var0.movementSequence = var0.walkSequence;
                  }
               }
            } else {
               var0.rotation += var0.instantTurn ? var5 : var0.field1001 * -143599197 * -1951063541;
               var7 = true;
               if (var5 < var0.field1001 || var5 > 2048 - var0.field1001) {
                  var0.rotation = var0.orientation;
                  var7 = false;
               }

               if (!var0.instantTurn && var0.idleSequence == var0.movementSequence && (var0.field997 > 25 || var7)) {
                  if (var0.turnRightSequence != -1) {
                     var0.movementSequence = var0.turnRightSequence;
                  } else {
                     var0.movementSequence = var0.walkSequence;
                  }
               }
            }

            var0.rotation &= 2047;
            var0.instantTurn = false;
         } else {
            var0.field997 = 0;
         }

      }
   }

   @ObfuscatedName("mo")
   @ObfuscatedSignature(
      descriptor = "(Lkd;I)Z",
      garbageValue = "-1358269638"
   )
   static boolean isComponentHidden(Widget var0) {
      return var0.isHidden;
   }
}
