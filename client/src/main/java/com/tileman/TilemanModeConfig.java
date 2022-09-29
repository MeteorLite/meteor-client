/*
 * Copyright (c) 2018, TheLonelyDev <https://github.com/TheLonelyDev>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2020, ConorLeckey <https://github.com/ConorLeckey>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.tileman;

import meteor.config.legacy.Alpha;
import meteor.config.legacy.Config;
import meteor.config.legacy.ConfigGroup;
import meteor.config.legacy.ConfigItem;
import meteor.config.legacy.ConfigSection;
import meteor.config.legacy.Range;
import java.awt.*;

@ConfigGroup("tilemanMode")
public interface TilemanModeConfig extends Config {
    @ConfigSection(
            name = "Game Mode",
            description = "Select your Tileman game mode'",
            position = 1
    )
    String gameModeSection = "gameMode";

    @ConfigSection(
            name = "Settings",
            description = "Settings'",
            position = 2
    )
    String settingsSection = "settings";

    @ConfigSection(
            name = "Custom Game Mode",
            description = "Create a custom Tileman game mode. Be sure to 'Enable Custom Game Mode'",
            position = 99,
            closedByDefault = true
    )
    String customGameModeSection = "customGameMode";

    enum TilemanGameMode {
        COMMUNITY,
        STRICT,
        ACCELERATED
    }

    @Alpha
    @ConfigItem(
            keyName = "gameMode",
            name = "Game Mode",
            section = gameModeSection,
            description = "Select your Tileman game mode",
            position = 1
    )
    default TilemanGameMode gameMode() {
        return TilemanGameMode.COMMUNITY;
    }

    @ConfigItem(
            keyName = "automarkTiles",
            name = "Auto-mark tiles",
            section = settingsSection,
            description = "Automatically mark tiles as you walk.",
            position = 2
    )
    default boolean automarkTiles() {
        return false;
    }

    @Range(
            min = Integer.MIN_VALUE
    )
    @ConfigItem(
            keyName = "warningLimit",
            name = "Unspent tiles warning",
            section = settingsSection,
            description = "Highlights overlay when limit reached",
            position = 3
    )
    default int warningLimit() {
        return 20;
    }

    @ConfigItem(
            keyName = "enableTilesWarning",
            name = "Enable Tiles Warning",
            section = settingsSection,
            description = "Turns on tile warnings when you reach your set limit or 0.",
            position = 4
    )
    default boolean enableTileWarnings() {
        return false;
    }

    @ConfigItem(
            keyName = "allowTileDeficit",
            name = "Allow Tile Deficit",
            section = settingsSection,
            description = "Allows you to place tiles after you have none left.",
            position = 5
    )
    default boolean allowTileDeficit() {
        return false;
    }

    @ConfigItem(
            keyName = "drawOnMinimap",
            name = "Draw tiles on minimap",
            section = settingsSection,
            description = "Configures whether marked tiles should be drawn on minimap",
            position = 6
    )
    default boolean drawTilesOnMinimap() {
        return true;
    }

    @ConfigItem(
            keyName = "drawTilesOnWorldMap",
            name = "Draw tiles on world map",
            section = settingsSection,
            description = "Configures whether marked tiles should be drawn on world map",
            position = 5
    )
    default boolean drawTilesOnWorldMap() {
        return true;
    }

    @Alpha
    @ConfigItem(
            keyName = "markerColor",
            name = "Tile Color",
            section = settingsSection,
            description = "Configures the color of the tiles",
            position = 6
    )
    default Color markerColor() {
        return Color.CYAN;
    }

    /***   Custom Game Mode section   ***/
    @ConfigItem(
            keyName = "enableCustomGameMode",
            name = "Enable Custom Game Mode",
            description = "Settings below will override Game Mode defaults",
            section = customGameModeSection,
            position = 1
    )
    default boolean enableCustomGameMode() {
        return false;
    }

    @Range(
            min = Integer.MIN_VALUE
    )
    @ConfigItem(
            keyName = "tilesOffset",
            name = "Bonus tiles",
            description = "Add more tiles to your limit, set to 0 for off",
            section = customGameModeSection,
            position = 2
    )
    default int tilesOffset() {
        return 9;
    }

    @ConfigItem(
            keyName = "includeTotalLevels",
            name = "Include total level",
            description = "Includes total level in usable tiles",
            section = customGameModeSection,
            position = 3
    )
    default boolean includeTotalLevel() {
        return false;
    }

    @ConfigItem(
            keyName = "excludeExp",
            name = "Exclude Experience",
            description = "Includes experience / 1000 in usable tiles",
            section = customGameModeSection,
            position = 4
    )
    default boolean excludeExp() {
        return false;
    }

    @Range(
            min = 500
    )
    @ConfigItem(
            keyName = "expPerTile",
            name = "Exp per Tile",
            description = "Determines how much exp you require per tile",
            section = customGameModeSection,
            position = 5
    )
    default int expPerTile() {
        return 1000;
    }
}
