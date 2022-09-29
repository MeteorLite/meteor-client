/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Modified by farhan1666
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
package net.runelite.client.plugins.aoewarnings;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import meteor.config.legacy.Config;
import meteor.config.legacy.ConfigGroup;
import meteor.config.legacy.ConfigItem;
import meteor.config.legacy.ConfigSection;
import meteor.config.legacy.Range;

import java.awt.*;
import java.util.EnumSet;

import static net.runelite.client.plugins.aoewarnings.AoeProjectileInfo.*;


@ConfigGroup("aoe")
public interface AoeWarningConfig extends Config
{
  @Getter(AccessLevel.PACKAGE)
  @AllArgsConstructor
  enum FontStyle
  {
    BOLD("Bold", Font.BOLD),
    ITALIC("Italic", Font.ITALIC),
    PLAIN("Plain", Font.PLAIN);

    private String name;
    private int font;

    @Override
    public String toString()
    {
      return getName();
    }
  }

  @AllArgsConstructor
  enum VorkathMode
  {
    BOMBS(VORKATH_BOMB),
    POOLS(VORKATH_POISON_POOL),
    SPAWN(VORKATH_SPAWN),
    FIRES(VORKATH_TICK_FIRE); // full auto ratatat

    private final AoeProjectileInfo info;
    static VorkathMode of(AoeProjectileInfo info)
    {
      for (VorkathMode m : values())
      {
        if (m.info == info)
        {
          return m;
        }
      }
      throw new EnumConstantNotPresentException(AoeProjectileInfo.class, info.toString());
    }
  }

  @ConfigSection(
      keyName = "overlayTitle",
      name = "Overlay",
      description = "",
      position = 1,
      closedByDefault = true
  )
  String overlayTitle = "Overlay";

  @ConfigItem(
      position = 2,
      keyName = "overlayColor",
      name = "Overlay Color",
      description = "Configures the color of the AoE Projectile Warnings overlay",
      section = overlayTitle
  )
  default Color overlayColor()
  {
    return Color.CYAN;
  }

