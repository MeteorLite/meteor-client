import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lq")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
    @ObfuscatedName("mi")
    @ObfuscatedSignature(
            descriptor = "Ldv;"
    )
    static Player localPlayer;
   @ObfuscatedName("af")
   int field2801;
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Llz;"
    )
    MusicPatch patch;
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lbr;"
    )
    RawSound rawSound;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Llp;"
   )
   MusicPatchNode2 field2786;
   @ObfuscatedName("au")
   int field2784;
   @ObfuscatedName("ab")
   int field2788;
   @ObfuscatedName("aq")
   int field2789;
   @ObfuscatedName("al")
   int field2790;
   @ObfuscatedName("at")
   int field2804;
   @ObfuscatedName("aa")
   int field2792;
   @ObfuscatedName("ay")
   int field2793;
   @ObfuscatedName("ao")
   int field2794;
   @ObfuscatedName("ax")
   int field2795;
   @ObfuscatedName("ai")
   int field2802;
   @ObfuscatedName("ag")
   int field2798;
   @ObfuscatedName("ah")
   int field2783;
   @ObfuscatedName("av")
   int field2799;
   @ObfuscatedName("ar")
   int field2791;
    @ObfuscatedName("am")
    @ObfuscatedSignature(
            descriptor = "Lbl;"
    )
    RawPcmStream stream;
   @ObfuscatedName("as")
   int field2796;
   @ObfuscatedName("ak")
   int field2803;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-61"
   )
   void method1679() {
      this.patch = null;
      this.rawSound = null;
      this.field2786 = null;
      this.stream = null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(IS)F",
      garbageValue = "13359"
   )
   public static float method1678(int var0) {
      var0 &= 16383;
      return (float)((double)((float)var0 / 16384.0F) * 6.283185307179586D);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1731174532"
   )
   public static boolean method1676(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

    @ObfuscatedName("iw")
    @ObfuscatedSignature(
            descriptor = "(Lmq;IIB)V",
            garbageValue = "-122"
    )
    static final void checkIfMinimapClicked(Widget var0, int var1, int var2) {
      if (Client.minimapState == 0 || Client.minimapState == 3) {
         if (!Client.isMenuOpen && (MouseHandler.MouseHandler_lastButton == 1 || !class473.mouseCam && MouseHandler.MouseHandler_lastButton == 4)) {
            SpriteMask var3 = var0.getSpriteMask(true);
            if (var3 == null) {
               return;
            }

            int var4 = MouseHandler.MouseHandler_lastPressedX - var1;
            int var5 = MouseHandler.MouseHandler_lastPressedY - var2;
            if (var3.contains(var4, var5)) {
               var4 -= var3.width / 2;
               var5 -= var3.height / 2;
               int var6 = Client.camAngleY & 2047;
               int var7 = Rasterizer3D.Rasterizer3D_sine[var6];
               int var8 = Rasterizer3D.Rasterizer3D_cosine[var6];
               int var9 = var4 * var8 + var5 * var7 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = var9 + localPlayer.x >> 7;
               int var12 = localPlayer.y - var10 >> 7;
               PacketBufferNode var13 = class330.getPacketBufferNode(ClientPacket.field2471, Client.packetWriter.isaacCipher);
               var13.packetBuffer.writeByte(18);
               var13.packetBuffer.writeShortAddLE(var12 + GameObject.baseY);
               var13.packetBuffer.writeShortLE(var11 + WorldMapData_0.baseX);
               var13.packetBuffer.writeByteSub(Client.keyHandlerInstance.getKeyPressed(82) ? (Client.keyHandlerInstance.getKeyPressed(81) ? 2 : 1) : 0);
               var13.packetBuffer.writeByte(var4);
               var13.packetBuffer.writeByte(var5);
               var13.packetBuffer.writeShort(Client.camAngleY);
               var13.packetBuffer.writeByte(57);
               var13.packetBuffer.writeByte(0);
               var13.packetBuffer.writeByte(0);
               var13.packetBuffer.writeByte(89);
               var13.packetBuffer.writeShort(localPlayer.x);
               var13.packetBuffer.writeShort(localPlayer.y);
               var13.packetBuffer.writeByte(63);
               Client.packetWriter.addNode(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

    @ObfuscatedName("nu")
    @ObfuscatedSignature(
            descriptor = "(Lmq;I)Ljava/lang/String;",
            garbageValue = "603369429"
    )
    static String Widget_getSpellActionName(Widget var0) {
      if (class195.Widget_unpackTargetMask(KeyHandler.getWidgetFlags(var0)) == 0) {
         return null;
      } else {
         return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
      }
   }
}
