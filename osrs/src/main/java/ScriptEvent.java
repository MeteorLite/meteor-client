import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
	@ObfuscatedName("at")
	@Export("args")
	Object[] args;
	@ObfuscatedName("ah")
	boolean field866;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lnn;"
	)
	@Export("widget")
	Widget widget;
	@ObfuscatedName("ao")
	@Export("mouseX")
	int mouseX;
	@ObfuscatedName("ab")
	@Export("mouseY")
	int mouseY;
	@ObfuscatedName("au")
	@Export("opIndex")
	int opIndex;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lnn;"
	)
	@Export("dragTarget")
	Widget dragTarget;
	@ObfuscatedName("ac")
	@Export("keyTyped")
	int keyTyped;
	@ObfuscatedName("al")
	@Export("keyPressed")
	int keyPressed;
	@ObfuscatedName("az")
	@Export("targetName")
	String targetName;
	@ObfuscatedName("ap")
	int field871;
	@ObfuscatedName("av")
	@Export("type")
	int type;

	public ScriptEvent() {
		this.type = 76;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/Object;I)V",
		garbageValue = "-1214962197"
	)
	@Export("setArgs")
	public void setArgs(Object[] var1) {
		this.args = var1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "334360487"
	)
	@Export("setType")
	public void setType(int var1) {
		this.type = var1;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lnn;B)V",
		garbageValue = "102"
	)
	public void method467(Widget var1) {
		this.widget = var1;
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZB)I",
		garbageValue = "0"
	)
	static int method468(int var0, Script var1, boolean var2) {
		return 2;
	}
}