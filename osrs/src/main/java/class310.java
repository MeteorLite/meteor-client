import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ll")
public class class310 {
	@ObfuscatedName("aw")
	int field2808;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lcf;"
	)
	class53 field2807;

	@ObfuscatedSignature(
		descriptor = "(ILcf;)V"
	)
	class310(int var1, class53 var2) {
		this.field2808 = var1;
		this.field2807 = var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/net/Socket;IIB)Lqh;",
		garbageValue = "29"
	)
	public static AbstractSocket method1640(Socket var0, int var1, int var2) throws IOException {
		return new BufferedNetSocket(var0, var1, var2);
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(Lmt;III)V",
		garbageValue = "924018154"
	)
	public static void method1641(Widget var0, int var1, int var2) {
		var0.field3081.bodyColors[var1] = var2;
		var0.field3081.method1690();
	}
}
