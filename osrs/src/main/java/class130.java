import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class130 extends DualNode {
   @ObfuscatedName("h")
   int field1261;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "[[Ldu;"
   )
   public class125[][] field1258 = null;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "[[Ldu;"
   )
   class125[][] field1259 = null;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lhn;"
   )
   public Skeleton field1257;
   @ObfuscatedName("m")
   int field1262 = 0;
   @ObfuscatedName("q")
   boolean field1260;

   @ObfuscatedSignature(
      descriptor = "(Lly;Lly;IZ)V",
      garbageValue = "0"
   )
   public class130(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
      this.field1261 = var3;
      byte[] var5 = var1.takeFile(this.field1261 >> 16 & '\uffff', this.field1261 & '\uffff');
      Buffer var6 = new Buffer(var5);
      int var7 = var6.readUnsignedByte();
      int var8 = var6.readUnsignedShort();
      byte[] var9 = var2.getFile(var8, 0);
      this.field1257 = new Skeleton(var8, var9);
      this.method716(var6, var7);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;IS)V",
      garbageValue = "-5453"
   )
   void method716(Buffer var1, int var2) {
      var1.readUnsignedShort();
      var1.readUnsignedShort();
      this.field1262 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedShort();
      this.field1259 = new class125[this.field1257.method1175().method1169()][];
      this.field1258 = new class125[this.field1257.method1176()][];

      for(int var4 = 0; var4 < var3; ++var4) {
         class126 var5 = class343.method1851(var1.readUnsignedByte());
         int var6 = var1.readShortSmart();
         class127 var7 = class34.method142(var1.readUnsignedByte());
         class125 var8 = new class125();
         var8.method698(var1, var2);
         int var9 = var5.method707();
         class125[][] var10;
         if (var5 == class126.field1226) {
            var10 = this.field1259;
         } else {
            var10 = this.field1258;
         }

         if (var10[var6] == null) {
            var10[var6] = new class125[var9];
         }

         var10[var6][var7.method711()] = var8;
         if (var5 == class126.field1229) {
            this.field1260 = true;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "854058965"
   )
   public int method722() {
      return this.field1262;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-98"
   )
   public boolean method717() {
      return this.field1260;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(ILdt;III)V",
      garbageValue = "2132738190"
   )
   public void method715(int var1, class123 var2, int var3, int var4) {
      class410 var5 = class326.method1778();
      this.method718(var5, var3, var2, var1);
      this.method720(var5, var3, var2, var1);
      this.method719(var5, var3, var2, var1);
      var2.method686(var5);
      var5.method2141();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Loj;ILdt;II)V",
      garbageValue = "826275338"
   )
   void method718(class410 var1, int var2, class123 var3, int var4) {
      float[] var5 = var3.method687(this.field1262);
      float var6 = var5[0];
      float var7 = var5[1];
      float var8 = var5[2];
      if (this.field1259[var2] != null) {
         class125 var9 = this.field1259[var2][0];
         class125 var10 = this.field1259[var2][1];
         class125 var11 = this.field1259[var2][2];
         if (var9 != null) {
            var6 = var9.method704(var4);
         }

         if (var10 != null) {
            var7 = var10.method704(var4);
         }

         if (var11 != null) {
            var8 = var11.method704(var4);
         }
      }

      class409 var16 = SpotAnimationDefinition.method976();
      var16.method2124(1.0F, 0.0F, 0.0F, var6);
      class409 var14 = SpotAnimationDefinition.method976();
      var14.method2124(0.0F, 1.0F, 0.0F, var7);
      class409 var15 = SpotAnimationDefinition.method976();
      var15.method2124(0.0F, 0.0F, 1.0F, var8);
      class409 var12 = SpotAnimationDefinition.method976();
      var12.method2125(var15);
      var12.method2125(var16);
      var12.method2125(var14);
      class410 var13 = class326.method1778();
      var13.method2137(var12);
      var1.method2136(var13);
      var16.method2127();
      var14.method2127();
      var15.method2127();
      var12.method2127();
      var13.method2141();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Loj;ILdt;II)V",
      garbageValue = "704346834"
   )
   void method719(class410 var1, int var2, class123 var3, int var4) {
      float[] var5 = var3.method688(this.field1262);
      float var6 = var5[0];
      float var7 = var5[1];
      float var8 = var5[2];
      if (this.field1259[var2] != null) {
         class125 var9 = this.field1259[var2][3];
         class125 var10 = this.field1259[var2][4];
         class125 var11 = this.field1259[var2][5];
         if (var9 != null) {
            var6 = var9.method704(var4);
         }

         if (var10 != null) {
            var7 = var10.method704(var4);
         }

         if (var11 != null) {
            var8 = var11.method704(var4);
         }
      }

      var1.field3763[12] = var6;
      var1.field3763[13] = var7;
      var1.field3763[14] = var8;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Loj;ILdt;II)V",
      garbageValue = "292297142"
   )
   void method720(class410 var1, int var2, class123 var3, int var4) {
      float[] var5 = var3.method689(this.field1262);
      float var6 = var5[0];
      float var7 = var5[1];
      float var8 = var5[2];
      if (this.field1259[var2] != null) {
         class125 var9 = this.field1259[var2][6];
         class125 var10 = this.field1259[var2][7];
         class125 var11 = this.field1259[var2][8];
         if (var9 != null) {
            var6 = var9.method704(var4);
         }

         if (var10 != null) {
            var7 = var10.method704(var4);
         }

         if (var11 != null) {
            var8 = var11.method704(var4);
         }
      }

      class410 var12 = class326.method1778();
      var12.method2135(var6, var7, var8);
      var1.method2136(var12);
      var12.method2141();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IIB)Lbv;",
      garbageValue = "21"
   )
   static Message Messages_getByChannelAndID(int var0, int var1) {
      ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(var0);
      return var2.getMessage(var1);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(II)Ljava/lang/Object;",
      garbageValue = "-1832346450"
   )
   static Object method724(int var0) {
      return class346.method1861((class456)World.findEnumerated(class456.method2303(), var0));
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1852132705"
   )
   static final void method723() {
      for(int var0 = 0; var0 < Client.soundEffectCount; ++var0) {
         --Client.queuedSoundEffectDelays[var0];
         if (Client.queuedSoundEffectDelays[var0] >= -10) {
            SoundEffect var9 = Client.soundEffects[var0];
            if (var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.readSoundEffect(WorldMapSection0.field2342, Client.soundEffectIds[var0], 0);
               if (var9 == null) {
                  continue;
               }

               Client.queuedSoundEffectDelays[var0] += var9.calculateDelay();
               Client.soundEffects[var0] = var9;
            }

            if (Client.queuedSoundEffectDelays[var0] < 0) {
               int var2;
               if (Client.soundLocations[var0] != 0) {
                  int var3 = (Client.soundLocations[var0] & 255) * 128;
                  int var4 = Client.soundLocations[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - class155.localPlayer.x;
                  if (var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.soundLocations[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - class155.localPlayer.y;
                  if (var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if (var8 > var3) {
                     Client.queuedSoundEffectDelays[var0] = -100;
                     continue;
                  }

                  if (var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * StructComposition.clientPreferences.getAreaSoundEffectsVolume() / var3;
               } else {
                  var2 = StructComposition.clientPreferences.getCurrentSoundEffectsVolume();
               }

               if (var2 > 0) {
                  RawSound var10 = var9.toRawSound().resample(DevicePcmPlayerProvider.decimator);
                  RawPcmStream var11 = RawPcmStream.createRawPcmStream(var10, 100, var2);
                  var11.setNumLoops(Client.queuedSoundEffectLoops[var0] - 1);
                  ApproximateRouteStrategy.pcmStreamMixer.addSubStream(var11);
               }

               Client.queuedSoundEffectDelays[var0] = -100;
            }
         } else {
            --Client.soundEffectCount;

            for(int var1 = var0; var1 < Client.soundEffectCount; ++var1) {
               Client.soundEffectIds[var1] = Client.soundEffectIds[var1 + 1];
               Client.soundEffects[var1] = Client.soundEffects[var1 + 1];
               Client.queuedSoundEffectLoops[var1] = Client.queuedSoundEffectLoops[var1 + 1];
               Client.queuedSoundEffectDelays[var1] = Client.queuedSoundEffectDelays[var1 + 1];
               Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
            }

            --var0;
         }
      }

      if (Client.playingJingle && !class159.method838()) {
         if (StructComposition.clientPreferences.getCurrentMusicVolume() != 0 && Client.currentTrackGroupId != -1) {
            class29.method115(class162.archive6, Client.currentTrackGroupId, 0, StructComposition.clientPreferences.getCurrentMusicVolume(), false);
         }

         Client.playingJingle = false;
      }

   }
}
