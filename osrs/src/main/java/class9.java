import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class9 implements class356 {
   @ObfuscatedName("wf")
   static List field21;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Laa;"
   )
   public static final class9 field30 = new class9(0, "POST", true, true);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Laa;"
   )
   public static final class9 field24 = new class9(1, "GET", true, false);
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Laa;"
   )
   static final class9 field22 = new class9(2, "PUT", false, true);
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Laa;"
   )
   static final class9 field23 = new class9(3, "PATCH", false, true);
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Laa;"
   )
   static final class9 field31 = new class9(4, "DELETE", false, true);
   @ObfuscatedName("ax")
   static int field29;
   @ObfuscatedName("jp")
   static int field28;
   @ObfuscatedName("ab")
   int field20;
   @ObfuscatedName("aq")
   String field25;
   @ObfuscatedName("al")
   boolean field26;
   @ObfuscatedName("at")
   boolean field27;

   class9(int var1, String var2, boolean var3, boolean var4) {
      this.field20 = var1;
      this.field25 = var2;
      this.field26 = var3;
      this.field27 = var4;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.field20;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "74"
   )
   boolean method33() {
      return this.field26;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "-57"
   )
   public String method30() {
      return this.field25;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "142097256"
   )
   boolean method31() {
      return this.field27;
   }
}
