import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class RawPcmStream extends PcmStream {
   @ObfuscatedName("h")
   int field365;
   @ObfuscatedName("e")
   int field366;
   @ObfuscatedName("v")
   int field379;
   @ObfuscatedName("x")
   int field367;
   @ObfuscatedName("m")
   int field369;
   @ObfuscatedName("q")
   int field368;
   @ObfuscatedName("f")
   int field371;
   @ObfuscatedName("r")
   int numLoops;
   @ObfuscatedName("u")
   int start;
   @ObfuscatedName("b")
   int end;
   @ObfuscatedName("j")
   boolean field375;
   @ObfuscatedName("g")
   int field376;
   @ObfuscatedName("i")
   int field377;
   @ObfuscatedName("o")
   int field378;
   @ObfuscatedName("n")
   int field374;

   @ObfuscatedSignature(
      descriptor = "(Laf;III)V"
   )
   RawPcmStream(RawSound var1, int var2, int var3, int var4) {
      super.sound = var1;
      this.start = var1.start;
      this.end = var1.end;
      this.field375 = var1.field299;
      this.field366 = var2;
      this.field379 = var3;
      this.field367 = var4;
      this.field365 = 0;
      this.method904();
   }

   @ObfuscatedSignature(
      descriptor = "(Laf;II)V"
   )
   RawPcmStream(RawSound var1, int var2, int var3) {
      super.sound = var1;
      this.start = var1.start;
      this.end = var1.end;
      this.field375 = var1.field299;
      this.field366 = var2;
      this.field379 = var3;
      this.field367 = 8192;
      this.field365 = 0;
      this.method904();
   }

   @ObfuscatedName("m")
   void method904() {
      this.field369 = this.field379;
      this.field368 = method961(this.field379, this.field367);
      this.field371 = method990(this.field379, this.field367);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "()Laa;"
   )
   protected PcmStream firstSubStream() {
      return null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "()Laa;"
   )
   protected PcmStream nextSubStream() {
      return null;
   }

   @ObfuscatedName("r")
   protected int vmethod5753() {
      return this.field379 == 0 && this.field376 == 0 ? 0 : 1;
   }

   @ObfuscatedName("u")
   public synchronized void fill(int[] var1, int var2, int var3) {
      if (this.field379 == 0 && this.field376 == 0) {
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
         if (this.field365 < 0) {
            if (this.field366 <= 0) {
               this.method958();
               this.remove();
               return;
            }

            this.field365 = 0;
         }

         if (this.field365 >= var7) {
            if (this.field366 >= 0) {
               this.method958();
               this.remove();
               return;
            }

            this.field365 = var7 - 1;
         }

         if (this.numLoops < 0) {
            if (this.field375) {
               if (this.field366 < 0) {
                  var9 = this.method927(var1, var2, var5, var3, var4.samples[this.start]);
                  if (this.field365 >= var5) {
                     return;
                  }

                  this.field365 = var5 + var5 - 1 - this.field365;
                  this.field366 = -this.field366;
               }

               while(true) {
                  var9 = this.method926(var1, var9, var6, var3, var4.samples[this.end - 1]);
                  if (this.field365 < var6) {
                     return;
                  }

                  this.field365 = var6 + var6 - 1 - this.field365;
                  this.field366 = -this.field366;
                  var9 = this.method927(var1, var9, var5, var3, var4.samples[this.start]);
                  if (this.field365 >= var5) {
                     return;
                  }

                  this.field365 = var5 + var5 - 1 - this.field365;
                  this.field366 = -this.field366;
               }
            } else if (this.field366 < 0) {
               while(true) {
                  var9 = this.method927(var1, var9, var5, var3, var4.samples[this.end - 1]);
                  if (this.field365 >= var5) {
                     return;
                  }

                  this.field365 = var6 - 1 - (var6 - 1 - this.field365) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method926(var1, var9, var6, var3, var4.samples[this.start]);
                  if (this.field365 < var6) {
                     return;
                  }

                  this.field365 = var5 + (this.field365 - var5) % var8;
               }
            }
         } else {
            if (this.numLoops > 0) {
               if (this.field375) {
                  label127: {
                     if (this.field366 < 0) {
                        var9 = this.method927(var1, var2, var5, var3, var4.samples[this.start]);
                        if (this.field365 >= var5) {
                           return;
                        }

                        this.field365 = var5 + var5 - 1 - this.field365;
                        this.field366 = -this.field366;
                        if (--this.numLoops == 0) {
                           break label127;
                        }
                     }

                     do {
                        var9 = this.method926(var1, var9, var6, var3, var4.samples[this.end - 1]);
                        if (this.field365 < var6) {
                           return;
                        }

                        this.field365 = var6 + var6 - 1 - this.field365;
                        this.field366 = -this.field366;
                        if (--this.numLoops == 0) {
                           break;
                        }

                        var9 = this.method927(var1, var9, var5, var3, var4.samples[this.start]);
                        if (this.field365 >= var5) {
                           return;
                        }

                        this.field365 = var5 + var5 - 1 - this.field365;
                        this.field366 = -this.field366;
                     } while(--this.numLoops != 0);
                  }
               } else {
                  int var10;
                  if (this.field366 < 0) {
                     while(true) {
                        var9 = this.method927(var1, var9, var5, var3, var4.samples[this.end - 1]);
                        if (this.field365 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field365) / var8;
                        if (var10 >= this.numLoops) {
                           this.field365 += var8 * this.numLoops;
                           this.numLoops = 0;
                           break;
                        }

                        this.field365 += var8 * var10;
                        this.numLoops -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method926(var1, var9, var6, var3, var4.samples[this.start]);
                        if (this.field365 < var6) {
                           return;
                        }

                        var10 = (this.field365 - var5) / var8;
                        if (var10 >= this.numLoops) {
                           this.field365 -= var8 * this.numLoops;
                           this.numLoops = 0;
                           break;
                        }

                        this.field365 -= var8 * var10;
                        this.numLoops -= var10;
                     }
                  }
               }
            }

            if (this.field366 < 0) {
               this.method927(var1, var9, 0, var3, 0);
               if (this.field365 < 0) {
                  this.field365 = -1;
                  this.method958();
                  this.remove();
               }
            } else {
               this.method926(var1, var9, var7, var3, 0);
               if (this.field365 >= var7) {
                  this.field365 = var7;
                  this.method958();
                  this.remove();
               }
            }

         }
      }
   }

   @ObfuscatedName("b")
   public synchronized void setNumLoops(int var1) {
      this.numLoops = var1;
   }

   @ObfuscatedName("j")
   public synchronized void skip(int var1) {
      if (this.field376 > 0) {
         if (var1 >= this.field376) {
            if (this.field379 == Integer.MIN_VALUE) {
               this.field379 = 0;
               this.field371 = 0;
               this.field368 = 0;
               this.field369 = 0;
               this.remove();
               var1 = this.field376;
            }

            this.field376 = 0;
            this.method904();
         } else {
            this.field369 += this.field377 * var1;
            this.field368 += this.field378 * var1;
            this.field371 += this.field374 * var1;
            this.field376 -= var1;
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

      if (this.field365 < 0) {
         if (this.field366 <= 0) {
            this.method958();
            this.remove();
            return;
         }

         this.field365 = 0;
      }

      if (this.field365 >= var5) {
         if (this.field366 >= 0) {
            this.method958();
            this.remove();
            return;
         }

         this.field365 = var5 - 1;
      }

      this.field365 += this.field366 * var1;
      if (this.numLoops < 0) {
         if (!this.field375) {
            if (this.field366 < 0) {
               if (this.field365 >= var3) {
                  return;
               }

               this.field365 = var4 - 1 - (var4 - 1 - this.field365) % var6;
            } else {
               if (this.field365 < var4) {
                  return;
               }

               this.field365 = var3 + (this.field365 - var3) % var6;
            }

         } else {
            if (this.field366 < 0) {
               if (this.field365 >= var3) {
                  return;
               }

               this.field365 = var3 + var3 - 1 - this.field365;
               this.field366 = -this.field366;
            }

            while(this.field365 >= var4) {
               this.field365 = var4 + var4 - 1 - this.field365;
               this.field366 = -this.field366;
               if (this.field365 >= var3) {
                  return;
               }

               this.field365 = var3 + var3 - 1 - this.field365;
               this.field366 = -this.field366;
            }

         }
      } else {
         if (this.numLoops > 0) {
            if (this.field375) {
               label129: {
                  if (this.field366 < 0) {
                     if (this.field365 >= var3) {
                        return;
                     }

                     this.field365 = var3 + var3 - 1 - this.field365;
                     this.field366 = -this.field366;
                     if (--this.numLoops == 0) {
                        break label129;
                     }
                  }

                  do {
                     if (this.field365 < var4) {
                        return;
                     }

                     this.field365 = var4 + var4 - 1 - this.field365;
                     this.field366 = -this.field366;
                     if (--this.numLoops == 0) {
                        break;
                     }

                     if (this.field365 >= var3) {
                        return;
                     }

                     this.field365 = var3 + var3 - 1 - this.field365;
                     this.field366 = -this.field366;
                  } while(--this.numLoops != 0);
               }
            } else {
               label161: {
                  int var7;
                  if (this.field366 < 0) {
                     if (this.field365 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field365) / var6;
                     if (var7 >= this.numLoops) {
                        this.field365 += var6 * this.numLoops;
                        this.numLoops = 0;
                        break label161;
                     }

                     this.field365 += var6 * var7;
                     this.numLoops -= var7;
                  } else {
                     if (this.field365 < var4) {
                        return;
                     }

                     var7 = (this.field365 - var3) / var6;
                     if (var7 >= this.numLoops) {
                        this.field365 -= var6 * this.numLoops;
                        this.numLoops = 0;
                        break label161;
                     }

                     this.field365 -= var6 * var7;
                     this.numLoops -= var7;
                  }

                  return;
               }
            }
         }

         if (this.field366 < 0) {
            if (this.field365 < 0) {
               this.field365 = -1;
               this.method958();
               this.remove();
            }
         } else if (this.field365 >= var5) {
            this.field365 = var5;
            this.method958();
            this.remove();
         }

      }
   }

   @ObfuscatedName("g")
   public synchronized void method906(int var1) {
      this.method908(var1 << 6, this.method921());
   }

   @ObfuscatedName("i")
   synchronized void method1011(int var1) {
      this.method908(var1, this.method921());
   }

   @ObfuscatedName("o")
   synchronized void method908(int var1, int var2) {
      this.field379 = var1;
      this.field367 = var2;
      this.field376 = 0;
      this.method904();
   }

   @ObfuscatedName("n")
   public synchronized int method964() {
      return this.field379 == Integer.MIN_VALUE ? 0 : this.field379;
   }

   @ObfuscatedName("k")
   public synchronized int method921() {
      return this.field367 < 0 ? -1 : this.field367;
   }

   @ObfuscatedName("a")
   public synchronized void method911(int var1) {
      int var2 = ((RawSound)super.sound).samples.length << 8;
      if (var1 < -1) {
         var1 = -1;
      }

      if (var1 > var2) {
         var1 = var2;
      }

      this.field365 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method912() {
      this.field366 = (this.field366 ^ this.field366 >> 31) + (this.field366 >>> 31);
      this.field366 = -this.field366;
   }

   @ObfuscatedName("l")
   void method958() {
      if (this.field376 != 0) {
         if (this.field379 == Integer.MIN_VALUE) {
            this.field379 = 0;
         }

         this.field376 = 0;
         this.method904();
      }

   }

   @ObfuscatedName("t")
   public synchronized void method914(int var1, int var2) {
      this.method915(var1, var2, this.method921());
   }

   @ObfuscatedName("c")
   public synchronized void method915(int var1, int var2, int var3) {
      if (var1 == 0) {
         this.method908(var2, var3);
      } else {
         int var4 = method961(var2, var3);
         int var5 = method990(var2, var3);
         if (var4 == this.field368 && var5 == this.field371) {
            this.field376 = 0;
         } else {
            int var6 = var2 - this.field369;
            if (this.field369 - var2 > var6) {
               var6 = this.field369 - var2;
            }

            if (var4 - this.field368 > var6) {
               var6 = var4 - this.field368;
            }

            if (this.field368 - var4 > var6) {
               var6 = this.field368 - var4;
            }

            if (var5 - this.field371 > var6) {
               var6 = var5 - this.field371;
            }

            if (this.field371 - var5 > var6) {
               var6 = this.field371 - var5;
            }

            if (var1 > var6) {
               var1 = var6;
            }

            this.field376 = var1;
            this.field379 = var2;
            this.field367 = var3;
            this.field377 = (var2 - this.field369) / var1;
            this.field378 = (var4 - this.field368) / var1;
            this.field374 = (var5 - this.field371) / var1;
         }
      }
   }

   @ObfuscatedName("ay")
   public synchronized void method916(int var1) {
      if (var1 == 0) {
         this.method1011(0);
         this.remove();
      } else if (this.field368 == 0 && this.field371 == 0) {
         this.field376 = 0;
         this.field379 = 0;
         this.field369 = 0;
         this.remove();
      } else {
         int var2 = -this.field369;
         if (this.field369 > var2) {
            var2 = this.field369;
         }

         if (-this.field368 > var2) {
            var2 = -this.field368;
         }

         if (this.field368 > var2) {
            var2 = this.field368;
         }

         if (-this.field371 > var2) {
            var2 = -this.field371;
         }

         if (this.field371 > var2) {
            var2 = this.field371;
         }

         if (var1 > var2) {
            var1 = var2;
         }

         this.field376 = var1;
         this.field379 = Integer.MIN_VALUE;
         this.field377 = -this.field369 / var1;
         this.field378 = -this.field368 / var1;
         this.field374 = -this.field371 / var1;
      }
   }

   @ObfuscatedName("an")
   public synchronized void method917(int var1) {
      if (this.field366 < 0) {
         this.field366 = -var1;
      } else {
         this.field366 = var1;
      }

   }

   @ObfuscatedName("ab")
   public synchronized int method918() {
      return this.field366 < 0 ? -this.field366 : this.field366;
   }

   @ObfuscatedName("al")
   public boolean method919() {
      return this.field365 < 0 || this.field365 >= ((RawSound)super.sound).samples.length << 8;
   }

   @ObfuscatedName("az")
   public boolean method976() {
      return this.field376 != 0;
   }

   @ObfuscatedName("ak")
   int method926(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if (this.field376 > 0) {
            int var6 = var2 + this.field376;
            if (var6 > var4) {
               var6 = var4;
            }

            this.field376 += var2;
            if (this.field366 == 256 && (this.field365 & 255) == 0) {
               if (class286.PcmPlayer_stereo) {
                  var2 = method972(0, ((RawSound)super.sound).samples, var1, this.field365, var2, this.field368, this.field371, this.field378, this.field374, 0, var6, var3, this);
               } else {
                  var2 = method936(((RawSound)super.sound).samples, var1, this.field365, var2, this.field369, this.field377, 0, var6, var3, this);
               }
            } else if (class286.PcmPlayer_stereo) {
               var2 = method923(0, 0, ((RawSound)super.sound).samples, var1, this.field365, var2, this.field368, this.field371, this.field378, this.field374, 0, var6, var3, this, this.field366, var5);
            } else {
               var2 = method940(0, 0, ((RawSound)super.sound).samples, var1, this.field365, var2, this.field369, this.field377, 0, var6, var3, this, this.field366, var5);
            }

            this.field376 -= var2;
            if (this.field376 != 0) {
               return var2;
            }

            if (!this.method1013()) {
               continue;
            }

            return var4;
         }

         if (this.field366 == 256 && (this.field365 & 255) == 0) {
            if (class286.PcmPlayer_stereo) {
               return method930(0, ((RawSound)super.sound).samples, var1, this.field365, var2, this.field368, this.field371, 0, var4, var3, this);
            }

            return method909(((RawSound)super.sound).samples, var1, this.field365, var2, this.field369, 0, var4, var3, this);
         }

         if (class286.PcmPlayer_stereo) {
            return method933(0, 0, ((RawSound)super.sound).samples, var1, this.field365, var2, this.field368, this.field371, 0, var4, var3, this, this.field366, var5);
         }

         return method1014(0, 0, ((RawSound)super.sound).samples, var1, this.field365, var2, this.field369, 0, var4, var3, this, this.field366, var5);
      }
   }

   @ObfuscatedName("af")
   int vmethod1052() {
      int var1 = this.field369 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if (this.numLoops == 0) {
         var1 -= var1 * this.field365 / (((RawSound)super.sound).samples.length << 8);
      } else if (this.numLoops >= 0) {
         var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
      }

      return var1 > 255 ? 255 : var1;
   }

   @ObfuscatedName("ai")
   int method927(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if (this.field376 > 0) {
            int var6 = var2 + this.field376;
            if (var6 > var4) {
               var6 = var4;
            }

            this.field376 += var2;
            if (this.field366 == -256 && (this.field365 & 255) == 0) {
               if (class286.PcmPlayer_stereo) {
                  var2 = method939(0, ((RawSound)super.sound).samples, var1, this.field365, var2, this.field368, this.field371, this.field378, this.field374, 0, var6, var3, this);
               } else {
                  var2 = method938(((RawSound)super.sound).samples, var1, this.field365, var2, this.field369, this.field377, 0, var6, var3, this);
               }
            } else if (class286.PcmPlayer_stereo) {
               var2 = method943(0, 0, ((RawSound)super.sound).samples, var1, this.field365, var2, this.field368, this.field371, this.field378, this.field374, 0, var6, var3, this, this.field366, var5);
            } else {
               var2 = method942(0, 0, ((RawSound)super.sound).samples, var1, this.field365, var2, this.field369, this.field377, 0, var6, var3, this, this.field366, var5);
            }

            this.field376 -= var2;
            if (this.field376 != 0) {
               return var2;
            }

            if (!this.method1013()) {
               continue;
            }

            return var4;
         }

         if (this.field366 == -256 && (this.field365 & 255) == 0) {
            if (class286.PcmPlayer_stereo) {
               return method931(0, ((RawSound)super.sound).samples, var1, this.field365, var2, this.field368, this.field371, 0, var4, var3, this);
            }

            return method1005(((RawSound)super.sound).samples, var1, this.field365, var2, this.field369, 0, var4, var3, this);
         }

         if (class286.PcmPlayer_stereo) {
            return method935(0, 0, ((RawSound)super.sound).samples, var1, this.field365, var2, this.field368, this.field371, 0, var4, var3, this, this.field366, var5);
         }

         return method934(0, 0, ((RawSound)super.sound).samples, var1, this.field365, var2, this.field369, 0, var4, var3, this, this.field366, var5);
      }
   }

   @ObfuscatedName("ax")
   boolean method1013() {
      int var1 = this.field379;
      int var2;
      int var3;
      if (var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method961(var1, this.field367);
         var3 = method990(var1, this.field367);
      }

      if (var1 == this.field369 && var2 == this.field368 && var3 == this.field371) {
         if (this.field379 == Integer.MIN_VALUE) {
            this.field379 = 0;
            this.field371 = 0;
            this.field368 = 0;
            this.field369 = 0;
            this.remove();
            return true;
         } else {
            this.method904();
            return false;
         }
      } else {
         if (this.field369 < var1) {
            this.field377 = 1;
            this.field376 = var1 - this.field369;
         } else if (this.field369 > var1) {
            this.field377 = -1;
            this.field376 = this.field369 - var1;
         } else {
            this.field377 = 0;
         }

         if (this.field368 < var2) {
            this.field378 = 1;
            if (this.field376 == 0 || this.field376 > var2 - this.field368) {
               this.field376 = var2 - this.field368;
            }
         } else if (this.field368 > var2) {
            this.field378 = -1;
            if (this.field376 == 0 || this.field376 > this.field368 - var2) {
               this.field376 = this.field368 - var2;
            }
         } else {
            this.field378 = 0;
         }

         if (this.field371 < var3) {
            this.field374 = 1;
            if (this.field376 == 0 || this.field376 > var3 - this.field371) {
               this.field376 = var3 - this.field371;
            }
         } else if (this.field371 > var3) {
            this.field374 = -1;
            if (this.field376 == 0 || this.field376 > this.field371 - var3) {
               this.field376 = this.field371 - var3;
            }
         } else {
            this.field374 = 0;
         }

         return false;
      }
   }

   @ObfuscatedName("h")
   static int method961(int var0, int var1) {
      return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("e")
   static int method990(int var0, int var1) {
      return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Laf;II)Lap;"
   )
   public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
      return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(PcmPlayer.field325 * 2205000)), var2 << 6) : null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Laf;III)Lap;"
   )
   public static RawPcmStream method1029(RawSound var0, int var1, int var2, int var3) {
      return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIILap;)I"
   )
   static int method909(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

      var8.field365 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIILap;)I"
   )
   static int method930(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

      var10.field365 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIILap;)I"
   )
   static int method1005(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

      var8.field365 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIILap;)I"
   )
   static int method931(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

      var10.field365 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIILap;II)I"
   )
   static int method1014(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

      var10.field365 = var4;
      return var5;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILap;II)I"
   )
   static int method933(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

      var11.field365 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIILap;II)I"
   )
   static int method934(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

      var10.field365 = var4;
      return var5;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILap;II)I"
   )
   static int method935(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

      var11.field365 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIIILap;)I"
   )
   static int method936(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if ((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field368 += var9.field378 * (var6 - var3);
      var9.field371 += var9.field374 * (var6 - var3);

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

      var9.field369 = var4 >> 2;
      var9.field365 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIIIILap;)I"
   )
   static int method972(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if ((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field369 += var12.field377 * (var9 - var4);
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

      var12.field368 = var5 >> 2;
      var12.field371 = var6 >> 2;
      var12.field365 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIIILap;)I"
   )
   static int method938(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field368 += var9.field378 * (var6 - var3);
      var9.field371 += var9.field374 * (var6 - var3);

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

      var9.field369 = var4 >> 2;
      var9.field365 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIIIILap;)I"
   )
   static int method939(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field369 += var12.field377 * (var9 - var4);
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

      var12.field368 = var5 >> 2;
      var12.field371 = var6 >> 2;
      var12.field365 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILap;II)I"
   )
   static int method940(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      var11.field368 -= var11.field378 * var5;
      var11.field371 -= var11.field374 * var5;
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

      var11.field368 += var11.field378 * var5;
      var11.field371 += var11.field374 * var5;
      var11.field369 = var6;
      var11.field365 = var4;
      return var5;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIIIILap;II)I"
   )
   static int method923(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
      var13.field369 -= var5 * var13.field377;
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
      var13.field369 += var13.field377 * var5;
      var13.field368 = var6;
      var13.field371 = var7;
      var13.field365 = var4;
      return var5;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILap;II)I"
   )
   static int method942(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      var11.field368 -= var11.field378 * var5;
      var11.field371 -= var11.field374 * var5;
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

      var11.field368 += var11.field378 * var5;
      var11.field371 += var11.field374 * var5;
      var11.field369 = var6;
      var11.field365 = var4;
      return var5;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIIIILap;II)I"
   )
   static int method943(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
      var13.field369 -= var5 * var13.field377;
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
      var13.field369 += var13.field377 * var5;
      var13.field368 = var6;
      var13.field371 = var7;
      var13.field365 = var4;
      return var5;
   }
}
