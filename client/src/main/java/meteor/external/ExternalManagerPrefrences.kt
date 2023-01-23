package meteor.external

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import meteor.config.ConfigManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.PluginManager
import meteor.plugins.PluginManager.getManifest
import meteor.plugins.PluginManager.plugins
import meteor.plugins.PluginManager.runningMap
import meteor.plugins.PluginManager.start
import meteor.ui.composables.preferences.secondColor
import meteor.ui.composables.preferences.setErrorState
import meteor.ui.composables.preferences.surface
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import org.jetbrains.kotlin.daemon.common.toHexString
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL
import java.net.URLClassLoader
import java.security.MessageDigest

fun InputStream.hash(): String {
    val md = MessageDigest.getInstance("SHA-512")
    val buffer = ByteArray(1024)
    var read = read(buffer)
    while (read != -1) {
        md.update(buffer, 0, read)
        read = read(buffer)
    }
    return md.digest().toHexString()
}
val savePath = "${System.getProperty("user.home")}/.meteor/externalplugins"
var projectUrl = mutableStateOf("")
var repositoryOwner = mutableStateOf("MeteorLite")
var repository = mutableStateOf("Meteor-Externals")
var pluginNames = mutableStateListOf<String>()
var pluginNamesState = mutableStateOf(pluginNames)
val http = OkHttpClient()
var body: ResponseBody? = null
var jsonString: String? = null
var jsonArray: JSONArray? = null


fun findJsonValue(name: String): JSONObject? {
    for (i in 0 until jsonArray!!.length()) {
        val p = jsonArray?.getJSONObject(i)
        if (p?.getString("name") == name) {
            return p
        }
    }
    return null
}

fun downloadFile(url: String, savePath: String, fileName: String, hash: String) {
    val file = File("$savePath/$fileName")
    if (file.exists()) {
        // Check if the file has the correct hash
        if (hash == file.inputStream().use { it.hash() }) {
            return
        }
    }

    val connection =  URL(url).openConnection()
    val inputStream = connection.getInputStream()
    val fileOutputStream = FileOutputStream("$savePath/$fileName")

    file.createNewFile()
    val buffer = ByteArray(1024)
    var bytesRead = inputStream.read(buffer)
    while (bytesRead != -1) {
        fileOutputStream.write(buffer, 0, bytesRead)
        bytesRead = inputStream.read(buffer)
    }

    inputStream.close()
    fileOutputStream.close()
}

fun loadAndInitJar(jarFile: File) {
    URLClassLoader(arrayOf(jarFile.toURI().toURL())).use { classLoader ->
        try {
            val manifest = getManifest(jarFile)
            val pluginClassName = manifest?.mainAttributes?.getValue("Main-Class")
                ?: return setErrorState("Main-Class attribute not found in manifest")

            val pluginClass = classLoader.loadClass(pluginClassName)
            val plugin = pluginClass.getDeclaredConstructor().newInstance() as Plugin
            if (plugins.any { it.getName() == plugin.getName() }) {
                return setErrorState("Duplicate plugin (${plugin.getName()}) not allowed")
            }

            val pluginEnabled = ConfigManager.getConfiguration(pluginClassName, "pluginEnabled")
            val disabledOnStartup = pluginClass.getAnnotation(PluginDescriptor::class.java)?.disabledOnStartup ?: false
            if (pluginEnabled != null && disabledOnStartup) {
                ConfigManager.setConfiguration(pluginClassName, "pluginEnabled", false)
            }

            plugins.add(plugin)
            runningMap[plugin] = plugin.shouldEnable()
            if (runningMap[plugin] == true) {
                start(plugin)
            }
        } catch (e: Exception) {

            setErrorState(e.message!!)
        }
    }
}

fun remove(jarFile: File) {
    val index = plugins.indexOfFirst { it.getName() == jarFile.nameWithoutExtension }
    if (index >= 0) {
        val plugin = plugins[index]
        PluginManager.stop(plugin)
        val classLoader = plugin.javaClass.classLoader as URLClassLoader
        classLoader.use {
            plugins.removeAt(index)
            runningMap.remove(plugin)
        }
            jarFile.delete()
    }
}

@Composable
fun openSupport(support: String) {
    val uriHandler = LocalUriHandler.current
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = surface),
        onClick = { uriHandler.openUri(support) },
        modifier = Modifier.height(33.dp).width(275.dp)
    ) {
        Text("Support: $support", color = secondColor.value)
    }
}