package by.bsuir.cafetopia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import by.bsuir.cafetopia.ui.app.CafetopiaApp
import by.bsuir.cafetopia.ui.theme.CafetopiaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContent {
            CafetopiaTheme {
                CafetopiaApp()
            }
        }
    }
}