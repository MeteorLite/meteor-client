import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
@Implements("RouteStrategy")
public abstract class RouteStrategy {
    @ObfuscatedName("f")
    public int approxDestinationX;
    @ObfuscatedName("w")
    public int approxDestinationY;
    @ObfuscatedName("v")
    public int approxDestinationSizeX;
    @ObfuscatedName("s")
    public int approxDestinationSizeY;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(IIILgv;I)Z",
            garbageValue = "118374037"
    )
    public abstract boolean hasArrived(int var1, int var2, int var3, CollisionMap var4);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-546644607"
   )
   static final void method1108() {
      Decimator.method306("Your ignore list is full. Max of 100 for free users, and 400 for members");
   }
}
