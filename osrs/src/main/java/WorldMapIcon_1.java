import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("WorldMapIcon_1")
public class WorldMapIcon_1 extends AbstractWorldMapIcon {
   @ObfuscatedName("aj")
   @Export("objectDefId")
   final int objectDefId;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lja;"
   )
   @Export("region")
   final WorldMapRegion region;
   @ObfuscatedName("ac")
   @Export("element")
   int element;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Ljb;"
   )
   @Export("label")
   WorldMapLabel label;
   @ObfuscatedName("an")
   @Export("subWidth")
   int subWidth;
   @ObfuscatedName("ao")
   @Export("subHeight")
   int subHeight;

   @ObfuscatedSignature(
      descriptor = "(Llt;Llt;ILja;)V"
   )
   WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
      super(var1, var2);
      this.objectDefId = var3;
      this.region = var4;
      this.init();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "783728307"
   )
   @Export("init")
   void init() {
      this.element = WallDecoration.getObjectDefinition(this.objectDefId).transform().mapIconId;
      this.label = this.region.createMapLabel(class123.WorldMapElement_get(this.element));
      WorldMapElement var1 = class123.WorldMapElement_get(this.getElement());
      SpritePixels var2 = var1.getSpriteBool(false);
      if (var2 != null) {
         this.subWidth = var2.subWidth;
         this.subHeight = var2.subHeight;
      } else {
         this.subWidth = 0;
         this.subHeight = 0;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-81"
   )
   @Export("getElement")
   public int getElement() {
      return this.element;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)Ljb;",
      garbageValue = "-166366580"
   )
   @Export("getLabel")
   WorldMapLabel getLabel() {
      return this.label;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "638535000"
   )
   @Export("getSubWidth")
   int getSubWidth() {
      return this.subWidth;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "36"
   )
   @Export("getSubHeight")
   int getSubHeight() {
      return this.subHeight;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZI)I",
      garbageValue = "-488125464"
   )
   static int method1325(int var0, Script var1, boolean var2) {
      if (var0 == 6200) {
         Interpreter.Interpreter_intStackSize -= 2;
         Client.field418 = (short)class102.method597(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
         if (Client.field418 <= 0) {
            Client.field418 = 256;
         }

         Client.field616 = (short)class102.method597(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
         if (Client.field616 <= 0) {
            Client.field616 = 256;
         }

         return 1;
      } else if (var0 == 6201) {
         Interpreter.Interpreter_intStackSize -= 2;
         Client.zoomHeight = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         if (Client.zoomHeight <= 0) {
            Client.zoomHeight = 256;
         }

         Client.zoomWidth = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         if (Client.zoomWidth <= 0) {
            Client.zoomWidth = 320;
         }

         return 1;
      } else if (var0 == 6202) {
         Interpreter.Interpreter_intStackSize -= 4;
         Client.field619 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         if (Client.field619 <= 0) {
            Client.field619 = 1;
         }

         Client.field620 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         if (Client.field620 <= 0) {
            Client.field620 = 32767;
         } else if (Client.field620 < Client.field619) {
            Client.field620 = Client.field619;
         }

         Client.field621 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         if (Client.field621 <= 0) {
            Client.field621 = 1;
         }

         Client.field622 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         if (Client.field622 <= 0) {
            Client.field622 = 32767;
         } else if (Client.field622 < Client.field621) {
            Client.field622 = Client.field621;
         }

         return 1;
      } else if (var0 == 6203) {
         if (Client.viewportWidget != null) {
            Language.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.viewportWidth;
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.viewportHeight;
         } else {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
         }

         return 1;
      } else if (var0 == 6204) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.zoomHeight;
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.zoomWidth;
         return 1;
      } else if (var0 == 6205) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class87.method473(Client.field418);
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class87.method473(Client.field616);
         return 1;
      } else if (var0 == 6220) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
         return 1;
      } else if (var0 == 6221) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
         return 1;
      } else if (var0 == 6222) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GameEngine.canvasWidth;
         return 1;
      } else if (var0 == 6223) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class143.canvasHeight;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ks")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIB)V",
      garbageValue = "-61"
   )
   static final void method1319(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = var2 - var0;
      int var7 = var3 - var1;
      int var8 = var6 >= 0 ? var6 : -var6;
      int var9 = var7 >= 0 ? var7 : -var7;
      int var10 = var8;
      if (var8 < var9) {
         var10 = var9;
      }

      if (var10 != 0) {
         int var11 = (var6 << 16) / var10;
         int var12 = (var7 << 16) / var10;
         if (var12 <= var11) {
            var11 = -var11;
         } else {
            var12 = -var12;
         }

         int var13 = var5 * var12 >> 17;
         int var14 = var5 * var12 + 1 >> 17;
         int var15 = var5 * var11 >> 17;
         int var16 = var5 * var11 + 1 >> 17;
         var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
         var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
         int var17 = var0 + var13;
         int var18 = var0 - var14;
         int var19 = var0 + var6 - var14;
         int var20 = var0 + var6 + var13;
         int var21 = var15 + var1;
         int var22 = var1 - var16;
         int var23 = var7 + var1 - var16;
         int var24 = var15 + var7 + var1;
         Rasterizer3D.method1174(var17, var18, var19);
         Rasterizer3D.method1155(var21, var22, var23, var17, var18, var19, var4);
         Rasterizer3D.method1174(var17, var19, var20);
         Rasterizer3D.method1155(var21, var23, var24, var17, var19, var20, var4);
      }
   }
}
