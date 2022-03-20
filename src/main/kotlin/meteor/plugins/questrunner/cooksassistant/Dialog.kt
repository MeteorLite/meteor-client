package meteor.plugins.questrunner.cooksassistant

import meteor.api.widgets.Dialog
import meteor.plugins.questrunner.QuestRunnerPlugin

object Dialog {
    val plugin = QuestRunnerPlugin

    fun handle() {
        for (dialog in Dialog.options)
            if (plugin.lastPluginState == CooksAssistantRunner.PLUGIN_STATE.START_QUEST)
                when (dialog.text) {
                    "What's wrong?", "Yes." -> {
                        Dialog.enterInput(1)
                        break
                    }
                }
    }
}