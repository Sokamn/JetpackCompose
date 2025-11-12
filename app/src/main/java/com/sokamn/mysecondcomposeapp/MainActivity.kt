package com.sokamn.mysecondcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.sokamn.mysecondcomposeapp.challenges.layout.MyExerciseConstraint
import com.sokamn.mysecondcomposeapp.components.MyButtons
import com.sokamn.mysecondcomposeapp.components.MyImage
import com.sokamn.mysecondcomposeapp.components.MyTextField
import com.sokamn.mysecondcomposeapp.components.MyTextFieldParent
import com.sokamn.mysecondcomposeapp.components.MyTexts
import com.sokamn.mysecondcomposeapp.components.layout.ConstraintBarrier
import com.sokamn.mysecondcomposeapp.components.layout.ConstraintChain
import com.sokamn.mysecondcomposeapp.components.layout.MyAdvancedConstraintLayout
import com.sokamn.mysecondcomposeapp.state.MyState
import com.sokamn.mysecondcomposeapp.ui.theme.MySecondComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MySecondComposeAppTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    MyImage(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    widthDp = 125,
    heightDp = 20,
    showSystemUi = true,
    device = Devices.PIXEL_7_PRO,
    showBackground = true
)
@Composable
fun GreetingPreview() {
    MySecondComposeAppTheme {
        Greeting("Android")
    }
}