package com.bwahyuh.quranme.data.model

import android.os.Parcelable
import com.google.firebase.Timestamp
import com.bwahyuh.quranme.repo.local.entity.CheckedTaskEntity
import com.bwahyuh.quranme.repo.local.entity.ProgressTaskEntity
import com.bwahyuh.quranme.utils.TimeUtils.formatDate
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class ProgressTask(
    val id: Long,
    val title: String,
    var date: Long,
    var repeating: String,
    var isCheck: Boolean
) : Parcelable

fun ProgressTask.toProgressEntity() = ProgressTaskEntity(
    this.id, this.title, this.date, Timestamp(Date(date)).formatDate, this.repeating
)

fun ProgressTask.toCheckedEntity() = CheckedTaskEntity(
    this.id, this.isCheck, Timestamp(Date(date)).formatDate, this.date
)
