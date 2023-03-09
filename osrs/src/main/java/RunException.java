import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("tw")
@Implements("RunException")
public class RunException extends RuntimeException {
   @ObfuscatedName("aj")
   @Export("RunException_applet")
   public static Applet RunException_applet;
   @ObfuscatedName("al")
   @Export("localPlayerName")
   public static String localPlayerName;
   @ObfuscatedName("ac")
   @Export("RunException_revision")
   public static int RunException_revision;
   @ObfuscatedName("ao")
   String field4096;
   @ObfuscatedName("av")
   Throwable parent;
}
