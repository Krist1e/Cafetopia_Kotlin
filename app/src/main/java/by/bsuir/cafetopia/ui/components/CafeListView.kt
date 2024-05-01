package by.bsuir.cafetopia.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.bsuir.cafetopia.model.Cafe
import by.bsuir.cafetopia.utils.mockCafe

@Composable
fun CafeListView(
    cafes: List<Cafe>,
    modifier: Modifier = Modifier,
    listState: LazyListState = rememberLazyListState(),
    item: @Composable (Cafe) -> Unit
) {
    LazyColumn(
        state = listState,
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(cafes) { cafe ->
            item(cafe)
        }
    }
}

@Preview(name = "CafeListView", showBackground = true)
@Composable
private fun PreviewCafeListView() {
    CafeListView(cafes = (1..10).map { mockCafe() }) {
        Text(text = it.name)
    }
}