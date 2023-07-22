import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lo")
@Implements("ZoneOperation")
public class ZoneOperation {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final ZoneOperation OBJ_DEL_LEGACY;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final ZoneOperation OBJ_ADD;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final ZoneOperation AREA_SOUND;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final ZoneOperation LOC_ANIM;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final ZoneOperation OBJ_COUNT;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final ZoneOperation PREFETCH_GAMEOBJECTS;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final ZoneOperation LOC_DEL;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final ZoneOperation LOC_ADD_CHANGE;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final ZoneOperation OBJ_DEL;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final ZoneOperation MAP_ANIM;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Llo;"
	)
	public static final ZoneOperation MAPPROJ_ANIM;

	static {
		OBJ_DEL_LEGACY = new ZoneOperation(4);
		OBJ_ADD = new ZoneOperation(14);
		AREA_SOUND = new ZoneOperation(5);
		LOC_ANIM = new ZoneOperation(4);
		OBJ_COUNT = new ZoneOperation(11);
		PREFETCH_GAMEOBJECTS = new ZoneOperation(14);
		LOC_DEL = new ZoneOperation(2);
		LOC_ADD_CHANGE = new ZoneOperation(5);
		OBJ_DEL = new ZoneOperation(7);
		MAP_ANIM = new ZoneOperation(6);
		MAPPROJ_ANIM = new ZoneOperation(16);
	}

	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "4"
	)
	ZoneOperation(int var1) {
	}
}
