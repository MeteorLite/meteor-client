import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("aq")
   static int field1052 = 1;
   @ObfuscatedName("ar")
   static int field1054 = 1;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lhl;"
   )
   @Export("definition")
   NPCComposition definition;
   @ObfuscatedName("al")
   @Export("nameChange")
   String nameChange = "";
   @ObfuscatedName("ab")
   int field1049 = 31;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lsz;"
   )
   class478 field1050;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lhj;"
   )
   NewShit field1051;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lhj;"
   )
   NewShit field1053;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   void method580(String var1) {
      this.nameChange = var1 == null ? "" : var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)Lix;",
      garbageValue = "-1998422213"
   )
   @Export("getModel")
   protected final Model getModel() {
      if (this.definition == null) {
         return null;
      } else {
         SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? Coord.SequenceDefinition_get(super.sequence) : null;
         SequenceDefinition var2 = super.movementSequence == -1 || super.idleSequence == super.movementSequence && var1 != null ? null : Coord.SequenceDefinition_get(super.movementSequence);
         Model var3 = this.definition.method961(var1, super.sequenceFrame, var2, super.movementFrame, this.field1051);
         if (var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.defaultHeight = var3.height;
            int var4 = var3.indicesCount;
            if (super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
               Model var5 = DevicePcmPlayerProvider.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
               if (var5 != null) {
                  var5.offsetBy(0, -super.spotAnimHeight, 0);
                  Model[] var6 = new Model[]{var3, var5};
                  var3 = new Model(var6, 2);
               }
            }

            if (this.definition.size == 1) {
               var3.isSingleTile = true;
            }

            if (super.recolourAmount != 0 && Client.cycle >= super.recolourStartCycle && Client.cycle < super.recolourEndCycle) {
               var3.overrideHue = super.recolourHue;
               var3.overrideSaturation = super.recolourSaturation;
               var3.overrideLuminance = super.recolourLuminance;
               var3.overrideAmount = super.recolourAmount;
               var3.field2173 = (short)var4;
            } else {
               var3.overrideAmount = 0;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "14"
   )
   void method572(int var1) {
      this.field1049 = var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1354169302"
   )
   boolean method559(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return (this.field1049 & 1 << var1) != 0;
      } else {
         return true;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-2016328682"
   )
   final String method577() {
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

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(ILis;B)V",
      garbageValue = "43"
   )
   @Export("move")
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

      if (super.sequence != -1 && Coord.SequenceDefinition_get(super.sequence).priority == 1) {
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

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(IIZI)V",
      garbageValue = "693431583"
   )
   final void method561(int var1, int var2, boolean var3) {
      if (super.sequence != -1 && Coord.SequenceDefinition_get(super.sequence).priority == 1) {
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
      super.field1004 = 0;
      super.field1003 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = super.pathX[0] * 128 + super.field931 * 64;
      super.y = super.pathY[0] * 128 + super.field931 * 64;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(I)[I",
      garbageValue = "-1203673251"
   )
   int[] method564() {
      return this.field1050 != null ? this.field1050.method2470() : this.definition.method968();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(B)[S",
      garbageValue = "126"
   )
   short[] method565() {
      return this.field1050 != null ? this.field1050.method2471() : this.definition.method964();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(IISI)V",
      garbageValue = "1445683275"
   )
   void method566(int var1, int var2, short var3) {
      if (this.field1050 == null) {
         this.field1050 = new class478(this.definition);
      }

      this.field1050.method2472(var1, var2, var3);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "([I[SI)V",
      garbageValue = "685093659"
   )
   void method567(int[] var1, short[] var2) {
      if (this.field1050 == null) {
         this.field1050 = new class478(this.definition);
      }

      this.field1050.method2469(var1, var2);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1082576070"
   )
   void method573() {
      this.field1050 = null;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(Lhj;I)V",
      garbageValue = "-95948932"
   )
   void method568(NewShit var1) {
      this.field1053 = var1;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(I)Lhj;",
      garbageValue = "295942057"
   )
   NewShit method569() {
      return this.field1053;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(Lhj;I)V",
      garbageValue = "2106253999"
   )
   void method570(NewShit var1) {
      this.field1051 = var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1187706422"
   )
   @Export("isVisible")
   final boolean isVisible() {
      return this.definition != null;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "16"
   )
   void method575() {
      this.field1053 = null;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-36"
   )
   void method578() {
      this.field1051 = null;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "103"
   )
   public static int method582(int var0) {
      return class435.field3777[var0 & 16383];
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(ILne;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "34"
   )
   public static void method581(int var0, AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.getGroupId(var2);
      int var7 = var1.getFileId(var6, var3);
      method574(var0, var1, var6, var7, var4, var5);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(ILne;IIIZI)V",
      garbageValue = "-1234060447"
   )
   public static void method574(int var0, AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
      class293.musicPlayerStatus = 1;
      class364.musicTrackArchive = var1;
      IntHashTable.musicTrackGroupId = var2;
      class293.musicTrackFileId = var3;
      class368.musicTrackVolume = var4;
      class293.musicTrackBoolean = var5;
      AbstractRasterProvider.pcmSampleLength = var0;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZI)I",
      garbageValue = "-196574713"
   )
   static int method576(int var0, Script var1, boolean var2) {
      if (var0 == 6754) {
         int var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         NPCComposition var4 = class188.getNpcDefinition(var3);
         Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var4 != null ? var4.name : "";
         return 1;
      } else {
         NPCComposition var5;
         if (var0 == 6764) {
            Interpreter.Interpreter_intStackSize -= 2;
            var5 = class188.getNpcDefinition(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
            int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5.method969(var6);
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5.method972(var6);
            return 1;
         } else if (var0 == 6765) {
            var5 = class188.getNpcDefinition(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5 != null ? var5.combatLevel * -1896830679 * 283378457 : 0;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1695688824"
   )
   @Export("setWindowedMode")
   static void setWindowedMode(int var0) {
      Client.field569 = 0L;
      if (var0 >= 2) {
         Client.isResizable = true;
      } else {
         Client.isResizable = false;
      }

      if (class7.getWindowedMode() == 1) {
         class392.client.setMaxCanvasSize(765, 503);
      } else {
         class392.client.setMaxCanvasSize(7680, 2160);
      }

      if (Client.gameState >= 25) {
         PacketBufferNode var1 = UserComparator9.getPacketBufferNode(ClientPacket.field2432, Client.packetWriter.isaacCipher);
         var1.packetBuffer.writeByte(class7.getWindowedMode());
         var1.packetBuffer.writeShort(GameEngine.canvasWidth);
         var1.packetBuffer.writeShort(class143.canvasHeight);
         Client.packetWriter.addNode(var1);
      }

   }

   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      descriptor = "(IIB)Ljava/lang/String;",
      garbageValue = "24"
   )
   static final String method571(int var0, int var1) {
      int var2 = var1 - var0;
      if (var2 < -9) {
         return Canvas.colorStartTag(16711680);
      } else if (var2 < -6) {
         return Canvas.colorStartTag(16723968);
      } else if (var2 < -3) {
         return Canvas.colorStartTag(16740352);
      } else if (var2 < 0) {
         return Canvas.colorStartTag(16756736);
      } else if (var2 > 9) {
         return Canvas.colorStartTag(65280);
      } else if (var2 > 6) {
         return Canvas.colorStartTag(4259584);
      } else if (var2 > 3) {
         return Canvas.colorStartTag(8453888);
      } else {
         return var2 > 0 ? Canvas.colorStartTag(12648192) : Canvas.colorStartTag(16776960);
      }
   }
}
