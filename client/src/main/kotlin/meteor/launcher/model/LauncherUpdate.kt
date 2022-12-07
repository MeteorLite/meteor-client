package meteor.launcher.model

class LauncherUpdate {
    var version: String = ""
    var updateInfo: String = ""
    var files = ArrayList<File>()
    var modulesParts = ArrayList<File>()
}