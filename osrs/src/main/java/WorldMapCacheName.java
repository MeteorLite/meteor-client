import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lkg;"
   )
   public static final WorldMapCacheName field2394 = new WorldMapCacheName("details");
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lkg;"
   )
   public static final WorldMapCacheName field2389 = new WorldMapCacheName("compositemap");
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lkg;"
   )
   public static final WorldMapCacheName field2391 = new WorldMapCacheName("compositetexture");
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lkg;"
   )
   static final WorldMapCacheName field2388 = new WorldMapCacheName("area");
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lkg;"
   )
   public static final WorldMapCacheName field2392 = new WorldMapCacheName("labels");
   @ObfuscatedName("sl")
   @ObfuscatedSignature(
      descriptor = "Lfi;"
   )
   @Export("guestClanSettings")
   static ClanSettings guestClanSettings;
   @ObfuscatedName("ao")
   @Export("name")
   public final String name;

   WorldMapCacheName(String var1) {
      this.name = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "295942057"
   )
   public static boolean method1487() {
      ReflectionCheck var0 = (ReflectionCheck)class36.reflectionChecks.last();
      return var0 != null;
   }
}
