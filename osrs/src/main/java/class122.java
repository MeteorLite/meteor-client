import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class122 {
	@ObfuscatedName("c")
	static boolean method2927(long var0) {
		return class17.method271(var0) == 2;
	}

	@ObfuscatedName("fk")
	@ObfuscatedSignature(
		descriptor = "(Llb;Ljava/lang/String;I)V",
		garbageValue = "1453241977"
	)
	static void method2926(Archive var0, String var1) {
		ArchiveLoader var2 = new ArchiveLoader(var0, var1);
		Client.archiveLoaders.add(var2);
		Client.field613 += var2.groupCount;
	}
}
