import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class140 extends class136 {
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      descriptor = "Lra;"
   )
   static IndexedSprite worldSelectRightSprite;
   @ObfuscatedName("h")
   int field1304;
   @ObfuscatedName("e")
   byte field1305;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lem;"
   )
   final class139 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lem;)V"
   )
   class140(class139 var1) {
      this.this$0 = var1;
      this.field1304 = -1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1101327225"
   )
   void vmethod3254(Buffer var1) {
      this.field1304 = var1.readUnsignedShort();
      this.field1305 = var1.readByte();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   void vmethod3248(ClanSettings var1) {
      var1.method786(this.field1304, this.field1305);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-1959996684"
   )
   static int method754(int var0) {
      return class29.KeyHandler_keyCodes[var0];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lly;I)V",
      garbageValue = "519981474"
   )
   public static void method751(AbstractArchive var0) {
      class283.FloorUnderlayDefinition_archive = var0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IIIB)I",
      garbageValue = "76"
   )
   static int method753(int var0, int var1, int var2) {
      return var0 << 28 | var1 << 14 | var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIII)Z",
      garbageValue = "-1039689208"
   )
   static final boolean method748(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = ViewportMouse.ViewportMouse_y + var6;
      if (var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = ViewportMouse.ViewportMouse_y - var6;
         if (var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = ViewportMouse.ViewportMouse_x + var6;
            if (var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = ViewportMouse.ViewportMouse_x - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1425199157"
   )
   static void updateGameState(int var0) {
      if (var0 != Client.gameState) {
         if (Client.gameState == 30) {
            Client.field417.method1065();
         }

         if (Client.gameState == 0) {
            BuddyRankComparator.client.method166();
         }

         if (var0 == 20 || var0 == 40 || var0 == 45 || var0 == 50) {
            class37.setLoginState(0);
            Client.field493 = 0;
            Client.field386 = 0;
            Client.timer.method2001(var0);
            if (var0 != 20) {
               InterfaceParent.method472(false);
            }
         }

         if (var0 != 20 && var0 != 40 && class14.field42 != null) {
            class14.field42.close();
            class14.field42 = null;
         }

         if (Client.gameState == 25) {
            Client.field503 = 0;
            Client.field446 = 0;
            Client.field600 = 1;
            Client.field631 = 0;
            Client.field419 = 1;
         }

         if (var0 != 5 && var0 != 10) {
            if (var0 == 20) {
               int var3 = Client.gameState == 11 ? 4 : 0;
               UserComparator5.method666(ClanChannelMember.archive10, ClientPreferences.archive8, false, var3);
            } else if (var0 == 11) {
               UserComparator5.method666(ClanChannelMember.archive10, ClientPreferences.archive8, false, 4);
            } else if (var0 == 50) {
               TaskHandler.setLoginResponseString("", "Updating date of birth...", "");
               UserComparator5.method666(ClanChannelMember.archive10, ClientPreferences.archive8, false, 7);
            } else {
               FontName.method2254();
            }
         } else {
            boolean var1 = StructComposition.clientPreferences.method542() >= Client.param21;
            int var2 = var1 ? 0 : 12;
            UserComparator5.method666(ClanChannelMember.archive10, ClientPreferences.archive8, true, var2);
         }

         Client.gameState = var0;
      }
   }
}
