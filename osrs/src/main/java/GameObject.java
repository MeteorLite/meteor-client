import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public final class GameObject {
   @ObfuscatedName("sb")
   @ObfuscatedSignature(
      descriptor = "Lrx;"
   )
   static SpritePixels sceneMinimapSprite;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1864133043
   )
   int plane;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1769154667
   )
   int z;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -472121489
   )
   int centerX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1527155529
   )
   int centerY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -835257591
   )
   int orientation;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   public Renderable renderable;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1451034711
   )
   int startX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1873413133
   )
   int endX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1389612741
   )
   int startY;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 675535951
   )
   int endY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1098759017
   )
   int field2806;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 187670921
   )
   int lastDrawn;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -7754761910240207891L
   )
   public long tag = 0L;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -799893141
   )
   int flags = 0;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "395481445"
   )
   static void method4831() {
      if (Login.Login_username == null || Login.Login_username.length() <= 0) {
         if (StructComposition.clientPreferences.method2430() != null) {
            Login.Login_username = StructComposition.clientPreferences.method2430();
            Client.Login_isUsernameRemembered = true;
         } else {
            Client.Login_isUsernameRemembered = false;
         }

      }
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      descriptor = "(Lcg;B)V",
      garbageValue = "4"
   )
   static void method4832(NPC var0) {
      var0.field1181 = var0.definition.size;
      var0.field1249 = var0.definition.rotation;
      if (var0.field1249 == 0) {
         var0.rotation = 0;
      }

      var0.walkSequence = var0.definition.walkSequence;
      var0.walkBackSequence = var0.definition.walkBackSequence;
      var0.walkLeftSequence = var0.definition.walkLeftSequence;
      var0.walkRightSequence = var0.definition.walkRightSequence;
      var0.idleSequence = var0.definition.idleSequence;
      var0.turnLeftSequence = var0.definition.turnLeftSequence;
      var0.turnRightSequence = var0.definition.turnRightSequence;
      var0.runSequence = var0.definition.field2035;
      var0.field1191 = var0.definition.field2038;
      var0.field1201 = var0.definition.field2039;
      var0.field1193 = var0.definition.field2040;
      var0.field1194 = var0.definition.field2041;
      var0.field1195 = var0.definition.field2042;
      var0.field1226 = var0.definition.field2043;
      var0.field1197 = var0.definition.field2044;
   }
}
