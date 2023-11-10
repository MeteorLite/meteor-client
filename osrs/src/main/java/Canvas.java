import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;
import java.net.URL;
import java.util.Iterator;

@ObfuscatedName("ag")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
	@ObfuscatedName("fk")
	@ObfuscatedSignature(
		descriptor = "Loh;"
	)
	static Archive field68;
	@ObfuscatedName("at")
	@Export("component")
	Component component;

	Canvas(Component var1) {
		this.component = var1;
	}

	public final void update(Graphics var1) {
		this.component.update(var1);
	}

	public final void paint(Graphics var1) {
		this.component.paint(var1);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lhd;",
		garbageValue = "-1413317241"
	)
	public static FloorOverlayDefinition method85(int var0) {
		FloorOverlayDefinition var1 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var0);
			var1 = new FloorOverlayDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2), var0);
			}

			var1.postDecode();
			FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)Lha;",
		garbageValue = "-2114676262"
	)
	@Export("SpotAnimationDefinition_get")
	public static SpotAnimationDefinition SpotAnimationDefinition_get(int var0) {
		SpotAnimationDefinition var1 = (SpotAnimationDefinition)SpotAnimationDefinition.SpotAnimationDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SpotAnimationDefinition.SpotAnimationDefinition_archive.takeFile(13, var0);
			var1 = new SpotAnimationDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			SpotAnimationDefinition.SpotAnimationDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ILjava/lang/String;B)Z",
		garbageValue = "50"
	)
	static boolean method88(String var0, int var1, String var2) {
		if (var1 == 0) {
			try {
				if (!class31.field86.startsWith("win")) {
					throw new Exception();
				} else if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
					throw new Exception();
				} else {
					String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

					for (int var4 = 0; var4 < var0.length(); ++var4) {
						if (var10.indexOf(var0.charAt(var4)) == -1) {
							throw new Exception();
						}
					}

					Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
					return true;
				}
			} catch (Throwable var5) {
				return false;
			}
		} else if (var1 == 1) {
			try {
				Object var3 = class26.invoke(class31.field85, var2, new Object[]{(new URL(class31.field85.getCodeBase(), var0)).toString()});
				return var3 != null;
			} catch (Throwable var6) {
				return false;
			}
		} else if (var1 == 2) {
			try {
				class31.field85.getAppletContext().showDocument(new URL(class31.field85.getCodeBase(), var0), "_blank");
				return true;
			} catch (Exception var7) {
				return false;
			}
		} else if (var1 == 3) {
			try {
				class26.method108(class31.field85, "loggedout");
			} catch (Throwable var9) {
			}

			try {
				class31.field85.getAppletContext().showDocument(new URL(class31.field85.getCodeBase(), var0), "_top");
				return true;
			} catch (Exception var8) {
				return false;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(FFFFLfm;I)V",
		garbageValue = "-2092193307"
	)
	static void method90(float var0, float var1, float var2, float var3, class131 var4) {
		float var5 = var1 - var0;
		float var6 = var2 - var1;
		float var7 = var3 - var2;
		float var8 = var6 - var5;
		var4.field1262 = var7 - var6 - var8;
		var4.field1269 = var8 + var8 + var8;
		var4.field1266 = var5 + var5 + var5;
		var4.field1268 = var0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "6"
	)
	static void method89() {
		Script.Script_cached.clear();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-18"
	)
	static void method87() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromIgnored();
		}

	}

	@ObfuscatedName("js")
	@ObfuscatedSignature(
		descriptor = "(Ldf;II)V",
		garbageValue = "330156995"
	)
	static final void method91(Actor var0, int var1) {
		class514.worldToScreen(var0.x, var0.y, var1);
	}

	@ObfuscatedName("ln")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIII)V",
		garbageValue = "1842329520"
	)
	@Export("drawWidgets")
	static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (HealthBarDefinition.widgetDefinition.loadInterface(var0)) {
			UserComparator10.field1197 = null;
			SoundSystem.drawInterface(HealthBarDefinition.widgetDefinition.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
			if (UserComparator10.field1197 != null) {
				SoundSystem.drawInterface(UserComparator10.field1197, -1412584499, var1, var2, var3, var4, ParamComposition.field1629, PendingSpawn.field950, var7);
				UserComparator10.field1197 = null;
			}

		} else {
			if (var7 != -1) {
				Client.field407[var7] = true;
			} else {
				for (int var8 = 0; var8 < 100; ++var8) {
					Client.field407[var8] = true;
				}
			}

		}
	}
}