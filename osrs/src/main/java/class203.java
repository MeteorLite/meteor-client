import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class203 implements class29 {
    @ObfuscatedName("k")
    public static int pcmSampleLength;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lkz;"
   )
   Widget field1814 = null;
   @ObfuscatedName("w")
   boolean field1812 = false;
   @ObfuscatedName("v")
   boolean field1813 = false;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(IB)Z",
            garbageValue = "110"
    )
    public boolean vmethod3949(int var1) {
      if (this.field1814 == null) {
         return false;
      } else {
         class27 var2 = this.field1814.method1746();
         if (var2 == null) {
            return false;
         } else {
            if (var2.method104(var1)) {
               switch(var1) {
               case 81:
                  this.field1813 = true;
                  break;
               case 82:
                  this.field1812 = true;
                  break;
               default:
                  if (this.method1069(var1)) {
                     LoginScreenAnimation.invalidateWidget(this.field1814);
                  }
               }
            }

            return var2.method105(var1);
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "11"
   )
   public boolean vmethod3989(int var1) {
      switch(var1) {
      case 81:
         this.field1813 = false;
         return false;
      case 82:
         this.field1812 = false;
         return false;
      default:
         return false;
      }
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(CI)Z",
            garbageValue = "783044550"
    )
    public boolean vmethod3951(char var1) {
      if (this.field1814 == null) {
         return false;
      } else if (!MusicPatch.method1608(var1)) {
         return false;
      } else {
         class307 var2 = this.field1814.method1750();
         if (var2 != null && var2.method1683()) {
            class27 var3 = this.field1814.method1746();
            if (var3 == null) {
               return false;
            } else {
               if (var3.method101(var1) && var2.method1654(var1)) {
                  LoginScreenAnimation.invalidateWidget(this.field1814);
               }

               return var3.method100(var1);
            }
         } else {
            return false;
         }
      }
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(ZI)Z",
            garbageValue = "653857297"
    )
    public boolean vmethod3953(boolean var1) {
      return false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Lkz;B)V",
      garbageValue = "15"
   )
   public void method1065(Widget var1) {
      this.method1066();
      if (var1 != null) {
         this.field1814 = var1;
         class305 var2 = var1.method1747();
         if (var2 != null) {
            var2.field2802.method1708(true);
            if (var2.field2806 != null) {
               ScriptEvent var3 = new ScriptEvent();
               var3.method461(var1);
               var3.setArgs(var2.field2806);
               class12.getScriptEvents().addFirst(var3);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(S)Lkz;",
      garbageValue = "-11104"
   )
   public Widget method1072() {
      return this.field1814;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1261439160"
   )
   public void method1066() {
      if (this.field1814 != null) {
         class305 var1 = this.field1814.method1747();
         Widget var2 = this.field1814;
         this.field1814 = null;
         if (var1 != null) {
            var1.field2802.method1708(false);
            if (var1.field2806 != null) {
               ScriptEvent var3 = new ScriptEvent();
               var3.method461(var2);
               var3.setArgs(var1.field2806);
               class12.getScriptEvents().addFirst(var3);
            }

         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "577677539"
   )
   boolean method1069(int var1) {
      if (this.field1814 == null) {
         return false;
      } else {
         class307 var2 = this.field1814.method1750();
         if (var2 != null && var2.method1683()) {
            switch(var1) {
            case 13:
               this.method1066();
               return true;
            case 48:
               if (this.field1812) {
                  var2.method1692();
               }

               return true;
            case 65:
               if (this.field1812) {
                  var2.method1673(class12.method48());
               }

               return true;
            case 66:
               if (this.field1812) {
                  var2.method1672(class12.method48());
               }

               return true;
            case 67:
               if (this.field1812) {
                  var2.method1705(class12.method48());
               }

               return true;
            case 84:
               if (var2.method1660() == 0) {
                  var2.method1654(10);
               } else if (this.field1813 && var2.method1690()) {
                  var2.method1654(10);
               } else {
                  class305 var3 = this.field1814.method1747();
                  ScriptEvent var4 = new ScriptEvent();
                  var4.method461(this.field1814);
                  var4.setArgs(var3.field2808);
                  class12.getScriptEvents().addFirst(var4);
                  this.method1066();
               }

               return true;
            case 85:
               if (this.field1812) {
                  var2.method1656();
               } else {
                  var2.method1655();
               }

               return true;
            case 96:
               if (this.field1812) {
                  var2.method1719(this.field1813);
               } else {
                  var2.method1703(this.field1813);
               }

               return true;
            case 97:
               if (this.field1812) {
                  var2.method1664(this.field1813);
               } else {
                  var2.method1662(this.field1813);
               }

               return true;
            case 98:
               if (this.field1812) {
                  var2.method1674();
               } else {
                  var2.method1665(this.field1813);
               }

               return true;
            case 99:
               if (this.field1812) {
                  var2.method1675();
               } else {
                  var2.method1666(this.field1813);
               }

               return true;
            case 101:
               if (this.field1812) {
                  var2.method1657();
               } else {
                  var2.method1713();
               }

               return true;
            case 102:
               if (this.field1812) {
                  var2.method1715(this.field1813);
               } else {
                  var2.method1642(this.field1813);
               }

               return true;
            case 103:
               if (this.field1812) {
                  var2.method1718(this.field1813);
               } else {
                  var2.method1710(this.field1813);
               }

               return true;
            case 104:
               if (this.field1812) {
                  var2.method1669(this.field1813);
               } else {
                  var2.method1667(this.field1813);
               }

               return true;
            case 105:
               if (this.field1812) {
                  var2.method1670(this.field1813);
               } else {
                  var2.method1668(this.field1813);
               }

               return true;
            default:
               return false;
            }
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "-56"
   )
   static boolean method1074(int var0) {
      return (var0 & 128) != 0;
   }

   @ObfuscatedName("kz")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-175438217"
   )
   static final void method1073(int var0) {
      var0 = Math.min(Math.max(var0, 0), 127);
      PacketWriter.clientPreferences.setCurrentSoundEffectVolume(var0);
   }
}
