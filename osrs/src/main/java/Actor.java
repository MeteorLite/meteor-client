import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public abstract class Actor extends Renderable {
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -389894911
   )
   int x;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 65440413
   )
   int y;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1214343763
   )
   int rotation;
   @ObfuscatedName("at")
   boolean isWalking = false;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 670600495
   )
   int field1181 = 1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 627237213
   )
   int playerCycle;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -345007929
   )
   int idleSequence = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 285862749
   )
   int turnLeftSequence = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1599221413
   )
   int turnRightSequence = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 498947341
   )
   int walkSequence = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1244346649
   )
   int walkBackSequence = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1074551991
   )
   int walkLeftSequence = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 635132903
   )
   int walkRightSequence = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 942099641
   )
   int runSequence = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1991306379
   )
   int field1191 = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1794639095
   )
   int field1201 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -780518925
   )
   int field1193 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1001233629
   )
   int field1194 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1165960723
   )
   int field1195 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1684483195
   )
   int field1226 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 496030663
   )
   int field1197 = -1;
   @ObfuscatedName("ac")
   String overheadText = null;
   @ObfuscatedName("bh")
   boolean isAutoChatting;
   @ObfuscatedName("be")
   boolean showPublicPlayerChat = false;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1917412835
   )
   int overheadTextCyclesRemaining = 100;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1708374603
   )
   int overheadTextColor = 0;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1814648137
   )
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
   @ObfuscatedGetter(
      intValue = 254868797
   )
   int targetIndex = -1;
   @ObfuscatedName("br")
   boolean false0 = false;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1743725497
   )
   int movingOrientation = -1;
   @ObfuscatedName("bn")
   boolean instantTurn;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -23593053
   )
   int movementSequence = -1;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1618805973
   )
   int movementFrame = 0;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 81322447
   )
   int movementFrameCycle = 0;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 623693747
   )
   int field1218 = 0;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 94737613
   )
   int sequence = -1;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1723796857
   )
   int sequenceFrame = 0;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1043036109
   )
   int sequenceFrameCycle = 0;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1398805233
   )
   int sequenceDelay = 0;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 203372551
   )
   int currentSequenceFrameIndex = 0;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 385930223
   )
   int spotAnimation = -1;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1092439411
   )
   int spotAnimationFrame = 0;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -4845983
   )
   int spotAnimFrameCycle = 0;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1151499147
   )
   int spotAnimationStartCycle;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1672871789
   )
   int spotAnimHeight;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1740141433
   )
   int exactMoveDeltaX1;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 17282343
   )
   int exactMoveDeltaX2;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1947883815
   )
   int exactMoveDeltaY1;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -749405229
   )
   int exactMoveDeltaY2;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -526209475
   )
   int exactMoveArrive1Cycle;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -140925909
   )
   int exactMoveArrive2Cycle;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 244421825
   )
   int exactMoveDirection;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -5311601
   )
   int npcCycle = 0;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 1571258463
   )
   int defaultHeight = 200;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1291773733
   )
   int recolourStartCycle = -1;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -1011438041
   )
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
   @ObfuscatedGetter(
      intValue = -947520985
   )
   int orientation;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -306091521
   )
   int field1245 = 0;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -1951063541
   )
   int field1249 = 32;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 472227045
   )
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
   @ObfuscatedGetter(
      intValue = -346153835
   )
   int field1239 = 0;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 2136239977
   )
   int field1252 = 0;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 1485827703
   )
   int combatLevelChange = -1;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-200769249"
   )
   boolean isVisible() {
      return false;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "226013540"
   )
   final void method2348() {
      this.pathLength = 0;
      this.field1252 = 0;
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
         HitSplatDefinition var12 = class364.method6987(var1);
         var10 = var12.field2146;
         var11 = var12.field2132;
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
         if (var13.definition.field1983 == var8.field1983) {
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
   public static int method2362(int var0) {
      return class284.field3329[var0];
   }
}
