package determent.edet_management_system.shared.messenger.decompose

import com.arkivanov.decompose.ComponentContext

class DefaultMessengerComponent(
    componentContext: ComponentContext,
) : MessengerComponent, ComponentContext by componentContext {
}