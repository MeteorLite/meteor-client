import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
@Implements("FileSystem")
public class FileSystem {
    @ObfuscatedName("af")
    public static boolean FileSystem_hasPermissions = false;
    @ObfuscatedName("aw")
    static Hashtable FileSystem_cacheFiles = new Hashtable(16);
    @ObfuscatedName("al")
    public static boolean ItemDefinition_inMembersWorld;
    @ObfuscatedName("aa")
    static int[] Tiles_hue;
}
