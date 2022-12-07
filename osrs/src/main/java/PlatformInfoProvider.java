import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pd")
public interface PlatformInfoProvider {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)Lpk;",
      garbageValue = "-45"
   )
   PlatformInfo get();
}
