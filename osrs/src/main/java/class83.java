import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class83 {
   @ObfuscatedName("ao")
   static int field841;

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(Ljava/util/Date;I)Z",
      garbageValue = "2091247209"
   )
   static boolean method461(Date var0) {
      Date var1 = WorldMapSection0.method1440();
      return var0.after(var1);
   }

   @ObfuscatedName("nt")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "3"
   )
   public static boolean method462() {
      return Client.clickedWidget != null;
   }
}
