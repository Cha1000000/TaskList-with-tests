package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Given
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // When
        val result = getActiveAndCompletedStats(tasks)

        // Then
        assertEquals(result.activeTasksPercent, 100f)
        assertEquals(result.completedTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsHundredZero() {
        //Given
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true)
        )
        //When
        val result = getActiveAndCompletedStats(tasks)
        //Then
        assertEquals(result.completedTasksPercent, 100f)
        assertEquals(result.activeTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        // Given 3 completed tasks and 2 active tasks
        val tasks = listOf(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false)
        )
        // When the list of tasks is computed
        val result = getActiveAndCompletedStats(tasks)

        // Then the result is 40-60
        assertEquals(result.activeTasksPercent, 40f)
        assertEquals(result.completedTasksPercent, 60f)
    }

    @Test
    fun getActiveAndCompletedStats_emptyList_returnsZeros() {
        //When
        val result = getActiveAndCompletedStats(emptyList())
        //Then
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        //When
        val result = getActiveAndCompletedStats(null)
        //Then
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 0f)
    }
}