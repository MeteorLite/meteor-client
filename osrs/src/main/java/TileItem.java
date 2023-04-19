import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("TileItem")
public final class TileItem extends Renderable {
   @ObfuscatedName("gp")
   static String field1079;
    @ObfuscatedName("af")
    int id;
    @ObfuscatedName("an")
    int quantity;
   @ObfuscatedName("ac")
   int field1078 = 31;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "77"
   )
   void method622(int var1) {
      this.field1078 = var1;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(B)Lit;",
            garbageValue = "-112"
    )
    protected final Model getModel() {
      return HealthBarUpdate.ItemDefinition_get(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1791885272"
   )
   boolean method625(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return (this.field1078 & 1 << var1) != 0;
      } else {
         return true;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(II)Lfh;",
      garbageValue = "2142933215"
   )
   static class133 method626(int var0) {
      if (class20.method82(var0) != 0) {
         return null;
      } else {
         class133 var2 = (class133)SequenceDefinition.SequenceDefinition_cachedModel.get((long)var0);
         class133 var1;
         if (var2 != null) {
            var1 = var2;
         } else {
            var2 = class211.method1180(SequenceDefinition.SequenceDefinition_animationsArchive, SequenceDefinition.SequenceDefinition_skeletonsArchive, var0, false);
            if (var2 != null) {
               SequenceDefinition.SequenceDefinition_cachedModel.put(var2, (long)var0);
            }

            var1 = var2;
         }

         return var1;
      }
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "0"
   )
   static void method627() {
      if (Client.field482) {
         MouseHandler.addPlayerToScene(MusicPatchNode.localPlayer, false);
      }

   }

    @ObfuscatedName("ms")
    @ObfuscatedSignature(
            descriptor = "([Lmq;IB)V",
            garbageValue = "21"
    )
    static final void drawModelComponents(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if (var3 != null && var3.parentId == var1 && (!var3.isIf3 || !class393.isComponentHidden(var3))) {
            int var5;
            if (var3.type == 0) {
               if (!var3.isIf3 && class393.isComponentHidden(var3) && var3 != MidiPcmStream.mousedOverWidgetIf1) {
                  continue;
               }

               drawModelComponents(var0, var3.id);
               if (var3.children != null) {
                  drawModelComponents(var3.children, var3.id);
               }

               InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
               if (var4 != null) {
                  var5 = var4.group;
                  if (SoundSystem.loadInterface(var5)) {
                     drawModelComponents(VerticalAlignment.Widget_interfaceComponents[var5], -1);
                  }
               }
            }

            if (var3.type == 6) {
               if (var3.sequenceId != -1 || var3.sequenceId2 != -1) {
                  boolean var8 = class452.runCs1(var3);
                  if (var8) {
                     var5 = var3.sequenceId2;
                  } else {
                     var5 = var3.sequenceId;
                  }

                  if (var5 != -1) {
                     SequenceDefinition var6 = ItemContainer.SequenceDefinition_get(var5);
                     if (!var6.isCachedModelIdSet()) {
                        for(var3.modelFrameCycle += Client.field432; var3.modelFrameCycle > var6.frameLengths[var3.modelFrame]; class144.invalidateWidget(var3)) {
                           var3.modelFrameCycle -= var6.frameLengths[var3.modelFrame];
                           ++var3.modelFrame;
                           if (var3.modelFrame >= var6.frameIds.length) {
                              var3.modelFrame -= var6.frameCount;
                              if (var3.modelFrame < 0 || var3.modelFrame >= var6.frameIds.length) {
                                 var3.modelFrame = 0;
                              }
                           }
                        }
                     } else {
                        var3.modelFrame += Client.field432;
                        int var7 = var6.method1128();
                        if (var3.modelFrame >= var7) {
                           var3.modelFrame -= var6.frameCount;
                           if (var3.modelFrame < 0 || var3.modelFrame >= var7) {
                              var3.modelFrame = 0;
                           }
                        }

                        class144.invalidateWidget(var3);
                     }
                  }
               }

               if (var3.rotationKey != 0 && !var3.isIf3) {
                  int var9 = var3.rotationKey >> 16;
                  var5 = var3.rotationKey << 16 >> 16;
                  var9 *= Client.field432;
                  var5 *= Client.field432;
                  var3.modelAngleX = var9 + var3.modelAngleX & 2047;
                  var3.modelAngleY = var5 + var3.modelAngleY & 2047;
                  class144.invalidateWidget(var3);
               }
            }
         }
      }

   }
}
