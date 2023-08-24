import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("MoveSpeed")
public enum MoveSpeed implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lin;"
	)
	@Export("STATIONARY")
	STATIONARY((byte)-1),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lin;"
	)
	@Export("CRAWL")
	CRAWL((byte)0),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lin;"
	)
	@Export("WALK")
	WALK((byte)1),
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lin;"
	)
	@Export("RUN")
	RUN((byte)2);

	@ObfuscatedName("ap")
	static byte[][][] field1924;
	@ObfuscatedName("ac")
	@Export("speed")
	public byte speed;

	MoveSpeed(byte var3) {
		this.speed = var3;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.speed;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IB)Ljava/lang/String;",
		garbageValue = "-51"
	)
	@Export("colorStartTag")
	static String colorStartTag(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">";
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1754323091"
	)
	public static int method1141(int var0) {
		return (var0 & class508.field4120) - 1;
	}

	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "-4242"
	)
	@Export("runWidgetOnLoadListener")
	static void runWidgetOnLoadListener(int var0) {
		if (var0 != -1) {
			if (ModeWhere.loadInterface(var0)) {
				Widget[] var1 = PacketBufferNode.Widget_interfaceComponents[var0];

				for (int var2 = 0; var2 < var1.length; ++var2) {
					Widget var3 = var1[var2];
					if (var3.onLoad != null) {
						ScriptEvent var4 = new ScriptEvent();
						var4.widget = var3;
						var4.args = var3.onLoad;
						NPC.runScript(var4, 5000000, 0);
					}
				}

			}
		}
	}

	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		descriptor = "(IB)Ljava/lang/Object;",
		garbageValue = "-77"
	)
	static Object method1143(int var0) {
		return class172.method908((class502)KeyHandler.findEnumerated(class502.method2494(), var0));
	}
}