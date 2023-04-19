import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ol")
public class class370 {
   @ObfuscatedName("af")
   static char[] field3593 = new char[64];
   @ObfuscatedName("an")
   static char[] field3591;
   @ObfuscatedName("aw")
   static char[] field3592;
   @ObfuscatedName("ac")
   static int[] field3594;
    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            descriptor = "[Lsj;"
    )
    public static BufferedFile[] JagexCache_idxFiles;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3593[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3593[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3593[var0] = (char)(var0 + 48 - 52);
      }

      field3593[62] = '+';
      field3593[63] = '/';
      field3591 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3591[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3591[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3591[var0] = (char)(var0 + 48 - 52);
      }

      field3591[62] = '*';
      field3591[63] = '-';
      field3592 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3592[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3592[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3592[var0] = (char)(var0 + 48 - 52);
      }

      field3592[62] = '-';
      field3592[63] = '_';
      field3594 = new int[128];

      for(var0 = 0; var0 < field3594.length; ++var0) {
         field3594[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3594[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3594[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3594[var0] = var0 - 48 + 52;
      }

      int[] var2 = field3594;
      field3594[43] = 62;
      var2[42] = 62;
      int[] var1 = field3594;
      field3594[47] = 63;
      var1[45] = 63;
   }

    @ObfuscatedName("mm")
    @ObfuscatedSignature(
            descriptor = "(Lmq;III)V",
            garbageValue = "-1880681871"
    )
    static final void clickWidget(Widget var0, int var1, int var2) {
      if (Client.clickedWidget == null && !Client.isMenuOpen) {
         if (var0 != null) {
            Widget var5 = var0;
            int var6 = StructComposition.method1071(KeyHandler.getWidgetFlags(var0));
            Widget var4;
            int var7;
            if (var6 == 0) {
               var4 = null;
            } else {
               var7 = 0;

               while(true) {
                  if (var7 >= var6) {
                     var4 = var5;
                     break;
                  }

                  var5 = class165.getWidget(var5.parentId);
                  if (var5 == null) {
                     var4 = null;
                     break;
                  }

                  ++var7;
               }
            }

            Widget var8 = var4;
            if (var4 == null) {
               var8 = var0.parent;
            }

            if (var8 != null) {
               Client.clickedWidget = var0;
               var5 = var0;
               var6 = StructComposition.method1071(KeyHandler.getWidgetFlags(var0));
               if (var6 == 0) {
                  var4 = null;
               } else {
                  var7 = 0;

                  while(true) {
                     if (var7 >= var6) {
                        var4 = var5;
                        break;
                     }

                     var5 = class165.getWidget(var5.parentId);
                     if (var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var7;
                  }
               }

               var8 = var4;
               if (var4 == null) {
                  var8 = var0.parent;
               }

               Client.clickedWidgetParent = var8;
               Client.widgetClickX = var1;
               Client.widgetClickY = var2;
               class96.widgetDragDuration = 0;
               Client.isDraggingWidget = false;
               int var9 = DynamicObject.method461();
               if (var9 != -1) {
                  ZoneOperation.method1597(var9);
               }

               return;
            }
         }

      }
   }
}
