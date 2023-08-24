package org.json;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@Implements("org/json/JSONString")
@ObfuscatedName("org/json/JSONString")
public interface JSONString {
	@Export("toJSONString")
	@ObfuscatedName("toJSONString")
	String toJSONString();
}