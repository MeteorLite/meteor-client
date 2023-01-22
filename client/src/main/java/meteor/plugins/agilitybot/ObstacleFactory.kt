package meteor.plugins.agilitybot

class ObstacleFactory {
    private val obstacles: MutableList<Obstacle> = ArrayList()
    fun append(area: Area, name: String, action: String, tile: Location?): ObstacleFactory {
        val obs = Obstacle(area, name, action, tile)
        obstacles.add(obs)
        return this
    }

    fun append(area: Area, name: String, action: String, id: Int): ObstacleFactory {
        val obs = Obstacle(area, name, action, false, null, id)
        obstacles.add(obs)
        return this
    }

    fun append(area: Area, name: String, action: String): ObstacleFactory {
        val obs = Obstacle(area, name, action)
        obstacles.add(obs)
        return this
    }

    fun array(): Array<Obstacle> {
        return obstacles.toTypedArray()
    }

    companion object {
        fun newInstance(bool: Boolean): ObstacleFactory {
            return ObstacleFactory()
        }
    }
}