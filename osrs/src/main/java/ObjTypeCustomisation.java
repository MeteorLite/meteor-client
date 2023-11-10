import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("ObjTypeCustomisation")
public class ObjTypeCustomisation {
	@ObfuscatedName("aa")
	static int field1431;
	@ObfuscatedName("su")
	@ObfuscatedSignature(
		descriptor = "Lun;"
	)
	@Export("privateChatMode")
	static PrivateChatMode privateChatMode;
	@ObfuscatedName("ar")
	@Export("recol")
	public short[] recol;
	@ObfuscatedName("ao")
	@Export("retex")
	public short[] retex;

	ObjTypeCustomisation(int var1) {
		ItemComposition var2 = class214.ItemDefinition_get(var1);
		if (var2.hasRecolor()) {
			this.recol = new short[var2.recolorTo.length];
			System.arraycopy(var2.recolorTo, 0, this.recol, 0, this.recol.length);
		}

		if (var2.hasRetexture()) {
			this.retex = new short[var2.retextureTo.length];
			System.arraycopy(var2.retextureTo, 0, this.retex, 0, this.retex.length);
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-19"
	)
	public static void method876() {
		FileSystem.FileSystem_cacheFiles.clear();
	}
}