package rs117.hd.template

import com.google.common.io.CharStreams
import meteor.Logger
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.function.Function

class Template {
    private val resourceLoaders: ArrayList<Function<String, String?>> = ArrayList()
    private val log = Logger("GPUHD Shader")

    fun add(fn: Function<String, String?>): Template {
        resourceLoaders.add(fn)
        return this
    }

    fun process(str: String): String {
        val sb = StringBuilder()
        for (line in (str as java.lang.String).split("\r?\n")) {
            val trimmed = line.trim { it <= ' ' }
            if (trimmed.startsWith("#include ")) {
                val resource = trimmed.substring(9)
                val resourceStr = load(resource)
                sb.append(resourceStr)
            } else {
                sb.append(line).append('\n')
            }
        }
        return sb.toString()
    }

    fun load(filename: String?): String {
        for (loader in resourceLoaders) {
            if (filename != null) {
                val value = loader.apply(filename)
                if (value != null) {
                    return process(value)
                }
            }
        }
        return ""
    }

    fun addInclude(clazz: Class<*>): Template {
        return add { f: String ->
            try {
                clazz.getResourceAsStream(f).use { `is` ->
                    if (`is` != null) {
                        return@add inputStreamToString(`is`)
                    }
                }
            } catch (e: IOException) { e.printStackTrace()}
            null
        }
    }

    private fun inputStreamToString(`in`: InputStream): String {
        return try {
            CharStreams.toString(InputStreamReader(`in`, StandardCharsets.UTF_8))
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}