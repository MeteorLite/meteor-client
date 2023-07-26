import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tm")
public class class503 implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Ltm;"
	)
	public static final class503 field4090;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Ltm;"
	)
	public static final class503 field4091;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ltm;"
	)
	public static final class503 field4089;
	@ObfuscatedName("am")
	public final int field4093;
	@ObfuscatedName("as")
	public final int field4094;
	@ObfuscatedName("aj")
	public final Class field4095;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Ltd;"
	)
	final class499 field4092;

	static {
		field4090 = new class503(0, 0, Integer.class, new class500());
		field4091 = new class503(1, 1, Long.class, new class502());
		field4089 = new class503(2, 2, String.class, new class504());
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/Class;Ltd;)V"
	)
	class503(int var1, int var2, Class var3, class499 var4) {
		this.field4093 = var1;
		this.field4094 = var2;
		this.field4095 = var3;
		this.field4092 = var4;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4094;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)Ljava/lang/Object;",
		garbageValue = "-37"
	)
	public Object method2474(Buffer var1) {
		return this.field4092.vmethod8273(var1);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)[Ltm;",
		garbageValue = "-101"
	)
	public static class503[] method2469() {
		return new class503[]{field4091, field4090, field4089};
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Llw;Luy;B)Llv;",
		garbageValue = "52"
	)
	@Export("getPacketBufferNode")
	public static PacketBufferNode getPacketBufferNode(ClientPacket var0, IsaacCipher var1) {
		PacketBufferNode var2 = class130.method708();
		var2.clientPacket = var0;
		var2.clientPacketLength = var0.length;
		if (var2.clientPacketLength == -1) {
			var2.packetBuffer = new PacketBuffer(260);
		} else if (var2.clientPacketLength == -2) {
			var2.packetBuffer = new PacketBuffer(10000);
		} else if (var2.clientPacketLength <= 18) {
			var2.packetBuffer = new PacketBuffer(20);
		} else if (var2.clientPacketLength <= 98) {
			var2.packetBuffer = new PacketBuffer(100);
		} else {
			var2.packetBuffer = new PacketBuffer(260);
		}

		var2.packetBuffer.setIsaacCipher(var1);
		var2.packetBuffer.writeByteIsaac(var2.clientPacket.id);
		var2.index = 0;
		return var2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Class;I)Ltm;",
		garbageValue = "-1095130595"
	)
	public static class503 method2470(Class var0) {
		class503[] var1 = method2469();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			class503 var3 = var1[var2];
			if (var3.field4095 == var0) {
				return var3;
			}
		}

		return null;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Lty;I)V",
		garbageValue = "472817950"
	)
	public static void method2472(Object var0, Buffer var1) {
		Class var3 = var0.getClass();
		class503 var4 = method2470(var3);
		if (var4 == null) {
			throw new IllegalArgumentException();
		} else {
			class499 var2 = var4.field4092;
			var2.vmethod8274(var0, var1);
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1510166958"
	)
	public static void method2471() {
		HealthBarDefinition.HealthBarDefinition_cached.clear();
		HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
	}

	@ObfuscatedName("my")
	@ObfuscatedSignature(
		descriptor = "(Lmt;B)Lmt;",
		garbageValue = "-69"
	)
	static Widget method2475(Widget var0) {
		Widget var1 = WorldMapEvent.method1547(var0);
		if (var1 == null) {
			var1 = var0.parent;
		}

		return var1;
	}
}
