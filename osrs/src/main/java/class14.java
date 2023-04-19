import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class14 {
    @ObfuscatedName("iq")
    @ObfuscatedSignature(
            descriptor = "Let;"
    )
    static UrlRequester urlRequester;
   @ObfuscatedName("af")
   final int field44;
   @ObfuscatedName("an")
   final String field45;
   @ObfuscatedName("aw")
   final ThreadFactory field48;
   @ObfuscatedName("ac")
   final ThreadPoolExecutor field47;

   public class14(String var1, int var2, int var3) {
      this.field45 = var1;
      this.field44 = var2;
      this.field48 = new class16(this);
      this.field47 = this.method51(var3);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(II)Ljava/util/concurrent/ThreadPoolExecutor;",
      garbageValue = "140913775"
   )
   final ThreadPoolExecutor method51(int var1) {
      return new ThreadPoolExecutor(var1, var1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(this.field44), this.field48);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lay;B)Lam;",
      garbageValue = "1"
   )
   public class18 method52(class10 var1) {
      if (this.field47.getQueue().remainingCapacity() <= 0) {
         System.err.println("REST thread pool queue is empty\r\nThread pool size " + this.field47.getCorePoolSize() + " Queue capacity " + this.field44);
         return new class18("Queue full");
      } else {
         class18 var2 = new class18(this.field47.submit(new class19(this, var1)));
         return var2;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "537635380"
   )
   public final void method54() {
      try {
         this.field47.shutdown();
      } catch (Exception var2) {
         System.err.println("Error shutting down RestRequestService\r\n" + var2);
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lek;FB)F",
      garbageValue = "88"
   )
   static float method58(class125 var0, float var1) {
      if (var0 == null) {
         return 0.0F;
      } else {
         float var2 = var1 - var0.field1221;
         return var0.field1226 + var2 * (var0.field1237 + var2 * (var0.field1223 * var2 + var0.field1224));
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(CIB)Ljava/lang/String;",
      garbageValue = "0"
   )
   static String method57(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-729068470"
   )
   public static void method56() {
      ObjectComposition.ObjectDefinition_cached.clear();
      ObjectComposition.ObjectDefinition_cachedModelData.clear();
      ObjectComposition.ObjectDefinition_cachedEntities.clear();
      ObjectComposition.ObjectDefinition_cachedModels.clear();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "2038496653"
   )
   static void method55(int var0) {
      class129.method763(14);
      Login.field738 = var0;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1683073993"
   )
   static final void method53(boolean var0) {
      if (var0) {
         Client.field394 = Login.field751 ? class135.field1299 : class135.field1301;
      } else {
         Client.field394 = class20.clientPreferences.method563(Login.Login_username) ? class135.field1302 : class135.field1305;
      }

   }
}
