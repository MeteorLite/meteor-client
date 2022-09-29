import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("FriendSystem")
public class FriendSystem {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lna;"
	)
	@Export("friendsList")
	public final FriendsList friendsList;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("ignoreList")
	public final IgnoreList ignoreList;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 983410639
	)
	int field814;

	@ObfuscatedSignature(
		descriptor = "(Lpn;)V"
	)
	FriendSystem(LoginType var1) {
		this.field814 = 0;
		this.loginType = var1;
		this.friendsList = new FriendsList(var1);
		this.ignoreList = new IgnoreList(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "293339898"
	)
	boolean method1784() {
		return this.field814 == 2;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-76"
	)
	final void method1785() {
		this.field814 = 1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Lqq;II)V",
		garbageValue = "2116353988"
	)
	@Export("readUpdate")
	final void readUpdate(Buffer var1, int var2) {
		this.friendsList.read(var1, var2);
		this.field814 = 2;
		Interpreter.method2011();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "41"
	)
	@Export("processFriendUpdates")
	final void processFriendUpdates() {
		for (class370 var1 = (class370)this.friendsList.friendLoginUpdates.last(); var1 != null; var1 = (class370)this.friendsList.friendLoginUpdates.previous()) {
			if ((long)var1.field4346 < Language.method6232() / 1000L - 5L) {
				if (var1.field4347 > 0) {
					class65.addGameMessage(5, "", var1.field4345 + " has logged in.");
				}

				if (var1.field4347 == 0) {
					class65.addGameMessage(5, "", var1.field4345 + " has logged out.");
				}

				var1.remove();
			}
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1775658387"
	)
	@Export("clear")
	final void clear() {
		this.field814 = 0;
		this.friendsList.clear();
		this.ignoreList.clear();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(Lqo;ZI)Z",
		garbageValue = "-218613046"
	)
	@Export("isFriended")
	final boolean isFriended(Username var1, boolean var2) {
		if (var1 == null) {
			return false;
		} else if (var1.equals(class67.localPlayer.username)) {
			return true;
		} else {
			return this.friendsList.isFriended(var1, var2);
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(Lqo;I)Z",
		garbageValue = "1139624346"
	)
	@Export("isIgnored")
	final boolean isIgnored(Username var1) {
		if (var1 == null) {
			return false;
		} else {
			return this.ignoreList.contains(var1);
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-588093598"
	)
	@Export("addFriend")
	final void addFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				StringBuilder var10000;
				String var4;
				if (this.friendsListIsFull()) {
					var10000 = null;
					var4 = "Your friend list is full. Max of 200 for free users, and 400 for members";
					class65.addGameMessage(30, "", var4);
				} else if (class67.localPlayer.username.equals(var2)) {
					class116.method2857();
				} else if (this.isFriended(var2, false)) {
					var10000 = (new StringBuilder()).append(var1);
					Object var10001 = null;
					var4 = var10000.append(" is already on your friend list").toString();
					class65.addGameMessage(30, "", var4);
				} else if (this.isIgnored(var2)) {
					ClientPreferences.method2400(var1);
				} else {
					PacketBufferNode var3 = class120.getPacketBufferNode(ClientPacket.field3030, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class357.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}
			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "106"
	)
	@Export("friendsListIsFull")
	final boolean friendsListIsFull() {
		return this.friendsList.isFull() || this.friendsList.getSize() >= 200 && Client.field621 != 1;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "1418867525"
	)
	@Export("addIgnore")
	final void addIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.canAddIgnore()) {
					WorldMapSectionType.method5077();
				} else if (class67.localPlayer.username.equals(var2)) {
					UserComparator7.method2743();
				} else if (this.isIgnored(var2)) {
					StringBuilder var10000 = (new StringBuilder()).append(var1);
					Object var10001 = null;
					String var4 = var10000.append(" is already on your ignore list").toString();
					class65.addGameMessage(30, "", var4);
				} else if (this.isFriended(var2, false)) {
					class145.method3227(var1);
				} else {
					PacketBufferNode var3 = class120.getPacketBufferNode(ClientPacket.field3037, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class357.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}
			}
		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-718632691"
	)
	@Export("canAddIgnore")
	final boolean canAddIgnore() {
		return this.ignoreList.isFull() || this.ignoreList.getSize() >= 100 && Client.field621 != 1;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "859092397"
	)
	@Export("removeFriend")
	final void removeFriend(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.friendsList.removeByUsername(var2)) {
					WorldMapLabel.method5119();
					PacketBufferNode var3 = class120.getPacketBufferNode(ClientPacket.field3036, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class357.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				Interpreter.method2011();
			}
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "-40"
	)
	@Export("removeIgnore")
	final void removeIgnore(String var1) {
		if (var1 != null) {
			Username var2 = new Username(var1, this.loginType);
			if (var2.hasCleanName()) {
				if (this.ignoreList.removeByUsername(var2)) {
					WorldMapLabel.method5119();
					PacketBufferNode var3 = class120.getPacketBufferNode(ClientPacket.field2938, Client.packetWriter.isaacCipher);
					var3.packetBuffer.writeByte(class357.stringCp1252NullTerminatedByteSize(var1));
					var3.packetBuffer.writeStringCp1252NullTerminated(var1);
					Client.packetWriter.addNode(var3);
				}

				class364.FriendSystem_invalidateIgnoreds();
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		descriptor = "(Lqo;B)Z",
		garbageValue = "1"
	)
	@Export("isFriendAndHasWorld")
	final boolean isFriendAndHasWorld(Username var1) {
		Friend var2 = (Friend)this.friendsList.getByUsername(var1);
		return var2 != null && var2.hasWorld();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(S)V",
		garbageValue = "14834"
	)
	static void method1807() {
		ByteArrayPool.field4259.clear();
		ByteArrayPool.field4259.add(100);
		ByteArrayPool.field4259.add(5000);
		ByteArrayPool.field4259.add(10000);
		ByteArrayPool.field4259.add(30000);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1479702690"
	)
	static void method1836() {
		if (Login.clearLoginScreen) {
			Login.titleboxSprite = null;
			Login.titlebuttonSprite = null;
			DevicePcmPlayerProvider.runesSprite = null;
			TextureProvider.leftTitleSprite = null;
			PcmPlayer.rightTitleSprite = null;
			MilliClock.logoSprite = null;
			LoginType.title_muteSprite = null;
			WorldMapDecoration.options_buttons_0Sprite = null;
			UserComparator7.options_buttons_2Sprite = null;
			class82.worldSelectBackSprites = null;
			ReflectionCheck.worldSelectFlagSprites = null;
			UserComparator6.worldSelectArrows = null;
			class182.worldSelectStars = null;
			class10.field45 = null;
			VertexNormal.field2637.method2356();
			TaskHandler.method3435(2);
			class117.method2859(true);
			Login.clearLoginScreen = false;
		}
	}
}
