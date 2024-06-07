package determent.determent_management.shared.root_decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.value.Value
import determent.determent_management.shared.bottom_navigation.decompose.DefaultBottomNavigationComponent
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val nav = StackNavigation<Config>()

    private val _stack =
        childStack(
            source = nav,
            serializer = Config.serializer(),
            initialConfiguration = Config.BottomNavigation,
            handleBackButton = true,
            childFactory = ::child,
        )

    override val stack: Value<ChildStack<*, RootComponent.Child>> = _stack

    init {

    }


    private fun child(config: Config, componentContext: ComponentContext): RootComponent.Child =
        when (config) {
            is Config.BottomNavigation -> RootComponent.Child.BottomNavigationChild(
                DefaultBottomNavigationComponent(
                    component = componentContext
                )
            )
        }

    override fun onBackClicked() {
        nav.pop()
    }

    override fun onBackClicked(toIndex: Int) {
        nav.popTo(index = toIndex)
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object BottomNavigation : Config
    }


}