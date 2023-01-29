package meteor.plugins.agilitybot


import meteor.Main.client
import net.runelite.api.Player
import net.runelite.api.TileObject
import java.util.*

enum class Course(val obstacles: Array<Obstacle>?) {
    GNOME_COURSE(
        ObstacleFactory.newInstance(true)
            .append(
                Area(Location(2472, 3438, 0), Location(2490, 3436, 0)),
                "Log balance", "Walk-across"
            )
            .append(
                Area(Location(2470, 3429, 0), Location(2477, 3426, 0)),
                "Obstacle net", "Climb-over"
            )
            .append(
                Area(Location(2471, 3424, 1), Location(2476, 3422, 1), 1),
                "Tree branch", "Climb"
            )
            .append(
                Area(Location(2472, 3421, 2), Location(2477, 3418, 2), 2),
                "Balancing rope", "Walk-on"
            )
            .append(
                Area(Location(2483, 3421, 2), Location(2488, 3418, 2), 2),
                "Tree branch", "Climb-down"
            )
            .append(
                Area(Location(2482, 3425, 0), Location(2489, 3419, 0)),
                "Obstacle net", "Climb-over"
            )
            .append(
                Area(Location(2482, 3431, 0), Location(2490, 3427, 0)),
                "Obstacle pipe", "Squeeze-through"
            )
            .array()
    ),
    DRAYNOR_COURSE(
        ObstacleFactory.newInstance(true)
            .append(
                Area(Location(3060, 3281, 0), Location(3110, 3147, 0), 0),
                "Rough wall", "Climb"
            )
            .append(
                Area(Location(3097, 3281, 3), Location(3102, 3277, 3), 3),
                "Tightrope", "Cross"
            )
            .append(
                Area(Location(3088, 3276, 3), Location(3091, 3273, 3), 3),
                "Tightrope", "Cross"
            )
            .append(
                Area(Location(3089, 3267, 3), Location(3094, 3265, 3), 3),
                "Narrow wall", "Balance"
            )
            .append(
                Area(Location(3088, 3261, 3), Location(3088, 3257, 3), 3),
                "Wall", "Jump-up"
            )
            .append(
                Area(Location(3088, 3255, 3), Location(3094, 3255, 3), 3),
                "Gap", "Jump"
            )
            .append(
                Area(Location(3096, 3621, 3), Location(3101, 3256, 3), 3),
                "Crate", "Climb-down"
            )
            .array()
    ),
    VARROCK_COURSE(
        ObstacleFactory.newInstance(true)
            .append(
                Area(Location(3249, 3392, 0), Location(3186, 3431, 0), 0),
                "Rough wall", "Climb", 14412
            )
            .append(
                Area(Location(3219, 3419, 3), Location(3214, 3410, 3), 3),
                "Clothes line", "Cross", 14413
            )
            .append(
                Area(Location(3208, 3414, 3), Location(3201, 3417, 3), 3),
                "Gap", "Leap", 14414
            )
            .append(
                Area(Location(3197, 3416, 1), Location(3193, 3416, 1), 1),
                "Wall", "Balance", 14832
            )
            .append(
                Area(Location(3192, 3406, 3), Location(3198, 3402, 3), 3),
                "Gap", "Leap", 14833
            )
            .append(
                Area(Location(3182, 3382, 3), Location(3208, 3398, 3), 3),
                "Gap", "Leap", 14834
            )
            .append(
                Area(Location(3218, 3393, 3), Location(3232, 3402, 3), 3),
                "Gap", "Leap", 14835
            )
            .append(
                Area(Location(3236, 3403, 3), Location(3240, 3408, 3), 3),
                "Ledge", "Hurdle", 14836
            )
            .append(
                Area(Location(3240, 3410, 3), Location(3236, 3415, 3), 3),
                "Edge", "Jump-off", 14841
            )
            .array()
    ),
    CANFIS_COURSE(
        ObstacleFactory.newInstance(true)
            .append(
                Area(Location(3465, 3470, 0), Location(3522, 3518, 0), 0),
                "Tall tree", "Climb"
            )
            .append(
                Area(Location(3502, 3491, 2), Location(3511, 3498, 2), 2),
                "Gap", "Jump", Location(3505, 3498, 2)
            )
            .append(
                Area(Location(3496, 3503, 2), Location(3504, 3507, 2), 2),
                "Gap", "Jump", Location(3496, 3504, 2)
            )
            .append(
                Area(Location(3485, 3498, 2), Location(3493, 3505, 2), 2),
                "Gap", "Jump", Location(3485, 3499, 2)
            ) //
            .append(
                Area(Location(3474, 3491, 3), Location(3480, 3500, 3), 3),
                "Gap", "Jump", Location(3478, 3491, 3)
            ) //
            .append(
                Area(Location(3476, 3480, 2), Location(3484, 3487, 2), 2),
                "Pole-vault", "Vault"
            )
            .append(
                Area(Location(3486, 3468, 3), Location(3504, 3479, 3), 3),
                "Gap", "Jump", Location(3503, 3476, 3)
            )
            .append(
                Area(Location(3509, 3474, 2), Location(3516, 3483, 2), 2),
                "Gap", "Jump", Location(3510, 3483, 2)
            )
            .array()
    ),
    FALADOR_COURSE(
        ObstacleFactory.newInstance(true)
            .append(
                Area(Location(3003, 3363, 0), Location(3059, 3328, 0), 0),
                "Rough wall", "Climb", 14898
            )
            .append(
                Area(Location(3036, 3343, 3), Location(3040, 3342, 3), 3),
                "Tightrope", "Cross", 14899
            )
            .append(
                Area(Location(3045, 3349, 3), Location(3051, 3341, 3), 3),
                "Hand holds", "Cross", Location(3050, 3350, 3)
            )
            .append(
                Area(Location(3048, 3358, 3), Location(3050, 3357, 3), 3),
                "Gap", "Jump", 14903
            )
            .append(
                Area(Location(3045, 3367, 3), Location(3048, 3361, 3), 3),
                "Gap", "Jump", 14904
            )
            .append(
                Area(Location(3034, 3364, 3), Location(3041, 3361, 3), 3),
                "Tightrope", "Cross", 14905
            )
            .append(
                Area(Location(3026, 3354, 3), Location(3029, 3352, 3), 3),
                "Tightrope", "Cross", Location(3026, 3353, 3)
            )
            .append(
                Area(Location(3009, 3358, 3), Location(3021, 3353, 3), 3),
                "Gap", "Jump", 14919
            )
            .append(
                Area(Location(3016, 3349, 3), Location(3022, 3343, 3), 3),
                "Ledge", "Jump", 14920
            )
            .append(
                Area(Location(3011, 3346, 3), Location(3014, 3344, 3), 3),
                "Ledge", "Jump", 14921
            ) // the first bendy corner bit
            .append(
                Area(Location(3009, 3342, 3), Location(3013, 3335, 3), 3),
                "Ledge", "Jump", 14923
            )
            .append(
                Area(Location(3012, 3334, 3), Location(3017, 3331, 3), 3),
                "Ledge", "Jump", 14924
            )
            .append(
                Area(Location(3019, 3335, 3), Location(3024, 3332, 3), 3),
                "Edge", "Jump", Location(3025, 3332, 3)
            )
            .array()
    ),
    SEERS_COURSE(
        ObstacleFactory.newInstance(true)
            .append(Area(Location(2682, 3511, 0), Location(2728, 3451, 0), 0), "Wall", "Climb-up", 14927)
            .append(Area(Location(2721, 3497, 3), Location(2730, 3490, 3), 3), "Gap", "Jump", 14928)
            .append(Area(Location(2705, 3495, 2), Location(2713, 3488, 2), 2), "Tightrope", "Cross", 14932)
            .append(Area(Location(2710, 3481, 2), Location(2715, 3477, 2), 2), "Gap", "Jump", 14929)
            .append(Area(Location(2700, 3475, 3), Location(2715, 3470, 3), 3), "Gap", "Jump", 14930)
            .append(Area(Location(2698, 3475, 2), Location(2702, 3460, 2), 2), "Edge", "Jump", 14931)
            .array()
    ),
    POLLNIVNEACH_COURSE(
        ObstacleFactory.newInstance(true)
            .append(
                Area(Location(3344, 3003, 0), Location(3400, 2900, 0), 0),
                "Basket",
                "Climb-on",
                Location(3351, 2962)
            )
            .append(Area(Location(3351, 2961, 1), Location(3346, 2968, 1), 1), "Market stall", "Jump-on")
            .append(Area(Location(3352, 2973, 1), Location(3355, 2976, 1), 1), "Banner", "Grab")
            .append(Area(Location(3360, 2977, 1), Location(3362, 2979, 1), 1), "Gap", "Leap")
            .append(Area(Location(3366, 2976, 1), Location(3369, 2974, 1), 1), "Tree", "Jump-to")
            .append(Area(Location(3369, 2982, 1), Location(3365, 2986, 1), 1), "Rough wall", "Climb")
            .append(Area(Location(3365, 2985, 2), Location(3355, 2981, 2), 2), "Monkeybars", "Cross")
            .append(Area(Location(3357, 2995, 2), Location(3370, 2990, 2), 2), "Tree", "Jump-on")
            .append(Area(Location(3356, 3000, 2), Location(3362, 3004, 2), 2), "Drying line", "Jump-to")
            .array()
    ),
    RELLEKKA_COURSE(
        ObstacleFactory.newInstance(true)
            .append(Area(Location(2675, 3647, 0), Location(2620, 3681, 0), 0), "Rough wall", "Climb")
            .append(Area(Location(2626, 3676, 3), Location(2622, 3672, 3), 3), "Gap", "Leap")
            .append(Area(Location(2622, 3668, 3), Location(2615, 3658, 3), 3), "Tightrope", "Cross")
            .append(Area(Location(2626, 3651, 3), Location(2629, 3655, 3), 3), "Gap", "Leap")
            .append(Area(Location(2639, 3653, 3), Location(2643, 3649, 3), 3), "Gap", "Hurdle")
            .append(Area(Location(2643, 3657, 3), Location(2650, 3662, 3), 3), "Tightrope", "Cross")
            .append(Area(Location(2655, 3665, 3), Location(2663, 3685, 3), 3), "Pile of fish", "Jump-in")
            .array()
    ),
    ARDY_COURSE(
        ObstacleFactory.newInstance(true)
            .append(Area(Location(2647, 3327, 0), Location(2679, 3286, 0), 0), "Wooden Beams", "Climb-up", 15608)
            .append(Area(Location(2670, 3310, 3), Location(2672, 3297, 3), 3), "Gap", "Jump", 15609)
            .append(Area(Location(2660, 3320, 3), Location(2666, 3316, 3), 3), "Plank", "Walk-on", 26635)
            .append(Area(Location(2652, 3320, 3), Location(2657, 3316, 3), 3), "Gap", "Jump", 15610)
            .append(Area(Location(2652, 3315, 3), Location(2654, 3309, 3), 3), "Gap", "Jump", 15611)
            .append(Area(Location(2650, 3310, 3), Location(2655, 3299, 3), 3), "Steep roof", "Balance-across", 28912)
            .append(Area(Location(2654, 3300, 3), Location(2658, 3296, 3), 3), "Gap", "Jump", 15612)
            .array()
    ),
    NEAREST(null);

