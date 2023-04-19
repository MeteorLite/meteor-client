import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
@Implements("ClanSettings")
public class ClanSettings {
    @ObfuscatedName("ck")
    @ObfuscatedSignature(
            descriptor = "Lnx;"
    )
    static Language clientLanguage;
    @ObfuscatedName("an")
    boolean useHashes;
    @ObfuscatedName("aw")
    boolean useNames;
   @ObfuscatedName("ac")
   long field1370;
   @ObfuscatedName("au")
   int field1354 = 0;
    @ObfuscatedName("ab")
    public String name = null;
   @ObfuscatedName("aq")
   int field1356 = 0;
    @ObfuscatedName("al")
    public boolean allowGuests;
   @ObfuscatedName("at")
   public byte field1369;
   @ObfuscatedName("aa")
   public byte field1359;
   @ObfuscatedName("ay")
   public byte field1360;
   @ObfuscatedName("ao")
   public byte field1351;
    @ObfuscatedName("ax")
    public int memberCount;
    @ObfuscatedName("ai")
    long[] memberHashes;
    @ObfuscatedName("ag")
    public byte[] memberRanks;
    @ObfuscatedName("ah")
    int[] sortedMembers;
   @ObfuscatedName("av")
   int[] field1367;
   @ObfuscatedName("ar")
   public int[] field1366;
   @ObfuscatedName("am")
   public boolean[] field1375;
    @ObfuscatedName("as")
    public int currentOwner = -1;
   @ObfuscatedName("aj")
   public int field1374 = -1;
    @ObfuscatedName("ak")
    public int bannedMemberCount;
    @ObfuscatedName("az")
    long[] bannedMemberHashes;
    @ObfuscatedName("ad")
    public String[] memberNames;
    @ObfuscatedName("ae")
    public String[] bannedMemberNames;
    @ObfuscatedName("ap")
    @ObfuscatedSignature(
            descriptor = "Lro;"
    )
    IterableNodeHashTable parameters;

