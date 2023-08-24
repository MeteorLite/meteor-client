import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@ObfuscatedName("ba")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
	@ObfuscatedName("sh")
	@ObfuscatedSignature(
		descriptor = "Lqc;"
	)
	@Export("friendsChat")
	static FriendsChat friendsChat;
	@ObfuscatedName("au")
	@Export("id")
	int id;
	@ObfuscatedName("ae")
	@Export("size")
	int size;
	@ObfuscatedName("ao")
	@Export("operations")
	int[] operations;
	@ObfuscatedName("at")
	@Export("creationErrors")
	int[] creationErrors;
	@ObfuscatedName("ac")
	Field[] fields;
	@ObfuscatedName("ai")
	@Export("intReplaceValues")
	int[] intReplaceValues;
	@ObfuscatedName("az")
	@Export("methods")
	Method[] methods;
	@ObfuscatedName("ap")
	@Export("arguments")
	byte[][][] arguments;

	ReflectionCheck() {
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(Lmi;II)V",
		garbageValue = "-1454269975"
	)
	public static void method174(Widget var0, int var1) {
		ItemComposition var2 = InvDefinition.ItemDefinition_get(var1);
		var0.field3101.equipment[var2.maleModel] = var1 + 512;
		if (var2.maleModel1 != -1) {
			var0.field3101.equipment[var2.maleModel1] = 0;
		}

		if (var2.maleModel2 != -1) {
			var0.field3101.equipment[var2.maleModel2] = 0;
		}

		var0.field3101.method1729();
	}
}