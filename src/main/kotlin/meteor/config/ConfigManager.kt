package meteor.config

import Main
import com.google.common.base.Strings
import com.google.common.collect.ComparisonChain
import eventbus.Events
import meteor.Configuration.CONFIG_FILE
import meteor.Configuration.MASTER_GROUP
import meteor.config.legacy.*
import eventbus.events.ConfigChanged
import meteor.Configuration.METEOR_DIR
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
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.time.Duration
import java.time.Instant
import java.util.*
import java.util.function.Consumer
import java.util.function.Function
import java.util.stream.Collectors

object ConfigManager {
    private val properties = Properties()
    private val handler: ConfigInvocationHandler = ConfigInvocationHandler(this)
    private val consumers: HashMap<String, Consumer<in Plugin?>> = HashMap()
    private const val KEY_SPLITTER_GROUP = 0
    private const val KEY_SPLITTER_KEY = 1
    var loaded = false

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
        return if (type == EnumSet::class.java) {
            try {
                val substring = str.substring(str.indexOf("{") + 1, str.length - 1)
                val splitStr = substring.split(", ").toTypedArray()
                val enumClass: Class<out Enum<*>>
                if (!str.contains("{")) {
                    return null
                }
                enumClass = findEnumClass(str, Main::class.java.classLoader)
                val enumSet = EnumSet.noneOf(enumClass)
                for (s in splitStr) {
                    try {
                        enumSet.add(java.lang.Enum.valueOf(enumClass, s.replace("[", "").replace("]", "")))
                    } catch (ignore: IllegalArgumentException) {
                        return EnumSet.noneOf(enumClass)
                    }
                }
                enumSet
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        } else str
    }

    fun objectToString(`object`: Any?): String? {
        if (`object` is Color) {
            return `object`.rgb.toString()
        }
        if (`object` is Enum<*>) {
            return `object`.name
        }
        if (`object` is Dimension) {
            return `object`.width.toString() + "x" + `object`.height
        }
        if (`object` is Point) {
            return `object`.x.toString() + ":" + `object`.y
        }
        if (`object` is Rectangle) {
            return `object`.x.toString() + ":" + `object`.y + ":" + `object`.width + ":" + `object`.height
        }
        if (`object` is Instant) {
            return `object`.toString()
        }
        if (`object` is Keybind) {
            return `object`.keyCode.toString() + ":" + `object`.modifiers
        }
        if (`object` is WorldPoint) {
            return `object`.x.toString() + ":" + `object`.y + ":" + `object`.plane
        }
        if (`object` is Duration) {
            return `object`.toMillis().toString()
        }
        if (`object` is ByteArray) {
            return Base64.getUrlEncoder().encodeToString(`object` as ByteArray?)
        }
        return if (`object` is EnumSet<*>) {
            if (`object`.size == 0) {
                getElementType(`object` as EnumSet<*>?)!!.canonicalName + "{}"
            } else `object`.toTypedArray()[0].javaClass.canonicalName + "{" + `object` + "}"
        } else `object`?.toString()
    }

    fun getElementType(enumSet: EnumSet<*>?): Class<*>? {
        var enumSet = enumSet
        if (enumSet!!.isEmpty()) {
            enumSet = EnumSet.complementOf(enumSet)
        }
        return enumSet!!.iterator().next().javaClass.declaringClass
    }

