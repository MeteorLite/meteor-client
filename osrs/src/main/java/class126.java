import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class126 implements Callable {
   @ObfuscatedName("as")
   public static short[][] field1199;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lew;"
   )
   final class127 field1198;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Leu;"
   )
   final class128 field1195;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   final class129 field1197;
   @ObfuscatedName("ab")
   final int field1196;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   @Export("this$0")
   @ObfuscatedName("this$0")
   final class134 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfl;Lew;Leu;Led;I)V"
   )
   class126(class134 var1, class127 var2, class128 var3, class129 var4, int var5) {
      this.this$0 = var1;
      this.field1198 = var2;
      this.field1195 = var3;
      this.field1197 = var4;
      this.field1196 = var5;
   }

   @Export("call")
   @ObfuscatedName("call")
   public Object call() {
      this.field1198.method705();
      class127[][] var1;
      if (this.field1195 == class128.field1234) {
         var1 = this.this$0.field1265;
      } else {
         var1 = this.this$0.field1258;
      }

      var1[this.field1196][this.field1197.method711()] = this.field1198;
      return null;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Ljava/io/File;I)V",
      garbageValue = "-818218620"
   )
   static void method694(File var0) {
      FileSystem.FileSystem_cacheDir = var0;
      if (!FileSystem.FileSystem_cacheDir.exists()) {
         throw new RuntimeException("");
      } else {
         FileSystem.FileSystem_hasPermissions = true;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "112300404"
   )
   public static byte[] method695(Object var0, boolean var1) {
      if (var0 == null) {
         return null;
      } else if (var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if (var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if (var0 instanceof AbstractByteArrayCopier) {
         AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-1808711243"
   )
   @Export("getFile")
   static File getFile(String var0) {
      if (!FileSystem.FileSystem_hasPermissions) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)FileSystem.FileSystem_cacheFiles.get(var0);
         if (var1 != null) {
            return var1;
         } else {
            File var2 = new File(FileSystem.FileSystem_cacheDir, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if (!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  FileSystem.FileSystem_cacheFiles.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if (var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("nq")
   @ObfuscatedSignature(
      descriptor = "(II)Lst;",
      garbageValue = "311737350"
   )
   static class471 method696(int var0) {
      class471 var1 = (class471)Client.Widget_cachedModels.get((long)var0);
      if (var1 == null) {
         var1 = new class471(class320.field3001, class36.method175(var0), GameObject.method1307(var0));
         Client.Widget_cachedModels.put(var1, (long)var0);
      }

      return var1;
   }
}
