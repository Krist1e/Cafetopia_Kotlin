package by.bsuir.cafetopia.ui.components

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import by.bsuir.cafetopia.model.Cafe
import by.bsuir.cafetopia.utils.mockCafe

@Composable
@OptIn(ExperimentalMaterial3AdaptiveApi::class)
fun CafeListScreen(
    cafes: List<Cafe>,
    selectedCafe: Cafe?,
    onSelectCafe: (Cafe) -> Unit,
    onFavoriteChange: (Cafe) -> Unit,
    modifier: Modifier = Modifier,
    listState: LazyListState = rememberLazyListState()
) {
    val navigator = rememberListDetailPaneScaffoldNavigator()

    BackHandler(navigator.canNavigateBack()) {
        navigator.navigateBack()
    }

    ListDetailPaneScaffold(
        directive = navigator.scaffoldDirective,
        value = navigator.scaffoldValue,
        listPane = {
            AnimatedPane {
                CafeListView(
                    cafes = cafes,
                    listState = listState
                ) { cafe ->
                    CafeCardView(
                        cafe = cafe,
                        onClick = {
                            onSelectCafe(cafe)
                            navigator.navigateTo(ListDetailPaneScaffoldRole.Detail)
                        },
                        onFavoriteChange = { onFavoriteChange(cafe) }
                    )
                }
            }
        },
        detailPane = {
            AnimatedPane {
                selectedCafe?.let { cafe ->
                    CafeDetailsView(
                        cafe = cafe,
                        onFavoriteChange = { onFavoriteChange(cafe) }
                    )
                }
            }
        },
        modifier = modifier
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(name = "CafeListScreen", showBackground = true)
@Composable
fun PreviewCafeListScreen() {
    val cafes = (0..<10).map { mockCafe() }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CafeListScreen(
            cafes = cafes,
            selectedCafe = cafes.first(),
            onSelectCafe = {},
            onFavoriteChange = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}