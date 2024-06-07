package determent.edet_management_system.shared.catalog.decompose

import com.arkivanov.decompose.ComponentContext

class DefaultCatalogComponent(
    componentContext: ComponentContext
) : CatalogComponent, ComponentContext by componentContext {
}