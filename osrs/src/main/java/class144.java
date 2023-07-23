import java.util.ArrayList;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class144 extends class143 {
	@ObfuscatedName("aw")
	int field1324;
	@ObfuscatedName("ay")
	boolean field1323;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lfr;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class146 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lfr;)V"
	)
	class144(class146 var1) {
		this.this$0 = var1;
		this.field1324 = -1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "1"
	)
	@Export("vmethod3254")
	void vmethod3254(Buffer var1) {
		this.field1324 = var1.readUnsignedShort();
		this.field1323 = var1.readUnsignedByte() == 1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lfx;B)V",
		garbageValue = "-72"
	)
	@Export("vmethod3248")
	void vmethod3248(ClanSettings var1) {
		var1.method816(this.field1324, this.field1323);
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/ArrayList;ZI)V",
		garbageValue = "1982957469"
	)
	static void method764(ArrayList var0, boolean var1) {
		if (!var1) {
			class306.field2755.clear();
		}

		Iterator var2 = var0.iterator();

		while (var2.hasNext()) {
			MusicSong var3 = (MusicSong)var2.next();
			if (var3.musicTrackGroupId != -1 && var3.musicTrackFileId != -1) {
				if (!var1) {
					class306.field2755.add(var3);
				}

				class306.field2758.add(var3);
			}
		}

	}

	@ObfuscatedName("cs")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)Ljava/lang/Object;",
		garbageValue = "-1359810813"
	)
	static Object method767(class503 var0) {
		switch(var0.field4093) {
		case 0:
			return Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
		case 2:
			return Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
		default:
			throw new IllegalStateException("popValueOfType() failure - unsupported type");
		}
	}

	@ObfuscatedName("mm")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2108978122"
	)
	@Export("getTapToDrop")
	static boolean getTapToDrop() {
		return Client.tapToDrop;
	}
}
