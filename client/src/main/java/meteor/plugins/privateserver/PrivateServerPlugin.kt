package meteor.plugins.privateserver

import com.google.gson.GsonBuilder
import eventbus.events.ConfigChanged
import meteor.Configuration
import meteor.Main
import meteor.PrivateServerConfiguration
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.rs.api.RSClient
import java.math.BigInteger

@PluginDescriptor(
    name = "Private Server",
    description = "Configuration for connecting to private servers",
    enabledByDefault = false
)
class PrivateServerPlugin : Plugin() {
    private val config = configuration<PrivateServerConfig>()
    private val gson = GsonBuilder().setPrettyPrinting().create()
    private var rspsConfig = PrivateServerConfiguration()

    override fun onStart() {
        loadPrivateServerConfiguration()
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group == "privateServer") {
            if (config.host().isNotEmpty() && config.modulus().isNotEmpty()) {
                savePrivateServerConfiguration()
            }
        }
    }

    fun loadPrivateServerConfiguration() {
        if (Configuration.rspsConfigFile.exists()) {
            rspsConfig = gson.fromJson(Configuration.rspsConfigFile.readText(), PrivateServerConfiguration::class.java)
            client.setHost(rspsConfig.host)
            client.modulus = BigInteger(rspsConfig.modulus, 16)
        }
    }

    fun savePrivateServerConfiguration() {
        client.setHost(rspsConfig.host)
        client.modulus = BigInteger(rspsConfig.modulus, 16)

        //Persist data
        rspsConfig.host = config.host()
        rspsConfig.modulus = config.modulus()
        Configuration.rspsConfigFile.writeText(gson.toJson(rspsConfig))
    }
}