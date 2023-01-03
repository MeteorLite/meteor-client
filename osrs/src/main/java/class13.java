import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.bouncycastle.crypto.tls.DefaultTlsClient;
import org.bouncycastle.crypto.tls.TlsAuthentication;

@ObfuscatedName("o")
class class13 extends DefaultTlsClient {
   @ObfuscatedName("s")
   static int field39;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Li;"
   )
   final class12 this$1;

   @ObfuscatedSignature(
      descriptor = "(Li;)V"
   )
   class13(class12 var1) {
      this.this$1 = var1;
   }

   @ObfuscatedName("getClientExtensions")
   public Hashtable getClientExtensions() throws IOException {
      Hashtable var1 = super.getClientExtensions();
      if (var1 == null) {
         var1 = new Hashtable();
      }

      byte[] var2 = this.this$1.val$host.getBytes();
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      DataOutputStream var4 = new DataOutputStream(var3);
      var4.writeShort(var2.length + 3);
      var4.writeByte(0);
      var4.writeShort(var2.length);
      var4.write(var2);
      var4.close();
      var1.put(0, var3.toByteArray());
      return var1;
   }

   @ObfuscatedName("getAuthentication")
   public TlsAuthentication getAuthentication() throws IOException {
      return new class11(this);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)I",
      garbageValue = "-339253147"
   )
   public static int stringCp1252NullTerminatedByteSize(String var0) {
      return var0.length() + 1;
   }
}
