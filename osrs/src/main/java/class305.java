import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ObfuscatedName("lz")
public class class305 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	public static AbstractArchive field2777;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	public static AbstractArchive field2775;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	public static AbstractArchive field2776;
	@ObfuscatedName("at")
	@Export("midiPcmStream")
	public static ArrayList midiPcmStream;
	@ObfuscatedName("ac")
	public static LinkedList field2774;
	@ObfuscatedName("ai")
	@Export("musicSongs")
	public static ArrayList musicSongs;
	@ObfuscatedName("az")
	public static ArrayList field2773;
	@ObfuscatedName("ap")
	public static ArrayList field2771;
	@ObfuscatedName("aa")
	public static final List field2778;
	@ObfuscatedName("af")
	@Export("musicPlayerStatus")
	public static int musicPlayerStatus;
	@ObfuscatedName("ad")
	public static int field2766;
	@ObfuscatedName("aq")
	public static int field2769;
	@ObfuscatedName("al")
	public static int field2768;

	static {
		midiPcmStream = null;
		field2774 = new LinkedList();
		musicSongs = new ArrayList(3);
		field2773 = new ArrayList(3);
		field2771 = new ArrayList();
		field2778 = new ArrayList();
		musicPlayerStatus = 0;
		field2766 = 0;
		field2769 = 0;
		field2768 = 0;
	}
}