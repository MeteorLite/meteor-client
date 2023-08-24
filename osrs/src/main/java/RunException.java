import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

import java.applet.Applet;

@ObfuscatedName("uy")
@Implements("RunException")
public class RunException extends RuntimeException {
	@ObfuscatedName("au")
	@Export("RunException_applet")
	public static Applet RunException_applet;
	@ObfuscatedName("ae")
	public static String field4289;
	@ObfuscatedName("ao")
	@Export("RunException_revision")
	public static int RunException_revision;
	@ObfuscatedName("at")
	public static int field4287;
	@ObfuscatedName("ac")
	public static int field4285;
	@ObfuscatedName("jy")
	@Export("xteaKeys")
	static int[][] xteaKeys;
	@ObfuscatedName("ai")
	String field4291;
	@ObfuscatedName("az")
	Throwable parent;

	RunException(Throwable var1, String var2) {
		this.field4291 = var2;
		this.parent = var1;
	}
}