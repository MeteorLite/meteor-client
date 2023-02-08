import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("Actor")
public abstract class Actor extends Renderable {
    @ObfuscatedName("aw")
    int x;
    @ObfuscatedName("ar")
    int y;
    @ObfuscatedName("al")
    int rotation;
    @ObfuscatedName("at")
    boolean isWalking = false;
   @ObfuscatedName("aj")
   int field939 = 1;
    @ObfuscatedName("ax")
    int playerCycle;
    @ObfuscatedName("az")
    int idleSequence = -1;
    @ObfuscatedName("ap")
    int turnLeftSequence = -1;
    @ObfuscatedName("ay")
    int turnRightSequence = -1;
    @ObfuscatedName("ac")
    int walkSequence = -1;
    @ObfuscatedName("av")
    int walkBackSequence = -1;
    @ObfuscatedName("aq")
    int walkLeftSequence = -1;
    @ObfuscatedName("ak")
    int walkRightSequence = -1;
    @ObfuscatedName("au")
    int runSequence = -1;
    @ObfuscatedName("ae")
    int runBackSequence = -1;
    @ObfuscatedName("ah")
    int runLeftSequence = -1;
    @ObfuscatedName("ad")
    int runRightSequence = -1;
    @ObfuscatedName("ab")
    int crawlSequence = -1;
    @ObfuscatedName("an")
    int crawlBackSequence = -1;
    @ObfuscatedName("am")
    int crawlLeftSequence = -1;
    @ObfuscatedName("as")
    int crawlRightSequence = -1;
    @ObfuscatedName("ao")
    String overheadText = null;
   @ObfuscatedName("bj")
   boolean isAutoChatting;
   @ObfuscatedName("bf")
   boolean showPublicPlayerChat = false;
    @ObfuscatedName("bz")
    int overheadTextCyclesRemaining = 100;
   @ObfuscatedName("br")
   int field937 = 0;
   @ObfuscatedName("bm")
   int field961 = 0;
    @ObfuscatedName("bo")
    byte hitSplatCount = 0;
    @ObfuscatedName("bl")
    int[] hitSplatTypes = new int[4];
    @ObfuscatedName("bq")
    int[] hitSplatValues = new int[4];
    @ObfuscatedName("bn")
    int[] hitSplatCycles = new int[4];
    @ObfuscatedName("bi")
    int[] hitSplatTypes2 = new int[4];
    @ObfuscatedName("bw")
    int[] hitSplatValues2 = new int[4];
    @ObfuscatedName("bt")
    @ObfuscatedSignature(
            descriptor = "Lmt;"
    )
    IterableNodeDeque healthBars = new IterableNodeDeque();
    @ObfuscatedName("bd")
    int targetIndex = -1;
    @ObfuscatedName("bg")
    boolean false0 = false;
    @ObfuscatedName("bb")
    int movingOrientation = -1;
    @ObfuscatedName("bk")
    boolean instantTurn;
    @ObfuscatedName("bs")
    int movementSequence = -1;
    @ObfuscatedName("by")
    int movementFrame = 0;
    @ObfuscatedName("bu")
    int movementFrameCycle = 0;
   @ObfuscatedName("bp")
   int field976 = 0;
    @ObfuscatedName("bc")
    int sequence = -1;
    @ObfuscatedName("ba")
    int sequenceFrame = 0;
    @ObfuscatedName("bh")
    int sequenceFrameCycle = 0;
    @ObfuscatedName("bx")
    int sequenceDelay = 0;
    @ObfuscatedName("bv")
    int currentSequenceFrameIndex = 0;
    @ObfuscatedName("cu")
    int spotAnimation = -1;
    @ObfuscatedName("cr")
    int spotAnimationFrame = 0;
    @ObfuscatedName("cs")
    int spotAnimFrameCycle = 0;
    @ObfuscatedName("cp")
    int spotAnimationStartCycle;
   @ObfuscatedName("cq")
   int spotAnimHeight;
   @ObfuscatedName("cd")
   int exactMoveDeltaX1;
   @ObfuscatedName("cc")
   int exactMoveDeltaX2;
   @ObfuscatedName("ch")
   int exactMoveDeltaY1;
   @ObfuscatedName("ck")
   int exactMoveDeltaY2;
    @ObfuscatedName("cl")
    int exactMoveArrive1Cycle;
    @ObfuscatedName("cx")
    int exactMoveArrive2Cycle;
    @ObfuscatedName("ct")
    int exactMoveDirection;
    @ObfuscatedName("cb")
    int npcCycle = 0;
    @ObfuscatedName("cz")
    int defaultHeight = 200;
    @ObfuscatedName("ca")
    int recolourStartCycle = -1;
    @ObfuscatedName("cy")
    int recolourEndCycle = -1;
    @ObfuscatedName("cv")
    byte recolourHue;
    @ObfuscatedName("cf")
    byte recolourSaturation;
    @ObfuscatedName("cm")
    byte recolourLuminance;
    @ObfuscatedName("ce")
    byte recolourAmount;
    @ObfuscatedName("co")
    int orientation;
   @ObfuscatedName("cg")
   int field967 = 0;
   @ObfuscatedName("cj")
   int field1004 = 32;
    @ObfuscatedName("ci")
    int pathLength = 0;
    @ObfuscatedName("cn")
    int[] pathX = new int[10];
    @ObfuscatedName("cw")
    int[] pathY = new int[10];
    @ObfuscatedName("dw")
    @ObfuscatedSignature(
            descriptor = "[Lhz;"
    )
    MoveSpeed[] pathTraversed = new MoveSpeed[10];
   @ObfuscatedName("dz")
   int field951 = 0;
   @ObfuscatedName("db")
   int field1006 = 0;
    @ObfuscatedName("di")
    int combatLevelChange = -1;

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-967333967"
    )
    boolean isVisible() {
      return false;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1512245406"
   )
   final void method501() {
      this.pathLength = 0;
      this.field1006 = 0;
   }

    @ObfuscatedName("bl")
    @ObfuscatedSignature(
            descriptor = "(IIIIIII)V",
            garbageValue = "1738027073"
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
         HitSplatDefinition var12 = ChatChannel.method446(var1);
         var10 = var12.field1658;
         var11 = var12.field1655;
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

    @ObfuscatedName("bq")
    @ObfuscatedSignature(
            descriptor = "(IIIIIIB)V",
            garbageValue = "73"
    )
    final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
      HealthBarDefinition var7 = class122.method687(var1);
      HealthBar var8 = null;
      HealthBar var9 = null;
      int var10 = var7.int2;
      int var11 = 0;

      HealthBar var12;
      for(var12 = (HealthBar)this.healthBars.last(); var12 != null; var12 = (HealthBar)this.healthBars.previous()) {
         ++var11;
         if (var12.definition.field1517 == var7.field1517) {
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

    @ObfuscatedName("bn")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "-46712861"
    )
    final void removeHealthBar(int var1) {
      HealthBarDefinition var2 = class122.method687(var1);

      for(HealthBar var3 = (HealthBar)this.healthBars.last(); var3 != null; var3 = (HealthBar)this.healthBars.previous()) {
         if (var2 == var3.definition) {
            var3.remove();
            return;
         }
      }

   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(II)Lgn;",
            garbageValue = "-712256700"
    )
    public static StructComposition StructDefinition_getStructDefinition(int var0) {
      StructComposition var1 = (StructComposition)StructComposition.StructDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = StructComposition.StructDefinition_archive.takeFile(34, var0);
         var1 = new StructComposition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.postDecode();
         StructComposition.StructDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("kp")
   static final void method505(double var0) {
      Rasterizer3D.Rasterizer3D_setBrightness(var0);
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(var0);
      ItemComposition.ItemDefinition_cachedSprites.clear();
      PacketWriter.clientPreferences.setBrightness(var0);
   }
}
