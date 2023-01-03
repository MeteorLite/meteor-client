import java.io.EOFException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@Deprecated
@ObfuscatedName("dn")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("v")
   boolean[] intsPersistence;
   @ObfuscatedName("x")
   Map map;
   /** @deprecated */
   @ObfuscatedName("m")
   String[] strings;
   @ObfuscatedName("q")
   boolean unwrittenChanges = false;
   @ObfuscatedName("f")
   long field1119;

   Varcs() {
      int var1 = HitSplatDefinition.archive2.getGroupFileCount(19);
      this.map = new HashMap();
      this.intsPersistence = new boolean[var1];

      int var2;
      for(var2 = 0; var2 < var1; ++var2) {
         VarcInt var3 = ApproximateRouteStrategy.method348(var2);
         this.intsPersistence[var2] = var3.persist;
      }

      var2 = 0;
      if (HitSplatDefinition.archive2.method1791(15)) {
         var2 = HitSplatDefinition.archive2.getGroupFileCount(15);
      }

      this.strings = new String[var2];
      this.read();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1759334485"
   )
   void setInt(int var1, int var2) {
      this.map.put(var1, var2);
      if (this.intsPersistence[var1]) {
         this.unwrittenChanges = true;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-1675199100"
   )
   int getInt(int var1) {
      Object var2 = this.map.get(var1);
      return var2 instanceof Integer ? (Integer)var2 : -1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;I)V",
      garbageValue = "311729783"
   )
   void setString(int var1, String var2) {
      this.map.put(var1, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(IB)Ljava/lang/String;",
      garbageValue = "-35"
   )
   String getString(int var1) {
      Object var2 = this.map.get(var1);
      return var2 instanceof String ? (String)var2 : "";
   }

   /** @deprecated */
   @Deprecated
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;I)V",
      garbageValue = "1222873973"
   )
   void setStringOld(int var1, String var2) {
      this.strings[var1] = var2;
   }

   /** @deprecated */
   @Deprecated
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(II)Ljava/lang/String;",
      garbageValue = "1059760137"
   )
   String getStringOld(int var1) {
      return this.strings[var1];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1016231396"
   )
   void clearTransient() {
      int var1;
      for(var1 = 0; var1 < this.intsPersistence.length; ++var1) {
         if (!this.intsPersistence[var1]) {
            this.map.remove(var1);
         }
      }

      for(var1 = 0; var1 < this.strings.length; ++var1) {
         this.strings[var1] = null;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(ZB)Lqq;",
      garbageValue = "103"
   )
   AccessFile getPreferencesFile(boolean var1) {
      return class87.getPreferencesFile("2", LoginPacket.field2681.name, var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2001062355"
   )
   void write() {
      AccessFile var1 = this.getPreferencesFile(true);

      try {
         int var2 = 3;
         int var3 = 0;
         Iterator var4 = this.map.entrySet().iterator();

         while(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            int var6 = (Integer)var5.getKey();
            if (this.intsPersistence[var6]) {
               Object var7 = var5.getValue();
               var2 += 3;
               if (var7 instanceof Integer) {
                  var2 += 4;
               } else if (var7 instanceof String) {
                  var2 += class13.stringCp1252NullTerminatedByteSize((String)var7);
               }

               ++var3;
            }
         }

         Buffer var23 = new Buffer(var2);
         var23.writeByte(2);
         var23.writeShort(var3);
         Iterator var24 = this.map.entrySet().iterator();

         while(var24.hasNext()) {
            Entry var12 = (Entry)var24.next();
            int var13 = (Integer)var12.getKey();
            if (this.intsPersistence[var13]) {
               var23.writeShort(var13);
               Object var8 = var12.getValue();
               class456 var9 = class456.method2299(var8.getClass());
               var23.writeByte(var9.field3972);
               class456.method2300(var8, var23);
            }
         }

         var1.write(var23.array, 0, var23.offset);
      } catch (Exception var21) {
         ;
      } finally {
         try {
            var1.close();
         } catch (Exception var20) {
            ;
         }

      }

      this.unwrittenChanges = false;
      this.field1119 = Message.method344();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "88987164"
   )
   void read() {
      AccessFile var1 = this.getPreferencesFile(false);

      label226: {
         try {
            byte[] var2 = new byte[(int)var1.length()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.read(var2, var3, var2.length - var3);
               if (var4 == -1) {
                  throw new EOFException();
               }
            }

            Buffer var14 = new Buffer(var2);
            if (var14.array.length - var14.offset >= 1) {
               int var15 = var14.readUnsignedByte();
               if (var15 >= 0 && var15 <= 2) {
                  int var7;
                  int var8;
                  int var9;
                  int var16;
                  if (var15 >= 2) {
                     var16 = var14.readUnsignedShort();
                     var7 = 0;

                     while(true) {
                        if (var7 >= var16) {
                           break label226;
                        }

                        var8 = var14.readUnsignedShort();
                        var9 = var14.readUnsignedByte();
                        class456 var10 = (class456)World.findEnumerated(class456.method2303(), var9);
                        Object var11 = var10.method2301(var14);
                        if (this.intsPersistence[var8]) {
                           this.map.put(var8, var11);
                        }

                        ++var7;
                     }
                  } else {
                     var16 = var14.readUnsignedShort();

                     for(var7 = 0; var7 < var16; ++var7) {
                        var8 = var14.readUnsignedShort();
                        var9 = var14.readInt();
                        if (this.intsPersistence[var8]) {
                           this.map.put(var8, var9);
                        }
                     }

                     var7 = var14.readUnsignedShort();
                     var8 = 0;

                     while(true) {
                        if (var8 >= var7) {
                           break label226;
                        }

                        var14.readUnsignedShort();
                        var14.readStringCp1252NullTerminated();
                        ++var8;
                     }
                  }
               }

               return;
            }
         } catch (Exception var25) {
            break label226;
         } finally {
            try {
               var1.close();
            } catch (Exception var24) {
               ;
            }

         }

         return;
      }

      this.unwrittenChanges = false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1650356121"
   )
   void tryWrite() {
      if (this.unwrittenChanges && this.field1119 < Message.method344() - 60000L) {
         this.write();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2005809582"
   )
   boolean hasUnwrittenChanges() {
      return this.unwrittenChanges;
   }
}
