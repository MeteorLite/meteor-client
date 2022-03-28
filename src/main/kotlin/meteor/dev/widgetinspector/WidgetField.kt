/*
 * Copyright (c) 2018 Abex
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
package meteor.dev.widgetinspector

import lombok.Getter
import lombok.extern.slf4j.Slf4j
import meteor.Main
import kotlin.jvm.JvmOverloads
import java.util.function.BiConsumer
import meteor.dev.widgetinspector.WidgetInspector
import meteor.dev.widgetinspector.WidgetField
import net.runelite.api.widgets.Widget
import org.slf4j.helpers.MessageFormatter
import java.util.function.Function

@Slf4j
class WidgetField<T> @JvmOverloads internal constructor(
    @field:Getter val name: String,
    private val getter: Function<Widget, T>,
    setter: BiConsumer<Widget, T>? = null,
    type: Class<T>? = null
) {
    private val setter: BiConsumer<Widget, T>?
    private val type: Class<T>?

    init {
        this.setter = setter
        this.type = type
    }

    fun getValue(widget: Widget): Any {
        val value: T = getter.apply(widget)
        // These types are handled by the JTable automatically
        if (value is Boolean || value is Number || value is String) {
            return value
        }
        return if (value is Widget) {
            WidgetInspector.getWidgetIdentifier(value)
        } else MessageFormatter.format("{}", value).message
    }

    fun setValue(widget: Widget, inValue: Any) {
        var value: Any? = null
        if ("null" == inValue) {
            value = null
        }
        if (type!!.isAssignableFrom(inValue.javaClass)) {
            value = inValue
        } else if (type == Boolean::class.java) {
            value = java.lang.Boolean.valueOf(inValue as String)
        } else if (type == Int::class.java) {
            value = Integer.valueOf(inValue as String)
        } else {
            Main.logger.warn("Type {} is not supported for editing", type)
        }
        setter!!.accept(widget, value as T)
    }

    val isSettable: Boolean
        get() = setter != null
}