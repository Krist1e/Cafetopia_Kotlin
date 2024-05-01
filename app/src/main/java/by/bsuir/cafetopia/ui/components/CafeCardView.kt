package by.bsuir.cafetopia.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.bsuir.cafetopia.model.Cafe
import by.bsuir.cafetopia.utils.mockCafe
import coil.compose.AsyncImage

@Composable
fun CafeCardView(
    cafe: Cafe,
    onClick: () -> Unit,
    onFavoriteChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        onClick = onClick,
        modifier = modifier.height(280.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            AsyncImage(
                model = cafe.image,
                contentDescription = "cover",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(color = Color.Gray, shape = MaterialTheme.shapes.medium)
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(MaterialTheme.shapes.medium)
            )

            Column(
                modifier = modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = cafe.name,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    modifier = modifier.fillMaxWidth()
                )

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = modifier
                            .fillMaxHeight()
                            .weight(0.8f),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = cafe.address,
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            cafe.tags.forEach { tag ->
                                Tag(
                                    text = tag,
                                    modifier = Modifier.padding(4.dp)
                                )
                            }
                        }
                    }

                    FavoriteButton(
                        isFavorite = cafe.isFavorite,
                        onFavoriteChange = onFavoriteChange,
                        modifier = Modifier.weight(0.2f)
                    )
                }
            }
        }
    }
}

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onFavoriteChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = { onFavoriteChange() },
        modifier = modifier
    ) {
        Icon(
            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
            contentDescription = "Favorite"
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(name = "CafeCard", showBackground = true)
fun PreviewCafeCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        CafeCardView(cafe = mockCafe(), onClick = {}, onFavoriteChange = {})
    }
}