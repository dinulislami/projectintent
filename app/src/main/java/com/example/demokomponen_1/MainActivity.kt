package com.example.demokomponen_1

import android.annotation.TargetApi
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
class MainActivity : AppCompatActivity() {
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()

    lateinit var cb_thriller : CheckBox
    lateinit var cb_comedy : CheckBox
    lateinit var cb_horor : CheckBox
    lateinit var cb_romance : CheckBox
    lateinit var cb_action : CheckBox
    lateinit var cb_fantasy : CheckBox

    lateinit var rb_13 : RadioButton
    lateinit var rb_18 : RadioButton
    lateinit var rb_19 : RadioButton

    lateinit var negara : Spinner

    @RequiresApi(Build.VERSION_CODES.N)
    @TargetApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview_date = this.tanggal


        textview_date!!.text = "Date Release"

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }

            private fun updateDateInView() {
                val myFormat = "MM/dd/yyyy" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                textview_date!!.text = sdf.format(cal.getTime())
            }
        }

        textview_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    this@MainActivity,
                    dateSetListener,

                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()

            }
        })
        val title =  findViewById<EditText>(R.id.email)
        val directed =  findViewById<EditText>(R.id.name)
        val home =  findViewById<EditText>(R.id.password)
        val date = findViewById<TextView>(R.id.tanggal)
        val button = findViewById<Button>(R.id.login)

        cb_thriller = findViewById(R.id.cb_basket) as CheckBox
        cb_comedy = findViewById(R.id.cb_sepakbola) as CheckBox
        cb_horor = findViewById(R.id.cb_renang) as CheckBox
        cb_romance = findViewById(R.id.cb_volly) as CheckBox
        cb_action = findViewById(R.id.cb_takraw) as CheckBox
        cb_fantasy = findViewById(R.id.cb_batminton) as CheckBox

        rb_13 = findViewById(R.id.rb_13dl) as RadioButton
        rb_18 = findViewById(R.id.rb_18ajadl) as RadioButton
        rb_19 = findViewById(R.id.rb_19ajadl) as RadioButton
        negara = findViewById(R.id.pilihnegara) as Spinner

        var neg = negara.getSelectedItem().toString()

        var spinner_pos = negara.getSelectedItemPosition()
        //String[] negara_values = getResource().getStringArray(R.array.spinnerCountry)






        button.setOnClickListener {
            val judul = title.text.toString()
            val direksi = directed.text.toString()
            val produksi = home.text.toString()
            var genre=""
            var age=""
            var negara= negara.getSelectedItem().toString()
            val tanggal = date.text.toString()



            if (cb_action.isChecked)
                genre+="action"
            if (cb_fantasy.isChecked)
                genre+="fantasy"
            if (cb_comedy.isChecked)
                genre+="Comedy"
            if (cb_horor.isChecked)
                genre+="horor"
            if (cb_romance.isChecked)
                genre+="romance"
            if (cb_thriller.isChecked)
                genre+="thriler"

            if(rb_13.isChecked)
                age+="13 th"
            if(rb_18.isChecked)
                age+="18 th"
            if(rb_19.isChecked)
                age+="19 th"



            val intent = Intent (this@MainActivity, Activitykedua::class.java)
            intent.putExtra("judul", judul)
            intent.putExtra("direksi", direksi)
            intent.putExtra("produksi", produksi)
            intent.putExtra("Genre",genre)
            intent.putExtra("Age",age)
            intent.putExtra("Negara",negara)
            intent.putExtra("tanggal",tanggal)

            startActivity(intent)


        }

    }
}

