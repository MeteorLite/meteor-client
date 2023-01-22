package meteor.ui.composables.preferences

import androidx.compose.runtime.mutableStateOf
import meteor.plugins.loottracker.LootTrackerItem
import meteor.util.MultiMap


var priceMap = MultiMap<String, Int>()
var multiMap = mutableStateOf(MultiMap<String, LootTrackerItem?>())