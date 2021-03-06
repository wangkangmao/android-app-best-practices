package com.wangkm.kotlintimer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn.setOnClickListener {
            DataReportTimer.getInstance().startTimer()
        }
        stopBtn.setOnClickListener {
            DataReportTimer.getInstance().stopTimer()
        }
    }

}
