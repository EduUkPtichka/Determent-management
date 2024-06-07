package determent.edet_management_system.shared.core_decompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import determent.edet_management_system.shared.root_decompose.ui_cmp.ContentScreenRoot
import determent.edet_management_system.shared.root_decompose.RootComponent
import platform.UIKit.UIViewController

fun rootViewController(root: RootComponent): UIViewController =
    ComposeUIViewController {
        ContentScreenRoot(
            component = root,
            modifier = Modifier.fillMaxSize()
        )
    }