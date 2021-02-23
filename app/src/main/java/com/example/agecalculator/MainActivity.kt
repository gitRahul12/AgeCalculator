package com.example.agecalculator

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.ENGLISH

class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val btnSelectDate = findViewById<Button>(R.id.btnSelectDate)
        // val tvDateSelected = findViewById<TextView>(R.id.tvDateSelected)

        btn1SelectDate.setOnClickListener {view ->

            selectDatePicker(view)

        }


    }



    @RequiresApi(Build.VERSION_CODES.N)
    fun selectDatePicker(view : View){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener {
                    view, selectedYear, selectedMonth, selectedDayOfMonth ->
                     val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                    tvSelctedDate.text = selectedDate

                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                    val theDate = sdf.parse(selectedDate)

                    val selectedDateInDays = theDate!!.time / ((1000*60*60*24))

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    val currentDateInDays = currentDate!!.time / ((1000*60*60*24))

                    val differenceInDays = currentDateInDays - selectedDateInDays

                    tvAgeInDays.text = differenceInDays.toString()


                }, year,month,day).show()
    }




}