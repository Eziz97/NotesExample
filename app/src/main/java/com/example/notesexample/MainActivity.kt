package com.example.notesexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val karandash = findViewById<ImageButton>(R.id.karandash)
        karandash.setOnClickListener {
            startActivity(Intent(this, NoteScrin::class.java))
        }

        val notesGrid = findViewById<RecyclerView>(R.id.notesGrid)
        notesGrid.layoutManager = GridLayoutManager(
            this,
            2,
            RecyclerView.VERTICAL,
            false
        )
        //notesGrid.adapter = NotesAdapter()
    }
        class NotesAdapter(val notes:List<Note>)  :RecyclerView.Adapter<NotesAdapter.noteViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.item_note,parent,false) as ViewGroup
            return noteViewHolder(view)

        }

        override fun onBindViewHolder(holder: noteViewHolder, position: Int) {
            val item = notes [position]
            holder.bind(item)
        }

        override fun getItemCount(): Int {
            return notes.size
        }




   inner class noteViewHolder(val view : ViewGroup):RecyclerView.ViewHolder(view){
       fun bind(item: Note) {
           //TODO("Not yet implemented")
       }

   }

}




    override fun onResume() {
        super.onResume()




        val allNotes= loadAllNotes()

    }


    private fun loadAllNotes():List<Note> {
        val listFiles= this.application.filesDir.listFiles()
        val notes=listFiles.map{ file ->
            val source = file.bufferedReader().readText
            val parts = source.splite("|")

            val title=parts[0]
            val note = parts[1]


            Note(
              title = title,
                note = note,
                dateMs = file.name.split(".")[0]

            )
       }

     return notes
    }

}