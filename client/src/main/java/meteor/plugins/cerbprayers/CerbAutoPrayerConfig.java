package meteor.plugins.cerbprayers;

import meteor.config.legacy.Config;
import meteor.config.legacy.ConfigGroup;
import meteor.config.legacy.ConfigItem;
import net.runelite.api.Prayer;

@ConfigGroup("CerbHelperConfig")
public interface CerbAutoPrayerConfig extends Config {

	@ConfigItem(
			keyName = "offensivePrayerToggle",
			name = "Offensive Prayer Toggle",
			description = "Toggles the option to use offensive prayers",
			position = 0
	)
	default boolean offensivePrayerToggle()
	{
		return false;
	}
	@ConfigItem(
			keyName = "offensivePrayer",
			name = "Offensive Prayer",
			description = "Choose which offensive prayer to use",
			position = 1
	)
	default OffensivePrayers offensivePrayer() {
		return OffensivePrayers.RIGOUR;
	}

	public enum OffensivePrayers{
		EAGLE_EYE(Prayer.EAGLE_EYE),
		RIGOUR(Prayer.RIGOUR),
		PIETY(Prayer.PIETY);

		private final Prayer prayer;

		OffensivePrayers (Prayer prayer)
		{
			this.prayer = prayer;
		}

		public Prayer getPrayer()
		{
			return prayer;
		}
	}
}