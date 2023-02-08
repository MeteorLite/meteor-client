import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class122 {
   @ObfuscatedName("f")
   public final int field1184;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Ldc;"
   )
   public class122 field1192;
   @ObfuscatedName("v")
   float[][] field1181;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "[Lpb;"
   )
   final class417[] field1182;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "[Lpb;"
   )
   class417[] field1183;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "[Lpb;"
   )
   class417[] field1188;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Lpb;"
   )
   class417 field1189 = new class417();
   @ObfuscatedName("n")
   boolean field1186 = true;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "Lpb;"
   )
   class417 field1187 = new class417();
   @ObfuscatedName("k")
   boolean field1179 = true;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "Lpb;"
   )
   class417 field1180 = new class417();
   @ObfuscatedName("r")
   float[][] field1190;
   @ObfuscatedName("b")
   float[][] field1191;
   @ObfuscatedName("m")
   float[][] field1185;

   @ObfuscatedSignature(
      descriptor = "(ILrd;Z)V"
   )
   public class122(int var1, Buffer var2, boolean var3) {
      this.field1184 = var2.readShort();
      this.field1182 = new class417[var1];
      this.field1183 = new class417[this.field1182.length];
      this.field1188 = new class417[this.field1182.length];
      this.field1181 = new float[this.field1182.length][3];

      for(int var4 = 0; var4 < this.field1182.length; ++var4) {
         this.field1182[var4] = new class417(var2, var3);
         this.field1181[var4][0] = var2.method2428();
         this.field1181[var4][1] = var2.method2428();
         this.field1181[var4][2] = var2.method2428();
      }

      this.method683();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1603384529"
   )
   void method683() {
      this.field1190 = new float[this.field1182.length][3];
      this.field1191 = new float[this.field1182.length][3];
      this.field1185 = new float[this.field1182.length][3];
      class417[] var2 = class417.field3775;
      class417 var1;
      synchronized(class417.field3775) {
         if (class417.field3777 == 0) {
            var1 = new class417();
         } else {
            class417.field3775[--class417.field3777].method2187();
            var1 = class417.field3775[class417.field3777];
         }
      }

      class417 var7 = var1;

      for(int var5 = 0; var5 < this.field1182.length; ++var5) {
         class417 var4 = this.method675(var5);
         var7.method2176(var4);
         var7.method2181();
         this.field1190[var5] = var7.method2174();
         this.field1191[var5][0] = var4.field3778[12];
         this.field1191[var5][1] = var4.field3778[13];
         this.field1191[var5][2] = var4.field3778[14];
         this.field1185[var5] = var4.method2183();
      }

      var7.method2172();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(II)Lpb;",
      garbageValue = "1996728703"
   )
   class417 method675(int var1) {
      return this.field1182[var1];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(II)Lpb;",
      garbageValue = "714615016"
   )
   class417 method684(int var1) {
      if (this.field1183[var1] == null) {
         this.field1183[var1] = new class417(this.method675(var1));
         if (this.field1192 != null) {
            this.field1183[var1].method2175(this.field1192.method684(var1));
         } else {
            this.field1183[var1].method2175(class417.field3779);
         }
      }

      return this.field1183[var1];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(IB)Lpb;",
      garbageValue = "-28"
   )
   class417 method685(int var1) {
      if (this.field1188[var1] == null) {
         this.field1188[var1] = new class417(this.method684(var1));
         this.field1188[var1].method2181();
      }

      return this.field1188[var1];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(Lpb;I)V",
      garbageValue = "832632914"
   )
   void method676(class417 var1) {
      this.field1189.method2176(var1);
      this.field1186 = true;
      this.field1179 = true;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(I)Lpb;",
      garbageValue = "1963000555"
   )
   class417 method677() {
      return this.field1189;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(I)Lpb;",
      garbageValue = "1304604327"
   )
   class417 method680() {
      if (this.field1186) {
         this.field1187.method2176(this.method677());
         if (this.field1192 != null) {
            this.field1187.method2175(this.field1192.method680());
         }

         this.field1186 = false;
      }

      return this.field1187;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(IB)Lpb;",
      garbageValue = "20"
   )
   public class417 method678(int var1) {
      if (this.field1179) {
         this.field1180.method2176(this.method685(var1));
         this.field1180.method2175(this.method680());
         this.field1179 = false;
      }

      return this.field1180;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(II)[F",
      garbageValue = "-1657522001"
   )
   float[] method679(int var1) {
      return this.field1190[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(II)[F",
      garbageValue = "1874306129"
   )
   float[] method682(int var1) {
      return this.field1191[var1];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(IB)[F",
      garbageValue = "38"
   )
   float[] method681(int var1) {
      return this.field1185[var1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(II)Lgi;",
      garbageValue = "-1237924055"
   )
   public static HealthBarDefinition method687(int var0) {
      HealthBarDefinition var1 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = class303.HealthBarDefinition_archive.takeFile(33, var0);
         var1 = new HealthBarDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         HealthBarDefinition.HealthBarDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)[Ldx;",
      garbageValue = "-13"
   )
   static class127[] method688() {
      return new class127[]{class127.field1244, class127.field1237, class127.field1246, class127.field1238, class127.field1240, class127.field1256, class127.field1242, class127.field1243, class127.field1239, class127.field1245, class127.field1241, class127.field1247, class127.field1248, class127.field1249, class127.field1250, class127.field1251, class127.field1252};
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-955503656"
   )
   static void method689(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      NetFileRequest var4 = (NetFileRequest)NetCache.NetCache_pendingWrites.get(var2);
      if (var4 != null) {
         NetCache.NetCache_pendingWritesQueue.addLast(var4);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "593870439"
   )
   static int method686(int var0, Script var1, boolean var2) {
      if (var0 == 3200) {
         class302.Interpreter_intStackSize -= 3;
         class275.queueSoundEffect(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2]);
         return 1;
      } else if (var0 == 3201) {
         SpriteMask.playSong(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
         return 1;
      } else if (var0 == 3202) {
         class302.Interpreter_intStackSize -= 2;
         ScriptEvent.playJingle(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]);
         return 1;
      } else {
         class86 var3;
         class85 var4;
         int var5;
         int var6;
         String var7;
         if (var0 != 3212 && var0 != 3213 && var0 != 3209 && var0 != 3181 && var0 != 3203 && var0 != 3205 && var0 != 3207) {
            if (var0 != 3214 && var0 != 3215 && var0 != 3210 && var0 != 3182 && var0 != 3204 && var0 != 3206 && var0 != 3208) {
               return var0 == 3211 ? 1 : 2;
            } else {
               var3 = class86.field883;
               var4 = class85.field878;
               boolean var8 = false;
               if (var0 == 3214) {
                  var6 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  var3 = (class86)class4.findEnumerated(PacketBufferNode.method1537(), var6);
                  if (var3 == null) {
                     throw new RuntimeException(String.format("Unrecognized device option %d", var6));
                  }
               }

               if (var0 == 3215) {
                  var6 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  var4 = (class85)class4.findEnumerated(class135.method736(), var6);
                  if (var4 == null) {
                     throw new RuntimeException(String.format("Unrecognized game option %d", var6));
                  }
               }

               if (var0 == 3210) {
                  var6 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  var3 = (class86)class4.findEnumerated(PacketBufferNode.method1537(), var6);
                  if (var3 == null) {
                     var4 = (class85)class4.findEnumerated(class135.method736(), var6);
                     if (var4 == null) {
                        throw new RuntimeException(String.format("Unrecognized client option %d", var6));
                     }
                  }
               } else if (var0 == 3182) {
                  var3 = class86.field888;
               } else if (var0 == 3204) {
                  var4 = class85.field875;
               } else if (var0 == 3206) {
                  var4 = class85.field881;
               } else if (var0 == 3208) {
                  var4 = class85.field876;
               }

               if (var4 == class85.field878) {
                  switch(var3.field889) {
                  case 1:
                     var5 = PacketWriter.clientPreferences.getIsUsernameHidden() ? 1 : 0;
                     break;
                  case 2:
                     var5 = PacketWriter.clientPreferences.getTitleMusicDisabled() ? 1 : 0;
                     break;
                  case 3:
                     var5 = PacketWriter.clientPreferences.method526() ? 1 : 0;
                     break;
                  case 4:
                     var5 = PacketWriter.clientPreferences.method528();
                     break;
                  case 5:
                     var5 = class463.method2340();
                     break;
                  default:
                     var7 = String.format("Unkown device option: %s.", var3.toString());
                     throw new RuntimeException(var7);
                  }
               } else {
                  switch(var4.field877) {
                  case 1:
                     var5 = PacketWriter.clientPreferences.getRoofsHidden() ? 1 : 0;
                     break;
                  case 2:
                     var6 = PacketWriter.clientPreferences.getCurrentMusicVolume();
                     var5 = Math.round((float)(var6 * 100) / 255.0F);
                     break;
                  case 3:
                     var6 = PacketWriter.clientPreferences.getCurrentSoundEffectsVolume();
                     var5 = Math.round((float)(var6 * 100) / 127.0F);
                     break;
                  case 4:
                     var6 = PacketWriter.clientPreferences.getAreaSoundEffectsVolume();
                     var5 = Math.round((float)(var6 * 100) / 127.0F);
                     break;
                  default:
                     var7 = String.format("Unkown game option: %s.", var4.toString());
                     throw new RuntimeException(var7);
                  }
               }

               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var5;
               return 1;
            }
         } else {
            var3 = class86.field883;
            var4 = class85.field878;
            var5 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            if (var0 == 3212) {
               var6 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               var3 = (class86)class4.findEnumerated(PacketBufferNode.method1537(), var6);
               if (var3 == null) {
                  throw new RuntimeException(String.format("Unrecognized device option %d", var6));
               }
            }

            if (var0 == 3213) {
               var6 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               var4 = (class85)class4.findEnumerated(class135.method736(), var6);
               if (var4 == null) {
                  throw new RuntimeException(String.format("Unrecognized game option %d", var6));
               }
            }

            if (var0 == 3209) {
               var6 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
               var3 = (class86)class4.findEnumerated(PacketBufferNode.method1537(), var6);
               if (var3 == null) {
                  var4 = (class85)class4.findEnumerated(class135.method736(), var6);
                  if (var4 == null) {
                     throw new RuntimeException(String.format("Unrecognized client option %d", var6));
                  }
               }
            } else if (var0 == 3181) {
               var3 = class86.field888;
            } else if (var0 == 3203) {
               var4 = class85.field875;
            } else if (var0 == 3205) {
               var4 = class85.field881;
            } else if (var0 == 3207) {
               var4 = class85.field876;
            }

            if (var4 == class85.field878) {
               switch(var3.field889) {
               case 1:
                  PacketWriter.clientPreferences.setIsUsernameHidden(var5 == 1);
                  break;
               case 2:
                  PacketWriter.clientPreferences.getTitleMusicDisabled(var5 == 1);
                  break;
               case 3:
                  PacketWriter.clientPreferences.method524(var5 == 1);
                  break;
               case 4:
                  if (var5 < 0) {
                     var5 = 0;
                  }

                  PacketWriter.clientPreferences.method527(var5);
                  break;
               case 5:
                  LoginScreenAnimation.method516(var5);
                  break;
               default:
                  var7 = String.format("Unkown device option: %s.", var3.toString());
                  throw new RuntimeException(var7);
               }
            } else {
               switch(var4.field877) {
               case 1:
                  PacketWriter.clientPreferences.setRoofsHidden(var5 == 1);
                  break;
               case 2:
                  var5 = Math.min(Math.max(var5, 0), 100);
                  var6 = Math.round((float)(var5 * 255) / 100.0F);
                  Player.method488(var6);
                  break;
               case 3:
                  var5 = Math.min(Math.max(var5, 0), 100);
                  var6 = Math.round((float)(var5 * 127) / 100.0F);
                  class203.method1073(var6);
                  break;
               case 4:
                  var5 = Math.min(Math.max(var5, 0), 100);
                  var6 = Math.round((float)(var5 * 127) / 100.0F);
                  NPC.method575(var6);
                  break;
               default:
                  var7 = String.format("Unkown game option: %s.", var4.toString());
                  throw new RuntimeException(var7);
               }
            }

            return 1;
         }
      }
   }
}
