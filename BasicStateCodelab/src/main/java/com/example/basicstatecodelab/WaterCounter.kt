package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun WaterCounter(modifier: Modifier = Modifier) {

    Column {
        var count by remember { mutableStateOf(0) }
        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 min walk today??",
                    onClose = { showTask = false })
            }
            Text(text = "You've had ${count} glasses. ", modifier = modifier.padding(16.dp))

        }
        Row() {
            Button(
                onClick = { count++ }, modifier = Modifier.padding(top = 8.dp), enabled = count < 10
            ) {
                Text(text = "Add One")
            }
            Button(
                onClick = { count = 0 },
                modifier = Modifier.padding(top = 8.dp, start = 8.dp)
            ) {
                Text(text = "Clear count")
            }

        }
    }
}


@Preview
@Composable
fun WaterCounterPreview() {
    WaterCounter()
}