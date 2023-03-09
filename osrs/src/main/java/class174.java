import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class174 {
   @ObfuscatedName("ab")
   public String field1430;
   @ObfuscatedName("an")
   public float[] field1433;
   @ObfuscatedName("ao")
   public int field1431;
   @ObfuscatedName("av")
   public int field1429;
   @ObfuscatedName("aq")
   public int field1432;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lgs;"
   )
   @Export("this$0")
   @ObfuscatedName("this$0")
   final class167 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lgs;)V"
   )
   class174(class167 var1) {
      this.this$0 = var1;
      this.field1433 = new float[4];
      this.field1431 = 1;
      this.field1429 = 1;
      this.field1432 = 0;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lne;I)I",
      garbageValue = "-505461552"
   )
   static int method905(AbstractArchive var0) {
      int var1 = Login.field759.length + Login.field760.length;
      String[] var2 = Login.field761;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         String var4 = var2[var3];
         if (var0.getGroupId(var4) != -1) {
            ++var1;
         }
      }

      return var1;
   }

   @ObfuscatedName("mz")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "106"
   )
   static final void method906() {
      for(int var0 = 0; var0 < Players.Players_count; ++var0) {
         Player var1 = Client.players[Players.Players_indices[var0]];
         var1.clearIsInClanChat();
      }

   }
}
