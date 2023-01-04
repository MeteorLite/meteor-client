import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("sb")
   @ObfuscatedSignature(
      descriptor = "Lrx;"
   )
   static SpritePixels sceneMinimapSprite;
   @ObfuscatedName("h")
   int plane;
   @ObfuscatedName("e")
   int z;
   @ObfuscatedName("v")
   int centerX;
   @ObfuscatedName("x")
   int centerY;
   @ObfuscatedName("m")
   int orientation;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   public Renderable renderable;
   @ObfuscatedName("f")
   int startX;
   @ObfuscatedName("r")
   int endX;
   @ObfuscatedName("u")
   int startY;
   @ObfuscatedName("b")
   int endY;
   @ObfuscatedName("j")
   int field2232;
   @ObfuscatedName("g")
   int lastDrawn;
   @ObfuscatedName("i")
   public long tag = 0L;
   @ObfuscatedName("o")
   int flags = 0;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "395481445"
   )
   static void method1298() {
      if (Login.Login_username == null || Login.Login_username.length() <= 0) {
         if (StructComposition.clientPreferences.getUsernameToRemember() != null) {
            Login.Login_username = StructComposition.clientPreferences.getUsernameToRemember();
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
   static void method1299(NPC var0) {
      var0.field933 = var0.definition.size;
      var0.field1001 = var0.definition.rotation;
      if (var0.field1001 == 0) {
         var0.rotation = 0;
      }

      var0.walkSequence = var0.definition.walkSequence;
      var0.walkBackSequence = var0.definition.walkBackSequence;
      var0.walkLeftSequence = var0.definition.walkLeftSequence;
      var0.walkRightSequence = var0.definition.walkRightSequence;
      var0.idleSequence = var0.definition.idleSequence;
      var0.turnLeftSequence = var0.definition.turnLeftSequence;
      var0.turnRightSequence = var0.definition.turnRightSequence;
      var0.runSequence = var0.definition.field1563;
      var0.field943 = var0.definition.field1566;
      var0.field953 = var0.definition.field1567;
      var0.field945 = var0.definition.field1568;
      var0.field946 = var0.definition.field1569;
      var0.field947 = var0.definition.field1570;
      var0.field978 = var0.definition.field1571;
      var0.field949 = var0.definition.field1572;
   }
}
