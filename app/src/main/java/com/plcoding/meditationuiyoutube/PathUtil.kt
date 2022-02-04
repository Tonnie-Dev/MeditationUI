package com.plcoding.meditationuiyoutube

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import kotlin.math.abs


//2 params - from which point you want to connect to and from
fun Path.standardQuadFromTo(from: Offset, to: Offset) {


    quadraticBezierTo(
        x1 = from.x,
        y1 = from.y,

        /*this takes care of the center point where the path
        passes through to make a smooth curve*/
        x2 = abs((from.x - to.x) / 2),
        y2 = abs((from.y - to.y) / 2)
    )

    //abs always take the positive value of distance between coordinates
}