import java.security.SecureRandom;
import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
class class133 implements Callable {
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Lns;"
   )
   @Export("NetCache_currentResponse")
   public static NetFileRequest NetCache_currentResponse;
   @ObfuscatedName("hy")
   @Export("secureRandom")
   static SecureRandom secureRandom;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   @Export("this$0")
   @ObfuscatedName("this$0")
   final class134 this$0;
   // $FF: synthetic field
   @Export("val$workStart")
   @ObfuscatedName("val$workStart")
   final int val$workStart;
   // $FF: synthetic field
   @Export("val$workEnd")
   @ObfuscatedName("val$workEnd")
   final int val$workEnd;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "[Lez;"
   )
   @Export("val$curveLoadJobs")
   @ObfuscatedName("val$curveLoadJobs")
   final class126[] val$curveLoadJobs;

   @ObfuscatedSignature(
      descriptor = "(Lfl;II[Lez;)V"
   )
   class133(class134 var1, int var2, int var3, class126[] var4) {
      this.this$0 = var1;
      this.val$workStart = var2;
      this.val$workEnd = var3;
      this.val$curveLoadJobs = var4;
   }

   @Export("call")
   @ObfuscatedName("call")
   public Object call() {
      for(int var1 = this.val$workStart; var1 < this.val$workEnd; ++var1) {
         this.val$curveLoadJobs[var1].call();
      }

      return null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)[Leu;",
      garbageValue = "5"
   )
   static class128[] method723() {
      return new class128[]{class128.field1225, class128.field1234, class128.field1226, class128.field1227, class128.field1228, class128.field1229};
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1753207720"
   )
   static void method722() {
      Messages.Messages_channels.clear();
      Messages.Messages_hashTable.clear();
      Messages.Messages_queue.clear();
      Messages.Messages_count = 0;
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-120"
   )
   static final void method721() {
      if (class18.ClanChat_inClanChat) {
         if (ReflectionCheck.friendsChat != null) {
            ReflectionCheck.friendsChat.sort();
         }

         class169.method899();
         class18.ClanChat_inClanChat = false;
      }

   }
}
