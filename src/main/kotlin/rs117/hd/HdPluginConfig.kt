/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2021, 117 <https://twitter.com/117scape>
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
package rs117.hd

import meteor.config.legacy.*
import rs117.hd.config.*

@ConfigGroup("hd")
interface HdPluginConfig : Config {
    @Range(max = GpuHDPlugin.MAX_DISTANCE)
    @ConfigItem(
        keyName = "drawDistance",
        name = "Draw Distance",
        description = "Draw distance",
        position = 1,
        section = generalSettings
    )
    fun drawDistance(): Int {
        return 40
    }

    @ConfigItem(
        keyName = "antiAliasingMode",
        name = "Anti Aliasing",
        description = "Configures the anti-aliasing mode",
        position = 2,
        section = generalSettings
    )
    fun antiAliasingMode(): AntiAliasingMode? {
        return AntiAliasingMode.MSAA_8
    }

    @ConfigItem(
        keyName = "uiScalingMode",
        name = "UI scaling mode",
        description = "Sampling function to use for the UI in stretched mode",
        position = 3,
        section = generalSettings
    )
    fun uiScalingMode(): UIScalingMode? {
        return UIScalingMode.CATMULL_ROM
    }

    @Range(min = 0, max = 16)
    @ConfigItem(
        keyName = "anisotropicFilteringLevel",
        name = "Anisotropic Filtering",
        description = "Configures the anisotropic filtering level.",
        position = 4,
        section = generalSettings
    )
    fun anisotropicFilteringLevel(): Int {
        return 16
    }

    @ConfigItem(
        keyName = "colorBlindMode",
        name = "Colorblindness Correction",
        description = "Adjusts colors to account for colorblindness",
        position = 5,
        section = generalSettings
    )
    fun colorBlindMode(): ColorBlindMode? {
        return ColorBlindMode.NONE
    }

    @ConfigItem(
        keyName = "flashingEffects",
        name = "Flashing Effects",
        description = "Displays fast flashing effects, such as lightning, in certain areas.",
        position = 6,
        section = generalSettings
    )
    fun flashingEffects(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "saturation",
        name = "Saturation",
        description = "Controls the saturation of the final rendered image.",
        position = 7,
        section = generalSettings
    )
    fun saturation(): Saturation? {
        return Saturation.DEFAULT
    }

    @ConfigItem(
        keyName = "contrast",
        name = "Contrast",
        description = "Controls the contrast of the final rendered image.",
        position = 8,
        section = generalSettings
    )
    fun contrast(): Contrast? {
        return Contrast.DEFAULT
    }

    @Range(min = 1, max = 50)
    @ConfigItem(
        keyName = "brightness2",
        name = "Brightness",
        description = "Controls the brightness of scene lighting.",
        position = 9,
        section = generalSettings
    )
    fun brightness(): Int {
        return 20
    }

    @ConfigItem(
        keyName = "levelOfDetail",
        name = "Level of Detail",
        description = "Improves performance by preventing certain distant objects from being drawn.",
        position = 10,
        section = generalSettings
    )
    fun levelOfDetail(): LevelOfDetail? {
        return LevelOfDetail.FULL
    }

    @ConfigItem(
        keyName = "maxDynamicLights",
        name = "Dynamic Lights",
        description = "The maximum number of dynamic lights visible at one time. Reducing this will improve performance.",
        position = 101,
        section = lightingSettings
    )
    fun maxDynamicLights(): MaxDynamicLights? {
        return MaxDynamicLights.MANY
    }

    @ConfigItem(
        keyName = "projectileLights",
        name = "Projectile Lights",
        description = "Adds dynamic lights to some projectiles.",
        position = 102,
        section = lightingSettings
    )
    fun projectileLights(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "npcLights",
        name = "NPC Lights",
        description = "Adds dynamic lights to some NPCs.",
        position = 103,
        section = lightingSettings
    )
    fun npcLights(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "atmosphericLighting",
        name = "Atmospheric Lighting",
        description = "Changes the color and brightness of full-scene lighting in certain areas.",
        position = 104,
        section = lightingSettings
    )
    fun atmosphericLighting(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "shadowsEnabled",
        name = "Shadows",
        description = "Enables fully-dynamic shadows.",
        position = 105,
        section = lightingSettings
    )
    fun shadowsEnabled(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "shadowResolution",
        name = "Shadow Quality",
        description = "The resolution of the shadow maps. Higher resolutions result in sharper, higher quality shadows at the cost of performance.",
        position = 106,
        section = lightingSettings
    )
    fun shadowResolution(): ShadowResolution? {
        return ShadowResolution.RES_4096
    }

