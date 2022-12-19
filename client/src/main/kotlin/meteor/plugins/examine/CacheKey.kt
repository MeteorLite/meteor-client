package meteor.plugins.examine

import java.util.*

internal class CacheKey(type: ExamineType, id: Int) {
    private val type: ExamineType
    private val id: Int

    init {
        this.type = type
        this.id = id
    }

    override fun hashCode(): Int {
        var hash = 3
        hash = 23 * hash + Objects.hashCode(type)
        hash = 23 * hash + id
        return hash
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) {
            return true
        }
        if (obj == null) {
            return false
        }
        if (javaClass != obj.javaClass) {
            return false
        }
        val other = obj as CacheKey
        return if (id != other.id) {
            false
        } else type === other.type
    }
}

