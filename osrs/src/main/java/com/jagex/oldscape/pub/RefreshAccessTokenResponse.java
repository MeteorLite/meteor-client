package com.jagex.oldscape.pub;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@Implements("com/jagex/oldscape/pub/RefreshAccessTokenResponse")
@ObfuscatedName("com/jagex/oldscape/pub/RefreshAccessTokenResponse")
public interface RefreshAccessTokenResponse {
	boolean isSuccess();

	String getAccessToken();

	String getRefreshToken();
}
