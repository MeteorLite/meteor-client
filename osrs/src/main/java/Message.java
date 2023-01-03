import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("Message")
public class Message extends DualNode {
   @ObfuscatedName("h")
   int count;
   @ObfuscatedName("e")
   int cycle;
   @ObfuscatedName("v")
   int type;
   @ObfuscatedName("x")
   String sender;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lrp;"
   )
   Username senderUsername;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Loh;"
   )
   TriBool isFromFriend0;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Loh;"
   )
   TriBool isFromIgnored0;
   @ObfuscatedName("r")
   String prefix;
   @ObfuscatedName("u")
   String text;

   Message(int var1, String var2, String var3, String var4) {
      this.isFromFriend0 = TriBool.TriBool_unknown;
      this.isFromIgnored0 = TriBool.TriBool_unknown;
      this.set(var1, var2, var3, var4);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1359807045"
   )
   void set(int var1, String var2, String var3, String var4) {
      int var5 = ++Messages.Messages_count - 1;
      this.count = var5;
      this.cycle = Client.cycle;
      this.type = var1;
      this.sender = var2;
      this.fillSenderUsername();
      this.prefix = var3;
      this.text = var4;
      this.clearIsFromFriend();
      this.clearIsFromIgnored();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "0"
   )
   void clearIsFromFriend() {
      this.isFromFriend0 = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-22"
   )
   final boolean isFromFriend() {
      if (this.isFromFriend0 == TriBool.TriBool_unknown) {
         this.fillIsFromFriend();
      }

      return this.isFromFriend0 == TriBool.TriBool_true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "189401523"
   )
   void fillIsFromFriend() {
      this.isFromFriend0 = DefaultsGroup.friendSystem.friendsList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-59"
   )
   void clearIsFromIgnored() {
      this.isFromIgnored0 = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-394319082"
   )
   final boolean isFromIgnored() {
      if (this.isFromIgnored0 == TriBool.TriBool_unknown) {
         this.fillIsFromIgnored();
      }

      return this.isFromIgnored0 == TriBool.TriBool_true;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "95"
   )
   void fillIsFromIgnored() {
      this.isFromIgnored0 = DefaultsGroup.friendSystem.ignoreList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1260943209"
   )
   final void fillSenderUsername() {
      if (this.sender != null) {
         this.senderUsername = new Username(class282.method1533(this.sender), SecureRandomFuture.loginType);
      } else {
         this.senderUsername = null;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)J",
      garbageValue = "-16"
   )
   public static final synchronized long method344() {
      long var0 = System.currentTimeMillis();
      if (var0 < class31.field84) {
         class282.field2695 += class31.field84 - var0;
      }

      class31.field84 = var0;
      return class282.field2695 + var0;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "153233392"
   )
   static int method345(int var0, Script var1, boolean var2) {
      if (var0 == 6809) {
         int var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         ObjectComposition var4 = VarpDefinition.getObjectDefinition(var3);
         Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4 != null ? var4.name : "";
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-37"
   )
   static int getWindowedMode() {
      return Client.isResizable ? 2 : 1;
   }
}
