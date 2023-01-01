import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
public class MusicPatchNode extends Node {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1405159971
   )
   int field3427;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lkl;"
   )
   MusicPatch patch;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Laf;"
   )
   RawSound rawSound;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Ljy;"
   )
   MusicPatchNode2 field3428;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -632852283
   )
   int field3418;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 641391177
   )
   int field3419;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -529495939
   )
   int field3423;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -504007495
   )
   int field3421;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1627034491
   )
   int field3422;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 742573521
   )
   int field3414;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1904955935
   )
   int field3424;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2065414593
   )
   int field3425;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -272808679
   )
   int field3420;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1342299511
   )
   int field3416;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1756880989
   )
   int field3415;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -524220702
   )
   int field3429;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -894231501
   )
   int field3430;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -146245059
   )
   int field3431;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "Lap;"
   )
   RawPcmStream stream;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1397627135
   )
   int field3433;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1978134147
   )
   int field3434;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1866464890"
   )
   void method5787() {
      this.patch = null;
      this.rawSound = null;
      this.field3428 = null;
      this.stream = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZS)I",
      garbageValue = "11174"
   )
   static int method5788(int var0, Script var1, boolean var2) {
      Widget var3;
      if (var0 >= 2000) {
         var0 -= 1000;
         var3 = ObjTypeCustomisation.getWidget(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
      } else {
         var3 = var2 ? class190.scriptDotWidget : class360.scriptActiveWidget;
      }

      String var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
      int[] var5 = null;
      if (var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
         int var6 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         if (var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var9 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var9.length - 1; var7 >= 1; --var7) {
         if (var4.charAt(var7 - 1) == 's') {
            var9[var7] = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
         } else {
            var9[var7] = new Integer(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
         }
      }

      var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
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
         var3.field3567 = var9;
      } else if (var0 == 1427) {
         var3.onResize = var9;
      } else if (var0 == 1428) {
         var3.field3553 = var9;
      } else if (var0 == 1429) {
         var3.field3663 = var9;
      } else if (var0 == 1430) {
         var3.field3658 = var9;
      } else if (var0 == 1431) {
         var3.field3653 = var9;
      } else if (var0 == 1434) {
         var3.field3670 = var9;
      } else if (var0 == 1435) {
         var3.field3654 = var9;
      } else {
         if (var0 < 1436 || var0 > 1439) {
            return 2;
         }

         class301 var8 = var3.method6185();
         if (var8 != null) {
            if (var0 == 1436) {
               var8.field3467 = var9;
            } else if (var0 == 1437) {
               var8.field3468 = var9;
            } else if (var0 == 1438) {
               var8.field3465 = var9;
            } else if (var0 == 1439) {
               var8.field3469 = var9;
            }
         }
      }

      var3.hasListener = true;
      return 1;
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      descriptor = "(IZZZZI)Lln;",
      garbageValue = "243666843"
   )
   static Archive newArchive(int var0, boolean var1, boolean var2, boolean var3, boolean var4) {
      ArchiveDisk var5 = null;
      if (JagexCache.JagexCache_dat2File != null) {
         var5 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idxFiles[var0], 1000000);
      }

      return new Archive(var5, WorldMapArea.masterDisk, var0, var1, var2, var3, var4);
   }
}
