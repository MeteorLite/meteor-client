import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("BoundaryObject")
public final class BoundaryObject {
    @ObfuscatedName("af")
    int z;
    @ObfuscatedName("an")
    int x;
    @ObfuscatedName("aw")
    int y;
    @ObfuscatedName("ac")
    int orientationA;
    @ObfuscatedName("au")
    int orientationB;
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Liv;"
    )
    public Renderable renderable1;
    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "Liv;"
    )
    public Renderable renderable2;
    @ObfuscatedName("al")
    public long tag = 0L;
    @ObfuscatedName("at")
    int flags = 0;

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIFFFIIII)V",
      garbageValue = "-428480375"
   )
   static void method1379(int var0, int var1, int var2, int var3, int var4, int var5, float var6, float var7, float var8, int var9, int var10, int var11) {
      Rasterizer3D.field1999.vmethod1374(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }
}
