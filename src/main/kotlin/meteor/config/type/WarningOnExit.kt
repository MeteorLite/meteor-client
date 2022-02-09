package meteor.config.type


enum class WarningOnExit(type: String) {
    ALWAYS("Always"), LOGGED_IN("Logged in"), NEVER("Never");
}