import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lq")
@Implements("ZoneOperation")
public class ZoneOperation {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	@Export("LOC_ADD_CHANGE")
	public static final ZoneOperation LOC_ADD_CHANGE;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	@Export("LOC_ANIM")
	public static final ZoneOperation LOC_ANIM;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	@Export("LOC_DEL")
	public static final ZoneOperation LOC_DEL;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	@Export("OBJ_DEL")
	public static final ZoneOperation OBJ_DEL;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	public static final ZoneOperation field2624;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	@Export("OBJ_COUNT")
	public static final ZoneOperation OBJ_COUNT;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	@Export("PREFETCH_GAMEOBJECTS")
	public static final ZoneOperation PREFETCH_GAMEOBJECTS;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	public static final ZoneOperation field2617;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	public static final ZoneOperation field2623;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	@Export("OBJ_ADD")
	public static final ZoneOperation OBJ_ADD;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	public static final ZoneOperation field2619;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	@Export("AREA_SOUND")
	public static final ZoneOperation AREA_SOUND;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	@Export("MAPPROJ_ANIM")
	public static final ZoneOperation MAPPROJ_ANIM;

	static {
		LOC_ADD_CHANGE = new ZoneOperation(5);
		LOC_ANIM = new ZoneOperation(4);
		LOC_DEL = new ZoneOperation(7);
		OBJ_DEL = new ZoneOperation(4);
		field2624 = new ZoneOperation(14);
		OBJ_COUNT = new ZoneOperation(16);
		PREFETCH_GAMEOBJECTS = new ZoneOperation(14);
		field2617 = new ZoneOperation(6);
		field2623 = new ZoneOperation(5);
		OBJ_ADD = new ZoneOperation(19);
		field2619 = new ZoneOperation(11);
		AREA_SOUND = new ZoneOperation(2);
		MAPPROJ_ANIM = new ZoneOperation(20);
	}

	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "5"
	)
	ZoneOperation(int var1) {
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lom;II)Lmq;",
		garbageValue = "-1598987475"
	)
	static MusicPatch method1643(AbstractArchive var0, int var1) {
		byte[] var2 = var0.takeFileFlat(var1);
		return var2 == null ? null : new MusicPatch(var2);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-191003094"
	)
	static void method1644() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var0.obj != null) {
				var0.set();
			}
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)Luz;",
		garbageValue = "-108536845"
	)
	@Export("getDbTableType")
	public static DbTableType getDbTableType(int var0) {
		DbTableType var1 = (DbTableType)DbTableType.DBTableType_cache.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = DbTableType.field4138.takeFile(39, var0);
			var1 = new DbTableType();
			if (var2 != null) {
				var1.method2538(new Buffer(var2));
			}

			var1.method2540();
			DbTableType.DBTableType_cache.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(Lnm;II)V",
		garbageValue = "-1795308286"
	)
	public static void method1645(Widget var0, int var1) {
		ItemComposition var2 = class214.ItemDefinition_get(var1);
		var0.field3127.equipment[var2.maleModel] = var1 + 512;
		if (var2.maleModel1 != -1) {
			var0.field3127.equipment[var2.maleModel1] = 0;
		}

		if (var2.maleModel2 != -1) {
			var0.field3127.equipment[var2.maleModel2] = 0;
		}

		var0.field3127.method1760();
	}
}