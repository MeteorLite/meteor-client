import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("Actor")
public abstract class Actor extends Renderable {
    @ObfuscatedName("an")
    boolean isWalking = false;
    @ObfuscatedName("bx")
    int x;
    @ObfuscatedName("bo")
    int y;
    @ObfuscatedName("bz")
    int rotation;
   @ObfuscatedName("bm")
   int field936 = 1;
    @ObfuscatedName("bd")
    int playerCycle;
    @ObfuscatedName("bt")
    int idleSequence = -1;
    @ObfuscatedName("bj")
    int turnLeftSequence = -1;
    @ObfuscatedName("bn")
    int turnRightSequence = -1;
    @ObfuscatedName("bs")
    int walkSequence = -1;
    @ObfuscatedName("br")
    int walkBackSequence = -1;
    @ObfuscatedName("bg")
    int walkLeftSequence = -1;
    @ObfuscatedName("bu")
    int walkRightSequence = -1;
    @ObfuscatedName("bf")
    int runSequence = -1;
    @ObfuscatedName("bq")
    int runBackSequence = -1;
    @ObfuscatedName("ba")
    int runLeftSequence = -1;
    @ObfuscatedName("bv")
    int runRightSequence = -1;
    @ObfuscatedName("bl")
    int crawlSequence = -1;
    @ObfuscatedName("bp")
    int crawlBackSequence = -1;
    @ObfuscatedName("bc")
    int crawlLeftSequence = -1;
    @ObfuscatedName("bh")
    int crawlRightSequence = -1;
    @ObfuscatedName("bw")
    String overheadText = null;
    @ObfuscatedName("ce")
    boolean isAutoChatting;
    @ObfuscatedName("ci")
    boolean showPublicPlayerChat = false;
    @ObfuscatedName("cs")
    int overheadTextCyclesRemaining = 100;
   @ObfuscatedName("cc")
   int field957 = 0;
   @ObfuscatedName("cn")
   int field1002 = 0;
    @ObfuscatedName("cu")
    byte hitSplatCount = 0;
    @ObfuscatedName("ck")
    int[] hitSplatTypes = new int[4];
    @ObfuscatedName("cq")
    int[] hitSplatValues = new int[4];
    @ObfuscatedName("cm")
    int[] hitSplatCycles = new int[4];
    @ObfuscatedName("cf")
    int[] hitSplatTypes2 = new int[4];
    @ObfuscatedName("cl")
    int[] hitSplatValues2 = new int[4];
    @ObfuscatedName("cg")
    @ObfuscatedSignature(
            descriptor = "Loi;"
    )
    IterableNodeDeque healthBars = new IterableNodeDeque();
    @ObfuscatedName("cr")
    int targetIndex = -1;
    @ObfuscatedName("cy")
    boolean false0 = false;
    @ObfuscatedName("cx")
    int movingOrientation = -1;
   @ObfuscatedName("cv")
   int field993 = -1;
   @ObfuscatedName("cb")
   int field970 = -1;
   @ObfuscatedName("co")
   boolean field938;
    @ObfuscatedName("cz")
    int movementSequence = -1;
    @ObfuscatedName("cw")
    int movementFrame = 0;
    @ObfuscatedName("cj")
    int movementFrameCycle = 0;
   @ObfuscatedName("ch")
   int field975 = 0;
    @ObfuscatedName("ct")
    int sequence = -1;
    @ObfuscatedName("cp")
    int sequenceFrame = 0;
    @ObfuscatedName("cd")
    int sequenceFrameCycle = 0;
    @ObfuscatedName("dm")
    int sequenceDelay = 0;
    @ObfuscatedName("dw")
    int currentSequenceFrameIndex = 0;
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      descriptor = "Lro;"
   )
   IterableNodeHashTable spotAnimations = new IterableNodeHashTable(4);
   @ObfuscatedName("do")
   int graphicsCount = 0;
   @ObfuscatedName("di")
   int field983;
   @ObfuscatedName("dr")
   int field984;
   @ObfuscatedName("dl")
   int field985;
   @ObfuscatedName("dk")
   int field1003;
    @ObfuscatedName("dt")
    int spotAnimation;
    @ObfuscatedName("dv")
    int exactMoveArrive1Cycle;
    @ObfuscatedName("dz")
    int exactMoveDirection;
    @ObfuscatedName("dg")
    int npcCycle = 0;
    @ObfuscatedName("de")
    int defaultHeight = 200;
    @ObfuscatedName("dh")
    int recolourStartCycle = -1;
    @ObfuscatedName("dp")
    int recolourEndCycle = -1;
    @ObfuscatedName("du")
    byte recolourHue;
    @ObfuscatedName("db")
    byte recolourSaturation;
    @ObfuscatedName("df")
    byte recolourLuminance;
    @ObfuscatedName("dq")
    byte recolourAmount;
    @ObfuscatedName("dd")
    int orientation;
   @ObfuscatedName("dj")
   int field999 = 0;
   @ObfuscatedName("dx")
   int field986 = 32;
    @ObfuscatedName("dn")
    int pathLength = 0;
    @ObfuscatedName("dy")
    int[] pathX = new int[10];
    @ObfuscatedName("ds")
    int[] pathY = new int[10];
    @ObfuscatedName("da")
    @ObfuscatedSignature(
            descriptor = "[Liu;"
    )
    MoveSpeed[] pathTraversed = new MoveSpeed[10];
   @ObfuscatedName("ep")
   int field1005 = 0;
   @ObfuscatedName("eo")
   int field1006 = 0;
    @ObfuscatedName("eq")
    int combatLevelChange = -1;

    @ObfuscatedName("as")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1666539507"
    )
    boolean isVisible() {
      return false;
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "32"
   )
   final void method536() {
      this.pathLength = 0;
      this.field1006 = 0;
   }

    @ObfuscatedName("co")
    @ObfuscatedSignature(
            descriptor = "(IIIIIII)V",
            garbageValue = "1919870398"
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
         HitSplatDefinition var12 = class122.method738(var1);
         var10 = var12.field1678;
         var11 = var12.field1672;
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

    @ObfuscatedName("cz")
    @ObfuscatedSignature(
            descriptor = "(IIIIIIB)V",
            garbageValue = "121"
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
         if (var13.definition.field1521 == var8.field1521) {
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

    @ObfuscatedName("cw")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "1269115179"
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

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "329491762"
   )
   void updateSpotAnimation(int idx, int graphicID, int graphicHeight, int graphicStartCycle) {
      int startCycle = graphicStartCycle + Client.cycle;
      SpotAnimation graphic = (SpotAnimation)this.spotAnimations.get((long)idx);
      if (graphic != null) {
         graphic.remove();
         --this.graphicsCount;
      }

      if (graphicID != 65535 && graphicID != -1) {
         byte var7 = 0;
         if (graphicStartCycle > 0) {
            var7 = -1;
         }

         this.spotAnimations.put(new SpotAnimation(graphicID, graphicHeight, startCycle, var7), (long)idx);
         ++this.graphicsCount;
      }
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      descriptor = "(B)Lro;",
      garbageValue = "10"
   )
   IterableNodeHashTable method532() {
      return this.spotAnimations;
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2086288959"
   )
   void method533() {
      IterableNodeHashTableIterator var1 = new IterableNodeHashTableIterator(this.spotAnimations);

      for(SpotAnimation var2 = (SpotAnimation)var1.method2390(); var2 != null; var2 = (SpotAnimation)var1.next()) {
         var2.remove();
      }

      this.graphicsCount = 0;
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      descriptor = "(Lit;B)Lit;",
      garbageValue = "106"
   )
   Model method530(Model var1) {
      if (this.graphicsCount == 0) {
         return var1;
      } else {
         IterableNodeHashTableIterator var2 = new IterableNodeHashTableIterator(this.spotAnimations);
         int var3 = var1.verticesCount;
         int var4 = var1.indicesCount;
         int var5 = var1.field2153;
         byte var6 = var1.field2152;

         for(SpotAnimation var7 = (SpotAnimation)var2.method2390(); var7 != null; var7 = (SpotAnimation)var2.next()) {
            if (var7.field4169 != -1) {
               Model var8 = ItemContainer.SpotAnimationDefinition_get(var7.id).getSharedSpotAnimationModel();
               if (var8 != null) {
                  var3 += var8.verticesCount;
                  var4 += var8.indicesCount;
                  var5 += var8.field2153;
               }
            }
         }

         Model var10 = new Model(var3, var4, var5, var6);
         var10.method1342(var1);

         for(SpotAnimation var11 = (SpotAnimation)var2.method2390(); var11 != null; var11 = (SpotAnimation)var2.next()) {
            if (var11.field4169 != -1) {
               Model var9 = ItemContainer.SpotAnimationDefinition_get(var11.id).getModel(var11.field4169);
               if (var9 != null) {
                  var9.offsetBy(0, -var11.height, 0);
                  var10.method1342(var9);
               }
            }
         }

         return var10;
      }
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2125761914"
   )
   void method527() {
      this.field938 = false;
      this.movingOrientation = -1;
      this.field993 = -1;
      this.field970 = -1;
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(III)Lcq;",
            garbageValue = "470709205"
    )
    static Message Messages_getByChannelAndID(int var0, int var1) {
      ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(var0);
      return var2.getMessage(var1);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(ILnm;IIIZI)V",
      garbageValue = "-1229709463"
   )
   public static void method538(int var0, AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
      class297.musicPlayerStatus = 1;
      class297.musicTrackArchive = var1;
      class379.musicTrackGroupId = var2;
      VarpDefinition.musicTrackFileId = var3;
      class100.musicTrackVolume = var4;
      class120.musicTrackBoolean = var5;
      class162.pcmSampleLength = var0;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "59"
   )
   public static int method539(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-1598492457"
   )
   static final int method537(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
