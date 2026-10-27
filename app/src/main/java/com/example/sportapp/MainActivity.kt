package com.example.sportapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sportapp.ui.theme.SportAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Если SportAppTheme подчеркнут красным, нажмите на него (Alt+Enter) и выберите Import class
            SportAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Меню") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        // Список наших упражнений
        val exercises = listOf(
            Exercise("Упражнения", "Комплекс упражнений на все группы мышц.", "10-20 секунд"),
            Exercise("Планка", "Упражнение для укрепления мышц пресса и спины.", "2-3 подхода"),
            Exercise("Приседания", "Базовое упражнение для ног и ягодиц.", "15 повторений"),
            Exercise("Отжимания", "Упражнение для груди, плеч и трицепсов.", "10 повторений")
        )

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(exercises) { exercise ->
                ExerciseCard(exercise = exercise) // Вызов нашей карточки
            }
        }
    }
}

// Предпросмотр в Android Studio
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    SportAppTheme {
        MainScreen()
    }
}