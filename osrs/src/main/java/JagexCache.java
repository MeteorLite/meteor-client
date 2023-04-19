import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
@Implements("JagexCache")
public class JagexCache {
    @ObfuscatedName("ac")
    static File JagexCache_locationFile;
    @ObfuscatedName("ab")
    public static int idxCount;
    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "Lsj;"
    )
    public static BufferedFile JagexCache_randomDat = null;
    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            descriptor = "Lsj;"
    )
    public static BufferedFile JagexCache_dat2File = null;
    @ObfuscatedName("ai")
    @ObfuscatedSignature(
            descriptor = "Lsj;"
    )
    public static BufferedFile JagexCache_idx255File = null;
    @ObfuscatedName("ah")
    public static int cacheGamebuild;

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(IIIIB)I",
      garbageValue = "-40"
   )
   static final int method952(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }
}
