import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
@Implements("ServerPacket")
public class ServerPacket {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket REBUILD_REGION_NORMAL = new ServerPacket(0, -2);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket REBUILD_REGION = new ServerPacket(1, -2);
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2542 = new ServerPacket(2, 14);
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket CLANCHANNEL_DELTA = new ServerPacket(3, -2);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2540 = new ServerPacket(4, 2);
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2541 = new ServerPacket(5, 6);
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket REFLECTION_CHECK = new ServerPacket(6, -2);
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2543 = new ServerPacket(7, 16);
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2635 = new ServerPacket(8, 6);
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket UPDATE_INV_FULL = new ServerPacket(9, -2);
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket CHAT_FILTER_SETTINGS = new ServerPacket(10, 2);
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2547 = new ServerPacket(11, 0);
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2548 = new ServerPacket(12, 5);
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2559 = new ServerPacket(13, 8);
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2550 = new ServerPacket(14, 5);
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2551 = new ServerPacket(15, -2);
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2552 = new ServerPacket(16, 8);
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2553 = new ServerPacket(17, 14);
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2611 = new ServerPacket(18, 6);
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2555 = new ServerPacket(19, 6);
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2556 = new ServerPacket(20, -1);
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket SPOTANIM_SPECIFIC = new ServerPacket(21, 8);
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket RESET_ANIMS = new ServerPacket(22, 0);
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2544 = new ServerPacket(23, -2);
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2617 = new ServerPacket(24, 4);
   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket ENTER_FREECAM = new ServerPacket(25, 1);
   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2562 = new ServerPacket(26, 1);
   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2563 = new ServerPacket(27, 2);
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2564 = new ServerPacket(28, 2);
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2565 = new ServerPacket(29, 5);
   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2566 = new ServerPacket(30, 0);
   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2570 = new ServerPacket(31, 4);
   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2584 = new ServerPacket(32, 1);
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket UPDATE_INV_PARTIAL = new ServerPacket(33, -2);
   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2545 = new ServerPacket(34, 6);
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2608 = new ServerPacket(35, -1);
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket PLAYER_INFO = new ServerPacket(36, -2);
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket GAMEFRAME_FULL = new ServerPacket(37, -2);
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2567 = new ServerPacket(38, 8);
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket TRIGGER_ONDIALOGABORT = new ServerPacket(39, 0);
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2576 = new ServerPacket(40, 5);
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket SYNTH_SOUND = new ServerPacket(41, 5);
   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket HEAT_MAP = new ServerPacket(42, 1);
   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket TRADING_POST_RESULTS = new ServerPacket(43, -2);
   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2580 = new ServerPacket(44, -2);
   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket MESSAGE_PRIVATE = new ServerPacket(45, -2);
   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2637 = new ServerPacket(46, 2);
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket IF_SETEVENTS = new ServerPacket(47, 12);
   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2538 = new ServerPacket(48, 6);
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket FRIENDLIST_LOADED = new ServerPacket(49, 0);
   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2586 = new ServerPacket(50, 2);
   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket CAM_SHAKE = new ServerPacket(51, 4);
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket UPDATE_UID192 = new ServerPacket(52, 28);
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2644 = new ServerPacket(53, 4);
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2590 = new ServerPacket(54, -1);
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket IF_MOVESUB = new ServerPacket(55, 8);
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket UPDATE_RUNENERGY = new ServerPacket(56, 2);
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket IF_SETNPCHEAD = new ServerPacket(57, 6);
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket UPDATE_ZONE_PARTIAL_FOLLOWS = new ServerPacket(58, 2);
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2620 = new ServerPacket(59, 1);
   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket IF_SETANIM = new ServerPacket(60, 6);
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket IF_OPENSUB = new ServerPacket(61, 7);
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2539 = new ServerPacket(62, -2);
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2599 = new ServerPacket(63, -2);
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2600 = new ServerPacket(64, 4);
   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2621 = new ServerPacket(65, -1);
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket CAM_LOOKAT = new ServerPacket(66, 6);
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2603 = new ServerPacket(67, 6);
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2604 = new ServerPacket(68, 20);
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2605 = new ServerPacket(69, 0);
   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2606 = new ServerPacket(70, -2);
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2607 = new ServerPacket(71, 17);
   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2633 = new ServerPacket(72, 8);
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2609 = new ServerPacket(73, -2);
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2610 = new ServerPacket(74, 10);
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket VARCLAN = new ServerPacket(75, -1);
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2612 = new ServerPacket(76, 6);
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket LOGOUT_TRANSFER = new ServerPacket(77, -1);
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2614 = new ServerPacket(78, 6);
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2615 = new ServerPacket(79, 0);
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2616 = new ServerPacket(80, 2);
   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2596 = new ServerPacket(81, 2);
   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2618 = new ServerPacket(82, 2);
   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2619 = new ServerPacket(83, 0);
   @ObfuscatedName("de")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket MESSAGE_CLANCHANNEL_SYSTEM = new ServerPacket(84, -1);
   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket UPDATE_INV_CLEAR = new ServerPacket(85, 4);
   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2622 = new ServerPacket(86, 9);
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2623 = new ServerPacket(87, 11);
   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2624 = new ServerPacket(88, 4);
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2639 = new ServerPacket(89, -1);
   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2626 = new ServerPacket(90, -2);
   @ObfuscatedName("da")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2627 = new ServerPacket(91, 6);
   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket IF_SETPOSITION = new ServerPacket(92, 8);
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket TOGGLE_OCULUS_ORB = new ServerPacket(93, 4);
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2630 = new ServerPacket(94, -2);
   @ObfuscatedName("db")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2631 = new ServerPacket(95, 3);
   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2632 = new ServerPacket(96, 7);
   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket MESSAGE_PRIVATE_ECHO = new ServerPacket(97, -2);
   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket IF_SETTEXT = new ServerPacket(98, -2);
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2595 = new ServerPacket(99, 0);
   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket NPC_INFO_SMALL = new ServerPacket(100, -2);
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket NPC_INFO_LARGE = new ServerPacket(101, -2);
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2589 = new ServerPacket(102, -1);
   @ObfuscatedName("di")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2554 = new ServerPacket(103, -2);
   @ObfuscatedName("en")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2640 = new ServerPacket(104, 0);
   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket IF_SETOBJECT = new ServerPacket(105, 10);
   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   public static final ServerPacket field2642 = new ServerPacket(106, 5);
   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      descriptor = "Lke;"
   )
   static final ServerPacket field2643 = new ServerPacket(107, -2);
   @ObfuscatedName("ep")
   @Export("id")
   public final int id;
   @ObfuscatedName("eb")
   @Export("length")
   public final int length;

   ServerPacket(int var1, int var2) {
      this.id = var1;
      this.length = var2;
   }
}
