import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class121 {
   @ObfuscatedName("ac")
   public static final float field1180 = Math.ulp(1.0F);
   @ObfuscatedName("au")
   public static final float field1181;
   @ObfuscatedName("ab")
   static float[] field1183;
   @ObfuscatedName("aq")
   static float[] field1182;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Ldp;"
   )
   static LoginScreenAnimation field1184;
   @ObfuscatedName("gv")
   static String field1185;

   static {
      field1181 = field1180 * 2.0F;
      field1183 = new float[4];
      field1182 = new float[5];
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(B)[Lec;",
      garbageValue = "127"
   )
   static class127[] method721() {
      return new class127[]{class127.field1252, class127.field1254, class127.field1253, class127.field1251, class127.field1271, class127.field1266, class127.field1257, class127.field1258, class127.field1259, class127.field1260, class127.field1261, class127.field1255, class127.field1263, class127.field1256, class127.field1262, class127.field1265, class127.field1264};
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)[Ldk;",
      garbageValue = "1978895221"
   )
   static class85[] method723() {
      return new class85[]{class85.field871, class85.field878, class85.field874, class85.field877, class85.field872};
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "-1"
   )
   static int method719(int var0, Script var1, boolean var2) {
      Widget var3;
      if (var0 >= 2000) {
         var0 -= 1000;
         var3 = class165.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
      } else {
         var3 = var2 ? SoundSystem.scriptDotWidget : class1.scriptActiveWidget;
      }

      String var4 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
      int[] var5 = null;
      if (var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         if (var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var9 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var9.length - 1; var7 >= 1; --var7) {
         if (var4.charAt(var7 - 1) == 's') {
            var9[var7] = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
         } else {
            var9[var7] = new Integer(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         }
      }

      var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
      if (var7 != -1) {
         var9[0] = new Integer(var7);
      } else {
         var9 = null;
      }

      if (var0 == 1400) {
         var3.onClick = var9;
      } else if (var0 == 1401) {
         var3.onHold = var9;
      } else if (var0 == 1402) {
         var3.onRelease = var9;
      } else if (var0 == 1403) {
         var3.onMouseOver = var9;
      } else if (var0 == 1404) {
         var3.onMouseLeave = var9;
      } else if (var0 == 1405) {
         var3.onDrag = var9;
      } else if (var0 == 1406) {
         var3.onTargetLeave = var9;
      } else if (var0 == 1407) {
         var3.onVarTransmit = var9;
         var3.varTransmitTriggers = var5;
      } else if (var0 == 1408) {
         var3.onTimer = var9;
      } else if (var0 == 1409) {
         var3.onOp = var9;
      } else if (var0 == 1410) {
         var3.onDragComplete = var9;
      } else if (var0 == 1411) {
         var3.onClickRepeat = var9;
      } else if (var0 == 1412) {
         var3.onMouseRepeat = var9;
      } else if (var0 == 1414) {
         var3.onInvTransmit = var9;
         var3.invTransmitTriggers = var5;
      } else if (var0 == 1415) {
         var3.onStatTransmit = var9;
         var3.statTransmitTriggers = var5;
      } else if (var0 == 1416) {
         var3.onTargetEnter = var9;
      } else if (var0 == 1417) {
         var3.onScroll = var9;
      } else if (var0 == 1418) {
         var3.onChatTransmit = var9;
      } else if (var0 == 1419) {
         var3.onKey = var9;
      } else if (var0 == 1420) {
         var3.onFriendTransmit = var9;
      } else if (var0 == 1421) {
         var3.onClanTransmit = var9;
      } else if (var0 == 1422) {
         var3.onMiscTransmit = var9;
      } else if (var0 == 1423) {
         var3.onDialogAbort = var9;
      } else if (var0 == 1424) {
         var3.onSubChange = var9;
      } else if (var0 == 1425) {
         var3.onStockTransmit = var9;
      } else if (var0 == 1426) {
         var3.field2998 = var9;
      } else if (var0 == 1427) {
         var3.onResize = var9;
      } else if (var0 == 1428) {
         var3.field2946 = var9;
      } else if (var0 == 1429) {
         var3.field2876 = var9;
      } else if (var0 == 1430) {
         var3.field2988 = var9;
      } else if (var0 == 1431) {
         var3.field2892 = var9;
      } else if (var0 == 1434) {
         var3.field2961 = var9;
      } else if (var0 == 1435) {
         var3.field2984 = var9;
      } else {
         if (var0 < 1436 || var0 > 1439) {
            return 2;
         }

         class312 var8 = var3.method1818();
         if (var8 != null) {
            if (var0 == 1436) {
               var8.field2821 = var9;
            } else if (var0 == 1437) {
               var8.field2826 = var9;
            } else if (var0 == 1438) {
               var8.field2825 = var9;
            } else if (var0 == 1439) {
               var8.field2824 = var9;
            }
         }
      }

      var3.hasListener = true;
      return 1;
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "15"
   )
   static void method724() {
      Client.packetWriter.clearBuffer();
      Client.packetWriter.packetBuffer.offset = 0;
      Client.packetWriter.serverPacket = null;
      Client.packetWriter.field1138 = null;
      Client.packetWriter.field1139 = null;
      Client.packetWriter.field1133 = null;
      Client.packetWriter.serverPacketLength = 0;
      Client.packetWriter.field1136 = 0;
      Client.rebootTimer = 0;
      Client.menuOptionsCount = 0;
      Client.isMenuOpen = false;
      Client.minimapState = 0;
      Client.destinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.players[var0] = null;
      }

      MusicPatchNode.localPlayer = null;

      for(var0 = 0; var0 < Client.npcs.length; ++var0) {
         NPC var1 = Client.npcs[var0];
         if (var1 != null) {
            var1.targetIndex = -1;
            var1.false0 = false;
         }
      }

      ItemContainer.itemContainers = new NodeHashTable(32);
      class138.updateGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field573[var0] = true;
      }

      class1.method4();
   }

    @ObfuscatedName("kd")
    @ObfuscatedSignature(
            descriptor = "(III)V",
            garbageValue = "1957371418"
    )
    static final void updateItemPile(int var0, int var1) {
      NodeDeque var2 = Client.groundItems[GameEngine.Client_plane][var0][var1];
      if (var2 == null) {
         class31.scene.removeGroundItemPile(GameEngine.Client_plane, var0, var1);
      } else {
         long var3 = -99999999L;
         TileItem var5 = null;

         TileItem var6;
         for(var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
            ItemComposition var7 = HealthBarUpdate.ItemDefinition_get(var6.id);
            long var8 = (long)var7.price;
            if (var7.isStackable == 1) {
               var8 *= var6.quantity < Integer.MAX_VALUE ? (long)(var6.quantity + 1) : (long)var6.quantity;
            }

            if (var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if (var5 == null) {
            class31.scene.removeGroundItemPile(GameEngine.Client_plane, var0, var1);
         } else {
            var2.addLast(var5);
            TileItem var12 = null;
            TileItem var11 = null;

            for(var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
               if (var5.id != var6.id) {
                  if (var12 == null) {
                     var12 = var6;
                  }

                  if (var12.id != var6.id && var11 == null) {
                     var11 = var6;
                  }
               }
            }

            long var9 = FaceNormal.calculateTag(var0, var1, 3, false, 0);
            class31.scene.newGroundItemPile(GameEngine.Client_plane, var0, var1, class147.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, GameEngine.Client_plane), var5, var9, var12, var11);
         }
      }
   }

   @ObfuscatedName("lp")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Lmq;S)Ljava/lang/String;",
      garbageValue = "-1115"
   )
   static String method720(String var0, Widget var1) {
      if (var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if (var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = ArchiveLoader.method478(var1, var2 - 1);
               String var5;
               if (var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }
}
