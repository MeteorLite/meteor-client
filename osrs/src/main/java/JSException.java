import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pq")
@Implements("netscape/js/JSException")
public class JSException extends RuntimeException {
	@ObfuscatedName("kl")
	@ObfuscatedSignature(
		descriptor = "Lud;"
	)
	@Export("compass")
	static SpritePixels compass;

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)[Llq;",
		garbageValue = "1413170050"
	)
	public static ZoneOperation[] method2055() {
		return new ZoneOperation[]{ZoneOperation.LOC_ADD_CHANGE,
				ZoneOperation.LOC_ANIM,
				ZoneOperation.LOC_DEL,
				ZoneOperation.OBJ_DEL,
				ZoneOperation.field2624,
				ZoneOperation.OBJ_COUNT,
				ZoneOperation.PREFETCH_GAMEOBJECTS,
				ZoneOperation.field2617,
				ZoneOperation.field2623,
				ZoneOperation.OBJ_ADD,
				ZoneOperation.field2619,
				ZoneOperation.AREA_SOUND,
				ZoneOperation.MAPPROJ_ANIM};
	}
}