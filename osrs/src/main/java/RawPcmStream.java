import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
   @ObfuscatedName("h")
   int field231;
   @ObfuscatedName("e")
   int field232;
   @ObfuscatedName("v")
   int field245;
   @ObfuscatedName("x")
   int field233;
   @ObfuscatedName("m")
   int field235;
   @ObfuscatedName("q")
   int field234;
   @ObfuscatedName("f")
   int field237;
   @ObfuscatedName("r")
   @Export("numLoops")
   int numLoops;
   @ObfuscatedName("u")
   @Export("start")
   int start;
   @ObfuscatedName("b")
   @Export("end")
   int end;
   @ObfuscatedName("j")
   boolean field241;
   @ObfuscatedName("g")
   int field242;
   @ObfuscatedName("i")
   int field243;
   @ObfuscatedName("o")
   int field244;
   @ObfuscatedName("n")
   int field240;

   @ObfuscatedSignature(
      descriptor = "(Laf;III)V"
   )
   RawPcmStream(RawSound var1, int var2, int var3, int var4) {
      super.sound = var1;
      this.start = var1.start;
      this.end = var1.end;
      this.field241 = var1.field173;
      this.field232 = var2;
      this.field245 = var3;
      this.field233 = var4;
      this.field231 = 0;
      this.method249();
   }

   @ObfuscatedSignature(
      descriptor = "(Laf;II)V"
   )
   RawPcmStream(RawSound var1, int var2, int var3) {
      super.sound = var1;
      this.start = var1.start;
      this.end = var1.end;
      this.field241 = var1.field173;
      this.field232 = var2;
      this.field245 = var3;
      this.field233 = 8192;
      this.field231 = 0;
      this.method249();
   }

   @ObfuscatedName("m")
   void method249() {
      this.field235 = this.field245;
      this.field234 = method283(this.field245, this.field233);
      this.field237 = method287(this.field245, this.field233);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "()Laa;"
   )
   @Export("firstSubStream")
   protected PcmStream firstSubStream() {
      return null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "()Laa;"
   )
   @Export("nextSubStream")
   protected PcmStream nextSubStream() {
      return null;
   }

   @ObfuscatedName("r")
   @Export("vmethod5648")
   protected int vmethod5648() {
      return this.field245 == 0 && this.field242 == 0 ? 0 : 1;
   }

   @ObfuscatedName("u")
   @Export("fill")
   public synchronized void fill(int[] var1, int var2, int var3) {
      if (this.field245 == 0 && this.field242 == 0) {
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
         if (this.field231 < 0) {
            if (this.field232 <= 0) {
               this.method282();
               this.remove();
               return;
            }

            this.field231 = 0;
         }

         if (this.field231 >= var7) {
            if (this.field232 >= 0) {
               this.method282();
               this.remove();
               return;
            }

            this.field231 = var7 - 1;
         }

         if (this.numLoops < 0) {
            if (this.field241) {
               if (this.field232 < 0) {
                  var9 = this.method268(var1, var2, var5, var3, var4.samples[this.start]);
                  if (this.field231 >= var5) {
                     return;
                  }

                  this.field231 = var5 + var5 - 1 - this.field231;
                  this.field232 = -this.field232;
               }

               while(true) {
                  var9 = this.method267(var1, var9, var6, var3, var4.samples[this.end - 1]);
                  if (this.field231 < var6) {
                     return;
                  }

                  this.field231 = var6 + var6 - 1 - this.field231;
                  this.field232 = -this.field232;
                  var9 = this.method268(var1, var9, var5, var3, var4.samples[this.start]);
                  if (this.field231 >= var5) {
                     return;
                  }

                  this.field231 = var5 + var5 - 1 - this.field231;
                  this.field232 = -this.field232;
               }
            } else if (this.field232 < 0) {
               while(true) {
                  var9 = this.method268(var1, var9, var5, var3, var4.samples[this.end - 1]);
                  if (this.field231 >= var5) {
                     return;
                  }

                  this.field231 = var6 - 1 - (var6 - 1 - this.field231) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method267(var1, var9, var6, var3, var4.samples[this.start]);
                  if (this.field231 < var6) {
                     return;
                  }

                  this.field231 = var5 + (this.field231 - var5) % var8;
               }
            }
         } else {
            if (this.numLoops > 0) {
               if (this.field241) {
                  label132: {
                     if (this.field232 < 0) {
                        var9 = this.method268(var1, var2, var5, var3, var4.samples[this.start]);
                        if (this.field231 >= var5) {
                           return;
                        }

                        this.field231 = var5 + var5 - 1 - this.field231;
                        this.field232 = -this.field232;
                        if (--this.numLoops == 0) {
                           break label132;
                        }
                     }

                     do {
                        var9 = this.method267(var1, var9, var6, var3, var4.samples[this.end - 1]);
                        if (this.field231 < var6) {
                           return;
                        }

                        this.field231 = var6 + var6 - 1 - this.field231;
                        this.field232 = -this.field232;
                        if (--this.numLoops == 0) {
                           break;
                        }

                        var9 = this.method268(var1, var9, var5, var3, var4.samples[this.start]);
                        if (this.field231 >= var5) {
                           return;
                        }

                        this.field231 = var5 + var5 - 1 - this.field231;
                        this.field232 = -this.field232;
                     } while(--this.numLoops != 0);
                  }
               } else {
                  int var10;
                  if (this.field232 < 0) {
                     while(true) {
                        var9 = this.method268(var1, var9, var5, var3, var4.samples[this.end - 1]);
                        if (this.field231 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field231) / var8;
                        if (var10 >= this.numLoops) {
                           this.field231 += var8 * this.numLoops;
                           this.numLoops = 0;
                           break;
                        }

                        this.field231 += var8 * var10;
                        this.numLoops -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method267(var1, var9, var6, var3, var4.samples[this.start]);
                        if (this.field231 < var6) {
                           return;
                        }

                        var10 = (this.field231 - var5) / var8;
                        if (var10 >= this.numLoops) {
                           this.field231 -= var8 * this.numLoops;
                           this.numLoops = 0;
                           break;
                        }

                        this.field231 -= var8 * var10;
                        this.numLoops -= var10;
                     }
                  }
               }
            }

            if (this.field232 < 0) {
               this.method268(var1, var9, 0, var3, 0);
               if (this.field231 < 0) {
                  this.field231 = -1;
                  this.method282();
                  this.remove();
               }
            } else {
               this.method267(var1, var9, var7, var3, 0);
               if (this.field231 >= var7) {
                  this.field231 = var7;
                  this.method282();
                  this.remove();
               }
            }

         }
      }
   }

   @ObfuscatedName("b")
   @Export("setNumLoops")
   public synchronized void setNumLoops(int var1) {
      this.numLoops = var1;
   }

   @ObfuscatedName("j")
   @Export("skip")
   public synchronized void skip(int var1) {
      if (this.field242 > 0) {
         if (var1 >= this.field242) {
            if (this.field245 == Integer.MIN_VALUE) {
               this.field245 = 0;
               this.field237 = 0;
               this.field234 = 0;
               this.field235 = 0;
               this.remove();
               var1 = this.field242;
            }

            this.field242 = 0;
            this.method249();
         } else {
            this.field235 += this.field243 * var1;
            this.field234 += this.field244 * var1;
            this.field237 += this.field240 * var1;
            this.field242 -= var1;
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

      if (this.field231 < 0) {
         if (this.field232 <= 0) {
            this.method282();
            this.remove();
            return;
         }

         this.field231 = 0;
      }

      if (this.field231 >= var5) {
         if (this.field232 >= 0) {
            this.method282();
            this.remove();
            return;
         }

         this.field231 = var5 - 1;
      }

      this.field231 += this.field232 * var1;
      if (this.numLoops < 0) {
         if (!this.field241) {
            if (this.field232 < 0) {
               if (this.field231 >= var3) {
                  return;
               }

               this.field231 = var4 - 1 - (var4 - 1 - this.field231) % var6;
            } else {
               if (this.field231 < var4) {
                  return;
               }

               this.field231 = var3 + (this.field231 - var3) % var6;
            }

         } else {
            if (this.field232 < 0) {
               if (this.field231 >= var3) {
                  return;
               }

               this.field231 = var3 + var3 - 1 - this.field231;
               this.field232 = -this.field232;
            }

            while(this.field231 >= var4) {
               this.field231 = var4 + var4 - 1 - this.field231;
               this.field232 = -this.field232;
               if (this.field231 >= var3) {
                  return;
               }

               this.field231 = var3 + var3 - 1 - this.field231;
               this.field232 = -this.field232;
            }

         }
      } else {
         if (this.numLoops > 0) {
            if (this.field241) {
               label121: {
                  if (this.field232 < 0) {
                     if (this.field231 >= var3) {
                        return;
                     }

                     this.field231 = var3 + var3 - 1 - this.field231;
                     this.field232 = -this.field232;
                     if (--this.numLoops == 0) {
                        break label121;
                     }
                  }

                  do {
                     if (this.field231 < var4) {
                        return;
                     }

                     this.field231 = var4 + var4 - 1 - this.field231;
                     this.field232 = -this.field232;
                     if (--this.numLoops == 0) {
                        break;
                     }

                     if (this.field231 >= var3) {
                        return;
                     }

                     this.field231 = var3 + var3 - 1 - this.field231;
                     this.field232 = -this.field232;
                  } while(--this.numLoops != 0);
               }
            } else {
               label153: {
                  int var7;
                  if (this.field232 < 0) {
                     if (this.field231 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field231) / var6;
                     if (var7 >= this.numLoops) {
                        this.field231 += var6 * this.numLoops;
                        this.numLoops = 0;
                        break label153;
                     }

                     this.field231 += var6 * var7;
                     this.numLoops -= var7;
                  } else {
                     if (this.field231 < var4) {
                        return;
                     }

                     var7 = (this.field231 - var3) / var6;
                     if (var7 >= this.numLoops) {
                        this.field231 -= var6 * this.numLoops;
                        this.numLoops = 0;
                        break label153;
                     }

                     this.field231 -= var6 * var7;
                     this.numLoops -= var7;
                  }

                  return;
               }
            }
         }

         if (this.field232 < 0) {
            if (this.field231 < 0) {
               this.field231 = -1;
               this.method282();
               this.remove();
            }
         } else if (this.field231 >= var5) {
            this.field231 = var5;
            this.method282();
            this.remove();
         }

      }
   }

   @ObfuscatedName("g")
   public synchronized void method251(int var1) {
      this.method252(var1 << 6, this.method263());
   }

   @ObfuscatedName("i")
   synchronized void method289(int var1) {
      this.method252(var1, this.method263());
   }

   @ObfuscatedName("o")
   synchronized void method252(int var1, int var2) {
      this.field245 = var1;
      this.field233 = var2;
      this.field242 = 0;
      this.method249();
   }

   @ObfuscatedName("n")
   public synchronized int method284() {
      return this.field245 == Integer.MIN_VALUE ? 0 : this.field245;
   }

   @ObfuscatedName("k")
   public synchronized int method263() {
      return this.field233 < 0 ? -1 : this.field233;
   }

   @ObfuscatedName("a")
   public synchronized void method255(int var1) {
      int var2 = ((RawSound)super.sound).samples.length << 8;
      if (var1 < -1) {
         var1 = -1;
      }

      if (var1 > var2) {
         var1 = var2;
      }

      this.field231 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method256() {
      this.field232 = (this.field232 ^ this.field232 >> 31) + (this.field232 >>> 31);
      this.field232 = -this.field232;
   }

   @ObfuscatedName("l")
   void method282() {
      if (this.field242 != 0) {
         if (this.field245 == Integer.MIN_VALUE) {
            this.field245 = 0;
         }

         this.field242 = 0;
         this.method249();
      }

   }

   @ObfuscatedName("t")
   public synchronized void method257(int var1, int var2) {
      this.method258(var1, var2, this.method263());
   }

   @ObfuscatedName("c")
   public synchronized void method258(int var1, int var2, int var3) {
      if (var1 == 0) {
         this.method252(var2, var3);
      } else {
         int var4 = method283(var2, var3);
         int var5 = method287(var2, var3);
         if (var4 == this.field234 && var5 == this.field237) {
            this.field242 = 0;
         } else {
            int var6 = var2 - this.field235;
            if (this.field235 - var2 > var6) {
               var6 = this.field235 - var2;
            }

            if (var4 - this.field234 > var6) {
               var6 = var4 - this.field234;
            }

            if (this.field234 - var4 > var6) {
               var6 = this.field234 - var4;
            }

            if (var5 - this.field237 > var6) {
               var6 = var5 - this.field237;
            }

            if (this.field237 - var5 > var6) {
               var6 = this.field237 - var5;
            }

            if (var1 > var6) {
               var1 = var6;
            }

            this.field242 = var1;
            this.field245 = var2;
            this.field233 = var3;
            this.field243 = (var2 - this.field235) / var1;
            this.field244 = (var4 - this.field234) / var1;
            this.field240 = (var5 - this.field237) / var1;
         }
      }
   }

   @ObfuscatedName("ay")
   public synchronized void method259(int var1) {
      if (var1 == 0) {
         this.method289(0);
         this.remove();
      } else if (this.field234 == 0 && this.field237 == 0) {
         this.field242 = 0;
         this.field245 = 0;
         this.field235 = 0;
         this.remove();
      } else {
         int var2 = -this.field235;
         if (this.field235 > var2) {
            var2 = this.field235;
         }

         if (-this.field234 > var2) {
            var2 = -this.field234;
         }

         if (this.field234 > var2) {
            var2 = this.field234;
         }

         if (-this.field237 > var2) {
            var2 = -this.field237;
         }

         if (this.field237 > var2) {
            var2 = this.field237;
         }

         if (var1 > var2) {
            var1 = var2;
         }

         this.field242 = var1;
         this.field245 = Integer.MIN_VALUE;
         this.field243 = -this.field235 / var1;
         this.field244 = -this.field234 / var1;
         this.field240 = -this.field237 / var1;
      }
   }

   @ObfuscatedName("an")
   public synchronized void method260(int var1) {
      if (this.field232 < 0) {
         this.field232 = -var1;
      } else {
         this.field232 = var1;
      }

   }

   @ObfuscatedName("ab")
   public synchronized int method261() {
      return this.field232 < 0 ? -this.field232 : this.field232;
   }

   @ObfuscatedName("al")
   public boolean method262() {
      return this.field231 < 0 || this.field231 >= ((RawSound)super.sound).samples.length << 8;
   }

   @ObfuscatedName("az")
   public boolean method286() {
      return this.field242 != 0;
   }

   @ObfuscatedName("ak")
   int method267(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if (this.field242 > 0) {
            int var6 = var2 + this.field242;
            if (var6 > var4) {
               var6 = var4;
            }

            this.field242 += var2;
            if (this.field232 == 256 && (this.field231 & 255) == 0) {
               if (class286.PcmPlayer_stereo) {
                  var2 = method285(0, ((RawSound)super.sound).samples, var1, this.field231, var2, this.field234, this.field237, this.field244, this.field240, 0, var6, var3, this);
               } else {
                  var2 = method274(((RawSound)super.sound).samples, var1, this.field231, var2, this.field235, this.field243, 0, var6, var3, this);
               }
            } else if (class286.PcmPlayer_stereo) {
               var2 = method265(0, 0, ((RawSound)super.sound).samples, var1, this.field231, var2, this.field234, this.field237, this.field244, this.field240, 0, var6, var3, this, this.field232, var5);
            } else {
               var2 = method277(0, 0, ((RawSound)super.sound).samples, var1, this.field231, var2, this.field235, this.field243, 0, var6, var3, this, this.field232, var5);
            }

            this.field242 -= var2;
            if (this.field242 != 0) {
               return var2;
            }

            if (!this.method290()) {
               continue;
            }

            return var4;
         }

         if (this.field232 == 256 && (this.field231 & 255) == 0) {
            if (class286.PcmPlayer_stereo) {
               return method269(0, ((RawSound)super.sound).samples, var1, this.field231, var2, this.field234, this.field237, 0, var4, var3, this);
            }

            return method253(((RawSound)super.sound).samples, var1, this.field231, var2, this.field235, 0, var4, var3, this);
         }

         if (class286.PcmPlayer_stereo) {
            return method271(0, 0, ((RawSound)super.sound).samples, var1, this.field231, var2, this.field234, this.field237, 0, var4, var3, this, this.field232, var5);
         }

         return method291(0, 0, ((RawSound)super.sound).samples, var1, this.field231, var2, this.field235, 0, var4, var3, this, this.field232, var5);
      }
   }

   @ObfuscatedName("af")
   @Export("vmethod1019")
   int vmethod1019() {
      int var1 = this.field235 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if (this.numLoops == 0) {
         var1 -= var1 * this.field231 / (((RawSound)super.sound).samples.length << 8);
      } else if (this.numLoops >= 0) {
         var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
      }

      return var1 > 255 ? 255 : var1;
   }

   @ObfuscatedName("ai")
   int method268(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if (this.field242 > 0) {
            int var6 = var2 + this.field242;
            if (var6 > var4) {
               var6 = var4;
            }

            this.field242 += var2;
            if (this.field232 == -256 && (this.field231 & 255) == 0) {
               if (class286.PcmPlayer_stereo) {
                  var2 = method276(0, ((RawSound)super.sound).samples, var1, this.field231, var2, this.field234, this.field237, this.field244, this.field240, 0, var6, var3, this);
               } else {
                  var2 = method275(((RawSound)super.sound).samples, var1, this.field231, var2, this.field235, this.field243, 0, var6, var3, this);
               }
            } else if (class286.PcmPlayer_stereo) {
               var2 = method279(0, 0, ((RawSound)super.sound).samples, var1, this.field231, var2, this.field234, this.field237, this.field244, this.field240, 0, var6, var3, this, this.field232, var5);
            } else {
               var2 = method278(0, 0, ((RawSound)super.sound).samples, var1, this.field231, var2, this.field235, this.field243, 0, var6, var3, this, this.field232, var5);
            }

            this.field242 -= var2;
            if (this.field242 != 0) {
               return var2;
            }

            if (!this.method290()) {
               continue;
            }

            return var4;
         }

         if (this.field232 == -256 && (this.field231 & 255) == 0) {
            if (class286.PcmPlayer_stereo) {
               return method270(0, ((RawSound)super.sound).samples, var1, this.field231, var2, this.field234, this.field237, 0, var4, var3, this);
            }

            return method288(((RawSound)super.sound).samples, var1, this.field231, var2, this.field235, 0, var4, var3, this);
         }

         if (class286.PcmPlayer_stereo) {
            return method273(0, 0, ((RawSound)super.sound).samples, var1, this.field231, var2, this.field234, this.field237, 0, var4, var3, this, this.field232, var5);
         }

         return method272(0, 0, ((RawSound)super.sound).samples, var1, this.field231, var2, this.field235, 0, var4, var3, this, this.field232, var5);
      }
   }

   @ObfuscatedName("ax")
   boolean method290() {
      int var1 = this.field245;
      int var2;
      int var3;
      if (var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method283(var1, this.field233);
         var3 = method287(var1, this.field233);
      }

      if (var1 == this.field235 && var2 == this.field234 && var3 == this.field237) {
         if (this.field245 == Integer.MIN_VALUE) {
            this.field245 = 0;
            this.field237 = 0;
            this.field234 = 0;
            this.field235 = 0;
            this.remove();
            return true;
         } else {
            this.method249();
            return false;
         }
      } else {
         if (this.field235 < var1) {
            this.field243 = 1;
            this.field242 = var1 - this.field235;
         } else if (this.field235 > var1) {
            this.field243 = -1;
            this.field242 = this.field235 - var1;
         } else {
            this.field243 = 0;
         }

         if (this.field234 < var2) {
            this.field244 = 1;
            if (this.field242 == 0 || this.field242 > var2 - this.field234) {
               this.field242 = var2 - this.field234;
            }
         } else if (this.field234 > var2) {
            this.field244 = -1;
            if (this.field242 == 0 || this.field242 > this.field234 - var2) {
               this.field242 = this.field234 - var2;
            }
         } else {
            this.field244 = 0;
         }

         if (this.field237 < var3) {
            this.field240 = 1;
            if (this.field242 == 0 || this.field242 > var3 - this.field237) {
               this.field242 = var3 - this.field237;
            }
         } else if (this.field237 > var3) {
            this.field240 = -1;
            if (this.field242 == 0 || this.field242 > this.field237 - var3) {
               this.field242 = this.field237 - var3;
            }
         } else {
            this.field240 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("h")
   static int method283(int var0, int var1) {
      return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("e")
   static int method287(int var0, int var1) {
      return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Laf;II)Lap;"
   )
   @Export("createRawPcmStream")
   public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
      return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(PcmPlayer.field198 * 100)), var2 << 6) : null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Laf;III)Lap;"
   )
   public static RawPcmStream method292(RawSound var0, int var1, int var2, int var3) {
      return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIILap;)I"
   )
   static int method253(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

      var8.field231 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIILap;)I"
   )
   static int method269(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

      var10.field231 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIILap;)I"
   )
   static int method288(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

      var8.field231 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIILap;)I"
   )
   static int method270(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

      var10.field231 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIILap;II)I"
   )
   static int method291(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

      var10.field231 = var4;
      return var5;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILap;II)I"
   )
   static int method271(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

      var11.field231 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIILap;II)I"
   )
   static int method272(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

      var10.field231 = var4;
      return var5;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILap;II)I"
   )
   static int method273(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

      var11.field231 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIIILap;)I"
   )
   static int method274(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if ((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field234 += var9.field244 * (var6 - var3);
      var9.field237 += var9.field240 * (var6 - var3);

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

      var9.field235 = var4 >> 2;
      var9.field231 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIIIILap;)I"
   )
   static int method285(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if ((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field235 += var12.field243 * (var9 - var4);
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

      var12.field234 = var5 >> 2;
      var12.field237 = var6 >> 2;
      var12.field231 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIIILap;)I"
   )
   static int method275(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field234 += var9.field244 * (var6 - var3);
      var9.field237 += var9.field240 * (var6 - var3);

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

      var9.field235 = var4 >> 2;
      var9.field231 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIIIILap;)I"
   )
   static int method276(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field235 += var12.field243 * (var9 - var4);
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

      var12.field234 = var5 >> 2;
      var12.field237 = var6 >> 2;
      var12.field231 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILap;II)I"
   )
   static int method277(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      var11.field234 -= var11.field244 * var5;
      var11.field237 -= var11.field240 * var5;
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

      var11.field234 += var11.field244 * var5;
      var11.field237 += var11.field240 * var5;
      var11.field235 = var6;
      var11.field231 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIIIILap;II)I"
   )
   static int method265(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
      var13.field235 -= var5 * var13.field243;
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
      var13.field235 += var13.field243 * var5;
      var13.field234 = var6;
      var13.field237 = var7;
      var13.field231 = var4;
      return var5;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILap;II)I"
   )
   static int method278(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      var11.field234 -= var11.field244 * var5;
      var11.field237 -= var11.field240 * var5;
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

      var11.field234 += var11.field244 * var5;
      var11.field237 += var11.field240 * var5;
      var11.field235 = var6;
      var11.field231 = var4;
      return var5;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIIIILap;II)I"
   )
   static int method279(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
      var13.field235 -= var5 * var13.field243;
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
      var13.field235 += var13.field243 * var5;
      var13.field234 = var6;
      var13.field237 = var7;
      var13.field231 = var4;
      return var5;
   }
}
