import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("my")
public class class335 {
    @ObfuscatedName("au")
    public static File cacheDir;
   @ObfuscatedName("ah")
   static int field3093;

   static {
      int var0 = 0;
      int var1 = 0;
      class330[] var2 = class4.method7();

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class330 var4 = var2[var3];
         if (var4.field3073 > var0) {
            var0 = var4.field3073;
         }

         if (var4.field3074 > var1) {
            var1 = var4.field3074;
         }
      }

   }

   @ObfuscatedName("lo")
   @ObfuscatedSignature(
      descriptor = "(Lmq;I)V",
      garbageValue = "-478627331"
   )
   static final void method1851(Widget var0) {
      String var1;
      int var2;
      int var3;
      if (var0.buttonType == 1) {
         var1 = var0.buttonText;
         var2 = var0.id;
         var3 = var0.itemId;
         SceneTilePaint.insertMenuItem(var1, "", 24, 0, 0, var2, var3, false);
      }

      if (var0.buttonType == 2 && !Client.isSpellSelected) {
         var1 = MusicPatchNode.Widget_getSpellActionName(var0);
         if (var1 != null) {
            class138.method796(var1, class383.colorStartTag(65280) + var0.field3004, 25, 0, -1, var0.id, var0.itemId);
         }
      }

      if (var0.buttonType == 3) {
         MenuAction.insertMenuItemNoShift("Close", "", 26, 0, 0, var0.id);
      }

      if (var0.buttonType == 4) {
         MenuAction.insertMenuItemNoShift(var0.buttonText, "", 28, 0, 0, var0.id);
      }

      if (var0.buttonType == 5) {
         MenuAction.insertMenuItemNoShift(var0.buttonText, "", 29, 0, 0, var0.id);
      }

      if (var0.buttonType == 6 && Client.meslayerContinueWidget == null) {
         MenuAction.insertMenuItemNoShift(var0.buttonText, "", 30, 0, -1, var0.id);
      }

      if (var0.isIf3) {
         if (Client.isSpellSelected) {
            if (ScriptEvent.method492(KeyHandler.getWidgetFlags(var0)) && (SecureRandomFuture.selectedSpellFlags & 32) == 32) {
               class138.method796(Client.field530, Client.field522 + " " + "->" + " " + var0.dataText, 58, 0, var0.childIndex, var0.id, var0.itemId);
            }
         } else {
            for(int var6 = 9; var6 >= 5; --var6) {
               int var4 = KeyHandler.getWidgetFlags(var0);
               boolean var11 = (var4 >> var6 + 1 & 1) != 0;
               String var7;
               if (!var11 && var0.onOp == null) {
                  var7 = null;
               } else if (var0.actions != null && var0.actions.length > var6 && var0.actions[var6] != null && var0.actions[var6].trim().length() != 0) {
                  var7 = var0.actions[var6];
               } else {
                  var7 = null;
               }

               if (var7 != null) {
                  class138.method796(var7, var0.dataText, 1007, var6 + 1, var0.childIndex, var0.id, var0.itemId);
               }
            }

            var1 = MusicPatchNode.Widget_getSpellActionName(var0);
            if (var1 != null) {
               class138.method796(var1, var0.dataText, 25, 0, var0.childIndex, var0.id, var0.itemId);
            }

            for(var2 = 4; var2 >= 0; --var2) {
               int var5 = KeyHandler.getWidgetFlags(var0);
               boolean var12 = (var5 >> var2 + 1 & 1) != 0;
               String var8;
               if (!var12 && var0.onOp == null) {
                  var8 = null;
               } else if (var0.actions != null && var0.actions.length > var2 && var0.actions[var2] != null && var0.actions[var2].trim().length() != 0) {
                  var8 = var0.actions[var2];
               } else {
                  var8 = null;
               }

               if (var8 != null) {
                  SceneTilePaint.insertMenuItem(var8, var0.dataText, 57, var2 + 1, var0.childIndex, var0.id, var0.itemId, var0.prioritizeMenuEntry);
               }
            }

            var3 = KeyHandler.getWidgetFlags(var0);
            boolean var10 = (var3 & 1) != 0;
            if (var10) {
               MenuAction.insertMenuItemNoShift("Continue", "", 30, 0, var0.childIndex, var0.id);
            }
         }
      }

   }
}
