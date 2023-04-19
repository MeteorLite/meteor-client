import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lnh;"
    )
    NodeDeque subStreams = new NodeDeque();
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lnh;"
   )
   NodeDeque field169 = new NodeDeque();
   @ObfuscatedName("aw")
   int field170 = 0;
   @ObfuscatedName("ac")
   int field171 = -1;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lbp;)V"
    )
    public final synchronized void addSubStream(PcmStream var1) {
      this.subStreams.addLast(var1);
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lbp;)V"
    )
    public final synchronized void removeSubStream(PcmStream var1) {
      var1.remove();
   }

   @ObfuscatedName("aw")
   void method203() {
      if (this.field170 > 0) {
         for(PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field169.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field169.previous()) {
            var1.field300 -= this.field170;
         }

         this.field171 -= this.field170;
         this.field170 = 0;
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lrp;Lcs;)V"
   )
   void method204(Node var1, PcmStreamMixerListener var2) {
      while(this.field169.sentinel != var1 && ((PcmStreamMixerListener)var1).field300 <= var2.field300) {
         var1 = var1.previous;
      }

      NodeDeque.NodeDeque_addBefore(var2, var1);
      this.field171 = ((PcmStreamMixerListener)this.field169.sentinel.previous).field300;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Lcs;)V"
   )
   void method209(PcmStreamMixerListener var1) {
      var1.remove();
      var1.remove2();
      Node var2 = this.field169.sentinel.previous;
      if (var2 == this.field169.sentinel) {
         this.field171 = -1;
      } else {
         this.field171 = ((PcmStreamMixerListener)var2).field300;
      }

   }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "()Lbp;"
    )
    protected PcmStream firstSubStream() {
      return (PcmStream)this.subStreams.last();
   }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "()Lbp;"
    )
    protected PcmStream nextSubStream() {
      return (PcmStream)this.subStreams.previous();
   }

    @ObfuscatedName("al")
    protected int vmethod5648() {
      return 0;
   }

    @ObfuscatedName("at")
    public final synchronized void fill(int[] var1, int var2, int var3) {
      do {
         if (this.field171 < 0) {
            this.updateSubStreams(var1, var2, var3);
            return;
         }

         if (var3 + this.field170 < this.field171) {
            this.field170 += var3;
            this.updateSubStreams(var1, var2, var3);
            return;
         }

         int var4 = this.field171 - this.field170;
         this.updateSubStreams(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field170 += var4;
         this.method203();
         PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field169.last();
         synchronized(var5) {
            int var7 = var5.update();
            if (var7 < 0) {
               var5.field300 = 0;
               this.method209(var5);
            } else {
               var5.field300 = var7;
               this.method204(var5.previous, var5);
            }
         }
      } while(var3 != 0);

   }

    @ObfuscatedName("aa")
    void updateSubStreams(int[] var1, int var2, int var3) {
      for(PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
         var4.update(var1, var2, var3);
      }

   }

    @ObfuscatedName("ay")
    public final synchronized void skip(int var1) {
      do {
         if (this.field171 < 0) {
            this.skipSubStreams(var1);
            return;
         }

         if (this.field170 + var1 < this.field171) {
            this.field170 += var1;
            this.skipSubStreams(var1);
            return;
         }

         int var2 = this.field171 - this.field170;
         this.skipSubStreams(var2);
         var1 -= var2;
         this.field170 += var2;
         this.method203();
         PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field169.last();
         synchronized(var3) {
            int var5 = var3.update();
            if (var5 < 0) {
               var3.field300 = 0;
               this.method209(var3);
            } else {
               var3.field300 = var5;
               this.method204(var3.previous, var3);
            }
         }
      } while(var1 != 0);

   }

    @ObfuscatedName("ao")
    void skipSubStreams(int var1) {
      for(PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
         var2.skip(var1);
      }

   }
}
