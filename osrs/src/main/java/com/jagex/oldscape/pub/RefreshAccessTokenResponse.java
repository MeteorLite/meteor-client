package com.jagex.oldscape.pub;

import net.runelite.mapping.Implements;

public interface RefreshAccessTokenResponse {
   boolean isSuccess();

   String getAccessToken();

   String getRefreshToken();
}
