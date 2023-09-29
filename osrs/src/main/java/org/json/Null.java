package org.json;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@Implements("org/json/Null")
@ObfuscatedName("org/json/JSONObject$Null")
final class Null {
	Null() {
	}


	public final Object clone() {
		return this;
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		return var1 == null || this == var1;
	}

	public String toString() {
		return "null";
	}
}