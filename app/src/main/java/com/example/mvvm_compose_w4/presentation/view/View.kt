package com.example.mvvm_compose_w4.presentation.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvvm_compose_w4.core.data.DemoData
import com.example.mvvm_compose_w4.core.domain.DriverMessage
import com.example.mvvm_compose_w4.presentation.ui.theme.MVVMComposew4Theme

class View : ComponentActivity() {
}

// Previews
@Preview(showBackground = true)
@Composable
fun MVVDisplayPreview() {
    MVVMComposew4Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val demoList = DemoData.create(12, "Pascal", "Severin")
            TitleBar(label = "Driver Standings",
                content = {
                    ScrollList(demoList)
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DriverElementPreview() {
    val demoElement = DemoData.create(1, "John", "Doe")
    DriverElement(demoElement[0])
}

// Implementations

@Composable
fun MVVDisplay(drivers: List<DriverMessage>) {
    MVVMComposew4Theme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            TitleBar(label = "Driver Standings",
                content = { ScrollList(drivers) })
        }
    }
}

@Composable
fun TitleBar(label: String, content: @Composable () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = label)
            }
        )
    }
    ) {
        content()
    }
}

@Composable
fun ScrollList(messages: List<DriverMessage>) {
    LazyColumn(modifier = Modifier.padding(20.dp)) {
        items(messages) { msg ->
            DriverElement(driver = msg)
        }
    }
}

@Composable
fun DriverElement(driver: DriverMessage) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.defaultMinSize(20.dp),
                text = driver.position.toString(),
                fontWeight = FontWeight.Bold
            )
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(text = driver.givenName)
                Text(text = driver.familyName)
            }
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(text = driver.team)
            Text(text = " ${driver.points} PTS")
        }
    }
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .width(2.dp)
    )
}
