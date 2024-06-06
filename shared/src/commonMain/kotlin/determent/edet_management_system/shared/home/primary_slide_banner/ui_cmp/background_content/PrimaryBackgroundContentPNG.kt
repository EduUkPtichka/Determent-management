package determent.edet_management_system.shared.home.primary_slide_banner.ui_cmp.background_content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.haze

/**
 * Android API 31 and higher
 */
@Composable
fun PrimaryBackgroundContentPNG(
    imagePng: Painter,
    hazeState: HazeState,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .height(500.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = imagePng,
            contentDescription = null,
            modifier = Modifier
                .haze(
                    hazeState,
                    HazeStyle(
                        tint = Color.White.copy(alpha = 0.1f),
                        blurRadius = 20.dp,
                        noiseFactor = 0.01f
                    )
                )
                .fillMaxSize()
            ,
            contentScale = ContentScale.Crop
        )

        content()

    }
}