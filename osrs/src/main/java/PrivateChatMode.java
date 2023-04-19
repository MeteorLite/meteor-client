import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tf")
@Implements("PrivateChatMode")
public class PrivateChatMode {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Ltf;"
   )
   static final PrivateChatMode field4163 = new PrivateChatMode(0);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Ltf;"
   )
   public static final PrivateChatMode field4161 = new PrivateChatMode(1);
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Ltf;"
   )
   static final PrivateChatMode field4162 = new PrivateChatMode(2);
    @ObfuscatedName("ac")
    public final int id;

   PrivateChatMode(int var1) {
      this.id = var1;
   }
}
