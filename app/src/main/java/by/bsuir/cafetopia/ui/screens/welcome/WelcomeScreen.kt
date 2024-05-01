package by.bsuir.cafetopia.ui.screens.welcome

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.bsuir.cafetopia.R
import by.bsuir.cafetopia.ui.components.FilledTextButton
import by.bsuir.cafetopia.ui.theme.CafetopiaTheme

@Composable
fun WelcomeScreen(
    onSignInMove: () -> Unit,
    onSignUpMove: () -> Unit,
    scrollState: ScrollState = rememberScrollState()
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            bitmap = ImageBitmap.imageResource(id = R.drawable.logo),
            contentDescription = "Logo",
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.size(200.dp)
        )

        Text(
            text = "Cafetopia",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Column(
            modifier = Modifier.padding(horizontal = 48.dp, vertical = 64.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FilledTextButton("Sign In", onSignInMove, Modifier.fillMaxWidth())
            FilledTextButton("Sign Up", onSignUpMove, Modifier.fillMaxWidth())
        }
    }
}

@Composable
@Preview(name = "Welcome")
private fun WelcomeScreenPreview() {
    CafetopiaTheme(darkTheme = false) {
        WelcomeScreen(
            onSignInMove = {},
            onSignUpMove = {}
        )
    }
}

