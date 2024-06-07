package determent.determent_management.shared.root_decompose

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import determent.determent_management.shared.bottom_navigation.decompose.BottomNavigationComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked()
    fun onBackClicked(toIndex: Int)

    sealed class Child {
        class BottomNavigationChild(val component: BottomNavigationComponent) : Child()
    }
}