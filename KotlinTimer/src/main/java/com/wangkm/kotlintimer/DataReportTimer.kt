package com.wangkm.kotlintimer

import android.util.Log
import java.util.*
import kotlin.concurrent.fixedRateTimer

/**
 * @author: created by wangkm
 * @time: 2021/05/12 20:50
 * @desc： 定时数据上报任务
 * @email: 1240413544@qq.com
 */

class DataReportTimer private constructor() {

    private var mTimer: Timer? = null

    companion object {
        @Volatile
        private var mDataReportTimer: DataReportTimer? = null

        fun getInstance(): DataReportTimer {
            if (mDataReportTimer == null) {
                synchronized(DataReportTimer::class) {
                    if (mDataReportTimer == null) {
                        mDataReportTimer = DataReportTimer()
                    }
                }
            }
            return mDataReportTimer!!
        }

    }

    fun startTimer() {
        mTimer = fixedRateTimer("", false, 0, 1000) {
            Log.d("DataReportTimer", "得瑟中。。。")
        }
    }

    fun stopTimer() {
        mTimer?.cancel()
        Log.d("DataReportTimer", "醒醒！！！")
    }
}