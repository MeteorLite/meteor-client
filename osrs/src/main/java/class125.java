import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public enum class125 implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lej;"
   )
   field1194(0, 0),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lej;"
   )
   field1193(1, 1),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lej;"
   )
   field1189(2, 2),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lej;"
   )
   field1188(3, 3),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lej;"
   )
   field1190(4, 4);

   @ObfuscatedName("ao")
   final int field1191;
   @ObfuscatedName("av")
   final int field1192;

   class125(int var3, int var4) {
      this.field1191 = var3;
      this.field1192 = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field1192;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lne;Lne;IZI)Liw;",
      garbageValue = "-1427479421"
   )
   public static Frames method692(AbstractArchive var0, AbstractArchive var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.getGroupFileIds(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.getFile(var2, var5[var6]);
         if (var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if (var3) {
               var9 = var1.getFile(0, var8);
            } else {
               var9 = var1.getFile(var8, 0);
            }

            if (var9 == null) {
               var4 = false;
            }
         }
      }

      if (!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }
}
