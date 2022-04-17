/*
 * Copyright (c) 2020, Zoinkwiz
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
package com.questhelper;

import com.questhelper.panel.questorders.QuestOrders;
import com.questhelper.questhelpers.Quest;
import com.questhelper.questhelpers.QuestHelper;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Getter;
import meteor.config.Config;
import meteor.config.ConfigAnnotations.*;
import net.runelite.api.util.Text;

@ConfigGroup("questhelper")
public interface QuestHelperConfig extends Config
{
	@ConfigItem(
		keyName = "autostartQuests",
		name = "Auto start helper",
		description = "Automatically start the quest helper when you start a quest"
	)
	default boolean autoStartQuests()
	{
		return true;
	}

	@ConfigItem(
		keyName = "autoOpenSidebar",
		name = "Auto open sidebar",
		description = "Automatically opens the quest helper sidebar when you start a quest"
	)
	default boolean autoOpenSidebar()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showOverlayPanel",
		name = "Display overlay on screen",
		description = "Chose whether the overlay should be displayed on screen"
	)
	default boolean showOverlay()
	{
		return true;
	}

	@ConfigSection(
		position = 1,
		name = "Quest Hints",
		description = "Determines what hints should be shown"
	)
	String hintsSection = "hintsSection";

	@ConfigItem(
		keyName = "showTextHighlight",
		name = "Highlight correct dialog",
		description = "Highlight correct dialog choices",
		section = hintsSection
	)
	default boolean showTextHighlight()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showSymbolOverlay",
		name = "Display icons on NPCs and objects",
		description = "Choose whether NPCs should icons marking them as the current target or not",
		section = hintsSection
	)
	default boolean showSymbolOverlay()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showMiniMapArrow",
		name = "Display arrows on the mini-map and overworld",
		description = "Choose whether flashing arrows point to the next objective",
		section = hintsSection
	)
	default boolean showMiniMapArrow()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWorldLines",
		name = "Display navigation paths",
		description = "Choose whether navigation paths are drawn to the next objective",
		section = hintsSection
	)
	default boolean showWorldLines()
	{
		return true;
	}

	@ConfigItem(
		keyName = "showWidgetHints",
		name = "Display widget hints",
		description = "Choose whether important widget actions are highlighted",
		section = hintsSection
	)
	default boolean showWidgetHints()
	{
		return true;
	}
	
	@ConfigSection(
		position = 1,
		name = "Colours",
		description = "What colour each option can be"
	)
	String colorSection = "colorSection";

	@ConfigItem(
		keyName = "textHighlightColor",
		name = "Text highlight colour",
		description = "Change the colour of dialog choices highlighted by the helper",
		section = colorSection
	)
	default Color textHighlightColor()
	{
		return Color.BLUE;
	}

	@ConfigItem(
		keyName = "targetOverlayColor",
		name = "Color of target overlay",
		description = "Change the colour which target NPCs/Objects will be highlighted with",
		section = colorSection
	)
	default Color targetOverlayColor()
	{
		return Color.CYAN;
	}
}
