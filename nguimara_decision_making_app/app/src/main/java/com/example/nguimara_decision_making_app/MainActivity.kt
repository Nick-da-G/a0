package com.example.nguimara_decision_making_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nguimara_decision_making_app.ui.theme.Nguimara_decision_making_appTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Nguimara_decision_making_appTheme {
                DecisionApp()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    AppText()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DecisionApp(){
    Nguimara_decision_making_appTheme{
        AppText()
    }
}

@Composable
fun AppText(modifier: Modifier = Modifier){
    var chance by remember { mutableStateOf( 0) }
    var result by remember { mutableStateOf( false ) }
    var clickCount by remember { mutableIntStateOf(0) }

    Text(
        text = "nguimara \n #1876288",
        modifier = Modifier.padding(top = 50.dp, start = 25.dp)
    )

if (clickCount > 0) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (result) {
            true -> Text(
                text = "Yes",
                color = Color.Green,
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 140.dp)
            )

            false -> Text(
                text = "No",
                color = Color.Red,
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 140.dp)

            )
        }
    }
}

    Column (
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Should We Go?",
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Clicks: $clickCount",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            lineHeight = 100.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Button(onClick = { chance = (1..2).random()
            clickCount++
            if (chance == 1){
                result = true
            } else {
                result = false
            }
        }) {
            Text(text = "Ok!")
        }
        Button(onClick = { chance = (1..4).random()
            clickCount++
            if (chance == 1){
                result = true
            } else {
                result = false
            }
        }) {
            Text(text = "Meh")
        }
        Button(onClick = { chance = (1..10).random()
            clickCount++
            if (chance == 1){
                result = true
            } else {
                result = false
            }
        }) {
            Text(text = "Nah")
        }
    }
}
