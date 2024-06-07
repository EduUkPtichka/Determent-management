package determent.edet_management_system.shared.root_decompose.ui_cmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import determent.edet_management_system.shared.bottom_navigation.ui_cmp.ContentScreenBottomNavigation
import determent.edet_management_system.shared.root_decompose.RootComponent

@Composable
fun ContentScreenRoot(
    component: RootComponent,
    modifier: Modifier = Modifier,
){
    Children(
        stack = component.stack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.BottomNavigationChild -> ContentScreenBottomNavigation(component = child.component)
        }
    }
}