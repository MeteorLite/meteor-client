package meteor.ui.composables.toolbar

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import meteor.ui.composables.preferences.background
import meteor.ui.composables.preferences.surface
import meteor.ui.composables.preferences.uiColor

class ToolbarButton(
    var name: String, var icon: ImageVector?, var imageResource: String? = null, var iconColor: Color = uiColor.value,
    var backgroundColor: MutableState<Color> = mutableStateOf(background),
    var description: String? = "", var alignment: Alignment = Alignment.TopCenter,
    var bottom: Boolean = false, var onClick: () -> Unit,
    var position: Int = 999
) {

    //Required for java access
    constructor(
        name: String, imageResource: String,
        description: String, alignment: Alignment,
        bottom: Boolean, onClick: () -> Unit
    ) :
            this(
                name,
                icon = null,
                imageResource = imageResource,
                description = description,
                alignment = alignment,
                bottom = bottom,
                onClick = onClick,
                iconColor = uiColor.value
            )

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun CreateComponent() {
        TooltipArea(
            modifier = Modifier.background(
                shape = RoundedCornerShape(3.dp), color = surface
            ), tooltipPlacement = TooltipPlacement.ComponentRect(offset = DpOffset(x = -10.dp, y = 0.dp)), tooltip = {
                Box(modifier = Modifier.sizeIn(minWidth = 60.dp, minHeight = 20.dp, maxWidth = 60.dp, maxHeight = 200.dp)
                    .background(color = surface, RoundedCornerShape(5.dp)), contentAlignment = Alignment.Center) {
                    Text(
                        description.toString(),
                        style = TextStyle
                            (
                            color = uiColor.value,
                            textAlign = TextAlign.Center,
                            letterSpacing = 2.sp,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium
                            ),
                        modifier = Modifier.padding(vertical = 5.dp)
                        )
                }

            }) {
            Box(
                modifier = Modifier.padding(vertical = 3.dp).clip(RoundedCornerShape(size = 7.dp)).background(mutableStateOf(background).value).width(35.dp)
                    .height(35.dp),
                contentAlignment = alignment,
            ) {
                IconButton(
                    onClick = onClick,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    if (icon != null)
                        Icon(
                            icon!!,
                            contentDescription = description,
                            tint = iconColor,
                        )
                    else if (imageResource != null)
                        Image(
                            painter = painterResource(imageResource!!),
                            contentDescription = description
                        )
                }
            }
            Spacer(
                Modifier.height(10.dp)
                    .background(backgroundColor.value)
            )
        }
    }
}