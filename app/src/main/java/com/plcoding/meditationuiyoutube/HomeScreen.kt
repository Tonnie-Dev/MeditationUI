package com.plcoding.meditationuiyoutube

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.plcoding.meditationuiyoutube.ui.theme.*

@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
                .fillMaxSize()
                .background(DeepBlue)
    ) {


        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression", "Rejection"))
            CurrentMeditation()
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


@Composable
fun ChipSection(chips: List<String>) {

    var selectedChipIndex by remember { mutableStateOf(0) }

    LazyRow {

        /*  items(chips.size){ i->
              selectedChipIndex+1
              Surface(modifier = Modifier.padding(5.dp), shape = RoundedCornerShape(8.dp), elevation = 8.dp) {

                  Text(text = chips[i], Modifier.padding(12.dp))
              }
          }*/

        items(chips.size) { i ->


            Box(
                modifier = Modifier
                        .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                        .clickable { selectedChipIndex = i }
                        .clip(RoundedCornerShape(10.dp))
                        .background(if (selectedChipIndex == i) ButtonBlue else DarkerButtonBlue)
                        .padding(15.dp)


            ) {


                Text(text = chips[i], color = TextWhite)
            }
        }

    }


}

@Composable
fun CurrentMeditation() {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(LightRed)
                .padding(vertical = 20.dp, horizontal = 15.dp)
    ) {
        Column() {
            Text(text = "Daily Thought", style = MaterialTheme.typography.h2)
            Text(
                text = "Meditation • 3-10 min",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }

        Box(
            modifier = Modifier
                   
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }

}
