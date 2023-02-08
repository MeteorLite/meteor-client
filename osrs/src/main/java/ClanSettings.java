import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("ClanSettings")
public class ClanSettings {
    @ObfuscatedName("jq")
    static int cameraX;
    @ObfuscatedName("w")
    boolean useHashes;
    @ObfuscatedName("v")
    boolean useNames;
   @ObfuscatedName("s")
   long field1342;
   @ObfuscatedName("z")
   int field1343 = 0;
    @ObfuscatedName("j")
    public String name = null;
   @ObfuscatedName("i")
   int field1345 = 0;
    @ObfuscatedName("n")
    public boolean allowGuests;
   @ObfuscatedName("l")
   public byte field1347;
   @ObfuscatedName("k")
   public byte field1363;
   @ObfuscatedName("c")
   public byte field1359;
   @ObfuscatedName("r")
   public byte field1349;
    @ObfuscatedName("b")
    public int memberCount;
    @ObfuscatedName("m")
    long[] memberHashes;
    @ObfuscatedName("t")
    public byte[] memberRanks;
    @ObfuscatedName("h")
    int[] sortedMembers;
   @ObfuscatedName("p")
   int[] field1354;
   @ObfuscatedName("o")
   public int[] field1355;
   @ObfuscatedName("u")
   public boolean[] field1356;
    @ObfuscatedName("x")
    public int currentOwner = -1;
   @ObfuscatedName("a")
   public int field1358 = -1;
    @ObfuscatedName("q")
    public int bannedMemberCount;
    @ObfuscatedName("d")
    long[] bannedMemberHashes;
    @ObfuscatedName("e")
    public String[] memberNames;
    @ObfuscatedName("g")
    public String[] bannedMemberNames;
    @ObfuscatedName("y")
    @ObfuscatedSignature(
            descriptor = "Lqu;"
    )
    IterableNodeHashTable parameters;

