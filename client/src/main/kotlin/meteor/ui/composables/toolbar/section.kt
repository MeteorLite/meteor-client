package meteor.ui.composables.toolbar

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
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.Octicons
import compose.icons.octicons.ChevronLeft16
import meteor.Main

import meteor.ui.composables.uiColor



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
                        tint = uiColor
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
fun hider(
    modifier: Modifier = Modifier,
    expanded: MutableState<Boolean>,
    onExpandChanged: (Boolean)-> Unit,
    content: @Composable () -> Unit,

) {
    Column(
        modifier = modifier
            .fillMaxWidth()

    ) {
        onExpandChanged(expanded.value)
    }
    if (expanded.value) {
        content()
    }
}
@Composable
fun ExpandableToolbar(
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    onExpandChanged: (Boolean) -> Unit,
    expand: @Composable (RowScope.(modifier: Modifier) -> Unit)? = null,
    content: ()-> Unit,

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
                        tint = uiColor,
                        modifier = Modifier.clickable {      if (expanded) {
                            content.invoke()
                        } }
                    )
                }
            }

        }

    }
}

@Composable
fun Expandable2(
    modifier: Modifier = Modifier.background(Color.Transparent),
    expanded: Boolean = false,
    onExpandChanged: (Boolean) -> Unit,
    expand: @Composable (RowScope.(modifier: Modifier) -> Unit)? = null,
    contentAnimation: FiniteAnimationSpec<IntSize> = tween(
        durationMillis = 300,
        easing = LinearOutSlowInEasing
    ),
    expandAnimation: State<Float> = animateFloatAsState(
        targetValue = if (expanded) 360f else 0f
    )
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(animationSpec = contentAnimation).background(Color.Transparent).height(35.dp)
    ) {

        Row(
            modifier = Modifier.clickable { onExpandChanged(!expanded) }.background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically,
        ) {

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
                        modifier = Modifier.height(35.dp),
                        imageVector = Octicons.ChevronLeft16,
                        contentDescription = "Drop-Down Arrow",
                        tint = uiColor
                    )
                }
            }
        }

    }
}
@Composable
@Preview
fun hideItem(modifier: Modifier = Modifier, bool: Boolean ,content: @Composable () -> Unit) {
    var expanded = remember { mutableStateOf(bool) }

    hider(
        modifier = Modifier.width(35.dp).height(35.dp),
        expanded = expanded,
        onExpandChanged = {
            expanded.value = it
        },
        content = {
            Column {
                content.invoke()
            }
        },
    )
}
@Composable
@Preview
fun sectionItem(modifier: Modifier = Modifier, content: ()->Unit) {
    val expanded = remember { mutableStateOf(false) }

    Expandable2(
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
fun unhide(bool : Boolean, content: @Composable () -> Unit) {

    val unhide = mutableStateOf(!bool)
    Expandable(
        modifier = Modifier,
        expanded = unhide.value,
        onExpandChanged = {
            unhide.value = it
        },

        content = {
            Column {
                content.invoke()
            }
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
                color = uiColor,
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


@Composable
@Preview
fun Expandable(content: @Composable () -> Unit,stuff: @Composable () -> Unit) {
    val expanded = remember { mutableStateOf(false) }

    Expandable(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        expanded = expanded.value,
        onExpandChanged = {

        },
        title = {
            Text(
                modifier = Modifier
                    .weight(8f),
                text = "Title",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1
            )
        },
        content = {
            stuff.invoke()
        },
    )
}