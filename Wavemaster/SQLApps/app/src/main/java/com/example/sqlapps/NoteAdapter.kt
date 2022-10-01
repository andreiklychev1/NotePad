package com.example.sqlapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.sqlapps.databinding.SingleCardBinding
import com.example.sqlapps.db.MyDbManager

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    val noteList = ArrayList<Note>()



    class NoteHolder(v : View) : RecyclerView.ViewHolder(v) {
        val binding = SingleCardBinding.bind(v)

        fun bind(note : Note) = with (binding) {
            noteName.text = note.title
            noteBody.text = note.note

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_card, parent, false)
        return NoteHolder(view)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
      holder.bind(noteList[position])
    }

    override fun getItemCount(): Int = noteList.size

    fun addNote(note : Note) {
        noteList.add(note)
        notifyDataSetChanged()
    }
}