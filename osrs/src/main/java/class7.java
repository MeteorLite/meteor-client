import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class7 {
   @ObfuscatedName("h")
   ExecutorService field9 = Executors.newSingleThreadExecutor();
   @ObfuscatedName("e")
   Future field10;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lqy;"
   )
   final Buffer field11;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lx;"
   )
   final class3 field12;

   @ObfuscatedSignature(
      descriptor = "(Lqy;Lx;)V"
   )
   public class7(Buffer var1, class3 var2) {
      this.field11 = var1;
      this.field12 = var2;
      this.method18();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "10"
   )
   public boolean method21() {
      return this.field10.isDone();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "67"
   )
   public void method17() {
      this.field9.shutdown();
      this.field9 = null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)Lqy;",
      garbageValue = "1313541740"
   )
   public Buffer method20() {
      try {
         return (Buffer)this.field10.get();
      } catch (Exception var2) {
         return null;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "117"
   )
   void method18() {
      this.field10 = this.field9.submit(new class1(this, this.field11, this.field12));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "-831312501"
   )
   static int method19(int var0, Script var1, boolean var2) {
      Widget var3 = ObjTypeCustomisation.getWidget(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
      if (var0 == 2600) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.scrollX;
         return 1;
      } else if (var0 == 2601) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.scrollY;
         return 1;
      } else if (var0 == 2602) {
         Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.text;
         return 1;
      } else if (var0 == 2603) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if (var0 == 2604) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if (var0 == 2605) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if (var0 == 2606) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.modelAngleX;
         return 1;
      } else if (var0 == 2607) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.modelAngleZ;
         return 1;
      } else if (var0 == 2608) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.modelAngleY;
         return 1;
      } else if (var0 == 2609) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.transparencyTop;
         return 1;
      } else if (var0 == 2610) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.transparencyBot;
         return 1;
      } else if (var0 == 2611) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.color;
         return 1;
      } else if (var0 == 2612) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.color2;
         return 1;
      } else if (var0 == 2613) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
         return 1;
      } else if (var0 == 2614) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
         return 1;
      } else {
         class298 var4;
         if (var0 == 2617) {
            var4 = var3.method1748();
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4 != null ? var4.field2800 * 1940747343 * 2140480175 : 0;
         }

         if (var0 == 2618) {
            var4 = var3.method1748();
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4 != null ? var4.field2802 * 50034791 * 1875649367 : 0;
            return 1;
         } else {
            class303 var7;
            if (var0 == 2619) {
               var7 = var3.method1724();
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1647().method1941() : "";
               return 1;
            } else if (var0 == 2620) {
               var4 = var3.method1748();
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var4 != null ? var4.field2801 * -37162831 * -10528687 : 0;
               return 1;
            } else if (var0 == 2621) {
               var7 = var3.method1724();
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7 != null ? var7.method1682() : 0;
               return 1;
            } else if (var0 == 2622) {
               var7 = var3.method1724();
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7 != null ? var7.method1683() : 0;
               return 1;
            } else if (var0 == 2623) {
               var7 = var3.method1724();
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7 != null ? var7.method1708() : 0;
               return 1;
            } else if (var0 == 2624) {
               var7 = var3.method1724();
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7 != null && var7.method1694() ? 1 : 0;
               return 1;
            } else if (var0 != 2625) {
               if (var0 == 2626) {
                  var7 = var3.method1724();
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1676().method1990() : "";
                  return 1;
               } else if (var0 == 2627) {
                  var7 = var3.method1724();
                  int var5 = var7 != null ? var7.method1663() : 0;
                  int var6 = var7 != null ? var7.method1678() : 0;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Math.min(var5, var6);
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Math.max(var5, var6);
                  return 1;
               } else if (var0 == 2628) {
                  var7 = var3.method1724();
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7 != null ? var7.method1678() : 0;
                  return 1;
               } else if (var0 == 2629) {
                  var7 = var3.method1724();
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7 != null ? var7.method1704() : 0;
                  return 1;
               } else if (var0 == 2630) {
                  var7 = var3.method1724();
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7 != null ? var7.method1685() : 0;
                  return 1;
               } else if (var0 == 2631) {
                  var7 = var3.method1724();
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7 != null ? var7.method1686() : 0;
                  return 1;
               } else if (var0 == 2632) {
                  var7 = var3.method1724();
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7 != null ? var7.method1698() : 0;
                  return 1;
               } else {
                  class28 var8;
                  if (var0 == 2633) {
                     var8 = var3.method1737();
                     Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize - 1] = var8 != null ? var8.method103(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize - 1]) : 0;
                     return 1;
                  } else if (var0 == 2634) {
                     var8 = var3.method1737();
                     Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize - 1] = var8 != null ? var8.method105((char)Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize - 1]) : 0;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var7 = var3.method1724();
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7 != null && var7.method1633() ? 1 : 0;
               return 1;
            }
         }
      }
   }

   @ObfuscatedName("ld")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "255"
   )
   static final void method15(int var0) {
      var0 = Math.min(Math.max(var0, 0), 127);
      StructComposition.clientPreferences.updateSoundEffectVolume(var0);
   }

   @ObfuscatedName("la")
   @ObfuscatedSignature(
      descriptor = "(IIII)Lcx;",
      garbageValue = "-413394938"
   )
   @Export("ifOpenSub")
   static final InterfaceParent ifOpenSub(int var0, int var1, int var2) {
      InterfaceParent var3 = new InterfaceParent();
      var3.group = var1;
      var3.type = var2;
      Client.interfaceParents.put(var3, (long)var0);
      class69.Widget_resetModelFrames(var1);
      Widget var4 = ObjTypeCustomisation.getWidget(var0);
      class69.invalidateWidget(var4);
      if (Client.meslayerContinueWidget != null) {
         class69.invalidateWidget(Client.meslayerContinueWidget);
         Client.meslayerContinueWidget = null;
      }

      class169.revalidateWidgetScroll(class71.Widget_interfaceComponents[var0 >> 16], var4, false);
      class31.runWidgetOnLoadListener(var1);
      if (Client.rootInterface != -1) {
         GrandExchangeOfferAgeComparator.runIntfCloseListeners(Client.rootInterface, 1);
      }

      return var3;
   }

   @ObfuscatedName("mi")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1774309040"
   )
   @Export("Clan_leaveChat")
   static final void Clan_leaveChat() {
      PacketBufferNode var0 = class136.getPacketBufferNode(ClientPacket.field2529, Client.packetWriter.isaacCipher);
      var0.packetBuffer.writeByte(0);
      Client.packetWriter.addNode(var0);
   }
}
