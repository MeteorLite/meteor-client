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
        Main.client.localPlayer?.let {
            it.name?.let { name ->
                if (name.isNotEmpty())
                    setConfiguration("$name-attributes", attribute, value)
            }
        }
    }

    fun unsetPlayerConfiguration(attribute: String) {
        Main.client.localPlayer?.let {
            it.name?.let { name ->
                if (name.isNotEmpty())
                    unsetConfiguration("$name-attributes", attribute)
            }
        }
    }

    fun getPlayerConfiguration(attribute: String) : String? {
        Main.client.localPlayer?.let {
            it.name?.let { name ->
                if (name.isNotEmpty())
                    return getConfiguration("$name-attributes", attribute)
            }
        }
        return null
    }

    fun stringToObject(str: String, type: Class<*>): Any? {
        if (type == Boolean::class.javaPrimitiveType || type == Boolean::class.java) {
            return (str).toBoolean()
        }
        if (type == Int::class.javaPrimitiveType || type == Int::class.java) {
            return try {
                str.toInt()
            } catch (e: NumberFormatException) {
                1
            }
        }
        if (type == Double::class.javaPrimitiveType || type == Double::class.java) {
            return str.toDouble()
        }
        if (type == Color::class.java) {
            return colorFromString(str)
        }
        if (type == Dimension::class.java) {
            val splitStr = str.split("x").toTypedArray()
            val width = splitStr[0].toInt()
            val height = splitStr[1].toInt()
            return Dimension(width, height)
        }
        if (type == Point::class.java) {
            val splitStr = str.split(":").toTypedArray()
            val width = splitStr[0].toInt()
            val height = splitStr[1].toInt()
            return Point(width, height)
        }
        if (type == Rectangle::class.java) {
            val splitStr = str.split(":").toTypedArray()
            val x = splitStr[0].toInt()
            val y = splitStr[1].toInt()
            val width = splitStr[2].toInt()
            val height = splitStr[3].toInt()
            return Rectangle(x, y, width, height)
        }
        if (type.isEnum) {
            return java.lang.Enum.valueOf(type as Class<out Enum<*>?>, str)
        }
        if (type == Instant::class.java) {
            return Instant.parse(str)
        }
        if (type == Keybind::class.java || type == ModifierlessKeybind::class.java) {
            val splitStr = str.split(":").toTypedArray()
            val code = splitStr[0].toInt()
            val mods = splitStr[1].toInt()
            return if (type == ModifierlessKeybind::class.java) {
                ModifierlessKeybind(code, mods)
            } else Keybind(code, mods)
        }
        if (type == WorldPoint::class.java) {
            val splitStr = str.split(":").toTypedArray()
            val x = splitStr[0].toInt()
            val y = splitStr[1].toInt()
            val plane = splitStr[2].toInt()
            return WorldPoint(x, y, plane)
        }
        if (type == Duration::class.java) {
            return Duration.ofMillis(str.toLong())
        }
        if (type == ByteArray::class.java) {
            return Base64.getUrlDecoder().decode(str)
        }
        return str
    }

    fun objectToString(type: Any?): String? {
        if (type is Color) {
            return type.rgb.toString()
        }
        if (type is Enum<*>) {
            return type.name
        }
        if (type is Dimension) {
            return type.width.toString() + "x" + type.height
        }
        if (type is Point) {
            return type.x.toString() + ":" + type.y
        }
        if (type is Rectangle) {
            return type.x.toString() + ":" + type.y + ":" + type.width + ":" + type.height
        }
        if (type is Instant) {
            return type.toString()
        }
        if (type is Keybind) {
            return type.keyCode.toString() + ":" + type.modifiers
        }
        if (type is WorldPoint) {
            return type.x.toString() + ":" + type.y + ":" + type.plane
        }
        if (type is Duration) {
            return type.toMillis().toString()
        }
        if (type is ByteArray) {
            return Base64.getUrlEncoder().encodeToString(type as ByteArray?)
        }
        return if (type is EnumSet<*>) {
            if (type.size == 0) {
                getElementType(type as EnumSet<*>?)!!.canonicalName + "{}"
            } else type.toTypedArray()[0].javaClass.canonicalName + "{" + type + "}"
        } else type?.toString()
    }

    fun getElementType(enumSet: EnumSet<*>?): Class<*>? {
        var thisSet = enumSet
        if (thisSet!!.isEmpty()) {
            thisSet = EnumSet.complementOf(thisSet)
        }
        return thisSet!!.iterator().next().javaClass.declaringClass
    }



    fun colorFromString(string: String): Color? {
        return try {
            val i = Integer.decode(string)
            Color(i, true)
        } catch (e: NumberFormatException) {
            null
        }
    }

    fun splitKey(key: String): Array<String>? {
        var newKey = key
        val i = newKey.indexOf('.')
        if (i == -1) {
            // all keys must have a group and key
            return null
        }
        val group = newKey.substring(0, i)
        newKey = newKey.substring(i + 1)
        return arrayOf(group, newKey)
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
        return properties.keys.stream().filter { v: Any -> (v as String).startsWith(prefix) }
                .map { obj: Any? -> String::class.java.cast(obj) }.collect(Collectors.toList())
    }

    fun getConfiguration(groupName: String, key: String): String? {
        return properties.getProperty(getWholeKey(groupName, key))
    }

    fun <T> getConfiguration(groupName: String, key: String, clazz: Class<T>): T? {
        val value = getConfiguration(groupName, key)
        if (!Strings.isNullOrEmpty(value)) {
            try {
                return stringToObject(value!!, clazz) as T
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
                //log.warn("Unable to unmarshal {} ", getWholeKey(groupName, profile, key), e);
            }
        }
        return null
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

    fun getAllDeclaredInterfaceFields(clazz: Class<*>): Collection<Field> {
        val methods: MutableCollection<Field> = HashSet()
        val interfaces = Stack<Class<*>>()
        interfaces.push(clazz)
        while (!interfaces.isEmpty()) {
            val inter = interfaces.pop()
            Collections.addAll(methods, *inter.declaredFields)
            Collections.addAll(interfaces, *inter.interfaces)
        }
        return methods
    }

    private fun getAllDeclaredInterfaceMethods(clazz: Class<*>): Collection<Method> {
        val methods: HashSet<Method> = HashSet()
        val interfaces = Stack<Class<*>>()
        interfaces.push(clazz)
        while (!interfaces.isEmpty()) {
            val inter: Class<*> = interfaces.pop()
            Collections.addAll(methods, *inter.declaredMethods)
            Collections.addAll(interfaces, *inter.interfaces)
        }
        return methods
    }

    fun getDefaultConfigValue(config: Any, methodName: String) : String?{
        var value: String? = null
        val clazz = config.javaClass.interfaces[0]
        for (method in getAllDeclaredInterfaceMethods(clazz)) {
            if (method.name == methodName) {
                val item: ConfigItem? = method.getAnnotation(ConfigItem::class.java)

                // only get default configuration for methods which read configuration (0 args)
                if (item == null || method.parameterCount != 0) {
                    continue
                }

                val defaultValue: Any = try {
                    ConfigInvocationHandler.callDefaultMethod(config, method, null)
                } catch (ex: Throwable) {
                    ex.printStackTrace()
                    continue
                }
                value = objectToString(defaultValue)
            }
        }
        return value
    }

    fun setDefaultConfiguration(config: Any, override: Boolean) {
        val clazz = config.javaClass.interfaces[0]
        val group: ConfigGroup = clazz.getAnnotation(ConfigGroup::class.java)
                ?: return
        for (method in getAllDeclaredInterfaceMethods(clazz)) {
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
                if (current == valueString || Strings.isNullOrEmpty(current) && Strings
                                .isNullOrEmpty(valueString)) {
                    continue  // already set to the default value
                }

                //log.debug("Setting default configuration value for {}.{} to {}", group.value(), item.keyName(), defaultValue);
                setConfiguration(group.value, item.keyName, valueString!!)
            }
        }
    }

    fun setConfiguration(groupName: String, key: String, value: Any) {
        // do not save consumers for buttons, they cannot be changed anyway
        if (value is Consumer<*>) {
            return
        }

        require(!(Strings.isNullOrEmpty(groupName) || Strings.isNullOrEmpty(key) || key.indexOf(':') != -1))

        val wholeKey = getWholeKey(groupName, key)
        var oldValue: String?
        synchronized(this) { oldValue = properties.setProperty(wholeKey, objectToString(value)) as String? }

        handler.invalidate()

        val configChanged = ConfigChanged()
        configChanged.group = groupName
        configChanged.key = key
        configChanged.oldValue = oldValue
        configChanged.newValue = objectToString(value)
        EventBus.post(Events.CONFIG_CHANGED, configChanged)

        saveProperties()
    }

    fun getConfigDescriptor(configurationProxy: Config): ConfigDescriptor {
        val inter: Class<*> = configurationProxy.javaClass.interfaces[0] ?: configurationProxy::class.java.interfaces[0]
        val group: ConfigGroup = inter.getAnnotation(ConfigGroup::class.java)
            ?: throw IllegalArgumentException("Not a config group")
        val sections: List<ConfigSectionDescriptor> =  getAllDeclaredInterfaceFields(inter)
            .asSequence()
            .filter { it.isAnnotationPresent(ConfigSection::class.java) && it.type == String::class.java }
            .map { ConfigSectionDescriptor(
                it[inter].toString(),
                it.getDeclaredAnnotation(ConfigSection::class.java)
            ) }
            .sortedBy {  it.position()
            }.toMutableList() + inter.methods
            .filter { it.parameterCount == 0 && it.isAnnotationPresent(ConfigSection::class.java) }
            .map {
                ConfigSectionDescriptor(
                    it.returnType.declaredFields.toString(),
                    it.getDeclaredAnnotation(ConfigSection::class.java)
                )
            }
            .sortedBy { it.position()
            }.toMutableList()

        val titles: List<ConfigTitleDescriptor> = getAllDeclaredInterfaceFields(inter)
            .asSequence()
            .filter {  it.isAnnotationPresent(ConfigTitle::class.java) && it.type == String::class.java }
            .map { ConfigTitleDescriptor(it[inter].toString(), it.getDeclaredAnnotation(ConfigTitle::class.java)) }
            .filter { obj: ConfigTitleDescriptor? -> Objects.nonNull(obj) }
            .sortedBy{ it.position()
            }.toList()
        val items: List<ConfigItemDescriptor> = inter.methods
            .filter { it.parameterCount == 0 && it.isAnnotationPresent(ConfigItem::class.java) }
            .map {
                ConfigItemDescriptor(
                    it.getDeclaredAnnotation(ConfigItem::class.java),
                    it.returnType,
                    it.getDeclaredAnnotation(Range::class.java),
                    it.getDeclaredAnnotation(Alpha::class.java),
                    it.getDeclaredAnnotation(Units::class.java),
                    it.getDeclaredAnnotation(Icon::class.java),
                    it.getDeclaredAnnotation(Secret::class.java)
                )
            }
            .sortedBy { it.position()
            }.toList()
        return ConfigDescriptor(group, sections, titles, items)
    }

    @Synchronized
    fun loadSavedProperties() {
        consumers.clear()
        val newProperties = Properties()

        if (CONFIG_FILE.exists())
        try {
            FileInputStream(CONFIG_FILE).use { `in` ->
                newProperties.load(InputStreamReader(`in`, StandardCharsets.UTF_8))
                swapProperties(newProperties)
                loaded = true
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        if (!loaded) {
            saveProperties()
            loaded = true
        }
    }

    private fun swapProperties(newProperties: Properties) {
        val newKeys: Set<Any> = HashSet(newProperties.keys)
        val oldKeys: Set<Any> = HashSet(properties.keys)
        synchronized(this) { handler.invalidate() }
        for (wholeKey in oldKeys) {
            val split = splitKey((wholeKey as String)) ?: continue
            val groupName = split[KEY_SPLITTER_GROUP]
            val key = split[KEY_SPLITTER_KEY]
            val newValue = properties[wholeKey] as String?
            setConfiguration(groupName, key, newValue!!)
        }
        for (wholeKey in newKeys) {
            val split = splitKey((wholeKey as String)) ?: continue
            val groupName = split[KEY_SPLITTER_GROUP]
            val key = split[KEY_SPLITTER_KEY]
            val newValue = newProperties[wholeKey] as String?
            setConfiguration(groupName, key, newValue!!)
        }
    }

}