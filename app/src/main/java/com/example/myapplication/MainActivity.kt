package com.example.myapplication


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.myapplication.ui.theme.MyApplicationTheme
import me.onebone.toolbar.*


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen()
                }
            }
        }
    }


    @Composable
    fun HomeScreen(){

        val state = rememberCollapsingToolbarScaffoldState()

        CollapsingToolbarScaffold(
            modifier = Modifier.fillMaxSize(),
            toolbarModifier = Modifier.background(MaterialTheme.colors.primary),
            state = state,
            toolbar = {
                Spacer(modifier = Modifier.fillMaxWidth().height(60.dp))
                Box{
                    Image(
                        painter = painterResource(id = R.drawable.image),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth().height(200.dp)
                            .graphicsLayer {
                                alpha = state.toolbarState.progress
                            }
                    )
                    Text(
                        text = "Title",
                        modifier = Modifier.padding(20.dp),
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.W500
                    )
                }
            },

            scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
            body = {
                LazyColumn{
                    items(20){ index->
                        Text(
                            "Item ${index + 1}",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        )
                    }
                }
            }
        )

    }


}