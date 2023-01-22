/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package meteor.plugins.groundmarkers

import com.google.common.base.Strings
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import lombok.extern.slf4j.Slf4j
import meteor.Logger
import meteor.Main
import meteor.Main.client
import meteor.chat.QueuedMessage.Companion.builder
import meteor.game.chatbox.ChatboxPanelManager
import meteor.menus.MenuManager
import meteor.menus.WidgetMenuOption
import net.runelite.api.ChatMessageType
import net.runelite.api.MenuEntry
import net.runelite.api.widgets.WidgetInfo
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection
import java.awt.datatransfer.UnsupportedFlavorException
import java.io.IOException
import java.util.*
import java.util.function.Function
import java.util.stream.Collectors
import javax.inject.Singleton

@Slf4j
@Singleton
internal class GroundMarkerSharingManager(
    private val plugin: GroundMarkerPlugin,

) {
    private val log = Logger("GM Sharing Manager")

    private val chatMessageManager = Main.chatMessageManager
    private val chatboxPanelManager = ChatboxPanelManager
    private val gson = Gson()
    fun addImportExportMenuOptions() {
        MenuManager.addManagedCustomMenu(EXPORT_MARKERS_OPTION) { menuEntry: MenuEntry -> exportGroundMarkers(menuEntry) }
        MenuManager.addManagedCustomMenu(IMPORT_MARKERS_OPTION) { menuEntry: MenuEntry -> promptForImport(menuEntry) }
    }

    fun addClearMenuOption() {
        MenuManager.addManagedCustomMenu(CLEAR_MARKERS_OPTION) { promptForClear() }
    }

    fun removeMenuOptions() {
        MenuManager.removeManagedCustomMenu(EXPORT_MARKERS_OPTION)
        MenuManager.removeManagedCustomMenu(IMPORT_MARKERS_OPTION)
        MenuManager.removeManagedCustomMenu(CLEAR_MARKERS_OPTION)
    }

    private fun exportGroundMarkers(menuEntry: MenuEntry) {
        val regions = client.mapRegions ?: return
        val activePoints = Arrays.stream(regions)
            .mapToObj { regionId: Int -> plugin.getPoints(regionId).stream() }
            .flatMap(Function.identity())
            .collect(Collectors.toList())
        if (activePoints.isEmpty()) {
            sendChatMessage("You have no ground markers to export.")
            return
        }
        val exportDump = gson.toJson(activePoints)
        log.debug("Exported ground markers: {}", exportDump)
        Toolkit.getDefaultToolkit()
            .systemClipboard
            .setContents(StringSelection(exportDump), null)
        sendChatMessage(activePoints.size.toString() + " ground markers were copied to your clipboard.")
    }

    private fun promptForImport(menuEntry: MenuEntry) {
        val clipboardText: String = try {
            Toolkit.getDefaultToolkit()
                .systemClipboard
                .getData(DataFlavor.stringFlavor)
                .toString()
        } catch (ex: IOException) {
            sendChatMessage("Unable to read system clipboard.")
            log.warn("error reading clipboard", ex)
            return
        } catch (ex: UnsupportedFlavorException) {
            sendChatMessage("Unable to read system clipboard.")
            log.warn("error reading clipboard", ex)
            return
        }
        log.debug("Clipboard contents: {}", clipboardText)
        if (Strings.isNullOrEmpty(clipboardText)) {
            sendChatMessage("You do not have any ground markers copied in your clipboard.")
            return
        }
        val importPoints: List<GroundMarkerPoint> = try {
            // CHECKSTYLE:OFF
            gson.fromJson(clipboardText, object : TypeToken<List<GroundMarkerPoint?>?>() {}.type)
            // CHECKSTYLE:ON
        } catch (e: JsonSyntaxException) {
            log.debug("Malformed JSON for clipboard import", e)
            sendChatMessage("You do not have any ground markers copied in your clipboard.")
            return
        }
        if (importPoints.isEmpty()) {
            sendChatMessage("You do not have any ground markers copied in your clipboard.")
            return
        }
        chatboxPanelManager.openTextMenuInput("Are you sure you want to import " + importPoints.size + " ground markers?")
            .option("Yes") { importGroundMarkers(importPoints) }
            .option("No", null)
            .build()
    }

    private fun importGroundMarkers(importPoints: Collection<GroundMarkerPoint>) {
        // regions being imported may not be loaded on client,
        // so need to import each bunch directly into the config
        // first, collate the list of unique region ids in the import
        val regionGroupedPoints = importPoints.stream()
            .collect(Collectors.groupingBy(GroundMarkerPoint::regionId))

        // now import each region into the config
        regionGroupedPoints.forEach { (regionId: Int?, groupedPoints: List<GroundMarkerPoint>) ->
            // combine imported points with existing region points
            log.debug("Importing {} points to region {}", groupedPoints.size, regionId)
            val regionPoints: Collection<GroundMarkerPoint> = plugin.getPoints(regionId!!)
            val mergedList: MutableCollection<GroundMarkerPoint> = ArrayList(regionPoints.size + groupedPoints.size)
            // add existing points
            mergedList.addAll(regionPoints)

            // add new points
            for (point in groupedPoints) {
                // filter out duplicates
                if (!mergedList.contains(point)) {
                    mergedList.add(point)
                }
            }
            plugin.savePoints(regionId, mergedList)
        }

        // reload points from config
        log.debug("Reloading points after import")
        plugin.loadPoints()
        sendChatMessage(importPoints.size.toString() + " ground markers were imported from the clipboard.")
    }

    private fun promptForClear() {
        val regions = client.mapRegions ?: return
        val numActivePoints = regions.sumOf { regionId: Int -> plugin.getPoints(regionId).size.toLong() }
        if (numActivePoints == 0L) {
            sendChatMessage("You have no ground markers to clear.")
            return
        }
        chatboxPanelManager.openTextMenuInput("Are you sure you want to clear the<br>$numActivePoints currently loaded ground markers?")
            .option("Yes") {
                for (regionId in regions) {
                    plugin.savePoints(regionId, null)
                }
                plugin.loadPoints()
                sendChatMessage(
                    numActivePoints.toString() + " ground marker"
                            + if (numActivePoints == 1L) " was cleared." else "s were cleared."
                )
            }
            .option("No", null)
            .build()
    }

    private fun sendChatMessage(message: String) {
        chatMessageManager.queue(
            builder()
                .type(ChatMessageType.CONSOLE)
                .runeLiteFormattedMessage(message)
        )
    }
        private val EXPORT_MARKERS_OPTION =
            WidgetMenuOption("Export", "Ground Markers", WidgetInfo.MINIMAP_WORLDMAP_OPTIONS)
        private val IMPORT_MARKERS_OPTION =
            WidgetMenuOption("Import", "Ground Markers", WidgetInfo.MINIMAP_WORLDMAP_OPTIONS)
        private val CLEAR_MARKERS_OPTION =
            WidgetMenuOption("Clear", "Ground Markers", WidgetInfo.MINIMAP_WORLDMAP_OPTIONS)

}