import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.DataInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@ObfuscatedName("ea")
@Implements("Messages")
public class Messages {
	@ObfuscatedName("au")
	@Export("Messages_channels")
	static final Map Messages_channels;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lsf;"
	)
	@Export("Messages_hashTable")
	static final IterableNodeHashTable Messages_hashTable;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lou;"
	)
	@Export("Messages_queue")
	static final IterableDualNodeQueue Messages_queue;
	@ObfuscatedName("at")
	@Export("Messages_count")
	static int Messages_count;
	@ObfuscatedName("as")
	public static String field1146;

	static {
		Messages_channels = new HashMap();
		Messages_hashTable = new IterableNodeHashTable(1024);
		Messages_queue = new IterableDualNodeQueue();
		Messages_count = 0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
		garbageValue = "886881488"
	)
	@Export("RunException_sendStackTrace")
	public static void RunException_sendStackTrace(String var0, Throwable var1) {
		if (var1 != null) {
			var1.printStackTrace();
		} else {
			try {
				String var2 = "";
				if (var1 != null) {
					var2 = class493.method2465(var1);
				}

				if (var0 != null) {
					if (var1 != null) {
						var2 = var2 + " | ";
					}

					var2 = var2 + var0;
				}

				System.out.println("Error: " + var2);
				var2 = var2.replace(':', '.');
				var2 = var2.replace('@', '_');
				var2 = var2.replace('&', '_');
				var2 = var2.replace('#', '_');
				if (RunException.RunException_applet == null) {
					return;
				}

				URL var3 = new URL(RunException.RunException_applet.getCodeBase(), "clienterror.ws?cv=" + RunException.RunException_revision + "&cs=" + RunException.field4287 + "&u=" + RunException.field4289 + "&v1=" + TaskHandler.javaVendor + "&v2=" + class106.javaVersion + "&ct=" + RunException.field4285 + "&e=" + var2);
				DataInputStream var4 = new DataInputStream(var3.openStream());
				var4.read();
				var4.close();
			} catch (Exception var5) {
			}

		}
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "1446947589"
	)
	static int method635(int var0, Script var1, boolean var2) {
		if (var0 == 7108) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = UserList.method2244() ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}
}