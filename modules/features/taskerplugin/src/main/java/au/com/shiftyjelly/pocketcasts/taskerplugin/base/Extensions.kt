package au.com.shiftyjelly.pocketcasts.taskerplugin.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

val String?.nullIfEmpty get() = if (isNullOrEmpty()) null else this
fun <T> tryOrNull(handleError: ((Throwable) -> T?)? = null, block: () -> T?): T? = try {
    block()
} catch (t: Throwable) {
    handleError?.invoke(t)
}

val screenSize
    @Composable
    get() :DpSize {
        val configuration = LocalConfiguration.current

        val screenHeight = configuration.screenHeightDp.dp
        val screenWidth = configuration.screenWidthDp.dp
        return DpSize(width = screenWidth, height = screenHeight)
    }