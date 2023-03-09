import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qx")
public class class422 {
   @ObfuscatedName("aj")
   float field3754;
   @ObfuscatedName("al")
   float field3759;
   @ObfuscatedName("ac")
   float field3750;
   @ObfuscatedName("ab")
   float field3751;
   @ObfuscatedName("an")
   float field3752;
   @ObfuscatedName("ao")
   float field3753;
   @ObfuscatedName("av")
   float field3748;
   @ObfuscatedName("aq")
   float field3755;
   @ObfuscatedName("ap")
   float field3756;
   @ObfuscatedName("ar")
   float field3757;
   @ObfuscatedName("ak")
   float field3749;
   @ObfuscatedName("ax")
   float field3758;

   static {
      new class422();
   }

   class422() {
      this.method2202();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1933719764"
   )
   void method2202() {
      this.field3758 = 0.0F;
      this.field3749 = 0.0F;
      this.field3757 = 0.0F;
      this.field3755 = 0.0F;
      this.field3748 = 0.0F;
      this.field3753 = 0.0F;
      this.field3751 = 0.0F;
      this.field3750 = 0.0F;
      this.field3759 = 0.0F;
      this.field3756 = 1.0F;
      this.field3752 = 1.0F;
      this.field3754 = 1.0F;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(FI)V",
      garbageValue = "-1117453232"
   )
   void method2203(float var1) {
      float var2 = (float)Math.cos((double)var1);
      float var3 = (float)Math.sin((double)var1);
      float var4 = this.field3759;
      float var5 = this.field3752;
      float var6 = this.field3755;
      float var7 = this.field3749;
      this.field3759 = var2 * var4 - this.field3750 * var3;
      this.field3750 = var2 * this.field3750 + var4 * var3;
      this.field3752 = var2 * var5 - var3 * this.field3753;
      this.field3753 = var2 * this.field3753 + var5 * var3;
      this.field3755 = var6 * var2 - this.field3756 * var3;
      this.field3756 = var6 * var3 + this.field3756 * var2;
      this.field3749 = var2 * var7 - var3 * this.field3758;
      this.field3758 = var2 * this.field3758 + var7 * var3;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(FI)V",
      garbageValue = "-1895738714"
   )
   void method2204(float var1) {
      float var2 = (float)Math.cos((double)var1);
      float var3 = (float)Math.sin((double)var1);
      float var4 = this.field3754;
      float var5 = this.field3751;
      float var6 = this.field3748;
      float var7 = this.field3757;
      this.field3754 = var2 * var4 + var3 * this.field3750;
      this.field3750 = this.field3750 * var2 - var4 * var3;
      this.field3751 = var3 * this.field3753 + var5 * var2;
      this.field3753 = var2 * this.field3753 - var5 * var3;
      this.field3748 = this.field3756 * var3 + var6 * var2;
      this.field3756 = var2 * this.field3756 - var6 * var3;
      this.field3757 = this.field3758 * var3 + var2 * var7;
      this.field3758 = this.field3758 * var2 - var7 * var3;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(FI)V",
      garbageValue = "-1995207939"
   )
   void method2205(float var1) {
      float var2 = (float)Math.cos((double)var1);
      float var3 = (float)Math.sin((double)var1);
      float var4 = this.field3754;
      float var5 = this.field3751;
      float var6 = this.field3748;
      float var7 = this.field3757;
      this.field3754 = var2 * var4 - var3 * this.field3759;
      this.field3759 = var3 * var4 + this.field3759 * var2;
      this.field3751 = var5 * var2 - this.field3752 * var3;
      this.field3752 = var3 * var5 + var2 * this.field3752;
      this.field3748 = var6 * var2 - this.field3755 * var3;
      this.field3755 = this.field3755 * var2 + var6 * var3;
      this.field3757 = var2 * var7 - var3 * this.field3749;
      this.field3749 = var7 * var3 + this.field3749 * var2;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(FFFI)V",
      garbageValue = "-446919774"
   )
   void method2206(float var1, float var2, float var3) {
      this.field3757 += var1;
      this.field3749 += var2;
      this.field3758 += var3;
   }

   @Export("toString")
   @ObfuscatedName("toString")
   public String toString() {
      return this.field3754 + "," + this.field3751 + "," + this.field3748 + "," + this.field3757 + "\n" + this.field3759 + "," + this.field3752 + "," + this.field3755 + "," + this.field3749 + "\n" + this.field3750 + "," + this.field3753 + "," + this.field3756 + "," + this.field3758;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "-31"
   )
   static int method2207(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if (var0 >= 2000) {
         var0 -= 1000;
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         var4 = WorldMapSection1.getWidget(var3);
      } else {
         var4 = var2 ? GameObject.scriptDotWidget : SoundSystem.scriptActiveWidget;
      }

      if (var0 == 1000) {
         Interpreter.Interpreter_intStackSize -= 4;
         var4.rawX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4.rawY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         var4.xAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         var4.yAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         class69.invalidateWidget(var4);
         class392.client.alignWidget(var4);
         if (var3 != -1 && var4.type == 0) {
            class278.revalidateWidgetScroll(class155.Widget_interfaceComponents[var3 >> 16], var4, false);
         }

         return 1;
      } else if (var0 == 1001) {
         Interpreter.Interpreter_intStackSize -= 4;
         var4.rawWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4.rawHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         var4.widthAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         var4.heightAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         class69.invalidateWidget(var4);
         class392.client.alignWidget(var4);
         if (var3 != -1 && var4.type == 0) {
            class278.revalidateWidgetScroll(class155.Widget_interfaceComponents[var3 >> 16], var4, false);
         }

         return 1;
      } else if (var0 == 1003) {
         boolean var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         if (var5 != var4.isHidden) {
            var4.isHidden = var5;
            class69.invalidateWidget(var4);
         }

         return 1;
      } else if (var0 == 1005) {
         var4.noClickThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         return 1;
      } else if (var0 == 1006) {
         var4.noScrollThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }
}
