package meteor.config.legacy

interface ConfigObject {
    fun key(): String?
    fun name(): String
    fun position(): Int
}