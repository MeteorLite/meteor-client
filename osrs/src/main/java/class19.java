import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class19 {
   @ObfuscatedName("vb")
   @Export("foundItemIds")
   static short[] foundItemIds;
   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      descriptor = "Lfl;"
   )
   @Export("socketTask")
   static Task socketTask;
   @ObfuscatedName("h")
   Future field56;
   @ObfuscatedName("e")
   String field55;

   class19(Future var1) {
      this.field56 = var1;
   }

   class19(String var1) {
      this.method65(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-1964970587"
   )
   void method65(String var1) {
      if (var1 == null) {
         var1 = "";
      }

      this.field55 = var1;
      if (this.field56 != null) {
         this.field56.cancel(true);
         this.field56 = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "16"
   )
   public final String method66() {
      return this.field55;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "47"
   )
   public boolean method68() {
      return this.field55 != null || this.field56 == null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "2"
   )
   public final boolean method67() {
      return this.method68() ? true : this.field56.isDone();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(S)Lp;",
      garbageValue = "-10095"
   )
   public final class21 method69() {
      if (this.method68()) {
         return new class21(this.field55);
      } else if (!this.method67()) {
         return null;
      } else {
         try {
            return (class21)this.field56.get();
         } catch (Exception var3) {
            String var2 = "Error retrieving REST request reply";
            System.err.println(var2 + "\r\n" + var3);
            this.method65(var2);
            return new class21(var2);
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lqx;IB)V",
      garbageValue = "0"
   )
   @Export("updatePlayers")
   static final void updatePlayers(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      Players.Players_pendingUpdateCount = 0;
      FriendSystem.method412(var0);
      class300.method1616(var0);
      if (var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }
}
