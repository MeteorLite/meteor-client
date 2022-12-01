package dev.hoot.api.magic;

import dev.hoot.api.game.Vars;
import meteor.api.items.Items;
import net.runelite.api.InventoryID;

import java.util.Arrays;

public class RunePouch
{
	private static final int SLOT_1_TYPE_BIT = 29;
	private static final int SLOT_1_QUANTITY_BIT = 1624;
	private static final int SLOT_2_TYPE_BIT = 1622;
	private static final int SLOT_2_QUANTITY_BIT = 1625;
	private static final int SLOT_3_TYPE_BIT = 1623;
	private static final int SLOT_3_QUANTITY_BIT = 1626;

	public enum RuneSlot
	{
		FIRST(SLOT_1_TYPE_BIT, SLOT_1_QUANTITY_BIT),
		SECOND(SLOT_2_TYPE_BIT, SLOT_2_QUANTITY_BIT),
		THIRD(SLOT_3_TYPE_BIT, SLOT_3_QUANTITY_BIT);

		private final int type;
		private final int quantityVarbitIdx;

		RuneSlot(int type, int quantityVarbitIdx)
		{
			this.type = type;
			this.quantityVarbitIdx = quantityVarbitIdx;
		}

		public int getType()
		{
			return type;
		}

		public int getQuantityVarbitIdx()
		{
			return quantityVarbitIdx;
		}

		public String getRuneName()
		{
			switch (Vars.getBit(type))
			{
				case 1:
					return "Air rune";
				case 2:
					return "Water rune";
				case 3:
					return "Earth rune";
				case 4:
					return "Fire rune";
				case 5:
					return "Mind rune";
				case 6:
					return "Chaos rune";
				case 7:
					return "Death rune";
				case 8:
					return "Blood rune";
				case 9:
					return "Cosmic rune";
				case 10:
					return "Nature rune";
				case 11:
					return "Law rune";
				case 12:
					return "Body rune";
				case 13:
					return "Soul rune";
				case 14:
					return "Astral rune";
				case 15:
					return "Mist rune";
				case 16:
					return "Mud rune";
				case 17:
					return "Dust rune";
				case 18:
					return "Lava rune";
				case 19:
					return "Steam rune";
				case 20:
					return "Smoke rune";
				default:
					return null;
			}
		}

		public int getQuantity()
		{
			return Vars.getBit(quantityVarbitIdx);
		}
	}

	public static int getQuantity(Rune rune)
	{
		if (!hasPouch())
		{
			return 0;
		}

		RuneSlot runeSlot =
				Arrays.stream(RuneSlot.values()).filter(x -> Arrays.stream(rune.getRuneNames())
								.anyMatch(name -> x.getRuneName() != null && x.getRuneName().startsWith(name)))
						.findFirst()
						.orElse(null);

		if (runeSlot == null)
		{
			return 0;
		}

		return runeSlot.getQuantity();
	}

	public static boolean hasPouch()
	{
		return Items.INSTANCE.getFirst(new String[] {"Rune pouch"}, InventoryID.INVENTORY) != null;
	}
}
