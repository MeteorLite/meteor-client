import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lky;"
    )
    MidiPcmStream superStream;
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lmo;"
    )
    NodeDeque queue = new NodeDeque();
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lay;"
    )
    PcmStreamMixer mixer = new PcmStreamMixer();

   @ObfuscatedSignature(
      descriptor = "(Lky;)V"
   )
   MusicPatchPcmStream(MidiPcmStream var1) {
      this.superStream = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lkv;[IIIIB)V",
      garbageValue = "26"
   )
   void method1612(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
      if ((this.superStream.field2719[var1.field2771] & 4) != 0 && var1.field2775 < 0) {
         int var6 = this.superStream.field2717[var1.field2771] / class284.field2683;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2781) / var6;
            if (var7 > var4) {
               var1.field2781 += var4 * var6;
               break;
            }

            var1.stream.fill(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2781 += var7 * var6 - 1048576;
            int var8 = class284.field2683 / 100;
            int var9 = 262144 / var6;
            if (var9 < var8) {
               var8 = var9;
            }

            RawPcmStream var10 = var1.stream;
            if (this.superStream.field2728[var1.field2771] == 0) {
               var1.stream = RawPcmStream.method257(var1.rawSound, var10.method272(), var10.method239(), var10.method267());
            } else {
               var1.stream = RawPcmStream.method257(var1.rawSound, var10.method272(), 0, var10.method267());
               this.superStream.method1584(var1, var1.patch.field2755[var1.field2766] < 0);
               var1.stream.method241(var8, var10.method239());
            }

            if (var1.patch.field2755[var1.field2766] < 0) {
               var1.stream.setNumLoops(-1);
            }

            var10.method243(var8);
            var10.fill(var2, var3, var5 - var3);
            if (var10.method247()) {
               this.mixer.addSubStream(var10);
            }
         }
      }

      var1.stream.fill(var2, var3, var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Lkv;IB)V",
      garbageValue = "0"
   )
   void method1613(MusicPatchNode var1, int var2) {
      if ((this.superStream.field2719[var1.field2771] & 4) != 0 && var1.field2775 < 0) {
         int var3 = this.superStream.field2717[var1.field2771] / class284.field2683;
         int var4 = (var3 + 1048575 - var1.field2781) / var3;
         var1.field2781 = var3 * var2 + var1.field2781 & 1048575;
         if (var4 <= var2) {
            if (this.superStream.field2728[var1.field2771] == 0) {
               var1.stream = RawPcmStream.method257(var1.rawSound, var1.stream.method272(), var1.stream.method239(), var1.stream.method267());
            } else {
               var1.stream = RawPcmStream.method257(var1.rawSound, var1.stream.method272(), 0, var1.stream.method267());
               this.superStream.method1584(var1, var1.patch.field2755[var1.field2766] < 0);
            }

            if (var1.patch.field2755[var1.field2766] < 0) {
               var1.stream.setNumLoops(-1);
            }

            var2 = var1.field2781 / var3;
         }
      }

      var1.stream.skip(var2);
   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "()Lan;"
    )
    protected PcmStream firstSubStream() {
      MusicPatchNode var1 = (MusicPatchNode)this.queue.last();
      if (var1 == null) {
         return null;
      } else {
         return (PcmStream)(var1.stream != null ? var1.stream : this.nextSubStream());
      }
   }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "()Lan;"
    )
    protected PcmStream nextSubStream() {
      MusicPatchNode var1;
      do {
         var1 = (MusicPatchNode)this.queue.previous();
         if (var1 == null) {
            return null;
         }
      } while(var1.stream == null);

      return var1.stream;
   }

    @ObfuscatedName("n")
    protected int vmethod5648() {
      return 0;
   }

    @ObfuscatedName("l")
    protected void fill(int[] var1, int var2, int var3) {
      this.mixer.fill(var1, var2, var3);

      for(MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
         if (!this.superStream.method1582(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if (var5 <= var6.field2780) {
                  this.method1612(var6, var1, var4, var5, var4 + var5);
                  var6.field2780 -= var5;
                  break;
               }

               this.method1612(var6, var1, var4, var6.field2780, var4 + var5);
               var4 += var6.field2780;
               var5 -= var6.field2780;
            } while(!this.superStream.method1566(var6, var1, var4, var5));
         }
      }

   }

    @ObfuscatedName("c")
    protected void skip(int var1) {
      this.mixer.skip(var1);

      for(MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
         if (!this.superStream.method1582(var3)) {
            int var2 = var1;

            do {
               if (var2 <= var3.field2780) {
                  this.method1613(var3, var2);
                  var3.field2780 -= var2;
                  break;
               }

               this.method1613(var3, var3.field2780);
               var2 -= var3.field2780;
            } while(!this.superStream.method1566(var3, (int[])null, 0, var2));
         }
      }

   }

    @ObfuscatedName("gt")
    @ObfuscatedSignature(
            descriptor = "(IIIIZI)V",
            garbageValue = "1425861786"
    )
    static final void setViewportShape(int var0, int var1, int var2, int var3, boolean var4) {
      if (var2 < 1) {
         var2 = 1;
      }

      if (var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      int var6;
      if (var5 < 0) {
         var6 = Client.field637;
      } else if (var5 >= 100) {
         var6 = Client.field638;
      } else {
         var6 = (Client.field638 - Client.field637) * var5 / 100 + Client.field637;
      }

      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var10;
      if (var7 < Client.field643) {
         var10 = Client.field643;
         var6 = var10 * var2 * 334 / (var3 * 512);
         if (var6 > Client.field642) {
            var6 = Client.field642;
            var8 = var3 * var6 * 512 / (var10 * 334);
            var9 = (var2 - var8) / 2;
            if (var4) {
               Rasterizer2D.Rasterizer2D_resetClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if (var7 > Client.field644) {
         var10 = Client.field644;
         var6 = var10 * var2 * 334 / (var3 * 512);
         if (var6 < Client.field627) {
            var6 = Client.field627;
            var8 = var10 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if (var4) {
               Rasterizer2D.Rasterizer2D_resetClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      Client.viewportZoom = var3 * var6 / 334;
      if (var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         class174.method900(var2, var3);
      }

      Client.viewportOffsetX = var0;
      Client.viewportOffsetY = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }
}
