package determent.edet_management_system.shared.home.primary_slide_banner.ui_cmp.primary_content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import org.example.library.MR

@Composable
fun PrimaryNewAddItem(

) {
    val composableHeight = 400.dp
    var composableWidthPx by remember { mutableStateOf(1000f) }
    val composableWidth = with(LocalDensity.current) { composableWidthPx.toDp() }
    val draggableState = rememberDraggableState(onDelta = {
        composableWidthPx += it
    })
    val iconSize = remember { 400.dp }


    Row(
        modifier = Modifier
            .width(composableWidth)
            .height(composableHeight)
            .draggable(draggableState, Orientation.Horizontal)
            .background(Color.Red)
            .clipToBounds()

    ) {
        Image(
            modifier = Modifier
                .requiredSize(iconSize)
                .offset(
                    maxOf(0.dp, (iconSize - composableWidth) / 2)
                )
            ,
            painter = painterResource(MR.images.png_primaryA),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

    }
}

