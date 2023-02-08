package com.jagex.oldscape.pub;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@Implements("com/jagex/oldscape/pub/RefreshAccessTokenResponse")
@ObfuscatedName("com/jagex/oldscape/pub/RefreshAccessTokenResponse")
public interface RefreshAccessTokenResponse {
   @Export("isSuccess")
   @ObfuscatedName("isSuccess")
   boolean isSuccess();

   @Export("getAccessToken")
   @ObfuscatedName("getAccessToken")
   String getAccessToken();

   @Export("getRefreshToken")
   @ObfuscatedName("getRefreshToken")
   String getRefreshToken();
}
