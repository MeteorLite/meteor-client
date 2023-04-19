import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nd")
@Implements("Archive")
public class Archive extends AbstractArchive {
   @ObfuscatedName("up")
   static int field3467;
    @ObfuscatedName("ao")
    static CRC32 Archive_crc = new CRC32();
    @ObfuscatedName("jn")
    static int[] regionLandArchiveIds;
    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "Lqk;"
    )
    ArchiveDisk archiveDisk;
    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "Lqk;"
    )
    ArchiveDisk masterDisk;
    @ObfuscatedName("al")
    int index;
   @ObfuscatedName("at")
   volatile int field3459 = 0;
   @ObfuscatedName("aa")
   boolean field3460 = false;
    @ObfuscatedName("ay")
    volatile boolean[] validGroups;
    @ObfuscatedName("ax")
    int indexCrc;
    @ObfuscatedName("ai")
    int indexVersion;
   @ObfuscatedName("ag")
   int field3462 = -1;
   @ObfuscatedName("ah")
   boolean field3465 = false;

   @ObfuscatedSignature(
      descriptor = "(Lqk;Lqk;IZZZZ)V"
   )
   public Archive(ArchiveDisk var1, ArchiveDisk var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      super(var4, var5);
      this.archiveDisk = var1;
      this.masterDisk = var2;
      this.index = var3;
      this.field3460 = var6;
      this.field3465 = var7;
      int var9 = this.index;
      if (this.field3465) {
         if (var9 <= NetCache.field3489) {
            throw new RuntimeException("");
         }

         if (var9 < NetCache.field3508) {
            NetCache.field3508 = var9;
         }
      } else {
         if (var9 >= NetCache.field3508) {
            throw new RuntimeException("");
         }

         if (var9 > NetCache.field3489) {
            NetCache.field3489 = var9;
         }
      }

      if (Login.field764 != null) {
         Login.field764.offset = var9 * 8 + 5;
         if (Login.field764.offset >= Login.field764.array.length) {
            if (!this.field3465) {
               throw new RuntimeException("");
            }

            this.method1872();
         } else {
            int var10 = Login.field764.readInt();
            int var11 = Login.field764.readInt();
            this.loadIndex(var10, var11);
         }
      } else {
         Message.requestNetFile((Archive)null, 255, 255, 0, (byte)0, true);
         NetCache.NetCache_archives[var9] = this;
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-28"
   )
   public boolean method1862() {
      return this.field3459 == 1;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "0"
    )
    public int percentage() {
      if (this.field3459 == 1 || this.field3465 && this.field3459 == 2) {
         return 100;
      } else if (super.groups != null) {
         return 99;
      } else {
         int var1 = class20.method83(255, this.index);
         if (var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "-2103539915"
    )
    void loadRegionFromGroup(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      NetFileRequest var5 = (NetFileRequest)NetCache.NetCache_pendingWrites.get(var3);
      if (var5 != null) {
         NetCache.NetCache_pendingWritesQueue.addLast(var5);
      }

   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "-1884547323"
    )
    void loadGroup(int var1) {
      if (this.archiveDisk != null && this.validGroups != null && this.validGroups[var1]) {
         ArchiveDisk var2 = this.archiveDisk;
         byte[] var4 = null;
         NodeDeque var5 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
         synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
            for(ArchiveDiskAction var6 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var6 != null; var6 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
               if (var6.key == (long)var1 && var2 == var6.archiveDisk && var6.type == 0) {
                  var4 = var6.data;
                  break;
               }
            }
         }

         if (var4 != null) {
            this.load(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.read(var1);
            this.load(var2, var1, var9, true);
         }
      } else {
         Message.requestNetFile(this, this.index, var1, super.groupCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-59"
   )
   void method1872() {
      this.field3459 = 2;
      super.groupIds = new int[0];
      super.groupCrcs = new int[0];
      super.groupVersions = new int[0];
      super.fileCounts = new int[0];
      super.fileIds = new int[0][];
      super.groups = new Object[0];
      super.files = new Object[0][];
   }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(III)V",
            garbageValue = "-691028"
    )
    void loadIndex(int var1, int var2) {
      this.indexCrc = var1;
      this.indexVersion = var2;
      if (this.masterDisk != null) {
         int var3 = this.index;
         ArchiveDisk var4 = this.masterDisk;
         byte[] var6 = null;
         NodeDeque var7 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
         synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
            for(ArchiveDiskAction var8 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var8 != null; var8 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
               if (var8.key == (long)var3 && var4 == var8.archiveDisk && var8.type == 0) {
                  var6 = var8.data;
                  break;
               }
            }
         }

         if (var6 != null) {
            this.load(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.read(var3);
            this.load(var4, var3, var11, true);
         }
      } else {
         Message.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
      }

   }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "(I[BZZI)V",
            garbageValue = "681088359"
    )
    void write(int var1, byte[] var2, boolean var3, boolean var4) {
      if (var3) {
         if (this.field3459 == 1) {
            throw new RuntimeException();
         }

         if (this.masterDisk != null) {
            MenuAction.method439(this.index, var2, this.masterDisk);
         }

         this.decodeIndex(var2);
         this.loadAllLocal();
      } else {
         var2[var2.length - 2] = (byte)(super.groupVersions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.groupVersions[var1];
         if (this.archiveDisk != null) {
            MenuAction.method439(var1, var2, this.archiveDisk);
            this.validGroups[var1] = true;
         }

         if (var4) {
            super.groups[var1] = class108.method675(var2, false);
         }
      }

   }

    @ObfuscatedName("al")
    @ObfuscatedSignature(
            descriptor = "(Lqk;I[BZB)V",
            garbageValue = "101"
    )
    public void load(ArchiveDisk var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if (var1 == this.masterDisk) {
         if (this.field3459 == 1) {
            throw new RuntimeException();
         }

         if (var3 == null) {
            Message.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
            return;
         }

         Archive_crc.reset();
         Archive_crc.update(var3, 0, var3.length);
         var5 = (int)Archive_crc.getValue();
         if (var5 != this.indexCrc) {
            Message.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
            return;
         }

         Buffer var6 = new Buffer(class13.decompressBytes(var3));
         int var7 = var6.readUnsignedByte();
         if (var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if (var7 >= 6) {
            var8 = var6.readInt();
         }

         if (var8 != this.indexVersion) {
            Message.requestNetFile(this, 255, this.index, this.indexCrc, (byte)0, true);
            return;
         }

         this.decodeIndex(var3);
         this.loadAllLocal();
      } else {
         if (!var4 && var2 == this.field3462) {
            this.field3459 = 1;
         }

         if (var3 == null || var3.length <= 2) {
            this.validGroups[var2] = false;
            if (this.field3460 || var4) {
               Message.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
            }

            return;
         }

         Archive_crc.reset();
         Archive_crc.update(var3, 0, var3.length - 2);
         var5 = (int)Archive_crc.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if (var5 != super.groupCrcs[var2] || var9 != super.groupVersions[var2]) {
            this.validGroups[var2] = false;
            if (this.field3460 || var4) {
               Message.requestNetFile(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.validGroups[var2] = true;
         if (var4) {
            super.groups[var2] = class108.method675(var3, false);
         }
      }

   }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "302914766"
    )
    void loadAllLocal() {
      this.validGroups = new boolean[super.groups.length];

      int var1;
      for(var1 = 0; var1 < this.validGroups.length; ++var1) {
         this.validGroups[var1] = false;
      }

      if (this.archiveDisk == null) {
         this.field3459 = 1;
      } else {
         this.field3462 = -1;

         for(var1 = 0; var1 < this.validGroups.length; ++var1) {
            if (super.fileCounts[var1] > 0) {
               Clips.method1361(var1, this.archiveDisk, this);
               this.field3462 = var1;
            }
         }

         if (this.field3462 == -1) {
            this.field3459 = 1;
         }

      }
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(II)I",
            garbageValue = "-1973967810"
    )
    int groupLoadPercent(int var1) {
      if (super.groups[var1] != null) {
         return 100;
      } else {
         return this.validGroups[var1] ? 100 : class20.method83(this.index, var1);
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1783984529"
   )
   public boolean method1871(int var1) {
      return this.validGroups[var1];
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1442403869"
   )
   public boolean method1870(int var1) {
      return this.getGroupFileIds(var1) != null;
   }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "4"
    )
    public int loadPercent() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.groups.length; ++var3) {
         if (super.fileCounts[var3] > 0) {
            var1 += 100;
            var2 += this.groupLoadPercent(var3);
         }
      }

      if (var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(CLnx;I)I",
            garbageValue = "-1341614150"
    )
    static int lowercaseChar(char var0, Language var1) {
      int var2 = var0 << 4;
      if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      if (var0 == 241 && var1 == Language.Language_ES) {
         var2 = 1762;
      }

      return var2;
   }
}
