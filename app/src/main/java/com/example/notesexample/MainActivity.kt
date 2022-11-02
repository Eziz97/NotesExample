package com.example.notesexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val karandash= findViewById<ImageButton>(R.id.karandash)
        karandash.setOnClickListener {
            startActivity(Intent(this,NoteScrin::class.java))
        }


    }
}