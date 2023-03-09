import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rw")
public class class462 extends class426 implements class271 {
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lne;"
   )
   final AbstractArchive field3939;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lky;"
   )
   final DemotingHashTable field3940 = new DemotingHashTable(64);
   @ObfuscatedName("ab")
   final int field3941;

   @ObfuscatedSignature(
      descriptor = "(Lml;ILnq;Lne;)V"
   )
   public class462(StudioGame var1, int var2, Language var3, AbstractArchive var4) {
      super(var1, var3, var4 != null ? var4.getGroupFileCount(var2) : 0);
      this.field3939 = var4;
      this.field3941 = var2;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(II)Lqd;",
      garbageValue = "-1357061563"
   )
   @Export("vmethod8207")
   protected class428 vmethod8207(int var1) {
      DemotingHashTable var3 = this.field3940;
      synchronized(this.field3940) {
         class427 var2 = (class427)this.field3940.get((long)var1);
         if (var2 == null) {
            var2 = this.method2350(var1);
            this.field3940.method1518(var2, (long)var1);
         }

         return var2;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(II)Lqf;",
      garbageValue = "-1434656279"
   )
   class427 method2350(int var1) {
      byte[] var2 = this.field3939.takeFile(this.field3941, var1);
      class427 var3 = new class427(var1);
      if (var2 != null) {
         var3.method2217(new Buffer(var2));
      }

      return var3;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1207683194"
   )
   public void method2348() {
      DemotingHashTable var1 = this.field3940;
      synchronized(this.field3940) {
         this.field3940.clear();
      }
   }

   @Export("iterator")
   @ObfuscatedName("iterator")
   public Iterator iterator() {
      return new class461(this);
   }

   @ObfuscatedName("nb")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1719486946"
   )
   static void method2351() {
      if (Language.field3504 != null) {
         Client.field447 = Client.cycle;
         Language.field3504.method1884();

         for(int var0 = 0; var0 < Client.players.length; ++var0) {
            if (Client.players[var0] != null) {
               Language.field3504.method1881((Client.players[var0].x >> 7) + GameEngine.baseX, (Client.players[var0].y >> 7) + class178.baseY);
            }
         }
      }

   }
}
