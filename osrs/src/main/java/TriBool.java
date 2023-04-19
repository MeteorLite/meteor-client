import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("px")
@Implements("TriBool")
public class TriBool {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lpx;"
    )
    public static final TriBool TriBool_unknown = new TriBool();
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lpx;"
    )
    public static final TriBool TriBool_true = new TriBool();
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lpx;"
    )
    public static final TriBool TriBool_false = new TriBool();
   @ObfuscatedName("cf")
   static int field3738;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "0"
   )
   public static int method2198(int var0) {
      return class439.field3830[var0 & 16383];
   }
}
