package com.chrisprime.sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chrisprime.sandbox.challenges.IncludedHealth
import com.chrisprime.sandbox.ui.theme.SandboxTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SandboxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    RickAndMortyApiListGraphQl(modifier = Modifier.fillMaxWidth())
                }
            }
        }

        IncludedHealth.runChallenges()
    }
}

@Composable
fun RickAndMortyApiListGraphQl(
    apiBaseUrl: String = "https://rickandmortyapi.com/graphql",
    modifier: Modifier,
) {

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SandboxTheme {
//        Greeting("Android")
        RickAndMortyApiListGraphQl(modifier = Modifier.fillMaxWidth())
    }
}