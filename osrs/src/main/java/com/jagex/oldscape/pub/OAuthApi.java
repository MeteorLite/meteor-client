package com.jagex.oldscape.pub;

import net.runelite.mapping.ObfuscatedSignature;

public interface OAuthApi {
	long getAccountHash();

	boolean isOnLoginScreen();

	@ObfuscatedSignature(
		descriptor = "(Lcom/jagex/oldscape/pub/RefreshAccessTokenRequester;)V"
	)
	void setRefreshTokenRequester(OtlTokenRequester var1);

	void setOtlTokenRequester(com.jagex.oldscape.pub.OtlTokenRequester var1);
}
