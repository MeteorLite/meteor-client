import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
@Implements("Skeleton")
public class Skeleton extends Node {
   @ObfuscatedName("lf")
   @ObfuscatedSignature(
      descriptor = "Lht;"
   )
   static TextureProvider textureProvider;
   @ObfuscatedName("q")
   int id;
   @ObfuscatedName("f")
   int count;
   @ObfuscatedName("r")
   int[] transformTypes;
   @ObfuscatedName("u")
   int[][] labels;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Lhi;"
   )
   class213 field1990;

   public Skeleton(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.transformTypes = new int[this.count];
      this.labels = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.transformTypes[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.labels[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.labels[var4].length; ++var5) {
            this.labels[var4][var5] = var3.readUnsignedByte();
         }
      }

      if (var3.offset < var3.array.length) {
         var4 = var3.readUnsignedShort();
         if (var4 > 0) {
            this.field1990 = new class213(var3, var4);
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-2112065673"
   )
   public int method1176() {
      return this.count;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)Lhi;",
      garbageValue = "736109074"
   )
   public class213 method1175() {
      return this.field1990;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "81"
   )
   static final void method1177() {
      Object var10000 = null;
      String var0 = "You can't add yourself to your own friend list";
      KitDefinition.addGameMessage(30, "", var0);
   }
}
