package determent.edet_management_system.shared.bottom_navigation.ui_cmp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import determent.edet_management_system.shared.bottom_navigation.decompose.BottomNavigationComponent
import determent.edet_management_system.shared.bottom_navigation.state_manager.StateManagerBN.NavigationBarItemScreen
import determent.edet_management_system.shared.bottom_navigation.state_manager.StateManagerBN.ResourceBN.svg_catalog_selected
import determent.edet_management_system.shared.bottom_navigation.state_manager.StateManagerBN.ResourceBN.svg_catalog_unselected
import determent.edet_management_system.shared.bottom_navigation.state_manager.StateManagerBN.ResourceBN.svg_home_selected
import determent.edet_management_system.shared.bottom_navigation.state_manager.StateManagerBN.ResourceBN.svg_home_unselected
import determent.edet_management_system.shared.bottom_navigation.state_manager.StateManagerBN.ResourceBN.svg_messenger_selected
import determent.edet_management_system.shared.bottom_navigation.state_manager.StateManagerBN.ResourceBN.svg_messenger_unselected
import determent.edet_management_system.shared.catalog.ui_cmp.ContentScreenCatalog
import determent.edet_management_system.shared.home.ui_cmp.ContentScreenHome
import determent.edet_management_system.shared.messenger.ui_cmp.ContentScreenMessenger

@Composable
fun ContentScreenBottomNavigation(
    component: BottomNavigationComponent,
    modifier: Modifier = Modifier,
) {

    var selectedItem by remember { mutableIntStateOf(0) }

    val navigationBarItemScreen by remember {
        mutableStateOf(
            listOf(
                NavigationBarItemScreen(
                    title = "Главная",
                    selectedIcon = { svg_home_selected() },
                    unselectedIcon = { svg_home_unselected() },
                    onClickedScreen = component::onHomeClicked,
                    isSelected = false
                ),
                NavigationBarItemScreen(
                    title = "Каталог",
                    selectedIcon = { svg_catalog_selected() },
                    unselectedIcon = { svg_catalog_unselected() },
                    onClickedScreen = component::onCatalogClicked,
                    isSelected = false
                ),
                NavigationBarItemScreen(
                    title = "Сообщения",
                    selectedIcon = { svg_messenger_selected() },
                    unselectedIcon = { svg_messenger_unselected() },
                    onClickedScreen = component::onMessengerClicked,
                    isSelected = false
                )
            )
        )
    }

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth(),
            ) {
                navigationBarItemScreen.forEachIndexed { index, screens ->
                    NavigationBarItem(
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            screens.onClickedScreen()
                        },

                        icon = {
                            Icon(
                                painter = if (selectedItem == index) screens.selectedIcon() else screens.unselectedIcon(),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(30.dp)
                            )
                        },

                        label = {
                            Text(
                                text = screens.title,
                                fontSize = 10.sp
                            )
                        }

                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.padding(it)
            ) {
                Children(
                    stack = component.childStack,
                    modifier = modifier,
                    animation = stackAnimation(fade() + scale()),
                ) {
                    when (val childStack = it.instance) {
                        is BottomNavigationComponent.ChildBN.HomeChildBN -> ContentScreenHome(component = childStack.component)
                        is BottomNavigationComponent.ChildBN.CatalogChildBN -> ContentScreenCatalog(content = childStack.component)
                        is BottomNavigationComponent.ChildBN.MessengerChildBN -> ContentScreenMessenger(component = childStack.component)
                    }
                }
            }

        }
    )
}