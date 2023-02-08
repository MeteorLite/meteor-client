import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public enum class135 implements class349 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Leq;"
   )
   field1286(2, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Leq;"
   )
   field1283(4, 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Leq;"
   )
   field1284(0, 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Leq;"
   )
   field1285(3, 3),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Leq;"
   )
   field1290(1, 4);

   @ObfuscatedName("uq")
   static int field1289;
   @ObfuscatedName("j")
   public final int field1287;
    @ObfuscatedName("i")
    final int id;

   class135(int var3, int var4) {
      this.field1287 = var3;
      this.id = var4;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.id;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(III)Lkz;",
            garbageValue = "-1176907573"
    )
    public static Widget getWidgetChild(int var0, int var1) {
      Widget var2 = class133.getWidget(var0);
      if (var1 == -1) {
         return var2;
      } else {
         return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)[Lch;",
      garbageValue = "381687737"
   )
   static class85[] method736() {
      return new class85[]{class85.field875, class85.field878, class85.field874, class85.field876, class85.field881};
   }

    @ObfuscatedName("kd")
    @ObfuscatedSignature(
            descriptor = "([Lkz;IB)V",
            garbageValue = "10"
    )
    static final void runComponentCloseListeners(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if (var3 != null) {
            if (var3.type == 0) {
               if (var3.children != null) {
                  runComponentCloseListeners(var3.children, var1);
               }

               InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
               if (var4 != null) {
                  class147.runIntfCloseListeners(var4.group, var1);
               }
            }

            ScriptEvent var5;
            if (var1 == 0 && var3.onDialogAbort != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.args = var3.onDialogAbort;
               WorldMapAreaData.runScriptEvent(var5);
            }

            if (var1 == 1 && var3.onSubChange != null) {
               if (var3.childIndex >= 0) {
                  Widget var6 = class133.getWidget(var3.id);
                  if (var6 == null || var6.children == null || var3.childIndex >= var6.children.length || var3 != var6.children[var3.childIndex]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.args = var3.onSubChange;
               WorldMapAreaData.runScriptEvent(var5);
            }
         }
      }

   }
}
