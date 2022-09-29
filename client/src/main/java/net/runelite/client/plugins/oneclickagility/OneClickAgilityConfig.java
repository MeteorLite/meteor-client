package net.runelite.client.plugins.oneclickagility;

import meteor.config.legacy.Config;
import meteor.config.legacy.ConfigGroup;
import meteor.config.legacy.ConfigItem;
import meteor.config.legacy.Range;

@ConfigGroup("oneclickagility")
public interface OneClickAgilityConfig extends Config
{
    @ConfigItem(
		    position = 0,
		    keyName = "courseSelection",
		    name = "Select course",
		    description = ""
    )
    default AgilityCourse courseSelection()
    {
        return AgilityCourse.SEERS_VILLAGE;
    }

    @ConfigItem(
            position = 1,
            keyName = "seersTele",
            name = "Seers Teleport",
            description = "Uses the Seer's village teleport at the end of the Seer's course",
            hidden = true,
            unhide = "courseSelection",
            unhideValue = "SEERS_VILLAGE"
    )
    default boolean seersTele()
    {
        return false;
    }

    @ConfigItem(
            position = 2,
            keyName = "skillBoost",
            name = "Boost Agility",
            description = "Eat summer pies to boost your agility level"
    )
    default boolean skillBoost()
    {
        return false;
    }

    @Range(
            min = 1,
            max = 5
    )
    @ConfigItem(
            position = 3,
            keyName = "boostAmount",
            name = "Minimum boost",
            description = "",
            hidden = true,
            unhide = "skillBoost"
    )
    default int boostAmount()
    {
        return 3;
    }

    @ConfigItem(
            position = 4,
            keyName = "consumeMisclicks",
            name = "Stop Misclicks",
            description = "Allows you to spam left click"
    )
    default boolean consumeMisclicks()
    {
        return true;
    }

    @ConfigItem(
            position = 5,
            keyName = "pickUpMarks",
            name = "Pick up Marks of Grace",
            description = "Pick up Marks of Grace"
    )
    default boolean pickUpMarks()
    {
        return true;
    }

    @ConfigItem(
            position = 5,
            keyName = "pickUpCoins",
            name = "Pick up coins",
            description = "Pick up coins if you have the fragment enabled"
    )
    default boolean pickUpCoins()
    {
        return false;
    }
}
