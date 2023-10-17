package meteor.ui.composables.nodes

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.Octicons
import compose.icons.octicons.ChevronLeft16
import compose.icons.octicons.ChevronRight16

import meteor.ui.composables.preferences.darkLightMode
import meteor.ui.composables.preferences.darkThemeColors
import meteor.ui.composables.preferences.lightThemeColors
import meteor.ui.composables.preferences.uiColor
import orsc.Main


@Composable
fun Expandable(
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    onExpandChanged: (Boolean) -> Unit,
    leading: @Composable (RowScope.() -> Unit)? = null,
    title: @Composable (RowScope.() -> Unit)? = null,
    expand: @Composable (RowScope.(modifier: Modifier) -> Unit)? = null,
    content: @Composable () -> Unit,
    contentAnimation: FiniteAnimationSpec<IntSize> = tween(
        durationMillis = 300,
        easing = LinearOutSlowInEasing
    ),
    expandAnimation: State<Float> = animateFloatAsState(
        targetValue = if (expanded) 180f else 0f
    )
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(animationSpec = contentAnimation)
    ) {
        Row(
            modifier = Modifier.clickable { onExpandChanged(!expanded) },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            leading?.let {
                leading()
            }
            title?.let {
                title()
            }
            expand?.let {
                expand(
                    Modifier.rotate(expandAnimation.value)
                )
            } ?: run {
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .rotate(expandAnimation.value),
                    onClick = {
                        onExpandChanged(!expanded)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow",
                        tint = uiColor.value
                    )
                }
            }
        }
        if (expanded) {
            content()
        }
    }
}


@Composable
fun expandToolbar(
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    onExpandChanged: (Boolean) -> Unit,
) {
        Column(
            modifier = Modifier.background(if (darkLightMode.value) darkThemeColors.background else lightThemeColors.background).clickable { onExpandChanged(!expanded) },

        ) {

                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    onClick = {
                        onExpandChanged(!expanded)
                    }
                ) {

                    Icon(
                        modifier = Modifier.height(35.dp),
                        imageVector = if (expanded) Octicons.ChevronLeft16 else Octicons.ChevronRight16,
                        contentDescription = "Drop-Down Arrow",
                        tint = uiColor.value
                    )
                }
            }
        }


@Composable
@Preview
fun sectionItem(modifier: Modifier = Modifier, content: ()->Unit) {
    val expanded = remember { mutableStateOf(false) }

    expandToolbar(
        modifier = Modifier.width(15.dp).height(35.dp),
        expanded = expanded.value,
        onExpandChanged = {
            expanded.value = it
            content.invoke()
        },
    )
}

@Composable
@Preview
fun sectionItem(title:String, content: @Composable () -> Unit) {
    val expanded = remember { mutableStateOf(false) }
    val size = remember {
        mutableStateOf(Main.meteorConfig.pluginListTextSize())
    }
    Expandable(
        modifier = Modifier,
        expanded = expanded.value,
        onExpandChanged = {
            expanded.value = it
        },

        title = {
            Text(
                modifier = Modifier
                    .weight(8f).padding(start = 20.dp),
                text = title,
                color = uiColor.value,
                fontSize = size.value.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1
            )
        },
        content = {
            Column {
                content.invoke()
            }
        },
    )
}

