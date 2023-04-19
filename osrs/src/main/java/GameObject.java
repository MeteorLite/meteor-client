import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("GameObject")
public final class GameObject {
    @ObfuscatedName("jc")
    static int baseY;
    @ObfuscatedName("jd")
    static int[][] xteaKeys;
    @ObfuscatedName("af")
    int plane;
    @ObfuscatedName("an")
    int startX;
    @ObfuscatedName("aw")
    int z;
    @ObfuscatedName("ac")
    int centerX;
    @ObfuscatedName("au")
    int centerY;
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Liv;"
    )
    public Renderable renderable;
    @ObfuscatedName("aq")
    int orientation;
    @ObfuscatedName("al")
    int endX;
    @ObfuscatedName("at")
    int startY;
    @ObfuscatedName("aa")
    int endY;
   @ObfuscatedName("ay")
   int field2271;
    @ObfuscatedName("ao")
    int lastDrawn;
    @ObfuscatedName("ax")
    public long tag = 0L;
    @ObfuscatedName("ai")
    int flags = 0;
}
