package determent.edet_management_system.shared.home.decompose

import com.arkivanov.decompose.ComponentContext

class DefaultHomeComponent(
    component: ComponentContext
): HomeComponent, ComponentContext by component{

}