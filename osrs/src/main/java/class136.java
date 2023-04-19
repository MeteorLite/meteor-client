import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class136 extends class139 {
    @ObfuscatedName("ar")
    static int[] ByteArrayPool_altSizeArrayCounts;
   @ObfuscatedName("af")
   int field1310;
   @ObfuscatedName("an")
   int field1308;
   @ObfuscatedName("aw")
   int field1306;
   @ObfuscatedName("ac")
   int field1309;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfa;)V"
   )
   class136(class142 var1) {
      this.this$0 = var1;
      this.field1310 = -1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "168736686"
    )
    void vmethod3254(Buffer var1) {
      this.field1310 = var1.readUnsignedShort();
      this.field1308 = var1.readInt();
      this.field1306 = var1.readUnsignedByte();
      this.field1309 = var1.readUnsignedByte();
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lfj;I)V",
            garbageValue = "1712319228"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method865(this.field1310, this.field1308, this.field1306, this.field1309);
   }

   @ObfuscatedName("af")
   public static String method789(long var0) {
      Calendar.Calendar_calendar.setTime(new Date(var0));
      int var2 = Calendar.Calendar_calendar.get(7);
      int var3 = Calendar.Calendar_calendar.get(5);
      int var4 = Calendar.Calendar_calendar.get(2);
      int var5 = Calendar.Calendar_calendar.get(1);
      int var6 = Calendar.Calendar_calendar.get(11);
      int var7 = Calendar.Calendar_calendar.get(12);
      int var8 = Calendar.Calendar_calendar.get(13);
      return Calendar.DAYS_OF_THE_WEEK[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + Calendar.MONTH_NAMES_ENGLISH_GERMAN[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;S)V",
            garbageValue = "-29165"
    )
    static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatChannel var4 = (ChatChannel)Messages.Messages_channels.get(var0);
      if (var4 == null) {
         var4 = new ChatChannel();
         Messages.Messages_channels.put(var0, var4);
      }

      Message var5 = var4.addMessage(var0, var1, var2, var3);
      Messages.Messages_hashTable.put(var5, (long)var5.count);
      Messages.Messages_queue.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }
}