  @ConfigItem(
      keyName = "outline",
      name = "Display Outline",
      description = "Configures whether or not AoE Projectile Warnings have an outline",
      section = overlayTitle,
      position = 3
  )
  default boolean isOutlineEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "delay",
      name = "Fade Delay",
      description = "Configures the amount of time in milliseconds that the warning lingers for after the projectile has touched the ground",
      section = overlayTitle,
      position = 4
  )
  @Range(
      min = 1,
      max = 900
  )
  default int delay()
  {
    return 300;
  }

  @ConfigItem(
      keyName = "fade",
      name = "Fade Warnings",
      description = "Configures whether or not AoE Projectile Warnings fade over time",
      section = overlayTitle,
      position = 5
  )
  default boolean isFadeEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "tickTimers",
      name = "Tick Timers",
      description = "Configures whether or not AoE Projectile Warnings has tick timers overlaid as well.",
      section = textTitle,
      position = 6
  )
  default boolean tickTimers()
  {
    return true;
  }

  @ConfigSection(
      keyName = "textTitle",
      position = 7,
      name = "Text",
      description = "",
      closedByDefault = true
  )
  String textTitle = "Text";

  @ConfigItem(
      position = 8,
      keyName = "fontStyle",
      name = "Font Style",
      description = "Bold/Italics/Plain",
      section = textTitle,
      hidden = true,
      unhide = "tickTimers"
  )
  default FontStyle fontStyle()
  {
    return FontStyle.BOLD;
  }

  @Range(
      min = 10,
      max = 40
  )
  @ConfigItem(
      position = 9,
      keyName = "textSize",
      name = "Text Size",
      description = "Text Size for Timers.",
      section = textTitle,
      hidden = true,
      unhide = "tickTimers"
  )
  default int textSize()
  {
    return 32;
  }

  @ConfigItem(
      position = 10,
      keyName = "shadows",
      name = "Shadows",
      description = "Adds Shadows to text.",
      section = textTitle,
      hidden = true,
      unhide = "tickTimers"
  )
  default boolean shadows()
  {
    return true;
  }

  @ConfigSection(
      keyName = "bosses",
      position = 11,
      name = "Bosses",
      description = "",
      closedByDefault = true
  )
  String bosses = "Bosses";

  @ConfigItem(
      keyName = "lizardmanaoe",
      name = "Lizardman Shamans",
      description = "Configures whether or not AoE Projectile Warnings for Lizardman Shamans is displayed",
      section = bosses,
      position = 13
  )
  default boolean isShamansEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "archaeologistaoe",
      name = "Crazy Archaeologist",
      description = "Configures whether or not AoE Projectile Warnings for Archaeologist is displayed",
      section = bosses,
      position = 16
  )
  default boolean isArchaeologistEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "icedemon",
      name = "Ice Demon",
      description = "Configures whether or not AoE Projectile Warnings for Ice Demon is displayed",
      section = bosses,
      position = 19
  )
  default boolean isIceDemonEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "vasa",
      name = "Vasa",
      description = "Configures whether or not AoE Projectile Warnings for Vasa is displayed",
      section = bosses,
      position = 22
  )
  default boolean isVasaEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "tekton",
      name = "Tekton",
      description = "Configures whether or not AoE Projectile Warnings for Tekton is displayed",
      section = bosses,
      position = 25
  )
  default boolean isTektonEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "vorkath",
      name = "Vorkath",
      description = "Configure what AoE projectiles you should be warned for at Vorkath",
      section = bosses,
      position = 28
  )
  default EnumSet<VorkathMode> vorkathModes()
  {
    return EnumSet.allOf(VorkathMode.class);
  }

  @ConfigItem(
      keyName = "galvek",
      name = "Galvek",
      description = "Configures whether or not AoE Projectile Warnings for Galvek are displayed",
      section = bosses,
      position = 31
  )
  default boolean isGalvekEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "gargboss",
      name = "Gargoyle Boss",
      description = "Configs whether or not AoE Projectile Warnings for Dawn/Dusk are displayed",
      section = bosses,
      position = 34
  )
  default boolean isGargBossEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "vetion",
      name = "Vet'ion",
      description = "Configures whether or not AoE Projectile Warnings for Vet'ion are displayed",
      section = bosses,
      position = 37
  )
  default boolean isVetionEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "chaosfanatic",
      name = "Chaos Fanatic",
      description = "Configures whether or not AoE Projectile Warnings for Chaos Fanatic are displayed",
      section = bosses,
      position = 40
  )
  default boolean isChaosFanaticEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "olm",
      name = "Olm",
      description = "Configures whether or not AoE Projectile Warnings for The Great Olm are displayed",
      section = bosses,
      position = 43
  )
  default boolean isOlmEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "bombDisplay",
      name = "Olm Bombs",
      description = "Display a timer and colour-coded AoE for Olm's crystal-phase bombs.",
      section = bosses,
      position = 46
  )
  default boolean bombDisplay()
  {
    return true;
  }

  @ConfigItem(
      keyName = "lightning",
      name = "Olm Lightning Trails",
      description = "Show Lightning Trails",
      section = bosses,
      position = 49
  )
  default boolean LightningTrail()
  {
    return true;
  }

  @ConfigItem(
      keyName = "corp",
      name = "Corporeal Beast",
      description = "Configures whether or not AoE Projectile Warnings for the Corporeal Beast are displayed",
      section = bosses,
      position = 52
  )
  default boolean isCorpEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "wintertodt",
      name = "Wintertodt Snow Fall",
      description = "Configures whether or not AOE Projectile Warnings for the Wintertodt snow fall are displayed",
      section = bosses,
      position = 55
  )
  default boolean isWintertodtEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "isXarpusEnabled",
      name = "Xarpus",
      description = "Configures whether or not AOE Projectile Warnings for Xarpus are displayed",
      section = bosses,
      position = 58
  )
  default boolean isXarpusEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "addyDrags",
      name = "Addy Drags",
      description = "Show Bad Areas",
      section = bosses,
      position = 61
  )
  default boolean addyDrags()
  {
    return true;
  }

  @ConfigItem(
      keyName = "drake",
      name = "Drakes Breath",
      description = "Configures if Drakes Breath tile markers are displayed",
      section = bosses,
      position = 64
  )
  default boolean isDrakeEnabled()
  {
    return true;
  }
  @ConfigItem(
      keyName = "cerbFire",
      name = "Cerberus Fire",
      description = "Configures if Cerberus fire tile markers are displayed",
      section = bosses,
      position = 67
  )
  default boolean isCerbFireEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "demonicGorilla",
      name = "Demonic Gorilla",
      description = "Configures if Demonic Gorilla boulder tile markers are displayed",
      section = bosses,
      position = 70
  )
  default boolean isDemonicGorillaEnabled()
  {
    return true;
  }

  @ConfigItem(
      keyName = "verzik",
      name = "Verzik",
      description = "Configures if Verzik purple Nylo/falling rock AOE is shown",
      section = bosses,
      position = 73
  )
  default boolean isVerzikEnabled()
  {
    return true;
  }
}