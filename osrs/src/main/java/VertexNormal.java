import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;
import java.awt.Desktop.Action;
import java.net.URI;

@ObfuscatedName("jp")
@Implements("VertexNormal")
public class VertexNormal {
	@ObfuscatedName("ao")
	@Export("Tiles_overlays")
	static short[][][] Tiles_overlays;
	@ObfuscatedName("ac")
	@Export("x")
	int x;
	@ObfuscatedName("al")
	@Export("y")
	int y;
	@ObfuscatedName("ak")
	@Export("z")
	int z;
	@ObfuscatedName("ax")
	@Export("magnitude")
	int magnitude;

	VertexNormal() {
	}

	@ObfuscatedSignature(
		descriptor = "(Ljp;)V"
	)
	VertexNormal(VertexNormal var1) {
		this.x = var1.x;
		this.y = var1.y;
		this.z = var1.z;
		this.magnitude = var1.magnitude;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZZI)V",
		garbageValue = "-2141219999"
	)
	@Export("openURL")
	public static void openURL(String var0, boolean var1, boolean var2) {
		if (var1) {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI(var0));
					return;
				} catch (Exception var4) {
				}
			}

			if (class31.field84.startsWith("win")) {
				Friend.method2242(var0, 0, "openjs");
			} else if (class31.field84.startsWith("mac")) {
				Friend.method2242(var0, 1, "openjs");
			} else {
				Friend.method2242(var0, 2, "openjs");
			}
		} else {
			Friend.method2242(var0, 3, "openjs");
		}

	}
}