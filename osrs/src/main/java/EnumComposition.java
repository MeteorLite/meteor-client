import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("EnumComposition")
public class EnumComposition extends DualNode {
    @ObfuscatedName("vc")
    @ObfuscatedSignature(
            descriptor = "Lmk;"
    )
    static GrandExchangeEvents grandExchangeEvents;
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    static AbstractArchive EnumDefinition_archive;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    static EvictingDualNodeHashTable EnumDefinition_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("v")
    public char inputType;
    @ObfuscatedName("s")
    public char outputType;
    @ObfuscatedName("z")
    public String defaultStr = "null";
    @ObfuscatedName("j")
    public int defaultInt;
    @ObfuscatedName("i")
    public int outputCount = 0;
    @ObfuscatedName("n")
    public int[] keys;
    @ObfuscatedName("l")
    public int[] intVals;
    @ObfuscatedName("k")
    public String[] strVals;

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(Lrd;I)V",
            garbageValue = "-2126248770"
    )
    void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(Lrd;II)V",
            garbageValue = "-225365971"
    )
    void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         this.inputType = (char)var1.readUnsignedByte();
      } else if (var2 == 2) {
         this.outputType = (char)var1.readUnsignedByte();
      } else if (var2 == 3) {
         this.defaultStr = var1.readStringCp1252NullTerminated();
      } else if (var2 == 4) {
         this.defaultInt = var1.readInt();
      } else {
         int var3;
         if (var2 == 5) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.strVals = new String[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.strVals[var3] = var1.readStringCp1252NullTerminated();
            }
         } else if (var2 == 6) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.intVals = new int[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.intVals[var3] = var1.readInt();
            }
         }
      }

   }

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "59"
    )
    public int size() {
      return this.outputCount;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "1103882701"
   )
   static int method948(int var0, Script var1, boolean var2) {
      Widget var3 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
      if (var0 == 2600) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.scrollX;
         return 1;
      } else if (var0 == 2601) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.scrollY;
         return 1;
      } else if (var0 == 2602) {
         Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3.text;
         return 1;
      } else if (var0 == 2603) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if (var0 == 2604) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if (var0 == 2605) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if (var0 == 2606) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.modelAngleX;
         return 1;
      } else if (var0 == 2607) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.modelAngleZ;
         return 1;
      } else if (var0 == 2608) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.modelAngleY;
         return 1;
      } else if (var0 == 2609) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.transparencyTop;
         return 1;
      } else if (var0 == 2610) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.transparencyBot;
         return 1;
      } else if (var0 == 2611) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.color;
         return 1;
      } else if (var0 == 2612) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.color2;
         return 1;
      } else if (var0 == 2613) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
         return 1;
      } else if (var0 == 2614) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
         return 1;
      } else {
         class302 var4;
         if (var0 == 2617) {
            var4 = var3.method1745();
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4 != null ? var4.field2794 * 1058580729 * -1366058679 : 0;
         }

         if (var0 == 2618) {
            var4 = var3.method1745();
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4 != null ? var4.field2797 * 2101478585 * -318979703 : 0;
            return 1;
         } else {
            class307 var7;
            if (var0 == 2619) {
               var7 = var3.method1750();
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1714().method1941() : "";
               return 1;
            } else if (var0 == 2620) {
               var4 = var3.method1745();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var4 != null ? var4.field2795 * 1069637893 * 781009869 : 0;
               return 1;
            } else if (var0 == 2621) {
               var7 = var3.method1750();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1661() : 0;
               return 1;
            } else if (var0 == 2622) {
               var7 = var3.method1750();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1686() : 0;
               return 1;
            } else if (var0 == 2623) {
               var7 = var3.method1750();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1687() : 0;
               return 1;
            } else if (var0 == 2624) {
               var7 = var3.method1750();
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null && var7.method1680() ? 1 : 0;
               return 1;
            } else if (var0 != 2625) {
               if (var0 == 2626) {
                  var7 = var3.method1750();
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1679().method2013() : "";
                  return 1;
               } else if (var0 == 2627) {
                  var7 = var3.method1750();
                  int var5 = var7 != null ? var7.method1682() : 0;
                  int var6 = var7 != null ? var7.method1716() : 0;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Math.min(var5, var6);
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Math.max(var5, var6);
                  return 1;
               } else if (var0 == 2628) {
                  var7 = var3.method1750();
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1716() : 0;
                  return 1;
               } else if (var0 == 2629) {
                  var7 = var3.method1750();
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1688() : 0;
                  return 1;
               } else if (var0 == 2630) {
                  var7 = var3.method1750();
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1660() : 0;
                  return 1;
               } else if (var0 == 2631) {
                  var7 = var3.method1750();
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1709() : 0;
                  return 1;
               } else if (var0 == 2632) {
                  var7 = var3.method1750();
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7 != null ? var7.method1689() : 0;
                  return 1;
               } else {
                  class27 var8;
                  if (var0 == 2633) {
                     var8 = var3.method1746();
                     Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize - 1] = var8 != null ? var8.method98(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize - 1]) : 0;
                     return 1;
                  } else if (var0 == 2634) {
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

   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1234070189"
   )
   static boolean method947(int var0) {
      for(int var1 = 0; var1 < Client.field623; ++var1) {
         if (Client.field610[var1] == var0) {
            return true;
         }
      }

      return false;
   }
}
