package com.example.yurip.livehealth.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yurip.livehealth.R
import kotlinx.android.synthetic.main.recycler_view.view.*

class NodeListAdapter(private val notes: List<Note>,
                      private val context: Context) : RecyclerView.Adapter<NodeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val note = notes[position]

        holder?.let {
            it.bindView(note)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(note: Note) {
            val title = itemView.note_item_title
            val description = itemView.note_item_description

            title.text = note.title
            description.text = note.description
        }

    }
}