   @ObfuscatedSignature(
      descriptor = "(Lsg;)V"
   )
   public ClanSettings(Buffer var1) {
      this.method864(var1);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1318866700"
   )
   void method867(int var1) {
      if (this.useHashes) {
         if (this.memberHashes != null) {
            System.arraycopy(this.memberHashes, 0, this.memberHashes = new long[var1], 0, this.memberCount);
         } else {
            this.memberHashes = new long[var1];
         }
      }

      if (this.useNames) {
         if (this.memberNames != null) {
            System.arraycopy(this.memberNames, 0, this.memberNames = new String[var1], 0, this.memberCount);
         } else {
            this.memberNames = new String[var1];
         }
      }

      if (this.memberRanks != null) {
         System.arraycopy(this.memberRanks, 0, this.memberRanks = new byte[var1], 0, this.memberCount);
      } else {
         this.memberRanks = new byte[var1];
      }

      if (this.field1367 != null) {
         System.arraycopy(this.field1367, 0, this.field1367 = new int[var1], 0, this.memberCount);
      } else {
         this.field1367 = new int[var1];
      }

      if (this.field1366 != null) {
         System.arraycopy(this.field1366, 0, this.field1366 = new int[var1], 0, this.memberCount);
      } else {
         this.field1366 = new int[var1];
      }

      if (this.field1375 != null) {
         System.arraycopy(this.field1375, 0, this.field1375 = new boolean[var1], 0, this.memberCount);
      } else {
         this.field1375 = new boolean[var1];
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-100"
   )
   void method853(int var1) {
      if (this.useHashes) {
         if (this.bannedMemberHashes != null) {
            System.arraycopy(this.bannedMemberHashes, 0, this.bannedMemberHashes = new long[var1], 0, this.bannedMemberCount);
         } else {
            this.bannedMemberHashes = new long[var1];
         }
      }

      if (this.useNames) {
         if (this.bannedMemberNames != null) {
            System.arraycopy(this.bannedMemberNames, 0, this.bannedMemberNames = new String[var1], 0, this.bannedMemberCount);
         } else {
            this.bannedMemberNames = new String[var1];
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)I",
      garbageValue = "79"
   )
   public int method851(String var1) {
      if (var1 != null && var1.length() != 0) {
         for(int var2 = 0; var2 < this.memberCount; ++var2) {
            if (this.memberNames[var2].equals(var1)) {
               return var2;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(IIIB)I",
      garbageValue = "60"
   )
   public int method852(int var1, int var2, int var3) {
      int var4 = var3 == 31 ? -1 : (1 << var3 + 1) - 1;
      return (this.field1367[var1] & var4) >>> var2;
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(IB)Ljava/lang/Integer;",
            garbageValue = "-112"
    )
    public Integer getTitleGroupValue(int var1) {
      if (this.parameters == null) {
         return null;
      } else {
         Node var2 = this.parameters.get((long)var1);
         return var2 != null && var2 instanceof IntegerNode ? new Integer(((IntegerNode)var2).integer) : null;
      }
   }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(B)[I",
            garbageValue = "33"
    )
    public int[] getSortedMembers() {
      if (this.sortedMembers == null) {
         String[] var1 = new String[this.memberCount];
         this.sortedMembers = new int[this.memberCount];

         for(int var2 = 0; var2 < this.memberCount; this.sortedMembers[var2] = var2++) {
            var1[var2] = this.memberNames[var2];
            if (var1[var2] != null) {
               var1[var2] = var1[var2].toLowerCase();
            }
         }

         int[] var3 = this.sortedMembers;
         class138.method801(var1, var3, 0, var1.length - 1);
      }

      return this.sortedMembers;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(JLjava/lang/String;II)V",
      garbageValue = "-706420067"
   )
   void method849(long var1, String var3, int var4) {
      if (var3 != null && var3.length() == 0) {
         var3 = null;
      }

      if (var1 > 0L != this.useHashes) {
         throw new RuntimeException("");
      } else if (this.useNames != (var3 != null)) {
         throw new RuntimeException("");
      } else {
         if (var1 > 0L && (this.memberHashes == null || this.memberCount >= this.memberHashes.length) || var3 != null && (this.memberNames == null || this.memberCount >= this.memberNames.length)) {
            this.method867(this.memberCount + 5);
         }

         if (this.memberHashes != null) {
            this.memberHashes[this.memberCount] = var1;
         }

         if (this.memberNames != null) {
            this.memberNames[this.memberCount] = var3;
         }

         if (this.currentOwner == -1) {
            this.currentOwner = this.memberCount;
            this.memberRanks[this.memberCount] = 126;
         } else {
            this.memberRanks[this.memberCount] = 0;
         }

         this.field1367[this.memberCount] = 0;
         this.field1366[this.memberCount] = var4;
         this.field1375[this.memberCount] = false;
         ++this.memberCount;
         this.sortedMembers = null;
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-122"
   )
   void method855(int var1) {
      if (var1 >= 0 && var1 < this.memberCount) {
         --this.memberCount;
         this.sortedMembers = null;
         if (this.memberCount == 0) {
            this.memberHashes = null;
            this.memberNames = null;
            this.memberRanks = null;
            this.field1367 = null;
            this.field1366 = null;
            this.field1375 = null;
            this.currentOwner = -1;
            this.field1374 = -1;
         } else {
            System.arraycopy(this.memberRanks, var1 + 1, this.memberRanks, var1, this.memberCount - var1);
            System.arraycopy(this.field1367, var1 + 1, this.field1367, var1, this.memberCount - var1);
            System.arraycopy(this.field1366, var1 + 1, this.field1366, var1, this.memberCount - var1);
            System.arraycopy(this.field1375, var1 + 1, this.field1375, var1, this.memberCount - var1);
            if (this.memberHashes != null) {
               System.arraycopy(this.memberHashes, var1 + 1, this.memberHashes, var1, this.memberCount - var1);
            }

            if (this.memberNames != null) {
               System.arraycopy(this.memberNames, var1 + 1, this.memberNames, var1, this.memberCount - var1);
            }

            this.updateOwner();
         }

      } else {
         throw new RuntimeException("");
      }
   }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1881573906"
    )
    void updateOwner() {
      if (this.memberCount == 0) {
         this.currentOwner = -1;
         this.field1374 = -1;
      } else {
         this.currentOwner = -1;
         this.field1374 = -1;
         int var1 = 0;
         byte var2 = this.memberRanks[0];

         for(int var3 = 1; var3 < this.memberCount; ++var3) {
            if (this.memberRanks[var3] > var2) {
               if (var2 == 125) {
                  this.field1374 = var1;
               }

               var1 = var3;
               var2 = this.memberRanks[var3];
            } else if (this.field1374 == -1 && this.memberRanks[var3] == 125) {
               this.field1374 = var3;
            }
         }

         this.currentOwner = var1;
         if (this.currentOwner != -1) {
            this.memberRanks[this.currentOwner] = 126;
         }

      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(JLjava/lang/String;I)V",
      garbageValue = "-1787643966"
   )
   void method857(long var1, String var3) {
      if (var3 != null && var3.length() == 0) {
         var3 = null;
      }

      if (var1 > 0L != this.useHashes) {
         throw new RuntimeException("");
      } else if (var3 != null != this.useNames) {
         throw new RuntimeException("");
      } else {
         if (var1 > 0L && (this.bannedMemberHashes == null || this.bannedMemberCount >= this.bannedMemberHashes.length) || var3 != null && (this.bannedMemberNames == null || this.bannedMemberCount >= this.bannedMemberNames.length)) {
            this.method853(this.bannedMemberCount + 5);
         }

         if (this.bannedMemberHashes != null) {
            this.bannedMemberHashes[this.bannedMemberCount] = var1;
         }

         if (this.bannedMemberNames != null) {
            this.bannedMemberNames[this.bannedMemberCount] = var3;
         }

         ++this.bannedMemberCount;
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-394037024"
   )
   void method858(int var1) {
      --this.bannedMemberCount;
      if (this.bannedMemberCount == 0) {
         this.bannedMemberHashes = null;
         this.bannedMemberNames = null;
      } else {
         if (this.bannedMemberHashes != null) {
            System.arraycopy(this.bannedMemberHashes, var1 + 1, this.bannedMemberHashes, var1, this.bannedMemberCount - var1);
         }

         if (this.bannedMemberNames != null) {
            System.arraycopy(this.bannedMemberNames, var1 + 1, this.bannedMemberNames, var1, this.bannedMemberCount - var1);
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(IBI)I",
      garbageValue = "-456839417"
   )
   int method866(int var1, byte var2) {
      if (var2 != 126 && var2 != 127) {
         if (this.currentOwner == var1 && (this.field1374 == -1 || this.memberRanks[this.field1374] < 125)) {
            return -1;
         } else if (this.memberRanks[var1] == var2) {
            return -1;
         } else {
            this.memberRanks[var1] = var2;
            this.updateOwner();
            return var1;
         }
      } else {
         return -1;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "-1"
   )
   boolean method850(int var1) {
      if (this.currentOwner != var1 && this.memberRanks[var1] != 126) {
         this.memberRanks[this.currentOwner] = 125;
         this.field1374 = this.currentOwner;
         this.memberRanks[var1] = 126;
         this.currentOwner = var1;
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(IZS)I",
      garbageValue = "-16552"
   )
   int method860(int var1, boolean var2) {
      if (this.field1375[var1] == var2) {
         return -1;
      } else {
         this.field1375[var1] = var2;
         return var1;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(IIIII)I",
      garbageValue = "789169188"
   )
   int method865(int var1, int var2, int var3, int var4) {
      int var5 = (1 << var3) - 1;
      int var6 = var4 == 31 ? -1 : (1 << var4 + 1) - 1;
      int var7 = var6 ^ var5;
      var2 <<= var3;
      var2 &= var7;
      int var8 = this.field1367[var1];
      if ((var8 & var7) == var2) {
         return -1;
      } else {
         var8 &= ~var7;
         this.field1367[var1] = var8 | var2;
         return var1;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "276195611"
   )
   boolean method861(int var1, int var2) {
      if (this.parameters != null) {
         Node var3 = this.parameters.get((long)var1);
         if (var3 != null) {
            if (var3 instanceof IntegerNode) {
               IntegerNode var4 = (IntegerNode)var3;
               if (var2 == var4.integer) {
                  return false;
               }

               var4.integer = var2;
               return true;
            }

            var3.remove();
         }
      } else {
         this.parameters = new IterableNodeHashTable(4);
      }

      this.parameters.put(new IntegerNode(var2), (long)var1);
      return true;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(IIIII)Z",
      garbageValue = "-458025371"
   )
   boolean method862(int var1, int var2, int var3, int var4) {
      int var5 = (1 << var3) - 1;
      int var6 = var4 == 31 ? -1 : (1 << var4 + 1) - 1;
      int var7 = var6 ^ var5;
      var2 <<= var3;
      var2 &= var7;
      if (this.parameters != null) {
         Node var8 = this.parameters.get((long)var1);
         if (var8 != null) {
            if (var8 instanceof IntegerNode) {
               IntegerNode var9 = (IntegerNode)var8;
               if ((var9.integer & var7) == var2) {
                  return false;
               }

               var9.integer &= ~var7;
               var9.integer |= var2;
               return true;
            }

            var8.remove();
         }
      } else {
         this.parameters = new IterableNodeHashTable(4);
      }

      this.parameters.put(new IntegerNode(var2), (long)var1);
      return true;
   }

   @ObfuscatedName("ar")
   boolean method859(int var1, long var2) {
      if (this.parameters != null) {
         Node var4 = this.parameters.get((long)var1);
         if (var4 != null) {
            if (var4 instanceof LongNode) {
               LongNode var5 = (LongNode)var4;
               if (var2 == var5.longValue) {
                  return false;
               }

               var5.longValue = var2;
               return true;
            }

            var4.remove();
         }
      } else {
         this.parameters = new IterableNodeHashTable(4);
      }

      this.parameters.put(new LongNode(var2), (long)var1);
      return true;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;I)Z",
      garbageValue = "1681536577"
   )
   boolean method863(int var1, String var2) {
      if (var2 == null) {
         var2 = "";
      } else if (var2.length() > 80) {
         var2 = var2.substring(0, 80);
      }

      if (this.parameters != null) {
         Node var3 = this.parameters.get((long)var1);
         if (var3 != null) {
            if (var3 instanceof ObjectNode) {
               ObjectNode var4 = (ObjectNode)var3;
               if (var4.obj instanceof String) {
                  if (var2.equals(var4.obj)) {
                     return false;
                  }

                  var4.remove();
                  this.parameters.put(new ObjectNode(var2), var4.key);
                  return true;
               }
            }

            var3.remove();
         }
      } else {
         this.parameters = new IterableNodeHashTable(4);
      }

      this.parameters.put(new ObjectNode(var2), (long)var1);
      return true;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(Lsg;B)V",
      garbageValue = "-101"
   )
   void method864(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if (var2 >= 1 && var2 <= 6) {
         int var3 = var1.readUnsignedByte();
         if ((var3 & 1) != 0) {
            this.useHashes = true;
         }

         if ((var3 & 2) != 0) {
            this.useNames = true;
         }

         if (!this.useHashes) {
            this.memberHashes = null;
            this.bannedMemberHashes = null;
         }

         if (!this.useNames) {
            this.memberNames = null;
            this.bannedMemberNames = null;
         }

         this.field1354 = var1.readInt();
         this.field1356 = var1.readInt();
         if (var2 <= 3 && this.field1356 != 0) {
            this.field1356 += 16912800;
         }

         this.memberCount = var1.readUnsignedShort();
         this.bannedMemberCount = var1.readUnsignedByte();
         this.name = var1.readStringCp1252NullTerminated();
         if (var2 >= 4) {
            var1.readInt();
         }

         this.allowGuests = var1.readUnsignedByte() == 1;
         this.field1369 = var1.readByte();
         this.field1359 = var1.readByte();
         this.field1360 = var1.readByte();
         this.field1351 = var1.readByte();
         int var4;
         if (this.memberCount > 0) {
            if (this.useHashes && (this.memberHashes == null || this.memberHashes.length < this.memberCount)) {
               this.memberHashes = new long[this.memberCount];
            }

            if (this.useNames && (this.memberNames == null || this.memberNames.length < this.memberCount)) {
               this.memberNames = new String[this.memberCount];
            }

            if (this.memberRanks == null || this.memberRanks.length < this.memberCount) {
               this.memberRanks = new byte[this.memberCount];
            }

            if (this.field1367 == null || this.field1367.length < this.memberCount) {
               this.field1367 = new int[this.memberCount];
            }

            if (this.field1366 == null || this.field1366.length < this.memberCount) {
               this.field1366 = new int[this.memberCount];
            }

            if (this.field1375 == null || this.field1375.length < this.memberCount) {
               this.field1375 = new boolean[this.memberCount];
            }

            for(var4 = 0; var4 < this.memberCount; ++var4) {
               if (this.useHashes) {
                  this.memberHashes[var4] = var1.readLong();
               }

               if (this.useNames) {
                  this.memberNames[var4] = var1.readStringCp1252NullTerminatedOrNull();
               }

               this.memberRanks[var4] = var1.readByte();
               if (var2 >= 2) {
                  this.field1367[var4] = var1.readInt();
               }

               if (var2 >= 5) {
                  this.field1366[var4] = var1.readUnsignedShort();
               } else {
                  this.field1366[var4] = 0;
               }

               if (var2 >= 6) {
                  this.field1375[var4] = var1.readUnsignedByte() == 1;
               } else {
                  this.field1375[var4] = false;
               }
            }

            this.updateOwner();
         }

         if (this.bannedMemberCount > 0) {
            if (this.useHashes && (this.bannedMemberHashes == null || this.bannedMemberHashes.length < this.bannedMemberCount)) {
               this.bannedMemberHashes = new long[this.bannedMemberCount];
            }

            if (this.useNames && (this.bannedMemberNames == null || this.bannedMemberNames.length < this.bannedMemberCount)) {
               this.bannedMemberNames = new String[this.bannedMemberCount];
            }

            for(var4 = 0; var4 < this.bannedMemberCount; ++var4) {
               if (this.useHashes) {
                  this.bannedMemberHashes[var4] = var1.readLong();
               }

               if (this.useNames) {
                  this.bannedMemberNames[var4] = var1.readStringCp1252NullTerminatedOrNull();
               }
            }
         }

         if (var2 >= 3) {
            var4 = var1.readUnsignedShort();
            if (var4 > 0) {
               this.parameters = new IterableNodeHashTable(var4 < 16 ? class70.method442(var4) : 16);

               while(var4-- > 0) {
                  int var5 = var1.readInt();
                  int var6 = var5 & 1073741823;
                  int var7 = var5 >>> 30;
                  if (var7 == 0) {
                     int var8 = var1.readInt();
                     this.parameters.put(new IntegerNode(var8), (long)var6);
                  } else if (var7 == 1) {
                     long var10 = var1.readLong();
                     this.parameters.put(new LongNode(var10), (long)var6);
                  } else if (var7 == 2) {
                     String var12 = var1.readStringCp1252NullTerminated();
                     this.parameters.put(new ObjectNode(var12), (long)var6);
                  }
               }
            }
         }

      } else {
         throw new RuntimeException("" + var2);
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(IIB)Z",
      garbageValue = "68"
   )
   static boolean method869(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "1203832974"
   )
   public static File method870(String var0, String var1, int var2) {
      String var3 = var2 == 0 ? "" : "" + var2;
      JagexCache.JagexCache_locationFile = new File(HorizontalAlignment.userHomeDirectory, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      Buffer var8;
      int var11;
      File var27;
      if (JagexCache.JagexCache_locationFile.exists()) {
         try {
            AccessFile var7 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);

            int var9;
            for(var8 = new Buffer((int)var7.length()); var8.offset < var8.array.length; var8.offset += var9) {
               var9 = var7.read(var8.array, var8.offset, var8.array.length - var8.offset);
               if (var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if (var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if (var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if (var9 <= 2) {
               var4 = var8.readStringCp1252NullCircumfixed();
               if (var10 == 1) {
                  var5 = var8.readStringCp1252NullCircumfixed();
               }
            } else {
               var4 = var8.readCESU8();
               if (var10 == 1) {
                  var5 = var8.readCESU8();
               }
            }

            var7.close();
         } catch (IOException var25) {
            var25.printStackTrace();
         }

         if (var4 != null) {
            var27 = new File(var4);
            if (!var27.exists()) {
               var4 = null;
            }
         }

         if (var4 != null) {
            var27 = new File(var4, "test.dat");

            boolean var28;
            try {
               RandomAccessFile var15 = new RandomAccessFile(var27, "rw");
               var11 = var15.read();
               var15.seek(0L);
               var15.write(var11);
               var15.seek(0L);
               var15.close();
               var27.delete();
               var28 = true;
            } catch (Exception var23) {
               var28 = false;
            }

            if (!var28) {
               var4 = null;
            }
         }
      }

      if (var4 == null && var2 == 0) {
         label154:
         for(int var16 = 0; var16 < class96.cacheSubPaths.length; ++var16) {
            for(int var17 = 0; var17 < class130.cacheParentPaths.length; ++var17) {
               File var18 = new File(class130.cacheParentPaths[var17] + class96.cacheSubPaths[var16] + File.separatorChar + var0 + File.separatorChar);
               if (var18.exists()) {
                  File var19 = new File(var18, "test.dat");

                  boolean var29;
                  try {
                     RandomAccessFile var12 = new RandomAccessFile(var19, "rw");
                     int var13 = var12.read();
                     var12.seek(0L);
                     var12.write(var13);
                     var12.seek(0L);
                     var12.close();
                     var19.delete();
                     var29 = true;
                  } catch (Exception var22) {
                     var29 = false;
                  }

                  if (var29) {
                     var4 = var18.toString();
                     var6 = true;
                     break label154;
                  }
               }
            }
         }
      }

      if (var4 == null) {
         var4 = HorizontalAlignment.userHomeDirectory + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      File var26;
      if (var5 != null) {
         var26 = new File(var5);
         var27 = new File(var4);

         try {
            File[] var33 = var26.listFiles();
            File[] var31 = var33;

            for(var11 = 0; var11 < var31.length; ++var11) {
               File var30 = var31[var11];
               File var20 = new File(var27, var30.getName());
               boolean var14 = var30.renameTo(var20);
               if (!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var24) {
            var24.printStackTrace();
         }

         var6 = true;
      }

      if (var6) {
         var26 = new File(var4);
         var8 = null;

         try {
            AccessFile var34 = new AccessFile(JagexCache.JagexCache_locationFile, "rw", 10000L);
            Buffer var32 = new Buffer(500);
            var32.writeByte(3);
            var32.writeByte(var8 != null ? 1 : 0);
            var32.writeCESU8(var26.getPath());
            if (var8 != null) {
               var32.writeCESU8("");
            }

            var34.write(var32.array, 0, var32.offset);
            var34.close();
         } catch (IOException var21) {
            var21.printStackTrace();
         }
      }

      return new File(var4);
   }
}