   @ObfuscatedSignature(
      descriptor = "(Lrd;)V"
   )
   public ClanSettings(Buffer var1) {
      this.method803(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-139593993"
   )
   void method807(int var1) {
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

      if (this.field1354 != null) {
         System.arraycopy(this.field1354, 0, this.field1354 = new int[var1], 0, this.memberCount);
      } else {
         this.field1354 = new int[var1];
      }

      if (this.field1355 != null) {
         System.arraycopy(this.field1355, 0, this.field1355 = new int[var1], 0, this.memberCount);
      } else {
         this.field1355 = new int[var1];
      }

      if (this.field1356 != null) {
         System.arraycopy(this.field1356, 0, this.field1356 = new boolean[var1], 0, this.memberCount);
      } else {
         this.field1356 = new boolean[var1];
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1554618972"
   )
   void method798(int var1) {
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)I",
      garbageValue = "1098460015"
   )
   public int method808(String var1) {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(IIIB)I",
      garbageValue = "-28"
   )
   public int method790(int var1, int var2, int var3) {
      int var4 = var3 == 31 ? -1 : (1 << var3 + 1) - 1;
      return (this.field1354[var1] & var4) >>> var2;
   }

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(II)Ljava/lang/Integer;",
            garbageValue = "-1228062939"
    )
    public Integer getTitleGroupValue(int var1) {
      if (this.parameters == null) {
         return null;
      } else {
         Node var2 = this.parameters.get((long)var1);
         return var2 != null && var2 instanceof IntegerNode ? new Integer(((IntegerNode)var2).integer) : null;
      }
   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(B)[I",
            garbageValue = "-5"
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
         GameObject.method1309(var1, var3, 0, var1.length - 1);
      }

      return this.sortedMembers;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(JLjava/lang/String;IB)V",
      garbageValue = "41"
   )
   void method792(long var1, String var3, int var4) {
      if (var3 != null && var3.length() == 0) {
         var3 = null;
      }

      if (this.useHashes != var1 > 0L) {
         throw new RuntimeException("");
      } else if (this.useNames != (var3 != null)) {
         throw new RuntimeException("");
      } else {
         if (var1 > 0L && (this.memberHashes == null || this.memberCount >= this.memberHashes.length) || var3 != null && (this.memberNames == null || this.memberCount >= this.memberNames.length)) {
            this.method807(this.memberCount + 5);
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

         this.field1354[this.memberCount] = 0;
         this.field1355[this.memberCount] = var4;
         this.field1356[this.memberCount] = false;
         ++this.memberCount;
         this.sortedMembers = null;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "2088665402"
   )
   void method793(int var1) {
      if (var1 >= 0 && var1 < this.memberCount) {
         --this.memberCount;
         this.sortedMembers = null;
         if (this.memberCount == 0) {
            this.memberHashes = null;
            this.memberNames = null;
            this.memberRanks = null;
            this.field1354 = null;
            this.field1355 = null;
            this.field1356 = null;
            this.currentOwner = -1;
            this.field1358 = -1;
         } else {
            System.arraycopy(this.memberRanks, var1 + 1, this.memberRanks, var1, this.memberCount - var1);
            System.arraycopy(this.field1354, var1 + 1, this.field1354, var1, this.memberCount - var1);
            System.arraycopy(this.field1355, var1 + 1, this.field1355, var1, this.memberCount - var1);
            System.arraycopy(this.field1356, var1 + 1, this.field1356, var1, this.memberCount - var1);
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

    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "934486709"
    )
    void updateOwner() {
      if (this.memberCount == 0) {
         this.currentOwner = -1;
         this.field1358 = -1;
      } else {
         this.currentOwner = -1;
         this.field1358 = -1;
         int var1 = 0;
         byte var2 = this.memberRanks[0];

         for(int var3 = 1; var3 < this.memberCount; ++var3) {
            if (this.memberRanks[var3] > var2) {
               if (var2 == 125) {
                  this.field1358 = var1;
               }

               var1 = var3;
               var2 = this.memberRanks[var3];
            } else if (this.field1358 == -1 && this.memberRanks[var3] == 125) {
               this.field1358 = var3;
            }
         }

         this.currentOwner = var1;
         if (this.currentOwner != -1) {
            this.memberRanks[this.currentOwner] = 126;
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(JLjava/lang/String;I)V",
      garbageValue = "-1469829407"
   )
   void method794(long var1, String var3) {
      if (var3 != null && var3.length() == 0) {
         var3 = null;
      }

      if (this.useHashes != var1 > 0L) {
         throw new RuntimeException("");
      } else if (var3 != null != this.useNames) {
         throw new RuntimeException("");
      } else {
         if (var1 > 0L && (this.bannedMemberHashes == null || this.bannedMemberCount >= this.bannedMemberHashes.length) || var3 != null && (this.bannedMemberNames == null || this.bannedMemberCount >= this.bannedMemberNames.length)) {
            this.method798(this.bannedMemberCount + 5);
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1220938857"
   )
   void method788(int var1) {
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(IBI)I",
      garbageValue = "1312856804"
   )
   int method804(int var1, byte var2) {
      if (var2 != 126 && var2 != 127) {
         if (this.currentOwner == var1 && (this.field1358 == -1 || this.memberRanks[this.field1358] < 125)) {
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-2036782663"
   )
   boolean method805(int var1) {
      if (this.currentOwner != var1 && this.memberRanks[var1] != 126) {
         this.memberRanks[this.currentOwner] = 125;
         this.field1358 = this.currentOwner;
         this.memberRanks[var1] = 126;
         this.currentOwner = var1;
         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(IZB)I",
      garbageValue = "7"
   )
   int method797(int var1, boolean var2) {
      if (this.field1356[var1] == var2) {
         return -1;
      } else {
         this.field1356[var1] = var2;
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(IIIII)I",
      garbageValue = "-1265657645"
   )
   int method802(int var1, int var2, int var3, int var4) {
      int var5 = (1 << var3) - 1;
      int var6 = var4 == 31 ? -1 : (1 << var4 + 1) - 1;
      int var7 = var6 ^ var5;
      var2 <<= var3;
      var2 &= var7;
      int var8 = this.field1354[var1];
      if ((var8 & var7) == var2) {
         return -1;
      } else {
         var8 &= ~var7;
         this.field1354[var1] = var8 | var2;
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "-1901194150"
   )
   boolean method795(int var1, int var2) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(IIIII)Z",
      garbageValue = "-49732436"
   )
   boolean method799(int var1, int var2, int var3, int var4) {
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

   @ObfuscatedName("o")
   boolean method800(int var1, long var2) {
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;I)Z",
      garbageValue = "-1440392993"
   )
   boolean method801(int var1, String var2) {
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Lrd;I)V",
      garbageValue = "466080590"
   )
   void method803(Buffer var1) {
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

         this.field1343 = var1.readInt();
         this.field1345 = var1.readInt();
         if (var2 <= 3 && this.field1345 != 0) {
            this.field1345 += 16912800;
         }

         this.memberCount = var1.readUnsignedShort();
         this.bannedMemberCount = var1.readUnsignedByte();
         this.name = var1.readStringCp1252NullTerminated();
         if (var2 >= 4) {
            var1.readInt();
         }

         this.allowGuests = var1.readUnsignedByte() == 1;
         this.field1347 = var1.readByte();
         this.field1363 = var1.readByte();
         this.field1359 = var1.readByte();
         this.field1349 = var1.readByte();
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

            if (this.field1354 == null || this.field1354.length < this.memberCount) {
               this.field1354 = new int[this.memberCount];
            }

            if (this.field1355 == null || this.field1355.length < this.memberCount) {
               this.field1355 = new int[this.memberCount];
            }

            if (this.field1356 == null || this.field1356.length < this.memberCount) {
               this.field1356 = new boolean[this.memberCount];
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
                  this.field1354[var4] = var1.readInt();
               }

               if (var2 >= 5) {
                  this.field1355[var4] = var1.readUnsignedShort();
               } else {
                  this.field1355[var4] = 0;
               }

               if (var2 >= 6) {
                  this.field1356[var4] = var1.readUnsignedByte() == 1;
               } else {
                  this.field1356[var4] = false;
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
               this.parameters = new IterableNodeHashTable(var4 < 16 ? class4.method5(var4) : 16);

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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(IILgt;Lgv;I)Z",
      garbageValue = "-451842817"
   )
   public static final boolean method796(int var0, int var1, RouteStrategy var2, CollisionMap var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class209.directions[var6][var7] = 99;
      class209.distances[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class209.bufferX[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class209.bufferY[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class209.bufferX[var11];
         var5 = class209.bufferY[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.xInset;
         int var14 = var5 - var3.yInset;
         if (var2.hasArrived(1, var4, var5, var3)) {
            class209.field1853 = var4;
            class209.field1854 = var5;
            return true;
         }

         int var15 = class209.distances[var16][var17] + 1;
         if (var16 > 0 && class209.directions[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class209.bufferX[var18] = var4 - 1;
            class209.bufferY[var18] = var5;
            var18 = var18 + 1 & 4095;
            class209.directions[var16 - 1][var17] = 2;
            class209.distances[var16 - 1][var17] = var15;
         }

         if (var16 < 127 && class209.directions[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class209.bufferX[var18] = var4 + 1;
            class209.bufferY[var18] = var5;
            var18 = var18 + 1 & 4095;
            class209.directions[var16 + 1][var17] = 8;
            class209.distances[var16 + 1][var17] = var15;
         }

         if (var17 > 0 && class209.directions[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class209.bufferX[var18] = var4;
            class209.bufferY[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class209.directions[var16][var17 - 1] = 1;
            class209.distances[var16][var17 - 1] = var15;
         }

         if (var17 < 127 && class209.directions[var16][var17 + 1] == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class209.bufferX[var18] = var4;
            class209.bufferY[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class209.directions[var16][var17 + 1] = 4;
            class209.distances[var16][var17 + 1] = var15;
         }

         if (var16 > 0 && var17 > 0 && class209.directions[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class209.bufferX[var18] = var4 - 1;
            class209.bufferY[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class209.directions[var16 - 1][var17 - 1] = 3;
            class209.distances[var16 - 1][var17 - 1] = var15;
         }

         if (var16 < 127 && var17 > 0 && class209.directions[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class209.bufferX[var18] = var4 + 1;
            class209.bufferY[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class209.directions[var16 + 1][var17 - 1] = 9;
            class209.distances[var16 + 1][var17 - 1] = var15;
         }

         if (var16 > 0 && var17 < 127 && class209.directions[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class209.bufferX[var18] = var4 - 1;
            class209.bufferY[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class209.directions[var16 - 1][var17 + 1] = 6;
            class209.distances[var16 - 1][var17 + 1] = var15;
         }

         if (var16 < 127 && var17 < 127 && class209.directions[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class209.bufferX[var18] = var4 + 1;
            class209.bufferY[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class209.directions[var16 + 1][var17 + 1] = 12;
            class209.distances[var16 + 1][var17 + 1] = var15;
         }
      }

      class209.field1853 = var4;
      class209.field1854 = var5;
      return false;
   }

    @ObfuscatedName("ll")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;B)V",
            garbageValue = "-18"
    )
    static final void Clan_joinChat(String var0) {
      if (!var0.equals("")) {
         PacketBufferNode var1 = Renderable.getPacketBufferNode(ClientPacket.field2528, Client.packetWriter.isaacCipher);
         var1.packetBuffer.writeByte(class96.stringCp1252NullTerminatedByteSize(var0));
         var1.packetBuffer.writeStringCp1252NullTerminated(var0);
         Client.packetWriter.addNode(var1);
      }
   }

   @ObfuscatedName("md")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "79"
   )
   static boolean method809() {
      return PacketWriter.clientPreferences.method534() >= Client.param21;
   }
}
