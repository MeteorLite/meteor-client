import java.util.Comparator;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
class class18 implements Comparator {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   public static AbstractArchive HitSplatDefinition_archive;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lj;"
   )
   @ObfuscatedName("this$0")
   final class10 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lj;)V"
   )
   class18(class10 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Ljava/util/Map$Entry;Ljava/util/Map$Entry;B)I",
      garbageValue = "-60"
   )
   int method58(Entry var1, Entry var2) {
      return ((Float)var2.getValue()).compareTo((Float)var1.getValue());
   }

   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.method58((Entry)var1, (Entry)var2);
   }

   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IIIB)I",
      garbageValue = "42"
   )
   public static int method60(int var0, int var1, int var2) {
      var2 &= 3;
      if (var2 == 0) {
         return var1;
      } else if (var2 == 1) {
         return 7 - var0;
      } else {
         return var2 == 2 ? 7 - var1 : var0;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "801580605"
   )
   static int method61(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if (var2 == null) {
         return -1;
      } else {
         return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "1"
   )
   public static int method63(int var0) {
      return var0 != 0 && var0 != 1 ? -1 : 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(Lkd;I[B[BB)V",
      garbageValue = "120"
   )
   static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
      if (var0.field2946 == null) {
         if (var2 == null) {
            return;
         }

         var0.field2946 = new byte[11][];
         var0.field2947 = new byte[11][];
         var0.field2954 = new int[11];
         var0.field2949 = new int[11];
      }

      var0.field2946[var1] = var2;
      if (var2 != null) {
         var0.field2945 = true;
      } else {
         var0.field2945 = false;

         for(int var4 = 0; var4 < var0.field2946.length; ++var4) {
            if (var0.field2946[var4] != null) {
               var0.field2945 = true;
               break;
            }
         }
      }

      var0.field2947[var1] = var3;
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      descriptor = "(Lln;Ljava/lang/String;I)V",
      garbageValue = "-156913966"
   )
   static void method59(Archive var0, String var1) {
      ArchiveLoader var2 = new ArchiveLoader(var0, var1);
      Client.archiveLoaders.add(var2);
      Client.field649 += var2.groupCount;
   }

   @ObfuscatedName("lg")
   @ObfuscatedSignature(
      descriptor = "(Lkd;III)V",
      garbageValue = "-1041605206"
   )
   static final void clickWidget(Widget var0, int var1, int var2) {
      if (Client.clickedWidget == null && !Client.isMenuOpen) {
         if (var0 != null && class306.method1753(var0) != null) {
            Client.clickedWidget = var0;
            Client.clickedWidgetParent = class306.method1753(var0);
            Client.widgetClickX = var1;
            Client.widgetClickY = var2;
            class87.widgetDragDuration = 0;
            Client.isDraggingWidget = false;
            int var3 = Client.menuOptionsCount - 1;
            if (var3 != -1) {
               ReflectionCheck.method187(var3);
            }

         }
      }
   }

   @ObfuscatedName("ly")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-53673761"
   )
   static final void method64(int var0) {
      var0 = Math.min(Math.max(var0, 0), 127);
      StructComposition.clientPreferences.method545(var0);
   }
}
