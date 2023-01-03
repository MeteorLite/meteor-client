import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("ApproximateRouteStrategy")
public class ApproximateRouteStrategy extends RouteStrategy {
   @ObfuscatedName("so")
   @ObfuscatedSignature(
      descriptor = "Laz;"
   )
   @Export("pcmStreamMixer")
   static PcmStreamMixer pcmStreamMixer;
   @ObfuscatedName("jy")
   static int field347;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IIILgw;I)Z",
      garbageValue = "1813316312"
   )
   @Export("hasArrived")
   protected boolean hasArrived(int var1, int var2, int var3, CollisionMap var4) {
      return var2 == super.approxDestinationX && var3 == super.approxDestinationY;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)Lfe;",
      garbageValue = "-1070341750"
   )
   public static VarcInt method348(int var0) {
      VarcInt var1 = (VarcInt)VarcInt.VarcInt_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarcInt.VarcInt_archive.takeFile(19, var0);
         var1 = new VarcInt();
         if (var2 != null) {
            var1.method922(new Buffer(var2));
         }

         VarcInt.VarcInt_cached.put(var1, (long)var0);
         return var1;
      }
   }
}
