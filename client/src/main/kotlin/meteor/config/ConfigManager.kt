@file:Suppress("UNCHECKED_CAST")

package meteor.config

import meteor.Main
import com.google.common.base.Strings
import eventbus.Events
import meteor.Configuration.CONFIG_FILE
import meteor.config.legacy.*
import eventbus.events.ConfigChanged
import meteor.Configuration.METEOR_DIR
import meteor.config.descriptor.*
import meteor.plugins.Plugin
import net.runelite.api.coords.WorldPoint
import org.rationalityfrontline.kevent.KEVENT as EventBus
import java.awt.Color
import java.awt.Dimension
import java.awt.Point
import java.awt.Rectangle
import java.io.*
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.lang.reflect.Proxy
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.time.Instant
import java.util.*
import java.util.function.Consumer
import java.util.stream.Collectors

object ConfigManager {
    private val properties = Properties()
    private val handler: ConfigInvocationHandler = ConfigInvocationHandler(this)
    private val consumers: HashMap<String, Consumer<in Plugin?>> = HashMap()
    private const val KEY_SPLITTER_GROUP = 0
    private const val KEY_SPLITTER_KEY = 1
    var loaded = false

    fun setPlayerConfiguration(attribute: String, value: Any) {
        Main.client.localPlayer?.name?.takeIf { it.isNotEmpty() }?.let {
            setConfiguration("attributes", attribute, value)
        }
    }

    fun unsetPlayerConfiguration(attribute: String) {
        Main.client.localPlayer?.name?.takeIf { it.isNotEmpty() }?.let { unsetConfiguration("$it-attributes", attribute) }
    }

    fun getPlayerConfiguration(attribute: String) : String? {
        return Main.client.localPlayer?.name?.takeIf { it.isNotEmpty() }?.let { getConfiguration("$it-attributes", attribute) }
    }
    fun stringToObject(str: String, type: Class<*>): Any? {
        return when (type) {
            Boolean::class.javaPrimitiveType, Boolean::class.java -> str.toBoolean()
            Int::class.javaPrimitiveType, Int::class.java -> str.toIntOrNull() ?: 1
            Double::class.javaPrimitiveType, Double::class.java -> str.toDouble()
            Color::class.java -> colorFromString(str)
            Dimension::class.java -> {
                val (width, height) = str.split("x")
                Dimension(width.toInt(), height.toInt())
            }
            Point::class.java -> {
                val (x, y) = str.split(":")
                Point(x.toInt(), y.toInt())
            }
            Rectangle::class.java -> {
                val (x, y, width, height) = str.split(":")
                Rectangle(x.toInt(), y.toInt(), width.toInt(), height.toInt())
            }
            Enum::class.java -> java.lang.Enum.valueOf(type as Class<out Enum<*>>, str)
            Instant::class.java -> Instant.parse(str)
            Keybind::class.java, ModifierlessKeybind::class.java -> {
                val (code, mods) = str.split(":")
                if (type == ModifierlessKeybind::class.java) {
                    ModifierlessKeybind(code.toInt(), mods.toInt())
                } else {
                    Keybind(code.toInt(), mods.toInt())
                }
            }
            WorldPoint::class.java -> {
                val (x, y, plane) = str.split(":")
                WorldPoint(x.toInt(), y.toInt(), plane.toInt())
            }
            Duration::class.java -> Duration.ofMillis(str.toLong())
            ByteArray::class.java -> Base64.getUrlDecoder().decode(str)
            else -> str
        }
    }
    fun objectToString(obj: Any?): String? {
        return when (obj) {
            is Color -> obj.rgb.toString()
            is Enum<*> -> obj.name
            is Dimension -> "${obj.width}x${obj.height}"
            is Point -> "${obj.x}:${obj.y}"
            is Rectangle -> "${obj.x}:${obj.y}:${obj.width}:${obj.height}"
            is Instant -> obj.toString()
            is Keybind -> "${obj.keyCode}:${obj.modifiers}"
            is WorldPoint -> "${obj.x}:${obj.y}:${obj.plane}"
            is Duration -> obj.toMillis().toString()
            is ByteArray -> Base64.getUrlEncoder().encodeToString(obj)
            else -> obj.toString()
        }
    }
    fun colorFromString(string: String): Color? = try {
        val i = Integer.decode(string)
        Color(i, true)
    } catch (e: NumberFormatException) {
        null
    }
    fun splitKey(key: String): Array<String>? {
        return if (key.contains('.')) {
            arrayOf(key.substringBefore('.'), key.substringAfter('.'))
        } else {
            null
        }
    }
    fun saveProperties() {
        if (!METEOR_DIR.exists())
            METEOR_DIR.mkdirs()
        if (!CONFIG_FILE.exists()) {
            CONFIG_FILE.createNewFile()
        }

        CONFIG_FILE.writer(charset = StandardCharsets.UTF_8).use { out ->
            properties.store(out, "Meteor configuration")
        }
    }

