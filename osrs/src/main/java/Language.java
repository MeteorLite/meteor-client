import java.io.IOException;
import java.util.Locale;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nx")
@Implements("Language")
public class Language implements class356 {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lnx;"
    )
    public static final Language Language_EN;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lnx;"
   )
   static final Language field3554;
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lnx;"
    )
    public static final Language Language_FR;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lnx;"
   )
   static final Language field3547;
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Lnx;"
   )
   static final Language field3548;
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Lnx;"
    )
    public static final Language Language_ES;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lnx;"
   )
   static final Language field3550;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "[Lnx;"
   )
   static final Language[] field3556;
    @ObfuscatedName("ir")
    @ObfuscatedSignature(
            descriptor = "Lon;"
    )
    static Font fontPlain11;
    @ObfuscatedName("ot")
    @ObfuscatedSignature(
            descriptor = "Lcb;"
    )
    static MenuAction tempMenuAction;
   @ObfuscatedName("al")
   final String field3555;
    @ObfuscatedName("at")
    final String language;
    @ObfuscatedName("aa")
    final int id;

   static {
      Language_EN = new Language("EN", "en", "English", ModeWhere.field3573, 0, "GB");
      field3554 = new Language("DE", "de", "German", ModeWhere.field3573, 1, "DE");
      Language_FR = new Language("FR", "fr", "French", ModeWhere.field3573, 2, "FR");
      field3547 = new Language("PT", "pt", "Portuguese", ModeWhere.field3573, 3, "BR");
      field3548 = new Language("NL", "nl", "Dutch", ModeWhere.field3568, 4, "NL");
      Language_ES = new Language("ES", "es", "Spanish", ModeWhere.field3568, 5, "ES");
      field3550 = new Language("ES_MX", "es-mx", "Spanish (Latin American)", ModeWhere.field3573, 6, "MX");
      Language[] var0 = method1947();
      field3556 = new Language[var0.length];
      Language[] var1 = var0;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Language var3 = var1[var2];
         if (field3556[var3.id] != null) {
            throw new IllegalStateException();
         }

         field3556[var3.id] = var3;
      }

   }

   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lne;ILjava/lang/String;)V"
   )
   Language(String var1, String var2, String var3, ModeWhere var4, int var5, String var6) {
      this.field3555 = var1;
      this.language = var2;
      this.id = var5;
      if (var6 != null) {
         new Locale(var2.substring(0, 2), var6);
      } else {
         new Locale(var2.substring(0, 2));
      }

   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.id;
   }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(B)Ljava/lang/String;",
            garbageValue = "80"
    )
    String getLanguage() {
      return this.language;
   }

    @ObfuscatedName("toString")
    public String toString() {
      return this.getLanguage().toLowerCase(Locale.ENGLISH);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(B)[Lnx;",
      garbageValue = "-121"
   )
   static Language[] method1947() {
      return new Language[]{Language_FR, field3548, field3554, field3550, field3547, Language_EN, Language_ES};
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(B)[Lmb;",
      garbageValue = "-10"
   )
   public static class337[] method1949() {
      return new class337[]{class337.field3421, class337.field3422, class337.field3423, class337.field3420};
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(IB)Lnx;",
      garbageValue = "-1"
   )
   public static Language method1943(int var0) {
      return var0 >= 0 && var0 < field3556.length ? field3556[var0] : null;
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      descriptor = "(Lsh;B)Ljava/lang/Object;",
      garbageValue = "90"
   )
   static Object method1948(class478 var0) {
      if (var0 == null) {
         throw new IllegalStateException("popValueOfType() failure - null baseVarType");
      } else {
         switch(var0.field4029) {
         case 1:
            return Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         case 2:
            return Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
         default:
            throw new IllegalStateException("popValueOfType() failure - unsupported type");
         }
      }
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-257332846"
   )
   static final void method1946(boolean var0) {
      class323.playPcmPlayers();
      ++Client.packetWriter.pendingWrites;
      if (Client.packetWriter.pendingWrites >= 50 || var0) {
         Client.packetWriter.pendingWrites = 0;
         if (!Client.hadNetworkError && Client.packetWriter.getSocket() != null) {
            PacketBufferNode var1 = class330.getPacketBufferNode(ClientPacket.field2554, Client.packetWriter.isaacCipher);
            Client.packetWriter.addNode(var1);

            try {
               Client.packetWriter.flush();
            } catch (IOException var3) {
               Client.hadNetworkError = true;
            }
         }

      }
   }
}
