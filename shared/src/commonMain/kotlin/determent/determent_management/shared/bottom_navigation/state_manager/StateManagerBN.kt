package determent.determent_management.shared.bottom_navigation.state_manager

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import dev.icerock.moko.resources.compose.painterResource
import org.example.library.MR

sealed interface StateManagerBN {

    data class NavigationBarItemLogic(
        val onSelectedScreen: ()-> Unit,
        val isSelected: Boolean
    )  {

    }

    data class NavigationBarItemScreen(
        inline val title: String,
        inline val selectedIcon: @Composable () -> Painter,
        inline val unselectedIcon: @Composable () -> Painter,
        val onClickedScreen: ()-> Unit,
        val isSelected: Boolean,
    ) {
//        companion object {
//            val navigationBarItemResource = listOf(
//                NavigationBarItemResource(
//                    title = "Главная",
//                    selectedIcon = { ResourceBN.svg_home_selected() },
//                    unselectedIcon = { ResourceBN.svg_home_unselected() },
//                ),
//                NavigationBarItemResource(
//                    title = "Каталог",
//                    selectedIcon = { ResourceBN.svg_catalog_selected() },
//                    unselectedIcon = { ResourceBN.svg_catalog_unselected() },
//                ),
//                NavigationBarItemResource(
//                    title = "Сообщения",
//                    selectedIcon = { ResourceBN.svg_messenger_selected() },
//                    unselectedIcon = { ResourceBN.svg_messenger_unselected() },
//                )
//            )
//        }
    }

    object ResourceBN {
        @Composable
        inline fun svg_home_selected() = painterResource(MR.images.svg_home_selected)

        @Composable
        inline fun svg_home_unselected() = painterResource(MR.images.svg_home_unselected)

        @Composable
        inline fun svg_catalog_selected() = painterResource(MR.images.svg_catalog_selected)

        @Composable
        inline fun svg_catalog_unselected() = painterResource(MR.images.svg_catalog_unselected)

        @Composable
        inline fun svg_messenger_selected() = painterResource(MR.images.svg_messager_selected)

        @Composable
        inline fun svg_messenger_unselected() = painterResource(MR.images.svg_message_unselected)

    }
}

