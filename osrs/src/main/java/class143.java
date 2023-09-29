import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class143 extends class145 {
	@ObfuscatedName("ac")
	long field1324;
	@ObfuscatedName("al")
	String field1323;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lff;"
	)
	final class148 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lff;)V"
	)
	class143(class148 var1) {
		this.this$0 = var1;
		this.field1324 = -1L;
		this.field1323 = null;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "-11659242"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1324 = var1.readLong();
		}

		this.field1323 = var1.readStringCp1252NullTerminatedOrNull();
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lgi;I)V",
		garbageValue = "21847466"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method817(this.field1324, this.field1323, 0);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)F",
		garbageValue = "1171307082"
	)
	public static float method756(int var0) {
		var0 &= 16383;
		return (float)(6.283185307179586D * (double)((float)var0 / 16384.0F));
	}

	@ObfuscatedName("iu")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "83"
	)
	static final void method759() {
		if (class183.ClanChat_inClanChat) {
			if (class358.friendsChat != null) {
				class358.friendsChat.sort();
			}

			for (int var0 = 0; var0 < Players.Players_count; ++var0) {
				Player var1 = Client.players[Players.Players_indices[var0]];
				var1.clearIsInFriendsChat();
			}

			class183.ClanChat_inClanChat = false;
		}

	}
}