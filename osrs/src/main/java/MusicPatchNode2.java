import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lp")
@Implements("MusicPatchNode2")
public class MusicPatchNode2 {
   @ObfuscatedName("af")
   byte[] field2718;
   @ObfuscatedName("an")
   byte[] field2717;
   @ObfuscatedName("aw")
   int field2719;
   @ObfuscatedName("ac")
   int field2720;
   @ObfuscatedName("au")
   int field2725;
   @ObfuscatedName("ab")
   int field2722;
   @ObfuscatedName("aq")
   int field2723;
   @ObfuscatedName("al")
   int field2724;
   @ObfuscatedName("at")
   int field2721;

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(Lnm;Ljava/lang/String;Ljava/lang/String;I)Ltc;",
            garbageValue = "1319736369"
    )
    public static IndexedSprite SpriteBuffer_getIndexedSpriteByName(AbstractArchive var0, String var1, String var2) {
      if (!var0.isValidFileName(var1, var2)) {
         return null;
      } else {
         int var3 = var0.getGroupId(var1);
         int var4 = var0.getFileId(var3, var2);
         byte[] var7 = var0.takeFile(var3, var4);
         boolean var6;
         if (var7 == null) {
            var6 = false;
         } else {
            class485.SpriteBuffer_decode(var7);
            var6 = true;
         }

         IndexedSprite var5;
         if (!var6) {
            var5 = null;
         } else {
            var5 = Strings.method1852();
         }

         return var5;
      }
   }
}
