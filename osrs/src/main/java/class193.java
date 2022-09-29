import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public enum class193 implements MouseWheel {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lga;"
	)
	field2248((byte)-1),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lga;"
	)
	field2244((byte)0),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lga;"
	)
	field2246((byte)1),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lga;"
	)
	field2247((byte)2);

	@ObfuscatedName("k")
	public byte field2245;

	class193(byte var3) {
		this.field2245 = var3;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field2245;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IB)Lfs;",
		garbageValue = "32"
	)
	@Export("getNpcDefinition")
	public static NPCComposition getNpcDefinition(int var0) {
		NPCComposition var1 = (NPCComposition)NPCComposition.NpcDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = NPCComposition.NpcDefinition_archive.takeFile(9, var0);
			var1 = new NPCComposition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			NPCComposition.NpcDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("jp")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-45"
	)
	@Export("Widget_runOnTargetLeave")
	static void Widget_runOnTargetLeave() {
		if (Client.isSpellSelected) {
			Widget var0 = JagexCache.getWidgetChild(ClanSettings.selectedSpellWidget, Client.selectedSpellChildIndex);
			if (var0 != null && var0.onTargetLeave != null) {
				ScriptEvent var1 = new ScriptEvent();
				var1.widget = var0;
				var1.args = var0.onTargetLeave;
				class348.runScriptEvent(var1);
			}

			Client.selectedSpellItemId = -1;
			Client.isSpellSelected = false;
			class403.invalidateWidget(var0);
		}
	}

	@ObfuscatedName("jy")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIII)V",
		garbageValue = "1370548065"
	)
	@Export("drawWidgets")
	static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (FloorOverlayDefinition.loadInterface(var0)) {
			BoundaryObject.field2663 = null;
			GraphicsObject.drawInterface(Calendar.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
			if (BoundaryObject.field2663 != null) {
				GraphicsObject.drawInterface(BoundaryObject.field2663, -1412584499, var1, var2, var3, var4, MouseHandler.field240, Tile.field2344, var7);
				BoundaryObject.field2663 = null;
			}

		} else {
			if (var7 != -1) {
				Client.field714[var7] = true;
			} else {
				for (int var8 = 0; var8 < 100; ++var8) {
					Client.field714[var8] = true;
				}
			}

		}
	}
}
