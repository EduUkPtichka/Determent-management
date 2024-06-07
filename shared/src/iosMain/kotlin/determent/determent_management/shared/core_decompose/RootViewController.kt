package determent.determent_management.shared.core_decompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import determent.determent_management.shared.root_decompose.ui_cmp.ContentScreenRoot
import determent.determent_management.shared.root_decompose.RootComponent
import platform.UIKit.UIViewController

fun rootViewController(root: RootComponent): UIViewController =
    ComposeUIViewController {
        ContentScreenRoot(
            component = root,
            modifier = Modifier.fillMaxSize()
        )
    }