    fun findEnumClass(`class`: String,
                      classLoader: ClassLoader): Class<Enum<*>> {
        var transformedString = StringBuilder()
        try {
            val strings = `class`.substring(0, `class`.indexOf("{")).split("\\.").toTypedArray()
            var i = 0
            while (i != strings.size) {
                when (i) {
                    0 -> {
                        transformedString.append(strings[i])
                    }
                    strings.size - 1 -> {
                        transformedString.append("$").append(strings[i])
                    }
                    else -> {
                        transformedString.append(".").append(strings[i])
                    }
                }
                i++
            }
            return classLoader.loadClass(transformedString.toString()) as Class<Enum<*>>
        } catch (e2: java.lang.Exception) {
            // Will likely fail a lot
        }
        try {
            return classLoader.loadClass(`class`.substring(0, `class`.indexOf("{"))) as Class<Enum<*>>
        } catch (e: java.lang.Exception) {
            // Will likely fail a lot
        }
        transformedString = StringBuilder()
        throw RuntimeException("Failed to find Enum for " + `class`.substring(0, `class`.indexOf("{")))
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
        var key = key
        val i = key.indexOf('.')
        if (i == -1) {
            // all keys must have a group and key
            return null
        }
        val group = key.substring(0, i)
        key = key.substring(i + 1)
        return arrayOf(group, key)
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

    fun <T> getConfiguration(groupName: String, key: String, clazz: Class<T>): T {
        val value = getConfiguration(groupName, key)
        if (!Strings.isNullOrEmpty(value)) {
            try {
                return stringToObject(value!!, clazz) as T
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
                //log.warn("Unable to unmarshal {} ", getWholeKey(groupName, profile, key), e);
            }
        }
        return null as T
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

    private fun getAllDeclaredInterfaceFields(clazz: Class<*>): Collection<Field> {
        val methods: MutableCollection<Field> = HashSet()
        val interfaces = Stack<Class<*>>()
        interfaces.push(clazz)
        while (!interfaces.isEmpty()) {
            val `interface` = interfaces.pop()
            Collections.addAll(methods, *`interface`.declaredFields)
            Collections.addAll(interfaces, *`interface`.interfaces)
        }
        return methods
    }

    private fun getAllDeclaredInterfaceMethods(clazz: Class<*>): Collection<Method> {
        val methods: HashSet<Method> = HashSet()
        val interfaces = Stack<Class<*>>()
        interfaces.push(clazz)
        while (!interfaces.isEmpty()) {
            val `interface`: Class<*> = interfaces.pop()
            Collections.addAll(methods, *`interface`.declaredMethods)
            Collections.addAll(interfaces, *`interface`.interfaces)
        }
        return methods
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
        synchronized(this) { oldValue = properties.setProperty(wholeKey, "$value") as String? }

        handler.invalidate()

        val configChanged = ConfigChanged()
        configChanged.group = groupName
        configChanged.key = key
        configChanged.oldValue = oldValue
        configChanged.newValue = "$value"
        EventBus.post(Events.CONFIG_CHANGED, configChanged)

        saveProperties()
    }

    fun getConfigDescriptor(configurationProxy: Config): ConfigDescriptor? {
        val inter: Class<*> = configurationProxy.javaClass.interfaces[0]
        val group: ConfigGroup = inter.getAnnotation(ConfigGroup::class.java)
                ?: throw IllegalArgumentException("Not a config group")
        val sections: List<ConfigSectionDescriptor> = getAllDeclaredInterfaceFields(inter).stream()
                .filter { m: Field -> m.isAnnotationPresent(ConfigSection::class.java) && m.type == String::class.java }
                .map<ConfigSectionDescriptor>(Function { m: Field ->
                    try {
                        return@Function ConfigSectionDescriptor(m[inter].toString(),
                                m.getDeclaredAnnotation(ConfigSection::class.java)
                        )
                    } catch (e: IllegalAccessException) {
                        //log.warn("Unable to load section {}::{}", inter.getSimpleName(), m.getName());
                        return@Function null
                    }
                })
                .filter { obj: ConfigSectionDescriptor? -> Objects.nonNull(obj) }
                .sorted { a: ConfigSectionDescriptor, b: ConfigSectionDescriptor ->
                    ComparisonChain.start()
                            .compare(a.section.position, b.section.position)
                            .compare(a.section.name, b.section.name)
                            .result()
                }
                .collect(Collectors.toList())
        val titles: List<ConfigTitleDescriptor> = getAllDeclaredInterfaceFields(inter).stream()
                .filter { m: Field -> m.isAnnotationPresent(ConfigTitle::class.java) && m.type == String::class.java }
                .map<ConfigTitleDescriptor>(Function { m: Field ->
                    try {
                        return@Function ConfigTitleDescriptor(m[inter].toString(),
                                m.getDeclaredAnnotation(ConfigTitle::class.java)
                        )
                    } catch (e: IllegalAccessException) {
                        //log.warn("Unable to load title {}::{}", inter.getSimpleName(), m.getName());
                        return@Function null
                    }
                })
                .filter { obj: ConfigTitleDescriptor? -> Objects.nonNull(obj) }
                .sorted { a: ConfigTitleDescriptor, b: ConfigTitleDescriptor ->
                    ComparisonChain.start()
                            .compare(a.title.position, b.title.position)
                            .compare(a.title.name, b.title.name)
                            .result()
                }
                .collect(Collectors.toList())
        val items: List<ConfigItemDescriptor> = Arrays.stream(inter.methods)
                .filter { m: Method -> m.parameterCount == 0 && m.isAnnotationPresent(ConfigItem::class.java) }
                .map { m: Method ->
                    ConfigItemDescriptor(
                            m.getDeclaredAnnotation(ConfigItem::class.java),
                            m.returnType,
                            m.getDeclaredAnnotation(Range::class.java),
                            m.getDeclaredAnnotation(Alpha::class.java),
                            m.getDeclaredAnnotation(Units::class.java),
                            m.getDeclaredAnnotation(Icon::class.java)
                    )
                }
                .sorted { a: ConfigItemDescriptor, b: ConfigItemDescriptor ->
                    ComparisonChain.start()
                            .compare(a.item.position, b.item.position)
                            .compare(a.item.name, b.item.name)
                            .result()
                }
                .collect(Collectors.toList())
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