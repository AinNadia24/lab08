package com.ainadia.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.DatePicker
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ainadia.lab08.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val pizzaSize = arrayListOf("Small", "Medium", "Large", "Extra Large")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                // bila seekbar diubah code ini dipanggil
                binding.sizeTextView.text = pizzaSize[p1]
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                print("Start Tracking")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                print("Start Tracking")

            }

        })
        // bila button di tekan hantar id2 berikut ke page
        binding.scheduleBtn.setOnClickListener{

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", binding.nameEditText.text.toString())
            intent.putExtra("name", binding.phoneEditText.text.toString())
            intent.putExtra("Size", binding.sizeTextView.text.toString())
            intent.putExtra("date", binding.dateTextView.text.toString())
            intent.putExtra("time", binding.timeTextView.text.toString())

            startActivity(intent)
        }
        binding.dateBtn.setOnClickListener{

            // dapatkan tarikh arini
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)

            val myDatePicker = DatePickerDialog( this, android.R.style.ThemeOverlay,

                DatePickerDialog.OnDateSetListener{datePicker, i, i2, i3 ->

                binding.dateTextView.text ="$i3/${i2+1} /$i"
            }, year, month, day


            )
            myDatePicker.show()


        }

        binding.timeBtn.setOnClickListener{

            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            val myTimePicker = TimePickerDialog(this,

                TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->

                    binding.timeTextView.text = "$i:$i2"
                }, hour, minute, false)
            myTimePicker.show()

        }


    }
}