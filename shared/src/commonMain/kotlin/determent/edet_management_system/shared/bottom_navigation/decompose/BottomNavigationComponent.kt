package determent.edet_management_system.shared.bottom_navigation.decompose

import com.arkivanov.decompose.Child
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface BottomNavigationComponent {

val stack: Value<ChildStack<*, Child>>

    fun onHomeClicked()
    fun onCatalogClicked()
    fun onMessengerClicked()

    sealed class Child() {
        data class
    }


}