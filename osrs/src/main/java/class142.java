import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class142 {
   @ObfuscatedName("af")
   long field1324;
   @ObfuscatedName("an")
   int field1322 = -1;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Loi;"
   )
   IterableNodeDeque field1323 = new IterableNodeDeque();

   @ObfuscatedSignature(
      descriptor = "(Lsg;)V"
   )
   public class142(Buffer var1) {
      this.method809(var1);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lsg;I)V",
      garbageValue = "-1541444446"
   )
   void method809(Buffer var1) {
      this.field1324 = var1.readLong();
      this.field1322 = var1.readInt();

      for(int var2 = var1.readUnsignedByte(); var2 != 0; var2 = var1.readUnsignedByte()) {
         Object var3;
         if (var2 == 3) {
            var3 = new class161(this);
         } else if (var2 == 1) {
            var3 = new class137(this);
         } else if (var2 == 13) {
            var3 = new class154(this);
         } else if (var2 == 4) {
            var3 = new class146(this);
         } else if (var2 == 6) {
            var3 = new class153(this);
         } else if (var2 == 5) {
            var3 = new class138(this);
         } else if (var2 == 2) {
            var3 = new class143(this);
         } else if (var2 == 7) {
            var3 = new class136(this);
         } else if (var2 == 14) {
            var3 = new class140(this);
         } else if (var2 == 8) {
            var3 = new class157(this);
         } else if (var2 == 9) {
            var3 = new class163(this);
         } else if (var2 == 10) {
            var3 = new class149(this);
         } else if (var2 == 11) {
            var3 = new class144(this);
         } else if (var2 == 12) {
            var3 = new class148(this);
         } else {
            if (var2 != 15) {
               throw new RuntimeException("");
            }

            var3 = new class158(this);
         }

         ((class139)var3).vmethod3254(var1);
         this.field1323.addFirst((Node)var3);
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lfj;B)V",
      garbageValue = "-52"
   )
   public void method807(ClanSettings var1) {
      if (this.field1324 == var1.field1370 && this.field1322 == var1.field1354) {
         for(class139 var2 = (class139)this.field1323.last(); var2 != null; var2 = (class139)this.field1323.previous()) {
            var2.vmethod3248(var1);
         }

         ++var1.field1354;
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "6"
   )
   static int getClipMidY2() {
      return Rasterizer3D.clips.field2238;
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1215119663"
   )
   static final void method810() {
      for(Projectile var0 = (Projectile)Client.projectiles.last(); var0 != null; var0 = (Projectile)Client.projectiles.previous()) {
         if (var0.plane == GameEngine.Client_plane && Client.cycle <= var0.cycleEnd) {
            if (Client.cycle >= var0.cycleStart) {
               if (var0.targetIndex > 0) {
                  NPC var1 = Client.npcs[var0.targetIndex - 1];
                  if (var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.setDestination(var1.x, var1.y, class147.getTileHeight(var1.x, var1.y, var0.plane) - var0.endHeight, Client.cycle);
                  }
               }

               if (var0.targetIndex < 0) {
                  int var2 = -var0.targetIndex - 1;
                  Player var3;
                  if (var2 == Client.localPlayerIndex) {
                     var3 = MusicPatchNode.localPlayer;
                  } else {
                     var3 = Client.players[var2];
                  }

                  if (var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.setDestination(var3.x, var3.y, class147.getTileHeight(var3.x, var3.y, var0.plane) - var0.endHeight, Client.cycle);
                  }
               }

               var0.advance(Client.field432);
               class31.scene.drawEntity(GameEngine.Client_plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.yaw, -1L, false);
            }
         } else {
            var0.remove();
         }
      }

   }

   @ObfuscatedName("kg")
   @ObfuscatedSignature(
      descriptor = "(Ldf;B)V",
      garbageValue = "76"
   )
   static void method811(NPC var0) {
      var0.field936 = var0.definition.size;
      var0.field986 = var0.definition.rotation;
      var0.walkSequence = var0.definition.walkSequence;
      var0.walkBackSequence = var0.definition.walkBackSequence;
      var0.walkLeftSequence = var0.definition.walkLeftSequence;
      var0.walkRightSequence = var0.definition.walkRightSequence;
      var0.idleSequence = var0.definition.idleSequence;
      var0.turnLeftSequence = var0.definition.turnLeftSequence;
      var0.turnRightSequence = var0.definition.turnRightSequence;
      var0.runSequence = var0.definition.runSequence;
      var0.runBackSequence = var0.definition.runBackSequence;
      var0.runLeftSequence = var0.definition.runLeftSequence;
      var0.runRightSequence = var0.definition.runRightSequence;
      var0.crawlSequence = var0.definition.crawlSequence;
      var0.crawlBackSequence = var0.definition.crawlBackSequence;
      var0.crawlLeftSequence = var0.definition.crawlLeftSequence;
      var0.crawlRightSequence = var0.definition.crawlRightSequence;
   }
}
