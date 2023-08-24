import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.zip.CRC32;

@ObfuscatedName("nk")
@Implements("Archive")
public class Archive extends AbstractArchive {
	@ObfuscatedName("aq")
	@Export("Archive_crc")
	static CRC32 Archive_crc;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lru;"
	)
	@Export("archiveDisk")
	ArchiveDisk archiveDisk;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lru;"
	)
	@Export("masterDisk")
	ArchiveDisk masterDisk;
	@ObfuscatedName("ap")
	@Export("index")
	int index;
	@ObfuscatedName("aa")
	volatile int field3525;
	@ObfuscatedName("af")
	boolean field3516;
	@ObfuscatedName("ad")
	@Export("validGroups")
	volatile boolean[] validGroups;
	@ObfuscatedName("al")
	@Export("indexCrc")
	int indexCrc;
	@ObfuscatedName("an")
	@Export("indexVersion")
	int indexVersion;
	@ObfuscatedName("ar")
	int field3520;
	@ObfuscatedName("ab")
	boolean field3515;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lnf;"
	)
	JagNetThread field3521;

	static {
		Archive_crc = new CRC32();
	}

	@ObfuscatedSignature(
		descriptor = "(Lru;Lru;Lnf;IZZZZ)V"
	)
	public Archive(ArchiveDisk var1, ArchiveDisk var2, JagNetThread var3, int var4, boolean var5, boolean var6, boolean var7, boolean var8) {
		super(var5, var6);
		this.field3525 = 0;
		this.field3516 = false;
		this.field3520 = -1;
		this.field3515 = false;
		this.archiveDisk = var1;
		this.masterDisk = var2;
		this.index = var4;
		this.field3516 = var7;
		this.field3515 = var8;
		this.field3521 = var3;
		this.field3521.method1934(this, this.index);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-432364648"
	)
	public boolean method1887() {
		return this.field3525 == 1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-60"
	)
	@Export("percentage")
	public int percentage() {
		if (this.field3525 == 1 || this.field3515 && this.field3525 == 2) {
			return 100;
		} else if (super.groups != null) {
			return 99;
		} else {
			int var1 = this.field3521.method1938(255, this.index);
			if (var1 >= 100) {
				var1 = 99;
			}

			return var1;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1272707955"
	)
	@Export("loadRegionFromGroup")
	void loadRegionFromGroup(int var1) {
		this.field3521.method1937(this.index, var1);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "402130956"
	)
	@Export("loadGroup")
	void loadGroup(int var1) {
		if (this.archiveDisk != null && this.validGroups != null && this.validGroups[var1]) {
			ArchiveDisk var2 = this.archiveDisk;
			byte[] var4 = null;
			synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
				for (ArchiveDiskAction var6 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var6 != null; var6 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
					if ((long)var1 == var6.key && var2 == var6.archiveDisk && var6.type == 0) {
						var4 = var6.data;
						break;
					}
				}
			}

			if (var4 != null) {
				this.load(var2, var1, var4, true);
			} else {
				byte[] var5 = var2.read(var1);
				this.load(var2, var1, var5, true);
			}
		} else {
			this.field3521.method1936(this, this.index, var1, super.groupCrcs[var1], (byte)2, true);
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	void method1891() {
		this.field3525 = 2;
		super.groupIds = new int[0];
		super.groupCrcs = new int[0];
		super.groupVersions = new int[0];
		super.fileCounts = new int[0];
		super.fileIds = new int[0][];
		super.groups = new Object[0];
		super.files = new Object[0][];
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "18"
	)
	@Export("loadIndex")
	void loadIndex(int var1, int var2) {
		this.indexCrc = var1;
		this.indexVersion = var2;
		if (this.masterDisk != null) {
			int var3 = this.index;
			ArchiveDisk var4 = this.masterDisk;
			byte[] var6 = null;
			synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
				for (ArchiveDiskAction var8 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var8 != null; var8 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
					if (var8.key == (long)var3 && var4 == var8.archiveDisk && var8.type == 0) {
						var6 = var8.data;
						break;
					}
				}
			}

			if (var6 != null) {
				this.load(var4, var3, var6, true);
			} else {
				byte[] var7 = var4.read(var3);
				this.load(var4, var3, var7, true);
			}
		} else {
			this.field3521.method1936(this, 255, this.index, this.indexCrc, (byte)0, true);
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I[BZZI)V",
		garbageValue = "1578809524"
	)
	@Export("write")
	void write(int var1, byte[] var2, boolean var3, boolean var4) {
		if (var3) {
			if (this.field3525 == 1) {
				throw new RuntimeException();
			}

			if (this.masterDisk != null) {
				int var5 = this.index;
				ArchiveDisk var6 = this.masterDisk;
				ArchiveDiskAction var7 = new ArchiveDiskAction();
				var7.type = 0;
				var7.key = (long)var5;
				var7.data = var2;
				var7.archiveDisk = var6;
				synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var7);
				}

				UserComparator8.method671();
			}

			this.decodeIndex(var2);
			this.loadAllLocal();
		} else {
			var2[var2.length - 2] = (byte)(super.groupVersions[var1] >> 8);
			var2[var2.length - 1] = (byte)super.groupVersions[var1];
			if (this.archiveDisk != null) {
				ArchiveDisk var11 = this.archiveDisk;
				ArchiveDiskAction var16 = new ArchiveDiskAction();
				var16.type = 0;
				var16.key = (long)var1;
				var16.data = var2;
				var16.archiveDisk = var11;
				synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var16);
				}

				UserComparator8.method671();
				this.validGroups[var1] = true;
			}

			if (var4) {
				Object[] var15 = super.groups;
				Object var17;
				if (var2 == null) {
					var17 = null;
				} else if (var2.length > 136) {
					DirectByteArrayCopier var8 = new DirectByteArrayCopier();
					var8.set(var2);
					var17 = var8;
				} else {
					var17 = var2;
				}

				var15[var1] = var17;
			}
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lru;I[BZI)V",
		garbageValue = "-250323664"
	)
	@Export("load")
	public void load(ArchiveDisk var1, int var2, byte[] var3, boolean var4) {
		int var5;
		if (var1 == this.masterDisk) {
			if (this.field3525 == 1) {
				throw new RuntimeException();
			} else if (var3 == null) {
				this.field3521.method1936(this, 255, this.index, this.indexCrc, (byte)0, true);
			} else {
				Archive_crc.reset();
				Archive_crc.update(var3, 0, var3.length);
				var5 = (int)Archive_crc.getValue();
				if (var5 != this.indexCrc) {
					this.field3521.method1936(this, 255, this.index, this.indexCrc, (byte)0, true);
				} else {
					Buffer var6 = new Buffer(class53.decompressBytes(var3));
					int var7 = var6.readUnsignedByte();
					if (var7 != 5 && var7 != 6) {
						throw new RuntimeException(var7 + "," + this.index + "," + var2);
					} else {
						int var8 = 0;
						if (var7 >= 6) {
							var8 = var6.readInt();
						}

						if (var8 != this.indexVersion) {
							this.field3521.method1936(this, 255, this.index, this.indexCrc, (byte)0, true);
						} else {
							this.decodeIndex(var3);
							this.loadAllLocal();
						}
					}
				}
			}
		} else {
			if (!var4 && var2 == this.field3520) {
				this.field3525 = 1;
			}

			if (var3 != null && var3.length > 2) {
				Archive_crc.reset();
				Archive_crc.update(var3, 0, var3.length - 2);
				var5 = (int)Archive_crc.getValue();
				int var11 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
				if (var5 == super.groupCrcs[var2] && var11 == super.groupVersions[var2]) {
					this.validGroups[var2] = true;
					if (var4) {
						Object[] var12 = super.groups;
						Object var9;
						if (var3 == null) {
							var9 = null;
						} else if (var3.length > 136) {
							DirectByteArrayCopier var10 = new DirectByteArrayCopier();
							var10.set(var3);
							var9 = var10;
						} else {
							var9 = var3;
						}

						var12[var2] = var9;
					}

				} else {
					this.validGroups[var2] = false;
					if (this.field3516 || var4) {
						this.field3521.method1936(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
					}

				}
			} else {
				this.validGroups[var2] = false;
				if (this.field3516 || var4) {
					this.field3521.method1936(this, this.index, var2, super.groupCrcs[var2], (byte)2, var4);
				}

			}
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1319297597"
	)
	@Export("loadAllLocal")
	void loadAllLocal() {
		this.validGroups = new boolean[super.groups.length];

		int var1;
		for (var1 = 0; var1 < this.validGroups.length; ++var1) {
			this.validGroups[var1] = false;
		}

		if (this.archiveDisk == null) {
			this.field3525 = 1;
		} else {
			this.field3520 = -1;

			for (var1 = 0; var1 < this.validGroups.length; ++var1) {
				if (super.fileCounts[var1] > 0) {
					SceneTilePaint.method1350(var1, this.archiveDisk, this);
					this.field3520 = var1;
				}
			}

			if (this.field3520 == -1) {
				this.field3525 = 1;
			}

		}
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1917091652"
	)
	@Export("groupLoadPercent")
	int groupLoadPercent(int var1) {
		if (super.groups[var1] != null) {
			return 100;
		} else {
			return this.validGroups[var1] ? 100 : this.field3521.method1938(this.index, var1);
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-354618855"
	)
	public boolean method1897(int var1) {
		return this.validGroups[var1];
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "1031243198"
	)
	public boolean method1898(int var1) {
		return this.getGroupFileIds(var1) != null;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-91850240"
	)
	@Export("loadPercent")
	public int loadPercent() {
		int var1 = 0;
		int var2 = 0;

		int var3;
		for (var3 = 0; var3 < super.groups.length; ++var3) {
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
}