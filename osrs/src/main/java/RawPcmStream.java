import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
   @ObfuscatedName("aj")
   int field236;
   @ObfuscatedName("al")
   int field244;
   @ObfuscatedName("ac")
   int field235;
   @ObfuscatedName("ab")
   int field233;
   @ObfuscatedName("an")
   int field234;
   @ObfuscatedName("ao")
   int field238;
   @ObfuscatedName("av")
   int field239;
   @ObfuscatedName("aq")
   @Export("numLoops")
   int numLoops;
   @ObfuscatedName("ap")
   @Export("start")
   int start;
   @ObfuscatedName("ar")
   @Export("end")
   int end;
   @ObfuscatedName("ak")
   boolean field237;
   @ObfuscatedName("ax")
   int field247;
   @ObfuscatedName("as")
   int field245;
   @ObfuscatedName("ay")
   int field246;
   @ObfuscatedName("am")
   int field240;

   @ObfuscatedSignature(
      descriptor = "(Lbe;III)V"
   )
   RawPcmStream(RawSound var1, int var2, int var3, int var4) {
      super.sound = var1;
      this.start = var1.start;
      this.end = var1.end;
      this.field237 = var1.field173;
      this.field244 = var2;
      this.field235 = var3;
      this.field233 = var4;
      this.field236 = 0;
      this.method240();
   }

   @ObfuscatedSignature(
      descriptor = "(Lbe;II)V"
   )
   RawPcmStream(RawSound var1, int var2, int var3) {
      super.sound = var1;
      this.start = var1.start;
      this.end = var1.end;
      this.field237 = var1.field173;
      this.field244 = var2;
      this.field235 = var3;
      this.field233 = 8192;
      this.field236 = 0;
      this.method240();
   }

   @ObfuscatedName("an")
   void method240() {
      this.field234 = this.field235;
      this.field238 = method272(this.field235, this.field233);
      this.field239 = method235(this.field235, this.field233);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "()Lbj;"
   )
   @Export("firstSubStream")
   protected PcmStream firstSubStream() {
      return null;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "()Lbj;"
   )
   @Export("nextSubStream")
   protected PcmStream nextSubStream() {
      return null;
   }

   @ObfuscatedName("aq")
   @Export("vmethod5648")
   protected int vmethod5648() {
      return this.field235 == 0 && this.field247 == 0 ? 0 : 1;
   }

   @ObfuscatedName("ap")
   @Export("fill")
   public synchronized void fill(int[] var1, int var2, int var3) {
      if (this.field235 == 0 && this.field247 == 0) {
         this.skip(var3);
      } else {
         RawSound var4 = (RawSound)super.sound;
         int var5 = this.start << 8;
         int var6 = this.end << 8;
         int var7 = var4.samples.length << 8;
         int var8 = var6 - var5;
         if (var8 <= 0) {
            this.numLoops = 0;
         }

         int var9 = var2;
         var3 += var2;
         if (this.field236 < 0) {
            if (this.field244 <= 0) {
               this.method275();
               this.remove();
               return;
            }

            this.field236 = 0;
         }

         if (this.field236 >= var7) {
            if (this.field244 >= 0) {
               this.method275();
               this.remove();
               return;
            }

            this.field236 = var7 - 1;
         }

         if (this.numLoops < 0) {
            if (this.field237) {
               if (this.field244 < 0) {
                  var9 = this.method255(var1, var2, var5, var3, var4.samples[this.start]);
                  if (this.field236 >= var5) {
                     return;
                  }

                  this.field236 = var5 + var5 - 1 - this.field236;
                  this.field244 = -this.field244;
               }

               while(true) {
                  var9 = this.method258(var1, var9, var6, var3, var4.samples[this.end - 1]);
                  if (this.field236 < var6) {
                     return;
                  }

                  this.field236 = var6 + var6 - 1 - this.field236;
                  this.field244 = -this.field244;
                  var9 = this.method255(var1, var9, var5, var3, var4.samples[this.start]);
                  if (this.field236 >= var5) {
                     return;
                  }

                  this.field236 = var5 + var5 - 1 - this.field236;
                  this.field244 = -this.field244;
               }
            } else if (this.field244 < 0) {
               while(true) {
                  var9 = this.method255(var1, var9, var5, var3, var4.samples[this.end - 1]);
                  if (this.field236 >= var5) {
                     return;
                  }

                  this.field236 = var6 - 1 - (var6 - 1 - this.field236) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method258(var1, var9, var6, var3, var4.samples[this.start]);
                  if (this.field236 < var6) {
                     return;
                  }

                  this.field236 = var5 + (this.field236 - var5) % var8;
               }
            }
         } else {
            if (this.numLoops > 0) {
               if (this.field237) {
                  label132: {
                     if (this.field244 < 0) {
                        var9 = this.method255(var1, var2, var5, var3, var4.samples[this.start]);
                        if (this.field236 >= var5) {
                           return;
                        }

                        this.field236 = var5 + var5 - 1 - this.field236;
                        this.field244 = -this.field244;
                        if (--this.numLoops == 0) {
                           break label132;
                        }
                     }

                     do {
                        var9 = this.method258(var1, var9, var6, var3, var4.samples[this.end - 1]);
                        if (this.field236 < var6) {
                           return;
                        }

                        this.field236 = var6 + var6 - 1 - this.field236;
                        this.field244 = -this.field244;
                        if (--this.numLoops == 0) {
                           break;
                        }

                        var9 = this.method255(var1, var9, var5, var3, var4.samples[this.start]);
                        if (this.field236 >= var5) {
                           return;
                        }

                        this.field236 = var5 + var5 - 1 - this.field236;
                        this.field244 = -this.field244;
                     } while(--this.numLoops != 0);
                  }
               } else {
                  int var10;
                  if (this.field244 < 0) {
                     while(true) {
                        var9 = this.method255(var1, var9, var5, var3, var4.samples[this.end - 1]);
                        if (this.field236 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field236) / var8;
                        if (var10 >= this.numLoops) {
                           this.field236 += var8 * this.numLoops;
                           this.numLoops = 0;
                           break;
                        }

                        this.field236 += var8 * var10;
                        this.numLoops -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method258(var1, var9, var6, var3, var4.samples[this.start]);
                        if (this.field236 < var6) {
                           return;
                        }

                        var10 = (this.field236 - var5) / var8;
                        if (var10 >= this.numLoops) {
                           this.field236 -= var8 * this.numLoops;
                           this.numLoops = 0;
                           break;
                        }

                        this.field236 -= var8 * var10;
                        this.numLoops -= var10;
                     }
                  }
               }
            }

            if (this.field244 < 0) {
               this.method255(var1, var9, 0, var3, 0);
               if (this.field236 < 0) {
                  this.field236 = -1;
                  this.method275();
                  this.remove();
               }
            } else {
               this.method258(var1, var9, var7, var3, 0);
               if (this.field236 >= var7) {
                  this.field236 = var7;
                  this.method275();
                  this.remove();
               }
            }

         }
      }
   }

   @ObfuscatedName("ar")
   @Export("setNumLoops")
   public synchronized void setNumLoops(int var1) {
      this.numLoops = var1;
   }

   @ObfuscatedName("ak")
   @Export("skip")
   public synchronized void skip(int var1) {
      if (this.field247 > 0) {
         if (var1 >= this.field247) {
            if (this.field235 == Integer.MIN_VALUE) {
               this.field235 = 0;
               this.field239 = 0;
               this.field238 = 0;
               this.field234 = 0;
               this.remove();
               var1 = this.field247;
            }

            this.field247 = 0;
            this.method240();
         } else {
            this.field234 += this.field245 * var1;
            this.field238 += this.field246 * var1;
            this.field239 += this.field240 * var1;
            this.field247 -= var1;
         }
      }

      RawSound var2 = (RawSound)super.sound;
      int var3 = this.start << 8;
      int var4 = this.end << 8;
      int var5 = var2.samples.length << 8;
      int var6 = var4 - var3;
      if (var6 <= 0) {
         this.numLoops = 0;
      }

      if (this.field236 < 0) {
         if (this.field244 <= 0) {
            this.method275();
            this.remove();
            return;
         }

         this.field236 = 0;
      }

      if (this.field236 >= var5) {
         if (this.field244 >= 0) {
            this.method275();
            this.remove();
            return;
         }

         this.field236 = var5 - 1;
      }

      this.field236 += this.field244 * var1;
      if (this.numLoops < 0) {
         if (!this.field237) {
            if (this.field244 < 0) {
               if (this.field236 >= var3) {
                  return;
               }

               this.field236 = var4 - 1 - (var4 - 1 - this.field236) % var6;
            } else {
               if (this.field236 < var4) {
                  return;
               }

               this.field236 = var3 + (this.field236 - var3) % var6;
            }

         } else {
            if (this.field244 < 0) {
               if (this.field236 >= var3) {
                  return;
               }

               this.field236 = var3 + var3 - 1 - this.field236;
               this.field244 = -this.field244;
            }

            while(this.field236 >= var4) {
               this.field236 = var4 + var4 - 1 - this.field236;
               this.field244 = -this.field244;
               if (this.field236 >= var3) {
                  return;
               }

               this.field236 = var3 + var3 - 1 - this.field236;
               this.field244 = -this.field244;
            }

         }
      } else {
         if (this.numLoops > 0) {
            if (this.field237) {
               label121: {
                  if (this.field244 < 0) {
                     if (this.field236 >= var3) {
                        return;
                     }

                     this.field236 = var3 + var3 - 1 - this.field236;
                     this.field244 = -this.field244;
                     if (--this.numLoops == 0) {
                        break label121;
                     }
                  }

                  do {
                     if (this.field236 < var4) {
                        return;
                     }

                     this.field236 = var4 + var4 - 1 - this.field236;
                     this.field244 = -this.field244;
                     if (--this.numLoops == 0) {
                        break;
                     }

                     if (this.field236 >= var3) {
                        return;
                     }

                     this.field236 = var3 + var3 - 1 - this.field236;
                     this.field244 = -this.field244;
                  } while(--this.numLoops != 0);
               }
            } else {
               label153: {
                  int var7;
                  if (this.field244 < 0) {
                     if (this.field236 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field236) / var6;
                     if (var7 >= this.numLoops) {
                        this.field236 += var6 * this.numLoops;
                        this.numLoops = 0;
                        break label153;
                     }

                     this.field236 += var6 * var7;
                     this.numLoops -= var7;
                  } else {
                     if (this.field236 < var4) {
                        return;
                     }

                     var7 = (this.field236 - var3) / var6;
                     if (var7 >= this.numLoops) {
                        this.field236 -= var6 * this.numLoops;
                        this.numLoops = 0;
                        break label153;
                     }

                     this.field236 -= var6 * var7;
                     this.numLoops -= var7;
                  }

                  return;
               }
            }
         }

         if (this.field244 < 0) {
            if (this.field236 < 0) {
               this.field236 = -1;
               this.method275();
               this.remove();
            }
         } else if (this.field236 >= var5) {
            this.field236 = var5;
            this.method275();
            this.remove();
         }

      }
   }

   @ObfuscatedName("ax")
   public synchronized void method279(int var1) {
      this.method241(var1 << 6, this.method270());
   }

   @ObfuscatedName("as")
   synchronized void method268(int var1) {
      this.method241(var1, this.method270());
   }

   @ObfuscatedName("ay")
   synchronized void method241(int var1, int var2) {
      this.field235 = var1;
      this.field233 = var2;
      this.field247 = 0;
      this.method240();
   }

   @ObfuscatedName("am")
   public synchronized int method242() {
      return this.field235 == Integer.MIN_VALUE ? 0 : this.field235;
   }

   @ObfuscatedName("az")
   public synchronized int method270() {
      return this.field233 < 0 ? -1 : this.field233;
   }

   @ObfuscatedName("ae")
   public synchronized void method273(int var1) {
      int var2 = ((RawSound)super.sound).samples.length << 8;
      if (var1 < -1) {
         var1 = -1;
      }

      if (var1 > var2) {
         var1 = var2;
      }

      this.field236 = var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method243() {
      this.field244 = (this.field244 ^ this.field244 >> 31) + (this.field244 >>> 31);
      this.field244 = -this.field244;
   }

   @ObfuscatedName("ag")
   void method275() {
      if (this.field247 != 0) {
         if (this.field235 == Integer.MIN_VALUE) {
            this.field235 = 0;
         }

         this.field247 = 0;
         this.method240();
      }

   }

   @ObfuscatedName("at")
   public synchronized void method245(int var1, int var2) {
      this.method246(var1, var2, this.method270());
   }

   @ObfuscatedName("af")
   public synchronized void method246(int var1, int var2, int var3) {
      if (var1 == 0) {
         this.method241(var2, var3);
      } else {
         int var4 = method272(var2, var3);
         int var5 = method235(var2, var3);
         if (var4 == this.field238 && var5 == this.field239) {
            this.field247 = 0;
         } else {
            int var6 = var2 - this.field234;
            if (this.field234 - var2 > var6) {
               var6 = this.field234 - var2;
            }

            if (var4 - this.field238 > var6) {
               var6 = var4 - this.field238;
            }

            if (this.field238 - var4 > var6) {
               var6 = this.field238 - var4;
            }

            if (var5 - this.field239 > var6) {
               var6 = var5 - this.field239;
            }

            if (this.field239 - var5 > var6) {
               var6 = this.field239 - var5;
            }

            if (var1 > var6) {
               var1 = var6;
            }

            this.field247 = var1;
            this.field235 = var2;
            this.field233 = var3;
            this.field245 = (var2 - this.field234) / var1;
            this.field246 = (var4 - this.field238) / var1;
            this.field240 = (var5 - this.field239) / var1;
         }
      }
   }

   @ObfuscatedName("ai")
   public synchronized void method247(int var1) {
      if (var1 == 0) {
         this.method268(0);
         this.remove();
      } else if (this.field238 == 0 && this.field239 == 0) {
         this.field247 = 0;
         this.field235 = 0;
         this.field234 = 0;
         this.remove();
      } else {
         int var2 = -this.field234;
         if (this.field234 > var2) {
            var2 = this.field234;
         }

         if (-this.field238 > var2) {
            var2 = -this.field238;
         }

         if (this.field238 > var2) {
            var2 = this.field238;
         }

         if (-this.field239 > var2) {
            var2 = -this.field239;
         }

         if (this.field239 > var2) {
            var2 = this.field239;
         }

         if (var1 > var2) {
            var1 = var2;
         }

         this.field247 = var1;
         this.field235 = Integer.MIN_VALUE;
         this.field245 = -this.field234 / var1;
         this.field246 = -this.field238 / var1;
         this.field240 = -this.field239 / var1;
      }
   }

   @ObfuscatedName("aw")
   public synchronized void method248(int var1) {
      if (this.field244 < 0) {
         this.field244 = -var1;
      } else {
         this.field244 = var1;
      }

   }

   @ObfuscatedName("aa")
   public synchronized int method249() {
      return this.field244 < 0 ? -this.field244 : this.field244;
   }

   @ObfuscatedName("ah")
   public boolean method269() {
      return this.field236 < 0 || this.field236 >= ((RawSound)super.sound).samples.length << 8;
   }

   @ObfuscatedName("bz")
   public boolean method280() {
      return this.field247 != 0;
   }

   @ObfuscatedName("bq")
   int method258(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if (this.field247 > 0) {
            int var6 = var2 + this.field247;
            if (var6 > var4) {
               var6 = var4;
            }

            this.field247 += var2;
            if (this.field244 == 256 && (this.field236 & 255) == 0) {
               if (ChatChannel.PcmPlayer_stereo) {
                  var2 = method262(0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field238, this.field239, this.field246, this.field240, 0, var6, var3, this);
               } else {
                  var2 = method261(((RawSound)super.sound).samples, var1, this.field236, var2, this.field234, this.field245, 0, var6, var3, this);
               }
            } else if (ChatChannel.PcmPlayer_stereo) {
               var2 = method266(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field238, this.field239, this.field246, this.field240, 0, var6, var3, this, this.field244, var5);
            } else {
               var2 = method265(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field234, this.field245, 0, var6, var3, this, this.field244, var5);
            }

            this.field247 -= var2;
            if (this.field247 != 0) {
               return var2;
            }

            if (!this.method256()) {
               continue;
            }

            return var4;
         }

         if (this.field244 == 256 && (this.field236 & 255) == 0) {
            if (ChatChannel.PcmPlayer_stereo) {
               return method271(0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field238, this.field239, 0, var4, var3, this);
            }

            return method257(((RawSound)super.sound).samples, var1, this.field236, var2, this.field234, 0, var4, var3, this);
         }

         if (ChatChannel.PcmPlayer_stereo) {
            return method276(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field238, this.field239, 0, var4, var3, this, this.field244, var5);
         }

         return method237(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field234, 0, var4, var3, this, this.field244, var5);
      }
   }

   @ObfuscatedName("bc")
   int method255(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if (this.field247 > 0) {
            int var6 = var2 + this.field247;
            if (var6 > var4) {
               var6 = var4;
            }

            this.field247 += var2;
            if (this.field244 == -256 && (this.field236 & 255) == 0) {
               if (ChatChannel.PcmPlayer_stereo) {
                  var2 = method264(0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field238, this.field239, this.field246, this.field240, 0, var6, var3, this);
               } else {
                  var2 = method263(((RawSound)super.sound).samples, var1, this.field236, var2, this.field234, this.field245, 0, var6, var3, this);
               }
            } else if (ChatChannel.PcmPlayer_stereo) {
               var2 = method267(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field238, this.field239, this.field246, this.field240, 0, var6, var3, this, this.field244, var5);
            } else {
               var2 = method244(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field234, this.field245, 0, var6, var3, this, this.field244, var5);
            }

            this.field247 -= var2;
            if (this.field247 != 0) {
               return var2;
            }

            if (!this.method256()) {
               continue;
            }

            return var4;
         }

         if (this.field244 == -256 && (this.field236 & 255) == 0) {
            if (ChatChannel.PcmPlayer_stereo) {
               return method274(0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field238, this.field239, 0, var4, var3, this);
            }

            return method277(((RawSound)super.sound).samples, var1, this.field236, var2, this.field234, 0, var4, var3, this);
         }

         if (ChatChannel.PcmPlayer_stereo) {
            return method260(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field238, this.field239, 0, var4, var3, this, this.field244, var5);
         }

         return method259(0, 0, ((RawSound)super.sound).samples, var1, this.field236, var2, this.field234, 0, var4, var3, this, this.field244, var5);
      }
   }

   @ObfuscatedName("bu")
   boolean method256() {
      int var1 = this.field235;
      int var2;
      int var3;
      if (var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method272(var1, this.field233);
         var3 = method235(var1, this.field233);
      }

      if (var1 == this.field234 && var2 == this.field238 && var3 == this.field239) {
         if (this.field235 == Integer.MIN_VALUE) {
            this.field235 = 0;
            this.field239 = 0;
            this.field238 = 0;
            this.field234 = 0;
            this.remove();
            return true;
         } else {
            this.method240();
            return false;
         }
      } else {
         if (this.field234 < var1) {
            this.field245 = 1;
            this.field247 = var1 - this.field234;
         } else if (this.field234 > var1) {
            this.field245 = -1;
            this.field247 = this.field234 - var1;
         } else {
            this.field245 = 0;
         }

         if (this.field238 < var2) {
            this.field246 = 1;
            if (this.field247 == 0 || this.field247 > var2 - this.field238) {
               this.field247 = var2 - this.field238;
            }
         } else if (this.field238 > var2) {
            this.field246 = -1;
            if (this.field247 == 0 || this.field247 > this.field238 - var2) {
               this.field247 = this.field238 - var2;
            }
         } else {
            this.field246 = 0;
         }

         if (this.field239 < var3) {
            this.field240 = 1;
            if (this.field247 == 0 || this.field247 > var3 - this.field239) {
               this.field247 = var3 - this.field239;
            }
         } else if (this.field239 > var3) {
            this.field240 = -1;
            if (this.field247 == 0 || this.field247 > this.field239 - var3) {
               this.field247 = this.field239 - var3;
            }
         } else {
            this.field240 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("by")
   @Export("vmethod1019")
   int vmethod1019() {
      int var1 = this.field234 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if (this.numLoops == 0) {
         var1 -= var1 * this.field236 / (((RawSound)super.sound).samples.length << 8);
      } else if (this.numLoops >= 0) {
         var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
      }

      return var1 > 255 ? 255 : var1;
   }

   @ObfuscatedName("aj")
   static int method272(int var0, int var1) {
      return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("al")
   static int method235(int var0, int var1) {
      return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lbe;II)Lbn;"
   )
   @Export("createRawPcmStream")
   public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
      return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(PcmPlayer.field194 * 100)), var2 << 6) : null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lbe;III)Lbn;"
   )
   public static RawPcmStream method239(RawSound var0, int var1, int var2, int var3) {
      return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIILbn;)I"
   )
   static int method257(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if ((var5 = var3 + var7 - var2) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
         var10001 = var3++;
      }

      var8.field236 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIILbn;)I"
   )
   static int method271(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if ((var7 = var4 + var9 - var3) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      var10.field236 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIILbn;)I"
   )
   static int method277(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if ((var5 = var3 + var2 - (var7 - 1)) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
         var10001 = var3++;
      }

      var8.field236 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIILbn;)I"
   )
   static int method274(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if ((var7 = var3 + var4 - (var9 - 1)) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      var10.field236 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIILbn;II)I"
   )
   static int method237(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
      if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
         var7 = var8;
      }

      for(var1 = var12; var5 < var7; var4 += var11) {
         var13 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
      }

      var10.field236 = var4;
      return var5;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILbn;II)I"
   )
   static int method276(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field236 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIILbn;II)I"
   )
   static int method259(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
      if (var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
         var7 = var8;
      }

      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         byte var13 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
         var7 = var8;
      }

      var0 = var12;

      for(var1 = var11; var5 < var7; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
      }

      var10.field236 = var4;
      return var5;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILbn;II)I"
   )
   static int method260(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var0 = (var2[var1] - var14) * (var4 & 255) + (var14 << 8);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field236 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIIILbn;)I"
   )
   static int method261(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if ((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field238 += var9.field246 * (var6 - var3);
      var9.field239 += var9.field240 * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
      }

      var9.field234 = var4 >> 2;
      var9.field236 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIIIILbn;)I"
   )
   static int method262(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if ((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field234 += var12.field245 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field238 = var5 >> 2;
      var12.field239 = var6 >> 2;
      var12.field236 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIIILbn;)I"
   )
   static int method263(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field238 += var9.field246 * (var6 - var3);
      var9.field239 += var9.field240 * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
      }

      var9.field234 = var4 >> 2;
      var9.field236 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIIIILbn;)I"
   )
   static int method264(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field234 += var12.field245 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field238 = var5 >> 2;
      var12.field239 = var6 >> 2;
      var12.field236 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILbn;II)I"
   )
   static int method265(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      var11.field238 -= var11.field246 * var5;
      var11.field239 -= var11.field240 * var5;
      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var14;
      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field238 += var11.field246 * var5;
      var11.field239 += var11.field240 * var5;
      var11.field234 = var6;
      var11.field236 = var4;
      return var5;
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIIIILbn;II)I"
   )
   static int method266(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
      var13.field234 -= var5 * var13.field245;
      if (var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var16 = var2[var4 >> 8];
         var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field234 += var13.field245 * var5;
      var13.field238 = var6;
      var13.field239 = var7;
      var13.field236 = var4;
      return var5;
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILbn;II)I"
   )
   static int method244(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      var11.field238 -= var11.field246 * var5;
      var11.field239 -= var11.field240 * var5;
      if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var0 = var13;

      for(var1 = var12; var5 < var8; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field238 += var11.field246 * var5;
      var11.field239 += var11.field240 * var5;
      var11.field234 = var6;
      var11.field236 = var4;
      return var5;
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIIIILbn;II)I"
   )
   static int method267(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
      var13.field234 -= var5 * var13.field245;
      if (var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var16 = var2[var1 - 1];
         var0 = (var2[var1] - var16) * (var4 & 255) + (var16 << 8);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field234 += var13.field245 * var5;
      var13.field238 = var6;
      var13.field239 = var7;
      var13.field236 = var4;
      return var5;
   }
}
