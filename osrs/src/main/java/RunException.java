import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("rw")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("e")
   public static String localPlayerName;
   @ObfuscatedName("v")
   public static int RunException_revision;
   @ObfuscatedName("x")
   public static int field4112;
   @ObfuscatedName("m")
   public static int clientType;
   @ObfuscatedName("q")
   String field4116;
   @ObfuscatedName("f")
   Throwable throwable;
}
