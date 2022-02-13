package meteor.api.widgets

import Main.client

import net.runelite.api.Friend
import java.util.*
import java.util.function.Predicate
import java.util.stream.Collectors

object Friends {
    fun getAll(filter: Predicate<Friend>?): List<Friend?> {
        return Arrays.stream(client.getFriendContainer().getMembers())
            .filter(filter)
            .collect(Collectors.toList())
    }

    fun getAll(vararg names: String): List<Friend?> {
        return getAll { x: Friend ->
            if (x.`name$api` == null) {
                return@getAll false
            }
            for (name in names) {
                if (name == x.`name$api`) {
                    return@getAll true
                }
            }
            false
        }
    }

    fun getAll(vararg worlds: Int): List<Friend?> {
        return getAll { x: Friend ->
            for (world in worlds) {
                if (world == x.currentWorld) {
                    return@getAll true
                }
            }
            false
        }
    }

    fun getFirst(filter: Predicate<Friend>?): Friend? {
        return getAll(filter).stream()
            .findFirst()
            .orElse(null)
    }

    fun getFirst(vararg names: String): Friend? {
        return getFirst { x: Friend ->
            if (x.`name$api` == null) {
                return@getFirst false
            }
            for (name in names) {
                if (name == x.`name$api`) {
                    return@getFirst true
                }
            }
            false
        }
    }

    fun getFirst(vararg worlds: Int): Friend? {
        return getFirst { x: Friend ->
            for (world in worlds) {
                if (world == x.currentWorld) {
                    return@getFirst true
                }
            }
            false
        }
    }

    fun isAdded(name: String?): Boolean {
        return client.isFriended(name, false)
    }

    fun isOnline(friend: Friend): Boolean {
        return isOnline(friend.`name$api`)
    }

    fun isOnline(name: String?): Boolean {
        return client.isFriended(name, true)
    }

    fun add(name: String?) {
        client.addFriend(name)
    }

    fun remove(name: String?) {
        client.removeFriend(name)
    }
}