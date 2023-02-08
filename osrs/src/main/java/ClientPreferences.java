import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("ClientPreferences")
public class ClientPreferences {
    @ObfuscatedName("z")
    boolean roofsHidden;
    @ObfuscatedName("j")
    boolean hideUsername = false;
    @ObfuscatedName("i")
    boolean titleMusicDisabled;
    @ObfuscatedName("n")
    boolean displayFps = false;
   @ObfuscatedName("l")
   int field1037;
    @ObfuscatedName("k")
    double brightness = 0.8D;
    @ObfuscatedName("c")
    int musicVolume = 127;
    @ObfuscatedName("r")
    int soundEffectsVolume = 127;
    @ObfuscatedName("b")
    int areaSoundEffectsVolume = 127;
   @ObfuscatedName("m")
   int field1042 = -1;
    @ObfuscatedName("t")
    String rememberedUsername = null;
    @ObfuscatedName("h")
    int windowMode = 1;
    @ObfuscatedName("p")
    final Map parameters = new LinkedHashMap();

   ClientPreferences() {
      this.method520(true);
   }

   @ObfuscatedSignature(
      descriptor = "(Lrd;)V"
   )
   ClientPreferences(Buffer var1) {
      if (var1 != null && var1.array != null) {
         int var2 = var1.readUnsignedByte();
         if (var2 >= 0 && var2 <= 10) {
            if (var1.readUnsignedByte() == 1) {
               this.roofsHidden = true;
            }

            if (var2 > 1) {
               this.titleMusicDisabled = var1.readUnsignedByte() == 1;
            }

            if (var2 > 3) {
               this.windowMode = var1.readUnsignedByte();
            }

            if (var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.parameters.put(var5, var6);
               }
            }

            if (var2 > 4) {
               this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
            }

            if (var2 > 5) {
               this.hideUsername = var1.readBoolean();
            }

            if (var2 > 6) {
               this.brightness = (double)var1.readUnsignedByte() / 100.0D;
               this.musicVolume = var1.readUnsignedByte();
               this.soundEffectsVolume = var1.readUnsignedByte();
               this.areaSoundEffectsVolume = var1.readUnsignedByte();
            }

            if (var2 > 7) {
               this.field1042 = var1.readUnsignedByte();
            }

            if (var2 > 8) {
               this.displayFps = var1.readUnsignedByte() == 1;
            }

            if (var2 > 9) {
               this.field1037 = var1.readInt();
            }
         } else {
            this.method520(true);
         }
      } else {
         this.method520(true);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "54"
   )
   void method520(boolean var1) {
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)Lrd;",
            garbageValue = "1661663667"
    )
    Buffer toBuffer() {
      Buffer var1 = new Buffer(417, true);
      var1.writeByte(10);
      var1.writeByte(this.roofsHidden ? 1 : 0);
      var1.writeByte(this.titleMusicDisabled ? 1 : 0);
      var1.writeByte(this.windowMode);
      var1.writeByte(this.parameters.size());
      Iterator var2 = this.parameters.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeInt((Integer)var3.getKey());
         var1.writeInt((Integer)var3.getValue());
      }

      var1.writeStringCp1252NullTerminated(this.rememberedUsername != null ? this.rememberedUsername : "");
      var1.writeBoolean(this.hideUsername);
      var1.writeByte((int)(this.brightness * 100.0D));
      var1.writeByte(this.musicVolume);
      var1.writeByte(this.soundEffectsVolume);
      var1.writeByte(this.areaSoundEffectsVolume);
      var1.writeByte(this.field1042);
      var1.writeByte(this.displayFps ? 1 : 0);
      var1.writeInt(this.field1037);
      return var1;
   }

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(ZB)V",
            garbageValue = "-109"
    )
    void setRoofsHidden(boolean var1) {
      this.roofsHidden = var1;
      SoundSystem.savePreferences();
   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(S)Z",
            garbageValue = "180"
    )
    boolean getRoofsHidden() {
      return this.roofsHidden;
   }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "(ZB)V",
            garbageValue = "2"
    )
    void setIsUsernameHidden(boolean var1) {
      this.hideUsername = var1;
      SoundSystem.savePreferences();
   }

    @ObfuscatedName("n")
    @ObfuscatedSignature(
            descriptor = "(S)Z",
            garbageValue = "8123"
    )
    boolean getIsUsernameHidden() {
      return this.hideUsername;
   }

    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "(ZI)V",
            garbageValue = "-642291381"
    )
    void getTitleMusicDisabled(boolean var1) {
      this.titleMusicDisabled = var1;
      SoundSystem.savePreferences();
   }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1585419909"
    )
    boolean getTitleMusicDisabled() {
      return this.titleMusicDisabled;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "810617878"
   )
   void method524(boolean var1) {
      this.displayFps = var1;
      SoundSystem.savePreferences();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "915076830"
   )
   void method525() {
      this.method524(!this.displayFps);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "2"
   )
   boolean method526() {
      return this.displayFps;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-8"
   )
   void method527(int var1) {
      this.field1037 = var1;
      SoundSystem.savePreferences();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-2141806502"
   )
   int method528() {
      return this.field1037;
   }

    @ObfuscatedName("h")
    void setBrightness(double var1) {
      this.brightness = var1;
      SoundSystem.savePreferences();
   }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            descriptor = "(B)D",
            garbageValue = "76"
    )
    double getBrightness() {
      return this.brightness;
   }

    @ObfuscatedName("o")
    @ObfuscatedSignature(
            descriptor = "(IB)V",
            garbageValue = "8"
    )
    void setCurrentMusicVolume(int var1) {
      this.musicVolume = var1;
      SoundSystem.savePreferences();
   }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-348918421"
    )
    int getCurrentMusicVolume() {
      return this.musicVolume;
   }

    @ObfuscatedName("x")
    @ObfuscatedSignature(
            descriptor = "(IB)V",
            garbageValue = "107"
    )
    void setCurrentSoundEffectVolume(int var1) {
      this.soundEffectsVolume = var1;
      SoundSystem.savePreferences();
   }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "1825265297"
    )
    int getCurrentSoundEffectsVolume() {
      return this.soundEffectsVolume;
   }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "-1384124032"
    )
    void setAreaSoundEffectsVolume(int var1) {
      this.areaSoundEffectsVolume = var1;
      SoundSystem.savePreferences();
   }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1799077602"
    )
    int getAreaSoundEffectsVolume() {
      return this.areaSoundEffectsVolume;
   }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;I)V",
            garbageValue = "-83522118"
    )
    void setUsernameToRemember(String var1) {
      this.rememberedUsername = var1;
      SoundSystem.savePreferences();
   }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            descriptor = "(I)Ljava/lang/String;",
            garbageValue = "-919916182"
    )
    String getUsernameToRemember() {
      return this.rememberedUsername;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1162088376"
   )
   void method533(int var1) {
      this.field1042 = var1;
      SoundSystem.savePreferences();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "1"
   )
   int method534() {
      return this.field1042;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "724225707"
   )
   void method535(int var1) {
      this.windowMode = var1;
      SoundSystem.savePreferences();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1675025735"
   )
   int method536() {
      return this.windowMode;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;II)V",
      garbageValue = "-1508652053"
   )
   void method550(String var1, int var2) {
      int var3 = this.method539(var1);
      if (this.parameters.size() >= 10 && !this.parameters.containsKey(var3)) {
         Iterator var4 = this.parameters.entrySet().iterator();
         var4.next();
         var4.remove();
      }

      this.parameters.put(var3, var2);
      SoundSystem.savePreferences();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Z",
      garbageValue = "-1879605728"
   )
   boolean method537(String var1) {
      int var2 = this.method539(var1);
      return this.parameters.containsKey(var2);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)I",
      garbageValue = "-2142036926"
   )
   int method538(String var1) {
      int var2 = this.method539(var1);
      return !this.parameters.containsKey(var2) ? 0 : (Integer)this.parameters.get(var2);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)I",
      garbageValue = "103"
   )
   int method539(String var1) {
      return GrandExchangeOfferAgeComparator.method1848(var1.toLowerCase());
   }
}
