import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("av")
   int x;
   @ObfuscatedName("au")
   int y;
   @ObfuscatedName("ar")
   int rotation;
   @ObfuscatedName("at")
   boolean isWalking = false;
   @ObfuscatedName("ay")
   int field933 = 1;
   @ObfuscatedName("an")
   int playerCycle;
   @ObfuscatedName("ab")
   int idleSequence = -1;
   @ObfuscatedName("al")
   int turnLeftSequence = -1;
   @ObfuscatedName("ag")
   int turnRightSequence = -1;
   @ObfuscatedName("az")
   int walkSequence = -1;
   @ObfuscatedName("ak")
   int walkBackSequence = -1;
   @ObfuscatedName("af")
   int walkLeftSequence = -1;
   @ObfuscatedName("ai")
   int walkRightSequence = -1;
   @ObfuscatedName("ax")
   int runSequence = -1;
   @ObfuscatedName("ah")
   int runBackSequence = -1;
   @ObfuscatedName("aw")
   int runLeftSequence = -1;
   @ObfuscatedName("aj")
   int runRightSequence = -1;
   @ObfuscatedName("aq")
   int crawlSequence = -1;
   @ObfuscatedName("ap")
   int crawlBackSequence = -1;
   @ObfuscatedName("aa")
   int crawlLeftSequence = -1;
   @ObfuscatedName("ae")
   int crawlRightSequence = -1;
   @ObfuscatedName("ac")
   String overheadText = null;
   @ObfuscatedName("bh")
   boolean isAutoChatting;
   @ObfuscatedName("be")
   boolean showPublicPlayerChat = false;
   @ObfuscatedName("bf")
   int overheadTextCyclesRemaining = 100;
   @ObfuscatedName("bo")
   int overheadTextColor = 0;
   @ObfuscatedName("by")
   int overheadTextEffect = 0;
   @ObfuscatedName("bp")
   byte hitSplatCount = 0;
   @ObfuscatedName("bc")
   int[] hitSplatTypes = new int[4];
   @ObfuscatedName("bl")
   int[] hitSplatValues = new int[4];
   @ObfuscatedName("bv")
   int[] hitSplatCycles = new int[4];
   @ObfuscatedName("bx")
   int[] hitSplatTypes2 = new int[4];
   @ObfuscatedName("bg")
   int[] hitSplatValues2 = new int[4];
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "Lmv;"
   )
   IterableNodeDeque healthBars = new IterableNodeDeque();
   @ObfuscatedName("bi")
   int targetIndex = -1;
   @ObfuscatedName("br")
   boolean false0 = false;
   @ObfuscatedName("bq")
   int movingOrientation = -1;
   @ObfuscatedName("bn")
   boolean instantTurn;
   @ObfuscatedName("ba")
   int movementSequence = -1;
   @ObfuscatedName("bs")
   int movementFrame = 0;
   @ObfuscatedName("bt")
   int movementFrameCycle = 0;
   @ObfuscatedName("bu")
   int field970 = 0;
   @ObfuscatedName("bj")
   int sequence = -1;
   @ObfuscatedName("bb")
   int sequenceFrame = 0;
   @ObfuscatedName("bm")
   int sequenceFrameCycle = 0;
   @ObfuscatedName("bk")
   int sequenceDelay = 0;
   @ObfuscatedName("bd")
   int currentSequenceFrameIndex = 0;
   @ObfuscatedName("cf")
   int spotAnimation = -1;
   @ObfuscatedName("cl")
   int spotAnimationFrame = 0;
   @ObfuscatedName("cq")
   int spotAnimFrameCycle = 0;
   @ObfuscatedName("cc")
   int spotAnimationStartCycle;
   @ObfuscatedName("cw")
   int spotAnimHeight;
   @ObfuscatedName("cx")
   int exactMoveDeltaX1;
   @ObfuscatedName("cb")
   int exactMoveDeltaX2;
   @ObfuscatedName("cs")
   int exactMoveDeltaY1;
   @ObfuscatedName("cy")
   int exactMoveDeltaY2;
   @ObfuscatedName("cp")
   int exactMoveArrive1Cycle;
   @ObfuscatedName("cj")
   int exactMoveArrive2Cycle;
   @ObfuscatedName("cn")
   int exactMoveDirection;
   @ObfuscatedName("cm")
   int npcCycle = 0;
   @ObfuscatedName("ct")
   int defaultHeight = 200;
   @ObfuscatedName("cu")
   int recolourStartCycle = -1;
   @ObfuscatedName("co")
   int recolourEndCycle = -1;
   @ObfuscatedName("ch")
   byte recolourHue;
   @ObfuscatedName("ce")
   byte recolourSaturation;
   @ObfuscatedName("cg")
   byte recolourLuminance;
   @ObfuscatedName("ca")
   byte recolourAmount;
   @ObfuscatedName("cv")
   int orientation;
   @ObfuscatedName("cz")
   int field997 = 0;
   @ObfuscatedName("cr")
   int field1001 = 32;
   @ObfuscatedName("cd")
   int pathLength = 0;
   @ObfuscatedName("ck")
   int[] pathX = new int[10];
   @ObfuscatedName("ci")
   int[] pathY = new int[10];
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      descriptor = "[Lgs;"
   )
   MoveSpeed[] pathTraversed = new MoveSpeed[10];
   @ObfuscatedName("dn")
   int field991 = 0;
   @ObfuscatedName("da")
   int field1004 = 0;
   @ObfuscatedName("de")
   int combatLevelChange = -1;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2124571860"
   )
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
