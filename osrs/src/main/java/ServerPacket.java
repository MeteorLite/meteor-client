import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ls")
@Implements("ServerPacket")
public class ServerPacket {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket NPC_ANIM_SPECIFIC;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket AREA_SOUND;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket TRADING_POST_UPDATE;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("CLANCHANNEL_DELTA")
	public static final ServerPacket SEND_PING;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("IF_SETTEXT")
	public static final ServerPacket UPDATE_REBOOT_TIMER;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETEVENTS;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("REFLECTION_CHECK")
	public static final ServerPacket NEW_PACKET_CAM_RESET_V2;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket SET_PLAYER_OP;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket VARP_LARGE;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETOBJECT;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("CHAT_FILTER_SETTINGS")
	public static final ServerPacket OPEN_URL;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_MOVESUB;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket CAM_LOOKAT_EASED_ANGLE_ABSOLUTE;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket CAM_MOVETO_EASED_CIRCULAR;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETTEXT;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket REFLECTIONCHECK_FRIENDLIST;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket MAPPROJ_ANIM;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket GAMEFRAME_FULL;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket UPDATE_INV_STOP_TRANSMIT;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket MESSAGE_PRIVATE_ECHO;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket RUN_CLIENTSCRIPT;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("SPOTANIM_SPECIFIC")
	public static final ServerPacket VARCLAN_ENABLE;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket MAPPROJ_ANIM_SPECIFIC;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("NPC_INFO_LARGE")
	public static final ServerPacket UPDATE_RUNENERGY;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket CAM_SHAKE;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("ENTER_FREECAM")
	public static final ServerPacket MESSAGE_CLANCHANNEL;
	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETNPCHEAD;
	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("IF_SETPOSITION")
	public static final ServerPacket IF_CLOSESUB;
	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket UPDATE_STAT;
	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket UPDATE_IGNORELIST;
	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETCOLOUR;
	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket MAP_ANIM;
	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket NPC_SPOTANIM_SPECIFIC;
	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("UPDATE_INV_PARTIAL")
	public static final ServerPacket HEAT_MAP;
	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket LOC_ADD_CHANGE;
	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket PLAYER_ANIM_SPECIFIC;
	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("PLAYER_INFO")
	public static final ServerPacket OBJ_ADD;
	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket TRADING_POST_RESULTS;
	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("IF_SETOBJECT")
	public static final ServerPacket SPOTANIM_SPECIFIC;
	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket VARP_SMALL;
	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket CHAT_FILTER_SETTINGS;
	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket UPDATE_RUNWEIGHT;
	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("RESET_ANIMS")
	public static final ServerPacket UPDATE_ZONE_PARTIAL_FOLLOWS;
	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket RESET_ANIMS;
	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket SYNTH_SOUND;
	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("UPDATE_INV_FULL")
	public static final ServerPacket MIDI_JINGLE;
	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("MESSAGE_CLANCHANNEL_SYSTEM")
	public static final ServerPacket IF1_MODELROTATE;
	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket HINT_ARROW;
	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket NEW_PACK_215;
	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETPLAYERMODEL_BASECOLOUR;
	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETANGLE;
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket NPC_HEADICON_SPECIFIC;
	@ObfuscatedName("ct")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("UPDATE_UID192")
	public static final ServerPacket MESSAGE_PRIVATE;
	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETSCROLLPOS;
	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket REBUILD_REGION;
	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket LOC_ANIM_SPECIFIC;
	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("UPDATE_ZONE_PARTIAL_FOLLOWS")
	public static final ServerPacket MESSAGE_GAME;
	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("IF_SETNPCHEAD")
	public static final ServerPacket UPDATE_INV_FULL;
	@ObfuscatedName("cn")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETANIM;
	@ObfuscatedName("cw")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("HEAT_MAP")
	public static final ServerPacket IF_OPENSUB;
	@ObfuscatedName("ce")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("TRIGGER_ONDIALOGABORT")
	public static final ServerPacket IF_SETMODEL;
	@ObfuscatedName("cq")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("IF_OPENSUB")
	public static final ServerPacket UPDATE_UID192;
	@ObfuscatedName("cm")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket SYNC_CLIENT_VARCACHE;
	@ObfuscatedName("ca")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket CLANSETTINGS_FULL;
	@ObfuscatedName("cx")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("REBUILD_REGION")
	public static final ServerPacket CAM_LOOKAT;
	@ObfuscatedName("co")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket SET_MAP_FLAG;
	@ObfuscatedName("cu")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("CAM_LOOKAT")
	public static final ServerPacket MINIMAP_TOGGLE;
	@ObfuscatedName("cr")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket UPDATE_FRIENDLIST;
	@ObfuscatedName("cd")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket TRIGGER_ONDIALOGABORT;
	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETPLAYERMODEL_OBJ;
	@ObfuscatedName("ck")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket PLAYER_SPOTANIM_SPECIFIC;
	@ObfuscatedName("cl")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket OBJ_COUNT;
	@ObfuscatedName("cp")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETPOSITION;
	@ObfuscatedName("ch")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket UPDATE_INV_PARTIAL;
	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("GAMEFRAME_FULL")
	public static final ServerPacket RESET_CLIENT_VARCACHE;
	@ObfuscatedName("ci")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("VARCLAN")
	public static final ServerPacket FRIENDLIST_LOADED;
	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket NPC_INFO_SMALL;
	@ObfuscatedName("cc")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("LOGOUT_TRANSFER")
	public static final ServerPacket MESSAGE_FRIENDCHANNEL;
	@ObfuscatedName("dc")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket CHAT_FILTER_SETTINGS_PRIVATECHAT;
	@ObfuscatedName("dq")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket PLAYER_INFO;
	@ObfuscatedName("dg")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETPLAYERMODEL_BODYTYPE;
	@ObfuscatedName("dj")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket TOGGLE_OCULUS_ORB;
	@ObfuscatedName("dy")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket CAM_MOVETO_EASED;
	@ObfuscatedName("dr")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket VARCLAN;
	@ObfuscatedName("do")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket LOC_DEL;
	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket REFLECTION_CHECK;
	@ObfuscatedName("dn")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket VARCLAN_DISABLE;
	@ObfuscatedName("di")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket ENTER_FREECAM;
	@ObfuscatedName("de")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("NPC_INFO_SMALL")
	public static final ServerPacket CLANCHANNEL_FULL;
	@ObfuscatedName("dd")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket MIDI_SONG_LEGACY;
	@ObfuscatedName("dt")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETHIDE;
	@ObfuscatedName("df")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket MESSAGE_CLANCHANNEL_SYSTEM;
	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket OBJ_DEL_LEGACY;
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket CLANSETTINGS_DELTA;
	@ObfuscatedName("dz")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("UPDATE_INV_CLEAR")
	public static final ServerPacket UPDATE_ZONE_FULL_FOLLOWS;
	@ObfuscatedName("dx")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket UPDATE_INV_CLEAR;
	@ObfuscatedName("dp")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("TRADING_POST_RESULTS")
	public static final ServerPacket CLANCHANNEL_DELTA;
	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("MESSAGE_PRIVATE_ECHO")
	public static final ServerPacket CAM_RESET;
	@ObfuscatedName("da")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket EMPTY_PACKET;
	@ObfuscatedName("dv")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket REBUILD_REGION_NORMAL;
	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket LOGOUT;
	@ObfuscatedName("dl")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket LOGOUT_FULL;
	@ObfuscatedName("db")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket UPDATE_ZONE_PARTIAL_ENCLOSED;
	@ObfuscatedName("dw")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket CAM_LOOKAT_EASED_COORD;
	@ObfuscatedName("et")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket CAM_LOOKAT_EASED_ANGLE_RELATIVE;
	@ObfuscatedName("em")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket UPDATE_FRIENDCHAT_CHANNEL_FULL_V2;
	@ObfuscatedName("ec")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_OPENTOP;
	@ObfuscatedName("el")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	static final ServerPacket field2719;
	@ObfuscatedName("er")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("UPDATE_RUNENERGY")
	public static final ServerPacket CAM_MOVETO;
	@ObfuscatedName("ew")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("MESSAGE_PRIVATE")
	public static final ServerPacket UPDATE_SITESETTINGS;
	@ObfuscatedName("eo")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket PREFETCH_GAMEOBJECTS;
	@ObfuscatedName("eb")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETPLAYERHEAD;
	@ObfuscatedName("ej")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket LOC_ANIM;
	@ObfuscatedName("eh")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	@Export("REBUILD_REGION_NORMAL")
	public static final ServerPacket OBJ_DEL;
	@ObfuscatedName("ei")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket LOGIN_SCREEN_PACKET;
	@ObfuscatedName("en")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket NPC_INFO_LARGE;
	@ObfuscatedName("es")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket IF_SETPLAYERMODEL_SELF;
	@ObfuscatedName("eq")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket UPDATE_FRIENDCHAT_CHANNEL_FULL;
	@ObfuscatedName("ee")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket MIDI_SONG;
	@ObfuscatedName("eg")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket MIDI_SONG_STOP;
	@ObfuscatedName("ey")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket MIDI_SONG_WITH_SECONDARY;
	@ObfuscatedName("ed")
	@ObfuscatedSignature(
		descriptor = "Lls;"
	)
	public static final ServerPacket MIDI_SWAP;
	@ObfuscatedName("ea")
	@Export("id")
	public final int id;
	@ObfuscatedName("ex")
	@Export("length")
	public final int length;

