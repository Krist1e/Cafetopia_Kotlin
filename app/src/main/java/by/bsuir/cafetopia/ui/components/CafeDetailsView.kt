package by.bsuir.cafetopia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.bsuir.cafetopia.model.Cafe
import by.bsuir.cafetopia.utils.mockCafe
import coil.compose.AsyncImage

@Composable
fun CafeDetailsView(
    cafe: Cafe,
    onFavoriteChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            AsyncImage(
                model = cafe.image,
                contentDescription = "cover",
                modifier = Modifier
                    .background(color = Color.Gray, shape = MaterialTheme.shapes.medium)
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )
        }

        item {
            TitleSectionView(
                cafe = cafe,
                onFavoriteChange = onFavoriteChange
            )
        }

        item {
            InformationSectionView(cafe)
        }

        item {
            DescriptionSectionView(cafe)
        }

        item {
            ImagesSectionView(cafe)
        }
    }
}

@Composable
private fun TitleSectionView(
    cafe: Cafe,
    onFavoriteChange: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
    ) {
        Text(
            text = cafe.name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.weight(0.8f)
        )

        FavoriteButton(
            isFavorite = cafe.isFavorite,
            onFavoriteChange = onFavoriteChange,
            modifier = Modifier.weight(0.2f)
        )
    }
}

@Composable
private fun InformationSectionView(cafe: Cafe) {
    HorizontalDivider()

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Text(
            text = "Information",
            style = MaterialTheme.typography.titleMedium,
        )

        CafeInformationView(cafe = cafe)
    }
}

@Composable
private fun CafeInformationView(cafe: Cafe) {
    Column {
        InfoRowView(
            title = "Address",
            value = cafe.address
        )
        InfoRowView(
            title = "Tags",
            value = cafe.tags.joinToString()
        )
        InfoRowView(
            title = "Options",
            value = cafe.options.joinToString()
        )
        InfoRowView(
            title = "Phone",
            value = cafe.phone
        )
        InfoRowView(
            title = "Email",
            value = cafe.email
        )
        InfoRowView(
            title = "Website",
            value = cafe.website
        )
        InfoRowView(
            title = "Working hours",
            value = "${cafe.openHours} - ${cafe.closeHours}"
        )
    }
}

@Composable
private fun DescriptionSectionView(cafe: Cafe) {
    HorizontalDivider(
        modifier = Modifier.padding(top = 16.dp)
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Text(
            text = "Description",
            style = MaterialTheme.typography.titleMedium,
        )

        Text(
            text = cafe.description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun ImagesSectionView(cafe: Cafe) {
    HorizontalDivider(
        modifier = Modifier.padding(top = 16.dp)
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Text(
            text = "Images",
            style = MaterialTheme.typography.titleMedium,
        )

        ImagesView(cafe = cafe)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ImagesView(cafe: Cafe) {
    val carouselState = rememberCarouselState(itemCount = { cafe.images.size })

    HorizontalMultiBrowseCarousel(
        state = carouselState,
        preferredItemWidth = 384.dp,
        modifier = Modifier.height(216.dp),
        itemSpacing = 4.dp
    ) {
        AsyncImage(
            model = cafe.images[it],
            contentDescription = "screenshot",
            modifier = Modifier
                .background(color = Color.Gray, shape = MaterialTheme.shapes.medium)
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(name = "CafeDetailsView", showBackground = true)
@Composable
private fun PreviewCafeDetailsView() {
    CafeDetailsView(cafe = mockCafe(), onFavoriteChange = {})
}