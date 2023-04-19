import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qf")
public enum class428 implements class356 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lqf;"
   )
   field3815(1, 1),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lqf;"
   )
   field3817(2, 2),
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lqf;"
   )
   field3816(0, 3),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lqf;"
   )
   field3814(3, 10);

   @ObfuscatedName("au")
   final int field3818;
   @ObfuscatedName("ab")
   final int field3819;

   class428(int var3, int var4) {
      this.field3818 = var3;
      this.field3819 = var4;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.field3819;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(Lit;IIIIB)Z",
      garbageValue = "11"
   )
   static final boolean method2272(Model var0, int var1, int var2, int var3, int var4) {
      boolean var5 = ViewportMouse.ViewportMouse_isInViewport;
      if (!var5) {
         return false;
      } else {
         class122.method737();
         AABB var6 = (AABB)var0.aabb.get(var1);
         int var7 = var2 + var6.xMid;
         int var8 = var3 + var6.yMid;
         int var9 = var4 + var6.zMid;
         int var10 = var6.xMidOffset;
         int var11 = var6.yMidOffset;
         int var12 = var6.zMidOffset;
         int var13 = ViewportMouse.field2207 - var7;
         int var14 = class294.field2715 - var8;
         int var15 = ViewportMouse.field2208 - var9;
         if (Math.abs(var13) > var10 + EnumComposition.field1536) {
            return false;
         } else if (Math.abs(var14) > var11 + ViewportMouse.field2211) {
            return false;
         } else if (Math.abs(var15) > var12 + class9.field29) {
            return false;
         } else if (Math.abs(var15 * UserComparator8.field1157 - var14 * ReflectionCheck.field166) > var11 * class9.field29 + var12 * ViewportMouse.field2211) {
            return false;
         } else if (Math.abs(var13 * ReflectionCheck.field166 - var15 * ViewportMouse.field2209) > var12 * EnumComposition.field1536 + var10 * class9.field29) {
            return false;
         } else {
            return Math.abs(var14 * ViewportMouse.field2209 - var13 * UserComparator8.field1157) <= var11 * EnumComposition.field1536 + var10 * ViewportMouse.field2211;
         }
      }
   }
}
