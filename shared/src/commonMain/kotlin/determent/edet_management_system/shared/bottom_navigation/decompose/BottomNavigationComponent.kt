package determent.edet_management_system.shared.bottom_navigation.decompose

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import determent.edet_management_system.shared.catalog.decompose.CatalogComponent
import determent.edet_management_system.shared.home.decompose.HomeComponent
import determent.edet_management_system.shared.messenger.decompose.MessengerComponent

interface BottomNavigationComponent {

    val childStack: Value<ChildStack<*, ChildBN>>

    fun onHomeClicked()
    fun onCatalogClicked()
    fun onMessengerClicked()

    sealed class ChildBN() {
        class HomeChildBN(val component: HomeComponent) : ChildBN()
        class CatalogChildBN(val component: CatalogComponent): ChildBN()
        class MessengerChildBN(val component: MessengerComponent): ChildBN()
    }
}