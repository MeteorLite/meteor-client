import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qj")
public class class425 {
	@ObfuscatedName("au")
	@Export("ByteArrayPool_altSizeArrayCounts")
	public static int[] ByteArrayPool_altSizeArrayCounts;
	@ObfuscatedName("ac")
	int field3761;
	@ObfuscatedName("al")
	int field3763;
	@ObfuscatedName("ak")
	int field3762;
	@ObfuscatedName("ax")
	int field3764;

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		boolean var1 = true;
		int var2 = 10 - Integer.toString(this.field3761).length();
		int var3 = 10 - Integer.toString(this.field3762).length();
		int var4 = 10 - Integer.toString(this.field3763).length();
		String var5 = "          ".substring(10 - var2);
		String var6 = "          ".substring(10 - var3);
		String var7 = "          ".substring(10 - var4);
		return "    Size: " + this.field3761 + var5 + "Created: " + this.field3763 + var7 + "Total used: " + this.field3762 + var6 + "Max-In-Use: " + this.field3764;
	}

	@ObfuscatedName("ox")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-921532851"
	)
	static void method2178() {
		Client.packetWriter.addNode(ClanChannelMember.getPacketBufferNode(ClientPacket.FREECAM_EXIT, Client.packetWriter.isaacCipher));
		Client.oculusOrbState = 0;
	}
}