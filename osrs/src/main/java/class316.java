import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ObfuscatedName("mi")
public class class316 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	public static AbstractArchive field2792;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	public static AbstractArchive field2791;
	@ObfuscatedName("ao")
	@Export("midiPcmStream")
	public static ArrayList midiPcmStream;
	@ObfuscatedName("ab")
	public static LinkedList field2790;
	@ObfuscatedName("au")
	@Export("musicSongs")
	public static ArrayList musicSongs;
	@ObfuscatedName("aa")
	public static ArrayList field2787;
	@ObfuscatedName("ac")
	static ArrayList field2798;
	@ObfuscatedName("al")
	public static final List field2793;
	@ObfuscatedName("az")
	@Export("musicPlayerStatus")
	static int musicPlayerStatus;
	@ObfuscatedName("ap")
	static int field2794;
	@ObfuscatedName("av")
	static int field2795;
	@ObfuscatedName("ax")
	static int field2796;

	static {
		midiPcmStream = null;
		field2790 = new LinkedList();
		musicSongs = new ArrayList(3);
		field2787 = new ArrayList(3);
		field2798 = new ArrayList();
		field2793 = new ArrayList();
		musicPlayerStatus = 0;
		field2794 = 0;
		field2795 = 0;
		field2796 = 0;
	}

	@ObfuscatedName("nh")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1493963164"
	)
	static final void method1650() {
		Client.field520 = Client.cycleCntr;
		InterfaceParent.field861 = true;
	}
}