package determent.determent_management.shared.catalog.decompose

import com.arkivanov.decompose.ComponentContext

class DefaultCatalogComponent(
    componentContext: ComponentContext
) : CatalogComponent, ComponentContext by componentContext {
}