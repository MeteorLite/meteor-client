package meteor.config.legacy

enum class FlashNotification(type: String) {
    DISABLED("Off"), FLASH_TWO_SECONDS("Flash for 2 seconds"), SOLID_TWO_SECONDS("Solid for 2 seconds"), FLASH_UNTIL_CANCELLED(
            "Flash until cancelled"),
    SOLID_UNTIL_CANCELLED("Solid until cancelled");
}