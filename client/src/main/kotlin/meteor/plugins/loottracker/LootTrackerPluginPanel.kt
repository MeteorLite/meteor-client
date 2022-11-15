package meteor.plugins.loottracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.hoot.api.game.GameThread
import dev.hoot.api.game.Prices
import meteor.Main.itemManager
import meteor.plugins.PluginDescriptor
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.hiscore.result
import meteor.ui.composables.preferences.*
import meteor.util.ImageUtil
import org.jetbrains.skiko.toBitmap
import java.awt.Color

class LootTrackerPluginPanel:PluginPanel() {

    @Composable
    override fun Header() {
    }

    @Composable
    override fun Content() {


        Column(modifier = Modifier.width(375.dp)) {
            LazyColumn(Modifier.width(350.dp).fillMaxHeight()) {

                items(items = multiMap.value.entrySet().distinct().toMutableStateList()) { map ->
                    Spacer(Modifier.height(10.dp))
                    Row(modifier = Modifier.width(350.dp).background(surface,RoundedCornerShape(4.dp))) {
                        Text(
                            map.key,
                            style = TextStyle(color = uiColor, fontSize = 24.sp),
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        Spacer(Modifier.width(30.dp))
                        priceMap.entrySet().forEach {
                            if (it.key == map.key) {
                                Text(
                                    it.value!!.sum().toString() + " gp",
                                    style = TextStyle(color = intColor, fontSize = 20.sp),
                                    modifier = Modifier.padding(top = 10.dp)
                                )
                            }
                        }
                    }
                    Spacer(Modifier.height(5.dp))
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 40.dp),
                        modifier = Modifier.width(350.dp).height(125.dp).background(surface, RoundedCornerShape(10.dp)).padding(5.dp),
                        contentPadding = PaddingValues(15.dp),
                        userScrollEnabled = false,
                    ) {
                            items(items = map.value!!.toList()) {

                                Card(backgroundColor = androidx.compose.ui.graphics.Color.DarkGray, shape = RoundedCornerShape(5.dp)) {
                                        Image(it?.asyncBufferedImage?.value!! .toComposeImageBitmap(), "")
                                }
                            }
                        }

                }
            }
        }
    }
}