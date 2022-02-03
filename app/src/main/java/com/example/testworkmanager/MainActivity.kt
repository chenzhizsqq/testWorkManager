package com.example.testworkmanager

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.testworkmanager.databinding.ActivityMainBinding
import com.example.testworkmanager.simpleTest.SimpleTestActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.simpleTest.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.simpleTest -> {
                val intent =
                    Intent(this@MainActivity, SimpleTestActivity::class.java)
                startActivity(intent)
            }
        }
    }
}