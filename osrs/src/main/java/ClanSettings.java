import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("ClanSettings")
public class ClanSettings {
	@ObfuscatedName("ah")
	@Export("useHashes")
	boolean useHashes;
	@ObfuscatedName("ar")
	@Export("useNames")
	boolean useNames;
	@ObfuscatedName("ao")
	long field1374;
	@ObfuscatedName("ab")
	public int field1385;
	@ObfuscatedName("au")
	@Export("name")
	public String name;
	@ObfuscatedName("aa")
	int field1371;
	@ObfuscatedName("ac")
	@Export("allowGuests")
	public boolean allowGuests;
	@ObfuscatedName("al")
	public byte field1380;
	@ObfuscatedName("az")
	public byte field1383;
	@ObfuscatedName("ap")
	public byte field1381;
	@ObfuscatedName("av")
	public byte field1382;
	@ObfuscatedName("ax")
	@Export("memberCount")
	public int memberCount;
	@ObfuscatedName("as")
	@Export("memberHashes")
	long[] memberHashes;
	@ObfuscatedName("ay")
	@Export("memberRanks")
	public byte[] memberRanks;
	@ObfuscatedName("ak")
	@Export("sortedMembers")
	int[] sortedMembers;
	@ObfuscatedName("aj")
	int[] field1372;
	@ObfuscatedName("am")
	public int[] field1390;
	@ObfuscatedName("aq")
	public boolean[] field1379;
	@ObfuscatedName("ai")
	@Export("currentOwner")
	public int currentOwner;
	@ObfuscatedName("aw")
	public int field1388;
	@ObfuscatedName("ae")
	@Export("bannedMemberCount")
	public int bannedMemberCount;
	@ObfuscatedName("an")
	@Export("bannedMemberHashes")
	long[] bannedMemberHashes;
	@ObfuscatedName("ag")
	@Export("memberNames")
	public String[] memberNames;
	@ObfuscatedName("ad")
	@Export("bannedMemberNames")
	public String[] bannedMemberNames;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "Ltz;"
	)
	@Export("parameters")
	IterableNodeHashTable parameters;

	@ObfuscatedSignature(
		descriptor = "(Luj;)V"
	)
	public ClanSettings(Buffer var1) {
		this.field1385 = 0;
		this.name = null;
		this.field1371 = 0;
		this.currentOwner = -1;
		this.field1388 = -1;
		this.method818(var1);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "95"
	)
	void method798(int var1) {
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

		if (this.field1372 != null) {
			System.arraycopy(this.field1372, 0, this.field1372 = new int[var1], 0, this.memberCount);
		} else {
			this.field1372 = new int[var1];
		}

		if (this.field1390 != null) {
			System.arraycopy(this.field1390, 0, this.field1390 = new int[var1], 0, this.memberCount);
		} else {
			this.field1390 = new int[var1];
		}

		if (this.field1379 != null) {
			System.arraycopy(this.field1379, 0, this.field1379 = new boolean[var1], 0, this.memberCount);
		} else {
			this.field1379 = new boolean[var1];
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1189145621"
	)
	void method799(int var1) {
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

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)I",
		garbageValue = "1"
	)
	public int method800(String var1) {
		if (var1 != null && var1.length() != 0) {
			for (int var2 = 0; var2 < this.memberCount; ++var2) {
				if (this.memberNames[var2].equals(var1)) {
					return var2;
				}
			}

			return -1;
		} else {
			return -1;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "1718718774"
	)
	public int method801(int var1, int var2, int var3) {
		int var4 = var3 == 31 ? -1 : (1 << var3 + 1) - 1;
		return (this.field1372[var1] & var4) >>> var2;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/Integer;",
		garbageValue = "2128934080"
	)
	@Export("getTitleGroupValue")
	public Integer getTitleGroupValue(int var1) {
		if (this.parameters == null) {
			return null;
		} else {
			Node var2 = this.parameters.get((long)var1);
			return var2 != null && var2 instanceof IntegerNode ? new Integer(((IntegerNode)var2).integer) : null;
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-672366104"
	)
	@Export("getSortedMembers")
	public int[] getSortedMembers() {
		if (this.sortedMembers == null) {
			String[] var1 = new String[this.memberCount];
			this.sortedMembers = new int[this.memberCount];

			for (int var2 = 0; var2 < this.memberCount; this.sortedMembers[var2] = var2++) {
				var1[var2] = this.memberNames[var2];
				if (var1[var2] != null) {
					var1[var2] = var1[var2].toLowerCase();
				}
			}

			int[] var3 = this.sortedMembers;
			class475.method2362(var1, var3, 0, var1.length - 1);
		}

		return this.sortedMembers;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(JLjava/lang/String;II)V",
		garbageValue = "613838614"
	)
	void method804(long var1, String var3, int var4) {
		if (var3 != null && var3.length() == 0) {
			var3 = null;
		}

		if (var1 > 0L != this.useHashes) {
			throw new RuntimeException("");
		} else if (var3 != null != this.useNames) {
			throw new RuntimeException("");
		} else {
			if (var1 > 0L && (this.memberHashes == null || this.memberCount >= this.memberHashes.length) || var3 != null && (this.memberNames == null || this.memberCount >= this.memberNames.length)) {
				this.method798(this.memberCount + 5);
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

			this.field1372[this.memberCount] = 0;
			this.field1390[this.memberCount] = var4;
			this.field1379[this.memberCount] = false;
			++this.memberCount;
			this.sortedMembers = null;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "2072484175"
	)
	void method806(int var1) {
		if (var1 >= 0 && var1 < this.memberCount) {
			--this.memberCount;
			this.sortedMembers = null;
			if (this.memberCount == 0) {
				this.memberHashes = null;
				this.memberNames = null;
				this.memberRanks = null;
				this.field1372 = null;
				this.field1390 = null;
				this.field1379 = null;
				this.currentOwner = -1;
				this.field1388 = -1;
			} else {
				System.arraycopy(this.memberRanks, var1 + 1, this.memberRanks, var1, this.memberCount - var1);
				System.arraycopy(this.field1372, var1 + 1, this.field1372, var1, this.memberCount - var1);
				System.arraycopy(this.field1390, var1 + 1, this.field1390, var1, this.memberCount - var1);
				System.arraycopy(this.field1379, var1 + 1, this.field1379, var1, this.memberCount - var1);
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

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-7"
	)
	@Export("updateOwner")
	void updateOwner() {
		if (this.memberCount == 0) {
			this.currentOwner = -1;
			this.field1388 = -1;
		} else {
			this.currentOwner = -1;
			this.field1388 = -1;
			int var1 = 0;
			byte var2 = this.memberRanks[0];

			for (int var3 = 1; var3 < this.memberCount; ++var3) {
				if (this.memberRanks[var3] > var2) {
					if (var2 == 125) {
						this.field1388 = var1;
					}

					var1 = var3;
					var2 = this.memberRanks[var3];
				} else if (this.field1388 == -1 && this.memberRanks[var3] == 125) {
					this.field1388 = var3;
				}
			}

			this.currentOwner = var1;
			if (this.currentOwner != -1) {
				this.memberRanks[this.currentOwner] = 126;
			}

		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(JLjava/lang/String;I)V",
		garbageValue = "-1952730404"
	)
	void method808(long var1, String var3) {
		if (var3 != null && var3.length() == 0) {
			var3 = null;
		}

		if (this.useHashes != var1 > 0L) {
			throw new RuntimeException("");
		} else if (this.useNames != (var3 != null)) {
			throw new RuntimeException("");
		} else {
			if (var1 > 0L && (this.bannedMemberHashes == null || this.bannedMemberCount >= this.bannedMemberHashes.length) || var3 != null && (this.bannedMemberNames == null || this.bannedMemberCount >= this.bannedMemberNames.length)) {
				this.method799(this.bannedMemberCount + 5);
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

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1253930747"
	)
	void method809(int var1) {
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

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(IBB)I",
		garbageValue = "-88"
	)
	int method810(int var1, byte var2) {
		if (var2 != 126 && var2 != 127) {
			if (this.currentOwner == var1 && (this.field1388 == -1 || this.memberRanks[this.field1388] < 125)) {
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
		garbageValue = "7"
	)
	boolean method811(int var1) {
		if (this.currentOwner != var1 && this.memberRanks[var1] != 126) {
			this.memberRanks[this.currentOwner] = 125;
			this.field1388 = this.currentOwner;
			this.memberRanks[var1] = 126;
			this.currentOwner = var1;
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IZI)I",
		garbageValue = "-1328118008"
	)
	int method812(int var1, boolean var2) {
		if (this.field1379[var1] == var2) {
			return -1;
		} else {
			this.field1379[var1] = var2;
			return var1;
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IIIII)I",
		garbageValue = "2048454468"
	)
	int method813(int var1, int var2, int var3, int var4) {
		int var5 = (1 << var3) - 1;
		int var6 = var4 == 31 ? -1 : (1 << var4 + 1) - 1;
		int var7 = var6 ^ var5;
		var2 <<= var3;
		var2 &= var7;
		int var8 = this.field1372[var1];
		if ((var8 & var7) == var2) {
			return -1;
		} else {
			var8 &= ~var7;
			this.field1372[var1] = var8 | var2;
			return var1;
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "2056023373"
	)
	boolean method814(int var1, int var2) {
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

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(IIIII)Z",
		garbageValue = "-303137716"
	)
	boolean method815(int var1, int var2, int var3, int var4) {
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

	@ObfuscatedName("am")
	boolean method816(int var1, long var2) {
		if (this.parameters != null) {
			Node var4 = this.parameters.get((long)var1);
			if (var4 != null) {
				if (var4 instanceof LongNode) {
					LongNode var5 = (LongNode)var4;
					if (var5.longValue == var2) {
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

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;I)Z",
		garbageValue = "-1755861280"
	)
	boolean method817(int var1, String var2) {
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

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Luj;B)V",
		garbageValue = "-1"
	)
	void method818(Buffer var1) {
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

			this.field1385 = var1.readInt();
			this.field1371 = var1.readInt();
			if (var2 <= 3 && this.field1371 != 0) {
				this.field1371 += 16912800;
			}

			this.memberCount = var1.readUnsignedShort();
			this.bannedMemberCount = var1.readUnsignedByte();
			this.name = var1.readStringCp1252NullTerminated();
			if (var2 >= 4) {
				var1.readInt();
			}

			this.allowGuests = var1.readUnsignedByte() == 1;
			this.field1380 = var1.readByte();
			this.field1383 = var1.readByte();
			this.field1381 = var1.readByte();
			this.field1382 = var1.readByte();
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

				if (this.field1372 == null || this.field1372.length < this.memberCount) {
					this.field1372 = new int[this.memberCount];
				}

				if (this.field1390 == null || this.field1390.length < this.memberCount) {
					this.field1390 = new int[this.memberCount];
				}

				if (this.field1379 == null || this.field1379.length < this.memberCount) {
					this.field1379 = new boolean[this.memberCount];
				}

				for (var4 = 0; var4 < this.memberCount; ++var4) {
					if (this.useHashes) {
						this.memberHashes[var4] = var1.readLong();
					}

					if (this.useNames) {
						this.memberNames[var4] = var1.readStringCp1252NullTerminatedOrNull();
					}

					this.memberRanks[var4] = var1.readByte();
					if (var2 >= 2) {
						this.field1372[var4] = var1.readInt();
					}

					if (var2 >= 5) {
						this.field1390[var4] = var1.readUnsignedShort();
					} else {
						this.field1390[var4] = 0;
					}

					if (var2 >= 6) {
						this.field1379[var4] = var1.readUnsignedByte() == 1;
					} else {
						this.field1379[var4] = false;
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

				for (var4 = 0; var4 < this.bannedMemberCount; ++var4) {
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
					this.parameters = new IterableNodeHashTable(var4 < 16 ? class184.method927(var4) : 16);

					while (var4-- > 0) {
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

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lri;FFFI)F",
		garbageValue = "-584068586"
	)
	static float method805(class464 var0, float var1, float var2, float var3) {
		float var4 = class251.method1335(var0.field3921, var0.field3922, var1);
		if (Math.abs(var4) < class127.field1219) {
			return var1;
		} else {
			float var5 = class251.method1335(var0.field3921, var0.field3922, var2);
			if (Math.abs(var5) < class127.field1219) {
				return var2;
			} else {
				float var6 = 0.0F;
				float var7 = 0.0F;
				float var8 = 0.0F;
				float var13 = 0.0F;
				boolean var14 = true;
				boolean var15 = false;

				do {
					var15 = false;
					if (var14) {
						var6 = var1;
						var13 = var4;
						var7 = var2 - var1;
						var8 = var7;
						var14 = false;
					}

					if (Math.abs(var13) < Math.abs(var5)) {
						var1 = var2;
						var2 = var6;
						var6 = var1;
						var4 = var5;
						var5 = var13;
						var13 = var4;
					}

					float var16 = class127.field1218 * Math.abs(var2) + 0.5F * var3;
					float var17 = (var6 - var2) * 0.5F;
					boolean var18 = Math.abs(var17) > var16 && var5 != 0.0F;
					if (var18) {
						if (Math.abs(var8) >= var16 && Math.abs(var4) > Math.abs(var5)) {
							float var12 = var5 / var4;
							float var9;
							float var10;
							if (var6 == var1) {
								var9 = var12 * var17 * 2.0F;
								var10 = 1.0F - var12;
							} else {
								var10 = var4 / var13;
								float var11 = var5 / var13;
								var9 = (var17 * 2.0F * var10 * (var10 - var11) - (var2 - var1) * (var11 - 1.0F)) * var12;
								var10 = (var12 - 1.0F) * (var11 - 1.0F) * (var10 - 1.0F);
							}

							if ((double)var9 > 0.0D) {
								var10 = -var10;
							} else {
								var9 = -var9;
							}

							var12 = var8;
							var8 = var7;
							if (var9 * 2.0F < var17 * 3.0F * var10 - Math.abs(var16 * var10) && var9 < Math.abs(var12 * 0.5F * var10)) {
								var7 = var9 / var10;
							} else {
								var7 = var17;
								var8 = var17;
							}
						} else {
							var7 = var17;
							var8 = var17;
						}

						var1 = var2;
						var4 = var5;
						if (Math.abs(var7) > var16) {
							var2 += var7;
						} else if ((double)var17 > 0.0D) {
							var2 += var16;
						} else {
							var2 -= var16;
						}

						var5 = class251.method1335(var0.field3921, var0.field3922, var2);
						if ((double)(var5 * (var13 / Math.abs(var13))) > 0.0D) {
							var14 = true;
							var15 = true;
						} else {
							var15 = true;
						}
					}
				} while(var15);

				return var2;
			}
		}
	}

	@ObfuscatedName("ki")
	@ObfuscatedSignature(
		descriptor = "(IIS)V",
		garbageValue = "25188"
	)
	@Export("updateItemPile")
	static final void updateItemPile(int var0, int var1) {
		NodeDeque var2 = Client.groundItems[ItemLayer.Client_plane][var0][var1];
		if (var2 == null) {
			class36.scene.removeGroundItemPile(ItemLayer.Client_plane, var0, var1);
		} else {
			long var3 = -99999999L;
			TileItem var5 = null;

			TileItem var6;
			for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
				ItemComposition var7 = class214.ItemDefinition_get(var6.id);
				long var8 = (long)var7.price;
				if (var7.isStackable == 1) {
					var8 *= var6.quantity < Integer.MAX_VALUE ? (long)(var6.quantity + 1) : (long)var6.quantity;
				}

				if (var8 > var3) {
					var3 = var8;
					var5 = var6;
				}
			}

			if (var5 == null) {
				class36.scene.removeGroundItemPile(ItemLayer.Client_plane, var0, var1);
			} else {
				var2.addLast(var5);
				TileItem var12 = null;
				TileItem var11 = null;

				for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
					if (var6.id != var5.id) {
						if (var12 == null) {
							var12 = var6;
						}

						if (var6.id != var12.id && var11 == null) {
							var11 = var6;
						}
					}
				}

				long var9 = Player.calculateTag(var0, var1, 3, false, 0);
				class36.scene.newGroundItemPile(ItemLayer.Client_plane, var0, var1, WorldMapDecorationType.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, ItemLayer.Client_plane), var5, var9, var12, var11);
			}
		}
	}

	@ObfuscatedName("ko")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	static final void method820() {
		int var0 = FriendSystem.menuX;
		int var1 = class60.menuY;
		int var2 = class428.menuWidth;
		int var3 = class515.menuHeight;
		int var4 = 6116423;
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, var4);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0 + 1, var1 + 1, var2 - 2, 16, 0);
		Rasterizer2D.Rasterizer2D_drawRectangle(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
		GrandExchangeOfferTotalQuantityComparator.fontBold12.draw("Choose Option", var0 + 3, var1 + 14, var4, -1);
		int var5 = MouseHandler.MouseHandler_x;
		int var6 = MouseHandler.MouseHandler_y;

		for (int var7 = 0; var7 < Client.menuOptionsCount; ++var7) {
			int var8 = var1 + (Client.menuOptionsCount - 1 - var7) * 15 + 31;
			int var9 = 16777215;
			if (var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
				var9 = 16776960;
			}

			Font var10 = GrandExchangeOfferTotalQuantityComparator.fontBold12;
			String var11;
			if (var7 < 0) {
				var11 = "";
			} else if (Client.menuTargets[var7].length() > 0) {
				var11 = Client.menuActions[var7] + " " + Client.menuTargets[var7];
			} else {
				var11 = Client.menuActions[var7];
			}

			var10.draw(var11, var0 + 3, var8, var9, 0);
		}

		SoundSystem.method233(FriendSystem.menuX, class60.menuY, class428.menuWidth, class515.menuHeight);
	}
}