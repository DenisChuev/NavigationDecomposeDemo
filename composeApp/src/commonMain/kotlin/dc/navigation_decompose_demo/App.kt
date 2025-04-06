package dc.navigation_decompose_demo

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import navigation.RootComponent
import screens.ScreenA
import screens.ScreenB

@Composable
fun App(root: RootComponent, modifier: Modifier = Modifier) {
    MaterialTheme {
        val childStack by root.childStack.subscribeAsState()
        Children(
            stack = childStack,
            modifier = modifier
        ) { child ->
            when(val instance = child.instance) {
                is RootComponent.Child.ScreenA -> ScreenA(instance.component)
                is RootComponent.Child.ScreenB -> ScreenB(instance.component.text, instance.component)
            }
        }
    }
}