package determent.determent_management.shared.bottom_navigation.model


data class NavigationBarItemLogic(
    val onSelectedScreen: () -> Unit,
    val isSelected: Boolean
)
