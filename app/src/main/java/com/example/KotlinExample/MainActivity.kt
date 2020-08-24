package com.example.KotlinExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.KotlinExample.databinding.ActivityMainBinding

private const val SLEEP = 4000L

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notBlockButton.setOnClickListener {
            Thread(Runnable {
                Thread.sleep(SLEEP)
            })
        }

        binding.blockButton.setOnClickListener {
            Thread.sleep(SLEEP)
        }

        binding.showMessage.setOnClickListener {
            Toast.makeText(this, "mensaje de muestra", Toast.LENGTH_SHORT).show()
        }
    }
}