import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class176 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "[Lch;"
	)
	@Export("World_worlds")
	static World[] World_worlds;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Let;"
	)
	public UrlRequest field1469;
	@ObfuscatedName("ae")
	public float[] field1470;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lgf;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class170 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lgf;)V"
	)
	class176(class170 var1) {
		this.this$0 = var1;
		this.field1470 = new float[4];
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[Llg;",
		garbageValue = "-1051328819"
	)
	public static ServerPacket[] method916() {
		return new ServerPacket[]{ServerPacket.NPC_ANIM_SPECIFIC, ServerPacket.AREA_SOUND, ServerPacket.TRADING_POST_UPDATE, ServerPacket.SEND_PING, ServerPacket.UPDATE_REBOOT_TIMER, ServerPacket.IF_SETEVENTS, ServerPacket.NEW_PACKET_CAM_RESET_V2, ServerPacket.SET_PLAYER_OP, ServerPacket.VARP_LARGE, ServerPacket.IF_SETOBJECT, ServerPacket.OPEN_URL, ServerPacket.IF_MOVESUB, ServerPacket.CAM_LOOKAT_EASED_ANGLE_ABSOLUTE, ServerPacket.CAM_MOVETO_EASED_CIRCULAR, ServerPacket.IF_SETTEXT, ServerPacket.REFLECTIONCHECK_FRIENDLIST, ServerPacket.MAPPROJ_ANIM, ServerPacket.GAMEFRAME_FULL, ServerPacket.UPDATE_INV_STOP_TRANSMIT, ServerPacket.MESSAGE_PRIVATE_ECHO, ServerPacket.RUN_CLIENTSCRIPT, ServerPacket.VARCLAN_ENABLE, ServerPacket.MAPPROJ_ANIM_SPECIFIC, ServerPacket.UPDATE_RUNENERGY, ServerPacket.CAM_SHAKE, ServerPacket.MESSAGE_CLANCHANNEL, ServerPacket.IF_SETNPCHEAD, ServerPacket.IF_CLOSESUB, ServerPacket.UPDATE_STAT, ServerPacket.UPDATE_IGNORELIST, ServerPacket.IF_SETCOLOUR, ServerPacket.MAP_ANIM, ServerPacket.NPC_SPOTANIM_SPECIFIC, ServerPacket.HEAT_MAP, ServerPacket.LOC_ADD_CHANGE, ServerPacket.PLAYER_ANIM_SPECIFIC, ServerPacket.OBJ_ADD, ServerPacket.TRADING_POST_RESULTS, ServerPacket.SPOTANIM_SPECIFIC, ServerPacket.VARP_SMALL, ServerPacket.CHAT_FILTER_SETTINGS, ServerPacket.UPDATE_RUNWEIGHT, ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS, ServerPacket.RESET_ANIMS, ServerPacket.SYNTH_SOUND, ServerPacket.MIDI_JINGLE, ServerPacket.IF1_MODELROTATE, ServerPacket.HINT_ARROW, ServerPacket.NEW_PACK_215, ServerPacket.IF_SETPLAYERMODEL_BASECOLOUR, ServerPacket.IF_SETANGLE, ServerPacket.NPC_HEADICON_SPECIFIC, ServerPacket.MESSAGE_PRIVATE, ServerPacket.IF_SETSCROLLPOS, ServerPacket.REBUILD_REGION, ServerPacket.LOC_ANIM_SPECIFIC, ServerPacket.MESSAGE_GAME, ServerPacket.UPDATE_INV_FULL, ServerPacket.IF_SETANIM, ServerPacket.IF_OPENSUB, ServerPacket.IF_SETMODEL, ServerPacket.UPDATE_UID192, ServerPacket.SYNC_CLIENT_VARCACHE, ServerPacket.CLANSETTINGS_FULL, ServerPacket.CAM_LOOKAT, ServerPacket.SET_MAP_FLAG, ServerPacket.MINIMAP_TOGGLE, ServerPacket.UPDATE_FRIENDLIST, ServerPacket.TRIGGER_ONDIALOGABORT, ServerPacket.IF_SETPLAYERMODEL_OBJ, ServerPacket.PLAYER_SPOTANIM_SPECIFIC, ServerPacket.OBJ_COUNT, ServerPacket.IF_SETPOSITION, ServerPacket.UPDATE_INV_PARTIAL, ServerPacket.RESET_CLIENT_VARCACHE, ServerPacket.FRIENDLIST_LOADED, ServerPacket.NPC_INFO_SMALL, ServerPacket.MESSAGE_FRIENDCHANNEL, ServerPacket.CHAT_FILTER_SETTINGS_PRIVATECHAT, ServerPacket.PLAYER_INFO, ServerPacket.IF_SETPLAYERMODEL_BODYTYPE, ServerPacket.TOGGLE_OCULUS_ORB, ServerPacket.CAM_MOVETO_EASED, ServerPacket.VARCLAN, ServerPacket.LOC_DEL, ServerPacket.REFLECTION_CHECK, ServerPacket.VARCLAN_DISABLE, ServerPacket.ENTER_FREECAM, ServerPacket.CLANCHANNEL_FULL, ServerPacket.MIDI_SONG_LEGACY, ServerPacket.IF_SETHIDE, ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM, ServerPacket.OBJ_DEL_LEGACY, ServerPacket.CLANSETTINGS_DELTA, ServerPacket.UPDATE_ZONE_FULL_FOLLOWS, ServerPacket.UPDATE_INV_CLEAR, ServerPacket.CLANCHANNEL_DELTA, ServerPacket.CAM_RESET, ServerPacket.EMPTY_PACKET, ServerPacket.REBUILD_REGION_NORMAL, ServerPacket.LOGOUT, ServerPacket.LOGOUT_FULL, ServerPacket.UPDATE_ZONE_PARTIAL_ENCLOSED, ServerPacket.CAM_LOOKAT_EASED_COORD, ServerPacket.CAM_LOOKAT_EASED_ANGLE_RELATIVE, ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL_V2, ServerPacket.IF_OPENTOP, ServerPacket.field2725, ServerPacket.CAM_MOVETO, ServerPacket.UPDATE_SITESETTINGS, ServerPacket.PREFETCH_GAMEOBJECTS, ServerPacket.IF_SETPLAYERHEAD, ServerPacket.LOC_ANIM, ServerPacket.OBJ_DEL, ServerPacket.LOGIN_SCREEN_PACKET, ServerPacket.NPC_INFO_LARGE, ServerPacket.IF_SETPLAYERMODEL_SELF, ServerPacket.UPDATE_FRIENDCHAT_CHANNEL_FULL, ServerPacket.MIDI_SONG, ServerPacket.MIDI_SONG_STOP, ServerPacket.MIDI_SONG_WITH_SECONDARY, ServerPacket.MIDI_SWAP, ServerPacket.field2730};
	}

	@ObfuscatedName("mu")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/String;",
		garbageValue = "-1840256196"
	)
	static final String method917(int var0) {
		return var0 < 999999999 ? Integer.toString(var0) : "*";
	}
}