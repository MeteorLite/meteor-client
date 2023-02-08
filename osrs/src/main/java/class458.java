import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qt")
public class class458 extends class422 implements class268 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   final AbstractArchive field3974;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Ljp;"
   )
   final DemotingHashTable field3975 = new DemotingHashTable(64);
   @ObfuscatedName("s")
   final int field3973;

   @ObfuscatedSignature(
      descriptor = "(Lle;ILmn;Lln;)V"
   )
   public class458(StudioGame var1, int var2, Language var3, AbstractArchive var4) {
      super(var1, var3, var4 != null ? var4.getGroupFileCount(var2) : 0);
      this.field3974 = var4;
      this.field3973 = var2;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(II)Lpj;",
            garbageValue = "-982443960"
    )
    protected class424 vmethod8207(int var1) {
      DemotingHashTable var3 = this.field3975;
      synchronized(this.field3975) {
         class423 var2 = (class423)this.field3975.get((long)var1);
         if (var2 == null) {
            var2 = this.method2327(var1);
            this.field3975.method1512(var2, (long)var1);
         }

         return var2;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(II)Lpp;",
      garbageValue = "-1876607651"
   )
   class423 method2327(int var1) {
      byte[] var2 = this.field3974.takeFile(this.field3973, var1);
      class423 var3 = new class423(var1);
      if (var2 != null) {
         var3.method2200(new Buffer(var2));
      }

      return var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-105"
   )
   public void method2326() {
      DemotingHashTable var1 = this.field3975;
      synchronized(this.field3975) {
         this.field3975.clear();
      }
   }

    @ObfuscatedName("iterator")
    public Iterator iterator() {
      return new class457(this);
   }
}
