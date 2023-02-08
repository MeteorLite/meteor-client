import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ra")
@Implements("PrivateChatMode")
public class PrivateChatMode {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lra;"
   )
   static final PrivateChatMode field4119 = new PrivateChatMode(0);
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lra;"
   )
   public static final PrivateChatMode field4117 = new PrivateChatMode(1);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lra;"
   )
   static final PrivateChatMode field4118 = new PrivateChatMode(2);
    @ObfuscatedName("s")
    public final int id;

   PrivateChatMode(int var1) {
      this.id = var1;
   }
}
