package meteor

import java.io.File

object Configuration {
    val METEOR_DIR = File(System.getProperty("user.home"), ".meteor")
    val EXTERNALS_DIR = File(METEOR_DIR, "externals")
    var CONFIG_FILE = File(METEOR_DIR, "settings.properties")
    const val MASTER_GROUP = "MeteorLite"
    var BLOCK_MOUSE_4_PLUS = true
    var allowGPU = true
}