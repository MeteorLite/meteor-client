import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

import java.applet.Applet;

@ObfuscatedName("vf")
@Implements("RunException")
public class RunException extends RuntimeException {
	@ObfuscatedName("at")
	@Export("RunException_applet")
	public static Applet RunException_applet;
	@ObfuscatedName("ao")
	public static int field4318;
	@ObfuscatedName("ab")
	public static int field4317;
	@ObfuscatedName("au")
	String field4320;
	@ObfuscatedName("aa")
	@Export("parent")
	Throwable parent;

	RunException(Throwable var1, String var2) {
		this.field4320 = var2;
		this.parent = var1;
	}
}