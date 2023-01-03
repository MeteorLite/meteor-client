import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("LoginPacket")
public class LoginPacket implements class274 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Ljh;"
   )
   public static final LoginPacket field2679 = new LoginPacket(14, 0);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Ljh;"
   )
   static final LoginPacket field2684 = new LoginPacket(15, 4);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Ljh;"
   )
   public static final LoginPacket field2680 = new LoginPacket(16, -2);
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Ljh;"
   )
   public static final LoginPacket field2682 = new LoginPacket(18, -2);
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Ljh;"
   )
   public static final LoginPacket field2683 = new LoginPacket(19, -2);
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Ljh;"
   )
   static final LoginPacket field2687 = new LoginPacket(27, 0);
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "[Ljh;"
   )
   static final LoginPacket[] field2686 = new LoginPacket[32];
   @ObfuscatedName("k")
   public static int cacheGamebuild;
   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "Llw;"
   )
   static StudioGame field2681;
   @ObfuscatedName("f")
   public final int id;

   static {
      LoginPacket[] var0 = GrandExchangeOfferOwnWorldComparator.method352();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         field2686[var0[var1].id] = var0[var1];
      }

   }

   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "0"
   )
   LoginPacket(int var1, int var2) {
      this.id = var1;
   }
}
