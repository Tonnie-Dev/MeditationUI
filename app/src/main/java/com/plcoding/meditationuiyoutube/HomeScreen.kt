package com.plcoding.meditationuiyoutube

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.plcoding.meditationuiyoutube.ui.theme.DeepBlue

@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
                .fillMaxSize()
                .background(DeepBlue)
    ) {


        Column {
            GreetingSection()
        }
    }
}

@Composable
fun GreetingSection(name: String = "Tonnie") {

    Row(
        modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column() {
            Text(text = "Good Morning, $name", style = MaterialTheme.typography.h2)
            Text(text = "We wish you have a good day!", style = MaterialTheme.typography.body1)


        }

        IconButton(onClick = { /*TODO*/ }) {

            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.White
            )
        }
    }
}

val themes = listOf("Sweet Sleep", "Insomnia", "Depression")
