import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("ObjTypeCustomisation")
public class ObjTypeCustomisation {
   @ObfuscatedName("sc")
   static boolean field1453;
   @ObfuscatedName("ac")
   @Export("recol")
   public short[] recol;
   @ObfuscatedName("ab")
   @Export("retex")
   public short[] retex;

   ObjTypeCustomisation(int var1) {
      ItemComposition var2 = ParamComposition.ItemDefinition_get(var1);
      if (var2.hasRecolor()) {
         this.recol = new short[var2.recolorTo.length];
         System.arraycopy(var2.recolorTo, 0, this.recol, 0, this.recol.length);
      }

      if (var2.hasRetexture()) {
         this.retex = new short[var2.retextureTo.length];
         System.arraycopy(var2.retextureTo, 0, this.retex, 0, this.retex.length);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lne;I)V",
      garbageValue = "-1529721231"
   )
   public static void method921(AbstractArchive var0) {
      EnumComposition.EnumDefinition_archive = var0;
   }
}
