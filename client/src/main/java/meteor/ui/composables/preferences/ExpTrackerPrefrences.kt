package meteor.ui.composables.preferences

import androidx.compose.runtime.mutableStateMapOf
import net.runelite.api.Skill

var expMap = mutableStateMapOf<Skill, Int>()

var expHrMap = mutableStateMapOf<Skill, Int>()
var actionsHrMap = mutableStateMapOf<Skill,Int>()
var startExp = emptyList<Pair<Skill,Int>>()