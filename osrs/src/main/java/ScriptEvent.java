import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("vk")
   @Export("foundItemIdCount")
   static int foundItemIdCount;
   @ObfuscatedName("h")
   @Export("args")
   Object[] args;
   @ObfuscatedName("e")
   @Export("isMouseInputEvent")
   boolean isMouseInputEvent;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("x")
   @Export("mouseX")
   int mouseX;
   @ObfuscatedName("m")
   @Export("mouseY")
   int mouseY;
   @ObfuscatedName("q")
   @Export("opIndex")
   int opIndex;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   @Export("dragTarget")
   Widget dragTarget;
   @ObfuscatedName("r")
   @Export("keyTyped")
   int keyTyped;
   @ObfuscatedName("u")
   @Export("keyPressed")
   int keyPressed;
   @ObfuscatedName("b")
   @Export("targetName")
   String targetName;
   @ObfuscatedName("j")
   int field851;
   @ObfuscatedName("g")
   @Export("type")
   int type = 76;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "([Ljava/lang/Object;I)V",
      garbageValue = "1401633518"
   )
   @Export("setArgs")
   public void setArgs(Object[] var1) {
      this.args = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "953044520"
   )
   @Export("setType")
   public void setType(int var1) {
      this.type = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lkd;B)V",
      garbageValue = "-122"
   )
   public void method475(Widget var1) {
      this.widget = var1;
   }
}
