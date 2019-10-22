package com.example.demokomponen_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class Activitykedua : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activitykedua)

        var intent = intent
        val judul = intent.getStringExtra("judul")
        val direksi = intent.getStringExtra("direksi")
        val produksi = intent.getStringExtra("produksi")
        val genre=intent.getStringExtra("Genre")
        val age=intent.getStringExtra("Age")
        val negara = intent.getStringExtra("Negara")
        val tanggal = intent.getStringExtra("tanggal")




        val hasil = findViewById<TextView>(R.id.hasil)

        hasil.text= "judul : "+judul+"\ndireksi : "+direksi+"\nproduksi :"+produksi+"\nGenre :"+genre+"\nUmur :"+age+"\nNegara:"+negara+"\ntanggal : "+tanggal
    }
}
