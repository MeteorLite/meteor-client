import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
public class class209 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	static final class209 field1649;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	static final class209 field1652;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	static final class209 field1651;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	static final class209 field1655;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	static final class209 field1653;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	static final class209 field1650;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	static final class209 field1654;

	static {
		field1649 = new class209(0, class223.field1868);
		field1652 = new class209(1, class223.field1865);
		field1651 = new class209(2, class223.field1869);
		field1655 = new class209(3, class223.field1870);
		field1653 = new class209(4, class223.field1871);
		field1650 = new class209(5, class223.field1866);
		field1654 = new class209(6, class223.field1867);
	}

	@ObfuscatedSignature(
		descriptor = "(ILij;)V"
	)
	class209(int var1, class223 var2) {
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)[Lng;",
		garbageValue = "-563682826"
	)
	static GameBuild[] method1031() {
		return new GameBuild[]{GameBuild.LIVE, GameBuild.BUILDLIVE, GameBuild.RC, GameBuild.WIP};
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)[Llu;",
		garbageValue = "50"
	)
	public static ServerPacket[] method1033() {
		return new ServerPacket[]{ServerPacket.NPC_ANIM_SPECIFIC, ServerPacket.REFLECTIONCHECK_FRIENDLIST, ServerPacket.TRADING_POST_UPDATE, ServerPacket.SEND_PING, ServerPacket.field2649, ServerPacket.IF_SETNPCHEAD, ServerPacket.field2652, ServerPacket.SET_PLAYER_OP, ServerPacket.OBJ_COUNT, ServerPacket.UPDATE_UID192, ServerPacket.OBJ_DEL_LEGACY, ServerPacket.MIDI_SONG_LEGACY, ServerPacket.RESET_ANIMS, ServerPacket.IF_OPENTOP, ServerPacket.UPDATE_INV_STOP_TRANSMIT, ServerPacket.MIDI_SONG_WITH_SECONDARY, ServerPacket.MAPPROJ_ANIM, ServerPacket.OPEN_URL, ServerPacket.field2643, ServerPacket.IF_CLOSESUB, ServerPacket.UPDATE_ZONE_PARTIAL_ENCLOSED, ServerPacket.VARCLAN_ENABLE, ServerPacket.UPDATE_REBOOT_TIMER, ServerPacket.VARP_LARGE, ServerPacket.TRADING_POST_RESULTS, ServerPacket.MESSAGE_CLANCHANNEL, ServerPacket.NPC_SPOTANIM_SPECIFIC, ServerPacket.IF_SETTEXT, ServerPacket.UPDATE_STAT, ServerPacket.UPDATE_IGNORELIST, ServerPacket.IF_SETMODEL, ServerPacket.MAP_ANIM, ServerPacket.IF_SETEVENTS, ServerPacket.MIDI_SONG_STOP, ServerPacket.LOC_ADD_CHANGE, ServerPacket.field2675, ServerPacket.OBJ_ADD, ServerPacket.LOC_ANIM_SPECIFIC, ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS, ServerPacket.PLAYER_INFO, ServerPacket.MESSAGE_PRIVATE_ECHO, ServerPacket.UPDATE_RUNWEIGHT, ServerPacket.CAM_LOOKAT_EASED_ANGLE_RELATIVE, ServerPacket.VARP_SMALL, ServerPacket.PLAYER_SPOTANIM_SPECIFIC, ServerPacket.field2672, ServerPacket.IF1_MODELROTATE, ServerPacket.HINT_ARROW, ServerPacket.NEW_PACK_215, ServerPacket.IF_SETANGLE, ServerPacket.IF_SETPLAYERMODEL_OBJ, ServerPacket.field2683, ServerPacket.MESSAGE_PRIVATE, ServerPacket.IF_SETOBJECT, ServerPacket.CAM_MOVETO_EASED_CIRCULAR, ServerPacket.CLANCHANNEL_DELTA, ServerPacket.IF_SETPLAYERMODEL_SELF, ServerPacket.UPDATE_INV_FULL, ServerPacket.CHAT_FILTER_SETTINGS_PRIVATECHAT, ServerPacket.IF_OPENSUB, ServerPacket.IF_SETPOSITION, ServerPacket.CAM_RESET, ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL_V2, ServerPacket.CLANSETTINGS_FULL, ServerPacket.CAM_SHAKE, ServerPacket.SET_MAP_FLAG, ServerPacket.MINIMAP_TOGGLE, ServerPacket.UPDATE_FRIENDLIST, ServerPacket.TRIGGER_ONDIALOGABORT, ServerPacket.MIDI_JINGLE, ServerPacket.REBUILD_REGION, ServerPacket.IF_SETPLAYERMODEL_BODYTYPE, ServerPacket.NPC_HEADICON_SPECIFIC, ServerPacket.UPDATE_INV_PARTIAL, ServerPacket.RESET_CLIENT_VARCACHE, ServerPacket.FRIENDLIST_LOADED, ServerPacket.NPC_INFO_SMALL, ServerPacket.MESSAGE_FRIENDCHANNEL, ServerPacket.REFLECTION_CHECK, ServerPacket.VARCLAN, ServerPacket.field2730, ServerPacket.MESSAGE_GAME, ServerPacket.CAM_MOVETO_EASED, ServerPacket.PREFETCH_GAMEOBJECTS, ServerPacket.IF_SETPLAYERMODEL_BASECOLOUR, ServerPacket.SYNC_CLIENT_VARCACHE, ServerPacket.VARCLAN_DISABLE, ServerPacket.UPDATE_RUNENERGY, ServerPacket.IF_SETANIM, ServerPacket.NPC_INFO_LARGE, ServerPacket.IF_SETHIDE, ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM, ServerPacket.field2720, ServerPacket.CLANSETTINGS_DELTA, ServerPacket.RUN_CLIENTSCRIPT, ServerPacket.UPDATE_SITESETTINGS, ServerPacket.UPDATE_ZONE_FULL_FOLLOWS, ServerPacket.LOGOUT_FULL, ServerPacket.EMPTY_PACKET, ServerPacket.HEAT_MAP, ServerPacket.field2736, ServerPacket.field2714, ServerPacket.field2715, ServerPacket.SPOTANIM_SPECIFIC, ServerPacket.IF_SETSCROLLPOS, ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL, ServerPacket.CAM_LOOKAT_EASED_COORD, ServerPacket.LOGOUT, ServerPacket.CAM_MOVETO, ServerPacket.field2744, ServerPacket.NEW_PACKET_CAM_RESET_V2, ServerPacket.IF_SETPLAYERHEAD, ServerPacket.UPDATE_INV_CLEAR, ServerPacket.OBJ_DEL, ServerPacket.LOGIN_SCREEN_PACKET, ServerPacket.REBUILD_REGION_NORMAL, ServerPacket.TOGGLE_OCULUS_ORB, ServerPacket.LOC_DEL, ServerPacket.MIDI_SONG, ServerPacket.ENTER_FREECAM, ServerPacket.SYNTH_SOUND, ServerPacket.MIDI_SWAP, ServerPacket.PLAYER_ANIM_SPECIFIC, ServerPacket.field2738, ServerPacket.field2755};
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "3"
	)
	public static boolean method1032(int var0) {
		return var0 == WorldMapDecorationType.field3173.id;
	}
}