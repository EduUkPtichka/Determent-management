package determent.determent_management.shared.home.decompose

import com.arkivanov.decompose.ComponentContext

class DefaultHomeComponent(
    component: ComponentContext
): HomeComponent, ComponentContext by component{

}