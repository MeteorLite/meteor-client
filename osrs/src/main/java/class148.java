import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class148 extends class156 {
   @ObfuscatedName("aj")
   int field1327;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lgk;"
   )
   final class157 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lgk;)V"
   )
   class148(class157 var1) {
      this.this$0 = var1;
      this.field1327 = -1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "2070491057"
   )
   @Export("vmethod3238")
   void vmethod3238(Buffer var1) {
      this.field1327 = var1.readUnsignedShort();
      var1.readUnsignedByte();
      if (var1.readUnsignedByte() != 255) {
         --var1.offset;
         var1.readLong();
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lgn;B)V",
      garbageValue = "-82"
   )
   @Export("vmethod3239")
   void vmethod3239(ClanChannel var1) {
      var1.removeMember(this.field1327);
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      descriptor = "(Lrf;I)Ljava/lang/Object;",
      garbageValue = "556757847"
   )
   static Object method778(class467 var0) {
      if (var0 == null) {
         throw new IllegalStateException("popValueOfType() failure - null baseVarType");
      } else {
         switch(var0.field3946) {
         case 0:
            return Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         case 2:
            return Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
         default:
            throw new IllegalStateException("popValueOfType() failure - unsupported type");
         }
      }
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "0"
   )
   @Export("updateItemPile")
   static final void updateItemPile(int var0, int var1) {
      NodeDeque var2 = Client.groundItems[TaskHandler.Client_plane][var0][var1];
      if (var2 == null) {
         class1.scene.removeGroundItemPile(TaskHandler.Client_plane, var0, var1);
      } else {
         long var3 = -99999999L;
         TileItem var5 = null;

         TileItem var6;
         for(var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
            ItemComposition var7 = ParamComposition.ItemDefinition_get(var6.id);
            long var8 = (long)var7.price;
            if (var7.isStackable == 1) {
               var8 *= var6.quantity < Integer.MAX_VALUE ? (long)(var6.quantity + 1) : (long)var6.quantity;
            }

            if (var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if (var5 == null) {
            class1.scene.removeGroundItemPile(TaskHandler.Client_plane, var0, var1);
         } else {
            var2.addLast(var5);
            TileItem var12 = null;
            TileItem var11 = null;

            for(var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
               if (var5.id != var6.id) {
                  if (var12 == null) {
                     var12 = var6;
                  }

                  if (var12.id != var6.id && var11 == null) {
                     var11 = var6;
                  }
               }
            }

            long var9 = class103.calculateTag(var0, var1, 3, false, 0);
            class1.scene.newGroundItemPile(TaskHandler.Client_plane, var0, var1, WorldMapDecorationType.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, TaskHandler.Client_plane), var5, var9, var12, var11);
         }
      }
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      descriptor = "(ZLsq;B)V",
      garbageValue = "3"
   )
   @Export("updateNpcs")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      Client.field480 = 0;
      Client.field413 = 0;
      var1.importIndex();
      int var2 = var1.readBits(8);
      int var3;
      if (var2 < Client.npcCount) {
         for(var3 = var2; var3 < Client.npcCount; ++var3) {
            Client.field481[++Client.field480 - 1] = Client.npcIndices[var3];
         }
      }

      if (var2 > Client.npcCount) {
         throw new RuntimeException("");
      } else {
         Client.npcCount = 0;

         for(var3 = 0; var3 < var2; ++var3) {
            int var4 = Client.npcIndices[var3];
            NPC var5 = Client.npcs[var4];
            int var6 = var1.readBits(1);
            if (var6 == 0) {
               Client.npcIndices[++Client.npcCount - 1] = var4;
               var5.npcCycle = Client.cycle;
            } else {
               int var7 = var1.readBits(2);
               if (var7 == 0) {
                  Client.npcIndices[++Client.npcCount - 1] = var4;
                  var5.npcCycle = Client.cycle;
                  Client.field535[++Client.field413 - 1] = var4;
               } else {
                  int var8;
                  int var9;
                  if (var7 == 1) {
                     Client.npcIndices[++Client.npcCount - 1] = var4;
                     var5.npcCycle = Client.cycle;
                     var8 = var1.readBits(3);
                     var5.move(var8, MoveSpeed.WALK);
                     var9 = var1.readBits(1);
                     if (var9 == 1) {
                        Client.field535[++Client.field413 - 1] = var4;
                     }
                  } else if (var7 == 2) {
                     Client.npcIndices[++Client.npcCount - 1] = var4;
                     var5.npcCycle = Client.cycle;
                     if (var1.readBits(1) == 1) {
                        var8 = var1.readBits(3);
                        var5.move(var8, MoveSpeed.RUN);
                        var9 = var1.readBits(3);
                        var5.move(var9, MoveSpeed.RUN);
                     } else {
                        var8 = var1.readBits(3);
                        var5.move(var8, MoveSpeed.CRAWL);
                     }

                     var8 = var1.readBits(1);
                     if (var8 == 1) {
                        Client.field535[++Client.field413 - 1] = var4;
                     }
                  } else if (var7 == 3) {
                     Client.field481[++Client.field480 - 1] = var4;
                  }
               }
            }
         }

         class19.method78(var0, var1);
         class181.method923(var1);

         for(var2 = 0; var2 < Client.field480; ++var2) {
            var3 = Client.field481[var2];
            if (Client.npcs[var3].npcCycle != Client.cycle) {
               Client.npcs[var3].definition = null;
               Client.npcs[var3] = null;
            }
         }

         if (var1.offset != Client.packetWriter.serverPacketLength) {
            throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
         } else {
            for(var2 = 0; var2 < Client.npcCount; ++var2) {
               if (Client.npcs[Client.npcIndices[var2]] == null) {
                  throw new RuntimeException(var2 + "," + Client.npcCount);
               }
            }

         }
      }
   }
}
