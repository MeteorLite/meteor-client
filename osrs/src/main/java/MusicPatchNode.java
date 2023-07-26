import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mw")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("aw")
	int field2843;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Llm;"
	)
	@Export("table")
	MusicPatch table;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lbi;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Llk;"
	)
	MusicPatchNode2 field2846;
	@ObfuscatedName("as")
	int field2839;
	@ObfuscatedName("aj")
	int field2834;
	@ObfuscatedName("ag")
	int field2832;
	@ObfuscatedName("az")
	int field2845;
	@ObfuscatedName("av")
	int field2842;
	@ObfuscatedName("ap")
	int field2837;
	@ObfuscatedName("aq")
	int field2838;
	@ObfuscatedName("at")
	int field2840;
	@ObfuscatedName("ah")
	int field2833;
	@ObfuscatedName("ax")
	int field2844;
	@ObfuscatedName("aa")
	int field2829;
	@ObfuscatedName("au")
	int field2841;
	@ObfuscatedName("ae")
	int field2831;
	@ObfuscatedName("ab")
	int field2830;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Lbt;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("ao")
	int field2836;
	@ObfuscatedName("ak")
	int field2835;

	MusicPatchNode() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1119340106"
	)
	void method1659() {
		this.table = null;
		this.rawSound = null;
		this.field2846 = null;
		this.stream = null;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "([BZI)Ljava/lang/Object;",
		garbageValue = "-2056513709"
	)
	public static Object method1657(byte[] var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0.length > 136) {
			DirectByteArrayCopier var2 = new DirectByteArrayCopier();
			var2.set(var0);
			return var2;
		} else {
			return var0;
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Lhq;",
		garbageValue = "325991417"
	)
	@Export("getParamDefinition")
	public static ParamComposition getParamDefinition(int var0) {
		ParamComposition var1 = (ParamComposition)ParamComposition.ParamDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = ParamComposition.ParamDefinition_archive.takeFile(11, var0);
			var1 = new ParamComposition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			ParamComposition.ParamDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "-82"
	)
	static final void method1660(String var0) {
		Tile.method1160(var0 + " is already on your ignore list");
	}
}
