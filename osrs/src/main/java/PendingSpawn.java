import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
    @ObfuscatedName("af")
    int plane;
    @ObfuscatedName("an")
    int type;
    @ObfuscatedName("aw")
    int x;
    @ObfuscatedName("ac")
    int y;
    @ObfuscatedName("au")
    int objectId;
   @ObfuscatedName("ab")
   int field927;
   @ObfuscatedName("aq")
   int field922;
    @ObfuscatedName("al")
    int id;
    @ObfuscatedName("at")
    int rotation;
    @ObfuscatedName("aa")
    int objectType;
   @ObfuscatedName("ay")
   int field931;
   @ObfuscatedName("ax")
   int field928 = 31;
    @ObfuscatedName("ai")
    int startCycle = 0;
    @ObfuscatedName("ag")
    int endCycle = -1;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-9"
   )
   void method524(int var1) {
      this.field928 = var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-633273091"
   )
   boolean method525(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return (this.field928 & 1 << var1) != 0;
      } else {
         return true;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lnm;Lnm;IZI)Lio;",
      garbageValue = "-264326412"
   )
   public static Frames method523(AbstractArchive var0, AbstractArchive var1, int var2, boolean var3) {
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
