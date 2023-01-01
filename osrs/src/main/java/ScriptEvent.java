import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class ScriptEvent extends Node {
   @ObfuscatedName("vk")
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
   int mouseX;
   @ObfuscatedName("m")
   int mouseY;
   @ObfuscatedName("q")
   int opIndex;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   Widget dragTarget;
   @ObfuscatedName("r")
   int keyTyped;
   @ObfuscatedName("u")
   int keyPressed;
   @ObfuscatedName("b")
   String targetName;
   @ObfuscatedName("j")
   int field1084;
   @ObfuscatedName("g")
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
