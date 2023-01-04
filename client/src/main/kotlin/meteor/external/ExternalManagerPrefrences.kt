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
import meteor.plugins.PluginManager.getManifest
import meteor.plugins.PluginManager.plugins
import meteor.plugins.PluginManager.runningMap
import meteor.plugins.PluginManager.start
import meteor.ui.composables.preferences.intColor
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
    println("URL: $url")
    val file = File("$savePath/$fileName")
    if (file.exists()) {
        if (hash == file.inputStream().use { it.hash() }) {
            return
        }
    } else {
        file.createNewFile()
    }

    val url = URL(url)
    val connection = url.openConnection()
    val inputStream = connection.getInputStream()
    val fileOutputStream = FileOutputStream("$savePath/$fileName")

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
    val classLoader = URLClassLoader(arrayOf(jarFile.toURI().toURL()))
    val manifest = getManifest(jarFile)
    val pluginClassName = manifest?.mainAttributes?.getValue("Main-Class")
    val pluginClass = classLoader.loadClass(pluginClassName)
    val plugin = pluginClass.getDeclaredConstructor().newInstance() as Plugin
    if (plugins.any { p -> p.getName() == plugin.getName() }) {
        throw RuntimeException("Duplicate plugin (${plugin.getName()}) not allowed")
    }
    if (pluginClassName?.let { ConfigManager.getConfiguration(it, "pluginEnabled") } != null && pluginClass.getAnnotation(
            PluginDescriptor::class.java
        )!!.disabledOnStartup
    ) {
        if (pluginClassName != null) {
            ConfigManager.setConfiguration(pluginClassName, "pluginEnabled", false)
        }
    }
    plugins.add(plugin)
    runningMap[plugin] = plugin.shouldEnable()
    if (runningMap[plugin]!!) {
        start(plugin)
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

        Text("Support: $support", color = intColor)
    }
}