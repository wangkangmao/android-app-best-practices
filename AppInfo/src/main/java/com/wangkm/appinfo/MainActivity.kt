package com.wangkm.appinfo

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAppInfo()
    }

    private fun getAppInfo(){
        val pm = packageManager
        val list2 = pm.getInstalledPackages(PackageManager.MATCH_UNINSTALLED_PACKAGES)
        for (packageInfo in list2) {
            val appName = packageInfo.applicationInfo.loadLabel(packageManager).toString()
            val packageName = packageInfo.packageName
            packageTV.text = packageTV.text.toString() + "\n" + appName + "\n" + packageName + "\n"
        }
    }
}