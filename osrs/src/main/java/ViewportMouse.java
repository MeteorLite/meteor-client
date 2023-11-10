import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
@Implements("ViewportMouse")
public class ViewportMouse {
	@ObfuscatedName("at")
	@Export("ViewportMouse_isInViewport")
	static boolean ViewportMouse_isInViewport;
	@ObfuscatedName("ah")
	@Export("ViewportMouse_x")
	static int ViewportMouse_x;
	@ObfuscatedName("ar")
	@Export("ViewportMouse_y")
	static int ViewportMouse_y;
	@ObfuscatedName("ao")
	@Export("ViewportMouse_false0")
	static boolean ViewportMouse_false0;
	@ObfuscatedName("au")
	@Export("Tiles_shapes")
	static byte[][][] Tiles_shapes;
	@ObfuscatedName("az")
	static int field2433;
	@ObfuscatedName("ap")
	static int field2429;
	@ObfuscatedName("ax")
	static int field2432;
	@ObfuscatedName("as")
	@Export("ViewportMouse_entityCount")
	static int ViewportMouse_entityCount;
	@ObfuscatedName("ay")
	@Export("ViewportMouse_entityTags")
	public static long[] ViewportMouse_entityTags;
	@ObfuscatedName("kx")
	@Export("cameraX")
	static int cameraX;

	static {
		ViewportMouse_isInViewport = false;
		ViewportMouse_x = 0;
		ViewportMouse_y = 0;
		ViewportMouse_false0 = false;
		ViewportMouse_entityCount = 0;
		ViewportMouse_entityTags = new long[1000];
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lol;I)V",
		garbageValue = "181873849"
	)
	public static void method1566(AbstractArchive var0) {
		VarpDefinition.VarpDefinition_archive = var0;
		VarpDefinition.field1443 = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
	}
}