import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public abstract class class177 {
   @ObfuscatedName("ac")
   String field1468;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lgy;"
   )
   @ObfuscatedName("this$0")
   final class166 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lgy;Ljava/lang/String;)V"
   )
   class177(class166 var1, String var2) {
      this.this$0 = var1;
      this.field1468 = var2;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "-41"
    )
    public abstract int vmethod3379();

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(B)Ljava/lang/String;",
            garbageValue = "88"
    )
    public String vmethod3380() {
      return null;
   }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "421671702"
    )
    public int vmethod3378() {
      return -1;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "89"
   )
   public String method963() {
      return this.field1468;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1787184956"
   )
   public static void method967(boolean var0) {
      if (NetCache.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.writeByte(var0 ? 2 : 3);
            var1.writeMedium(0);
            NetCache.NetCache_socket.write(var1.array, 0, 4);
         } catch (IOException var4) {
            try {
               NetCache.NetCache_socket.close();
            } catch (Exception var3) {
               ;
            }

            ++NetCache.NetCache_ioExceptions;
            NetCache.NetCache_socket = null;
         }

      }
   }
}
