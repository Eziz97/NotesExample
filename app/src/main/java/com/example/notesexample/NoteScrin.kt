package com.example.notesexample

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log.println
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileInputStream

class NoteScrin: AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scrin_note)
        val arrow= findViewById<ImageButton>(R.id.arrow)
        arrow.setOnClickListener {
            onBackPressed()
        }

       val saveNoteButtom=findViewById<ImageButton>(R.id.saveNoteButtom)
        saveNoteButtom.setOnClickListener {
            val date = System.currentTimeMillis()
            val file = File(this.application.filesDir, "$date.txt")
            file.createNewFile()
            val noteField=findViewById<EditText>(R.id.saveNoteButtom)
            val noteText= noteField.text.toString()
            file.appendText(noteText)
            val readResult = FileInputStream(file).bufferedReader().use { it.readText() }
            println("readResult=$readResult")

    }

}