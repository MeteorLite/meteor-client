import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qi")
@Implements("FriendsChat")
public class FriendsChat extends UserList {
	@ObfuscatedName("hh")
	static String field3821;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ltt;"
	)
	@Export("loginType")
	final LoginType loginType;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lqz;"
	)
	@Export("localUser")
	final Usernamed localUser;
	@ObfuscatedName("ao")
	@Export("name")
	public String name;
	@ObfuscatedName("ab")
	@Export("owner")
	public String owner;
	@ObfuscatedName("au")
	@Export("minKick")
	public byte minKick;
	@ObfuscatedName("aa")
	@Export("rank")
	public int rank;
	@ObfuscatedName("ac")
	@Export("memberCount")
	int memberCount;

	@ObfuscatedSignature(
		descriptor = "(Ltt;Lqz;)V"
	)
	public FriendsChat(LoginType var1, Usernamed var2) {
		super(500);
		this.name = null;
		this.owner = null;
		this.memberCount = 1;
		this.loginType = var1;
		this.localUser = var2;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Lrf;",
		garbageValue = "794695059"
	)
	@Export("newInstance")
	User newInstance() {
		return new ClanMate();
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(II)[Lrf;",
		garbageValue = "-190310061"
	)
	@Export("newTypedArray")
	User[] newTypedArray(int var1) {
		return new ClanMate[var1];
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-2021517341"
	)
	final void method2216(String var1) {
		this.name = class128.method696(var1);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "111"
	)
	final void method2217(String var1) {
		this.owner = class128.method696(var1);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Luj;IB)V",
		garbageValue = "103"
	)
	public final void method2218(Buffer var1, int var2) {
		this.method2217(var1.readStringCp1252NullTerminated());
		long var3 = var1.readLong();
		long var6 = var3;
		String var5;
		int var8;
		if (var3 > 0L && var3 < 6582952005840035281L) {
			if (var3 % 37L == 0L) {
				var5 = null;
			} else {
				var8 = 0;

				for (long var9 = var3; 0L != var9; var9 /= 37L) {
					++var8;
				}

				StringBuilder var11 = new StringBuilder(var8);

				while (var6 != 0L) {
					long var12 = var6;
					var6 /= 37L;
					var11.append(class400.base37Table[(int)(var12 - 37L * var6)]);
				}

				var5 = var11.reverse().toString();
			}
		} else {
			var5 = null;
		}

		this.method2216(var5);
		this.minKick = var1.readByte();
		short var14;
		if (var2 == 1) {
			var8 = var1.readUnsignedByte();
			var14 = 255;
		} else {
			if (var2 != 2) {
				throw new IllegalArgumentException("Invalid friend chat full update version: " + var2);
			}

			var8 = var1.readShortSmartSub();
			var14 = -1;
		}

		if (var8 != var14) {
			int var10 = var8;
			this.clear();

			for (int var15 = 0; var15 < var10; ++var15) {
				ClanMate var16 = (ClanMate)this.addLastNoPreviousUsername(new Username(var1.readStringCp1252NullTerminated(), this.loginType));
				int var13 = var1.readUnsignedShort();
				var16.set(var13, ++this.memberCount - 1);
				var16.rank = var1.readByte();
				var1.readStringCp1252NullTerminated();
				this.isLocalPlayer(var16);
			}

		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Luj;I)V",
		garbageValue = "-623451894"
	)
	public final void method2220(Buffer var1) {
		Username var2 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
		int var3 = var1.readUnsignedShort();
		byte var4 = var1.readByte();
		boolean var5 = false;
		if (var4 == -128) {
			var5 = true;
		}

		ClanMate var6;
		if (var5) {
			if (this.getSize() == 0) {
				return;
			}

			var6 = (ClanMate)this.getByCurrentUsername(var2);
			if (var6 != null && var6.getWorld() == var3) {
				this.remove(var6);
			}
		} else {
			var1.readStringCp1252NullTerminated();
			var6 = (ClanMate)this.getByCurrentUsername(var2);
			if (var6 == null) {
				if (this.getSize() > super.capacity) {
					return;
				}

				var6 = (ClanMate)this.addLastNoPreviousUsername(var2);
			}

			var6.set(var3, ++this.memberCount - 1);
			var6.rank = var4;
			this.isLocalPlayer(var6);
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1485871297"
	)
	@Export("clearFriends")
	public final void clearFriends() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsFriend();
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "511267202"
	)
	@Export("invalidateIgnoreds")
	public final void invalidateIgnoreds() {
		for (int var1 = 0; var1 < this.getSize(); ++var1) {
			((ClanMate)this.get(var1)).clearIsIgnored();
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lrp;S)V",
		garbageValue = "-25332"
	)
	@Export("isLocalPlayer")
	final void isLocalPlayer(ClanMate var1) {
		if (var1.getUsername().equals(this.localUser.username())) {
			this.rank = var1.rank;
		}

	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(CI)C",
		garbageValue = "-350707745"
	)
	public static char method2219(char var0) {
		switch(var0) {
		case ' ':
		case '-':
		case '_':
		case '\u00a0':
			return '_';
		case '#':
		case '[':
		case ']':
			return var0;
		case '\u00c0':
		case '\u00c1':
		case '\u00c2':
		case '\u00c3':
		case '\u00c4':
		case '\u00e0':
		case '\u00e1':
		case '\u00e2':
		case '\u00e3':
		case '\u00e4':
			return 'a';
		case '\u00c7':
		case '\u00e7':
			return 'c';
		case '\u00c8':
		case '\u00c9':
		case '\u00ca':
		case '\u00cb':
		case '\u00e8':
		case '\u00e9':
		case '\u00ea':
		case '\u00eb':
			return 'e';
		case '\u00cd':
		case '\u00ce':
		case '\u00cf':
		case '\u00ed':
		case '\u00ee':
		case '\u00ef':
			return 'i';
		case '\u00d1':
		case '\u00f1':
			return 'n';
		case '\u00d2':
		case '\u00d3':
		case '\u00d4':
		case '\u00d5':
		case '\u00d6':
		case '\u00f2':
		case '\u00f3':
		case '\u00f4':
		case '\u00f5':
		case '\u00f6':
			return 'o';
		case '\u00d9':
		case '\u00da':
		case '\u00db':
		case '\u00dc':
		case '\u00f9':
		case '\u00fa':
		case '\u00fb':
		case '\u00fc':
			return 'u';
		case '\u00df':
			return 'b';
		case '\u00ff':
		case '\u0178':
			return 'y';
		default:
			return Character.toLowerCase(var0);
		}
	}

	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		descriptor = "(ILmh;ZI)V",
		garbageValue = "-1919128859"
	)
	static void method2224(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = WorldMapArchiveLoader.getWorldMap().getMapArea(var0);
		int var4 = class229.localPlayer.plane;
		int var5 = (class229.localPlayer.x >> 7) + NewShit.baseX;
		int var6 = (class229.localPlayer.y >> 7) + class101.baseY;
		Coord var7 = new Coord(var4, var5, var6);
		WorldMapArchiveLoader.getWorldMap().method2414(var3, var7, var1, var2);
	}
}