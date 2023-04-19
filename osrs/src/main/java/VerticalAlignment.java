import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements class356 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lhn;"
   )
   field1610(2, 0),
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lhn;"
    )
    VerticalAlignment_centered(1, 1),
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lhn;"
   )
   field1605(0, 2);

    @ObfuscatedName("ap")
    @ObfuscatedSignature(
            descriptor = "[[Lmq;"
    )
    public static Widget[][] Widget_interfaceComponents;
    @ObfuscatedName("ac")
    public final int value;
    @ObfuscatedName("au")
    final int id;

   VerticalAlignment(int var3, int var4) {
      this.value = var3;
      this.id = var4;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.id;
   }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/CharSequence;I)I",
            garbageValue = "270279938"
    )
    public static int hashString(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class100.charToByteCp1252(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-504948756"
   )
   static final void method1036(String var0) {
      UserComparator5.addGameMessage(30, "", var0);
   }
}
