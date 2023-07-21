import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("no")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3109(0, 0),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3125(1, 0),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3107(2, 0),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3106(3, 0),
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3108(9, 2),
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3116(4, 1),
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3114(5, 1),
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3126(6, 1),
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3123(7, 1),
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3119(8, 1),
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3120(12, 2),
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3121(13, 2),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3115(14, 2),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3124(15, 2),
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3110(16, 2),
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3122(17, 2),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3113(18, 2),
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3111(19, 2),
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3112(20, 2),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3118(21, 2),
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3104(10, 2),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3105(11, 2),
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "Lno;"
	)
	field3117(22, 3);

	@ObfuscatedName("af")
	@Export("id")
	public final int id;

	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "0"
	)
	WorldMapDecorationType(int var3, int var4) {
		this.id = var3;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/Component;B)V",
		garbageValue = "48"
	)
	static void method1826(Component var0) {
		var0.addMouseListener(MouseHandler.MouseHandler_instance);
		var0.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var0.addFocusListener(MouseHandler.MouseHandler_instance);
	}

	@ObfuscatedName("nr")
	@ObfuscatedSignature(
		descriptor = "(Lmt;I)Z",
		garbageValue = "1084852448"
	)
	@Export("isComponentHidden")
	static boolean isComponentHidden(Widget var0) {
		return var0.isHidden;
	}
}
