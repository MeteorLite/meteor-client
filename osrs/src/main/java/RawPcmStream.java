import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("RawPcmStream")
public class RawPcmStream extends PcmStream {
   @ObfuscatedName("f")
   int field244;
   @ObfuscatedName("v")
   int field241;
   @ObfuscatedName("s")
   int field254;
   @ObfuscatedName("z")
   int field243;
   @ObfuscatedName("j")
   int field249;
   @ObfuscatedName("i")
   int field245;
   @ObfuscatedName("n")
   int field242;
    @ObfuscatedName("l")
    int numLoops;
    @ObfuscatedName("k")
    int start;
    @ObfuscatedName("c")
    int end;
   @ObfuscatedName("r")
   boolean field250;
   @ObfuscatedName("b")
   int field251;
   @ObfuscatedName("m")
   int field252;
   @ObfuscatedName("t")
   int field246;
   @ObfuscatedName("h")
   int field240;

   @ObfuscatedSignature(
      descriptor = "(Lav;III)V"
   )
   RawPcmStream(RawSound var1, int var2, int var3, int var4) {
      super.sound = var1;
      this.start = var1.start;
      this.end = var1.end;
      this.field250 = var1.field184;
      this.field241 = var2;
      this.field254 = var3;
      this.field243 = var4;
      this.field244 = 0;
      this.method250();
   }

   @ObfuscatedSignature(
      descriptor = "(Lav;II)V"
   )
   RawPcmStream(RawSound var1, int var2, int var3) {
      super.sound = var1;
      this.start = var1.start;
      this.end = var1.end;
      this.field250 = var1.field184;
      this.field241 = var2;
      this.field254 = var3;
      this.field243 = 8192;
      this.field244 = 0;
      this.method250();
   }

