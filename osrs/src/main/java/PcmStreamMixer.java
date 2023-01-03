import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   NodeDeque subStreams = new NodeDeque();
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   NodeDeque field163 = new NodeDeque();
   @ObfuscatedName("v")
   int field162 = 0;
   @ObfuscatedName("x")
   int field165 = -1;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Laa;)V"
   )
   public final synchronized void addSubStream(PcmStream var1) {
      this.subStreams.addLast(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Laa;)V"
   )
   public final synchronized void removeSubStream(PcmStream var1) {
      var1.remove();
   }

   @ObfuscatedName("v")
   void method200() {
      if (this.field162 > 0) {
         for(PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field163.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field163.previous()) {
            var1.field294 -= this.field162;
         }

         this.field165 -= this.field162;
         this.field162 = 0;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Lpl;Lbo;)V"
   )
   void method194(Node var1, PcmStreamMixerListener var2) {
      while(this.field163.sentinel != var1 && ((PcmStreamMixerListener)var1).field294 <= var2.field294) {
         var1 = var1.previous;
      }

      NodeDeque.NodeDeque_addBefore(var2, var1);
      this.field165 = ((PcmStreamMixerListener)this.field163.sentinel.previous).field294;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Lbo;)V"
   )
   void method195(PcmStreamMixerListener var1) {
      var1.remove();
      var1.remove2();
      Node var2 = this.field163.sentinel.previous;
      if (var2 == this.field163.sentinel) {
         this.field165 = -1;
      } else {
         this.field165 = ((PcmStreamMixerListener)var2).field294;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "()Laa;"
   )
   protected PcmStream firstSubStream() {
      return (PcmStream)this.subStreams.last();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "()Laa;"
   )
   protected PcmStream nextSubStream() {
      return (PcmStream)this.subStreams.previous();
   }

   @ObfuscatedName("r")
   protected int vmethod5648() {
      return 0;
   }

   @ObfuscatedName("u")
   public final synchronized void fill(int[] var1, int var2, int var3) {
      do {
         if (this.field165 < 0) {
            this.updateSubStreams(var1, var2, var3);
            return;
         }

         if (var3 + this.field162 < this.field165) {
            this.field162 += var3;
            this.updateSubStreams(var1, var2, var3);
            return;
         }

         int var4 = this.field165 - this.field162;
         this.updateSubStreams(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field162 += var4;
         this.method200();
         PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field163.last();
         synchronized(var5) {
            int var7 = var5.update();
            if (var7 < 0) {
               var5.field294 = 0;
               this.method195(var5);
            } else {
               var5.field294 = var7;
               this.method194(var5.previous, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("b")
   void updateSubStreams(int[] var1, int var2, int var3) {
      for(PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
         var4.update(var1, var2, var3);
      }

   }

   @ObfuscatedName("j")
   public final synchronized void skip(int var1) {
      do {
         if (this.field165 < 0) {
            this.skipSubStreams(var1);
            return;
         }

         if (this.field162 + var1 < this.field165) {
            this.field162 += var1;
            this.skipSubStreams(var1);
            return;
         }

         int var2 = this.field165 - this.field162;
         this.skipSubStreams(var2);
         var1 -= var2;
         this.field162 += var2;
         this.method200();
         PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field163.last();
         synchronized(var3) {
            int var5 = var3.update();
            if (var5 < 0) {
               var3.field294 = 0;
               this.method195(var3);
            } else {
               var3.field294 = var5;
               this.method194(var3.previous, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("g")
   void skipSubStreams(int var1) {
      for(PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
         var2.skip(var1);
      }

   }
}
