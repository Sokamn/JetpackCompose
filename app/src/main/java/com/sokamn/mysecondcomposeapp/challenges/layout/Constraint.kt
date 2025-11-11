package com.sokamn.mysecondcomposeapp.challenges.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Preview(showBackground = true)
@Composable
fun PreviewConstraintExercise(){
    MyExerciseConstraint(Modifier)
}
@Composable
fun MyExerciseConstraint(modifier: Modifier){
    ConstraintLayout(modifier.fillMaxSize()){
        val (boxCyan, boxBlack, boxDarkGray, boxMagenta, boxGreen, boxYellow, boxGray, boxBlue, boxRed) = createRefs()

        Box(Modifier.size(175.dp).background(Color.Cyan).constrainAs(boxCyan){
            end.linkTo(boxMagenta.end)
            bottom.linkTo(boxMagenta.top)
        })
        Box(Modifier.size(75.dp).background(Color.Black).constrainAs(boxBlack){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxCyan.top)
            bottom.linkTo(boxDarkGray.bottom)
        })
        Box(Modifier.size(175.dp).background(Color.DarkGray).constrainAs(boxDarkGray){
            start.linkTo(boxGreen.start)
            bottom.linkTo(boxGreen.top)
        })
        Box(Modifier.size(75.dp).background(Color.Magenta).constrainAs(boxMagenta){
            end.linkTo(boxYellow.start)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen){
            start.linkTo(boxYellow.end)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })
        Box(Modifier.size(175.dp).background(Color.Blue).constrainAs(boxBlue){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxYellow.bottom)
        })
        Box(Modifier.size(75.dp).background(Color.Gray).constrainAs(boxGray){
            end.linkTo(boxYellow.start)
            top.linkTo(boxYellow.bottom)
        })
        Box(Modifier.size(75.dp).background(Color.Red).constrainAs(boxRed){
            start.linkTo(boxYellow.end)
            top.linkTo(boxYellow.bottom)
        })

    }
}