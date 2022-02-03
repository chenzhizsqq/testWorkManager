package com.example.testworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testworkmanager.databinding.ActivitySimpleTestBinding

class SimpleTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.title = "Simple Test"
    }
}