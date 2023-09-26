import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ve")
@Implements("RunException")
public class RunException extends RuntimeException {
	@ObfuscatedName("al")
	public static String field4314;
	@ObfuscatedName("ak")
	@Export("RunException_revision")
	public static int RunException_revision;
	@ObfuscatedName("ax")
	public static int field4313;
	@ObfuscatedName("ah")
	String field4315;
	@ObfuscatedName("ar")
	@Export("parent")
	Throwable parent;

	RunException(Throwable var1, String var2) {
		this.field4315 = var2;
		this.parent = var1;
	}
}