import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nh")
public class class382 {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lda;FB)F",
      garbageValue = "1"
   )
   static float method2028(class125 var0, float var1) {
      if (var0 == null) {
         return 0.0F;
      } else {
         float var2 = var1 - var0.field1204;
         return var2 * (var0.field1225 + (var0.field1212 * var2 + var0.field1213) * var2) + var0.field1215;
      }
   }

    @ObfuscatedName("mk")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;ZI)V",
            garbageValue = "953377843"
    )
    static void findItemDefinitions(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ItemComposition.ItemDefinition_fileCount; ++var4) {
         ItemComposition var5 = TileItem.ItemDefinition_get(var4);
         if ((!var1 || var5.isTradable) && var5.noteTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if (var3 >= 250) {
               class378.foundItemIdCount = -1;
               VarbitComposition.foundItemIds = null;
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

      VarbitComposition.foundItemIds = var2;
      WorldMapLabelSize.foundItemIndex = 0;
      class378.foundItemIdCount = var3;
      String[] var8 = new String[class378.foundItemIdCount];

      for(int var9 = 0; var9 < class378.foundItemIdCount; ++var9) {
         var8[var9] = TileItem.ItemDefinition_get(var2[var9]).name;
      }

      short[] var10 = VarbitComposition.foundItemIds;
      WorldMapCacheName.sortItemsByName(var8, var10, 0, var8.length - 1);
   }
}
