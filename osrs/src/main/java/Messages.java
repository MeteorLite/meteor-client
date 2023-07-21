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
		return new ServerPacket[]{ServerPacket.field2620, ServerPacket.field2622, ServerPacket.field2615, ServerPacket.CLANCHANNEL_DELTA, ServerPacket.IF_SETTEXT, ServerPacket.field2607, ServerPacket.REFLECTION_CHECK, ServerPacket.field2623, ServerPacket.field2619, ServerPacket.field2613, ServerPacket.CHAT_FILTER_SETTINGS, ServerPacket.field2617, ServerPacket.field2605, ServerPacket.field2621, ServerPacket.field2598, ServerPacket.field2618, ServerPacket.field2602, ServerPacket.field2599, ServerPacket.field2601, ServerPacket.field2612, ServerPacket.field2600, ServerPacket.SPOTANIM_SPECIFIC, ServerPacket.field2611, ServerPacket.NPC_INFO_LARGE, ServerPacket.field2606, ServerPacket.ENTER_FREECAM, ServerPacket.field2627, ServerPacket.IF_SETPOSITION, ServerPacket.field2637, ServerPacket.field2624, ServerPacket.field2629, ServerPacket.field2642, ServerPacket.field2639, ServerPacket.UPDATE_INV_PARTIAL, ServerPacket.field2640, ServerPacket.field2638, ServerPacket.PLAYER_INFO, ServerPacket.field2646, ServerPacket.IF_SETOBJECT, ServerPacket.field2626, ServerPacket.field2632, ServerPacket.field2644, ServerPacket.RESET_ANIMS, ServerPacket.field2649, ServerPacket.field2647, ServerPacket.UPDATE_INV_FULL, ServerPacket.MESSAGE_CLANCHANNEL_SYSTEM, ServerPacket.field2635, ServerPacket.field2643, ServerPacket.field2648, ServerPacket.field2630, ServerPacket.field2633, ServerPacket.UPDATE_UID192, ServerPacket.field2655, ServerPacket.field2675, ServerPacket.field2651, ServerPacket.UPDATE_ZONE_PARTIAL_FOLLOWS, ServerPacket.IF_SETNPCHEAD, ServerPacket.field2663, ServerPacket.HEAT_MAP, ServerPacket.TRIGGER_ONDIALOGABORT, ServerPacket.IF_OPENSUB, ServerPacket.field2662, ServerPacket.field2650, ServerPacket.REBUILD_REGION, ServerPacket.field2664, ServerPacket.CAM_LOOKAT, ServerPacket.field2667, ServerPacket.field2653, ServerPacket.field2674, ServerPacket.field2660, ServerPacket.field2661, ServerPacket.field2665, ServerPacket.field2657, ServerPacket.GAMEFRAME_FULL, ServerPacket.VARCLAN, ServerPacket.field2671, ServerPacket.LOGOUT_TRANSFER, ServerPacket.field2678, ServerPacket.field2692, ServerPacket.field2682, ServerPacket.field2685, ServerPacket.field2700, ServerPacket.field2693, ServerPacket.field2690, ServerPacket.field2686, ServerPacket.field2689, ServerPacket.field2684, ServerPacket.NPC_INFO_SMALL, ServerPacket.field2679, ServerPacket.field2695, ServerPacket.field2681, ServerPacket.field2688, ServerPacket.field2696, ServerPacket.UPDATE_INV_CLEAR, ServerPacket.field2699, ServerPacket.TRADING_POST_RESULTS, ServerPacket.MESSAGE_PRIVATE_ECHO, ServerPacket.field2676, ServerPacket.field2697, ServerPacket.field2683, ServerPacket.field2687, ServerPacket.field2677, ServerPacket.field2698, ServerPacket.field2716, ServerPacket.field2710, ServerPacket.field2703, ServerPacket.field2719, ServerPacket.UPDATE_RUNENERGY, ServerPacket.MESSAGE_PRIVATE, ServerPacket.field2712, ServerPacket.field2702, ServerPacket.field2709, ServerPacket.REBUILD_REGION_NORMAL, ServerPacket.field2708, ServerPacket.field2711, ServerPacket.field2715, ServerPacket.field2713, ServerPacket.field2705, ServerPacket.field2706, ServerPacket.field2718, ServerPacket.field2704};
	}
}
