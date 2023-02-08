import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("UserComparator9")
public class UserComparator9 extends AbstractUserComparator {
    @ObfuscatedName("vp")
    @ObfuscatedSignature(
            descriptor = "Lpu;"
    )
    static PlatformInfo platformInfo;
    @ObfuscatedName("f")
    final boolean reversed;

   public UserComparator9(boolean var1) {
      this.reversed = var1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Loa;Loa;B)I",
            garbageValue = "-40"
    )
    int compareBuddy(Buddy var1, Buddy var2) {
      if (Client.worldId == var1.world && var2.world == Client.worldId) {
         return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
      } else {
         return this.compareUser(var1, var2);
      }
   }

    @ObfuscatedName("compare")
    public int compare(Object var1, Object var2) {
      return this.compareBuddy((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "-412097374"
   )
   static int method660(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if (var0 >= 2000) {
         var0 -= 1000;
         var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         var4 = class133.getWidget(var3);
      } else {
         var4 = var2 ? Interpreter.scriptDotWidget : class85.scriptActiveWidget;
      }

      if (var0 == 1000) {
         class302.Interpreter_intStackSize -= 4;
         var4.rawX = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
         var4.rawY = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
         var4.xAlignment = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
         var4.yAlignment = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 3];
         LoginScreenAnimation.invalidateWidget(var4);
         Decimator.client.alignWidget(var4);
         if (var3 != -1 && var4.type == 0) {
            AbstractWorldMapData.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var3 >> 16], var4, false);
         }

         return 1;
      } else if (var0 == 1001) {
         class302.Interpreter_intStackSize -= 4;
         var4.rawWidth = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
         var4.rawHeight = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
         var4.widthAlignment = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
         var4.heightAlignment = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 3];
         LoginScreenAnimation.invalidateWidget(var4);
         Decimator.client.alignWidget(var4);
         if (var3 != -1 && var4.type == 0) {
            AbstractWorldMapData.revalidateWidgetScroll(WorldMapLabel.Widget_interfaceComponents[var3 >> 16], var4, false);
         }

         return 1;
      } else if (var0 == 1003) {
         boolean var5 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
         if (var5 != var4.isHidden) {
            var4.isHidden = var5;
            LoginScreenAnimation.invalidateWidget(var4);
         }

         return 1;
      } else if (var0 == 1005) {
         var4.noClickThrough = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
         return 1;
      } else if (var0 == 1006) {
         var4.noScrollThrough = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "16777215"
   )
   static final void method657(String var0) {
      Decimator.method306("Please remove " + var0 + " from your friend list first");
   }

    @ObfuscatedName("kv")
    @ObfuscatedSignature(
            descriptor = "(Lkz;III)V",
            garbageValue = "1549726934"
    )
    static final void clickWidget(Widget var0, int var1, int var2) {
      if (Client.clickedWidget == null && !Client.isMenuOpen) {
         if (var0 != null && WallDecoration.method1306(var0) != null) {
            Client.clickedWidget = var0;
            Client.clickedWidgetParent = WallDecoration.method1306(var0);
            Client.widgetClickX = var1;
            Client.widgetClickY = var2;
            class27.widgetDragDuration = 0;
            Client.isDraggingWidget = false;
            int var3 = Client.menuOptionsCount - 1;
            if (var3 != -1) {
               class33.method131(var3);
            }

         }
      }
   }
}
