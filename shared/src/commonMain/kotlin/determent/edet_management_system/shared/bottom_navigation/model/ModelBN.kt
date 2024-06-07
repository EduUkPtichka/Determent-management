package determent.edet_management_system.shared.bottom_navigation.model


data class NavigationBarItemLogic(
    val onSelectedScreen: () -> Unit,
    val isSelected: Boolean
)
