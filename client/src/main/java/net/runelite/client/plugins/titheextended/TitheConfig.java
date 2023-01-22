package net.runelite.client.plugins.titheextended;

import meteor.config.legacy.*;

import java.awt.Color;

@ConfigGroup(TitheConfig.group)
public interface TitheConfig extends Config {
	String group = "tictac7x-tithe";

	@ConfigSection(
		position = 1,
		name = "Farming patches",
		description = "Highlight farming patches and show progress of plants"
	) String section_patches = "farming_patches";

		@Alpha
		@ConfigItem(
			position = 1,
			keyName = "plants_dry",
			name = "Dry plants",
			description = "Highlight dry plants that need to be watered.",
			section = section_patches
		) default Color getPlantsDryColor() {
			return Overlay.getColor(Overlay.color_red, Overlay.alpha_vibrant);
		}

		@Alpha
		@ConfigItem(
			position = 2,
			keyName = "plants_watered",
			name = "Watered plants",
			description = "Highlight watered plants",
			section = section_patches
		) default Color getPlantsWateredColor() {
			return Overlay.getColor(Overlay.color_green, Overlay.alpha_vibrant);
		}

		@Alpha
		@ConfigItem(
			position = 3,
			keyName = "plants_grown",
			name = "Grown plants",
			description = "Highlight grown plants",
			section = section_patches
		) default Color getPlantsGrownColor() {
			return Overlay.getColor(Overlay.color_yellow, Overlay.alpha_vibrant);
		}

		@Alpha
		@ConfigItem(
			position = 4,
			keyName = "plants_blighted",
			name = "Blighted plants",
			description = "Highlight blighted plants",
			section = section_patches
		) default Color getPlantsBlightedColor() {
			return Overlay.getColor(Overlay.color_gray, Overlay.alpha_vibrant);
		}

		@Alpha
		@ConfigItem(
			position = 5,
			keyName = "farm_patches_hover",
			name = "Farm patches",
			description = "Highlight farm patches on hover",
			section = section_patches
		) default Color getPatchesHighlightOnHoverColor() {
			return Overlay.getColor(Overlay.color_gray, Overlay.alpha_normal);
		}

	@ConfigSection(
		position = 2,
		name = "Inventory",
		description = "Highlight items needed for the tithe farming in the inventory"
	) String section_inventory = "inventory";

		@Alpha
		@ConfigItem(
			position = 1,
			keyName = "seeds",
			name = "Seeds",
			description = "Highlight seeds",
			section = section_inventory
		) default Color getHighlightSeedsColor() {
			return Overlay.getColor(Overlay.color_green, Overlay.alpha_normal);
		}

		@Alpha
		@ConfigItem(
			position = 2,
			keyName = "farmer_outfit",
			name = "Farmer outfit",
			description = "Highlight farmer outfit when you only have fruits in inventory",
			section = section_inventory
		) default Color getHighlightFarmersOutfitColor() {
		return Overlay.getColor(Color.red, Overlay.alpha_normal);
	}

		@ConfigItem(
			position = 3,
			keyName = "watering_cans",
			name = "Highlight watering cans",
			description = "Highlight watering cans based on how much water they contain",
			section = section_inventory
		) default boolean highlightWateringCans() {
			return true;
		}

	@ConfigSection(
		position = 3,
		name = "Water",
		description = "Show amount of available and total waters"
	) String section_water = "water";

		@ConfigItem(
			position = 1,
			keyName = "water",
			name = "Show amount of water",
			description = "Show total and available amount of water in watering cans",
			section = section_water
		) default boolean showWaterAmount() {
			return true;
		}

		String gricollers_can_charges = "gricollers_can_charges";
		@ConfigItem(
			position = 2,
			keyName = gricollers_can_charges,
			name = "Gricoller's can charges",
			description = "Hold amount of charges left in Gricoller's can",
			section = section_water,
			hidden = true
		) default int getGricollersCanCharges() {
			return 0;
		}

		@ConfigItem(
			position = 3,
			keyName = "gricollers_can_charges_high",
			name = "Gricoller's can high charges amount",
			description = "Minimum number of charges to show water as high",
			section = section_water
		) default int getGricollersCanHighChargesAmount() {
		return 75;
	}

	@ConfigSection(
		position = 4,
		name = "Points",
		description = "Show custom information about tithe farm points"
	) String section_points = "points";

		String points = "points";
		@ConfigItem(
			position = 1,
			keyName = points,
			name = "Show custom points widget",
			description = "Show total, earned points and harvested fruits.",
			section = section_points
		) default boolean showCustomPoints() {
		return true;
	}
}
