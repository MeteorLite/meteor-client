import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("uw")
   static int field851;
    @ObfuscatedName("be")
    @ObfuscatedSignature(
            descriptor = "Lnm;"
    )
    static AbstractArchive Widget_spritesArchive;
    @ObfuscatedName("af")
    Object[] args;
   @ObfuscatedName("an")
   boolean field849;
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lmq;"
    )
    Widget widget;
    @ObfuscatedName("ac")
    int mouseX;
    @ObfuscatedName("au")
    int mouseY;
    @ObfuscatedName("ab")
    int opIndex;
    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "Lmq;"
    )
    Widget dragTarget;
    @ObfuscatedName("al")
    int keyTyped;
    @ObfuscatedName("at")
    int keyPressed;
    @ObfuscatedName("aa")
    String targetName;
   @ObfuscatedName("ay")
   int field859;
    @ObfuscatedName("ao")
    int type = 76;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "([Ljava/lang/Object;I)V",
            garbageValue = "1592193051"
    )
    public void setArgs(Object[] var1) {
      this.args = var1;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "-715457953"
    )
    public void setType(int var1) {
      this.type = var1;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Lmq;B)V",
      garbageValue = "46"
   )
   public void method491(Widget var1) {
      this.widget = var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-404046027"
   )
   public static boolean method492(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      descriptor = "(II)Ljava/lang/Object;",
      garbageValue = "140297466"
   )
   static Object method489(int var0) {
      return Language.method1948((class478)StructComposition.findEnumerated(class478.method2432(), var0));
   }
}
