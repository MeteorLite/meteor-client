package com.jagex.oldscape.pub;

import net.runelite.mapping.Implements;

public interface OAuthApi {
   default void setOtlTokenRequester(OtlTokenRequester var1) {};

   default void setRefreshTokenRequester(RefreshAccessTokenRequester var1) {};

   default long getAccountHash() {return -1;}

   default boolean isOnLoginScreen() {return false;}
}
