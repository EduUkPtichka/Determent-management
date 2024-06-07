package determent.determent_management.shared.messenger.decompose

import com.arkivanov.decompose.ComponentContext

class DefaultMessengerComponent(
    componentContext: ComponentContext,
) : MessengerComponent, ComponentContext by componentContext {
}