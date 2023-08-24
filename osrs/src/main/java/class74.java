import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.math.BigInteger;

@ObfuscatedName("ct")
public class class74 {
	@ObfuscatedName("au")
	static final BigInteger field742;
	@ObfuscatedName("ae")
	static final BigInteger field741;
	@ObfuscatedName("dg")
	@ObfuscatedSignature(
		descriptor = "[Lui;"
	)
	@Export("worldSelectBackSprites")
	static SpritePixels[] worldSelectBackSprites;

	static {
		field742 = new BigInteger("10001", 16);
		field741 = new BigInteger("9d65aa39691f5fadd6296eeee7726eab566ecc003adda321a1bf18f94cce90d5198fcdf30dca1deef73fa1deb8c1ed0731e3f4712b23ab9f180de4946043ea93a3fef2c0099f69c64d0be204a1415322032e6f60aca9aa2a420c696627b2ed49a7970bdfe1cdcf1446fa65530a3bb0b1573a3effc1086fa29016ff9cc35e8951", 16);
	}
}