    @ConfigItem(
        keyName = "shadowDistance",
        name = "Shadow Distance",
        description = "The maximum draw distance of shadow maps. Shorter distances result in sharper, higher quality shadows.",
        position = 107,
        section = lightingSettings
    )
    fun shadowDistance(): ShadowDistance? {
        return ShadowDistance.DISTANCE_40
    }

    @ConfigItem(
        keyName = "expandShadowDraw",
        name = "Expand Shadow Draw",
        description = "Reduces 'flickering' of shadows disappearing at screen edge by increasing geometry drawn at a cost of performance.",
        position = 108,
        section = lightingSettings
    )
    fun expandShadowDraw(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "fogDepthMode",
        name = "Fog Depth Mode",
        description = "Determines the method of controlling the depth of the fog. 'Dynamic' changes fog depth based on the area.",
        position = 201,
        section = environmentSettings
    )
    fun fogDepthMode(): FogDepthMode? {
        return FogDepthMode.DYNAMIC
    }

    @Range(max = GpuHDPlugin.MAX_FOG_DEPTH)
    @ConfigItem(
        keyName = "fogDepth",
        name = "Static Fog Depth",
        description = "Distance from the scene edge the fog starts. Applies when 'Fog Depth Mode' is set to 'static'.",
        position = 202,
        section = environmentSettings
    )
    fun fogDepth(): Int {
        return 5
    }

    @ConfigItem(
        keyName = "groundFog",
        name = "Ground Fog",
        description = "Enables a height-based fog effect that covers the ground in certain areas.",
        position = 203,
        section = environmentSettings
    )
    fun groundFog(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "defaultSkyColor",
        name = "Default Sky Color",
        description = "Determines the color of the sky when in a location without a custom sky color assigned.",
        position = 204,
        section = environmentSettings
    )
    fun defaultSkyColor(): DefaultSkyColor? {
        return DefaultSkyColor.DEFAULT
    }

    @ConfigItem(
        keyName = "objectTextures",
        name = "Object Textures",
        description = "Adds detail textures to certain world objects.",
        position = 205,
        section = environmentSettings
    )
    fun objectTextures(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "groundTextures",
        name = "Ground Textures",
        description = "Adds detail textures to the ground.",
        position = 206,
        section = environmentSettings
    )
    fun groundTextures(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "groundBlending",
        name = "Ground Blending",
        description = "Affects the quality of blending between different ground/terrain textures.",
        position = 207,
        section = environmentSettings
    )
    fun groundBlending(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "waterEffects",
        name = "Water Effects",
        description = "Changes the appearance of the water.",
        position = 208,
        section = environmentSettings
    )
    fun waterEffects(): WaterEffects? {
        return WaterEffects.ALL
    }

    @ConfigItem(
        keyName = "tzhaarHD",
        name = "HD TzHaar Reskin",
        description = "Recolors the TzHaar city of Mor Ul Rek to give it an appearance similar to that of its 2008 HD variant.",
        position = 209,
        section = environmentSettings
    )
    fun tzhaarHD(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "macosIntelWorkaround",
        name = "Fix shading on MacOS with Intel",
        description = "Workaround for visual artifacts on some Intel GPU drivers on MacOS.",
        position = 301,
        section = workaroundSettings
    )
    fun macosIntelWorkaround(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "unlockFps",
        name = "Unlock FPS",
        description = "Removes the 50 FPS cap for camera movement",
        position = 5,
        section = generalSettings
    )
    fun unlockFps(): Boolean {
        return false
    }

    companion object {
        /*====== General settings ======*/
        @ConfigSection(name = "General", description = "General settings", position = 0, closedByDefault = false)
        const val generalSettings = "General"

        /*====== Lighting settings ======*/
        @ConfigSection(name = "Lighting", description = "Lighting settings", position = 100, closedByDefault = false)
        const val lightingSettings = "Lighting"

        /*====== Environment settings ======*/
        @ConfigSection(
            name = "Environment",
            description = "Environment settings",
            position = 200,
            closedByDefault = false
        )
        const val environmentSettings = "Environment"

        /*====== Workaround settings ======*/
        @ConfigSection(
            name = "Workarounds",
            description = "Workaround settings",
            position = 300,
            closedByDefault = true
        )
        const val workaroundSettings = "workaroundSettings"
    }
}