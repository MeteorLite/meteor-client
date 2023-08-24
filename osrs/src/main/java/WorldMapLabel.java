import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
@Implements("WorldMapLabel")
public class WorldMapLabel {
	@ObfuscatedName("au")
	@Export("text")
	String text;
	@ObfuscatedName("ae")
	@Export("width")
	int width;
	@ObfuscatedName("ao")
	@Export("height")
	int height;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ljb;"
	)
	@Export("size")
	WorldMapLabelSize size;

	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;IILjb;)V"
	)
	WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
		this.text = var1;
		this.width = var2;
		this.height = var3;
		this.size = var4;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "39"
	)
	public static boolean method1534(int var0) {
		return var0 >= WorldMapDecorationType.field3138.id && var0 <= WorldMapDecorationType.field3140.id;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(CS)Z",
		garbageValue = "256"
	)
	@Export("isAlphaNumeric")
	public static boolean isAlphaNumeric(char var0) {
		return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}
}