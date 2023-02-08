import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("ScriptFrame")
public class ScriptFrame {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "Lfm;"
   )
   static ClanChannel field347;
    @ObfuscatedName("fi")
    @ObfuscatedSignature(
            descriptor = "Lor;"
    )
    static GraphicsDefaults spriteIds;
   @ObfuscatedName("ih")
   static int field343;
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lba;"
    )
    Script script;
    @ObfuscatedName("w")
    int pc = -1;
    @ObfuscatedName("v")
    int[] intLocals;
    @ObfuscatedName("s")
    String[] stringLocals;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(Lda;FFFFFFFFS)V",
      garbageValue = "19659"
   )
   static void method321(class125 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var0 != null) {
         var0.field1204 = var1;
         float var9 = var4 - var1;
         float var10 = var8 - var5;
         float var11 = var2 - var1;
         float var12 = 0.0F;
         float var13 = 0.0F;
         if (0.0D != (double)var11) {
            var12 = (var6 - var5) / var11;
         }

         var11 = var4 - var3;
         if (0.0D != (double)var11) {
            var13 = (var8 - var7) / var11;
         }

         float var14 = 1.0F / (var9 * var9);
         float var15 = var12 * var9;
         float var16 = var9 * var13;
         var0.field1212 = (var16 + var15 - var10 - var10) * var14 / var9;
         var0.field1213 = (var10 + var10 + var10 - var15 - var15 - var16) * var14;
         var0.field1225 = var12;
         var0.field1215 = var5;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(Lln;Lln;Ljava/lang/String;Ljava/lang/String;I)Lnv;",
      garbageValue = "1624400192"
   )
   public static Font method318(AbstractArchive var0, AbstractArchive var1, String var2, String var3) {
      int var4 = var0.getGroupId(var2);
      int var5 = var0.getFileId(var4, var3);
      return class33.method129(var0, var1, var4, var5);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "-2085800684"
   )
   static int method320(int var0, Script var1, boolean var2) {
      Widget var3;
      if (var0 >= 2000) {
         var0 -= 1000;
         var3 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
      } else {
         var3 = var2 ? Interpreter.scriptDotWidget : class85.scriptActiveWidget;
      }

      LoginScreenAnimation.invalidateWidget(var3);
      if (var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if (var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            return 1;
         } else if (var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class387.localPlayer.appearance.getChatHeadId();
            return 1;
         } else {
            return 2;
         }
      } else {
         class302.Interpreter_intStackSize -= 2;
         int var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
         int var5 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = TileItem.ItemDefinition_get(var4);
         var3.modelAngleX = var6.xan2d;
         var3.modelAngleY = var6.yan2d;
         var3.modelAngleZ = var6.zan2d;
         var3.modelOffsetX = var6.offsetX2d;
         var3.modelOffsetY = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if (var0 == 1205) {
            var3.itemQuantityMode = 0;
         } else if (var0 == 1212 | 1 == var6.isStackable) {
            var3.itemQuantityMode = 1;
         } else {
            var3.itemQuantityMode = 2;
         }

         if (var3.modelRotation > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.modelRotation;
         } else if (var3.rawWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
         }

         return 1;
      }
   }

    @ObfuscatedName("gc")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;I)V",
            garbageValue = "2147483647"
    )
    static final void doCheat(String var0) {
      if (var0.equalsIgnoreCase("toggleroof")) {
         PacketWriter.clientPreferences.setRoofsHidden(!PacketWriter.clientPreferences.getRoofsHidden());
         if (PacketWriter.clientPreferences.getRoofsHidden()) {
            ZoneOperation.addGameMessage(99, "", "Roofs are now all hidden");
         } else {
            ZoneOperation.addGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if (var0.equalsIgnoreCase("displayfps")) {
         PacketWriter.clientPreferences.method525();
      }

      if (var0.equalsIgnoreCase("renderself")) {
         Client.renderSelf = !Client.renderSelf;
      }

      if (var0.equalsIgnoreCase("mouseovertext")) {
         Client.showMouseOverText = !Client.showMouseOverText;
      }

      if (Client.staffModLevel >= 2) {
         if (var0.equalsIgnoreCase("errortest")) {
            throw new RuntimeException();
         }

         if (var0.equalsIgnoreCase("showcoord")) {
            GrandExchangeOfferUnitPriceComparator.worldMap.showCoord = !GrandExchangeOfferUnitPriceComparator.worldMap.showCoord;
         }

         if (var0.equalsIgnoreCase("fpson")) {
            PacketWriter.clientPreferences.method524(true);
         }

         if (var0.equalsIgnoreCase("fpsoff")) {
            PacketWriter.clientPreferences.method524(false);
         }

         if (var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if (var0.equalsIgnoreCase("clientdrop")) {
            WorldMapManager.method1404();
         }
      }

      PacketBufferNode var1 = Renderable.getPacketBufferNode(ClientPacket.field2459, Client.packetWriter.isaacCipher);
      var1.packetBuffer.writeByte(var0.length() + 1);
      var1.packetBuffer.writeStringCp1252NullTerminated(var0);
      Client.packetWriter.addNode(var1);
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-834303604"
   )
   static void method322() {
      Client.menuOptionsCount = 0;
      Client.isMenuOpen = false;
   }
}
