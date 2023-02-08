import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("WorldMapIcon_0")
public class WorldMapIcon_0 extends AbstractWorldMapIcon {
    @ObfuscatedName("od")
    static int selectedItemSlot;
    @ObfuscatedName("f")
    final int element;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lil;"
    )
    final WorldMapLabel label;
    @ObfuscatedName("v")
    final int subWidth;
    @ObfuscatedName("s")
    final int subHeight;

   @ObfuscatedSignature(
      descriptor = "(Lko;Lko;ILil;)V"
   )
   WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
      super(var1, var2);
      this.element = var3;
      this.label = var4;
      WorldMapElement var5 = class4.WorldMapElement_get(this.getElement());
      SpritePixels var6 = var5.getSpriteBool(false);
      if (var6 != null) {
         this.subWidth = var6.subWidth;
         this.subHeight = var6.subHeight;
      } else {
         this.subWidth = 0;
         this.subHeight = 0;
      }

   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "1964880024"
    )
    public int getElement() {
      return this.element;
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(I)Lil;",
            garbageValue = "-1317041670"
    )
    WorldMapLabel getLabel() {
      return this.label;
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "7"
    )
    int getSubWidth() {
      return this.subWidth;
   }

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "1769700454"
    )
    int getSubHeight() {
      return this.subHeight;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lln;I)V",
      garbageValue = "-1549197642"
   )
   public static void method1427(AbstractArchive var0) {
      VarpDefinition.VarpDefinition_archive = var0;
      VarpDefinition.field1471 = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-12"
   )
   public static void method1425() {
      while(true) {
         NodeDeque var1 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
         ArchiveDiskAction var0;
         synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
            var0 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.removeLast();
         }

         if (var0 == null) {
            return;
         }

         var0.archive.load(var0.archiveDisk, (int)var0.key, var0.data, false);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-1016590193"
   )
   public static int method1428(int var0) {
      return (var0 & class469.field3999) - 1;
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;B)V",
      garbageValue = "-90"
   )
   static void method1426(int var0, String var1) {
      int var2 = Players.Players_count;
      int[] var3 = Players.Players_indices;
      boolean var4 = false;
      Username var5 = new Username(var1, WorldMapCacheName.loginType);

      for(int var6 = 0; var6 < var2; ++var6) {
         Player var7 = Client.players[var3[var6]];
         if (var7 != null && var7 != class387.localPlayer && var7.username != null && var7.username.equals(var5)) {
            PacketBufferNode var8;
            if (var0 == 1) {
               var8 = Renderable.getPacketBufferNode(ClientPacket.field2450, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeShortLEA(var3[var6]);
               var8.packetBuffer.writeByteA(0);
               Client.packetWriter.addNode(var8);
            } else if (var0 == 4) {
               var8 = Renderable.getPacketBufferNode(ClientPacket.field2517, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeShort(var3[var6]);
               var8.packetBuffer.writeByteS(0);
               Client.packetWriter.addNode(var8);
            } else if (var0 == 6) {
               var8 = Renderable.getPacketBufferNode(ClientPacket.field2478, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeByteS(0);
               var8.packetBuffer.writeShort(var3[var6]);
               Client.packetWriter.addNode(var8);
            } else if (var0 == 7) {
               var8 = Renderable.getPacketBufferNode(ClientPacket.field2438, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeShortLEA(var3[var6]);
               var8.packetBuffer.method2399(0);
               Client.packetWriter.addNode(var8);
            }

            var4 = true;
            break;
         }
      }

      if (!var4) {
         ZoneOperation.addGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
