import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ls")
@Implements("ZoneOperation")
public class ZoneOperation {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("MAPPROJ_ANIM")
	public static final ZoneOperation MAPPROJ_ANIM;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("LOC_DEL")
	public static final ZoneOperation LOC_DEL;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("OBJ_COUNT")
	public static final ZoneOperation OBJ_COUNT;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ZoneOperation field2607;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("LOC_ADD_CHANGE")
	public static final ZoneOperation LOC_ADD_CHANGE;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("AREA_SOUND")
	public static final ZoneOperation AREA_SOUND;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("LOC_ANIM")
	public static final ZoneOperation LOC_ANIM;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("OBJ_ADD")
	public static final ZoneOperation OBJ_ADD;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("OBJ_DEL_LEGACY")
	public static final ZoneOperation OBJ_DEL_LEGACY;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("MAP_ANIM")
	public static final ZoneOperation MAP_ANIM;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("PREFETCH_GAMEOBJECTS")
	public static final ZoneOperation PREFETCH_GAMEOBJECTS;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("OBJ_DEL")
	public static final ZoneOperation OBJ_DEL;

	static {
		MAPPROJ_ANIM = new ZoneOperation(5);
		LOC_DEL = new ZoneOperation(16);
		OBJ_COUNT = new ZoneOperation(4);
		field2607 = new ZoneOperation(4);
		LOC_ADD_CHANGE = new ZoneOperation(2);
		AREA_SOUND = new ZoneOperation(11);
		LOC_ANIM = new ZoneOperation(6);
		OBJ_ADD = new ZoneOperation(14);
		OBJ_DEL_LEGACY = new ZoneOperation(14);
		MAP_ANIM = new ZoneOperation(5);
		PREFETCH_GAMEOBJECTS = new ZoneOperation(7);
		OBJ_DEL = new ZoneOperation(19);
	}

	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "5"
	)
	ZoneOperation(int var1) {
	}
}