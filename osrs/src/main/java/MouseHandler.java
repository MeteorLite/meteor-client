import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("MouseHandler")
public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener {
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Lbd;"
    )
    public static MouseHandler MouseHandler_instance = new MouseHandler();
    @ObfuscatedName("au")
    public static volatile int MouseHandler_idleCycles = 0;
    @ObfuscatedName("ab")
    public static volatile int MouseHandler_currentButtonVolatile = 0;
    @ObfuscatedName("aq")
    public static volatile int MouseHandler_xVolatile = -1;
    @ObfuscatedName("al")
    public static volatile int MouseHandler_yVolatile = -1;
    @ObfuscatedName("at")
    public static volatile long MouseHandler_lastMovedVolatile = -1L;
    @ObfuscatedName("aa")
    public static int MouseHandler_currentButton = 0;
    @ObfuscatedName("ay")
    public static int MouseHandler_x = 0;
    @ObfuscatedName("ao")
    public static int MouseHandler_y = 0;
    @ObfuscatedName("ax")
    public static long MouseHandler_millis = 0L;
    @ObfuscatedName("ai")
    public static volatile int MouseHandler_lastButtonVolatile = 0;
    @ObfuscatedName("ag")
    public static volatile int MouseHandler_lastPressedXVolatile = 0;
    @ObfuscatedName("ah")
    public static volatile int MouseHandler_lastPressedYVolatile = 0;
    @ObfuscatedName("av")
    public static volatile long MouseHandler_lastPressedTimeMillisVolatile = 0L;
    @ObfuscatedName("ar")
    public static int MouseHandler_lastButton = 0;
    @ObfuscatedName("am")
    public static int MouseHandler_lastPressedX = 0;
    @ObfuscatedName("as")
    public static int MouseHandler_lastPressedY = 0;
    @ObfuscatedName("aj")
    public static long MouseHandler_lastPressedTimeMillis = 0L;
    @ObfuscatedName("sx")
    @ObfuscatedSignature(
            descriptor = "Lgj;"
    )
    static ClanChannel guestClanChannel;

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(Ljava/awt/event/MouseEvent;B)I",
            garbageValue = "-121"
    )
    final int getButton(MouseEvent var1) {
      int var2 = var1.getButton();
      if (!var1.isAltDown() && var2 != 2) {
         return !var1.isMetaDown() && var2 != 3 ? 1 : 2;
      } else {
         return 4;
      }
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_xVolatile = var1.getX();
         MouseHandler_yVolatile = var1.getY();
         MouseHandler_lastMovedVolatile = var1.getWhen();
      }

   }

    @ObfuscatedName("mousePressed")
    public final synchronized void mousePressed(MouseEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_lastPressedXVolatile = var1.getX();
         MouseHandler_lastPressedYVolatile = var1.getY();
         MouseHandler_lastPressedTimeMillisVolatile = class96.clockNow();
         MouseHandler_lastButtonVolatile = this.getButton(var1);
         if (MouseHandler_lastButtonVolatile != 0) {
            MouseHandler_currentButtonVolatile = MouseHandler_lastButtonVolatile;
         }
      }

      if (var1.isPopupTrigger()) {
         var1.consume();
      }

   }

    @ObfuscatedName("mouseReleased")
    public final synchronized void mouseReleased(MouseEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_currentButtonVolatile = 0;
      }

      if (var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_xVolatile = -1;
         MouseHandler_yVolatile = -1;
         MouseHandler_lastMovedVolatile = var1.getWhen();
      }

   }

    @ObfuscatedName("mouseClicked")
    public final void mouseClicked(MouseEvent var1) {
      if (var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if (MouseHandler_instance != null) {
         MouseHandler_currentButtonVolatile = 0;
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      this.mouseMoved(var1);
   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      this.mouseMoved(var1);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "-2111294595"
   )
   public static boolean method195(char var0) {
      if ((var0 < ' ' || var0 >= 127) && (var0 <= 127 || var0 >= 160) && (var0 <= 160 || var0 > 255)) {
         if (var0 != 0) {
            char[] var1 = class369.cp1252AsciiExtension;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if (var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "-15"
   )
   static int method194(int var0, Script var1, boolean var2) {
      Widget var3 = class165.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
      if (var0 == 2600) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollX;
         return 1;
      } else if (var0 == 2601) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollY;
         return 1;
      } else if (var0 == 2602) {
         Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3.text;
         return 1;
      } else if (var0 == 2603) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if (var0 == 2604) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if (var0 == 2605) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if (var0 == 2606) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleX;
         return 1;
      } else if (var0 == 2607) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleZ;
         return 1;
      } else if (var0 == 2608) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelAngleY;
         return 1;
      } else if (var0 == 2609) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyTop;
         return 1;
      } else if (var0 == 2610) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.transparencyBot;
         return 1;
      } else if (var0 == 2611) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color;
         return 1;
      } else if (var0 == 2612) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.color2;
         return 1;
      } else if (var0 == 2613) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
         return 1;
      } else if (var0 == 2614) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
         return 1;
      } else {
         class309 var4;
         if (var0 == 2617) {
            var4 = var3.method1817();
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 != null ? var4.field2818 * -90398499 * 202848117 : 0;
         }

         if (var0 == 2618) {
            var4 = var3.method1817();
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 != null ? var4.field2816 * 216034339 * -1464228981 : 0;
            return 1;
         } else {
            class314 var7;
            if (var0 == 2619) {
               var7 = var3.method1815();
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1741().method2007() : "";
               return 1;
            } else if (var0 == 2620) {
               var4 = var3.method1817();
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 != null ? var4.field2817 * -1652794843 * 1912484269 : 0;
               return 1;
            } else if (var0 == 2621) {
               var7 = var3.method1815();
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1749() : 0;
               return 1;
            } else if (var0 == 2622) {
               var7 = var3.method1815();
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1783() : 0;
               return 1;
            } else if (var0 == 2623) {
               var7 = var3.method1815();
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1716() : 0;
               return 1;
            } else if (var0 == 2624) {
               var7 = var3.method1815();
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null && var7.method1743() ? 1 : 0;
               return 1;
            } else if (var0 != 2625) {
               if (var0 == 2626) {
                  var7 = var3.method1815();
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1742().method2083() : "";
                  return 1;
               } else if (var0 == 2627) {
                  var7 = var3.method1815();
                  int var5 = var7 != null ? var7.method1747() : 0;
                  int var6 = var7 != null ? var7.method1746() : 0;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Math.min(var5, var6);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Math.max(var5, var6);
                  return 1;
               } else if (var0 == 2628) {
                  var7 = var3.method1815();
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1746() : 0;
                  return 1;
               } else if (var0 == 2629) {
                  var7 = var3.method1815();
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1751() : 0;
                  return 1;
               } else if (var0 == 2630) {
                  var7 = var3.method1815();
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1752() : 0;
                  return 1;
               } else if (var0 == 2631) {
                  var7 = var3.method1815();
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1753() : 0;
                  return 1;
               } else if (var0 == 2632) {
                  var7 = var3.method1815();
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null ? var7.method1754() : 0;
                  return 1;
               } else {
                  class27 var8;
                  if (var0 == 2633) {
                     var8 = var3.method1795();
                     Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = var8 != null ? var8.method116(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]) : 0;
                     return 1;
                  } else if (var0 == 2634) {
                     var8 = var3.method1795();
                     Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = var8 != null ? var8.method117((char)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]) : 0;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var7 = var3.method1815();
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7 != null && var7.method1744() ? 1 : 0;
               return 1;
            }
         }
      }
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-372100645"
   )
   static int method191() {
      if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
         int var0 = 0;

         for(int var1 = 0; var1 <= Client.archiveLoadersDone; ++var1) {
            var0 += ((ArchiveLoader)Client.archiveLoaders.get(var1)).loadedCount;
         }

         return var0 * 10000 / Client.field397;
      } else {
         return 10000;
      }
   }

    @ObfuscatedName("ib")
    @ObfuscatedSignature(
            descriptor = "(Ldv;ZI)V",
            garbageValue = "-1861126010"
    )
    static void addPlayerToScene(Player var0, boolean var1) {
      if (var0 != null && var0.isVisible() && !var0.isHidden) {
         var0.isUnanimated = false;
         if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.idleSequence == var0.movementSequence) {
            var0.isUnanimated = true;
         }

         int var2 = var0.x >> 7;
         int var3 = var0.y >> 7;
         if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
            long var4 = FaceNormal.calculateTag(0, 0, 0, false, var0.index);
            if (var0.attachedModel != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
               var0.isUnanimated = false;
               var0.tileHeight = class147.getTileHeight(var0.x, var0.y, GameEngine.Client_plane);
               var0.playerCycle = Client.cycle;
               class31.scene.addNullableObject(GameEngine.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.minX, var0.minY, var0.maxX, var0.maxY);
            } else {
               if ((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
                     return;
                  }

                  Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
               }

               var0.tileHeight = class147.getTileHeight(var0.x, var0.y, GameEngine.Client_plane);
               var0.playerCycle = Client.cycle;
               class31.scene.drawEntity(GameEngine.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.isWalking);
            }
         }
      }

   }

   @ObfuscatedName("mr")
   @ObfuscatedSignature(
      descriptor = "(Lmq;I)V",
      garbageValue = "1973631354"
   )
   static final void method193(Widget var0) {
      int var1 = var0.contentType;
      if (var1 == 324) {
         if (Client.field639 == -1) {
            Client.field639 = var0.spriteId2;
            Client.field640 = var0.spriteId;
         }

         if (Client.playerAppearance.field2840 == 1) {
            var0.spriteId2 = Client.field639;
         } else {
            var0.spriteId2 = Client.field640;
         }

      } else if (var1 == 325) {
         if (Client.field639 == -1) {
            Client.field639 = var0.spriteId2;
            Client.field640 = var0.spriteId;
         }

         if (Client.playerAppearance.field2840 == 1) {
            var0.spriteId2 = Client.field640;
         } else {
            var0.spriteId2 = Client.field639;
         }

      } else if (var1 == 327) {
         var0.modelAngleX = 150;
         var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if (var1 == 328) {
         var0.modelAngleX = 150;
         var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
