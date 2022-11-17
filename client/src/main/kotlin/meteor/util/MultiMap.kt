package meteor.util

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf

class MultiMap<K, V> {
     val map: MutableMap<K, MutableCollection<V>?> =  mutableStateMapOf()

    fun put(key: K, value: V) {
        if (map[key] == null) map[key] = mutableStateListOf()
        map[key]!!.add(value)
    }

    fun putIfAbsent(key: K, value: V) {
        if (map[key] == null) map[key] = mutableStateListOf()
        if (!map[key]!!.contains(value)) map[key]!!.add(value)
    }

    fun remove(key: K, value: V): Boolean {
        return if (map[key] != null) map[key]!!.remove(value) else false
    }

    fun containsKey(key: K?): Boolean = map.containsKey(key)
    fun remove(key: K) {
        map.remove(key)
    }

    fun values(): MutableCollection<MutableCollection<V>?> {
        return map.values
    }
    fun size(): Int {
        var size = 0
        for (value in map.values) size += value!!.size
        return size
    }

    fun entrySet(): Set<Map.Entry<K, Collection<V>?>> = map.entries
}