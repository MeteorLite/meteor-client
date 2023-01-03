import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("ClientPreferences")
public class ClientPreferences {
   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   static Archive archive8;
   @ObfuscatedName("m")
   boolean roofsHidden;
   @ObfuscatedName("q")
   boolean hideUsername = false;
   @ObfuscatedName("f")
   boolean titleMusicDisabled;
   @ObfuscatedName("r")
   boolean displayFps = false;
   @ObfuscatedName("u")
   int field1036;
   @ObfuscatedName("b")
   double brightness = 0.8D;
   @ObfuscatedName("j")
   int musicVolume = 127;
   @ObfuscatedName("g")
   int soundEffectsVolume = 127;
   @ObfuscatedName("i")
   int areaSoundEffectsVolume = 127;
   @ObfuscatedName("o")
   int field1040 = -1;
   @ObfuscatedName("n")
   String rememberedUsername = null;
   @ObfuscatedName("k")
   int windowMode = 1;
   @ObfuscatedName("a")
   final Map parameters = new LinkedHashMap();

   ClientPreferences() {
      this.method533(true);
   }

   @ObfuscatedSignature(
      descriptor = "(Lqy;)V"
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
               this.field1040 = var1.readUnsignedByte();
            }

            if (var2 > 8) {
               this.displayFps = var1.readUnsignedByte() == 1;
            }

            if (var2 > 9) {
               this.field1036 = var1.readInt();
            }
         } else {
            this.method533(true);
         }
      } else {
         this.method533(true);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "1"
   )
   void method533(boolean var1) {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)Lqy;",
      garbageValue = "-1732648006"
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
      var1.writeByte(this.field1040);
      var1.writeByte(this.displayFps ? 1 : 0);
      var1.writeInt(this.field1036);
      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "533129640"
   )
   void setRoofsHidden(boolean var1) {
      this.roofsHidden = var1;
      Tile.savePreferences();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "105464922"
   )
   boolean getRoofsHidden() {
      return this.roofsHidden;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "64"
   )
   void setHideUsername(boolean var1) {
      this.hideUsername = var1;
      Tile.savePreferences();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1900607558"
   )
   boolean getHideUsername() {
      return this.hideUsername;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(ZB)V",
      garbageValue = "7"
   )
   void getTitleMusicDisabled(boolean var1) {
      this.titleMusicDisabled = var1;
      Tile.savePreferences();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "39"
   )
   boolean getTitleMusicDisabled() {
      return this.titleMusicDisabled;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(ZS)V",
      garbageValue = "8323"
   )
   void method559(boolean var1) {
      this.displayFps = var1;
      Tile.savePreferences();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "141048333"
   )
   void method550() {
      this.method559(!this.displayFps);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1316033707"
   )
   boolean method538() {
      return this.displayFps;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "54"
   )
   void method539(int var1) {
      this.field1036 = var1;
      Tile.savePreferences();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1786491107"
   )
   int method540() {
      return this.field1036;
   }

   @ObfuscatedName("k")
   void setBrightness(double var1) {
      this.brightness = var1;
      Tile.savePreferences();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(I)D",
      garbageValue = "2073863373"
   )
   double getBrightness() {
      return this.brightness;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "18863"
   )
   void setMusicVolume(int var1) {
      this.musicVolume = var1;
      Tile.savePreferences();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(S)I",
      garbageValue = "-5026"
   )
   int getMusicVolume() {
      return this.musicVolume;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-25"
   )
   void setSoundEffectVolume(int var1) {
      this.soundEffectsVolume = var1;
      Tile.savePreferences();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1444608091"
   )
   int getSoundEffectsVolume() {
      return this.soundEffectsVolume;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-315220076"
   )
   void setAreaSoundEffectsVolume(int var1) {
      this.areaSoundEffectsVolume = var1;
      Tile.savePreferences();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1615345308"
   )
   int getAreaSoundEffectsVolume() {
      return this.areaSoundEffectsVolume;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-2011496208"
   )
   void setRememberedUsername(String var1) {
      this.rememberedUsername = var1;
      Tile.savePreferences();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "-10"
   )
   String method548() {
      return this.rememberedUsername;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1027292403"
   )
   void method549(int var1) {
      this.field1040 = var1;
      Tile.savePreferences();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1999692147"
   )
   int method542() {
      return this.field1040;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "-9009"
   )
   void method557(int var1) {
      this.windowMode = var1;
      Tile.savePreferences();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1455962060"
   )
   int method551() {
      return this.windowMode;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;II)V",
      garbageValue = "8447783"
   )
   void method552(String var1, int var2) {
      int var3 = this.method555(var1);
      if (this.parameters.size() >= 10 && !this.parameters.containsKey(var3)) {
         Iterator var4 = this.parameters.entrySet().iterator();
         var4.next();
         var4.remove();
      }

      this.parameters.put(var3, var2);
      Tile.savePreferences();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Z",
      garbageValue = "-2059825929"
   )
   boolean method553(String var1) {
      int var2 = this.method555(var1);
      return this.parameters.containsKey(var2);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)I",
      garbageValue = "-2095892809"
   )
   int method554(String var1) {
      int var2 = this.method555(var1);
      return !this.parameters.containsKey(var2) ? 0 : (Integer)this.parameters.get(var2);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)I",
      garbageValue = "114"
   )
   int method555(String var1) {
      String var3 = var1.toLowerCase();
      int var4 = var3.length();
      int var5 = 0;

      for(int var6 = 0; var6 < var4; ++var6) {
         var5 = (var5 << 5) - var5 + var3.charAt(var6);
      }

      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "1700481860"
   )
   static int ItemContainer_getCount(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if (var2 == null) {
         return 0;
      } else {
         return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
      }
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      descriptor = "(Lct;II)V",
      garbageValue = "-935643958"
   )
   static final void method564(Actor var0, int var1) {
      ScriptFrame.worldToScreen(var0.x, var0.y, var1);
   }
}
