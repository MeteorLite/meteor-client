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
import androidx.compose.ui.Alignment
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


        Column(modifier = Modifier.width(300.dp)) {
            LazyColumn(Modifier.width(275.dp).fillMaxHeight()) {

                items(items = multiMap.value.entrySet().distinct().toMutableStateList()) { map ->
                    Spacer(Modifier.height(20.dp))
                    Row(modifier = Modifier.offset(x = 10.dp).width(275.dp).background(surface,RoundedCornerShape(4.dp)), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
                        Text(
                            map.key,
                            style = TextStyle(color = uiColor.value, fontSize = 15.sp),

                        )
                        Spacer(Modifier.width(30.dp))
                        priceMap.entrySet().forEach {
                            if (it.key == map.key) {
                                Text(
                                    it.value!!.sum().toString() + " gp",
                                    style = TextStyle(color = secondColor.value, fontSize = 15.sp),

                                )
                            }
                        }
                    }
                    Spacer(Modifier.height(5.dp))
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 50.dp),
                        modifier = Modifier.offset(x = 10.dp).width(275.dp).height(400.dp).background(surface, RoundedCornerShape(10.dp)),
                        userScrollEnabled = false,
                    ) {
                            items(items = map.value!!.toList()) {

                                Card(backgroundColor = androidx.compose.ui.graphics.Color.DarkGray, shape = RoundedCornerShape(5.dp), modifier = Modifier.size(30.dp).padding(2.dp)) {
                                        Image(it?.asyncBufferedImage?.value!! .toComposeImageBitmap(), "")
                                }
                            }
                        }

                }
            }
        }
    }
}