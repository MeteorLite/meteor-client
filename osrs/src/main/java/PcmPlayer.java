import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("PcmPlayer")
public class PcmPlayer {
   @ObfuscatedName("an")
   public static int field194;
   @ObfuscatedName("aq")
   @Export("soundSystemExecutor")
   static ScheduledExecutorService soundSystemExecutor;
   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      descriptor = "Lpj;"
   )
   @Export("js5Socket")
   static AbstractSocket js5Socket;
   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      descriptor = "Lpw;"
   )
   @Export("spriteIds")
   static GraphicsDefaults spriteIds;
   @ObfuscatedName("ay")
   @Export("samples")
   protected int[] samples;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Lbj;"
   )
   @Export("stream")
   PcmStream stream;
   @ObfuscatedName("az")
   int field192 = 32;
   @ObfuscatedName("ae")
   @Export("timeMs")
   long timeMs = WorldMapSection2.clockNow();
   @ObfuscatedName("au")
   @Export("capacity")
   int capacity;
   @ObfuscatedName("ag")
   int field189;
   @ObfuscatedName("at")
   int field195;
   @ObfuscatedName("af")
   long field196 = 0L;
   @ObfuscatedName("ai")
   int field197 = 0;
   @ObfuscatedName("aw")
   int field198 = 0;
   @ObfuscatedName("aa")
   int field199 = 0;
   @ObfuscatedName("ah")
   long field200 = 0L;
   @ObfuscatedName("ad")
   boolean field190 = true;
   @ObfuscatedName("bh")
   int field202 = 0;
   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "[Lbj;"
   )
   PcmStream[] field203 = new PcmStream[8];
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "[Lbj;"
   )
   PcmStream[] field201 = new PcmStream[8];

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2134180158"
   )
   @Export("init")
   protected void init() throws Exception {
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "1"
   )
   @Export("open")
   protected void open(int var1) throws Exception {
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "84"
   )
   @Export("position")
   protected int position() throws Exception {
      return this.capacity;
   }

   @ObfuscatedName("ab")
   @Export("write")
   protected void write() throws Exception {
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-1"
   )
   @Export("close")
   protected void close() {
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "-5904"
   )
   @Export("discard")
   protected void discard() throws Exception {
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(Lbj;I)V",
      garbageValue = "1750133787"
   )
   @Export("setStream")
   public final synchronized void setStream(PcmStream var1) {
      this.stream = var1;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1624173078"
   )
   @Export("run")
   public final synchronized void run() {
      if (this.samples != null) {
         long var1 = WorldMapSection2.clockNow();

         try {
            if (this.field196 != 0L) {
               if (var1 < this.field196) {
                  return;
               }

               this.open(this.capacity);
               this.field196 = 0L;
               this.field190 = true;
            }

            int var3 = this.position();
            if (this.field199 - var3 > this.field197) {
               this.field197 = this.field199 - var3;
            }

            int var4 = this.field189 + this.field195;
            if (var4 + 256 > 16384) {
               var4 = 16128;
            }

            if (var4 + 256 > this.capacity) {
               this.capacity += 1024;
               if (this.capacity > 16384) {
                  this.capacity = 16384;
               }

               this.close();
               this.open(this.capacity);
               var3 = 0;
               this.field190 = true;
               if (var4 + 256 > this.capacity) {
                  var4 = this.capacity - 256;
                  this.field195 = var4 - this.field189;
               }
            }

            while(var3 < var4) {
               this.fill(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if (var1 > this.field200) {
               if (!this.field190) {
                  if (this.field197 == 0 && this.field198 == 0) {
                     this.close();
                     this.field196 = var1 + 2000L;
                     return;
                  }

                  this.field195 = Math.min(this.field198, this.field197);
                  this.field198 = this.field197;
               } else {
                  this.field190 = false;
               }

               this.field197 = 0;
               this.field200 = var1 + 2000L;
            }

            this.field199 = var3;
         } catch (Exception var7) {
            this.close();
            this.field196 = var1 + 2000L;
         }

         try {
            if (var1 > this.timeMs + 500000L) {
               var1 = this.timeMs;
            }

            while(var1 > this.timeMs + 5000L) {
               this.skip(256);
               this.timeMs += (long)(256000 / field194);
            }
         } catch (Exception var6) {
            this.timeMs = var1;
         }

      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1765565781"
   )
   public final void method218() {
      this.field190 = true;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "1"
   )
   @Export("tryDiscard")
   public final synchronized void tryDiscard() {
      this.field190 = true;

      try {
         this.discard();
      } catch (Exception var2) {
         this.close();
         this.field196 = WorldMapSection2.clockNow() + 2000L;
      }

   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1555106489"
   )
   @Export("shutdown")
   public final synchronized void shutdown() {
      if (class291.soundSystem != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if (this == class291.soundSystem.players[var2]) {
               class291.soundSystem.players[var2] = null;
            }

            if (class291.soundSystem.players[var2] != null) {
               var1 = false;
            }
         }

         if (var1) {
            soundSystemExecutor.shutdownNow();
            soundSystemExecutor = null;
            class291.soundSystem = null;
         }
      }

      this.close();
      this.samples = null;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "2131967863"
   )
   @Export("skip")
   final void skip(int var1) {
      this.field202 -= var1;
      if (this.field202 < 0) {
         this.field202 = 0;
      }

      if (this.stream != null) {
         this.stream.skip(var1);
      }

   }

   @ObfuscatedName("bk")
   @Export("fill")
   final void fill(int[] var1, int var2) {
      int var3 = var2;
      if (ChatChannel.PcmPlayer_stereo) {
         var3 = var2 << 1;
      }

      class380.clearIntArray(var1, 0, var3);
      this.field202 -= var2;
      if (this.stream != null && this.field202 <= 0) {
         this.field202 += field194 >> 4;
         AbstractWorldMapIcon.PcmStream_disable(this.stream);
         this.method210(this.stream, this.stream.vmethod1019());
         int var4 = 0;
         int var5 = 255;

         int var6;
         PcmStream var10;
         label105:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if (var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if ((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  PcmStream var11 = this.field203[var7];

                  label99:
                  while(true) {
                     while(true) {
                        if (var11 == null) {
                           break label99;
                        }

                        AbstractSound var12 = var11.sound;
                        if (var12 != null && var12.position > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.after;
                        } else {
                           var11.active = true;
                           int var13 = var11.vmethod5648();
                           var4 += var13;
                           if (var12 != null) {
                              var12.position += var13;
                           }

                           if (var4 >= this.field192) {
                              break label105;
                           }

                           PcmStream var14 = var11.firstSubStream();
                           if (var14 != null) {
                              for(int var15 = var11.field249; var14 != null; var14 = var11.nextSubStream()) {
                                 this.method210(var14, var15 * var14.vmethod1019() >> 8);
                              }
                           }

                           PcmStream var16 = var11.after;
                           var11.after = null;
                           if (var10 == null) {
                              this.field203[var7] = var16;
                           } else {
                              var10.after = var16;
                           }

                           if (var16 == null) {
                              this.field201[var7] = var10;
                           }

                           var11 = var16;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            PcmStream var17 = this.field203[var6];
            PcmStream[] var18 = this.field203;
            this.field201[var6] = null;

            for(var18[var6] = null; var17 != null; var17 = var10) {
               var10 = var17.after;
               var17.after = null;
            }
         }
      }

      if (this.field202 < 0) {
         this.field202 = 0;
      }

      if (this.stream != null) {
         this.stream.fill(var1, 0, var2);
      }

      this.timeMs = WorldMapSection2.clockNow();
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "(Lbj;II)V",
      garbageValue = "-1707696429"
   )
   final void method210(PcmStream var1, int var2) {
      int var3 = var2 >> 5;
      PcmStream var4 = this.field201[var3];
      if (var4 == null) {
         this.field203[var3] = var1;
      } else {
         var4.after = var1;
      }

      this.field201[var3] = var1;
      var1.field249 = var2;
   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      descriptor = "(Lmy;IIZI)V",
      garbageValue = "1659869209"
   )
   @Export("alignWidgetSize")
   static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if (var0.widthAlignment == 0) {
         var0.width = var0.rawWidth;
      } else if (var0.widthAlignment == 1) {
         var0.width = var1 - var0.rawWidth;
      } else if (var0.widthAlignment == 2) {
         var0.width = var0.rawWidth * var1 >> 14;
      }

      if (var0.heightAlignment == 0) {
         var0.height = var0.rawHeight;
      } else if (var0.heightAlignment == 1) {
         var0.height = var2 - var0.rawHeight;
      } else if (var0.heightAlignment == 2) {
         var0.height = var2 * var0.rawHeight >> 14;
      }

      if (var0.widthAlignment == 4) {
         var0.width = var0.field2973 * var0.height / var0.field2888;
      }

      if (var0.heightAlignment == 4) {
         var0.height = var0.width * var0.field2888 / var0.field2973;
      }

      if (var0.contentType == 1337) {
         Client.viewportWidget = var0;
      }

      if (var0.type == 12) {
         var0.method1758().method1658(var0.width, var0.height);
      }

      if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.args = var0.onResize;
         Client.scriptEvents.addFirst(var6);
      }

   }
}
