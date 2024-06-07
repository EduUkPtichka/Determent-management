package determent.determent_management.shared.bottom_navigation.decompose

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import determent.determent_management.shared.catalog.decompose.CatalogComponent
import determent.determent_management.shared.home.decompose.HomeComponent
import determent.determent_management.shared.messenger.decompose.MessengerComponent

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