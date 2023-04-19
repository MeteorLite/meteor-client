import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pj")
public final class class399 implements Comparable {
    @ObfuscatedName("wm")
    static short[] foundItemIds;
    @ObfuscatedName("ay")
    @ObfuscatedSignature(
            descriptor = "Lgv;"
    )
    static Clock clock;
    @ObfuscatedName("fw")
    @ObfuscatedSignature(
            descriptor = "Lnd;"
    )
    static Archive archive6;
   @ObfuscatedName("af")
   Object field3699;
   @ObfuscatedName("an")
   Object field3700;
   @ObfuscatedName("aw")
   long field3701;
   @ObfuscatedName("ac")
   long field3702;

   class399(Object var1, Object var2) {
      this.field3699 = var1;
      this.field3700 = var2;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lpj;I)I",
      garbageValue = "-331222916"
   )
   int method2128(class399 var1) {
      if (this.field3702 < var1.field3702) {
         return -1;
      } else {
         return this.field3702 > var1.field3702 ? 1 : 0;
      }
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      if (var1 instanceof class399) {
         return this.field3700.equals(((class399)var1).field3700);
      } else {
         throw new IllegalArgumentException();
      }
   }

    @ObfuscatedName("hashCode")
    public int hashCode() {
      return this.field3700.hashCode();
   }

    @ObfuscatedName("compareTo")
    public int compareTo(Object var1) {
      return this.method2128((class399)var1);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(II)Ltf;",
      garbageValue = "-108064052"
   )
   public static PrivateChatMode method2129(int var0) {
      PrivateChatMode[] var1 = new PrivateChatMode[]{PrivateChatMode.field4163, PrivateChatMode.field4162, PrivateChatMode.field4161};
      PrivateChatMode[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         PrivateChatMode var4 = var2[var3];
         if (var0 == var4.id) {
            return var4;
         }
      }

      return null;
   }
}
