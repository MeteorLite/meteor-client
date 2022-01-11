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
package meteor.config.legacy

import com.google.common.cache.CacheBuilder
import meteor.config.ConfigManager
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method


internal class ConfigInvocationHandler(private val manager: ConfigManager) : InvocationHandler {
    private val cache = CacheBuilder.newBuilder()
            .maximumSize(256)
            .build<Method, Any>()

    @Throws(Throwable::class)
    override fun invoke(proxy: Any, method: Method, args: Array<Any?>?): Any? {
        // Use cached configuration value if available
        if (args == null) {
            val cachedValue = cache.getIfPresent(method)
            if (cachedValue != null) {
                return if (cachedValue === NULL) null else cachedValue
            }
        }
        val iface: Class<*> = proxy.javaClass.interfaces[0]
        val group = iface.getAnnotation(ConfigGroup::class.java)
        val item = method.getAnnotation(ConfigItem::class.java)
        if (group == null) {
            println("Configuration proxy class {} has no @ConfigGroup! $proxy")
            return null
        }
        if (item == null) {
            println("Configuration method {} has no @ConfigItem! $method")
            return null
        }
        return if (args == null) {
            //log.trace("cache miss (size: {}, group: {}, key: {})", cache.size(), group.value(), item.keyName());

            // Getting configuration item
            val value = ConfigManager.getConfiguration(group.value, item.keyName)
            if (value == null) {
                if (method.isDefault) {
                    val defaultValue = callDefaultMethod(proxy, method, null)
                    cache.put(method, defaultValue)
                    return defaultValue
                }
                cache.put(method, NULL)
                return null
            }

            // Convert value to return type
            val returnType = method.returnType
            try {
                val objectValue = ConfigManager.stringToObject(value, returnType)
                cache.put(method, objectValue ?: NULL)
                objectValue
            } catch (e: Exception) {
                //log.warn("Unable to unmarshal {}.{} ", group.value(), item.keyName(), e);
                if (method.isDefault) {
                    callDefaultMethod(proxy, method, null)
                } else null
            }
        } else {
            // Setting a configuration value
            if (args.size != 1) {
                throw RuntimeException("Invalid number of arguments to configuration method")
            }
            val newValue = args[0]
            val type = method.parameterTypes[0]
            val oldValue = ConfigManager.getConfiguration(group.value, item.keyName, type)
            if (oldValue == newValue) {
                // nothing to do
                return null
            }
            if (method.isDefault) {
                val defaultValue = callDefaultMethod(proxy, method, args)
                if (newValue == defaultValue) {
                    // Just unset if it goes back to the default
                    ConfigManager.unsetConfiguration(group.value, item.keyName)
                    return null
                }
            }
            if (newValue == null) {
                ConfigManager.unsetConfiguration(group.value, item.keyName)
            } else {
                val newValueStr = ConfigManager.objectToString(newValue)
                ConfigManager.setConfiguration(group.value, item.keyName, newValueStr!!)
            }
            null
        }
    }

    fun invalidate() {
        //log.trace("cache invalidate");
        cache.invalidateAll()
    }

    companion object {
        // Special object to represent null values in the cache
        private val NULL = Any()
        fun callDefaultMethod(proxy: Any, method: Method, args: Array<Any?>?): Any {
            val lookup = MethodHandles.lookup()
            val handle: MethodHandle = lookup.unreflectSpecial(method, method.declaringClass)
            return handle
                    .invoke(proxy)
        }
    }
}