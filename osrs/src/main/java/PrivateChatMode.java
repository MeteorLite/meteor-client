import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rt")
@Implements("PrivateChatMode")
public class PrivateChatMode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lrt;"
   )
   static final PrivateChatMode field4106 = new PrivateChatMode(0);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lrt;"
   )
   public static final PrivateChatMode field4103 = new PrivateChatMode(1);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lrt;"
   )
   static final PrivateChatMode field4104 = new PrivateChatMode(2);
   @ObfuscatedName("x")
   public final int id;

   PrivateChatMode(int var1) {
      this.id = var1;
   }
}
