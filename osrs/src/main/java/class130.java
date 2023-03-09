import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class130 implements class121 {
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IILip;Liz;B)Z",
      garbageValue = "-117"
   )
   static final boolean method714(int var0, int var1, RouteStrategy var2, CollisionMap var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class212.directions[var6][var7] = 99;
      class212.distances[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class212.bufferX[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class212.bufferY[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class212.bufferX[var11];
         var5 = class212.bufferY[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.xInset;
         int var14 = var5 - var3.yInset;
         if (var2.hasArrived(2, var4, var5, var3)) {
            class212.field1848 = var4;
            class83.field841 = var5;
            return true;
         }

         int var15 = class212.distances[var16][var17] + 1;
         if (var16 > 0 && class212.directions[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class212.bufferX[var18] = var4 - 1;
            class212.bufferY[var18] = var5;
            var18 = var18 + 1 & 4095;
            class212.directions[var16 - 1][var17] = 2;
            class212.distances[var16 - 1][var17] = var15;
         }

         if (var16 < 126 && class212.directions[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class212.bufferX[var18] = var4 + 1;
            class212.bufferY[var18] = var5;
            var18 = var18 + 1 & 4095;
            class212.directions[var16 + 1][var17] = 8;
            class212.distances[var16 + 1][var17] = var15;
         }

         if (var17 > 0 && class212.directions[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class212.bufferX[var18] = var4;
            class212.bufferY[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class212.directions[var16][var17 - 1] = 1;
            class212.distances[var16][var17 - 1] = var15;
         }

         if (var17 < 126 && class212.directions[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class212.bufferX[var18] = var4;
            class212.bufferY[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class212.directions[var16][var17 + 1] = 4;
            class212.distances[var16][var17 + 1] = var15;
         }

         if (var16 > 0 && var17 > 0 && class212.directions[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class212.bufferX[var18] = var4 - 1;
            class212.bufferY[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class212.directions[var16 - 1][var17 - 1] = 3;
            class212.distances[var16 - 1][var17 - 1] = var15;
         }

         if (var16 < 126 && var17 > 0 && class212.directions[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class212.bufferX[var18] = var4 + 1;
            class212.bufferY[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class212.directions[var16 + 1][var17 - 1] = 9;
            class212.distances[var16 + 1][var17 - 1] = var15;
         }

         if (var16 > 0 && var17 < 126 && class212.directions[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class212.bufferX[var18] = var4 - 1;
            class212.bufferY[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class212.directions[var16 - 1][var17 + 1] = 6;
            class212.distances[var16 - 1][var17 + 1] = var15;
         }

         if (var16 < 126 && var17 < 126 && class212.directions[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class212.bufferX[var18] = var4 + 1;
            class212.bufferY[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class212.directions[var16 + 1][var17 + 1] = 12;
            class212.distances[var16 + 1][var17 + 1] = var15;
         }
      }

      class212.field1848 = var4;
      class83.field841 = var5;
      return false;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-900441843"
   )
   @Export("ItemContainer_getCount")
   static int ItemContainer_getCount(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if (var2 == null) {
         return 0;
      } else {
         return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(I)[Lsp;",
      garbageValue = "1901804570"
   )
   static IndexedSprite[] method717() {
      IndexedSprite[] var0 = new IndexedSprite[class492.SpriteBuffer_spriteCount];

      for(int var1 = 0; var1 < class492.SpriteBuffer_spriteCount; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.width = class492.SpriteBuffer_spriteWidth;
         var2.height = class492.SpriteBuffer_spriteHeight;
         var2.xOffset = class492.SpriteBuffer_xOffsets[var1];
         var2.yOffset = Canvas.SpriteBuffer_yOffsets[var1];
         var2.subWidth = InterfaceParent.SpriteBuffer_spriteWidths[var1];
         var2.subHeight = class144.SpriteBuffer_spriteHeights[var1];
         var2.palette = class181.SpriteBuffer_spritePalette;
         var2.pixels = class144.SpriteBuffer_pixels[var1];
      }

      FriendsList.method2086();
      return var0;
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1363946201"
   )
   static final void method716(boolean var0) {
      if (var0) {
         Client.field392 = Login.field750 ? class136.field1281 : class136.field1283;
      } else {
         Client.field392 = WorldMapSectionType.clientPreferences.method539(Login.Login_username) ? class136.field1280 : class136.field1282;
      }

   }

   @ObfuscatedName("kn")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-801479046"
   )
   @Export("resumePauseWidget")
   static void resumePauseWidget(int var0, int var1) {
      PacketBufferNode var2 = UserComparator9.getPacketBufferNode(ClientPacket.CONTINUE, Client.packetWriter.isaacCipher);
      var2.packetBuffer.writeShort(var1);
      var2.packetBuffer.writeIntME(var0);
      Client.packetWriter.addNode(var2);
   }
}