   @ObfuscatedName("z")
   void method250() {
      this.field249 = this.field254;
      this.field245 = method273(this.field254, this.field243);
      this.field242 = method233(this.field254, this.field243);
   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "()Lan;"
    )
    protected PcmStream firstSubStream() {
      return null;
   }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "()Lan;"
    )
    protected PcmStream nextSubStream() {
      return null;
   }

    @ObfuscatedName("n")
    protected int vmethod5648() {
      return this.field254 == 0 && this.field251 == 0 ? 0 : 1;
   }

    @ObfuscatedName("l")
    public synchronized void fill(int[] var1, int var2, int var3) {
      if (this.field254 == 0 && this.field251 == 0) {
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
         if (this.field244 < 0) {
            if (this.field241 <= 0) {
               this.method252();
               this.remove();
               return;
            }

            this.field244 = 0;
         }

         if (this.field244 >= var7) {
            if (this.field241 >= 0) {
               this.method252();
               this.remove();
               return;
            }

            this.field244 = var7 - 1;
         }

         if (this.numLoops < 0) {
            if (this.field250) {
               if (this.field241 < 0) {
                  var9 = this.method270(var1, var2, var5, var3, var4.samples[this.start]);
                  if (this.field244 >= var5) {
                     return;
                  }

                  this.field244 = var5 + var5 - 1 - this.field244;
                  this.field241 = -this.field241;
               }

               while(true) {
                  var9 = this.method251(var1, var9, var6, var3, var4.samples[this.end - 1]);
                  if (this.field244 < var6) {
                     return;
                  }

                  this.field244 = var6 + var6 - 1 - this.field244;
                  this.field241 = -this.field241;
                  var9 = this.method270(var1, var9, var5, var3, var4.samples[this.start]);
                  if (this.field244 >= var5) {
                     return;
                  }

                  this.field244 = var5 + var5 - 1 - this.field244;
                  this.field241 = -this.field241;
               }
            } else if (this.field241 < 0) {
               while(true) {
                  var9 = this.method270(var1, var9, var5, var3, var4.samples[this.end - 1]);
                  if (this.field244 >= var5) {
                     return;
                  }

                  this.field244 = var6 - 1 - (var6 - 1 - this.field244) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method251(var1, var9, var6, var3, var4.samples[this.start]);
                  if (this.field244 < var6) {
                     return;
                  }

                  this.field244 = var5 + (this.field244 - var5) % var8;
               }
            }
         } else {
            if (this.numLoops > 0) {
               if (this.field250) {
                  label132: {
                     if (this.field241 < 0) {
                        var9 = this.method270(var1, var2, var5, var3, var4.samples[this.start]);
                        if (this.field244 >= var5) {
                           return;
                        }

                        this.field244 = var5 + var5 - 1 - this.field244;
                        this.field241 = -this.field241;
                        if (--this.numLoops == 0) {
                           break label132;
                        }
                     }

                     do {
                        var9 = this.method251(var1, var9, var6, var3, var4.samples[this.end - 1]);
                        if (this.field244 < var6) {
                           return;
                        }

                        this.field244 = var6 + var6 - 1 - this.field244;
                        this.field241 = -this.field241;
                        if (--this.numLoops == 0) {
                           break;
                        }

                        var9 = this.method270(var1, var9, var5, var3, var4.samples[this.start]);
                        if (this.field244 >= var5) {
                           return;
                        }

                        this.field244 = var5 + var5 - 1 - this.field244;
                        this.field241 = -this.field241;
                     } while(--this.numLoops != 0);
                  }
               } else {
                  int var10;
                  if (this.field241 < 0) {
                     while(true) {
                        var9 = this.method270(var1, var9, var5, var3, var4.samples[this.end - 1]);
                        if (this.field244 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field244) / var8;
                        if (var10 >= this.numLoops) {
                           this.field244 += var8 * this.numLoops;
                           this.numLoops = 0;
                           break;
                        }

                        this.field244 += var8 * var10;
                        this.numLoops -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method251(var1, var9, var6, var3, var4.samples[this.start]);
                        if (this.field244 < var6) {
                           return;
                        }

                        var10 = (this.field244 - var5) / var8;
                        if (var10 >= this.numLoops) {
                           this.field244 -= var8 * this.numLoops;
                           this.numLoops = 0;
                           break;
                        }

                        this.field244 -= var8 * var10;
                        this.numLoops -= var10;
                     }
                  }
               }
            }

            if (this.field241 < 0) {
               this.method270(var1, var9, 0, var3, 0);
               if (this.field244 < 0) {
                  this.field244 = -1;
                  this.method252();
                  this.remove();
               }
            } else {
               this.method251(var1, var9, var7, var3, 0);
               if (this.field244 >= var7) {
                  this.field244 = var7;
                  this.method252();
                  this.remove();
               }
            }

         }
      }
   }

    @ObfuscatedName("k")
    public synchronized void setNumLoops(int var1) {
      this.numLoops = var1;
   }

    @ObfuscatedName("c")
    public synchronized void skip(int var1) {
      if (this.field251 > 0) {
         if (var1 >= this.field251) {
            if (this.field254 == Integer.MIN_VALUE) {
               this.field254 = 0;
               this.field242 = 0;
               this.field245 = 0;
               this.field249 = 0;
               this.remove();
               var1 = this.field251;
            }

            this.field251 = 0;
            this.method250();
         } else {
            this.field249 += this.field252 * var1;
            this.field245 += this.field246 * var1;
            this.field242 += this.field240 * var1;
            this.field251 -= var1;
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

      if (this.field244 < 0) {
         if (this.field241 <= 0) {
            this.method252();
            this.remove();
            return;
         }

         this.field244 = 0;
      }

      if (this.field244 >= var5) {
         if (this.field241 >= 0) {
            this.method252();
            this.remove();
            return;
         }

         this.field244 = var5 - 1;
      }

      this.field244 += this.field241 * var1;
      if (this.numLoops < 0) {
         if (!this.field250) {
            if (this.field241 < 0) {
               if (this.field244 >= var3) {
                  return;
               }

               this.field244 = var4 - 1 - (var4 - 1 - this.field244) % var6;
            } else {
               if (this.field244 < var4) {
                  return;
               }

               this.field244 = var3 + (this.field244 - var3) % var6;
            }

         } else {
            if (this.field241 < 0) {
               if (this.field244 >= var3) {
                  return;
               }

               this.field244 = var3 + var3 - 1 - this.field244;
               this.field241 = -this.field241;
            }

            while(this.field244 >= var4) {
               this.field244 = var4 + var4 - 1 - this.field244;
               this.field241 = -this.field241;
               if (this.field244 >= var3) {
                  return;
               }

               this.field244 = var3 + var3 - 1 - this.field244;
               this.field241 = -this.field241;
            }

         }
      } else {
         if (this.numLoops > 0) {
            if (this.field250) {
               label121: {
                  if (this.field241 < 0) {
                     if (this.field244 >= var3) {
                        return;
                     }

                     this.field244 = var3 + var3 - 1 - this.field244;
                     this.field241 = -this.field241;
                     if (--this.numLoops == 0) {
                        break label121;
                     }
                  }

                  do {
                     if (this.field244 < var4) {
                        return;
                     }

                     this.field244 = var4 + var4 - 1 - this.field244;
                     this.field241 = -this.field241;
                     if (--this.numLoops == 0) {
                        break;
                     }

                     if (this.field244 >= var3) {
                        return;
                     }

                     this.field244 = var3 + var3 - 1 - this.field244;
                     this.field241 = -this.field241;
                  } while(--this.numLoops != 0);
               }
            } else {
               label153: {
                  int var7;
                  if (this.field241 < 0) {
                     if (this.field244 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field244) / var6;
                     if (var7 >= this.numLoops) {
                        this.field244 += var6 * this.numLoops;
                        this.numLoops = 0;
                        break label153;
                     }

                     this.field244 += var6 * var7;
                     this.numLoops -= var7;
                  } else {
                     if (this.field244 < var4) {
                        return;
                     }

                     var7 = (this.field244 - var3) / var6;
                     if (var7 >= this.numLoops) {
                        this.field244 -= var6 * this.numLoops;
                        this.numLoops = 0;
                        break label153;
                     }

                     this.field244 -= var6 * var7;
                     this.numLoops -= var7;
                  }

                  return;
               }
            }
         }

         if (this.field241 < 0) {
            if (this.field244 < 0) {
               this.field244 = -1;
               this.method252();
               this.remove();
            }
         } else if (this.field244 >= var5) {
            this.field244 = var5;
            this.method252();
            this.remove();
         }

      }
   }

   @ObfuscatedName("r")
   public synchronized void method237(int var1) {
      this.method244(var1 << 6, this.method267());
   }

   @ObfuscatedName("b")
   synchronized void method238(int var1) {
      this.method244(var1, this.method267());
   }

   @ObfuscatedName("m")
   synchronized void method244(int var1, int var2) {
      this.field254 = var1;
      this.field243 = var2;
      this.field251 = 0;
      this.method250();
   }

   @ObfuscatedName("t")
   public synchronized int method239() {
      return this.field254 == Integer.MIN_VALUE ? 0 : this.field254;
   }

   @ObfuscatedName("h")
   public synchronized int method267() {
      return this.field243 < 0 ? -1 : this.field243;
   }

   @ObfuscatedName("p")
   public synchronized void method240(int var1) {
      int var2 = ((RawSound)super.sound).samples.length << 8;
      if (var1 < -1) {
         var1 = -1;
      }

      if (var1 > var2) {
         var1 = var2;
      }

      this.field244 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(Z)V",
      garbageValue = "1"
   )
   public synchronized void method255() {
      this.field241 = (this.field241 ^ this.field241 >> 31) + (this.field241 >>> 31);
      this.field241 = -this.field241;
   }

   @ObfuscatedName("u")
   void method252() {
      if (this.field251 != 0) {
         if (this.field254 == Integer.MIN_VALUE) {
            this.field254 = 0;
         }

         this.field251 = 0;
         this.method250();
      }

   }

   @ObfuscatedName("x")
   public synchronized void method241(int var1, int var2) {
      this.method242(var1, var2, this.method267());
   }

   @ObfuscatedName("a")
   public synchronized void method242(int var1, int var2, int var3) {
      if (var1 == 0) {
         this.method244(var2, var3);
      } else {
         int var4 = method273(var2, var3);
         int var5 = method233(var2, var3);
         if (var4 == this.field245 && var5 == this.field242) {
            this.field251 = 0;
         } else {
            int var6 = var2 - this.field249;
            if (this.field249 - var2 > var6) {
               var6 = this.field249 - var2;
            }

            if (var4 - this.field245 > var6) {
               var6 = var4 - this.field245;
            }

            if (this.field245 - var4 > var6) {
               var6 = this.field245 - var4;
            }

            if (var5 - this.field242 > var6) {
               var6 = var5 - this.field242;
            }

            if (this.field242 - var5 > var6) {
               var6 = this.field242 - var5;
            }

            if (var1 > var6) {
               var1 = var6;
            }

            this.field251 = var1;
            this.field254 = var2;
            this.field243 = var3;
            this.field252 = (var2 - this.field249) / var1;
            this.field246 = (var4 - this.field245) / var1;
            this.field240 = (var5 - this.field242) / var1;
         }
      }
   }

   @ObfuscatedName("q")
   public synchronized void method243(int var1) {
      if (var1 == 0) {
         this.method238(0);
         this.remove();
      } else if (this.field245 == 0 && this.field242 == 0) {
         this.field251 = 0;
         this.field254 = 0;
         this.field249 = 0;
         this.remove();
      } else {
         int var2 = -this.field249;
         if (this.field249 > var2) {
            var2 = this.field249;
         }

         if (-this.field245 > var2) {
            var2 = -this.field245;
         }

         if (this.field245 > var2) {
            var2 = this.field245;
         }

         if (-this.field242 > var2) {
            var2 = -this.field242;
         }

         if (this.field242 > var2) {
            var2 = this.field242;
         }

         if (var1 > var2) {
            var1 = var2;
         }

         this.field251 = var1;
         this.field254 = Integer.MIN_VALUE;
         this.field252 = -this.field249 / var1;
         this.field246 = -this.field245 / var1;
         this.field240 = -this.field242 / var1;
      }
   }

   @ObfuscatedName("d")
   public synchronized void method277(int var1) {
      if (this.field241 < 0) {
         this.field241 = -var1;
      } else {
         this.field241 = var1;
      }

   }

   @ObfuscatedName("e")
   public synchronized int method272() {
      return this.field241 < 0 ? -this.field241 : this.field241;
   }

   @ObfuscatedName("g")
   public boolean method246() {
      return this.field244 < 0 || this.field244 >= ((RawSound)super.sound).samples.length << 8;
   }

   @ObfuscatedName("y")
   public boolean method247() {
      return this.field251 != 0;
   }

   @ObfuscatedName("ax")
   int method251(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if (this.field251 > 0) {
            int var6 = var2 + this.field251;
            if (var6 > var4) {
               var6 = var4;
            }

            this.field251 += var2;
            if (this.field241 == 256 && (this.field244 & 255) == 0) {
               if (PcmPlayer.PcmPlayer_stereo) {
                  var2 = method260(0, ((RawSound)super.sound).samples, var1, this.field244, var2, this.field245, this.field242, this.field246, this.field240, 0, var6, var3, this);
               } else {
                  var2 = method259(((RawSound)super.sound).samples, var1, this.field244, var2, this.field249, this.field252, 0, var6, var3, this);
               }
            } else if (PcmPlayer.PcmPlayer_stereo) {
               var2 = method274(0, 0, ((RawSound)super.sound).samples, var1, this.field244, var2, this.field245, this.field242, this.field246, this.field240, 0, var6, var3, this, this.field241, var5);
            } else {
               var2 = method263(0, 0, ((RawSound)super.sound).samples, var1, this.field244, var2, this.field249, this.field252, 0, var6, var3, this, this.field241, var5);
            }

            this.field251 -= var2;
            if (this.field251 != 0) {
               return var2;
            }

            if (!this.method268()) {
               continue;
            }

            return var4;
         }

         if (this.field241 == 256 && (this.field244 & 255) == 0) {
            if (PcmPlayer.PcmPlayer_stereo) {
               return method234(0, ((RawSound)super.sound).samples, var1, this.field244, var2, this.field245, this.field242, 0, var4, var3, this);
            }

            return method261(((RawSound)super.sound).samples, var1, this.field244, var2, this.field249, 0, var4, var3, this);
         }

         if (PcmPlayer.PcmPlayer_stereo) {
            return method256(0, 0, ((RawSound)super.sound).samples, var1, this.field244, var2, this.field245, this.field242, 0, var4, var3, this, this.field241, var5);
         }

         return method271(0, 0, ((RawSound)super.sound).samples, var1, this.field244, var2, this.field249, 0, var4, var3, this, this.field241, var5);
      }
   }

   @ObfuscatedName("az")
   int method270(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if (this.field251 > 0) {
            int var6 = var2 + this.field251;
            if (var6 > var4) {
               var6 = var4;
            }

            this.field251 += var2;
            if (this.field241 == -256 && (this.field244 & 255) == 0) {
               if (PcmPlayer.PcmPlayer_stereo) {
                  var2 = method262(0, ((RawSound)super.sound).samples, var1, this.field244, var2, this.field245, this.field242, this.field246, this.field240, 0, var6, var3, this);
               } else {
                  var2 = method276(((RawSound)super.sound).samples, var1, this.field244, var2, this.field249, this.field252, 0, var6, var3, this);
               }
            } else if (PcmPlayer.PcmPlayer_stereo) {
               var2 = method265(0, 0, ((RawSound)super.sound).samples, var1, this.field244, var2, this.field245, this.field242, this.field246, this.field240, 0, var6, var3, this, this.field241, var5);
            } else {
               var2 = method264(0, 0, ((RawSound)super.sound).samples, var1, this.field244, var2, this.field249, this.field252, 0, var6, var3, this, this.field241, var5);
            }

            this.field251 -= var2;
            if (this.field251 != 0) {
               return var2;
            }

            if (!this.method268()) {
               continue;
            }

            return var4;
         }

         if (this.field241 == -256 && (this.field244 & 255) == 0) {
            if (PcmPlayer.PcmPlayer_stereo) {
               return method254(0, ((RawSound)super.sound).samples, var1, this.field244, var2, this.field245, this.field242, 0, var4, var3, this);
            }

            return method253(((RawSound)super.sound).samples, var1, this.field244, var2, this.field249, 0, var4, var3, this);
         }

         if (PcmPlayer.PcmPlayer_stereo) {
            return method258(0, 0, ((RawSound)super.sound).samples, var1, this.field244, var2, this.field245, this.field242, 0, var4, var3, this, this.field241, var5);
         }

         return method269(0, 0, ((RawSound)super.sound).samples, var1, this.field244, var2, this.field249, 0, var4, var3, this, this.field241, var5);
      }
   }

   @ObfuscatedName("ap")
   boolean method268() {
      int var1 = this.field254;
      int var2;
      int var3;
      if (var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method273(var1, this.field243);
         var3 = method233(var1, this.field243);
      }

      if (var1 == this.field249 && var2 == this.field245 && var3 == this.field242) {
         if (this.field254 == Integer.MIN_VALUE) {
            this.field254 = 0;
            this.field242 = 0;
            this.field245 = 0;
            this.field249 = 0;
            this.remove();
            return true;
         } else {
            this.method250();
            return false;
         }
      } else {
         if (this.field249 < var1) {
            this.field252 = 1;
            this.field251 = var1 - this.field249;
         } else if (this.field249 > var1) {
            this.field252 = -1;
            this.field251 = this.field249 - var1;
         } else {
            this.field252 = 0;
         }

         if (this.field245 < var2) {
            this.field246 = 1;
            if (this.field251 == 0 || this.field251 > var2 - this.field245) {
               this.field251 = var2 - this.field245;
            }
         } else if (this.field245 > var2) {
            this.field246 = -1;
            if (this.field251 == 0 || this.field251 > this.field245 - var2) {
               this.field251 = this.field245 - var2;
            }
         } else {
            this.field246 = 0;
         }

         if (this.field242 < var3) {
            this.field240 = 1;
            if (this.field251 == 0 || this.field251 > var3 - this.field242) {
               this.field251 = var3 - this.field242;
            }
         } else if (this.field242 > var3) {
            this.field240 = -1;
            if (this.field251 == 0 || this.field251 > this.field242 - var3) {
               this.field251 = this.field242 - var3;
            }
         } else {
            this.field240 = 0;
         }

         return false;
      }
   }

    @ObfuscatedName("av")
    int vmethod1019() {
      int var1 = this.field249 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if (this.numLoops == 0) {
         var1 -= var1 * this.field244 / (((RawSound)super.sound).samples.length << 8);
      } else if (this.numLoops >= 0) {
         var1 -= var1 * this.start / ((RawSound)super.sound).samples.length;
      }

      return var1 > 255 ? 255 : var1;
   }

   @ObfuscatedName("f")
   static int method273(int var0, int var1) {
      return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   @ObfuscatedName("w")
   static int method233(int var0, int var1) {
      return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(Lav;II)Lab;"
    )
    public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
      return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, (int)((long)var0.sampleRate * 256L * (long)var1 / (long)(class284.field2683 * 100)), var2 << 6) : null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Lav;III)Lab;"
   )
   public static RawPcmStream method257(RawSound var0, int var1, int var2, int var3) {
      return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIILab;)I"
   )
   static int method261(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

      var8.field244 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIILab;)I"
   )
   static int method234(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

      var10.field244 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIILab;)I"
   )
   static int method253(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, RawPcmStream var8) {
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

      var8.field244 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIILab;)I"
   )
   static int method254(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10) {
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

      var10.field244 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIILab;II)I"
   )
   static int method271(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

      var10.field244 = var4;
      return var5;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILab;II)I"
   )
   static int method256(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

      var11.field244 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIILab;II)I"
   )
   static int method269(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, RawPcmStream var10, int var11, int var12) {
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

      var10.field244 = var4;
      return var5;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILab;II)I"
   )
   static int method258(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
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

      var11.field244 = var4;
      return var5 >> 1;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIIILab;)I"
   )
   static int method259(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if ((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field245 += var9.field246 * (var6 - var3);
      var9.field242 += var9.field240 * (var6 - var3);

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

      var9.field249 = var4 >> 2;
      var9.field244 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIIIILab;)I"
   )
   static int method260(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if ((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field249 += var12.field252 * (var9 - var4);
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

      var12.field245 = var5 >> 2;
      var12.field242 = var6 >> 2;
      var12.field244 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "([B[IIIIIIIILab;)I"
   )
   static int method276(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, RawPcmStream var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field245 += var9.field246 * (var6 - var3);
      var9.field242 += var9.field240 * (var6 - var3);

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

      var9.field249 = var4 >> 2;
      var9.field244 = var2 << 8;
      return var3;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "(I[B[IIIIIIIIIILab;)I"
   )
   static int method262(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, RawPcmStream var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field249 += var12.field252 * (var9 - var4);
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

      var12.field245 = var5 >> 2;
      var12.field242 = var6 >> 2;
      var12.field244 = var3 << 8;
      return var4 >> 1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILab;II)I"
   )
   static int method263(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      var11.field245 -= var11.field246 * var5;
      var11.field242 -= var11.field240 * var5;
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

      var11.field245 += var11.field246 * var5;
      var11.field242 += var11.field240 * var5;
      var11.field249 = var6;
      var11.field244 = var4;
      return var5;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIIIILab;II)I"
   )
   static int method274(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
      var13.field249 -= var5 * var13.field252;
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
      var13.field249 += var13.field252 * var5;
      var13.field245 = var6;
      var13.field242 = var7;
      var13.field244 = var4;
      return var5;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIILab;II)I"
   )
   static int method264(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, RawPcmStream var11, int var12, int var13) {
      var11.field245 -= var11.field246 * var5;
      var11.field242 -= var11.field240 * var5;
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

      var11.field245 += var11.field246 * var5;
      var11.field242 += var11.field240 * var5;
      var11.field249 = var6;
      var11.field244 = var4;
      return var5;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(II[B[IIIIIIIIIILab;II)I"
   )
   static int method265(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
      var13.field249 -= var5 * var13.field252;
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
      var13.field249 += var13.field252 * var5;
      var13.field245 = var6;
      var13.field242 = var7;
      var13.field244 = var4;
      return var5;
   }
}
