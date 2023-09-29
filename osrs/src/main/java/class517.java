import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tr")
public class class517 implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Ltr;"
	)
	public static final class517 field4129;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Ltr;"
	)
	public static final class517 field4131;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Ltr;"
	)
	public static final class517 field4130;
	@ObfuscatedName("ax")
	public final int field4133;
	@ObfuscatedName("ao")
	public final int field4132;
	@ObfuscatedName("ah")
	public final Class field4134;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ltd;"
	)
	public final class513 field4135;

	static {
		field4129 = new class517(2, 0, Integer.class, new class514());
		field4131 = new class517(1, 1, Long.class, new class516());
		field4130 = new class517(0, 2, String.class, new class518());
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/Class;Ltd;)V"
	)
	class517(int var1, int var2, Class var3, class513 var4) {
		this.field4133 = var1;
		this.field4132 = var2;
		this.field4134 = var3;
		this.field4135 = var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4132;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)Ljava/lang/Object;",
		garbageValue = "-1115238999"
	)
	public Object method2532(Buffer var1) {
		return this.field4135.vmethod8273(var1);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lom;Lom;ZI)V",
		garbageValue = "2080268851"
	)
	public static void method2530(AbstractArchive var0, AbstractArchive var1, boolean var2) {
		ObjectComposition.ObjectDefinition_archive = var0;
		ObjectComposition.ObjectDefinition_modelsArchive = var1;
		ObjectComposition.ObjectDefinition_isLowDetail = var2;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "-4677"
	)
	public static void method2526() {
		class190.field1496.clear();
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "618410019"
	)
	public static boolean method2527(int var0) {
		return (var0 >> 20 & 1) != 0;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)[Ltr;",
		garbageValue = "-527981427"
	)
	public static class517[] method2528() {
		return new class517[]{field4130, field4129, field4131};
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Class;B)Ltr;",
		garbageValue = "25"
	)
	public static class517 method2529(Class var0) {
		class517[] var1 = method2528();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			class517 var3 = var1[var2];
			if (var3.field4134 == var0) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("ip")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "119"
	)
	static void method2533() {
		PacketBufferNode var0 = ClanChannelMember.getPacketBufferNode(ClientPacket.EVENT_WINDOW_SETTING, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(class178.getWindowedMode());
		var0.packetBuffer.writeShort(class340.canvasWidth);
		var0.packetBuffer.writeShort(class491.canvasHeight);
		Client.packetWriter.addNode(var0);
	}

	@ObfuscatedName("mm")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/String;",
		garbageValue = "-352823613"
	)
	static final String method2534(int var0) {
		return var0 < 999999999 ? Integer.toString(var0) : "*";
	}
}