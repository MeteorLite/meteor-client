import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("Message")
public class Message extends DualNode {
    @ObfuscatedName("ta")
    static int cameraLookAtSpeed;
   @ObfuscatedName("bt")
   static int field359;
    @ObfuscatedName("f")
    int count;
    @ObfuscatedName("w")
    int cycle;
    @ObfuscatedName("v")
    int type;
    @ObfuscatedName("s")
    String sender;
    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "Lsi;"
    )
    Username senderUsername;
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "Lot;"
    )
    TriBool isFromFriend0;
    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "Lot;"
    )
    TriBool isFromIgnored0;
    @ObfuscatedName("n")
    String prefix;
    @ObfuscatedName("l")
    String text;

   Message(int var1, String var2, String var3, String var4) {
      this.isFromFriend0 = TriBool.TriBool_unknown;
      this.isFromIgnored0 = TriBool.TriBool_unknown;
      this.set(var1, var2, var3, var4);
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
            garbageValue = "1059828352"
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

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1277277139"
    )
    void clearIsFromFriend() {
      this.isFromFriend0 = TriBool.TriBool_unknown;
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(B)Z",
            garbageValue = "28"
    )
    final boolean isFromFriend() {
      if (this.isFromFriend0 == TriBool.TriBool_unknown) {
         this.fillIsFromFriend();
      }

      return this.isFromFriend0 == TriBool.TriBool_true;
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "330583161"
    )
    void fillIsFromFriend() {
      this.isFromFriend0 = WorldMapElement.friendSystem.friendsList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "-2"
    )
    void clearIsFromIgnored() {
      this.isFromIgnored0 = TriBool.TriBool_unknown;
   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1151238306"
    )
    final boolean isFromIgnored() {
      if (this.isFromIgnored0 == TriBool.TriBool_unknown) {
         this.fillIsFromIgnored();
      }

      return this.isFromIgnored0 == TriBool.TriBool_true;
   }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "0"
    )
    void fillIsFromIgnored() {
      this.isFromIgnored0 = WorldMapElement.friendSystem.ignoreList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

    @ObfuscatedName("n")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1789118280"
    )
    final void fillSenderUsername() {
      if (this.sender != null) {
         this.senderUsername = new Username(class6.method16(this.sender), WorldMapCacheName.loginType);
      } else {
         this.senderUsername = null;
      }

   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(IIB)Lbq;",
            garbageValue = "109"
    )
    static Message Messages_getByChannelAndID(int var0, int var1) {
      ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(var0);
      return var2.getMessage(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-163362829"
   )
   static final int method333(int var0, int var1) {
      int var2 = method323(var0 - 1, var1 - 1) + method323(var0 + 1, var1 - 1) + method323(var0 - 1, var1 + 1) + method323(var0 + 1, var1 + 1);
      int var3 = method323(var0 - 1, var1) + method323(var0 + 1, var1) + method323(var0, var1 - 1) + method323(var0, var1 + 1);
      int var4 = method323(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IIB)I",
      garbageValue = "-118"
   )
   static final int method323(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

    @ObfuscatedName("gz")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1433470376"
    )
    static int getWindowedMode() {
      return Client.isResizable ? 2 : 1;
   }
}
