import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("com/jagex/oldscape/pub/OtlTokenResponse")
public interface OtlTokenResponse {
   @ObfuscatedName("isSuccess")
   boolean isSuccess();

   @ObfuscatedName("getToken")
   String getToken();
}
