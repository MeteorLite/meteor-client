import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lw")
@Implements("ClientPacket")
public class ClientPacket implements class294 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket MOVE_MINIMAPCLICK = new ClientPacket(0, -1);
	@ObfuscatedName("ay")
	@ObfuscatedSignature(descriptor = "Llw;") @Export("OPPLAYER3")
	public static final ClientPacket OPLOC5 = new ClientPacket(1, 7);
	@ObfuscatedName("ar")
	@ObfuscatedSignature(descriptor = "Llw;") @Export("IF_BUTTON2")
	public static final ClientPacket IDLE_LOGOUT = new ClientPacket(2, 0);
	@ObfuscatedName("am")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket NATIVE_PACKET3 = new ClientPacket(3, -1);
	@ObfuscatedName("as")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket TELEPORT = new ClientPacket(4, 9);
	@ObfuscatedName("aj")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket BUTTON_CLICK = new ClientPacket(5, 4);
	@ObfuscatedName("ag")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket IF_BUTTON3 = new ClientPacket(6, 8);
	@ObfuscatedName("az")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket EVENT_APPLET_FOCUS = new ClientPacket(7, 1);
	@ObfuscatedName("av")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPNPCT = new ClientPacket(8, 11);
	@ObfuscatedName("ap")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPLOC2 = new ClientPacket(9, 7);
	@ObfuscatedName("aq")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket CLICKWORLDMAP = new ClientPacket(10, 4);
	@ObfuscatedName("at")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPNPC3 = new ClientPacket(11, 3);
	@ObfuscatedName("ah")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPOBJ6 = new ClientPacket(12, 6);
	@ObfuscatedName("ax")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket FRIENDLIST_DEL = new ClientPacket(13, -1);
	@ObfuscatedName("aa")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket CLAN_JOINCHAT_LEAVECHAT = new ClientPacket(14, -1);
	@ObfuscatedName("au")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket IF_BUTTONT = new ClientPacket(15, 16);
	@ObfuscatedName("ae")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket F_EVENT_MOUSE_SCROLL = new ClientPacket(16, 6);
	@ObfuscatedName("ab")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("IF_BUTTON7")
	public static final ClientPacket NATIVE_PACKET4 = new ClientPacket(17, 2);
	@ObfuscatedName("ad")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket UPDATE_APPEARANCE = new ClientPacket(18, 13);
	@ObfuscatedName("ao")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket EVENT_KEYBOARD = new ClientPacket(19, -2);
	@ObfuscatedName("ac")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket EVENT_MOUSE_MOVE = new ClientPacket(20, -1);
	@ObfuscatedName("ak")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket CLIENT_CHEAT = new ClientPacket(21, -1);
	@ObfuscatedName("an")
	@ObfuscatedSignature(descriptor = "Llw;") @Export("OPPLAYERT")
	public static final ClientPacket IF_BUTTON10 = new ClientPacket(22, 8);
	@ObfuscatedName("af")
	@ObfuscatedSignature(descriptor = "Llw;") @Export("OPPLAYER7")
	public static final ClientPacket SEND_SNAPSHOT = new ClientPacket(23, -1);
	@ObfuscatedName("ai")
	@ObfuscatedSignature(descriptor = "Llw;") @Export("WALK")
	public static final ClientPacket IF_BUTTON9 = new ClientPacket(24, 8);
	@ObfuscatedName("al")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPNPC6 = new ClientPacket(25, 2);
	@ObfuscatedName("bd")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket FRIEND_SETRANK = new ClientPacket(26, -1);
	@ObfuscatedName("bb")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket WINDOW_STATUS = new ClientPacket(27, 5);
	@ObfuscatedName("bn")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket NO_TIMEOUT = new ClientPacket(28, 0);
	@ObfuscatedName("ba")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket RESUME_P_NAMEDIALOG = new ClientPacket(29, -1);
	@ObfuscatedName("bf")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPNPC5 = new ClientPacket(30, 3);
	@ObfuscatedName("bs")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPNPC1 = new ClientPacket(31, 3);
	@ObfuscatedName("bp")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPNPC2")
	public static final ClientPacket IF_BUTTON5 = new ClientPacket(32, 8);
	@ObfuscatedName("bv")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket SEND_PING_REPLY = new ClientPacket(33, 10);
	@ObfuscatedName("bq")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("IF_BUTTON1")
	public static final ClientPacket IF_BUTTON1 = new ClientPacket(34, 8);
	@ObfuscatedName("bo")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPOBJU = new ClientPacket(35, 15);
	@ObfuscatedName("br")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPOBJT = new ClientPacket(36, 15);
	@ObfuscatedName("bw")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPLOC1 = new ClientPacket(37, 7);
	@ObfuscatedName("be")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket RESUME_P_STRINGDIALOG = new ClientPacket(38, -1);
	@ObfuscatedName("bc")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPLOCU = new ClientPacket(39, 15);
	@ObfuscatedName("bi")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPOBJ3")
	public static final ClientPacket OPPLAYER3 = new ClientPacket(40, 3);
	@ObfuscatedName("bu")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket RESUME_P_OBJDIALOG = new ClientPacket(41, 2);
	@ObfuscatedName("bk")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPLOC3 = new ClientPacket(42, 7);
	@ObfuscatedName("bz")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket NATIVE_PACKET = new ClientPacket(43, 7);
	@ObfuscatedName("bx")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket AFFINEDCLANSETTINGS_SETMUTED_FROMCHANNEL = new ClientPacket(44, -1);
	@ObfuscatedName("bh")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPOBJ5 = new ClientPacket(45, 7);
	@ObfuscatedName("bm")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPOBJ5")
	public static final ClientPacket BUG_REPORT = new ClientPacket(46, -2);
	@ObfuscatedName("bl")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket IF_BUTTON6 = new ClientPacket(47, 8);
	@ObfuscatedName("bt")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket FRIENDLIST_ADD = new ClientPacket(48, -1);
	@ObfuscatedName("by")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPPLAYER8")
	public static final ClientPacket OPNPCU = new ClientPacket(49, 11);
	@ObfuscatedName("bg")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPLOC4")
	public static final ClientPacket RESUME_P_COUNTDIALOG = new ClientPacket(50, 4);
	@ObfuscatedName("bj")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket CLANCHANNEL_KICKUSER = new ClientPacket(51, -1);
	@ObfuscatedName("ct")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPNPC5")
	public static final ClientPacket IF_BUTTON4 = new ClientPacket(52, 8);
	@ObfuscatedName("cf")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPOBJ4 = new ClientPacket(53, 7);
	@ObfuscatedName("cz")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket EXIT_FREECAM = new ClientPacket(54, 0);
	@ObfuscatedName("cb")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPPLAYER4 = new ClientPacket(55, 3);
	@ObfuscatedName("cs")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPPLAYER2 = new ClientPacket(56, 3);
	@ObfuscatedName("cj")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket LOGIN_STATISTICS = new ClientPacket(57, -1);
	@ObfuscatedName("cn")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPOBJ2 = new ClientPacket(58, 7);
	@ObfuscatedName("cw")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPLOC4 = new ClientPacket(59, 7);
	@ObfuscatedName("ce")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket IGNORELIST_DEL = new ClientPacket(60, -1);
	@ObfuscatedName("cq")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPPLAYER5 = new ClientPacket(61, 3);
	@ObfuscatedName("cm")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket field2542 = new ClientPacket(62, -1);
	@ObfuscatedName("ca")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket NATIVE_PACKET2 = new ClientPacket(63, -1);
	@ObfuscatedName("cx")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("IF_BUTTONT")
	public static final ClientPacket OPPLAYER6 = new ClientPacket(64, 3);
	@ObfuscatedName("co")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket field2544 = new ClientPacket(65, 4);
	@ObfuscatedName("cu")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket field2550 = new ClientPacket(66, -2);
	@ObfuscatedName("cr")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPOBJ2")
	public static final ClientPacket OPOBJ1 = new ClientPacket(67, 7);
	@ObfuscatedName("cd")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("CONTINUE")
	public static final ClientPacket CONTINUE = new ClientPacket(68, 6);
	@ObfuscatedName("cy")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPPLAYER4")
	public static final ClientPacket OPPLAYERU = new ClientPacket(69, 11);
	@ObfuscatedName("ck")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPPLAYER8 = new ClientPacket(70, 3);
	@ObfuscatedName("cl")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPLOC6 = new ClientPacket(71, 2);
	@ObfuscatedName("cp")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPOBJ3 = new ClientPacket(72, 7);
	@ObfuscatedName("ch")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket IGNORELIST_ADD = new ClientPacket(73, -1);
	@ObfuscatedName("cg")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("IF_BUTTON3")
	public static final ClientPacket CAMVIEW_CLICK = new ClientPacket(74, 22);
	@ObfuscatedName("ci")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket REFLECTION_CHECK_REPLY = new ClientPacket(75, -1);
	@ObfuscatedName("cv")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPNPC2 = new ClientPacket(76, 3);
	@ObfuscatedName("cc")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPOBJT")
	public static final ClientPacket OPPLAYER7 = new ClientPacket(77, 3);
	@ObfuscatedName("dc")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPOBJ1")
	public static final ClientPacket MAP_BUILD_COMPLETE = new ClientPacket(78, 0);
	@ObfuscatedName("dq")
	@ObfuscatedSignature(descriptor = "Llw;") @Export("OPPLAYER1")
	public static final ClientPacket OPPLAYER1 = new ClientPacket(79, 3);
	@ObfuscatedName("dg")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPPLAYER6")
	public static final ClientPacket OPNPC4 = new ClientPacket(80, 3);
	@ObfuscatedName("dj")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket CLOSE_MODAL = new ClientPacket(81, 0);
	@ObfuscatedName("dy")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket IF_BUTTON7 = new ClientPacket(82, 8);
	@ObfuscatedName("dr")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPLOC5")
	public static final ClientPacket IF_BUTTON2 = new ClientPacket(83, 8);
	@ObfuscatedName("do")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket IF_BUTTON8 = new ClientPacket(84, 8);
	@ObfuscatedName("dk")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket AFFINEDCLANSETTINGS_ADDBANNED_FROMCHANNEL = new ClientPacket(85, -1);
	@ObfuscatedName("dn")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket SET_CHATFILTERSETTINGS = new ClientPacket(86, 3);
	@ObfuscatedName("di")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket SOUND_SONGEND = new ClientPacket(87, 4);
	@ObfuscatedName("de")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket IF_BUTTOND = new ClientPacket(88, 16);
	@ObfuscatedName("dd")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket OPLOCT = new ClientPacket(89, 15);
	@ObfuscatedName("dt")
	@ObfuscatedSignature(descriptor = "Llw;")
	@Export("OPPLAYER5")
	public static final ClientPacket OPPLAYERT = new ClientPacket(90, 11);
	@ObfuscatedName("df")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket EVENT_CAMERA_POSITION = new ClientPacket(91, 4);
	@ObfuscatedName("dm")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket NATIVE_PACKET5 = new ClientPacket(92, 2);
	@ObfuscatedName("du")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket MOVE_GAMECLICK = new ClientPacket(93, -1);
	@ObfuscatedName("dz")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket MESSAGE_PUBLIC = new ClientPacket(94, -1);
	@ObfuscatedName("dx")
	@ObfuscatedSignature(descriptor = "Llw;")
	public static final ClientPacket EVENT_MOUSE_SCROLl = new ClientPacket(95, 2);
	@ObfuscatedName("dp") @Export("id") final int id;
	@ObfuscatedName("ds") @Export("length") final int length;


	ClientPacket(int var1, int var2) {
		this.id = var1;
		this.length = var2;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1172052861"
	)
	public static int method1569(int var0) {
		return var0 >> 17 & 7;
	}

	@ObfuscatedName("jh")
	@ObfuscatedSignature(
		descriptor = "(I)Lod;",
		garbageValue = "1574453085"
	)
	@Export("getScriptEvents")
	public static NodeDeque getScriptEvents() {
		return Client.scriptEvents;
	}
}
