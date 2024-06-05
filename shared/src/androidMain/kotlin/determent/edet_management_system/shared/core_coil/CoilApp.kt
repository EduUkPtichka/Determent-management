package determent.edet_management_system.shared.core_coil

import androidx.compose.runtime.Composable
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import determent.edet_management_system.shared.core_coil.getAsyncImageLoader

@OptIn(ExperimentalCoilApi::class)
@Composable
internal fun CoilApp() {
    setSingletonImageLoaderFactory { context ->
        getAsyncImageLoader(context)
    }
}