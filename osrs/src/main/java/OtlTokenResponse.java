import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@Implements("OtlTokenResponse")
@ObfuscatedName("com/jagex/oldscape/pub/OtlTokenResponse")
public interface OtlTokenResponse {
	@Export("isSuccess")
	@ObfuscatedName("isSuccess")
	boolean isSuccess();

	@Export("getToken")
	@ObfuscatedName("getToken")
	String getToken();
}