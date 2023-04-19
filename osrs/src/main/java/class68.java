import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class68 {
   @ObfuscatedName("au")
   static final BigInteger field717 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("ab")
   static final BigInteger field716 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lnm;III)[Ltc;",
      garbageValue = "-973800610"
   )
   public static IndexedSprite[] method434(AbstractArchive var0, int var1, int var2) {
      byte[] var4 = var0.takeFile(var1, var2);
      boolean var3;
      if (var4 == null) {
         var3 = false;
      } else {
         class485.SpriteBuffer_decode(var4);
         var3 = true;
      }

      if (!var3) {
         return null;
      } else {
         IndexedSprite[] var5 = new IndexedSprite[class503.SpriteBuffer_spriteCount];

         for(int var6 = 0; var6 < class503.SpriteBuffer_spriteCount; ++var6) {
            IndexedSprite var7 = var5[var6] = new IndexedSprite();
            var7.width = class503.SpriteBuffer_spriteWidth;
            var7.height = class503.SpriteBuffer_spriteHeight;
            var7.xOffset = class503.SpriteBuffer_xOffsets[var6];
            var7.yOffset = class17.SpriteBuffer_yOffsets[var6];
            var7.subWidth = class97.SpriteBuffer_spriteWidths[var6];
            var7.subHeight = class138.SpriteBuffer_spriteHeights[var6];
            var7.palette = class394.SpriteBuffer_spritePalette;
            var7.pixels = VarbitComposition.SpriteBuffer_pixels[var6];
         }

         class398.method2125();
         return var5;
      }
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(Lmq;IIII)V",
            garbageValue = "-635612095"
    )
    static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
      if (var0.field2936 == null) {
         throw new RuntimeException();
      } else {
         var0.field2936[var1] = var2;
         var0.field2977[var1] = var3;
      }
   }

    @ObfuscatedName("nf")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;ZS)V",
            garbageValue = "255"
    )
    static void findItemDefinitions(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < MouseRecorder.ItemDefinition_fileCount; ++var4) {
         ItemComposition var5 = HealthBarUpdate.ItemDefinition_get(var4);
         if ((!var1 || var5.isTradable) && var5.noteTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if (var3 >= 250) {
               class264.foundItemIdCount = -1;
               class399.foundItemIds = null;
               return;
            }

            if (var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class399.foundItemIds = var2;
      FontName.foundItemIndex = 0;
      class264.foundItemIdCount = var3;
      String[] var8 = new String[class264.foundItemIdCount];

      for(int var9 = 0; var9 < class264.foundItemIdCount; ++var9) {
         var8[var9] = HealthBarUpdate.ItemDefinition_get(var2[var9]).name;
      }

      GrandExchangeOffer.method1930(var8, class399.foundItemIds);
   }
}
