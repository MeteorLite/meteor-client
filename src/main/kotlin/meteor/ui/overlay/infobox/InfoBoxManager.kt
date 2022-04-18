/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package meteor.ui.overlay.infobox

import com.google.common.base.Preconditions
import com.google.common.base.Strings
import com.google.common.collect.ComparisonChain
import eventbus.events.ConfigChanged
import meteor.Configuration
import meteor.Main
import meteor.config.ConfigManager
import meteor.events.InfoBoxMenuClicked
import meteor.plugins.EventSubscriber
import meteor.ui.overlay.ComponentOrientation
import meteor.ui.overlay.OverlayManager
import java.util.concurrent.ConcurrentHashMap
import meteor.ui.overlay.OverlayMenuEntry
import java.awt.image.BufferedImage
import meteor.util.AsyncBufferedImage
import net.runelite.api.MenuAction
import java.awt.Graphics
import java.util.Collections
import java.util.Comparator
import java.util.function.Consumer
import java.util.function.Predicate
import java.util.stream.Collectors

object InfoBoxManager : EventSubscriber() {
    private val layers: MutableMap<String, InfoBoxOverlay> = ConcurrentHashMap()
    private val config = Main.meteorConfig!!

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group == Configuration.MASTER_GROUP && it.key == "infoBoxSize") {
            layers.values.forEach(Consumer { l: InfoBoxOverlay ->
                l.infoBoxes.forEach(
                    Consumer { infoBox: InfoBox -> updateInfoBoxImage(infoBox) })
            })
        }
    }

    override fun onInfoBoxMenuClicked(it: InfoBoxMenuClicked) {
        if (DETACH == it.entry.option) {
            // The layer name doesn't matter as long as it is unique
            splitInfobox(
                it.infoBox.name + "_" + System.currentTimeMillis(),
                it.infoBox
            )
        } else if (FLIP == it.entry.option) {
            val infoBoxOverlay = layers[getLayer(it.infoBox)]
            val newOrientation = infoBoxOverlay!!.flip()
            setOrientation(infoBoxOverlay.name, newOrientation)
        } else if (DELETE == it.entry.option) {
            // This is just a merge into the default layer
            val source = layers[getLayer(it.infoBox)]
            val dest = layers.computeIfAbsent(DEFAULT_LAYER) { name: String -> makeOverlay(name) }
            if (source !== dest) {
                mergeInfoBoxes(source, dest)
            }
        }
    }

    fun addInfoBox(infoBox: InfoBox) {
        Preconditions.checkNotNull(infoBox)
        updateInfoBoxImage(infoBox)
        val layerName = getLayer(infoBox)
        val overlay = layers.computeIfAbsent(layerName) { name: String -> makeOverlay(name) }
        val menuEntries = infoBox.menuEntries
        menuEntries.add(DETACH_ME)
        menuEntries.add(FLIP_ME)
        if (layerName != DEFAULT_LAYER) {
            // Non default-group infoboxes have a delete option to delete the group
            menuEntries.add(DELETE_ME)
        }
        synchronized(this) {
            val idx = findInsertionIndex(overlay.infoBoxes, infoBox) { b1: InfoBox, b2: InfoBox ->
                ComparisonChain
                    .start()
                    .compare(b1.priority, b2.priority)
                    .compare(b1.plugin.getName(), b2.plugin.getName())
                    .result()
            }
            overlay.infoBoxes.add(idx, infoBox)
        }
        val image = infoBox.image
        if (image is AsyncBufferedImage) {
            image.onLoaded { updateInfoBoxImage(infoBox) }
        }
    }

    @Synchronized
    fun removeInfoBox(infoBox: InfoBox?) {
        if (infoBox == null) {
            return
        }
        layers[getLayer(infoBox)]!!.infoBoxes.remove(infoBox)
        infoBox.menuEntries.remove(DETACH_ME)
        infoBox.menuEntries.remove(FLIP_ME)
        infoBox.menuEntries.remove(DELETE_ME)
    }

    @Synchronized
    fun removeIf(filter: Predicate<InfoBox?>?) {
        for (overlay in layers.values) {
            overlay.infoBoxes.removeIf(filter!!)
        }
    }

    val infoBoxes: List<InfoBox>
        get() = layers.values.stream().map { obj: InfoBoxOverlay -> obj.infoBoxes }
            .flatMap { obj: List<InfoBox> -> obj.stream() }
            .collect(Collectors.toList())

    @Synchronized
    fun cull() {
        layers.values.forEach(Consumer { l: InfoBoxOverlay -> l.infoBoxes.removeIf { obj: InfoBox -> obj.cull() } })
    }

    fun updateInfoBoxImage(infoBox: InfoBox) {
        if (infoBox.image == null) {
            return
        }

        // Set scaled InfoBox image
        val image = infoBox.image!!
        var resultImage = image
        val width = image.getWidth(null).toDouble()
        val height = image.getHeight(null).toDouble()
        val size = Math.max(
            2, config
                .infoBoxSize()
        ).toDouble() // Limit size to 2 as that is minimum size not causing breakage
        if (size < width || size < height) {
            val scalex = size / width
            val scaley = size / height
            if (scalex == 1.0 && scaley == 1.0) {
                return
            }
            val scale = Math.min(scalex, scaley)
            val newWidth = (width * scale).toInt()
            val newHeight = (height * scale).toInt()
            val scaledImage = BufferedImage(
                newWidth, newHeight,
                BufferedImage.TYPE_INT_ARGB
            )
            val g: Graphics = scaledImage.createGraphics()
            g.drawImage(image, 0, 0, newWidth, newHeight, null)
            g.dispose()
            resultImage = scaledImage
        }
        infoBox.scaledImage = resultImage
    }

    private fun makeOverlay(name: String): InfoBoxOverlay {
        var orientation = getOrientation(name)
        if (orientation == null) {
            if (name == DEFAULT_LAYER) {
                // Fall back to old orientation config option
                orientation =
                    if (config.infoBoxVertical()) ComponentOrientation.VERTICAL else ComponentOrientation.HORIZONTAL
                setOrientation(name, orientation)
            } else {
                // Default infobox orientation
                orientation = ComponentOrientation.HORIZONTAL
            }
        }
        val infoBoxOverlay = InfoBoxOverlay(
            name,
            orientation
        )
        OverlayManager.add(infoBoxOverlay)
        infoBoxOverlay.subscribe()
        return infoBoxOverlay
    }

    private fun removeOverlay(overlay: InfoBoxOverlay?) {
        unsetOrientation(overlay!!.name)
        overlay.eventListening = false
        OverlayManager.remove(overlay)
        layers.remove(overlay.name)
    }

    @Synchronized
    private fun splitInfobox(newLayer: String, infoBox: InfoBox) {
        val layer = getLayer(infoBox)
        val oldOverlay = layers[layer]
        // Find all infoboxes with the same name, as they are all within the same group and so move at once.
        val filtered: Collection<InfoBox> = oldOverlay!!.infoBoxes.stream()
            .filter { i: InfoBox -> i.name == infoBox.name }.collect(Collectors.toList())
        oldOverlay.infoBoxes.removeAll(filtered)
        if (oldOverlay.infoBoxes.isEmpty()) {
            removeOverlay(oldOverlay)
        }
        val newOverlay = layers.computeIfAbsent(newLayer) { name: String -> makeOverlay(name) }
        newOverlay.infoBoxes.addAll(filtered)

        // Adjust config for new infoboxes
        for (i in filtered) {
            setLayer(i, newLayer)
            if (!i.menuEntries.contains(DELETE_ME)) {
                i.menuEntries.add(DELETE_ME)
            }
        }
    }

    @Synchronized
    fun mergeInfoBoxes(source: InfoBoxOverlay?, dest: InfoBoxOverlay) {
        val infoBoxesToMove: Collection<InfoBox> = source!!.infoBoxes
        val isDefault = dest.name == DEFAULT_LAYER
        for (infoBox in infoBoxesToMove) {
            setLayer(infoBox, dest.name)
            if (isDefault) {
                infoBox.menuEntries.remove(DELETE_ME)
            }
        }
        dest.infoBoxes.addAll(infoBoxesToMove)
        source.infoBoxes.clear()

        // remove source
        removeOverlay(source)
    }

    private fun getLayer(infoBox: InfoBox): String {
        val name = ConfigManager.getConfiguration(INFOBOXLAYER_KEY, infoBox.name)
        return if (Strings.isNullOrEmpty(name)) {
            DEFAULT_LAYER
        } else name!!
    }

    private fun setLayer(infoBox: InfoBox, layer: String) {
        if (layer == DEFAULT_LAYER) {
            ConfigManager.unsetConfiguration(INFOBOXLAYER_KEY, infoBox.name)
        } else {
            ConfigManager.setConfiguration(INFOBOXLAYER_KEY, infoBox.name, layer)
        }
    }

    fun getOrientation(name: String): ComponentOrientation? {
        return ConfigManager
            .getConfiguration(
                INFOBOXOVERLAY_KEY, INFOBOXOVERLAY_ORIENTATION_PREFIX + name,
                ComponentOrientation::class.java
            )
    }

    fun setOrientation(name: String, orientation: ComponentOrientation?) {
        ConfigManager.setConfiguration(
            INFOBOXOVERLAY_KEY, INFOBOXOVERLAY_ORIENTATION_PREFIX + name,
            orientation as Any
        )
    }

    fun unsetOrientation(name: String) {
        ConfigManager.unsetConfiguration(INFOBOXOVERLAY_KEY, INFOBOXOVERLAY_ORIENTATION_PREFIX + name)
    }

    private const val INFOBOXLAYER_KEY = "infoboxlayer"
    private const val INFOBOXOVERLAY_KEY = "infoboxoverlay"
    private const val INFOBOXOVERLAY_ORIENTATION_PREFIX = "orient_"
    private const val DEFAULT_LAYER = "InfoBoxOverlay"
    private const val DETACH = "Detach"
    private const val FLIP = "Flip"
    private const val DELETE = "Delete"
    private val DETACH_ME = OverlayMenuEntry(
        MenuAction.RUNELITE_INFOBOX, DETACH, "InfoBox"
    )
    private val FLIP_ME = OverlayMenuEntry(
        MenuAction.RUNELITE_INFOBOX,
        FLIP, "InfoBox Group"
    )
    private val DELETE_ME = OverlayMenuEntry(
        MenuAction.RUNELITE_INFOBOX, DELETE, "InfoBox Group"
    )

    /**
     * Find insertion point for the given key into the given sorted list. If key already exists in the
     * list, return the index after the last occurrence.
     *
     * @param list
     * @param key
     * @param c
     * @param <T>
     * @return
    </T> */
    private fun <T> findInsertionIndex(
        list: List<T>, key: T,
        c: Comparator<in T>
    ): Int {
        val idx = Collections.binarySearch(list, key, c)
        if (idx < 0) {
            // key isn't found in the list
            return -idx - 1
        }

        // list(idx) is equal to key, so it is not necessary to recheck it
        for (i in idx + 1 until list.size) {
            val cur = list[i]
            val cmp = c.compare(cur, key)
            if (cmp > 0) {
                // this is the first element which is greater
                return i
            }
        }
        return list.size
    }
}