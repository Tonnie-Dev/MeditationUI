package com.plcoding.meditationuiyoutube

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
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
                modifier = Modifier.size(24.dp)
            )
        }
    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection(features: List<Feature>) {
    Column(Modifier.fillMaxSize()) {

        Text(
            text = "Featured", style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight(),
            content = {


                items(features.size) {}
            })

    }
}


@Composable
fun FeatureItem(feature: Feature) {


    BoxWithConstraints(
        modifier = Modifier
                .padding(8.dp)
                .aspectRatio(1f) // forces the box to be a square where h==w
                .clip(RoundedCornerShape(10.dp))
                .background(feature.darkColor)
    ) {

        val h = constraints.maxHeight
        val w = constraints.maxWidth

        //define medium colored path

        val mediumColoredPoint1 = Offset(0f, h * .3f)
        val mediumColoredPoint2 = Offset(w * .1f, h * .6f)
        val mediumColoredPoint3 = Offset(w * .4f, h * .2f)
        val mediumColoredPoint4 = Offset(w * .75f, h * .75f)
        val mediumColoredPoint5 = Offset(w * 1.3f, -h.toFloat())

        val mediumColoredPath = Path().apply {

            //move to first coordinate
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)

            //draw line to connect to the 2nd point and curve it

            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            //draw normal points making a path that we can then fill with  color

            lineTo(w + 100f, h + 100f)
            lineTo(-100f, h + 100f)
            close()

        }


        //light colored path
        val lightPoint1 = Offset(0f, h * .35f)
        val lightPoint2 = Offset(w * .1f, h * .4f)
        val lightPoint3 = Offset(w * .3f, h * .35f)
        val lightPoint4 = Offset(w * .65f, h.toFloat())
        val lightPoint5 = Offset(w * 1.4f, -h.toFloat() / 3f)

        val lightColoredPath = Path().apply {

            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)


            //draw normal points making a path that we can then fill with  color
            lineTo(w + 100f, h + 100f)
            lineTo(-100f, h + 100f)
            close()
        }

        //draw the paths using canvas

        Canvas(modifier = Modifier.fillMaxSize(), onDraw = {

            drawPath(mediumColoredPath, color = feature.mediumColor)
            drawPath(lightColoredPath, color = feature.lightColor)
        })

    }

}
