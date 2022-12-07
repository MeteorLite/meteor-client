import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
public abstract class AbstractArchive {
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Lrr;"
   )
   static GZipDecompressor gzipDecompressor = new GZipDecompressor();
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -373211487
   )
   static int field4213 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -195992711
   )
   int groupCount;
   @ObfuscatedName("l")
   int[] groupIds;
   @ObfuscatedName("t")
   int[] groupNameHashes;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "Lrc;"
   )
   IntHashTable groupNameHashTable;
   @ObfuscatedName("p")
   int[] groupCrcs;
   @ObfuscatedName("d")
   int[] groupVersions;
   @ObfuscatedName("y")
   int[] fileCounts;
   @ObfuscatedName("z")
   int[][] fileIds;
   @ObfuscatedName("w")
   int[][] fileNameHashes;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "[Lrc;"
   )
   IntHashTable[] fileNameHashTables;
   @ObfuscatedName("ad")
   Object[] groups;
   @ObfuscatedName("ao")
   Object[][] files;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1772103585
   )
   public int hash;
   @ObfuscatedName("au")
   boolean releaseGroups;
   @ObfuscatedName("ar")
   boolean shallowFiles;

   AbstractArchive(boolean var1, boolean var2) {
      this.releaseGroups = var1;
      this.shallowFiles = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-25"
   )
   void loadRegionFromGroup(int var1) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "1"
   )
   void loadGroup(int var1) {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "266817"
   )
   int groupLoadPercent(int var1) {
      return this.groups[var1] != null ? 100 : 0;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "([BI)V",
      garbageValue = "-1924766663"
   )
   void decodeIndex(byte[] var1) {
      this.hash = class343.method6673(var1, var1.length);
      Buffer var2 = new Buffer(WorldMapCacheName.decompressBytes(var1));
      int var3 = var2.readUnsignedByte();
      if (var3 >= 5 && var3 <= 7) {
         if (var3 >= 6) {
            var2.readInt();
         }

         int var4 = var2.readUnsignedByte();
         if (var3 >= 7) {
            this.groupCount = var2.method8612();
         } else {
            this.groupCount = var2.readUnsignedShort();
         }

         int var5 = 0;
         int var6 = -1;
         this.groupIds = new int[this.groupCount];
         int var7;
         if (var3 >= 7) {
            for(var7 = 0; var7 < this.groupCount; ++var7) {
               this.groupIds[var7] = var5 += var2.method8612();
               if (this.groupIds[var7] > var6) {
                  var6 = this.groupIds[var7];
               }
            }
         } else {
            for(var7 = 0; var7 < this.groupCount; ++var7) {
               this.groupIds[var7] = var5 += var2.readUnsignedShort();
               if (this.groupIds[var7] > var6) {
                  var6 = this.groupIds[var7];
               }
            }
         }

         this.groupCrcs = new int[var6 + 1];
         this.groupVersions = new int[var6 + 1];
         this.fileCounts = new int[var6 + 1];
         this.fileIds = new int[var6 + 1][];
         this.groups = new Object[var6 + 1];
         this.files = new Object[var6 + 1][];
         if (var4 != 0) {
            this.groupNameHashes = new int[var6 + 1];

            for(var7 = 0; var7 < this.groupCount; ++var7) {
               this.groupNameHashes[this.groupIds[var7]] = var2.readInt();
            }

            this.groupNameHashTable = new IntHashTable(this.groupNameHashes);
         }

         for(var7 = 0; var7 < this.groupCount; ++var7) {
            this.groupCrcs[this.groupIds[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.groupCount; ++var7) {
            this.groupVersions[this.groupIds[var7]] = var2.readInt();
         }

         for(var7 = 0; var7 < this.groupCount; ++var7) {
            this.fileCounts[this.groupIds[var7]] = var2.readUnsignedShort();
         }

         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         if (var3 >= 7) {
            for(var7 = 0; var7 < this.groupCount; ++var7) {
               var8 = this.groupIds[var7];
               var9 = this.fileCounts[var8];
               var5 = 0;
               var10 = -1;
               this.fileIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.fileIds[var8][var11] = var5 += var2.method8612();
                  if (var12 > var10) {
                     var10 = var12;
                  }
               }

               this.files[var8] = new Object[var10 + 1];
            }
         } else {
            for(var7 = 0; var7 < this.groupCount; ++var7) {
               var8 = this.groupIds[var7];
               var9 = this.fileCounts[var8];
               var5 = 0;
               var10 = -1;
               this.fileIds[var8] = new int[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  var12 = this.fileIds[var8][var11] = var5 += var2.readUnsignedShort();
                  if (var12 > var10) {
                     var10 = var12;
                  }
               }

               this.files[var8] = new Object[var10 + 1];
            }
         }

         if (var4 != 0) {
            this.fileNameHashes = new int[var6 + 1][];
            this.fileNameHashTables = new IntHashTable[var6 + 1];

            for(var7 = 0; var7 < this.groupCount; ++var7) {
               var8 = this.groupIds[var7];
               var9 = this.fileCounts[var8];
               this.fileNameHashes[var8] = new int[this.files[var8].length];

               for(var10 = 0; var10 < var9; ++var10) {
                  this.fileNameHashes[var8][this.fileIds[var8][var10]] = var2.readInt();
               }

               this.fileNameHashTables[var8] = new IntHashTable(this.fileNameHashes[var8]);
            }
         }

      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(IIB)[B",
      garbageValue = "1"
   )
   public byte[] takeFile(int var1, int var2) {
      return this.takeFileEncrypted(var1, var2, (int[])null);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(II[II)[B",
      garbageValue = "810907384"
   )
   public byte[] takeFileEncrypted(int var1, int var2, int[] var3) {
      if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
         if (this.files[var1][var2] == null) {
            boolean var4 = this.buildFiles(var1, var3);
            if (!var4) {
               this.loadGroup(var1);
               var4 = this.buildFiles(var1, var3);
               if (!var4) {
                  return null;
               }
            }
         }

         byte[] var5 = Frames.method4623(this.files[var1][var2], false);
         if (this.shallowFiles) {
            this.files[var1][var2] = null;
         }

         return var5;
      } else {
         return null;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(IIB)Z",
      garbageValue = "1"
   )
   public boolean tryLoadFile(int var1, int var2) {
      if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
         if (this.files[var1][var2] != null) {
            return true;
         } else if (this.groups[var1] != null) {
            return true;
         } else {
            this.loadGroup(var1);
            return this.groups[var1] != null;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "578203362"
   )
   public boolean method6505(int var1) {
      if (this.files.length == 1) {
         return this.tryLoadFile(0, var1);
      } else if (this.files[var1].length == 1) {
         return this.tryLoadFile(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1251168431"
   )
   public boolean tryLoadGroup(int var1) {
      if (this.groups[var1] != null) {
         return true;
      } else {
         this.loadGroup(var1);
         return this.groups[var1] != null;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "10470008"
   )
   public boolean isFullyLoaded() {
      boolean var1 = true;

      for(int var2 = 0; var2 < this.groupIds.length; ++var2) {
         int var3 = this.groupIds[var2];
         if (this.groups[var3] == null) {
            this.loadGroup(var3);
            if (this.groups[var3] == null) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(II)[B",
      garbageValue = "794449412"
   )
   public byte[] takeFileFlat(int var1) {
      if (this.files.length == 1) {
         return this.takeFile(0, var1);
      } else if (this.files[var1].length == 1) {
         return this.takeFile(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(III)[B",
      garbageValue = "-1368832269"
   )
   public byte[] getFile(int var1, int var2) {
      if (var1 >= 0 && var1 < this.files.length && this.files[var1] != null && var2 >= 0 && var2 < this.files[var1].length) {
         if (this.files[var1][var2] == null) {
            boolean var3 = this.buildFiles(var1, (int[])null);
            if (!var3) {
               this.loadGroup(var1);
               var3 = this.buildFiles(var1, (int[])null);
               if (!var3) {
                  return null;
               }
            }
         }

         byte[] var4 = Frames.method4623(this.files[var1][var2], false);
         return var4;
      } else {
         return null;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(IB)[B",
      garbageValue = "-88"
   )
   public byte[] getFileFlat(int var1) {
      if (this.files.length == 1) {
         return this.getFile(0, var1);
      } else if (this.files[var1].length == 1) {
         return this.getFile(var1, 0);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(II)[I",
      garbageValue = "1272729135"
   )
   public int[] getGroupFileIds(int var1) {
      return var1 >= 0 && var1 < this.fileIds.length ? this.fileIds[var1] : null;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "-89"
   )
   public int getGroupFileCount(int var1) {
      return this.files[var1].length;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "529186509"
   )
   public int getGroupCount() {
      return this.files.length;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-122"
   )
   public void clearGroups() {
      for(int var1 = 0; var1 < this.groups.length; ++var1) {
         this.groups[var1] = null;
      }

   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-41"
   )
   public void clearFilesGroup(int var1) {
      for(int var2 = 0; var2 < this.files[var1].length; ++var2) {
         this.files[var1][var2] = null;
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "2147285255"
   )
   public void clearFiles() {
      for(int var1 = 0; var1 < this.files.length; ++var1) {
         if (this.files[var1] != null) {
            for(int var2 = 0; var2 < this.files[var1].length; ++var2) {
               this.files[var1][var2] = null;
            }
         }
      }

   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "(I[IB)Z",
      garbageValue = "83"
   )
   boolean buildFiles(int var1, int[] var2) {
      if (this.groups[var1] == null) {
         return false;
      } else {
         int var3 = this.fileCounts[var1];
         int[] var4 = this.fileIds[var1];
         Object[] var5 = this.files[var1];
         boolean var6 = true;

         for(int var7 = 0; var7 < var3; ++var7) {
            if (var5[var4[var7]] == null) {
               var6 = false;
               break;
            }
         }

         if (var6) {
            return true;
         } else {
            byte[] var21;
            if (var2 == null || var2[0] == 0 && var2[1] == 0 && var2[2] == 0 && var2[3] == 0) {
               var21 = Frames.method4623(this.groups[var1], false);
            } else {
               var21 = Frames.method4623(this.groups[var1], true);
               Buffer var8 = new Buffer(var21);
               var8.xteaDecrypt(var2, 5, var8.array.length);
            }

            byte[] var25 = WorldMapCacheName.decompressBytes(var21);
            if (this.releaseGroups) {
               this.groups[var1] = null;
            }

            int var10;
            if (var3 > 1) {
               int var22 = var25.length;
               --var22;
               var10 = var25[var22] & 255;
               var22 -= var10 * var3 * 4;
               Buffer var11 = new Buffer(var25);
               int[] var12 = new int[var3];
               var11.offset = var22;

               int var14;
               int var15;
               for(int var13 = 0; var13 < var10; ++var13) {
                  var14 = 0;

                  for(var15 = 0; var15 < var3; ++var15) {
                     var14 += var11.readInt();
                     var12[var15] += var14;
                  }
               }

               byte[][] var23 = new byte[var3][];

               for(var14 = 0; var14 < var3; ++var14) {
                  var23[var14] = new byte[var12[var14]];
                  var12[var14] = 0;
               }

               var11.offset = var22;
               var14 = 0;

               int var17;
               for(var15 = 0; var15 < var10; ++var15) {
                  int var24 = 0;

                  for(var17 = 0; var17 < var3; ++var17) {
                     var24 += var11.readInt();
                     System.arraycopy(var25, var14, var23[var17], var12[var17], var24);
                     var12[var17] += var24;
                     var14 += var24;
                  }
               }

               for(var15 = 0; var15 < var3; ++var15) {
                  if (!this.shallowFiles) {
                     var17 = var4[var15];
                     byte[] var19 = var23[var15];
                     Object var18;
                     if (var19 == null) {
                        var18 = null;
                     } else if (var19.length > 136) {
                        DirectByteArrayCopier var20 = new DirectByteArrayCopier();
                        var20.set(var19);
                        var18 = var20;
                     } else {
                        var18 = var19;
                     }

                     var5[var17] = var18;
                  } else {
                     var5[var4[var15]] = var23[var15];
                  }
               }
            } else if (!this.shallowFiles) {
               var10 = var4[0];
               Object var26;
               if (var25 == null) {
                  var26 = null;
               } else if (var25.length > 136) {
                  DirectByteArrayCopier var27 = new DirectByteArrayCopier();
                  var27.set(var25);
                  var26 = var27;
               } else {
                  var26 = var25;
               }

               var5[var10] = var26;
            } else {
               var5[var4[0]] = var25;
            }

            return true;
         }
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)I",
      garbageValue = "-22"
   )
   public int getGroupId(String var1) {
      var1 = var1.toLowerCase();
      return this.groupNameHashTable.get(JagexCache.hashString(var1));
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;I)I",
      garbageValue = "1349286475"
   )
   public int getFileId(int var1, String var2) {
      var2 = var2.toLowerCase();
      return this.fileNameHashTables[var1].get(JagexCache.hashString(var2));
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;S)Z",
      garbageValue = "-24263"
   )
   public boolean isValidFileName(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.groupNameHashTable.get(JagexCache.hashString(var1));
      if (var3 < 0) {
         return false;
      } else {
         int var4 = this.fileNameHashTables[var3].get(JagexCache.hashString(var2));
         return var4 >= 0;
      }
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;I)[B",
      garbageValue = "-1843868053"
   )
   public byte[] takeFileByNames(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.groupNameHashTable.get(JagexCache.hashString(var1));
      int var4 = this.fileNameHashTables[var3].get(JagexCache.hashString(var2));
      return this.takeFile(var3, var4);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1466516863"
   )
   public boolean tryLoadFileByNames(String var1, String var2) {
      var1 = var1.toLowerCase();
      var2 = var2.toLowerCase();
      int var3 = this.groupNameHashTable.get(JagexCache.hashString(var1));
      int var4 = this.fileNameHashTables[var3].get(JagexCache.hashString(var2));
      return this.tryLoadFile(var3, var4);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Z",
      garbageValue = "-1678206543"
   )
   public boolean tryLoadGroupByName(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.groupNameHashTable.get(JagexCache.hashString(var1));
      return this.tryLoadGroup(var2);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "1932463857"
   )
   public void loadRegionFromName(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.groupNameHashTable.get(JagexCache.hashString(var1));
      if (var2 >= 0) {
         this.loadRegionFromGroup(var2);
      }
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)I",
      garbageValue = "-90"
   )
   public int groupLoadPercentByName(String var1) {
      var1 = var1.toLowerCase();
      int var2 = this.groupNameHashTable.get(JagexCache.hashString(var1));
      return this.groupLoadPercent(var2);
   }
}
