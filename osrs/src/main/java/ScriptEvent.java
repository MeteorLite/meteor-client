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
   @Export("Widget_spritesArchive")
   static AbstractArchive Widget_spritesArchive;
   @ObfuscatedName("af")
   @Export("args")
   Object[] args;
   @ObfuscatedName("an")
   boolean field849;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("ac")
   @Export("mouseX")
   int mouseX;
   @ObfuscatedName("au")
   @Export("mouseY")
   int mouseY;
   @ObfuscatedName("ab")
   @Export("opIndex")
   int opIndex;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   @Export("dragTarget")
   Widget dragTarget;
   @ObfuscatedName("al")
   @Export("keyTyped")
   int keyTyped;
   @ObfuscatedName("at")
   @Export("keyPressed")
   int keyPressed;
   @ObfuscatedName("aa")
   @Export("targetName")
   String targetName;
   @ObfuscatedName("ay")
   int field859;
   @ObfuscatedName("ao")
   @Export("type")
   int type = 76;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "([Ljava/lang/Object;I)V",
      garbageValue = "1592193051"
   )
   @Export("setArgs")
   public void setArgs(Object[] var1) {
      this.args = var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-715457953"
   )
   @Export("setType")
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
