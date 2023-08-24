import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("gc")
public class class157 extends class143 {
	@ObfuscatedName("gt")
	static String field1407;
	@ObfuscatedName("iz")
	static int field1406;
	@ObfuscatedName("au")
	int field1408;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfn;"
	)
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfn;)V"
	)
	class157(class146 var1) {
		this.this$0 = var1;
		this.field1408 = -1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "209179459"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1408 = var1.readUnsignedShort();
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lfi;B)V",
		garbageValue = "73"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method816(this.field1408);
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(CS)Z",
		garbageValue = "255"
	)
	static boolean method835(char var0) {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var0) != -1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-858591877"
	)
	public static String method832(String var0) {
		StringBuilder var1 = new StringBuilder(var0.length());
		int var2 = 0;
		int var3 = -1;

		for (int var4 = 0; var4 < var0.length(); ++var4) {
			char var5 = var0.charAt(var4);
			if (var5 == '<') {
				var1.append(var0.substring(var2, var4));
				var3 = var4;
			} else if (var5 == '>' && var3 != -1) {
				String var6 = var0.substring(var3 + 1, var4);
				var3 = -1;
				if (var6.equals("lt")) {
					var1.append("<");
				} else if (var6.equals("gt")) {
					var1.append(">");
				} else if (var6.equals("br")) {
					var1.append("\n");
				}

				var2 = var4 + 1;
			}
		}

		if (var2 < var0.length()) {
			var1.append(var0.substring(var2, var0.length()));
		}

		return var1.toString();
	}

	@ObfuscatedName("is")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/ArrayList;IIIIB)V",
		garbageValue = "6"
	)
	static void method836(ArrayList var0, int var1, int var2, int var3, int var4) {
		if (!var0.isEmpty()) {
			int var5 = (Integer)var0.get(0);
			if (var5 == -1 && !Client.playingJingle) {
				Script.method445(0, 0);
			} else if (var5 != -1 && !class172.method906(var5) && class449.clientPreferences.getCurrentMusicVolume() != 0) {
				ArrayList var6 = new ArrayList();

				for (int var7 = 0; var7 < var0.size(); ++var7) {
					var6.add(new MusicSong(class385.archive6, (Integer)var0.get(var7), 0, class449.clientPreferences.getCurrentMusicVolume(), false));
				}

				if (Client.playingJingle) {
					class305.field2773.clear();
					class305.field2773.addAll(var6);
					class270.method1537(var1, var2, var3, var4);
				} else {
					class53.method291(var6, var1, var2, var3, var4, false);
				}
			}

		}
	}
}