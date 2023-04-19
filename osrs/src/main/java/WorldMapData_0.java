import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("WorldMapData_0")
public class WorldMapData_0 extends AbstractWorldMapData {
    @ObfuscatedName("ib")
    static int baseX;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "-1901491736"
    )
    void init(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if (var2 != WorldMapID.field2418.value) {
         throw new IllegalStateException("");
      } else {
         super.minPlane = var1.readUnsignedByte();
         super.planes = var1.readUnsignedByte();
         super.regionXLow = var1.readUnsignedShort();
         super.regionYLow = var1.readUnsignedShort();
         super.regionX = var1.readUnsignedShort();
         super.regionY = var1.readUnsignedShort();
         super.groupId = var1.method2516();
         super.fileId = var1.method2516();
      }
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lsg;S)V",
            garbageValue = "2348"
    )
    void readGeography(Buffer var1) {
      super.planes = Math.min(super.planes, 4);
      super.floorUnderlayIds = new short[1][64][64];
      super.floorOverlayIds = new short[super.planes][64][64];
      super.field2390 = new byte[super.planes][64][64];
      super.field2396 = new byte[super.planes][64][64];
      super.decorations = new WorldMapDecoration[super.planes][64][64][];
      int var2 = var1.readUnsignedByte();
      if (var2 != class262.field2414.value) {
         throw new IllegalStateException("");
      } else {
         int var3 = var1.readUnsignedByte();
         int var4 = var1.readUnsignedByte();
         if (var3 == super.regionX && var4 == super.regionY) {
            for(int var5 = 0; var5 < 64; ++var5) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  this.readTile(var5, var6, var1);
               }
            }

         } else {
            throw new IllegalStateException("");
         }
      }
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      if (!(var1 instanceof WorldMapData_0)) {
         return false;
      } else {
         WorldMapData_0 var2 = (WorldMapData_0)var1;
         return var2.regionX == super.regionX && var2.regionY == super.regionY;
      }
   }

    @ObfuscatedName("hashCode")
    public int hashCode() {
      return super.regionX | super.regionY << 8;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "-99"
   )
   static int method1389(int var0) {
      return var0 * 3 + 600;
   }

    @ObfuscatedName("nr")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "1629805896"
    )
    static final void Clan_leaveChat() {
      PacketBufferNode var0 = class330.getPacketBufferNode(ClientPacket.field2508, Client.packetWriter.isaacCipher);
      var0.packetBuffer.writeByte(0);
      Client.packetWriter.addNode(var0);
   }
}
