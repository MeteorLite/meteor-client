package meteor

import java.io.File

object Configuration {
    val METEOR_DIR = File(System.getProperty("user.home"), ".meteor")
    var CONFIG_FILE = File(METEOR_DIR, "settings.properties")
    var MASTER_GROUP = "MeteorLite"
    var BLOCK_MOUSE_4_PLUS = true
    var allowGPU = true;
}