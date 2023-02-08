import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
@Implements("SequenceDefinition")
public class SequenceDefinition extends DualNode {
   @ObfuscatedName("f")
   static boolean field1808 = false;
    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    static AbstractArchive SequenceDefinition_archive;
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    static AbstractArchive SequenceDefinition_animationsArchive;
    @ObfuscatedName("n")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    static EvictingDualNodeHashTable SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    static EvictingDualNodeHashTable SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    static EvictingDualNodeHashTable SequenceDefinition_cachedModel = new EvictingDualNodeHashTable(100);
    @ObfuscatedName("c")
    public int SequenceDefinition_cachedModelId = -1;
    @ObfuscatedName("r")
    public Map animMayaFrameSounds;
    @ObfuscatedName("b")
    int animMayaStart = 0;
    @ObfuscatedName("m")
    int animMayaEnd = 0;
    @ObfuscatedName("t")
    public int[] frameIds;
    @ObfuscatedName("h")
    int[] chatFrameIds;
    @ObfuscatedName("p")
    public int[] frameLengths;
    @ObfuscatedName("o")
    public int[] soundEffects;
    @ObfuscatedName("u")
    public int frameCount = -1;
    @ObfuscatedName("x")
    int[] mergedBoneGroups;
    @ObfuscatedName("a")
    boolean[] animMayaMasks;
    @ObfuscatedName("q")
    public boolean stretches = false;
    @ObfuscatedName("d")
    public int forcedPriority = 5;
    @ObfuscatedName("e")
    public int shield = -1;
    @ObfuscatedName("g")
    public int weapon = -1;
    @ObfuscatedName("y")
    public int iterations = 99;
   @ObfuscatedName("af")
   public boolean field1799 = false;
    @ObfuscatedName("aa")
    public int precedenceAnimating = -1;
    @ObfuscatedName("ai")
    public int priority = -1;
    @ObfuscatedName("ag")
    public int replyMode = 2;

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(Lrd;I)V",
            garbageValue = "1334689844"
    )
    void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(Lrd;II)V",
            garbageValue = "2142217777"
    )
    void decodeNext(Buffer var1, int var2) {
      int var3;
      int var4;
      if (var2 == 1) {
         var3 = var1.readUnsignedShort();
         this.frameLengths = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameLengths[var4] = var1.readUnsignedShort();
         }

         this.frameIds = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIds[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIds[var4] += var1.readUnsignedShort() << 16;
         }
      } else if (var2 == 2) {
         this.frameCount = var1.readUnsignedShort();
      } else if (var2 == 3) {
         var3 = var1.readUnsignedByte();
         this.mergedBoneGroups = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.mergedBoneGroups[var4] = var1.readUnsignedByte();
         }

         this.mergedBoneGroups[var3] = 9999999;
      } else if (var2 == 4) {
         this.stretches = true;
      } else if (var2 == 5) {
         this.forcedPriority = var1.readUnsignedByte();
      } else if (var2 == 6) {
         this.shield = var1.readUnsignedShort();
      } else if (var2 == 7) {
         this.weapon = var1.readUnsignedShort();
      } else if (var2 == 8) {
         this.iterations = var1.readUnsignedByte();
         this.field1799 = true;
      } else if (var2 == 9) {
         this.precedenceAnimating = var1.readUnsignedByte();
      } else if (var2 == 10) {
         this.priority = var1.readUnsignedByte();
      } else if (var2 == 11) {
         this.replyMode = var1.readUnsignedByte();
      } else if (var2 == 12) {
         var3 = var1.readUnsignedByte();
         this.chatFrameIds = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.chatFrameIds[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.chatFrameIds[var4] += var1.readUnsignedShort() << 16;
         }
      } else if (var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.soundEffects = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.soundEffects[var4] = var1.readMedium();
         }
      } else if (var2 == 14) {
         this.SequenceDefinition_cachedModelId = var1.readInt();
      } else if (var2 == 15) {
         var3 = var1.readUnsignedShort();
         this.animMayaFrameSounds = new HashMap();

         for(var4 = 0; var4 < var3; ++var4) {
            int var5 = var1.readUnsignedShort();
            int var6 = var1.readMedium();
            this.animMayaFrameSounds.put(var5, var6);
         }
      } else if (var2 == 16) {
         this.animMayaStart = var1.readUnsignedShort();
         this.animMayaEnd = var1.readUnsignedShort();
      } else if (var2 == 17) {
         this.animMayaMasks = new boolean[256];

         for(var3 = 0; var3 < this.animMayaMasks.length; ++var3) {
            this.animMayaMasks[var3] = false;
         }

         var3 = var1.readUnsignedByte();

         for(var4 = 0; var4 < var3; ++var4) {
            this.animMayaMasks[var1.readUnsignedByte()] = true;
         }
      }

   }

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1438810920"
    )
    void postDecode() {
      if (this.precedenceAnimating == -1) {
         if (this.mergedBoneGroups == null && this.animMayaMasks == null) {
            this.precedenceAnimating = 0;
         } else {
            this.precedenceAnimating = 2;
         }
      }

      if (this.priority == -1) {
         if (this.mergedBoneGroups == null && this.animMayaMasks == null) {
            this.priority = 0;
         } else {
            this.priority = 2;
         }
      }

   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(Lhs;IB)Lhs;",
            garbageValue = "80"
    )
    public Model transformActorModel(Model var1, int var2) {
      if (!this.isCachedModelIdSet()) {
         var2 = this.frameIds[var2];
         Frames var8 = class131.getFrames(var2 >> 16);
         var2 &= 65535;
         if (var8 == null) {
            return var1.toSharedSequenceModel(true);
         } else {
            Model var4 = var1.toSharedSequenceModel(!var8.hasAlphaTransform(var2));
            var4.animate(var8, var2);
            return var4;
         }
      } else {
         int var7 = this.SequenceDefinition_cachedModelId;
         class133 var3;
         if (class70.method420(var7) != 0) {
            var3 = null;
         } else {
            class133 var6 = (class133)SequenceDefinition_cachedModel.get((long)var7);
            class133 var5;
            if (var6 != null) {
               var5 = var6;
            } else {
               var6 = Login.method425(SequenceDefinition_animationsArchive, class16.SequenceDefinition_skeletonsArchive, var7, false);
               if (var6 != null) {
                  SequenceDefinition_cachedModel.put(var6, (long)var7);
               }

               var5 = var6;
            }

            var3 = var5;
         }

         if (var3 == null) {
            return var1.toSharedSequenceModel(true);
         } else {
            Model var9 = var1.toSharedSequenceModel(!var3.method720());
            var9.method1285(var3, var2);
            return var9;
         }
      }
   }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "(Lhs;IIB)Lhs;",
            garbageValue = "-110"
    )
    Model transformObjectModel(Model var1, int var2, int var3) {
      if (!this.isCachedModelIdSet()) {
         var2 = this.frameIds[var2];
         Frames var9 = class131.getFrames(var2 >> 16);
         var2 &= 65535;
         if (var9 == null) {
            return var1.toSharedSequenceModel(true);
         } else {
            Model var5 = var1.toSharedSequenceModel(!var9.hasAlphaTransform(var2));
            var3 &= 3;
            if (var3 == 1) {
               var5.rotateY270Ccw();
            } else if (var3 == 2) {
               var5.rotateY180();
            } else if (var3 == 3) {
               var5.rotateY90Ccw();
            }

            var5.animate(var9, var2);
            if (var3 == 1) {
               var5.rotateY90Ccw();
            } else if (var3 == 2) {
               var5.rotateY180();
            } else if (var3 == 3) {
               var5.rotateY270Ccw();
            }

            return var5;
         }
      } else {
         int var8 = this.SequenceDefinition_cachedModelId;
         class133 var4;
         if (class70.method420(var8) != 0) {
            var4 = null;
         } else {
            class133 var7 = (class133)SequenceDefinition_cachedModel.get((long)var8);
            class133 var6;
            if (var7 != null) {
               var6 = var7;
            } else {
               var7 = Login.method425(SequenceDefinition_animationsArchive, class16.SequenceDefinition_skeletonsArchive, var8, false);
               if (var7 != null) {
                  SequenceDefinition_cachedModel.put(var7, (long)var8);
               }

               var6 = var7;
            }

            var4 = var6;
         }

         if (var4 == null) {
            return var1.toSharedSequenceModel(true);
         } else {
            Model var10 = var1.toSharedSequenceModel(!var4.method720());
            var3 &= 3;
            if (var3 == 1) {
               var10.rotateY270Ccw();
            } else if (var3 == 2) {
               var10.rotateY180();
            } else if (var3 == 3) {
               var10.rotateY90Ccw();
            }

            var10.method1285(var4, var2);
            if (var3 == 1) {
               var10.rotateY90Ccw();
            } else if (var3 == 2) {
               var10.rotateY180();
            } else if (var3 == 3) {
               var10.rotateY270Ccw();
            }

            return var10;
         }
      }
   }

    @ObfuscatedName("n")
    @ObfuscatedSignature(
            descriptor = "(Lhs;IB)Lhs;",
            garbageValue = "1"
    )
    Model transformSpotAnimationModel(Model var1, int var2) {
      if (!this.isCachedModelIdSet()) {
         var2 = this.frameIds[var2];
         Frames var8 = class131.getFrames(var2 >> 16);
         var2 &= 65535;
         if (var8 == null) {
            return var1.toSharedSpotAnimationModel(true);
         } else {
            Model var4 = var1.toSharedSpotAnimationModel(!var8.hasAlphaTransform(var2));
            var4.animate(var8, var2);
            return var4;
         }
      } else {
         int var7 = this.SequenceDefinition_cachedModelId;
         class133 var3;
         if (class70.method420(var7) != 0) {
            var3 = null;
         } else {
            class133 var6 = (class133)SequenceDefinition_cachedModel.get((long)var7);
            class133 var5;
            if (var6 != null) {
               var5 = var6;
            } else {
               var6 = Login.method425(SequenceDefinition_animationsArchive, class16.SequenceDefinition_skeletonsArchive, var7, false);
               if (var6 != null) {
                  SequenceDefinition_cachedModel.put(var6, (long)var7);
               }

               var5 = var6;
            }

            var3 = var5;
         }

         if (var3 == null) {
            return var1.toSharedSpotAnimationModel(true);
         } else {
            Model var9 = var1.toSharedSpotAnimationModel(!var3.method720());
            var9.method1285(var3, var2);
            return var9;
         }
      }
   }

    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "(Lhs;ILge;II)Lhs;",
            garbageValue = "-202244152"
    )
    public Model applyTransformations(Model var1, int var2, SequenceDefinition var3, int var4) {
      if (field1808 && !this.isCachedModelIdSet() && !var3.isCachedModelIdSet()) {
         return this.method1061(var1, var2, var3, var4);
      } else {
         Model var5 = var1.toSharedSequenceModel(false);
         boolean var6 = false;
         Frames var7 = null;
         Skeleton var8 = null;
         class133 var9;
         if (this.isCachedModelIdSet()) {
            var9 = this.method1058();
            if (var9 == null) {
               return var5;
            }

            if (var3.isCachedModelIdSet() && this.animMayaMasks == null) {
               var5.method1285(var9, var2);
               return var5;
            }

            var8 = var9.field1265;
            var5.method1271(var8, var9, var2, this.animMayaMasks, false, !var3.isCachedModelIdSet());
         } else {
            var2 = this.frameIds[var2];
            var7 = class131.getFrames(var2 >> 16);
            var2 &= 65535;
            if (var7 == null) {
               return var3.transformActorModel(var1, var4);
            }

            if (!var3.isCachedModelIdSet() && (this.mergedBoneGroups == null || var4 == -1)) {
               var5.animate(var7, var2);
               return var5;
            }

            if (this.mergedBoneGroups == null || var4 == -1) {
               var5.animate(var7, var2);
               return var5;
            }

            var6 = var3.isCachedModelIdSet();
            if (!var6) {
               var5.method1294(var7, var2, this.mergedBoneGroups, false);
            }
         }

         if (var3.isCachedModelIdSet()) {
            var9 = var3.method1058();
            if (var9 == null) {
               return var5;
            }

            if (var8 == null) {
               var8 = var9.field1265;
            }

            var5.method1271(var8, var9, var4, this.animMayaMasks, true, true);
         } else {
            var4 = var3.frameIds[var4];
            Frames var10 = class131.getFrames(var4 >> 16);
            var4 &= 65535;
            if (var10 == null) {
               return this.transformActorModel(var1, var2);
            }

            var5.method1294(var10, var4, this.mergedBoneGroups, true);
         }

         if (var6 && var7 != null) {
            var5.method1294(var7, var2, this.mergedBoneGroups, false);
         }

         var5.resetBounds();
         return var5;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(Lhs;ILge;II)Lhs;",
      garbageValue = "-2099671514"
   )
   Model method1061(Model var1, int var2, SequenceDefinition var3, int var4) {
      var2 = this.frameIds[var2];
      Frames var5 = class131.getFrames(var2 >> 16);
      var2 &= 65535;
      if (var5 == null) {
         return var3.transformActorModel(var1, var4);
      } else {
         var4 = var3.frameIds[var4];
         Frames var6 = class131.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if (var6 == null) {
            var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2));
            var7.animate(var5, var2);
            return var7;
         } else {
            var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2) & !var6.hasAlphaTransform(var4));
            var7.animate2(var5, var2, var6, var4, this.mergedBoneGroups);
            return var7;
         }
      }
   }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            descriptor = "(Lhs;II)Lhs;",
            garbageValue = "164179866"
    )
    public Model transformWidgetModel(Model var1, int var2) {
      if (!this.isCachedModelIdSet()) {
         int var3 = this.frameIds[var2];
         Frames var4 = class131.getFrames(var3 >> 16);
         var3 &= 65535;
         if (var4 == null) {
            return var1.toSharedSequenceModel(true);
         } else {
            Frames var5 = null;
            int var6 = 0;
            if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
               var6 = this.chatFrameIds[var2];
               var5 = class131.getFrames(var6 >> 16);
               var6 &= 65535;
            }

            Model var7;
            if (var5 != null && var6 != 65535) {
               var7 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var3) & !var5.hasAlphaTransform(var6));
               var7.animate(var4, var3);
               var7.animate(var5, var6);
               return var7;
            } else {
               var7 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var3));
               var7.animate(var4, var3);
               return var7;
            }
         }
      } else {
         return this.transformActorModel(var1, var2);
      }
   }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-1029590355"
    )
    public boolean isCachedModelIdSet() {
      return this.SequenceDefinition_cachedModelId >= 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "2032080348"
   )
   public int method1060() {
      return this.animMayaEnd - this.animMayaStart;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)Lei;",
      garbageValue = "894053899"
   )
   class133 method1058() {
      if (this.isCachedModelIdSet()) {
         int var2 = this.SequenceDefinition_cachedModelId;
         class133 var1;
         if (class70.method420(var2) != 0) {
            var1 = null;
         } else {
            class133 var4 = (class133)SequenceDefinition_cachedModel.get((long)var2);
            class133 var3;
            if (var4 != null) {
               var3 = var4;
            } else {
               var4 = Login.method425(SequenceDefinition_animationsArchive, class16.SequenceDefinition_skeletonsArchive, var2, false);
               if (var4 != null) {
                  SequenceDefinition_cachedModel.put(var4, (long)var2);
               }

               var3 = var4;
            }

            var1 = var3;
         }

         return var1;
      } else {
         return null;
      }
   }
}
