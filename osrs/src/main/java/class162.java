import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class162 extends class155 {
   @ObfuscatedName("f")
   String field1407;
   @ObfuscatedName("w")
   byte field1405;
   @ObfuscatedName("v")
   byte field1406;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfn;"
   )
   final class156 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfn;)V"
   )
   class162(class156 var1) {
      this.this$0 = var1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;B)V",
            garbageValue = "-123"
    )
    void vmethod3238(Buffer var1) {
      this.field1407 = var1.readStringCp1252NullTerminatedOrNull();
      if (this.field1407 != null) {
         var1.readUnsignedByte();
         this.field1405 = var1.readByte();
         this.field1406 = var1.readByte();
      }

   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Lfm;I)V",
            garbageValue = "127147356"
    )
    void vmethod3239(ClanChannel var1) {
      var1.name = this.field1407;
      if (this.field1407 != null) {
         var1.field1396 = this.field1405;
         var1.field1397 = this.field1406;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "-1856713774"
   )
   static int method860(int var0, Script var1, boolean var2) {
      Widget var3 = var2 ? Interpreter.scriptDotWidget : class85.scriptActiveWidget;
      if (var0 == 1600) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.scrollX;
         return 1;
      } else if (var0 == 1601) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.scrollY;
         return 1;
      } else {
         class307 var7;
         if (var0 == 1602) {
            if (var3.type == 12) {
               var7 = var3.method1750();
               if (var7 != null) {
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var7.method1678().method1941();
                  return 1;
               }
            }

            Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3.text;
            return 1;
         } else if (var0 == 1603) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.scrollWidth;
            return 1;
         } else if (var0 == 1604) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.scrollHeight;
            return 1;
         } else if (var0 == 1605) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.modelZoom;
            return 1;
         } else if (var0 == 1606) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.modelAngleX;
            return 1;
         } else if (var0 == 1607) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.modelAngleZ;
            return 1;
         } else if (var0 == 1608) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.modelAngleY;
            return 1;
         } else if (var0 == 1609) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.transparencyTop;
            return 1;
         } else if (var0 == 1610) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.transparencyBot;
            return 1;
         } else if (var0 == 1611) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.color;
            return 1;
         } else if (var0 == 1612) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.color2;
            return 1;
         } else if (var0 == 1613) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
            return 1;
         } else if (var0 == 1614) {
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
            return 1;
         } else {
            class302 var4;
            if (var0 == 1617) {
               var4 = var3.method1745();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4 != null ? var4.field2794 * 1058580729 * -1366058679 : 0;
            }

            if (var0 == 1618) {
               var4 = var3.method1745();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4 != null ? var4.field2797 * 2101478585 * -318979703 : 0;
               return 1;
            } else if (var0 == 1619) {
               var7 = var3.method1750();
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1714().method1941() : "";
               return 1;
            } else if (var0 == 1620) {
               var4 = var3.method1745();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4 != null ? var4.field2795 * 1069637893 * 781009869 : 0;
               return 1;
            } else if (var0 == 1621) {
               var7 = var3.method1750();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1661() : 0;
               return 1;
            } else if (var0 == 1622) {
               var7 = var3.method1750();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1686() : 0;
               return 1;
            } else if (var0 == 1623) {
               var7 = var3.method1750();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1687() : 0;
               return 1;
            } else if (var0 == 1624) {
               var7 = var3.method1750();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null && var7.method1680() ? 1 : 0;
               return 1;
            } else if (var0 != 1625) {
               if (var0 == 1626) {
                  var7 = var3.method1750();
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1679().method2013() : "";
                  return 1;
               } else if (var0 == 1627) {
                  var7 = var3.method1750();
                  int var5 = var7 != null ? var7.method1682() : 0;
                  int var6 = var7 != null ? var7.method1716() : 0;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Math.min(var5, var6);
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Math.max(var5, var6);
                  return 1;
               } else if (var0 == 1628) {
                  var7 = var3.method1750();
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1716() : 0;
                  return 1;
               } else if (var0 == 1629) {
                  var7 = var3.method1750();
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1688() : 0;
                  return 1;
               } else if (var0 == 1630) {
                  var7 = var3.method1750();
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1660() : 0;
                  return 1;
               } else if (var0 == 1631) {
                  var7 = var3.method1750();
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1709() : 0;
                  return 1;
               } else if (var0 == 1632) {
                  var7 = var3.method1750();
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1689() : 0;
                  return 1;
               } else {
                  class27 var8;
                  if (var0 == 1633) {
                     var8 = var3.method1746();
                     Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize - 1] = var8 != null ? var8.method98(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize - 1]) : 0;
                     return 1;
                  } else if (var0 == 1634) {
                     var8 = var3.method1746();
                     Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize - 1] = var8 != null ? var8.method99((char)Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize - 1]) : 0;
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var7 = var3.method1750();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null && var7.method1663() ? 1 : 0;
               return 1;
            }
         }
      }
   }
}
