import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class33 {
	@ObfuscatedName("aa")
	int field90;
	@ObfuscatedName("ac")
	int field91;

	class33(int var1, int var2) {
		this.field90 = var1;
		this.field91 = var2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lbi;I)Z",
		garbageValue = "1979217570"
	)
	boolean method142(class29 var1) {
		if (var1 == null) {
			return false;
		} else {
			switch(this.field90) {
			case 1:
				return var1.vmethod3949(this.field91);
			case 2:
				return var1.vmethod3989(this.field91);
			case 3:
				return var1.vmethod3951((char)this.field91);
			case 4:
				return var1.vmethod3953(this.field91 == 1);
			default:
				return false;
			}
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)I",
		garbageValue = "1755486935"
	)
	static int method143(String var0) {
		if (var0.equals("centre")) {
			return 1;
		} else {
			return !var0.equals("bottom") && !var0.equals("right") ? 0 : 2;
		}
	}

	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		descriptor = "(Ldn;I)V",
		garbageValue = "-56685834"
	)
	static void method144(NPC var0) {
		var0.field983 = var0.definition.size;
		var0.field1018 = var0.definition.rotation;
		var0.walkSequence = var0.definition.walkSequence;
		var0.walkBackSequence = var0.definition.walkBackSequence;
		var0.walkLeftSequence = var0.definition.walkLeftSequence;
		var0.walkRightSequence = var0.definition.walkRightSequence;
		var0.idleSequence = var0.definition.idleSequence;
		var0.turnLeftSequence = var0.definition.turnLeftSequence;
		var0.turnRightSequence = var0.definition.turnRightSequence;
		var0.runSequence = var0.definition.runSequence;
		var0.runBackSequence = var0.definition.runBackSequence;
		var0.runLeftSequence = var0.definition.runLeftSequence;
		var0.runRightSequence = var0.definition.runRightSequence;
		var0.crawlSequence = var0.definition.crawlSequence;
		var0.crawlBackSequence = var0.definition.crawlBackSequence;
		var0.crawlLeftSequence = var0.definition.crawlLeftSequence;
		var0.crawlRightSequence = var0.definition.crawlRightSequence;
	}
}