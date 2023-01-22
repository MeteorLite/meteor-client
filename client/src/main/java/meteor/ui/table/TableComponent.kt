/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package meteor.ui.table

import lombok.Getter
import lombok.Setter
import meteor.ui.components.ComponentConstants
import meteor.ui.components.LayoutableRenderableEntity
import net.runelite.api.util.Text
import java.awt.*
import java.util.*
import javax.annotation.Nonnull

class TableComponent : LayoutableRenderableEntity {
    val columns: MutableList<TableElement> = ArrayList()
    val rows: MutableList<TableRow> = ArrayList()
    
    private var bounds = Rectangle()
    private val defaultAlignment = TableAlignment.LEFT
    private val defaultColor = Color.WHITE
    private val gutter = Dimension(3, 0)
    private var preferredLocation = Point()
    private var preferredSize = Dimension(ComponentConstants.STANDARD_WIDTH, 0)
    override fun render(graphics: Graphics2D): Dimension? {
        val metrics = graphics.fontMetrics
        val colRow = TableRow.builder().elements(columns)
        val columnWidths = getColumnWidths(metrics, colRow)
        graphics.translate(preferredLocation.x, preferredLocation.y)

        // Display the columns first
        var height = displayRow(graphics, colRow, 0, columnWidths, metrics)
        for (row in rows) {
            height = displayRow(graphics, row, height, columnWidths, metrics)
        }
        graphics.translate(-preferredLocation.x, -preferredLocation.y)
        val dimension = Dimension(preferredSize.width, height)
        bounds.location = preferredLocation
        bounds.size = dimension
        return dimension
    }

    private fun displayRow(graphics: Graphics2D, row: TableRow, height: Int, columnWidths: IntArray, metrics: FontMetrics): Int {
        var height = height
        var x = 0
        val startingRowHeight = height
        val elements = row.elements
        for (i in elements.indices) {
            var y = startingRowHeight
            val cell = elements[i]
            val content = cell.content ?: continue
            val lines = lineBreakText(content, columnWidths[i], metrics)
            val alignment = getCellAlignment(row, i)
            val color = getCellColor(row, i)
            for (line in lines) {
                val alignmentOffset = getAlignedPosition(line, alignment, columnWidths[i], metrics)
                val leftLineComponent = TextComponent()
                y += metrics.height
                leftLineComponent.position = Point(x + alignmentOffset, y)
                leftLineComponent.text = line
                leftLineComponent.color = color
                leftLineComponent.render(graphics)
            }
            height = Math.max(height, y)
            x += columnWidths[i] + gutter.width
        }
        return height + gutter.height
    }

    /**
     * Returns the width that each column should take up
     * Based on https://stackoverflow.com/questions/22206825/algorithm-for-calculating-variable-column-widths-for-set-table-width
     *
     * @param metrics
     * @return int[] of column width
     */
    private fun getColumnWidths(metrics: FontMetrics, columnRow: TableRow): IntArray {
        var numCols = columns.size
        for (r in rows) {
            numCols = Math.max(r.elements.size, numCols)
        }
        val maxtextw = IntArray(numCols) // max text width over all rows
        val maxwordw = IntArray(numCols) // max width of longest word
        val flex = BooleanArray(numCols) // is column flexible?
        val wrap = BooleanArray(numCols) // can column be wrapped?
        val finalcolw = IntArray(numCols) // final width of columns
        val rows: MutableList<TableRow> = ArrayList(rows)
        rows.add(columnRow)
        for (r in rows) {
            val elements = r.elements
            for (col in elements.indices) {
                val ele = elements[col]
                val cell = ele.content ?: continue
                val cellWidth = getTextWidth(metrics, cell)
                maxtextw[col] = Math.max(maxtextw[col], cellWidth)
                for (word in cell.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                    maxwordw[col] = Math.max(maxwordw[col], getTextWidth(metrics, word))
                }
                if (maxtextw[col] == cellWidth) {
                    wrap[col] = cell.contains(" ")
                }
            }
        }
        var left = preferredSize.width - (numCols - 1) * gutter.width
        val avg = (left / numCols).toDouble()
        var nflex = 0

        // Determine whether columns should be flexible and assign width of non-flexible cells
        for (col in 0 until numCols) {
            // This limit can be adjusted as needed
            val maxNonFlexLimit = 1.5 * avg
            flex[col] = maxtextw[col] > maxNonFlexLimit
            if (flex[col]) {
                nflex++
            } else {
                finalcolw[col] = maxtextw[col]
                left -= finalcolw[col]
            }
        }

        // If there is not enough space, make columns that could be word-wrapped flexible too
        if (left < nflex * avg) {
            for (col in 0 until numCols) {
                if (!flex[col] && wrap[col]) {
                    left += finalcolw[col]
                    finalcolw[col] = 0
                    flex[col] = true
                    nflex++
                }
            }
        }

        // Calculate weights for flexible columns. The max width is capped at the table width to
        // treat columns that have to be wrapped more or less equal
        var tot = 0
        for (col in 0 until numCols) {
            if (flex[col]) {
                maxtextw[col] = Math.min(maxtextw[col], preferredSize.width)
                tot += maxtextw[col]
            }
        }

        // Now assign the actual width for flexible columns. Make sure that it is at least as long
        // as the longest word length
        for (col in 0 until numCols) {
            if (flex[col]) {
                finalcolw[col] = left * maxtextw[col] / tot
                finalcolw[col] = Math.max(finalcolw[col], maxwordw[col])
                left -= finalcolw[col]
            }
        }

        // When the sum of column widths is less than the total space available, distribute the
        // extra space equally across all columns
        val extraPerCol = left / numCols
        for (col in 0 until numCols) {
            finalcolw[col] += extraPerCol
            left -= extraPerCol
        }
        // Add any remainder to the right-most column
        finalcolw[finalcolw.size - 1] += left
        return finalcolw
    }

