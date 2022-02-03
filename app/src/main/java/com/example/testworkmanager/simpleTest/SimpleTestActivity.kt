package com.example.testworkmanager.simpleTest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.testworkmanager.databinding.ActivitySimpleTestBinding

class SimpleTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.title = "Simple Test"

        binding.simpleTest.setOnClickListener {
            val myWorkRequest: WorkRequest =
                OneTimeWorkRequestBuilder<MyWorker>()
                    .build()

            WorkManager
                .getInstance(this)
                .enqueue(myWorkRequest)
        }

    }

}