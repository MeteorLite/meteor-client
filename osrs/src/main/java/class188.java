import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class188 {
   @ObfuscatedName("ao")
   @Export("idxCount")
   static int idxCount;
   @ObfuscatedName("gy")
   @Export("worldHost")
   static String worldHost;
   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      descriptor = "Lqv;"
   )
   static class425 field1522;
   @ObfuscatedName("te")
   @ObfuscatedSignature(
      descriptor = "Lsn;"
   )
   @Export("sceneMinimapSprite")
   static SpritePixels sceneMinimapSprite;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(II)Lhl;",
      garbageValue = "-2070840169"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.NpcDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.NpcDefinition_archive.takeFile(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.postDecode();
         NPCComposition.NpcDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lnq;B)I",
      garbageValue = "0"
   )
   @Export("compareStrings")
   public static int compareStrings(CharSequence var0, CharSequence var1, Language var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if (var5 - var7 >= var3) {
            return -1;
         }

         if (var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if (var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if (var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = IgnoreList.method2078(var9);
         var8 = IgnoreList.method2078(var10);
         var9 = class323.standardizeChar(var9, var2);
         var10 = class323.standardizeChar(var10, var2);
         if (var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if (var9 != var10) {
               return class199.lowercaseChar(var9, var2) - class199.lowercaseChar(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         if (var2 == Language.Language_FR) {
            var5 = var3 - 1 - var17;
            var6 = var4 - 1 - var17;
         } else {
            var6 = var17;
            var5 = var17;
         }

         char var11 = var0.charAt(var5);
         var12 = var1.charAt(var6);
         if (var12 != var11 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if (var12 != var11) {
               return class199.lowercaseChar(var11, var2) - class199.lowercaseChar(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if (var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if (var13 != var12) {
               return class199.lowercaseChar(var12, var2) - class199.lowercaseChar(var13, var2);
            }
         }

         return 0;
      }
   }
}
