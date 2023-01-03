import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("av")
   @Export("x")
   int x;
   @ObfuscatedName("au")
   @Export("y")
   int y;
   @ObfuscatedName("ar")
   @Export("rotation")
   int rotation;
   @ObfuscatedName("at")
   @Export("isWalking")
   boolean isWalking = false;
   @ObfuscatedName("ay")
   int field933 = 1;
   @ObfuscatedName("an")
   @Export("playerCycle")
   int playerCycle;
   @ObfuscatedName("ab")
   @Export("idleSequence")
   int idleSequence = -1;
   @ObfuscatedName("al")
   @Export("turnLeftSequence")
   int turnLeftSequence = -1;
   @ObfuscatedName("ag")
   @Export("turnRightSequence")
   int turnRightSequence = -1;
   @ObfuscatedName("az")
   @Export("walkSequence")
   int walkSequence = -1;
   @ObfuscatedName("ak")
   @Export("walkBackSequence")
   int walkBackSequence = -1;
   @ObfuscatedName("af")
   @Export("walkLeftSequence")
   int walkLeftSequence = -1;
   @ObfuscatedName("ai")
   @Export("walkRightSequence")
   int walkRightSequence = -1;
   @ObfuscatedName("ax")
   @Export("runSequence")
   int runSequence = -1;
   @ObfuscatedName("ah")
   int field943 = -1;
   @ObfuscatedName("aw")
   int field953 = -1;
   @ObfuscatedName("aj")
   int field945 = -1;
   @ObfuscatedName("aq")
   int field946 = -1;
   @ObfuscatedName("ap")
   int field947 = -1;
   @ObfuscatedName("aa")
   int field978 = -1;
   @ObfuscatedName("ae")
   int field949 = -1;
   @ObfuscatedName("ac")
   @Export("overheadText")
   String overheadText = null;
   @ObfuscatedName("bh")
   @Export("isAutoChatting")
   boolean isAutoChatting;
   @ObfuscatedName("be")
   @Export("showPublicPlayerChat")
   boolean showPublicPlayerChat = false;
   @ObfuscatedName("bf")
   @Export("overheadTextCyclesRemaining")
   int overheadTextCyclesRemaining = 100;
   @ObfuscatedName("bo")
   @Export("overheadTextColor")
   int overheadTextColor = 0;
   @ObfuscatedName("by")
   @Export("overheadTextEffect")
   int overheadTextEffect = 0;
   @ObfuscatedName("bp")
   @Export("hitSplatCount")
   byte hitSplatCount = 0;
   @ObfuscatedName("bc")
   @Export("hitSplatTypes")
   int[] hitSplatTypes = new int[4];
   @ObfuscatedName("bl")
   @Export("hitSplatValues")
   int[] hitSplatValues = new int[4];
   @ObfuscatedName("bv")
   @Export("hitSplatCycles")
   int[] hitSplatCycles = new int[4];
   @ObfuscatedName("bx")
   @Export("hitSplatTypes2")
   int[] hitSplatTypes2 = new int[4];
   @ObfuscatedName("bg")
   @Export("hitSplatValues2")
   int[] hitSplatValues2 = new int[4];
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "Lmv;"
   )
   @Export("healthBars")
   IterableNodeDeque healthBars = new IterableNodeDeque();
   @ObfuscatedName("bi")
   @Export("targetIndex")
   int targetIndex = -1;
   @ObfuscatedName("br")
   @Export("false0")
   boolean false0 = false;
   @ObfuscatedName("bq")
   @Export("movingOrientation")
   int movingOrientation = -1;
   @ObfuscatedName("bn")
   @Export("instantTurn")
   boolean instantTurn;
   @ObfuscatedName("ba")
   @Export("movementSequence")
   int movementSequence = -1;
   @ObfuscatedName("bs")
   @Export("movementFrame")
   int movementFrame = 0;
   @ObfuscatedName("bt")
   @Export("movementFrameCycle")
   int movementFrameCycle = 0;
   @ObfuscatedName("bu")
   int field970 = 0;
   @ObfuscatedName("bj")
   @Export("sequence")
   int sequence = -1;
   @ObfuscatedName("bb")
   @Export("sequenceFrame")
   int sequenceFrame = 0;
   @ObfuscatedName("bm")
   @Export("sequenceFrameCycle")
   int sequenceFrameCycle = 0;
   @ObfuscatedName("bk")
   @Export("sequenceDelay")
   int sequenceDelay = 0;
   @ObfuscatedName("bd")
   @Export("currentSequenceFrameIndex")
   int currentSequenceFrameIndex = 0;
   @ObfuscatedName("cf")
   @Export("spotAnimation")
   int spotAnimation = -1;
   @ObfuscatedName("cl")
   @Export("spotAnimationFrame")
   int spotAnimationFrame = 0;
   @ObfuscatedName("cq")
   @Export("spotAnimFrameCycle")
   int spotAnimFrameCycle = 0;
   @ObfuscatedName("cc")
   @Export("spotAnimationStartCycle")
   int spotAnimationStartCycle;
   @ObfuscatedName("cw")
   @Export("spotAnimHeight")
   int spotAnimHeight;
   @ObfuscatedName("cx")
   @Export("exactMoveDeltaX1")
   int exactMoveDeltaX1;
   @ObfuscatedName("cb")
   @Export("exactMoveDeltaX2")
   int exactMoveDeltaX2;
   @ObfuscatedName("cs")
   @Export("exactMoveDeltaY1")
   int exactMoveDeltaY1;
   @ObfuscatedName("cy")
   @Export("exactMoveDeltaY2")
   int exactMoveDeltaY2;
   @ObfuscatedName("cp")
   @Export("exactMoveArrive1Cycle")
   int exactMoveArrive1Cycle;
   @ObfuscatedName("cj")
   @Export("exactMoveArrive2Cycle")
   int exactMoveArrive2Cycle;
   @ObfuscatedName("cn")
   @Export("exactMoveDirection")
   int exactMoveDirection;
   @ObfuscatedName("cm")
   @Export("npcCycle")
   int npcCycle = 0;
   @ObfuscatedName("ct")
   @Export("defaultHeight")
   int defaultHeight = 200;
   @ObfuscatedName("cu")
   @Export("recolourStartCycle")
   int recolourStartCycle = -1;
   @ObfuscatedName("co")
   @Export("recolourEndCycle")
   int recolourEndCycle = -1;
   @ObfuscatedName("ch")
   @Export("recolourHue")
   byte recolourHue;
   @ObfuscatedName("ce")
   @Export("recolourSaturation")
   byte recolourSaturation;
   @ObfuscatedName("cg")
   @Export("recolourLuminance")
   byte recolourLuminance;
   @ObfuscatedName("ca")
   @Export("recolourAmount")
   byte recolourAmount;
   @ObfuscatedName("cv")
   @Export("orientation")
   int orientation;
   @ObfuscatedName("cz")
   int field997 = 0;
   @ObfuscatedName("cr")
   int field1001 = 32;
   @ObfuscatedName("cd")
   @Export("pathLength")
   int pathLength = 0;
   @ObfuscatedName("ck")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("ci")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      descriptor = "[Lgs;"
   )
   @Export("pathTraversed")
   MoveSpeed[] pathTraversed = new MoveSpeed[10];
   @ObfuscatedName("dn")
   int field991 = 0;
   @ObfuscatedName("da")
   int field1004 = 0;
   @ObfuscatedName("de")
   @Export("combatLevelChange")
   int combatLevelChange = -1;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2124571860"
   )
   @Export("isVisible")
   boolean isVisible() {
      return false;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "226013540"
   )
   final void method512() {
      this.pathLength = 0;
      this.field1004 = 0;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(IIIIIII)V",
      garbageValue = "-45918745"
   )
   @Export("addHitSplat")
   final void addHitSplat(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if (this.hitSplatCycles[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if (var1 >= 0) {
         HitSplatDefinition var12 = class364.method1911(var1);
         var10 = var12.field1661;
         var11 = var12.field1649;
      }

      int var14;
      if (var8) {
         if (var10 == -1) {
            return;
         }

         var9 = 0;
         var14 = 0;
         if (var10 == 0) {
            var14 = this.hitSplatCycles[0];
         } else if (var10 == 1) {
            var14 = this.hitSplatValues[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if (var10 == 0) {
               if (this.hitSplatCycles[var13] < var14) {
                  var9 = var13;
                  var14 = this.hitSplatCycles[var13];
               }
            } else if (var10 == 1 && this.hitSplatValues[var13] < var14) {
               var9 = var13;
               var14 = this.hitSplatValues[var13];
            }
         }

         if (var10 == 1 && var14 >= var2) {
            return;
         }
      } else {
         if (var7) {
            this.hitSplatCount = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.hitSplatCount;
            this.hitSplatCount = (byte)((this.hitSplatCount + 1) % 4);
            if (this.hitSplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if (var9 >= 0) {
         this.hitSplatTypes[var9] = var1;
         this.hitSplatValues[var9] = var2;
         this.hitSplatTypes2[var9] = var3;
         this.hitSplatValues2[var9] = var4;
         this.hitSplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(IIIIIII)V",
      garbageValue = "1256732773"
   )
   @Export("addHealthBar")
   final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
      HealthBarDefinition var8 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var1);
      HealthBarDefinition var7;
      if (var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var1);
         var8 = new HealthBarDefinition();
         if (var9 != null) {
            var8.decode(new Buffer(var9));
         }

         HealthBarDefinition.HealthBarDefinition_cached.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      HealthBar var14 = null;
      HealthBar var10 = null;
      int var11 = var7.int2;
      int var12 = 0;

      HealthBar var13;
      for(var13 = (HealthBar)this.healthBars.last(); var13 != null; var13 = (HealthBar)this.healthBars.previous()) {
         ++var12;
         if (var13.definition.field1520 == var8.field1520) {
            var13.put(var2 + var4, var5, var6, var3);
            return;
         }

         if (var13.definition.int1 <= var8.int1) {
            var14 = var13;
         }

         if (var13.definition.int2 > var11) {
            var10 = var13;
            var11 = var13.definition.int2;
         }
      }

      if (var10 != null || var12 < 4) {
         var13 = new HealthBar(var8);
         if (var14 == null) {
            this.healthBars.addLast(var13);
         } else {
            IterableNodeDeque.IterableNodeDeque_addBefore(var13, var14);
         }

         var13.put(var2 + var4, var5, var6, var3);
         if (var12 >= 4) {
            var10.remove();
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "0"
   )
   @Export("removeHealthBar")
   final void removeHealthBar(int var1) {
      HealthBarDefinition var3 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var1);
      HealthBarDefinition var2;
      if (var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var1);
         var3 = new HealthBarDefinition();
         if (var4 != null) {
            var3.decode(new Buffer(var4));
         }

         HealthBarDefinition.HealthBarDefinition_cached.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(HealthBar var5 = (HealthBar)this.healthBars.last(); var5 != null; var5 = (HealthBar)this.healthBars.previous()) {
         if (var3 == var5.definition) {
            var5.remove();
            return;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "1295308947"
   )
   public static int method516(int var0) {
      return class284.field2697[var0];
   }
}
