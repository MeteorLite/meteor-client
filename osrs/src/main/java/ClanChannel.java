import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

@ObfuscatedName("go")
@Implements("ClanChannel")
public class ClanChannel extends Node {
	@ObfuscatedName("au")
	boolean field1423;
	@ObfuscatedName("ae")
	boolean field1422;
	@ObfuscatedName("ao")
	@Export("members")
	public List members;
	@ObfuscatedName("at")
	@Export("sortedMembers")
	int[] sortedMembers;
	@ObfuscatedName("ac")
	public long field1429;
	@ObfuscatedName("ai")
	@Export("name")
	public String name;
	@ObfuscatedName("az")
	public byte field1426;
	@ObfuscatedName("ap")
	public byte field1425;

	static {
		new BitSet(65536);
	}

	@ObfuscatedSignature(
		descriptor = "(Ltm;)V"
	)
	public ClanChannel(Buffer var1) {
		this.field1422 = true;
		this.name = null;
		this.method861(var1);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)[I",
		garbageValue = "74"
	)
	@Export("getSortedMembers")
	public int[] getSortedMembers() {
		if (this.sortedMembers == null) {
			String[] var1 = new String[this.members.size()];
			this.sortedMembers = new int[this.members.size()];

			for (int var2 = 0; var2 < this.members.size(); this.sortedMembers[var2] = var2++) {
				var1[var2] = ((ClanChannelMember)this.members.get(var2)).username.method2700();
			}

			int[] var3 = this.sortedMembers;
			VerticalAlignment.method998(var1, var3, 0, var1.length - 1);
		}

		return this.sortedMembers;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lfu;I)V",
		garbageValue = "2089443829"
	)
	@Export("addMember")
	void addMember(ClanChannelMember var1) {
		this.members.add(var1);
		this.sortedMembers = null;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-753870503"
	)
	@Export("removeMember")
	void removeMember(int var1) {
		this.members.remove(var1);
		this.sortedMembers = null;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "65"
	)
	public int method859() {
		return this.members.size();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;S)I",
		garbageValue = "179"
	)
	public int method860(String var1) {
		if (!this.field1422) {
			throw new RuntimeException("Displaynames not available");
		} else {
			for (int var2 = 0; var2 < this.members.size(); ++var2) {
				if (((ClanChannelMember)this.members.get(var2)).username.getName().equalsIgnoreCase(var1)) {
					return var2;
				}
			}

			return -1;
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "-1748777408"
	)
	void method861(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if ((var2 & 1) != 0) {
			this.field1423 = true;
		}

		if ((var2 & 2) != 0) {
			this.field1422 = true;
		}

		int var3 = 2;
		if ((var2 & 4) != 0) {
			var3 = var1.readUnsignedByte();
		}

		super.key = var1.readLong();
		this.field1429 = var1.readLong();
		this.name = var1.readStringCp1252NullTerminated();
		var1.readBoolean();
		this.field1425 = var1.readByte();
		this.field1426 = var1.readByte();
		int var4 = var1.readUnsignedShort();
		if (var4 > 0) {
			this.members = new ArrayList(var4);

			for (int var5 = 0; var5 < var4; ++var5) {
				ClanChannelMember var6 = new ClanChannelMember();
				if (this.field1423) {
					var1.readLong();
				}

				if (this.field1422) {
					var6.username = new Username(var1.readStringCp1252NullTerminated());
				}

				var6.rank = var1.readByte();
				var6.world = var1.readUnsignedShort();
				if (var3 >= 3) {
					var1.readBoolean();
				}

				this.members.add(var5, var6);
			}
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)Lhz;",
		garbageValue = "1042028592"
	)
	@Export("KitDefinition_get")
	public static KitDefinition KitDefinition_get(int var0) {
		KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = KitDefinition.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			KitDefinition.KitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("jx")
	@ObfuscatedSignature(
		descriptor = "(Lie;S)V",
		garbageValue = "12208"
	)
	static void method862(class211 var0) {
		if (var0 != null && var0.field1878 != null) {
			if (var0.field1878.childIndex >= 0) {
				Widget var1 = class92.getWidget(var0.field1878.parentId);
				if (var1 == null || var1.children == null || var1.children.length == 0 || var0.field1878.childIndex >= var1.children.length || var0.field1878 != var1.children[var0.field1878.childIndex]) {
					return;
				}
			}

			if (var0.field1878.type == 11 && var0.field1875 == 0) {
				if (var0.field1878.method1833(var0.field1876, var0.field1877, 0, 0)) {
					switch(var0.field1878.method1837()) {
					case 0:
						class30.openURL(var0.field1878.method1839(), true, false);
						break;
					case 1:
						int var2 = NewShit.getWidgetFlags(var0.field1878);
						boolean var5 = (var2 >> 22 & 1) != 0;
						if (var5) {
							int[] var3 = var0.field1878.method1840();
							if (var3 != null) {
								PacketBufferNode var4 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.field2583, Client.packetWriter.isaacCipher);
								var4.packetBuffer.writeIntIME_(var3[1]);
								var4.packetBuffer.writeIntIME(var0.field1878.id);
								var4.packetBuffer.writeIntME(var0.field1878.childIndex);
								var4.packetBuffer.writeInt(var0.field1878.method1838());
								var4.packetBuffer.writeIntIME(var3[2]);
								var4.packetBuffer.writeIntIME(var3[0]);
								Client.packetWriter.addNode(var4);
							}
						}
					}
				}
			} else if (var0.field1878.type == 12) {
				class329 var6 = var0.field1878.method1844();
				if (var6 != null && var6.method1783()) {
					switch(var0.field1875) {
					case 0:
						Client.field423.method1088(var0.field1878);
						var6.method1731(true);
						var6.method1770(var0.field1876, var0.field1877, Client.keyHandlerInstance.getKeyPressed(82), Client.keyHandlerInstance.getKeyPressed(81));
						break;
					case 1:
						var6.method1771(var0.field1876, var0.field1877);
					}
				}
			}

		}
	}
}