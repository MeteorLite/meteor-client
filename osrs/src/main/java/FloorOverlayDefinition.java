import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
@Implements("FloorOverlayDefinition")
public class FloorOverlayDefinition extends DualNode {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lnm;"
    )
    public static AbstractArchive FloorOverlayDefinition_archive;
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    public static EvictingDualNodeHashTable FloorOverlayDefinition_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("aw")
    public int primaryRgb = 0;
    @ObfuscatedName("ac")
    public int texture = -1;
    @ObfuscatedName("au")
    public boolean hideUnderlay = true;
    @ObfuscatedName("ab")
    public int secondaryRgb = -1;
    @ObfuscatedName("aq")
    public int hue;
    @ObfuscatedName("al")
    public int saturation;
    @ObfuscatedName("at")
    public int lightness;
    @ObfuscatedName("aa")
    public int secondaryHue;
    @ObfuscatedName("ay")
    public int secondarySaturation;
    @ObfuscatedName("ao")
    public int secondaryLightness;

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1436922747"
    )
    public void postDecode() {
      if (this.secondaryRgb != -1) {
         this.setHsl(this.secondaryRgb);
         this.secondaryHue = this.hue;
         this.secondarySaturation = this.saturation;
         this.secondaryLightness = this.lightness;
      }

      this.setHsl(this.primaryRgb);
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(Lsg;IS)V",
            garbageValue = "128"
    )
    public void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if (var3 == 0) {
            return;
         }

         this.decodeNext(var1, var3, var2);
      }
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(Lsg;IIS)V",
            garbageValue = "132"
    )
    void decodeNext(Buffer var1, int var2, int var3) {
      if (var2 == 1) {
         this.primaryRgb = var1.readMedium();
      } else if (var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if (var2 == 5) {
         this.hideUnderlay = false;
      } else if (var2 == 7) {
         this.secondaryRgb = var1.readMedium();
      } else if (var2 == 8) {
         ;
      }

   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "2082710578"
    )
    void setHsl(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if (var4 < var2) {
         var8 = var4;
      }

      if (var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if (var4 > var2) {
         var10 = var4;
      }

      if (var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if (var8 != var10) {
         if (var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if (var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if (var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if (var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if (var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
      this.saturation = (int)(var14 * 256.0D);
      this.lightness = (int)(var16 * 256.0D);
      if (this.saturation < 0) {
         this.saturation = 0;
      } else if (this.saturation > 255) {
         this.saturation = 255;
      }

      if (this.lightness < 0) {
         this.lightness = 0;
      } else if (this.lightness > 255) {
         this.lightness = 255;
      }

   }

    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            descriptor = "(Lcl;I)V",
            garbageValue = "1003171316"
    )
    static void changeWorld(World var0) {
      if (var0.isMembersOnly() != Client.isMembersWorld) {
         Client.isMembersWorld = var0.isMembersOnly();
         boolean var1 = var0.isMembersOnly();
         if (var1 != FileSystem.ItemDefinition_inMembersWorld) {
            class379.method2042();
            FileSystem.ItemDefinition_inMembersWorld = var1;
         }
      }

      if (var0.properties != Client.worldProperties) {
         Archive var3 = class452.archive8;
         int var2 = var0.properties;
         if ((var2 & 536870912) != 0) {
            Canvas.logoSprite = MusicPatchNode2.SpriteBuffer_getIndexedSpriteByName(var3, "logo_deadman_mode", "");
         } else if ((var2 & 1073741824) != 0) {
            Canvas.logoSprite = MusicPatchNode2.SpriteBuffer_getIndexedSpriteByName(var3, "logo_seasonal_mode", "");
         } else if ((var2 & 256) != 0) {
            Canvas.logoSprite = MusicPatchNode2.SpriteBuffer_getIndexedSpriteByName(var3, "logo_speedrunning", "");
         } else {
            Canvas.logoSprite = MusicPatchNode2.SpriteBuffer_getIndexedSpriteByName(var3, "logo", "");
         }
      }

      UserComparator8.worldHost = var0.host;
      Client.worldId = var0.id;
      Client.worldProperties = var0.properties;
      FriendsChat.worldPort = Client.gameBuild == 0 ? 'ꩊ' : var0.id + '鱀';
      class127.js5Port = Client.gameBuild == 0 ? 443 : var0.id + '썐';
      ItemContainer.currentPort = FriendsChat.worldPort;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZI)I",
      garbageValue = "2032974834"
   )
   static int method1121(int var0, Script var1, boolean var2) {
      return 2;
   }
}