    fun <T : Config?> getConfig(clazz: Class<T>): T? {
        if (!Modifier.isPublic(clazz.modifiers)) {
            throw RuntimeException(
                    "Non-public configuration classes can't have default methods invoked")
        }
        return Proxy.newProxyInstance(clazz.classLoader, arrayOf<Class<*>>(
                clazz
        ), handler) as T
    }

    fun getConfigurationKeys(prefix: String): List<String> {
        return properties.keys
            .filter { it is String && it.startsWith(prefix) }
            .map { it as String }
    }
    fun getConfiguration(groupName: String, key: String): String? {
        return properties.getProperty(getWholeKey(groupName, key))
    }

    fun <T> getConfiguration(groupName: String, key: String, clazz: Class<T>): T? {
        val value = getConfiguration(groupName, key)
        return if (value.isNullOrEmpty()) {
            null
        } else {
            stringToObject(value, clazz) as? T
        }
    }

    fun getWholeKey(groupName: String, key: String): String {
        return "$groupName.$key"
    }

    fun unsetConfiguration(groupName: String, key: String) {
        val wholeKey = getWholeKey(groupName, key)
        var oldValue: String?
        synchronized(this) { oldValue = properties.remove(wholeKey) as String? }
        if (oldValue == null) {
            return
        }

        //log.debug("Unsetting configuration value for {}", wholeKey);
        handler.invalidate()
        val configChanged = ConfigChanged()
        configChanged.group = groupName
        configChanged.key = key
        configChanged.oldValue = oldValue
        EventBus.post(Events.CONFIG_CHANGED, configChanged)
    }