    fun distance(player: Player): Int {
        return obstacles!![0].area.center.toWorldPoint().distanceTo(player.worldLocation)
    }

    fun getNext(player: Player): Obstacle? {
        obstacles?.let {
            for (obstacle in it) {
                if (obstacle.area.contains(player)) return obstacle
            }
        }

        return null
    }

    operator fun get(gameObject: TileObject): Obstacle? {
        obstacles?.let {
            for (obstacle in it)
                if (gameObject.id == obstacle.id) return obstacle
        }
        return null
    }

    val requiredLevel: Int
        get() = when (this) {
            GNOME_COURSE -> 0
            DRAYNOR_COURSE -> 10
            else -> (ordinal + 1) * 10
        }

    override fun toString(): String {
        val name = super.name
        return name[0].toString() + name.substring(1).lowercase(Locale.getDefault()).replace('_', ' ')
    }

    companion object {
        val nearest: Course
            get() {
                val local: Player = client.localPlayer!!
                var nearest = GNOME_COURSE
                var dist = Double.MAX_VALUE
                for (course in values()) {
                    val obstacles = course.obstacles
                    obstacles?.let {
                        val area = obstacles!![0].area
                        val dist2 = area.center.toWorldPoint().distanceTo(local.worldLocation).toDouble()
                        if (dist2 < dist) {
                            dist = dist2
                            nearest = course
                        }
                    }
                }
                return nearest
            }
    }
}