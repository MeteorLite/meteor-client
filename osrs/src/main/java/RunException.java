import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("rw")
public class RunException extends RuntimeException {
   @ObfuscatedName("e")
   public static String localPlayerName;
   @ObfuscatedName("v")
   public static int RunException_revision;
   @ObfuscatedName("x")
   public static int field5065;
   @ObfuscatedName("m")
   public static int clientType;
   @ObfuscatedName("q")
   String message;
   @ObfuscatedName("f")
   Throwable throwable;

   RunException(Throwable var1, String var2) {
      this.message = var2;
      this.throwable = var1;
   }
}
