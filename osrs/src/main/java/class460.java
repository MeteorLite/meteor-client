import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qf")
public class class460 extends DualNode {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "[Lqr;"
   )
   class456[] field3977;
   @ObfuscatedName("m")
   List field3978;

   @ObfuscatedSignature(
      descriptor = "(Lly;I)V"
   )
   public class460(AbstractArchive var1, int var2) {
      byte[] var3 = var1.takeFile(var2, 0);
      this.method2316(new Buffer(var3));
   }

   @ObfuscatedSignature(
      descriptor = "(Lly;II)V"
   )
   public class460(AbstractArchive var1, int var2, int var3) {
      byte[] var4 = var1.takeFile(var2, var3 + 1);
      this.method2316(new Buffer(var4));
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;B)V",
      garbageValue = "-66"
   )
   void method2316(Buffer var1) {
      int var2 = var1.method2363();
      this.field3977 = new class456[var2];
      this.field3978 = new ArrayList(var2);

      for(int var3 = 0; var3 < var2; ++var3) {
         this.field3977[var3] = (class456)World.findEnumerated(class456.method2303(), var1.readUnsignedByte());
         int var4 = var1.method2363();
         HashMap var5 = new HashMap(var4);

         while(var4-- > 0) {
            Object var6 = this.field3977[var3].method2301(var1);
            int var7 = var1.method2363();
            ArrayList var8 = new ArrayList();

            while(var7-- > 0) {
               int var9 = var1.method2363();
               var8.add(var9);
            }

            var5.put(var6, var8);
         }

         this.field3978.add(var3, var5);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;II)Ljava/util/List;",
      garbageValue = "1954591812"
   )
   public List method2317(Object var1, int var2) {
      if (var2 < 0) {
         var2 = 0;
      }

      Map var3 = (Map)this.field3978.get(var2);
      return (List)var3.get(var1);
   }
}
