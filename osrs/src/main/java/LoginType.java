import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sl")
@Implements("LoginType")
public class LoginType {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lsl;"
	)
	@Export("oldscape")
	public static final LoginType oldscape;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lsl;"
	)
	static final LoginType field4069;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lsl;"
	)
	static final LoginType field4071;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lsl;"
	)
	static final LoginType field4073;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lsl;"
	)
	static final LoginType field4068;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lsl;"
	)
	static final LoginType field4070;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lsl;"
	)
	static final LoginType field4074;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lsl;"
	)
	static final LoginType field4072;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lsl;"
	)
	public static final LoginType field4066;
	@ObfuscatedName("af")
	public final int field4076;
	@ObfuscatedName("ad")
	final String field4075;

	static {
		oldscape = new LoginType(8, 0, "", "");
		field4069 = new LoginType(4, 1, "", "");
		field4071 = new LoginType(1, 2, "", "");
		field4073 = new LoginType(6, 3, "", "");
		field4068 = new LoginType(2, 4, "", "");
		field4070 = new LoginType(0, 5, "", "");
		field4074 = new LoginType(5, 6, "", "");
		field4072 = new LoginType(7, 7, "", "");
		field4066 = new LoginType(3, -1, "", "", true, new LoginType[]{oldscape, field4069, field4071, field4068, field4073});
	}

	LoginType(int var1, int var2, String var3, String var4) {
		this.field4076 = var1;
		this.field4075 = var4;
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/String;Ljava/lang/String;Z[Lsl;)V"
	)
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4076 = var1;
		this.field4075 = var4;
	}

	@Export("toString")
	@ObfuscatedName("toString")
	public String toString() {
		return this.field4075;
	}

	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		descriptor = "(Ldf;III)V",
		garbageValue = "-1416218434"
	)
	@Export("performPlayerAnimation")
	static void performPlayerAnimation(Player var0, int var1, int var2) {
		if (var0.sequence == var1 && var1 != -1) {
			int var3 = EnumComposition.SequenceDefinition_get(var1).replyMode;
			if (var3 == 1) {
				var0.sequenceFrame = 0;
				var0.sequenceFrameCycle = 0;
				var0.sequenceDelay = var2;
				var0.currentSequenceFrameIndex = 0;
			}

			if (var3 == 2) {
				var0.currentSequenceFrameIndex = 0;
			}
		} else if (var1 == -1 || var0.sequence == -1 || EnumComposition.SequenceDefinition_get(var1).forcedPriority >= EnumComposition.SequenceDefinition_get(var0.sequence).forcedPriority) {
			var0.sequence = var1;
			var0.sequenceFrame = 0;
			var0.sequenceFrameCycle = 0;
			var0.sequenceDelay = var2;
			var0.currentSequenceFrameIndex = 0;
			var0.field1022 = var0.pathLength;
		}

	}
}