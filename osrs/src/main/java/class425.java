import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pj")
public class class425 {
	@ObfuscatedName("f")
	public static final char[] field4655;
	@ObfuscatedName("n")
	public static final char[] field4659;

	static {
		field4655 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
		field4659 = new char[]{'[', ']', '#'};
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1795200802"
	)
	public static int method7664(int var0) {
		return var0 >>> 12;
	}

	@ObfuscatedName("jr")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1900063141"
	)
	@Export("resumePauseWidget")
	static void resumePauseWidget(int var0, int var1) {
		PacketBufferNode var2 = class120.getPacketBufferNode(ClientPacket.field3020, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeIntME(var1);
		var2.packetBuffer.method7972(var0);
		Client.packetWriter.addNode(var2);
	}
}
