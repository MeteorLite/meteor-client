package meteor.plugins.questrunner

import meteor.plugins.EventSubscriber

open class QuestRunner : EventSubscriber() {

    open fun handleState() {}
    open fun startQuest() {}
    open fun finishQuest() {}
}