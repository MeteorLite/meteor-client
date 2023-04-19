import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class120 {
    @ObfuscatedName("ay")
    public static boolean musicTrackBoolean;
   @ObfuscatedName("af")
   int field1175;
   @ObfuscatedName("an")
   float field1178;
   @ObfuscatedName("aw")
   float field1174 = Float.MAX_VALUE;
   @ObfuscatedName("ac")
   float field1172 = Float.MAX_VALUE;
   @ObfuscatedName("au")
   float field1176 = Float.MAX_VALUE;
   @ObfuscatedName("ab")
   float field1173 = Float.MAX_VALUE;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lev;"
   )
   class120 field1177;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lsg;II)V",
      garbageValue = "652967441"
   )
   void method717(Buffer var1, int var2) {
      this.field1175 = var1.readShort();
      this.field1178 = var1.method2487();
      this.field1174 = var1.method2487();
      this.field1172 = var1.method2487();
      this.field1176 = var1.method2487();
      this.field1173 = var1.method2487();
   }

    @ObfuscatedName("lw")
    @ObfuscatedSignature(
            descriptor = "(ZB)V",
            garbageValue = "-44"
    )
    static void setTapToDrop(boolean var0) {
      Client.tapToDrop = var0;
   }
}
