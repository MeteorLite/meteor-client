import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("al")
   static int field1050 = 1;
   @ObfuscatedName("aa")
   static int field1047 = 1;
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lhs;"
    )
    NPCComposition definition;
    @ObfuscatedName("aw")
    String nameChange = "";
   @ObfuscatedName("au")
   int field1045 = 31;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lsx;"
   )
   class489 field1052;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lhv;"
   )
   NewShit field1048;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lhv;"
   )
   NewShit field1051;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-1586819780"
   )
   void method592(String var1) {
      this.nameChange = var1 == null ? "" : var1;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(B)Lit;",
            garbageValue = "-112"
    )
    protected final Model getModel() {
      if (this.definition == null) {
         return null;
      } else {
         SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? ItemContainer.SequenceDefinition_get(super.sequence) : null;
         SequenceDefinition var2 = super.movementSequence == -1 || super.movementSequence == super.idleSequence && var1 != null ? null : ItemContainer.SequenceDefinition_get(super.movementSequence);
         Model var3 = null;
         if (this.field1048 != null && this.field1048.field1558) {
            var3 = MusicPatchNode.localPlayer.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
         } else {
            var3 = this.definition.method1021(var1, super.sequenceFrame, var2, super.movementFrame, this.field1048);
         }

         if (var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.defaultHeight = var3.height;
            int var4 = var3.indicesCount;
            var3 = this.method530(var3);
            if (this.definition.size == 1) {
               var3.isSingleTile = true;
            }

            if (super.recolourAmount != 0 && Client.cycle >= super.recolourStartCycle && Client.cycle < super.recolourEndCycle) {
               var3.overrideHue = super.recolourHue;
               var3.overrideSaturation = super.recolourSaturation;
               var3.overrideLuminance = super.recolourLuminance;
               var3.overrideAmount = super.recolourAmount;
               var3.field2196 = (short)var4;
            } else {
               var3.overrideAmount = 0;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1826007749"
   )
   void method607(int var1) {
      this.field1045 = var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1164667978"
   )
   boolean method604(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return (this.field1045 & 1 << var1) != 0;
      } else {
         return true;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-1379499313"
   )
   final String method605() {
      if (!this.nameChange.isEmpty()) {
         return this.nameChange;
      } else {
         NPCComposition var1 = this.definition;
         if (var1.transforms != null) {
            var1 = var1.transform();
            if (var1 == null) {
               var1 = this.definition;
            }
         }

         return var1.name;
      }
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(ILiu;B)V",
            garbageValue = "110"
    )
    final void move(int var1, MoveSpeed var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if (var1 == 0) {
         --var3;
         ++var4;
      }

      if (var1 == 1) {
         ++var4;
      }

      if (var1 == 2) {
         ++var3;
         ++var4;
      }

      if (var1 == 3) {
         --var3;
      }

      if (var1 == 4) {
         ++var3;
      }

      if (var1 == 5) {
         --var3;
         --var4;
      }

      if (var1 == 6) {
         --var4;
      }

      if (var1 == 7) {
         ++var3;
         --var4;
      }

      if (super.sequence != -1 && ItemContainer.SequenceDefinition_get(super.sequence).priority == 1) {
         super.sequence = -1;
      }

      if (super.pathLength < 9) {
         ++super.pathLength;
      }

      for(int var5 = super.pathLength; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.pathTraversed[var5] = super.pathTraversed[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.pathTraversed[0] = var2;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(IIZI)V",
      garbageValue = "-208577848"
   )
   final void method594(int var1, int var2, boolean var3) {
      if (super.sequence != -1 && ItemContainer.SequenceDefinition_get(super.sequence).priority == 1) {
         super.sequence = -1;
      }

      if (!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if (super.pathLength < 9) {
               ++super.pathLength;
            }

            for(int var6 = super.pathLength; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.pathTraversed[var6] = super.pathTraversed[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.pathTraversed[0] = MoveSpeed.WALK;
            return;
         }
      }

      super.pathLength = 0;
      super.field1006 = 0;
      super.field1005 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.field936 * 64 + super.pathX[0] * 128;
      super.y = super.field936 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(B)[I",
      garbageValue = "14"
   )
   int[] method596() {
      return this.field1052 != null ? this.field1052.method2546() : this.definition.method1029();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(I)[S",
      garbageValue = "438914513"
   )
   short[] method602() {
      return this.field1052 != null ? this.field1052.method2544() : this.definition.method1031();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(IISI)V",
      garbageValue = "2033131793"
   )
   void method597(int var1, int var2, short var3) {
      if (this.field1052 == null) {
         this.field1052 = new class489(this.definition);
      }

      this.field1052.method2545(var1, var2, var3);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "([I[SI)V",
      garbageValue = "1712497596"
   )
   void method603(int[] var1, short[] var2) {
      if (this.field1052 == null) {
         this.field1052 = new class489(this.definition);
      }

      this.field1052.method2547(var1, var2);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "47"
   )
   void method606() {
      this.field1052 = null;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(Lhv;I)V",
      garbageValue = "-1457608941"
   )
   void method598(NewShit var1) {
      this.field1051 = var1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(I)Lhv;",
      garbageValue = "-767962512"
   )
   NewShit method599() {
      return this.field1051;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(Lhv;I)V",
      garbageValue = "1428478753"
   )
   void method600(NewShit var1) {
      this.field1048 = var1;
   }

    @ObfuscatedName("as")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1666539507"
    )
    final boolean isVisible() {
      return this.definition != null;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "17996"
   )
   void method608() {
      this.field1051 = null;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-112"
   )
   void method601() {
      this.field1048 = null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lnm;B)V",
      garbageValue = "-54"
   )
   public static void method610(AbstractArchive var0) {
      InvDefinition.InvDefinition_archive = var0;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(II)F",
      garbageValue = "1228620083"
   )
   static final float method609(int var0) {
      float var1 = 10075.0F - (float)var0;
      return (var1 * 1.0075567F - 75.56675F) / var1;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "599275396"
   )
   protected static final void method611() {
      class399.clock.mark();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.graphicsTickTimes[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.clientTickTimes[var0] = 0L;
      }

      DirectByteArrayCopier.gameCyclesToDo = 0;
   }
}
