import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.net.MalformedURLException;
import java.net.URL;

@ObfuscatedName("dv")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
	@ObfuscatedName("ub")
	@Export("cameraLookAtX")
	static int cameraLookAtX;
	@ObfuscatedName("au")
	@Export("plane")
	int plane;
	@ObfuscatedName("ae")
	@Export("type")
	int type;
	@ObfuscatedName("ao")
	@Export("x")
	int x;
	@ObfuscatedName("at")
	@Export("y")
	int y;
	@ObfuscatedName("ac")
	@Export("objectId")
	int objectId;
	@ObfuscatedName("ai")
	int field948;
	@ObfuscatedName("az")
	int field956;
	@ObfuscatedName("ap")
	@Export("id")
	int id;
	@ObfuscatedName("aa")
	@Export("rotation")
	int rotation;
	@ObfuscatedName("af")
	@Export("objectType")
	int objectType;
	@ObfuscatedName("ad")
	int field945;
	@ObfuscatedName("al")
	int field949;
	@ObfuscatedName("an")
	@Export("startCycle")
	int startCycle;
	@ObfuscatedName("ar")
	@Export("endCycle")
	int endCycle;

	PendingSpawn() {
		this.field949 = 31;
		this.startCycle = 0;
		this.endCycle = -1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-390756021"
	)
	void method506(int var1) {
		this.field949 = var1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1725061454"
	)
	boolean method507(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field949 & 1 << var1) != 0;
		} else {
			return true;
		}
	}

	@ObfuscatedName("au")
	public static final void method505(long var0) {
		if (var0 > 0L) {
			if (0L == var0 % 10L) {
				WorldMapData_0.method1390(var0 - 1L);
				WorldMapData_0.method1390(1L);
			} else {
				WorldMapData_0.method1390(var0);
			}

		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Z",
		garbageValue = "1525376195"
	)
	static boolean method508(String var0) {
		if (var0 == null) {
			return false;
		} else {
			try {
				new URL(var0);
				return true;
			} catch (MalformedURLException var2) {
				return false;
			}
		}
	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "-1915855915"
	)
	static final void method509(boolean var0) {
		if (var0) {
			Client.field421 = Login.field743 ? class139.field1319 : class139.field1321;
		} else {
			Client.field421 = class449.clientPreferences.method568(Login.Login_username) ? class139.field1322 : class139.field1320;
		}

	}
}