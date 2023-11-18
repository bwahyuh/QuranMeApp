package com.bwahyuh.quranme.data.repository

import com.bwahyuh.quranme.data.model.Ayah
import com.bwahyuh.quranme.data.model.PrayerReminder
import com.bwahyuh.quranme.data.model.ProgressTask
import com.bwahyuh.quranme.data.model.Schedule
import com.bwahyuh.quranme.repo.States
import kotlinx.coroutines.flow.Flow

interface DataRepositoryImpl {
    suspend fun getSchedule(lat: Double, long: Double, month: Int, year: Int): Flow<States<List<Schedule>>>

    suspend fun getAllReminder(): Flow<List<PrayerReminder>>
    suspend fun addAllReminders(listOfReminder: List<PrayerReminder>)
    suspend fun updateReminder(prayerReminder: PrayerReminder)
    suspend fun deleteAllReminder()

    suspend fun getProgressTask(date: String): Flow<List<ProgressTask>>
    suspend fun addProgressTask(task: ProgressTask)
    suspend fun deleteProgressTask(task: ProgressTask)

    suspend fun updateCheckedTask(task: ProgressTask, onFinish: () -> Unit)

    suspend fun getAyahQuran(noSurah: Int): Flow<States<List<Ayah>>>
}