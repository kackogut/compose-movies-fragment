package com.example.movies_showcase

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.movies_showcase.databinding.ActivityMainBinding
import com.example.movies_showcase.ui.theme.MoviesShowcaseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesShowcaseTheme {
                AndroidViewBinding(ActivityMainBinding::inflate)
            }
        }
    }
}
