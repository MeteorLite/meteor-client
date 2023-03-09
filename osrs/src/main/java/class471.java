import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("st")
public class class471 extends DualNode {
   @ObfuscatedName("kt")
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "[Lrf;"
   )
   class467[] field3956;
   @ObfuscatedName("an")
   List field3957;

   @ObfuscatedSignature(
      descriptor = "(Lne;I)V"
   )
   public class471(AbstractArchive var1, int var2) {
      byte[] var3 = var1.takeFile(var2, 0);
      this.method2377(new Buffer(var3));
   }

   @ObfuscatedSignature(
      descriptor = "(Lne;II)V"
   )
   public class471(AbstractArchive var1, int var2, int var3) {
      byte[] var4 = var1.takeFile(var2, var3 + 1);
      this.method2377(new Buffer(var4));
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "2066420776"
   )
   void method2377(Buffer var1) {
      int var2 = var1.method2463();
      this.field3956 = new class467[var2];
      this.field3957 = new ArrayList(var2);

      for(int var3 = 0; var3 < var2; ++var3) {
         this.field3956[var3] = (class467)SpriteMask.findEnumerated(class467.method2367(), var1.readUnsignedByte());
         int var4 = var1.method2463();
         HashMap var5 = new HashMap(var4);

         while(var4-- > 0) {
            Object var6 = this.field3956[var3].method2362(var1);
            int var7 = var1.method2463();
            ArrayList var8 = new ArrayList();

            while(var7-- > 0) {
               int var9 = var1.method2463();
               var8.add(var9);
            }

            var5.put(var6, var8);
         }

         this.field3957.add(var3, var5);
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;II)Ljava/util/List;",
      garbageValue = "1213630934"
   )
   public List method2376(Object var1, int var2) {
      if (var2 < 0) {
         var2 = 0;
      }

      Map var3 = (Map)this.field3957.get(var2);
      return (List)var3.get(var1);
   }
}