    fun setDefaultConfiguration(config: Any, override: Boolean) {
        val clazz = config.javaClass.interfaces[0]
        val group: ConfigGroup = clazz.getAnnotation(ConfigGroup::class.java)
            ?: return
        for (method in clazz.declaredMethods.toMutableSet()) {
            val item: ConfigItem? = method.getAnnotation(ConfigItem::class.java)

            // only apply default configuration for methods which read configuration (0 args)
            if (item == null || method.parameterCount != 0) {
                continue
            }
            if (method.returnType.isAssignableFrom(Consumer::class.java)) {
                val defaultValue: Any = try {
                    ConfigInvocationHandler.callDefaultMethod(config, method, null)
                } catch (ex: Throwable) {
                    ex.printStackTrace()
                    continue
                }

                //log.debug("Registered consumer: {}.{}", group.value(), item.keyName());
                consumers[group.value + "." + item.keyName] = defaultValue as Consumer<in Plugin?>
            } else {
                if (!method.isDefault) {
                    if (override) {
                        val current = getConfiguration(group.value, item.keyName)
                        // only unset if already set
                        if (current != null) {
                            unsetConfiguration(group.value, item.keyName)
                        }
                    }
                    continue
                }
                if (!override) {
                    // This checks if it is set and is also unmarshallable to the correct type; so
                    // we will overwrite invalid config values with the default
                    val current = getConfiguration(group.value, item.keyName, method.returnType)
                    if (current != null) {
                        continue  // something else is already set
                    }
                }
                val defaultValue: Any = try {
                    ConfigInvocationHandler.callDefaultMethod(config, method, null)
                } catch (ex: Throwable) {
                    ex.printStackTrace()
                    continue
                }
                val current = getConfiguration(group.value, item.keyName)
                val valueString = objectToString(defaultValue)
                // null and the empty string are treated identically in sendConfig and treated as an unset
                // If a config value defaults to "" and the current value is null, it will cause an extra
                // unset to be sent, so treat them as equal
                if (current == valueString || current.isNullOrEmpty() && valueString.isNullOrEmpty()) {
                    continue  // already set to the default value
                }

                //log.debug("Setting default configuration value for {}.{} to {}", group.value(), item.keyName(), defaultValue);
                setConfiguration(group.value, item.keyName, valueString!!)
            }
        }
    }
    fun setConfiguration(groupName: String, key: String, value: Any) {
        // do not save consumers for buttons, they cannot be changed anyway
        if (value is Consumer<*>) return

        require(!(groupName.isEmpty() || key.isEmpty() || key.indexOf(':') != -1))

        val wholeKey = getWholeKey(groupName, key)
        var oldValue: String?
        synchronized(this) {
            oldValue = properties[wholeKey] as String?
            properties[wholeKey] = objectToString(value)
        }

        handler.invalidate()

        val configChanged = ConfigChanged().apply {
            this.group = groupName
            this.key = key
            this.oldValue = oldValue
            this.newValue = objectToString(value)
        }
        EventBus.post(Events.CONFIG_CHANGED, configChanged)

        saveProperties()
    }
    fun getConfigDescriptor(configurationProxy: Config): ConfigDescriptor {
        val inter = configurationProxy.javaClass.interfaces[0]
            ?: configurationProxy::class.java.interfaces[0]
        val group = inter.getAnnotation(ConfigGroup::class.java)
            ?: throw IllegalArgumentException("Not a config group")
        val sections = inter.declaredFields
            .filter { it.isAnnotationPresent(ConfigSection::class.java) && it.type == String::class.java }
            .map { ConfigSectionDescriptor(it[inter].toString(), it.getDeclaredAnnotation(ConfigSection::class.java)) }
            .sortedBy { it.position() }
            .toMutableList() + inter.methods
            .filter { it.parameterCount == 0 && it.isAnnotationPresent(ConfigSection::class.java) }
            .map { ConfigSectionDescriptor(it.returnType.declaredFields.toString(), it.getDeclaredAnnotation(ConfigSection::class.java)) }
            .sortedBy { it.position() }
            .toMutableList()
        val titles = inter.declaredFields
            .filter { it.isAnnotationPresent(ConfigTitle::class.java) && it.type == String::class.java }
            .map { ConfigTitleDescriptor(it[inter].toString(), it.getDeclaredAnnotation(ConfigTitle::class.java)) }
            .sortedBy { it.position() }
        val items = inter.methods
            .filter { it.parameterCount == 0 && it.isAnnotationPresent(ConfigItem::class.java) }
            .map { ConfigItemDescriptor(it.getDeclaredAnnotation(ConfigItem::class.java), it.returnType, it.getDeclaredAnnotation(Range::class.java), it.getDeclaredAnnotation(Alpha::class.java), it.getDeclaredAnnotation(Units::class.java), it.getDeclaredAnnotation(Icon::class.java), it.getDeclaredAnnotation(Secret::class.java)) }
            .sortedBy { it.position() }
        return ConfigDescriptor(group, sections, titles, items)
    }
    @Synchronized
    fun loadSavedProperties() {
        consumers.clear()
        val newProperties = Properties()

        if (CONFIG_FILE.exists()) {
            try {
                FileInputStream(CONFIG_FILE).use { `in` ->
                    newProperties.load(InputStreamReader(`in`, StandardCharsets.UTF_8))
                    swapProperties(newProperties)
                    loaded = true
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        if (!loaded) {
            saveProperties()
            loaded = true
        }
    }

    private fun swapProperties(newProperties: Properties) {
        synchronized(this) { handler.invalidate() }
        val newKeys = newProperties.keys.toSet()
        val oldKeys = properties.keys.toSet()
        for (wholeKey in oldKeys) {
            val split = splitKey(wholeKey as String) ?: continue
            val groupName = split[KEY_SPLITTER_GROUP]
            val key = split[KEY_SPLITTER_KEY]
            val newValue = properties[wholeKey] as String?
            setConfiguration(groupName, key, newValue!!)
        }
        for (wholeKey in newKeys) {
            val split = splitKey(wholeKey as String) ?: continue
            val groupName = split[KEY_SPLITTER_GROUP]
            val key = split[KEY_SPLITTER_KEY]
            val newValue = newProperties[wholeKey] as String?
            setConfiguration(groupName, key, newValue!!)
        }
    }

}