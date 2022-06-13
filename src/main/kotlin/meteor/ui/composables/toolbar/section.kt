package meteor.ui.composables.toolbar

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
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

@ExperimentalMaterialApi
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
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
        }
        if (expanded) {
            content()
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun ExpandablePreview() {
    val expanded = remember { mutableStateOf(false) }

    Expandable(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        expanded = expanded.value,
        onExpandChanged = {
            expanded.value = it
        },
        leading = {
            Icon(
                modifier = Modifier,
                imageVector = Icons.Filled.Menu,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(20.dp))
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
            Column {
                repeat(10) {
                    Text(text = "Item $it")
                }
            }
        },
    )
}

@ExperimentalMaterialApi
@Composable
@Preview
fun ExpandableWithoutIconPreview() {
    val expanded = remember { mutableStateOf(false) }

    Expandable(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        expanded = expanded.value,
        onExpandChanged = {
            expanded.value = it
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
            Column {
                repeat(10) {
                    Text(text = "Item $it")
                }
            }
        },
    )
}