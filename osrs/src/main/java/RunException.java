import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("uf")
@Implements("RunException")
public class RunException extends RuntimeException {
	@ObfuscatedName("aw")
	@Export("RunException_applet")
	public static Applet RunException_applet;
	@ObfuscatedName("ay")
	public static String field4248;
	@ObfuscatedName("ar")
	@Export("RunException_revision")
	public static int RunException_revision;
	@ObfuscatedName("am")
	public static int field4244;
	@ObfuscatedName("as")
	public static int field4246;
	@ObfuscatedName("aj")
	String field4249;
	@ObfuscatedName("ag")
	Throwable parent;
}
