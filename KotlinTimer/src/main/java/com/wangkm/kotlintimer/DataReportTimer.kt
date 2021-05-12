package com.wangkm.kotlintimer

import android.util.Log
import java.io.Serializable
import java.util.*
import kotlin.concurrent.fixedRateTimer

/**
 * @author: created by wangkm
 * @time: 2021/05/12 20:50
 * @desc： 定时数据上报任务
 * @email: 1240413544@qq.com
 */

class DataReportTimer private constructor():Serializable{ //防止单例对象在反序列化时重新生成对象

    lateinit var mTimer: Timer

    companion object{
        @JvmStatic
        fun getInstance():DataReportTimer{
            return SingletonHolder.mInstance;
        }
    }

    private object SingletonHolder{
        val mInstance:DataReportTimer = DataReportTimer()
    }


    fun startTimer() {
        mTimer = fixedRateTimer("", false, 0, 1000) {
            Log.d("DataReportTimer", "得瑟中。。。")
        }
    }

    fun stopTimer() {
        mTimer.cancel()
        Log.d("DataReportTimer", "醒醒！！！")
    }
}