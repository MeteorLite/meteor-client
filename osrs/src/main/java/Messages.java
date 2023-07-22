import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("Messages")
public class Messages {
	@ObfuscatedName("aw")
	@Export("Messages_channels")
	static final Map Messages_channels;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lsa;"
	)
	@Export("Messages_hashTable")
	static final IterableNodeHashTable Messages_hashTable;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Loz;"
	)
	@Export("Messages_queue")
	static final IterableDualNodeQueue Messages_queue;
	@ObfuscatedName("am")
	@Export("Messages_count")
	static int Messages_count;

	static {
		Messages_channels = new HashMap();
		Messages_hashTable = new IterableNodeHashTable(1024);
		Messages_queue = new IterableDualNodeQueue();
		Messages_count = 0;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)[Lls;",
		garbageValue = "-1826957735"
	)
	public static ServerPacket[] method635() {
		return new ServerPacket[]{ServerPacket.NPC_ANIM_SPECIFIC, ServerPacket.AREA_SOUND, ServerPacket.TRADING_POST_UPDATE, ServerPacket.SEND_PING, ServerPacket.UPDATE_REBOOT_TIMER, ServerPacket.IF_SETEVENTS, ServerPacket.NEW_PACKET_CAM_RESET_V2, ServerPacket.SET_PLAYER_OP, ServerPacket.VARP_LARGE, ServerPacket.IF_SETOBJECT, ServerPacket.OPEN_URL, ServerPacket.IF_MOVESUB, ServerPacket.CAM_LOOKAT_EASED_ANGLE_ABSOLUTE, ServerPacket.CAM_MOVETO_EASED_CIRCULAR, ServerPacket.IF_SETTEXT, ServerPacket.REFLECTIONCHECK_FRIENDLIST, ServerPacket.MAPPROJ_ANIM, ServerPacket.GAMEFRAME_FULL, ServerPacket.UPDATE_INV_STOP_TRANSMIT, ServerPacket.MESSAGE_PRIVATE_ECHO, ServerPacket.RUN_CLIENTSCRIPT, ServerPacket.VARCLAN_ENABLE, ServerPacket.MAPPROJ_ANIM_SPECIFIC, ServerPacket.UPDATE_RUNENERGY, ServerPacket.CAM_SHAKE, ServerPacket.MESSAGE_CLANCHANNEL, ServerPacket.IF_SETNPCHEAD, ServerPacket.IF_CLOSESUB, ServerPacket.UPDATE_STAT, ServerPacket.UPDATE_IGNORELIST, ServerPacket.IF_SETCOLOUR, ServerPacket.MAP_ANIM, ServerPacket.NPC_SPOTANIM_SPECIFIC, ServerPacket.HEAT_MAP, ServerPacket.LOC_ADD_CHANGE, ServerPacket.NO_NAME_YET4, ServerPacket.OBJ_ADD, ServerPacket.TRADING_POST_RESULTS, ServerPacket.SPOTANIM_SPECIFIC, ServerPacket.VARP_SMALL, ServerPacket.CHAT_FILTER_SETTINGS, ServerPacket.UPDATE_RUNWEIGHT, ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS, ServerPacket.RESET_ANIMS, ServerPacket.SYNTH_SOUND, ServerPacket.MIDI_JINGLE, ServerPacket.IF1_MODELROTATE, ServerPacket.HINT_ARROW, ServerPacket.NEW_PACK_215, ServerPacket.IF_SETPLAYERMODEL_BASECOLOUR, ServerPacket.IF_SETANGLE, ServerPacket.NPC_HEADICON_SPECIFIC, ServerPacket.MESSAGE_PRIVATE, ServerPacket.IF_SETSCROLLPOS, ServerPacket.REBUILD_REGION, ServerPacket.LOC_ANIM_SPECIFIC, ServerPacket.MESSAGE_GAME, ServerPacket.UPDATE_INV_FULL, ServerPacket.IF_SETANIM, ServerPacket.IF_OPENSUB, ServerPacket.IF_SETMODEL, ServerPacket.UPDATE_UID192, ServerPacket.SYNC_CLIENT_VARCACHE, ServerPacket.CLANSETTINGS_FULL, ServerPacket.CAM_LOOKAT, ServerPacket.SET_MAP_FLAG, ServerPacket.MINIMAP_TOGGLE, ServerPacket.UPDATE_FRIENDLIST, ServerPacket.TRIGGER_ONDIALOGABORT, ServerPacket.IF_SETPLAYERMODEL_OBJ, ServerPacket.PLAYER_SPOTANIM_SPECIFIC, ServerPacket.OBJ_COUNT, ServerPacket.IF_SETPOSITION, ServerPacket.UPDATE_INV_PARTIAL, ServerPacket.RESET_CLIENT_VARCACHE, ServerPacket.FRIENDLIST_LOADED, ServerPacket.NPC_INFO_SMALL, ServerPacket.MESSAGE_FRIENDCHANNEL, ServerPacket.CHAT_FILTER_SETTINGS_PRIVATECHAT, ServerPacket.PLAYER_INFO, ServerPacket.IF_SETPLAYERMODEL_BODYTYPE, ServerPacket.TOGGLE_OCULUS_ORB, ServerPacket.CAM_MOVETO_EASED, ServerPacket.VARCLAN, ServerPacket.LOC_DEL, ServerPacket.REFLECTION_CHECK, ServerPacket.VARCLAN_DISABLE, ServerPacket.ENTER_FREECAM, ServerPacket.CLANCHANNEL_FULL, ServerPacket.MIDI_SONG, ServerPacket.IF_SETHIDE, ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM, ServerPacket.OBJ_DEL_LEGACY, ServerPacket.CLANSETTINGS_DELTA, ServerPacket.UPDATE_ZONE_FULL_FOLLOWS, ServerPacket.UPDATE_INV_CLEAR, ServerPacket.CLANCHANNEL_DELTA, ServerPacket.CAM_RESET, ServerPacket.EMPTY_PACKET, ServerPacket.REBUILD_REGION_NORMAL, ServerPacket.LOGOUT, ServerPacket.LOGOUT_FULL, ServerPacket.UPDATE_ZONE_PARTIAL_ENCLOSED, ServerPacket.CAM_LOOKAT_EASED_COORD, ServerPacket.CAM_LOOKAT_EASED_ANGLE_RELATIVE, ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL_V2, ServerPacket.IF_OPENTOP, ServerPacket.field2719, ServerPacket.CAM_MOVETO, ServerPacket.UPDATE_SITESETTINGS, ServerPacket.PREFETCH_GAMEOBJECTS, ServerPacket.IF_SETPLAYERHEAD, ServerPacket.LOC_ANIM, ServerPacket.OBJ_DEL, ServerPacket.LOGIN_SCREEN_PACKET, ServerPacket.NPC_INFO_LARGE, ServerPacket.IF_SETPLAYERMODEL_SELF, ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL, ServerPacket.NO_NAME_YET, ServerPacket.NO_NAME_YET2, ServerPacket.NO_NAME_YET5, ServerPacket.NO_NAME_YET3};
	}
}
