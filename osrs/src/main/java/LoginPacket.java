import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("LoginPacket")
public class LoginPacket implements class278 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Ljw;"
   )
   public static final LoginPacket field2682 = new LoginPacket(14, 0);
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Ljw;"
   )
   static final LoginPacket field2677 = new LoginPacket(15, 4);
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Ljw;"
    )
    public static final LoginPacket NEW_LOGIN_CONNECTION = new LoginPacket(16, -2);
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Ljw;"
    )
    public static final LoginPacket RECONNECT_LOGIN_CONNECTION = new LoginPacket(18, -2);
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Ljw;"
   )
   public static final LoginPacket field2678 = new LoginPacket(19, -2);
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Ljw;"
   )
   static final LoginPacket field2681 = new LoginPacket(27, 0);
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "[Ljw;"
   )
   static final LoginPacket[] field2680 = new LoginPacket[32];
    @ObfuscatedName("i")
    public final int id;

   static {
      LoginPacket[] var0 = Canvas.method82();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         field2680[var0[var1].id] = var0[var1];
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
