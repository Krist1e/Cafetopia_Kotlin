package com.example.cafetopia
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafetopia.ui.theme.Orange

@Composable
fun WelcomeActivity(onSignInClick: () -> Unit, onSignUpClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Orange),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LogoAndTitle()
        Spacer(modifier = Modifier.height(32.dp))
        SignInButton(onSignInClick = onSignInClick)
        Spacer(modifier = Modifier.height(16.dp))
        SignUpButton(onSignUpClick = onSignUpClick)
    }
}

@Composable
fun LogoAndTitle() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Cafetopia",
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}

@Composable
fun SignInButton(onSignInClick: () -> Unit) {
    Button(
        onClick = { onSignInClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        Text(text = "Sign in")
    }
}

@Composable
fun SignUpButton(onSignUpClick: () -> Unit) {
    Button(
        onClick = { onSignUpClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        Text(text = "Sign up")
    }
}

@Preview
@Composable
fun WelcomeActivityPreview() {
    WelcomeActivity({}, {})
}