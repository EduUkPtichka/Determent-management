package determent.edet_management_system.shared.bottom_navigation.decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import determent.edet_management_system.shared.bottom_navigation.decompose.BottomNavigationComponent.ChildBN
import determent.edet_management_system.shared.catalog.decompose.DefaultCatalogComponent
import determent.edet_management_system.shared.home.decompose.DefaultHomeComponent
import determent.edet_management_system.shared.messenger.decompose.DefaultMessengerComponent
import kotlinx.serialization.Serializable

class DefaultBottomNavigationComponent(
    component: ComponentContext
) : BottomNavigationComponent, ComponentContext by component {

    private val navigation = StackNavigation<Config>()

    override val childStack: Value<ChildStack<*, ChildBN>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Home,
            childFactory = ::child
        )

    private fun child(config: Config, componentContext: ComponentContext): ChildBN =
        when (config) {
            is Config.Home -> ChildBN.HomeChildBN(DefaultHomeComponent(componentContext))
            Config.Catalog -> ChildBN.CatalogChildBN(DefaultCatalogComponent(componentContext))
            Config.Messenger -> ChildBN.MessengerChildBN(DefaultMessengerComponent(componentContext))
        }

    override fun onHomeClicked() {
        navigation.bringToFront(Config.Home)
    }

    override fun onCatalogClicked() {
        navigation.bringToFront(Config.Catalog)
    }

    override fun onMessengerClicked() {
        navigation.bringToFront(Config.Catalog)
    }

    @Serializable
    private sealed interface Config {

        @Serializable
        data object Home : Config

        @Serializable
        data object Catalog : Config

        @Serializable
        data object Messenger : Config

    }


}