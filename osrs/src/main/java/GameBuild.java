import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lz")
public class GameBuild {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Llz;"
   )
   static final GameBuild LIVE = new GameBuild("LIVE", 0);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Llz;"
   )
   static final GameBuild BUILDLIVE = new GameBuild("BUILDLIVE", 3);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Llz;"
   )
   static final GameBuild RC = new GameBuild("RC", 1);
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Llz;"
   )
   static final GameBuild WIP = new GameBuild("WIP", 2);
   @ObfuscatedName("m")
   public final String name;
   @ObfuscatedName("q")
   final int buildId;

   GameBuild(String var1, int var2) {
      this.name = var1;
      this.buildId = var2;
   }
}
