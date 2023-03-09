import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("an")
   @Export("isWalking")
   boolean isWalking = false;
   @ObfuscatedName("bh")
   @Export("x")
   int x;
   @ObfuscatedName("bl")
   @Export("y")
   int y;
   @ObfuscatedName("bk")
   @Export("rotation")
   int rotation;
   @ObfuscatedName("br")
   int field931 = 1;
   @ObfuscatedName("ba")
   @Export("playerCycle")
   int playerCycle;
   @ObfuscatedName("bz")
   @Export("idleSequence")
   int idleSequence = -1;
   @ObfuscatedName("bq")
   @Export("turnLeftSequence")
   int turnLeftSequence = -1;
   @ObfuscatedName("bc")
   @Export("turnRightSequence")
   int turnRightSequence = -1;
   @ObfuscatedName("bt")
   @Export("walkSequence")
   int walkSequence = -1;
   @ObfuscatedName("be")
   @Export("walkBackSequence")
   int walkBackSequence = -1;
   @ObfuscatedName("bu")
   @Export("walkLeftSequence")
   int walkLeftSequence = -1;
   @ObfuscatedName("bd")
   @Export("walkRightSequence")
   int walkRightSequence = -1;
   @ObfuscatedName("by")
   @Export("runSequence")
   int runSequence = -1;
   @ObfuscatedName("bp")
   @Export("runBackSequence")
   int runBackSequence = -1;
   @ObfuscatedName("bb")
   @Export("runLeftSequence")
   int runLeftSequence = -1;
   @ObfuscatedName("bx")
   @Export("runRightSequence")
   int runRightSequence = -1;
   @ObfuscatedName("bn")
   @Export("crawlSequence")
   int crawlSequence = -1;
   @ObfuscatedName("bj")
   @Export("crawlBackSequence")
   int crawlBackSequence = -1;
   @ObfuscatedName("bf")
   @Export("crawlLeftSequence")
   int crawlLeftSequence = -1;
   @ObfuscatedName("bw")
   @Export("crawlRightSequence")
   int crawlRightSequence = -1;
   @ObfuscatedName("bi")
   @Export("overheadText")
   String overheadText = null;
   @ObfuscatedName("cl")
   @Export("isAutoChatting")
   boolean isAutoChatting;
   @ObfuscatedName("ca")
   @Export("showPublicPlayerChat")
   boolean showPublicPlayerChat = false;
   @ObfuscatedName("cb")
   @Export("overheadTextCyclesRemaining")
   int overheadTextCyclesRemaining = 100;
   @ObfuscatedName("co")
   int field952 = 0;
   @ObfuscatedName("cj")
   int field945 = 0;
   @ObfuscatedName("ce")
   @Export("hitSplatCount")
   byte hitSplatCount = 0;
   @ObfuscatedName("cd")
   @Export("hitSplatTypes")
   int[] hitSplatTypes = new int[4];
   @ObfuscatedName("cc")
   @Export("hitSplatValues")
   int[] hitSplatValues = new int[4];
   @ObfuscatedName("ct")
   @Export("hitSplatCycles")
   int[] hitSplatCycles = new int[4];
   @ObfuscatedName("cy")
   @Export("hitSplatTypes2")
   int[] hitSplatTypes2 = new int[4];
   @ObfuscatedName("ck")
   @Export("hitSplatValues2")
   int[] hitSplatValues2 = new int[4];
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      descriptor = "Lni;"
   )
   @Export("healthBars")
   IterableNodeDeque healthBars = new IterableNodeDeque();
   @ObfuscatedName("cg")
   @Export("targetIndex")
   int targetIndex = -1;
   @ObfuscatedName("ch")
   @Export("false0")
   boolean false0 = false;
   @ObfuscatedName("cs")
   @Export("movingOrientation")
   int movingOrientation = -1;
   @ObfuscatedName("cq")
   int field969 = -1;
   @ObfuscatedName("cx")
   int field965 = -1;
   @ObfuscatedName("cu")
   boolean field946;
   @ObfuscatedName("cm")
   @Export("movementSequence")
   int movementSequence = -1;
   @ObfuscatedName("cw")
   @Export("movementFrame")
   int movementFrame = 0;
   @ObfuscatedName("cp")
   int movementFrameCycle = 0;
   @ObfuscatedName("ci")
   int field970 = 0;
   @ObfuscatedName("cf")
   @Export("sequence")
   int sequence = -1;
   @ObfuscatedName("cv")
   @Export("sequenceFrame")
   int sequenceFrame = 0;
   @ObfuscatedName("cr")
   @Export("sequenceFrameCycle")
   int sequenceFrameCycle = 0;
   @ObfuscatedName("du")
   @Export("sequenceDelay")
   int sequenceDelay = 0;
   @ObfuscatedName("dg")
   @Export("currentSequenceFrameIndex")
   int currentSequenceFrameIndex = 0;
   @ObfuscatedName("dc")
   @Export("spotAnimation")
   int spotAnimation = -1;
   @ObfuscatedName("dp")
   @Export("spotAnimationFrame")
   int spotAnimationFrame = 0;
   @ObfuscatedName("dk")
   int field964 = 0;
   @ObfuscatedName("dr")
   int spotAnimationStartCycle;
   @ObfuscatedName("de")
   int spotAnimHeight;
   @ObfuscatedName("dx")
   int exactMoveDeltaX1;
   @ObfuscatedName("ds")
   int exactMoveDeltaX2;
   @ObfuscatedName("dd")
   int exactMoveDeltaY1;
   @ObfuscatedName("dv")
   int exactMoveDeltaY2;
   @ObfuscatedName("dh")
   @Export("exactMoveArrive1Cycle")
   int exactMoveArrive1Cycle;
   @ObfuscatedName("dj")
   @Export("exactMoveArrive2Cycle")
   int exactMoveArrive2Cycle;
   @ObfuscatedName("da")
   @Export("exactMoveDirection")
   int exactMoveDirection;
   @ObfuscatedName("dq")
   @Export("npcCycle")
   int npcCycle = 0;
   @ObfuscatedName("dw")
   @Export("defaultHeight")
   int defaultHeight = 200;
   @ObfuscatedName("dt")
   @Export("recolourStartCycle")
   int recolourStartCycle = -1;
   @ObfuscatedName("db")
   @Export("recolourEndCycle")
   int recolourEndCycle = -1;
   @ObfuscatedName("dm")
   @Export("recolourHue")
   byte recolourHue;
   @ObfuscatedName("dz")
   @Export("recolourSaturation")
   byte recolourSaturation;
   @ObfuscatedName("dl")
   @Export("recolourLuminance")
   byte recolourLuminance;
   @ObfuscatedName("df")
   @Export("recolourAmount")
   byte recolourAmount;
   @ObfuscatedName("dy")
   @Export("orientation")
   int orientation;
   @ObfuscatedName("do")
   int field997 = 0;
   @ObfuscatedName("dn")
   int field998 = 32;
   @ObfuscatedName("di")
   @Export("pathLength")
   int pathLength = 0;
   @ObfuscatedName("en")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("ei")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      descriptor = "[Lis;"
   )
   @Export("pathTraversed")
   MoveSpeed[] pathTraversed = new MoveSpeed[10];
   @ObfuscatedName("ex")
   int field1003 = 0;
   @ObfuscatedName("ep")
   int field1004 = 0;
   @ObfuscatedName("eb")
   @Export("combatLevelChange")
   int combatLevelChange = -1;

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1187706422"
   )
   @Export("isVisible")
   boolean isVisible() {
      return false;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "1"
   )
   final void method509() {
      this.pathLength = 0;
      this.field1004 = 0;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIB)V",
      garbageValue = "1"
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
         HitSplatDefinition var12 = NewShit.method958(var1);
         var10 = var12.field1652;
         var11 = var12.field1644;
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

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "(IIIIIII)V",
      garbageValue = "-2123887600"
   )
   @Export("addHealthBar")
   final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
      HealthBarDefinition var7 = HealthBar.method553(var1);
      HealthBar var8 = null;
      HealthBar var9 = null;
      int var10 = var7.int2;
      int var11 = 0;

      HealthBar var12;
      for(var12 = (HealthBar)this.healthBars.last(); var12 != null; var12 = (HealthBar)this.healthBars.previous()) {
         ++var11;
         if (var12.definition.field1511 == var7.field1511) {
            var12.put(var2 + var4, var5, var6, var3);
            return;
         }

         if (var12.definition.int1 <= var7.int1) {
            var8 = var12;
         }

         if (var12.definition.int2 > var10) {
            var9 = var12;
            var10 = var12.definition.int2;
         }
      }

      if (var9 != null || var11 < 4) {
         var12 = new HealthBar(var7);
         if (var8 == null) {
            this.healthBars.addLast(var12);
         } else {
            IterableNodeDeque.IterableNodeDeque_addBefore(var12, var8);
         }

         var12.put(var2 + var4, var5, var6, var3);
         if (var11 >= 4) {
            var9.remove();
         }

      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1332495526"
   )
   @Export("removeHealthBar")
   final void removeHealthBar(int var1) {
      HealthBarDefinition var2 = HealthBar.method553(var1);

      for(HealthBar var3 = (HealthBar)this.healthBars.last(); var3 != null; var3 = (HealthBar)this.healthBars.previous()) {
         if (var2 == var3.definition) {
            var3.remove();
            return;
         }
      }

   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1487000942"
   )
   void method507() {
      this.field946 = false;
      this.movingOrientation = -1;
      this.field969 = -1;
      this.field965 = -1;
   }
}
