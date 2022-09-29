import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class146 {
	@ObfuscatedName("hz")
	@ObfuscatedGetter(
		intValue = -1960461483
	)
	static int field1684;
	@ObfuscatedName("nq")
	@ObfuscatedSignature(
		descriptor = "Lbh;"
	)
	@Export("tempMenuAction")
	static MenuAction tempMenuAction;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		longValue = 4972834688742497923L
	)
	long field1681;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		longValue = 6940230468072027913L
	)
	long field1687;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Llz;"
	)
	IterableNodeDeque field1682;

	@ObfuscatedSignature(
		descriptor = "(Lqq;)V"
	)
	public class146(Buffer var1) {
		this.field1687 = -1L;
		this.field1682 = new IterableNodeDeque();
		this.method3229(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V",
		garbageValue = "1576904279"
	)
	void method3229(Buffer var1) {
		this.field1681 = var1.readLong();
		this.field1687 = var1.readLong();

		for (int var2 = var1.readUnsignedByte(); var2 != 0; var2 = var1.readUnsignedByte()) {
			Object var3;
			if (var2 == 1) {
				var3 = new class141(this);
			} else if (var2 == 4) {
				var3 = new class152(this);
			} else if (var2 == 3) {
				var3 = new class137(this);
			} else if (var2 == 2) {
				var3 = new class135(this);
			} else {
				if (var2 != 5) {
					throw new RuntimeException("");
				}

				var3 = new class142(this);
			}

			((class145)var3).vmethod3300(var1);
			this.field1682.addFirst((Node)var3);
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Ler;I)V",
		garbageValue = "1477279041"
	)
	public void method3230(ClanChannel var1) {
		if (var1.key == this.field1681 && var1.field1706 == this.field1687) {
			for (class145 var2 = (class145)this.field1682.last(); var2 != null; var2 = (class145)this.field1682.previous()) {
				var2.vmethod3302(var1);
			}

			++var1.field1706;
		} else {
			throw new RuntimeException("");
		}
	}

	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZI)V",
		garbageValue = "1164189292"
	)
	@Export("drawLoadingMessage")
	static final void drawLoadingMessage(String var0, boolean var1) {
		if (Client.showLoadingMessages) {
			byte var2 = 4;
			int var3 = var2 + 6;
			int var4 = var2 + 6;
			int var5 = class1.fontPlain12.lineWidth(var0, 250);
			int var6 = class1.fontPlain12.lineCount(var0, 250) * 13;
			Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 16777215);
			class1.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
			class9.method89(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6);
			if (var1) {
				class20.rasterProvider.drawFull(0, 0);
			} else {
				int var7 = var3;
				int var8 = var4;
				int var9 = var5;
				int var10 = var6;

				for (int var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
					if (Client.rootWidgetXs[var11] + Client.rootWidgetWidths[var11] > var7 && Client.rootWidgetXs[var11] < var9 + var7 && Client.rootWidgetYs[var11] + Client.rootWidgetHeights[var11] > var8 && Client.rootWidgetYs[var11] < var10 + var8) {
						Client.field556[var11] = true;
					}
				}
			}

		}
	}

	@ObfuscatedName("hj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-6602468"
	)
	static final void method3239() {
		for (GraphicsObject var0 = (GraphicsObject)Client.graphicsObjects.last(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjects.previous()) {
			if (var0.plane == Tiles.Client_plane && !var0.isFinished) {
				if (Client.cycle >= var0.cycleStart) {
					var0.advance(Client.field743);
					if (var0.isFinished) {
						var0.remove();
					} else {
						MusicPatchNode.scene.drawEntity(var0.plane, var0.x, var0.y, var0.z, 60, var0, 0, -1L, false);
					}
				}
			} else {
				var0.remove();
			}
		}

	}

	@ObfuscatedName("lo")
	@ObfuscatedSignature(
		descriptor = "(IIIILqi;Lko;I)V",
		garbageValue = "1807581062"
	)
	@Export("drawSpriteOnMinimap")
	static final void drawSpriteOnMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, SpriteMask var5) {
		if (var4 != null) {
			int var6 = Client.camAngleY & 2047;
			int var7 = var3 * var3 + var2 * var2;
			if (var7 <= 6400) {
				int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
				int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
				int var10 = var3 * var8 + var9 * var2 >> 16;
				int var11 = var3 * var9 - var8 * var2 >> 16;
				if (var7 > 2500) {
					var4.method8361(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2, var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
				} else {
					var4.drawTransBgAt(var0 + var10 + var5.width / 2 - var4.width / 2, var5.height / 2 + var1 - var11 - var4.height / 2);
				}

			}
		}
	}
}
