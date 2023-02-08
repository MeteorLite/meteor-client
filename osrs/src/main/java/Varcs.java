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
@ObfuscatedName("dw")
@Implements("Varcs")
public class Varcs {
   @ObfuscatedName("b")
   public static short[][] field1116;
    @ObfuscatedName("v")
    boolean[] intsPersistence;
    @ObfuscatedName("s")
    Map map;
   /** @deprecated */
   @ObfuscatedName("z")
   String[] strings;
    @ObfuscatedName("j")
    boolean unwrittenChanges = false;
   @ObfuscatedName("i")
   long field1111;

   Varcs() {
      int var1 = class372.archive2.getGroupFileCount(19);
      this.map = new HashMap();
      this.intsPersistence = new boolean[var1];

      int var2;
      for(var2 = 0; var2 < var1; ++var2) {
         VarcInt var4 = (VarcInt)VarcInt.VarcInt_cached.get((long)var2);
         VarcInt var3;
         if (var4 != null) {
            var3 = var4;
         } else {
            byte[] var5 = VarcInt.VarcInt_archive.takeFile(19, var2);
            var4 = new VarcInt();
            if (var5 != null) {
               var4.method930(new Buffer(var5));
            }

            VarcInt.VarcInt_cached.put(var4, (long)var2);
            var3 = var4;
         }

         this.intsPersistence[var2] = var3.persist;
      }

      var2 = 0;
      if (class372.archive2.method1800(15)) {
         var2 = class372.archive2.getGroupFileCount(15);
      }

      this.strings = new String[var2];
      this.read();
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(III)V",
            garbageValue = "673007191"
    )
    void setInt(int var1, int var2) {
      this.map.put(var1, var2);
      if (this.intsPersistence[var1]) {
         this.unwrittenChanges = true;
      }

   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(II)I",
            garbageValue = "165690125"
    )
    int getInt(int var1) {
      Object var2 = this.map.get(var1);
      return var2 instanceof Integer ? (Integer)var2 : -1;
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(ILjava/lang/String;I)V",
            garbageValue = "-1857512946"
    )
    void setString(int var1, String var2) {
      this.map.put(var1, var2);
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(IB)Ljava/lang/String;",
            garbageValue = "3"
    )
    String getString(int var1) {
      Object var2 = this.map.get(var1);
      return var2 instanceof String ? (String)var2 : "";
   }

   /** @deprecated */
   @Deprecated
   @ObfuscatedName("z")
   @ObfuscatedSignature(
           descriptor = "(ILjava/lang/String;I)V",
           garbageValue = "2075821296"
   )
   void setStringOld(int var1, String var2) {
      this.strings[var1] = var2;
   }

   /** @deprecated */
   @Deprecated
   @ObfuscatedName("j")
   @ObfuscatedSignature(
           descriptor = "(II)Ljava/lang/String;",
           garbageValue = "1364685302"
   )
   String getStringOld(int var1) {
      return this.strings[var1];
   }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "1996405903"
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

    @ObfuscatedName("n")
    @ObfuscatedSignature(
            descriptor = "(ZI)Lqr;",
            garbageValue = "-836020576"
    )
    AccessFile getPreferencesFile(boolean var1) {
      return UrlRequester.getPreferencesFile("2", class134.field1270.name, var1);
   }

    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "43"
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
                  var2 += class96.stringCp1252NullTerminatedByteSize((String)var7);
               }

               ++var3;
            }
         }

         Buffer var26 = new Buffer(var2);
         var26.writeByte(2);
         var26.writeShort(var3);
         Iterator var27 = this.map.entrySet().iterator();

         while(var27.hasNext()) {
            Entry var15 = (Entry)var27.next();
            int var16 = (Integer)var15.getKey();
            if (this.intsPersistence[var16]) {
               var26.writeShort(var16);
               Object var8 = var15.getValue();
               class463 var9 = class463.method2341(var8.getClass());
               var26.writeByte(var9.field3978);
               Class var11 = var8.getClass();
               class463 var12 = class463.method2341(var11);
               if (var12 == null) {
                  throw new IllegalArgumentException();
               }

               class459 var10 = var12.field3982;
               var10.vmethod8274(var8, var26);
            }
         }

         var1.write(var26.array, 0, var26.offset);
      } catch (Exception var24) {
         ;
      } finally {
         try {
            var1.close();
         } catch (Exception var23) {
            ;
         }

      }

      this.unwrittenChanges = false;
      this.field1111 = class153.clockNow();
   }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-927723462"
    )
    void read() {
      AccessFile var1 = this.getPreferencesFile(false);

      label210: {
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
               if (var15 < 0 || var15 > 2) {
                  return;
               }

               int var7;
               int var8;
               int var9;
               int var16;
               if (var15 >= 2) {
                  var16 = var14.readUnsignedShort();
                  var7 = 0;

                  while(true) {
                     if (var7 >= var16) {
                        break label210;
                     }

                     var8 = var14.readUnsignedShort();
                     var9 = var14.readUnsignedByte();
                     class463 var10 = (class463)class4.findEnumerated(class463.method2337(), var9);
                     Object var11 = var10.method2339(var14);
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
                        break label210;
                     }

                     var14.readUnsignedShort();
                     var14.readStringCp1252NullTerminated();
                     ++var8;
                  }
               }
            }
         } catch (Exception var25) {
            break label210;
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

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "247889880"
    )
    void tryWrite() {
      if (this.unwrittenChanges && this.field1111 < class153.clockNow() - 60000L) {
         this.write();
      }

   }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "(B)Z",
            garbageValue = "0"
    )
    boolean hasUnwrittenChanges() {
      return this.unwrittenChanges;
   }
}
