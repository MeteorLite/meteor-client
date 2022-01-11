package meteor.rs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.StandardCharsets

object AppletConfiguration {
    lateinit var properties: Map<String, String>
    lateinit var parameters: Map<String, String>

    fun init() {
        val properties: MutableMap<String, String> = HashMap()
        val parameters: MutableMap<String, String> = HashMap()

        try {
            loadRemoteConfiguration(properties, parameters)
        } catch (e: Exception) {
            loadLocalConfiguration(properties, parameters)
        }
    }

    private fun loadRemoteConfiguration(properties: MutableMap<String, String>, parameters: MutableMap<String, String>) {
        val url = URL("https://oldschool.runescape.com/jav_config.ws")
        val br = BufferedReader(InputStreamReader(url.openStream(), StandardCharsets.ISO_8859_1))
        processConfiguration(br, properties, parameters)
    }

    private fun loadLocalConfiguration(properties: MutableMap<String, String>, parameters: MutableMap<String, String>) {
        val br = BufferedReader(
                InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream("jav_config.ws")!!, StandardCharsets.ISO_8859_1))
        processConfiguration(br, properties, parameters)
    }

    private fun processConfiguration(reader: BufferedReader, properties: MutableMap<String, String>, parameters: MutableMap<String, String>) {
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            if (line != null) {
                val split1 = line!!.split("=", limit = 2).toTypedArray()
                when (split1[0]) {
                    "param" -> {
                        val split2 = split1[1].split("=", limit = 2).toTypedArray()
                        parameters[split2[0]] = split2[1]
                    }
                    "msg" -> {
                    }
                    else -> properties[split1[0]] = split1[1]
                }
            }
        }
        AppletConfiguration.properties = properties
        AppletConfiguration.parameters = parameters
    }
}