import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class ScriptEvent extends Node {
   @ObfuscatedName("vk")
   @ObfuscatedGetter(
      intValue = 876280679
   )
   static int foundItemIdCount;
   @ObfuscatedName("h")
   Object[] args;
   @ObfuscatedName("e")
   boolean isMouseInputEvent;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   Widget widget;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1516520981
   )
   int mouseX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 318715241
   )
   int mouseY;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2003088619
   )
   int opIndex;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   Widget dragTarget;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1106115125
   )
   int keyTyped;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 887616203
   )
   int keyPressed;
   @ObfuscatedName("b")
   String targetName;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1236564413
   )
   int field1084;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -646126757
   )
   int type = 76;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "([Ljava/lang/Object;I)V",
      garbageValue = "1401633518"
   )
   public void setArgs(Object[] var1) {
      this.args = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "791254847"
   )
   public void setType(int var1) {
      this.type = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lkd;B)V",
      garbageValue = "-122"
   )
   public void method2255(Widget var1) {
      this.widget = var1;
   }
}