    val isEmpty: Boolean
        get() = columns.size == 0 || rows.size == 0

    private fun ensureColumnSize(size: Int) {
        while (size > columns.size) {
            columns.add(TableElement())
        }
    }

    /**
     * Returns the color for the specified table element.
     * Priority order: cell->row->column->default
     *
     * @param row      TableRow element
     * @param colIndex column index
     */
    private fun getCellColor(row: TableRow, colIndex: Int): Color {
        val rowElements = row.elements
        val cell = if (colIndex < rowElements.size) rowElements[colIndex] else EMPTY_ELEMENT
        val column = if (colIndex < columns.size) columns[colIndex] else EMPTY_ELEMENT
        return firstNonNull(
                cell.color,
                row.rowColor,
                column.color,
                defaultColor)!!
    }

    private fun setColumnAlignment(col: Int, alignment: TableAlignment?) {
        assert(columns.size > col)
        columns[col].alignment = alignment
    }

    fun setColumnAlignments(@Nonnull vararg alignments: TableAlignment?) {
        ensureColumnSize(alignments.size)
        for (i in alignments.indices) {
            setColumnAlignment(i, alignments[i])
        }
    }

    /**
     * Returns the alignment for the specified table element.
     * Priority order: cell->row->column->default
     *
     * @param row      TableRow element
     * @param colIndex column index
     */
    private fun getCellAlignment(row: TableRow, colIndex: Int): TableAlignment {
        val rowElements = row.elements
        val cell = if (colIndex < rowElements.size) rowElements[colIndex] else EMPTY_ELEMENT
        val column = if (colIndex < columns.size) columns[colIndex] else EMPTY_ELEMENT
        return firstNonNull(
                cell.alignment,
                row.rowAlignment,
                column.alignment,
                defaultAlignment)!!
    }

    // Helper functions for cleaner overlay code
    fun addRow(@Nonnull vararg cells: String?) {
        val elements: MutableList<TableElement> = ArrayList()
        for (cell in cells) {
            elements.add(TableElement.builder().content(cell!!))
        }
        val row = TableRow()
        row.elements = elements
        rows.add(row)
    }

    private fun addRows(@Nonnull vararg rows: Array<String>) {
        for (row in rows) {
            addRow(*row)
        }
    }

    fun addRows(vararg rows: TableRow) {
        this.rows.addAll(listOf(*rows))
    }

    fun setRows(@Nonnull vararg elements: Array<String>) {
        rows.clear()
        addRows(*elements)
    }

    fun setRows(@Nonnull vararg elements: TableRow) {
        rows.clear()
        rows.addAll(listOf(*elements))
    }

    private fun addColumn(@Nonnull col: String) {
        columns.add(TableElement.builder().content(col))
    }

    fun addColumns(vararg columns: TableElement) {
        this.columns.addAll(listOf(*columns))
    }

    fun setColumns(@Nonnull vararg elements: TableElement) {
        columns.clear()
        columns.addAll(listOf(*elements))
    }

    fun setColumns(@Nonnull vararg columns: String) {
        this.columns.clear()
        for (col in columns) {
            addColumn(col)
        }
    }

    fun setBounds(rectangle: Rectangle) {
        bounds = rectangle
    }

    override fun setPreferredLocation(position: Point?) {
        preferredLocation = position!!
    }

    override fun getPreferredLocation(): Point? {
        return preferredLocation
    }

    override fun setPreferredSize(position: Dimension?) {
        preferredSize = position!!
    }

    override fun getPreferredSize(): Dimension? {
        return preferredSize
    }

    companion object {
        private val EMPTY_ELEMENT = TableElement()
        private fun getTextWidth(metrics: FontMetrics, cell: String?): Int {
            return metrics.stringWidth(Text.removeTags(cell))
        }

        private fun lineBreakText(text: String, maxWidth: Int, metrics: FontMetrics): Array<String?> {
            val words = text.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            if (words.size == 0) {
                return arrayOfNulls(0)
            }
            val wrapped = StringBuilder(words[0])
            var spaceLeft = maxWidth - getTextWidth(metrics, wrapped.toString())
            for (i in 1 until words.size) {
                val word = words[i]
                val wordLen = getTextWidth(metrics, word)
                val spaceWidth = metrics.stringWidth(" ")
                if (wordLen + spaceWidth > spaceLeft) {
                    wrapped.append("\n").append(word)
                    spaceLeft = maxWidth - wordLen
                } else {
                    wrapped.append(" ").append(word)
                    spaceLeft -= spaceWidth + wordLen
                }
            }
            return wrapped.toString().split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }

        private fun getAlignedPosition(str: String?, alignment: TableAlignment, columnWidth: Int, metrics: FontMetrics): Int {
            val stringWidth = getTextWidth(metrics, str)
            var offset = 0
            when (alignment) {
                TableAlignment.LEFT -> {}
                TableAlignment.CENTER -> offset = columnWidth / 2 - stringWidth / 2
                TableAlignment.RIGHT -> offset = columnWidth - stringWidth
            }
            return offset
        }

        @SafeVarargs
        private fun <T> firstNonNull(vararg elements: T?): T? {
            if (elements == null || elements.size == 0) {
                return null
            }
            var i = 0
            var cur = elements[0]
            while (cur == null && i < elements.size) {
                cur = elements[i]
                i++
            }
            return cur
        }
    }
}