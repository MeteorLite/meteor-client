import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lmo;"
    )
    NodeDeque subStreams = new NodeDeque();
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lmo;"
   )
   NodeDeque field174 = new NodeDeque();
   @ObfuscatedName("s")
   int field173 = 0;
   @ObfuscatedName("z")
   int field176 = -1;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lan;)V"
    )
    public final synchronized void addSubStream(PcmStream var1) {
      this.subStreams.addLast(var1);
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Lan;)V"
    )
    public final synchronized void removeSubStream(PcmStream var1) {
      var1.remove();
   }

   @ObfuscatedName("v")
   void method175() {
      if (this.field173 > 0) {
         for(PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field174.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field174.previous()) {
            var1.field303 -= this.field173;
         }

         this.field176 -= this.field173;
         this.field173 = 0;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Lpr;Lbz;)V"
   )
   void method176(Node var1, PcmStreamMixerListener var2) {
      while(this.field174.sentinel != var1 && ((PcmStreamMixerListener)var1).field303 <= var2.field303) {
         var1 = var1.previous;
      }

      NodeDeque.NodeDeque_addBefore(var2, var1);
      this.field176 = ((PcmStreamMixerListener)this.field174.sentinel.previous).field303;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(Lbz;)V"
   )
   void method177(PcmStreamMixerListener var1) {
      var1.remove();
      var1.remove2();
      Node var2 = this.field174.sentinel.previous;
      if (var2 == this.field174.sentinel) {
         this.field176 = -1;
      } else {
         this.field176 = ((PcmStreamMixerListener)var2).field303;
      }

   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "()Lan;"
    )
    protected PcmStream firstSubStream() {
      return (PcmStream)this.subStreams.last();
   }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "()Lan;"
    )
    protected PcmStream nextSubStream() {
      return (PcmStream)this.subStreams.previous();
   }

    @ObfuscatedName("n")
    protected int vmethod5648() {
      return 0;
   }

    @ObfuscatedName("l")
    public final synchronized void fill(int[] var1, int var2, int var3) {
      do {
         if (this.field176 < 0) {
            this.updateSubStreams(var1, var2, var3);
            return;
         }

         if (var3 + this.field173 < this.field176) {
            this.field173 += var3;
            this.updateSubStreams(var1, var2, var3);
            return;
         }

         int var4 = this.field176 - this.field173;
         this.updateSubStreams(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field173 += var4;
         this.method175();
         PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field174.last();
         synchronized(var5) {
            int var7 = var5.update();
            if (var7 < 0) {
               var5.field303 = 0;
               this.method177(var5);
            } else {
               var5.field303 = var7;
               this.method176(var5.previous, var5);
            }
         }
      } while(var3 != 0);

   }

    @ObfuscatedName("k")
    void updateSubStreams(int[] var1, int var2, int var3) {
      for(PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
         var4.update(var1, var2, var3);
      }

   }

    @ObfuscatedName("c")
    public final synchronized void skip(int var1) {
      do {
         if (this.field176 < 0) {
            this.skipSubStreams(var1);
            return;
         }

         if (this.field173 + var1 < this.field176) {
            this.field173 += var1;
            this.skipSubStreams(var1);
            return;
         }

         int var2 = this.field176 - this.field173;
         this.skipSubStreams(var2);
         var1 -= var2;
         this.field173 += var2;
         this.method175();
         PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field174.last();
         synchronized(var3) {
            int var5 = var3.update();
            if (var5 < 0) {
               var3.field303 = 0;
               this.method177(var3);
            } else {
               var3.field303 = var5;
               this.method176(var3.previous, var3);
            }
         }
      } while(var1 != 0);

   }

    @ObfuscatedName("r")
    void skipSubStreams(int var1) {
      for(PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
         var2.skip(var1);
      }

   }
}
