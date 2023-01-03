import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qk")
public class class451 extends class415 implements class264 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   final AbstractArchive field3963;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Ljj;"
   )
   final DemotingHashTable field3964 = new DemotingHashTable(64);
   @ObfuscatedName("x")
   final int field3962;

   @ObfuscatedSignature(
      descriptor = "(Llw;ILmb;Lly;)V"
   )
   public class451(StudioGame var1, int var2, Language var3, AbstractArchive var4) {
      super(var1, var3, var4 != null ? var4.getGroupFileCount(var2) : 0);
      this.field3963 = var4;
      this.field3962 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)Lpv;",
      garbageValue = "307947551"
   )
   @Export("vmethod8207")
   protected class417 vmethod8207(int var1) {
      DemotingHashTable var3 = this.field3964;
      synchronized(this.field3964) {
         class416 var2 = (class416)this.field3964.get((long)var1);
         if (var2 == null) {
            var2 = this.method2288(var1);
            this.field3964.method1499(var2, (long)var1);
         }

         return var2;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(II)Lpe;",
      garbageValue = "1730899339"
   )
   class416 method2288(int var1) {
      byte[] var2 = this.field3963.takeFile(this.field3962, var1);
      class416 var3 = new class416(var1);
      if (var2 != null) {
         var3.method2163(new Buffer(var2));
      }

      return var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1754265267"
   )
   public void method2287() {
      DemotingHashTable var1 = this.field3964;
      synchronized(this.field3964) {
         this.field3964.clear();
      }
   }

   @Export("iterator")
   @ObfuscatedName("iterator")
   public Iterator iterator() {
      return new class450(this);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "([BI)[B",
      garbageValue = "-1587631557"
   )
   public static byte[] method2290(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }
}
