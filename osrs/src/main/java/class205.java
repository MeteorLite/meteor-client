import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public class class205 implements class29 {
    @ObfuscatedName("gr")
    @ObfuscatedSignature(
            descriptor = "Lnd;"
    )
    static Archive archive20;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   Widget field1850 = null;
   @ObfuscatedName("an")
   boolean field1847 = false;
   @ObfuscatedName("aw")
   boolean field1849 = false;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(II)Z",
            garbageValue = "1311192309"
    )
    public boolean vmethod3949(int var1) {
      if (this.field1850 == null) {
         return false;
      } else {
         class27 var2 = this.field1850.method1795();
         if (var2 == null) {
            return false;
         } else {
            if (var2.method120(var1)) {
               switch(var1) {
               case 81:
                  this.field1849 = true;
                  break;
               case 82:
                  this.field1847 = true;
                  break;
               default:
                  if (this.method1143(var1)) {
                     class144.invalidateWidget(this.field1850);
                  }
               }
            }

            return var2.method118(var1);
         }
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1312051339"
   )
   public boolean vmethod3989(int var1) {
      switch(var1) {
      case 81:
         this.field1849 = false;
         return false;
      case 82:
         this.field1847 = false;
         return false;
      default:
         return false;
      }
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(CI)Z",
            garbageValue = "-2018590760"
    )
    public boolean vmethod3951(char var1) {
      if (this.field1850 == null) {
         return false;
      } else if (!MouseHandler.method195(var1)) {
         return false;
      } else {
         class314 var2 = this.field1850.method1815();
         if (var2 != null && var2.method1748()) {
            class27 var3 = this.field1850.method1795();
            if (var3 == null) {
               return false;
            } else {
               if (var3.method124(var1) && var2.method1720(var1)) {
                  class144.invalidateWidget(this.field1850);
               }

               return var3.method119(var1);
            }
         } else {
            return false;
         }
      }
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(ZB)Z",
            garbageValue = "-16"
    )
    public boolean vmethod3953(boolean var1) {
      return false;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(Lmq;I)V",
      garbageValue = "1563132907"
   )
   public void method1137(Widget var1) {
      this.method1138();
      if (var1 != null) {
         this.field1850 = var1;
         class312 var2 = var1.method1818();
         if (var2 != null) {
            var2.field2823.method1706(true);
            if (var2.field2821 != null) {
               ScriptEvent var3 = new ScriptEvent();
               var3.method491(var1);
               var3.setArgs(var2.field2821);
               GrandExchangeOfferAgeComparator.getScriptEvents().addFirst(var3);
            }
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(S)Lmq;",
      garbageValue = "32767"
   )
   public Widget method1144() {
      return this.field1850;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-18"
   )
   public void method1138() {
      if (this.field1850 != null) {
         class312 var1 = this.field1850.method1818();
         Widget var2 = this.field1850;
         this.field1850 = null;
         if (var1 != null) {
            var1.field2823.method1706(false);
            if (var1.field2821 != null) {
               ScriptEvent var3 = new ScriptEvent();
               var3.method491(var2);
               var3.setArgs(var1.field2821);
               GrandExchangeOfferAgeComparator.getScriptEvents().addFirst(var3);
            }

         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1039701598"
   )
   boolean method1143(int var1) {
      if (this.field1850 == null) {
         return false;
      } else {
         class314 var2 = this.field1850.method1815();
         if (var2 != null && var2.method1748()) {
            switch(var1) {
            case 13:
               this.method1138();
               return true;
            case 48:
               if (this.field1847) {
                  var2.method1787();
               }

               return true;
            case 65:
               if (this.field1847) {
                  var2.method1776(class143.method815());
               }

               return true;
            case 66:
               if (this.field1847) {
                  var2.method1736(class143.method815());
               }

               return true;
            case 67:
               if (this.field1847) {
                  var2.method1738(class143.method815());
               }

               return true;
            case 84:
               if (var2.method1752() == 0) {
                  var2.method1720(10);
               } else if (this.field1849 && var2.method1755()) {
                  var2.method1720(10);
               } else {
                  class312 var3 = this.field1850.method1818();
                  ScriptEvent var4 = new ScriptEvent();
                  var4.method491(this.field1850);
                  var4.setArgs(var3.field2825);
                  GrandExchangeOfferAgeComparator.getScriptEvents().addFirst(var4);
                  this.method1138();
               }

               return true;
            case 85:
               if (this.field1847) {
                  var2.method1780();
               } else {
                  var2.method1770();
               }

               return true;
            case 96:
               if (this.field1847) {
                  var2.method1786(this.field1849);
               } else {
                  var2.method1728(this.field1849);
               }

               return true;
            case 97:
               if (this.field1847) {
                  var2.method1730(this.field1849);
               } else {
                  var2.method1729(this.field1849);
               }

               return true;
            case 98:
               if (this.field1847) {
                  var2.method1777();
               } else {
                  var2.method1731(this.field1849);
               }

               return true;
            case 99:
               if (this.field1847) {
                  var2.method1778();
               } else {
                  var2.method1732(this.field1849);
               }

               return true;
            case 101:
               if (this.field1847) {
                  var2.method1785();
               } else {
                  var2.method1768();
               }

               return true;
            case 102:
               if (this.field1847) {
                  var2.method1726(this.field1849);
               } else {
                  var2.method1722(this.field1849);
               }

               return true;
            case 103:
               if (this.field1847) {
                  var2.method1773(this.field1849);
               } else {
                  var2.method1772(this.field1849);
               }

               return true;
            case 104:
               if (this.field1847) {
                  var2.method1734(this.field1849);
               } else {
                  var2.method1733(this.field1849);
               }

               return true;
            case 105:
               if (this.field1847) {
                  var2.method1724(this.field1849);
               } else {
                  var2.method1721(this.field1849);
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

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(I)Ldu;",
      garbageValue = "-739086795"
   )
   static ClientPreferences method1146() {
      AccessFile var0 = null;
      ClientPreferences var1 = new ClientPreferences();

      try {
         var0 = Rasterizer3D.getPreferencesFile("", Client.field358.name, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
            if (var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new ClientPreferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if (var0 != null) {
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
            garbageValue = "768397072"
    )
    static void setLoginResponseString(String var0, String var1, String var2) {
      Login.Login_response1 = var0;
      Login.Login_response2 = var1;
      Login.Login_response3 = var2;
   }
}
