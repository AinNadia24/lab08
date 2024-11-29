package com.ainadia.lab08

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ainadia.lab08.databinding.ActivityDetailBinding
import com.ainadia.lab08.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        val view = binding.root


        setContentView(view)
        // ambil id2 yang dihantar tadi

        binding.nameTextView.text = intent.getStringExtra("name")
        binding.phoneTextView.text = intent.getStringExtra("phone")
        binding.sizeTextView.text = intent.getStringExtra("size")
        binding.dateTextView.text = intent.getStringExtra("date")
        binding.timeTextView.text = intent.getStringExtra("time")

        binding.sendBtn.setOnClickListener{

            binding.ratingTextView.text = binding.ratingBar.rating.toString()

//            Snackbar.make(view, "Thank you for your rating, we received it!")
//            Snackbar.LENGTH_LONG).show()

            Snackbar.make(view, "Thankk you for your rating",
            Snackbar.LENGTH_LONG).setAction("OK")
            {
                println("User pressed OK")
            }
                .show()


        }

    }
}