import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.*;

@ObfuscatedName("uf")
public class class520 {
	@ObfuscatedName("ar")
	static final int field4148;
	@ObfuscatedName("ao")
	static final int field4147;
	@ObfuscatedName("aa")
	@Export("SpriteBuffer_spriteHeights")
	public static int[] SpriteBuffer_spriteHeights;

	static {
		field4148 = (int)(Math.pow(2.0D, 4.0D) - 1.0D);
		field4147 = (int)(Math.pow(2.0D, 8.0D) - 1.0D);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)[Lly;",
		garbageValue = "-51"
	)
	public static ZoneOperation[] method2524() {
		return new ZoneOperation[]{ZoneOperation.LOC_ANIM, ZoneOperation.field2616, ZoneOperation.field2620, ZoneOperation.field2618, ZoneOperation.OBJ_DEL, ZoneOperation.field2622, ZoneOperation.LOC_DEL, ZoneOperation.LOC_ADD_CHANGE, ZoneOperation.AREA_SOUND, ZoneOperation.field2625, ZoneOperation.OBJ_COUNT, ZoneOperation.MAPPROJ_ANIM, ZoneOperation.PREFETCH_GAMEOBJECTS};
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
		garbageValue = "-1924207396"
	)
	static String method2525(Throwable var0) throws IOException {
		String var1;
		if (var0 instanceof RunException) {
			RunException var2 = (RunException)var0;
			var1 = var2.field4320 + " | ";
			var0 = var2.parent;
		} else {
			var1 = "";
		}

		StringWriter var12 = new StringWriter();
		PrintWriter var3 = new PrintWriter(var12);
		var0.printStackTrace(var3);
		var3.close();
		String var4 = var12.toString();
		BufferedReader var5 = new BufferedReader(new StringReader(var4));
		String var6 = var5.readLine();

		while (true) {
			while (true) {
				String var7 = var5.readLine();
				if (var7 == null) {
					var1 = var1 + "| " + var6;
					return var1;
				}

				int var8 = var7.indexOf(40);
				int var9 = var7.indexOf(41, var8 + 1);
				if (var8 >= 0 && var9 >= 0) {
					String var10 = var7.substring(var8 + 1, var9);
					int var11 = var10.indexOf(".java:");
					if (var11 >= 0) {
						var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
						var1 = var1 + var10 + ' ';
						continue;
					}

					var7 = var7.substring(0, var8);
				}

				var7 = var7.trim();
				var7 = var7.substring(var7.lastIndexOf(32) + 1);
				var7 = var7.substring(var7.lastIndexOf(9) + 1);
				var1 = var1 + var7 + ' ';
			}
		}
	}

	@ObfuscatedName("nd")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "471269719"
	)
	static final void method2526() {
		PacketBufferNode var0 = class113.getPacketBufferNode(ClientPacket.FREECAM_EXIT, Client.packetWriter.isaacCipher);
		Client.packetWriter.addNode(var0);
		Interpreter.field703 = true;

		for (InterfaceParent var1 = (InterfaceParent)Client.interfaceParents.first(); var1 != null; var1 = (InterfaceParent)Client.interfaceParents.next()) {
			if (var1.type == 0 || var1.type == 3) {
				class302.closeInterface(var1, true);
			}
		}

		if (Client.meslayerContinueWidget != null) {
			class159.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

		Interpreter.field703 = false;
	}
}