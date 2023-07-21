import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Ljj;"
	)
	@Export("WorldMapLabelSize_small")
	public static final WorldMapLabelSize WorldMapLabelSize_small;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Ljj;"
	)
	@Export("WorldMapLabelSize_medium")
	public static final WorldMapLabelSize WorldMapLabelSize_medium;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ljj;"
	)
	@Export("WorldMapLabelSize_large")
	public static final WorldMapLabelSize WorldMapLabelSize_large;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Luu;"
	)
	@Export("options_buttons_0Sprite")
	static IndexedSprite options_buttons_0Sprite;
	@ObfuscatedName("si")
	@ObfuscatedSignature(
		descriptor = "Lgh;"
	)
	@Export("guestClanChannel")
	static ClanChannel guestClanChannel;
	@ObfuscatedName("am")
	final int field2299;
	@ObfuscatedName("as")
	final int field2300;
	@ObfuscatedName("aj")
	final int field2298;

	static {
		WorldMapLabelSize_small = new WorldMapLabelSize(0, 0, 4);
		WorldMapLabelSize_medium = new WorldMapLabelSize(2, 1, 2);
		WorldMapLabelSize_large = new WorldMapLabelSize(1, 2, 0);
	}

	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field2299 = var1;
		this.field2300 = var2;
		this.field2298 = var3;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(FB)Z",
		garbageValue = "-3"
	)
	boolean method1365(float var1) {
		return var1 >= (float)this.field2298;
	}

	@ObfuscatedName("me")
	@ObfuscatedSignature(
		descriptor = "(IIII)Ldn;",
		garbageValue = "977578301"
	)
	@Export("ifOpenSub")
	static final InterfaceParent ifOpenSub(int var0, int var1, int var2) {
		InterfaceParent var3 = new InterfaceParent();
		var3.group = var1;
		var3.type = var2;
		Client.interfaceParents.put(var3, (long)var0);
		class92.Widget_resetModelFrames(var1);
		Widget var4 = VarbitComposition.getWidget(var0);
		class200.invalidateWidget(var4);
		if (Client.meslayerContinueWidget != null) {
			class200.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

		SoundCache.revalidateWidgetScroll(ArchiveLoader.Widget_interfaceComponents[var0 >> 16], var4, false);
		ScriptFrame.runWidgetOnLoadListener(var1);
		if (Client.rootInterface != -1) {
			ChatChannel.runIntfCloseListeners(Client.rootInterface, 1);
		}

		return var3;
	}
}
