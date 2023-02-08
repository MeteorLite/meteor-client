import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
@Implements("JagexCache")
public class JagexCache {
    @ObfuscatedName("j")
    public static int idxCount;
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "Lqp;"
    )
    public static BufferedFile JagexCache_randomDat = null;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            descriptor = "Lqp;"
    )
    public static BufferedFile JagexCache_dat2File = null;
    @ObfuscatedName("m")
    @ObfuscatedSignature(
            descriptor = "Lqp;"
    )
    public static BufferedFile JagexCache_idx255File = null;
}