	static {
		NPC_ANIM_SPECIFIC = new ServerPacket(0, 5);
		AREA_SOUND = new ServerPacket(1, 5);
		TRADING_POST_UPDATE = new ServerPacket(2, 20);
		SEND_PING = new ServerPacket(3, 8);
		UPDATE_REBOOT_TIMER = new ServerPacket(4, 2);
		IF_SETEVENTS = new ServerPacket(5, 12);
		NEW_PACKET_CAM_RESET_V2 = new ServerPacket(6, 4);
		SET_PLAYER_OP = new ServerPacket(7, -1);
		VARP_LARGE = new ServerPacket(8, 6);
		IF_SETOBJECT = new ServerPacket(9, 10);
		OPEN_URL = new ServerPacket(10, -2);
		IF_MOVESUB = new ServerPacket(11, 8);
		CAM_LOOKAT_EASED_ANGLE_ABSOLUTE = new ServerPacket(12, 7);
		CAM_MOVETO_EASED_CIRCULAR = new ServerPacket(13, 10);
		IF_SETTEXT = new ServerPacket(14, -2);
		REFLECTIONCHECK_FRIENDLIST = new ServerPacket(15, -1);
		MAPPROJ_ANIM = new ServerPacket(16, 16);
		GAMEFRAME_FULL = new ServerPacket(17, -2);
		UPDATE_INV_STOP_TRANSMIT = new ServerPacket(18, 2);
		MESSAGE_PRIVATE_ECHO = new ServerPacket(19, -2);
		RUN_CLIENTSCRIPT = new ServerPacket(20, -2);
		VARCLAN_ENABLE = new ServerPacket(21, 0);
		MAPPROJ_ANIM_SPECIFIC = new ServerPacket(22, 17);
		UPDATE_RUNENERGY = new ServerPacket(23, 2);
		CAM_SHAKE = new ServerPacket(24, 4);
		MESSAGE_CLANCHANNEL = new ServerPacket(25, -1);
		IF_SETNPCHEAD = new ServerPacket(26, 6);
		IF_CLOSESUB = new ServerPacket(27, 4);
		UPDATE_STAT = new ServerPacket(28, 6);
		UPDATE_IGNORELIST = new ServerPacket(29, -2);
		IF_SETCOLOUR = new ServerPacket(30, 6);
		MAP_ANIM = new ServerPacket(31, 6);
		NPC_SPOTANIM_SPECIFIC = new ServerPacket(32, 9);
		HEAT_MAP = new ServerPacket(33, 1);
		LOC_ADD_CHANGE = new ServerPacket(34, 5);
		PLAYER_ANIM_SPECIFIC = new ServerPacket(35, 3);
		OBJ_ADD = new ServerPacket(36, 14);
		TRADING_POST_RESULTS = new ServerPacket(37, -2);
		SPOTANIM_SPECIFIC = new ServerPacket(38, 8);
		VARP_SMALL = new ServerPacket(39, 3);
		CHAT_FILTER_SETTINGS = new ServerPacket(40, 2);
		UPDATE_RUNWEIGHT = new ServerPacket(41, 2);
		UPDATE_ZONE_PARTIAL_FOLLOWS = new ServerPacket(42, 2);
		RESET_ANIMS = new ServerPacket(43, 0);
		SYNTH_SOUND = new ServerPacket(44, 5);
		MIDI_JINGLE = new ServerPacket(45, 5);
		IF1_MODELROTATE = new ServerPacket(46, 8);
		HINT_ARROW = new ServerPacket(47, 6);
		NEW_PACK_215 = new ServerPacket(48, -1);
		IF_SETPLAYERMODEL_BASECOLOUR = new ServerPacket(49, 6);
		IF_SETANGLE = new ServerPacket(50, 10);
		NPC_HEADICON_SPECIFIC = new ServerPacket(51, 9);
		MESSAGE_PRIVATE = new ServerPacket(52, -2);
		IF_SETSCROLLPOS = new ServerPacket(53, 6);
		REBUILD_REGION = new ServerPacket(54, -2);
		LOC_ANIM_SPECIFIC = new ServerPacket(55, 6);
		MESSAGE_GAME = new ServerPacket(56, -1);
		UPDATE_INV_FULL = new ServerPacket(57, -2);
		IF_SETANIM = new ServerPacket(58, 6);
		IF_OPENSUB = new ServerPacket(59, 7);
		IF_SETMODEL = new ServerPacket(60, 6);
		UPDATE_UID192 = new ServerPacket(61, 28);
		SYNC_CLIENT_VARCACHE = new ServerPacket(62, 0);
		CLANSETTINGS_FULL = new ServerPacket(63, -2);
		CAM_LOOKAT = new ServerPacket(64, 6);
		SET_MAP_FLAG = new ServerPacket(65, 2);
		MINIMAP_TOGGLE = new ServerPacket(66, 1);
		UPDATE_FRIENDLIST = new ServerPacket(67, -2);
		TRIGGER_ONDIALOGABORT = new ServerPacket(68, 0);
		IF_SETPLAYERMODEL_OBJ = new ServerPacket(69, 8);
		PLAYER_SPOTANIM_SPECIFIC = new ServerPacket(70, 9);
		OBJ_COUNT = new ServerPacket(71, 11);
		IF_SETPOSITION = new ServerPacket(72, 8);
		UPDATE_INV_PARTIAL = new ServerPacket(73, -2);
		RESET_CLIENT_VARCACHE = new ServerPacket(74, 0);
		FRIENDLIST_LOADED = new ServerPacket(75, 0);
		NPC_INFO_SMALL = new ServerPacket(76, -2);
		MESSAGE_FRIENDCHANNEL = new ServerPacket(77, -1);
		CHAT_FILTER_SETTINGS_PRIVATECHAT = new ServerPacket(78, 1);
		PLAYER_INFO = new ServerPacket(79, -2);
		IF_SETPLAYERMODEL_BODYTYPE = new ServerPacket(80, 5);
		TOGGLE_OCULUS_ORB = new ServerPacket(81, 4);
		CAM_MOVETO_EASED = new ServerPacket(82, 8);
		VARCLAN = new ServerPacket(83, -1);
		LOC_DEL = new ServerPacket(84, 2);
		REFLECTION_CHECK = new ServerPacket(85, -2);
		VARCLAN_DISABLE = new ServerPacket(86, 0);
		ENTER_FREECAM = new ServerPacket(87, 1);
		CLANCHANNEL_FULL = new ServerPacket(88, -2);
		MIDI_SONG_LEGACY = new ServerPacket(89, 2);
		IF_SETHIDE = new ServerPacket(90, 5);
		MESSAGE_CLANCHANNEL_SYSTEM = new ServerPacket(91, -1);
		OBJ_DEL_LEGACY = new ServerPacket(92, 4);
		CLANSETTINGS_DELTA = new ServerPacket(93, -2);
		UPDATE_ZONE_FULL_FOLLOWS = new ServerPacket(94, 2);
		UPDATE_INV_CLEAR = new ServerPacket(95, 4);
		CLANCHANNEL_DELTA = new ServerPacket(96, -2);
		CAM_RESET = new ServerPacket(97, 0);
		EMPTY_PACKET = new ServerPacket(98, 0);
		REBUILD_REGION_NORMAL = new ServerPacket(99, -2);
		LOGOUT = new ServerPacket(100, 1);
		LOGOUT_FULL = new ServerPacket(101, 0);
		UPDATE_ZONE_PARTIAL_ENCLOSED = new ServerPacket(102, -2);
		CAM_LOOKAT_EASED_COORD = new ServerPacket(103, 7);
		CAM_LOOKAT_EASED_ANGLE_RELATIVE = new ServerPacket(104, 7);
		UPDATE_FRIENDCHAT_CHANNEL_FULL_V2 = new ServerPacket(105, -2);
		IF_OPENTOP = new ServerPacket(106, 2);
		field2719 = new ServerPacket(107, -2);
		CAM_MOVETO = new ServerPacket(108, 6);
		UPDATE_SITESETTINGS = new ServerPacket(109, -1);
		PREFETCH_GAMEOBJECTS = new ServerPacket(110, 14);
		IF_SETPLAYERHEAD = new ServerPacket(111, 4);
		LOC_ANIM = new ServerPacket(112, 4);
		OBJ_DEL = new ServerPacket(113, 7);
		LOGIN_SCREEN_PACKET = new ServerPacket(114, 6);
		NPC_INFO_LARGE = new ServerPacket(115, -2);
		IF_SETPLAYERMODEL_SELF = new ServerPacket(116, 5);
		UPDATE_FRIENDCHAT_CHANNEL_FULL = new ServerPacket(117, -2);
		MIDI_SONG = new ServerPacket(118, 10);
		MIDI_SONG_STOP = new ServerPacket(119, 4);
		MIDI_SONG_WITH_SECONDARY = new ServerPacket(120, 12);
		MIDI_SWAP = new ServerPacket(121, 8);
	}

	ServerPacket(int var1, int var2) {
		this.id = var1;
		this.length = var2;
	}
}
