import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tg")
@Implements("PrivateChatMode")
public class PrivateChatMode {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Ltg;"
   )
   static final PrivateChatMode field4083 = new PrivateChatMode(0);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Ltg;"
   )
   public static final PrivateChatMode field4086 = new PrivateChatMode(1);
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Ltg;"
   )
   static final PrivateChatMode field4085 = new PrivateChatMode(2);
   @ObfuscatedName("ab")
   @Export("id")
   public final int id;

   PrivateChatMode(int var1) {
      this.id = var1;
   }
}
