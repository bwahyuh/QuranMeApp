package com.bwahyuh.quranme.compose.page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bwahyuh.quranme.compose.ui.components.ItemCalendar
import com.bwahyuh.quranme.compose.ui.components.ItemMainDate
import com.bwahyuh.quranme.compose.ui.components.ItemProgressActivity
import com.bwahyuh.quranme.compose.ui.components.ItemSchedule
import com.bwahyuh.quranme.compose.ui.components.ItemTimingSchedule
import com.bwahyuh.quranme.compose.ui.components.dummyCalendar
import com.bwahyuh.quranme.compose.ui.components.dummyDescNextPray
import com.bwahyuh.quranme.compose.ui.components.dummyListProgressTask
import com.bwahyuh.quranme.compose.ui.components.dummyLocationAddress
import com.bwahyuh.quranme.compose.ui.components.dummyNextPray
import com.bwahyuh.quranme.compose.ui.components.dummyTimingSchedule
import com.bwahyuh.quranme.data.model.DateSchedule
import com.bwahyuh.quranme.data.model.Prayer
import com.bwahyuh.quranme.data.model.ProgressTask
import com.bwahyuh.quranme.data.model.TimingSchedule

@Composable
fun HomePage(
    calendar: DateSchedule,
    timingSchedule: TimingSchedule,
    progressListTask: List<ProgressTask>,
    locationAddress: String,
    timeNextPray: String,
    descNextPray: String,
    getInterval: (timingSchedule: TimingSchedule, nearestSchedule: Prayer) -> Unit,
    onSetReminder: (timingSchedule: TimingSchedule, prayerTime: String, isReminded: Boolean, position: Int) -> Unit,
    goToDetailCalendar: () -> Unit,
    goToProgressActivity: () -> Unit,
) {
    Scaffold(Modifier.padding(16.dp)) {
        LazyColumn(contentPadding = it) {
            item { ItemMainDate(calendar) }
            item {
                ItemTimingSchedule(
                    timingSchedule,
                    locationAddress,
                    timeNextPray,
                    descNextPray,
                    getInterval
                )
            }
            item { ItemProgressActivity(progressListTask, goToProgressActivity) }
            item { ItemCalendar(calendar, goToDetailCalendar) }
            item { ItemSchedule(timingSchedule.imsak, timingSchedule, onSetReminder) }
            item { ItemSchedule(timingSchedule.fajr, timingSchedule, onSetReminder) }
            item { ItemSchedule(timingSchedule.dhuhr, timingSchedule, onSetReminder) }
            item { ItemSchedule(timingSchedule.asr, timingSchedule, onSetReminder) }
            item { ItemSchedule(timingSchedule.maghrib, timingSchedule, onSetReminder) }
            item { ItemSchedule(timingSchedule.isha, timingSchedule, onSetReminder) }
        }
    }
}

@SuppressLint("MissingPermission")
@Preview
@Composable
private fun PreviewHomePage() {
    HomePage(
        dummyCalendar, dummyTimingSchedule, dummyListProgressTask, dummyLocationAddress,
        dummyNextPray, dummyDescNextPray, { _, _ -> }, { _, _, _, _ -> }, {}, {}
    )
}