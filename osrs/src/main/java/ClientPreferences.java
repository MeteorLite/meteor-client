import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("ClientPreferences")
public class ClientPreferences {
   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      descriptor = "Lmx;"
   )
   @Export("archive9")
   static Archive archive9;
   @ObfuscatedName("an")
   @Export("roofsHidden")
   boolean roofsHidden;
   @ObfuscatedName("ao")
   @Export("hideUsername")
   boolean hideUsername = false;
   @ObfuscatedName("av")
   @Export("titleMusicDisabled")
   boolean titleMusicDisabled;
   @ObfuscatedName("aq")
   @Export("displayFps")
   boolean displayFps = false;
   @ObfuscatedName("ap")
   int field1032;
   @ObfuscatedName("ar")
   @Export("brightness")
   double brightness = 0.8D;
   @ObfuscatedName("ak")
   @Export("musicVolume")
   int musicVolume = 127;
   @ObfuscatedName("ax")
   @Export("soundEffectsVolume")
   int soundEffectsVolume = 127;
   @ObfuscatedName("as")
   @Export("areaSoundEffectsVolume")
   int areaSoundEffectsVolume = 127;
   @ObfuscatedName("ay")
   int field1039 = -1;
   @ObfuscatedName("am")
   @Export("rememberedUsername")
   String rememberedUsername = null;
   @ObfuscatedName("az")
   @Export("windowMode")
   int windowMode = 1;
   @ObfuscatedName("ae")
   @Export("parameters")
   final Map parameters = new LinkedHashMap();

   ClientPreferences() {
      this.method521(true);
   }

   @ObfuscatedSignature(
      descriptor = "(Lsy;)V"
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
               this.field1039 = var1.readUnsignedByte();
            }

            if (var2 > 8) {
               this.displayFps = var1.readUnsignedByte() == 1;
            }

            if (var2 > 9) {
               this.field1032 = var1.readInt();
            }
         } else {
            this.method521(true);
         }
      } else {
         this.method521(true);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1710618"
   )
   void method521(boolean var1) {
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(B)Lsy;",
      garbageValue = "69"
   )
   @Export("toBuffer")
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
      var1.writeByte(this.field1039);
      var1.writeByte(this.displayFps ? 1 : 0);
      var1.writeInt(this.field1032);
      return var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "1391541433"
   )
   @Export("setRoofsHidden")
   void setRoofsHidden(boolean var1) {
      this.roofsHidden = var1;
      class146.savePreferences();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1333321648"
   )
   @Export("getRoofsHidden")
   boolean getRoofsHidden() {
      return this.roofsHidden;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "278116329"
   )
   @Export("setIsUsernameHidden")
   void setIsUsernameHidden(boolean var1) {
      this.hideUsername = var1;
      class146.savePreferences();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "2098142981"
   )
   @Export("getIsUsernameHidden")
   boolean getIsUsernameHidden() {
      return this.hideUsername;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "147492823"
   )
   @Export("getTitleMusicDisabled")
   void getTitleMusicDisabled(boolean var1) {
      this.titleMusicDisabled = var1;
      class146.savePreferences();
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "846356129"
   )
   @Export("getTitleMusicDisabled")
   boolean getTitleMusicDisabled() {
      return this.titleMusicDisabled;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "-9"
   )
   void method550(boolean var1) {
      this.displayFps = var1;
      class146.savePreferences();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "0"
   )
   void method526() {
      this.method550(!this.displayFps);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "2082731266"
   )
   boolean method522() {
      return this.displayFps;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "-6657"
   )
   void method527(int var1) {
      this.field1032 = var1;
      class146.savePreferences();
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-599544988"
   )
   int method551() {
      return this.field1032;
   }

   @ObfuscatedName("am")
   @Export("setBrightness")
   void setBrightness(double var1) {
      this.brightness = var1;
      class146.savePreferences();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(B)D",
      garbageValue = "64"
   )
   @Export("getBrightness")
   double getBrightness() {
      return this.brightness;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "1"
   )
   @Export("setCurrentMusicVolume")
   void setCurrentMusicVolume(int var1) {
      this.musicVolume = var1;
      class146.savePreferences();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-348477158"
   )
   @Export("getCurrentMusicVolume")
   int getCurrentMusicVolume() {
      return this.musicVolume;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1816212673"
   )
   @Export("setCurrentSoundEffectVolume")
   void setCurrentSoundEffectVolume(int var1) {
      this.soundEffectsVolume = var1;
      class146.savePreferences();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1553842749"
   )
   @Export("getCurrentSoundEffectsVolume")
   int getCurrentSoundEffectsVolume() {
      return this.soundEffectsVolume;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1358573710"
   )
   @Export("setAreaSoundEffectsVolume")
   void setAreaSoundEffectsVolume(int var1) {
      this.areaSoundEffectsVolume = var1;
      class146.savePreferences();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "8"
   )
   @Export("getAreaSoundEffectsVolume")
   int getAreaSoundEffectsVolume() {
      return this.areaSoundEffectsVolume;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-1209475965"
   )
   @Export("setUsernameToRemember")
   void setUsernameToRemember(String var1) {
      this.rememberedUsername = var1;
      class146.savePreferences();
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "-832983404"
   )
   @Export("getUsernameToRemember")
   String getUsernameToRemember() {
      return this.rememberedUsername;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "77"
   )
   void method536(int var1) {
      this.field1039 = var1;
      class146.savePreferences();
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1119305336"
   )
   int method537() {
      return this.field1039;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "103"
   )
   void method547(int var1) {
      this.windowMode = var1;
      class146.savePreferences();
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "87"
   )
   int method538() {
      return this.windowMode;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;IB)V",
      garbageValue = "106"
   )
   void method545(String var1, int var2) {
      int var3 = this.method541(var1);
      if (this.parameters.size() >= 10 && !this.parameters.containsKey(var3)) {
         Iterator var4 = this.parameters.entrySet().iterator();
         var4.next();
         var4.remove();
      }

      this.parameters.put(var3, var2);
      class146.savePreferences();
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Z",
      garbageValue = "-763604251"
   )
   boolean method539(String var1) {
      int var2 = this.method541(var1);
      return this.parameters.containsKey(var2);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)I",
      garbageValue = "-1472188766"
   )
   int method540(String var1) {
      int var2 = this.method541(var1);
      return !this.parameters.containsKey(var2) ? 0 : (Integer)this.parameters.get(var2);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)I",
      garbageValue = "-1940131826"
   )
   int method541(String var1) {
      String var3 = var1.toLowerCase();
      int var4 = var3.length();
      int var5 = 0;

      for(int var6 = 0; var6 < var4; ++var6) {
         var5 = (var5 << 5) - var5 + var3.charAt(var6);
      }

      return var5;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "([BIII)Ljava/lang/String;",
      garbageValue = "2059491791"
   )
   static String method552(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class366.field3546[var5 >>> 2]);
         if (var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class366.field3546[(var5 & 3) << 4 | var6 >>> 4]);
            if (var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class366.field3546[(var6 & 15) << 2 | var7 >>> 6]).append(class366.field3546[var7 & 63]);
            } else {
               var3.append(class366.field3546[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class366.field3546[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }
}
