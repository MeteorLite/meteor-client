import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ry")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lry;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11 = new FontName("p11_full");
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lry;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12 = new FontName("p12_full");
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lry;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12 = new FontName("b12_full");
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lry;"
   )
   @Export("FontName_verdana11")
   public static final FontName FontName_verdana11 = new FontName("verdana_11pt_regular");
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lry;"
   )
   @Export("FontName_verdana13")
   public static final FontName FontName_verdana13 = new FontName("verdana_13pt_regular");
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lry;"
   )
   @Export("FontName_verdana15")
   public static final FontName FontName_verdana15 = new FontName("verdana_15pt_regular");
   @ObfuscatedName("cc")
   @Export("param9")
   static String param9;
   @ObfuscatedName("av")
   @Export("name")
   String name;

   FontName(String var1) {
      this.name = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(S)[Lmr;",
      garbageValue = "-27167"
   )
   static class326[] method2314() {
      return new class326[]{class326.field3030, class326.field3031};
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(S)[Lry;",
      garbageValue = "8828"
   )
   public static FontName[] method2311() {
      return new FontName[]{FontName_plain12, FontName_verdana13, FontName_bold12, FontName_verdana11, FontName_plain11, FontName_verdana15};
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(B)Lcz;",
      garbageValue = "70"
   )
   @Export("worldListStart")
   static World worldListStart() {
      World.World_listCount = 0;
      return class467.getNextWorldListWorld();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1950859515"
   )
   @Export("Login_promptCredentials")
   static void Login_promptCredentials(boolean var0) {
      if (!class392.client.method349() && !class392.client.method374() && !class392.client.method350()) {
         Login.Login_response1 = "";
         Login.Login_response2 = "Enter your username/email & password.";
         Login.Login_response3 = "";
         class14.method52(2);
         if (var0) {
            Login.Login_password = "";
         }

         if (Login.Login_username == null || Login.Login_username.length() <= 0) {
            if (WorldMapSectionType.clientPreferences.getUsernameToRemember() != null) {
               Login.Login_username = WorldMapSectionType.clientPreferences.getUsernameToRemember();
               Client.Login_isUsernameRemembered = true;
            } else {
               Client.Login_isUsernameRemembered = false;
            }
         }

         ReflectionCheck.method178();
      } else {
         class14.method52(10);
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "103"
   )
   static int method2315(int var0, Script var1, boolean var2) {
      Widget var3 = WorldMapSection1.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
      if (var0 == 2800) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapDecorationType.Widget_unpackTargetMask(ParamComposition.getWidgetFlags(var3));
         return 1;
      } else if (var0 != 2801) {
         if (var0 == 2802) {
            if (var3.dataText == null) {
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
            } else {
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3.dataText;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         --var4;
         if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3.actions[var4];
         } else {
            Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("kg")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;I)V",
      garbageValue = "1033960923"
   )
   static void method2312(int var0, String var1) {
      int var2 = Players.Players_count;
      int[] var3 = Players.Players_indices;
      boolean var4 = false;
      Username var5 = new Username(var1, Occluder.loginType);

      for(int var6 = 0; var6 < var2; ++var6) {
         Player var7 = Client.players[var3[var6]];
         if (var7 != null && var7 != BuddyRankComparator.localPlayer && var7.username != null && var7.username.equals(var5)) {
            PacketBufferNode var8;
            if (var0 == 1) {
               var8 = UserComparator9.getPacketBufferNode(ClientPacket.field2433, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeShort(var3[var6]);
               var8.packetBuffer.writeByteA(0);
               Client.packetWriter.addNode(var8);
            } else if (var0 == 4) {
               var8 = UserComparator9.getPacketBufferNode(ClientPacket.field2451, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeShortLEA(var3[var6]);
               var8.packetBuffer.method2409(0);
               Client.packetWriter.addNode(var8);
            } else if (var0 == 6) {
               var8 = UserComparator9.getPacketBufferNode(ClientPacket.field2450, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeByte(0);
               var8.packetBuffer.writeShortLE(var3[var6]);
               Client.packetWriter.addNode(var8);
            } else if (var0 == 7) {
               var8 = UserComparator9.getPacketBufferNode(ClientPacket.field2493, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeShort(var3[var6]);
               var8.packetBuffer.writeByte(0);
               Client.packetWriter.addNode(var8);
            }

            var4 = true;
            break;
         }
      }

      if (!var4) {
         MusicPatchNode.addGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
