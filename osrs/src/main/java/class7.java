import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class7 {
   @ObfuscatedName("az")
   @Export("cacheGamebuild")
   static int cacheGamebuild;
   @ObfuscatedName("if")
   @ObfuscatedSignature(
      descriptor = "Loe;"
   )
   @Export("fontBold12")
   static Font fontBold12;
   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      descriptor = "Lgc;"
   )
   @Export("mouseWheel")
   static class171 mouseWheel;
   @ObfuscatedName("aj")
   ExecutorService field13 = Executors.newSingleThreadExecutor();
   @ObfuscatedName("al")
   Future field9;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lsy;"
   )
   final Buffer field10;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lab;"
   )
   final class3 field11;

   @ObfuscatedSignature(
      descriptor = "(Lsy;Lab;)V"
   )
   public class7(Buffer var1, class3 var2) {
      this.field10 = var1;
      this.field11 = var2;
      this.method15();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-77"
   )
   public boolean method17() {
      return this.field9.isDone();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1656203797"
   )
   public void method16() {
      this.field13.shutdown();
      this.field13 = null;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)Lsy;",
      garbageValue = "2064289514"
   )
   public Buffer method13() {
      try {
         return (Buffer)this.field9.get();
      } catch (Exception var2) {
         return null;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-493851559"
   )
   void method15() {
      this.field9 = this.field13.submit(new class1(this, this.field10, this.field11));
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(II)Ljava/lang/String;",
      garbageValue = "-724726161"
   )
   @Export("addImageTag")
   static String addImageTag(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "53"
   )
   static int method14(int var0, Script var1, boolean var2) {
      if (var0 < 1000) {
         return class199.method1001(var0, var1, var2);
      } else if (var0 < 1100) {
         return class422.method2207(var0, var1, var2);
      } else if (var0 < 1200) {
         return class325.method1797(var0, var1, var2);
      } else if (var0 < 1300) {
         return Tiles.method450(var0, var1, var2);
      } else if (var0 < 1400) {
         return FriendsChat.method2096(var0, var1, var2);
      } else if (var0 < 1500) {
         return GrandExchangeOfferTotalQuantityComparator.method1858(var0, var1, var2);
      } else if (var0 < 1600) {
         return class319.method1785(var0, var1, var2);
      } else if (var0 < 1700) {
         return LoginPacket.method1545(var0, var1, var2);
      } else if (var0 < 1800) {
         return GrandExchangeOfferUnitPriceComparator.method1877(var0, var1, var2);
      } else if (var0 < 1900) {
         return SecureRandomCallable.method458(var0, var1, var2);
      } else if (var0 < 2000) {
         return NetFileRequest.method1824(var0, var1, var2);
      } else if (var0 < 2100) {
         return class422.method2207(var0, var1, var2);
      } else if (var0 < 2200) {
         return class325.method1797(var0, var1, var2);
      } else if (var0 < 2300) {
         return Tiles.method450(var0, var1, var2);
      } else if (var0 < 2400) {
         return FriendsChat.method2096(var0, var1, var2);
      } else if (var0 < 2500) {
         return GrandExchangeOfferTotalQuantityComparator.method1858(var0, var1, var2);
      } else if (var0 < 2600) {
         return class150.method783(var0, var1, var2);
      } else if (var0 < 2700) {
         return class249.method1426(var0, var1, var2);
      } else if (var0 < 2800) {
         return SoundCache.method230(var0, var1, var2);
      } else if (var0 < 2900) {
         return FontName.method2315(var0, var1, var2);
      } else if (var0 < 3000) {
         return NetFileRequest.method1824(var0, var1, var2);
      } else if (var0 < 3200) {
         return ChatChannel.method448(var0, var1, var2);
      } else if (var0 < 3300) {
         return Messages.method620(var0, var1, var2);
      } else if (var0 < 3400) {
         return class103.method601(var0, var1, var2);
      } else if (var0 < 3500) {
         return WorldMapScaleHandler.method1512(var0, var1, var2);
      } else if (var0 < 3600) {
         return MenuAction.method421(var0, var1, var2);
      } else if (var0 < 3700) {
         return UserComparator9.method666(var0, var1, var2);
      } else if (var0 < 3800) {
         return WorldMapEvent.method1513(var0, var1, var2);
      } else if (var0 < 3900) {
         return ReflectionCheck.method179(var0, var1, var2);
      } else if (var0 < 4000) {
         return Login.method430(var0, var1, var2);
      } else if (var0 < 4100) {
         return ScriptFrame.method322(var0, var1, var2);
      } else if (var0 < 4200) {
         return class351.method1888(var0, var1, var2);
      } else if (var0 < 4300) {
         return ItemLayer.method1119(var0, var1, var2);
      } else if (var0 < 5100) {
         return SoundSystem.method225(var0, var1, var2);
      } else if (var0 < 5400) {
         return class69.method414(var0, var1, var2);
      } else if (var0 < 5600) {
         return class105.method604(var0, var1, var2);
      } else if (var0 < 5700) {
         return class138.method744(var0, var1, var2);
      } else if (var0 < 6300) {
         return WorldMapIcon_1.method1325(var0, var1, var2);
      } else if (var0 < 6600) {
         return Client.method372(var0, var1, var2);
      } else if (var0 < 6700) {
         return FloorUnderlayDefinition.method985(var0, var1, var2);
      } else if (var0 < 6800) {
         return NPC.method576(var0, var1, var2);
      } else if (var0 < 6900) {
         return GrandExchangeOfferOwnWorldComparator.method344(var0, var1, var2);
      } else if (var0 < 7000) {
         return ScriptFrame.method324(var0, var1, var2);
      } else if (var0 < 7100) {
         return NPCComposition.method974(var0, var1, var2);
      } else if (var0 < 7200) {
         return class388.method2045(var0, var1, var2);
      } else if (var0 < 7300) {
         return WorldMapIcon_0.method1431(var0, var1, var2);
      } else if (var0 < 7500) {
         return class14.method54(var0, var1, var2);
      } else if (var0 < 7600) {
         return class159.method839(var0, var1, var2);
      } else {
         return var0 < 7700 ? class249.method1425(var0, var1, var2) : 2;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "16"
   )
   static final void method19() {
      Tiles.method451("You can't add yourself to your own friend list");
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(I)Lsn;",
      garbageValue = "-1526467553"
   )
   static SpritePixels method22() {
      SpritePixels var0 = new SpritePixels();
      var0.width = class492.SpriteBuffer_spriteWidth;
      var0.height = class492.SpriteBuffer_spriteHeight;
      var0.xOffset = class492.SpriteBuffer_xOffsets[0];
      var0.yOffset = Canvas.SpriteBuffer_yOffsets[0];
      var0.subWidth = InterfaceParent.SpriteBuffer_spriteWidths[0];
      var0.subHeight = class144.SpriteBuffer_spriteHeights[0];
      int var1 = var0.subHeight * var0.subWidth;
      byte[] var2 = class144.SpriteBuffer_pixels[0];
      var0.pixels = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = class181.SpriteBuffer_spritePalette[var2[var3] & 255];
      }

      FriendsList.method2086();
      return var0;
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-21"
   )
   @Export("getWindowedMode")
   static int getWindowedMode() {
      return Client.isResizable ? 2 : 1;
   }

   @ObfuscatedName("la")
   static final void method21(double var0) {
      Rasterizer3D.Rasterizer3D_setBrightness(var0);
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(var0);
      TaskHandler.method887();
      WorldMapSectionType.clientPreferences.setBrightness(var0);
   }
}
